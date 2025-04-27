
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
           char  filnam[50];
};
static const struct sqlcxp sqlfpn =
{
    49,
    "D:\\RISReports\\ProcReportsAll\\RDROUTOR\\RDROUTOR.PC"
};


static unsigned long sqlctx = 1566125477;


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
            void  *sqhstv[14];
   unsigned int   sqhstl[14];
            int   sqhsts[14];
            void  *sqindv[14];
            int   sqinds[14];
   unsigned int   sqharm[14];
   unsigned int   *sqharc[14];
   unsigned short  sqadto[14];
   unsigned short  sqtdso[14];
} sqlstm = {10,14};

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
"select B.section_code ,A.order_type_code ,A.order_id ,TO_CHAR(A.order_date_t\
ime,'DD/MM/YYYY') ,A.patient_id ,A.episode_type ,A.episode_id ,A.visit_id ,A.s\
ource_code ,A.physician_id ,A.order_status ,A.item_code ,C.short_desc ,A.order\
_line_status  from rd_pending_orders A ,rd_exams B ,or_order_catalog C where (\
((((A.item_code=B.order_catalog_code and C.order_catalog_code=A.item_code) and\
 A.ORDER_LINE_STATUS=(select ORDER_STATUS_CODE  from OR_ORDER_STATUS_CODE wher\
e ORDER_STATUS_TYPE='10')) and TRUNC(A.TEST_DATE_TIME) between TO_DATE(NVL(:b0\
,'01/01/1800'),'DD/MM/YYYY') and TO_DATE(NVL(:b1,'31/12/4712'),'DD/MM/YYYY')) \
and B.section_code between :b2 and :b3) and A.appt_reqd_yn=DECODE(:b4,'A',A.ap\
pt_reqd_yn,:b4)) order by 1,3            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,178,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,232,0,4,219,0,0,11,4,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
95,0,0,3,165,0,4,262,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
130,0,0,4,0,0,30,301,0,0,0,0,0,1,0,
145,0,0,5,127,0,2,312,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
176,0,0,6,0,0,13,441,0,0,14,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
247,0,0,6,741,0,9,517,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,
286,0,0,7,107,0,4,589,0,0,3,1,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,
313,0,0,8,159,0,4,615,0,0,6,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,
9,0,0,
352,0,0,9,128,0,4,647,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
383,0,0,10,95,0,4,663,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
410,0,0,11,116,0,4,681,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
441,0,0,12,98,0,4,699,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
468,0,0,13,201,0,4,723,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
499,0,0,14,111,0,4,748,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
526,0,0,15,322,0,6,1119,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,3,3,0,0,2,9,0,0,
557,0,0,16,112,0,6,1153,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
580,0,0,17,136,0,6,1166,0,0,2,2,0,1,0,2,9,0,0,1,3,0,0,
};


/****************************************************************************/
/* Program ID             : RDROUTOR.PC                                     */
/* -------------------------------------------------------------------------*/
/* Author				: Vasant Kumar										*/
/* Version				: 1.10.01											*/
/* Created On			: 05/04/1994										*/
/* Modified On			:													*/
/* Description			: This Function Prints the Orders with Items not	*/
/*                           Registered.									*/
/*--------------------------------------------------------------------------*/
/* Parameters to Execute: Userid/Password, Session_id, Program Date			*/
/* Usage				: RDROUTOR userid/password session_id pgm_date		*/
/*                                                                          */
/* VERSION				: eHIS 4.1                                          */
/*                                                                          */
/* AUTHOR				: Rajanish Nambiar                                  */
/*                                                                          */
/* DATE MODIFIED		: 23/Aug/2003                                       */
/*                                                                          */
/****************************************************************************/

//#define DEBUG 0

/*----------------------- Include Header Files -------------------------------*/
#include <stdio.h>
#include <string.h>
#include <gl.h>
/*---------------------- Declare Bind Variables ------------------------------*/

#define MAX_LINES 42
#define REP_WIDTH 130
#define REP_TITLE "LIST OF OUTSTANDING ORDERS FOR RADIOLOGY"
#define VER  "VER : 10.2\n"
#define ESC  0x1B

/* EXEC SQL BEGIN DECLARE SECTION; */ 

	/* VARCHAR nd_facility_id			[3],	//added by rvN 0n 23/Aug/2003
			nd_pgm_id    			[9],	//added by rvN 0n 23/Aug/2003
			//uid_pwd					[91],	//size increased by rvN 0n 23/Aug/2003
			uid_pwd					[122],  /o Length changed from 91 to 122 o/
			nd_session_id			[16],
			nd_pgm_date				[13],	//Input Parameters
									
			rep_date				[20],
			oper_id					[31],	//size increased by rvN 0n 23/Aug/2003
			comp_name				[61],	//size increased by rvN 0n 23/Aug/2003
	  		nd_pgm_name				[15],
			file_name				[15],
			
			nd_order_type_code_from [4],
			nd_order_type_code_to   [4],
			nd_order_id_from        [11],
			nd_order_id_to          [11],
			nd_fm_per_date          [11],
			nd_to_per_date          [11],
			p_fm_sctn				[5],
			p_to_sctn				[5],
			p_appt_type				[2],
			p_fm_sctn_val			[11],
			p_to_sctn_val			[11],
			p_appt_type_val			[26],
			p_module				[3],
			nd_source_code          [6],
			nd_module_id            [3],
			nd_status               [4],
			nd_stat_desc            [300],
			
			h_ord_type              [4],
			h_ord_id                [16],
			tmp_ord_id                [16],
			h_ord_date              [11],
			h_pat_id                [21],	//size increased by rvN 0n 23/Aug/2003
			h_epis_type             [2],
			h_epis_id               [13],	//size increased by rvN 0n 23/Aug/2003
			h_visit_id              [7],	//size increased by rvN 0n 23/Aug/2003
			h_sour_code             [7],
			h_doc_id                [7],
			
			h_sour_desc             [300],
			h_ward_no               [5],
			h_room_no               [5],
			h_bed_no                [9],
			h_loc_short_name        [61],	//size increased by rvN 0n 23/Aug/2003
			h_short_name            [61],	//size increased by rvN 0n 23/Aug/2003
			h_doc_name              [45],
			h_status                [3],
			h_stat_desc             [16],
			
			h_bed_class             [3],
			
			d_item_code             [21],	//size increased by rvN 0n 23/Aug/2003
			d_item_long_desc        [41],	//size increased by rvN 0n 23/Aug/2003
			d_grp_item_yn           [2],
			d_status                [3],
			d_stat_desc             [16],
			
			h_section				[5],
			tmp_section				[5],
			h_section_desc			[90],
	
		    v_ord_stat              [3]; */ 
struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[9]; } nd_pgm_id;

struct { unsigned short len; unsigned char arr[122]; } uid_pwd;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[13]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[20]; } rep_date;

struct { unsigned short len; unsigned char arr[31]; } oper_id;

struct { unsigned short len; unsigned char arr[61]; } comp_name;

struct { unsigned short len; unsigned char arr[15]; } nd_pgm_name;

struct { unsigned short len; unsigned char arr[15]; } file_name;

struct { unsigned short len; unsigned char arr[4]; } nd_order_type_code_from;

struct { unsigned short len; unsigned char arr[4]; } nd_order_type_code_to;

struct { unsigned short len; unsigned char arr[11]; } nd_order_id_from;

