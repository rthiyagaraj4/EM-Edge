
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
           char  filnam[32];
};
static const struct sqlcxp sqlfpn =
{
    31,
    "D:\\Issues\\PE\\Refund\\BLR00009.pc"
};


static unsigned long sqlctx = 611564957;


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
            void  *sqhstv[16];
   unsigned int   sqhstl[16];
            int   sqhsts[16];
            void  *sqindv[16];
            int   sqinds[16];
   unsigned int   sqharm[16];
   unsigned int   *sqharc[16];
   unsigned short  sqadto[16];
   unsigned short  sqtdso[16];
} sqlstm = {10,16};

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

 static const char *sq0014 = 
"select b.ln1_add ,b.ln2_add ,b.ln3_add ,b.tel_num ,TO_CHAR(sysdate,'dd/mm/y\
yyy') ,a.payer_name ,TO_CHAR(a.doc_date,'dd/mm/yyyy') ,c.short_desc ,b.base_c\
urrency ,a.doc_type_code ,a.doc_number ,a.doc_amt ,a.slmt_doc_ref_desc ,TO_CH\
AR(a.slmt_doc_ref_date,'dd/mm/yyyy') ,a.patient_id ,a.doc_srno  from bl_recei\
pt_refund_HDRdtl_VW a ,sy_acc_entity b ,bl_slmt_type c where (((((((a.operati\
ng_facility_id=b.acc_entity_id and b.acc_entity_code=c.acc_entity_code) and b\
.acc_entity_id=:b0) and a.slmt_type_code=c.slmt_type_code) and a.episode_type\
=:b1) and a.DOC_TYPE_CODE between :b2 and NVL(:b3,:b2)) and a.DOC_NUMBER betw\
een :b5 and NVL(:b6,:b5)) and trunc(doc_date) between NVL(TO_DATE(:b8,'DD/MM/\
YYYYHH24:MI:SS'),TO_DATE('01/01/100000:00:00','DD/MM/YYYYHH24:MI:SS')) and NV\
L(TO_DATE(:b9,'DD/MM/YYYYHH24:MI:SS'),TO_DATE('01/01/400023:59:59','DD/MM/YYY\
YHH24:MI:SS'))) order by 10            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,120,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,47,0,4,126,0,0,1,0,0,1,0,2,9,0,0,
55,0,0,3,60,0,4,131,0,0,3,2,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
82,0,0,4,119,0,6,218,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
109,0,0,5,0,0,30,233,0,0,0,0,0,1,0,
124,0,0,6,63,0,4,243,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
147,0,0,7,212,0,4,275,0,0,12,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
210,0,0,8,75,0,4,350,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
233,0,0,9,84,0,4,359,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
256,0,0,10,232,0,4,395,0,0,9,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
307,0,0,11,70,0,4,435,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
330,0,0,12,74,0,4,449,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
353,0,0,13,74,0,4,465,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
376,0,0,15,0,0,32,523,0,0,0,0,0,1,0,
391,0,0,14,884,0,9,535,0,0,10,10,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
446,0,0,14,0,0,13,549,0,0,16,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,
525,0,0,16,0,0,32,569,0,0,0,0,0,1,0,
540,0,0,14,0,0,15,587,0,0,0,0,0,1,0,
555,0,0,17,131,0,4,595,0,0,5,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
590,0,0,18,335,0,4,636,0,0,8,7,0,1,0,2,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,
637,0,0,19,43,0,4,897,0,0,2,1,0,1,0,1,9,0,0,2,97,0,0,
660,0,0,20,123,0,4,909,0,0,2,1,0,1,0,2,9,0,0,1,97,0,0,
683,0,0,21,276,0,4,916,0,0,3,2,0,1,0,2,9,0,0,1,97,0,0,1,9,0,0,
710,0,0,22,47,0,4,936,0,0,1,0,0,1,0,2,9,0,0,
729,0,0,23,117,0,6,952,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
756,0,0,24,144,0,4,997,0,0,2,1,0,1,0,2,3,0,0,1,9,0,0,
779,0,0,25,0,0,31,1010,0,0,0,0,0,1,0,
794,0,0,26,144,0,4,1037,0,0,2,1,0,1,0,2,3,0,0,1,9,0,0,
817,0,0,27,0,0,31,1051,0,0,0,0,0,1,0,
};


#include <stdio.h>         
#include <string.h> 
#include <bl.h>        

#define NOT_FOUND (sqlca.sqlerrd[2] == 0)

#define LAST_ROW (sqlca.sqlcode == 1403)

#define ONLINE_PRINTING 1

#define ESC 0x1B

/* EXEC SQL BEGIN DECLARE SECTION; */ 


	/* VARCHAR  
			 d_doc_type_code  [7],
			 d_doc_number     [9],
			 l_to_doc_type_code	[10],
		     l_to_doc_type_num	[10],
			 l_fr_date			[30],
			 l_to_date			[30],
			 lv_user_id       [91],
			 lv_pword 	      [91],

			 uid			[91], //added for PE CORRECTION
			 lv_session_id    [16],
	         lv_pgm_date      [25],
			 lv_pgm_id		  [10],
			 lv_facility_id	   [3],
			 lc_facility_id		[3],
			 lv_report_desc   [61],

			 lv_hosp_name     [31],
			 lv_hosp_addr1    [31],
			 lv_hosp_addr2    [31],
			 lv_hosp_addr3    [31],
			 lv_hosp_tel_num  [21],
			 lv_sysdate		  [31],

			 lv_payer_name	  [41],
			 lv_mail_addr1    [31],
			 lv_mail_addr2    [31],
			 lv_mail_addr3    [31],
			 lv_mail_po_code  [10],

			 lv_doc_date	  [31],
			 lv_slmt_type	  [16],
			 lv_base_currency [10],
			 lv_ref_desc	  [21],
			 lv_ref_date	  [31],
			 
			 lv_patient_id    [21],
			 lv_doc_srno	  [3],
			 lv_episode_type   [2],

			 lv_lang_id        [5],
			 lv_lgnd_id        [5],
			 lv_lgnd_val      [51],

			 P_START_TIME			[60],  //added for pe correction

			 d_err_code[30],

			 
				nd_add_ln1	 [31],  
				nd_add_ln2   [31],  
				nd_add_ln3   [31],  
				nd_add_ln4   [31],  
				d_postal_code   [9],
				d_res_area_code  [7],
				d_res_town_code  [7],
				d_region_code    [7],
                nd_region		[31],
                nd_res_town		[31],
				nd_res_area		[31],
				l_amt   [50],
				deci_val [2],

			 p_doc_type_code  [10]; */ 
struct { unsigned short len; unsigned char arr[7]; } d_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_doc_number;

struct { unsigned short len; unsigned char arr[10]; } l_to_doc_type_code;

struct { unsigned short len; unsigned char arr[10]; } l_to_doc_type_num;

