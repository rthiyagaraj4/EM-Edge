
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/rlrsndsp.PC"
};


static unsigned int sqlctx = 1288616139;


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
            void  *sqhstv[11];
   unsigned int   sqhstl[11];
            int   sqhsts[11];
            void  *sqindv[11];
            int   sqinds[11];
   unsigned int   sqharm[11];
   unsigned int   *sqharc[11];
   unsigned short  sqadto[11];
   unsigned short  sqtdso[11];
} sqlstm = {12,11};

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

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,205,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,30,223,0,0,0,0,0,1,0,
51,0,0,3,0,0,32,230,0,0,0,0,0,1,0,
66,0,0,4,110,0,6,239,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
89,0,0,5,136,0,6,250,0,0,2,2,0,1,0,2,9,0,0,1,3,0,0,
112,0,0,6,32,0,4,338,0,0,1,0,0,1,0,2,9,0,0,
131,0,0,7,102,0,4,346,0,0,3,1,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,
158,0,0,8,58,0,4,365,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
181,0,0,9,154,0,6,380,0,0,2,2,0,1,0,1,9,0,0,2,9,0,0,
204,0,0,10,110,0,4,566,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
231,0,0,11,124,0,4,589,0,0,4,2,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
262,0,0,12,0,0,17,653,0,0,1,1,0,1,0,1,97,0,0,
281,0,0,12,0,0,45,674,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
316,0,0,12,0,0,45,682,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
351,0,0,12,0,0,13,709,0,0,4,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
382,0,0,12,0,0,15,733,0,0,0,0,0,1,0,
397,0,0,13,215,0,6,766,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
424,0,0,14,132,0,4,878,0,0,4,2,0,1,0,1,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
455,0,0,15,132,0,4,889,0,0,4,2,0,1,0,1,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
486,0,0,16,150,0,4,927,0,0,5,3,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
521,0,0,17,126,0,4,950,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
552,0,0,18,126,0,4,957,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
583,0,0,19,224,0,4,1012,0,0,11,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
642,0,0,20,205,0,4,1030,0,0,10,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
697,0,0,21,101,0,6,1153,0,0,1,1,0,1,0,2,3,0,0,
716,0,0,22,218,0,4,1163,0,0,8,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,
763,0,0,23,94,0,4,1232,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
};


/*************************  REPORT ********************************
* File:			rlrsndsp.pc
* Author:		Sathish
* Date Created: 10/12/2003

* Purpose:		To generate Specimen lists sent to Referred Lab

* Input Parameters : Sent date
					 Referred Lab				   : 
				   : Section Code

* Tables  Accesed:	 RL_REFERRED_SPECIMENS,RL_PATIENT_MAST
					 MP_PATIENT_MAST, RL_REQUEST_HEADER,
					 RL_REFERRED_LAB_CODE


* Output file:		 RLRSNDSP.LIS  

*******************************************************************/



#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <math.h>

#define MAX_LINES 55
#define OERROR (sqlca.sqlcode < 0)
#define NO_DATA_FOUND sqlca.sqlcode==1403
#define VER  "VER : 1.10.01\n"
#define ESC 0x1B
#define REP_WIDTH 78

/********** Begin of the declare section *****************/

/* EXEC SQL BEGIN DECLARE SECTION; */ 


	/* VARCHAR  uid_pwd			[42],
             comp_name1			[1000],
             comp_name2			[1000],
             oper_id			[31],
			 d_pgm_id			[10],
			 rep_date			[100],
			 nd_file_name		[100],
			 d_version_no		[50],
			 d_version			[50],

/o****** input parameters to main ****************o/

			 nd_session_id      [60],
			 nd_pgm_date	   	[50],
			 nd_sent_date		[32],
			 nd_sent_date_to    [32],
			 nd_facility_id		[5],
			 nd_sec_code        [5],
			 nd_printoption     [3],
			 nd_ref_lab         [6],
			 nd_lab_desc		[40],
			 rl_patient_id		[25], 
			 rl_sent_date		[32],
			 rl_sent_date1      [32],
			 rl_specimen_no		[41],
			 rl_unit_no         [41],//Added by babu againist ML-SD-CRF-20230 on 07.08.2008
			 rl_pat_name		[240], 			 
			 rl_pat_name_1		[61], 
			 d_patient_name_1	[240],
			 d_patient_name_2	[240],
			 d_patient_name_3	[240],
			 d_patient_name_4	[240],
			 rl_pat_alter_id	[21],
			 rl_episode_type	[2],
			 rl_donor_spec_yn   [2],//Added by babu againist ML-SD-CRF-20230 on 07.08.2008

			 rl_alter_type		[5],
			 rl_alter2_type		[5],
			 rl_alter3_type		[5],
			 rl_alter4_type		[5],
			 rl_national_id_num [31],
			 rl_alter_num		[21],
			 rl_alter2_num		[21],
			 rl_alter3_num		[21],
			 rl_alter4_num		[21],
			 rl_oth_alter_num	[21],
			 rl_alter_id		[21],
			 rl_test_code		[11],
			 rl_test_desc		[41],			 
			 rl_test_desc_1		[41],			 
			 rl_test_desc_2		[41],			 
			 rl_test_desc_3		[41],			 
			 rl_test_desc_4		[41],			 
			
			 nd_footer_line_1	[201],
			 nd_footer_line_2	[201],

/o*********from mp_param*******************o/

 			 alt_id1_type		[5],
			 alt_id2_type		[5],
			 alt_id3_type		[5],
			 alt_id4_type		[5],
			 alt_id1_reqd		[2],
			 alt_id2_reqd		[2],
			 alt_id3_reqd		[2],
			 alt_id4_reqd		[2],
			 alt_id_legend		[5]; */ 
struct { unsigned short len; unsigned char arr[42]; } uid_pwd;

struct { unsigned short len; unsigned char arr[1000]; } comp_name1;

struct { unsigned short len; unsigned char arr[1000]; } comp_name2;

struct { unsigned short len; unsigned char arr[31]; } oper_id;

struct { unsigned short len; unsigned char arr[10]; } d_pgm_id;

struct { unsigned short len; unsigned char arr[100]; } rep_date;

struct { unsigned short len; unsigned char arr[100]; } nd_file_name;

struct { unsigned short len; unsigned char arr[50]; } d_version_no;

struct { unsigned short len; unsigned char arr[50]; } d_version;

struct { unsigned short len; unsigned char arr[60]; } nd_session_id;

struct { unsigned short len; unsigned char arr[50]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[32]; } nd_sent_date;

struct { unsigned short len; unsigned char arr[32]; } nd_sent_date_to;

struct { unsigned short len; unsigned char arr[5]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[5]; } nd_sec_code;

struct { unsigned short len; unsigned char arr[3]; } nd_printoption;

struct { unsigned short len; unsigned char arr[6]; } nd_ref_lab;

struct { unsigned short len; unsigned char arr[40]; } nd_lab_desc;

struct { unsigned short len; unsigned char arr[25]; } rl_patient_id;

struct { unsigned short len; unsigned char arr[32]; } rl_sent_date;

struct { unsigned short len; unsigned char arr[32]; } rl_sent_date1;

struct { unsigned short len; unsigned char arr[41]; } rl_specimen_no;

struct { unsigned short len; unsigned char arr[41]; } rl_unit_no;

struct { unsigned short len; unsigned char arr[240]; } rl_pat_name;

struct { unsigned short len; unsigned char arr[61]; } rl_pat_name_1;

struct { unsigned short len; unsigned char arr[240]; } d_patient_name_1;

struct { unsigned short len; unsigned char arr[240]; } d_patient_name_2;

struct { unsigned short len; unsigned char arr[240]; } d_patient_name_3;

struct { unsigned short len; unsigned char arr[240]; } d_patient_name_4;

struct { unsigned short len; unsigned char arr[21]; } rl_pat_alter_id;

