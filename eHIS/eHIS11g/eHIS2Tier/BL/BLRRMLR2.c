
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/BLRRMLR2.PC"
};


static unsigned int sqlctx = 1288468491;


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
            void  *sqhstv[43];
   unsigned int   sqhstl[43];
            int   sqhsts[43];
            void  *sqindv[43];
            int   sqinds[43];
   unsigned int   sqharm[43];
   unsigned int   *sqharc[43];
   unsigned short  sqadto[43];
   unsigned short  sqtdso[43];
} sqlstm = {12,43};

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
"select REMINDER_FORMAT_ID ,DOC_TYPE_CODE ,DOC_NUM ,REMINDER_NO  from BL_BILL\
S_FOR_REMINDER where (REMINDER_DISP_DOC_TYPE,REMINDER_DISP_DOC_NUMBER,REMINDER\
_DISP_DOC_SLNO) in (select DOC_TYPE_CODE ,DOC_NUMBER ,DOC_SRL_NO  from BL_REM_\
LET_PROCESS_TEMP where ((PROCESS_PGM_ID='BLRRMLR2' and PROCESS_SESSION_ID=:b0)\
 and PROCESS_DATE_TIME=:b1)) for update of REMINDER_PRINTED_YN nowait ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,168,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,30,221,0,0,0,0,0,1,0,
51,0,0,3,380,0,9,256,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
74,0,0,4,126,0,2,263,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
97,0,0,3,0,0,15,270,0,0,0,0,0,1,0,
112,0,0,3,0,0,13,306,0,0,4,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
143,0,0,5,111,0,4,416,0,0,4,2,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
174,0,0,6,111,0,4,427,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
205,0,0,7,125,0,4,437,0,0,5,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
240,0,0,8,948,0,4,449,0,0,43,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
427,0,0,9,99,0,5,947,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
450,0,0,10,46,0,4,979,0,0,4,3,0,1,0,1,9,0,0,1,9,0,0,1,3,0,0,2,3,0,0,
481,0,0,11,47,0,4,1003,0,0,4,3,0,1,0,1,9,0,0,1,3,0,0,1,3,0,0,2,9,0,0,
512,0,0,12,47,0,4,1168,0,0,3,2,0,1,0,1,9,0,0,1,3,0,0,2,3,0,0,
539,0,0,13,47,0,4,1189,0,0,3,2,0,1,0,1,9,0,0,1,3,0,0,2,3,0,0,
566,0,0,14,47,0,4,1210,0,0,3,2,0,1,0,1,9,0,0,1,3,0,0,2,3,0,0,
593,0,0,15,47,0,4,1230,0,0,3,2,0,1,0,1,9,0,0,1,3,0,0,2,3,0,0,
620,0,0,16,47,0,4,1249,0,0,3,2,0,1,0,1,9,0,0,1,3,0,0,2,3,0,0,
647,0,0,17,46,0,4,1269,0,0,3,2,0,1,0,1,9,0,0,1,3,0,0,2,3,0,0,
674,0,0,18,47,0,4,1289,0,0,2,1,0,1,0,1,9,0,0,2,3,0,0,
697,0,0,19,338,0,4,1395,0,0,4,2,0,1,0,1,3,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
728,0,0,20,61,0,6,1571,0,0,2,2,0,1,0,1,97,0,0,2,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 4.1                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLRRMLR2.PC                                  */
/* AUTHOR                : Jagwinder Kaur                               */  
/* DATE WRITTEN          : 10/06/2004                                   */      
/************************************************************************/
      
	      
#include <stdio.h>         
#include <string.h>       
#include <math.h> 
#include <bl.h>
#define OERROR (sqlca.sqlcode < 0)
#define LAST_ROW (sqlca.sqlcode == 1403)
#define NOT_FOUND (sqlca.sqlerrd[2] == 0)
#define RESOURCE_BUSY        (sqlca.sqlcode == -54)
#define DUPLICATE_KEY        (sqlca.sqlcode == -1)
#define ROW_COUNT            (sqlca.sqlerrd[2])
#define NODATAFOUND sqlca.sqlcode == 1403
#define ONLINE_PRINTING 1

/*
#define DEBUG 0
*/

#define ESC     0x1B

/* EXEC SQL BEGIN DECLARE SECTION; */ 


/* VARCHAR     date							[20],
            user_id                         [91],
	        nd_pwd 							[91],
		    nd_pwd1 						[132],
            nd_session_id                   [16],
            nd_pgm_date                     [25],
            d_curr_pgm_name                 [15],
			nd_report	         		    [20],
			nd_facility				        [3],
			nd_reminder_format_id			[21],
			bl_reminder_format_id			[21],
			bl_report_title_text			[101],
			bl_header_line_01				[101],
			bl_header_line_02				[101],
			bl_header_line_03				[101],
			bl_header_line_04				[101],
			bl_header_line_05				[101],
			bl_header_line_06				[101],
			bl_header_line_07				[101],
			bl_header_line_08				[101],
			bl_header_line_09				[101],
			bl_header_line_10				[101],
			bl_body_line_01					[101],
			bl_body_line_02					[101],
			bl_body_line_03					[101],
			bl_body_line_04					[101],
			bl_body_line_05					[101],
			bl_body_line_06					[101],
			bl_body_line_07					[101],
			bl_body_line_08					[101],
			bl_body_line_09					[101],
			bl_body_line_10					[101],
			bl_body_line_11					[101],
			bl_body_line_12					[101],
			bl_body_line_13					[101],
			bl_body_line_14					[101],
			bl_body_line_15					[101],
			bl_body_line_16					[101],
			bl_body_line_17					[101],
			bl_body_line_18					[101],
			bl_body_line_19					[101],
			bl_body_line_20					[101],
			bl_footer_line_01				[101],
			bl_footer_line_02				[101],
			bl_footer_line_03				[101],
			bl_footer_line_04				[101],
			bl_footer_line_05				[101],
			bl_footer_line_06				[101],
			bl_footer_line_07				[101],
			bl_footer_line_08				[101],
			bl_footer_line_09				[101],
			bl_footer_line_10				[101],
			nd_doc_type_code				[7],
			nd_doc_num						[9],
			nd_patient_id					[21],
			nd_cust_code					[9],
			nd_reminder_no					[4],
			column_var						[101],
			nd_column_val					[1000],
			str_var							[101],
			str_var2						[101],
			line_var						[101],
			dup_var							[101],
			lc_str_val						[101],
			lc_str_var						[101],
			tab_name						[31],
			ls_str_var						[101],
			lc_var							[3],
			ls_char_var						[3],
			ls_str							[101],
			ls_var							[101],
			nd_REGION_CODE					[100],
			nd_RES_AREA_CODE				[100],
			nd_RES_TOWN_CODE				[100],
			nd_RES_COUNTRY_CODE				[100],
			nd_PAT_REGION_CODE				[100],
			nd_PAT_RES_AREA_CODE			[100],
			nd_PAT_RES_TOWN_CODE			[100],
			nd_PAT_COUNTRY_CODE				[100],
			lc_splch_var					[101]; */ 
struct { unsigned short len; unsigned char arr[20]; } date;

struct { unsigned short len; unsigned char arr[91]; } user_id;

struct { unsigned short len; unsigned char arr[91]; } nd_pwd;

struct { unsigned short len; unsigned char arr[132]; } nd_pwd1;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[20]; } nd_report;

struct { unsigned short len; unsigned char arr[3]; } nd_facility;

struct { unsigned short len; unsigned char arr[21]; } nd_reminder_format_id;

struct { unsigned short len; unsigned char arr[21]; } bl_reminder_format_id;

struct { unsigned short len; unsigned char arr[101]; } bl_report_title_text;

struct { unsigned short len; unsigned char arr[101]; } bl_header_line_01;

struct { unsigned short len; unsigned char arr[101]; } bl_header_line_02;

struct { unsigned short len; unsigned char arr[101]; } bl_header_line_03;

struct { unsigned short len; unsigned char arr[101]; } bl_header_line_04;

struct { unsigned short len; unsigned char arr[101]; } bl_header_line_05;

struct { unsigned short len; unsigned char arr[101]; } bl_header_line_06;

struct { unsigned short len; unsigned char arr[101]; } bl_header_line_07;

struct { unsigned short len; unsigned char arr[101]; } bl_header_line_08;

struct { unsigned short len; unsigned char arr[101]; } bl_header_line_09;

struct { unsigned short len; unsigned char arr[101]; } bl_header_line_10;

struct { unsigned short len; unsigned char arr[101]; } bl_body_line_01;

struct { unsigned short len; unsigned char arr[101]; } bl_body_line_02;

struct { unsigned short len; unsigned char arr[101]; } bl_body_line_03;

struct { unsigned short len; unsigned char arr[101]; } bl_body_line_04;

struct { unsigned short len; unsigned char arr[101]; } bl_body_line_05;

struct { unsigned short len; unsigned char arr[101]; } bl_body_line_06;

struct { unsigned short len; unsigned char arr[101]; } bl_body_line_07;

struct { unsigned short len; unsigned char arr[101]; } bl_body_line_08;

struct { unsigned short len; unsigned char arr[101]; } bl_body_line_09;

struct { unsigned short len; unsigned char arr[101]; } bl_body_line_10;

struct { unsigned short len; unsigned char arr[101]; } bl_body_line_11;

struct { unsigned short len; unsigned char arr[101]; } bl_body_line_12;

struct { unsigned short len; unsigned char arr[101]; } bl_body_line_13;

struct { unsigned short len; unsigned char arr[101]; } bl_body_line_14;

struct { unsigned short len; unsigned char arr[101]; } bl_body_line_15;

struct { unsigned short len; unsigned char arr[101]; } bl_body_line_16;

struct { unsigned short len; unsigned char arr[101]; } bl_body_line_17;

struct { unsigned short len; unsigned char arr[101]; } bl_body_line_18;

struct { unsigned short len; unsigned char arr[101]; } bl_body_line_19;

struct { unsigned short len; unsigned char arr[101]; } bl_body_line_20;

struct { unsigned short len; unsigned char arr[101]; } bl_footer_line_01;

struct { unsigned short len; unsigned char arr[101]; } bl_footer_line_02;

struct { unsigned short len; unsigned char arr[101]; } bl_footer_line_03;

struct { unsigned short len; unsigned char arr[101]; } bl_footer_line_04;

struct { unsigned short len; unsigned char arr[101]; } bl_footer_line_05;

struct { unsigned short len; unsigned char arr[101]; } bl_footer_line_06;

struct { unsigned short len; unsigned char arr[101]; } bl_footer_line_07;

struct { unsigned short len; unsigned char arr[101]; } bl_footer_line_08;

struct { unsigned short len; unsigned char arr[101]; } bl_footer_line_09;

struct { unsigned short len; unsigned char arr[101]; } bl_footer_line_10;

struct { unsigned short len; unsigned char arr[7]; } nd_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } nd_doc_num;

struct { unsigned short len; unsigned char arr[21]; } nd_patient_id;

struct { unsigned short len; unsigned char arr[9]; } nd_cust_code;

struct { unsigned short len; unsigned char arr[4]; } nd_reminder_no;

struct { unsigned short len; unsigned char arr[101]; } column_var;

struct { unsigned short len; unsigned char arr[1000]; } nd_column_val;

struct { unsigned short len; unsigned char arr[101]; } str_var;

struct { unsigned short len; unsigned char arr[101]; } str_var2;

struct { unsigned short len; unsigned char arr[101]; } line_var;

struct { unsigned short len; unsigned char arr[101]; } dup_var;

struct { unsigned short len; unsigned char arr[101]; } lc_str_val;

struct { unsigned short len; unsigned char arr[101]; } lc_str_var;

struct { unsigned short len; unsigned char arr[31]; } tab_name;

