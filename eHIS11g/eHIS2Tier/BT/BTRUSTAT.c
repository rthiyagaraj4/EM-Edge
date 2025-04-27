
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
           char  filnam[25];
};
static const struct sqlcxp sqlfpn =
{
    24,
    "d:\\speclabel\\btrustat.pc"
};


static unsigned long sqlctx = 1171887115;


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
            void  *sqhstv[17];
   unsigned int   sqhstl[17];
            int   sqhsts[17];
            void  *sqindv[17];
            int   sqinds[17];
   unsigned int   sqharm[17];
   unsigned int   *sqharc[17];
   unsigned short  sqadto[17];
   unsigned short  sqtdso[17];
} sqlstm = {10,17};

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

 static const char *sq0020 = 
"select category_code ,product_code ,nvl(category_requested,0) ,nvl(category_\
allocated,0)  from BT_UNIT_REQUEST_CATEGORY A where (A.specimen_no=:b0 and A.o\
perating_facility_id=:b1)           ";

 static const char *sq0024 = 
"select A.unit_no ,A.product_code ,to_char(A.reserved_date,'dd/mm/yyyy hh24:m\
i:ss') ,A.crossmatched_yn ,A.ignore_crossmatch_yn ,DECODE(A.ignore_crossmatch_\
yn,'Y',A.ignore_remarks) ,C.description unit_status ,A.allocated_by ,A.Issued_\
by ,A.issued_to ,TO_CHAR(A.issued_date,'DD/MM/YYYY hh24:mi:ss') ,B.blood_group\
 ,B.rhesus_code ,B.current_volume ,B.volume_units ,B.aliquoted_yn ,to_char(b.e\
xpiry_date,'dd/mm/yyyy hh24:mi:ss')  from BT_UNIT_REQUEST_DTL A ,BT_BLOOD_UNIT\
S_MAST B ,BT_DECODED_UNIT_STATUS_LANG_VW C where (((((((A.specimen_no=:b0 and \
A.unit_no=B.unit_no) and A.product_code=B.product_code) and A.unit_status=DECO\
DE(:b1,'A','UA','R','UR','I','UI','T','UT','X','TF',A.unit_status)) and A.unit\
_status=C.dec_unit_status_code) and C.language_id=:b2) and A.operating_facilit\
y_id=B.operating_facility_id) and A.operating_facility_id=:b3) order by A.unit\
_no            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,207,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,30,230,0,0,0,0,0,1,0,
51,0,0,3,0,0,32,237,0,0,0,0,0,1,0,
66,0,0,4,120,0,6,249,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
89,0,0,5,136,0,6,262,0,0,2,2,0,1,0,2,9,0,0,1,3,0,0,
112,0,0,6,48,0,4,283,0,0,1,0,0,1,0,2,9,0,0,
131,0,0,7,171,0,4,328,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
166,0,0,8,158,0,6,338,0,0,2,2,0,1,0,3,9,0,0,1,9,0,0,
189,0,0,9,458,0,4,489,0,0,13,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
256,0,0,10,176,0,6,555,0,0,2,2,0,1,0,3,9,0,0,1,9,0,0,
279,0,0,11,186,0,6,575,0,0,2,2,0,1,0,3,9,0,0,1,9,0,0,
302,0,0,12,186,0,4,620,0,0,5,2,0,1,0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
337,0,0,13,199,0,4,631,0,0,5,2,0,1,0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
372,0,0,14,125,0,4,670,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
403,0,0,15,125,0,4,682,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
434,0,0,16,105,0,4,696,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
461,0,0,17,116,0,4,722,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
492,0,0,18,128,0,4,735,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
523,0,0,19,68,0,4,749,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
546,0,0,20,190,0,9,778,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
569,0,0,20,0,0,13,799,0,0,4,0,0,1,0,2,9,0,0,2,9,0,0,2,3,0,0,2,3,0,0,
600,0,0,21,0,0,32,821,0,0,0,0,0,1,0,
615,0,0,20,0,0,15,831,0,0,0,0,0,1,0,
630,0,0,22,103,0,4,843,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
657,0,0,23,77,0,4,862,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
680,0,0,24,871,0,9,970,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
711,0,0,24,0,0,13,1015,0,0,17,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,
794,0,0,25,176,0,6,1036,0,0,2,2,0,1,0,3,9,0,0,1,9,0,0,
817,0,0,26,168,0,6,1044,0,0,2,2,0,1,0,3,9,0,0,1,9,0,0,
840,0,0,27,172,0,6,1054,0,0,2,2,0,1,0,3,9,0,0,1,9,0,0,
863,0,0,28,0,0,32,1097,0,0,0,0,0,1,0,
878,0,0,24,0,0,15,1107,0,0,0,0,0,1,0,
893,0,0,29,140,0,4,1230,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
924,0,0,30,90,0,4,1254,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
};


/*****************************************************************************
*  File	         : btrustat.pc
   Author        : Shruti
   Date Created  : 18/02/2003
   Last Modified : 29/05/2004
   By            : Hameed

*  Ver 1.10.01    
   
*  Purpose : To Create Worklist Date for the given Specimen Range     
            
*  Input Parameters : 
                      Command line inputs
		      1. Usr_id/Password
                      2. Session id
		      3. Program Date     
                                       
  
*  Table Accessed : BT_UNIT_REQUEST_HDR
					BT_UNIT_REQUEST_DTL
					BT_UNIT_REQUEST_CATEGORY
					BT_BLOOD_UNITS_MAST
					BT_ALIQUOT_UNITS
					BT_PARAM
					BT_CATEGORY_MAST
					IP_WARD
					OP_CLINIC
					RL_REFERRAL
					SY_PHYSICIAN_MAST
					RL_CONSULTANTS
					MP_PATIENT_MAST
*****************************************************************************/

#include <stdio.h>
#include <string.h>
#include <math.h>

#define MAX_LINES 58
#define OERROR (sqlca.sqlcode < 0)
#define NODATAFOUND sqlca.sqlcode==1403
#define LAST_ROW 	(sqlca.sqlcode == 1403)
#define VER  "VER : 1.10.01\n"
#define REP_WIDTH 80


#define ESC 0x1B

/*
#define DEBUG 
*/

/* EXEC SQL BEGIN DECLARE SECTION; */ 


       /* increased the length all varchar variables by one to take care */
       /* for null termination */
	/* VARCHAR uid_pwd					[111],
			nd_session_id			[16],
			nd_pgm_date				[31],
			nd_user					[51],			
            sy_entity_id            [51],
			d_curr_date				[31],
			d_acc_entity_name		[400],
			d_user					[51],
			d_facility_id			[3],
			nd_operating_facility_id	[5],
			d_ordered_facility_id	[5],
			d_sysdate				[31],
			d_sysdate1				[31],
			nd_file_name			[150], 
			d_source_desc			[120],
			d_consultant_name	     	[120], 
  		    d_flag				    	[3],
			l_cust_id				[50]; */ 
struct { unsigned short len; unsigned char arr[111]; } uid_pwd;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[31]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[51]; } nd_user;

struct { unsigned short len; unsigned char arr[51]; } sy_entity_id;

struct { unsigned short len; unsigned char arr[31]; } d_curr_date;

struct { unsigned short len; unsigned char arr[400]; } d_acc_entity_name;

struct { unsigned short len; unsigned char arr[51]; } d_user;

struct { unsigned short len; unsigned char arr[3]; } d_facility_id;

struct { unsigned short len; unsigned char arr[5]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[5]; } d_ordered_facility_id;

struct { unsigned short len; unsigned char arr[31]; } d_sysdate;

struct { unsigned short len; unsigned char arr[31]; } d_sysdate1;

struct { unsigned short len; unsigned char arr[150]; } nd_file_name;

struct { unsigned short len; unsigned char arr[120]; } d_source_desc;

struct { unsigned short len; unsigned char arr[120]; } d_consultant_name;

struct { unsigned short len; unsigned char arr[3]; } d_flag;

struct { unsigned short len; unsigned char arr[50]; } l_cust_id;
//added for GHL-CRF-0314 by krishnamoorthys

	/******FIELDS FROM BT_UNIT_REQUEST_HDR**************/
	/* VARCHAR	d_patient_id			[31],
			d_episode_type			[21],
			d_source_code			[21],
			d_source_type			[21],
			d_consultant_code		[21],
			d_blood_group			[5],
			d_rhesus_code			[5],
			d_comment_code			[21],
			d_added_date			[31],
			d_specimen_no			[31],
			d_episode_no			[31]; */ 