struct { unsigned short len; unsigned char arr[2]; } rl_episode_type;

struct { unsigned short len; unsigned char arr[2]; } rl_donor_spec_yn;

struct { unsigned short len; unsigned char arr[5]; } rl_alter_type;

struct { unsigned short len; unsigned char arr[5]; } rl_alter2_type;

struct { unsigned short len; unsigned char arr[5]; } rl_alter3_type;

struct { unsigned short len; unsigned char arr[5]; } rl_alter4_type;

struct { unsigned short len; unsigned char arr[31]; } rl_national_id_num;

struct { unsigned short len; unsigned char arr[21]; } rl_alter_num;

struct { unsigned short len; unsigned char arr[21]; } rl_alter2_num;

struct { unsigned short len; unsigned char arr[21]; } rl_alter3_num;

struct { unsigned short len; unsigned char arr[21]; } rl_alter4_num;

struct { unsigned short len; unsigned char arr[21]; } rl_oth_alter_num;

struct { unsigned short len; unsigned char arr[21]; } rl_alter_id;

struct { unsigned short len; unsigned char arr[11]; } rl_test_code;

struct { unsigned short len; unsigned char arr[41]; } rl_test_desc;

struct { unsigned short len; unsigned char arr[41]; } rl_test_desc_1;

struct { unsigned short len; unsigned char arr[41]; } rl_test_desc_2;

struct { unsigned short len; unsigned char arr[41]; } rl_test_desc_3;

struct { unsigned short len; unsigned char arr[41]; } rl_test_desc_4;

struct { unsigned short len; unsigned char arr[201]; } nd_footer_line_1;

struct { unsigned short len; unsigned char arr[201]; } nd_footer_line_2;

struct { unsigned short len; unsigned char arr[5]; } alt_id1_type;

struct { unsigned short len; unsigned char arr[5]; } alt_id2_type;

struct { unsigned short len; unsigned char arr[5]; } alt_id3_type;

struct { unsigned short len; unsigned char arr[5]; } alt_id4_type;

struct { unsigned short len; unsigned char arr[2]; } alt_id1_reqd;

struct { unsigned short len; unsigned char arr[2]; } alt_id2_reqd;

struct { unsigned short len; unsigned char arr[2]; } alt_id3_reqd;

struct { unsigned short len; unsigned char arr[2]; } alt_id4_reqd;

struct { unsigned short len; unsigned char arr[5]; } alt_id_legend;


	int  l_tab_exists;

	char	 sql_stmt[7000];

	/* VARCHAR l_translated_value  [500], //added for globalisation
	        language_id [5]; */ 
struct { unsigned short len; unsigned char arr[500]; } l_translated_value;

struct { unsigned short len; unsigned char arr[5]; } language_id;
 //added for globalisation

    int     i; //added for globalisation

/* EXEC SQL END DECLARE SECTION; */ 


char	l_delimeter;
char	l_delimeter1;
int		l_len = 30;
int		l_test_len = 30;

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

/*** global variables *****/

FILE *f1;

char local_legend[40][600];  //added for globalisation

char string_var				 [5000];

char hdr_line1[REP_WIDTH+1],
     hdr_line2[REP_WIDTH+1],
     hdr_line3[REP_WIDTH+1],
     hdr_line4[REP_WIDTH+1],
     hdr_line5[REP_WIDTH+1];

//char rep_title1[] = "SPECIMEN LIST";/***Commented against SCF No Rl-62 from HMC on 14/04/2004***/
// char rep_title1[] = "SPECIMEN LIST SENT TO REFERRAL LAB";
//char rep_title1[] = "SPECIMENS SENT TO REFERRAL LAB";  // commented for globalisation
  char rep_title1[200];

char rep_title2[30];


int		line_no			= 0;
int		page_no			= 1;
int		i				= 0;


/************* MAIN PROCEDURE *******/ 

void proc_main(argc, argv)
int argc;
char *argv[];
{

	if(argc != 11)
	{
    	disp_message(ERR_MESG,"Usage rlrsndsp uid/passwd session id pgm date");
    	proc_exit();
   	}
	

	strcpy(uid_pwd.arr, argv[1]);	
   	uid_pwd.len = strlen(uid_pwd.arr); 
   
	strcpy(nd_session_id.arr, argv[2]);
   	nd_session_id.len = strlen(nd_session_id.arr);
	
	strcpy(nd_facility_id.arr,argv[4]);
	nd_facility_id.len = strlen(nd_facility_id.arr);
		 
	strcpy(OUTPUT_FILE_NAME, argv[5]);
		  
	strcpy(nd_sent_date.arr, argv[6]);
   	nd_sent_date.len = strlen(nd_sent_date.arr);

	strcpy(nd_sent_date_to.arr, argv[7]);
   	nd_sent_date_to.len = strlen(nd_sent_date_to.arr);

	strcpy(nd_ref_lab.arr, argv[8]);
   	nd_ref_lab.len = strlen(nd_ref_lab.arr); 

	strcpy(nd_sec_code.arr, argv[9]);
   	nd_sec_code.len = strlen(nd_sec_code.arr); 

	strcpy(nd_printoption.arr, argv[10]);
   	nd_printoption.len = strlen(nd_printoption.arr); 
	
	//s
	//sprintf(string_var, "Option  %s", nd_printoption.arr);
	//disp_message(ERR_MESG, string_var);
   
	strcpy(d_pgm_id.arr,"RLRSNDSP\0");
	d_pgm_id.len  = strlen(d_pgm_id.arr);


	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

	/* EXEC SQL CONNECT :uid_pwd; */ 

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
 sqlstm.sqhstv[0] = (         void  *)&uid_pwd;
 sqlstm.sqhstl[0] = (unsigned int  )44;
 sqlstm.sqhsts[0] = (         int  )44;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}

  

	set_meduser_role();

	/******* from here added for globalisation ********/
    strcpy(language_id.arr,l_language_id.arr);
	language_id.len =l_language_id.len;
	language_id.arr[l_language_id.len]='\0';
    /****** upto here added for globalisation ********/

	get_legend_value(32);  //added for globalisation

	fetch_alter_legend();
	get_footer_line();
	do_report();
	print_end_of_rep();

	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

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
 if (sqlca.sqlcode < 0) goto err_exit;
}



   	fclose(f1);
	return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )51;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at main() occured....\n");
   proc_exit();
}

/******** added for globalisation start ******************/