struct { unsigned short len; unsigned char arr[11]; } nd_order_id_to;

struct { unsigned short len; unsigned char arr[11]; } nd_fm_per_date;

struct { unsigned short len; unsigned char arr[11]; } nd_to_per_date;

struct { unsigned short len; unsigned char arr[5]; } p_fm_sctn;

struct { unsigned short len; unsigned char arr[5]; } p_to_sctn;

struct { unsigned short len; unsigned char arr[2]; } p_appt_type;

struct { unsigned short len; unsigned char arr[11]; } p_fm_sctn_val;

struct { unsigned short len; unsigned char arr[11]; } p_to_sctn_val;

struct { unsigned short len; unsigned char arr[26]; } p_appt_type_val;

struct { unsigned short len; unsigned char arr[3]; } p_module;

struct { unsigned short len; unsigned char arr[6]; } nd_source_code;

struct { unsigned short len; unsigned char arr[3]; } nd_module_id;

struct { unsigned short len; unsigned char arr[4]; } nd_status;

struct { unsigned short len; unsigned char arr[300]; } nd_stat_desc;

struct { unsigned short len; unsigned char arr[4]; } h_ord_type;

struct { unsigned short len; unsigned char arr[16]; } h_ord_id;

struct { unsigned short len; unsigned char arr[16]; } tmp_ord_id;

struct { unsigned short len; unsigned char arr[11]; } h_ord_date;

struct { unsigned short len; unsigned char arr[21]; } h_pat_id;

struct { unsigned short len; unsigned char arr[2]; } h_epis_type;

struct { unsigned short len; unsigned char arr[13]; } h_epis_id;

struct { unsigned short len; unsigned char arr[7]; } h_visit_id;

struct { unsigned short len; unsigned char arr[7]; } h_sour_code;

struct { unsigned short len; unsigned char arr[7]; } h_doc_id;

struct { unsigned short len; unsigned char arr[300]; } h_sour_desc;

struct { unsigned short len; unsigned char arr[5]; } h_ward_no;

struct { unsigned short len; unsigned char arr[5]; } h_room_no;

struct { unsigned short len; unsigned char arr[9]; } h_bed_no;

struct { unsigned short len; unsigned char arr[61]; } h_loc_short_name;

struct { unsigned short len; unsigned char arr[61]; } h_short_name;

struct { unsigned short len; unsigned char arr[45]; } h_doc_name;

struct { unsigned short len; unsigned char arr[3]; } h_status;

struct { unsigned short len; unsigned char arr[16]; } h_stat_desc;

struct { unsigned short len; unsigned char arr[3]; } h_bed_class;

struct { unsigned short len; unsigned char arr[21]; } d_item_code;

struct { unsigned short len; unsigned char arr[41]; } d_item_long_desc;

struct { unsigned short len; unsigned char arr[2]; } d_grp_item_yn;

struct { unsigned short len; unsigned char arr[3]; } d_status;

struct { unsigned short len; unsigned char arr[16]; } d_stat_desc;

struct { unsigned short len; unsigned char arr[5]; } h_section;

struct { unsigned short len; unsigned char arr[5]; } tmp_section;

struct { unsigned short len; unsigned char arr[90]; } h_section_desc;

struct { unsigned short len; unsigned char arr[3]; } v_ord_stat;


	/* VARCHAR	p_language_id		   [3],
			date_convert		   [21],
			nd_temp_date		   [21],
			nd_loc_date            [21],
			l_translated_value	   [200]; */ 
struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[21]; } date_convert;

struct { unsigned short len; unsigned char arr[21]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[21]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[200]; } l_translated_value;


			int i=0;
			int time_flag = 0;

   double  d_order_item_debit_value;

/*--------------------- End of Declare Bind Variables ------------------------*/

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
char filename[150];

char loc_legend[999][200];

FILE *f1;

/*-------------------------- Local Variables ---------------------------------*/
int page_no,
    line_no,
    first_line,
    g_hdr_cnt,
    g_err_typ;

char pgm_name[8],
     g_acct_code[41],
     fm_date [11],
     to_date [11],
     g_err_id[8],
     nd_flag[1],
     g_err_msg[72],
     s_amt[20],
     string_var [100];
/*-------------------------- End of Local Variables --------------------------*/

