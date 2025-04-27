
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
           char  filnam[40];
};
static const struct sqlcxp sqlfpn =
{
    39,
    "D:\\work\\october\\kauh_scf\\6i\\blrrevst.pc"
};


static unsigned long sqlctx = 253718635;


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

 static const char *sq0009 = 
"TY_CODE,'!!!!') between nvl(:b6,'!!!!') and nvl(:b7,'~~~~')) and NVL(B.RES_A\
REA_CODE,'!!!!!!') between nvl(:b8,'!!!!!!') and nvl(:b9,'~~~~~~')) and NVL(D.\
REGION_CODE,'!!!!!!') between :b10 and :b11) and A.PRT_GRP_HDR_CODE=E.PRT_GRP_\
HDR_CODE) and NVL(E.INCOME_YN,'N')='Y') and A.OPERATING_FACILITY_ID=:b12) grou\
p by C.REGION_CODE,C.SHORT_DESC,B.RES_AREA_CODE,D.SHORT_dESC,B.NATIONALITY_COD\
E,A.EPISODE_TYPE,A.EPISODE_ID,A.VISIT_ID order by C.REGION_CODE,B.RES_AREA_COD\
E,B.NATIONALITY_CODE,A.EPISODE_TYPE            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4146,0,0,0,
5,0,0,1,0,0,27,200,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,30,222,0,0,0,0,0,1,0,
51,0,0,3,0,0,32,228,0,0,0,0,0,1,0,
66,0,0,4,270,0,4,241,0,0,14,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
137,0,0,5,91,0,2,286,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
160,0,0,6,0,0,32,296,0,0,0,0,0,1,0,
175,0,0,7,158,0,4,307,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
210,0,0,8,0,0,32,325,0,0,0,0,0,1,0,
225,0,0,9,1537,0,9,397,0,0,13,13,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
292,0,0,10,0,0,32,406,0,0,0,0,0,1,0,
307,0,0,9,0,0,15,560,0,0,0,0,0,1,0,
322,0,0,9,0,0,13,575,0,0,9,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,3,0,0,2,3,0,0,2,4,0,0,
373,0,0,11,0,0,32,603,0,0,0,0,0,1,0,
388,0,0,12,0,0,32,789,0,0,0,0,0,1,0,
403,0,0,13,136,0,4,906,0,0,3,2,0,1,0,2,3,0,0,1,3,0,0,1,9,0,0,
430,0,0,14,0,0,32,923,0,0,0,0,0,1,0,
445,0,0,15,136,0,4,1004,0,0,3,2,0,1,0,2,4,0,0,1,3,0,0,1,9,0,0,
472,0,0,16,0,0,32,1020,0,0,0,0,0,1,0,
487,0,0,17,136,0,4,1087,0,0,3,2,0,1,0,2,3,0,0,1,3,0,0,1,9,0,0,
514,0,0,18,0,0,32,1103,0,0,0,0,0,1,0,
529,0,0,19,91,0,2,1587,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
552,0,0,20,82,0,4,1599,0,0,2,1,0,1,0,2,3,0,0,1,9,0,0,
575,0,0,21,95,0,4,1611,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
598,0,0,22,0,0,32,1623,0,0,0,0,0,1,0,
613,0,0,23,96,0,4,1646,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
636,0,0,24,165,0,6,1653,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
667,0,0,25,143,0,6,1673,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
};


#include <stdio.h>
//#include <math.h>
#include <string.h>
#include <bl.h>
   
#define MAX_LINES 55  
#define OERROR (sqlca.sqlcode < 0)
#define NODATAFOUND sqlca.sqlcode==1403
#define VER  "VER : 4.1\n"     
#define ESC 0x1B    
                    
/* EXEC SQL BEGIN DECLARE SECTION; */ 


	/* VARCHAR uid_pwd					[91],
			nd_session_id        	[16],
			nd_pgm_date	    	    [20],
			p_language_id           [3],

			//input parameters through from SY_PROG_PARAM 
			nd_fm_trans_date        [25],
            nd_to_trans_date        [25],
            nd_fm_nat_code	        [5],
            nd_to_nat_code 	        [5],
			nd_fm_region_cd			[6],
			nd_to_region_cd			[6],
			nd_fm_res_area_cd		[6],	
			nd_to_res_area_cd		[6],
			nd_fm_doc_cd			[16],
			nd_to_doc_cd			[16],
			nd_report_option	    [2],
			d_nat_code              [5],  
            d_nationality           [31],
			d_prev_nat_code         [21],      
			nd_operating_facility_id [3],
			date_convert			 [17],
			nd_temp_date		     [17],
			nd_loc_date			     [17],

			//for header routine
			d_acc_entity_name        [41],
			d_user                   [21],
			d_sysdate                [17],
			l_prev_region_code		 [7],
			l_prev_region_desc		 [101],
			l_prev_res_area_code	 [7],
			l_prev_area_desc		 [101],
			l_prev_nationality_code  [10],
			l_prev_nat_desc			 [21],
			l_prev_episode_type      [2],
			l_prev_res_area_desc	 [101],

			l_current_region_code	 [7],		
			l_current_res_area_code	 [7],
			l_current_nationality_code[10],
			l_current_episode_type	 [2],

			r_region_code			 [10],
			r_region_desc			 [101],
			r_res_area_code			 [10],	
			r_res_area_desc			 [101],
			r_nationality_code		 [10],
			r_episode_type			 [2],
			l_temp_nat_code			 [6],
			l_pk_value		         [100],
		    l_translated_value	     [201],
			
		    nd_facility_id	    [3]; */ 
struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[20]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[25]; } nd_fm_trans_date;

struct { unsigned short len; unsigned char arr[25]; } nd_to_trans_date;

struct { unsigned short len; unsigned char arr[5]; } nd_fm_nat_code;

struct { unsigned short len; unsigned char arr[5]; } nd_to_nat_code;

struct { unsigned short len; unsigned char arr[6]; } nd_fm_region_cd;

struct { unsigned short len; unsigned char arr[6]; } nd_to_region_cd;

struct { unsigned short len; unsigned char arr[6]; } nd_fm_res_area_cd;

struct { unsigned short len; unsigned char arr[6]; } nd_to_res_area_cd;

struct { unsigned short len; unsigned char arr[16]; } nd_fm_doc_cd;

struct { unsigned short len; unsigned char arr[16]; } nd_to_doc_cd;

struct { unsigned short len; unsigned char arr[2]; } nd_report_option;

struct { unsigned short len; unsigned char arr[5]; } d_nat_code;

struct { unsigned short len; unsigned char arr[31]; } d_nationality;

struct { unsigned short len; unsigned char arr[21]; } d_prev_nat_code;

struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[17]; } date_convert;

struct { unsigned short len; unsigned char arr[17]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[17]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[41]; } d_acc_entity_name;

struct { unsigned short len; unsigned char arr[21]; } d_user;

struct { unsigned short len; unsigned char arr[17]; } d_sysdate;

struct { unsigned short len; unsigned char arr[7]; } l_prev_region_code;

struct { unsigned short len; unsigned char arr[101]; } l_prev_region_desc;

struct { unsigned short len; unsigned char arr[7]; } l_prev_res_area_code;

struct { unsigned short len; unsigned char arr[101]; } l_prev_area_desc;

struct { unsigned short len; unsigned char arr[10]; } l_prev_nationality_code;

struct { unsigned short len; unsigned char arr[21]; } l_prev_nat_desc;

struct { unsigned short len; unsigned char arr[2]; } l_prev_episode_type;

struct { unsigned short len; unsigned char arr[101]; } l_prev_res_area_desc;

struct { unsigned short len; unsigned char arr[7]; } l_current_region_code;

struct { unsigned short len; unsigned char arr[7]; } l_current_res_area_code;

struct { unsigned short len; unsigned char arr[10]; } l_current_nationality_code;

struct { unsigned short len; unsigned char arr[2]; } l_current_episode_type;

struct { unsigned short len; unsigned char arr[10]; } r_region_code;

struct { unsigned short len; unsigned char arr[101]; } r_region_desc;

struct { unsigned short len; unsigned char arr[10]; } r_res_area_code;

struct { unsigned short len; unsigned char arr[101]; } r_res_area_desc;

struct { unsigned short len; unsigned char arr[10]; } r_nationality_code;

struct { unsigned short len; unsigned char arr[2]; } r_episode_type;

struct { unsigned short len; unsigned char arr[6]; } l_temp_nat_code;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;


			int		r_episode_id;   	
			int		r_visit_id;   	
			int		i;

			char g_facility_id[3];

			char filename[150];
			char x_msg[200];
			char loc_legend[999][201];
			char l_mesg[200];
			char    string_var[150];	
			char    aMesg[200];
			int     l_rec_count			= 0;
			
			double r_revenue				= 0.00;
			int l_nat_revenue			= 0;
			double l_nat_total_revenue	= 0.00;

			double l_total_report_revenue	= 0.00;
			int l_rep_no_of_adm			= 0;
			int l_rep_no_of_visit		= 0;
			int l_rep_no_patient_days	= 0;
			double l_rep_ip_revenue		= 0.00;
			double l_rep_op_revenue		= 0.00;
			double l_rep_rf_revenue		= 0.00;
			int l_rep_patient_days		= 0;

			double l_total_region_revenue= 0.00;
			int l_reg_no_of_adm			= 0;
			int l_reg_no_of_visit		= 0;
			int l_reg_no_patient_days	= 0;
			double l_reg_ip_revenue		= 0.00;
			double l_reg_op_revenue		= 0.00;
			double l_reg_rf_revenue		= 0.00;
			int l_reg_patient_days		= 0;

			double l_total_area_revenue	= 0.00;
			int l_area_no_of_adm		= 0;
			int l_area_no_of_visit		= 0;
			int l_area_no_patient_days	= 0;
			double l_area_ip_revenue		= 0.00;
			double l_area_op_revenue		= 0.00;
			double l_area_rf_revenue		= 0.00;
			double l_area_patient_days	= 0.00;

			int l_nat_no_of_adm			= 0;
			int l_nat_no_of_visit		= 0;
			int l_nat_no_patient_days	= 0;
			double l_nat_ip_revenue		= 0.00;
			double l_nat_op_revenue		= 0.00;
			double l_nat_rf_revenue		= 0.00;

			int l_nat_patient_days		= 0;

			int l_nationality_count		= 0;

			char l_fmt_report_revenue[20];
			char l_fmt_rep_ip_revenue[20];
			char l_fmt_rep_op_revenue[20];
			char l_fmt_rep_rf_revenue[20];


			char l_fmt_total_region_revenue[20];
			char l_fmt_reg_ip_revenue[20];
			char l_fmt_reg_op_revenue[20];
			char l_fmt_reg_rf_revenue[20];

			char l_fmt_total_area_revenue[20];
			char l_fmt_area_ip_revenue[20];
			char l_fmt_area_op_revenue[20];
			char l_fmt_area_rf_revenue[20];

			char l_fmt_nat_total_revenue[20];
			char l_fmt_nat_op_revenue[20];
			char l_fmt_nat_ip_revenue[20];
			char l_fmt_nat_rf_revenue[20];

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

FILE *f1;

int  line_no=0, 
	 page_no=0;