get_legend_value(int cou)
 {
	/* EXEC SQL EXECUTE
	BEGIN
	  SM_POPULATE_REPORT_LEGEND.FETCH_LEGEND (:nd_facility_id,:language_id,'RLRSNDSP.LEGEND_');
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin SM_POPULATE_REPORT_LEGEND . FETCH_LEGEND ( :nd_facilit\
y_id , :language_id , 'RLRSNDSP.LEGEND_' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )66;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_facility_id;
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
               :l_translated_value :=    GET_LEGEND(LTRIM(RTRIM('RLRSNDSP.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009'))))));
		END;
		END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin :l_translated_value := GET_LEGEND ( LTRIM ( RTRIM ( '\
RLRSNDSP.LEGEND_' || LTRIM ( RTRIM ( TO_CHAR ( :i , '009' ) ) ) ) ) ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )89;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&l_translated_value;
  sqlstm.sqhstl[0] = (unsigned int  )502;
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

		//disp_message(ERR_MESG,l_translated_value.arr);

		strcpy(local_legend[i],l_translated_value.arr);

	}
 }
/******** added for globalisation end ******************/
   

/******************* DO REPORT FUNCTION ***************/

do_report()
{

	fetch_sys_info();
	gen_file_name();

	line_no = 0;
	form_hdr();

	put_hdr();

	dclr_cursor();
	open_cursor();
	
	while(fetch_dtl())
		{
			fetch_pat();
			fetch_episode();

			//Added by babu againist ML-SD-CRF-20230 on 07.08.2008
			if (strcmp(rl_donor_spec_yn.arr, "Y") == 0) 
			{
				fetch_unit();
			
			}
			//up to here

			if(l_tab_exists ) 
			{
				if(strlen(rl_pat_alter_id.arr)==0 )
				{
				  fetch_alter();
				}
			}

			fetch_test();
			print_rep();
		 }
	close_cursor();

}

/********************* FETCH HOSPITAL NAME ************************/
fetch_sys_info()
{

	comp_name1.arr[0] = '\0';
	comp_name1.len    =   0;

	comp_name2.arr[0] = '\0';
	comp_name2.len    =   0;

	rep_date.arr[0]  = '\0';
	rep_date.len     =   0;

	oper_id.arr[0]	 = '\0';
	oper_id.len		 =   0;
	
	
/*  COMMENTED BY AMJAD ON 21/02/2006 TO CHANGE FORMAT      
	EXEC SQL SELECT ACC_ENTITY_NAME,
		    		TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),  
					USER 
	     	   INTO :comp_name,
					:rep_date,
					:oper_id
  			   FROM SY_ACC_ENTITY
 		      WHERE ACC_ENTITY_ID = :nd_facility_id;
*/
	/* EXEC SQL SELECT USER 
	     	   INTO :oper_id
  			   FROM DUAL; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select USER into :b0  from DUAL ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )112;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&oper_id;
 sqlstm.sqhstl[0] = (unsigned int  )33;
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



	if(OERROR)
	    disp_message( ORA_MESG,"SELECT failed on table  DUAL \n");


	/* EXEC SQL SELECT LAB_TITLE,
					LAB_TITLE_2
		    		//'Date/Time: ' || TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') //commented for globalisation
			   INTO :comp_name1,
					:comp_name2
			//		:rep_date
			   FROM RL_PARAM_FOR_FACILITY
			  WHERE OPERATING_FACILITY_ID = :nd_facility_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select LAB_TITLE ,LAB_TITLE_2 into :b0,:b1  from RL_PARAM_FO\
R_FACILITY where OPERATING_FACILITY_ID=:b2";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )131;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&comp_name1;
 sqlstm.sqhstl[0] = (unsigned int  )1002;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&comp_name2;
 sqlstm.sqhstl[1] = (unsigned int  )1002;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_facility_id;
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
	    disp_message( ORA_MESG,"SELECT failed on table  RL_PARAM_FOR_FACILITY \n");

	
    comp_name1.arr[comp_name1.len] = '\0';
    comp_name2.arr[comp_name2.len] = '\0';

    if ((NO_DATA_FOUND) || (strcmp(comp_name1.arr,"\0") == 0) && (strcmp(comp_name2.arr,"\0") == 0))
		{
			/* EXEC SQL SELECT LAB_TITLE,
							LAB_TITLE_2
		 //   				'Date/Time: ' || TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI')
					   INTO :comp_name1,
							:comp_name2
		//					:rep_date
					   FROM RL_PARAM; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select LAB_TITLE ,LAB_TITLE_2 into :b0,:b1  from RL_PARAM ";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )158;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&comp_name1;
   sqlstm.sqhstl[0] = (unsigned int  )1002;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&comp_name2;
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


		
		
		}

    if(OERROR)
	    disp_message( ORA_MESG,"SELECT failed on table  RL_PARAM \n");
	    
    /*****************added for globalisation Start ***********/
	/* EXEC SQL EXECUTE
	DECLARE
		t_date   date;
	BEGIN
		t_date := GET_LOCALE_DATE.GET_CURRENT_DATE(:language_id);
		:rep_date := to_char(t_date,'DD/MM/YYYY HH24:MI');
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN t_date := GET_LOCALE_DATE . GET_\
CURRENT_DATE ( :language_id ) ; :rep_date := to_char ( t_date , 'DD/MM/YYYY HH\
24:MI' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )181;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&language_id;
 sqlstm.sqhstl[0] = (unsigned int  )7;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&rep_date;
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



		
	/*****************added for globalisation End ***********/
		
	comp_name1.arr[comp_name1.len] = '\0';
    comp_name2.arr[comp_name2.len] = '\0';
    rep_date.arr[rep_date.len]	 = '\0';
    oper_id.arr[oper_id.len]	 = '\0';

}

/*********** FUNCTION TO OPEN FILE *****************/

gen_file_name()
{
     
     nd_file_name.arr[0]   = '\0';
     nd_file_name.len      = 0;
	 strcpy(nd_file_name.arr,WORKING_DIR);
	 //strcat(nd_file_name.arr,"rlrsndsp.lis");
	 strcat(nd_file_name.arr,OUTPUT_FILE_NAME);
    

     if ((f1 = fopen(nd_file_name.arr,"w")) == NULL)
     {
       sprintf(string_var,"Error while opening file %s\n",nd_file_name.arr);
	   disp_message(ERR_MESG,string_var) ;
       proc_exit();
     }
	 
}


/********************* FORM HDR ************************/
form_hdr()
{    
    static int first = 1;
    char buf[15];
    char buff[100];
	int col;
	
	line_no = 0;

    strcpy(rep_title2,"");

    memset(hdr_line1,' ',REP_WIDTH+1);
    memset(hdr_line2,' ',REP_WIDTH+1);
    memset(hdr_line4,' ',REP_WIDTH+1);
	memset(hdr_line5,'-',REP_WIDTH);
	hdr_line5[REP_WIDTH] = '\0';

     strncpy(hdr_line1,"MDL : RL",8);
	
	//strncpy(hdr_line1," ",1);
    //col = (int)(REP_WIDTH-strlen(comp_name1.arr))/2;
    //strncpy(hdr_line1+col,comp_name1.arr,strlen(comp_name1.arr));

	sprintf(buff,"%9.9s : %s",local_legend[2],rep_date.arr);
    
	col = (REP_WIDTH-strlen(buff));
    strcpy(hdr_line1+col,buff);  

	//strncpy(hdr_line2," ",1);
		    strncpy(hdr_line2,"OPR :",5);
    strncpy(hdr_line2+6,oper_id.arr,strlen(oper_id.arr));

	//    col = (int)(REP_WIDTH-strlen(comp_name2.arr))/2;
  //  strncpy(hdr_line2+col,comp_name2.arr,strlen(comp_name2.arr));

	//sprintf(buf,"PAGE : %-4d",page_no++);
	/*
	sprintf(buf,"%4.4s : %4d",local_legend[1], page_no++); // added for globalisation

    strcpy(hdr_line2 - 12 +(REP_WIDTH-strlen(buf)),buf);
*/
/*  
   strncpy(hdr_line2,"OPR :",5);
    strcpy(hdr_line2+6,oper_id.arr);
*/

    memset(hdr_line3,' ',REP_WIDTH+1);

    strncpy(hdr_line3,"REP : RLRSNDSP",14);
	//strncpy(hdr_line3," ",1);

	strcpy(rep_title1,local_legend[3]);

    col = (int)(REP_WIDTH-strlen(rep_title1))/2;
    strncpy(hdr_line3+col,rep_title1,strlen(rep_title1));

	sprintf(buf,"%4.4s : %4d",local_legend[1], page_no++); // added for globalisation

    strcpy(hdr_line3 +(REP_WIDTH-strlen(buf)),buf);

//    sprintf(buf,"PAGE : %4d",page_no++);
//    strcpy(hdr_line3+(REP_WIDTH-strlen(buf)),buf);

//    col = (int)(REP_WIDTH-strlen(rep_title2))/2; 
//    strcpy(hdr_line4+col,rep_title2);

    if(first)
		{
		// added the below two lines against the Incident 17618 by srinivas 
		fprintf(f1,"%-*s%-.78s\n",(int)(((78 - comp_name1.len)/2) ),"",comp_name1.arr);
		fprintf(f1,"%-*s%-.78s\n",(int)(((78 - comp_name2.len)/2) ),"",comp_name2.arr);
        fprintf(f1,"%s\n",hdr_line1);
		}
    else
		{
		  print_line(REP_WIDTH+1);
		  fprintf(f1,"%s\n",nd_footer_line_1.arr);		
		  fprintf(f1,"%s\n",nd_footer_line_2.arr);		
		  // added the below two lines against the Incident 17618 by srinivas  
	   	fprintf(f1,"\f\n%-*s%-.78s\n",(int)(((78 - comp_name1.len)/2) ),"",comp_name1.arr);
		fprintf(f1,"%-*s%-.78s\n",(int)(((78 - comp_name2.len)/2) ),"",comp_name2.arr);
    	  fprintf(f1,"%s\n",hdr_line1);
	}

    fprintf(f1,"%s\n",hdr_line2);
    fprintf(f1,"%s\n",hdr_line3);
 //   fprintf(f1,"%s\n",hdr_line4);
    fprintf(f1,"%s\n",hdr_line5);

	line_no += 7; 

    first = 0;
}

/******************** PUT HEADER *************************/

put_hdr()
{
	print_lab();	
	fprintf(f1,"\n\n");
	line_no+=2;
	//fprintf(f1,"Specimen Number\n");	/****Commented on 27/04/2004***/
	//fprintf(f1,"Test            Name                 NRIC/Alternate ID    Sent Date/Time   Ack\n");	

	/****Added on 17/04/2004*******Commented on 27/04/2004 as per Mr. Cyrus**/

	//fprintf(f1,"Test            Name                 ");
	//	fprintf(f1,"Test            Patient ID       Name                 ");/***added on 26/04/2004***/
	/*	fprintf(f1,"%-17s",alt_id_legend.arr);
		fprintf(f1,"Sent Date/Time   Ack\n");	
	*/
	/********upto here************************/


/****Added on 27/04/2004 as per Mr. Cyrus****************/	
	
	/*fprintf(f1,"Specimen Number                   Patient ID\n");
	fprintf(f1,"Test            ");	
	fprintf(f1,"Sent Date/Time    Patient Name      ");
	fprintf(f1,"%-17s",alt_id_legend.arr);
	fprintf(f1,"  Ack\n");*/  // commented for globalisation

/********upto here************************/
/**************added for globalisation*****/
	fprintf(f1,"%15.15s                   %10.10s\n",local_legend[5],local_legend[6]);
	fprintf(f1,"%4.4s            ",local_legend[7]);	
	fprintf(f1,"%14.14s    %12.12s      ",local_legend[8],local_legend[9]);
	fprintf(f1,"%-17s",alt_id_legend.arr);
	fprintf(f1,"  %3.3s\n",local_legend[10]);
	
/********upto here************************/

	line_no += 2;
	print_line(REP_WIDTH+1);

}

/********************* PRINT LAB ************************/
print_lab()
{
	
	nd_lab_desc.arr[0] = '\0';
	nd_lab_desc.len	   = 0;

	/* EXEC SQL SELECT long_desc
			   INTO :nd_lab_desc
			   FROM rl_referred_lab_code_lang_vw
			  WHERE referred_lab_code = :nd_ref_lab
			  AND language_id = :language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select long_desc into :b0  from rl_referred_lab_code_lang_vw\
 where (referred_lab_code=:b1 and language_id=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )204;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_lab_desc;
 sqlstm.sqhstl[0] = (unsigned int  )42;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_ref_lab;
 sqlstm.sqhstl[1] = (unsigned int  )8;
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


	
	nd_lab_desc.arr[nd_lab_desc.len] = '\0';

	//fprintf(f1,"Referral Lab Name : %s",nd_lab_desc.arr);		
	fprintf(f1,"%s : %s",local_legend[4],nd_lab_desc.arr);		
	
	line_no += 2;
}

/********************* FOOTER LINE ************************/
get_footer_line()
{
	nd_footer_line_1.arr[0] = '\0';
	nd_footer_line_1.len	   = 0;

	nd_footer_line_2.arr[0] = '\0';
	nd_footer_line_2.len	   = 0;

	/* EXEC SQL SELECT FOOTER_LINE_1,
					FOOTER_LINE_2
			   INTO :nd_footer_line_1,
					:nd_footer_line_2
			   FROM rl_section_ctl
			  WHERE operating_facility_id = :nd_facility_id 
				AND section_code = :nd_sec_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select FOOTER_LINE_1 ,FOOTER_LINE_2 into :b0,:b1  from rl_se\
ction_ctl where (operating_facility_id=:b2 and section_code=:b3)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )231;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_footer_line_1;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_footer_line_2;
 sqlstm.sqhstl[1] = (unsigned int  )203;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_facility_id;
 sqlstm.sqhstl[2] = (unsigned int  )7;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_sec_code;
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

 			   
	
	nd_footer_line_1.arr[nd_footer_line_1.len] = '\0';
	nd_footer_line_2.arr[nd_footer_line_2.len] = '\0';

return;
}


/********************* PRINT LINE ************************/

print_line(int no_of_lines)
{
   for (i=1;i<no_of_lines;i++)
   {
	  fprintf(f1, "-");
   }
   fprintf(f1, "\n");
   line_no++;
}

/****************** DECLARE CURSOR ********************/
dclr_cursor()
{

	/**
	EXEC SQL DECLARE rl_send_spec_cur CURSOR FOR
		SELECT to_char(specimen_no),patient_id,TO_CHAR(sent_date,'DD/MM/YYYY HH:MI'),test_code
		  FROM rl_referred_specimens 
		 WHERE operating_facility_id = :nd_facility_id 
           AND sent_date >= TO_DATE(:nd_sent_date, 'DD/MM/YYYY') 
           AND sent_date <  TO_DATE(:nd_sent_date, 'DD/MM/YYYY') + 1 
		   AND referred_lab_code = :nd_ref_lab 
           AND section_code = :nd_sec_code 
		   ORDER BY 1;
	**/

	strcpy(sql_stmt, "SELECT TO_CHAR(specimen_no), patient_id, \
	                  TO_CHAR(sent_date, 'DD/MM/YYYY HH24:MI'), \
	                  test_code \
					  FROM rl_referred_specimens \
					  WHERE operating_facility_id = :nd_facility_id ");
	
	if (strcmp(nd_printoption.arr, "P") == 0) 
	{
		strcat(sql_stmt, " AND sent_date >= TO_DATE(:nd_sent_date, 'DD/MM/YYYYHH24:MI:SS') \
		                   AND sent_date < TO_DATE(:nd_sent_date, 'DD/MM/YYYYHH24:MI:SS') + 1 ");
	}
	else
	{
		strcat(sql_stmt, "AND sent_date BETWEEN TO_DATE(:nd_sent_date,'DD/MM/YYYYHH24:MI:SS') \
		                  AND  TO_DATE(:nd_sent_date_to, 'DD/MM/YYYYHH24:MI:SS') ");
	}

	strcat(sql_stmt, "AND referred_lab_code = :nd_ref_lab \
	                  AND section_code = :nd_sec_code \
					  ORDER BY 1");

	/* EXEC SQL PREPARE S FROM :sql_stmt; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )262;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)sql_stmt;
 sqlstm.sqhstl[0] = (unsigned int  )7000;
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



	/* EXEC SQL DECLARE RL_SEND_SPEC_CUR CURSOR FOR S; */ 



	if (OERROR)
	  {
		fprintf(f1,"Error in declare cursor");
		disp_message(ORA_MESG,"Declare Failed on Cursor rl_send_spec_cur");
	  }

}

/********************* OPEN CURSOR *******************/
open_cursor()

{

	if (strcmp(nd_printoption.arr, "P") == 0)  
	{
		// EXEC SQL OPEN rl_send_spec_cur;
		/* EXEC SQL OPEN RL_SEND_SPEC_CUR USING :nd_facility_id,
		                                     :nd_sent_date,
											 :nd_sent_date,
											 :nd_ref_lab,
											 :nd_sec_code; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )281;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqcmod = (unsigned int )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_facility_id;
  sqlstm.sqhstl[0] = (unsigned int  )7;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_sent_date;
  sqlstm.sqhstl[1] = (unsigned int  )34;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_sent_date;
  sqlstm.sqhstl[2] = (unsigned int  )34;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_ref_lab;
  sqlstm.sqhstl[3] = (unsigned int  )8;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_sec_code;
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


	}
	else
	{
		/* EXEC SQL OPEN RL_SEND_SPEC_CUR USING :nd_facility_id,
		                                     :nd_sent_date,
											 :nd_sent_date_to,
											 :nd_ref_lab,
											 :nd_sec_code; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )316;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqcmod = (unsigned int )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_facility_id;
  sqlstm.sqhstl[0] = (unsigned int  )7;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_sent_date;
  sqlstm.sqhstl[1] = (unsigned int  )34;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_sent_date_to;
  sqlstm.sqhstl[2] = (unsigned int  )34;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_ref_lab;
  sqlstm.sqhstl[3] = (unsigned int  )8;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_sec_code;
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


	}
	
}


/********************* FETCH DETAIL ******************/

fetch_dtl()
{
  
  rl_specimen_no.arr[0]   =  '\0';
  rl_specimen_no.len	  =    0; 

  rl_patient_id.arr[0]	  =  '\0';
  rl_patient_id.len		  =    0;

  rl_sent_date.arr[0]	  =  '\0';
  rl_sent_date.len		  =	   0;

  rl_test_code.arr[0]	  =  '\0';
  rl_test_code.len		  =	   0;

	/* EXEC SQL FETCH RL_SEND_SPEC_CUR
			  INTO :rl_specimen_no, :rl_patient_id, :rl_sent_date, :rl_test_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )351;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqfoff = (           int )0;
 sqlstm.sqfmod = (unsigned int )2;
 sqlstm.sqhstv[0] = (         void  *)&rl_specimen_no;
 sqlstm.sqhstl[0] = (unsigned int  )43;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&rl_patient_id;
 sqlstm.sqhstl[1] = (unsigned int  )27;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&rl_sent_date;
 sqlstm.sqhstl[2] = (unsigned int  )34;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&rl_test_code;
 sqlstm.sqhstl[3] = (unsigned int  )13;
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
		disp_message(ORA_MESG,"FETCH failed on cursor rl_send_spec_cur CURSOR\n");

	if(NO_DATA_FOUND)
		return 0;

	rl_specimen_no.arr[rl_specimen_no.len]	= '\0';
	rl_patient_id.arr[rl_patient_id.len]	= '\0';
    rl_sent_date.arr[rl_sent_date.len]      = '\0';
	rl_test_code.arr[rl_test_code.len]		= '\0';

	return 1;

}

/****************** CLOSE CURSOR **********************/

close_cursor()
{

	/* EXEC SQL CLOSE rl_send_spec_cur; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )382;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



}


/******************* PRINT REP ****************/

print_rep()

{
   if(line_no + 9 >= MAX_LINES)
	{
	  line_no = 0;	    
	  form_hdr();
	  put_hdr(); 
    }

//fprintf(f1,"%-15s %-16s %-20s %-16s %s \n", rl_specimen_no.arr,rl_patient_id.arr,rl_pat_name.arr,rl_alter_id.arr,rl_sent_date.arr);/***Commented on 27/04/2004***/
//fprintf(f1,"%-40s \n\n",rl_test_desc.arr); 
 
/***Added on 27/04/2004****/

 l_delimeter = ' ';  
 l_delimeter1 = ' ';  
 rl_split_text(rl_pat_name.arr, l_delimeter, l_len, d_patient_name_1.arr,
			    d_patient_name_2.arr, d_patient_name_3.arr, d_patient_name_4.arr); 

 rl_split_text(rl_test_desc.arr, l_delimeter, l_test_len, rl_test_desc_1.arr,
			    rl_test_desc_2.arr, rl_test_desc_3.arr, rl_test_desc_4.arr);  /// 14.02.2006

 fprintf(f1,"%-15s", rl_specimen_no.arr);
 
 //fprintf(f1," %-18s", rl_sent_date.arr);
 /* EXEC SQL EXECUTE
 DECLARE
	t_date   date;
 BEGIN
	GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:rl_sent_date,'DD/MM/YYYY HH24:MI'), :language_id , t_date);
	:rl_sent_date1 := to_char(t_date,'DD/MM/YYYY HH24:MI');
 END;
 END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN GET_LOCALE_DATE . CONVERT_TO_LOC\
ALE_DATE ( to_date ( :rl_sent_date , 'DD/MM/YYYY HH24:MI' ) , :language_id , t\
_date ) ; :rl_sent_date1 := to_char ( t_date , 'DD/MM/YYYY HH24:MI' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )397;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&rl_sent_date;
 sqlstm.sqhstl[0] = (unsigned int  )34;
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
 sqlstm.sqhstv[2] = (         void  *)&rl_sent_date1;
 sqlstm.sqhstl[2] = (unsigned int  )34;
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


 fprintf(f1," %-18s", rl_sent_date1.arr);

 fprintf(f1,"%-16s  %-16s \n", rl_patient_id.arr,rl_alter_id.arr);
 line_no++;

///14.02.2006 fprintf(f1,"%-34s%-20s \n",rl_test_desc.arr,d_patient_name_1.arr); 
 
 fprintf(f1,"%-34s%-20s \n",rl_test_desc_1.arr,d_patient_name_1.arr); 
 line_no++;
 
 if(strlen(d_patient_name_2.arr) >0 || strlen(rl_test_desc_2.arr) >0) 
 {
   if(strlen(rl_test_desc_2.arr) >0)
     fprintf(f1,"%-34s",rl_test_desc_2.arr); 
   else
     fprintf(f1,"%-34s"," "); 

   if(strlen(d_patient_name_2.arr) >0)
      fprintf(f1,"%-20s\n",d_patient_name_2.arr); 
   else
      fprintf(f1,"%-20s\n"," "); 

   line_no++;
 }

/*******14.02.2006
 if(strlen(d_patient_name_3.arr) >0) 
 {
   fprintf(f1,"%-34s%-20s\n"," ",d_patient_name_3.arr); 
   line_no++;
 }
 if(strlen(d_patient_name_4.arr) >0) 
 {
   fprintf(f1,"%-34s%-20s\n"," ",d_patient_name_4.arr); 
   line_no++;
 }
 ********** 14.02.2006 ******/

  if(strlen(d_patient_name_3.arr) >0 || strlen(rl_test_desc_3.arr) >0) 
 {
   if(strlen(rl_test_desc_3.arr) >0)
     fprintf(f1,"%-34s",rl_test_desc_3.arr); 
   else
     fprintf(f1,"%-34s"," "); 

   if(strlen(d_patient_name_3.arr) >0)
      fprintf(f1,"%-20s\n",d_patient_name_3.arr); 
   else
      fprintf(f1,"%-20s\n"," "); 

   line_no++;
 }

  if(strlen(d_patient_name_4.arr) >0 || strlen(rl_test_desc_4.arr) >0) 
 {
   if(strlen(rl_test_desc_4.arr) >0)
     fprintf(f1,"%-34s",rl_test_desc_4.arr); 
   else
     fprintf(f1,"%-34s"," "); 

   if(strlen(d_patient_name_4.arr) >0)
      fprintf(f1,"%-20s\n",d_patient_name_4.arr); 
   else
      fprintf(f1,"%-20s\n"," "); 

   line_no++;
 }
  if (strlen(rl_unit_no.arr) > 0 )
  {
	fprintf(f1,"%-34s"," "); 
	fprintf(f1,"%-s:",local_legend[13]);
	fprintf(f1,"%-s",rl_unit_no.arr);//Added by babu againist ML-SD-CRF-20230 on 07.08.2008
	rl_unit_no.arr[0]  = '\0';
	rl_unit_no.len		=   0 ;
	line_no++;
	fprintf(f1, "\n");
	}

 fprintf(f1, "\n");

/****upto here*************/

 
 // line_no += 3;


}

/****************** FETCH PATIENT NAME ****************/

fetch_pat()
{

	rl_pat_name.arr[0]  = '\0';
	rl_pat_name.len		=   0 ;

	rl_pat_alter_id.arr[0]  = '\0';
	rl_pat_alter_id.len		= 0;

    
	/*EXEC SQL SELECT short_name, national_id_num
			   INTO :rl_pat_name,:rl_pat_alter_id
			   FROM mp_patient_mast
			  WHERE patient_id = :rl_patient_id;*/  //changed for globalisation
	/* EXEC SQL SELECT DECODE(:language_id,'en',short_name,'th',SHORT_NAME_LOC_LANG), national_id_num
			   INTO :rl_pat_name,:rl_pat_alter_id
			   FROM mp_patient_mast
			  WHERE patient_id = :rl_patient_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select DECODE(:b0,'en',short_name,'th',SHORT_NAME_LOC_LANG) \
,national_id_num into :b1,:b2  from mp_patient_mast where patient_id=:b3";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )424;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&language_id;
 sqlstm.sqhstl[0] = (unsigned int  )7;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&rl_pat_name;
 sqlstm.sqhstl[1] = (unsigned int  )242;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&rl_pat_alter_id;
 sqlstm.sqhstl[2] = (unsigned int  )23;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&rl_patient_id;
 sqlstm.sqhstl[3] = (unsigned int  )27;
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



	if(NO_DATA_FOUND)

	/*EXEC SQL SELECT short_name, national_id_num
			   INTO :rl_pat_name,:rl_pat_alter_id
			   FROM rl_patient_mast
			  WHERE patient_id = :rl_patient_id;*/  //changed for globalisation
	/* EXEC SQL SELECT DECODE(:language_id,'en',short_name,'th',SHORT_NAME_LOC_LANG), national_id_num
			   INTO :rl_pat_name,:rl_pat_alter_id
			   FROM rl_patient_mast
			  WHERE patient_id = :rl_patient_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select DECODE(:b0,'en',short_name,'th',SHORT_NAME_LOC_LANG) \
,national_id_num into :b1,:b2  from rl_patient_mast where patient_id=:b3";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )455;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&language_id;
 sqlstm.sqhstl[0] = (unsigned int  )7;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&rl_pat_name;
 sqlstm.sqhstl[1] = (unsigned int  )242;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&rl_pat_alter_id;
 sqlstm.sqhstl[2] = (unsigned int  )23;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&rl_patient_id;
 sqlstm.sqhstl[3] = (unsigned int  )27;
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



	
    rl_pat_name.arr[rl_pat_name.len]		 = '\0';	
	rl_pat_alter_id.arr[rl_pat_alter_id.len]		 = '\0';
	strcpy(rl_alter_id.arr, rl_pat_alter_id.arr);

	return;

}

/****************** FETCH EPISODE TYPE ****************/

fetch_episode()

{

	rl_episode_type.arr[0]  = '\0';
	rl_episode_type.len		= 0;
	rl_donor_spec_yn.arr[0] = '\0';
	rl_donor_spec_yn.len    = 0;


    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  /*
	EXEC SQL SELECT episode_type
			   INTO :rl_episode_type
			   FROM rl_request_header
			  WHERE patient_id = :rl_patient_id
			    AND specimen_no = :rl_specimen_no
				AND operating_facility_id = :nd_facility_id;
  */

  //Added by babu againist ML-SD-CRF-20230 on 07.08.2008

	/* EXEC SQL   SELECT episode_type,donor_specimen_yn
			   INTO :rl_episode_type,:rl_donor_spec_yn
			   FROM rl_request_header
			   WHERE patient_id = :rl_patient_id
			   AND specimen_no = :rl_specimen_no
			   AND operating_facility_id = :nd_facility_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select episode_type ,donor_specimen_yn into :b0,:b1  from rl\
_request_header where ((patient_id=:b2 and specimen_no=:b3) and operating_faci\
lity_id=:b4)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )486;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&rl_episode_type;
 sqlstm.sqhstl[0] = (unsigned int  )4;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&rl_donor_spec_yn;
 sqlstm.sqhstl[1] = (unsigned int  )4;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&rl_patient_id;
 sqlstm.sqhstl[2] = (unsigned int  )27;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&rl_specimen_no;
 sqlstm.sqhstl[3] = (unsigned int  )43;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_facility_id;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}



//up to here

	rl_episode_type.arr[rl_episode_type.len] = '\0';
    rl_donor_spec_yn.arr[rl_donor_spec_yn.len] = '\0';
	return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 
   
   disp_message(ORA_MESG,"Oracle error at fetch_episode() occured....\n");
   proc_exit();
}
/******************Fetch unit starts********************/
fetch_unit()
{
rl_unit_no.arr[0]  = '\0';
rl_unit_no.len		=   0 ;
/* EXEC SQL	SELECT unit_no
			INTO   :rl_unit_no
			FROM   bd_lab_screen_test_dtl
			WHERE  specimen_no =:rl_specimen_no
			AND    test_code   = :rl_test_code
			AND    operating_facility_id = :nd_facility_id; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 5;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select unit_no into :b0  from bd_lab_screen_test_dtl where ((\
specimen_no=:b1 and test_code=:b2) and operating_facility_id=:b3)";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )521;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)4352;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&rl_unit_no;
sqlstm.sqhstl[0] = (unsigned int  )43;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&rl_specimen_no;
sqlstm.sqhstl[1] = (unsigned int  )43;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&rl_test_code;
sqlstm.sqhstl[2] = (unsigned int  )13;
sqlstm.sqhsts[2] = (         int  )0;
sqlstm.sqindv[2] = (         void  *)0;
sqlstm.sqinds[2] = (         int  )0;
sqlstm.sqharm[2] = (unsigned int  )0;
sqlstm.sqadto[2] = (unsigned short )0;
sqlstm.sqtdso[2] = (unsigned short )0;
sqlstm.sqhstv[3] = (         void  *)&nd_facility_id;
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


if(NO_DATA_FOUND)
/* EXEC SQL	SELECT unit_no
			INTO   :rl_unit_no
			FROM   bt_lab_screen_test_dtl
			WHERE  specimen_no =:rl_specimen_no
			AND    test_code   = :rl_test_code
			AND    operating_facility_id = :nd_facility_id; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 5;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select unit_no into :b0  from bt_lab_screen_test_dtl where ((\
specimen_no=:b1 and test_code=:b2) and operating_facility_id=:b3)";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )552;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)4352;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&rl_unit_no;
sqlstm.sqhstl[0] = (unsigned int  )43;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&rl_specimen_no;
sqlstm.sqhstl[1] = (unsigned int  )43;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&rl_test_code;
sqlstm.sqhstl[2] = (unsigned int  )13;
sqlstm.sqhsts[2] = (         int  )0;
sqlstm.sqindv[2] = (         void  *)0;
sqlstm.sqinds[2] = (         int  )0;
sqlstm.sqharm[2] = (unsigned int  )0;
sqlstm.sqadto[2] = (unsigned short )0;
sqlstm.sqtdso[2] = (unsigned short )0;
sqlstm.sqhstv[3] = (         void  *)&nd_facility_id;
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



if(NO_DATA_FOUND);
rl_unit_no.arr[rl_unit_no.len]		 = '\0';	


}

/****************** FETCH ALTERNATE ID ****************/

fetch_alter()

{
				
		rl_national_id_num.arr[0] = '\0';
		rl_national_id_num.len    = 0;

		rl_alter_id.arr[0]  = '\0';
		rl_alter_id.len		= 0;

		rl_alter_type.arr[0] = '\0';
		rl_alter_type.len	 = 0;

		rl_alter2_type.arr[0] = '\0';
		rl_alter2_type.len	 = 0;

		rl_alter3_type.arr[0] = '\0';
		rl_alter3_type.len	 = 0;

		rl_alter4_type.arr[0] = '\0';
		rl_alter4_type.len	 = 0;
		
		rl_alter_num.arr[0] = '\0';
		rl_alter_num.len	= 0;

		rl_alter2_num.arr[0] = '\0';
		rl_alter2_num.len	= 0;

		rl_alter3_num.arr[0] = '\0';
		rl_alter3_num.len	= 0;

		rl_alter4_num.arr[0] = '\0';
		rl_alter4_num.len	= 0;

		rl_oth_alter_num.arr[0] = '\0';
		rl_oth_alter_num.len	= 0;

		if(strcmp(rl_episode_type.arr,"I")==0 || strcmp(rl_episode_type.arr,"O")==0 || strcmp(rl_episode_type.arr,"H")==0)
		{

			/* EXEC SQL SELECT national_id_no,
			                alt_id1_type, alt_id1_no,
						    alt_id2_type, alt_id2_no,
							alt_id3_type, alt_id3_no,
							alt_id4_type, alt_id4_no, oth_alt_id_no
					INTO	:rl_national_id_num,
						    :rl_alter_type,:rl_alter_num,
							:rl_alter2_type,:rl_alter2_num,
							:rl_alter3_type,:rl_alter3_num,
							:rl_alter4_type,:rl_alter4_num, :rl_oth_alter_num
					 FROM	mp_patient
					 WHERE  patient_id = :rl_patient_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select national_id_no ,alt_id1_type ,alt_id1_no ,alt_id2_t\
ype ,alt_id2_no ,alt_id3_type ,alt_id3_no ,alt_id4_type ,alt_id4_no ,oth_alt_i\
d_no into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9  from mp_patient where patie\
nt_id=:b10";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )583;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&rl_national_id_num;
   sqlstm.sqhstl[0] = (unsigned int  )33;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&rl_alter_type;
   sqlstm.sqhstl[1] = (unsigned int  )7;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&rl_alter_num;
   sqlstm.sqhstl[2] = (unsigned int  )23;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&rl_alter2_type;
   sqlstm.sqhstl[3] = (unsigned int  )7;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&rl_alter2_num;
   sqlstm.sqhstl[4] = (unsigned int  )23;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&rl_alter3_type;
   sqlstm.sqhstl[5] = (unsigned int  )7;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&rl_alter3_num;
   sqlstm.sqhstl[6] = (unsigned int  )23;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&rl_alter4_type;
   sqlstm.sqhstl[7] = (unsigned int  )7;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&rl_alter4_num;
   sqlstm.sqhstl[8] = (unsigned int  )23;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&rl_oth_alter_num;
   sqlstm.sqhstl[9] = (unsigned int  )23;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&rl_patient_id;
   sqlstm.sqhstl[10] = (unsigned int  )27;
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



		}
		else if( strcmp(rl_episode_type.arr,"R")==0 )
		{
		  if ( l_tab_exists )
		  {
			/* EXEC SQL SELECT alt_id1_type, alt_id1_no,
						    alt_id2_type, alt_id2_no,
							alt_id3_type, alt_id3_no,
							alt_id4_type, alt_id4_no, oth_alt_id_no
					INTO	:rl_alter_type,:rl_alter_num,
							:rl_alter2_type,:rl_alter2_num,
							:rl_alter3_type,:rl_alter3_num,
							:rl_alter4_type,:rl_alter4_num, :rl_oth_alter_num
					FROM	mp_ext_person
					WHERE  person_id = :rl_patient_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select alt_id1_type ,alt_id1_no ,alt_id2_type ,alt_id2_no \
,alt_id3_type ,alt_id3_no ,alt_id4_type ,alt_id4_no ,oth_alt_id_no into :b0,:b\
1,:b2,:b3,:b4,:b5,:b6,:b7,:b8  from mp_ext_person where person_id=:b9";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )642;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&rl_alter_type;
   sqlstm.sqhstl[0] = (unsigned int  )7;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&rl_alter_num;
   sqlstm.sqhstl[1] = (unsigned int  )23;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&rl_alter2_type;
   sqlstm.sqhstl[2] = (unsigned int  )7;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&rl_alter2_num;
   sqlstm.sqhstl[3] = (unsigned int  )23;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&rl_alter3_type;
   sqlstm.sqhstl[4] = (unsigned int  )7;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&rl_alter3_num;
   sqlstm.sqhstl[5] = (unsigned int  )23;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&rl_alter4_type;
   sqlstm.sqhstl[6] = (unsigned int  )7;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&rl_alter4_num;
   sqlstm.sqhstl[7] = (unsigned int  )23;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&rl_oth_alter_num;
   sqlstm.sqhstl[8] = (unsigned int  )23;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&rl_patient_id;
   sqlstm.sqhstl[9] = (unsigned int  )27;
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
		}

		rl_national_id_num.arr[rl_national_id_num.len] = '\0';
		rl_alter_type.arr[rl_alter_type.len]           = '\0';
		rl_alter2_type.arr[rl_alter2_type.len]         = '\0';
		rl_alter3_type.arr[rl_alter3_type.len]         = '\0';		
		rl_alter4_type.arr[rl_alter4_type.len]         = '\0';

		rl_alter_num.arr[rl_alter_num.len]             = '\0';
		rl_alter2_num.arr[rl_alter2_num.len]           = '\0';	
		rl_alter3_num.arr[rl_alter3_num.len]           = '\0';
		rl_alter4_num.arr[rl_alter4_num.len]           = '\0';
		rl_oth_alter_num.arr[rl_oth_alter_num.len]     = '\0';

		rl_alter_id.arr[rl_alter_id.len]               = '\0';


		/****Added by Sai Dutt on 06/03/2006 *************/
/*
		if (strlen(rl_pat_alter_id.arr))
		{
			strcpy(rl_alter_id.arr,rl_pat_alter_id.arr);
		}
		else if(strcmp(alt_id1_reqd.arr,"Y")==0) 
		{
			strcpy(rl_alter_id.arr,rl_alter_num.arr);
		}
		else if(strcmp(alt_id2_reqd.arr,"Y")==0) 
		{			
			strcpy(rl_alter_id.arr,rl_alter2_num.arr);
		}		
		else if(strcmp(alt_id3_reqd.arr,"Y")==0) 
		{
			strcpy(rl_alter_id.arr,rl_alter3_num.arr);
		}
		else if(strcmp(alt_id4_reqd.arr,"Y")==0)
		{			
			strcpy(rl_alter_id.arr,rl_alter4_num.arr);
		}
*/
		if ( strlen(rl_alter_id.arr)== 0)
		{
		  if (strlen(rl_alter_num.arr) > 0)
		  {
			strcpy(rl_alter_id.arr,rl_alter_num.arr);
		  }
		  else if (strlen(rl_alter2_num.arr) > 0)
		  {
			strcpy(rl_alter_id.arr,rl_alter2_num.arr);
		  }
		  else if (strlen(rl_alter3_num.arr) > 0)
		  {
			strcpy(rl_alter_id.arr,rl_alter3_num.arr);
		  }	
		  else if (strlen(rl_alter4_num.arr) > 0)
		  {
			strcpy(rl_alter_id.arr,rl_alter4_num.arr);
		  }
		  else if (strlen(rl_oth_alter_num.arr) > 0)
		  {
			strcpy(rl_alter_id.arr,rl_oth_alter_num.arr);
		  }
		}

		rl_alter_id.len = strlen(rl_alter_id.arr);

		/********upto here**********************/

		/**************COMMENTED ON 17/04/2004 

		if(strcmp(rl_alter_type.arr,"NRIC")==0) 
			strcpy(rl_alter_id.arr,rl_alter_num.arr);
		if(strcmp(rl_alter2_type.arr,"NRIC")==0) 
			strcpy(rl_alter_id.arr,rl_alter2_num.arr);
		if(strcmp(rl_alter3_type.arr,"NRIC")==0) 
			strcpy(rl_alter_id.arr,rl_alter3_num.arr);
		if(strcmp(rl_alter4_type.arr,"NRIC")==0) 
			strcpy(rl_alter_id.arr,rl_alter4_num.arr);

		rl_alter_id.arr[rl_alter_id.len]  = '\0';				

		******************/
	
		
		return;

}

/****************** FETCH ALTERNATE ID REQUIRED AND LEGEND ****************/

fetch_alter_legend()

{		
		alt_id1_reqd.arr[0]  = '\0';
		alt_id1_reqd.len	 = 0;
		alt_id1_type.arr[0]  = '\0';
		alt_id1_type.len	 = 0;
		alt_id2_reqd.arr[0]  = '\0';
		alt_id2_reqd.len	 = 0;
		alt_id2_type.arr[0]  = '\0';
		alt_id2_type.len	 = 0;
		alt_id3_reqd.arr[0]  = '\0';
		alt_id3_reqd.len	 = 0;
		alt_id3_type.arr[0]  = '\0';
		alt_id3_type.len	 = 0;
		alt_id4_reqd.arr[0]  = '\0';
		alt_id4_reqd.len	 = 0;
		alt_id4_type.arr[0]  = '\0';
		alt_id4_type.len	 = 0;
		alt_id_legend.arr[0]  = '\0';
		alt_id_legend.len	 = 0;

		 /* EXEC SQL EXECUTE 
			  begin
				if SM_INSTALLATION_TAB_CHECK THEN
				   :l_tab_exists := 1;
				else
				   :l_tab_exists := 0;
				end if;
			  end;
		 END-EXEC; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "begin if SM_INSTALLATION_TAB_CHECK THEN :l_tab_exists := 1\
 ; else :l_tab_exists := 0 ; end if ; end ;";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )697;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&l_tab_exists;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
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



		/* EXEC SQL SELECT NVL(alt_id1_reqd_yn, 'N'), alt_id1_type,
					    NVL(alt_id2_reqd_yn, 'N'), alt_id2_type,
						NVL(alt_id3_reqd_yn, 'N'), alt_id3_type,
						NVL(alt_id4_reqd_yn, 'N'), alt_id4_type
				 INTO	:alt_id1_reqd,:alt_id1_type,
						:alt_id2_reqd,:alt_id2_type,
						:alt_id3_reqd,:alt_id3_type,
						:alt_id4_reqd,:alt_id4_type
				 FROM	mp_param; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select NVL(alt_id1_reqd_yn,'N') ,alt_id1_type ,NVL(alt_id2_\
reqd_yn,'N') ,alt_id2_type ,NVL(alt_id3_reqd_yn,'N') ,alt_id3_type ,NVL(alt_id\
4_reqd_yn,'N') ,alt_id4_type into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7  from mp_par\
am ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )716;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&alt_id1_reqd;
  sqlstm.sqhstl[0] = (unsigned int  )4;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&alt_id1_type;
  sqlstm.sqhstl[1] = (unsigned int  )7;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&alt_id2_reqd;
  sqlstm.sqhstl[2] = (unsigned int  )4;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&alt_id2_type;
  sqlstm.sqhstl[3] = (unsigned int  )7;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&alt_id3_reqd;
  sqlstm.sqhstl[4] = (unsigned int  )4;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&alt_id3_type;
  sqlstm.sqhstl[5] = (unsigned int  )7;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&alt_id4_reqd;
  sqlstm.sqhstl[6] = (unsigned int  )4;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&alt_id4_type;
  sqlstm.sqhstl[7] = (unsigned int  )7;
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



		alt_id1_reqd.arr[alt_id1_reqd.len] = '\0';
		alt_id2_reqd.arr[alt_id2_reqd.len] = '\0';
		alt_id3_reqd.arr[alt_id3_reqd.len] = '\0';
		alt_id4_reqd.arr[alt_id4_reqd.len] = '\0';
		alt_id1_type.arr[alt_id1_type.len] = '\0';
		alt_id2_type.arr[alt_id2_type.len] = '\0';
		alt_id3_type.arr[alt_id3_type.len] = '\0';
		alt_id4_type.arr[alt_id4_type.len] = '\0';	
		
		
/*
 -- Start -- Commented by Sai Dutt on 06/03/2006 --

		if(strcmp(alt_id1_reqd.arr,"Y")==0) 
		{
			strcpy(alt_id_legend.arr, "NRIC/");
			strcat(alt_id_legend.arr,alt_id1_type.arr);
		}
		else if(strcmp(alt_id2_reqd.arr,"Y")==0) 
		{	
			strcpy(alt_id_legend.arr, "NRIC/");
			strcat(alt_id_legend.arr,alt_id2_type.arr);
		}
		else if(strcmp(alt_id3_reqd.arr,"Y")==0)
		{
			strcpy(alt_id_legend.arr, "NRIC/");
			strcat(alt_id_legend.arr,alt_id3_type.arr);
		}
		else if(strcmp(alt_id4_reqd.arr,"Y")==0) 
		{
			strcpy(alt_id_legend.arr, "NRIC/");
			strcat(alt_id_legend.arr,alt_id4_type.arr);
		}
		else
		{
			strcpy(alt_id_legend.arr, "NRIC/");
			strcat(alt_id_legend.arr,alt_id1_type.arr);
		}

 -- End -- Commented by Sai Dutt on 06/03/2006 --
 */
		//strcpy(alt_id_legend.arr, "NRIC/Altenate ID");  //commented for globalisation
		strcpy(alt_id_legend.arr, local_legend[11]);

		return;
}


/****************** FETCH TEST DESC ****************/

fetch_test()

{

	rl_test_desc.arr[0]  = '\0';
	rl_test_desc.len	 = 0;

	//EXEC SQL SELECT long_desc /***Commented on 27/04/2004 as advised by Mr. Cyrus***/
//  14.02.2006	commented against ML requirement EXEC SQL SELECT short_desc 
		   /* EXEC SQL SELECT long_desc 
	           INTO :rl_test_desc
	           FROM rl_test_code_lang_vw
	          WHERE test_code = :rl_test_code
			  AND language_id = :language_id; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 11;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select long_desc into :b0  from rl_test_code_lang_vw whe\
re (test_code=:b1 and language_id=:b2)";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )763;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&rl_test_desc;
     sqlstm.sqhstl[0] = (unsigned int  )43;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&rl_test_code;
     sqlstm.sqhstl[1] = (unsigned int  )13;
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



	rl_test_desc.arr[rl_test_desc.len]  = '\0';	

}

/********************* PRINT END OF REPORT ************************/
print_end_of_rep()
{
    int col;
    char buff[REP_WIDTH+1];
	char line1[100];

    memset(buff,' ',REP_WIDTH-11);
    col = (int)(REP_WIDTH-19)/2;

    //strncpy(buff+col,"** END OF REPORT **",19);
	sprintf(buff+col,"** %13.13s **",local_legend[12]);
    strncpy(buff,buff,strlen(buff));
	   
	print_line(REP_WIDTH+1);
    fprintf(f1,"%s\n",nd_footer_line_1.arr);		
    fprintf(f1,"%s\n",nd_footer_line_2.arr);		
	
    fprintf(f1,"\n%s\n",buff);
	fprintf(f1,"\f");  // 28.04.2003 added  

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