struct { unsigned short len; unsigned char arr[31]; } d_patient_id;

struct { unsigned short len; unsigned char arr[21]; } d_episode_type;

struct { unsigned short len; unsigned char arr[21]; } d_source_code;

struct { unsigned short len; unsigned char arr[21]; } d_source_type;

struct { unsigned short len; unsigned char arr[21]; } d_consultant_code;

struct { unsigned short len; unsigned char arr[5]; } d_blood_group;

struct { unsigned short len; unsigned char arr[5]; } d_rhesus_code;

struct { unsigned short len; unsigned char arr[21]; } d_comment_code;

struct { unsigned short len; unsigned char arr[31]; } d_added_date;

struct { unsigned short len; unsigned char arr[31]; } d_specimen_no;

struct { unsigned short len; unsigned char arr[31]; } d_episode_no;


	/******FIELDS FROM BT_UNIT_REQUEST_CATEGORY**************/
	/* VARCHAR	d_category_code			[31],
	        d_cat_prod_code         [31],
			d_remarks				[501]; */ 
struct { unsigned short len; unsigned char arr[31]; } d_category_code;

struct { unsigned short len; unsigned char arr[31]; } d_cat_prod_code;

struct { unsigned short len; unsigned char arr[501]; } d_remarks;


	int		d_category_requested,	
			d_category_allocated;

	/******FIELDS FROM BT_UNIT_REQUEST_DTL**************/
	/* VARCHAR	d_unit_no				[31],
			d_product_code			[31],
			d_reserved_date			[31],
			d_req_date_time			[31],
			d_crossmatched_yn		[2],
			d_ignore_crossmatch_yn	[2],
			d_ignore_remarks			[1001],
			d_unit_status			[21],
			d_allocated_by			[31],
			d_issued_by			[31],
			d_issued_to				[31],
			d_issued_on			[31],
			
			d_expiry_date			[50]; */ 
struct { unsigned short len; unsigned char arr[31]; } d_unit_no;

struct { unsigned short len; unsigned char arr[31]; } d_product_code;

struct { unsigned short len; unsigned char arr[31]; } d_reserved_date;

struct { unsigned short len; unsigned char arr[31]; } d_req_date_time;

struct { unsigned short len; unsigned char arr[2]; } d_crossmatched_yn;

struct { unsigned short len; unsigned char arr[2]; } d_ignore_crossmatch_yn;

struct { unsigned short len; unsigned char arr[1001]; } d_ignore_remarks;

struct { unsigned short len; unsigned char arr[21]; } d_unit_status;

struct { unsigned short len; unsigned char arr[31]; } d_allocated_by;

struct { unsigned short len; unsigned char arr[31]; } d_issued_by;

struct { unsigned short len; unsigned char arr[31]; } d_issued_to;

struct { unsigned short len; unsigned char arr[31]; } d_issued_on;

struct { unsigned short len; unsigned char arr[50]; } d_expiry_date;
 //added for ghl-crf-0314 by krishnamoorthys

	/******FIELDS FROM BT_BLOOD_UNITS_MAST**************/
	/* VARCHAR	nd_blood_group			[5],
			nd_rhesus_code			[5],
			d_current_volume			[6],
			d_volume_units			[5],
			d_aliquoted_yn			[2]; */ 
struct { unsigned short len; unsigned char arr[5]; } nd_blood_group;

struct { unsigned short len; unsigned char arr[5]; } nd_rhesus_code;

struct { unsigned short len; unsigned char arr[6]; } d_current_volume;

struct { unsigned short len; unsigned char arr[5]; } d_volume_units;

struct { unsigned short len; unsigned char arr[2]; } d_aliquoted_yn;


	/******FIELDS FROM BT_ALIQUOT_UNITS**************/
	/* VARCHAR	d_aliquot_rmks			[1001]; */ 
struct { unsigned short len; unsigned char arr[1001]; } d_aliquot_rmks;


	/******FIELDS FROM BT_PARAM***********************/
	/* VARCHAR	d_footer_line_1			[201],
			d_footer_line_2			[201]; */ 
struct { unsigned short len; unsigned char arr[201]; } d_footer_line_1;

struct { unsigned short len; unsigned char arr[201]; } d_footer_line_2;


	/******FIELDS FROM MP_PATIENT_MAST***********************/
	/* VARCHAR	d_patient_name			[300],
			d_date_of_birth			[100],
			d_sex					[100]; */ 
struct { unsigned short len; unsigned char arr[300]; } d_patient_name;

struct { unsigned short len; unsigned char arr[100]; } d_date_of_birth;

struct { unsigned short len; unsigned char arr[100]; } d_sex;


/******FIELDS FROM BT_CATEGORY_MAST***********************/
	/* VARCHAR	d_short_desc			[100]; */ 
struct { unsigned short len; unsigned char arr[100]; } d_short_desc;



/******FIELDS FROM BT_CMATCH_COMMENTS_MAST***********************/
	/* VARCHAR	d_comment_desc			[1000]; */ 
struct { unsigned short len; unsigned char arr[1000]; } d_comment_desc;


	/* VARCHAR	l_translated_value		 [1000],
		language_id			[5]; */ 
struct { unsigned short len; unsigned char arr[1000]; } l_translated_value;

struct { unsigned short len; unsigned char arr[5]; } language_id;


/***********************************************************************/
int l_count = 0;
int i;
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

char    file_name[30],
		file_name2[30],
		string_var[1000];
		
char hdr_line1[REP_WIDTH+1],
     hdr_line2[REP_WIDTH+1],
     hdr_line3[REP_WIDTH+1],
     hdr_line4[REP_WIDTH+1],
     hdr_line5[REP_WIDTH+1];

char rep_title2[30];
char con_rep_title[60];

int		line_no;
int		page_no = 1;

FILE *f1;

void end_report();

char local_legend[32][100];

void proc_main(argc, argv)
int argc;
char *argv[];

{
 int fetch_category_cur();
 int fetch_patient_dtl_cur();

   if(argc != 7) 
   {
     disp_message(ERR_MESG,"Usage btrustat uid/passwd session_id pgm_date\n");
     proc_exit();
   }


   strcpy(uid_pwd.arr, argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr); 

   strcpy(nd_session_id.arr, argv[2]);
   nd_session_id.len = strlen(nd_session_id.arr); 

   strcpy(nd_pgm_date.arr, argv[3]);
   nd_pgm_date.len = strlen(nd_pgm_date.arr); 

   strcpy(nd_operating_facility_id.arr, argv[4]);
   nd_operating_facility_id.len = strlen(nd_operating_facility_id.arr); 

   strcpy(d_specimen_no.arr, argv[5]);
   d_specimen_no.len = strlen(d_specimen_no.arr); 

   strcpy(d_flag.arr, argv[6]);
   d_flag.len = strlen(d_flag.arr); 


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
   sqlstm.sqhstl[0] = (unsigned int  )113;
   sqlstm.sqhsts[0] = (         int  )113;
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
      disp_message(ORA_MESG,"Failed to connect using : %s\n");

#ifdef DEBUG
    printf("Connected to ORACLE as user: %s \n", uid_pwd.arr);
#endif  

	set_meduser_role();

	strcpy(language_id.arr,l_language_id.arr);
	language_id.len =l_language_id.len;
	language_id.arr[l_language_id.len]='\0';

	gen_file_name();
	
	get_legend_value(34);//changed 31 to 34 for ghl-crf-0314 by krishnamoorthys

	do_report();
	
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   
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


   
   fclose(f1);
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


   disp_message(ORA_MESG,"Oracle error at main() occured....\n");
   proc_exit();
}   
/* ---------------------------------------------------- */