struct { unsigned short len; unsigned char arr[101]; } ls_str_var;

struct { unsigned short len; unsigned char arr[3]; } lc_var;

struct { unsigned short len; unsigned char arr[3]; } ls_char_var;

struct { unsigned short len; unsigned char arr[101]; } ls_str;

struct { unsigned short len; unsigned char arr[101]; } ls_var;

struct { unsigned short len; unsigned char arr[100]; } nd_REGION_CODE;

struct { unsigned short len; unsigned char arr[100]; } nd_RES_AREA_CODE;

struct { unsigned short len; unsigned char arr[100]; } nd_RES_TOWN_CODE;

struct { unsigned short len; unsigned char arr[100]; } nd_RES_COUNTRY_CODE;

struct { unsigned short len; unsigned char arr[100]; } nd_PAT_REGION_CODE;

struct { unsigned short len; unsigned char arr[100]; } nd_PAT_RES_AREA_CODE;

struct { unsigned short len; unsigned char arr[100]; } nd_PAT_RES_TOWN_CODE;

struct { unsigned short len; unsigned char arr[100]; } nd_PAT_COUNTRY_CODE;

struct { unsigned short len; unsigned char arr[101]; } lc_splch_var;

		 
    char	sql_stmt             [5000]; 			
    /* varchar sql_stmt1            [1000],
			sql_stmt2            [1000]; */ 
struct { unsigned short len; unsigned char arr[1000]; } sql_stmt1;

struct { unsigned short len; unsigned char arr[1000]; } sql_stmt2;

	
	char    string_arr	[1000], 
		    new_str		[1001];	
    char    st_var[50]; 

   /*char    sql_stmt                      [5000], 			
           sql_stmt1                     [100],
           sql_stmt2                     [1000],
		   string_arr					 [1000], 
		   new_str						[1001];	*/

int date_yn = 0,line_ctr = 0;
int splch_pos,st_pos,spchar_type,bold_st = 0,font_st = 0;
int spchar_pos = 0,spchar_pos1,ctr;
int i,bl_doc_srl_no,pos_var,pos_var1,pos_var2,print_upto,pos_length,var_length;
int l_pos,lv_var,j,len_lc_str_val,prt_len,print_upto_c,ld_var,char_pos;
int ld_pos,ld_length,len=0;

char nd_order_by,temp[50]="\0";
char filename[150];
char x_msg[200];
char loc_legend[999][201];
char l_mesg[200];
char fm_date[11],to_date[11];
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

int    lctr = 0,pctr = 1,nvalid = 0,ncancel = 0;
int    first = 1;

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
 
    strcpy(g_pgm_id,"BLRRMLR2");
    strcpy(nd_pwd.arr,argv[1]);
    strcpy(nd_pwd1.arr,argv[1]);
    nd_pwd.len = strlen(nd_pwd.arr);
    nd_pwd1.len = strlen(nd_pwd1.arr);

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

	/*
        if (argc == 5)
	{
	    strcpy(nd_report.arr,"BLRRMLR2");
    	    nd_report.len = strlen(nd_report.arr);
	    
	}

	if (argc > 5)
	{
	    strcpy(nd_report.arr,argv[5]);
    	    nd_report.len = strlen(nd_report.arr);
	}
	*/

	strcpy(nd_report.arr,argv[5]);
        nd_report.len = strlen(nd_report.arr);
	

	declare_cur();

    	open_file();
		fprintf(fp,"%c(s13H",ESC); 	/* To set the font 			*/
		open_cur();
		print_body();    
		fflush(fp);
		close_cur();
        end_of_rep();
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



declare_cur()
{  

    /* EXEC SQL DECLARE BL_REM_LET_FORMAT_CUR CURSOR FOR 
		SELECT	REMINDER_FORMAT_ID,
				DOC_TYPE_CODE,
				DOC_NUM,
				REMINDER_NO
				FROM BL_BILLS_FOR_REMINDER
				WHERE (REMINDER_DISP_DOC_TYPE,REMINDER_DISP_DOC_NUMBER,REMINDER_DISP_DOC_SLNO) 
				   IN ( SELECT	DOC_TYPE_CODE,
								DOC_NUMBER,
								DOC_SRL_NO
						FROM BL_REM_LET_PROCESS_TEMP
					    WHERE PROCESS_PGM_ID   = 'BLRRMLR2'
						AND PROCESS_SESSION_ID = :nd_session_id
						AND PROCESS_DATE_TIME  = :nd_pgm_date)
			FOR UPDATE OF REMINDER_PRINTED_YN NOWAIT; */ 



		if (OERROR)
			err_mesg("SELECT failed on table BL_BILLS_FOR_REMINDER",0,"");
  
}


