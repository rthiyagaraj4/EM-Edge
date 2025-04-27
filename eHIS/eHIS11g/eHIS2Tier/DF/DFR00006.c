
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/DF/DFR00006.pc"
};


static unsigned int sqlctx = 1288451659;


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
            void  *sqhstv[17];
   unsigned int   sqhstl[17];
            int   sqhsts[17];
            void  *sqindv[17];
            int   sqinds[17];
   unsigned int   sqharm[17];
   unsigned int   *sqharc[17];
   unsigned short  sqadto[17];
   unsigned short  sqtdso[17];
} sqlstm = {12,17};

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

 static const char *sq0002 = 
" between NVL(:b7,'!!!!!!!!!!') and NVL(:b8,'~~~~~~~~~~')) and a.patient_id b\
etween NVL(:b9,'!!!!!!!!!!!!!!!!!!!!') and NVL(:b10,'~~~~~~~~~~~~~~~~~~~~')) a\
nd ((a.episode_id between NVL(:b11,0) and NVL(:b12,999999999) and :b13<>'R') o\
r :b13='R')) and a.episode_type=decode(:b13,'A',a.episode_type,:b13)) and b.fa\
cility_id=a.operating_facility_id) and a.physician_id=b.physician_id) and a.bl\
ng_serv_code=c.blng_serv_code) group by a.physician_id,b.short_name,a.patient_\
id,((a.episode_type||'/')||DECODE(a.episode_type,'I',to_char(a.episode_id),'D'\
,to_char(a.episode_id),((a.episode_id||'/')||to_char(a.visit_id)))),a.bill_doc\
_type_code,a.bill_doc_num,a.blng_serv_code,c.short_desc,a.serv_item_code,to_ch\
ar(a.service_date,'dd/mm/yyyy hh24:mi'),a.trx_doc_ref,a.trx_doc_ref_line_num o\
rder by 1,3,4,5,6            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,117,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,1831,0,9,500,0,0,17,17,0,1,0,1,9,0,0,1,3,0,0,1,3,0,0,1,3,0,0,1,3,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,
119,0,0,2,0,0,13,534,0,0,14,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,4,0,0,
190,0,0,2,0,0,15,570,0,0,0,0,0,1,0,
205,0,0,3,267,0,4,699,0,0,17,3,0,1,0,2,3,0,0,2,3,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,
288,0,0,4,84,0,2,741,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
315,0,0,5,96,0,4,759,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
338,0,0,6,165,0,6,767,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
369,0,0,7,120,0,4,893,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
};


          
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
#define MAX_LINES 42
#define REP_WIDTH 211
#define VER  "VER : 4.10\n"
#define ESC  0x1B

/* EXEC SQL BEGIN DECLARE SECTION; */ 


	/* VARCHAR     l_translated_value	[201],	
		    l_pk_value	[100],

		    nd_curr_pgm_id [15],
		    nd_session_id [16],
		    nd_pgm_date   [25],
		    nd_pwd 	[91],
		    nd_facility_id[3]; */ 
struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[15]; } nd_curr_pgm_id;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[91]; } nd_pwd;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;


	/* VARCHAR	    nd_from_doctor_id[16],
		    nd_to_doctor_id[16],
		    nd_from_blng_serv_code[11],
		    nd_to_blng_serv_code[11],
		    nd_from_patient_id[21],
		    nd_to_patient_id[21],
		    nd_from_episode_id[20],
		    nd_to_episode_id[21],
		    nd_episode_type[2],
		    nd_repeat_grp_col[2],
		    d_acc_entity_name[100],
		    d_user[31],
		    d_curr_date[21],		    
		    d_physician_id[16], 
		    d_prv_physician_id[16], 
		    d_physician_name[16],
		    d_prv_physician_name[16],
		    d_patient_id[21],
		    d_prv_patient_id[21],
		    d_episode_id[21],
		    d_prv_episode_id[21],
		    d_bill_doc_type_code[10],
		    d_bill_doc_num[10],
		    d_blng_serv_code[11],
		    d_service_desc[16],
		    d_serv_item_code[21],
		    d_serv_date[30],
		    d_serv_qty[10],
			p_language_id[3]; */ 
struct { unsigned short len; unsigned char arr[16]; } nd_from_doctor_id;

struct { unsigned short len; unsigned char arr[16]; } nd_to_doctor_id;

struct { unsigned short len; unsigned char arr[11]; } nd_from_blng_serv_code;

struct { unsigned short len; unsigned char arr[11]; } nd_to_blng_serv_code;

struct { unsigned short len; unsigned char arr[21]; } nd_from_patient_id;

struct { unsigned short len; unsigned char arr[21]; } nd_to_patient_id;

struct { unsigned short len; unsigned char arr[20]; } nd_from_episode_id;

struct { unsigned short len; unsigned char arr[21]; } nd_to_episode_id;

struct { unsigned short len; unsigned char arr[2]; } nd_episode_type;

struct { unsigned short len; unsigned char arr[2]; } nd_repeat_grp_col;

struct { unsigned short len; unsigned char arr[100]; } d_acc_entity_name;

struct { unsigned short len; unsigned char arr[31]; } d_user;

struct { unsigned short len; unsigned char arr[21]; } d_curr_date;

struct { unsigned short len; unsigned char arr[16]; } d_physician_id;

struct { unsigned short len; unsigned char arr[16]; } d_prv_physician_id;

struct { unsigned short len; unsigned char arr[16]; } d_physician_name;

struct { unsigned short len; unsigned char arr[16]; } d_prv_physician_name;

struct { unsigned short len; unsigned char arr[21]; } d_patient_id;

struct { unsigned short len; unsigned char arr[21]; } d_prv_patient_id;

struct { unsigned short len; unsigned char arr[21]; } d_episode_id;

struct { unsigned short len; unsigned char arr[21]; } d_prv_episode_id;

struct { unsigned short len; unsigned char arr[10]; } d_bill_doc_type_code;

struct { unsigned short len; unsigned char arr[10]; } d_bill_doc_num;

struct { unsigned short len; unsigned char arr[11]; } d_blng_serv_code;

struct { unsigned short len; unsigned char arr[16]; } d_service_desc;

struct { unsigned short len; unsigned char arr[21]; } d_serv_item_code;

struct { unsigned short len; unsigned char arr[30]; } d_serv_date;

