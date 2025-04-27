
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
};


static unsigned int sqlctx = 1288615947;


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
            void  *sqhstv[15];
   unsigned int   sqhstl[15];
            int   sqhsts[15];
            void  *sqindv[15];
            int   sqinds[15];
   unsigned int   sqharm[15];
   unsigned int   *sqharc[15];
   unsigned short  sqadto[15];
   unsigned short  sqtdso[15];
} sqlstm = {12,15};

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

 static const char *sq0007 = 
"select A.test_code ,nvl(B.no_of_aliquot_labels,1)  from rl_request_detail A \
,rl_test_code B where (((((specimen_no=TO_NUMBER(:b0) and A.test_code=decode(:\
b1,'*A',A.test_code,:b1)) and operating_facility_id=:b3) and A.test_code=B.tes\
t_code) and NVL(B.aliquot_label_yn,'N')='Y') and NVL(cancelled_yn,'N')<>'Y')  \
         ";

 static const char *sq0009 = 
"select test_code ,TO_CHAR(specimen_no) ,seq_no  from RL_INTERVAL_TEST_SPECIM\
ENS where (((interval_test_specimen_no=TO_NUMBER(:b0) and operating_facility_i\
d=:b1) and specimen_no<>TO_NUMBER(:b0)) and test_code=:b3) order by specimen_n\
o            ";

 static const char *sq0013 = 
"select rownum ,specimen_no  from RL_INTERVAL_TEST_SPECIMENS where (interval_\
test_specimen_no=TO_NUMBER(:b0) and OPERATING_FACILITY_ID=:b1) order by specim\
en_no            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,135,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,446,0,4,172,0,0,15,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
111,0,0,3,0,0,30,242,0,0,0,0,0,1,0,
126,0,0,4,0,0,30,250,0,0,0,0,0,1,0,
141,0,0,5,124,0,4,280,0,0,3,2,0,1,0,1,9,0,0,2,9,0,0,1,9,0,0,
168,0,0,6,159,0,4,287,0,0,5,2,0,1,0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
203,0,0,7,319,0,9,316,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
234,0,0,7,0,0,13,332,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
257,0,0,7,0,0,15,381,0,0,0,0,0,1,0,
272,0,0,8,95,0,4,392,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
299,0,0,9,245,0,9,421,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
330,0,0,9,0,0,15,441,0,0,0,0,0,1,0,
345,0,0,9,0,0,13,456,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,3,0,0,
372,0,0,10,108,0,4,549,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
395,0,0,11,152,0,4,562,0,0,5,3,0,1,0,2,3,0,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
430,0,0,12,159,0,4,576,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
461,0,0,13,171,0,9,597,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
484,0,0,13,0,0,13,608,0,0,2,0,0,1,0,2,3,0,0,2,9,0,0,
507,0,0,14,135,0,4,633,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,3,0,0,1,9,0,0,
538,0,0,15,126,0,4,688,0,0,1,0,0,1,0,2,9,0,0,
557,0,0,16,224,0,3,741,0,0,3,3,0,1,0,1,9,0,0,1,3,0,0,1,9,0,0,
584,0,0,17,105,0,4,757,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
};


#line 1 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
/*
#define DEBUG
*/

#define NO_DATA_FOUND (sqlca.sqlcode == 1403)  
#define VIEW_LOG_FILE 1
#define ONLINE_PRINTING 1
#define INIT_MESG "Slide Label Printing"
#define HLINE 40  
#define VLINE 10
#define ESC 0x1B


/*#define SPACE1 0xA1 
#define SPACE2 0x40*/   

#include <stdio.h>  
#include <string.h>
#include <gl.h>
#include <math.h>

/* EXEC SQL BEGIN DECLARE SECTION; */ 
#line 22 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  

/* VARCHAR nd_operating_facility_id   [3],
        nd_facility_id		 	   [3],
        uid_pwd                    [91],
		nd_session_id              [50],
        d_specimen_no              [21],
        d_no_copy                  [4],
		d_temp_no_copy			   [4],
		nd_trx_ind		           [2],
		nd_printer_type            [2],
		nd_ws_no			       [50],

	d_patient_id           [21],
	d_section_code         [6],
	d_specimen_type_code   [5],
	d_episode_type		   [2],
	d_order_id			   [15],
	d_order_type_code	   [4],
    d_test_code            [11],
	d_urgent_indicator	   [8],
	d_pat_name             [240],
	nd_specimen_no		   [21],
	parent_spec_no		   [21],
	r_child_spec_no		   [21],
	d_desc_on_label		   [31],
	d_actual_patient_id	   [21],
	d_source_type		   [2],
	d_source_code		   [11],
	d_ref_location		   [21],
	d_description		   [21],
	er_msg                 [171],
	d_category_code		   [5],
	d_category_year		   [5],
	d_category_no		   [21],
	d_test_name			   [41],	
    //d_facility_name		   [41],
	d_facility_name		   [300],
	nd_test				   [11],
	nd_interval_test	   [11],
	language_id			   [5]; */ 
struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;
#line 24 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;
#line 25 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

struct { unsigned short len; unsigned char arr[91]; } uid_pwd;
#line 26 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

struct { unsigned short len; unsigned char arr[50]; } nd_session_id;
#line 27 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

struct { unsigned short len; unsigned char arr[21]; } d_specimen_no;
#line 28 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

struct { unsigned short len; unsigned char arr[4]; } d_no_copy;
#line 29 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

struct { unsigned short len; unsigned char arr[4]; } d_temp_no_copy;
#line 30 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

struct { unsigned short len; unsigned char arr[2]; } nd_trx_ind;
#line 31 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

struct { unsigned short len; unsigned char arr[2]; } nd_printer_type;
#line 32 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

struct { unsigned short len; unsigned char arr[50]; } nd_ws_no;
#line 33 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

struct { unsigned short len; unsigned char arr[21]; } d_patient_id;
#line 35 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

struct { unsigned short len; unsigned char arr[6]; } d_section_code;
#line 36 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

struct { unsigned short len; unsigned char arr[5]; } d_specimen_type_code;
#line 37 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

struct { unsigned short len; unsigned char arr[2]; } d_episode_type;
#line 38 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

struct { unsigned short len; unsigned char arr[15]; } d_order_id;
#line 39 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

struct { unsigned short len; unsigned char arr[4]; } d_order_type_code;
#line 40 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

struct { unsigned short len; unsigned char arr[11]; } d_test_code;
#line 41 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

struct { unsigned short len; unsigned char arr[8]; } d_urgent_indicator;
#line 42 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

struct { unsigned short len; unsigned char arr[240]; } d_pat_name;
#line 43 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

struct { unsigned short len; unsigned char arr[21]; } nd_specimen_no;
#line 44 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

struct { unsigned short len; unsigned char arr[21]; } parent_spec_no;
#line 45 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

struct { unsigned short len; unsigned char arr[21]; } r_child_spec_no;
#line 46 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

struct { unsigned short len; unsigned char arr[31]; } d_desc_on_label;
#line 47 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

struct { unsigned short len; unsigned char arr[21]; } d_actual_patient_id;
#line 48 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

struct { unsigned short len; unsigned char arr[2]; } d_source_type;
#line 49 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

struct { unsigned short len; unsigned char arr[11]; } d_source_code;
#line 50 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

struct { unsigned short len; unsigned char arr[21]; } d_ref_location;
#line 51 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

struct { unsigned short len; unsigned char arr[21]; } d_description;
#line 52 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

struct { unsigned short len; unsigned char arr[171]; } er_msg;
#line 53 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

struct { unsigned short len; unsigned char arr[5]; } d_category_code;
#line 54 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

struct { unsigned short len; unsigned char arr[5]; } d_category_year;
#line 55 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

struct { unsigned short len; unsigned char arr[21]; } d_category_no;
#line 56 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

struct { unsigned short len; unsigned char arr[41]; } d_test_name;
#line 57 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

struct { unsigned short len; unsigned char arr[300]; } d_facility_name;
#line 59 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

struct { unsigned short len; unsigned char arr[11]; } nd_test;
#line 60 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

struct { unsigned short len; unsigned char arr[11]; } nd_interval_test;
#line 61 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

struct { unsigned short len; unsigned char arr[5]; } language_id;
#line 62 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 //added for globalisation

 char string_var [100];
       

/*tern  char WORKING_DIR_NAME [75];*/

		int er_msg_type = 0;	
		int err_flag = 0;

		int d_count = 0;
		int i_count = 0;

/* EXEC SQL END DECLARE SECTION; */ 
#line 75 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"


/* EXEC SQL INCLUDE SQLCA.H;
 */ 
#line 1 "C:\\Oracle\\Middleware\\Oracle_FRHome1\\precomp\\public\\SQLCA.H"
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
#line 1 "C:\\Oracle\\Middleware\\Oracle_FRHome1\\precomp\\public\\SQLDA.H"
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




#line 79 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
#include <winproc.h>

FILE *f1;
char filename[150];
char nd_filename[150];

  char  *command;
  int i,s1,hosp_nm_len;

  char gtt_yn = 'N';