open_cur() 
{
	/* EXEC SQL OPEN BL_REM_LET_FORMAT_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0003;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )51;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_session_id;
 sqlstm.sqhstl[0] = (unsigned int  )18;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_pgm_date;
 sqlstm.sqhstl[1] = (unsigned int  )27;
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
         err_mesg("OPEN failed on cursor BL_REM_LET_FORMAT_CUR",0,"");
}

close_cur() 
{
    /* EXEC SQL DELETE BL_REM_LET_PROCESS_TEMP
					    WHERE PROCESS_PGM_ID   = 'BLRRMLR2'
						AND PROCESS_SESSION_ID = :nd_session_id
						AND PROCESS_DATE_TIME  = :nd_pgm_date; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 4;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "delete  from BL_REM_LET_PROCESS_TEMP  where ((PROCESS_PGM\
_ID='BLRRMLR2' and PROCESS_SESSION_ID=:b0) and PROCESS_DATE_TIME=:b1)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )74;
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
    sqlstm.sqhstl[1] = (unsigned int  )27;
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
        err_mesg("DELETE failed on table BL_REM_LET_PROCESS_TEMP",0,"");

	/* EXEC SQL CLOSE BL_REM_LET_FORMAT_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )97;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    
}
end_of_rep()
{
fclose(fp);

  //    if (strcmp(nd_report.arr,"BLRRMLR2") == 0)
//	   {
		PrintDocument
		(nd_pwd1.arr, //char *PUidPwd;
		 nd_session_id.arr, //char *PSessionID;
		 nd_facility.arr, //char *PFacilityID;
		 "BL", //char *PModuleID;
		 nd_report.arr, //char *PDocumentID;
		 filename, //char *POnlinePrintFileNames;
		 "O", //char *PLocationTypes;
		 " ", //char *PLocationCodes;
		 1, //int PNumOfCopies;
		 1, //int PPageFrom;
		 9999 //int PPageTo;
		  );
  //      }
}
fetch_cur()
{
	nd_reminder_format_id.arr[0]	= '\0';
	nd_doc_type_code.arr[0]			= '\0';
	nd_doc_num.arr[0]				= '\0';
	nd_reminder_no.arr[0]			= '\0';
	
	nd_reminder_format_id.len	= 0;
	nd_doc_type_code.len		= 0;
	nd_doc_num.len				= 0;
	nd_reminder_no.len			= 0;
	
     /* EXEC SQL FETCH BL_REM_LET_FORMAT_CUR 
				 INTO	:nd_reminder_format_id,
						:nd_doc_type_code,
						:nd_doc_num,
						:nd_reminder_no; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 4;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )112;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqfoff = (           int )0;
     sqlstm.sqfmod = (unsigned int )2;
     sqlstm.sqhstv[0] = (         void  *)&nd_reminder_format_id;
     sqlstm.sqhstl[0] = (unsigned int  )23;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&nd_doc_type_code;
     sqlstm.sqhstl[1] = (unsigned int  )9;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&nd_doc_num;
     sqlstm.sqhstl[2] = (unsigned int  )11;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&nd_reminder_no;
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


	
	 if (OERROR)
         err_mesg("FETCH failed on cursor BL_REM_LET_FORMAT_CUR",0,"");

	    	nd_reminder_format_id.arr[nd_reminder_format_id.len]= '\0';
			nd_doc_type_code.arr[nd_doc_type_code.len]			= '\0';
			nd_doc_num.arr[nd_doc_num.len]						= '\0';
			nd_reminder_no.arr[nd_reminder_no.len]				= '\0';
    return(LAST_ROW?0:1);
}

fetch_dtl()
{
bl_reminder_format_id.arr[0]	= '\0';
bl_report_title_text.arr[0]		= '\0';
bl_header_line_01.arr[0]		= '\0';
bl_header_line_02.arr[0]		= '\0';
bl_header_line_03.arr[0]		= '\0';
bl_header_line_04.arr[0]		= '\0';
bl_header_line_05.arr[0]		= '\0';
bl_header_line_06.arr[0]		= '\0';
bl_header_line_07.arr[0]		= '\0';
bl_header_line_08.arr[0]		= '\0';
bl_header_line_09.arr[0]		= '\0';
bl_header_line_10.arr[0]		= '\0';
bl_body_line_01.arr[0]			= '\0';
bl_body_line_02.arr[0]			= '\0';
bl_body_line_03.arr[0]			= '\0';
bl_body_line_04.arr[0]			= '\0';
bl_body_line_05.arr[0]			= '\0';
bl_body_line_06.arr[0]			= '\0';
bl_body_line_07.arr[0]			= '\0';
bl_body_line_08.arr[0]			= '\0';
bl_body_line_09.arr[0]			= '\0';
bl_body_line_10.arr[0]			= '\0';
bl_body_line_11.arr[0]			= '\0';
bl_body_line_12.arr[0]			= '\0';
bl_body_line_13.arr[0]			= '\0';
bl_body_line_14.arr[0]			= '\0';
bl_body_line_15.arr[0]			= '\0';
bl_body_line_16.arr[0]			= '\0';
bl_body_line_17.arr[0]			= '\0';
bl_body_line_18.arr[0]			= '\0';
bl_body_line_19.arr[0]			= '\0';
bl_body_line_20.arr[0]			= '\0';
bl_footer_line_01.arr[0]		= '\0';
bl_footer_line_02.arr[0]		= '\0';
bl_footer_line_03.arr[0]		= '\0';
bl_footer_line_04.arr[0]		= '\0';
bl_footer_line_05.arr[0]		= '\0';
bl_footer_line_06.arr[0]		= '\0';
bl_footer_line_07.arr[0]		= '\0';
bl_footer_line_08.arr[0]		= '\0';
bl_footer_line_09.arr[0]		= '\0';
bl_footer_line_10.arr[0]		= '\0';
str_var.arr[0]                  = '\0';				
nd_patient_id.arr[0]			= '\0';
nd_cust_code.arr[0]				= '\0';

bl_report_title_text.len= 0;
bl_header_line_01.len	= 0;
bl_header_line_02.len	= 0;
bl_header_line_03.len	= 0;
bl_header_line_04.len	= 0;
bl_header_line_05.len	= 0;
bl_header_line_06.len	= 0;
bl_header_line_07.len	= 0;
bl_header_line_08.len	= 0;
bl_header_line_09.len	= 0;
bl_header_line_10.len	= 0;
bl_body_line_01.len		= 0;
bl_body_line_02.len		= 0;
bl_body_line_03.len		= 0;
bl_body_line_04.len		= 0;
bl_body_line_05.len		= 0;
bl_body_line_06.len		= 0;
bl_body_line_07.len		= 0;
bl_body_line_08.len		= 0;
bl_body_line_09.len		= 0;
bl_body_line_10.len		= 0;
bl_body_line_11.len		= 0;
bl_body_line_12.len		= 0;
bl_body_line_13.len		= 0;
bl_body_line_14.len		= 0;
bl_body_line_15.len		= 0;
bl_body_line_16.len		= 0;
bl_body_line_17.len		= 0;
bl_body_line_18.len		= 0;
bl_body_line_19.len		= 0;
bl_body_line_20.len		= 0;
bl_footer_line_01.len	= 0;
bl_footer_line_02.len	= 0;
bl_footer_line_03.len	= 0;
bl_footer_line_04.len	= 0;
bl_footer_line_05.len	= 0;
bl_footer_line_06.len	= 0;
bl_footer_line_07.len	= 0;
bl_footer_line_08.len	= 0;
bl_footer_line_09.len	= 0;
bl_footer_line_10.len	= 0;
str_var.len				= 0;
nd_patient_id.len		= 0;
nd_cust_code.len		= 0; 

     
		/* EXEC SQL SELECT	A.PATIENT_ID,
						A.CUST_CODE
				INTO :nd_patient_id,
					 :nd_cust_code                     
			FROM BL_BILL_HDR A
            WHERE A.DOC_TYPE_CODE = :nd_doc_type_code
            AND A.DOC_NUM = :nd_doc_num; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select A.PATIENT_ID ,A.CUST_CODE into :b0,:b1  from BL_BILL\
_HDR A where (A.DOC_TYPE_CODE=:b2 and A.DOC_NUM=:b3)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )143;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_patient_id;
  sqlstm.sqhstl[0] = (unsigned int  )23;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_cust_code;
  sqlstm.sqhstl[1] = (unsigned int  )11;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_doc_type_code;
  sqlstm.sqhstl[2] = (unsigned int  )9;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_doc_num;
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
			err_mesg("SELECT failed on table BL_BILL_HDR 1 ",0,"");

        /* EXEC SQL SELECT REGION_CODE,RES_AREA_CODE, RES_TOWN_CODE 
		         into :nd_REGION_CODE,
				 	  :nd_RES_AREA_CODE,
					  :nd_RES_TOWN_CODE  
                 FROM SM_FACILITY_PARAM
				 WHERE FACILITY_ID = :nd_facility; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 12;
        sqlstm.arrsiz = 4;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "select REGION_CODE ,RES_AREA_CODE ,RES_TOWN_CODE into\
 :b0,:b1,:b2  from SM_FACILITY_PARAM where FACILITY_ID=:b3";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )174;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)4352;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&nd_REGION_CODE;
        sqlstm.sqhstl[0] = (unsigned int  )102;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&nd_RES_AREA_CODE;
        sqlstm.sqhstl[1] = (unsigned int  )102;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&nd_RES_TOWN_CODE;
        sqlstm.sqhstl[2] = (unsigned int  )102;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&nd_facility;
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



		if (OERROR)
			err_mesg("SELECT failed on table SM_FACILITY_PARAM FOR REGION",0,"");

        /* EXEC SQL SELECT REGION_CODE,RES_AREA_CODE, RES_TOWN_CODE,NATIONALITY_CODE
		         into :nd_PAT_REGION_CODE,
				 	  :nd_PAT_RES_AREA_CODE,
					  :nd_PAT_RES_TOWN_CODE,
					  :nd_PAT_COUNTRY_CODE 
                 FROM MP_PATIENT
				 WHERE PATIENT_ID = :nd_patient_id; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 12;
        sqlstm.arrsiz = 5;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "select REGION_CODE ,RES_AREA_CODE ,RES_TOWN_CODE ,NAT\
IONALITY_CODE into :b0,:b1,:b2,:b3  from MP_PATIENT where PATIENT_ID=:b4";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )205;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)4352;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&nd_PAT_REGION_CODE;
        sqlstm.sqhstl[0] = (unsigned int  )102;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&nd_PAT_RES_AREA_CODE;
        sqlstm.sqhstl[1] = (unsigned int  )102;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&nd_PAT_RES_TOWN_CODE;
        sqlstm.sqhstl[2] = (unsigned int  )102;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&nd_PAT_COUNTRY_CODE;
        sqlstm.sqhstl[3] = (unsigned int  )102;
        sqlstm.sqhsts[3] = (         int  )0;
        sqlstm.sqindv[3] = (         void  *)0;
        sqlstm.sqinds[3] = (         int  )0;
        sqlstm.sqharm[3] = (unsigned int  )0;
        sqlstm.sqadto[3] = (unsigned short )0;
        sqlstm.sqtdso[3] = (unsigned short )0;
        sqlstm.sqhstv[4] = (         void  *)&nd_patient_id;
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
			err_mesg("SELECT failed on table MP_PATIENT FOR REGION",0,"");


      /* EXEC SQL SELECT	REMINDER_FORMAT_ID,
				REPORT_TITLE_TEXT,
				HEADER_LINE_01,
				HEADER_LINE_02,
				HEADER_LINE_03,
				HEADER_LINE_04,
				HEADER_LINE_05,
				HEADER_LINE_06,
				HEADER_LINE_07,
				HEADER_LINE_08,
				HEADER_LINE_09,
				HEADER_LINE_10,
				BODY_LINE_01,
				BODY_LINE_02,
				BODY_LINE_03,
				BODY_LINE_04,
				BODY_LINE_05,
				BODY_LINE_06,
				BODY_LINE_07,
				BODY_LINE_08,
				BODY_LINE_09,
				BODY_LINE_10,
				BODY_LINE_11,
				BODY_LINE_12,
				BODY_LINE_13,
				BODY_LINE_14,
				BODY_LINE_15,
				BODY_LINE_16,
				BODY_LINE_17,
				BODY_LINE_18,
				BODY_LINE_19,
				BODY_LINE_20,
				FOOTER_LINE_01,
				FOOTER_LINE_02,
				FOOTER_LINE_03,
				FOOTER_LINE_04,
				FOOTER_LINE_05,
				FOOTER_LINE_06,
				FOOTER_LINE_07,
				FOOTER_LINE_08,
				FOOTER_LINE_09,
				FOOTER_LINE_10
			INTO :bl_reminder_format_id,
					:bl_report_title_text,
					:bl_header_line_01,
					:bl_header_line_02,
					:bl_header_line_03,
					:bl_header_line_04,
					:bl_header_line_05,
					:bl_header_line_06,
					:bl_header_line_07,
					:bl_header_line_08,
					:bl_header_line_09,
					:bl_header_line_10,
					:bl_body_line_01,
					:bl_body_line_02,
					:bl_body_line_03,
					:bl_body_line_04,
					:bl_body_line_05,
					:bl_body_line_06,
					:bl_body_line_07,
					:bl_body_line_08,
					:bl_body_line_09,
					:bl_body_line_10,
					:bl_body_line_11,
					:bl_body_line_12,
					:bl_body_line_13,
					:bl_body_line_14,
					:bl_body_line_15,
					:bl_body_line_16,
					:bl_body_line_17,
					:bl_body_line_18,
					:bl_body_line_19,
					:bl_body_line_20,
					:bl_footer_line_01,
					:bl_footer_line_02,
					:bl_footer_line_03,
					:bl_footer_line_04,
					:bl_footer_line_05,
					:bl_footer_line_06,
					:bl_footer_line_07,
					:bl_footer_line_08,
					:bl_footer_line_09,
					:bl_footer_line_10
		FROM BL_REM_LET_FORMAT
		WHERE REMINDER_FORMAT_ID = :nd_reminder_format_id
		AND APPL_TRX_IND = 'B'
		AND STATUS IS NULL; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 12;
      sqlstm.arrsiz = 43;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "select REMINDER_FORMAT_ID ,REPORT_TITLE_TEXT ,HEADER_LI\
NE_01 ,HEADER_LINE_02 ,HEADER_LINE_03 ,HEADER_LINE_04 ,HEADER_LINE_05 ,HEADER_\
LINE_06 ,HEADER_LINE_07 ,HEADER_LINE_08 ,HEADER_LINE_09 ,HEADER_LINE_10 ,BODY_\
LINE_01 ,BODY_LINE_02 ,BODY_LINE_03 ,BODY_LINE_04 ,BODY_LINE_05 ,BODY_LINE_06 \
,BODY_LINE_07 ,BODY_LINE_08 ,BODY_LINE_09 ,BODY_LINE_10 ,BODY_LINE_11 ,BODY_LI\
NE_12 ,BODY_LINE_13 ,BODY_LINE_14 ,BODY_LINE_15 ,BODY_LINE_16 ,BODY_LINE_17 ,B\
ODY_LINE_18 ,BODY_LINE_19 ,BODY_LINE_20 ,FOOTER_LINE_01 ,FOOTER_LINE_02 ,FOOTE\
R_LINE_03 ,FOOTER_LINE_04 ,FOOTER_LINE_05 ,FOOTER_LINE_06 ,FOOTER_LINE_07 ,FOO\
TER_LINE_08 ,FOOTER_LINE_09 ,FOOTER_LINE_10 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:\
b7,:b8,:b9,:b10,:b11,:b12,:b13,:b14,:b15,:b16,:b17,:b18,:b19,:b20,:b21,:b22,:b\
23,:b24,:b25,:b26,:b27,:b28,:b29,:b30,:b31,:b32,:b33,:b34,:b35,:b36,:b37,:b38,\
:b39,:b40,:b41  from BL_REM_LET_FORMAT where ((REMINDER_FORMAT_ID=:b42 and APP\
L_TRX_IND='B') and STATUS is null )";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )240;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)4352;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&bl_reminder_format_id;
      sqlstm.sqhstl[0] = (unsigned int  )23;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&bl_report_title_text;
      sqlstm.sqhstl[1] = (unsigned int  )103;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&bl_header_line_01;
      sqlstm.sqhstl[2] = (unsigned int  )103;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&bl_header_line_02;
      sqlstm.sqhstl[3] = (unsigned int  )103;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&bl_header_line_03;
      sqlstm.sqhstl[4] = (unsigned int  )103;
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&bl_header_line_04;
      sqlstm.sqhstl[5] = (unsigned int  )103;
      sqlstm.sqhsts[5] = (         int  )0;
      sqlstm.sqindv[5] = (         void  *)0;
      sqlstm.sqinds[5] = (         int  )0;
      sqlstm.sqharm[5] = (unsigned int  )0;
      sqlstm.sqadto[5] = (unsigned short )0;
      sqlstm.sqtdso[5] = (unsigned short )0;
      sqlstm.sqhstv[6] = (         void  *)&bl_header_line_05;
      sqlstm.sqhstl[6] = (unsigned int  )103;
      sqlstm.sqhsts[6] = (         int  )0;
      sqlstm.sqindv[6] = (         void  *)0;
      sqlstm.sqinds[6] = (         int  )0;
      sqlstm.sqharm[6] = (unsigned int  )0;
      sqlstm.sqadto[6] = (unsigned short )0;
      sqlstm.sqtdso[6] = (unsigned short )0;
      sqlstm.sqhstv[7] = (         void  *)&bl_header_line_06;
      sqlstm.sqhstl[7] = (unsigned int  )103;
      sqlstm.sqhsts[7] = (         int  )0;
      sqlstm.sqindv[7] = (         void  *)0;
      sqlstm.sqinds[7] = (         int  )0;
      sqlstm.sqharm[7] = (unsigned int  )0;
      sqlstm.sqadto[7] = (unsigned short )0;
      sqlstm.sqtdso[7] = (unsigned short )0;
      sqlstm.sqhstv[8] = (         void  *)&bl_header_line_07;
      sqlstm.sqhstl[8] = (unsigned int  )103;
      sqlstm.sqhsts[8] = (         int  )0;
      sqlstm.sqindv[8] = (         void  *)0;
      sqlstm.sqinds[8] = (         int  )0;
      sqlstm.sqharm[8] = (unsigned int  )0;
      sqlstm.sqadto[8] = (unsigned short )0;
      sqlstm.sqtdso[8] = (unsigned short )0;
      sqlstm.sqhstv[9] = (         void  *)&bl_header_line_08;
      sqlstm.sqhstl[9] = (unsigned int  )103;
      sqlstm.sqhsts[9] = (         int  )0;
      sqlstm.sqindv[9] = (         void  *)0;
      sqlstm.sqinds[9] = (         int  )0;
      sqlstm.sqharm[9] = (unsigned int  )0;
      sqlstm.sqadto[9] = (unsigned short )0;
      sqlstm.sqtdso[9] = (unsigned short )0;
      sqlstm.sqhstv[10] = (         void  *)&bl_header_line_09;
      sqlstm.sqhstl[10] = (unsigned int  )103;
      sqlstm.sqhsts[10] = (         int  )0;
      sqlstm.sqindv[10] = (         void  *)0;
      sqlstm.sqinds[10] = (         int  )0;
      sqlstm.sqharm[10] = (unsigned int  )0;
      sqlstm.sqadto[10] = (unsigned short )0;
      sqlstm.sqtdso[10] = (unsigned short )0;
      sqlstm.sqhstv[11] = (         void  *)&bl_header_line_10;
      sqlstm.sqhstl[11] = (unsigned int  )103;
      sqlstm.sqhsts[11] = (         int  )0;
      sqlstm.sqindv[11] = (         void  *)0;
      sqlstm.sqinds[11] = (         int  )0;
      sqlstm.sqharm[11] = (unsigned int  )0;
      sqlstm.sqadto[11] = (unsigned short )0;
      sqlstm.sqtdso[11] = (unsigned short )0;
      sqlstm.sqhstv[12] = (         void  *)&bl_body_line_01;
      sqlstm.sqhstl[12] = (unsigned int  )103;
      sqlstm.sqhsts[12] = (         int  )0;
      sqlstm.sqindv[12] = (         void  *)0;
      sqlstm.sqinds[12] = (         int  )0;
      sqlstm.sqharm[12] = (unsigned int  )0;
      sqlstm.sqadto[12] = (unsigned short )0;
      sqlstm.sqtdso[12] = (unsigned short )0;
      sqlstm.sqhstv[13] = (         void  *)&bl_body_line_02;
      sqlstm.sqhstl[13] = (unsigned int  )103;
      sqlstm.sqhsts[13] = (         int  )0;
      sqlstm.sqindv[13] = (         void  *)0;
      sqlstm.sqinds[13] = (         int  )0;
      sqlstm.sqharm[13] = (unsigned int  )0;
      sqlstm.sqadto[13] = (unsigned short )0;
      sqlstm.sqtdso[13] = (unsigned short )0;
      sqlstm.sqhstv[14] = (         void  *)&bl_body_line_03;
      sqlstm.sqhstl[14] = (unsigned int  )103;
      sqlstm.sqhsts[14] = (         int  )0;
      sqlstm.sqindv[14] = (         void  *)0;
      sqlstm.sqinds[14] = (         int  )0;
      sqlstm.sqharm[14] = (unsigned int  )0;
      sqlstm.sqadto[14] = (unsigned short )0;
      sqlstm.sqtdso[14] = (unsigned short )0;
      sqlstm.sqhstv[15] = (         void  *)&bl_body_line_04;
      sqlstm.sqhstl[15] = (unsigned int  )103;
      sqlstm.sqhsts[15] = (         int  )0;
      sqlstm.sqindv[15] = (         void  *)0;
      sqlstm.sqinds[15] = (         int  )0;
      sqlstm.sqharm[15] = (unsigned int  )0;
      sqlstm.sqadto[15] = (unsigned short )0;
      sqlstm.sqtdso[15] = (unsigned short )0;
      sqlstm.sqhstv[16] = (         void  *)&bl_body_line_05;
      sqlstm.sqhstl[16] = (unsigned int  )103;
      sqlstm.sqhsts[16] = (         int  )0;
      sqlstm.sqindv[16] = (         void  *)0;
      sqlstm.sqinds[16] = (         int  )0;
      sqlstm.sqharm[16] = (unsigned int  )0;
      sqlstm.sqadto[16] = (unsigned short )0;
      sqlstm.sqtdso[16] = (unsigned short )0;
      sqlstm.sqhstv[17] = (         void  *)&bl_body_line_06;
      sqlstm.sqhstl[17] = (unsigned int  )103;
      sqlstm.sqhsts[17] = (         int  )0;
      sqlstm.sqindv[17] = (         void  *)0;
      sqlstm.sqinds[17] = (         int  )0;
      sqlstm.sqharm[17] = (unsigned int  )0;
      sqlstm.sqadto[17] = (unsigned short )0;
      sqlstm.sqtdso[17] = (unsigned short )0;
      sqlstm.sqhstv[18] = (         void  *)&bl_body_line_07;
      sqlstm.sqhstl[18] = (unsigned int  )103;
      sqlstm.sqhsts[18] = (         int  )0;
      sqlstm.sqindv[18] = (         void  *)0;
      sqlstm.sqinds[18] = (         int  )0;
      sqlstm.sqharm[18] = (unsigned int  )0;
      sqlstm.sqadto[18] = (unsigned short )0;
      sqlstm.sqtdso[18] = (unsigned short )0;
      sqlstm.sqhstv[19] = (         void  *)&bl_body_line_08;
      sqlstm.sqhstl[19] = (unsigned int  )103;
      sqlstm.sqhsts[19] = (         int  )0;
      sqlstm.sqindv[19] = (         void  *)0;
      sqlstm.sqinds[19] = (         int  )0;
      sqlstm.sqharm[19] = (unsigned int  )0;
      sqlstm.sqadto[19] = (unsigned short )0;
      sqlstm.sqtdso[19] = (unsigned short )0;
      sqlstm.sqhstv[20] = (         void  *)&bl_body_line_09;
      sqlstm.sqhstl[20] = (unsigned int  )103;
      sqlstm.sqhsts[20] = (         int  )0;
      sqlstm.sqindv[20] = (         void  *)0;
      sqlstm.sqinds[20] = (         int  )0;
      sqlstm.sqharm[20] = (unsigned int  )0;
      sqlstm.sqadto[20] = (unsigned short )0;
      sqlstm.sqtdso[20] = (unsigned short )0;
      sqlstm.sqhstv[21] = (         void  *)&bl_body_line_10;
      sqlstm.sqhstl[21] = (unsigned int  )103;
      sqlstm.sqhsts[21] = (         int  )0;
      sqlstm.sqindv[21] = (         void  *)0;
      sqlstm.sqinds[21] = (         int  )0;
      sqlstm.sqharm[21] = (unsigned int  )0;
      sqlstm.sqadto[21] = (unsigned short )0;
      sqlstm.sqtdso[21] = (unsigned short )0;
      sqlstm.sqhstv[22] = (         void  *)&bl_body_line_11;
      sqlstm.sqhstl[22] = (unsigned int  )103;
      sqlstm.sqhsts[22] = (         int  )0;
      sqlstm.sqindv[22] = (         void  *)0;
      sqlstm.sqinds[22] = (         int  )0;
      sqlstm.sqharm[22] = (unsigned int  )0;
      sqlstm.sqadto[22] = (unsigned short )0;
      sqlstm.sqtdso[22] = (unsigned short )0;
      sqlstm.sqhstv[23] = (         void  *)&bl_body_line_12;
      sqlstm.sqhstl[23] = (unsigned int  )103;
      sqlstm.sqhsts[23] = (         int  )0;
      sqlstm.sqindv[23] = (         void  *)0;
      sqlstm.sqinds[23] = (         int  )0;
      sqlstm.sqharm[23] = (unsigned int  )0;
      sqlstm.sqadto[23] = (unsigned short )0;
      sqlstm.sqtdso[23] = (unsigned short )0;
      sqlstm.sqhstv[24] = (         void  *)&bl_body_line_13;
      sqlstm.sqhstl[24] = (unsigned int  )103;
      sqlstm.sqhsts[24] = (         int  )0;
      sqlstm.sqindv[24] = (         void  *)0;
      sqlstm.sqinds[24] = (         int  )0;
      sqlstm.sqharm[24] = (unsigned int  )0;
      sqlstm.sqadto[24] = (unsigned short )0;
      sqlstm.sqtdso[24] = (unsigned short )0;
      sqlstm.sqhstv[25] = (         void  *)&bl_body_line_14;
      sqlstm.sqhstl[25] = (unsigned int  )103;
      sqlstm.sqhsts[25] = (         int  )0;
      sqlstm.sqindv[25] = (         void  *)0;
      sqlstm.sqinds[25] = (         int  )0;
      sqlstm.sqharm[25] = (unsigned int  )0;
      sqlstm.sqadto[25] = (unsigned short )0;
      sqlstm.sqtdso[25] = (unsigned short )0;
      sqlstm.sqhstv[26] = (         void  *)&bl_body_line_15;
      sqlstm.sqhstl[26] = (unsigned int  )103;
      sqlstm.sqhsts[26] = (         int  )0;
      sqlstm.sqindv[26] = (         void  *)0;
      sqlstm.sqinds[26] = (         int  )0;
      sqlstm.sqharm[26] = (unsigned int  )0;
      sqlstm.sqadto[26] = (unsigned short )0;
      sqlstm.sqtdso[26] = (unsigned short )0;
      sqlstm.sqhstv[27] = (         void  *)&bl_body_line_16;
      sqlstm.sqhstl[27] = (unsigned int  )103;
      sqlstm.sqhsts[27] = (         int  )0;
      sqlstm.sqindv[27] = (         void  *)0;
      sqlstm.sqinds[27] = (         int  )0;
      sqlstm.sqharm[27] = (unsigned int  )0;
      sqlstm.sqadto[27] = (unsigned short )0;
      sqlstm.sqtdso[27] = (unsigned short )0;
      sqlstm.sqhstv[28] = (         void  *)&bl_body_line_17;
      sqlstm.sqhstl[28] = (unsigned int  )103;
      sqlstm.sqhsts[28] = (         int  )0;
      sqlstm.sqindv[28] = (         void  *)0;
      sqlstm.sqinds[28] = (         int  )0;
      sqlstm.sqharm[28] = (unsigned int  )0;
      sqlstm.sqadto[28] = (unsigned short )0;
      sqlstm.sqtdso[28] = (unsigned short )0;
      sqlstm.sqhstv[29] = (         void  *)&bl_body_line_18;
      sqlstm.sqhstl[29] = (unsigned int  )103;
      sqlstm.sqhsts[29] = (         int  )0;
      sqlstm.sqindv[29] = (         void  *)0;
      sqlstm.sqinds[29] = (         int  )0;
      sqlstm.sqharm[29] = (unsigned int  )0;
      sqlstm.sqadto[29] = (unsigned short )0;
      sqlstm.sqtdso[29] = (unsigned short )0;
      sqlstm.sqhstv[30] = (         void  *)&bl_body_line_19;
      sqlstm.sqhstl[30] = (unsigned int  )103;
      sqlstm.sqhsts[30] = (         int  )0;
      sqlstm.sqindv[30] = (         void  *)0;
      sqlstm.sqinds[30] = (         int  )0;
      sqlstm.sqharm[30] = (unsigned int  )0;
      sqlstm.sqadto[30] = (unsigned short )0;
      sqlstm.sqtdso[30] = (unsigned short )0;
      sqlstm.sqhstv[31] = (         void  *)&bl_body_line_20;
      sqlstm.sqhstl[31] = (unsigned int  )103;
      sqlstm.sqhsts[31] = (         int  )0;
      sqlstm.sqindv[31] = (         void  *)0;
      sqlstm.sqinds[31] = (         int  )0;
      sqlstm.sqharm[31] = (unsigned int  )0;
      sqlstm.sqadto[31] = (unsigned short )0;
      sqlstm.sqtdso[31] = (unsigned short )0;
      sqlstm.sqhstv[32] = (         void  *)&bl_footer_line_01;
      sqlstm.sqhstl[32] = (unsigned int  )103;
      sqlstm.sqhsts[32] = (         int  )0;
      sqlstm.sqindv[32] = (         void  *)0;
      sqlstm.sqinds[32] = (         int  )0;
      sqlstm.sqharm[32] = (unsigned int  )0;
      sqlstm.sqadto[32] = (unsigned short )0;
      sqlstm.sqtdso[32] = (unsigned short )0;
      sqlstm.sqhstv[33] = (         void  *)&bl_footer_line_02;
      sqlstm.sqhstl[33] = (unsigned int  )103;
      sqlstm.sqhsts[33] = (         int  )0;
      sqlstm.sqindv[33] = (         void  *)0;
      sqlstm.sqinds[33] = (         int  )0;
      sqlstm.sqharm[33] = (unsigned int  )0;
      sqlstm.sqadto[33] = (unsigned short )0;
      sqlstm.sqtdso[33] = (unsigned short )0;
      sqlstm.sqhstv[34] = (         void  *)&bl_footer_line_03;
      sqlstm.sqhstl[34] = (unsigned int  )103;
      sqlstm.sqhsts[34] = (         int  )0;
      sqlstm.sqindv[34] = (         void  *)0;
      sqlstm.sqinds[34] = (         int  )0;
      sqlstm.sqharm[34] = (unsigned int  )0;
      sqlstm.sqadto[34] = (unsigned short )0;
      sqlstm.sqtdso[34] = (unsigned short )0;
      sqlstm.sqhstv[35] = (         void  *)&bl_footer_line_04;
      sqlstm.sqhstl[35] = (unsigned int  )103;
      sqlstm.sqhsts[35] = (         int  )0;
      sqlstm.sqindv[35] = (         void  *)0;
      sqlstm.sqinds[35] = (         int  )0;
      sqlstm.sqharm[35] = (unsigned int  )0;
      sqlstm.sqadto[35] = (unsigned short )0;
      sqlstm.sqtdso[35] = (unsigned short )0;
      sqlstm.sqhstv[36] = (         void  *)&bl_footer_line_05;
      sqlstm.sqhstl[36] = (unsigned int  )103;
      sqlstm.sqhsts[36] = (         int  )0;
      sqlstm.sqindv[36] = (         void  *)0;
      sqlstm.sqinds[36] = (         int  )0;
      sqlstm.sqharm[36] = (unsigned int  )0;
      sqlstm.sqadto[36] = (unsigned short )0;
      sqlstm.sqtdso[36] = (unsigned short )0;
      sqlstm.sqhstv[37] = (         void  *)&bl_footer_line_06;
      sqlstm.sqhstl[37] = (unsigned int  )103;
      sqlstm.sqhsts[37] = (         int  )0;
      sqlstm.sqindv[37] = (         void  *)0;
      sqlstm.sqinds[37] = (         int  )0;
      sqlstm.sqharm[37] = (unsigned int  )0;
      sqlstm.sqadto[37] = (unsigned short )0;
      sqlstm.sqtdso[37] = (unsigned short )0;
      sqlstm.sqhstv[38] = (         void  *)&bl_footer_line_07;
      sqlstm.sqhstl[38] = (unsigned int  )103;
      sqlstm.sqhsts[38] = (         int  )0;
      sqlstm.sqindv[38] = (         void  *)0;
      sqlstm.sqinds[38] = (         int  )0;
      sqlstm.sqharm[38] = (unsigned int  )0;
      sqlstm.sqadto[38] = (unsigned short )0;
      sqlstm.sqtdso[38] = (unsigned short )0;
      sqlstm.sqhstv[39] = (         void  *)&bl_footer_line_08;
      sqlstm.sqhstl[39] = (unsigned int  )103;
      sqlstm.sqhsts[39] = (         int  )0;
      sqlstm.sqindv[39] = (         void  *)0;
      sqlstm.sqinds[39] = (         int  )0;
      sqlstm.sqharm[39] = (unsigned int  )0;
      sqlstm.sqadto[39] = (unsigned short )0;
      sqlstm.sqtdso[39] = (unsigned short )0;
      sqlstm.sqhstv[40] = (         void  *)&bl_footer_line_09;
      sqlstm.sqhstl[40] = (unsigned int  )103;
      sqlstm.sqhsts[40] = (         int  )0;
      sqlstm.sqindv[40] = (         void  *)0;
      sqlstm.sqinds[40] = (         int  )0;
      sqlstm.sqharm[40] = (unsigned int  )0;
      sqlstm.sqadto[40] = (unsigned short )0;
      sqlstm.sqtdso[40] = (unsigned short )0;
      sqlstm.sqhstv[41] = (         void  *)&bl_footer_line_10;
      sqlstm.sqhstl[41] = (unsigned int  )103;
      sqlstm.sqhsts[41] = (         int  )0;
      sqlstm.sqindv[41] = (         void  *)0;
      sqlstm.sqinds[41] = (         int  )0;
      sqlstm.sqharm[41] = (unsigned int  )0;
      sqlstm.sqadto[41] = (unsigned short )0;
      sqlstm.sqtdso[41] = (unsigned short )0;
      sqlstm.sqhstv[42] = (         void  *)&nd_reminder_format_id;
      sqlstm.sqhstl[42] = (unsigned int  )23;
      sqlstm.sqhsts[42] = (         int  )0;
      sqlstm.sqindv[42] = (         void  *)0;
      sqlstm.sqinds[42] = (         int  )0;
      sqlstm.sqharm[42] = (unsigned int  )0;
      sqlstm.sqadto[42] = (unsigned short )0;
      sqlstm.sqtdso[42] = (unsigned short )0;
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
            err_mesg("SELECT failed on cursor BL_REM_LET_FORMAT",0,"");



		
bl_report_title_text.arr[bl_report_title_text.len]		= '\0';
bl_header_line_01.arr[bl_header_line_01.len]		= '\0';
bl_header_line_02.arr[bl_header_line_02.len]		= '\0';
bl_header_line_03.arr[bl_header_line_03.len]		= '\0';
bl_header_line_04.arr[bl_header_line_04.len]		= '\0';
bl_header_line_05.arr[bl_header_line_05.len]		= '\0';
bl_header_line_06.arr[bl_header_line_06.len]		= '\0';
bl_header_line_07.arr[bl_header_line_07.len]		= '\0';
bl_header_line_08.arr[bl_header_line_08.len]		= '\0';
bl_header_line_09.arr[bl_header_line_09.len]		= '\0';
bl_header_line_10.arr[bl_header_line_10.len]		= '\0';
bl_body_line_01.arr[bl_body_line_01.len]			= '\0';
bl_body_line_02.arr[bl_body_line_02.len]			= '\0';
bl_body_line_03.arr[bl_body_line_03.len]			= '\0';
bl_body_line_04.arr[bl_body_line_04.len]			= '\0';
bl_body_line_05.arr[bl_body_line_05.len]			= '\0';
bl_body_line_06.arr[bl_body_line_06.len]			= '\0';
bl_body_line_07.arr[bl_body_line_07.len]			= '\0';
bl_body_line_08.arr[bl_body_line_08.len]			= '\0';
bl_body_line_09.arr[bl_body_line_09.len]			= '\0';
bl_body_line_10.arr[bl_body_line_10.len]			= '\0';
bl_body_line_11.arr[bl_body_line_11.len]			= '\0';
bl_body_line_12.arr[bl_body_line_12.len]			= '\0';
bl_body_line_13.arr[bl_body_line_13.len]			= '\0';
bl_body_line_14.arr[bl_body_line_14.len]			= '\0';
bl_body_line_15.arr[bl_body_line_15.len]			= '\0';
bl_body_line_16.arr[bl_body_line_16.len]			= '\0';
bl_body_line_17.arr[bl_body_line_17.len]			= '\0';
bl_body_line_18.arr[bl_body_line_18.len]			= '\0';
bl_body_line_19.arr[bl_body_line_19.len]			= '\0';
bl_body_line_20.arr[bl_body_line_20.len]			= '\0';
bl_footer_line_01.arr[bl_footer_line_01.len]		= '\0';
bl_footer_line_02.arr[bl_footer_line_02.len]		= '\0';
bl_footer_line_03.arr[bl_footer_line_03.len]		= '\0';
bl_footer_line_04.arr[bl_footer_line_04.len]		= '\0';
bl_footer_line_05.arr[bl_footer_line_05.len]		= '\0';
bl_footer_line_06.arr[bl_footer_line_06.len]		= '\0';
bl_footer_line_07.arr[bl_footer_line_07.len]		= '\0';
bl_footer_line_08.arr[bl_footer_line_08.len]		= '\0';
bl_footer_line_09.arr[bl_footer_line_09.len]		= '\0';
bl_footer_line_10.arr[bl_footer_line_10.len]		= '\0';
nd_patient_id.arr[nd_patient_id.len]				= '\0';
nd_cust_code.arr[nd_cust_code.len]					= '\0'; 
		
}


print_head()
{
    
    if (bl_header_line_01.arr[0] != '\0')
      {
		print_line(bl_header_line_01.arr);  //PRADEEP
		fprintf(fp,"\n");
		line_ctr++;
       }
	if (bl_header_line_02.arr[0] != '\0')
      {
		
		print_line(bl_header_line_02.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
       }
	if (bl_header_line_03.arr[0] != '\0')
      {
	  
		print_line(bl_header_line_03.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
       }
	if (bl_header_line_04.arr[0] != '\0')
      {
	  
		print_line(bl_header_line_04.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
       }
	if (bl_header_line_05.arr[0] != '\0')
      {
	  
		print_line(bl_header_line_05.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
       }
	if (bl_header_line_06.arr[0] != '\0')
      {
	  
		print_line(bl_header_line_06.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
       }
	if (bl_header_line_07.arr[0] != '\0')
      {
	  
		print_line(bl_header_line_07.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
       }
	if (bl_header_line_08.arr[0] != '\0')
      {
	  
		print_line(bl_header_line_08.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
       }
	if (bl_header_line_09.arr[0] != '\0')
      {
	  
		print_line(bl_header_line_09.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
       }
	if (bl_header_line_10.arr[0] != '\0')
      {
	  
		print_line(bl_header_line_10.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
       }
    
	if (bl_report_title_text.arr[0] != '\0')
      {
	  
        fprintf(fp,"%c(s3B",ESC); 
		
  		print_line(bl_report_title_text.arr);
		
		fprintf(fp,"%c(s-3B",ESC); /* release bold style */
		fprintf(fp,"\n\n");
		
		line_ctr++;
		
		line_ctr++;
	
       }
}