get_legend_value(int cou)
 {
   


	/* EXEC SQL EXECUTE
	BEGIN
	  SM_POPULATE_REPORT_LEGEND.FETCH_LEGEND (:nd_operating_facility_id,:language_id,'BTRUSTAT.LEGEND_');
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin SM_POPULATE_REPORT_LEGEND . FETCH_LEGEND ( :nd_operati\
ng_facility_id , :language_id , 'BTRUSTAT.LEGEND_' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )66;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )7;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&language_id;
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






 for (i=1; i<=cou; i++)
	{
	l_translated_value.arr[0]		= '\0';
	
	/* EXEC SQL EXECUTE
	BEGIN
               :l_translated_value :=    GET_LEGEND(LTRIM(RTRIM('BTRUSTAT.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009'))))));
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin :l_translated_value := GET_LEGEND ( LTRIM ( RTRIM ( 'B\
TRUSTAT.LEGEND_' || LTRIM ( RTRIM ( TO_CHAR ( :i , '009' ) ) ) ) ) ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )89;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_translated_value;
 sqlstm.sqhstl[0] = (unsigned int  )1002;
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

	//sp_message(ERR_MESG,l_translated_value.arr);

	strcpy(local_legend[i],l_translated_value.arr);


	}


 }

//A1 added the below code for GHL-CRF-0314 by krishnamoorthys
get_cust_id()
{
 /* EXEC SQL SELECT CUSTOMER_ID
		   INTO :l_cust_id
		   FROM SM_SITE_PARAM; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select CUSTOMER_ID into :b0  from SM_SITE_PARAM ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )112;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_cust_id;
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



	if (OERROR)
       disp_message(ORA_MESG,"Select failed on table SM_SITE_PARAM");    
	
	l_cust_id.arr[l_cust_id.len]                 = '\0';

	
 }
// end A1 GHL-CRF-0314



/*
get_entity_id()
{
 EXEC SQL SELECT COUNT(1)
	 INTO :l_count
	 FROM SY_ACC_ENTITY;
 if (l_count > 1) 
   {
   EXEC SQL SELECT NVL(default_entity_id, 'ZZ')
		  		INTO :sy_entity_id
		  		FROM RL_PARAM;
   }
  else
   {
   EXEC SQL SELECT acc_entity_id INTO :sy_entity_id
	FROM SY_ACC_ENTITY;
   }
   if (OERROR)
         disp_message(ORA_MESG,"Select failed on table SY_ACC_ENTITY");

   sy_entity_id.arr[sy_entity_id.len] = '\0';
}
*/
/* ---------------------------------------------------- */

/************ get the header details ************/
get_header_dtls()
{
 

   /* EXEC SQL SELECT SUBSTR(acc_entity_name, 1, 60), 
			  USER,
			  TO_CHAR(sysdate, 'DD/MM/YYYY HH24:MI')
	    INTO :d_acc_entity_name,
			 :d_user,
			 :d_sysdate
            FROM SY_ACC_ENTITY_LANG_VW
            WHERE ACC_ENTITY_ID = :nd_operating_facility_id
			AND LANGUAGE_ID = :language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 5;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select SUBSTR(acc_entity_name,1,60) ,USER ,TO_CHAR(sysdate\
,'DD/MM/YYYY HH24:MI') into :b0,:b1,:b2  from SY_ACC_ENTITY_LANG_VW where (ACC\
_ENTITY_ID=:b3 and LANGUAGE_ID=:b4)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )131;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_acc_entity_name;
   sqlstm.sqhstl[0] = (unsigned int  )402;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_user;
   sqlstm.sqhstl[1] = (unsigned int  )53;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_sysdate;
   sqlstm.sqhstl[2] = (unsigned int  )33;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[3] = (unsigned int  )7;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&language_id;
   sqlstm.sqhstl[4] = (unsigned int  )7;
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



        /* EXEC SQL EXECUTE
		BEGIN
		  GET_LOCALE_DATE_2T.CONVERT_TO_LOCALE_DATE (to_date(:d_sysdate,'DD/MM/YYYY HH24:MI'), :language_id, :d_sysdate, 'DD/MM/YYYY HH24:MI');
		END;
		END-EXEC; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 5;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "begin GET_LOCALE_DATE_2T . CONVERT_TO_LOCALE_DATE ( t\
o_date ( :d_sysdate , 'DD/MM/YYYY HH24:MI' ) , :language_id , :d_sysdate , 'DD\
/MM/YYYY HH24:MI' ) ; END ;";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )166;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&d_sysdate;
        sqlstm.sqhstl[0] = (unsigned int  )33;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&language_id;
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



  d_acc_entity_name.arr[d_acc_entity_name.len] = '\0';
  d_user.arr[d_user.len]                       = '\0';
  d_sysdate.arr[d_sysdate.len]                 = '\0';



 }

/*****************************DO REPORT***************************/
do_report()
{
    //get_entity_id();
	//disp_message(ERR_MESG,"testing 29 apr 2014") ;
	get_cust_id();//Added for GHL-CRF-0314 by krishnamoorthys
	get_header_dtls();
	get_patient();
	print_patient_dtls();
	do_category();
	get_patient_spec_dtls();
	get_footer();
	end_report();
	
}

/****************************GEN FILE NAME***********************/
gen_file_name()
{
	 /* For a constant file name (4 lines) */
  	 strcpy(nd_file_name.arr,WORKING_DIR) ;
     nd_file_name.len = strlen(nd_file_name.arr);
	 strcat(nd_file_name.arr,"btrustat.lis");
	 nd_file_name.len = strlen(nd_file_name.arr);

	 if ((f1 = fopen(nd_file_name.arr,"w")) == NULL)
     {
	   sprintf(string_var,"Error while opening file %s\n",nd_file_name.arr);
	   disp_message(ERR_MESG,string_var) ;
       proc_exit();
     }
}

/*----------------------------------------------------------------------------*/




print_title()
{
	int l_pos = 0;
	int l_pos2 = 0;
	int l_rem_pos = 0;
	int l_len = 0;
	int l_page_pos = 0;

	char l_string[100];

	line_no = 0;

	/**** first line ***********/	
	fprintf(f1, "MDL : BT");
	
	l_pos = (int)(((80 - d_acc_entity_name.len)/2));
	l_pos = l_pos - 8;
	sprintf(string_var, "%-*s%s", l_pos, " ", d_acc_entity_name.arr);
	
	   

	fprintf(f1, "%s", string_var);

	/**** second line ***********/
	l_pos2 = (l_pos + d_acc_entity_name.len);
	l_pos2 = 53 - l_pos2;	
	sprintf(string_var, "%-*s%s", l_pos2, " ", d_sysdate.arr);


//	fprintf(f1, "%-10.10s\n", d_sysdate.arr);
	fprintf(f1, "%s\n", string_var);

	fprintf(f1, "OPR : %s\n" , d_user.arr );

	l_len = 10;

	fprintf(f1, "REP : BTRUSTAT");
	sprintf(l_string,"%s",local_legend[22]);
	//strcpy(l_string, "UNITS  REPORT");
	l_pos = (int)(((80 - strlen(l_string))/2));
	l_pos = l_pos - 14;
	l_page_pos = l_pos;
//	l_pos = l_pos - l_len;
	sprintf(string_var, "%-*s%s", l_pos, " ", l_string);
	fprintf(f1, "%s", string_var);

	
	l_rem_pos =  (l_page_pos + strlen(l_string));
	l_rem_pos = 52 - l_rem_pos;

	sprintf(string_var, "%-*s%s : %d", l_rem_pos, " ", local_legend[27], page_no);
	fprintf(f1, "%s\n", string_var);

	fprintf(f1, "------------------------------------------------------------------------------\n");
	line_no = 3;

}
/*----------------------------------------------------------------------------*/
fprint_repeat(l_fp,l_prn_chr,l_no)
FILE *l_fp;
char l_prn_chr;
int  l_no;
{
   int l_i = 0;

   for (l_i = 0;l_i < l_no;l_i++)
        fputc(l_prn_chr,l_fp);
}
/*-----------------------------------------------------*/

/***********GET PATIENT**********************/

get_patient()
{

 d_patient_id.arr[0]		='\0';
 d_patient_id.len			=0;
 d_episode_type.arr[0]		='\0';
 d_episode_type.len			=0;
 d_source_code.arr[0]		='\0';
 d_source_code.len			=0;
 d_source_type.arr[0]		='\0';
 d_source_type.len			=0;
 d_consultant_code.arr[0]	='\0';
 d_consultant_code.len		=0;
 d_blood_group.arr[0]		='\0';
 d_blood_group.len			=0;
 d_rhesus_code.arr[0]		='\0';
 d_rhesus_code.len			=0;
 d_comment_code.arr[0]		='\0';
 d_comment_code.len			=0;
 d_added_date.arr[0]		='\0';
 d_added_date.len			=0;
 d_episode_no.arr[0]		='\0';
 d_episode_no.len			=0;
 d_ordered_facility_id.arr[0]	=	'\0';
 d_ordered_facility_id.len		= 0;
                                                                                                            

    /* EXEC SQL	SELECT	A.patient_id,A.episode_type,A.episode_no,A.source_type,
						A.source_code,A.consultant_code, A.blood_group, A.rhesus_code,
						A.comment_code,to_char(A.added_date,'dd/mm/yyyy hh24:mi'),
						B.ordered_facility_id
				INTO	:d_patient_id,:d_episode_type, :d_episode_no,
						:d_source_type, :d_source_code,
						:d_consultant_code,:d_blood_group,:d_rhesus_code,
						:d_comment_code,:d_added_date, :d_ordered_facility_id
				FROM BT_UNIT_REQUEST_HDR A, RL_REQUEST_HEADER B
				WHERE A.specimen_no =:d_specimen_no
				AND	  A.operating_facility_id = :nd_operating_facility_id
				AND A.specimen_no = B.specimen_no
				AND A.operating_facility_id = B.operating_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 13;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select A.patient_id ,A.episode_type ,A.episode_no ,A.sour\
ce_type ,A.source_code ,A.consultant_code ,A.blood_group ,A.rhesus_code ,A.com\
ment_code ,to_char(A.added_date,'dd/mm/yyyy hh24:mi') ,B.ordered_facility_id i\
nto :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10  from BT_UNIT_REQUEST_HDR A ,\
RL_REQUEST_HEADER B where (((A.specimen_no=:b11 and A.operating_facility_id=:b\
12) and A.specimen_no=B.specimen_no) and A.operating_facility_id=B.operating_f\
acility_id)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )189;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_patient_id;
    sqlstm.sqhstl[0] = (unsigned int  )33;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_episode_type;
    sqlstm.sqhstl[1] = (unsigned int  )23;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_episode_no;
    sqlstm.sqhstl[2] = (unsigned int  )33;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_source_type;
    sqlstm.sqhstl[3] = (unsigned int  )23;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_source_code;
    sqlstm.sqhstl[4] = (unsigned int  )23;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_consultant_code;
    sqlstm.sqhstl[5] = (unsigned int  )23;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_blood_group;
    sqlstm.sqhstl[6] = (unsigned int  )7;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_rhesus_code;
    sqlstm.sqhstl[7] = (unsigned int  )7;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&d_comment_code;
    sqlstm.sqhstl[8] = (unsigned int  )23;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&d_added_date;
    sqlstm.sqhstl[9] = (unsigned int  )33;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&d_ordered_facility_id;
    sqlstm.sqhstl[10] = (unsigned int  )7;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&d_specimen_no;
    sqlstm.sqhstl[11] = (unsigned int  )33;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[12] = (unsigned int  )7;
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



// added the table RL_REQUEST_HEADER and corresponding where condition on 03/02/2010						

	    d_patient_id.arr[d_patient_id.len]				='\0';
		d_episode_type.arr[d_episode_type.len]			='\0';
		d_episode_no.arr[d_episode_no.len]				='\0';
		d_source_type.arr[d_source_type.len]			='\0';
 		d_source_code.arr[d_source_code.len]			='\0';
 		d_consultant_code.arr[d_consultant_code.len]	='\0';
 		d_blood_group.arr[d_blood_group.len]			='\0';
		d_rhesus_code.arr[d_rhesus_code.len]			='\0';
		d_comment_code.arr[d_comment_code.len]			='\0';
		d_added_date.arr[d_added_date.len]				='\0';
 		d_ordered_facility_id.arr[d_ordered_facility_id.len]	=	'\0';
 
}

/*********PRINT PATIENT DTLS**************/
print_patient_dtls()
{

	print_title();

//	void printt_page_header(); // added by preetham on 01/06/2009

	//fprintf(f1, "------------------------------------------------------------------------------\n");
	fprintf(f1, "%-15s: ",local_legend[1]);
	fprintf(f1, "%-20.20s", d_patient_id.arr);
	get_patient_name();
	fprintf(f1, "\t\t%-30.30s\n", d_patient_name.arr);
	fprintf(f1, "%-15s: ",local_legend[2]);

	if (strcmp(d_sex.arr,"M")==0) 
	{
		fprintf(f1, "%-6.6s",local_legend[28]);
	}
	else if (strcmp(d_sex.arr,"F")==0) 
	{
		fprintf(f1, "%-6.6s",local_legend[29]);
	}
	else
	{
		fprintf(f1, "%-6.6s",local_legend[30]);
	}

//	fprintf(f1, "%-6.6s",d_sex.arr);


	//fprintf(f1, "                        ");
	fprintf(f1, "%-23.23s %-12s: "," ",local_legend[3]);



/* EXEC SQL EXECUTE
	DECLARE
	t_date   date;
	BEGIN
//	GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:d_date_of_birth,'DD/MM/YYYY'), :language_id , t_date);
	GET_LOCALE_DATE_2T.CONVERT_TO_LOCALE_DATE (to_date(:d_date_of_birth,'DD/MM/YYYY'), :language_id , :d_date_of_birth, 'DD/MM/YYYY'); // added by preetham on 1/06/2009 wrt leap year issue (and all other get_local_date)
//	:d_date_of_birth := to_char(t_date,'DD/MM/YYYY');
	END;
END-EXEC; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 13;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "declare t_date date ; BEGIN GET_LOCALE_DATE_2T . CONVERT_TO_L\
OCALE_DATE ( to_date ( :d_date_of_birth , 'DD/MM/YYYY' ) , :language_id , :d_d\
ate_of_birth , 'DD/MM/YYYY' ) ; END ;";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )256;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&d_date_of_birth;
sqlstm.sqhstl[0] = (unsigned int  )102;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&language_id;
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







	fprintf(f1, "%-10.10s\n",d_date_of_birth.arr);
	fprintf(f1, "%-15s: ",local_legend[4]);
	fprintf(f1, "%-22.22s", d_specimen_no.arr);
	


/* EXEC SQL EXECUTE
	DECLARE
	s_date   date;
	BEGIN
//	GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:d_added_date,'DD/MM/YYYY hh24:mi'), :language_id , s_date);
	GET_LOCALE_DATE_2T.CONVERT_TO_LOCALE_DATE (to_date(:d_added_date,'DD/MM/YYYY HH24:MI'), :language_id , :d_added_date, 'DD/MM/YYYY HH24:MI');
//	:d_added_date := to_char(s_date,'DD/MM/YYYY');
	END;
END-EXEC; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 13;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "declare s_date date ; BEGIN GET_LOCALE_DATE_2T . CONVERT_TO_L\
OCALE_DATE ( to_date ( :d_added_date , 'DD/MM/YYYY HH24:MI' ) , :language_id ,\
 :d_added_date , 'DD/MM/YYYY HH24:MI' ) ; END ;";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )279;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&d_added_date;
sqlstm.sqhstl[0] = (unsigned int  )33;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&language_id;
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




	fprintf(f1, " %-4.4s %-14s : "," ",local_legend[5]);
	fprintf(f1, "%-20.20s\n", d_added_date.arr);
	fprintf(f1, "%-15s: ",local_legend[9]);
	fprintf(f1, "%-5.5s",d_source_code.arr);
	get_source_desc();
	fprintf(f1, "%-15.15s\n",d_source_desc.arr);
	fprintf(f1, "%-15s: ",local_legend[6]);
//	fprintf(f1, "%-5.5s",d_consultant_code.arr);
	get_consultant_name();	
	fprintf(f1, "%s\n",d_consultant_name.arr);	
	fprintf(f1, "%-15s: ",local_legend[7]);
	fprintf(f1, "%1.4s",d_blood_group.arr);
	fprintf(f1, "   ");
	fprintf(f1, "%29.29s %-8s : "," ",local_legend[8]);
	fprintf(f1, "%4.4s\n",d_rhesus_code.arr);
	fprintf(f1, "------------------------------------------------------------------------------\n");


	line_no = line_no + 8;
}

/*------------------PATIENT NAME--------------------*/

get_patient_name()
{

 d_patient_name.arr[0]					= '\0';
 d_patient_name.len						= 0;
 d_date_of_birth.arr[0]					= '\0';
 d_date_of_birth.len					= 0;
 d_sex.arr[0]							= '\0';
 d_sex.len								= 0;
              
			                                                                                                 
    /* EXEC SQL	SELECT Decode(:language_id,'en',short_name,NVL(short_name_loc_lang,short_name)) ,
				to_char(date_of_birth,'dd/mm/yyyy') date_of_birth,
//				decode(sex ,'M','Male','F','Female') sex
				sex
				INTO :d_patient_name, :d_date_of_birth, :d_sex
				FROM MP_PATIENT_MAST
				WHERE patient_id=:d_patient_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 13;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select Decode(:b0,'en',short_name,NVL(short_name_loc_lang\
,short_name)) ,to_char(date_of_birth,'dd/mm/yyyy') date_of_birth ,sex into :b1\
,:b2,:b3  from MP_PATIENT_MAST where patient_id=:b4";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )302;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&language_id;
    sqlstm.sqhstl[0] = (unsigned int  )7;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_patient_name;
    sqlstm.sqhstl[1] = (unsigned int  )302;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_date_of_birth;
    sqlstm.sqhstl[2] = (unsigned int  )102;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_sex;
    sqlstm.sqhstl[3] = (unsigned int  )102;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_patient_id;
    sqlstm.sqhstl[4] = (unsigned int  )33;
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



	  if (NODATAFOUND)
	{

    /* EXEC SQL	SELECT SUBSTR(Decode(:language_id,'en',person_name,NVL(person_name_loc_lang,person_name)),1,80),
				to_char(date_of_birth,'dd/mm/yyyy') date_of_birth,
//				decode(sex ,'M','Male','F','Female') sex
				sex
				INTO :d_patient_name, :d_date_of_birth, :d_sex
				FROM MP_EXT_PERSON
				WHERE person_id=:d_patient_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 13;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select SUBSTR(Decode(:b0,'en',person_name,NVL(person_name\
_loc_lang,person_name)),1,80) ,to_char(date_of_birth,'dd/mm/yyyy') date_of_bir\
th ,sex into :b1,:b2,:b3  from MP_EXT_PERSON where person_id=:b4";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )337;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&language_id;
    sqlstm.sqhstl[0] = (unsigned int  )7;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_patient_name;
    sqlstm.sqhstl[1] = (unsigned int  )302;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_date_of_birth;
    sqlstm.sqhstl[2] = (unsigned int  )102;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_sex;
    sqlstm.sqhstl[3] = (unsigned int  )102;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_patient_id;
    sqlstm.sqhstl[4] = (unsigned int  )33;
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
									
	d_patient_name.arr[d_patient_name.len]		= '\0';
	d_date_of_birth.arr[d_date_of_birth.len]	= '\0';
	d_sex.arr[d_sex.len]						= '\0';

/*****************  
    if (strlen(d_date_of_birth.arr) > 0) 
	{
		EXEC SQL EXECUTE
		BEGIN
			GET_LOCALE_DATE_2T.CONVERT_TO_LOCALE_DATE (to_date(:d_date_of_birth,'DD/MM/YYYY'), :language_id, :d_date_of_birth, 'DD/MM/YYYY');
		END;
		END-EXEC;
	}	
	d_date_of_birth.arr[d_date_of_birth.len]	= '\0';
****************************/
}

/*------------------CONSULTANT NAME--------------------*/

get_consultant_name()
{

 d_consultant_name.arr[0]	='\0';
 d_consultant_name.len		=0;

	//if (d_episode_type.arr[0] == 'I' || d_episode_type.arr[0]== 'O')

	if (d_episode_type.arr[0] == 'I')
	{
	
			/* EXEC SQL	SELECT short_name
				INTO :d_consultant_name
				FROM SY_PHYSICIAN_MAST_lang_vw
				WHERE physician_id=:d_consultant_code
				and language_id=:language_id
				and facility_id = :d_ordered_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 13;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select short_name into :b0  from SY_PHYSICIAN_MAST_lang_vw\
 where ((physician_id=:b1 and language_id=:b2) and facility_id=:b3)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )372;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_consultant_name;
   sqlstm.sqhstl[0] = (unsigned int  )122;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_consultant_code;
   sqlstm.sqhstl[1] = (unsigned int  )23;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&language_id;
   sqlstm.sqhstl[2] = (unsigned int  )7;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_ordered_facility_id;
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

					
// Added the condition facility on 03/02/2010
	}

	else if (d_episode_type.arr[0]== 'O')
	{
	
			/* EXEC SQL	SELECT short_name
				INTO :d_consultant_name
				FROM SY_PHYSICIAN_MAST_lang_vw
				WHERE physician_id=:d_consultant_code
				and language_id = :language_id
				and facility_id = :d_ordered_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 13;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select short_name into :b0  from SY_PHYSICIAN_MAST_lang_vw\
 where ((physician_id=:b1 and language_id=:b2) and facility_id=:b3)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )403;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_consultant_name;
   sqlstm.sqhstl[0] = (unsigned int  )122;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_consultant_code;
   sqlstm.sqhstl[1] = (unsigned int  )23;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&language_id;
   sqlstm.sqhstl[2] = (unsigned int  )7;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_ordered_facility_id;
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

					
// Added the condition facility on 03/02/2010

	}

	else	

	{
	
		/* EXEC SQL	SELECT short_name
				INTO :d_consultant_name
				FROM RL_CONSULTANTS_LANG_VW
				WHERE ref_consultant_id=:d_consultant_code
				and language_id = :language_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 13;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select short_name into :b0  from RL_CONSULTANTS_LANG_VW whe\
re (ref_consultant_id=:b1 and language_id=:b2)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )434;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_consultant_name;
  sqlstm.sqhstl[0] = (unsigned int  )122;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_consultant_code;
  sqlstm.sqhstl[1] = (unsigned int  )23;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&language_id;
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

	d_consultant_name.arr[d_consultant_name.len]	='\0';
		

	if (NODATAFOUND);
  
}

/*------------------SOURCE DESCRIPTION--------------------*/

get_source_desc()
{

   d_source_desc.arr[0]	='\0';
   d_source_desc.len		=0;


	if (d_source_type.arr[0] == 'C')
	{                                                                                                             
			/* EXEC SQL	SELECT short_desc
				INTO :d_source_desc
				FROM OP_CLINIC_lang_vw
				WHERE clinic_code=:d_source_code
				and language_id = :language_id
				and facility_id = :d_ordered_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 13;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select short_desc into :b0  from OP_CLINIC_lang_vw where (\
(clinic_code=:b1 and language_id=:b2) and facility_id=:b3)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )461;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_source_desc;
   sqlstm.sqhstl[0] = (unsigned int  )122;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_source_code;
   sqlstm.sqhstl[1] = (unsigned int  )23;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&language_id;
   sqlstm.sqhstl[2] = (unsigned int  )7;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_ordered_facility_id;
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


// Added the facility condition on 03/02/2010
					
	}
    else if (d_source_type.arr[0]== 'W')
	{                                                                                                             


		/* EXEC SQL	SELECT short_desc
				INTO :d_source_desc
				FROM IP_NURSING_UNIT_LANG_VW
				WHERE nursing_unit_code = :d_source_code
				AND language_id = :language_id
				AND facility_id = :d_ordered_facility_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 13;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select short_desc into :b0  from IP_NURSING_UNIT_LANG_VW wh\
ere ((nursing_unit_code=:b1 and language_id=:b2) and facility_id=:b3)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )492;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_source_desc;
  sqlstm.sqhstl[0] = (unsigned int  )122;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_source_code;
  sqlstm.sqhstl[1] = (unsigned int  )23;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&language_id;
  sqlstm.sqhstl[2] = (unsigned int  )7;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_ordered_facility_id;
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



//				FROM IP_WARD
//				WHERE ward_code=:d_source_code;
//	Changed the table from IP_WARD to IP_NURSING_UNIT and added the facility id condition on 03/02/2010
					
	}
	else
	{
		/* EXEC SQL	SELECT short_desc
				INTO :d_source_desc
				FROM RL_REFERRAL
				WHERE referral_code=:d_source_code; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 13;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select short_desc into :b0  from RL_REFERRAL where referral\
_code=:b1";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )523;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_source_desc;
  sqlstm.sqhstl[0] = (unsigned int  )122;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_source_code;
  sqlstm.sqhstl[1] = (unsigned int  )23;
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


	d_source_desc.arr[d_source_desc.len]	='\0';

	if (NODATAFOUND);  
}


/********* DECLARE CATEGORY_CURSOR **********/

dclr_category_cur()
{

  /* EXEC SQL DECLARE CATEGORY_CURSOR CURSOR FOR
          SELECT category_code,product_code,nvl(category_requested,0),nvl(category_allocated,0)
		  FROM BT_UNIT_REQUEST_CATEGORY A
          WHERE A.specimen_no = :d_specimen_no
		  AND	A.operating_facility_id=:nd_operating_facility_id; */ 

}


/********* OPEN CATEGORY CURSOR **********/
open_category_cur()
{
     /* EXEC SQL OPEN CATEGORY_CURSOR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 13;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0020;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )546;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&d_specimen_no;
     sqlstm.sqhstl[0] = (unsigned int  )33;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
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



}

/********* FETCH CATEGORY CURSOR **********/
int fetch_category_cur()
 
{

  char msg_1[200];

  d_category_code.arr[0]	= '\0';
  d_cat_prod_code.arr[0]    ='\0';
  d_category_code.len		= 0;
  d_category_requested       =0;
  d_category_allocated        =0;
  


  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


  /* EXEC SQL FETCH CATEGORY_CURSOR	
            INTO :d_category_code,
			     :d_cat_prod_code,
			     :d_category_requested,
			      :d_category_allocated; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 13;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )569;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_category_code;
  sqlstm.sqhstl[0] = (unsigned int  )33;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_cat_prod_code;
  sqlstm.sqhstl[1] = (unsigned int  )33;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_category_requested;
  sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_category_allocated;
  sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
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


 				 
  d_category_code.arr[d_category_code.len]	= '\0';
  d_cat_prod_code.arr[d_cat_prod_code.len]  = '\0';


#ifdef DEBUG
         printf("SQLCA code after fetch :%d\n", sqlca.sqlcode);
#endif

  if (NODATAFOUND)
{
    return 0;
}

  return 1;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 13;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )600;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at fetch_Category_cursor() occured....\n");
   proc_exit();

}

/********** CLOSE CATEGORY CURSOR *********/
close_category_cur()
{
  
	 /* EXEC SQL CLOSE CATEGORY_CURSOR ; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 13;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )615;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



}

/*------------------CATEGORY DESCRIPTION--------------------*/

get_category_desc()
{

 d_short_desc.arr[0]					= '\0';
 d_short_desc.len						= 0;
                                                                                                             
    /* EXEC SQL	SELECT short_desc
				INTO :d_short_desc
				FROM BT_CATEGORY_MAST_lang_vw
				WHERE CATEGORY_CODE = :d_category_code
				and language_id = :language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 13;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select short_desc into :b0  from BT_CATEGORY_MAST_lang_vw\
 where (CATEGORY_CODE=:b1 and language_id=:b2)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )630;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_short_desc;
    sqlstm.sqhstl[0] = (unsigned int  )102;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_category_code;
    sqlstm.sqhstl[1] = (unsigned int  )33;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&language_id;
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


									
	d_short_desc.arr[d_short_desc.len]					= '\0';
 	

}

/*------------------CATEGORY COMMENTS--------------------*/

get_comment()
{

 d_comment_desc.arr[0]					= '\0';
 d_comment_desc.len						= 0;
                                                                                                             
    /* EXEC SQL	SELECT long_desc
				INTO :d_comment_desc
				FROM BT_CMATCH_COMMENT_MAST
				WHERE COMMENT_CODE= :d_comment_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 13;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select long_desc into :b0  from BT_CMATCH_COMMENT_MAST wh\
ere COMMENT_CODE=:b1";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )657;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_comment_desc;
    sqlstm.sqhstl[0] = (unsigned int  )1002;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_comment_code;
    sqlstm.sqhstl[1] = (unsigned int  )23;
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


									
	d_comment_desc.arr[d_comment_desc.len]					= '\0';
 	
 fprintf(f1, "------------------------------------------------------------------------------\n");	
// fprintf(f1, "Comment : ");
 fprintf(f1, "%s : ",local_legend[31]);
 fprintf(f1, "%-40.40s\n",d_comment_desc.arr);
 fprintf(f1, "------------------------------------------------------------------------------\n\n");	
 line_no=line_no + 4;

}

/************* DO CATEGORY *******************/

do_category()
{

  int still_category_exist=0;

  chk_break(5);
  //fprintf(f1, "%s   %s                %s  \n",local_legend[10],local_legend[11],local_legend[21]);

  fprintf(f1, "%-20s%-30s%-20s\n",local_legend[10],local_legend[11],local_legend[21]);
//  fprintf(f1, "Product Code   Category Name              Units Required  \n");
  fprintf(f1, "------------------------------------------------------------------------------\n");

   line_no = line_no + 2;

  dclr_category_cur();
  open_category_cur();

  still_category_exist = fetch_category_cur();
  while (still_category_exist==1)
  {

       print_category_dtls();

       still_category_exist=fetch_category_cur();
  } 
 
 get_comment();

 close_category_cur();
  	  
 
}

/************************PRINT CATEGORY*********************/
print_category_dtls()
{
  chk_break(1);

 get_category_desc();

 /*fprintf(f1, "%-15.15s",d_cat_prod_code.arr);
 fprintf(f1, "   %-5.5s",d_category_code.arr);
 fprintf(f1, "   ");
 fprintf(f1, "%-20.20s",d_short_desc.arr);
 fprintf(f1, "\t%4d\n",d_category_requested);*/

 fprintf(f1, "%-20s",d_cat_prod_code.arr);
 fprintf(f1, "%-8s",d_category_code.arr);
 fprintf(f1, "%-22s",d_short_desc.arr);
 fprintf(f1, "%d\n",d_category_requested);


 line_no++;
}


/********* DECLARE PATIENT_DETAIL_CURSOR **********/

  dclr_patient_dtl_cur()
  {
  
  /* EXEC SQL DECLARE PATIENT_DTL_CURSOR CURSOR FOR
        SELECT	A.unit_no,A.product_code,to_char(A.reserved_date,'dd/mm/yyyy hh24:mi:ss'),
				A.crossmatched_yn,A.ignore_crossmatch_yn,
				DECODE(A.ignore_crossmatch_yn,'Y',A.ignore_remarks) ,
//				decode(A.unit_status,'UA','Allocated','UR','Compatible/Suitable','UP',
//				'Incompatible','US','Re-Reserved','UI','Issued','UE','Issued Transferred',
//				'UN','Returned','UT','Transfused') unit_status,
				C.description unit_status,
				A.allocated_by,A.Issued_by,A.issued_to,
				TO_CHAR(A.issued_date, 'DD/MM/YYYY hh24:mi:ss'),
				B.blood_group,B.rhesus_code,B.current_volume,B.volume_units,
				B.aliquoted_yn,to_char(b.expiry_date,'dd/mm/yyyy hh24:mi:ss') //Added "expiry_date" for ghl-crf-0314 by krishnamoorthys
		FROM	BT_UNIT_REQUEST_DTL A, BT_BLOOD_UNITS_MAST B, BT_DECODED_UNIT_STATUS_LANG_VW C
	    WHERE   A.specimen_no = :d_specimen_no
		  AND   A.unit_no = B.unit_no
		  AND   A.product_code = B.product_code
		  AND   A.unit_status = DECODE(:d_flag, 'A', 'UA', 'R', 'UR', 'I', 'UI', 'T', 'UT','X','TF', A.unit_status)
		  AND   A.unit_status = C.dec_unit_status_code
		  AND   C.language_id = :language_id
		  AND	A.operating_facility_id=B.operating_facility_id
		  AND	A.operating_facility_id=:nd_operating_facility_id
		ORDER BY A.unit_no; */ 


}

/*********OPEN PATIENT_DETAIL_CURSOR **********/

 open_patient_dtl_cur()
 {
     /* EXEC SQL OPEN PATIENT_DTL_CURSOR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 13;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0024;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )680;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&d_specimen_no;
     sqlstm.sqhstl[0] = (unsigned int  )33;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_flag;
     sqlstm.sqhstl[1] = (unsigned int  )5;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&language_id;
     sqlstm.sqhstl[2] = (unsigned int  )7;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
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



  }

/********* FETCH PATIENT_DETAIL CURSOR **********/
int fetch_patient_dtl_cur()
{
	d_unit_no.arr[0]				=	'\0';
	d_unit_no.len					=	0;
	d_product_code.arr[0]			=	'\0';
	d_product_code.len				=	0;
	d_reserved_date.arr[0]			=	'\0';
	d_reserved_date.len				=	0;
	d_crossmatched_yn.arr[0]		=	'\0';
	d_crossmatched_yn.len			=	0;
	d_ignore_crossmatch_yn.arr[0]	=	'\0';
	d_ignore_crossmatch_yn.len		=	0;
	d_ignore_remarks.arr[0]			=	'\0';
	d_ignore_remarks.len			=	0;
	d_unit_status.arr[0]			=	'\0'; 
	d_unit_status.len				=	0; 
	d_allocated_by.arr[0]			=	'\0';
	d_allocated_by.len				=	0;
	d_issued_by.arr[0]				=	'\0';
	d_issued_by.len					=	0;
	d_issued_to.arr[0]				=	'\0';
	d_issued_to.len					=	0;
	d_issued_on.arr[0]				=	'\0';
	d_issued_on.len					=	0;
	nd_blood_group.arr[0]			=	'\0';
	nd_blood_group.len				=	0;
	nd_rhesus_code.arr[0]			=	'\0';
	nd_rhesus_code.len				=	0;
	d_current_volume.arr[0]			=	'\0';
	d_current_volume.len			=	0;
	d_volume_units.arr[0]			=	'\0';
	d_volume_units.len				=	0;
	d_aliquoted_yn.arr[0]			=	'\0';
	d_aliquoted_yn.len				=	0;
	
	d_expiry_date.arr[0]			=	'\0';//Added for ghl-crf-0314 by krishnamoorthys
	d_expiry_date.len				=	0;//Added for ghl-crf-0314 by krishnamoorthys

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


  /* EXEC SQL FETCH PATIENT_DTL_CURSOR	
            INTO	:d_unit_no,
					:d_product_code,
					:d_reserved_date,
					:d_crossmatched_yn,
					:d_ignore_crossmatch_yn,
					:d_ignore_remarks,
					:d_unit_status,
					:d_allocated_by,
					:d_issued_by,
					:d_issued_to,
					:d_issued_on,
					:nd_blood_group,
					:nd_rhesus_code,
					:d_current_volume,
					:d_volume_units,
					:d_aliquoted_yn,
					:d_expiry_date; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 17;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )711;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_unit_no;
  sqlstm.sqhstl[0] = (unsigned int  )33;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_product_code;
  sqlstm.sqhstl[1] = (unsigned int  )33;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_reserved_date;
  sqlstm.sqhstl[2] = (unsigned int  )33;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_crossmatched_yn;
  sqlstm.sqhstl[3] = (unsigned int  )4;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_ignore_crossmatch_yn;
  sqlstm.sqhstl[4] = (unsigned int  )4;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_ignore_remarks;
  sqlstm.sqhstl[5] = (unsigned int  )1003;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&d_unit_status;
  sqlstm.sqhstl[6] = (unsigned int  )23;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&d_allocated_by;
  sqlstm.sqhstl[7] = (unsigned int  )33;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&d_issued_by;
  sqlstm.sqhstl[8] = (unsigned int  )33;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&d_issued_to;
  sqlstm.sqhstl[9] = (unsigned int  )33;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&d_issued_on;
  sqlstm.sqhstl[10] = (unsigned int  )33;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&nd_blood_group;
  sqlstm.sqhstl[11] = (unsigned int  )7;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&nd_rhesus_code;
  sqlstm.sqhstl[12] = (unsigned int  )7;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&d_current_volume;
  sqlstm.sqhstl[13] = (unsigned int  )8;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&d_volume_units;
  sqlstm.sqhstl[14] = (unsigned int  )7;
  sqlstm.sqhsts[14] = (         int  )0;
  sqlstm.sqindv[14] = (         void  *)0;
  sqlstm.sqinds[14] = (         int  )0;
  sqlstm.sqharm[14] = (unsigned int  )0;
  sqlstm.sqadto[14] = (unsigned short )0;
  sqlstm.sqtdso[14] = (unsigned short )0;
  sqlstm.sqhstv[15] = (         void  *)&d_aliquoted_yn;
  sqlstm.sqhstl[15] = (unsigned int  )4;
  sqlstm.sqhsts[15] = (         int  )0;
  sqlstm.sqindv[15] = (         void  *)0;
  sqlstm.sqinds[15] = (         int  )0;
  sqlstm.sqharm[15] = (unsigned int  )0;
  sqlstm.sqadto[15] = (unsigned short )0;
  sqlstm.sqtdso[15] = (unsigned short )0;
  sqlstm.sqhstv[16] = (         void  *)&d_expiry_date;
  sqlstm.sqhstl[16] = (unsigned int  )52;
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
  if (sqlca.sqlcode < 0) goto err_exit;
}

 //Added for ghl-crf-0314 by krishnamoorthys

    if (strlen(d_reserved_date.arr) > 0) 
	{
		/* EXEC SQL EXECUTE
		BEGIN
			GET_LOCALE_DATE_2T.CONVERT_TO_LOCALE_DATE (to_date(:d_reserved_date,'DD/MM/YYYY HH24:MI:SS'), :language_id, :d_reserved_date, 'DD/MM/YYYY HH24:MI:SS');
		END;
		END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 17;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin GET_LOCALE_DATE_2T . CONVERT_TO_LOCALE_DATE ( to_date\
 ( :d_reserved_date , 'DD/MM/YYYY HH24:MI:SS' ) , :language_id , :d_reserved_d\
ate , 'DD/MM/YYYY HH24:MI:SS' ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )794;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_reserved_date;
  sqlstm.sqhstl[0] = (unsigned int  )33;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&language_id;
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


	}	
    if (strlen(d_issued_on.arr) > 0) 
	{
		/* EXEC SQL EXECUTE
		BEGIN
			GET_LOCALE_DATE_2T.CONVERT_TO_LOCALE_DATE (to_date(:d_issued_on,'DD/MM/YYYY HH24:MI:SS'), :language_id, :d_issued_on, 'DD/MM/YYYY HH24:MI:SS');
		END;
		END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 17;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin GET_LOCALE_DATE_2T . CONVERT_TO_LOCALE_DATE ( to_date\
 ( :d_issued_on , 'DD/MM/YYYY HH24:MI:SS' ) , :language_id , :d_issued_on , 'D\
D/MM/YYYY HH24:MI:SS' ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )817;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_issued_on;
  sqlstm.sqhstl[0] = (unsigned int  )33;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&language_id;
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


	}	
	
	//*****Added for ghl-crf-0314 by krishnamoorthys********//
	if (strlen(d_expiry_date.arr) > 0) 
	{
		/* EXEC SQL EXECUTE
		BEGIN
			GET_LOCALE_DATE_2T.CONVERT_TO_LOCALE_DATE (to_date(:d_expiry_date,'DD/MM/YYYY HH24:MI:SS'), :language_id, :d_expiry_date, 'DD/MM/YYYY HH24:MI:SS');
		END;
		END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 17;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin GET_LOCALE_DATE_2T . CONVERT_TO_LOCALE_DATE ( to_date\
 ( :d_expiry_date , 'DD/MM/YYYY HH24:MI:SS' ) , :language_id , :d_expiry_date \
, 'DD/MM/YYYY HH24:MI:SS' ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )840;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_expiry_date;
  sqlstm.sqhstl[0] = (unsigned int  )52;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&language_id;
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


	}	
     //************//

	d_unit_no.arr[d_unit_no.len]							=	'\0';
	d_product_code.arr[d_product_code.len]					=	'\0';
	d_reserved_date.arr[d_reserved_date.len]				=	'\0';
	d_crossmatched_yn.arr[d_crossmatched_yn.len]			=	'\0';
	d_ignore_crossmatch_yn.arr[d_ignore_crossmatch_yn.len]	=	'\0';
	d_ignore_remarks.arr[d_ignore_remarks.len]				=	'\0';
	d_unit_status.arr[d_unit_status.len]					=	'\0';
	d_allocated_by.arr[d_allocated_by.len]					=	'\0';
	d_issued_by.arr[d_issued_by.len]						=	'\0';
	d_issued_to.arr[d_issued_to.len]						=	'\0';
	d_issued_on.arr[d_issued_on.len]						=	'\0';
	nd_blood_group.arr[nd_blood_group.len]					=	'\0';
	nd_rhesus_code.arr[nd_rhesus_code.len]					=	'\0';
	d_current_volume.arr[d_current_volume.len]				=	'\0';
	d_volume_units.arr[d_volume_units.len]					=	'\0';
	d_aliquoted_yn.arr[d_aliquoted_yn.len]					=	'\0';
	
	d_expiry_date.arr[d_expiry_date.len]					=	'\0';//Added for ghl-crf-0314 by krishnamoorthys





#ifdef DEBUG
         printf("SQLCA code after fetch :%d\n", sqlca.sqlcode);
#endif

  if (NODATAFOUND)
{
    return 0;
}
  return 1;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 17;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )863;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


     disp_message(ORA_MESG,"Oracle error at fetch_patient_dtl_cursor() occured....\n");
   proc_exit();

}

/********** CLOSE PATIENT_DTL CURSOR *********/
close_patient_dtl_cur()
{
  
	 /* EXEC SQL CLOSE PATIENT_DTL_CURSOR ; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 17;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )878;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



}
/************* GET PATIENT SPEC DETAILS *******************/

get_patient_spec_dtls()
{

int still_pat_dtls_exist = 0;
 

 chk_break(7);

 fprintf(f1,"------------------------------------------------------------------------------\n");


//fprintf(f1,"%-20s%-10s%-8s%-8s%-20s%s\n",local_legend[12],local_legend[13],local_legend[14],local_legend[8],local_legend[15],local_legend[16]);
  if (strcmp(l_cust_id.arr,"MC")==0)  //added if/else part for GHL-CRF-0314 by krishnamoorthys
  {
  fprintf(f1,"%-16s%-10s%-6s%-7s%-19s%s\n",local_legend[12],local_legend[13],local_legend[14],local_legend[8],local_legend[15],local_legend[32]);
  fprintf(f1,"%-26s%-8s%-24s%s\n"," ",local_legend[17]," ",local_legend[34]);
  }
  else
  {
  fprintf(f1,"%-16s%-10s%-6s%-7s%-19s%s\n",local_legend[12],local_legend[13],local_legend[14],local_legend[8],local_legend[15],local_legend[16]);
  fprintf(f1,"%-26s%-8s%-24s%s\n"," ",local_legend[17]," ",local_legend[18]);
  }
  


 fprintf(f1,"------------------------------------------------------------------------------\n");
 //fprintf(f1,"%s\n",local_legend[19]);
 //fprintf(f1,"%s\n",local_legend[20]);
 line_no = line_no + 4;


  dclr_patient_dtl_cur();
  open_patient_dtl_cur();

  still_pat_dtls_exist = fetch_patient_dtl_cur();

  while (still_pat_dtls_exist == 1)
  {
      print_patient_spec_dtls();

      still_pat_dtls_exist=fetch_patient_dtl_cur();
  } 
 close_patient_dtl_cur();
 
 fprintf(f1,"\n");
 line_no = line_no + 1;

}
/****************PRINT PATIENT SPEC DETAILS**************/

print_patient_spec_dtls()
{

 chk_break(1);



fprintf(f1,"%-16s",d_unit_no.arr);
 fprintf(f1,"%-10s",d_product_code.arr);
 /*************fprintf(f1,"%-5.5s",d_blood_group.arr);*************/
 fprintf(f1,"%-6s",nd_blood_group.arr);
 /**************fprintf(f1,"%-6.6s",d_rhesus_code.arr);*************/
 fprintf(f1,"%-6s",nd_rhesus_code.arr);

 fprintf(f1,"%-20s",d_unit_status.arr);
 
 if (strcmp(l_cust_id.arr,"MC")==0) //added if/else part for GHL-CRF-0314 by krishnamoorthys
 {
 fprintf(f1,"%s\n",d_expiry_date.arr);
 }
 else
 {
 fprintf(f1,"%s\n",d_reserved_date.arr);
 }

 line_no = line_no + 1;
 
  if ( strlen(d_issued_by.arr) > 0 || strlen(d_issued_to.arr) > 0)
  {
     //fprintf(f1, "Issued by - to - on : ");
	 fprintf(f1, "%-10.10s: %-10.10s",local_legend[23],d_issued_by.arr);
	 fprintf(f1, "%-4s -  %-10.10s",local_legend[24],d_issued_to.arr);
	 fprintf(f1, "%-4.4s - %-20.20s \n",local_legend[25],d_issued_on.arr);
	 //fprintf(f1,"%-20.20s - %-10.10s - %20.20s\n",d_issued_by.arr, d_issued_to.arr,d_issued_on.arr);
	 line_no = line_no + 1;

  }

  if (d_ignore_crossmatch_yn.arr[0] == 'Y') 
  {
 //	fprintf(f1, "Bypass Crossmatch - Remarks : ");
	fprintf(f1, "%s: ",local_legend[19]);
	fprintf(f1,"%-10s\n",d_ignore_remarks.arr);
	line_no = line_no + 1;
  }
 
  if (d_aliquoted_yn.arr[0] == 'Y') 
  {
	get_aliquote_rmks();

	chk_break(1);
	//fprintf(f1, "Aliquot - Remarks : ");
	fprintf(f1, "%s: ",local_legend[20]);
	fprintf(f1,"%s\n",d_aliquot_rmks.arr);

	line_no = line_no + 1;
  }

  
}

/*****************************GET ALIQUOT REMARKS**********************/
get_aliquote_rmks()
{

 d_aliquot_rmks.arr[0]				= '\0';
 d_aliquot_rmks.len					= 0;
                                                                                                            
    /* EXEC SQL	SELECT SUBSTR(aliquot_remarks, 1, 78)
				INTO :d_aliquot_rmks
				FROM BT_ALIQUOT_UNITS
				WHERE Unit_no=:d_unit_no
					AND product_code=:d_product_code
					AND operating_facility_id = :nd_operating_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 17;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select SUBSTR(aliquot_remarks,1,78) into :b0  from BT_ALI\
QUOT_UNITS where ((Unit_no=:b1 and product_code=:b2) and operating_facility_id\
=:b3)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )893;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_aliquot_rmks;
    sqlstm.sqhstl[0] = (unsigned int  )1003;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_unit_no;
    sqlstm.sqhstl[1] = (unsigned int  )33;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_product_code;
    sqlstm.sqhstl[2] = (unsigned int  )33;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
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



// added the facility condition on 03/02/2010						

	   d_aliquot_rmks.arr[d_aliquot_rmks.len] = '\0';



}

/*****************************GET FOOTER**********************/
get_footer()
{

 d_footer_line_1.arr[0]					= '\0';
 d_footer_line_1.len					= 0;
 d_footer_line_2.arr[0]					= '\0';
 d_footer_line_2.len					= 0;
                                                                                                            
    /* EXEC SQL	SELECT SUBSTR(footer_line_1, 1, 75), SUBSTR(footer_line_2, 1, 75)
				INTO :d_footer_line_1,:d_footer_line_2
				FROM BT_PARAM; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 17;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select SUBSTR(footer_line_1,1,75) ,SUBSTR(footer_line_2,1\
,75) into :b0,:b1  from BT_PARAM ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )924;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_footer_line_1;
    sqlstm.sqhstl[0] = (unsigned int  )203;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_footer_line_2;
    sqlstm.sqhstl[1] = (unsigned int  )203;
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


										

	   d_footer_line_1.arr[d_footer_line_1.len] = '\0';
	   d_footer_line_2.arr[d_footer_line_2.len] = '\0';
	
	  chk_break(5);


 fprintf(f1,"------------------------------------------------------------------------------\n");			

 if ( strlen(d_footer_line_1.arr) > 0)
 {
	fprintf(f1,"%-s\n\n",d_footer_line_1.arr);
 }

 if (strlen(d_footer_line_2.arr) > 0)
 {
	fprintf(f1,"%-s\n",d_footer_line_2.arr);
 }

 if (strlen(d_footer_line_1.arr) > 0 || strlen(d_footer_line_2.arr) > 0 )
 {
	fprintf(f1,"------------------------------------------------------------------------------\n");			
 }

}


void end_report()
{
  int rec_len;

  fprintf(f1,"\n");  
  rec_len = strlen(local_legend[26]);//added for globalisation
  print_space(40, rec_len,1);//added for globalisation
  fprintf(f1,"******* %s *******\n", local_legend[26]); // added for globalisation
  fprintf(f1,"\n");
 // fprintf(f1,"\f");
}


/*** added for globalisation ******/
	print_space(int aa, int bb, int cc)
	{
		if (cc ==1)
		{
  			for(i=1;i <= (aa - bb) ;i++)
			{
				fprintf(f1,"%s"," ");
			}	
		}
		else if (cc ==0)
		{
  			for(i= (aa - bb);i <= aa ;i++)
			{
				fprintf(f1,"%s","-");
			}	
		}
	}
/*** added for globalisation ******/




/******************CHECK BREAK**************/
chk_break(int l_no)
{


     if (line_no + l_no  >= MAX_LINES) 
     {

	     line_no=0;
	     fprintf(f1,"\f");
	     fprintf(f1,"\n");
  		 page_no++;
		 print_title();
//		 printt_page_header();
     }

}


/************************************ THE END ************************************/
#undef DEBUG
#undef NODATAFOUND
#undef MAX_LINES
#undef VER

#undef DEBUG
#undef NODATAFOUND
#undef MAX_LINES
#undef VER