struct { unsigned short len; unsigned char arr[30]; } l_fr_date;

struct { unsigned short len; unsigned char arr[30]; } l_to_date;

struct { unsigned short len; unsigned char arr[91]; } lv_user_id;

struct { unsigned short len; unsigned char arr[91]; } lv_pword;

struct { unsigned short len; unsigned char arr[91]; } uid;

struct { unsigned short len; unsigned char arr[16]; } lv_session_id;

struct { unsigned short len; unsigned char arr[25]; } lv_pgm_date;

struct { unsigned short len; unsigned char arr[10]; } lv_pgm_id;

struct { unsigned short len; unsigned char arr[3]; } lv_facility_id;

struct { unsigned short len; unsigned char arr[3]; } lc_facility_id;

struct { unsigned short len; unsigned char arr[61]; } lv_report_desc;

struct { unsigned short len; unsigned char arr[31]; } lv_hosp_name;

struct { unsigned short len; unsigned char arr[31]; } lv_hosp_addr1;

struct { unsigned short len; unsigned char arr[31]; } lv_hosp_addr2;

struct { unsigned short len; unsigned char arr[31]; } lv_hosp_addr3;

struct { unsigned short len; unsigned char arr[21]; } lv_hosp_tel_num;

struct { unsigned short len; unsigned char arr[31]; } lv_sysdate;

struct { unsigned short len; unsigned char arr[41]; } lv_payer_name;

struct { unsigned short len; unsigned char arr[31]; } lv_mail_addr1;

struct { unsigned short len; unsigned char arr[31]; } lv_mail_addr2;

struct { unsigned short len; unsigned char arr[31]; } lv_mail_addr3;

struct { unsigned short len; unsigned char arr[10]; } lv_mail_po_code;

struct { unsigned short len; unsigned char arr[31]; } lv_doc_date;

struct { unsigned short len; unsigned char arr[16]; } lv_slmt_type;

struct { unsigned short len; unsigned char arr[10]; } lv_base_currency;

struct { unsigned short len; unsigned char arr[21]; } lv_ref_desc;

struct { unsigned short len; unsigned char arr[31]; } lv_ref_date;

struct { unsigned short len; unsigned char arr[21]; } lv_patient_id;

struct { unsigned short len; unsigned char arr[3]; } lv_doc_srno;

struct { unsigned short len; unsigned char arr[2]; } lv_episode_type;

struct { unsigned short len; unsigned char arr[5]; } lv_lang_id;

struct { unsigned short len; unsigned char arr[5]; } lv_lgnd_id;

struct { unsigned short len; unsigned char arr[51]; } lv_lgnd_val;

struct { unsigned short len; unsigned char arr[60]; } P_START_TIME;

struct { unsigned short len; unsigned char arr[30]; } d_err_code;

struct { unsigned short len; unsigned char arr[31]; } nd_add_ln1;

struct { unsigned short len; unsigned char arr[31]; } nd_add_ln2;

struct { unsigned short len; unsigned char arr[31]; } nd_add_ln3;

struct { unsigned short len; unsigned char arr[31]; } nd_add_ln4;

struct { unsigned short len; unsigned char arr[9]; } d_postal_code;

struct { unsigned short len; unsigned char arr[7]; } d_res_area_code;

struct { unsigned short len; unsigned char arr[7]; } d_res_town_code;

struct { unsigned short len; unsigned char arr[7]; } d_region_code;

struct { unsigned short len; unsigned char arr[31]; } nd_region;

struct { unsigned short len; unsigned char arr[31]; } nd_res_town;

struct { unsigned short len; unsigned char arr[31]; } nd_res_area;

struct { unsigned short len; unsigned char arr[50]; } l_amt;

struct { unsigned short len; unsigned char arr[2]; } deci_val;

struct { unsigned short len; unsigned char arr[10]; } p_doc_type_code;

	
	int		 p_doc_num,
			 l_no_of_decimal;

	char	 lc_filename	 [150],
			 lc_actl_amt      [30],
			 lc_char_amt      [30],
			 lc_doc_num        [9],
			 lc_lgnd_id        [5];

	double   ld_doc_amt,
			 ld_outst_amt;

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

		

    strcpy(g_pgm_id, "BLR00009");
	
    strcpy(lv_pword.arr, argv[1]);

   lv_pword.len = strlen(lv_pword.arr);
   /* EXEC SQL CONNECT :lv_pword; */ 

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
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}




	
    set_meduser_role(); 

	/* EXEC SQL select GET_TRACE_TIMESTAMP into :P_START_TIME from dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select GET_TRACE_TIMESTAMP into :b0  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )36;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&P_START_TIME;
 sqlstm.sqhstl[0] = (unsigned int  )62;
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

 // added for pe correctiom

		uid.arr[0] = '\0'; // added for pe correctiom
		uid.len	   =	0; // added for pe correctiom
	
		/* EXEC SQL select substr(:lv_pword,0,instr(:lv_pword,'/')-1) into :uid from dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select substr(:b0,0,(instr(:b0,'/')-1)) into :b2  from dua\
l ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )55;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&lv_pword;
  sqlstm.sqhstl[0] = (unsigned int  )93;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&lv_pword;
  sqlstm.sqhstl[1] = (unsigned int  )93;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&uid;
  sqlstm.sqhstl[2] = (unsigned int  )93;
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

 // added for pe correctiom

		 uid.arr[uid.len] = '\0'; // added for pe correctiom
	
	  
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

    strcpy(lv_facility_id.arr, argv[0]);
    lv_facility_id.len = strlen(lv_facility_id.arr);
    strcpy(g_facility_id, lv_facility_id.arr);

/*	strcpy(d_doc_type_code.arr, argv[4]);
	d_doc_type_code.len	= strlen(d_doc_type_code.arr);

	strcpy(d_doc_number.arr, argv[5]);
	d_doc_number.len = strlen(d_doc_number.arr);

	strcpy(l_to_doc_type_code.arr,argv[6]);
	l_to_doc_type_code.len = strlen(l_to_doc_type_code.arr);

	strcpy(l_to_doc_type_num.arr,argv[7]);
	l_to_doc_type_num.len = strlen(l_to_doc_type_num.arr);

	strcpy(l_fr_date.arr,argv[8]);
	l_fr_date.len = strlen(l_fr_date.arr);

	strcpy(l_to_date.arr,argv[9]);
	l_to_date.len = strlen(l_to_date.arr);

	strcpy(lv_episode_type.arr,argv[10]);
	lv_episode_type.len	= strlen(lv_episode_type.arr);

	strcpy(lv_lang_id.arr,argv[11]);
	lv_lang_id.len	=	strlen(lv_lang_id.arr); */
					

     fn_fetch_parameters();
     fn_fetch_hosp_name();
	 fn_fetch_hosp_address();
	 fn_fetch_region_code();
	 fn_fetch_town_code();
     fn_fetch_area_code();

	 fn_open_file();

	 

	fn_declare_receipt_dtls();

	while (fn_fetch_receipt_dtls()) 
	 {
	//disp_message(ERR_MESG,"enter while");		
	 fn_fetch_patient_dtls();

	 fn_fetch_outst_amt();

	fn_print_settings();
	
   	fn_print_header();
	
	fn_print_body();

   	fn_print_footer();
	
	fprintf(fp,"%cE",ESC);		// To reset the printer
	
  }

  fclose(fp);