void proc_main(argc,argv)
int argc;
char *argv[];
{

   void dclr_cur();

/**** newly added on 14/01/2003 to suppress the error messages ***/
  	err_flag = 0;  

  if(argc < 11) 
  {
    ins_message(ERR_MESG,"rlrslilb : Usage -  arguments wrong\n");
  }

    strcpy(uid_pwd.arr,argv[1]);
    uid_pwd.len = strlen(uid_pwd.arr);

    strcpy(nd_session_id.arr, argv[2]);
    nd_session_id.len = strlen(nd_session_id.arr);


    strcpy(nd_facility_id.arr, argv[4]);
	nd_facility_id.len = strlen(nd_facility_id.arr);

    strcpy(d_specimen_no.arr,argv[5]);
    d_specimen_no.len = strlen(d_specimen_no.arr);

	strcpy(d_section_code.arr,argv[6]);
    d_section_code.len = strlen(d_section_code.arr);

	strcpy(d_no_copy.arr,argv[7]);
    d_no_copy.len = strlen(d_no_copy.arr);

   	strcpy(nd_printer_type.arr, argv[8]);
    nd_printer_type.len = strlen(nd_printer_type.arr); 

	strcpy(nd_ws_no.arr, argv[9]);
    nd_ws_no.len = strlen(nd_ws_no.arr); 

	strcpy(nd_test.arr, argv[10]);
    nd_test.len = strlen(nd_test.arr); 

	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 
#line 133 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"


    /* EXEC SQL CONNECT :uid_pwd; */ 
#line 135 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

{
#line 135 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
    struct sqlexd sqlstm;
#line 135 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
    sqlstm.sqlvsn = 12;
#line 135 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
    sqlstm.arrsiz = 4;
#line 135 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
    sqlstm.sqladtp = &sqladt;
#line 135 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
    sqlstm.sqltdsp = &sqltds;
#line 135 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
    sqlstm.iters = (unsigned int  )10;
#line 135 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
    sqlstm.offset = (unsigned int  )5;
#line 135 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
    sqlstm.cud = sqlcud0;
#line 135 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
    sqlstm.sqlest = (unsigned char  *)&sqlca;
#line 135 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
    sqlstm.sqlety = (unsigned short)4352;
#line 135 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
    sqlstm.occurs = (unsigned int  )0;
#line 135 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
    sqlstm.sqhstv[0] = (         void  *)&uid_pwd;
#line 135 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
    sqlstm.sqhstl[0] = (unsigned int  )93;
#line 135 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
    sqlstm.sqhsts[0] = (         int  )93;
#line 135 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
    sqlstm.sqindv[0] = (         void  *)0;
#line 135 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
    sqlstm.sqinds[0] = (         int  )0;
#line 135 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
    sqlstm.sqharm[0] = (unsigned int  )0;
#line 135 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
    sqlstm.sqadto[0] = (unsigned short )0;
#line 135 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
    sqlstm.sqtdso[0] = (unsigned short )0;
#line 135 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
    sqlstm.sqphsv = sqlstm.sqhstv;
#line 135 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
    sqlstm.sqphsl = sqlstm.sqhstl;
#line 135 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
    sqlstm.sqphss = sqlstm.sqhsts;
#line 135 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
    sqlstm.sqpind = sqlstm.sqindv;
#line 135 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
    sqlstm.sqpins = sqlstm.sqinds;
#line 135 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
    sqlstm.sqparm = sqlstm.sqharm;
#line 135 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
    sqlstm.sqparc = sqlstm.sqharc;
#line 135 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
    sqlstm.sqpadto = sqlstm.sqadto;
#line 135 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
    sqlstm.sqptdso = sqlstm.sqtdso;
#line 135 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
    sqlstm.sqlcmax = (unsigned int )100;
#line 135 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
    sqlstm.sqlcmin = (unsigned int )2;
#line 135 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
    sqlstm.sqlcincr = (unsigned int )1;
#line 135 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
    sqlstm.sqlctimeout = (unsigned int )0;
#line 135 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
    sqlstm.sqlcnowait = (unsigned int )0;
#line 135 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
#line 135 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
    if (sqlca.sqlcode < 0) goto err_exit;
#line 135 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
}

#line 135 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"


	/*
	* Enable or Disable tracing
	*/
	EnableOrDisableTracing();

    set_meduser_role();

/*********************** added for globalisation ******************************/
    strcpy(language_id.arr,l_language_id.arr);
	language_id.len =l_language_id.len;
	language_id.arr[l_language_id.len]='\0';
/*********************** added for globalisation ******************************/

	d_patient_id.arr[0]				= '\0';
	d_patient_id.len				= 0;
	d_episode_type.arr[0]			= '\0';
	d_episode_type.len				= 0;
	d_specimen_type_code.arr[0]		= '\0';
	d_specimen_type_code.len		= 0;
	d_urgent_indicator.arr[0]		= '\0';
	d_urgent_indicator.len			= 0;
	d_source_code.arr[0]			= '\0';
	d_source_code.len				= 0;
	d_source_type.arr[0]			= '\0';
	d_source_type.len				= 0;
	d_category_code.arr[0]			= '\0';
	d_category_code.len				= 0;
	d_category_year.arr[0]			= '\0';
	d_category_year.len				= 0;
	d_category_no.arr[0]			= '\0';
	d_category_no.len				= 0;
	nd_operating_facility_id.arr[0]	= '\0';
	nd_operating_facility_id.len	= 0;  
	    	
    
	/* EXEC SQL SELECT operating_facility_id,patient_id, specimen_type_code, episode_type,
				   DECODE(urgent_indicator,'S','ST','U','UR','RO'), 
				   order_type_code, 
					order_id, source_code, source_type,
					SUBSTR(category_code, 1, 4), SUBSTR(category_year, 3, 2), 
					SUBSTR(category_number, 1, 10)
			 INTO :nd_operating_facility_id,:d_patient_id, :d_specimen_type_code,
				  :d_episode_type,
				  :d_urgent_indicator, :d_order_type_code,
				  :d_order_id, :d_source_code, :d_source_type,
				  :d_category_code, :d_category_year, :d_category_no
			 FROM rl_request_header
			 WHERE specimen_no = TO_NUMBER(:d_specimen_no)
			 AND OPERATING_FACILITY_ID = DECODE(:nd_facility_id,'*A',OPERATING_FACILITY_ID,
         										                   :nd_facility_id); */ 
#line 186 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

{
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 struct sqlexd sqlstm;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqlvsn = 12;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.arrsiz = 15;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqladtp = &sqladt;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqltdsp = &sqltds;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.stmt = "select operating_facility_id ,patient_id ,specimen_type_code\
 ,episode_type ,DECODE(urgent_indicator,'S','ST','U','UR','RO') ,order_type_co\
de ,order_id ,source_code ,source_type ,SUBSTR(category_code,1,4) ,SUBSTR(cate\
gory_year,3,2) ,SUBSTR(category_number,1,10) into :b0,:b1,:b2,:b3,:b4,:b5,:b6,\
:b7,:b8,:b9,:b10,:b11  from rl_request_header where (specimen_no=TO_NUMBER(:b1\
2) and OPERATING_FACILITY_ID=DECODE(:b13,'*A',OPERATING_FACILITY_ID,:b13))";
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.iters = (unsigned int  )1;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.offset = (unsigned int  )36;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.selerr = (unsigned short)1;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.cud = sqlcud0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqlest = (unsigned char  *)&sqlca;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqlety = (unsigned short)4352;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.occurs = (unsigned int  )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstl[0] = (unsigned int  )5;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhsts[0] = (         int  )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqindv[0] = (         void  *)0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqinds[0] = (         int  )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqharm[0] = (unsigned int  )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqadto[0] = (unsigned short )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqtdso[0] = (unsigned short )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstv[1] = (         void  *)&d_patient_id;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstl[1] = (unsigned int  )23;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhsts[1] = (         int  )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqindv[1] = (         void  *)0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqinds[1] = (         int  )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqharm[1] = (unsigned int  )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqadto[1] = (unsigned short )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqtdso[1] = (unsigned short )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstv[2] = (         void  *)&d_specimen_type_code;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstl[2] = (unsigned int  )7;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhsts[2] = (         int  )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqindv[2] = (         void  *)0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqinds[2] = (         int  )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqharm[2] = (unsigned int  )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqadto[2] = (unsigned short )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqtdso[2] = (unsigned short )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstv[3] = (         void  *)&d_episode_type;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstl[3] = (unsigned int  )4;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhsts[3] = (         int  )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqindv[3] = (         void  *)0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqinds[3] = (         int  )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqharm[3] = (unsigned int  )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqadto[3] = (unsigned short )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqtdso[3] = (unsigned short )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstv[4] = (         void  *)&d_urgent_indicator;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstl[4] = (unsigned int  )10;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhsts[4] = (         int  )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqindv[4] = (         void  *)0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqinds[4] = (         int  )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqharm[4] = (unsigned int  )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqadto[4] = (unsigned short )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqtdso[4] = (unsigned short )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstv[5] = (         void  *)&d_order_type_code;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstl[5] = (unsigned int  )6;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhsts[5] = (         int  )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqindv[5] = (         void  *)0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqinds[5] = (         int  )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqharm[5] = (unsigned int  )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqadto[5] = (unsigned short )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqtdso[5] = (unsigned short )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstv[6] = (         void  *)&d_order_id;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstl[6] = (unsigned int  )17;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhsts[6] = (         int  )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqindv[6] = (         void  *)0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqinds[6] = (         int  )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqharm[6] = (unsigned int  )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqadto[6] = (unsigned short )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqtdso[6] = (unsigned short )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstv[7] = (         void  *)&d_source_code;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstl[7] = (unsigned int  )13;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhsts[7] = (         int  )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqindv[7] = (         void  *)0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqinds[7] = (         int  )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqharm[7] = (unsigned int  )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqadto[7] = (unsigned short )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqtdso[7] = (unsigned short )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstv[8] = (         void  *)&d_source_type;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstl[8] = (unsigned int  )4;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhsts[8] = (         int  )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqindv[8] = (         void  *)0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqinds[8] = (         int  )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqharm[8] = (unsigned int  )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqadto[8] = (unsigned short )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqtdso[8] = (unsigned short )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstv[9] = (         void  *)&d_category_code;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstl[9] = (unsigned int  )7;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhsts[9] = (         int  )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqindv[9] = (         void  *)0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqinds[9] = (         int  )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqharm[9] = (unsigned int  )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqadto[9] = (unsigned short )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqtdso[9] = (unsigned short )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstv[10] = (         void  *)&d_category_year;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstl[10] = (unsigned int  )7;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhsts[10] = (         int  )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqindv[10] = (         void  *)0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqinds[10] = (         int  )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqharm[10] = (unsigned int  )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqadto[10] = (unsigned short )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqtdso[10] = (unsigned short )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstv[11] = (         void  *)&d_category_no;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstl[11] = (unsigned int  )23;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhsts[11] = (         int  )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqindv[11] = (         void  *)0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqinds[11] = (         int  )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqharm[11] = (unsigned int  )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqadto[11] = (unsigned short )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqtdso[11] = (unsigned short )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstv[12] = (         void  *)&d_specimen_no;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstl[12] = (unsigned int  )23;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhsts[12] = (         int  )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqindv[12] = (         void  *)0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqinds[12] = (         int  )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqharm[12] = (unsigned int  )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqadto[12] = (unsigned short )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqtdso[12] = (unsigned short )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstv[13] = (         void  *)&nd_facility_id;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstl[13] = (unsigned int  )5;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhsts[13] = (         int  )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqindv[13] = (         void  *)0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqinds[13] = (         int  )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqharm[13] = (unsigned int  )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqadto[13] = (unsigned short )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqtdso[13] = (unsigned short )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstv[14] = (         void  *)&nd_facility_id;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstl[14] = (unsigned int  )5;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhsts[14] = (         int  )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqindv[14] = (         void  *)0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqinds[14] = (         int  )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqharm[14] = (unsigned int  )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqadto[14] = (unsigned short )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqtdso[14] = (unsigned short )0;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqphsv = sqlstm.sqhstv;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqphsl = sqlstm.sqhstl;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqphss = sqlstm.sqhsts;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqpind = sqlstm.sqindv;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqpins = sqlstm.sqinds;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqparm = sqlstm.sqharm;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqparc = sqlstm.sqharc;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqpadto = sqlstm.sqadto;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqptdso = sqlstm.sqtdso;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 if (sqlca.sqlcode < 0) goto err_exit;
#line 172 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
}

#line 186 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"


 	 d_order_type_code.arr[d_order_type_code.len]		= '\0';
	 d_order_id.arr[d_order_id.len]						= '\0';
	 d_patient_id.arr[d_patient_id.len]					= '\0';
	 d_episode_type.arr[d_episode_type.len]				= '\0';
	 d_specimen_type_code.arr[d_specimen_type_code.len]	= '\0';
	 d_urgent_indicator.arr[d_urgent_indicator.len]		= '\0';
	 d_source_code.arr[d_source_code.len]				= '\0';
	 d_source_type.arr[d_source_type.len]				= '\0';
 	 d_category_code.arr[d_category_code.len]			= '\0';
	 d_category_year.arr[d_category_year.len]			= '\0';
	 d_category_no.arr[d_category_no.len]				= '\0';
	 nd_operating_facility_id.arr[nd_operating_facility_id.len]	= '\0';

	
	 if(NO_DATA_FOUND)
	 {
		sprintf(string_var,"%s -> %s\n",d_specimen_no.arr, 
									sqlca.sqlerrm.sqlerrmc);
		ins_message(ERR_MESG, string_var);
     }

	 gen_file_name();
	 get_facility_name(); // Added on 30/06/2004

   	 dclr_cur();

	 //get_specimen_label();

	 get_patient_details();

	 d_count = 0;

    if (strcmp(nd_printer_type.arr,"3")!= 0)
	   set_fonts();

	//print_label(); Moved to inside "print_test_code()"

    get_trans_ind();

	print_test_code();

	fclose(f1);

	fprintf(f1, "%cE", ESC);

	if (strcmp(nd_printer_type.arr,"3")!= 0)
	   set_fonts();

	if (err_flag == 0 && i_count> 0 )
	 {  
		print_interval_specimens();
	 }


    /* EXEC SQL COMMIT WORK RELEASE; */ 
#line 242 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

{
#line 242 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
    struct sqlexd sqlstm;
#line 242 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
    sqlstm.sqlvsn = 12;
#line 242 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
    sqlstm.arrsiz = 15;
#line 242 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
    sqlstm.sqladtp = &sqladt;
#line 242 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
    sqlstm.sqltdsp = &sqltds;
#line 242 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
    sqlstm.iters = (unsigned int  )1;
#line 242 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
    sqlstm.offset = (unsigned int  )111;
#line 242 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
    sqlstm.cud = sqlcud0;
#line 242 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
    sqlstm.sqlest = (unsigned char  *)&sqlca;
#line 242 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
    sqlstm.sqlety = (unsigned short)4352;
#line 242 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
    sqlstm.occurs = (unsigned int  )0;
#line 242 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
#line 242 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
    if (sqlca.sqlcode < 0) goto err_exit;
#line 242 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
}

#line 242 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

    return;

err_exit:
    /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 
#line 246 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

	// EXEC SQL ROLLBACK WORK RELEASE;
    sprintf(string_var,"%s -> %s\n",d_specimen_no.arr, sqlca.sqlerrm.sqlerrmc);
    ins_message(ORA_MESG,string_var);
	/* EXEC SQL COMMIT WORK RELEASE; */ 
#line 250 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

{
#line 250 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 struct sqlexd sqlstm;
#line 250 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqlvsn = 12;
#line 250 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.arrsiz = 15;
#line 250 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqladtp = &sqladt;
#line 250 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqltdsp = &sqltds;
#line 250 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.iters = (unsigned int  )1;
#line 250 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.offset = (unsigned int  )126;
#line 250 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.cud = sqlcud0;
#line 250 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqlest = (unsigned char  *)&sqlca;
#line 250 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqlety = (unsigned short)4352;
#line 250 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.occurs = (unsigned int  )0;
#line 250 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
#line 250 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
}

#line 250 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

}

