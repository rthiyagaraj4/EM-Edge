
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRSNOMD.PC"
};


static unsigned int sqlctx = 1288616299;


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

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,184,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,29,213,0,0,0,0,0,1,0,
51,0,0,3,0,0,32,224,0,0,0,0,0,1,0,
66,0,0,4,120,0,6,237,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
89,0,0,5,136,0,6,248,0,0,2,2,0,1,0,2,9,0,0,1,3,0,0,
112,0,0,6,158,0,4,269,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
147,0,0,7,0,0,32,290,0,0,0,0,0,1,0,
162,0,0,8,0,0,17,454,0,0,1,1,0,1,0,1,97,0,0,
181,0,0,8,0,0,45,460,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,
220,0,0,8,0,0,45,465,0,0,9,9,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,
271,0,0,8,0,0,45,472,0,0,12,12,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
334,0,0,8,0,0,45,481,0,0,15,15,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
409,0,0,8,0,0,45,495,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,
448,0,0,8,0,0,45,500,0,0,8,8,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,
495,0,0,8,0,0,45,506,0,0,10,10,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
550,0,0,8,0,0,45,513,0,0,12,12,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
613,0,0,9,0,0,32,531,0,0,0,0,0,1,0,
628,0,0,8,0,0,13,613,0,0,6,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,
667,0,0,10,0,0,32,642,0,0,0,0,0,1,0,
682,0,0,11,131,0,6,691,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
709,0,0,12,119,0,6,701,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
736,0,0,13,0,0,32,738,0,0,0,0,0,1,0,
751,0,0,14,211,0,4,790,0,0,5,2,0,1,0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
786,0,0,15,0,0,32,808,0,0,0,0,0,1,0,
801,0,0,16,211,0,4,823,0,0,5,2,0,1,0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
836,0,0,17,0,0,32,842,0,0,0,0,0,1,0,
851,0,0,18,100,0,6,880,0,0,2,2,0,1,0,2,9,0,0,1,9,0,0,
874,0,0,19,136,0,6,1115,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
901,0,0,20,132,0,6,1132,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
};


/****************************OCS MEDICOM ver 1.0*****************************
*  File	: rlrsnomd.pc
   Author : S.Sheelvant 
   Date Created : 10/01/1997
   Last Modified : 10/01/1997

*  Ver 1.10.01
   
*  Purpose : To generate a SNOMED Report. 

*  Input Parameters : 
              Command line inputs
		      1.  Usr_id/Password
              2.  Session id
		      3.  Program Date
		      4.  Section code
		      5.  snomed count
		      6.  from date
		      7.  to date
		      8.  snomed code 1
		      9.  snomed code 2
		      10. snomed code 3
		      11. snomed code 4

*  Table Accessed : RL_REQUEST_HEADER,RL_RESULT_SNOMED

*  Output File : rlrsnomd.lis
 ****************************************************************************/  

#include <stdio.h>
#include <math.h>
/*#include <string.h> */

/*#define MAX_LINES 50 */	/* Commented by durai against MF-SCF-00046 */
#define MAX_LINES 43		/* Added by durai against MF-SCF-00046 */
#define ERROR (sqlca.sqlcode < 0)
#define NODATAFOUND sqlca.sqlcode==1403
#define VER  "VER : 4.1\n"
#define ESC 0x1B
#define REP_WIDTH   130		/* Added by durai against MF-SCF-00046 */
/*#define DEBUG 1*/ 


/* EXEC SQL BEGIN DECLARE SECTION; */ 


       /* increased the length all varchar variables by one to take care */
       /* for null termination */
	/* VARCHAR uid_pwd		              [42],
	        nd_operating_facility_id  [3],
            nd_file_name              [151],
            nd_user	                  [15],
            nd_file_no                [15],
            nd_printer_name           [16],
			nd_trx_ind		          [2],

        /o Variables to recieve data from specimen register cursoro/ 
	    d_specimen_no           [20],
		d_patient_name          [240],
		d_patient_id            [31],
		d_source_code           [7],
        d_episode_type          [4],
        d_req_comment_1         [45],
        d_req_comment_2         [45],
        d_req_comment_3         [45],
		d_consultant_code       [12],
		d_spec_date             [31],
		d_spec_date1            [31],
		d_dob                   [11],
		d_dob1                  [11],
		d_sex                   [2],

        /o input parameters to main() o/
        nd_session_id      	[16],
        nd_pgm_date	   	    [20],

 		nd_section_code     [10], 
 		nd_count            [10],
 		nd_snomed_code1    	[21],
 		nd_snomed_code2    	[21],
 		nd_snomed_code3    	[21],
 		nd_snomed_code4    	[21],
 		nd_from_date    	[21],
		nd_from_date1    	[21],	/o Added by durai against MF-SCF-00046 o/
 		nd_to_date    	    [21],
		nd_to_date1    	    [21],	/o Added by durai against MF-SCF-00046 o/
        nd_print_yn         [2],
		nd_intersect_or     [2],

		/o for header routine o/
	    //d_acc_entity_name        [41],
		d_acc_entity_name        [300],
		d_user                   [21],
		d_sysdate                [17],
		d_sysdate1               [17]; */ 
struct { unsigned short len; unsigned char arr[42]; } uid_pwd;

struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[151]; } nd_file_name;

struct { unsigned short len; unsigned char arr[15]; } nd_user;

struct { unsigned short len; unsigned char arr[15]; } nd_file_no;

struct { unsigned short len; unsigned char arr[16]; } nd_printer_name;

struct { unsigned short len; unsigned char arr[2]; } nd_trx_ind;

struct { unsigned short len; unsigned char arr[20]; } d_specimen_no;

struct { unsigned short len; unsigned char arr[240]; } d_patient_name;

struct { unsigned short len; unsigned char arr[31]; } d_patient_id;

struct { unsigned short len; unsigned char arr[7]; } d_source_code;

struct { unsigned short len; unsigned char arr[4]; } d_episode_type;

struct { unsigned short len; unsigned char arr[45]; } d_req_comment_1;

struct { unsigned short len; unsigned char arr[45]; } d_req_comment_2;

struct { unsigned short len; unsigned char arr[45]; } d_req_comment_3;

struct { unsigned short len; unsigned char arr[12]; } d_consultant_code;

struct { unsigned short len; unsigned char arr[31]; } d_spec_date;

struct { unsigned short len; unsigned char arr[31]; } d_spec_date1;

struct { unsigned short len; unsigned char arr[11]; } d_dob;

struct { unsigned short len; unsigned char arr[11]; } d_dob1;

struct { unsigned short len; unsigned char arr[2]; } d_sex;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[20]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[10]; } nd_section_code;

struct { unsigned short len; unsigned char arr[10]; } nd_count;

struct { unsigned short len; unsigned char arr[21]; } nd_snomed_code1;

struct { unsigned short len; unsigned char arr[21]; } nd_snomed_code2;

struct { unsigned short len; unsigned char arr[21]; } nd_snomed_code3;

struct { unsigned short len; unsigned char arr[21]; } nd_snomed_code4;

struct { unsigned short len; unsigned char arr[21]; } nd_from_date;

struct { unsigned short len; unsigned char arr[21]; } nd_from_date1;

struct { unsigned short len; unsigned char arr[21]; } nd_to_date;

struct { unsigned short len; unsigned char arr[21]; } nd_to_date1;

struct { unsigned short len; unsigned char arr[2]; } nd_print_yn;

struct { unsigned short len; unsigned char arr[2]; } nd_intersect_or;

struct { unsigned short len; unsigned char arr[300]; } d_acc_entity_name;

struct { unsigned short len; unsigned char arr[21]; } d_user;

struct { unsigned short len; unsigned char arr[17]; } d_sysdate;

struct { unsigned short len; unsigned char arr[17]; } d_sysdate1;



        char sql_stmt[10000];

		/* VARCHAR l_translated_value  [500], //added for globalisation
				language_id [5]; */ 
struct { unsigned short len; unsigned char arr[500]; } l_translated_value;

struct { unsigned short len; unsigned char arr[5]; } language_id;
 //added for globalisation
		int     i; //added for globalisation

/* EXEC SQL END DECLARE SECTION; */ 


/* EXEC SQL INCLUDE SQLCA;
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

int   line_no=0, page_no=0;
int   first_page_flag=1;
long  nd_totl_specimens      = 0;
/* summary fields for calculating No. of records */ 
void print_page_header();
void print_col_heading();