void proc_main ( argc, argv )
int  argc;
char *argv[];
{
	if ( argc != 6 ) 
    {
         disp_message(ERR_MESG,"RDROUTOR : Usage RDROUTOR userid/password session_id pgm_date\n");
         proc_exit();
    }

    strcpy(nd_pgm_name.arr, "RDROUTOR");
    nd_pgm_name.len = strlen(nd_pgm_name.arr);

    strcpy(g_pgm_id, "RDROUTOR");

    strcpy(nd_pgm_id.arr, argv[0]);
	nd_pgm_id.len = strlen(nd_pgm_id.arr); 

	strcpy(uid_pwd.arr, argv[1]);
	uid_pwd.len = strlen(uid_pwd.arr); 

	strcpy(nd_session_id.arr, argv[2]);
	nd_session_id.len = strlen(nd_session_id.arr); 

	strcpy(nd_pgm_date.arr, argv[3]);
	nd_pgm_date.len = strlen(nd_pgm_date.arr); 

	strcpy(nd_facility_id.arr, argv[4]);
	nd_facility_id.len = strlen(nd_facility_id.arr);

	strcpy(OUTPUT_FILE_NAME, argv[5]);
	

	/* EXEC SQL 
	CONNECT :uid_pwd; */ 

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
 sqlstm.sqhstl[0] = (unsigned int  )124;
 sqlstm.sqhsts[0] = (         int  )124;
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


	
	if (ERROR) {
		disp_message(ORA_MESG,"Unable to connect to oracle.\n");
		/*	  sprintf("%s\n",sqlca.sqlerrm.sqlerrmc);      */
		proc_exit();
	}
	
	set_meduser_role();

	/*Code Included for internationalization*/
	strcpy(p_language_id.arr,l_language_id.arr);
	p_language_id.len = l_language_id.len;

    start_prog_msg();

    nd_order_type_code_from.arr[0]  = '\0';
    nd_order_type_code_to.arr[0]    = '\0';
    nd_order_id_from.arr[0]         = '\0';
    nd_order_id_to.arr[0]           = '\0';
    nd_fm_per_date.arr[0]           = '\0';
    nd_to_per_date.arr[0]           = '\0';
	p_fm_sctn.arr[0]				= '\0';
	p_to_sctn.arr[0]				= '\0';
	p_appt_type.arr[0]				= '\0';
	p_module.arr[0]					= '\0';
    file_name.arr[0]                = '\0';
    
	nd_order_type_code_from.len		= 0;
    nd_order_type_code_to.len		= 0;
    nd_order_id_from.len			= 0;
    nd_order_id_to.len				= 0;
    nd_fm_per_date.len				= 0;      
    nd_to_per_date.len				= 0;   
	p_fm_sctn.len					= 0;   
	p_to_sctn.len					= 0;   
	p_appt_type.len					= 0;   
	p_module.len					= 0;   
    file_name.len					= 0;      

	/* EXEC SQL SELECT PARAM1, PARAM2,    
					PARAM3, PARAM4,    
					PARAM5, 
					PARAM6, LOWER(PGM_ID)||'.lis'
			   INTO :nd_fm_per_date, :nd_to_per_date,
					:p_fm_sctn, :p_to_sctn,
					:p_appt_type, 
					:p_module, :file_name
			   FROM SY_PROG_PARAM
			  WHERE OPERATING_FACILITY_ID = :nd_facility_id
			    AND PGM_ID     = :nd_pgm_name
	            AND PGM_DATE   = :nd_pgm_date
	            AND SESSION_ID = TO_NUMBER(:nd_session_id); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 ,PARAM5 ,PARAM6 ,(LOWE\
R(PGM_ID)||'.lis') into :b0,:b1,:b2,:b3,:b4,:b5,:b6  from SY_PROG_PARAM where \
(((OPERATING_FACILITY_ID=:b7 and PGM_ID=:b8) and PGM_DATE=:b9) and SESSION_ID=\
TO_NUMBER(:b10))";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )36;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_fm_per_date;
 sqlstm.sqhstl[0] = (unsigned int  )13;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_to_per_date;
 sqlstm.sqhstl[1] = (unsigned int  )13;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&p_fm_sctn;
 sqlstm.sqhstl[2] = (unsigned int  )7;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&p_to_sctn;
 sqlstm.sqhstl[3] = (unsigned int  )7;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&p_appt_type;
 sqlstm.sqhstl[4] = (unsigned int  )4;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&p_module;
 sqlstm.sqhstl[5] = (unsigned int  )5;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&file_name;
 sqlstm.sqhstl[6] = (unsigned int  )17;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&nd_facility_id;
 sqlstm.sqhstl[7] = (unsigned int  )5;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&nd_pgm_name;
 sqlstm.sqhstl[8] = (unsigned int  )17;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&nd_pgm_date;
 sqlstm.sqhstl[9] = (unsigned int  )15;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&nd_session_id;
 sqlstm.sqhstl[10] = (unsigned int  )18;
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


	
	if (ERROR || NO_DATA_FOUND) {
         disp_message(ERR_MESG,"sy_prog_param had error ...\n");
         /* err_mesg("SELECT failed on table  SY_PROG_PARAM",0,"");*/
    }

    nd_fm_per_date.arr[nd_fm_per_date.len]		= '\0';
    nd_to_per_date.arr[nd_to_per_date.len]		= '\0';
    file_name.arr[file_name.len]                = '\0';
	p_fm_sctn.arr[p_fm_sctn.len]				= '\0';
	p_to_sctn.arr[p_to_sctn.len]				= '\0';
	p_appt_type.arr[p_appt_type.len]			= '\0';
	p_module.arr[p_module.len]					= '\0';

    strcpy(filename,WORKING_DIR);
	strcat(filename,OUTPUT_FILE_NAME);
	
	if ( ( f1 = fopen(filename, "w") ) == NULL) {
		disp_message(ERR_MESG,"Error in opening output file...\n");
		proc_exit();
	}

    comp_name.len = 0;
    rep_date.len  = 0;
    oper_id.len   = 0;

    comp_name.arr[comp_name.len] = '\0';
    rep_date.arr[rep_date.len]   = '\0';
    oper_id.arr[oper_id.len]     = '\0';

    /* EXEC SQL 
	SELECT upper(ACC_ENTITY_NAME),TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
           USER 
	  INTO :comp_name,:rep_date,
		   :oper_id
	  FROM SY_ACC_ENTITY_LANG_VW
	 WHERE ACC_ENTITY_ID = :nd_facility_id
	 AND   LANGUAGE_ID = :p_language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select upper(ACC_ENTITY_NAME) ,TO_CHAR(SYSDATE,'DD/MM/YYY\
Y HH24:MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY_LANG_VW where (ACC_ENTI\
TY_ID=:b3 and LANGUAGE_ID=:b4)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )95;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&comp_name;
    sqlstm.sqhstl[0] = (unsigned int  )63;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&rep_date;
    sqlstm.sqhstl[1] = (unsigned int  )22;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&oper_id;
    sqlstm.sqhstl[2] = (unsigned int  )33;
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
    sqlstm.sqhstv[4] = (         void  *)&p_language_id;
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



	if (ERROR)
		err_mesg("SELECT failed on table  SY_ACC_ENTITY",0,"");
	
	comp_name.arr[comp_name.len] = '\0';
	rep_date.arr[rep_date.len]   = '\0';
	oper_id.arr[oper_id.len]     = '\0';

    decl_curs();

    line_no = 1;
    page_no = 0;

    fprintf(f1,"%c&k4S",ESC);
	fprintf(f1,"%c&l1O",ESC); 
	fprintf(f1,"%c&a5L",ESC);/*for landscape printing by rvNambiar on 26/Aug/2003 */

	fetch_legend_value();
	
	put_inp_parm();

	do_report();

    print_end_of_rep();

    fclose(f1);

    del_parm();
    
	end_prog_msg();

    /* EXEC SQL COMMIT RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )130;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	return;

}
/*------------------------------ End of Main Program -------------------------*/

/*---------------------------- Delete the SY_PROG_PARAM ----------------------*/