void proc_main(argc, argv)
int argc;
char *argv[];
{
	void	get_params(),
  			get_header_dtls(),
  			do_report();
 
	if(argc < 5) 
	{
		disp_message(ERR_MESG,"Usage BLRREVST uid/passwd session_id pgm_date facility_id");
		proc_exit();
	}

    strcpy(uid_pwd.arr,argv[1]);
    uid_pwd.len = strlen(uid_pwd.arr);

    strcpy(nd_session_id.arr,argv[2]);
    nd_session_id.len = strlen(nd_session_id.arr);
    strcpy(g_session_id,argv[2]);
    
    strcpy(nd_pgm_date.arr,argv[3]);
    nd_pgm_date.len = strlen(nd_pgm_date.arr);

	strcpy(nd_facility_id.arr,argv[4]);
   	nd_facility_id.len = strlen(nd_facility_id.arr);
   	strcpy(g_facility_id,nd_facility_id.arr);

    strcpy(g_pgm_id,"BLRREVST");
    strcpy(g_pgm_date,argv[3]);


	strcpy(filename,WORKING_DIR);
	strcat(filename,"blrrevst.lis");

	if((f1 = fopen(filename, "w")) == NULL) 
	{
		disp_message(ERR_MESG,".... Error opening output file ....");
		proc_exit();
	} 


	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

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
 if (sqlca.sqlcode < 0) goto err_exit;
}

  

   set_meduser_role();
   
   strcpy(p_language_id.arr,l_language_id.arr);
   p_language_id.len = l_language_id.len;

   
   get_params();
   get_header_dtls();
	    
   fetch_legend_value();
   ip_op_revenue_cur();

   do_report();
	    

   delete_prog_param();

   fclose(f1);

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


	   disp_message(ERR_MESG,"Oracle error at main() occured....");
	   disp_message(ORA_MESG, sqlca.sqlerrm.sqlerrmc);
	   proc_exit();
}   


// get the parameters from the SY_PROG_PARM table and
// delete the record after reading it.
void get_params()
{

   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL SELECT OPERATING_FACILITY_ID,
				   PARAM1,
				   PARAM2,
				   PARAM3,
				   PARAM4,
				   PARAM5,
				   PARAM6,
				   PARAM7,
				   PARAM8,
				   PARAM9,
				   PARAM10,
				   PARAM11
            INTO   :nd_operating_facility_id,
				   :nd_fm_trans_date,
	               :nd_to_trans_date,
	               :nd_fm_nat_code,
	               :nd_to_nat_code,
				   :nd_fm_region_cd,
				   :nd_to_region_cd,
				   :nd_fm_res_area_cd,
				   :nd_to_res_area_cd,
				   :nd_fm_doc_cd,
				   :nd_to_doc_cd,
				   :nd_report_option
			FROM   SY_PROG_PARAM
			WHERE  PGM_ID		= 'BLRREVST'
		    AND	   SESSION_ID	= TO_NUMBER(:nd_session_id)
		    AND    PGM_DATE		= :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,PARA\
M4 ,PARAM5 ,PARAM6 ,PARAM7 ,PARAM8 ,PARAM9 ,PARAM10 ,PARAM11 into :b0,:b1,:b2,\
:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11  from SY_PROG_PARAM where ((PGM_ID='BLRR\
EVST' and SESSION_ID=TO_NUMBER(:b12)) and PGM_DATE=:b13)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )66;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_fm_trans_date;
   sqlstm.sqhstl[1] = (unsigned int  )27;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_to_trans_date;
   sqlstm.sqhstl[2] = (unsigned int  )27;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_fm_nat_code;
   sqlstm.sqhstl[3] = (unsigned int  )7;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_to_nat_code;
   sqlstm.sqhstl[4] = (unsigned int  )7;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_fm_region_cd;
   sqlstm.sqhstl[5] = (unsigned int  )8;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_to_region_cd;
   sqlstm.sqhstl[6] = (unsigned int  )8;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_fm_res_area_cd;
   sqlstm.sqhstl[7] = (unsigned int  )8;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_to_res_area_cd;
   sqlstm.sqhstl[8] = (unsigned int  )8;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_fm_doc_cd;
   sqlstm.sqhstl[9] = (unsigned int  )18;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_to_doc_cd;
   sqlstm.sqhstl[10] = (unsigned int  )18;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&nd_report_option;
   sqlstm.sqhstl[11] = (unsigned int  )4;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[12] = (unsigned int  )18;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[13] = (unsigned int  )22;
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
   if (sqlca.sqlcode < 0) goto err_exit;
}



    nd_fm_trans_date.arr[nd_fm_trans_date.len]   = '\0';
    nd_to_trans_date.arr[nd_to_trans_date.len]   = '\0';
    nd_fm_nat_code.arr[nd_fm_nat_code.len]	     = '\0';
    nd_to_nat_code.arr[nd_to_nat_code.len]	     = '\0';
	nd_fm_region_cd.arr[nd_fm_region_cd.len]	 = '\0';
	nd_to_region_cd.arr[nd_to_region_cd.len]	 = '\0';
	nd_fm_res_area_cd.arr[nd_fm_res_area_cd.len] = '\0';
	nd_to_res_area_cd.arr[nd_to_res_area_cd.len] = '\0';
	nd_fm_doc_cd.arr[nd_fm_doc_cd.len]	         = '\0';
	nd_to_doc_cd.arr[nd_to_doc_cd.len]			 = '\0';
	nd_report_option.arr[nd_report_option.len]	 = '\0';

	strcpy(g_facility_id,nd_operating_facility_id.arr);

    //delete the parameter record
    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    /* EXEC SQL DELETE SY_PROG_PARAM
	 		  WHERE PGM_ID		= 'BLRREVST'
	            AND SESSION_ID	= :nd_session_id
		        AND PGM_DATE	= :nd_pgm_date; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 14;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='BLRREVST' and\
 SESSION_ID=:b0) and PGM_DATE=:b1)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )137;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
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
    if (sqlca.sqlcode < 0) goto err_exit;
}



	return;

  err_exit:

	/* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

	/* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )160;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	disp_message(ERR_MESG,"Oracle error at get_params() occured....");
	disp_message(ORA_MESG, sqlca.sqlerrm.sqlerrmc);
	proc_exit();
}
 

//get the header details
void get_header_dtls()
{
    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    /* EXEC SQL SELECT ACC_ENTITY_NAME,
				    USER,
				    TO_CHAR(SYSDATE, 'DD/MM/YYYY HH24:MI')
		      INTO :d_acc_entity_name,
			  	   :d_user,
				   :d_sysdate
              FROM SY_ACC_ENTITY_lang_vw
			  WHERE ACC_ENTITY_ID = :nd_operating_facility_id
			  and language_id=:p_language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 14;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,USER ,TO_CHAR(SYSDATE,'DD/MM/YYYY\
 HH24:MI') into :b0,:b1,:b2  from SY_ACC_ENTITY_lang_vw where (ACC_ENTITY_ID=:\
b3 and language_id=:b4)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )175;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_acc_entity_name;
    sqlstm.sqhstl[0] = (unsigned int  )43;
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
    if (sqlca.sqlcode < 0) goto err_exit;
}



	d_acc_entity_name.arr[d_acc_entity_name.len] = '\0';
	d_user.arr[d_user.len]                       = '\0';
	d_sysdate.arr[d_sysdate.len]                 = '\0';

	return;

	err_exit:
	   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

	   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 14;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )210;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	   disp_message(ERR_MESG,"Oracle error at get_header_dtls() occured....");
	   disp_message(ORA_MESG, sqlca.sqlerrm.sqlerrmc);
	   proc_exit();
}
 
ip_op_revenue_cur()
{
    
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

	  /* EXEC SQL DECLARE ip_op_revenue_cur
	  			CURSOR 
				   FOR
				SELECT  NVL(C.REGION_CODE,'Nil'),
 						NVL(C.SHORT_DESC,'Not Specified'),
      					NVL(B.RES_AREA_CODE,'Nil'),
 						NVL(D.SHORT_dESC,'Not Specified'),
      					NVL(B.NATIONALITY_CODE,'Nil')	,
 						A.EPISODE_TYPE		,
						A.EPISODE_ID		,
						A.VISIT_ID			,
  						ROUND(SUM(nvl(A.ORG_NET_CHARGE_AMT,0)),2)
				  FROM  BL_PATIENT_CHARGES_FOLIO	A,
 						MP_PATIENT_MAST     		B,
    					MP_REGION_lang_vw			C,
      					MP_RES_AREA_lang_vw			D,
						BL_BLNG_PRT_GRP_HDR 		E
				 WHERE  TRUNC(A.TRX_DATE,'MI')  
			   BETWEEN  TO_DATE(:nd_fm_trans_date,'DD/MM/YYYY HH24:MI')
   				   AND	TO_DATE(:nd_to_trans_date,'DD/MM/YYYY HH24:MI')
                   AND  A.TRX_FINALIZE_IND = 'Y'       
				   AND	C.language_id=:p_language_id  
				   AND  C.language_id=D.language_id
				   //AND  NVL(A.TRX_STATUS,'Z')  !=  'C'   
			       AND	( NVL(PACKAGE_IND,'X')      = 'S' 
						  OR (NVL(PACKAGE_TRX_IND,'X')  = 'Y' AND NVL(PACKAGE_IND,'X')= 'P')  
				   		  OR (AVAILED_IND IN('U','Y'))) 
				   AND  NVL(A.PHYSICIAN_ID,'!!!!!!!!!!!!!!!') 
			   BETWEEN  nvl(:nd_fm_doc_cd,'!!!!!!!!!!!!!!!')
				   AND  nvl(:nd_to_doc_cd,'~~~~~~~~~~~~~~~')
				   AND  A.EPISODE_TYPE = DECODE(:nd_report_option,'I','I','O','O','D','D','E','E','R','R', 'B',A.EPISODE_TYPE)	//31/10/2004
				   AND  A.PATIENT_ID   			=	B.PATIENT_ID
				   AND  B.RES_AREA_CODE  		=	D.RES_AREA_CODE(+)
       			   AND  D.REGION_CODE      	      = 	C.REGION_CODE(+)
				   AND  NVL(B.NATIONALITY_CODE,'!!!!')
			   BETWEEN  nvl(:nd_fm_nat_code,'!!!!')
				   AND  nvl(:nd_to_nat_code,'~~~~')
				   AND  NVL(B.RES_AREA_CODE,'!!!!!!')
			   BETWEEN  nvl(:nd_fm_res_area_cd,'!!!!!!')
				   AND  nvl(:nd_to_res_area_cd,'~~~~~~')
				   AND  NVL(D.REGION_CODE,'!!!!!!')
		           BETWEEN :nd_fm_region_cd  AND  :nd_to_region_cd 
				   AND  A.PRT_GRP_HDR_CODE		=	E.PRT_GRP_HDR_CODE 
				   AND  NVL(E.INCOME_YN,'N')	=  'Y'
				   AND  A.OPERATING_FACILITY_ID = :nd_operating_facility_id
				 GROUP
					BY  C.REGION_CODE		,
 						C.SHORT_DESC		,
      					B.RES_AREA_CODE		,
 						D.SHORT_dESC		,
      					B.NATIONALITY_CODE	,
 						A.EPISODE_TYPE		,
						A.EPISODE_ID		,
						A.VISIT_ID			
				 ORDER
					BY	C.REGION_CODE,
						B.RES_AREA_CODE,
						B.NATIONALITY_CODE,
						A.EPISODE_TYPE; */ 

	     

	   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

	   /* EXEC SQL OPEN ip_op_revenue_cur; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 14;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlbuft((void **)0, 
      "select NVL(C.REGION_CODE,'Nil') ,NVL(C.SHORT_DESC,'Not Specified') ,N\
VL(B.RES_AREA_CODE,'Nil') ,NVL(D.SHORT_dESC,'Not Specified') ,NVL(B.NATIONAL\
ITY_CODE,'Nil') ,A.EPISODE_TYPE ,A.EPISODE_ID ,A.VISIT_ID ,ROUND(sum(nvl(A.O\
RG_NET_CHARGE_AMT,0)),2)  from BL_PATIENT_CHARGES_FOLIO A ,MP_PATIENT_MAST B\
 ,MP_REGION_lang_vw C ,MP_RES_AREA_lang_vw D ,BL_BLNG_PRT_GRP_HDR E where ((\
(((((((((((((TRUNC(A.TRX_DATE,'MI') between TO_DATE(:b0,'DD/MM/YYYY HH24:MI'\
) and TO_DATE(:b1,'DD/MM/YYYY HH24:MI') and A.TRX_FINALIZE_IND='Y') and C.la\
nguage_id=:b2) and C.language_id=D.language_id) and ((NVL(PACKAGE_IND,'X')='\
S' or (NVL(PACKAGE_TRX_IND,'X')='Y' and NVL(PACKAGE_IND,'X')='P')) or AVAILE\
D_IND in ('U','Y'))) and NVL(A.PHYSICIAN_ID,'!!!!!!!!!!!!!!!') between nvl(:\
b3,'!!!!!!!!!!!!!!!') and nvl(:b4,'~~~~~~~~~~~~~~~')) and A.EPISODE_TYPE=DEC\
ODE(:b5,'I','I','O','O','D','D','E','E','R','R','B',A.EPISODE_TYPE)) and A.P\
ATIENT_ID=B.PATIENT_ID) and B.RES_AREA_CODE=D.RES_AREA_CODE(+)) and D.REGION\
_CODE=C.REGION_CODE(+)) and NVL(B.NATIONALI");
    sqlstm.stmt = sq0009;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )225;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_fm_trans_date;
    sqlstm.sqhstl[0] = (unsigned int  )27;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_to_trans_date;
    sqlstm.sqhstl[1] = (unsigned int  )27;
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
    sqlstm.sqhstv[3] = (         void  *)&nd_fm_doc_cd;
    sqlstm.sqhstl[3] = (unsigned int  )18;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_to_doc_cd;
    sqlstm.sqhstl[4] = (unsigned int  )18;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_report_option;
    sqlstm.sqhstl[5] = (unsigned int  )4;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_fm_nat_code;
    sqlstm.sqhstl[6] = (unsigned int  )7;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_to_nat_code;
    sqlstm.sqhstl[7] = (unsigned int  )7;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_fm_res_area_cd;
    sqlstm.sqhstl[8] = (unsigned int  )8;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&nd_to_res_area_cd;
    sqlstm.sqhstl[9] = (unsigned int  )8;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&nd_fm_region_cd;
    sqlstm.sqhstl[10] = (unsigned int  )8;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&nd_to_region_cd;
    sqlstm.sqhstl[11] = (unsigned int  )8;
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


	   return;

		  	err_exit:
  	
		   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 


		   disp_message(ERR_MESG, sqlca.sqlerrm.sqlerrmc);
		   disp_message(ERR_MESG,"Oracle error at ip_op_revenue_cur() occured....");
		   		   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
          struct sqlexd sqlstm;
          sqlstm.sqlvsn = 10;
          sqlstm.arrsiz = 14;
          sqlstm.sqladtp = &sqladt;
          sqlstm.sqltdsp = &sqltds;
          sqlstm.iters = (unsigned int  )1;
          sqlstm.offset = (unsigned int  )292;
          sqlstm.cud = sqlcud0;
          sqlstm.sqlest = (unsigned char  *)&sqlca;
          sqlstm.sqlety = (unsigned short)256;
          sqlstm.occurs = (unsigned int  )0;
          sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		   proc_exit();
}


//prints the master-detail record until the cursor is empty
void do_report()
{
  void print_rep_header();
  void print_page_header();
  void prepare_new_page();
  int  fetch_ip_op_revenue_cur();	

  print_rep_header();
  
  prepare_new_page();
  
  
  while(fetch_ip_op_revenue_cur())
  {
	l_rec_count = l_rec_count + 1;

	//sprintf(aMesg,"Rec Count : %-6d",l_rec_count);
	//disp_message(ERR_MESG,aMesg);

	//for the first record in the cursor the full row will  be 
	//printed.
	if (l_rec_count==1) 
	{
		l_prev_region_code.arr[0]	  = '\0';
		l_prev_region_desc.arr[0]	  = '\0';	
		l_prev_res_area_code.arr[0]	  = '\0';
		l_prev_area_desc.arr[0]		  = '\0';	
		l_prev_nationality_code.arr[0]= '\0';
		l_prev_episode_type.arr[0]	  = '\0';	

		strcpy(l_prev_region_code.arr,r_region_code.arr);
		strcpy(l_prev_region_desc.arr,r_region_desc.arr);
		strcpy(l_prev_res_area_code.arr,r_res_area_code.arr);
		strcpy(l_prev_res_area_desc.arr,r_res_area_desc.arr);
		strcpy(l_prev_nationality_code.arr,r_nationality_code.arr);
		strcpy(l_prev_episode_type.arr,r_episode_type.arr);	
		
		print_region_record();
		print_area_record();
		calc_region_revenue();
		calc_region_no_adm_visit();
		calc_region_patient_days();

		calc_area_revenue();
		calc_area_no_adm_visit();
		calc_area_patient_days();

		calc_nat_revenue();
		get_nationality_desc();
		calc_nat_no_adm_visit();
		calc_nat_patient_days();
		
	}

	if (l_rec_count > 1)
	{
		//if previous region code is current region code then
		//region code should not be printed, and the check has 
		//to be continue for area level
		if (strcmp(l_prev_region_code.arr,r_region_code.arr) == 0)
		{
			calc_region_revenue();
			calc_region_no_adm_visit();
			calc_region_patient_days();

			//if previous residence area code is current res area 
			//code then, residence area code should not be printed
			if (strcmp(l_prev_res_area_code.arr,r_res_area_code.arr) == 0)
			{
				calc_area_revenue();
				calc_area_no_adm_visit();
				calc_area_patient_days();

				//if previous residence code is current residence code
				//then nationality has to be checked.
				if (strcmp(l_prev_nationality_code.arr,r_nationality_code.arr) == 0)
				{
					calc_nat_revenue();
					calc_nat_no_adm_visit();
					calc_nat_patient_days();
				}	
				//else nationality
				else
				{
					print_nat_record();
					swap_nat_variables();
					calc_nat_revenue();
					calc_nat_no_adm_visit();
					calc_nat_patient_days();
				}
			}
			//else residence area code and rest of the fields has 
			//to be printed.
			else
			{
				print_nat_record();
				print_area_total();
				print_area_record();

				swap_area_vaiables();
				calc_area_revenue();
				calc_area_no_adm_visit();
				calc_area_patient_days();

				swap_nat_variables();
				calc_nat_revenue();
				calc_nat_no_adm_visit();
				calc_nat_patient_days();
			}
			//disp_message(ERR_MESG,"OUT IF AREA");					
			
		}
		//if previous not equal to current the new value is 
		//assigned to previous and rest of line other than 
		//region code  is printed.
		else
		{
			print_nat_record();
			print_area_total();
			print_region_total();
			print_region_record();
			print_area_record();

			swap_region_vaiables();
			calc_region_revenue();
			calc_region_no_adm_visit();
			calc_region_patient_days();

			swap_area_vaiables();
			calc_area_revenue();
			calc_area_no_adm_visit();
			calc_area_patient_days();

			swap_nat_variables();
			calc_nat_revenue();
			calc_nat_no_adm_visit();
			calc_nat_patient_days();
		}
		//disp_message(ERR_MESG,"OUT IF REGION");					

	}//l_rec_count <> 1 if condition

  }
  print_nat_record();
  print_area_total();
  print_region_total();
  print_report_total();
  print_report_end();  
  /* EXEC SQL CLOSE ip_op_revenue_cur; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )307;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

	
}

/* prepares for the new page */
void prepare_new_page()
{
   //fprintf(f1,"");
   print_page_header();
}