get_patient_details()
{

	d_pat_name.arr[0]				= '\0';
	d_actual_patient_id.arr[0]		= '\0';
	d_ref_location.arr[0]			= '\0';

	d_actual_patient_id.len			= 0;
	d_pat_name.len					= 0;
	d_ref_location.len				= 0;

	if (strcmp(d_episode_type.arr, "I") == 0 || 
				strcmp(d_episode_type.arr, "O") == 0 ||
				strcmp(d_episode_type.arr, "H") == 0)
	{
/*

DECODE(substr(SHORT_NAME_LOC_LANG,1,15),			    
						     NULL, SHORT_NAME,
							 SHORT_NAME_LOC_LANG)
*/
/*
DECODE(substr(SHORT_NAME_LOC_LANG,1,30),			    
						     NULL, SHORT_NAME,
							 SHORT_NAME_LOC_LANG)
*/
/*** CHANGED ON 21/11/2002 AS PER REQUEST  FROM THE SITE ****/
			/* EXEC SQL SELECT SUBSTR(DECODE(:language_id, 'en', SHORT_NAME, 'th', SHORT_NAME_LOC_LANG), 1, 30)
					 INTO :d_pat_name
					 FROM MP_PATIENT_MAST
					 WHERE PATIENT_ID = :d_patient_id; */ 
#line 283 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

{
#line 280 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   struct sqlexd sqlstm;
#line 280 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqlvsn = 12;
#line 280 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.arrsiz = 15;
#line 280 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqladtp = &sqladt;
#line 280 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqltdsp = &sqltds;
#line 280 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.stmt = "select SUBSTR(DECODE(:b0,'en',SHORT_NAME,'th',SHORT_NAME_L\
OC_LANG),1,30) into :b1  from MP_PATIENT_MAST where PATIENT_ID=:b2";
#line 280 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.iters = (unsigned int  )1;
#line 280 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.offset = (unsigned int  )141;
#line 280 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.selerr = (unsigned short)1;
#line 280 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.cud = sqlcud0;
#line 280 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqlest = (unsigned char  *)&sqlca;
#line 280 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqlety = (unsigned short)4352;
#line 280 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.occurs = (unsigned int  )0;
#line 280 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqhstv[0] = (         void  *)&language_id;
#line 280 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqhstl[0] = (unsigned int  )7;
#line 280 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqhsts[0] = (         int  )0;
#line 280 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqindv[0] = (         void  *)0;
#line 280 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqinds[0] = (         int  )0;
#line 280 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqharm[0] = (unsigned int  )0;
#line 280 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqadto[0] = (unsigned short )0;
#line 280 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqtdso[0] = (unsigned short )0;
#line 280 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqhstv[1] = (         void  *)&d_pat_name;
#line 280 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqhstl[1] = (unsigned int  )242;
#line 280 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqhsts[1] = (         int  )0;
#line 280 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqindv[1] = (         void  *)0;
#line 280 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqinds[1] = (         int  )0;
#line 280 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqharm[1] = (unsigned int  )0;
#line 280 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqadto[1] = (unsigned short )0;
#line 280 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqtdso[1] = (unsigned short )0;
#line 280 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqhstv[2] = (         void  *)&d_patient_id;
#line 280 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqhstl[2] = (unsigned int  )23;
#line 280 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqhsts[2] = (         int  )0;
#line 280 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqindv[2] = (         void  *)0;
#line 280 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqinds[2] = (         int  )0;
#line 280 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqharm[2] = (unsigned int  )0;
#line 280 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqadto[2] = (unsigned short )0;
#line 280 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqtdso[2] = (unsigned short )0;
#line 280 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqphsv = sqlstm.sqhstv;
#line 280 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqphsl = sqlstm.sqhstl;
#line 280 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqphss = sqlstm.sqhsts;
#line 280 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqpind = sqlstm.sqindv;
#line 280 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqpins = sqlstm.sqinds;
#line 280 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqparm = sqlstm.sqharm;
#line 280 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqparc = sqlstm.sqharc;
#line 280 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqpadto = sqlstm.sqadto;
#line 280 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqptdso = sqlstm.sqtdso;
#line 280 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
#line 280 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
}