del_parm()
{
	/* EXEC SQL 
	DELETE SY_PROG_PARAM
	 WHERE OPERATING_FACILITY_ID = :nd_facility_id
	   AND PGM_ID				 = :nd_pgm_name
	   AND PGM_DATE				 = :nd_pgm_date
	   AND SESSION_ID			 = TO_NUMBER(:nd_session_id); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from SY_PROG_PARAM  where (((OPERATING_FACILITY_ID=:\
b0 and PGM_ID=:b1) and PGM_DATE=:b2) and SESSION_ID=TO_NUMBER(:b3))";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )145;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_pgm_name;
 sqlstm.sqhstl[1] = (unsigned int  )17;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_pgm_date;
 sqlstm.sqhstl[2] = (unsigned int  )15;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_session_id;
 sqlstm.sqhstl[3] = (unsigned int  )18;
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



	if (ERROR) 
		err_mesg("DELETE failed on table SY_PROG_PARAM",0,""); 

}
/*---------------------------- End of Main Program ---------------------------*/

/*-------------------- Declaring Hdr Dtl Supp Cursors ------------------------*/
decl_curs()
{
	/* EXEC SQL 
	DECLARE RD_ORDER_CUR CURSOR FOR
	 SELECT B.section_code, //new column
	        A.order_type_code, A.order_id,
			//TO_CHAR(ORD_DATE_TIME, 'DD/MM/YYYY'),
            TO_CHAR(A.order_date_time, 'DD/MM/YYYY'),
			A.patient_id, A.episode_type, A.episode_id,
			//EPISODE_VISIT_NUM,
			A.visit_id, A.source_code,
			//ORD_PRACT_ID,
			A.physician_id, A.order_status,
			//detail items
			A.item_code, C.short_desc, A.order_line_status
	   FROM rd_pending_orders A, rd_exams B, or_order_catalog C
	  WHERE A.item_code = B.order_catalog_code
		AND C.order_catalog_code = A.item_code
		AND A.ORDER_LINE_STATUS  = (SELECT ORDER_STATUS_CODE
								 FROM OR_ORDER_STATUS_CODE
                                WHERE ORDER_STATUS_TYPE = '10')
		AND TRUNC(A.TEST_DATE_TIME)
			BETWEEN TO_DATE(NVL(:nd_fm_per_date,'01/01/1800'),'DD/MM/YYYY')
				AND TO_DATE(NVL(:nd_to_per_date,'31/12/4712'),'DD/MM/YYYY')
        AND B.section_code BETWEEN :p_fm_sctn AND :p_to_sctn
		AND A.appt_reqd_yn = DECODE(:p_appt_type, 'A', A.appt_reqd_yn, :p_appt_type)
	  ORDER BY 1, 3; */ 
  
			  
	/*
		EXEC SQL SELECT ORDER_STATUS_CODE
				INTO :v_ord_stat
				FROM OR_ORDER_STATUS_CODE
			   WHERE ORDER_STATUS_TYPE = '10';
	 
		SELECT ORDER_TYPE_CODE,
					 ORDER_ID,
					 TO_CHAR( ORD_DATE_TIME, 'DD/MM/YYYY' ),
					 PATIENT_ID,
					 B.EPISODE_TYPE,
					 EPISODE_ID,
					 EPISODE_VISIT_NUM,
					 SOURCE_CODE,
					 ORD_PRACT_ID,
					 ORDER_STATUS
				FROM OR_ORDER A, MP_EPISODE_TYPE_VW B
			   WHERE A.PATIENT_CLASS = B.PATIENT_CLASS
				 AND NVL(PERFORMING_FACILITY_ID, ORDERING_FACILITY_ID) = :nd_facility_id
				 AND ORDER_CATEGORY = 'RD'
				 AND ORDER_STATUS = :v_ord_stat
				 AND TO_DATE ( TO_CHAR ( ORD_DATE_TIME ,'DD/MM/YYYY'),'DD/MM/YYYY')
					 BETWEEN
					 TO_DATE(NVL(:nd_fm_per_date,'01/01/1800'),'DD/MM/YYYY')
				 AND TO_DATE(NVL(:nd_to_per_date,'31/12/4712'),'DD/MM/YYYY')
			   ORDER BY ORD_DATE_TIME, ORDER_TYPE_CODE, ORDER_ID;

		EXEC SQL DECLARE RD_ORDER_DTL_CUR CURSOR FOR
	          SELECT ORDER_CATALOG_CODE,
					 CATALOG_DESC,
					 //GROUP_ITEM_YN,ORDER_ITEM_DEBIT_VALUE,  //commented by rvN on 25/08/2003 as Vishwa's Instruction
					 ORDER_LINE_STATUS  
			  FROM   OR_ORDER_LINE
			  WHERE  ORDER_TYPE_CODE = :h_ord_type 
			  AND    ORDER_ID = :h_ord_id 
			  AND    ORDER_LINE_STATUS = :v_ord_stat
			  ORDER  BY ORDER_LINE_NUM;
	*/

     
}
/*-----------------End of Declaring Hdr Supp Cursors -------------------------*/

/*----------------- Fetch The Order Order Headers  ---------------------------*/
fetch_hdr()
{
	/*-------------------- Intialising the Bind Variables ------------------------*/
    h_ord_type.arr[0]			= '\0';
    h_ord_id.arr[0]				= '\0';
    h_ord_date.arr[0]			= '\0';
    h_pat_id.arr[0]				= '\0';
    h_epis_type.arr[0]			= '\0';
    h_epis_id.arr[0]			= '\0';
    h_visit_id.arr[0]			= '\0';
    h_sour_code.arr[0]			= '\0';
    h_doc_id.arr[0]				= '\0';
    h_status.arr[0]				= '\0';
	v_ord_stat.arr[0]			= '\0';

	d_item_code.arr[0]			= '\0';
    d_item_long_desc.arr[0]		= '\0';
    d_grp_item_yn.arr[0]		= '\0';
    d_status.arr[0]				= '\0';

	h_section.arr[0]			= '\0';
    
    h_ord_id.len				= 0; 
    h_ord_date.len				= 0;            
    h_pat_id.len				= 0;            
    h_epis_type.len				= 0;            
    h_epis_id.len				= 0;            
    h_visit_id.len				= 0;            
    h_sour_code.len				= 0;            
    h_doc_id.len				= 0;            
    h_status.len				= 0;            
	v_ord_stat.len				= 0;

	d_item_code.len				= 0;
    d_item_long_desc.len		= 0;
    d_grp_item_yn.len			= 0;
    d_status.len				= 0;

	h_section.len				= 0;
    	 
	/*----------------- End of Intialising the Bind Variables --------------------*/

	/*----------------- Fetching Contract Header Informations --------------------*/
	/* EXEC SQL 
	FETCH RD_ORDER_CUR
	 INTO :h_section,
		  :h_ord_type,
          :h_ord_id,
          :h_ord_date,
          :h_pat_id,
          :h_epis_type,
          :h_epis_id,
          :h_visit_id,
          :h_sour_code,
          :h_doc_id,
          :h_status,
		  :d_item_code,
		  :d_item_long_desc,
		  :d_status; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )176;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&h_section;
 sqlstm.sqhstl[0] = (unsigned int  )7;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&h_ord_type;
 sqlstm.sqhstl[1] = (unsigned int  )6;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&h_ord_id;
 sqlstm.sqhstl[2] = (unsigned int  )18;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&h_ord_date;
 sqlstm.sqhstl[3] = (unsigned int  )13;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&h_pat_id;
 sqlstm.sqhstl[4] = (unsigned int  )23;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&h_epis_type;
 sqlstm.sqhstl[5] = (unsigned int  )4;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&h_epis_id;
 sqlstm.sqhstl[6] = (unsigned int  )15;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&h_visit_id;
 sqlstm.sqhstl[7] = (unsigned int  )9;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&h_sour_code;
 sqlstm.sqhstl[8] = (unsigned int  )9;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&h_doc_id;
 sqlstm.sqhstl[9] = (unsigned int  )9;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&h_status;
 sqlstm.sqhstl[10] = (unsigned int  )5;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&d_item_code;
 sqlstm.sqhstl[11] = (unsigned int  )23;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&d_item_long_desc;
 sqlstm.sqhstl[12] = (unsigned int  )43;
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&d_status;
 sqlstm.sqhstl[13] = (unsigned int  )5;
 sqlstm.sqhsts[13] = (         int  )0;
 sqlstm.sqindv[13] = (         void  *)0;
 sqlstm.sqinds[13] = (         int  )0;
 sqlstm.sqharm[13] = (unsigned int  )0;
 sqlstm.sqadto[13] = (unsigned short )0;
 sqlstm.sqtdso[13] = (unsigned short )0;
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



	/*------------- End of Fetching Contract Header Informations -----------------*/

     if (ERROR)
       err_mesg("FETCH failed on cursor RD_ORDER_CUR",0,"");

     if (NO_DATA_FOUND)
       return 0;

	/*------- Terminating With Null for all Bind Variables at the End of data-----*/

    h_ord_type.arr[h_ord_type.len]				= '\0';
    h_ord_id.arr[h_ord_id.len]					= '\0';
    h_ord_date.arr[h_ord_date.len]				= '\0';
    h_pat_id.arr[h_pat_id.len]					= '\0';
    h_epis_type.arr[h_epis_type.len]			= '\0';
    h_epis_id.arr[h_epis_id.len]				= '\0';
    h_visit_id.arr[h_visit_id.len]				= '\0';
    h_sour_code.arr[h_sour_code.len]			= '\0';
    h_doc_id.arr[h_doc_id.len]					= '\0';
    h_status.arr[h_status.len]					= '\0';
	v_ord_stat.arr[v_ord_stat.len]				= '\0';

	d_item_code.arr[d_item_code.len]            = '\0';
    d_item_long_desc.arr[d_item_long_desc.len]  = '\0';
    d_grp_item_yn.arr[d_grp_item_yn.len]        = '\0';
    d_status.arr[d_status.len]                  = '\0';

	h_section.arr[h_section.len]				= '\0';

	/*--- End of Terminating With Null for all Bind Variables at the End of data--*/
	return 1;
}
/*-------------------- End of Fetching Header Details ------------------------*/

/*-------------------------- Start of the Do Report --------------------------*/
do_report()
{
    char l_long_out_str [100],
	l_test_ser_cd[3];
    int  l_st_no = 0;
    int  first,frst;
	int  desc_len;
	int  sctn_tot = 1;
    char s_amt[20];

    fprintf(f1,"\f");
    
	line_no = 1;
    
	put_hdr();
    
    put_trn_hdr();
	
	/*put_trn_dtl();*/

    frst = 1;
	strcpy(tmp_ord_id.arr, "*****");
	strcpy(tmp_section.arr, "*****");

	/* EXEC SQL OPEN RD_ORDER_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0006;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )247;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_fm_per_date;
 sqlstm.sqhstl[0] = (unsigned int  )13;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_to_per_date;
 sqlstm.sqhstl[1] = (unsigned int  )13;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&p_fm_sctn;
 sqlstm.sqhstl[2] = (unsigned int  )7;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&p_to_sctn;
 sqlstm.sqhstl[3] = (unsigned int  )7;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&p_appt_type;
 sqlstm.sqhstl[4] = (unsigned int  )4;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&p_appt_type;
 sqlstm.sqhstl[5] = (unsigned int  )4;
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


		if (ERROR)
			err_mesg("OPEN failed on cursor RD_ORDER_CUR",0,"");
	
	while ( fetch_hdr() )
    { 
		if (strcmp(tmp_section.arr, h_section.arr)!=0)
		{
			
			if (frst != 1){
				chk_break(3);
				fprintf(f1,"\n");
				/*  legend[24]  --  Section Total */
				fprintf(f1, "%18.18s : %d\n",loc_legend[24], sctn_tot);
				print_line('-', REP_WIDTH); 
				line_no  = line_no + 3;
				sctn_tot = 1;
			}
			get_section_desc();
			chk_break(2);
			/*  legend[11]  -- Section */
			fprintf(f1, "%s: %s-%s",loc_legend[11], h_section.arr, h_section_desc.arr);
			desc_len = strlen(h_section.arr) + strlen(h_section_desc.arr) + 11;
			fprintf(f1,"\n"); print_line('-', desc_len); 
			line_no = line_no + 2;
			put_hdr_body();
			put_dtl_hdr();
			put_trn_dtl();
		}
		else
		{
			if (strcmp(tmp_ord_id.arr, h_ord_id.arr)!=0){
				fprintf(f1,"\n"); line_no = line_no + 1;
				put_hdr_body();
				put_dtl_hdr();
				put_trn_dtl();
			}
			else{
				put_trn_dtl();
			}
			frst	 = 0;
			sctn_tot = sctn_tot + 1;
		}

		strcpy(tmp_ord_id.arr, h_ord_id.arr);
		strcpy(tmp_section.arr, h_section.arr);
		
		/*chk_break(1);
		fprintf(f1,"\n");
		line_no = line_no + 1;*/
	}
	
	chk_break(3);
	fprintf(f1,"\n");
	fprintf(f1, "Section Total : %d\n", sctn_tot);
	print_line('-', REP_WIDTH); 
	line_no  = line_no + 3;
	

}
/*------------------------- End of Do Report Function -----------------------*/