char string_var[2000] ;

FILE *f1;
/* Added by durai against MF-SCF-00046 */
char hdr_line1[REP_WIDTH+1],	
     hdr_line2[REP_WIDTH+1],
     hdr_line3[REP_WIDTH+1],
	 hdr_line4[REP_WIDTH+1];		/* Added by Durai Rajkumar against 6187 */			
char rep_title1[500];
/* Ends against MF-SCF-00046 */
char local_legend[40][600];  //added for globalisation

void proc_main(argc, argv)
int argc;
char *argv[];
{
  void  get_header_dtls(),
  	dclr_specimen_register(),
  	do_report();

   if(argc < 10)
      disp_message(ERR_MESG, "Usage : rlrsnomd uid/pwd section count snmd1 snmd2 snmd3 snmd4 from to print_yn\n");
	  //c printf("Usage : rlrsnomd uid/pwd section count snmd1 snmd2 snmd3 snmd4 from to print_yn\n");
 
   strcpy(uid_pwd.arr, argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr);

   strcpy(nd_session_id.arr, argv[2]);
   nd_session_id.len = strlen(nd_session_id.arr); 

   strcpy(nd_pgm_date.arr, argv[3]);
   nd_pgm_date.len = strlen(nd_pgm_date.arr); 

   strcpy(nd_operating_facility_id.arr, argv[4]);
   nd_operating_facility_id.len = strlen(nd_operating_facility_id.arr);

   strcpy(nd_section_code.arr, argv[5]);
   nd_section_code.len = strlen(nd_section_code.arr); 

   strcpy(nd_count.arr, argv[6]);
   nd_count.len = strlen(nd_count.arr); 

   strcpy(nd_snomed_code1.arr, argv[7]);
   nd_snomed_code1.len = strlen(nd_snomed_code1.arr); 

   strcpy(nd_snomed_code2.arr, argv[8]);
   nd_snomed_code2.len = strlen(nd_snomed_code2.arr); 

   strcpy(nd_snomed_code3.arr, argv[9]);
   nd_snomed_code3.len = strlen(nd_snomed_code3.arr); 

   strcpy(nd_snomed_code4.arr, argv[10]);
   nd_snomed_code4.len = strlen(nd_snomed_code4.arr); 

   strcpy(nd_from_date.arr,argv[11]);
   nd_from_date.len = strlen(nd_from_date.arr); 

   strcpy(nd_to_date.arr,argv[12]);
   nd_to_date.len = strlen(nd_to_date.arr); 

   strcpy(nd_intersect_or.arr,argv[13]);
   nd_intersect_or.len = strlen(nd_intersect_or.arr);
   
   strcpy(nd_print_yn.arr,argv[14]);
   nd_print_yn.len = strlen(nd_print_yn.arr);

   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL CONNECT :uid_pwd; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )20;
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
	/******* upto here added for globalisation ********/

	get_legend_value(19);  //added for globalisation

   #ifdef DEBUG
    printf("Connected to ORACLE as user: %s \n", uid_pwd.arr);
   #endif  
	

   gen_file_name();
   
   // increment_file_no();

   get_header_dtls();

   dclr_specimen_register();

   do_report();


   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL COMMIT WORK; */ 

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

   if(nd_print_yn.arr[0] = 'Y')
      print_job();

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


   sprintf(string_var, "Oracle error at main() occured.... %s\n",sqlca.sqlerrm.sqlerrmc);
   disp_message(ORA_MESG,string_var);

   //c printf("Oracle error at main() occured....\n");
   //c printf("%s\n", sqlca.sqlerrm.sqlerrmc);
   
   proc_exit();
}   


get_legend_value(int cou)
 {
	/* EXEC SQL EXECUTE
	BEGIN
	  SM_POPULATE_REPORT_LEGEND.FETCH_LEGEND (:nd_operating_facility_id,:language_id,'RLRSNOMD.LEGEND_');
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin SM_POPULATE_REPORT_LEGEND . FETCH_LEGEND ( :nd_operati\
ng_facility_id , :language_id , 'RLRSNOMD.LEGEND_' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )66;
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
               :l_translated_value :=    GET_LEGEND(LTRIM(RTRIM('RLRSNOMD.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009'))))));
		END;
		END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin :l_translated_value := GET_LEGEND ( LTRIM ( RTRIM ( '\
RLRSNOMD.LEGEND_' || LTRIM ( RTRIM ( TO_CHAR ( :i , '009' ) ) ) ) ) ) ; END ;";
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

		//sp_message(ERR_MESG,l_translated_value.arr);

		strcpy(local_legend[i],l_translated_value.arr);

	}
 }
/******** added for globalisation end ******************/


/* get the header details */
void get_header_dtls()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL SELECT ACC_ENTITY_NAME, /o description of the institution o/
				   USER,TO_CHAR(SYSDATE, 'DD/MM/YYYY HH24:MI')
	          INTO d_acc_entity_name,:d_user,:d_sysdate
              FROM SY_ACC_ENTITY_lang_vw
			  WHERE ACC_ENTITY_ID = :nd_operating_facility_id
			  AND language_id = :language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 5;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select ACC_ENTITY_NAME ,USER ,TO_CHAR(SYSDATE,'DD/MM/YYYY \
HH24:MI') into :b0,:b1,:b2  from SY_ACC_ENTITY_lang_vw where (ACC_ENTITY_ID=:b\
3 and language_id=:b4)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )112;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_acc_entity_name;
   sqlstm.sqhstl[0] = (unsigned int  )302;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_user;
   sqlstm.sqhstl[1] = (unsigned int  )23;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_sysdate;
   sqlstm.sqhstl[2] = (unsigned int  )19;
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
   if (sqlca.sqlcode < 0) goto err_exit;
}



  d_acc_entity_name.arr[d_acc_entity_name.len] = '\0';
  d_user.arr[d_user.len]                       = '\0';
  d_sysdate.arr[d_sysdate.len]                 = '\0';

  #ifdef DEBUG
   printf("d_acc_entity_name = %s\n", d_acc_entity_name.arr);
   printf("d_user = %s\n", d_user.arr);
   printf("d_sysdate = %s\n", d_sysdate.arr);
  #endif

  return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 5;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )147;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   
   sprintf(string_var, "Oracle error at get_header_dtls() occured.... %s\n",sqlca.sqlerrm.sqlerrmc);
   disp_message(ORA_MESG,string_var);
   
   proc_exit();

   //c printf("Oracle error at get_header_dtls() occured....\n");
   //c printf("%s\n", sqlca.sqlerrm.sqlerrmc);
   //c exit(1);
}
 