#line 283 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

	}
	else
	{
			/* EXEC SQL SELECT DECODE(:language_id, 'en', SHORT_NAME, 'th', SHORT_NAME_LOC_LANG) short_name, 
						actual_patient_id, location
					 INTO :d_pat_name, d_actual_patient_id, :d_ref_location
					 FROM RL_PATIENT_MAST
					 WHERE PATIENT_ID = :d_patient_id; */ 
#line 291 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

{
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   struct sqlexd sqlstm;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqlvsn = 12;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.arrsiz = 15;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqladtp = &sqladt;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqltdsp = &sqltds;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.stmt = "select DECODE(:b0,'en',SHORT_NAME,'th',SHORT_NAME_LOC_LANG\
) short_name ,actual_patient_id ,location into :b1,:b2,:b3  from RL_PATIENT_MA\
ST where PATIENT_ID=:b4";
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.iters = (unsigned int  )1;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.offset = (unsigned int  )168;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.selerr = (unsigned short)1;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.cud = sqlcud0;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqlest = (unsigned char  *)&sqlca;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqlety = (unsigned short)4352;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.occurs = (unsigned int  )0;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqhstv[0] = (         void  *)&language_id;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqhstl[0] = (unsigned int  )7;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqhsts[0] = (         int  )0;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqindv[0] = (         void  *)0;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqinds[0] = (         int  )0;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqharm[0] = (unsigned int  )0;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqadto[0] = (unsigned short )0;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqtdso[0] = (unsigned short )0;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqhstv[1] = (         void  *)&d_pat_name;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqhstl[1] = (unsigned int  )242;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqhsts[1] = (         int  )0;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqindv[1] = (         void  *)0;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqinds[1] = (         int  )0;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqharm[1] = (unsigned int  )0;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqadto[1] = (unsigned short )0;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqtdso[1] = (unsigned short )0;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqhstv[2] = (         void  *)&d_actual_patient_id;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqhstl[2] = (unsigned int  )23;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqhsts[2] = (         int  )0;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqindv[2] = (         void  *)0;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqinds[2] = (         int  )0;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqharm[2] = (unsigned int  )0;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqadto[2] = (unsigned short )0;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqtdso[2] = (unsigned short )0;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqhstv[3] = (         void  *)&d_ref_location;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqhstl[3] = (unsigned int  )23;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqhsts[3] = (         int  )0;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqindv[3] = (         void  *)0;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqinds[3] = (         int  )0;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqharm[3] = (unsigned int  )0;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqadto[3] = (unsigned short )0;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqtdso[3] = (unsigned short )0;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqhstv[4] = (         void  *)&d_patient_id;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqhstl[4] = (unsigned int  )23;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqhsts[4] = (         int  )0;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqindv[4] = (         void  *)0;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqinds[4] = (         int  )0;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqharm[4] = (unsigned int  )0;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqadto[4] = (unsigned short )0;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqtdso[4] = (unsigned short )0;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqphsv = sqlstm.sqhstv;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqphsl = sqlstm.sqhstl;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqphss = sqlstm.sqhsts;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqpind = sqlstm.sqindv;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqpins = sqlstm.sqinds;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqparm = sqlstm.sqharm;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqparc = sqlstm.sqharc;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqpadto = sqlstm.sqadto;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqptdso = sqlstm.sqtdso;
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
#line 287 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
}

#line 291 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

					 /* AND OPERATING_FACILITY_ID = :nd_operating_facility_id; */
	}

 

	d_pat_name.arr[d_pat_name.len]						= '\0';
	d_actual_patient_id.arr[d_actual_patient_id.len]	= '\0';
	d_ref_location.arr[d_ref_location.len]				= '\0';

}

void dclr_cur()
{
 
		/* EXEC SQL DECLARE c1 CURSOR FOR
			     SELECT A.test_code,nvl(B.no_of_aliquot_labels,1) 
				 FROM rl_request_detail A, rl_test_code B
				 WHERE specimen_no = TO_NUMBER(:d_specimen_no)
				 AND A.test_code = decode(:nd_test,'*A',A.test_code,:nd_test)
				 AND operating_facility_id = :nd_operating_facility_id
				 AND A.test_code = B.test_code
				 AND NVL(B.aliquot_label_yn,'N') = 'Y'
				 AND NVL(cancelled_yn, 'N') <> 'Y'; */ 
#line 314 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"


		/* EXEC SQL OPEN c1; */ 
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

{
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  struct sqlexd sqlstm;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqlvsn = 12;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.arrsiz = 15;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqladtp = &sqladt;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqltdsp = &sqltds;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.stmt = sq0007;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.iters = (unsigned int  )1;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.offset = (unsigned int  )203;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.selerr = (unsigned short)1;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.cud = sqlcud0;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqlest = (unsigned char  *)&sqlca;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqlety = (unsigned short)4352;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.occurs = (unsigned int  )0;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqcmod = (unsigned int )0;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqhstv[0] = (         void  *)&d_specimen_no;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqhstl[0] = (unsigned int  )23;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqhsts[0] = (         int  )0;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqindv[0] = (         void  *)0;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqinds[0] = (         int  )0;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqharm[0] = (unsigned int  )0;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqadto[0] = (unsigned short )0;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqtdso[0] = (unsigned short )0;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqhstv[1] = (         void  *)&nd_test;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqhstl[1] = (unsigned int  )13;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqhsts[1] = (         int  )0;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqindv[1] = (         void  *)0;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqinds[1] = (         int  )0;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqharm[1] = (unsigned int  )0;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqadto[1] = (unsigned short )0;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqtdso[1] = (unsigned short )0;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqhstv[2] = (         void  *)&nd_test;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqhstl[2] = (unsigned int  )13;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqhsts[2] = (         int  )0;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqindv[2] = (         void  *)0;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqinds[2] = (         int  )0;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqharm[2] = (unsigned int  )0;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqadto[2] = (unsigned short )0;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqtdso[2] = (unsigned short )0;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqhstl[3] = (unsigned int  )5;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqhsts[3] = (         int  )0;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqindv[3] = (         void  *)0;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqinds[3] = (         int  )0;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqharm[3] = (unsigned int  )0;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqadto[3] = (unsigned short )0;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqtdso[3] = (unsigned short )0;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqphsv = sqlstm.sqhstv;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqphsl = sqlstm.sqhstl;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqphss = sqlstm.sqhsts;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqpind = sqlstm.sqindv;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqpins = sqlstm.sqinds;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqparm = sqlstm.sqharm;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqparc = sqlstm.sqharc;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqpadto = sqlstm.sqadto;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqptdso = sqlstm.sqtdso;
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
}

#line 316 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

		

     return;
}