struct { unsigned short len; unsigned char arr[10]; } d_serv_qty;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;


	double	    d_hosp_revenue_amt,
		    d_doctor_share,
		    d_settled_amount,

		    d_st_hosp_revenue_amt,
		    d_st_doctor_share,
		    d_st_settled_amount,
		    
		    d_gt_hosp_revenue_amt,
		    d_gt_doctor_share,
		    d_gt_settled_amount;


	char loc_legend[999][201],
	     loc_legend170_1[201],
	     loc_legend170_2[201],
	     loc_legend180_1[201],
	     loc_legend180_2[201],	
	     loc_legend210_1[201],
	     loc_legend210_2[201];
	
	char l_mesg[200];
	int i,page_no=0,lctr=0, l_line_cnt_for_dtl_rec = 0;
	char filename[500];

	int nd_from_month, nd_to_month, nd_from_year, nd_to_year;

	
	int len = 0, r_ctr = 0;

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


    strcpy(g_pgm_id,"DFR00006");
    strcpy(nd_pwd.arr,argv[1]);
    nd_pwd.len = strlen(nd_pwd.arr);
	 

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

    	strcpy(nd_curr_pgm_id.arr,g_pgm_id); 
    	nd_curr_pgm_id.len = strlen(nd_curr_pgm_id.arr); 

    	strcpy(nd_session_id.arr,argv[2]);
    	nd_session_id.len = strlen(nd_session_id.arr);
    	strcpy(g_session_id,nd_session_id.arr);

    	strcpy(nd_pgm_date.arr,argv[3]);
    	nd_pgm_date.len = strlen(nd_pgm_date.arr);
    	strcpy(g_pgm_date,nd_pgm_date.arr);

    	strcpy(nd_facility_id.arr,argv[4]);
    	nd_facility_id.len = strlen(nd_facility_id.arr);
    	strcpy(g_facility_id,nd_facility_id.arr);	
	
        open_files();

	get_sy_prog_param();

        fetch_legend_value();    

        declare_cur();

        get_header_dtls();

	fprintf(fp,"%c&l1O",ESC); 
	fprintf(fp,"%c(s20H",ESC); 

	print_first_page();

	process_dtl();

	end_of_rep();

	fprintf(fp,"%cE",ESC); /* To Reset the Printer */ 

	fclose(fp);
    
 }

 end_of_rep()  
{
	fprintf(fp,"\n%90s***  END OF REPORT ***\n\f"," ");
	fflush(fp);
}

 declare_cur()
 {
 /* EXEC SQL DECLARE DR_PAY_CUR CURSOR FOR
       SELECT a.physician_id physician_id, 
       b.short_name physician_name,
       a.patient_id patient_id,
       a.episode_type||'/'||DECODE(a.episode_type,'I',to_char(a.episode_id),
						  'D',to_char(a.episode_id),
						  a.episode_id||'/'||to_char(a.visit_id)) episode_id,
       a.bill_doc_type_code bill_doc_type_code,
       a.bill_doc_num bill_doc_num,
       a.blng_serv_code blng_serv_code,
       c.short_desc service_desc,
       a.serv_item_code serv_item_code,
       to_char(a.service_date,'dd/mm/yyyy hh24:mi') service_date,
       sum(a.serv_qty) serv_qty,
       nvl(sum(nvl(a.net_revenue_amt,0)),0) hosp_revenue_amt,
       nvl(sum(nvl(a.dr_revenue_amt,0)),0) doctor_share,
       nvl(sum(nvl(a.settled_amt,0)),0) settled_amount
FROM df_rev_folio_slmt_vw a,
     sy_physician_mast b,
     bl_blng_serv c
WHERE a.operating_facility_id = :nd_facility_id
//AND a.processing_month BETWEEN :nd_from_month AND :nd_to_month
AND a.processing_year||TO_CHAR(a.processing_month,'FM00') 
	BETWEEN :nd_from_year||TO_CHAR(:nd_from_month,'FM00') 
	AND :nd_to_year||TO_CHAR(:nd_to_month,'FM00')
AND nvl(a.df_trx_status,'X') != 'C'
AND a.physician_id BETWEEN NVL(:nd_from_doctor_id,'!!!!!!!!!!!!!!!') 
		   AND NVL(:nd_to_doctor_id,'~~~~~~~~~~~~~~~') 		  
AND a.blng_serv_code BETWEEN NVL(:nd_from_blng_serv_code,'!!!!!!!!!!') 
		     AND NVL(:nd_to_blng_serv_code,'~~~~~~~~~~') 
AND a.patient_id BETWEEN NVL(:nd_from_patient_id,'!!!!!!!!!!!!!!!!!!!!') 
		 AND NVL(:nd_to_patient_id,'~~~~~~~~~~~~~~~~~~~~') 
AND ((a.episode_id BETWEEN NVL(:nd_from_episode_id,0)
		 AND NVL(:nd_to_episode_id,999999999)
     AND :nd_episode_type != 'R')
     OR 
     (:nd_episode_type = 'R'))
AND a.episode_type = decode(:nd_episode_type,'A',a.episode_type,:nd_episode_type)
AND b.facility_id = a.operating_facility_id
AND a.physician_id = b.physician_id
AND a.blng_serv_code = c.blng_serv_code
GROUP BY a.physician_id, 
       b.short_name,
       a.patient_id,
       a.episode_type||'/'||DECODE(a.episode_type,'I',to_char(a.episode_id),'D',to_char(a.episode_id),
				 a.episode_id||'/'||to_char(a.visit_id)),
       a.bill_doc_type_code,
       a.bill_doc_num,
       a.blng_serv_code,
       c.short_desc,
       a.serv_item_code,
       to_char(a.service_date,'dd/mm/yyyy hh24:mi'),
       a.trx_doc_ref,
       a.trx_doc_ref_line_num       
ORDER BY 1,3,4,5,6; */ 

}

 process_dtl()
 {
	open_dr_pay_cur();	

	while(fetch_dr_pay_cur())
	{	
		l_line_cnt_for_dtl_rec = l_line_cnt_for_dtl_rec  + 1;

		if (d_prv_physician_id.arr[0] == '\0' &&
		    d_prv_patient_id.arr[0] == '\0' &&
		    d_prv_episode_id.arr[0] == '\0')		  
		 {
			fprintf(fp, "%-15.15s %-15.15s %-20.20s %-15.15s %-9.9s %-10.10s %-10.10s %-15.15s %-20.20s %-16.16s %7.7s ",
					d_physician_id.arr,d_physician_name.arr,
					d_patient_id.arr,d_episode_id.arr,
					d_bill_doc_type_code.arr,d_bill_doc_num.arr,
					d_blng_serv_code.arr,d_service_desc.arr,
					d_serv_item_code.arr,d_serv_date.arr,
					d_serv_qty.arr);
					print_formated(d_hosp_revenue_amt);
					fprintf(fp," ");
					print_formated(d_doctor_share);
					fprintf(fp," ");
					print_formated(d_settled_amount);
		 }
		 else if (strcmp(d_physician_id.arr,d_prv_physician_id.arr) == 0 &&
			  strcmp(d_patient_id.arr,d_prv_patient_id.arr) == 0 &&
			  strcmp(d_episode_id.arr,d_prv_episode_id.arr) == 0)
		 {
			if (l_line_cnt_for_dtl_rec == 1 || nd_repeat_grp_col.arr[0] == 'Y')
			{

				fprintf(fp, "%-15.15s %-15.15s %-20.20s %-15.15s %-9.9s %-10.10s %-10.10s %-15.15s %-20.20s %-16.16s %7.7s ",
					d_physician_id.arr,d_physician_name.arr,
					d_patient_id.arr,d_episode_id.arr,
					d_bill_doc_type_code.arr,d_bill_doc_num.arr,
					d_blng_serv_code.arr,d_service_desc.arr,
					d_serv_item_code.arr,d_serv_date.arr,d_serv_qty.arr);
					print_formated(d_hosp_revenue_amt);
					fprintf(fp," ");
					print_formated(d_doctor_share);
					fprintf(fp," ");
					print_formated(d_settled_amount);
			}
			else
			{

				fprintf(fp, "%-15.15s %-15.15s %-20.20s %-15.15s %-9.9s %-10.10s %-10.10s %-15.15s %-20.20s %-16.16s %7.7s ",
					"","","","",
					d_bill_doc_type_code.arr,d_bill_doc_num.arr,
					d_blng_serv_code.arr,d_service_desc.arr,
					d_serv_item_code.arr,d_serv_date.arr,d_serv_qty.arr);
					print_formated(d_hosp_revenue_amt);
					fprintf(fp," ");
					print_formated(d_doctor_share);
					fprintf(fp," ");
					print_formated(d_settled_amount);
			}
		}
		else if (strcmp(d_physician_id.arr,d_prv_physician_id.arr) == 0 &&
			  strcmp(d_patient_id.arr,d_prv_patient_id.arr) == 0 &&
			  strcmp(d_episode_id.arr,d_prv_episode_id.arr) != 0)
		 {

			if (l_line_cnt_for_dtl_rec == 1 || nd_repeat_grp_col.arr[0] == 'Y')
			{

				fprintf(fp, "%-15.15s %-15.15s %-20.20s %-15.15s %-9.9s %-10.10s %-10.10s %-15.15s %-20.20s %-16.16s %7.7s ",
					d_physician_id.arr,d_physician_name.arr,
					d_patient_id.arr,d_episode_id.arr,
					d_bill_doc_type_code.arr,d_bill_doc_num.arr,
					d_blng_serv_code.arr,d_service_desc.arr,
					d_serv_item_code.arr,d_serv_date.arr,d_serv_qty.arr);
					print_formated(d_hosp_revenue_amt);
					fprintf(fp," ");
					print_formated(d_doctor_share);
					fprintf(fp," ");
					print_formated(d_settled_amount);
			}
			else
			{
				fprintf(fp, "%-15.15s %-15.15s %-20.20s %-15.15s %-9.9s %-10.10s %-10.10s %-15.15s %-20.20s %-16.16s %7.7s ",
					"","","",d_episode_id.arr,
					d_bill_doc_type_code.arr,d_bill_doc_num.arr,
					d_blng_serv_code.arr,d_service_desc.arr,
					d_serv_item_code.arr,d_serv_date.arr,d_serv_qty.arr);
					print_formated(d_hosp_revenue_amt);
					fprintf(fp," ");
					print_formated(d_doctor_share);
					fprintf(fp," ");
					print_formated(d_settled_amount);
			}
		}

		else if (strcmp(d_physician_id.arr,d_prv_physician_id.arr) == 0 &&
			  strcmp(d_patient_id.arr,d_prv_patient_id.arr) != 0 &&
			  strcmp(d_episode_id.arr,d_prv_episode_id.arr) != 0)
		 {

			if (l_line_cnt_for_dtl_rec == 1 || nd_repeat_grp_col.arr[0] == 'Y')
			{

				fprintf(fp, "%-15.15s %-15.15s %-20.20s %-15.15s %-9.9s %-10.10s %-10.10s %-15.15s %-20.20s %-16.16s %7.7s ",
					d_physician_id.arr,d_physician_name.arr,
					d_patient_id.arr,d_episode_id.arr,
					d_bill_doc_type_code.arr,d_bill_doc_num.arr,
					d_blng_serv_code.arr,d_service_desc.arr,
					d_serv_item_code.arr,d_serv_date.arr,d_serv_qty.arr);
					print_formated(d_hosp_revenue_amt);
					fprintf(fp," ");
					print_formated(d_doctor_share);
					fprintf(fp," ");
					print_formated(d_settled_amount);
			}
			else
			{
				fprintf(fp, "%-15.15s %-15.15s %-20.20s %-15.15s %-9.9s %-10.10s %-10.10s %-15.15s %-20.20s %-16.16s %7.7s ",
					"","",d_patient_id.arr,d_episode_id.arr,
					d_bill_doc_type_code.arr,d_bill_doc_num.arr,
					d_blng_serv_code.arr,d_service_desc.arr,
					d_serv_item_code.arr,d_serv_date.arr,d_serv_qty.arr);
					print_formated(d_hosp_revenue_amt);
					fprintf(fp," ");
					print_formated(d_doctor_share);
					fprintf(fp," ");
					print_formated(d_settled_amount);
			}
		}

		else
		{
			fprintf(fp, "%-15.15s %-15.15s %-20.20s %-15.15s %-20.20s %-16.16s %-55.55s ",
			"","","","","","","");
			print_line('-',47);     			
			
			sprintf(l_mesg,"%-s(%-s) ",d_prv_physician_id.arr,d_prv_physician_name.arr);
			
			fprintf(fp, "%-15.15s %-15.15s %-20.20s %-15.15s %-20.20s %-35.35s ",
			"","","","","",l_mesg);

			fprintf(fp,"%-20.20s %-16.16s",loc_legend[220],"");
			
			print_formated(d_st_hosp_revenue_amt);
			fprintf(fp," ");
			print_formated(d_st_doctor_share);
			fprintf(fp," ");
			print_formated(d_st_settled_amount);

			d_st_hosp_revenue_amt = 0;
			d_st_doctor_share     = 0;
			d_st_settled_amount   = 0;
			
			next_line(1);		

			fprintf(fp, "%-15.15s %-15.15s %-20.20s %-15.15s %-20.20s %-16.16s %-55.55s ",
			"","","","","","","");
			print_line('-',47);     			

			fprintf(fp, "%-15.15s %-15.15s %-20.20s %-15.15s %-9.9s %-10.10s %-10.10s %-15.15s %-20.20s %-16.16s %7.7s ",
					d_physician_id.arr,d_physician_name.arr,
					d_patient_id.arr,d_episode_id.arr,
					d_bill_doc_type_code.arr,d_bill_doc_num.arr,
					d_blng_serv_code.arr,d_service_desc.arr,
					d_serv_item_code.arr,d_serv_date.arr,d_serv_qty.arr);
					print_formated(d_hosp_revenue_amt);
					fprintf(fp," ");
					print_formated(d_doctor_share);
					fprintf(fp," ");
					print_formated(d_settled_amount);
		
		}
		
		next_line(1);		

		d_st_hosp_revenue_amt = d_st_hosp_revenue_amt + d_hosp_revenue_amt;
		d_st_doctor_share     = d_st_doctor_share + d_doctor_share;
		d_st_settled_amount   = d_st_settled_amount + d_settled_amount;

		d_gt_hosp_revenue_amt = d_gt_hosp_revenue_amt + d_hosp_revenue_amt;
		d_gt_doctor_share     = d_gt_doctor_share + d_doctor_share;
		d_gt_settled_amount   = d_gt_settled_amount + d_settled_amount;

		strcpy(d_prv_physician_id.arr,d_physician_id.arr);
		d_prv_physician_id.len = strlen(d_prv_physician_id.arr);

		strcpy(d_prv_patient_id.arr,d_patient_id.arr);
		d_prv_patient_id.len = strlen(d_prv_patient_id.arr);

		strcpy(d_prv_episode_id.arr,d_episode_id.arr);
		d_prv_episode_id.len = strlen(d_prv_episode_id.arr);

		strcpy(d_prv_physician_name.arr,d_physician_name.arr);
		d_prv_physician_name.len = strlen(d_prv_physician_name.arr);		
		
		
	}

		fprintf(fp, "%-15.15s %-15.15s %-20.20s %-15.15s %-20.20s %-16.16s %-55.55s ",
			"","","","","","","");
			print_line('-',47);     
			
			if (d_prv_physician_id.arr[0] != '\0')
			{
				sprintf(l_mesg,"%-s(%-s) ",d_prv_physician_id.arr,d_prv_physician_name.arr);
			}
			
			fprintf(fp, "%-15.15s %-15.15s %-20.20s %-15.15s %-20.20s %-35.35s ",
			"","","","","",l_mesg);

			fprintf(fp,"%-20.20s %-16.16s",loc_legend[220],"");
			
			print_formated(d_st_hosp_revenue_amt);
			fprintf(fp," ");
			print_formated(d_st_doctor_share);
			fprintf(fp," ");
			print_formated(d_st_settled_amount);			
			
			next_line(1);		

			fprintf(fp, "%-15.15s %-15.15s %-20.20s %-15.15s %-20.20s %-16.16s %-50.50s ",
			"","","","","","","");
			print_line('-',52);    
			
			fprintf(fp, "%-15.15s %-15.15s %-20.20s %-15.15s %-20.20s %-55.55s %-16.16s ",
			"","","","","",loc_legend[240],"");

			print_formated(d_gt_hosp_revenue_amt);
			fprintf(fp," ");
			print_formated(d_gt_doctor_share);
			fprintf(fp," ");
			print_formated(d_gt_settled_amount);

			next_line(1);		

			fprintf(fp, "%-15.15s %-15.15s %-20.20s %-15.15s %-20.20s %-16.16s %-50.50s ",
			"","","","","","","");
			print_line('-',52);    
	
 }