/* function declares SPECIMEN_REGISTER cursor */
void dclr_specimen_register()
{

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    strcpy(sql_stmt, 
      "SELECT /*+ INDEX (RL_REQUEST_HEADER RL_REQUEST_HEADER_I5) */ SPECIMEN_NO,PATIENT_ID,SOURCE_CODE,EPISODE_TYPE, \
       CONSULTANT_CODE,TO_CHAR(SPEC_REGD_DATE_TIME,'DD/MM/YYYY HH24:MI') \
       FROM RL_REQUEST_HEADER ");

	strcat(sql_stmt,   
        " WHERE SPEC_REGD_DATE_TIME >= TO_DATE(:nd_from_date,'dd/mm/yyyy') \
          AND SPEC_REGD_DATE_TIME < (TO_DATE(:nd_to_date,'dd/mm/yyyy') + 1) \
		  AND OPERATING_FACILITY_ID = :nd_operating_facility_id \
		  AND (PATIENT_ID, SPECIMEN_NO, OPERATING_FACILITY_ID) IN ");
	
	if(nd_intersect_or.arr[0] = 'I')
	{
	   if (nd_count.arr[0] == '1')
	   {
		 strcat(sql_stmt,
		 " (SELECT /*+ INDEX (RL_RESULT_SNOMED RL_RESULT_SNOMED_I1) */ PATIENT_ID, SPECIMEN_NO, OPERATING_FACILITY_ID FROM RL_RESULT_SNOMED \
				 WHERE PATIENT_ID = RL_REQUEST_HEADER.PATIENT_ID \
				 AND SPECIMEN_NO = RL_REQUEST_HEADER.SPECIMEN_NO \
				 AND OPERATING_FACILITY_ID = :nd_operating_facility_id \
				 AND (SNOMED_CODE = :nd_snomed_code1 OR SNOMED_CODE_2 = :nd_snomed_code1))");

	   }

	   if (nd_count.arr[0] == '2')
	   {
		 strcat(sql_stmt,
		 " (SELECT /*+ INDEX (RL_RESULT_SNOMED RL_RESULT_SNOMED_I1) */ PATIENT_ID, SPECIMEN_NO, OPERATING_FACILITY_ID FROM RL_RESULT_SNOMED \
				WHERE PATIENT_ID = RL_REQUEST_HEADER.PATIENT_ID \
				AND SPECIMEN_NO = RL_REQUEST_HEADER.SPECIMEN_NO \
				AND OPERATING_FACILITY_ID = :nd_operating_facility_id \
				AND (SNOMED_CODE = :nd_snomed_code1 OR SNOMED_CODE_2 = :nd_snomed_code1) \
				INTERSECT \
				SELECT /*+ INDEX (RL_RESULT_SNOMED RL_RESULT_SNOMED_I1) */ PATIENT_ID, SPECIMEN_NO, OPERATING_FACILITY_ID FROM RL_RESULT_SNOMED \
				WHERE PATIENT_ID = RL_REQUEST_HEADER.PATIENT_ID \
				AND SPECIMEN_NO = RL_REQUEST_HEADER.SPECIMEN_NO \
				AND OPERATING_FACILITY_ID = :nd_operating_facility_id \
				AND (SNOMED_CODE = :nd_snomed_code2 OR SNOMED_CODE_2 = :nd_snomed_code2))");
	   }
	   if (nd_count.arr[0] == '3')
	   {
		 strcat(sql_stmt,
		 " (SELECT /*+ INDEX (RL_RESULT_SNOMED RL_RESULT_SNOMED_I1) */ PATIENT_ID, SPECIMEN_NO, OPERATING_FACILITY_ID FROM RL_RESULT_SNOMED \
				WHERE PATIENT_ID = RL_REQUEST_HEADER.PATIENT_ID \
				AND SPECIMEN_NO = RL_REQUEST_HEADER.SPECIMEN_NO \
				AND OPERATING_FACILITY_ID = :nd_operating_facility_id \
				AND (SNOMED_CODE = :nd_snomed_code1 OR SNOMED_CODE_2 = :nd_snomed_code1) \
				INTERSECT \
				SELECT /*+ INDEX (RL_RESULT_SNOMED RL_RESULT_SNOMED_I1) */ PATIENT_ID, SPECIMEN_NO, OPERATING_FACILITY_ID FROM RL_RESULT_SNOMED \
				WHERE PATIENT_ID = RL_REQUEST_HEADER.PATIENT_ID \
				AND SPECIMEN_NO = RL_REQUEST_HEADER.SPECIMEN_NO \
				AND OPERATING_FACILITY_ID = :nd_operating_facility_id \
				AND (SNOMED_CODE = :nd_snomed_code2 OR SNOMED_CODE_2 = :nd_snomed_code2) \
				INTERSECT \
				SELECT /*+ INDEX (RL_RESULT_SNOMED RL_RESULT_SNOMED_I1) */ PATIENT_ID, SPECIMEN_NO, OPERATING_FACILITY_ID FROM RL_RESULT_SNOMED \
				WHERE PATIENT_ID = RL_REQUEST_HEADER.PATIENT_ID \
				AND SPECIMEN_NO = RL_REQUEST_HEADER.SPECIMEN_NO \
				AND OPERATING_FACILITY_ID = :nd_operating_facility_id \
				AND (SNOMED_CODE = :nd_snomed_code3 OR SNOMED_CODE_2 = :nd_snomed_code3))");
	   }
	   if (nd_count.arr[0] == '4')
	   {
		 strcat(sql_stmt,
		 " (SELECT /*+ INDEX (RL_RESULT_SNOMED RL_RESULT_SNOMED_I1) */ PATIENT_ID, SPECIMEN_NO, OPERATING_FACILITY_ID FROM RL_RESULT_SNOMED \
				WHERE PATIENT_ID = RL_REQUEST_HEADER.PATIENT_ID \
				AND SPECIMEN_NO = RL_REQUEST_HEADER.SPECIMEN_NO \
				AND OPERATING_FACILITY_ID = :nd_operating_facility_id \
				AND (SNOMED_CODE = :nd_snomed_code1 OR SNOMED_CODE_2 = :nd_snomed_code1) \
				INTERSECT \
				SELECT /*+ INDEX (RL_RESULT_SNOMED RL_RESULT_SNOMED_I1) */ PATIENT_ID, SPECIMEN_NO, OPERATING_FACILITY_ID FROM RL_RESULT_SNOMED \
				WHERE PATIENT_ID = RL_REQUEST_HEADER.PATIENT_ID \
				AND SPECIMEN_NO = RL_REQUEST_HEADER.SPECIMEN_NO \
				AND OPERATING_FACILITY_ID = :nd_operating_facility_id \
				AND (SNOMED_CODE = :nd_snomed_code2 OR SNOMED_CODE_2 = :nd_snomed_code2) \
				INTERSECT \
				SELECT /*+ INDEX (RL_RESULT_SNOMED RL_RESULT_SNOMED_I1) */ PATIENT_ID, SPECIMEN_NO, OPERATING_FACILITY_ID FROM RL_RESULT_SNOMED \
				WHERE PATIENT_ID = RL_REQUEST_HEADER.PATIENT_ID \
				AND SPECIMEN_NO = RL_REQUEST_HEADER.SPECIMEN_NO \
				AND OPERATING_FACILITY_ID = :nd_operating_facility_id \
				AND (SNOMED_CODE = :nd_snomed_code3 OR SNOMED_CODE_2 = :nd_snomed_code3) \
				INTERSECT \
				SELECT /*+ INDEX (RL_RESULT_SNOMED RL_RESULT_SNOMED_I1) */ PATIENT_ID, SPECIMEN_NO, OPERATING_FACILITY_ID FROM RL_RESULT_SNOMED \
				WHERE PATIENT_ID = RL_REQUEST_HEADER.PATIENT_ID \
				AND SPECIMEN_NO = RL_REQUEST_HEADER.SPECIMEN_NO \
				AND OPERATING_FACILITY_ID = :nd_operating_facility_id \
				AND (SNOMED_CODE = :nd_snomed_code4 OR SNOMED_CODE_2 = :nd_snomed_code4))");
	   }
	}
	else
	{
	   if (nd_count.arr[0] == '1')
	   {
		 strcat(sql_stmt,
		 " AND SPECIMEN_NO IN \
			   (SELECT SPECIMEN_NO FROM RL_RESULT_SNOMED \
				 WHERE PATIENT_ID = PATIENT_ID \
				 AND OPERATING_FACILITY_ID = :nd_operating_facility_id \
				 AND (SNOMED_CODE = :nd_snomed_code1 OR SNOMED_CODE_2 = :nd_snomed_code1))");

	   }

	   if (nd_count.arr[0] == '2')
	   {
		 strcat(sql_stmt,
		 " AND SPECIMEN_NO IN \
			   (SELECT SPECIMEN_NO FROM RL_RESULT_SNOMED \
				WHERE PATIENT_ID = PATIENT_ID \
				AND OPERATING_FACILITY_ID = :nd_operating_facility_id \
				AND (SNOMED_CODE IN (:nd_snomed_code1, :nd_snomed_code2) OR \
				     SNOMED_CODE_2 IN (:nd_snomed_code1,:nd_snomed_code2)))");
	   }
	   if (nd_count.arr[0] == '3')
	   {
		 strcat(sql_stmt,
		 " AND SPECIMEN_NO IN \
			   (SELECT SPECIMEN_NO FROM RL_RESULT_SNOMED \
				WHERE PATIENT_ID = PATIENT_ID \
				AND OPERATING_FACILITY_ID = :nd_operating_facility_id \
				AND (SNOMED_CODE IN (:nd_snomed_code1, :nd_snomed_code2,:nd_snomed_code3) OR \
				     SNOMED_CODE_2 IN (:nd_snomed_code1,:nd_snomed_code2,:nd_snomed_code3)))");
	   }
	   if (nd_count.arr[0] == '4')
	   {
		 strcat(sql_stmt,
		 " AND SPECIMEN_NO IN \
			   (SELECT SPECIMEN_NO FROM RL_RESULT_SNOMED \
				WHERE PATIENT_ID = PATIENT_ID \
				AND OPERATING_FACILITY_ID = :nd_operating_facility_id \
				AND (SNOMED_CODE IN (:nd_snomed_code1, :nd_snomed_code2,:nd_snomed_code3,:nd_snomed_code4) OR \
				     SNOMED_CODE_2 IN (:nd_snomed_code1,:nd_snomed_code2,:nd_snomed_code3,:nd_snomed_code4)))");
	   }

	}

	strcat(sql_stmt, " AND NVL(CANCELLED_YN,'N') = 'N' ");
	strcat(sql_stmt, " ORDER BY SPECIMEN_NO");

/***
	strcat(sql_stmt,   
        " AND OPERATING_FACILITY_ID = :nd_operating_facility_id \
		  AND SPEC_REGD_DATE_TIME > TO_DATE(:nd_from_date,'dd/mm/yyyy') \
          AND SPEC_REGD_DATE_TIME < (TO_DATE(:nd_to_date,'dd/mm/yyyy') + 1) \
          ORDER BY SPECIMEN_NO");
**/


    /* EXEC SQL PREPARE S FROM :sql_stmt; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )162;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)sql_stmt;
    sqlstm.sqhstl[0] = (unsigned int  )10000;
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
    if (sqlca.sqlcode < 0) goto err_exit;
}


    /* EXEC SQL DECLARE SPECIMEN_REGISTER CURSOR FOR S; */ 


	if (nd_intersect_or.arr[0] == 'I') 
	{
		if (nd_count.arr[0] == '1')
			 /* EXEC SQL OPEN SPECIMEN_REGISTER USING :nd_from_date,:nd_to_date,
			                                       :nd_operating_facility_id,
			                                       :nd_operating_facility_id,
												   :nd_snomed_code1,:nd_snomed_code1; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 6;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )181;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_from_date;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_to_date;
    sqlstm.sqhstl[1] = (unsigned int  )23;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[2] = (unsigned int  )5;
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
    sqlstm.sqhstv[4] = (         void  *)&nd_snomed_code1;
    sqlstm.sqhstl[4] = (unsigned int  )23;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_snomed_code1;
    sqlstm.sqhstl[5] = (unsigned int  )23;
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


		if (nd_count.arr[0] == '2')
			 /* EXEC SQL OPEN SPECIMEN_REGISTER USING :nd_from_date,:nd_to_date,
			                                       :nd_operating_facility_id,
												   :nd_operating_facility_id,
												   :nd_snomed_code1,:nd_snomed_code1,
												   :nd_operating_facility_id,
												   :nd_snomed_code2,:nd_snomed_code2; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 9;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )220;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_from_date;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_to_date;
    sqlstm.sqhstl[1] = (unsigned int  )23;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[2] = (unsigned int  )5;
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
    sqlstm.sqhstv[4] = (         void  *)&nd_snomed_code1;
    sqlstm.sqhstl[4] = (unsigned int  )23;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_snomed_code1;
    sqlstm.sqhstl[5] = (unsigned int  )23;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[6] = (unsigned int  )5;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_snomed_code2;
    sqlstm.sqhstl[7] = (unsigned int  )23;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_snomed_code2;
    sqlstm.sqhstl[8] = (unsigned int  )23;
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
    if (sqlca.sqlcode < 0) goto err_exit;
}


		if (nd_count.arr[0] == '3')
			 /* EXEC SQL OPEN SPECIMEN_REGISTER USING :nd_from_date,:nd_to_date,
			                                       :nd_operating_facility_id,
												   :nd_operating_facility_id,
												   :nd_snomed_code1,:nd_snomed_code1,
												   :nd_operating_facility_id,
												   :nd_snomed_code2,:nd_snomed_code2,
												   :nd_operating_facility_id,
												   :nd_snomed_code3,:nd_snomed_code3; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )271;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_from_date;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_to_date;
    sqlstm.sqhstl[1] = (unsigned int  )23;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[2] = (unsigned int  )5;
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
    sqlstm.sqhstv[4] = (         void  *)&nd_snomed_code1;
    sqlstm.sqhstl[4] = (unsigned int  )23;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_snomed_code1;
    sqlstm.sqhstl[5] = (unsigned int  )23;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[6] = (unsigned int  )5;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_snomed_code2;
    sqlstm.sqhstl[7] = (unsigned int  )23;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_snomed_code2;
    sqlstm.sqhstl[8] = (unsigned int  )23;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[9] = (unsigned int  )5;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&nd_snomed_code3;
    sqlstm.sqhstl[10] = (unsigned int  )23;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&nd_snomed_code3;
    sqlstm.sqhstl[11] = (unsigned int  )23;
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
    if (sqlca.sqlcode < 0) goto err_exit;
}


		if (nd_count.arr[0] == '4')
			 /* EXEC SQL OPEN SPECIMEN_REGISTER USING :nd_from_date,:nd_to_date,
			                                       :nd_operating_facility_id,
												   :nd_operating_facility_id,
												   :nd_snomed_code1,:nd_snomed_code1,
												   :nd_operating_facility_id,
												   :nd_snomed_code2,:nd_snomed_code2,
												   :nd_operating_facility_id,
												   :nd_snomed_code3,:nd_snomed_code3,
												   :nd_operating_facility_id,
												   :nd_snomed_code4,:nd_snomed_code4; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 15;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )334;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_from_date;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_to_date;
    sqlstm.sqhstl[1] = (unsigned int  )23;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[2] = (unsigned int  )5;
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
    sqlstm.sqhstv[4] = (         void  *)&nd_snomed_code1;
    sqlstm.sqhstl[4] = (unsigned int  )23;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_snomed_code1;
    sqlstm.sqhstl[5] = (unsigned int  )23;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[6] = (unsigned int  )5;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_snomed_code2;
    sqlstm.sqhstl[7] = (unsigned int  )23;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_snomed_code2;
    sqlstm.sqhstl[8] = (unsigned int  )23;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[9] = (unsigned int  )5;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&nd_snomed_code3;
    sqlstm.sqhstl[10] = (unsigned int  )23;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&nd_snomed_code3;
    sqlstm.sqhstl[11] = (unsigned int  )23;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[12] = (unsigned int  )5;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&nd_snomed_code4;
    sqlstm.sqhstl[13] = (unsigned int  )23;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&nd_snomed_code4;
    sqlstm.sqhstl[14] = (unsigned int  )23;
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
    if (sqlca.sqlcode < 0) goto err_exit;
}


	}
	else
	{
		if (nd_count.arr[0] == '1')
			 /* EXEC SQL OPEN SPECIMEN_REGISTER USING :nd_from_date,:nd_to_date,
			                                       :nd_operating_facility_id,
			                                       :nd_operating_facility_id,
												   :nd_snomed_code1,:nd_snomed_code1; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 15;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )409;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_from_date;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_to_date;
    sqlstm.sqhstl[1] = (unsigned int  )23;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[2] = (unsigned int  )5;
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
    sqlstm.sqhstv[4] = (         void  *)&nd_snomed_code1;
    sqlstm.sqhstl[4] = (unsigned int  )23;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_snomed_code1;
    sqlstm.sqhstl[5] = (unsigned int  )23;
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


		if (nd_count.arr[0] == '2')
			 /* EXEC SQL OPEN SPECIMEN_REGISTER USING :nd_from_date,:nd_to_date,
			                                       :nd_operating_facility_id,
												   :nd_operating_facility_id,
												   :nd_snomed_code1,:nd_snomed_code2,
												   :nd_snomed_code1,:nd_snomed_code2; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 15;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )448;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_from_date;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_to_date;
    sqlstm.sqhstl[1] = (unsigned int  )23;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[2] = (unsigned int  )5;
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
    sqlstm.sqhstv[4] = (         void  *)&nd_snomed_code1;
    sqlstm.sqhstl[4] = (unsigned int  )23;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_snomed_code2;
    sqlstm.sqhstl[5] = (unsigned int  )23;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_snomed_code1;
    sqlstm.sqhstl[6] = (unsigned int  )23;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_snomed_code2;
    sqlstm.sqhstl[7] = (unsigned int  )23;
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
    if (sqlca.sqlcode < 0) goto err_exit;
}


		if (nd_count.arr[0] == '3')
			 /* EXEC SQL OPEN SPECIMEN_REGISTER USING :nd_from_date,:nd_to_date,
			                                       :nd_operating_facility_id,
												   :nd_operating_facility_id,
												   :nd_snomed_code1,:nd_snomed_code2,
												   :nd_snomed_code3,:nd_snomed_code1,
												   :nd_snomed_code2,:nd_snomed_code3; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 15;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )495;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_from_date;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_to_date;
    sqlstm.sqhstl[1] = (unsigned int  )23;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[2] = (unsigned int  )5;
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
    sqlstm.sqhstv[4] = (         void  *)&nd_snomed_code1;
    sqlstm.sqhstl[4] = (unsigned int  )23;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_snomed_code2;
    sqlstm.sqhstl[5] = (unsigned int  )23;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_snomed_code3;
    sqlstm.sqhstl[6] = (unsigned int  )23;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_snomed_code1;
    sqlstm.sqhstl[7] = (unsigned int  )23;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_snomed_code2;
    sqlstm.sqhstl[8] = (unsigned int  )23;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&nd_snomed_code3;
    sqlstm.sqhstl[9] = (unsigned int  )23;
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
    if (sqlca.sqlcode < 0) goto err_exit;
}


		if (nd_count.arr[0] == '4')
			 /* EXEC SQL OPEN SPECIMEN_REGISTER USING :nd_from_date,:nd_to_date,
			                                       :nd_operating_facility_id,
												   :nd_operating_facility_id,
												   :nd_snomed_code1,:nd_snomed_code2,
												   :nd_snomed_code3,:nd_snomed_code4,
												   :nd_snomed_code1,:nd_snomed_code2,
												   :nd_snomed_code3,:nd_snomed_code4; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 15;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )550;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_from_date;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_to_date;
    sqlstm.sqhstl[1] = (unsigned int  )23;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[2] = (unsigned int  )5;
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
    sqlstm.sqhstv[4] = (         void  *)&nd_snomed_code1;
    sqlstm.sqhstl[4] = (unsigned int  )23;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_snomed_code2;
    sqlstm.sqhstl[5] = (unsigned int  )23;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_snomed_code3;
    sqlstm.sqhstl[6] = (unsigned int  )23;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_snomed_code4;
    sqlstm.sqhstl[7] = (unsigned int  )23;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_snomed_code1;
    sqlstm.sqhstl[8] = (unsigned int  )23;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&nd_snomed_code2;
    sqlstm.sqhstl[9] = (unsigned int  )23;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&nd_snomed_code3;
    sqlstm.sqhstl[10] = (unsigned int  )23;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&nd_snomed_code4;
    sqlstm.sqhstl[11] = (unsigned int  )23;
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
    if (sqlca.sqlcode < 0) goto err_exit;
}


	}

   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

/*   EXEC SQL OPEN SPECIMEN_REGISTER;*/
  #ifdef DEBUG
    printf("leaving dclr_specimen_register()\n");
  #endif
 
  return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )613;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



   sprintf(string_var, "Oracle error at dclr_specimen_register() occured.... %s\n",sqlca.sqlerrm.sqlerrmc);
   disp_message(ORA_MESG,string_var);
   
   proc_exit();

   //c printf("Oracle error at dclr_specimen_register() occured....\n");
   //c printf("%s\n", sqlca.sqlerrm.sqlerrmc);
   //c exit(1);
}