print_body()
{

  while(fetch_cur())
  {
  
    fetch_dtl();
  
    print_head();

   	if (bl_body_line_01.arr[0] != '\0')
      {
		print_line(bl_body_line_01.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
		check_page_end(1,0);
       }
	if (bl_body_line_02.arr[0] != '\0')
      {
		print_line(bl_body_line_02.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
		check_page_end(1,0);
       }
	if (bl_body_line_03.arr[0] != '\0')
      {
		print_line(bl_body_line_03.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
		check_page_end(1,0);
       }
	if (bl_body_line_04.arr[0] != '\0')
      {
		print_line(bl_body_line_04.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
		check_page_end(1,0);
       }
	if (bl_body_line_05.arr[0] != '\0')
      {
		print_line(bl_body_line_05.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
		check_page_end(1,0);
       }
	if (bl_body_line_06.arr[0] != '\0')
      {
		print_line(bl_body_line_06.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
		check_page_end(1,0);
       }
	if (bl_body_line_07.arr[0] != '\0')
      {
		print_line(bl_body_line_07.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
		check_page_end(1,0);
       }
	if (bl_body_line_08.arr[0] != '\0')
      {
		print_line(bl_body_line_08.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
		check_page_end(1,0);
       }
	if (bl_body_line_09.arr[0] != '\0')
      {
		print_line(bl_body_line_09.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
		check_page_end(1,0);
       }
	if (bl_body_line_10.arr[0] != '\0')
      {
		print_line(bl_body_line_10.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
		check_page_end(1,0);
       }
	if (bl_body_line_11.arr[0] != '\0')
      {
		print_line(bl_body_line_11.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
		check_page_end(1,0);
       }
	if (bl_body_line_12.arr[0] != '\0')
      {
		print_line(bl_body_line_12.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
		check_page_end(1,0);
       }
	if (bl_body_line_13.arr[0] != '\0')
      {
		print_line(bl_body_line_13.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
		check_page_end(1,0);
       }
	if (bl_body_line_14.arr[0] != '\0')
      {
		print_line(bl_body_line_14.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
		check_page_end(1,0);
       }
	if (bl_body_line_15.arr[0] != '\0')
      {
		print_line(bl_body_line_15.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
		check_page_end(1,0);
       }
	if (bl_body_line_16.arr[0] != '\0')
      {
		print_line(bl_body_line_16.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
		check_page_end(1,0);
       }
	if (bl_body_line_17.arr[0] != '\0')
      {
		print_line(bl_body_line_17.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
		check_page_end(1,0);
       }
	if (bl_body_line_18.arr[0] != '\0')
      {
		print_line(bl_body_line_18.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
		check_page_end(1,0);
       }
	if (bl_body_line_19.arr[0] != '\0')
      {
		print_line(bl_body_line_19.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
		check_page_end(1,0);
       }
	if (bl_body_line_20.arr[0] != '\0')
      {
		print_line(bl_body_line_20.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
		check_page_end(1,0);
       }
	
	if (bl_footer_line_01.arr[0] != '\0')
      {
		print_line(bl_footer_line_01.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
		check_page_end(1,0);
       }
	if (bl_footer_line_02.arr[0] != '\0')
      {
		print_line(bl_footer_line_02.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
		check_page_end(1,0);
       }
	if (bl_footer_line_03.arr[0] != '\0')
      {
		print_line(bl_footer_line_03.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
		check_page_end(1,0);
       }
	if (bl_footer_line_04.arr[0] != '\0')
      {
		print_line(bl_footer_line_04.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
		check_page_end(1,0);
       }
	if (bl_footer_line_05.arr[0] != '\0')
      {
		print_line(bl_footer_line_05.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
		check_page_end(1,0);
       }
	if (bl_footer_line_06.arr[0] != '\0')
      {
		print_line(bl_footer_line_06.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
		check_page_end(1,0);
       }
	if (bl_footer_line_07.arr[0] != '\0')
      {
		print_line(bl_footer_line_07.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
		check_page_end(1,0);
       }
	if (bl_footer_line_08.arr[0] != '\0')
      {
		print_line(bl_footer_line_08.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
		check_page_end(1,0);
       }
	if (bl_footer_line_09.arr[0] != '\0')
      {
		print_line(bl_footer_line_09.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
		check_page_end(1,0);
       }
	if (bl_footer_line_10.arr[0] != '\0')
      {
		print_line(bl_footer_line_10.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
		check_page_end(1,0);
       }

   fprintf(fp,"\f");
   pctr = 1;
   line_ctr = 2;

	/* EXEC SQL UPDATE BL_BILLS_FOR_REMINDER
			 SET REMINDER_PRINTED_YN = 'Y'
			 WHERE DOC_TYPE_CODE=:nd_doc_type_code
			 AND DOC_NUM=:nd_doc_num; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 43;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "update BL_BILLS_FOR_REMINDER  set REMINDER_PRINTED_YN='Y' wh\
ere (DOC_TYPE_CODE=:b0 and DOC_NUM=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )427;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_doc_type_code;
 sqlstm.sqhstl[0] = (unsigned int  )9;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_doc_num;
 sqlstm.sqhstl[1] = (unsigned int  )11;
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
        err_mesg("update failed on table BL_BILLS_FOR_REMINDER",0,"");

	
  
 }	  /* end of while loop  */
}     /* end of procedure   */


int char_position(ls_var,lc_var,ld_var)
char ls_var[101];
char lc_var[3];
int ld_var;
{
 ls_str_var.arr[0] = '\0';
 ls_str_var.len = 0;

 ls_char_var.arr[0] = '\0';
 ls_char_var.len = 0;

 strcpy(ls_str_var.arr,ls_var);
 strcpy(ls_char_var.arr,lc_var);

 ls_str_var.len = strlen(ls_str_var.arr);
 ls_char_var.len = strlen(ls_char_var.arr);

  
 /* EXEC SQL select instr(:ls_str_var,:ls_char_var,:ld_var)
	         into :char_pos
			 from dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 43;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select instr(:b0,:b1,:b2) into :b3  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )450;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&ls_str_var;
 sqlstm.sqhstl[0] = (unsigned int  )103;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&ls_char_var;
 sqlstm.sqhstl[1] = (unsigned int  )5;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&ld_var;
 sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&char_pos;
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
}


 
 if (OERROR)
        err_mesg("SELECT failed on table DUAL",0,"");

 
 ld_var = 0;
 return(char_pos);
}

char put_string(ls_var,ld_pos,ld_length)
char ls_var[101];
int ld_pos,ld_length;
{
 ls_str_var.arr[0] = '\0';
 ls_str_var.len = 0;

 strcpy(ls_str_var.arr,ls_var);
 ls_str_var.len = strlen(ls_str_var.arr);

// ls_str_var.arr[ls_str_var.len] = '\0';

 /* EXEC SQL select substr(:ls_str_var,:ld_pos,:ld_length)
	         into :ls_str
			 from dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 43;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select substr(:b0,:b1,:b2) into :b3  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )481;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&ls_str_var;
 sqlstm.sqhstl[0] = (unsigned int  )103;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&ld_pos;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&ld_length;
 sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&ls_str;
 sqlstm.sqhstl[3] = (unsigned int  )103;
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



 ls_str.arr[ls_str.len] = '\0';

 if (OERROR)
        err_mesg("SELECT failed on table DUAL",0,"");

 return(ls_str.arr);
 
}


check_splch(str_var1)
char str_var1[101];
{
 prt_len = 0;
 spchar_pos = 0;
 spchar_pos1 = 0;
 lc_str_val.arr[0]	='\0';
 lc_str_val.len		= 0;
 lc_str_var.arr[0]	='\0';
 lc_str_var.len		= 0;
 
 ctr = 1;
 print_upto_c = 0;
 strcpy(lc_str_val.arr,str_var1);
 lc_str_val.len = strlen(lc_str_val.arr);
 len_lc_str_val = strlen(lc_str_val.arr);

 while(ctr <= len_lc_str_val)
 {
 prt_len = 0;
 spchar_pos = 0;
 spchar_pos1 = 0;
 
 
 spchar_pos = chk_esc_pos(lc_str_val.arr,ctr);
 
 spchar_pos1 = chk_nwln_pos(lc_str_val.arr,ctr);
 if (spchar_pos1 > 0  && spchar_pos1 <= spchar_pos)
   {
   spchar_pos = spchar_pos1;
   spchar_type = 1;
   }

 spchar_pos1 = chk_cp_nwln_pos(lc_str_val.arr,ctr);
 if (spchar_pos1 > 0 && spchar_pos1 <= spchar_pos)
   {
   spchar_pos = spchar_pos1;
   spchar_type = 2;
   }

 
 spchar_pos1 = chk_tab_pos(lc_str_val.arr,ctr);
 if (spchar_pos1 > 0 && spchar_pos1 <= spchar_pos)
   {
   spchar_pos = spchar_pos1;
   spchar_type = 3;
   }

 spchar_pos1 = chk_bold_pos(lc_str_val.arr,ctr);
 if (spchar_pos1 > 0 && spchar_pos1 <= spchar_pos)
   {
   spchar_pos = spchar_pos1;
   spchar_type = 4;
   }

 spchar_pos1 = chk_font_pos(lc_str_val.arr,ctr);
 if (spchar_pos1 > 0 && spchar_pos1 <= spchar_pos)
   {
   spchar_pos = spchar_pos1;
   spchar_type = 5;
   }

 if (spchar_pos == 0)   
 {
 lc_str_var.arr[0]	='\0';
 lc_str_var.len		= 0;
 prt_len = len_lc_str_val - print_upto_c ;

 put_string(lc_str_val.arr,print_upto_c + 1,prt_len);
 strcpy(lc_str_var.arr,ls_str.arr);

 lc_str_var.len=strlen(lc_str_var.arr);

 fprintf(fp,"%s",lc_str_var.arr);

 ctr = len_lc_str_val+1;
 print_upto_c = len_lc_str_val;
 }
 else
 {
 lc_str_var.arr[0]	='\0';
 lc_str_var.len		= 0;

 prt_len = spchar_pos - print_upto_c -1;
 
 put_string(lc_str_val.arr,print_upto_c+1,prt_len);
 strcpy(lc_str_var.arr,ls_str.arr);
 lc_str_var.len = strlen(lc_str_var.arr);

  fprintf(fp,"%s",lc_str_var.arr);
  
  if (spchar_type == 1)
  {
  fprintf(fp,"\n");
  line_ctr++;
  }

  if (spchar_type == 2)
  {
  fprintf(fp,"\n");
  line_ctr++;
  }

  if (spchar_type == 3)
  fprintf(fp,"        ");

  if (spchar_type == 4)
  {
	if (bold_st)
	{
	fprintf(fp,"%c(s-3B",ESC); /* release bold style */
	bold_st = 0;
	}
    else
	{
	fprintf(fp,"%c(s3B",ESC); 	/* To set Bold style 			*/
	bold_st = 1;
	}
  }

  if (spchar_type == 5)
  {
	if (font_st)
	{
	fprintf(fp,"%c(s13H",ESC); 	/* To set the font 			*/
	font_st = 0;
	}
    else
	{
	fprintf(fp,"%c(s10H",ESC); 	/* To set the font 			*/
	font_st = 1;
	}
  }


  ctr = spchar_pos+2;
  print_upto_c = spchar_pos+1;
  }  
 }
}

int chk_tab_pos(str_var2,st_pos)
char str_var2[101];
{
lc_splch_var.arr[0] = '\0';
lc_splch_var.len = 0;
splch_pos = 0;

 strcpy(lc_splch_var.arr,str_var2);
 lc_splch_var.len = strlen(lc_splch_var.arr);
 
 /* EXEC SQL select instr(:lc_splch_var,'\t',:st_pos)
   into :splch_pos
   from dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 43;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select instr(:b0,'\\t',:b1) into :b2  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )512;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&lc_splch_var;
 sqlstm.sqhstl[0] = (unsigned int  )103;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&st_pos;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&splch_pos;
 sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
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
        err_mesg("SELECT chk_tab_pos failed on table DUAL",0,"");
		 
 return(splch_pos);
}

int chk_nwln_pos(str_var2,st_pos)
char str_var2[101];
{
lc_splch_var.arr[0] = '\0';
lc_splch_var.len = 0;

splch_pos = 0;

 strcpy(lc_splch_var.arr,str_var2);
 lc_splch_var.len = strlen(lc_splch_var.arr);
 
 /* EXEC SQL select instr(:lc_splch_var,'\n',:st_pos)
   into :splch_pos
   from dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 43;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select instr(:b0,'\\n',:b1) into :b2  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )539;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&lc_splch_var;
 sqlstm.sqhstl[0] = (unsigned int  )103;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&st_pos;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&splch_pos;
 sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
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
        err_mesg("SELECT chk_tab_pos failed on table DUAL",0,"");

 return(splch_pos);
}

int chk_cp_nwln_pos(str_var2,st_pos)
char str_var2[101];
{
lc_splch_var.arr[0] = '\0';
lc_splch_var.len = 0;

splch_pos = 0;

 strcpy(lc_splch_var.arr,str_var2);
 lc_splch_var.len = strlen(lc_splch_var.arr);
 
 /* EXEC SQL select instr(:lc_splch_var,'\N',:st_pos)
   into :splch_pos
   from dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 43;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select instr(:b0,'\\N',:b1) into :b2  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )566;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&lc_splch_var;
 sqlstm.sqhstl[0] = (unsigned int  )103;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&st_pos;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&splch_pos;
 sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
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
        err_mesg("SELECT chk_tab_pos failed on table DUAL",0,"");
		 
 return(splch_pos);
}

int chk_bold_pos(str_var2,st_pos)
char str_var2[101];
{
lc_splch_var.arr[0] = '\0';
lc_splch_var.len = 0;
splch_pos = 0;

 strcpy(lc_splch_var.arr,str_var2);
 lc_splch_var.len = strlen(lc_splch_var.arr);
 
 /* EXEC SQL select instr(:lc_splch_var,'\b',:st_pos)
   into :splch_pos
   from dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 43;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select instr(:b0,'\\b',:b1) into :b2  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )593;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&lc_splch_var;
 sqlstm.sqhstl[0] = (unsigned int  )103;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&st_pos;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&splch_pos;
 sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
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
        err_mesg("SELECT chk_tab_pos failed on table DUAL",0,"");
 return(splch_pos);
}

int chk_font_pos(str_var2,st_pos)
char str_var2[101];
{
lc_splch_var.arr[0] = '\0';
lc_splch_var.len = 0;
splch_pos = 0;

 strcpy(lc_splch_var.arr,str_var2);
 lc_splch_var.len = strlen(lc_splch_var.arr);
 
 /* EXEC SQL select instr(:lc_splch_var,'\f',:st_pos)
   into :splch_pos
   from dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 43;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select instr(:b0,'\\f',:b1) into :b2  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )620;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&lc_splch_var;
 sqlstm.sqhstl[0] = (unsigned int  )103;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&st_pos;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&splch_pos;
 sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
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
        err_mesg("SELECT chk_tab_pos failed on table DUAL",0,"");

 return(splch_pos);
}

int chk_esc_pos(str_var2,st_pos)
char str_var2[101];
{
lc_splch_var.arr[0] = '\0';
lc_splch_var.len = 0;
splch_pos = 0;

 strcpy(lc_splch_var.arr,str_var2);
 lc_splch_var.len = strlen(lc_splch_var.arr);
 
 /* EXEC SQL select instr(:lc_splch_var,'\',:st_pos)
   into :splch_pos
   from dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 43;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select instr(:b0,'\\',:b1) into :b2  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )647;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&lc_splch_var;
 sqlstm.sqhstl[0] = (unsigned int  )103;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&st_pos;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&splch_pos;
 sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
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
        err_mesg("SELECT chk_tab_pos failed on table DUAL",0,"");

 return(splch_pos);
}

int chk_date_yn(str_var2)
char str_var2[101];
{
lc_splch_var.arr[0] = '\0';
lc_splch_var.len = 0;
splch_pos = 0;

 strcpy(lc_splch_var.arr,str_var2);
 lc_splch_var.len = strlen(lc_splch_var.arr);
 
 /* EXEC SQL select instr(:lc_splch_var,'DATE',1)
   into :splch_pos
   from dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 43;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select instr(:b0,'DATE',1) into :b1  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )674;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&lc_splch_var;
 sqlstm.sqhstl[0] = (unsigned int  )103;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&splch_pos;
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



  if (OERROR)
        err_mesg("SELECT chk_tab_pos failed on table DUAL",0,"");

 return(splch_pos);
}

print_line(line_var)
varchar line_var[101];
{

	dup_var.arr[0] = '\0';
	dup_var.len = 0;

    pos_var  = 0;
	pos_var1 = 0;
	pos_var2 = 0;
	print_upto = 0;
	lv_var  = 1;
	i = 0;

	
	strcpy(dup_var.arr,line_var);
	dup_var.len = strlen(dup_var.arr);
	var_length = strlen(dup_var.arr);
	pos_var = char_position(dup_var.arr,"+",1);

	while(i < var_length)
	{ 
	
	if (pos_var == 0)
	{
    pos_length = var_length - i + 2;

	put_string(dup_var.arr,i,pos_length);
	
	strcpy(str_var.arr,ls_str.arr);

	str_var.len= strlen(str_var.arr);
	
	check_splch(str_var.arr);
	pos_var1 = 0;
	pos_var2 = 0;
	i = var_length;
	}

	if (pos_var != 0 && pos_var1 == 0)
	{	    
	pos_var1 = pos_var;

	pos_length = pos_var1-print_upto-1;	

    put_string(dup_var.arr,print_upto+1,pos_length);
    strcpy(str_var.arr,ls_str.arr);
	str_var.len = strlen(str_var.arr);
	check_splch(str_var.arr);

    print_upto = pos_var1 - 1;
	i = pos_var1+1;
	pos_var2 = char_position(dup_var.arr,"+",i);

     if (pos_var2 == 0)
	 {
	  pos_length = var_length - pos_var1 + 1;
      put_string(dup_var.arr,pos_var1,pos_length);
      strcpy(str_var.arr,ls_str.arr);
	  str_var.len = strlen(str_var.arr);

	  check_splch(str_var.arr);
	  print_upto = var_length+1;
	  i = var_length+1;
     }

    }

    if (pos_var2 != 0)
	{
    nd_column_val.arr[0] = '\0';
	nd_column_val.len = 0;
	column_var.arr[0] = '\0';
	column_var.len = 0;
	tab_name.arr[0] = '\0';
	tab_name.len = 0;
	
    //strcpy(sql_stmt," ");
	//strcpy(sql_stmt1," ");
//	strcpy(sql_stmt2," ");
sql_stmt1.arr[0] = '\0';
sql_stmt1.len = 0;
sql_stmt2.arr[0] = '\0';
sql_stmt2.len = 0;


	pos_length = pos_var2 - pos_var1 - 1;

    column_var.arr[0] = '\0';
	column_var.len = 0;
	
	 put_string(dup_var.arr,pos_var1+1,pos_length);
     strcpy(column_var.arr,ls_str.arr);
	 column_var.len = strlen(column_var.arr);
	 date_yn = chk_date_yn(column_var.arr);

	  /* EXEC SQL SELECT  
	           decode(:date_yn,0,'select to_char(ltrim('|| LET_MAPPED_COL_NAME || ')) from '|| LET_MAPPED_TABLE_NAME ||' WHERE ',
										 'select to_char('|| LET_MAPPED_COL_NAME || ',''DD/MM/YYYY'') from '|| LET_MAPPED_TABLE_NAME ||' WHERE '),LET_MAPPED_TABLE_NAME
					into  :sql_stmt1,tab_name
                    FROM BL_REM_LET_MAPPING_COL
                    WHERE LET_COLUMN_ID = :column_var
					AND APPL_TRX_IND = 'B'; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 43;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select decode(:b0,0,(((('select to_char(ltrim('||LET_MAPPE\
D_COL_NAME)||')) from ')||LET_MAPPED_TABLE_NAME)||' WHERE '),(((('select to_ch\
ar('||LET_MAPPED_COL_NAME)||',''DD/MM/YYYY'') from ')||LET_MAPPED_TABLE_NAME)|\
|' WHERE ')) ,LET_MAPPED_TABLE_NAME into :b1,:b2  from BL_REM_LET_MAPPING_COL \
where (LET_COLUMN_ID=:b3 and APPL_TRX_IND='B')";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )697;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&date_yn;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&sql_stmt1;
   sqlstm.sqhstl[1] = (unsigned int  )1002;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&tab_name;
   sqlstm.sqhstl[2] = (unsigned int  )33;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&column_var;
   sqlstm.sqhstl[3] = (unsigned int  )103;
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
        err_mesg("SELECT failed on table BL_REM_LET_MAPPING_COL",0,"");

	len = strlen(sql_stmt1.arr);
	sql_stmt1.arr[sql_stmt1.len]  ='\0';
//	sprintf(temp,"%d",len);
//	disp_message(ERR_MESG,temp);

	/*EXEC SQL SELECT 'select to_char('|| LET_MAPPED_COL_NAME || ') from '|| LET_MAPPED_TABLE_NAME ||' WHERE ',LET_MAPPED_TABLE_NAME
			 into  :sql_stmt1,tab_name
			 FROM BL_REM_LET_MAPPING_COL    //nd_doc_type_type
			 WHERE LET_COLUMN_ID = :column_var;
      */  

    tab_name.arr[tab_name.len] = '\0';
	

	if(strcmp(tab_name.arr,"BL_BILL_HDR") == 0 || strcmp(tab_name.arr,"BL_BILL_DCP_DTL_VW") == 0) 
	{
    //strcpy(sql_stmt2.arr, "DOC_TYPE_CODE = :nd_doc_type_code and DOC_NUM = to_number(:nd_doc_num)");
	strcpy(sql_stmt2.arr, "DOC_TYPE_CODE = ");
	strcat(sql_stmt2.arr,"'");
	strcat(sql_stmt2.arr,nd_doc_type_code.arr);
	strcat(sql_stmt2.arr,"' and DOC_NUM = to_number('");
    strcat(sql_stmt2.arr,nd_doc_num.arr);
    strcat(sql_stmt2.arr,"')");
	}
	
	if(strcmp(tab_name.arr,"MP_PATIENT_MAST") == 0) 
	{
    //strcpy(sql_stmt2.arr, "PATIENT_ID = :nd_patient_id ");
 	 strcpy(sql_stmt2.arr, "PATIENT_ID = ");
	 strcat(sql_stmt2.arr,"'");
     strcat(sql_stmt2.arr,nd_patient_id.arr);
	 strcat(sql_stmt2.arr,"'");

	}

	if(strcmp(tab_name.arr,"BL_BILLS_FOR_REMINDER") == 0) 
	{
    //strcpy(sql_stmt2.arr, "DOC_TYPE_CODE = :nd_doc_type_code and DOC_NUM = to_number(:nd_doc_num) and reminder_no = to_number(:nd_reminder_no)");
	strcpy(sql_stmt2.arr, "DOC_TYPE_CODE = ");
	strcat(sql_stmt2.arr,"'");
	strcat(sql_stmt2.arr,nd_doc_type_code.arr);
	strcat(sql_stmt2.arr,"' and DOC_NUM = to_number('");
    strcat(sql_stmt2.arr,nd_doc_num.arr);
    strcat(sql_stmt2.arr,"')");
	strcat(sql_stmt2.arr," and reminder_no = to_number('");
    strcat(sql_stmt2.arr,nd_reminder_no.arr);
    strcat(sql_stmt2.arr,"')");
	//disp_message(ERR_MESG,sql_stmt2.arr);
	}

	if(strcmp(tab_name.arr,"SY_ACC_ENTITY") == 0) 
	{
    //strcpy(sql_stmt2.arr, "ACC_ENTITY_ID = :nd_facility");
	strcpy(sql_stmt2.arr, "ACC_ENTITY_ID = ");
	strcat(sql_stmt2.arr,"'");
	strcat(sql_stmt2.arr,nd_facility.arr);
    strcat(sql_stmt2.arr,"'");
	}
	
    if(strcmp(tab_name.arr,"SM_FACILITY_PARAM") == 0) 
	{
    //strcpy(sql_stmt2.arr, "FACILITY_ID = :nd_facility");
	strcpy(sql_stmt2.arr, "FACILITY_ID = ");
	strcat(sql_stmt2.arr,"'");
	strcat(sql_stmt2.arr,nd_facility.arr);
    strcat(sql_stmt2.arr,"'");
    }

	if(strcmp(tab_name.arr,"MP_PAT_OTHER_DTLS") == 0) 
	{
     //strcpy(sql_stmt2.arr, "PATIENT_ID = :nd_patient_id");
     strcpy(sql_stmt2.arr, "PATIENT_ID = ");
	 strcat(sql_stmt2.arr,"'");
	 strcat(sql_stmt2.arr,nd_patient_id.arr);
	 strcat(sql_stmt2.arr,"'");
    }
	
	if (strcmp(tab_name.arr,"MP_RES_AREA")==0)
	{
	 //strcpy(sql_stmt2.arr, "RES_AREA_CODE=:nd_PAT_RES_AREA_CODE");
     strcpy(sql_stmt2.arr, "RES_AREA_CODE = ");
	 strcat(sql_stmt2.arr,"'");
	 strcat(sql_stmt2.arr,nd_PAT_RES_AREA_CODE.arr);
	 strcat(sql_stmt2.arr,"'");
	}
    
	if (strcmp(tab_name.arr,"MP_COUNTRY")==0)
	{
     //strcpy(sql_stmt2.arr, "COUNTRY_CODE=:nd_PAT_COUNTRY_CODE"); 
     strcpy(sql_stmt2.arr, "COUNTRY_CODE = ");
	 strcat(sql_stmt2.arr,"'");
	 strcat(sql_stmt2.arr,nd_PAT_COUNTRY_CODE.arr);
	 strcat(sql_stmt2.arr,"'");
    } 

	if (strcmp(tab_name.arr,"MP_RES_TOWN")==0)
	{
	 //strcpy(sql_stmt2.arr, "RES_TOWN_CODE=:nd_PAT_RES_TOWN_CODE");
     strcpy(sql_stmt2.arr, "RES_TOWN_CODE = ");
	 strcat(sql_stmt2.arr,"'");
	 strcat(sql_stmt2.arr,nd_PAT_RES_TOWN_CODE.arr);
	 strcat(sql_stmt2.arr,"'");

	}

 	if(strcmp(tab_name.arr,"MP_REGION") == 0) 
	{
     //strcpy(sql_stmt2.arr, "REGION_CODE = :nd_REGION_CODE");
     strcpy(sql_stmt2.arr, "REGION_CODE = ");
	 strcat(sql_stmt2.arr,"'");
	 if (strcmp(column_var.arr,"MAIL_REGION_NAME")==0)
	   strcat(sql_stmt2.arr,nd_PAT_REGION_CODE.arr);
     else
	   strcat(sql_stmt2.arr,nd_REGION_CODE.arr);
	    
	 strcat(sql_stmt2.arr,"'");
	}
    
	if(strcmp(tab_name.arr,"MP_RES_AREA") == 0) 
	{
 	 //strcpy(sql_stmt2.arr, "RES_AREA_CODE = :nd_RES_AREA_CODE"); 
     strcpy(sql_stmt2.arr, "RES_AREA_CODE  = ");
	 strcat(sql_stmt2.arr,"'");
	 if (strcmp(column_var.arr,"MAIL_AREA_NAME")==0)
	  strcat(sql_stmt2.arr,nd_PAT_RES_TOWN_CODE.arr);
     else
	  strcat(sql_stmt2.arr,nd_RES_AREA_CODE.arr);
	 strcat(sql_stmt2.arr,"'");
	}
    
	if(strcmp(tab_name.arr,"MP_RES_TOWN") == 0) 
	{
	 //strcpy(sql_stmt2.arr, "RES_TOWN_CODE = :nd_RES_TOWN_CODE"); 
     strcpy(sql_stmt2.arr, "RES_TOWN_CODE   = ");
	 strcat(sql_stmt2.arr,"'");
	 
	 if (strcmp(column_var.arr,"MAIL_TOWN_NAME")==0)
	  strcat(sql_stmt2.arr,nd_PAT_RES_TOWN_CODE.arr);
     else
	  strcat(sql_stmt2.arr,nd_RES_TOWN_CODE.arr);

	 strcat(sql_stmt2.arr,"'");    
	 }

    if(strcmp(tab_name.arr,"AR_CUSTOMER") == 0) 
	{
     //strcpy(sql_stmt2.arr, "CUST_CODE = :nd_cust_code");
     strcpy(sql_stmt2.arr, "CUST_CODE   = ");
	 strcat(sql_stmt2.arr,"'");
	 strcat(sql_stmt2.arr,nd_cust_code.arr);
	 strcat(sql_stmt2.arr,"'");       
	}


	strcpy(sql_stmt,sql_stmt1.arr);

	strcat(sql_stmt,sql_stmt2.arr); 

sql_stmt[strlen(sql_stmt)]='\0';    

//	sql_stmt[sql_stmt.len] = '\0';

//disp_message(ERR_MESG,sql_stmt);
	//strcpy(sql_stmt,sql_stmt);

/* EXEC SQL EXECUTE
	BEGIN
	 EXECUTE IMMEDIATE :sql_stmt INTO :nd_column_val;
	END;
END-EXEC; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 43;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "begin EXECUTE IMMEDIATE :sql_stmt INTO :nd_column_val ; END ;";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )728;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)4352;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)sql_stmt;
sqlstm.sqhstl[0] = (unsigned int  )5000;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&nd_column_val;
sqlstm.sqhstl[1] = (unsigned int  )1002;
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



    //nd_column_val.arr[0] = '\0';
	//nd_column_val.len = 0;
    
if (OERROR)
	 {
	  sprintf(st_var,"%d",sqlca.sqlcode);
	  column_var.arr[0] = '\0';
	  column_var.len = 0;
	
      pos_length = pos_var2 - pos_var1 + 1;
	  put_string(dup_var.arr,pos_var1,pos_length);
      strcpy(column_var.arr,ls_str.arr);
	 
	  column_var.len = strlen(column_var.arr);
	  if((strcmp(st_var,"-1405")!=0))
       fprintf(fp,"%s",column_var.arr);

	 }
else
{
	nd_column_val.arr[nd_column_val.len] = '\0';
	fprintf(fp,"%-s",nd_column_val.arr);

}

//	EXEC SQL PREPARE SELECT_REM FROM :sql_stmt;
//disp_message(ERR_MESG,"ST PREPARED");
/*	if (OERROR)
	 {
	  column_var.arr[0] = '\0';
	  column_var.len = 0;
	
      pos_length = pos_var2 - pos_var1 + 1;
	  put_string(dup_var.arr,pos_var1,pos_length);
      strcpy(column_var.arr,ls_str.arr);
	 
	  column_var.len = strlen(column_var.arr);
      fprintf(fp,"%s",column_var.arr);

	 }
    else
	{
	EXEC SQL DECLARE SELECT_REM_CUR CURSOR FOR SELECT_REM;

    if (OERROR)
        err_mesg("Declare failed on SELECT_REM_CUR",0,"");
//disp_message(ERR_MESG,"BEFORE IF");
	if(strcmp(tab_name.arr,"BL_BILL_HDR") == 0 || strcmp(tab_name.arr,"BL_BILL_DCP_DTL_VW") == 0) 
	{
	//disp_message(ERR_MESG,"INSIDE IF");
	EXEC SQL OPEN SELECT_REM_CUR using 
	           :nd_doc_type_code,:nd_doc_num;
    }
//disp_message(ERR_MESG,"AFTER IF");
   	if(strcmp(tab_name.arr,"MP_PATIENT_MAST") == 0) 
	EXEC SQL OPEN SELECT_REM_CUR using 
	           :nd_patient_id;

    if(strcmp(tab_name.arr,"SM_FACILITY_PARAM") == 0) 
	EXEC SQL OPEN SELECT_REM_CUR using 
	           :nd_facility;

    if (strcmp(column_var.arr,"MAIL_REGION_NAME")==0)
	{
    if(strcmp(tab_name.arr,"MP_REGION") == 0) 
	EXEC SQL OPEN SELECT_REM_CUR using 
	           :nd_PAT_REGION_CODE;
	}
	else
	{
    if(strcmp(tab_name.arr,"MP_REGION") == 0) 
	EXEC SQL OPEN SELECT_REM_CUR using 
	           :nd_REGION_CODE;
    }

    if(strcmp(tab_name.arr,"MP_COUNTRY") == 0) 
	EXEC SQL OPEN SELECT_REM_CUR using 
	           :nd_PAT_COUNTRY_CODE;


   if (strcmp(column_var.arr,"MAIL_AREA_NAME")==0)
    {
	if(strcmp(tab_name.arr,"MP_RES_AREA") == 0) 
	EXEC SQL OPEN SELECT_REM_CUR using 
	           :nd_PAT_RES_TOWN_CODE;
	}
	else
	{
	if(strcmp(tab_name.arr,"MP_RES_AREA") == 0) 
	EXEC SQL OPEN SELECT_REM_CUR using 
	           :nd_RES_AREA_CODE;
    }

	if (strcmp(column_var.arr,"MAIL_TOWN_NAME")==0)
	{
	 if(strcmp(tab_name.arr,"MP_RES_TOWN") == 0) 
	EXEC SQL OPEN SELECT_REM_CUR using 
	           :nd_PAT_RES_TOWN_CODE;
	}
	else
	{
	 if(strcmp(tab_name.arr,"MP_RES_TOWN") == 0) 
	EXEC SQL OPEN SELECT_REM_CUR using 
	           :nd_RES_TOWN_CODE;
    }   


  if(strcmp(tab_name.arr,"BL_BILLS_FOR_REMINDER") == 0) 


	EXEC SQL OPEN SELECT_REM_CUR using 
	           :nd_doc_type_code,:nd_doc_num,:nd_reminder_no;



	if(strcmp(tab_name.arr,"SY_ACC_ENTITY") == 0) 

	EXEC SQL OPEN SELECT_REM_CUR using 
				:nd_facility;

	if(strcmp(tab_name.arr,"MP_PAT_OTHER_DTLS") == 0) 
	EXEC SQL OPEN SELECT_REM_CUR using 
	           :nd_patient_id;


	if(strcmp(tab_name.arr,"AR_CUSTOMER") == 0) 
	EXEC SQL OPEN SELECT_REM_CUR using 
	           :nd_cust_code;


	if (OERROR)
        err_mesg("Open failed on SELECT_REM_CUR",0,"");

    nd_column_val.arr[0] = '\0';
	nd_column_val.len = 0;
    
	
	//EXEC SQL FETCH SELECT_REM_CUR INTO :nd_column_val;
//disp_message(ERR_MESG,nd_column_val.arr);
    if (OERROR)
        err_mesg("fetch failed on SELECT_REM_CUR",0,"");
	
	nd_column_val.arr[nd_column_val.len] = '\0';
	fprintf(fp,"%-s",nd_column_val.arr);
 
	}

	*/

	print_upto = pos_var2;
	i = pos_var2+1;  

    //EXEC SQL CLOSE SELECT_REM_CUR;
    pos_var1 = 0;
	pos_var2 = 0;
	pos_var = char_position(dup_var.arr,"+",i);
    }
   } 

} 
	
open_file()
{

    strcpy(filename,WORKING_DIR);
	strcat(filename,"BLRRMLR2.lis");

    if ((fp = fopen(filename,"w")) == NULL)
    {
       disp_message(ERR_MESG,"Error in opening file BLRRMLR2.lis");
       proc_exit();
    }

}

check_page_end(l_lead_lines, l_print_flag)
int l_lead_lines;
int	l_print_flag;
{
	if(l_print_flag==1)
		l_lead_lines=l_lead_lines+10;

	if((line_ctr+l_lead_lines)> 55) 
	{
		fprintf(fp,"%-70s %s %d\n"," ","Contd...",++pctr);
		fprintf(fp,"\f");
		fprintf(fp,"%-45s Page : %d\n\n"," ",pctr);
		line_ctr = 2;
		print_head();
	}
}