//added for PE CORRECTION
	/* EXEC SQL EXECUTE
	BEGIN	
	TRACE_DURATION_BL(
	:lv_pgm_id ,
	'Acknowledgement Letter for Receipt Generation' ,
	:P_START_TIME ,
	:uid );
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin TRACE_DURATION_BL ( :lv_pgm_id , 'Acknowledgement Let\
ter for Receipt Generation' , :P_START_TIME , :uid ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )82;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&lv_pgm_id;
 sqlstm.sqhstl[0] = (unsigned int  )12;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&P_START_TIME;
 sqlstm.sqhstl[1] = (unsigned int  )62;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&uid;
 sqlstm.sqhstl[2] = (unsigned int  )93;
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


//added for PE CORRECTION

  fn_print_online();

  close_receipt_cursor();

    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 4;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )109;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
		err_mesg("COMMIT WORK RELEASE failed.",0,"");
}

fn_fetch_parameters()
{
	lv_report_desc.arr[0] = '\0';
	lv_report_desc.len    = 0;

	/* EXEC SQL SELECT report_desc 
			 INTO   lv_report_desc
			 FROM   sm_report 
			 WHERE  report_id = :lv_pgm_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select report_desc into :b0  from sm_report where report_id\
=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )124;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&lv_report_desc;
 sqlstm.sqhstl[0] = (unsigned int  )63;
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
		err_mesg("SELECT failed on table SM_REPORT.", 0, "");

	lv_report_desc.arr[lv_report_desc.len] = '\0';

	d_doc_type_code.arr[0]		= '\0';
	d_doc_number.arr[0]			= '\0';
	l_to_doc_type_code.arr[0]	= '\0';
	l_to_doc_type_num.arr[0]	= '\0';
	l_fr_date.arr[0]			= '\0';
	l_to_date.arr[0]			= '\0';
	lv_facility_id.arr[0]		= '\0';

	lv_episode_type.arr[0]		= '\0';
	lv_lang_id.arr[0]			= '\0';
	
	d_doc_type_code.len		= 0;
	d_doc_number.len		=0;
	l_to_doc_type_code.len	=0;
	l_to_doc_type_num.len	=0;
	l_fr_date.len			=0;
	l_to_date.len			=0;
	lv_facility_id.len		=0;
	lv_episode_type.len = 0;
	lv_lang_id.len      = 0;

 	
	/* EXEC SQL /oSELECT param1,
					TO_NUMBER(param2),
					param3,
					param4
			 INTO   :p_doc_type_code,
				    :p_doc_num,
					:lv_episode_type,
					:lv_lang_id
			 FROM   sy_prog_param
             WHERE  pgm_id     = :lv_pgm_id
             AND	session_id = :lv_session_id
             AND	pgm_date   = :lv_pgm_date;o/

		
			 SELECT	operating_facility_id,
					PARAM1,
					PARAM2,
					PARAM3,
					PARAM4,
					PARAM5,
					PARAM6,
					PARAM7,
					PARAM8
			   INTO	:lv_facility_id,
					:d_doc_type_code,
					:d_doc_number ,
					:l_to_doc_type_code,
					:l_to_doc_type_num,
					:l_fr_date,
					:l_to_date,
					:lv_episode_type,
					:lv_lang_id
			   FROM sy_prog_param
			  WHERE pgm_id     = :lv_pgm_id
	            AND PGM_DATE   = :lv_pgm_date
	            AND SESSION_ID = :lv_session_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 12;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select operating_facility_id ,PARAM1 ,PARAM2 ,PARAM3 ,PARAM\
4 ,PARAM5 ,PARAM6 ,PARAM7 ,PARAM8 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8  f\
rom sy_prog_param where ((pgm_id=:b9 and PGM_DATE=:b10) and SESSION_ID=:b11)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )147;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&lv_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_doc_type_code;
 sqlstm.sqhstl[1] = (unsigned int  )9;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_doc_number;
 sqlstm.sqhstl[2] = (unsigned int  )11;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&l_to_doc_type_code;
 sqlstm.sqhstl[3] = (unsigned int  )12;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&l_to_doc_type_num;
 sqlstm.sqhstl[4] = (unsigned int  )12;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&l_fr_date;
 sqlstm.sqhstl[5] = (unsigned int  )32;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&l_to_date;
 sqlstm.sqhstl[6] = (unsigned int  )32;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&lv_episode_type;
 sqlstm.sqhstl[7] = (unsigned int  )4;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&lv_lang_id;
 sqlstm.sqhstl[8] = (unsigned int  )7;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&lv_pgm_id;
 sqlstm.sqhstl[9] = (unsigned int  )12;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&lv_pgm_date;
 sqlstm.sqhstl[10] = (unsigned int  )27;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&lv_session_id;
 sqlstm.sqhstl[11] = (unsigned int  )18;
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
}




	strcpy(g_facility_id, lv_facility_id.arr);

	if (OERROR)
		err_mesg("SELECT failed on table SY_PROG_PARAM.", 0, "");

	if (NOT_FOUND)
        err_mesg("No record found in SY_PROG_PARAM.", 0, "");

	d_doc_type_code.arr[d_doc_type_code.len] = '\0';
	d_doc_number.arr[d_doc_number.len]		 = '\0';
	l_to_doc_type_code.arr[l_to_doc_type_code.len] ='\0';
	l_to_doc_type_num.arr[l_to_doc_type_num.len]	='\0';
	l_fr_date.arr[l_fr_date.len]		= '\0';
	l_to_date.arr[l_to_date.len]		= '\0';
	lv_episode_type.arr[lv_episode_type.len] = '\0';
	lv_lang_id.arr[lv_lang_id.len]           = '\0'; 
	lv_facility_id.arr[lv_facility_id.len]	 = '\0';

	

/*	EXEC SQL DELETE sy_prog_param
             WHERE  pgm_id     = :lv_pgm_id
             AND	session_id = :lv_session_id
             AND	pgm_date   = :lv_pgm_date;*/

	if (OERROR)
		err_mesg("DELETE failed on table SY_PROG_PARAM.", 0, "");
}