/* prints the master-detail record until the cursor is empty */
void do_report()
{
  void prepare_new_page();
  void print_detl_rec();
  void end_report();
  int fetch_specimen_register();
  int still_rec_left;
  
  print_rep_header();

  page_no += 1; /* icrement by 1 as it is moving to second page */
  line_no = 6;

  print_page_header();
  print_col_heading();

  line_no +=4; /*incr. by 4 as col. headings occupy 4 lines */ 

  /* read the first cursor record */
  still_rec_left = fetch_specimen_register();

  #ifdef DEBUG
      printf("entered do_report()\n");
      fflush(stdout);
  #endif

  while(still_rec_left)
  {
       if(line_no >= MAX_LINES)
       {
          prepare_new_page();
          print_detl_rec();
       }
       else 
          print_detl_rec();

    nd_totl_specimens += 1;
    still_rec_left = fetch_specimen_register();
  }
  #ifdef DEBUG
      printf("entered do_report outside while()\n");
      fflush(stdout);
  #endif
  end_report();
}

/* prepares for the new page */
void prepare_new_page()
{
   #if DEBUG
     printf("entered prepare_new_page\n");
     fflush(stdout);
   #endif

   page_no += 1; /* incr. by 1 to move to subsequent pages */
   fprintf(f1,"");
   line_no = 6;
   print_page_header();
   print_col_heading(); 
   line_no += 4;
}