int fetch_test_code()
{

	d_test_code.arr[0]		= '\0';
	d_test_code.len			= 0;

	d_temp_no_copy.arr[0]		= '\0';
	d_temp_no_copy.len			= 0; 

      /* EXEC SQL FETCH c1 INTO :d_test_code,:d_temp_no_copy; */ 
#line 332 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

{
#line 332 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      struct sqlexd sqlstm;
#line 332 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqlvsn = 12;
#line 332 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.arrsiz = 15;
#line 332 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqladtp = &sqladt;
#line 332 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqltdsp = &sqltds;
#line 332 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.iters = (unsigned int  )1;
#line 332 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.offset = (unsigned int  )234;
#line 332 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.selerr = (unsigned short)1;
#line 332 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.cud = sqlcud0;
#line 332 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqlest = (unsigned char  *)&sqlca;
#line 332 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqlety = (unsigned short)4352;
#line 332 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.occurs = (unsigned int  )0;
#line 332 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqfoff = (           int )0;
#line 332 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqfmod = (unsigned int )2;
#line 332 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqhstv[0] = (         void  *)&d_test_code;
#line 332 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqhstl[0] = (unsigned int  )13;
#line 332 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqhsts[0] = (         int  )0;
#line 332 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqindv[0] = (         void  *)0;
#line 332 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqinds[0] = (         int  )0;
#line 332 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqharm[0] = (unsigned int  )0;
#line 332 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqadto[0] = (unsigned short )0;
#line 332 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqtdso[0] = (unsigned short )0;
#line 332 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqhstv[1] = (         void  *)&d_temp_no_copy;
#line 332 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqhstl[1] = (unsigned int  )6;
#line 332 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqhsts[1] = (         int  )0;
#line 332 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqindv[1] = (         void  *)0;
#line 332 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqinds[1] = (         int  )0;
#line 332 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqharm[1] = (unsigned int  )0;
#line 332 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqadto[1] = (unsigned short )0;
#line 332 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqtdso[1] = (unsigned short )0;
#line 332 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqphsv = sqlstm.sqhstv;
#line 332 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqphsl = sqlstm.sqhstl;
#line 332 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqphss = sqlstm.sqhsts;
#line 332 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqpind = sqlstm.sqindv;
#line 332 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqpins = sqlstm.sqinds;
#line 332 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqparm = sqlstm.sqharm;
#line 332 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqparc = sqlstm.sqharc;
#line 332 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqpadto = sqlstm.sqadto;
#line 332 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqptdso = sqlstm.sqtdso;
#line 332 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
#line 332 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
}

#line 332 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

 
    if (OERROR)
	{
		sprintf(string_var,"%s  fetch_test_code() -> %s\n", d_specimen_no.arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
     }

	 if (NO_DATA_FOUND)
        return 0;
  
    d_test_code.arr[d_test_code.len]	      = '\0';
    d_temp_no_copy.arr[d_temp_no_copy.len]    = '\0';
	strcpy(d_no_copy.arr,d_temp_no_copy.arr);
	d_no_copy.len = strlen(d_no_copy.arr);  

    return 1;
  
}


print_test_code()
{
   int test_code ;
   int count = 1;
   int spaces ;

   test_code = fetch_test_code();
 
   while(test_code)
   {
	
		print_file();
	
		if (i_count == 0)
		{
			get_interval_test();	
			//get_interval_desc();
			if (i_count> 0)
			{
			   strcpy(nd_interval_test.arr,d_test_code.arr);	
			   nd_interval_test.len = strlen(nd_interval_test.arr);
		    }
		}

    test_code = fetch_test_code();
	
   }

	/* EXEC SQL CLOSE c1; */ 
#line 381 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

{
#line 381 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 struct sqlexd sqlstm;
#line 381 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqlvsn = 12;
#line 381 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.arrsiz = 15;
#line 381 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqladtp = &sqladt;
#line 381 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqltdsp = &sqltds;
#line 381 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.iters = (unsigned int  )1;
#line 381 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.offset = (unsigned int  )257;
#line 381 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.cud = sqlcud0;
#line 381 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqlest = (unsigned char  *)&sqlca;
#line 381 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqlety = (unsigned short)4352;
#line 381 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.occurs = (unsigned int  )0;
#line 381 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
#line 381 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
}

#line 381 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

    
}


get_testname()
{

     d_test_name.arr[0] = '\0';
	 d_test_name.len    = 0;

	 /* EXEC SQL SELECT SHORT_DESC
	            INTO :d_test_name
				FROM RL_TEST_CODE_lang_vw
			   WHERE TEST_CODE = :d_test_code
			   and language_id = :language_id; */ 
#line 396 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

{
#line 392 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  struct sqlexd sqlstm;
#line 392 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqlvsn = 12;
#line 392 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.arrsiz = 15;
#line 392 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqladtp = &sqladt;
#line 392 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqltdsp = &sqltds;
#line 392 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.stmt = "select SHORT_DESC into :b0  from RL_TEST_CODE_lang_vw where\
 (TEST_CODE=:b1 and language_id=:b2)";
#line 392 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.iters = (unsigned int  )1;
#line 392 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.offset = (unsigned int  )272;
#line 392 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.selerr = (unsigned short)1;
#line 392 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.cud = sqlcud0;
#line 392 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqlest = (unsigned char  *)&sqlca;
#line 392 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqlety = (unsigned short)4352;
#line 392 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.occurs = (unsigned int  )0;
#line 392 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqhstv[0] = (         void  *)&d_test_name;
#line 392 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqhstl[0] = (unsigned int  )43;
#line 392 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqhsts[0] = (         int  )0;
#line 392 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqindv[0] = (         void  *)0;
#line 392 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqinds[0] = (         int  )0;
#line 392 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqharm[0] = (unsigned int  )0;
#line 392 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqadto[0] = (unsigned short )0;
#line 392 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqtdso[0] = (unsigned short )0;
#line 392 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqhstv[1] = (         void  *)&d_test_code;
#line 392 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqhstl[1] = (unsigned int  )13;
#line 392 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqhsts[1] = (         int  )0;
#line 392 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqindv[1] = (         void  *)0;
#line 392 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqinds[1] = (         int  )0;
#line 392 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqharm[1] = (unsigned int  )0;
#line 392 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqadto[1] = (unsigned short )0;
#line 392 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqtdso[1] = (unsigned short )0;
#line 392 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqhstv[2] = (         void  *)&language_id;
#line 392 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqhstl[2] = (unsigned int  )7;
#line 392 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqhsts[2] = (         int  )0;
#line 392 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqindv[2] = (         void  *)0;
#line 392 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqinds[2] = (         int  )0;
#line 392 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqharm[2] = (unsigned int  )0;
#line 392 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqadto[2] = (unsigned short )0;
#line 392 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqtdso[2] = (unsigned short )0;
#line 392 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqphsv = sqlstm.sqhstv;
#line 392 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqphsl = sqlstm.sqhstl;
#line 392 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqphss = sqlstm.sqhsts;
#line 392 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqpind = sqlstm.sqindv;
#line 392 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqpins = sqlstm.sqinds;
#line 392 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqparm = sqlstm.sqharm;
#line 392 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqparc = sqlstm.sqharc;
#line 392 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqpadto = sqlstm.sqadto;
#line 392 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqptdso = sqlstm.sqtdso;
#line 392 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
#line 392 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
}

#line 396 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"



	if(OERROR)
	{
		sprintf(string_var,"%s get_testname()-> %s\n", d_specimen_no.arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
	}

	d_test_name.arr[d_test_name.len] = '\0';

}


print_interval_specimens()
{

    /* EXEC SQL DECLARE interval_curs CURSOR FOR
			SELECT test_code, TO_CHAR(specimen_no), seq_no
		    FROM RL_INTERVAL_TEST_SPECIMENS
			WHERE interval_test_specimen_no = TO_NUMBER(:d_specimen_no)
			AND operating_facility_id = :nd_operating_facility_id
			AND specimen_no <> TO_NUMBER(:d_specimen_no)
			AND test_code = :nd_interval_test
			ORDER BY specimen_no; */ 
#line 420 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

	/* EXEC SQL OPEN interval_curs; */ 
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

{
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 struct sqlexd sqlstm;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqlvsn = 12;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.arrsiz = 15;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqladtp = &sqladt;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqltdsp = &sqltds;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.stmt = sq0009;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.iters = (unsigned int  )1;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.offset = (unsigned int  )299;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.selerr = (unsigned short)1;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.cud = sqlcud0;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqlest = (unsigned char  *)&sqlca;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqlety = (unsigned short)4352;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.occurs = (unsigned int  )0;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqcmod = (unsigned int )0;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstv[0] = (         void  *)&d_specimen_no;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstl[0] = (unsigned int  )23;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhsts[0] = (         int  )0;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqindv[0] = (         void  *)0;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqinds[0] = (         int  )0;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqharm[0] = (unsigned int  )0;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqadto[0] = (unsigned short )0;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqtdso[0] = (unsigned short )0;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstl[1] = (unsigned int  )5;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhsts[1] = (         int  )0;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqindv[1] = (         void  *)0;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqinds[1] = (         int  )0;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqharm[1] = (unsigned int  )0;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqadto[1] = (unsigned short )0;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqtdso[1] = (unsigned short )0;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstv[2] = (         void  *)&d_specimen_no;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstl[2] = (unsigned int  )23;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhsts[2] = (         int  )0;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqindv[2] = (         void  *)0;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqinds[2] = (         int  )0;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqharm[2] = (unsigned int  )0;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqadto[2] = (unsigned short )0;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqtdso[2] = (unsigned short )0;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstv[3] = (         void  *)&nd_interval_test;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstl[3] = (unsigned int  )13;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhsts[3] = (         int  )0;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqindv[3] = (         void  *)0;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqinds[3] = (         int  )0;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqharm[3] = (unsigned int  )0;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqadto[3] = (unsigned short )0;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqtdso[3] = (unsigned short )0;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqphsv = sqlstm.sqhstv;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqphsl = sqlstm.sqhstl;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqphss = sqlstm.sqhsts;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqpind = sqlstm.sqindv;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqpins = sqlstm.sqinds;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqparm = sqlstm.sqharm;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqparc = sqlstm.sqharc;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqpadto = sqlstm.sqadto;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqptdso = sqlstm.sqtdso;
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
}

#line 421 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"


	while(fetch_interval_curs())
	{


		gtt_yn = 'Y';
		if ( ( f1 = fopen ( filename, "w" ) ) == NULL ) 
		{
			ins_message(ERR_MESG,"Error in opening output file...\n");
		}

	if (strcmp(nd_printer_type.arr,"3")!= 0)
		set_fonts();	
		
		//get_interval_desc();

		print_file();
	}

	/* EXEC SQL CLOSE interval_curs; */ 
#line 441 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

{
#line 441 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 struct sqlexd sqlstm;
#line 441 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqlvsn = 12;
#line 441 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.arrsiz = 15;
#line 441 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqladtp = &sqladt;
#line 441 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqltdsp = &sqltds;
#line 441 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.iters = (unsigned int  )1;
#line 441 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.offset = (unsigned int  )330;
#line 441 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.cud = sqlcud0;
#line 441 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqlest = (unsigned char  *)&sqlca;
#line 441 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqlety = (unsigned short)4352;
#line 441 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.occurs = (unsigned int  )0;
#line 441 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
#line 441 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
}

#line 441 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

	

}



int fetch_interval_curs()
{

	d_test_code.arr[d_test_code.len]		= '\0';
	nd_specimen_no.arr[nd_specimen_no.len]	= '\0';
	d_count = 0;


      /* EXEC SQL FETCH interval_curs INTO
				:d_test_code, :nd_specimen_no, d_count; */ 
#line 457 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

{
#line 456 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      struct sqlexd sqlstm;
#line 456 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqlvsn = 12;
#line 456 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.arrsiz = 15;
#line 456 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqladtp = &sqladt;
#line 456 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqltdsp = &sqltds;
#line 456 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.iters = (unsigned int  )1;
#line 456 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.offset = (unsigned int  )345;
#line 456 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.selerr = (unsigned short)1;
#line 456 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.cud = sqlcud0;
#line 456 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqlest = (unsigned char  *)&sqlca;
#line 456 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqlety = (unsigned short)4352;
#line 456 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.occurs = (unsigned int  )0;
#line 456 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqfoff = (           int )0;
#line 456 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqfmod = (unsigned int )2;
#line 456 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqhstv[0] = (         void  *)&d_test_code;
#line 456 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqhstl[0] = (unsigned int  )13;
#line 456 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqhsts[0] = (         int  )0;
#line 456 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqindv[0] = (         void  *)0;
#line 456 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqinds[0] = (         int  )0;
#line 456 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqharm[0] = (unsigned int  )0;
#line 456 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqadto[0] = (unsigned short )0;
#line 456 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqtdso[0] = (unsigned short )0;
#line 456 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqhstv[1] = (         void  *)&nd_specimen_no;
#line 456 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqhstl[1] = (unsigned int  )23;
#line 456 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqhsts[1] = (         int  )0;
#line 456 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqindv[1] = (         void  *)0;
#line 456 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqinds[1] = (         int  )0;
#line 456 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqharm[1] = (unsigned int  )0;
#line 456 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqadto[1] = (unsigned short )0;
#line 456 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqtdso[1] = (unsigned short )0;
#line 456 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqhstv[2] = (         void  *)&d_count;
#line 456 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
#line 456 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqhsts[2] = (         int  )0;
#line 456 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqindv[2] = (         void  *)0;
#line 456 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqinds[2] = (         int  )0;
#line 456 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqharm[2] = (unsigned int  )0;
#line 456 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqadto[2] = (unsigned short )0;
#line 456 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqtdso[2] = (unsigned short )0;
#line 456 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqphsv = sqlstm.sqhstv;
#line 456 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqphsl = sqlstm.sqhstl;
#line 456 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqphss = sqlstm.sqhsts;
#line 456 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqpind = sqlstm.sqindv;
#line 456 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqpins = sqlstm.sqinds;
#line 456 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqparm = sqlstm.sqharm;
#line 456 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqparc = sqlstm.sqharc;
#line 456 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqpadto = sqlstm.sqadto;
#line 456 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqptdso = sqlstm.sqtdso;
#line 456 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
#line 456 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
}

#line 457 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

 
    if (OERROR)
	{
		sprintf(string_var,"%s fetch_interval_curs()-> %s\n", d_specimen_no.arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);

     }

	 if (NO_DATA_FOUND)
        return 0;
  
    d_test_code.arr[d_test_code.len]	       = '\0';
	nd_specimen_no.arr[nd_specimen_no.len]	   = '\0';
 
    return 1;
  
}

print_file()
{

	print_label();
	
/***** only for interval test ******************/
	fprintf(f1,"%s\n",d_test_code.arr);	
	//fprintf(f1, "%-20.20s", d_description.arr);

	fclose(f1);		
	fprintf(f1, "%cE", ESC);

	if (strcmp(nd_printer_type.arr,"3")!= 0)
	   set_fonts();

      if (strcmp(nd_trx_ind.arr,"Y") == 0)
	  {
		   for(i=0;i<atoi(d_no_copy.arr);i++)	 
		   {


			WSPrintDocument
				(
					uid_pwd.arr,					//char	*PUidPwd;
					nd_session_id.arr,				//char	*PSessionID;
					nd_operating_facility_id.arr,	//char	*PFacilityID;
					"RL",							//char	*PModuleID;
					"RLRSLILB",						//char	*PDocumentID;
					filename,						//char	*POnlinePrintFileNames;
					"O",							//char	*PLocationTypes;
					d_section_code.arr,				//char	*PLocationCodes;
					1,								//int	PNumOfCopies;
					1,								//int	PPageFrom;
					9999,							//int	PPageTo;
					nd_ws_no.arr,					//char	*PWorkstationID
					WORKING_DIR						//char	*PReportOutputDir
				);
		   }

	  }
	  else
	  {
		
		   for(i=0;i<atoi(d_no_copy.arr);i++)	 
		   {
			
			WSPrintDocument
					   (
						uid_pwd.arr,					//char	*PUidPwd;
						nd_session_id.arr,				//char	*PSessionID;
						nd_operating_facility_id.arr,	//char	*PFacilityID;
						"RL",							//char	*PModuleID;
						"RLRSLILB",						//char	*PDocumentID;
						filename,						//char	*POnlinePrintFileNames;
						"O",							//char	*PLocationTypes;
						" ",							//char	*PLocationCodes;
						1,								//int	PNumOfCopies;
						1,								//int	PPageFrom;
						9999,							//int	PPageTo;
						nd_ws_no.arr,					//char	*PWorkstationID
						WORKING_DIR						//char	*PReportOutputDir
					   );
			}
			
	   } 
}

get_specimen_label()
{

	d_desc_on_label.arr[0]		= '\0';
	d_desc_on_label.len			= 0;
    
	/* EXEC SQL SELECT NVL(SUBSTR(desc_on_label, 1, 22), ' ')
			 INTO :d_desc_on_label
			 FROM RL_SPECIMEN_TYPE_CODE
			 WHERE specimen_type_code = :d_specimen_type_code; */ 
#line 552 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

{
#line 549 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 struct sqlexd sqlstm;
#line 549 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqlvsn = 12;
#line 549 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.arrsiz = 15;
#line 549 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqladtp = &sqladt;
#line 549 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqltdsp = &sqltds;
#line 549 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.stmt = "select NVL(SUBSTR(desc_on_label,1,22),' ') into :b0  from RL\
_SPECIMEN_TYPE_CODE where specimen_type_code=:b1";
#line 549 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.iters = (unsigned int  )1;
#line 549 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.offset = (unsigned int  )372;
#line 549 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.selerr = (unsigned short)1;
#line 549 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.cud = sqlcud0;
#line 549 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqlest = (unsigned char  *)&sqlca;
#line 549 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqlety = (unsigned short)4352;
#line 549 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.occurs = (unsigned int  )0;
#line 549 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstv[0] = (         void  *)&d_desc_on_label;
#line 549 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstl[0] = (unsigned int  )33;
#line 549 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhsts[0] = (         int  )0;
#line 549 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqindv[0] = (         void  *)0;
#line 549 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqinds[0] = (         int  )0;
#line 549 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqharm[0] = (unsigned int  )0;
#line 549 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqadto[0] = (unsigned short )0;
#line 549 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqtdso[0] = (unsigned short )0;
#line 549 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstv[1] = (         void  *)&d_specimen_type_code;
#line 549 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstl[1] = (unsigned int  )7;
#line 549 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhsts[1] = (         int  )0;
#line 549 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqindv[1] = (         void  *)0;
#line 549 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqinds[1] = (         int  )0;
#line 549 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqharm[1] = (unsigned int  )0;
#line 549 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqadto[1] = (unsigned short )0;
#line 549 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqtdso[1] = (unsigned short )0;
#line 549 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqphsv = sqlstm.sqhstv;
#line 549 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqphsl = sqlstm.sqhstl;
#line 549 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqphss = sqlstm.sqhsts;
#line 549 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqpind = sqlstm.sqindv;
#line 549 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqpins = sqlstm.sqinds;
#line 549 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqparm = sqlstm.sqharm;
#line 549 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqparc = sqlstm.sqharc;
#line 549 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqpadto = sqlstm.sqadto;
#line 549 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqptdso = sqlstm.sqtdso;
#line 549 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
#line 549 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
}

#line 552 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"



	d_desc_on_label.arr[d_desc_on_label.len]		= '\0';
}

get_interval_test()
{
	
	
	/* EXEC SQL SELECT seq_no, seq_no
			 INTO :i_count, :d_count
			 FROM RL_INTERVAL_TEST_SPECIMENS
			 WHERE specimen_no = TO_NUMBER(:d_specimen_no)
			 AND OPERATING_FACILITY_ID = :nd_operating_facility_id
			 AND test_code = :d_test_code; */ 
#line 567 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

{
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 struct sqlexd sqlstm;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqlvsn = 12;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.arrsiz = 15;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqladtp = &sqladt;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqltdsp = &sqltds;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.stmt = "select seq_no ,seq_no into :b0,:b1  from RL_INTERVAL_TEST_SP\
ECIMENS where ((specimen_no=TO_NUMBER(:b2) and OPERATING_FACILITY_ID=:b3) and \
test_code=:b4)";
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.iters = (unsigned int  )1;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.offset = (unsigned int  )395;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.selerr = (unsigned short)1;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.cud = sqlcud0;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqlest = (unsigned char  *)&sqlca;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqlety = (unsigned short)4352;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.occurs = (unsigned int  )0;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstv[0] = (         void  *)&i_count;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhsts[0] = (         int  )0;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqindv[0] = (         void  *)0;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqinds[0] = (         int  )0;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqharm[0] = (unsigned int  )0;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqadto[0] = (unsigned short )0;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqtdso[0] = (unsigned short )0;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstv[1] = (         void  *)&d_count;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhsts[1] = (         int  )0;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqindv[1] = (         void  *)0;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqinds[1] = (         int  )0;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqharm[1] = (unsigned int  )0;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqadto[1] = (unsigned short )0;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqtdso[1] = (unsigned short )0;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstv[2] = (         void  *)&d_specimen_no;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstl[2] = (unsigned int  )23;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhsts[2] = (         int  )0;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqindv[2] = (         void  *)0;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqinds[2] = (         int  )0;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqharm[2] = (unsigned int  )0;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqadto[2] = (unsigned short )0;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqtdso[2] = (unsigned short )0;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstl[3] = (unsigned int  )5;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhsts[3] = (         int  )0;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqindv[3] = (         void  *)0;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqinds[3] = (         int  )0;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqharm[3] = (unsigned int  )0;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqadto[3] = (unsigned short )0;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqtdso[3] = (unsigned short )0;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstv[4] = (         void  *)&d_test_code;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstl[4] = (unsigned int  )13;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhsts[4] = (         int  )0;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqindv[4] = (         void  *)0;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqinds[4] = (         int  )0;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqharm[4] = (unsigned int  )0;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqadto[4] = (unsigned short )0;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqtdso[4] = (unsigned short )0;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqphsv = sqlstm.sqhstv;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqphsl = sqlstm.sqhstl;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqphss = sqlstm.sqhsts;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqpind = sqlstm.sqindv;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqpins = sqlstm.sqinds;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqparm = sqlstm.sqharm;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqparc = sqlstm.sqharc;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqpadto = sqlstm.sqadto;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqptdso = sqlstm.sqtdso;
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
#line 562 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
}

#line 567 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"


}

get_parent()
{
	parent_spec_no.arr[0]	= '\0';
	parent_spec_no.len		= 0;

	/* EXEC SQL SELECT interval_test_specimen_no
			 INTO :parent_spec_no
			 FROM RL_INTERVAL_TEST_SPECIMENS
			 WHERE specimen_no = TO_NUMBER(:d_specimen_no)
			 AND OPERATING_FACILITY_ID = :nd_operating_facility_id
			 AND test_code = :d_test_code; */ 
#line 581 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

{
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 struct sqlexd sqlstm;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqlvsn = 12;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.arrsiz = 15;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqladtp = &sqladt;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqltdsp = &sqltds;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.stmt = "select interval_test_specimen_no into :b0  from RL_INTERVAL_\
TEST_SPECIMENS where ((specimen_no=TO_NUMBER(:b1) and OPERATING_FACILITY_ID=:b\
2) and test_code=:b3)";
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.iters = (unsigned int  )1;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.offset = (unsigned int  )430;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.selerr = (unsigned short)1;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.cud = sqlcud0;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqlest = (unsigned char  *)&sqlca;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqlety = (unsigned short)4352;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.occurs = (unsigned int  )0;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstv[0] = (         void  *)&parent_spec_no;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstl[0] = (unsigned int  )23;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhsts[0] = (         int  )0;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqindv[0] = (         void  *)0;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqinds[0] = (         int  )0;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqharm[0] = (unsigned int  )0;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqadto[0] = (unsigned short )0;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqtdso[0] = (unsigned short )0;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstv[1] = (         void  *)&d_specimen_no;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstl[1] = (unsigned int  )23;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhsts[1] = (         int  )0;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqindv[1] = (         void  *)0;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqinds[1] = (         int  )0;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqharm[1] = (unsigned int  )0;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqadto[1] = (unsigned short )0;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqtdso[1] = (unsigned short )0;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstl[2] = (unsigned int  )5;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhsts[2] = (         int  )0;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqindv[2] = (         void  *)0;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqinds[2] = (         int  )0;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqharm[2] = (unsigned int  )0;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqadto[2] = (unsigned short )0;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqtdso[2] = (unsigned short )0;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstv[3] = (         void  *)&d_test_code;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstl[3] = (unsigned int  )13;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhsts[3] = (         int  )0;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqindv[3] = (         void  *)0;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqinds[3] = (         int  )0;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqharm[3] = (unsigned int  )0;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqadto[3] = (unsigned short )0;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqtdso[3] = (unsigned short )0;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqphsv = sqlstm.sqhstv;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqphsl = sqlstm.sqhstl;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqphss = sqlstm.sqhsts;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqpind = sqlstm.sqindv;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqpins = sqlstm.sqinds;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqparm = sqlstm.sqharm;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqparc = sqlstm.sqharc;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqpadto = sqlstm.sqadto;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqptdso = sqlstm.sqtdso;
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
#line 576 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
}

#line 581 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"


	parent_spec_no.arr[parent_spec_no.len]	= '\0';

}

dclr_rownum_curs()
{
 
		/* EXEC SQL DECLARE c2 CURSOR FOR
			     SELECT rownum, specimen_no
				 FROM RL_INTERVAL_TEST_SPECIMENS
				 WHERE interval_test_specimen_no = TO_NUMBER(:parent_spec_no)
				 AND OPERATING_FACILITY_ID = :nd_operating_facility_id
				 ORDER BY specimen_no; */ 
#line 595 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"


		/* EXEC SQL OPEN c2; */ 
#line 597 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

{
#line 597 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  struct sqlexd sqlstm;
#line 597 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqlvsn = 12;
#line 597 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.arrsiz = 15;
#line 597 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqladtp = &sqladt;
#line 597 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqltdsp = &sqltds;
#line 597 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.stmt = sq0013;
#line 597 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.iters = (unsigned int  )1;
#line 597 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.offset = (unsigned int  )461;
#line 597 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.selerr = (unsigned short)1;
#line 597 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.cud = sqlcud0;
#line 597 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqlest = (unsigned char  *)&sqlca;
#line 597 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqlety = (unsigned short)4352;
#line 597 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.occurs = (unsigned int  )0;
#line 597 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqcmod = (unsigned int )0;
#line 597 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqhstv[0] = (         void  *)&parent_spec_no;
#line 597 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqhstl[0] = (unsigned int  )23;
#line 597 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqhsts[0] = (         int  )0;
#line 597 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqindv[0] = (         void  *)0;
#line 597 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqinds[0] = (         int  )0;
#line 597 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqharm[0] = (unsigned int  )0;
#line 597 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqadto[0] = (unsigned short )0;
#line 597 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqtdso[0] = (unsigned short )0;
#line 597 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
#line 597 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqhstl[1] = (unsigned int  )5;
#line 597 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqhsts[1] = (         int  )0;
#line 597 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqindv[1] = (         void  *)0;
#line 597 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqinds[1] = (         int  )0;
#line 597 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqharm[1] = (unsigned int  )0;
#line 597 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqadto[1] = (unsigned short )0;
#line 597 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqtdso[1] = (unsigned short )0;
#line 597 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqphsv = sqlstm.sqhstv;
#line 597 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqphsl = sqlstm.sqhstl;
#line 597 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqphss = sqlstm.sqhsts;
#line 597 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqpind = sqlstm.sqindv;
#line 597 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqpins = sqlstm.sqinds;
#line 597 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqparm = sqlstm.sqharm;
#line 597 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqparc = sqlstm.sqharc;
#line 597 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqpadto = sqlstm.sqadto;
#line 597 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqptdso = sqlstm.sqtdso;
#line 597 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
#line 597 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
}

#line 597 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

		

}

int fetch_rownum_curs()
{
	
	 r_child_spec_no.arr[0]		= '\0';
	 r_child_spec_no.len		= 0;

      /* EXEC SQL FETCH c2 INTO :d_count, r_child_spec_no; */ 
#line 608 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

{
#line 608 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      struct sqlexd sqlstm;
#line 608 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqlvsn = 12;
#line 608 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.arrsiz = 15;
#line 608 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqladtp = &sqladt;
#line 608 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqltdsp = &sqltds;
#line 608 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.iters = (unsigned int  )1;
#line 608 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.offset = (unsigned int  )484;
#line 608 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.selerr = (unsigned short)1;
#line 608 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.cud = sqlcud0;
#line 608 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqlest = (unsigned char  *)&sqlca;
#line 608 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqlety = (unsigned short)4352;
#line 608 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.occurs = (unsigned int  )0;
#line 608 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqfoff = (           int )0;
#line 608 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqfmod = (unsigned int )2;
#line 608 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqhstv[0] = (         void  *)&d_count;
#line 608 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
#line 608 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqhsts[0] = (         int  )0;
#line 608 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqindv[0] = (         void  *)0;
#line 608 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqinds[0] = (         int  )0;
#line 608 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqharm[0] = (unsigned int  )0;
#line 608 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqadto[0] = (unsigned short )0;
#line 608 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqtdso[0] = (unsigned short )0;
#line 608 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqhstv[1] = (         void  *)&r_child_spec_no;
#line 608 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqhstl[1] = (unsigned int  )23;
#line 608 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqhsts[1] = (         int  )0;
#line 608 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqindv[1] = (         void  *)0;
#line 608 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqinds[1] = (         int  )0;
#line 608 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqharm[1] = (unsigned int  )0;
#line 608 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqadto[1] = (unsigned short )0;
#line 608 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqtdso[1] = (unsigned short )0;
#line 608 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqphsv = sqlstm.sqhstv;
#line 608 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqphsl = sqlstm.sqhstl;
#line 608 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqphss = sqlstm.sqhsts;
#line 608 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqpind = sqlstm.sqindv;
#line 608 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqpins = sqlstm.sqinds;
#line 608 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqparm = sqlstm.sqharm;
#line 608 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqparc = sqlstm.sqharc;
#line 608 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqpadto = sqlstm.sqadto;
#line 608 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlstm.sqptdso = sqlstm.sqtdso;
#line 608 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
      sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
#line 608 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
}

#line 608 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

 
	 if (OERROR)
	{
		sprintf(string_var,"%s fetch_rownum_curs()-> %s\n", d_specimen_no.arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);

     }

	 if (NO_DATA_FOUND)
        return 0; 

	r_child_spec_no.arr[r_child_spec_no.len]		= '\0';

    return 1;
  
}


get_interval_desc()
{

	d_description.arr[0]		= '\0';
	d_description.len			= 0;

	/* EXEC SQL SELECT SUBSTR(description, 1, 20)
			 INTO :d_description
			 FROM RL_INTERVAL_TEST_DESC_LANG_VW
			 WHERE test_code = :d_test_code
			 AND seq_no = :d_count
			 and language_id = :language_id; */ 
#line 638 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

{
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 struct sqlexd sqlstm;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqlvsn = 12;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.arrsiz = 15;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqladtp = &sqladt;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqltdsp = &sqltds;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.stmt = "select SUBSTR(description,1,20) into :b0  from RL_INTERVAL_T\
EST_DESC_LANG_VW where ((test_code=:b1 and seq_no=:b2) and language_id=:b3)";
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.iters = (unsigned int  )1;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.offset = (unsigned int  )507;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.selerr = (unsigned short)1;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.cud = sqlcud0;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqlest = (unsigned char  *)&sqlca;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqlety = (unsigned short)4352;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.occurs = (unsigned int  )0;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstv[0] = (         void  *)&d_description;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstl[0] = (unsigned int  )23;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhsts[0] = (         int  )0;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqindv[0] = (         void  *)0;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqinds[0] = (         int  )0;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqharm[0] = (unsigned int  )0;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqadto[0] = (unsigned short )0;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqtdso[0] = (unsigned short )0;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstv[1] = (         void  *)&d_test_code;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstl[1] = (unsigned int  )13;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhsts[1] = (         int  )0;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqindv[1] = (         void  *)0;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqinds[1] = (         int  )0;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqharm[1] = (unsigned int  )0;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqadto[1] = (unsigned short )0;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqtdso[1] = (unsigned short )0;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstv[2] = (         void  *)&d_count;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhsts[2] = (         int  )0;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqindv[2] = (         void  *)0;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqinds[2] = (         int  )0;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqharm[2] = (unsigned int  )0;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqadto[2] = (unsigned short )0;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqtdso[2] = (unsigned short )0;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstv[3] = (         void  *)&language_id;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstl[3] = (unsigned int  )7;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhsts[3] = (         int  )0;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqindv[3] = (         void  *)0;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqinds[3] = (         int  )0;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqharm[3] = (unsigned int  )0;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqadto[3] = (unsigned short )0;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqtdso[3] = (unsigned short )0;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqphsv = sqlstm.sqhstv;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqphsl = sqlstm.sqhstl;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqphss = sqlstm.sqhsts;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqpind = sqlstm.sqindv;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqpins = sqlstm.sqinds;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqparm = sqlstm.sqharm;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqparc = sqlstm.sqharc;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqpadto = sqlstm.sqadto;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqptdso = sqlstm.sqtdso;
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
#line 633 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
}

#line 638 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

	
	
	d_description.arr[d_description.len]		= '\0';
	
}


set_fonts()
{

	/*	fprintf(f1,"%c&k4S",ESC); This will make the font condensed */	
	/*  fprintf(fp,"%c(s4B",ESC); This will make the font bold      */
	fprintf(f1, "%c(s17H", ESC);/* Reduce the font size*/ //15to17
	fprintf(f1,"%c&a0L",ESC);/* This will make the left margin to reduce to 0 */
	fprintf(f1,"%c&l0E\n",ESC);	/* This will make the top margin to reduce to 0 */
	fprintf(f1,"%c&l12D",ESC);/* This will make no. of lines per inch to 8 */

}


print_label()
{
	
	//fprintf(f1, "%s\n", d_facility_name.arr);	
	//fprintf(f1, "%-22s %s\n", d_desc_on_label.arr,d_urgent_indicator.arr);

	if (gtt_yn == 'N')
		fprintf(f1, "%-10.10s", d_specimen_no.arr);
	else
		fprintf(f1, "%-10.10s", nd_specimen_no.arr);

    fprintf(f1, " %s\n", d_urgent_indicator.arr);	

	/*if (strlen(d_actual_patient_id.arr) > 0)
		fprintf(f1, "%15.15s\n", d_actual_patient_id.arr);
	else  [Commented]*/

	    fprintf(f1, "%s\n", d_patient_id.arr);

}


/**************************select transaction based or not ***************/
get_trans_ind()
{
	
	nd_trx_ind.arr[0]		= '\0';
	nd_trx_ind.len		= 0;

	/* EXEC SQL  SELECT NVL(TRANSACTION_BASED_YN, 'N')
	          INTO   :nd_trx_ind
	          FROM   sy_online_print_id
              WHERE  MODULE_ID = 'RL'
			  AND    ONLINE_PRINT_NAME = 'RLRSLILB'; */ 
#line 692 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

{
#line 688 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 struct sqlexd sqlstm;
#line 688 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqlvsn = 12;
#line 688 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.arrsiz = 15;
#line 688 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqladtp = &sqladt;
#line 688 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqltdsp = &sqltds;
#line 688 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.stmt = "select NVL(TRANSACTION_BASED_YN,'N') into :b0  from sy_onlin\
e_print_id where (MODULE_ID='RL' and ONLINE_PRINT_NAME='RLRSLILB')";
#line 688 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.iters = (unsigned int  )1;
#line 688 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.offset = (unsigned int  )538;
#line 688 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.selerr = (unsigned short)1;
#line 688 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.cud = sqlcud0;
#line 688 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqlest = (unsigned char  *)&sqlca;
#line 688 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqlety = (unsigned short)4352;
#line 688 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.occurs = (unsigned int  )0;
#line 688 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstv[0] = (         void  *)&nd_trx_ind;
#line 688 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhstl[0] = (unsigned int  )4;
#line 688 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqhsts[0] = (         int  )0;
#line 688 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqindv[0] = (         void  *)0;
#line 688 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqinds[0] = (         int  )0;
#line 688 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqharm[0] = (unsigned int  )0;
#line 688 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqadto[0] = (unsigned short )0;
#line 688 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqtdso[0] = (unsigned short )0;
#line 688 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqphsv = sqlstm.sqhstv;
#line 688 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqphsl = sqlstm.sqhstl;
#line 688 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqphss = sqlstm.sqhsts;
#line 688 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqpind = sqlstm.sqindv;
#line 688 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqpins = sqlstm.sqinds;
#line 688 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqparm = sqlstm.sqharm;
#line 688 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqparc = sqlstm.sqharc;
#line 688 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqpadto = sqlstm.sqadto;
#line 688 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlstm.sqptdso = sqlstm.sqtdso;
#line 688 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
#line 688 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
}

#line 692 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"


	if(OERROR)
	{
		sprintf(string_var,"%s get_trans_ind()-> %s\n", d_specimen_no.arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);

	}

	nd_trx_ind.arr[nd_trx_ind.len]			= '\0';


    if(NO_DATA_FOUND)
		return 0;

		
	return 1;

}
/************************** gen file name ***************/
gen_file_name()
{
	strcpy(filename,WORKING_DIR);
	strcat(filename,"rlrslilb.lis");

	strcpy(nd_filename,WORKING_DIR);
	strcat(nd_filename,"rlrslil1.lis");

	if ( ( f1 = fopen ( filename, "w" ) ) == NULL ) 
	{
		ins_message(ERR_MESG,"Error in opening output file...\n");  
    }

}

/*--------------------------------------------------*/
ins_message(int msg_type,char msg[])
{
   er_msg.arr[0] = '\0';
   er_msg.len = 0;
   
   er_msg_type = 0;

   strcpy(er_msg.arr,msg);
   er_msg.len = strlen(er_msg.arr);
 
   er_msg_type = msg_type;


   /* EXEC SQL
   INSERT INTO SY_PROG_MSG
          (OPERATING_FACILITY_ID,PGM_ID,MSG_TYPE,MSG_NUM,MSG_DESC,MSG_DATE_TIME,SESSION_ID,PGM_DATE)
   VALUES 
          (:nd_operating_facility_id,'RLRSLILB',:er_msg_type,NULL, SUBSTR(:er_msg, 1, 70),SYSDATE,USERENV('sessionid'),
		   TO_CHAR(SYSDATE,'DD/MM/YYYY')); */ 
#line 746 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

{
#line 741 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   struct sqlexd sqlstm;
#line 741 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqlvsn = 12;
#line 741 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.arrsiz = 15;
#line 741 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqladtp = &sqladt;
#line 741 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqltdsp = &sqltds;
#line 741 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.stmt = "insert into SY_PROG_MSG (OPERATING_FACILITY_ID,PGM_ID,MSG_\
TYPE,MSG_NUM,MSG_DESC,MSG_DATE_TIME,SESSION_ID,PGM_DATE) values (:b0,'RLRSLILB\
',:b1,null ,SUBSTR(:b2,1,70),SYSDATE,USERENV('sessionid'),TO_CHAR(SYSDATE,'DD/\
MM/YYYY'))";
#line 741 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.iters = (unsigned int  )1;
#line 741 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.offset = (unsigned int  )557;
#line 741 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.cud = sqlcud0;
#line 741 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqlest = (unsigned char  *)&sqlca;
#line 741 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqlety = (unsigned short)4352;
#line 741 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.occurs = (unsigned int  )0;
#line 741 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
#line 741 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqhstl[0] = (unsigned int  )5;
#line 741 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqhsts[0] = (         int  )0;
#line 741 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqindv[0] = (         void  *)0;
#line 741 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqinds[0] = (         int  )0;
#line 741 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqharm[0] = (unsigned int  )0;
#line 741 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqadto[0] = (unsigned short )0;
#line 741 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqtdso[0] = (unsigned short )0;
#line 741 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqhstv[1] = (         void  *)&er_msg_type;
#line 741 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
#line 741 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqhsts[1] = (         int  )0;
#line 741 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqindv[1] = (         void  *)0;
#line 741 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqinds[1] = (         int  )0;
#line 741 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqharm[1] = (unsigned int  )0;
#line 741 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqadto[1] = (unsigned short )0;
#line 741 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqtdso[1] = (unsigned short )0;
#line 741 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqhstv[2] = (         void  *)&er_msg;
#line 741 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqhstl[2] = (unsigned int  )173;
#line 741 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqhsts[2] = (         int  )0;
#line 741 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqindv[2] = (         void  *)0;
#line 741 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqinds[2] = (         int  )0;
#line 741 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqharm[2] = (unsigned int  )0;
#line 741 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqadto[2] = (unsigned short )0;
#line 741 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqtdso[2] = (unsigned short )0;
#line 741 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqphsv = sqlstm.sqhstv;
#line 741 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqphsl = sqlstm.sqhstl;
#line 741 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqphss = sqlstm.sqhsts;
#line 741 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqpind = sqlstm.sqindv;
#line 741 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqpins = sqlstm.sqinds;
#line 741 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqparm = sqlstm.sqharm;
#line 741 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqparc = sqlstm.sqharc;
#line 741 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqpadto = sqlstm.sqadto;
#line 741 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlstm.sqptdso = sqlstm.sqtdso;
#line 741 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
#line 741 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
}

#line 746 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"


   err_flag = 1;
}

/************** Hospital name **********/
get_facility_name()
{
  d_facility_name.arr[0] = '\0';
  d_facility_name.len    = 0;

  /* EXEC SQL
     SELECT FACILITY_NAME 
       INTO :d_facility_name
       FROM SM_FACILITY_PARAM_LANG_VW
      WHERE FACILITY_ID = :nd_facility_id
	  and language_id = :language_id; */ 
#line 762 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"

{
#line 757 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  struct sqlexd sqlstm;
#line 757 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqlvsn = 12;
#line 757 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.arrsiz = 15;
#line 757 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqladtp = &sqladt;
#line 757 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqltdsp = &sqltds;
#line 757 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.stmt = "select FACILITY_NAME into :b0  from SM_FACILITY_PARAM_LANG_\
VW where (FACILITY_ID=:b1 and language_id=:b2)";
#line 757 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.iters = (unsigned int  )1;
#line 757 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.offset = (unsigned int  )584;
#line 757 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.selerr = (unsigned short)1;
#line 757 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.cud = sqlcud0;
#line 757 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqlest = (unsigned char  *)&sqlca;
#line 757 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqlety = (unsigned short)4352;
#line 757 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.occurs = (unsigned int  )0;
#line 757 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqhstv[0] = (         void  *)&d_facility_name;
#line 757 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqhstl[0] = (unsigned int  )302;
#line 757 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqhsts[0] = (         int  )0;
#line 757 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqindv[0] = (         void  *)0;
#line 757 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqinds[0] = (         int  )0;
#line 757 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqharm[0] = (unsigned int  )0;
#line 757 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqadto[0] = (unsigned short )0;
#line 757 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqtdso[0] = (unsigned short )0;
#line 757 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqhstv[1] = (         void  *)&nd_facility_id;
#line 757 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqhstl[1] = (unsigned int  )5;
#line 757 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqhsts[1] = (         int  )0;
#line 757 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqindv[1] = (         void  *)0;
#line 757 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqinds[1] = (         int  )0;
#line 757 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqharm[1] = (unsigned int  )0;
#line 757 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqadto[1] = (unsigned short )0;
#line 757 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqtdso[1] = (unsigned short )0;
#line 757 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqhstv[2] = (         void  *)&language_id;
#line 757 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqhstl[2] = (unsigned int  )7;
#line 757 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqhsts[2] = (         int  )0;
#line 757 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqindv[2] = (         void  *)0;
#line 757 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqinds[2] = (         int  )0;
#line 757 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqharm[2] = (unsigned int  )0;
#line 757 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqadto[2] = (unsigned short )0;
#line 757 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqtdso[2] = (unsigned short )0;
#line 757 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqphsv = sqlstm.sqhstv;
#line 757 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqphsl = sqlstm.sqhstl;
#line 757 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqphss = sqlstm.sqhsts;
#line 757 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqpind = sqlstm.sqindv;
#line 757 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqpins = sqlstm.sqinds;
#line 757 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqparm = sqlstm.sqharm;
#line 757 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqparc = sqlstm.sqharc;
#line 757 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqpadto = sqlstm.sqadto;
#line 757 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlstm.sqptdso = sqlstm.sqtdso;
#line 757 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
#line 757 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"
}

#line 762 "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSLILB.PC"


  d_facility_name.arr[d_facility_name.len] = '\0';
}