fn_fetch_hosp_name()
{
	lv_hosp_name.arr[0] = '\0';		
	lv_hosp_name.len    = 0;

	
	if (strcmp(lv_lang_id.arr, "en") == 0) 
	{
		/* EXEC SQL SELECT acc_entity_name
				 INTO   :lv_hosp_name
				 FROM   sy_acc_entity
				 WHERE  acc_entity_id = :lv_facility_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 12;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select acc_entity_name into :b0  from sy_acc_entity where \
acc_entity_id=:b1";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )210;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&lv_hosp_name;
  sqlstm.sqhstl[0] = (unsigned int  )33;
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



				
	}
	else
	{
		/* EXEC SQL SELECT acc_entity_name_loc_lang
				 INTO   :lv_hosp_name
				 FROM   sy_acc_entity
				 WHERE  acc_entity_id = :lv_facility_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 12;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select acc_entity_name_loc_lang into :b0  from sy_acc_enti\
ty where acc_entity_id=:b1";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )233;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&lv_hosp_name;
  sqlstm.sqhstl[0] = (unsigned int  )33;
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



	}

	if (OERROR)
		err_mesg("SELECT failed while fetching hospital name.", 0, "");

	lv_hosp_name.arr[lv_hosp_name.len] = '\0';	
}


fn_fetch_hosp_address()
{

  nd_add_ln1.arr[0] = '\0';
  nd_add_ln2.arr[0] = '\0';
  nd_add_ln3.arr[0] = '\0';
  nd_add_ln4.arr[0] = '\0';
  d_postal_code.arr[0] = '\0';
  d_res_area_code.arr[0] = '\0';
  d_res_town_code.arr[0] = '\0';
  d_region_code.arr[0] = '\0';

 nd_add_ln1.len=0;
 nd_add_ln2.len=0;
 nd_add_ln3.len=0;
 nd_add_ln4.len=0;
 d_postal_code.len=0;
 d_res_area_code.len=0;
 d_res_town_code.len=0;
 d_region_code.len=0;


/* exec sql SELECT
  upper(ADDR_LINE1),             
  UPPER(ADDR_LINE2),             
  UPPER(ADDR_LINE3),             
	UPPER(ADDR_LINE4),             
	UPPER(ADDR_POSTAL_CODE),       
	RES_AREA_CODE,          
	RES_TOWN_CODE,          
	REGION_CODE INTO 
	    :nd_add_ln1,
	    :nd_add_ln2,
	    :nd_add_ln3,
	    :nd_add_ln4,
	    :d_postal_code,
	    :d_res_area_code,
	    :d_res_town_code,
	    :d_region_code
	 FROM  SM_FACILITY_PARAM
   Where FACILITY_ID = :lv_facility_id; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 12;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select upper(ADDR_LINE1) ,UPPER(ADDR_LINE2) ,UPPER(ADDR_LINE\
3) ,UPPER(ADDR_LINE4) ,UPPER(ADDR_POSTAL_CODE) ,RES_AREA_CODE ,RES_TOWN_CODE \
,REGION_CODE into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7  from SM_FACILITY_PARAM whe\
re FACILITY_ID=:b8";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )256;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&nd_add_ln1;
sqlstm.sqhstl[0] = (unsigned int  )33;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&nd_add_ln2;
sqlstm.sqhstl[1] = (unsigned int  )33;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&nd_add_ln3;
sqlstm.sqhstl[2] = (unsigned int  )33;
sqlstm.sqhsts[2] = (         int  )0;
sqlstm.sqindv[2] = (         void  *)0;
sqlstm.sqinds[2] = (         int  )0;
sqlstm.sqharm[2] = (unsigned int  )0;
sqlstm.sqadto[2] = (unsigned short )0;
sqlstm.sqtdso[2] = (unsigned short )0;
sqlstm.sqhstv[3] = (         void  *)&nd_add_ln4;
sqlstm.sqhstl[3] = (unsigned int  )33;
sqlstm.sqhsts[3] = (         int  )0;
sqlstm.sqindv[3] = (         void  *)0;
sqlstm.sqinds[3] = (         int  )0;
sqlstm.sqharm[3] = (unsigned int  )0;
sqlstm.sqadto[3] = (unsigned short )0;
sqlstm.sqtdso[3] = (unsigned short )0;
sqlstm.sqhstv[4] = (         void  *)&d_postal_code;
sqlstm.sqhstl[4] = (unsigned int  )11;
sqlstm.sqhsts[4] = (         int  )0;
sqlstm.sqindv[4] = (         void  *)0;
sqlstm.sqinds[4] = (         int  )0;
sqlstm.sqharm[4] = (unsigned int  )0;
sqlstm.sqadto[4] = (unsigned short )0;
sqlstm.sqtdso[4] = (unsigned short )0;
sqlstm.sqhstv[5] = (         void  *)&d_res_area_code;
sqlstm.sqhstl[5] = (unsigned int  )9;
sqlstm.sqhsts[5] = (         int  )0;
sqlstm.sqindv[5] = (         void  *)0;
sqlstm.sqinds[5] = (         int  )0;
sqlstm.sqharm[5] = (unsigned int  )0;
sqlstm.sqadto[5] = (unsigned short )0;
sqlstm.sqtdso[5] = (unsigned short )0;
sqlstm.sqhstv[6] = (         void  *)&d_res_town_code;
sqlstm.sqhstl[6] = (unsigned int  )9;
sqlstm.sqhsts[6] = (         int  )0;
sqlstm.sqindv[6] = (         void  *)0;
sqlstm.sqinds[6] = (         int  )0;
sqlstm.sqharm[6] = (unsigned int  )0;
sqlstm.sqadto[6] = (unsigned short )0;
sqlstm.sqtdso[6] = (unsigned short )0;
sqlstm.sqhstv[7] = (         void  *)&d_region_code;
sqlstm.sqhstl[7] = (unsigned int  )9;
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
		err_mesg("SELECT failed while fetching hospital Address.", 0, "");

  nd_add_ln1.arr[nd_add_ln1.len] ='\0';
  nd_add_ln1.arr[nd_add_ln1.len] ='\0';
  nd_add_ln1.arr[nd_add_ln1.len] ='\0';
  nd_add_ln1.arr[nd_add_ln1.len] ='\0';
  nd_add_ln1.arr[nd_add_ln1.len] ='\0';
  nd_add_ln1.arr[nd_add_ln1.len] ='\0';
  nd_add_ln1.arr[nd_add_ln1.len] ='\0';
  nd_add_ln1.arr[nd_add_ln1.len] ='\0';

  

}

fn_fetch_region_code()
{
  nd_region.arr[0] ='\0';
  nd_region.len =0;
	/* EXEC SQL SELECT  	UPPER(LONG_DESC)  INTO :nd_region
	    FROM MP_REGION WHERE REGION_CODE=:d_region_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 12;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select UPPER(LONG_DESC) into :b0  from MP_REGION where REGI\
ON_CODE=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )307;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_region;
 sqlstm.sqhstl[0] = (unsigned int  )33;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_region_code;
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



if (OERROR)
		err_mesg("SELECT failed while fetching hospital region.", 0, "");
nd_region.arr[nd_region.len] = '\0';


}

fn_fetch_town_code()
{
  nd_res_town.arr[0] ='\0';
  nd_res_town.len =0;
	/* EXEC SQL	SELECT  	UPPER(LONG_DESC)  INTO :nd_res_town FROM MP_RES_TOWN  WHERE
  RES_TOWN_CODE=:d_res_town_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 12;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select UPPER(LONG_DESC) into :b0  from MP_RES_TOWN where RE\
S_TOWN_CODE=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )330;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_res_town;
 sqlstm.sqhstl[0] = (unsigned int  )33;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_res_town_code;
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



if (OERROR)
		err_mesg("SELECT failed while fetching hospital Town.", 0, "");
nd_res_town.arr[nd_res_town.len] = '\0';



}


fn_fetch_area_code()
{
  nd_res_area.arr[0] ='\0';
  nd_res_area.len =0;
	/* EXEC SQL	SELECT  	UPPER(LONG_DESC)  INTO :nd_res_area FROM MP_RES_AREA  WHERE 
  RES_AREA_CODE=:d_res_area_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 12;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select UPPER(LONG_DESC) into :b0  from MP_RES_AREA where RE\
S_AREA_CODE=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )353;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_res_area;
 sqlstm.sqhstl[0] = (unsigned int  )33;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_res_area_code;
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




if (OERROR)
		err_mesg("SELECT failed while fetching hospital Area.", 0, "");
nd_res_area.arr[nd_res_area.len] = '\0';


}


fn_declare_receipt_dtls()
{
		fn_init_receipt_dtls_var();

		
		
	/* EXEC SQL DECLARE receipt_cursor CURSOR FOR 
				SELECT	b.ln1_add,
					b.ln2_add,
					b.ln3_add,
					b.tel_num,
					TO_CHAR(sysdate, 'dd/mm/yyyy'),
					a.payer_name,
					TO_CHAR(a.doc_date, 'dd/mm/yyyy'),
					c.short_desc,
					b.base_currency,
					a.doc_type_code,
					a.doc_number,
					a.doc_amt,
					a.slmt_doc_ref_desc,
					TO_CHAR(a.slmt_doc_ref_date, 'dd/mm/yyyy'),
					a.patient_id,
					a.doc_srno
			 FROM   bl_receipt_refund_HDRdtl_VW a,
					sy_acc_entity		  b,
					bl_slmt_type		  c
             WHERE  a.operating_facility_id = b.acc_entity_id
			 AND	b.acc_entity_code       = c.acc_entity_code
			 AND	b.acc_entity_id         = :lv_facility_id
			 AND	a.slmt_type_code        = c.slmt_type_code
			 AND    a.episode_type          = :lv_episode_type
			 AND    a.DOC_TYPE_CODE		
			BETWEEN :d_doc_type_code
		      AND NVL(:l_to_doc_type_code,:d_doc_type_code)
			  AND a.DOC_NUMBER    	
	      BETWEEN :d_doc_number 
		      AND NVL(:l_to_doc_type_num, :d_doc_number)
			  AND trunc(doc_date)
		  BETWEEN NVL(TO_DATE(:l_fr_date,'DD/MM/YYYYHH24:MI:SS'),TO_DATE('01/01/100000:00:00','DD/MM/YYYYHH24:MI:SS'))
		      AND NVL(TO_DATE(:l_to_date,'DD/MM/YYYYHH24:MI:SS'),TO_DATE('01/01/400023:59:59','DD/MM/YYYYHH24:MI:SS'))
			  ORDER BY 10; */ 
 

	if(sqlca.sqlcode == -54) 
	{
		/*sprintf(d_err_code,"%5d",sqlca.sqlerrd[2]);
		disp_message(ERR_MESG,d_err_code);*/
        /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 12;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )376;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		proc_exit();
	}    

    if (OERROR)
    {
         err_mesg("DECLARE failed on cursor receipt_cursor",0,"");
    }


	fn_fix_receipt_dtls_var();	
	
	/* EXEC SQL OPEN receipt_cursor; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 12;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0014;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )391;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&lv_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&lv_episode_type;
 sqlstm.sqhstl[1] = (unsigned int  )4;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_doc_type_code;
 sqlstm.sqhstl[2] = (unsigned int  )9;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&l_to_doc_type_code;
 sqlstm.sqhstl[3] = (unsigned int  )12;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_doc_type_code;
 sqlstm.sqhstl[4] = (unsigned int  )9;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&d_doc_number;
 sqlstm.sqhstl[5] = (unsigned int  )11;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&l_to_doc_type_num;
 sqlstm.sqhstl[6] = (unsigned int  )12;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&d_doc_number;
 sqlstm.sqhstl[7] = (unsigned int  )11;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&l_fr_date;
 sqlstm.sqhstl[8] = (unsigned int  )32;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&l_to_date;
 sqlstm.sqhstl[9] = (unsigned int  )32;
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

 

    if (OERROR)
    {
         err_mesg("OPEN failed on cursor receipt_cursor",0,"");

    }	 
}

fn_fetch_receipt_dtls()
{

		fn_init_receipt_dtls_var();

		/* EXEC SQL fetch receipt_cursor into :lv_hosp_addr1,
									:lv_hosp_addr2,
									:lv_hosp_addr3,
									:lv_hosp_tel_num,
									:lv_sysdate,
									:lv_payer_name,
									:lv_doc_date,
									:lv_slmt_type,
									:lv_base_currency,
									:d_doc_type_code,
									:d_doc_number,
									:ld_doc_amt,
									:lv_ref_desc,
									:lv_ref_date,
									:lv_patient_id,
									:lv_doc_srno; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 16;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )446;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&lv_hosp_addr1;
  sqlstm.sqhstl[0] = (unsigned int  )33;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&lv_hosp_addr2;
  sqlstm.sqhstl[1] = (unsigned int  )33;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&lv_hosp_addr3;
  sqlstm.sqhstl[2] = (unsigned int  )33;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&lv_hosp_tel_num;
  sqlstm.sqhstl[3] = (unsigned int  )23;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&lv_sysdate;
  sqlstm.sqhstl[4] = (unsigned int  )33;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&lv_payer_name;
  sqlstm.sqhstl[5] = (unsigned int  )43;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&lv_doc_date;
  sqlstm.sqhstl[6] = (unsigned int  )33;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&lv_slmt_type;
  sqlstm.sqhstl[7] = (unsigned int  )18;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&lv_base_currency;
  sqlstm.sqhstl[8] = (unsigned int  )12;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&d_doc_type_code;
  sqlstm.sqhstl[9] = (unsigned int  )9;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&d_doc_number;
  sqlstm.sqhstl[10] = (unsigned int  )11;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&ld_doc_amt;
  sqlstm.sqhstl[11] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&lv_ref_desc;
  sqlstm.sqhstl[12] = (unsigned int  )23;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&lv_ref_date;
  sqlstm.sqhstl[13] = (unsigned int  )33;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&lv_patient_id;
  sqlstm.sqhstl[14] = (unsigned int  )23;
  sqlstm.sqhsts[14] = (         int  )0;
  sqlstm.sqindv[14] = (         void  *)0;
  sqlstm.sqinds[14] = (         int  )0;
  sqlstm.sqharm[14] = (unsigned int  )0;
  sqlstm.sqadto[14] = (unsigned short )0;
  sqlstm.sqtdso[14] = (unsigned short )0;
  sqlstm.sqhstv[15] = (         void  *)&lv_doc_srno;
  sqlstm.sqhstl[15] = (unsigned int  )5;
  sqlstm.sqhsts[15] = (         int  )0;
  sqlstm.sqindv[15] = (         void  *)0;
  sqlstm.sqinds[15] = (         int  )0;
  sqlstm.sqharm[15] = (unsigned int  )0;
  sqlstm.sqadto[15] = (unsigned short )0;
  sqlstm.sqtdso[15] = (unsigned short )0;
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


	if(sqlca.sqlcode == -54) 
	{
		/*sprintf(d_err_code,"%5d",sqlca.sqlerrd[2]);
		disp_message(ERR_MESG,d_err_code);*/
        /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 16;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )525;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		proc_exit();
	}   

    if (OERROR)
    {
         err_mesg("FETCH failed on cursor receipt_cursor",0,"");
    }


	fn_fix_receipt_dtls_var();		
	
	return(LAST_ROW?0:1); 
 
  }