/* fetches the next record from SPECIMEN REGISTER CURSOR */
/* returns 0 if the end of cursor is reached else returns 1. */
int fetch_specimen_register()
{

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  /* EXEC SQL FETCH SPECIMEN_REGISTER INTO
          :d_specimen_no, :d_patient_id,
		  :d_source_code, :d_episode_type,
		  :d_consultant_code,:d_spec_date; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 15;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )628;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_specimen_no;
  sqlstm.sqhstl[0] = (unsigned int  )22;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_patient_id;
  sqlstm.sqhstl[1] = (unsigned int  )33;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_source_code;
  sqlstm.sqhstl[2] = (unsigned int  )9;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_episode_type;
  sqlstm.sqhstl[3] = (unsigned int  )6;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_consultant_code;
  sqlstm.sqhstl[4] = (unsigned int  )14;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_spec_date;
  sqlstm.sqhstl[5] = (unsigned int  )33;
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


   #ifdef DEBUG
    printf("SQLCA code after fetch :%d\n", sqlca.sqlcode);
   #endif

  if (NODATAFOUND)
    return 0;

  d_specimen_no.arr[d_specimen_no.len]      = '\0';
  d_patient_id.arr[d_patient_id.len]        = '\0';
  d_source_code.arr[d_source_code.len]      = '\0';
  d_consultant_code.arr[d_consultant_code.len]    = '\0';
  d_spec_date.arr[d_spec_date.len]          = '\0';
  d_episode_type.arr[d_episode_type.len]          = '\0';
#ifdef DEBUG
 printf("d_specimen_no = %s\n",d_specimen_no.arr);
 printf("d_patient_id = %s\n",d_patient_id.arr);
 printf("d_source_code = %s\n",d_source_code.arr);
 printf("d_consultant_code = %s\n",d_consultant_code.arr);
 printf("d_spec_date = %s\n",d_spec_date.arr);
#endif

  return 1;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )667;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



   sprintf(string_var, "Oracle error at fetch_specimen_register() occured.... %s\n",sqlca.sqlerrm.sqlerrmc);
   disp_message(ORA_MESG,string_var);
   
   proc_exit();
   
   //c printf("Oracle error at fetch_specimen_register() occured....\n");
   //c printf("%s\n", sqlca.sqlerrm.sqlerrmc);
   //c exit(1);
}
/* print the finishing line of the report */
void end_report()
{
  /*fprintf(f1,"\n\n\n"); */ /* Commented by durai against MF-SCF-00046 */
  fprintf(f1,"\n");
  fprintf(f1,"                                                   ");
  
  //fprintf(f1,"** End of Report **");
  fprintf(f1,"** %13.13s **",local_legend[17]);

  fprintf(f1,"");
}

/* to print the detailed record */
void print_detl_rec()
{
    int  get_in_patient_dtl(); 
    
	// void get_general_patient_dtl(),
	
	void get_referral_patient_dtl();
    
	int i = 0;
    /* Commented by Durai Rajkumar against MF-SCF-0058 on 06-Nov-08
	if(strcmp(d_episode_type.arr,"I")==0 || strcmp(d_episode_type.arr,"O")==0) */
	if(strcmp(d_episode_type.arr,"I")==0 || strcmp(d_episode_type.arr,"O")==0 || strcmp(d_episode_type.arr,"H")==0) /* Added by Durai Rajkumar against MF-SCF-0058 on 06-Nov-08*/
    { 
	  i = get_in_patient_dtl();
      
	  /**
	  if(i == 0)
         get_general_patient_dtl();
	  **/
    }
    else
    if(strcmp(d_episode_type.arr,"R")==0)
      get_referral_patient_dtl();

    /* EXEC SQL EXECUTE
		DECLARE
			t_date   date;
		BEGIN
			//GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:d_spec_date,'DD/MM/YYYY'), :language_id , t_date);
			//:d_spec_date1 := to_char(t_date,'DD/MM/YYYY');
			:d_spec_date1 :=sm_convert_date_2t(to_date(:d_spec_date,'DD/MM/YYYY '),:language_id);
		END;
	END-EXEC; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 15;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "declare t_date date ; BEGIN :d_spec_date1 := sm_convert_d\
ate_2t ( to_date ( :d_spec_date , 'DD/MM/YYYY ' ) , :language_id ) ; END ;";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )682;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_spec_date1;
    sqlstm.sqhstl[0] = (unsigned int  )33;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_spec_date;
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



	/* EXEC SQL EXECUTE
		DECLARE
			t_date   date;
		BEGIN
			//GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:d_dob,'DD/MM/YYYY'), :language_id , t_date);
			//:d_dob1 := to_char(t_date,'DD/MM/YYYY');
			:d_dob1 :=sm_convert_date_2t(to_date(:d_dob,'DD/MM/YYYY '),:language_id);
		END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 15;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN :d_dob1 := sm_convert_date_2t ( \
to_date ( :d_dob , 'DD/MM/YYYY ' ) , :language_id ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )709;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_dob1;
 sqlstm.sqhstl[0] = (unsigned int  )13;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_dob;
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



	fprintf(f1,"%-11.11s %-25.25s %-30.30s %-11.11s %-1.1s  %-4.4s     %-6.6s       %-16.16s\n",
	 d_specimen_no.arr,d_patient_name.arr,d_patient_id.arr,d_dob1.arr,
	 d_sex.arr,d_source_code.arr,d_consultant_code.arr,d_spec_date1.arr);
    line_no += 1;

    if(strlen(d_req_comment_1.arr))
    {
       fprintf(f1,"%82.82s%-41s\n"," ",d_req_comment_1.arr);
       line_no += 1;
    }
    if(strlen(d_req_comment_2.arr))
    {
       fprintf(f1,"%82.82s%-41s\n"," ",d_req_comment_2.arr);
       line_no += 1;
    }
    if(strlen(d_req_comment_3.arr))
    {
       fprintf(f1,"%82.82s%-41s\n"," ",d_req_comment_3.arr);
       line_no += 1;
    }
    fprintf(f1,"\n");
    line_no += 1;

return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )736;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



   sprintf(string_var, "Oracle error at print_detl_rec() occured.... %s\n",sqlca.sqlerrm.sqlerrmc);
   disp_message(ORA_MESG,string_var);
   
   proc_exit();

   //c printf("Oracle error at print_detl_rec() occured....\n");
   //c printf("%s\n", sqlca.sqlerrm.sqlerrmc);
   //c exit(1);
}

/* Function to fetch the GENERAL PATIENT details */

/*** Commented since Table not exist in ehdv 
void get_general_patient_dtl()
{
  EXEC SQL WHENEVER SQLERROR GOTO err_exit;
  EXEC SQL SELECT SUBSTR(SHORT_NAME,1,25),TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY'), SEX 
	       INTO :d_patient_name,:d_dob,:d_sex
           FROM MP_PATIENT_MAST_OTHERS
	       WHERE PATIENT_ID = :d_patient_id; 

  d_patient_name.arr[d_patient_name.len]     = '\0';
  d_dob.arr[d_dob.len]                       = '\0';
  d_sex.arr[d_sex.len]                       = '\0';

  #ifdef DEBUG
   printf("d_patient_name= %s\n", d_patient_name.arr);
  #endif

  return;

err_exit:
   EXEC SQL WHENEVER SQLERROR CONTINUE;
   EXEC SQL ROLLBACK WORK RELEASE;

   sprintf(string_var, "Oracle error at get_general_patient_dtl() occured.... %s\n",sqlca.sqlerrm.sqlerrmc);
   disp_message(ORA_MESG,string_var);
   proc_exit();
   
   //c printf("Oracle error at get_general_patient_dtl() occured....\n");
   //c printf("%s\n", sqlca.sqlerrm.sqlerrmc);
   //c exit(1);
}
***/

/* Function to fetch the REFERRAL PATIENT details */
void get_referral_patient_dtl()
{
  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  //EXEC SQL SELECT DECODE(:language_id,'en',SUBSTR(SHORT_NAME,1,25),'th',SUBSTR(SHORT_NAME_LOC_LANG,1,25)),TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY'),SEX							/* Commented by durai against MF-SCF-00046 */
  /* EXEC SQL SELECT DECODE(:language_id,'en',SUBSTR(short_name,1,25),NVL(SUBSTR(short_name_loc_lang,1,25),SUBSTR(short_name,1,25))),TO_CHAR(date_of_birth,'DD/MM/YYYY'),sex   /o Added by durai against MF-SCF-00046 o/	       
		   INTO   :d_patient_name,:d_dob,:d_sex
           // FROM   MP_PATIENT_MAST_REFERRALS
		   FROM   RL_PATIENT_MAST
	       WHERE  PATIENT_ID = :d_patient_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 15;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select DECODE(:b0,'en',SUBSTR(short_name,1,25),NVL(SUBSTR(s\
hort_name_loc_lang,1,25),SUBSTR(short_name,1,25))) ,TO_CHAR(date_of_birth,'DD/\
MM/YYYY') ,sex into :b1,:b2,:b3  from RL_PATIENT_MAST where PATIENT_ID=:b4";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )751;
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
  sqlstm.sqhstv[1] = (         void  *)&d_patient_name;
  sqlstm.sqhstl[1] = (unsigned int  )242;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_dob;
  sqlstm.sqhstl[2] = (unsigned int  )13;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_sex;
  sqlstm.sqhstl[3] = (unsigned int  )4;
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
  if (sqlca.sqlcode < 0) goto err_exit;
}


		   
  d_patient_name.arr[d_patient_name.len]     = '\0';
  d_dob.arr[d_dob.len]                       = '\0';
  d_sex.arr[d_sex.len]                       = '\0';

  #ifdef DEBUG
   printf("d_patient_name= %s\n", d_patient_name.arr);
  #endif

  return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )786;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   sprintf(string_var, "Oracle error at get_referral_patient_dtl() occured.... %s\n",sqlca.sqlerrm.sqlerrmc);
   disp_message(ORA_MESG,string_var);
   proc_exit();

   //c printf("Oracle error at get_referral_patient_dtl() occured....\n");
   //c printf("%s\n", sqlca.sqlerrm.sqlerrmc);
   //c exit(1);
}

/* Function to fetch the INPATIENT details */
int get_in_patient_dtl()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   //EXEC SQL SELECT DECODE(:language_id,'en',SUBSTR(SHORT_NAME,1,25),'th',SUBSTR(SHORT_NAME_LOC_LANG,1,25)),TO_CHAR(DATE_OF_BIRTH,'DD/MM/YY'),SEX							/* Commented by durai against MF-SCF-00046 */
   /* EXEC SQL SELECT DECODE(:language_id,'en',SUBSTR(short_name,1,25),NVL(SUBSTR(short_name_loc_lang,1,25),SUBSTR(short_name,1,25))),TO_CHAR(date_of_birth,'DD/MM/YYYY'),sex   /o Added by durai against MF-SCF-00046 o/     
			INTO   :d_patient_name,:d_dob,:d_sex
            FROM   MP_PATIENT_MAST 
	        WHERE  PATIENT_ID = :d_patient_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select DECODE(:b0,'en',SUBSTR(short_name,1,25),NVL(SUBSTR(\
short_name_loc_lang,1,25),SUBSTR(short_name,1,25))) ,TO_CHAR(date_of_birth,'DD\
/MM/YYYY') ,sex into :b1,:b2,:b3  from MP_PATIENT_MAST where PATIENT_ID=:b4";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )801;
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
   sqlstm.sqhstv[1] = (         void  *)&d_patient_name;
   sqlstm.sqhstl[1] = (unsigned int  )242;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_dob;
   sqlstm.sqhstl[2] = (unsigned int  )13;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_sex;
   sqlstm.sqhstl[3] = (unsigned int  )4;
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
   if (sqlca.sqlcode < 0) goto err_exit;
}



  if(NODATAFOUND)
     return 0;
  d_patient_name.arr[d_patient_name.len]     = '\0';
  d_dob.arr[d_dob.len]                       = '\0';
  d_sex.arr[d_sex.len]                       = '\0';

  #ifdef DEBUG
   printf("d_patient_name= %s\n", d_patient_name.arr);
  #endif

  return 1;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )836;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



   sprintf(string_var, "Oracle error at get_in_patient_dtl() occured.... %s\n",sqlca.sqlerrm.sqlerrmc);
   disp_message(ORA_MESG,string_var);
   proc_exit();

   //c printf("Oracle error at get_in_patient_dtl() occured....\n");
   //c printf("%s\n", sqlca.sqlerrm.sqlerrmc);
   //c exit(1);
}

/* to print page headers the header details */ 
void print_page_header()
{
 register int i;
 static int first = 1;
 char buf[15];
 int col;
 fprintf(f1,"%c&l1O",ESC);
 fprintf(f1,"%c&k4S",ESC);
 /* Added by durai against MF-SCF-00046 */
 
 if (first)
 {
 memset(hdr_line1, ' ', REP_WIDTH+1);
 memset(hdr_line2,' ',REP_WIDTH+1);
 memset(hdr_line4,'-',REP_WIDTH);		/* Added by Durai Rajkumar against 6187 */
 hdr_line4[REP_WIDTH] = '\0';			
 strncpy(hdr_line1,"MDL : RL",8);
 col = (int)(REP_WIDTH-strlen(d_acc_entity_name.arr))/2;
 strncpy(hdr_line1+col,d_acc_entity_name.arr,strlen(d_acc_entity_name.arr));
 /* Ends against MF-SCF-00046 */
 /* Commented by durai against MF-SCF-00046 
 fprintf(f1,"MDL : RL    ");
 fprintf(f1,"                                               ");  
 fprintf(f1,"%s", d_acc_entity_name.arr);
 fprintf(f1,"                         ");  
 //fprintf(f1,"%s", d_sysdate.arr);   */
 /* EXEC SQL EXECUTE
	DECLARE
		t_date   date;
	BEGIN
		//t_date := GET_LOCALE_DATE.GET_CURRENT_DATE(:language_id);
		//:d_sysdate1 := to_char(t_date,'DD/MM/YYYY HH24:MI');
		:d_sysdate1 :=sm_convert_datetime_2t(SYSDATE,:language_id);
	END;
 END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 15;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN :d_sysdate1 := sm_convert_dateti\
me_2t ( SYSDATE , :language_id ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )851;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_sysdate1;
 sqlstm.sqhstl[0] = (unsigned int  )19;
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


 /* Commented by durai against MF-SCF-00046
 fprintf(f1,"%s", d_sysdate1.arr);
 fprintf(f1,"\n");
 fprintf(f1,"OPR : %s", d_user.arr);
 fprintf(f1,"                                    ");  
  //fprintf(f1,"              SNOMED LIST         ");
 fprintf(f1,"              %11.11         ",local_legend[1]);
 fprintf(f1,"                                  ");  
  //fprintf(f1,"Page : %4d", page_no);
 fprintf(f1,"%4.4s : %4d", local_legend[2],page_no);
 fprintf(f1,"\n");
 fprintf(f1,"REP : RLRSNOMD");
 fprintf(f1,"\n");                    */
 /* Added by durai against MF-SCF-00046 */
 col = (REP_WIDTH-strlen(d_sysdate1.arr));
 strcpy(hdr_line1+col,d_sysdate1.arr);
    
 strncpy(hdr_line2,"OPR :",5);
 strcpy(hdr_line2+6,d_user.arr);
 }
 memset(hdr_line3,' ',REP_WIDTH+1);
 strncpy(hdr_line3,"REP : RLRSNOMD",14);
 strcpy(rep_title1,local_legend[1]);
 col = (int)(REP_WIDTH-strlen(rep_title1))/2;
 strncpy(hdr_line3+col,rep_title1,strlen(rep_title1));
 //sprintf(buf,"PAGE : %4d",page_no);
 sprintf(buf,"%s : %4d",local_legend[2], page_no); 
 strcpy(hdr_line3+(REP_WIDTH-strlen(buf)),buf);
 if(first)
   fprintf(f1,"%s\n",hdr_line1);
 else
  {
    fprintf(f1,"\n");
	fprintf(f1,"%s\n",hdr_line1);
  }
  fprintf(f1,"%s\n",hdr_line2);
  fprintf(f1,"%s\n",hdr_line3);
  fprintf(f1,"%s\n",hdr_line4);			/* Added by Durai Rajkumar against 6187 */
  first = 0;
 /* Ends against MF-SCF-00046 */

}


/* print the heading */
void print_col_heading()
{

 /*fprintf(f1,"--------------------------------------------------------------------");
 fprintf(f1,"------------------------------------------------------------");
 fprintf(f1,"\n");*/					/* Commented by Durai Rajkumar against 6187 */

 /* line 1 */
 //fprintf(f1,"SPECIMEN    PATIENT'S NAME            PATIENT NO                     D.O.B.     SEX SOURCE   CONSULTANT   SPEC.DATE\n");
 //fprintf(f1,"NO                                                                                  CODE     CODE");

 fprintf(f1,"%8.8s    %12.12s            %10.10s                     %6.6s     %3.3s %6.6s   %10.10s   %9.9s\n",
			local_legend[7],local_legend[8],local_legend[9],local_legend[10],local_legend[11],local_legend[12],local_legend[13],local_legend[14]);
 fprintf(f1,"%2.2s                                                                                  %4.4s     %4.4s",local_legend[16],local_legend[15],local_legend[15]);

 fprintf(f1,"\n");
 /*fprintf(f1,"--------------------------------------------------------------------");
 fprintf(f1,"------------------------------------------------------------");*/			/* Commented by Durai Rajkumar against 6187 */
 fprintf(f1,"%s",hdr_line4);			/* Added by Durai Rajkumar against 6187 */
 fprintf(f1,"\n");
}

/*--------------------------------------------------------------------------*/
gen_file_name()
{
     nd_file_name.arr[0]   = '\0';
     nd_file_name.len      = 0;
	 strcpy(OUTPUT_FILE_NAME,"rlrsnomd.lis");
	 strcpy(nd_file_name.arr,WORKING_DIR);
	 strcat(nd_file_name.arr,"rlrsnomd.lis");
     
     if ((f1 = fopen(nd_file_name.arr,"w")) == NULL)
     {
       sprintf(string_var,"Error while opening file %s\n",nd_file_name.arr);
	   disp_message(ERR_MESG,string_var) ;
       proc_exit();
     }
	 /*{
	     fprintf(f1,"%c&|26A",ESC);
		 fprintf(f1,"%c&a90P",ESC);
	     fprintf(f1,"%c&|1O",ESC);
	     fprintf(f1,"%c&k4S",ESC);
	 }*/


}

/***
gen_file_name()
{
     nd_file_name.arr[0]   = '\0';
     nd_file_name.len      = 0;

     EXEC SQL SELECT DECODE(PRINT_FILE_NO,NULL,'0',TO_CHAR(PRINT_FILE_NO)),
		             LOWER(USER)
	          INTO :nd_file_no,:nd_user
	          FROM RL_PARAM;

     if (ERROR)
         //c err_mesg("Fetch failed on table RL_PARAM",0,"");
		 disp_message(ERR_MESG, "Fetch failed on table RL_PARAM");
      
     nd_file_no.arr[nd_file_no.len] = '\0';
     nd_user.arr[nd_user.len] = '\0';
     sprintf(nd_file_name.arr,"rlrsnomd_%s.lis",nd_file_no.arr);

     if ((f1 = fopen(nd_file_name.arr,"w")) == NULL)
     {
       //c printf("Error while opening file %s\n",nd_file_name.arr);

       sprintf(string_var, "Error while opening file  %s\n",nd_file_name.arr);
       disp_message(ERR_MESG,string_var);
       proc_exit();

       //c exit(0);
     }

}
***/
/*--------------------------------------------------------------------------*/
/***
increment_file_no()
{
  
  EXEC SQL UPDATE RL_PARAM
		SET PRINT_FILE_NO = NVL(PRINT_FILE_NO,0) + 1;

  if (ERROR)
    disp_message(ERR_MESG,"Update failed on table RL_PARAM");
	//c err_mesg("Update failed on table RL_PARAM",0,"");
	


  EXEC SQL COMMIT WORK;
    if (ERROR)
      disp_message(ERR_MESG,"COMMIT failed");
	  //c err_mesg("COMMIT failed",0,"");

}
***/

/*--------------------------------------------------------------------------*/
/****
print_job()
{
	char command_line[500];

	nd_printer_name.arr[0]   = '\0';
	nd_printer_name.len      = 0;

	EXEC SQL SELECT PRINTER_NAME
		 INTO :nd_printer_name
		 FROM RL_SECTION_CODE
		 WHERE SECTION_CODE = :nd_section_code;

	if (ERROR)
	  disp_message(ERR_MESG,"Fetch failed on table RL_SECTION_CODE");
      //c err_mesg("Fetch failed on table RL_SECTION_CODE",0,"");
	
	nd_printer_name.arr[nd_printer_name.len] = '\0';

	sprintf(command_line,"lp -s -d %s rlrsnomd_%s.lis ",nd_printer_name.arr,nd_file_no.arr);
	system(command_line);
}
***/

print_job()
{
	if (strcmp(nd_trx_ind.arr,"Y") == 0)

		 PrintDocument
			   (
				uid_pwd.arr,		             //char	*PUidPwd;
				nd_session_id.arr,	             //char	*PSessionID;
				nd_operating_facility_id.arr,	 //char	*PFacilityID;
				"RL",				             //char	*PModuleID;
				"RLRSNOMD",			             //char	*PDocumentID;
				nd_file_name.arr,			     //char	*POnlinePrintFileNames;
				"O",				             //char	*PLocationTypes;
				nd_section_code.arr,			 //char	*PLocationCodes;
				1,					             //int		PNumOfCopies;
				1,					             //int		PPageFrom;
				9999					         //int		PPageTo;
			   );
						   

	else 

		 PrintDocument
			   (
				uid_pwd.arr,		            //char	*PUidPwd;
				nd_session_id.arr,	            //char	*PSessionID;
				nd_operating_facility_id.arr,	//char	*PFacilityID;
				"RL",				            //char	*PModuleID;
				"RLRSNOMD",			            //char	*PDocumentID;
				nd_file_name.arr,			    //char	*POnlinePrintFileNames;
				"O",				            //char	*PLocationTypes;
				"~",				            //char	*PLocationCodes;
				1,					            //int		PNumOfCopies;
				1,					            //int		PPageFrom;
				9999					        //int		PPageTo;
			   );  
}

/*--------------------------------------------------------------------------*/

/* to print the header page for the report */
print_rep_header()
{
  char nd_fr_process_date_desc[11],
       nd_to_process_date_desc[11],
       nd_snomed_desc1        [41],
       nd_snomed_desc2        [41],
       nd_snomed_desc3        [41],
       nd_snomed_desc4        [41];
  
  if(strcmp(nd_from_date.arr, "01/01/1900") == 0)
    //strcpy(nd_fr_process_date_desc, "LOWEST");
	strcpy(nd_fr_process_date_desc, local_legend[18]);
    else		/* Added by durai against MF-SCF-00046 */
	{ 
	  /* EXEC SQL EXECUTE
		DECLARE
			l_fr_date   date;
		BEGIN
			//GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:nd_from_date,'DD/MM/YYYY'), :language_id , l_fr_date);
			//:nd_from_date1 := to_char(l_fr_date,'DD/MM/YYYY');
			:nd_from_date1 :=sm_convert_date_2t(to_date(:nd_from_date,'DD/MM/YYYY '),:language_id);
		END;
	 END-EXEC; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "declare l_fr_date date ; BEGIN :nd_from_date1 := sm_conver\
t_date_2t ( to_date ( :nd_from_date , 'DD/MM/YYYY ' ) , :language_id ) ; END ;";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )874;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_from_date1;
   sqlstm.sqhstl[0] = (unsigned int  )23;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_from_date;
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


	 strcpy(nd_fr_process_date_desc, nd_from_date1.arr);
	}			/* Ends against MF-SCF-00046 */

  if(strcmp(nd_to_date.arr, "31/12/2100") == 0)
    //strcpy(nd_to_process_date_desc, "HIGHEST");
	strcpy(nd_to_process_date_desc, local_legend[19]);
    else		/* Added by durai against MF-SCF-00046 */
	{ 
	  /* EXEC SQL EXECUTE
		DECLARE
			l_to_date   date;
		BEGIN
			//GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:nd_to_date,'DD/MM/YYYY'), :language_id , l_to_date);
			//:nd_to_date1 := to_char(l_to_date,'DD/MM/YYYY');
			:nd_to_date1 :=sm_convert_date_2t(to_date(:nd_to_date,'DD/MM/YYYY '),:language_id);
		END;
	 END-EXEC; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "declare l_to_date date ; BEGIN :nd_to_date1 := sm_convert_\
date_2t ( to_date ( :nd_to_date , 'DD/MM/YYYY ' ) , :language_id ) ; END ;";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )901;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_to_date1;
   sqlstm.sqhstl[0] = (unsigned int  )23;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_to_date;
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


	 strcpy(nd_to_process_date_desc, nd_to_date1.arr);
	}			/* Ends against MF-SCF-00046 */

  strcpy(nd_snomed_desc1,nd_snomed_code1.arr);
  strcpy(nd_snomed_desc2,nd_snomed_code2.arr);
  strcpy(nd_snomed_desc3,nd_snomed_code3.arr);
  strcpy(nd_snomed_desc4,nd_snomed_code4.arr);


  if(strcmp(nd_snomed_code1.arr, "!!!!!!!!!!") == 0)
    strcpy(nd_snomed_desc1, "");
    else strcpy(nd_snomed_desc1, nd_snomed_code1.arr);

  if(strcmp(nd_snomed_code2.arr, "!!!!!!!!!!") == 0)
    strcpy(nd_snomed_desc2, "");
    else strcpy(nd_snomed_desc2, nd_snomed_code2.arr);

  if(strcmp(nd_snomed_code3.arr, "!!!!!!!!!!") == 0)
    strcpy(nd_snomed_desc3, "");
    else strcpy(nd_snomed_desc3, nd_snomed_code3.arr);

  if(strcmp(nd_snomed_code4.arr, "!!!!!!!!!!") == 0)
    strcpy(nd_snomed_desc4, "");
    else strcpy(nd_snomed_desc4, nd_snomed_code4.arr);

  page_no++;
  print_page_header();

  fprintf(f1,VER);
  fprintf(f1,"\n\n\n\n");
  fprintf(f1,"        ");
  
  //fprintf(f1,"INPUT PARAMETERS :\n");
  fprintf(f1,"%16.16s :\n",local_legend[3]);

  fprintf(f1,"        ");
  fprintf(f1,"------------------\n\n");
  fprintf(f1,"                ");
  
  //fprintf(f1,"SNOMED CODE 1     : %s\n", nd_snomed_desc1);
  fprintf(f1,"%11.11s 1     : %s\n", local_legend[4],nd_snomed_desc1);

  fprintf(f1,"                ");
  
  //fprintf(f1,"SNOMED CODE 2     : %s\n", nd_snomed_desc2);
  fprintf(f1,"%11.11s 2     : %s\n", local_legend[4],nd_snomed_desc2);

  fprintf(f1,"                ");
  
  //fprintf(f1,"SNOMED CODE 3     : %s\n", nd_snomed_desc3);
  fprintf(f1,"%11.11s 3     : %s\n", local_legend[4],nd_snomed_desc3);

  fprintf(f1,"                ");
  
  //fprintf(f1,"SNOMED CODE 4     : %s\n", nd_snomed_desc4);
  fprintf(f1,"%11.11s 4     : %s\n", local_legend[4],nd_snomed_desc4);

  fprintf(f1,"\n");
  fprintf(f1,"                ");
  
  //fprintf(f1,"PROCESS DATE FROM : %s\n", nd_fr_process_date_desc);
  fprintf(f1,"%17.17s : %s\n", local_legend[5],nd_fr_process_date_desc);

  fprintf(f1,"                ");
  
  //fprintf(f1,"               TO : %s\n", nd_to_process_date_desc); 
  fprintf(f1,"               %2.2s : %s\n", local_legend[6],nd_to_process_date_desc); 

  fprintf(f1,"");
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



#undef DEBUG
#undef NODATAFOUND
#undef MAX_LINES
#undef VER