/*--------------------- Patient Details --------------------------------------*/
get_pat_dtls()
{
	h_loc_short_name.arr[0]                          = '\0';             
	h_short_name.arr[0]                              = '\0';             

	h_loc_short_name.len                             = 0;                
	h_short_name.len                                 = 0;                

	/* EXEC SQL SELECT  SHORT_NAME,
                    substr(SHORT_NAME_LOC_LANG,1,16)
            INTO   :h_short_name,
                   :h_loc_short_name
            FROM    MP_PATIENT_MAST
            WHERE   PATIENT_ID = :h_pat_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select SHORT_NAME ,substr(SHORT_NAME_LOC_LANG,1,16) into :b0\
,:b1  from MP_PATIENT_MAST where PATIENT_ID=:b2";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )286;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&h_short_name;
 sqlstm.sqhstl[0] = (unsigned int  )63;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&h_loc_short_name;
 sqlstm.sqhstl[1] = (unsigned int  )63;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&h_pat_id;
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



   h_loc_short_name.arr[h_loc_short_name.len]   = '\0';             
   h_short_name.arr[h_short_name.len]           = '\0';             

}
/*--------------------- End of Patient Details -------------------------------*/

/*--------------------- IP Dtls Description ----------------------------------*/
get_ip_dtls()
{
   h_ward_no.arr[0]                              = '\0';             
   h_room_no.arr[0]                              = '\0';             
   h_bed_no.arr[0]                               = '\0';             
   h_bed_class.arr[0]                            = '\0';             

   h_ward_no.len                                 = 0;                
   h_room_no.len                                 = 0;                
   h_bed_no.len                                  = 0;                
   h_bed_class.len                               = 0;             

   /* EXEC SQL SELECT CUR_WARD_CODE,
                   CUR_ROOM_NUM,
                   CUR_BED_NUM,
                   CUR_BED_CLASS_CODE
              INTO :h_ward_no,
                   :h_room_no,
                   :h_bed_no,
                   :h_bed_class
              FROM IP_EPISODE
             WHERE FACILITY_ID = :nd_facility_id
			   AND EPISODE_ID = to_number(:h_epis_id); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select CUR_WARD_CODE ,CUR_ROOM_NUM ,CUR_BED_NUM ,CUR_BED_C\
LASS_CODE into :b0,:b1,:b2,:b3  from IP_EPISODE where (FACILITY_ID=:b4 and EPI\
SODE_ID=to_number(:b5))";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )313;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&h_ward_no;
   sqlstm.sqhstl[0] = (unsigned int  )7;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&h_room_no;
   sqlstm.sqhstl[1] = (unsigned int  )7;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&h_bed_no;
   sqlstm.sqhstl[2] = (unsigned int  )11;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&h_bed_class;
   sqlstm.sqhstl[3] = (unsigned int  )5;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_facility_id;
   sqlstm.sqhstl[4] = (unsigned int  )5;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&h_epis_id;
   sqlstm.sqhstl[5] = (unsigned int  )15;
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



   h_ward_no.arr[h_ward_no.len]                  = '\0';             
   h_room_no.arr[h_room_no.len]                  = '\0';             
   h_bed_no.arr[h_bed_no.len]                    = '\0';             
   h_bed_class.arr[h_bed_class.len]              = '\0';             

}
/*--------------------- End of IP Dtls Description ---------------------------*/

/*------------------------- Get Ward Description -----------------------------*/
get_ward_desc()
{
   h_sour_desc.arr[0]                             = '\0';
   h_sour_desc.len                                = 0;

   /*EXEC SQL SELECT SHORT_DESC
              INTO :h_sour_desc
              FROM IP_WARD
             WHERE FACILITY_ID = :nd_facility_id
			   AND WARD_CODE = :h_sour_code;*/

	/* EXEC SQL SELECT short_desc
              INTO :h_sour_desc
              FROM ip_nursing_unit_lang_vw
             WHERE facility_id = :nd_facility_id
			   AND nursing_unit_code = :h_sour_code
			   AND language_id = :p_language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select short_desc into :b0  from ip_nursing_unit_lang_vw whe\
re ((facility_id=:b1 and nursing_unit_code=:b2) and language_id=:b3)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )352;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&h_sour_desc;
 sqlstm.sqhstl[0] = (unsigned int  )302;
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
 sqlstm.sqhstv[2] = (         void  *)&h_sour_code;
 sqlstm.sqhstl[2] = (unsigned int  )9;
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

 

   h_sour_desc.arr[h_sour_desc.len]                = '\0';

}

get_section_desc()
{
   h_section_desc.arr[0]					= '\0';
   h_section_desc.len                       = 0;

	/* EXEC SQL 
	SELECT lONG_desc
	  INTO :h_section_desc
      FROM rd_section_lang_vw
     WHERE section_code = :h_section
	 AND   language_id  = :p_language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select lONG_desc into :b0  from rd_section_lang_vw where (se\
ction_code=:b1 and language_id=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )383;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&h_section_desc;
 sqlstm.sqhstl[0] = (unsigned int  )92;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&h_section;
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



   h_section_desc.arr[h_section_desc.len]	= '\0';

}
/*--------------------- End of Getting Ward Description ----------------------*/

/*--------------------- Get Clinic Desc --------------------------------------*/
get_clinic_desc()
{
   h_sour_desc.arr[0]                             = '\0';
   h_sour_desc.len                                = 0;

   /* EXEC SQL SELECT short_desc
              INTO :h_sour_desc
              FROM op_clinic_lang_vw
             WHERE facility_id = :nd_facility_id
			   AND clinic_code = :h_sour_code
			   AND language_id = :p_language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select short_desc into :b0  from op_clinic_lang_vw where (\
(facility_id=:b1 and clinic_code=:b2) and language_id=:b3)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )410;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&h_sour_desc;
   sqlstm.sqhstl[0] = (unsigned int  )302;
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
   sqlstm.sqhstv[2] = (         void  *)&h_sour_code;
   sqlstm.sqhstl[2] = (unsigned int  )9;
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



   h_sour_desc.arr[h_sour_desc.len]                = '\0';

}
/*--------------------- End of getting Clinic Desc ---------------------------*/

/*--------------------- Get Clinic Desc --------------------------------------*/
get_ref_desc()
{
   h_sour_desc.arr[0]                             = '\0';
   h_sour_desc.len                                = 0;

   /* EXEC SQL SELECT SHORT_DESC
            INTO   :h_sour_desc
            FROM   SY_REFERRAL_lang_vw  
            WHERE  REFERRAL_CODE = :h_sour_code
			AND    language_id  = :p_language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select SHORT_DESC into :b0  from SY_REFERRAL_lang_vw where\
 (REFERRAL_CODE=:b1 and language_id=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )441;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&h_sour_desc;
   sqlstm.sqhstl[0] = (unsigned int  )302;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&h_sour_code;
   sqlstm.sqhstl[1] = (unsigned int  )9;
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



   h_sour_desc.arr[h_sour_desc.len]                = '\0';

}
/*--------------------- End of getting Clinic Desc ---------------------------*/

/*--------------------- Get Doctor Name---------------------------------------*/
get_doc_name()
{
	h_doc_name.arr[0]                             = '\0';
	h_doc_name.len                                = 0;

	/*EXEC SQL 
	SELECT short_name
	  INTO :h_doc_name
	  FROM SY_PHYSICIAN_MAST
	 WHERE FACILITY_ID = :nd_facility_id
	   AND PHYSICIAN_ID = :h_doc_id;*/

	/* EXEC SQL 
	SELECT short_name
	  INTO :h_doc_name
	  FROM AM_PRACTITIONER_LANG_VW A, AM_PRACT_FOR_FACILITY B
	 WHERE B.FACILITY_ID = :nd_facility_id
	   AND A.PRACTITIONER_ID = B.PRACTITIONER_ID
	   AND A.PRACTITIONER_ID = :h_doc_id
	   AND A.LANGUAGE_ID  = :p_language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select short_name into :b0  from AM_PRACTITIONER_LANG_VW A ,\
AM_PRACT_FOR_FACILITY B where (((B.FACILITY_ID=:b1 and A.PRACTITIONER_ID=B.PRA\
CTITIONER_ID) and A.PRACTITIONER_ID=:b2) and A.LANGUAGE_ID=:b3)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )468;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&h_doc_name;
 sqlstm.sqhstl[0] = (unsigned int  )47;
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
 sqlstm.sqhstv[2] = (         void  *)&h_doc_id;
 sqlstm.sqhstl[2] = (unsigned int  )9;
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



	h_doc_name.arr[h_doc_name.len]                = '\0';
}
/*--------------------- End of getting Dcotor Name ---------------------------*/

/*--------------------- Get the Status Description ---------------------------*/

get_status_desc(stat,stat_desc)
char *stat, *stat_desc;
  {
     strcpy ( nd_status.arr, stat );
     nd_status.len = strlen(nd_status.arr);

     nd_stat_desc.arr[0] = '\0';

     nd_stat_desc.len    = 0;

     /* EXEC SQL SELECT SHORT_DESC
	            INTO :nd_stat_desc
	            FROM OR_ORDER_STATUS_CODE_lang_vw
	           WHERE ORDER_STATUS_CODE = :nd_status
			   AND   language_id = :p_language_id; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 14;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select SHORT_DESC into :b0  from OR_ORDER_STATUS_CODE_la\
ng_vw where (ORDER_STATUS_CODE=:b1 and language_id=:b2)";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )499;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_stat_desc;
     sqlstm.sqhstl[0] = (unsigned int  )302;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&nd_status;
     sqlstm.sqhstl[1] = (unsigned int  )6;
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



     nd_stat_desc.arr[nd_stat_desc.len] = '\0';

     strcpy(stat_desc, nd_stat_desc.arr);
  }  
/*----------------------  End of Get Status Description ----------------------*/

/******--------Page Skip for same Order -------------***/
chk_pg_skp(ln_no)
int ln_no;
{
	if ((line_no +ln_no) >= MAX_LINES) {
		fprintf(f1,"");
        line_no = 1;
        put_hdr();
        put_trn_hdr();
	}
}
/*---------  End of Same Order Type --------------------------*/

/*-------------------------- Put Page Header ---------------------------------*/

put_hdr()
{
	int hosp_nm_len, rep_title_len = 10, s1, s2;
	char v_rep_title[200];
	
	fprintf(f1,"MDL : RD");
	hosp_nm_len  =  comp_name.len;
	s1 = (REP_WIDTH-hosp_nm_len)/2;
	horz_skip(s1-8);
	fprintf(f1,"%s", comp_name.arr);
	s2 = (REP_WIDTH-s1-hosp_nm_len);
	horz_skip(s2-16);

	init_date_temp_var();
	strcpy(date_convert.arr,rep_date.arr);
	time_flag = 1;
    fun_change_loc_date();
	//fprintf(f1,"%s", rep_date.arr);
	fprintf(f1,"%s",date_convert.arr);
    
	fprintf(f1,"\n"); fprintf(f1,"OPR : %s", oper_id.arr); fprintf(f1,"\n");
    
	fprintf(f1,"REP : %s",nd_pgm_id.arr);

	/*  legend[1]  -- LIST OF OUTSTANDING ORDERS FOR RADIOLOGY  */
	strcpy(v_rep_title,loc_legend[1]);
	//strcpy(v_rep_title,REP_TITLE);
	rep_title_len = strlen(v_rep_title);
	s1 = (REP_WIDTH-rep_title_len)/2;
	horz_skip(s1-14);
	//fprintf(f1,"%s",REP_TITLE);
	fprintf(f1,"%s",v_rep_title);


	s2 = (REP_WIDTH-s1-rep_title_len);
	horz_skip(s2-10);
	
	/* legend[2]  -- PAGE  */
	fprintf(f1,"%s:%4d\n",loc_legend[2],++page_no);

	horz_skip(41);

	/*  legend[8] -- FOR THE PERIOD FROM; legend[14] -- TO  */ 
	fprintf(f1,"%s : %-10s %s : %-10s\n",loc_legend[8], fm_date,loc_legend[14], to_date );
	//fprintf(f1,"FOR THE PERIOD FROM : %-10s TO : %-10s\n", fm_date, to_date );
	print_line('-', REP_WIDTH);
    line_no = 6;
}
/*------------------------- End of Page Header ------------------------------*/

/*------------------------- Put Transaction Header --------------------------*/
put_trn_hdr() 
{
    int  l_st_no = 0;
    char l_long_out_str [61];

	chk_break(5);
    /*fprintf(f1,"Order Type/No        Order Date Patient ID           Episode No/Visit No   Referring Source       Ward Room Bed No   Status\n");
    fprintf(f1,"                                Name                                                              Referring Doctor              \n");*/

	fprintf(f1,"%-14.14s %27.27s %29.29s %19.19s %22.22s %8s\n",loc_legend[15],loc_legend[16],loc_legend[17],loc_legend[18],loc_legend[19],loc_legend[20]);
    fprintf(f1,"%36.36s %78.78s\n",loc_legend[21],loc_legend[22]);

    /*         "1234/123456789012345 DD/MM/YYYY 12345678901234567890 1/123456789012/123456 123456 123456789012345 1234 1234 12345678  " */
    /*         "                                1234567890123456 123456789012345678901234567890   123456789012345 123456789012345678901234567890" */
	print_line('-', REP_WIDTH);  
	line_no += 3;
}
/*-------------------------- End of Transaction Header -----------------------*/

/*-------------------------- Put the Body of the Report ----------------------*/
put_hdr_body()
{
     chk_break(5);

     fprintf(f1,"%-4s/",h_ord_type.arr);
     fprintf(f1,"%-15s ",h_ord_id.arr);

	 init_date_temp_var();
	 strcpy(date_convert.arr,h_ord_date.arr);
	 time_flag = 0;
     fun_change_loc_date();
     //fprintf(f1,"%-10s ",h_ord_date.arr);
	 fprintf(f1,"%-10s ",date_convert.arr);

     fprintf(f1,"%-20s ",h_pat_id.arr);
     fprintf(f1,"%1s/%-12s/%-6s ", h_epis_type.arr,h_epis_id.arr,h_visit_id.arr);
     fprintf(f1,"%-6s ", h_sour_code.arr);

     if (strcmp(h_epis_type.arr,"I") == 0)
       {
          get_ip_dtls();
          get_ward_desc();
       }
     else 
       if (strcmp(h_epis_type.arr,"O") == 0)
         get_clinic_desc();
       else 
	 get_ref_desc();
  /*--------------------------------------------*/

     fprintf(f1,"%-15s ", h_sour_desc.arr);
     fprintf(f1,"%-4s ", h_ward_no.arr);
     fprintf(f1,"%-4s ", h_room_no.arr);
     fprintf(f1,"%-8s ", h_bed_no.arr);
     
     get_status_desc(h_status.arr,h_stat_desc.arr);
     fprintf(f1,"%-15s \n", h_stat_desc.arr); 

     get_pat_dtls();
     fprintf(f1,"                               ");
     fprintf(f1,"%-60s ", h_short_name.arr);
     //fprintf(f1,"%-16s ", h_loc_short_name.arr);

     get_doc_name();
     fprintf(f1,"     %-15s- ", h_doc_id.arr);
     fprintf(f1,"%-15s ", h_doc_name.arr);
     fprintf(f1,"\n"); 

     line_no += 2;
}
/*-------------------------- End of Body of Report ---------------------------*/

/*------------------------- Put Detail Heading  ------------------------------*/
put_dtl_hdr()
{
	chk_break(2);
	//fprintf(f1,"Order Catalog Code & Description                                Status         \n");
	fprintf(f1,"%-63.63s %-15.15s\n",loc_legend[23],loc_legend[20]);
	/*         "     123456789012345  1234567890123456789012345678901234567890  123456789012345\n\n" */
	print_line('-', 75);
	line_no += 2;
}
/*------------------------- End of Detail Heading ----------------------------*/

/*------------------------- Put Detail Body ----------------------------*/
put_trn_dtl()
{	
	chk_break(1);
	get_status_desc(d_status.arr, d_stat_desc.arr);
	fprintf(f1, "%-20s  %-40s  %-15s\n", d_item_code.arr, d_item_long_desc.arr,  d_stat_desc.arr);
	line_no++;

}  
/*------------------------- End of Detail Body ----------------------------*/

/*------------------------- Check The Page Break ---------------------------*/
chk_break(nol)
int nol;
{
	//fprintf(f1,"Line :%4d",line_no);
	if ( line_no+1 >= MAX_LINES ) 
	{
		fprintf(f1,"\f");
		line_no = 1;
		put_hdr();
		put_trn_hdr();
	}
}
/*--------------------------- End of Check Page Break ------------------------*/

put_inp_parm()
{
	int hosp_nm_len, rep_title_len = 10, s1, s2;
	char v_rep_title[200];
	
	fprintf(f1,"MDL : RD");
	hosp_nm_len  =  comp_name.len;
	s1 = (REP_WIDTH-hosp_nm_len)/2;
	horz_skip(s1-8);
	fprintf(f1,"%s", comp_name.arr);
	s2 = (REP_WIDTH-s1-hosp_nm_len);
	horz_skip(s2-16);

	
	init_date_temp_var();
	strcpy(date_convert.arr,rep_date.arr);
	time_flag = 1;
    fun_change_loc_date();
	//fprintf(f1,"%s", rep_date.arr);
	fprintf(f1,"%s", date_convert.arr);
    
	fprintf(f1,"\n"); fprintf(f1,"OPR : %s", oper_id.arr); fprintf(f1,"\n");
    
	fprintf(f1,"REP : %s",nd_pgm_id.arr);
	

	/*  legend[1]  -- LIST OF OUTSTANDING ORDERS FOR RADIOLOGY  */
	strcpy(v_rep_title,loc_legend[1]);
	//strcpy(v_rep_title,REP_TITLE);
	rep_title_len = strlen(v_rep_title);
	s1 = (REP_WIDTH-rep_title_len)/2;
	horz_skip(s1-14);
	fprintf(f1,"%s",v_rep_title);
	//fprintf(f1,"%s",REP_TITLE);


	s2 = (REP_WIDTH-s1-rep_title_len);
	horz_skip(s2-10);

	/* legend[2]  -- PAGE  */
	fprintf(f1,"%s :%4d\n",loc_legend[2],++page_no);

	horz_skip(41);

	if (!strcmp(nd_fm_per_date.arr,"01/01/1800"))
	  /*  legend[3]  -- LOWEST  */
      strcpy(fm_date, loc_legend[3]);
    else
	{	
		init_date_temp_var();
		strcpy(date_convert.arr,nd_fm_per_date.arr);
		time_flag = 0;
		fun_change_loc_date();
		strcpy(fm_date,date_convert.arr);
      //strcpy(fm_date, nd_fm_per_date.arr);
	}

	if (!strcmp(nd_to_per_date.arr,"31/12/4712"))
	  /*  legend[4]  -- HIGHEST  */
      strcpy(to_date, loc_legend[4]);
    else
	{
		init_date_temp_var();
		strcpy(date_convert.arr,nd_to_per_date.arr);
		time_flag = 0;
		fun_change_loc_date();
		strcpy(to_date,date_convert.arr);
      //strcpy(to_date, nd_to_per_date.arr);
	}

	if ( strcmp (p_fm_sctn.arr, "!!!!" ) == 0 )
		/*  legend[3] -- LOWEST */
		strcpy (p_fm_sctn_val.arr,loc_legend[3]);
    else 
		strcpy (p_fm_sctn_val.arr,	p_fm_sctn.arr );

	if	(strcmp (p_to_sctn.arr, "~~~~" ) == 0	)
		/*  legend[4] -- HIGHEST */
		strcpy (p_to_sctn_val.arr,loc_legend[4]);
	else
		strcpy (p_to_sctn_val.arr, p_to_sctn.arr );

	if	(strcmp (p_appt_type.arr, "Y" ) == 0	)
		/*  legend[5] -- APPOINTMENT REQUIRED */
		strcpy (p_appt_type_val.arr, loc_legend[5] );
	else if	(strcmp (p_appt_type.arr, "N" ) == 0	)
		/*  legend[6] -- APPOINTMENT NOT REQUIRED */
		strcpy (p_appt_type_val.arr, loc_legend[6]);
	else
		/*  legend[7] -- All */
		strcpy (p_appt_type_val.arr, loc_legend[7]);

		/*  legend[8] -- FOR THE PERIOD FROM; legend[14] -- TO  */ 
	fprintf(f1,"%s : %-10s %s : %-10s\n",loc_legend[8], fm_date,loc_legend[14], to_date );
	
	print_line('-', REP_WIDTH);
    
	fprintf(f1,VER);
    
	fprintf(f1,"\n\n\n\n\n");
	/*  legend[9] -- INPUT PARAMETERS  */
    fprintf(f1,"\t\t\t\t%s :\n",loc_legend[9]);
	fprintf(f1,"\t\t\t\t");
	print_line('-', 18);
    fprintf(f1,"\n");
	/*fprintf(f1,"\t\t\t\t\tORDER DATE        FROM  : %-11s\n",fm_date);
	fprintf(f1,"\t\t\t\t\t                  TO    : %-11s\n\n",to_date);
	fprintf(f1,"\t\t\t\t\tSECTION           FROM  : %-11s\n",p_fm_sctn_val.arr);
	fprintf(f1,"\t\t\t\t\t                  TO    : %-11s\n\n",p_to_sctn_val.arr);*/

	fprintf(f1,"\t\t\t\t\t%-18.18s",loc_legend[10]);
	fprintf(f1,"%-6.6s: %-11s\n",loc_legend[13],fm_date); 
	fprintf(f1,"\t\t\t\t\t%17s %-6.6s: %-11s\n\n","",loc_legend[14],to_date);
	fprintf(f1,"\t\t\t\t\t%-18.18s",loc_legend[11]);
	fprintf(f1,"%-6.6s: %-11s\n",loc_legend[13],p_fm_sctn_val.arr); 
	fprintf(f1,"\t\t\t\t\t%17s %-6.6s: %-11s\n\n","",loc_legend[14],p_to_sctn_val.arr);
	
	/* legend[12] -- APPOINTMENT TYPE */	
	fprintf(f1,"\t\t\t\t\t%-24.24s: %-26s\n",loc_legend[12],p_appt_type_val.arr);
}


print_end_of_rep()
{
	int col;

	chk_break(2); 
	fprintf(f1,"\n");    
	for (col = 0; col < (REP_WIDTH -27)/2; col++)
	fprintf(f1," "); 
	fprintf(f1,"*****%s*****",loc_legend[25]);
	fprintf(f1,"%cE",ESC);
}



print_line(ch,n) /* this is to obtain required characters */
  char ch;
  int n;
{
	int i;
	for(i=0;i<n;i++)
	fprintf(f1,"%c",ch);  fprintf(f1,"\n");
}

horz_skip(num) /* this is to obtain required blank space */
int num;
{
	int i;
	for(i=0;i<num;i++)fprintf(f1," ");
}


/***** Below functions are added for internationlization  *****/

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
nd_temp_date.arr[nd_temp_date.len]='\0';

get_local_date();

strcpy(date_convert.arr,nd_loc_date.arr); 

}

get_local_date()
{

	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;
	
	BEGIN
	  
       	get_locale_date.CONVERT_TO_LOCALE_DATE(to_date(:nd_temp_date,'DD/MM/YYYY HH24:MI'),:p_language_id,t_date);

		IF :time_flag = 1 THEN
		   :nd_loc_date := to_char(t_date,'DD/MM/YYYY HH24:MI');
		   :time_flag := 0;
		ELSE
	       :nd_loc_date := to_char(t_date,'DD/MM/YYYY');
		END IF;
	

	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . CONVERT_TO_LOC\
ALE_DATE ( to_date ( :nd_temp_date , 'DD/MM/YYYY HH24:MI' ) , :p_language_id ,\
 t_date ) ; IF :time_flag = 1 THEN :nd_loc_date := to_char ( t_date , 'DD/MM/Y\
YYY HH24:MI' ) ; :time_flag := 0 ; ELSE :nd_loc_date := to_char ( t_date , 'DD\
/MM/YYYY' ) ; END IF ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )526;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_temp_date;
 sqlstm.sqhstl[0] = (unsigned int  )23;
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
 sqlstm.sqhstv[2] = (         void  *)&time_flag;
 sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_loc_date;
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



		nd_loc_date.arr[nd_loc_date.len]='\0';		     

		if (OERROR)
		disp_message(ERR_MESG,"Date conversion failed...\n");
        //err_mesg("SELECTING Date failed",0,"");

}

fetch_legend_value()
{
	
	int i=0;
	/* EXEC SQL EXECUTE
	BEGIN	      
  	   sm_populate_report_legend.fetch_legend(:nd_facility_id,:p_language_id,'RDROUTOR.LEGEND_');
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin sm_populate_report_legend . fetch_legend ( :nd_facilit\
y_id , :p_language_id , 'RDROUTOR.LEGEND_' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )557;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
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





	for (i=1; i<=100; i++)
	{

	l_translated_value.arr[0]		= '\0';
	
	/* EXEC SQL EXECUTE
	BEGIN
       :l_translated_value := GET_LEGEND(LTRIM(RTRIM('RDROUTOR.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009'))))));
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin :l_translated_value := GET_LEGEND ( LTRIM ( RTRIM ( 'R\
DROUTOR.LEGEND_' || LTRIM ( RTRIM ( TO_CHAR ( :i , '009' ) ) ) ) ) ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )580;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_translated_value;
 sqlstm.sqhstl[0] = (unsigned int  )202;
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

	strcpy(loc_legend[i],l_translated_value.arr);

	}

}


/***************************************************************************/ 