print_formated(loc_amount)
double loc_amount;
{
    char s_amt[30], str_amt[30];	

    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);        
        format_amt(s_amt);
	strcat(s_amt,"-");
        sprintf(str_amt,"%15s",s_amt);
	l_ltrim(s_amt);
        fprintf(fp,"%15s",str_amt);
    }
    else 
	{
        put_val(s_amt,loc_amount);         
        format_amt(s_amt);
        sprintf(str_amt,"%15s",s_amt);
	l_ltrim(s_amt);
        fprintf(fp,"%15s",str_amt);
    }

}

open_dr_pay_cur() 
{
	/* EXEC SQL OPEN DR_PAY_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "select a.physician_id physician_id ,b.short_name physician_name ,a.patie\
nt_id patient_id ,((a.episode_type||'/')||DECODE(a.episode_type,'I',to_char(\
a.episode_id),'D',to_char(a.episode_id),((a.episode_id||'/')||to_char(a.visi\
t_id)))) episode_id ,a.bill_doc_type_code bill_doc_type_code ,a.bill_doc_num\
 bill_doc_num ,a.blng_serv_code blng_serv_code ,c.short_desc service_desc ,a\
.serv_item_code serv_item_code ,to_char(a.service_date,'dd/mm/yyyy hh24:mi')\
 service_date ,sum(a.serv_qty) serv_qty ,nvl(sum(nvl(a.net_revenue_amt,0)),0\
) hosp_revenue_amt ,nvl(sum(nvl(a.dr_revenue_amt,0)),0) doctor_share ,nvl(su\
m(nvl(a.settled_amt,0)),0) settled_amount  from df_rev_folio_slmt_vw a ,sy_p\
hysician_mast b ,bl_blng_serv c where ((((((((((a.operating_facility_id=:b0 \
and (a.processing_year||TO_CHAR(a.processing_month,'FM00')) between (:b1||TO\
_CHAR(:b2,'FM00')) and (:b3||TO_CHAR(:b4,'FM00'))) and nvl(a.df_trx_status,'\
X')<>'C') and a.physician_id between NVL(:b5,'!!!!!!!!!!!!!!!') and NVL(:b6,\
'~~~~~~~~~~~~~~~')) and a.blng_serv_code");
 sqlstm.stmt = sq0002;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )36;
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
 sqlstm.sqhstv[1] = (         void  *)&nd_from_year;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_from_month;
 sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_to_year;
 sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_to_month;
 sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_from_doctor_id;
 sqlstm.sqhstl[5] = (unsigned int  )18;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&nd_to_doctor_id;
 sqlstm.sqhstl[6] = (unsigned int  )18;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&nd_from_blng_serv_code;
 sqlstm.sqhstl[7] = (unsigned int  )13;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&nd_to_blng_serv_code;
 sqlstm.sqhstl[8] = (unsigned int  )13;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&nd_from_patient_id;
 sqlstm.sqhstl[9] = (unsigned int  )23;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&nd_to_patient_id;
 sqlstm.sqhstl[10] = (unsigned int  )23;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&nd_from_episode_id;
 sqlstm.sqhstl[11] = (unsigned int  )22;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&nd_to_episode_id;
 sqlstm.sqhstl[12] = (unsigned int  )23;
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&nd_episode_type;
 sqlstm.sqhstl[13] = (unsigned int  )4;
 sqlstm.sqhsts[13] = (         int  )0;
 sqlstm.sqindv[13] = (         void  *)0;
 sqlstm.sqinds[13] = (         int  )0;
 sqlstm.sqharm[13] = (unsigned int  )0;
 sqlstm.sqadto[13] = (unsigned short )0;
 sqlstm.sqtdso[13] = (unsigned short )0;
 sqlstm.sqhstv[14] = (         void  *)&nd_episode_type;
 sqlstm.sqhstl[14] = (unsigned int  )4;
 sqlstm.sqhsts[14] = (         int  )0;
 sqlstm.sqindv[14] = (         void  *)0;
 sqlstm.sqinds[14] = (         int  )0;
 sqlstm.sqharm[14] = (unsigned int  )0;
 sqlstm.sqadto[14] = (unsigned short )0;
 sqlstm.sqtdso[14] = (unsigned short )0;
 sqlstm.sqhstv[15] = (         void  *)&nd_episode_type;
 sqlstm.sqhstl[15] = (unsigned int  )4;
 sqlstm.sqhsts[15] = (         int  )0;
 sqlstm.sqindv[15] = (         void  *)0;
 sqlstm.sqinds[15] = (         int  )0;
 sqlstm.sqharm[15] = (unsigned int  )0;
 sqlstm.sqadto[15] = (unsigned short )0;
 sqlstm.sqtdso[15] = (unsigned short )0;
 sqlstm.sqhstv[16] = (         void  *)&nd_episode_type;
 sqlstm.sqhstl[16] = (unsigned int  )4;
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


	if(OERROR)	   
		err_mesg("OPEN failed on cursor DR_PAY_CUR",0,"");

}



fetch_dr_pay_cur()
{
	d_physician_id.arr[0] = '\0';
	d_physician_name.arr[0] = '\0';
	d_patient_id.arr[0] = '\0';
	d_episode_id.arr[0] = '\0';
	d_bill_doc_type_code.arr[0] = '\0';
	d_bill_doc_num.arr[0] = '\0';
	d_blng_serv_code.arr[0] = '\0';
	d_service_desc.arr[0] = '\0';
	d_serv_item_code.arr[0] = '\0';
	d_serv_date.arr[0] = '\0';
	d_serv_qty.arr[0] = '\0';

	d_physician_id.len = 0;
	d_physician_name.len = 0;
	d_patient_id.len = 0;
	d_episode_id.len = 0;
	d_bill_doc_type_code.len = 0;
	d_bill_doc_num.len = 0;
	d_blng_serv_code.len = 0;
	d_service_desc.len = 0;
	d_serv_item_code.len = 0;
	d_serv_date.len = 0;
	d_serv_qty.len = 0;

	/* EXEC SQL FETCH DR_PAY_CUR 
             INTO :d_physician_id, 
		  :d_physician_name,
		  :d_patient_id,
		  :d_episode_id,
		  :d_bill_doc_type_code,
		  :d_bill_doc_num,
		  :d_blng_serv_code,
		  :d_service_desc,
		  :d_serv_item_code,
		  :d_serv_date,
		  :d_serv_qty,
		  :d_hosp_revenue_amt,
		  :d_doctor_share,
		  :d_settled_amount; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )119;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqfoff = (           int )0;
 sqlstm.sqfmod = (unsigned int )2;
 sqlstm.sqhstv[0] = (         void  *)&d_physician_id;
 sqlstm.sqhstl[0] = (unsigned int  )18;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_physician_name;
 sqlstm.sqhstl[1] = (unsigned int  )18;
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
 sqlstm.sqhstl[3] = (unsigned int  )23;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_bill_doc_type_code;
 sqlstm.sqhstl[4] = (unsigned int  )12;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&d_bill_doc_num;
 sqlstm.sqhstl[5] = (unsigned int  )12;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&d_blng_serv_code;
 sqlstm.sqhstl[6] = (unsigned int  )13;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&d_service_desc;
 sqlstm.sqhstl[7] = (unsigned int  )18;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&d_serv_item_code;
 sqlstm.sqhstl[8] = (unsigned int  )23;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&d_serv_date;
 sqlstm.sqhstl[9] = (unsigned int  )32;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&d_serv_qty;
 sqlstm.sqhstl[10] = (unsigned int  )12;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&d_hosp_revenue_amt;
 sqlstm.sqhstl[11] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&d_doctor_share;
 sqlstm.sqhstl[12] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&d_settled_amount;
 sqlstm.sqhstl[13] = (unsigned int  )sizeof(double);
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



	if (OERROR)
		err_mesg("FETCH failed on cursor DR_PAY_CUR ",0,"");

	d_physician_id.arr[d_physician_id.len] = '\0';
	d_physician_name.arr[d_physician_name.len] = '\0';
	d_patient_id.arr[d_patient_id.len] = '\0';
	d_episode_id.arr[d_episode_id.len] = '\0';
	d_bill_doc_type_code.arr[d_bill_doc_type_code.len] = '\0';
	d_bill_doc_num.arr[d_bill_doc_num.len] = '\0';
	d_blng_serv_code.arr[d_blng_serv_code.len] = '\0';
	d_service_desc.arr[d_service_desc.len] = '\0';
	d_serv_item_code.arr[d_serv_item_code.len] = '\0';
	d_serv_date.arr[d_serv_date.len] ='\0'; 
	d_serv_qty.arr[d_serv_qty.len] = '\0';

	return(LAST_ROW?0:1);
}

close_dr_pay_cur()
{
	/* EXEC SQL CLOSE DR_PAY_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )190;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}



 print_first_page()
{
	print_page_title();
        fprintf(fp,"\nVER : 4.1\n");
   	fprintf(fp,"\n\n\n      INPUT PARAMETERS :\n");
	fprintf(fp,"      ----------------\n");

  	//fprintf(fp,"%35s : %-s\n\n","Period",nd_month_year.arr);

	fprintf(fp,"%35s : %-d/%-d\n",  "Period From",nd_from_month,nd_from_year);
	fprintf(fp,"%35s : %-d/%-d\n\n","         To",nd_to_month,nd_to_year);

	fprintf(fp,"%35s : %-s\n",  "Doctor Id From",nd_from_doctor_id.arr);
	fprintf(fp,"%35s : %-s\n\n","            To",nd_to_doctor_id.arr);

	fprintf(fp,"%35s : %-s\n",  "Billing Service From",nd_from_blng_serv_code.arr);
	fprintf(fp,"%35s : %-s\n\n","                  To",nd_to_blng_serv_code.arr);

	fprintf(fp,"%35s : %-s\n",  "Patient Id From",nd_from_patient_id.arr);
	fprintf(fp,"%35s : %-s\n\n","             To",nd_to_patient_id.arr);

	fprintf(fp,"%35s : %-s\n",  "Episode Id From",nd_from_episode_id.arr);
	fprintf(fp,"%35s : %-s\n\n","             To",nd_to_episode_id.arr);

	fprintf(fp,"%35s : ","Episode Type");
	

	if ( nd_episode_type.arr[0] == 'A') 
		fprintf(fp,"%-s","All");
	else if ( nd_episode_type.arr[0] == 'E') 
		fprintf(fp,"%-s","Emergency");
	else if ( nd_episode_type.arr[0] == 'O') 
		fprintf(fp,"%-s","Outpatient");	
	else if ( nd_episode_type.arr[0] == 'D') 
		fprintf(fp,"%-s","Daycare");
	else if ( nd_episode_type.arr[0] == 'I') 
		fprintf(fp,"%-s","Inpatient");
	else if ( nd_episode_type.arr[0] == 'R') 
		fprintf(fp,"%-s","External");

	fprintf(fp,"\n");	
	
        next_page();  
  

}

next_page() 
{
  
	fprintf(fp,"\n");
	fprintf(fp,"\f");
	lctr=0;
	fprintf(fp,"\n"); 

	l_line_cnt_for_dtl_rec = 0;

	// Used for Sub-title - printing to first line each page
	 
	print_page_title();
	print_column_title();  	
	
	
}

print_column_title()
 {
      fprintf(fp,"%-15.15s %-15.15s %-20.20s %-15.15s %-20.20s %-26.26s %-20.20s %-16.16s %7.7s %15.15s %15.15s %15.15s",
      loc_legend[60],loc_legend[70],loc_legend[80],loc_legend[90],loc_legend[100],loc_legend[130],loc_legend[160],loc_legend210_1,
      loc_legend170_1,loc_legend180_1,loc_legend[190],loc_legend[200]);

      next_line(1);

      fprintf(fp, "%-15.15s %-15.15s %-20.20s %-15.15s %-9.9s %-10.10s %-10.10s %-15.15s %-20.20s %-16.16s %7.7s %15.15s %15.15s %15.15s",
      "","","","",loc_legend[110],loc_legend[120],loc_legend[140],loc_legend[150],
      "",loc_legend210_2,loc_legend170_2,loc_legend180_2,"","");

      next_line(1);
      print_line('-',REP_WIDTH);         

 }


 open_files()
 {

	strcpy(filename,WORKING_DIR);
	strcat(filename,"DFR00006.lis");

	if ((fp = fopen(filename,"w")) == NULL)
	{
		disp_message(ERR_MESG,"Error in opening file DFR00006.lis");
		proc_exit();
	}

 }

 get_sy_prog_param()
 {
	//nd_month_year.arr[0] = '\0';
	nd_from_doctor_id.arr[0] = '\0';
	nd_to_doctor_id.arr[0] = '\0';
	nd_from_blng_serv_code.arr[0] = '\0';
	nd_to_blng_serv_code.arr[0] = '\0';
	nd_from_patient_id.arr[0] = '\0';
	nd_to_patient_id.arr[0] = '\0';
	nd_from_episode_id.arr[0] = '\0';
	nd_to_episode_id.arr[0] = '\0';
	nd_episode_type.arr[0] = '\0';
	nd_repeat_grp_col.arr[0] = '\0';

	//nd_month_year.len =0;
	nd_from_doctor_id.len =0;
	nd_to_doctor_id.len =0;
	nd_from_blng_serv_code.len =0;
	nd_to_blng_serv_code.len =0;
	nd_from_patient_id.len =0;
	nd_to_patient_id.len =0;
	nd_from_episode_id.len =0;
	nd_to_episode_id.len =0;
	nd_episode_type.len =0;
	nd_repeat_grp_col.len = 0;

			
        /* EXEC SQL SELECT	PARAM1,PARAM2,PARAM3,PARAM4,PARAM5,PARAM6,
			PARAM7,PARAM8,PARAM9,PARAM10, PARAM11,
			PARAM12,PARAM13,PARAM14
		 INTO	:nd_from_month, 
			:nd_to_month,
			:nd_from_year, 
			:nd_to_year,
			:nd_from_doctor_id,
			:nd_to_doctor_id,
			:nd_from_blng_serv_code,
			:nd_to_blng_serv_code,
			:nd_from_patient_id,
			:nd_to_patient_id,
			:nd_from_episode_id,
			:nd_to_episode_id,
			:nd_episode_type,
			:nd_repeat_grp_col
		FROM SY_PROG_PARAM
                WHERE PGM_ID   = :nd_curr_pgm_id
                AND SESSION_ID = :nd_session_id
                AND PGM_DATE   = :nd_pgm_date; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 12;
        sqlstm.arrsiz = 17;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 ,PARAM5 ,PARAM6\
 ,PARAM7 ,PARAM8 ,PARAM9 ,PARAM10 ,PARAM11 ,PARAM12 ,PARAM13 ,PARAM14 into :b0\
,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12,:b13  from SY_PROG_PARAM w\
here ((PGM_ID=:b14 and SESSION_ID=:b15) and PGM_DATE=:b16)";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )205;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)4352;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&nd_from_month;
        sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&nd_to_month;
        sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&nd_from_year;
        sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&nd_to_year;
        sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
        sqlstm.sqhsts[3] = (         int  )0;
        sqlstm.sqindv[3] = (         void  *)0;
        sqlstm.sqinds[3] = (         int  )0;
        sqlstm.sqharm[3] = (unsigned int  )0;
        sqlstm.sqadto[3] = (unsigned short )0;
        sqlstm.sqtdso[3] = (unsigned short )0;
        sqlstm.sqhstv[4] = (         void  *)&nd_from_doctor_id;
        sqlstm.sqhstl[4] = (unsigned int  )18;
        sqlstm.sqhsts[4] = (         int  )0;
        sqlstm.sqindv[4] = (         void  *)0;
        sqlstm.sqinds[4] = (         int  )0;
        sqlstm.sqharm[4] = (unsigned int  )0;
        sqlstm.sqadto[4] = (unsigned short )0;
        sqlstm.sqtdso[4] = (unsigned short )0;
        sqlstm.sqhstv[5] = (         void  *)&nd_to_doctor_id;
        sqlstm.sqhstl[5] = (unsigned int  )18;
        sqlstm.sqhsts[5] = (         int  )0;
        sqlstm.sqindv[5] = (         void  *)0;
        sqlstm.sqinds[5] = (         int  )0;
        sqlstm.sqharm[5] = (unsigned int  )0;
        sqlstm.sqadto[5] = (unsigned short )0;
        sqlstm.sqtdso[5] = (unsigned short )0;
        sqlstm.sqhstv[6] = (         void  *)&nd_from_blng_serv_code;
        sqlstm.sqhstl[6] = (unsigned int  )13;
        sqlstm.sqhsts[6] = (         int  )0;
        sqlstm.sqindv[6] = (         void  *)0;
        sqlstm.sqinds[6] = (         int  )0;
        sqlstm.sqharm[6] = (unsigned int  )0;
        sqlstm.sqadto[6] = (unsigned short )0;
        sqlstm.sqtdso[6] = (unsigned short )0;
        sqlstm.sqhstv[7] = (         void  *)&nd_to_blng_serv_code;
        sqlstm.sqhstl[7] = (unsigned int  )13;
        sqlstm.sqhsts[7] = (         int  )0;
        sqlstm.sqindv[7] = (         void  *)0;
        sqlstm.sqinds[7] = (         int  )0;
        sqlstm.sqharm[7] = (unsigned int  )0;
        sqlstm.sqadto[7] = (unsigned short )0;
        sqlstm.sqtdso[7] = (unsigned short )0;
        sqlstm.sqhstv[8] = (         void  *)&nd_from_patient_id;
        sqlstm.sqhstl[8] = (unsigned int  )23;
        sqlstm.sqhsts[8] = (         int  )0;
        sqlstm.sqindv[8] = (         void  *)0;
        sqlstm.sqinds[8] = (         int  )0;
        sqlstm.sqharm[8] = (unsigned int  )0;
        sqlstm.sqadto[8] = (unsigned short )0;
        sqlstm.sqtdso[8] = (unsigned short )0;
        sqlstm.sqhstv[9] = (         void  *)&nd_to_patient_id;
        sqlstm.sqhstl[9] = (unsigned int  )23;
        sqlstm.sqhsts[9] = (         int  )0;
        sqlstm.sqindv[9] = (         void  *)0;
        sqlstm.sqinds[9] = (         int  )0;
        sqlstm.sqharm[9] = (unsigned int  )0;
        sqlstm.sqadto[9] = (unsigned short )0;
        sqlstm.sqtdso[9] = (unsigned short )0;
        sqlstm.sqhstv[10] = (         void  *)&nd_from_episode_id;
        sqlstm.sqhstl[10] = (unsigned int  )22;
        sqlstm.sqhsts[10] = (         int  )0;
        sqlstm.sqindv[10] = (         void  *)0;
        sqlstm.sqinds[10] = (         int  )0;
        sqlstm.sqharm[10] = (unsigned int  )0;
        sqlstm.sqadto[10] = (unsigned short )0;
        sqlstm.sqtdso[10] = (unsigned short )0;
        sqlstm.sqhstv[11] = (         void  *)&nd_to_episode_id;
        sqlstm.sqhstl[11] = (unsigned int  )23;
        sqlstm.sqhsts[11] = (         int  )0;
        sqlstm.sqindv[11] = (         void  *)0;
        sqlstm.sqinds[11] = (         int  )0;
        sqlstm.sqharm[11] = (unsigned int  )0;
        sqlstm.sqadto[11] = (unsigned short )0;
        sqlstm.sqtdso[11] = (unsigned short )0;
        sqlstm.sqhstv[12] = (         void  *)&nd_episode_type;
        sqlstm.sqhstl[12] = (unsigned int  )4;
        sqlstm.sqhsts[12] = (         int  )0;
        sqlstm.sqindv[12] = (         void  *)0;
        sqlstm.sqinds[12] = (         int  )0;
        sqlstm.sqharm[12] = (unsigned int  )0;
        sqlstm.sqadto[12] = (unsigned short )0;
        sqlstm.sqtdso[12] = (unsigned short )0;
        sqlstm.sqhstv[13] = (         void  *)&nd_repeat_grp_col;
        sqlstm.sqhstl[13] = (unsigned int  )4;
        sqlstm.sqhsts[13] = (         int  )0;
        sqlstm.sqindv[13] = (         void  *)0;
        sqlstm.sqinds[13] = (         int  )0;
        sqlstm.sqharm[13] = (unsigned int  )0;
        sqlstm.sqadto[13] = (unsigned short )0;
        sqlstm.sqtdso[13] = (unsigned short )0;
        sqlstm.sqhstv[14] = (         void  *)&nd_curr_pgm_id;
        sqlstm.sqhstl[14] = (unsigned int  )17;
        sqlstm.sqhsts[14] = (         int  )0;
        sqlstm.sqindv[14] = (         void  *)0;
        sqlstm.sqinds[14] = (         int  )0;
        sqlstm.sqharm[14] = (unsigned int  )0;
        sqlstm.sqadto[14] = (unsigned short )0;
        sqlstm.sqtdso[14] = (unsigned short )0;
        sqlstm.sqhstv[15] = (         void  *)&nd_session_id;
        sqlstm.sqhstl[15] = (unsigned int  )18;
        sqlstm.sqhsts[15] = (         int  )0;
        sqlstm.sqindv[15] = (         void  *)0;
        sqlstm.sqinds[15] = (         int  )0;
        sqlstm.sqharm[15] = (unsigned int  )0;
        sqlstm.sqadto[15] = (unsigned short )0;
        sqlstm.sqtdso[15] = (unsigned short )0;
        sqlstm.sqhstv[16] = (         void  *)&nd_pgm_date;
        sqlstm.sqhstl[16] = (unsigned int  )27;
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
		err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

	if (NODATAFOUND)
		err_mesg("No Record found in SY_PROG_PARAM",0,"");
	

	//nd_month_year.arr[nd_month_year.len]  = '\0';
	nd_from_doctor_id.arr[nd_from_doctor_id.len] = '\0';
	nd_to_doctor_id.arr[nd_to_doctor_id.len] = '\0';
	nd_from_blng_serv_code.arr[nd_from_blng_serv_code.len] = '\0';
	nd_to_blng_serv_code.arr[nd_to_blng_serv_code.len] = '\0';
	nd_from_patient_id.arr[nd_from_patient_id.len] = '\0';
	nd_to_patient_id.arr[nd_to_patient_id.len] = '\0';
	nd_from_episode_id.arr[nd_from_episode_id.len] = '\0';
	nd_to_episode_id.arr[nd_to_episode_id.len] = '\0';
	nd_episode_type.arr[nd_episode_type.len] = '\0';
	nd_repeat_grp_col.arr[nd_repeat_grp_col.len] = '\0';


	/* EXEC SQL DELETE SY_PROG_PARAM
              WHERE PGM_ID   = :nd_curr_pgm_id
              AND SESSION_ID = :nd_session_id
              AND PGM_DATE   = :nd_pgm_date; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID=:b0 and SESSION_I\
D=:b1) and PGM_DATE=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )288;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_curr_pgm_id;
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
}




fetch_legend_value()
{
	for(i=1;i<=300;i++)
	{
		l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('DFR00006.LEGEND_'||
				LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		         INTO :l_pk_value
			 FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 17;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('DFR00006.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )315;
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
  sqlstm.arrsiz = 17;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility_id , 'S\
M' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_valu\
e , :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )338;
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

	// WRAP

	r_ctr = 0;
	if (strlen(loc_legend[170]) > 0)
	split_text(loc_legend[170],5,loc_legend170_1,&r_ctr);
	if (strlen(loc_legend[170]) > 5)	
	split_text(loc_legend[170],5,loc_legend170_2,&r_ctr);

	r_ctr = 0;
	if (strlen(loc_legend[180]) > 0)
	split_text(loc_legend[180],15,loc_legend180_1,&r_ctr);
	if (strlen(loc_legend[180]) > 15)	
	split_text(loc_legend[180],15,loc_legend180_2,&r_ctr);

	r_ctr = 0;
	if (strlen(loc_legend[210]) > 0)
	split_text(loc_legend[210],15,loc_legend210_1,&r_ctr);
	if (strlen(loc_legend[210]) > 15)	
	split_text(loc_legend[210],15,loc_legend210_2,&r_ctr);
	

}

next_line(skip) /* will check for MAX LINE before printing totals */		
int skip;
 {
	if ((lctr + skip) >= MAX_LINES)
	{
		next_page(); 
	}
	else
	{
		fprintf(fp,"\n"); ++lctr; 
		        /*     fprintf(fp,"LNNO:%2d",lno); */
	}
 }
        


print_page_title()
  {

	int hosp_nm_len,date1_len, rep_title_len = 10,
	    s1, s2,date_len,user_len,
	    pgm_len,sub_title_len;

	char v_rep_title[200],v_as_on_date[12],v_sub_title[200],v_title[200],
	     v_title1[200];
   
	fprintf(fp,"%3.3s : DF",loc_legend[10]);
	hosp_nm_len  =  d_acc_entity_name.len;
	s1 = (REP_WIDTH-hosp_nm_len)/2;
	horz_skip(s1-8);
	fprintf(fp,"%s", d_acc_entity_name.arr);
	s2 = (REP_WIDTH-s1-hosp_nm_len);
	date1_len=4; //strlen(loc_legend[40]);
	horz_skip(s2-date1_len-13);
	fprintf(fp,"%4.4s : %s", loc_legend[40],d_curr_date.arr);
    
	next_line(1);
	
	fprintf(fp,"%3.3s : %s", loc_legend[20],d_user.arr); 	
        
	//user_len=strlen(d_user.arr);
	//strcpy(v_rep_title," ");
	//rep_title_len = strlen(v_rep_title);
	//s1 = (REP_WIDTH-rep_title_len)/2;
	//strcpy(v_as_on_date,nd_as_on_date.arr);
	//date_len= strlen(v_as_on_date);
	//horz_skip(s1-user_len-6);
	//fprintf(fp,"%s",v_rep_title);
   	//s2 = (REP_WIDTH-s1-rep_title_len);
	//horz_skip(s2-24);
	//fprintf(fp,"%9s : %10s",loc_legend[220],d_curr_date.arr);

	next_line(1);

	fprintf(fp,"%3.3s : %s",loc_legend[30],nd_curr_pgm_id.arr);
        pgm_len=strlen(nd_curr_pgm_id.arr);	 
	
	strcpy(v_sub_title,loc_legend[230]);

	sub_title_len = strlen(v_sub_title);
	s1 = (REP_WIDTH-sub_title_len)/2;
   	horz_skip(s1-pgm_len-6);
        fprintf(fp,"%s",v_sub_title);

        s2 = (REP_WIDTH-s1-sub_title_len);
	horz_skip(s2-17);
	fprintf(fp,"%4.4s : %-10d",loc_legend[50],++page_no);
	next_line(1);  
   
	lctr = 3;
	print_line('-',REP_WIDTH); 
	//next_line(1);

}


get_header_dtls()
{
	d_acc_entity_name.arr[0] = '\0';
	d_user.arr[0] = '\0';
	d_curr_date.arr[0] = '\0';

	d_acc_entity_name.len = 0;
	d_user.len = 0;
	d_curr_date.len = 0;

	/* EXEC SQL SELECT acc_entity_name, user, to_char(sysdate, 'DD/MM/YYYY')
	INTO :d_acc_entity_name,:d_user, :d_curr_date
        FROM SY_ACC_ENTITY
	WHERE acc_entity_id = :nd_facility_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select acc_entity_name ,user ,to_char(sysdate,'DD/MM/YYYY') \
into :b0,:b1,:b2  from SY_ACC_ENTITY where acc_entity_id=:b3";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )369;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_acc_entity_name;
 sqlstm.sqhstl[0] = (unsigned int  )102;
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
 sqlstm.sqhstv[2] = (         void  *)&d_curr_date;
 sqlstm.sqhstl[2] = (unsigned int  )23;
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



	if (OERROR)
		err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");

	if (NODATAFOUND)
		err_mesg("No Record found in SY_ACC_ENTITY",0,"");

	d_acc_entity_name.arr[d_acc_entity_name.len] = '\0';
	d_user.arr[d_user.len] = '\0';
	d_curr_date.arr[d_curr_date.len] = '\0';

}

print_line(ch,n) /* this is to obtain required characters */
  char ch;
	int n;
	{
	int i;
	for(i=0;i<n;i++)
	fprintf(fp,"%c",ch);  fprintf(fp,"\n");++lctr;
	}
     
horz_skip(num) /* this is to obtain required blank space */
int num;
	{
	int i;
	for(i=0;i<num;i++)fprintf(fp," ");
	}