// returns 0 if the end of cursor is reached else returns 1
int fetch_ip_op_revenue_cur()
{
	//disp_message(ERR_MESG,"F1");
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

	/* EXEC SQL FETCH ip_op_revenue_cur 
			  INTO	 :r_region_code,
					 :r_region_desc,
					 :r_res_area_code,
					 :r_res_area_desc,
					 :r_nationality_code,
					 :r_episode_type,
					 :r_episode_id,
					 :r_visit_id,
					 :r_revenue; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )322;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&r_region_code;
 sqlstm.sqhstl[0] = (unsigned int  )12;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&r_region_desc;
 sqlstm.sqhstl[1] = (unsigned int  )103;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&r_res_area_code;
 sqlstm.sqhstl[2] = (unsigned int  )12;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&r_res_area_desc;
 sqlstm.sqhstl[3] = (unsigned int  )103;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&r_nationality_code;
 sqlstm.sqhstl[4] = (unsigned int  )12;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&r_episode_type;
 sqlstm.sqhstl[5] = (unsigned int  )4;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&r_episode_id;
 sqlstm.sqhstl[6] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&r_visit_id;
 sqlstm.sqhstl[7] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&r_revenue;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}



		//sprintf(aMesg,"Revenue : %-10d",r_revenue);
		//disp_message(ERR_MESG,aMesg);

	 if (NODATAFOUND)
		return 0;

	 r_region_code.arr[r_region_code.len]='\0';
	 r_region_desc.arr[r_region_desc.len]='\0';
	 r_res_area_code.arr[r_res_area_code.len]='\0';
	 r_res_area_desc.arr[r_res_area_desc.len]='\0';
	 r_nationality_code.arr[r_nationality_code.len]='\0';
	 r_episode_type.arr[r_episode_type.len]='\0';
	
    return 1;
	
	err_exit:
		/* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

		/* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )373;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		disp_message(ERR_MESG,"Oracle error at fetch_ip_op_revenue_cur() occured....");
		sprintf(aMesg,"Error: %-100s",sqlca.sqlerrm.sqlerrmc);
		disp_message(ERR_MESG,aMesg);
		disp_message(ORA_MESG, sqlca.sqlerrm.sqlerrmc);
		proc_exit();
}

//Print the finishing line of the report 
void end_report()
{
  fprintf(f1,"\n\n");
  fprintf(f1,"                                                   ");
  fprintf(f1,"** End of Report **");
  fprintf(f1,"");
}  

//to print the header page for the report  
void print_rep_header()    
{

    fprintf(f1,"%c&l1O",ESC);   /* To Print Landscape           */
    fprintf(f1,"%c(s14H",ESC); 	/* To set the font size			*/

	init_date_temp_var();
	 strcpy(date_convert.arr,d_sysdate.arr);
     fun_change_loc_date();

	if (strcmp(nd_report_option.arr,"B") == 0)
	{
		//fprintf(f1,"\f%-5.5s : %2.2s%45.45s%s%39.39s%s\n",loc_legend[540],loc_legend[150]," ",d_acc_entity_name.arr," ",date_convert.arr);commented by saikiran
        fprintf(f1,"%-5.5s : %2.2s%45.45s%s%39.39s%s\n",loc_legend[540],loc_legend[150]," ",d_acc_entity_name.arr," ",date_convert.arr);

		fprintf(f1,"%-5.5s : %-10s \n",loc_legend[550], d_user.arr);
		fprintf(f1,"%-5.5s : %-8.8s%23.23s%5.5s%1s%5.5s%1s%-47.47s%12.12s%-4.4s : %4d\n",loc_legend[560],loc_legend[40]," ",loc_legend[260],"/",loc_legend[290],"/",loc_legend[200]," ",loc_legend[30],++page_no);
 		fprintf(f1,"---------------------------------------------------------------------------------------------------------------------------------------\n");
	}
	else if (strcmp(nd_report_option.arr,"I")==0)
	{
		//fprintf(f1,"\f%-5.5s : %2.2s%28.28s%s%25.25s%s\n",loc_legend[540],loc_legend[150]," ",d_acc_entity_name.arr," ",date_convert.arr);commented by saikiran
		fprintf(f1,"\f%-5.5s : %2.2s%28.28s%s%25.25s%s\n",loc_legend[540],loc_legend[150]," ",d_acc_entity_name.arr," ",date_convert.arr);
		fprintf(f1,"%-5.5s : %-10s \n",loc_legend[550], d_user.arr);
		fprintf(f1,"%-5.5s : %-8.8s%10.10s%-47.47s%6.6s%-4.4s : %4d\n",loc_legend[560],loc_legend[40]," ",loc_legend[170]," ",loc_legend[30],++page_no);
		fprintf(f1,"------------------------------------------------------------------------------------------------\n");
	}
	else if (strcmp(nd_report_option.arr,"D")==0)
	{
		//fprintf(f1,"\f%-5.5s : %2s%28.28s%s%25.25s%s\n",loc_legend[540],loc_legend[150]," ",d_acc_entity_name.arr," ",date_convert.arr);commented by saikiran
		fprintf(f1,"%-5.5s : %2s%28.28s%s%25.25s%s\n",loc_legend[540],loc_legend[150]," ",d_acc_entity_name.arr," ",date_convert.arr);
		fprintf(f1,"%-5.5s : %-10s \n",loc_legend[550], d_user.arr);
		fprintf(f1,"%-5.5s : %-8.8s%10.10s%-47.47s%6.6s%-4.4s : %4d\n",loc_legend[560],loc_legend[40]," ",loc_legend[180]," ",loc_legend[30],++page_no);
		fprintf(f1,"------------------------------------------------------------------------------------------------\n");
	}

	else if (strcmp(nd_report_option.arr,"O")==0)
	{

		//fprintf(f1,"\f%-5.5s : %2.2s%28.28s%s%25.25s%s\n",loc_legend[540],loc_legend[150]," ",d_acc_entity_name.arr," ",date_convert.arr);commented by saikiran
		fprintf(f1,"%-5.5s : %2.2s%28.28s%s%25.25s%s\n",loc_legend[540],loc_legend[150]," ",d_acc_entity_name.arr," ",date_convert.arr);
		fprintf(f1,"%-5.5s : %-10s \n",loc_legend[550], d_user.arr);
		fprintf(f1,"%-5.5s : %-8.8s%10.10s%-47.47s%6.6s%-4.4s : %4d\n",loc_legend[560],loc_legend[40]," ",loc_legend[190]," ",loc_legend[30],++page_no);
		fprintf(f1,"------------------------------------------------------------------------------------------------\n");
	}
	else if (strcmp(nd_report_option.arr,"E")==0)
	{

		//fprintf(f1,"\f%-5.5s : %2.2s%28.28s%s%25.25s%s\n",loc_legend[540],loc_legend[150]," ",d_acc_entity_name.arr," ",date_convert.arr);commented by saikiran
		fprintf(f1,"%-5.5s : %2.2s%28.28s%s%25.25s%s\n",loc_legend[540],loc_legend[150]," ",d_acc_entity_name.arr," ",date_convert.arr);
		fprintf(f1,"%-5.5s : %-10s \n",loc_legend[550], d_user.arr);
		fprintf(f1,"%-5.5s : %-8.8s%10.10s%-47.47s%6.6s%-4.4s : %4d\n",loc_legend[560],loc_legend[40]," ",loc_legend[50]," ",loc_legend[30],++page_no);
		fprintf(f1,"------------------------------------------------------------------------------------------------\n");
	}

	else if (strcmp(nd_report_option.arr,"R")==0)
	{

		//fprintf(f1,"\f%-5.5s : %2.2s%28.28s%s%25.25s%s\n",loc_legend[540],loc_legend[150]," ",d_acc_entity_name.arr," ",date_convert.arr);commented by saikiran
		fprintf(f1,"%-5.5s : %2.2s%28.28s%s%25.25s%s\n",loc_legend[540],loc_legend[150]," ",d_acc_entity_name.arr," ",date_convert.arr);
		fprintf(f1,"%-5.5s : %-10s \n",loc_legend[550], d_user.arr);
		fprintf(f1,"%-5.5s : %-8.8s%10.10s%-47.47s%6.6s%-4.4s : %4d\n",loc_legend[560],loc_legend[40]," ",loc_legend[200]," ",loc_legend[30],++page_no);
		fprintf(f1,"------------------------------------------------------------------------------------------------\n");
	}
	fprintf(f1,"\n\n\n\n\n        %-20.20s :\n        ----------------\n\n",loc_legend[520]);


	if (strcmp(nd_fm_trans_date.arr,"!!!!")==0) 
		fprintf(f1,"\t\t%20.20s\t%10.10s\t\t %10.10s\n",loc_legend[80],loc_legend[60],loc_legend[420]);
	else
	 {
	 init_date_temp_var();
	 strcpy(date_convert.arr,nd_fm_trans_date.arr);
     fun_change_loc_date();
	    fprintf(f1,"\t\t%20.20s\t%10.10s\t\t    %10.10s\n",loc_legend[80],loc_legend[60],date_convert.arr);
	 }

	if (strcmp(nd_to_trans_date.arr,"~~~~")==0)
	    fprintf(f1,"\t\t      \t\t        %10.10s\t\t   %6.6s\n",loc_legend[70],loc_legend[430]);
	else
	 {
	 init_date_temp_var();
	 strcpy(date_convert.arr,nd_to_trans_date.arr);
     fun_change_loc_date();
	    fprintf(f1,"\t\t      \t\t        %10.10s\t\t   %11.11s\n\n",loc_legend[70],date_convert.arr);
	 }

	if (strcmp(nd_fm_nat_code.arr,"!!!!")==0) 
	
	    fprintf(f1,"\t\t%20.20s\t%10.10s\t\t    %-10.10s\n",loc_legend[90],loc_legend[60],loc_legend[420]);
	else
	    fprintf(f1,"\t\t%20.20s\t%10.10s\t\t    %-10.10s\n",loc_legend[90],loc_legend[60],nd_fm_nat_code.arr);

	if (strcmp(nd_to_nat_code.arr,"~~~~")==0)
	
	    fprintf(f1,"\t\t      \t\t        %10.10s\t\t    %-10.10s\n\n",loc_legend[70],loc_legend[430]);
	else
	    fprintf(f1,"\t\t      \t\t        %10.10s\t\t    %-10.10s\n\n",loc_legend[70],nd_to_nat_code.arr);

	if (strcmp(nd_fm_region_cd.arr,"!!!!!")==0)
	
	    fprintf(f1,"\t\t%15s\t        %10.10s\t\t    %-10.10s\n",loc_legend[100],loc_legend[60],loc_legend[420]);
	else
	    fprintf(f1,"\t\t%15s\t        %10.10s\t\t    %-10.10s\n",loc_legend[100],loc_legend[60],nd_fm_region_cd.arr);

	if (strcmp(nd_to_region_cd.arr,"~~~~~")==0)     
	
	    fprintf(f1,"\t\t        \t\t%10.10s\t\t    %-10.10s\n\n",loc_legend[70],loc_legend[430]);
	else
	    fprintf(f1,"\t\t        \t\t%10.10s\t\t    %-10.10s\n\n",loc_legend[70],nd_to_region_cd.arr);

	if (strcmp(nd_fm_res_area_cd.arr,"!!!!!!")==0)
	
	    fprintf(f1,"\t\t%23.23s\t%10.10s \t\t    %-10.10s\n",loc_legend[130],loc_legend[60],loc_legend[420]);
	else
        fprintf(f1,"\t\t%23.23s\t%10.10s \t\t    %-10.10s\n",loc_legend[130],loc_legend[60],nd_fm_res_area_cd.arr);

	if (strcmp(nd_to_res_area_cd.arr,"~~~~~~")==0)
	
	    fprintf(f1,"\t\t      \t\t        %10.10s \t\t    %-10.10s\n\n",loc_legend[70],loc_legend[430]);
	else
	    fprintf(f1,"\t\t      \t\t        %10.10s \t\t    %-10.10s\n\n",loc_legend[70],nd_to_res_area_cd.arr);

	if (strcmp(nd_fm_doc_cd.arr,"!!!!!!")==0) 
	
	    fprintf(f1,"\t\t%15.15s\t\t%10.10s\t\t    %-10.10s\n",loc_legend[140],loc_legend[60],loc_legend[420]);
	else
	    fprintf(f1,"\t\t%15.15s\t\t%10.10s\t\t    %-10.10s\n",loc_legend[140],loc_legend[60],nd_fm_doc_cd.arr);

	if (strcmp(nd_to_doc_cd.arr,"~~~~~~")==0) 
	
	    fprintf(f1,"\t\t        \t\t%10.10s\t\t    %-10.10s\n\n",loc_legend[70],loc_legend[430]);
	else
	    fprintf(f1,"\t\t        \t\t%10.10s\t\t    %-10.10s\n\n",loc_legend[70],nd_to_doc_cd.arr);

    if (strcmp(nd_report_option.arr,"B")==0)
	{
		fprintf(f1,"\t\t%16.16s           \t\t            %3.3s",loc_legend[110],loc_legend[280]);
	}
	else if (strcmp(nd_report_option.arr,"O")==0)
	{
		fprintf(f1,"\t\t%16.16s           \t\t            %10.10s",loc_legend[110],loc_legend[380]);
	}
	else if (strcmp(nd_report_option.arr,"E")==0)
	{
		fprintf(f1,"\t\t%16.16s           \t\t            %9.9s",loc_legend[110],loc_legend[390]);
	}

	else if  (strcmp(nd_report_option.arr,"I")==0)
	{
		fprintf(f1,"\t\t%16.16s           \t\t            %9.9s",loc_legend[110],loc_legend[360]);
	}
	else if  (strcmp(nd_report_option.arr,"D")==0)
	{
		fprintf(f1,"\t\t%16.16s           \t\t            %7.7s",loc_legend[110],loc_legend[370]);
	}

	else if  (strcmp(nd_report_option.arr,"R")==0)
	{
		fprintf(f1,"\t\t%16.16s           \t\t            %8.8s",loc_legend[110],loc_legend[400]);
	}

	
  
	return;  

	err_exit:
		/* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

		/* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )388;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		disp_message(ERR_MESG,"Oracle error at print_title() occured....");
		disp_message(ORA_MESG,sqlca.sqlerrm.sqlerrmc);
   
		proc_exit();
}
  

/* to print page headers the header details */ 
void print_page_header()
{   
     init_date_temp_var();
	 strcpy(date_convert.arr,d_sysdate.arr);
     fun_change_loc_date();

	if (strcmp(nd_report_option.arr,"B") == 0)  
	{ 
		
		fprintf(f1,"\f%-5.5s : %2.2s%43.43s%s%53.53s%s\n",loc_legend[540],loc_legend[150]," ",d_acc_entity_name.arr," ",date_convert.arr);
		fprintf(f1,"%-5.5s : %-10s \n",loc_legend[550], d_user.arr);
//		fprintf(f1,"%-5.5s : %-8.8s%24.24s%5.5s%1s%5.5s%1s%-47.47s%23.23s%-4.4s : %4d\n",loc_legend[560],loc_legend[40]," ",loc_legend[260],"/",loc_legend[290],"/",loc_legend[200]," ",loc_legend[30],++page_no);COMMENTED BY SAIKIRAN
		fprintf(f1,"%-5.5s : %-8.8s%24.24s%5.5s%1s%7.7s%1s%-47.47s%23.23s%-4.4s : %4d\n",loc_legend[560],loc_legend[40]," ",loc_legend[260],"/",loc_legend[290],"/",loc_legend[200]," ",loc_legend[30],++page_no);
																											      
		fprintf(f1,"----------------------------------------------------------------------------------------------------------------------------------------\n");
		/*fprintf(f1,"%6s%6s%4s%3s%11s%15s%5s %3s    %5s %7s%1s%5s    %5s %7s%4s     %10s   %5s\n",loc_legend[210]," ",loc_legend[220]," ",loc_legend[230]," ",loc_legend[240],loc_legend[250],loc_legend[260],loc_legend[270]," ",loc_legend[240],loc_legend[290],loc_legend[300]," ",loc_legend[310],loc_legend[320]);
		fprintf(f1,"      %6.6s    %3.3s           %15.15s%3.3s   %4.4s                %1s%6.6s                %4.4s             %5.5s             \n"," "," "," ",loc_legend[330],loc_legend[340]," ",loc_legend[350]," "," ");*/
		fprintf(f1,"%10.10s%2.2s%8.8s%2.2s%15.15s%10.10s%7.7s %5.5s %7.7s%9.9s%1s%7.7s    %7.7s %9.9s%2.2s%-12.12s   %-15.15s\n",loc_legend[210]," ",loc_legend[220]," ",loc_legend[230]," ",loc_legend[240],loc_legend[250],loc_legend[260],loc_legend[270]," ",loc_legend[240],loc_legend[290],loc_legend[300]," ",loc_legend[310],loc_legend[320]);
		fprintf(f1,"      %7.7s    %3.3s           %15.15s %7.7s %6.6s                %1s%8.8s                %4.4s             %5.5s             \n"," "," "," ",loc_legend[330],loc_legend[340]," ",loc_legend[350]," "," ");
		fprintf(f1,"----------------------------------------------------------------------------------------------------------------------------------------\n");
	}
	else if (strcmp(nd_report_option.arr,"I")==0)
	{
		fprintf(f1,"\f%-5.5s : %2.2s%28.28s%s%42.42s%s\n",loc_legend[540],loc_legend[150]," ",d_acc_entity_name.arr," ",date_convert.arr);
		fprintf(f1,"%-5.5s : %-10.10s \n",loc_legend[550], d_user.arr);
		fprintf(f1,"%-5.5s : %-8.8s%10.10s%-47.47s%23.23s%-4.4s : %4d\n",loc_legend[560],loc_legend[40]," ",loc_legend[170]," ",loc_legend[30],++page_no);
		fprintf(f1,"-------------------------------------------------------------------------------------------------------------\n");
		fprintf(f1,"%10.10s%8.8s%8.8s%5.5s%15.15s%14.14s%7.7s %7.7s%4.4s%5.5s %6.6s%4.4s%12.12s\n",loc_legend[210]," ",loc_legend[220]," ",loc_legend[230]," ",loc_legend[240],loc_legend[330]," ",loc_legend[250],loc_legend[340]," ",loc_legend[440]);
//fprintf(f1,"%6s%12s%4s%9s%11s%17s%5s %3s%7s%3s %4s%10s%10s\n",loc_legend[210]," ",loc_legend[220]," ",loc_legend[230]," ",loc_legend[240],loc_legend[330]," ",loc_legend[250],loc_legend[340]," ",loc_legend[440]);
		fprintf(f1,"-------------------------------------------------------------------------------------------------------------\n");
	}
	else if (strcmp(nd_report_option.arr,"D")==0)
	{
		fprintf(f1,"\f%-5.5s : %2.2s%28.28s%s%42.42s%s\n",loc_legend[540],loc_legend[150]," ",d_acc_entity_name.arr," ",date_convert.arr);
		fprintf(f1,"%-5.5s : %-10.10s \n",loc_legend[550], d_user.arr);
		fprintf(f1,"%-5.5s : %-8.8s%10.10s%-47.47s%23.23s%-4.4s : %4d\n",loc_legend[560],loc_legend[40]," ",loc_legend[180]," ",loc_legend[30],++page_no);
		fprintf(f1,"-------------------------------------------------------------------------------------------------------------\n");
		//fprintf(f1,"%6s%12s%4s%9s%11s%17s%5s %3s%7s%3s %4s%10s%10s\n",loc_legend[210]," ",loc_legend[220]," ",loc_legend[230]," ",loc_legend[240],loc_legend[330]," ",loc_legend[250],loc_legend[340]," ",loc_legend[450]);
		fprintf(f1,"%10.10s%8.8s%8.8s%5.5s%15.15s%14.14s%7.7s %7.7s%4.4s%5.5s %6.6s%5.5s%12.12s\n",loc_legend[210]," ",loc_legend[220]," ",loc_legend[230]," ",loc_legend[240],loc_legend[330]," ",loc_legend[250],loc_legend[340]," ",loc_legend[450]);
		fprintf(f1,"-------------------------------------------------------------------------------------------------------------\n");
	}
    
	else if (strcmp(nd_report_option.arr,"O")==0)
	{

		fprintf(f1,"\f%-5.5s : %2.2s%28.28s%s%42.42s%s\n",loc_legend[540],loc_legend[150]," ",d_acc_entity_name.arr," ",date_convert.arr);
		fprintf(f1,"%-5.5s : %-10.10s \n",loc_legend[550], d_user.arr);
		fprintf(f1,"%-5.5s : %-8.8s%10.10s%-47.47s%23.23s%-4.4s : %4d\n",loc_legend[560],loc_legend[40]," ",loc_legend[190]," ",loc_legend[30],++page_no);
		fprintf(f1,"----------------------------------------------------------------------------------------------------------\n");
		//fprintf(f1,"%10.10s%11.11s%8.8s%9.9s%15.15s%15.15s%7.7s %8.8s%6.6s%14.14s\n",loc_legend[210]," ",loc_legend[220]," ",loc_legend[230]," ",loc_legend[240],loc_legend[350]," ",loc_legend[460]); commented by saikiran
		fprintf(f1,"%10.10s%8.8s%8.8s%11.11s%15.15s%15.15s%6.6s %8.8s%8.8s%14.14s\n",loc_legend[210]," ",loc_legend[220]," ",loc_legend[230]," ",loc_legend[240],loc_legend[350]," ",loc_legend[460]);
		fprintf(f1,"----------------------------------------------------------------------------------------------------------\n");
	}

	else if (strcmp(nd_report_option.arr,"R")==0)
	{

		fprintf(f1,"\f%-5.5s : %2.2s%28.28s%s%41.41s%s\n",loc_legend[540],loc_legend[150]," ",d_acc_entity_name.arr," ",date_convert.arr);
		fprintf(f1,"%-5.5s : %-10.10s \n",loc_legend[550], d_user.arr);
		fprintf(f1,"%-5.5s : %-8.8s%10.10s%-47.47s%22.22s%-4.4s : %4d\n",loc_legend[560],loc_legend[40]," ",loc_legend[200]," ",loc_legend[30],++page_no);
		fprintf(f1,"----------------------------------------------------------------------------------------------------------\n");
		fprintf(f1,"%10.10s%8.8s%8.8s%6.6s%14.14s%19.19s     %9.9s%12.12s\n",loc_legend[210]," ",loc_legend[220]," ",loc_legend[230]," "," ",loc_legend[310]);
		fprintf(f1,"----------------------------------------------------------------------------------------------------------\n");
	}    

	else if (strcmp(nd_report_option.arr,"E")==0)
	{

		fprintf(f1,"\f%-5.5s : %2.2s%28.28s%s%42.42s%s\n",loc_legend[540],loc_legend[150]," ",d_acc_entity_name.arr," ",date_convert.arr);
		fprintf(f1,"%-5.5s : %-10.10s \n",loc_legend[550], d_user.arr);
		fprintf(f1,"%-5.5s : %-8.8s%10.10s%-47.47s%23.23s%-4.4s : %4d\n",loc_legend[560],loc_legend[40]," ",loc_legend[50]," ",loc_legend[30],++page_no);
		fprintf(f1,"----------------------------------------------------------------------------------------------------------\n");
		fprintf(f1,"%10.10s%8.8s%8.8s%8.8s%18.18s%16.16s%5.5s %8.8s%9.9s%14.14s\n",loc_legend[210]," ",loc_legend[220]," ",loc_legend[230]," ",loc_legend[240],loc_legend[350]," ",loc_legend[480]);
		fprintf(f1,"----------------------------------------------------------------------------------------------------------\n");
	}

	line_no = 7;
}

calc_nat_no_adm_visit()
{
	if (strcmp(r_episode_type.arr,"I")==0)
	{
			++l_nat_no_of_adm;
	
	}
	else if (strcmp(r_episode_type.arr,"D")==0)		//31/10/2004
	{
			++l_nat_no_of_adm;
	}
	else if (strcmp(r_episode_type.arr,"O")==0)
	{
			++l_nat_no_of_visit;
	}
	else if (strcmp(r_episode_type.arr,"E")==0)		//31/10/2004
	{
			++l_nat_no_of_visit;
	}

	return;
}


calc_nat_patient_days()
{

	if ((strcmp(r_episode_type.arr,"I")==0) || (strcmp(r_episode_type.arr,"D")==0))
	{
			/* EXEC SQL SELECT CEIL(NVL(DISCHARGE_DATE_TIME,SYSDATE) - ADMISSION_dATE_TIME)  
					   INTO :l_nat_patient_days
					   FROM IP_EPISODE
					  WHERE episode_id = :r_episode_id
					  AND  FACILITY_ID = :nd_operating_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select CEIL((NVL(DISCHARGE_DATE_TIME,SYSDATE)-ADMISSION_dA\
TE_TIME)) into :b0  from IP_EPISODE where (episode_id=:b1 and FACILITY_ID=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )403;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&l_nat_patient_days;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&r_episode_id;
   sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
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



					  if (l_nat_patient_days < 1) 
					  {
						  l_nat_patient_days = 1;
					  }	


					  l_nat_no_patient_days = l_nat_patient_days + l_nat_no_patient_days;

			return;	
			err_exit:
				/* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

				/* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 14;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )430;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


				disp_message(ERR_MESG,"Oracle error at calc_nat_patient_days occured");
				disp_message(ORA_MESG, sqlca.sqlerrm.sqlerrmc);
				proc_exit();
	}
	
	return;

}

calc_nat_revenue()
{

	//sprintf(aMesg,"Revenue Ip IP %16.2f - %16.2f - %16.2f",r_revenue,l_nat_ip_revenue,l_nat_op_revenue);
	//disp_message(ERR_MESG,aMesg);

	if (strcmp(r_episode_type.arr,"I")==0) 
	{
		l_nat_ip_revenue	= l_nat_ip_revenue + r_revenue;	
	}
	else if (strcmp(r_episode_type.arr,"D")==0) 
	{
		l_nat_ip_revenue	= l_nat_ip_revenue + r_revenue;
	}

	else if (strcmp(r_episode_type.arr,"O")==0) 
	{
		l_nat_op_revenue = l_nat_op_revenue + r_revenue;
	}
	
	else if (strcmp(r_episode_type.arr,"E")==0) 
	{
		l_nat_op_revenue = l_nat_op_revenue + r_revenue;
	}

	else if (strcmp(r_episode_type.arr,"R")==0) 
	{
		l_nat_rf_revenue = l_nat_rf_revenue + r_revenue;
	}


	return;
}

calc_area_tot_revenue()
{
	l_total_area_revenue = l_total_area_revenue + r_revenue;
	return;
}

calc_area_no_adm_visit()
{
	if (strcmp(r_episode_type.arr,"I")==0)
	{
			++l_area_no_of_adm;
	
	}
	else if (strcmp(r_episode_type.arr,"D")==0)	//31/10/2004
	{
			++l_area_no_of_adm;
	
	}
	else if (strcmp(r_episode_type.arr,"O")==0) 
	{
			++l_area_no_of_visit;
	}
	else if (strcmp(r_episode_type.arr,"E")==0)		//31/10/2004
	{
			++l_area_no_of_visit;
	}


	return;
}


calc_area_patient_days()
{

	if ((strcmp(r_episode_type.arr,"I")==0) || (strcmp(r_episode_type.arr,"D")==0))
	{
			/* EXEC SQL SELECT CEIL(NVL(DISCHARGE_DATE_TIME,SYSDATE) - ADMISSION_dATE_TIME) 
					   INTO :l_area_patient_days
					   FROM IP_EPISODE
					  WHERE episode_id = :r_episode_id
					  and   FACILITY_ID = :nd_operating_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select CEIL((NVL(DISCHARGE_DATE_TIME,SYSDATE)-ADMISSION_dA\
TE_TIME)) into :b0  from IP_EPISODE where (episode_id=:b1 and FACILITY_ID=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )445;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&l_area_patient_days;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&r_episode_id;
   sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
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



					  if (l_area_patient_days < 1) 
					  {
						  l_area_patient_days = 1;
					  }	
			
					  l_area_no_patient_days = l_area_patient_days + l_area_no_patient_days;

			return;	
			err_exit:
				/* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

				/* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 14;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )472;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


				disp_message(ERR_MESG,"Oracle error at calc_nat_patient_days occured");
				disp_message(ORA_MESG, sqlca.sqlerrm.sqlerrmc);
				proc_exit();

	}
	

	return;

}

calc_area_revenue()
{

	if ((strcmp(r_episode_type.arr,"I")==0) || (strcmp(r_episode_type.arr,"D")==0))
	{

		//sprintf(aMesg,"area revenue + revenue = %16.2f + %16.2f ",l_area_ip_revenue,r_revenue);
		//disp_message(ERR_MESG,aMesg);

		l_area_ip_revenue	= l_area_ip_revenue + r_revenue;
	
		//sprintf(aMesg,"Total %16.2f ",l_area_ip_revenue);
		//disp_message(ERR_MESG,aMesg);


	}
	else if ((strcmp(r_episode_type.arr,"O")==0) || (strcmp(r_episode_type.arr,"E")==0) )
	{
		l_area_op_revenue = l_area_op_revenue + r_revenue;
	}
	
	else if ((strcmp(r_episode_type.arr,"R")==0) )
	{
		l_area_rf_revenue = l_area_rf_revenue + r_revenue;
	}
	
	return;
}

calc_region_no_adm_visit()
{
	if ((strcmp(r_episode_type.arr,"I")==0) || (strcmp(r_episode_type.arr,"D")==0))
	{
			++l_reg_no_of_adm;
			//for grand total
			++l_rep_no_of_adm;
	
	}
	else if ((strcmp(r_episode_type.arr,"O")==0) || (strcmp(r_episode_type.arr,"E")==0))
	{
			++l_reg_no_of_visit;
			//for grand total
			++l_rep_no_of_visit;
	}

	
	return;
}


calc_region_patient_days()
{

	if ((strcmp(r_episode_type.arr,"I")==0) || (strcmp(r_episode_type.arr,"D")==0) )
	{
			/* EXEC SQL SELECT CEIL(NVL(DISCHARGE_DATE_TIME,SYSDATE) - ADMISSION_dATE_TIME)
					   INTO :l_reg_patient_days
					   FROM IP_EPISODE
					  WHERE episode_id = :r_episode_id
					  AND   FACILITY_ID = :nd_operating_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select CEIL((NVL(DISCHARGE_DATE_TIME,SYSDATE)-ADMISSION_dA\
TE_TIME)) into :b0  from IP_EPISODE where (episode_id=:b1 and FACILITY_ID=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )487;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&l_reg_patient_days;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&r_episode_id;
   sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
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



					  if (l_reg_patient_days < 1) 
					  {
						  l_reg_patient_days = 1;
					  }	

					 l_reg_no_patient_days = l_reg_patient_days + l_reg_no_patient_days;
					 l_rep_no_patient_days = l_reg_patient_days + l_rep_no_patient_days;
					 return;	
			err_exit:
				/* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

				/* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 14;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )514;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


				disp_message(ERR_MESG,"Oracle error at calc_nat_patient_days occured");
				disp_message(ORA_MESG, sqlca.sqlerrm.sqlerrmc);
				proc_exit();
	}
	return;

}

calc_region_tot_revenue()
{
	l_total_region_revenue = l_total_region_revenue + r_revenue;
	return;
}

calc_region_revenue()
{
	if ((strcmp(r_episode_type.arr,"I")==0) || (strcmp(r_episode_type.arr,"D")==0) )
	{
		l_reg_ip_revenue	= l_reg_ip_revenue + r_revenue;
		//for report total
		l_rep_ip_revenue	= l_rep_ip_revenue + r_revenue;
	}
	else if ((strcmp(r_episode_type.arr,"O")==0) || (strcmp(r_episode_type.arr,"E")==0))
	{
		l_reg_op_revenue = l_reg_op_revenue + r_revenue;
		//for report total
		l_rep_op_revenue = l_rep_op_revenue + r_revenue;
	}

	else if ((strcmp(r_episode_type.arr,"R")==0) )
	{
		l_reg_rf_revenue = l_reg_rf_revenue + r_revenue;
		//for report total
		l_rep_rf_revenue = l_rep_rf_revenue + r_revenue;
	}

	
	return;
}
   
swap_region_vaiables()
{
	strcpy(l_prev_region_code.arr,r_region_code.arr);
	strcpy(l_prev_region_desc.arr,r_region_desc.arr);
	l_total_region_revenue	= 0;
	l_reg_no_of_adm			= 0;
	l_reg_no_of_visit		= 0;
	l_reg_no_patient_days	= 0;
	l_reg_ip_revenue		= 0;
	l_reg_op_revenue		= 0;
	l_reg_rf_revenue		= 0;

	return;
}

swap_area_vaiables()
{
	strcpy(l_prev_res_area_code.arr,r_res_area_code.arr);
	strcpy(l_prev_area_desc.arr,r_res_area_desc.arr);

	l_total_area_revenue	= 0;
	l_area_no_of_adm		= 0;
	l_area_no_of_visit		= 0;
	l_area_no_patient_days	= 0;
	l_area_ip_revenue		= 0;
	l_area_op_revenue		= 0;
	l_area_rf_revenue		= 0;

	return;
}

swap_nat_variables()
{
	strcpy(l_prev_nationality_code.arr,r_nationality_code.arr);
	l_prev_nationality_code.arr[strlen(l_prev_nationality_code.arr)]='\0';
	get_nationality_desc();

	l_nat_no_of_adm			= 0;
	l_nat_no_of_visit		= 0;
	l_nat_no_patient_days	= 0;
	l_nat_ip_revenue		= 0;
	l_nat_op_revenue		= 0;
	l_nat_rf_revenue        = 0;

	return;
}

print_region_record()
{
	//sprintf(aMesg,"Region Code : %-6s",r_region_code.arr);
	//disp_message(ERR_MESG,aMesg);

	if (strcmp(r_region_code.arr,"Nil")==0)
	{
		fprintf(f1,"\n%6s %-15.15s\n"," ",r_region_desc.arr); 
	}
	else
	{
		//fprintf(f1,"\n%6s %-15.15s\n",r_region_code.arr,r_region_desc.arr); commented by saikiran
		  fprintf(f1,"\n%4s%-5s %-15.15s\n","",r_region_code.arr,r_region_desc.arr);
	}

	line_no = line_no + 2;
	check_page_end();
}

print_area_record()
{
	if (strcmp(nd_report_option.arr,"B")==0)
	{
		if (strcmp(r_res_area_code.arr,"Nil")==0)
		{
			fprintf(f1,"%12s%6s %-15.15s\n"," "," ",r_res_area_desc.arr);
		}
		else
		{
			//fprintf(f1,"%12s%6s %-15.15s\n"," ",r_res_area_code.arr,r_res_area_desc.arr);commented by saikiran
			fprintf(f1,"%16s%-6s %-15.15s\n"," ",r_res_area_code.arr,r_res_area_desc.arr);
		}
	}
	else if ((strcmp(nd_report_option.arr,"I")==0) || (strcmp(nd_report_option.arr,"D")==0))
	{
		//fprintf(f1,"%18s%6s %-15.15s\n"," ",r_res_area_code.arr,r_res_area_desc.arr);commneted by saikiran
		fprintf(f1,"%22s%-6s %-15.15s\n"," ",r_res_area_code.arr,r_res_area_desc.arr);

	}
	else if ((strcmp(nd_report_option.arr,"O")==0) || (strcmp(nd_report_option.arr,"E")==0) || (strcmp(nd_report_option.arr,"R")==0))
	{ 
		//fprintf(f1,"%21s%6s %-15.15s\n"," ",r_res_area_code.arr,r_res_area_desc.arr); commented by saikiran
		fprintf(f1,"%22s%-6s %-15.15s\n"," ",r_res_area_code.arr,r_res_area_desc.arr);
	
	}
	line_no = line_no + 1;
	check_page_end();
}

print_nat_record()
{

	if (strcmp(nd_report_option.arr,"B")==0)
	{
		l_nat_total_revenue = 	l_nat_ip_revenue + l_nat_op_revenue + l_nat_rf_revenue;
		sprintf(l_fmt_nat_total_revenue,"%18.2f",l_nat_total_revenue);
		format_amt(l_fmt_nat_total_revenue);
		
		sprintf(l_fmt_nat_op_revenue,"%16.2f",l_nat_op_revenue);
		format_amt(l_fmt_nat_op_revenue);
		
		sprintf(l_fmt_nat_rf_revenue,"%16.2f",l_nat_rf_revenue);
		format_amt(l_fmt_nat_rf_revenue);

		sprintf(l_fmt_nat_ip_revenue,"%16.2f",l_nat_ip_revenue);
		format_amt(l_fmt_nat_ip_revenue);
		
		if (strcmp(l_prev_nationality_code.arr,"Nil")==0)
		{
			fprintf(f1,"%19s%-4s %-20s %8d %4d %16s %4d %16s %16s %18s\n"," "," ",
								l_prev_nat_desc.arr,l_nat_no_of_adm,l_nat_no_patient_days,
								l_fmt_nat_ip_revenue,l_nat_no_of_visit,l_fmt_nat_op_revenue,l_fmt_nat_rf_revenue, l_fmt_nat_total_revenue);
		}
		else
		{ 
			//fprintf(f1,"%19s%-4s %-20s %8d %4d %16s %4d %16s %16s %18s\n"," ",l_prev_nationality_code.arr,l_prev_nat_desc.arr,l_nat_no_of_adm,l_nat_no_patient_days,l_fmt_nat_ip_revenue,l_nat_no_of_visit,l_fmt_nat_op_revenue,l_fmt_nat_rf_revenue, l_fmt_nat_total_revenue);
				fprintf(f1,"%26s%-4s %-20s%-5d %-5d %14s %4d %22s %11s %17s\n"," ",l_prev_nationality_code.arr,l_prev_nat_desc.arr,l_nat_no_of_adm,l_nat_no_patient_days,l_fmt_nat_ip_revenue,l_nat_no_of_visit,l_fmt_nat_op_revenue,l_fmt_nat_rf_revenue, l_fmt_nat_total_revenue);
		}		

		++line_no;
	}
	else if ((strcmp(nd_report_option.arr,"I")==0) || (strcmp(nd_report_option.arr,"D")==0))
	{

		sprintf(l_fmt_nat_ip_revenue,"%16.2f",l_nat_ip_revenue);
		format_amt(l_fmt_nat_ip_revenue);

		if (strcmp(l_prev_nationality_code.arr,"Nil")==0)
		{
			fprintf(f1,"%31s%-4s %-20.20s     %12d %13d  %18s\n"," "," ",l_prev_nat_desc.arr,l_nat_no_of_adm,l_nat_no_patient_days,l_fmt_nat_ip_revenue);
		}
		else
		{
			fprintf(f1,"%35s%-4s %-20s     %8d %13d  %18s\n"," ",l_prev_nationality_code.arr,l_prev_nat_desc.arr,l_nat_no_of_adm,l_nat_no_patient_days,l_fmt_nat_ip_revenue);
		  //fprintf(f1,"%31s%-4s %-20s     %8d %13d  %18s\n"," ",l_prev_nationality_code.arr,l_prev_nat_desc.arr,l_nat_no_of_adm,l_nat_no_patient_days,l_fmt_nat_ip_revenue);
		}
		++line_no;
	}
	else if ((strcmp(nd_report_option.arr,"O")==0) || (strcmp(nd_report_option.arr,"E")==0) )
	{

		sprintf(l_fmt_nat_op_revenue,"%16.2f",l_nat_op_revenue);
		format_amt(l_fmt_nat_op_revenue);

		if (strcmp(l_prev_nationality_code.arr,"Nil")==0)
		{
			fprintf(f1,"%37s %-4s %-20s  %17d    %18s\n"," "," ",l_prev_nat_desc.arr,l_nat_no_of_visit,l_fmt_nat_op_revenue);
		}
		else
		{
		fprintf(f1,"%40s %-4s %-20s  %14d    %18s\n"," ",l_prev_nationality_code.arr,l_prev_nat_desc.arr,l_nat_no_of_visit,l_fmt_nat_op_revenue);
		//	fprintf(f1,"%37s %-4s %-20s  %17d    %18s\n"," ",l_prev_nationality_code.arr,l_prev_nat_desc.arr,l_nat_no_of_visit,l_fmt_nat_op_revenue);commented by saikiran
			//fprintf(f1,"%37s %-4s %-20s  %13d    %18s\n"," ",l_prev_nationality_code.arr,l_prev_nat_desc.arr,l_nat_no_of_visit,l_fmt_nat_op_revenue);
		}

		++line_no;
	}
	else if ((strcmp(nd_report_option.arr,"R")==0))
	{

		sprintf(l_fmt_nat_rf_revenue,"%16.2f",l_nat_rf_revenue);
		format_amt(l_fmt_nat_rf_revenue);

		if (strcmp(l_prev_nationality_code.arr,"Nil")==0)
		{
			 fprintf(f1,"%37s %-4s %-20s      %22s\n"," "," ",l_prev_nat_desc.arr, l_fmt_nat_rf_revenue);
 		}
		else
		{
			//fprintf(f1,"%37s %-4s %-20s      %22s\n"," ",l_prev_nationality_code.arr,l_prev_nat_desc.arr,l_fmt_nat_rf_revenue);commented by saikrian
			fprintf(f1,"%34s %-4s %-20s      %25s\n"," ",l_prev_nationality_code.arr,l_prev_nat_desc.arr,l_fmt_nat_rf_revenue);
		}

		++line_no;
	}

	check_page_end();
}

print_area_total()
{
	if (strcmp(nd_report_option.arr,"B")==0)
	{

		l_total_area_revenue = 	l_area_ip_revenue + l_area_op_revenue + l_area_rf_revenue;
		sprintf(l_fmt_total_area_revenue,"%18.2f",l_total_area_revenue);
		format_amt(l_fmt_total_area_revenue);
		
		sprintf(l_fmt_area_op_revenue,"%16.2f",l_area_op_revenue);
		format_amt(l_fmt_area_op_revenue);

		sprintf(l_fmt_area_ip_revenue,"%16.2f",l_area_ip_revenue);
		format_amt(l_fmt_area_ip_revenue);
		
		sprintf(l_fmt_area_rf_revenue,"%16.2f",l_area_rf_revenue);
		format_amt(l_fmt_area_rf_revenue);


		fprintf(f1,"%46s------------------------------------------------------------------------------------------\n"," ");

		if (strcmp(l_prev_res_area_code.arr,"Nil")==0)
		{
//			fprintf(f1,"%12.12s%18.18s %-6.6s %4.4s %5.5s %4d %4d %16s %4d %16s %16s %18s\n\n"," ",loc_legend[490]," "," "," ",l_area_no_of_adm,l_area_no_patient_days,l_fmt_area_ip_revenue,l_area_no_of_visit,l_fmt_area_op_revenue,l_fmt_area_rf_revenue, l_fmt_total_area_revenue);COMMENTED BY SAIKIRAN
			fprintf(f1,"%12.12s%18.18s %-6.6s %4.4s %5.5s %4d %7d %16s %4d %23s %11s %17s\n\n"," ",loc_legend[490]," "," "," ",l_area_no_of_adm,l_area_no_patient_days,l_fmt_area_ip_revenue,l_area_no_of_visit,l_fmt_area_op_revenue,l_fmt_area_rf_revenue, l_fmt_total_area_revenue);
        }
		else  if (l_area_no_patient_days ==0) //added by saikiran
		{
				fprintf(f1,"%12s%18.18s %-6s %4s %2s %6d %5d %18s %4d   %20s %11s %17s\n\n"," ",loc_legend[490],l_prev_res_area_code.arr," "," ",l_area_no_of_adm,l_area_no_patient_days,l_fmt_area_ip_revenue,l_area_no_of_visit,l_fmt_area_op_revenue,l_fmt_area_rf_revenue, l_fmt_total_area_revenue);
		            }                               
			else
			{	//fprintf(f1,"%12s%18.18s %-6s %4s %5s %4d %4d %16s %4d %16s %16s %18s\n\n"," ",loc_legend[490],l_prev_res_area_code.arr," "," ",l_area_no_of_adm,l_area_no_patient_days,l_fmt_area_ip_revenue,l_area_no_of_visit,l_fmt_area_op_revenue,l_fmt_area_rf_revenue, l_fmt_total_area_revenue);COMMENTED BY SAIKIRAN
				fprintf(f1,"%12s%18.18s %-6s %4s %5s%4d %8d %15s %4d %22s %11s %17s\n\n"," ",loc_legend[490],l_prev_res_area_code.arr," "," ",l_area_no_of_adm,l_area_no_patient_days,l_fmt_area_ip_revenue,l_area_no_of_visit,l_fmt_area_op_revenue,l_fmt_area_rf_revenue, l_fmt_total_area_revenue);
 				              
			}
	     }
	else if ((strcmp(nd_report_option.arr,"I")==0) || (strcmp(nd_report_option.arr,"D")==0))
	{
		sprintf(l_fmt_area_ip_revenue,"%16.2f",l_area_ip_revenue);
		format_amt(l_fmt_area_ip_revenue);

		fprintf(f1,"%59s--------------------------------------------------\n"," ");

		if (strcmp(l_prev_res_area_code.arr,"Nil")==0)
		{
			fprintf(f1,"%18s%18s %-6s %-15s      %8d %13d  %18s\n\n"," ",loc_legend[490]," ",l_prev_area_desc.arr,l_area_no_of_adm,l_area_no_patient_days,l_fmt_area_ip_revenue);
		}
		else
		{
			fprintf(f1,"%18s%18.18s %-6s %-15s      %8d %13d  %18s\n\n"," ",loc_legend[490],l_prev_res_area_code.arr,l_prev_area_desc.arr,l_area_no_of_adm,l_area_no_patient_days,l_fmt_area_ip_revenue);
		  //fprintf(f1,"%18s%14s %-6s %-15s      %8d %13d  %18s\n\n"," ",loc_legend[490],l_prev_res_area_code.arr,l_prev_area_desc.arr,l_area_no_of_adm,l_area_no_patient_days,l_fmt_area_ip_revenue);
		}
	}
	else if ((strcmp(nd_report_option.arr,"O")==0) || (strcmp(nd_report_option.arr,"E")==0))
	{
		sprintf(l_fmt_area_op_revenue,"%16.2f",l_area_op_revenue);
		format_amt(l_fmt_area_op_revenue);

		fprintf(f1,"%67s---------------------------------------\n"," ");
		
		if (strcmp(l_prev_res_area_code.arr,"Nil")==0)
		{
			fprintf(f1,"%21s%18.18s %-6s %-15s %4s  %13d    %18s\n\n"," ",loc_legend[490]," ",l_prev_area_desc.arr," ",l_area_no_of_visit,l_fmt_area_op_revenue);
		}
		else
		{
			fprintf(f1,"%21s%18.18s %-6s %-15s %4s  %13d    %18s\n\n"," ",loc_legend[490],l_prev_res_area_code.arr,l_prev_area_desc.arr," ",l_area_no_of_visit,l_fmt_area_op_revenue);
		}
	}
	else if ((strcmp(nd_report_option.arr,"R")==0))
	{
		sprintf(l_fmt_area_rf_revenue,"%16.2f",l_area_rf_revenue);
		format_amt(l_fmt_area_rf_revenue);

		fprintf(f1,"%67s---------------------------------------\n"," ");
		
		if (strcmp(l_prev_res_area_code.arr,"Nil")==0)
		{
			fprintf(f1,"%21s%18.18s %-6s %-15s %4s      %18s\n\n"," ",loc_legend[490]," ",l_prev_area_desc.arr," ",l_fmt_area_rf_revenue);
		}
		else
		{
			fprintf(f1,"%21s%18.18s %-6s %-15s %4s      %18s\n\n"," ",loc_legend[490],l_prev_res_area_code.arr,l_prev_area_desc.arr," ",l_fmt_area_rf_revenue);
		}
	}

	line_no = line_no + 3;
	check_page_end();
}

print_region_total()
{
	if (strcmp(nd_report_option.arr,"B")==0)
	{
		l_total_region_revenue = 	l_reg_ip_revenue + l_reg_op_revenue + l_reg_rf_revenue;
		sprintf(l_fmt_total_region_revenue,"%18.2f",l_total_region_revenue);
		format_amt(l_fmt_total_region_revenue);
		
		sprintf(l_fmt_reg_op_revenue,"%16.2f",l_reg_op_revenue);
		format_amt(l_fmt_reg_op_revenue);

		sprintf(l_fmt_reg_ip_revenue,"%16.2f",l_reg_ip_revenue);
		format_amt(l_fmt_reg_ip_revenue);

		sprintf(l_fmt_reg_rf_revenue,"%16.2f",l_reg_rf_revenue);
		format_amt(l_fmt_reg_rf_revenue);

		fprintf(f1,"%46s==========================================================================================\n"," ");	
		if (strcmp(l_prev_region_code.arr,"Nil")==0)
		{
			fprintf(f1,"%-20.20s %-6s %-15s %2s%3s%4d %4d %16s %4d %16s %16s %18s\n\n",loc_legend[500]," ",l_prev_region_desc.arr," "," ",l_reg_no_of_adm,l_reg_no_patient_days,l_fmt_reg_ip_revenue,l_reg_no_of_visit,l_fmt_reg_op_revenue,l_fmt_reg_rf_revenue, l_fmt_total_region_revenue);
		}

		else  if (l_area_no_patient_days ==0) //added by saikiran
		{
				fprintf(f1,"%-20.20s %-6s %-15s %2s%3s%3d %5d %18s %4d %22s %11s %17s\n\n",loc_legend[500],l_prev_region_code.arr,l_prev_region_desc.arr," "," ",l_reg_no_of_adm,l_reg_no_patient_days,l_fmt_reg_ip_revenue,l_reg_no_of_visit,l_fmt_reg_op_revenue,l_fmt_reg_rf_revenue, l_fmt_total_region_revenue);

		            }                               
			else
			{	
	            fprintf(f1,"%-20.20s %-6s %-15s %2s%3s%3d %8d %15s %4d %22s %11s %17s\n\n",loc_legend[500],l_prev_region_code.arr,l_prev_region_desc.arr," "," ",l_reg_no_of_adm,l_reg_no_patient_days,l_fmt_reg_ip_revenue,l_reg_no_of_visit,l_fmt_reg_op_revenue,l_fmt_reg_rf_revenue, l_fmt_total_region_revenue);

			}
	     } 



/*		else
		{
			//fprintf(f1,"%-20.20s %-6s %-15s %2s%3s%4d %4d %16s %4d %16s %16s %18s\n\n",loc_legend[500],l_prev_region_code.arr,l_prev_region_desc.arr," "," ",l_reg_no_of_adm,l_reg_no_patient_days,l_fmt_reg_ip_revenue,l_reg_no_of_visit,l_fmt_reg_op_revenue,l_fmt_reg_rf_revenue, l_fmt_total_region_revenue);COMMENTED BY SAIKIRAN
			fprintf(f1,"%-20.20s %-6s %-15s %2s%3s%4d %7d %16s %4d %20s %12s %18s\n\n",loc_legend[500],l_prev_region_code.arr,l_prev_region_desc.arr," "," ",l_reg_no_of_adm,l_reg_no_patient_days,l_fmt_reg_ip_revenue,l_reg_no_of_visit,l_fmt_reg_op_revenue,l_fmt_reg_rf_revenue, l_fmt_total_region_revenue);
			
	
		}
	}commented by saikiran*/
	else if ((strcmp(nd_report_option.arr,"I")==0) || (strcmp(nd_report_option.arr,"D")==0))
	{
		sprintf(l_fmt_reg_ip_revenue,"%16.2f",l_reg_ip_revenue);
		format_amt(l_fmt_reg_ip_revenue);

		fprintf(f1,"%59s==================================================\n"," ");
		if (strcmp(l_prev_region_code.arr,"Nil")==0)
		{
			fprintf(f1,"%-20.20s %-6s %-15s %17s    %8d %13d  %18s\n\n",loc_legend[500]," ",l_prev_region_desc.arr," ",l_reg_no_of_adm,l_reg_no_patient_days,l_fmt_reg_ip_revenue);
		}
		else
		{
			fprintf(f1,"%-20.20s %-6s %-15s %17s    %8d %13d  %18s\n\n",loc_legend[500],l_prev_region_code.arr,l_prev_region_desc.arr," ",l_reg_no_of_adm,l_reg_no_patient_days,l_fmt_reg_ip_revenue);
		}
	}
	else if ((strcmp(nd_report_option.arr,"O")==0) || (strcmp(nd_report_option.arr,"E")==0))
	{
		sprintf(l_fmt_reg_op_revenue,"%16.2f",l_reg_op_revenue);
		format_amt(l_fmt_reg_op_revenue);

		fprintf(f1,"%67s=======================================\n"," ");

		if (strcmp(l_prev_region_code.arr,"Nil")==0)
		{
			fprintf(f1,"%-20.20s %-6s %-15s %25s%13d    %18s\n",loc_legend[500]," ",l_prev_region_desc.arr," ",l_reg_no_of_visit,l_fmt_reg_op_revenue);
		}
		else
		{
			fprintf(f1,"%-20.20s %-6s %-15s %25s%13d    %18s\n",loc_legend[500],l_prev_region_code.arr,l_prev_region_desc.arr," ",l_reg_no_of_visit,l_fmt_reg_op_revenue);
		}

	}    

	else if ((strcmp(nd_report_option.arr,"R")==0) )
	{
		sprintf(l_fmt_reg_rf_revenue,"%16.2f",l_reg_rf_revenue);
		format_amt(l_fmt_reg_rf_revenue);

		fprintf(f1,"%67s=======================================\n"," ");

		if (strcmp(l_prev_region_code.arr,"Nil")==0)
		{
			fprintf(f1,"%-20.20s %-6s %-15s %25s    %18s\n",loc_legend[500]," ",l_prev_region_desc.arr," ",l_fmt_reg_rf_revenue);
		}
		else
		{
			fprintf(f1,"%-20.20s %-6s %-15s %25s    %18s\n",loc_legend[500],l_prev_region_code.arr,l_prev_region_desc.arr," ",l_fmt_reg_rf_revenue);
		}

	}
	line_no = line_no + 2;
	check_page_end();
}

print_report_total()
{
	if (strcmp(nd_report_option.arr,"B")==0)
	{
		l_total_report_revenue = 	l_rep_ip_revenue + l_rep_op_revenue + l_rep_rf_revenue;

		sprintf(l_fmt_report_revenue,"%18.2f",l_total_report_revenue);
		format_amt(l_fmt_report_revenue);
		
		sprintf(l_fmt_rep_op_revenue,"%16.2f",l_rep_op_revenue);
		format_amt(l_fmt_rep_op_revenue);

		sprintf(l_fmt_rep_ip_revenue,"%16.2f",l_rep_ip_revenue);
		format_amt(l_fmt_rep_ip_revenue);

		sprintf(l_fmt_rep_rf_revenue,"%16.2f",l_rep_rf_revenue);
		format_amt(l_fmt_rep_rf_revenue);
		
		fprintf(f1,"%46s==========================================================================================\n"," ");
 		//fprintf(f1,"%-15.15s      %6s %6s%4s %9s %4d %4d %16s %4d %16s %16s %18s\n\n",loc_legend[510]," "," "," "," ",l_rep_no_of_adm,l_rep_no_patient_days,l_fmt_rep_ip_revenue,l_rep_no_of_visit,l_fmt_rep_op_revenue,l_fmt_rep_rf_revenue, l_fmt_report_revenue); COMMENTED BY SAIKIRAN
		if (l_rep_no_patient_days ==0)
		{
		    fprintf(f1,"%-15.15s      %6s %6s%4s %9s %4d %5d %18s %4d %22s %11s %17s\n\n",loc_legend[510]," "," "," "," ",l_rep_no_of_adm,l_rep_no_patient_days,l_fmt_rep_ip_revenue,l_rep_no_of_visit,l_fmt_rep_op_revenue,l_fmt_rep_rf_revenue, l_fmt_report_revenue); 
			}
		else
		{
		fprintf(f1,"%-15.15s      %6s %6s%4s %9s%4d %7d %16s %4d %22s %11s %17s\n\n",loc_legend[510]," "," "," "," ",l_rep_no_of_adm,l_rep_no_patient_days,l_fmt_rep_ip_revenue,l_rep_no_of_visit,l_fmt_rep_op_revenue,l_fmt_rep_rf_revenue, l_fmt_report_revenue); 
		}
		}
	else if ((strcmp(nd_report_option.arr,"I")==0) || (strcmp(nd_report_option.arr,"D")==0))
	{

		sprintf(l_fmt_rep_ip_revenue,"%16.2f",l_rep_ip_revenue);
		format_amt(l_fmt_rep_ip_revenue);

		fprintf(f1,"%59s==================================================\n"," ");
		fprintf(f1,"%-15.15s      %6s%34s    %8d %13d  %18s\n\n",loc_legend[510]," "," ",l_rep_no_of_adm,l_rep_no_patient_days,l_fmt_rep_ip_revenue);
	}
	else if ((strcmp(nd_report_option.arr,"O")==0) || (strcmp(nd_report_option.arr,"E")==0))
	{
		sprintf(l_fmt_rep_op_revenue,"%16.2f",l_rep_op_revenue);
		format_amt(l_fmt_rep_op_revenue);

		fprintf(f1,"%67s=======================================\n"," ");
		fprintf(f1,"%-15.15s      %6s%42s%13d    %18s\n",loc_legend[510]," "," ",l_rep_no_of_visit,l_fmt_rep_op_revenue);
	}
	else if ((strcmp(nd_report_option.arr,"R")==0))
	{
		sprintf(l_fmt_rep_rf_revenue,"%16.2f",l_rep_rf_revenue);
		format_amt(l_fmt_rep_rf_revenue);

		fprintf(f1,"%67s=======================================\n"," ");
		fprintf(f1,"%-15.15s      %6s%42s    %18s\n",loc_legend[510]," "," ",l_fmt_rep_rf_revenue);
	}
	line_no = line_no + 3;
	check_page_end();
}

print_report_end()
{
  line_no = line_no + 3;
  //check_page_end;
  fprintf(f1,"\n\n\n\t\t\t\t\t%s",loc_legend[530]);
  return;
}

delete_prog_param()
{
   /* EXEC SQL DELETE SY_PROG_PARAM
			 WHERE PGM_ID		= 'BLRREVST'
	           AND SESSION_ID	= :nd_session_id
		       AND PGM_DATE		= :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='BLRREVST' and \
SESSION_ID=:b0) and PGM_DATE=:b1)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )529;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
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


   return;
}

get_nationality_desc()
{
	
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


    /* EXEC SQL SELECT COUNT(COUNTRY_CODE)
			   INTO :l_nationality_count
			   FROM mp_country_his_vw 
              WHERE country_code = :r_nationality_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 14;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select count(COUNTRY_CODE) into :b0  from mp_country_his_\
vw where country_code=:b1";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )552;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&l_nationality_count;
    sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&r_nationality_code;
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
    if (sqlca.sqlcode < 0) goto err_exit;
}



	if (l_nationality_count==0)
	{
		strcpy(l_prev_nat_desc.arr ,"Not Specified");	
		return;
	}
	else 
	{
		/* EXEC SQL SELECT NVL(NATIONALITY,'Not Specified')
				   INTO :l_prev_nat_desc
				   FROM mp_country_his_vw
				  WHERE country_code = :r_nationality_code; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select NVL(NATIONALITY,'Not Specified') into :b0  from mp_c\
ountry_his_vw where country_code=:b1";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )575;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&l_prev_nat_desc;
  sqlstm.sqhstl[0] = (unsigned int  )23;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&r_nationality_code;
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
  if (sqlca.sqlcode < 0) goto err_exit;
}



		l_prev_nat_desc.arr [l_prev_nat_desc.len]  = '\0';
		return;
	}

  err_exit:

	/* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

	/* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )598;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	disp_message(ERR_MESG,"Error occured at get_nationlity_desc()....");
	sprintf(aMesg,sqlca.sqlerrm.sqlerrmc);
	disp_message(ERR_MESG,aMesg);
	proc_exit();
}

check_page_end()
{
	if ((line_no + 7) >= MAX_LINES)
	{
	    prepare_new_page();
	}	
	return;
}

fetch_legend_value()
{

	for(i=1;i<=900;i++)
	{
		l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLRREVST.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLRREVST.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )613;
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
			blcommon.get_local_lang_desc(:nd_facility_id,
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
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility_id , 'S\
M' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_valu\
e , :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )636;
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

get_local_date()
{
	
	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;
	
	BEGIN
//		get_locale_date.convert_to_locale_date(to_date(:nd_temp_date,'DD/MM/YYYY HH24:MI'),:p_language_id,t_date);

//		:nd_loc_date := to_char(t_date,'DD/MM/YYYY');

	   :nd_loc_date :=  	sm_convert_date_2t(to_date(:nd_temp_date,'DD/MM/YYYY HH24:MI:SS'),:p_language_id);  

	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN :nd_loc_date := sm_convert_date_\
2t ( to_date ( :nd_temp_date , 'DD/MM/YYYY HH24:MI:SS' ) , :p_language_id ) ; \
END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )667;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_loc_date;
 sqlstm.sqhstl[0] = (unsigned int  )19;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_temp_date;
 sqlstm.sqhstl[1] = (unsigned int  )19;
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

#undef DEBUG
#undef NODATAFOUND
#undef MAX_LINES
#undef VER