close_receipt_cursor()
{
	/* EXEC SQL CLOSE receipt_cursor; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 16;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )540;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


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
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 16;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select ln1_mail_add ,ln2_mail_add ,ln3_mail_add ,mail_posta\
l_code into :b0,:b1,:b2,:b3  from mp_pat_other_dtls where patient_id=:b4";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )555;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
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



fn_fetch_outst_amt()
{
	
	/*
	EXEC SQL SELECT SUM(bill_tot_outst_amt)
			 INTO   :ld_outst_amt
			 FROM	bl_bill_hdr
			 WHERE  operating_facility_id = :lv_facility_id
			 AND    episode_type          = :lv_episode_type
			 AND	(doc_type_code, doc_num) 
					IN (SELECT all_doc_type_code, all_doc_num
						FROM   bl_patient_ledger
						WHERE  operating_facility_id = :lv_facility_id
						AND    episode_type          = :lv_episode_type
						AND	   org_doc_type_code     = :d_doc_type_code
						AND	   org_doc_num			 = :d_doc_number); 
      commented for PE CORRECTION	*/

	  /* EXEC SQL SELECT SUM(bill_tot_outst_amt)
			 INTO   :ld_outst_amt
			 FROM	bl_bill_hdr
			 WHERE  operating_facility_id = :lv_facility_id
			 AND    episode_type          = :lv_episode_type
			 AND PATIENT_ID=:lv_patient_id //ADDED PATIENT ID FOR PE CORRECTION
			 AND	(doc_type_code, doc_num) 
					IN (SELECT all_doc_type_code, all_doc_num
						FROM   bl_patient_ledger
						WHERE  operating_facility_id = :lv_facility_id
						AND    episode_type          = :lv_episode_type
						AND	   org_doc_type_code     = :d_doc_type_code
						AND	   org_doc_num			 = :d_doc_number); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 16;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select sum(bill_tot_outst_amt) into :b0  from bl_bill_hdr\
 where (((operating_facility_id=:b1 and episode_type=:b2) and PATIENT_ID=:b3)\
 and (doc_type_code,doc_num) in (select all_doc_type_code ,all_doc_num  from \
bl_patient_ledger where (((operating_facility_id=:b1 and episode_type=:b2) an\
d org_doc_type_code=:b6) and org_doc_num=:b7)))";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )590;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&ld_outst_amt;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
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
   sqlstm.sqhstv[2] = (         void  *)&lv_episode_type;
   sqlstm.sqhstl[2] = (unsigned int  )4;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&lv_patient_id;
   sqlstm.sqhstl[3] = (unsigned int  )23;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&lv_facility_id;
   sqlstm.sqhstl[4] = (unsigned int  )5;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&lv_episode_type;
   sqlstm.sqhstl[5] = (unsigned int  )4;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&d_doc_type_code;
   sqlstm.sqhstl[6] = (unsigned int  )9;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&d_doc_number;
   sqlstm.sqhstl[7] = (unsigned int  )11;
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

 
	
	if (OERROR)
		err_mesg("SELECT failed while fetching Outstanding Amount.", 0, "");

			
}

fn_open_file()
{
    strcpy(lc_filename, WORKING_DIR);
	strcat(lc_filename, "BLR00009.lis");

    if ((fp = fopen(lc_filename, "w")) == NULL)
    {
		disp_message(ERR_MESG, "Error in opening file BLR00009.lis");
		proc_exit();
    }
}

fn_print_header()
{
	fprintf(fp,"%c(s3B",ESC); 	// To set bold style
	strcpy(lc_lgnd_id, "0010"); //Report desc
	fn_get_legend();
	fprintf(fp, "\n %26s%s \n", "", lv_lgnd_val.arr); 
	fprintf(fp,"%c(s-3B",ESC);	// To release bold style

	
	fprintf(fp, "\n\n\n\n %s \n", lv_hosp_name.arr);
	fprintf(fp, " %s \n", nd_add_ln1.arr);
	fprintf(fp, " %s \n", nd_add_ln2.arr);
	fprintf(fp, " %s \n", nd_add_ln3.arr);
	   if(strcmp(nd_add_ln4.arr,"\0")!=0)
		  fprintf(fp, " %s \n", nd_add_ln4.arr);
	   if(strcmp(d_postal_code.arr,"\0")!=0)
		  fprintf(fp, " %s \n", d_postal_code.arr);
	   if(strcmp(d_res_area_code.arr,"\0")!=0)
		  fprintf(fp, " %s \n", d_res_area_code.arr);
	   if(strcmp(d_res_town_code.arr,"\0")!=0)
		  fprintf(fp, " %s \n", d_res_town_code.arr);
	   if(strcmp(d_region_code.arr,"\0")!=0)
		  fprintf(fp, " %s \n", d_region_code.arr);


	strcpy(lc_lgnd_id, "0020"); //Tel
	fn_get_legend();
	fprintf(fp, " %s: %s \n", lv_lgnd_val.arr, lv_hosp_tel_num.arr); 
   
   	strcpy(lc_lgnd_id, "0055"); //ref
    fn_get_legend();
    fprintf(fp, " %70s    %s:  \n", "", lv_lgnd_val.arr);

	strcpy(lc_lgnd_id, "0021"); //Date
	fn_get_legend();
	fprintf(fp, " %70s %s: %s \n\n\n", "", lv_lgnd_val.arr, lv_sysdate.arr);
	
	fprintf(fp, " %s \n", lv_payer_name.arr);
	fprintf(fp, " %s \n", lv_mail_addr1.arr);
	fprintf(fp, " %s \n", lv_mail_addr2.arr);
	fprintf(fp, " %s \n", lv_mail_addr3.arr);
	fprintf(fp, " %s \n", lv_mail_po_code.arr);
}

fn_print_body()
{		
	

	
	fn_format_amt_str(ld_doc_amt);

	strcpy(lc_lgnd_id, "0030"); //Sir/Madam
	fn_get_legend();
	
	fprintf(fp, "\n\n\n %s \n", lv_lgnd_val.arr);
	
	fn_format_doc_num(); 
	

	strcpy(lc_lgnd_id, "0031"); //Original Receipt No.
	fn_get_legend(); 

	
	fprintf(fp, "\n %s: %s/%s/%s\n", lv_lgnd_val.arr, d_doc_type_code.arr, d_doc_number.arr,lv_doc_srno.arr);
	
	strcpy(lc_lgnd_id, "0032"); //Dated
	fn_get_legend();
	fprintf(fp, "\n %s: %s \n", lv_lgnd_val.arr, lv_doc_date.arr);
	
	strcpy(lc_lgnd_id, "0033"); //With reference to the payment made through
	fn_get_legend();
	fprintf(fp, "\n\n\n %s %s \n", lv_lgnd_val.arr, lv_slmt_type.arr);

	strcpy(lc_lgnd_id, "0034"); //amounting to
	fn_get_legend();
	fprintf(fp, " %s %s %s", lv_lgnd_val.arr, lv_base_currency.arr, lc_char_amt);

	strcpy(lc_lgnd_id, "0035"); //received on
	fn_get_legend();
	fprintf(fp, " %s %s \n", lv_lgnd_val.arr, lv_doc_date.arr);

	strcpy(lc_lgnd_id, "0036"); //through reference
	fn_get_legend();
	fprintf(fp, " %s %s/%s \n", lv_lgnd_val.arr, lv_ref_desc.arr, lv_ref_date.arr); 
	
	fn_format_amt_str(ld_outst_amt);

	strcpy(lc_lgnd_id, "0037"); //1. Enclosed herewith the receipt for your keeping.
	fn_get_legend();
	fprintf(fp,"\n %s \n", lv_lgnd_val.arr);
	
	strcpy(lc_lgnd_id, "0038"); //2. Please pay the balance of
	fn_get_legend();
	fprintf(fp,"\n %s %s %s \n", lv_lgnd_val.arr, lv_base_currency.arr, lc_char_amt);
	
	strcpy(lc_lgnd_id, "0039"); //Thank You
	fn_get_legend();
	fprintf(fp,"\n\n\n %s. \n", lv_lgnd_val.arr);

	strcpy(lc_lgnd_id, "0040"); //Yours Sincerely
	fn_get_legend();
	fprintf(fp,"\n\n %s, \n", lv_lgnd_val.arr);

//	fprintf(fp,"\n\n\n\n (---------------------------------------) \n");
	fprintf(fp,"\n\n\n\n\n");
	strcpy(lc_lgnd_id, "0041"); //Administrative Division
	fn_get_legend();
	fprintf(fp," %s, \n", lv_lgnd_val.arr);

	strcpy(lc_lgnd_id, "0042"); //Revenue Unit
	fn_get_legend();
	fprintf(fp," (%s) \n", lv_lgnd_val.arr);

	strcpy(lc_lgnd_id, "0043"); //For
	fn_get_legend();
	fprintf(fp," %s, \n", lv_lgnd_val.arr);

	strcpy(lc_lgnd_id, "0044"); //Director
	fn_get_legend();
	fprintf(fp," %s, \n", lv_lgnd_val.arr);

	fprintf(fp," %s \n", lv_hosp_name.arr);
}

fn_print_footer()
{
	strcpy(lc_lgnd_id, "0045"); //Note
	fn_get_legend();
	fprintf(fp, "\n\n\n\n %s:", lv_lgnd_val.arr);
	
	strcpy(lc_lgnd_id, "0046"); //This notice is computer generated
	fn_get_legend();
	fprintf(fp, " %s.", lv_lgnd_val.arr);
	
	strcpy(lc_lgnd_id, "0047"); //No signature is required
	fn_get_legend();
	fprintf(fp, " %s.\n", lv_lgnd_val.arr);
}

fn_init_receipt_dtls_var()
{
	lv_hosp_addr1.arr[0]    = '\0';
	lv_hosp_addr2.arr[0]    = '\0';
	lv_hosp_addr3.arr[0]    = '\0';
	lv_hosp_tel_num.arr[0]  = '\0';
	lv_sysdate.arr[0]       = '\0';
	lv_payer_name.arr[0]    = '\0';
	lv_doc_date.arr[0]      = '\0';
	lv_slmt_type.arr[0]     = '\0';
	lv_base_currency.arr[0] = '\0';
	lv_ref_desc.arr[0]      = '\0';
	lv_ref_date.arr[0]      = '\0';
	lv_patient_id.arr[0]    = '\0'; 
	lv_doc_srno.arr[0]		= '\0';


	lv_hosp_addr1.len    = 0;
	lv_hosp_addr2.len    = 0;
	lv_hosp_addr3.len    = 0;
	lv_hosp_tel_num.len  = 0;
	lv_sysdate.len       = 0;
	lv_payer_name.len    = 0;
	lv_doc_date.len      = 0;
	lv_slmt_type.len     = 0;
	lv_base_currency.len = 0;
	lv_ref_desc.len      = 0;
	lv_ref_date.len      = 0;
	lv_patient_id.len    = 0; 
	lv_doc_srno.len		 = 0;
	
}	

fn_fix_receipt_dtls_var()
{
	lv_hosp_addr1.arr[lv_hosp_addr1.len]       = '\0';
	lv_hosp_addr2.arr[lv_hosp_addr2.len]       = '\0';
	lv_hosp_addr3.arr[lv_hosp_addr3.len]       = '\0';
	lv_hosp_tel_num.arr[lv_hosp_tel_num.len]   = '\0';
	lv_sysdate.arr[lv_sysdate.len]             = '\0';
	lv_payer_name.arr[lv_payer_name.len]       = '\0';
	lv_doc_date.arr[lv_doc_date.len]           = '\0';
	lv_slmt_type.arr[lv_slmt_type.len]         = '\0';
	lv_base_currency.arr[lv_base_currency.len] = '\0';
	lv_ref_desc.arr[lv_ref_desc.len]           = '\0';
	lv_ref_date.arr[lv_ref_date.len]           = '\0';
	lv_patient_id.arr[lv_patient_id.len]       = '\0'; 
	lv_doc_srno.arr[lv_doc_srno.len]		   = '\0';
	d_doc_type_code.arr[d_doc_type_code.len]   = '\0';
	d_doc_number.arr[d_doc_number.len]		   = '\0';

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
	char lc_actl_amt[15];
		
	puts_val(lc_actl_amt,ld_get_amt );
	
    formats_amt(lc_actl_amt);

	sprintf(lc_char_amt,"%10s",lc_actl_amt);
											 
}

fn_format_doc_num()
{
	/* EXEC SQL SELECT LPAD(:d_doc_number, 8, '0')
			 INTO   :lc_doc_num
			 FROM   DUAL; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 16;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select LPAD(:b0,8,'0') into :b1  from DUAL ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )637;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_doc_number;
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
	
	if (strcmp(lv_lang_id.arr, "en") == 0) 
	{
		/* EXEC SQL SELECT RTRIM(SUBSTR(dflt_legend_value, 1, 50))
				 INTO   :lv_lgnd_val
				 FROM   sm_lang_legend
				 WHERE  legend_id LIKE 'MLBLR00009.LEGEND_'||:lc_lgnd_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 16;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select RTRIM(SUBSTR(dflt_legend_value,1,50)) into :b0  fro\
m sm_lang_legend where legend_id like ('MLBLR00009.LEGEND_'||:b1)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )660;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
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
				 AND    legend_id LIKE 'MLBLR00009.LEGEND_'||:lc_lgnd_id
				 AND    language_id  = :lv_lang_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 16;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select RTRIM(SUBSTR(column_value,1,50)) into :b0  from sm_\
record_trans_data ,sm_lang_legend where (((((module_id='SM' and table_id='SM_\
LANG_LEGEND') and column_id='DFLT_LEGEND_VALUE') and pk_value=legend_id) and \
legend_id like ('MLBLR00009.LEGEND_'||:b1)) and language_id=:b2)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )683;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
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

fn_print_online()
{

	 /* EXEC SQL  select GET_TRACE_TIMESTAMP into :P_START_TIME from dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 16;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select GET_TRACE_TIMESTAMP into :b0  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )710;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&P_START_TIME;
  sqlstm.sqhstl[0] = (unsigned int  )62;
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

 //ADDED FOR PE CORRECTION

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

	/* EXEC SQL EXECUTE
			BEGIN	
				TRACE_DURATION_BL(
				:lv_pgm_id ,
				'Acknowledgement Letter for Receipt Printing' ,
				:P_START_TIME ,
				:uid );
			END;
			END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 16;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin TRACE_DURATION_BL ( :lv_pgm_id , 'Acknowledgement Let\
ter for Receipt Printing' , :P_START_TIME , :uid ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )729;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&lv_pgm_id;
 sqlstm.sqhstl[0] = (unsigned int  )12;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&P_START_TIME;
 sqlstm.sqhstl[1] = (unsigned int  )62;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&uid;
 sqlstm.sqhstl[2] = (unsigned int  )93;
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

fn_print_settings()
{
	fprintf(fp,"%c(s0P",ESC);		// To fix the primary spacing
	fprintf(fp,"%c&l0O",ESC); 		// To print in portait mode
	fprintf(fp,"%c(s4099T",ESC);	// To set the font name	
	fprintf(fp,"%c&l8D",ESC); 		// To set vertical lines per inch
	fprintf(fp,"%c&a2L",ESC); 		// To set the left margin
	fprintf(fp,"%c&l6E",ESC); 		// To set the top margin
	fprintf(fp,"%c(s12H",ESC); 		// To set the font
	
	//fprintf(fp,"%c&l0H",ESC);		// To eject page
	//fprintf(fp,"%cE",ESC);		// To reset the printer
	//fprintf(fp,"%c&d0D",ESC);		// To set underline mode
	//fprintf(fp,"%c&d@",ESC);		// To release underline mode
	//fprintf(fp,"%c(s3B",ESC); 	// To set bold style
	//fprintf(fp,"%c(s-3B",ESC);	// To release bold style

	
}



puts_val(str,num)
char *str;
double num;
{
	
				 

	strcpy(lc_facility_id.arr,lv_facility_id.arr);
	lc_facility_id.len = strlen(lc_facility_id.arr);
	
	
	/* EXEC SQL SELECT no_of_decimal
               INTO :l_no_of_decimal
	  		   FROM sm_acc_entity_param
              WHERE acc_entity_id = (SELECT acc_entity_code 
									   FROM sy_acc_entity
									  WHERE acc_entity_id = :lc_facility_id); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 16;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select no_of_decimal into :b0  from sm_acc_entity_param whe\
re acc_entity_id=(select acc_entity_code  from sy_acc_entity where acc_entity\
_id=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )756;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_no_of_decimal;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&lc_facility_id;
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



	//EXEC SQL SELECT to_char(:l_no_of_decimal) into :deci_val from dual;
	 

   	if (sqlca.sqlcode < 0) 
	{
        disp_message(ORA_MESG,"ERR_MESG: Select failed in sm_acc_entity_param");
      	/* EXEC SQL ROLLBACK WORK; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 16;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )779;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   	}

	if(l_no_of_decimal==3)
	{
		sprintf(str,"%14.3f",num);
	}
	else
	{
		sprintf(str,"%15.2f",num);
	}

	return str;

}



formats_amt(str)
char	*str;
{

		
	strcpy(lc_facility_id.arr,lv_facility_id.arr);
	lc_facility_id.len = strlen(lc_facility_id.arr);
	

	/* EXEC SQL SELECT no_of_decimal
               INTO :l_no_of_decimal
	  		   FROM sm_acc_entity_param
              WHERE acc_entity_id = (SELECT acc_entity_code 
									   FROM sy_acc_entity
									  WHERE acc_entity_id = :lc_facility_id); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 16;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select no_of_decimal into :b0  from sm_acc_entity_param whe\
re acc_entity_id=(select acc_entity_code  from sy_acc_entity where acc_entity\
_id=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )794;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_no_of_decimal;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&lc_facility_id;
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


      
      //EXEC SQL SELECT to_char(:l_no_of_decimal) into :deci_val from dual;
	   

 
   	if (sqlca.sqlcode < 0) 
	{
        disp_message(ORA_MESG,"ERR_MESG: Select failed in sm_acc_entity_param");
      	/* EXEC SQL ROLLBACK WORK; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 16;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )817;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   	}

	if(strlen(str) == 0)
	{
		if(l_no_of_decimal == 2)

		{
		
			strcpy(str, "0.00");
		}
		else if(l_no_of_decimal == 3)
		{

		
			strcpy(str, "0.000");
		}
	}
	else 
	{    
		
		u_ltrim(str);
		str = check_decimal(str,l_no_of_decimal);
		str = put_comma(str,l_no_of_decimal);
    }
	
	return str;
}
  