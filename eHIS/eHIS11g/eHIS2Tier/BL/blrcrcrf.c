
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/blrcrcrf.pc"
};


static unsigned int sqlctx = 1288466763;


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
            void  *sqhstv[13];
   unsigned int   sqhstl[13];
            int   sqhsts[13];
            void  *sqindv[13];
            int   sqinds[13];
   unsigned int   sqharm[13];
   unsigned int   *sqharc[13];
   unsigned short  sqadto[13];
   unsigned short  sqtdso[13];
} sqlstm = {12,13};

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
"select BLDCP_DOC_TYPE_CODE ,BLDCP_DOC_NUM ,TRUNC(BLDCP_DOC_DATE) ,SETT_AMT ,\
RECPT_DOC_TYPE_CODE ,RECPT_DOC_NUM  from BL_REC_REF_TEMP where (TRUNC(PGM_DATE\
)=:b0 and SESSION_ID=TO_NUMBER(:b1)) order by BLDCP_DOC_TYPE_CODE,BLDCP_DOC_NU\
M,BLDCP_DOC_DATE            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,119,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,293,0,4,151,0,0,13,2,0,1,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
103,0,0,3,154,0,4,206,0,0,5,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,1,9,0,0,
138,0,0,4,0,0,30,251,0,0,0,0,0,1,0,
153,0,0,5,102,0,2,260,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
176,0,0,6,80,0,2,273,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
199,0,0,7,260,0,9,297,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
222,0,0,7,0,0,13,367,0,0,6,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,9,
0,0,
261,0,0,8,69,0,4,398,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
284,0,0,9,164,0,4,424,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
311,0,0,10,96,0,4,459,0,0,3,1,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,
338,0,0,11,57,0,4,487,0,0,1,0,0,1,0,2,9,0,0,
};


/*****************************************************************************/
/*																	 */
/* PROGRAM      : 	BLRCRCRF.PC                 			                 */
/* Purpose		:	TO PRINT CONSILIDATE RECEIPT/REFUND						 */
/* Author		:	V.SRIKANTH                                               */
/* Date			:   13/04/2000                                               */
/* Modified		:	Changed by VSK to put total for the detail lines         */
/*                  printed on the consolidated receipt 01/07/2000           */
/*                                                                           */
/*****************************************************************************/
/*  UPGRADED TO 4.1   */ 
                      
#define ONLINE_PRINTING 1       
#define REP_WIDTH 80
#define EMPHASIZED_START 0x45
#define EMPHASIZED_END 0x46
#define UNDERLINE 0x2D
#define ESC 0x1B


#include <stdio.h>
#include <string.h>
#include <gl.h> 
#include <bl.h>

#define OERROR (sqlca.sqlcode < 0)
#define LAST_ROW (sqlca.sqlcode == 1403)
#define NO_DATA_FOUND (sqlca.sqlcode == 1403)
#define RESOURCE_BUSY        (sqlca.sqlcode == -54)
#define DUPLICATE_KEY        (sqlca.sqlcode == -1)
#define ROW_COUNT            (sqlca.sqlerrd[2])
#define	MAX_LINES   70

/* EXEC SQL BEGIN DECLARE SECTION; */ 


    /* VARCHAR uid_pwd					[95],
	    d_session_id				[16],
	    d_pgm_date					[14],
        rep_date					[20],
          comp_name					[50],
            oper_id					[21],
	    d_pgm_id	 				[10],
  	    cur_date					[11],
		nd_user						[31],
  	    cur_str						[8],
	    nd_operating_facility_id	[3],
		nd_calling_pgm_id			[30],
	    sub_cur_str					[8]; */ 
struct { unsigned short len; unsigned char arr[95]; } uid_pwd;

struct { unsigned short len; unsigned char arr[16]; } d_session_id;

struct { unsigned short len; unsigned char arr[14]; } d_pgm_date;

struct { unsigned short len; unsigned char arr[20]; } rep_date;

struct { unsigned short len; unsigned char arr[50]; } comp_name;

struct { unsigned short len; unsigned char arr[21]; } oper_id;

struct { unsigned short len; unsigned char arr[10]; } d_pgm_id;

struct { unsigned short len; unsigned char arr[11]; } cur_date;

struct { unsigned short len; unsigned char arr[31]; } nd_user;

struct { unsigned short len; unsigned char arr[8]; } cur_str;

struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[30]; } nd_calling_pgm_id;

struct { unsigned short len; unsigned char arr[8]; } sub_cur_str;


    /* VARCHAR d_patient_id				[21],
			d_cash_counter				[5],
			d_shift_id				[2],
			d_slmt_type_code			[3],
			d_slmt_doc_ref_desc			[21],
			d_slmt_doc_ref_date			[11],
			d_slmt_doc_remarks			[31],
	                d_slmt_short_desc           [41],  
			d_patient_name              [61],
			d_bldcp_doc_type			[7],
			d_bldcp_doc_num				[9],
			d_bldcp_doc_date			[11],
			d_recpt_doc_type			[7],
			d_recpt_doc_num				[9]; */ 
struct { unsigned short len; unsigned char arr[21]; } d_patient_id;

struct { unsigned short len; unsigned char arr[5]; } d_cash_counter;

struct { unsigned short len; unsigned char arr[2]; } d_shift_id;

struct { unsigned short len; unsigned char arr[3]; } d_slmt_type_code;

struct { unsigned short len; unsigned char arr[21]; } d_slmt_doc_ref_desc;

struct { unsigned short len; unsigned char arr[11]; } d_slmt_doc_ref_date;

struct { unsigned short len; unsigned char arr[31]; } d_slmt_doc_remarks;

struct { unsigned short len; unsigned char arr[41]; } d_slmt_short_desc;

struct { unsigned short len; unsigned char arr[61]; } d_patient_name;

struct { unsigned short len; unsigned char arr[7]; } d_bldcp_doc_type;

struct { unsigned short len; unsigned char arr[9]; } d_bldcp_doc_num;

struct { unsigned short len; unsigned char arr[11]; } d_bldcp_doc_date;

struct { unsigned short len; unsigned char arr[7]; } d_recpt_doc_type;

struct { unsigned short len; unsigned char arr[9]; } d_recpt_doc_num;

  
int         hl	 = 196,     
			vl	 = 179,
			tlc	 = 218,
			trc	 = 191,
			blc	 = 192,
			brc	 = 217,
			vlti = 195,
			vrti = 180,
			htti = 194,
			hbti = 193,
			plus = 197;
			
int nd_decimal = 2;

   double   d_tot_doc_amt, d_doc_amt, d_rf_tot;

char filename[150],string_var[150];

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

FILE *f1;

int page_no = 0,
    line_no;


void proc_main(argc,argv)
int argc;
char *argv[];
{

   void replicate();
   void replicate_vl();


    if(argc != 5) {
        disp_message(ERR_MESG,"BLRCRCRF : Usage BLRCRCRF userid/password session_id pgm_date facility_id \n");
        proc_exit();
    }


    strcpy(uid_pwd.arr,argv[1]);
    uid_pwd.len = strlen(uid_pwd.arr);

    strcpy(d_session_id.arr,argv[2]);
    d_session_id.len = strlen(d_session_id.arr);
    
    strcpy(d_pgm_date.arr,argv[3]);
    d_pgm_date.len = strlen(d_pgm_date.arr);

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
    sqlstm.sqhstl[0] = (unsigned int  )97;
    sqlstm.sqhsts[0] = (         int  )97;
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



    if(OERROR) {
		disp_message(ORA_MESG,"Unable to connect to oracle.\n");
		proc_exit();
    }

    set_meduser_role();

    d_patient_id.arr[0]  = '\0';
	d_cash_counter.arr[0]  = '\0';
	d_shift_id.arr[0]  = '\0';
	d_slmt_type_code.arr[0]  = '\0';
	d_slmt_doc_ref_desc.arr[0]  = '\0';
	d_slmt_doc_ref_date.arr[0]  = '\0';
	d_slmt_doc_remarks.arr[0]  = '\0';
	nd_operating_facility_id.arr[0]   = '\0';
	nd_calling_pgm_id.arr[0] = '\0';
    
	d_patient_id.len  = 0;
	d_cash_counter.len  = 0;
	d_shift_id.len  = 0;
	d_slmt_type_code.len  = 0;
	d_slmt_doc_ref_desc.len  = 0;
	d_slmt_doc_ref_date.len  = 0;
	d_slmt_doc_remarks.len  = 0;
	nd_operating_facility_id.len = 0;       
	nd_calling_pgm_id.len = 0;

	nd_user.arr[0] = '\0';
	nd_user.len = 0;

 	/* EXEC SQL SELECT
			 		OPERATING_FACILITY_ID,
					PARAM1,
					to_number(PARAM2),
					PARAM3,
					PARAM4,
					PARAM5,
					PARAM6,
					PARAM7,
					PARAM8,
					NVL(PARAM9,USER),
					NVL(PARAM10,'BLRCRCRF')
			 INTO   :nd_operating_facility_id,
					:d_patient_id,
					:d_tot_doc_amt,
					:d_cash_counter,
					:d_shift_id,
					:d_slmt_type_code,
					:d_slmt_doc_ref_desc,
					:d_slmt_doc_ref_date,
					:d_slmt_doc_remarks,
					:nd_user,
					:nd_calling_pgm_id
     		 FROM   SY_PROG_PARAM
			 WHERE  PGM_ID     = 'BLRCRCRF'
			 AND    PGM_DATE   = :d_pgm_date
			 AND    SESSION_ID = TO_NUMBER(:d_session_id); */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 13;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,to_number(PARAM2) ,PA\
RAM3 ,PARAM4 ,PARAM5 ,PARAM6 ,PARAM7 ,PARAM8 ,NVL(PARAM9,USER) ,NVL(PARAM10,'B\
LRCRCRF') into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10  from SY_PROG_PARA\
M where ((PGM_ID='BLRCRCRF' and PGM_DATE=:b11) and SESSION_ID=TO_NUMBER(:b12))";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )36;
  sqlstm.selerr = (unsigned short)1;
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
  sqlstm.sqhstv[1] = (         void  *)&d_patient_id;
  sqlstm.sqhstl[1] = (unsigned int  )23;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_tot_doc_amt;
  sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_cash_counter;
  sqlstm.sqhstl[3] = (unsigned int  )7;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_shift_id;
  sqlstm.sqhstl[4] = (unsigned int  )4;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_slmt_type_code;
  sqlstm.sqhstl[5] = (unsigned int  )5;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&d_slmt_doc_ref_desc;
  sqlstm.sqhstl[6] = (unsigned int  )23;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&d_slmt_doc_ref_date;
  sqlstm.sqhstl[7] = (unsigned int  )13;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&d_slmt_doc_remarks;
  sqlstm.sqhstl[8] = (unsigned int  )33;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&nd_user;
  sqlstm.sqhstl[9] = (unsigned int  )33;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&nd_calling_pgm_id;
  sqlstm.sqhstl[10] = (unsigned int  )32;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&d_pgm_date;
  sqlstm.sqhstl[11] = (unsigned int  )16;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&d_session_id;
  sqlstm.sqhstl[12] = (unsigned int  )18;
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


	
    	
    if(OERROR || NO_DATA_FOUND)
	    err_mesg("SELECT failed on table  SY_PROG_PARAM",0,"");

    
	d_patient_id.arr[d_patient_id.len]  = '\0';
	d_cash_counter.arr[d_cash_counter.len]  = '\0';
	d_shift_id.arr[d_shift_id.len]  = '\0';
	d_slmt_type_code.arr[d_slmt_type_code.len]  = '\0';
	d_slmt_doc_ref_desc.arr[d_slmt_doc_ref_desc.len]  = '\0';
	d_slmt_doc_ref_date.arr[d_slmt_doc_ref_date.len]  = '\0';
	d_slmt_doc_remarks.arr[d_slmt_doc_remarks.len]  = '\0';
	nd_operating_facility_id.arr[nd_operating_facility_id.len] = '\0';
	nd_user.arr[nd_user.len] = '\0';
	nd_calling_pgm_id.arr[nd_calling_pgm_id.len] = '\0';


    strcpy(g_facility_id,nd_operating_facility_id.arr);
    strcpy(filename,WORKING_DIR);
    strcat(filename,"blrcrcrf.lis");

    if((f1=fopen(filename,"w")) == NULL) 
    {
       disp_message(ERR_MESG,"Error in opening output file...\n");
       proc_exit();
    }

    /* EXEC SQL SELECT ACCOUNTING_NAME,
		            TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
                    USER,
					NVL(no_of_decimal,2)
	     INTO		:comp_name,
					:rep_date,
					:oper_id,
					:nd_decimal
		 FROM   SY_ACC_ENTITY
	     WHERE acc_entity_id = :nd_operating_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 13;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACCOUNTING_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:\
MI') ,USER ,NVL(no_of_decimal,2) into :b0,:b1,:b2,:b3  from SY_ACC_ENTITY wher\
e acc_entity_id=:b4";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )103;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&comp_name;
    sqlstm.sqhstl[0] = (unsigned int  )52;
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
    sqlstm.sqhstl[2] = (unsigned int  )23;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_decimal;
    sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_operating_facility_id;
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


		

    if(OERROR)
	    err_mesg("SELECT failed on table  SY_ACC_ENTITY",0,"");

    comp_name.arr[comp_name.len] = '\0';
    rep_date.arr[rep_date.len]   = '\0';
    oper_id.arr[oper_id.len]     = '\0';

    line_no=1;

    decl_curs();

    do_report();

    fclose(f1);

    del_parm();
	del_recref_tmp();
 
	PrintDocument
	   (
		uid_pwd.arr,		//char	*PUidPwd;
		d_session_id.arr,	//char	*PSessionID;
		nd_operating_facility_id.arr,	//char	*PFacilityID;
		"BL",				//char	*PModuleID;
		nd_calling_pgm_id.arr,			//char	*PDocumentID;
		filename,			//char	*POnlinePrintFileNames;
		"O",				//char	*PLocationTypes;
		"",				//char	*PLocationCodes;
		1,					//int		PNumOfCopies;
		1,					//int		PPageFrom;
		9999					//int		PPageTo;
	);

    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 13;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )138;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    return;
}

/*--- Delete the Sy_Prog_Param Record */

del_parm()
{

    /* EXEC SQL DELETE SY_PROG_PARAM
	         WHERE  PGM_ID     = 'BLRCRCRF'
			 AND    PGM_DATE   = :d_pgm_date
			 AND    SESSION_ID = TO_NUMBER(:d_session_id); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 13;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='BLRCRCRF' and\
 PGM_DATE=:b0) and SESSION_ID=TO_NUMBER(:b1))";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )153;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_pgm_date;
    sqlstm.sqhstl[0] = (unsigned int  )16;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_session_id;
    sqlstm.sqhstl[1] = (unsigned int  )18;
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



    if(OERROR) 
        err_mesg("DELETE failed on table SY_PROG_PARAM",0,""); 
}


del_recref_tmp()
{

    /* EXEC SQL DELETE BL_REC_REF_TEMP
	         WHERE  PGM_DATE   = :d_pgm_date
			 AND    SESSION_ID = TO_NUMBER(:d_session_id); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 13;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "delete  from BL_REC_REF_TEMP  where (PGM_DATE=:b0 and SES\
SION_ID=TO_NUMBER(:b1))";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )176;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_pgm_date;
    sqlstm.sqhstl[0] = (unsigned int  )16;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_session_id;
    sqlstm.sqhstl[1] = (unsigned int  )18;
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



    if(OERROR) 
        err_mesg("DELETE failed on table BL_REC_REF_TEMP",0,""); 
}

/*--- Declaring the Cursors */

decl_curs()
{		
		/* EXEC SQL DECLARE BL_REC_REF_TEMP_CUR CURSOR FOR
		SELECT		BLDCP_DOC_TYPE_CODE,    
					BLDCP_DOC_NUM,          
					TRUNC(BLDCP_DOC_DATE),         
					SETT_AMT,               
					RECPT_DOC_TYPE_CODE,    
					RECPT_DOC_NUM  
		FROM BL_REC_REF_TEMP
		WHERE  		TRUNC(PGM_DATE)  = :d_pgm_date AND
			        SESSION_ID = TO_NUMBER(:d_session_id)         
		ORDER BY BLDCP_DOC_TYPE_CODE,BLDCP_DOC_NUM,BLDCP_DOC_DATE; */ 

          
   /* EXEC SQL OPEN BL_REC_REF_TEMP_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 13;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0007;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )199;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqcmod = (unsigned int )0;
   sqlstm.sqhstv[0] = (         void  *)&d_pgm_date;
   sqlstm.sqhstl[0] = (unsigned int  )16;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_session_id;
   sqlstm.sqhstl[1] = (unsigned int  )18;
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



   if(OERROR)
	err_mesg("OPEN failed on cursor BL_REC_REF_TEMP_CUR",0,"");

}



/*--- Main procedure */

do_report()
{
	d_rf_tot = 0.0;
	fetch_patient_name();
    print_hdr();

    while(fetch_recref_temp_cur())
			print_rec();       
	
   	  
	fetch_slmt_type_desc();
	print_ftr();

}



/*--- Printing The Receipt/Refund lines  */

print_rec()
{
		
   char s_amt[20];
   
   print_formated(s_amt,d_doc_amt);
 
   chk_break(1);
   	
   fprintf(f1,"      %-6s/%-9s    %-10s  %15s    %-6s/%-9s\n",
				d_bldcp_doc_type.arr,d_bldcp_doc_num.arr,d_bldcp_doc_date.arr,
				s_amt,d_recpt_doc_type.arr,d_recpt_doc_num.arr);

   d_rf_tot += d_doc_amt;	

   line_no ++;
}


/*--- Fetching the Main Cursor */

fetch_recref_temp_cur()
{		


	d_bldcp_doc_type.arr[0]  = '\0';
	d_bldcp_doc_num.arr[0]  = '\0';
	d_bldcp_doc_date.arr[0]  = '\0';
	d_recpt_doc_type.arr[0]  = '\0';
	d_recpt_doc_num.arr[0]  = '\0';
	
	d_doc_amt = 0.0;

    d_bldcp_doc_type.len = 0;
	d_bldcp_doc_num.len = 0;
	d_bldcp_doc_date.len = 0;
	d_recpt_doc_type.len = 0;
	d_recpt_doc_num.len = 0;	
	

    /* EXEC SQL FETCH BL_REC_REF_TEMP_CUR INTO
					:d_bldcp_doc_type,
					:d_bldcp_doc_num,
					:d_bldcp_doc_date,
					:d_doc_amt,
					:d_recpt_doc_type,
					:d_recpt_doc_num; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 13;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )222;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_bldcp_doc_type;
    sqlstm.sqhstl[0] = (unsigned int  )9;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_bldcp_doc_num;
    sqlstm.sqhstl[1] = (unsigned int  )11;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_bldcp_doc_date;
    sqlstm.sqhstl[2] = (unsigned int  )13;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_doc_amt;
    sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_recpt_doc_type;
    sqlstm.sqhstl[4] = (unsigned int  )9;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_recpt_doc_num;
    sqlstm.sqhstl[5] = (unsigned int  )11;
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

				
	
    if(OERROR)
		err_mesg("FETCH failed on cursor BL_REC_REF_TEMP_CUR",0,"");

    if(NO_DATA_FOUND)
		return 0;
		
	d_bldcp_doc_type.arr[d_bldcp_doc_type.len]  = '\0';
	d_bldcp_doc_num.arr[d_bldcp_doc_num.len]  = '\0';
	d_bldcp_doc_date.arr[d_bldcp_doc_date.len]  = '\0';
	d_recpt_doc_type.arr[d_recpt_doc_type.len]  = '\0';
	d_recpt_doc_num.arr[d_recpt_doc_num.len]  = '\0';		

    return 1;

}

fetch_patient_name()
{		

	d_patient_name.arr[0]  = '\0';
	d_patient_name.len = 0;


    /* EXEC SQL SELECT SHORT_NAME INTO :d_patient_name
		     FROM MP_PATIENT_MAST
			 WHERE PATIENT_ID = :d_patient_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 13;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select SHORT_NAME into :b0  from MP_PATIENT_MAST where PA\
TIENT_ID=:b1";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )261;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_patient_name;
    sqlstm.sqhstl[0] = (unsigned int  )63;
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
		err_mesg("FETCH failed on cursor MP_PATIENT_MAST",0,"");

    if(NO_DATA_FOUND)
		return 0;
		
	d_patient_name.arr[d_patient_name.len]  = '\0';
    
	return 1;

}


fetch_slmt_type_desc()
{		


	d_slmt_short_desc.arr[0]  = '\0';
	d_slmt_short_desc.len = 0;


    /* EXEC SQL SELECT SHORT_DESC INTO :d_slmt_short_desc
		     FROM BL_SLMT_TYPE
			 WHERE SLMT_TYPE_CODE = :d_slmt_type_code
			 AND ACC_ENTITY_CODE IN ( SELECT acc_entity_code 
						  FROM sy_acc_entity
						  WHERE acc_entity_id = :nd_operating_facility_id); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 13;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select SHORT_DESC into :b0  from BL_SLMT_TYPE where (SLMT\
_TYPE_CODE=:b1 and ACC_ENTITY_CODE in (select acc_entity_code  from sy_acc_ent\
ity where acc_entity_id=:b2))";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )284;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_slmt_short_desc;
    sqlstm.sqhstl[0] = (unsigned int  )43;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_slmt_type_code;
    sqlstm.sqhstl[1] = (unsigned int  )5;
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


			
	
    if(OERROR)
		err_mesg("FETCH failed on cursor BL_SLMT_TYPE",0,"");

    if(NO_DATA_FOUND)
		return 0;
		
	d_slmt_short_desc.arr[d_slmt_short_desc.len]  = '\0';
    
	return 1;

}


/*--- Printing  Header  */

print_hdr()
{	
	char out_str[10][133];
    char s_tot_amt[20];	
    int  length_str[10];
    int  i = 0,no_of_lines = 0;

    cur_str.arr[0]   = '\0';
    cur_str.len      =  0;   
    sub_cur_str.arr[0]   = '\0';
    sub_cur_str.len      = 0;
   
    /* EXEC SQL SELECT BASE_CURRENCY,
                    BASE_CURRENCY_DEC 
             INTO   :cur_str,
			        :sub_cur_str
			 FROM   SY_ACC_ENTITY
	     WHERE ACC_ENTITY_ID = :nd_operating_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 13;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select BASE_CURRENCY ,BASE_CURRENCY_DEC into :b0,:b1  fro\
m SY_ACC_ENTITY where ACC_ENTITY_ID=:b2";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )311;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&cur_str;
    sqlstm.sqhstl[0] = (unsigned int  )10;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&sub_cur_str;
    sqlstm.sqhstl[1] = (unsigned int  )10;
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


    if (sqlca.sqlcode == 1403)
     err_mesg("No base currency in table SY_ACC_ENTITY",0,"");
    if (sqlca.sqlcode < 0)
     err_mesg("SELECT failed on table  SY_ACC_ENTITY",0,"");
   
    cur_str.arr[cur_str.len]  = '\0';
    sub_cur_str.arr[sub_cur_str.len] = '\0';

    length_str[0] = 45;
    for (i =1;i<10;i++)
      length_str[i] = 80;
    for (i =1;i<10;i++)
      strcpy(out_str[i],"");

	
    no_of_lines = print_in_words(d_tot_doc_amt<0?-d_tot_doc_amt:d_tot_doc_amt,MAX_LINES,sub_cur_str.arr,out_str,nd_decimal);

    if(strlen(out_str[1]))
       strcat(out_str[1],")");
    else
       strcat(out_str[0],")");
    
	/* EXEC SQL  SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY') INTO :cur_date FROM DUAL; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select TO_CHAR(SYSDATE,'DD/MM/YYYY') into :b0  from DUAL ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )338;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&cur_date;
 sqlstm.sqhstl[0] = (unsigned int  )13;
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



	fprintf(f1,"\n\n");
	fprintf(f1,"                              ");
	fprintf(f1,"%s",comp_name.arr);

	fprintf(f1,"\n\n\n");
	fprintf(f1,"                                                        ");
	fprintf(f1,"Date : %s\n\n",cur_date.arr);
	fprintf(f1,"                                                        ");
	fprintf(f1,"%s / %s / %s\n\n",nd_user.arr,d_cash_counter.arr,d_shift_id.arr);

	if (d_tot_doc_amt >= 0)
		print_formated(s_tot_amt,d_tot_doc_amt);
	else
		print_formated(s_tot_amt,d_tot_doc_amt * -1);

	if (d_tot_doc_amt >= 0)
	{
		fprintf(f1,"                            ");
		fprintf(f1,"      OFFICIAL RECEIPT\n");
		fprintf(f1,"                                  ");
		replicate(hl,16);
		fprintf(f1,"\n\n\n");
//		fprintf(f1,"                            ");
//		fprintf(f1,"      ----------------\n\n\n\n");
		fprintf(f1,"      RECEIVED FROM  %s\n",d_patient_name.arr);
		fprintf(f1,"                     ");
		replicate(hl,51);
		fprintf(f1,"\n");
		fprintf(f1,"                     %s\n\n",d_patient_id.arr);
		fprintf(f1,"      THE SUM OF %s : %s\n",cur_str.arr, s_tot_amt);
		fprintf(f1,"                             ");
		replicate(hl,43);
		fprintf(f1,"\n");
	}
	else
	{
		fprintf(f1,"                            ");
		fprintf(f1,"      REFUND ACKNOWLEDGEMENT\n");
		fprintf(f1,"                                  ");
		replicate(hl,22);
		fprintf(f1,"\n\n\n");
//		fprintf(f1,"      ----------------------\n\n\n\n");
		fprintf(f1,"      REFUNDED TO    %s\n",d_patient_name.arr);
		fprintf(f1,"                     ");
		replicate(hl,51);
		fprintf(f1,"\n");
		fprintf(f1,"                     %s\n\n\n",d_patient_id.arr);
		fprintf(f1,"      THE SUM OF %s : %s\n",cur_str.arr,s_tot_amt);
		fprintf(f1,"                             ");
		replicate(hl,43);
		fprintf(f1,"\n");
	}


	if(d_tot_doc_amt != 0)
    fprintf(f1,"      (%-6s ",cur_str.arr);
   
    if(d_tot_doc_amt == 0) 
    {
 		fprintf(f1,"      (%s ",out_str[0]);
    }
    else
		fprintf(f1,"%s",out_str[0]);
  
    fprintf(f1,"%s\n",out_str[1]);

    fprintf(f1,"      ");
	replicate(hl,66);
	fprintf(f1,"\n");

	fprintf(f1,"%c(s4B\n",ESC);/* This makes font Bold */
	fprintf(f1,"      AS PAYMENT OF / FOR BILLS AS DETAILED BELOW:\n\n");
	fprintf(f1,"%c(s-3B",ESC);/* This makes font Light */
    
	fprintf(f1,"      BILL NO.            DATE                 AMOUNT    REFERENCE\n");
	
	fprintf(f1,"      ");
	replicate(hl,66);
	fprintf(f1,"\n");

    line_no=27;
} 

/*--- Apply the Page Break */

chk_break(nol)
int nol;
{
	if(line_no+nol >= 40) 
	{
	  page_no++;
	  fprintf(f1,"      ");
 	  replicate(hl,66);
	  for (line_no;line_no<58;line_no++) fprintf(f1,"\n");
	  fprintf(f1,"                                                              Page : %d",page_no);
      fprintf(f1,"");
      line_no = 1;
	  print_hdr();
    }
}

/*--- Print End of Report Tag */

print_ftr()
{
    char s_rf_tot[20]; 

	print_formated(s_rf_tot,d_rf_tot);

	fprintf(f1,"                                       ");
	replicate(hl,15);
	fprintf(f1,"\n");
	//---------------\n");
	fprintf(f1,"                               Total  %15s\n",s_rf_tot);
	fprintf(f1,"      ");
	fprintf(f1,"               ");
	fprintf(f1,"                  ");
	replicate(hl,15);
	fprintf(f1,"\n");
	fprintf(f1,"      ");
	fprintf(f1,"PAYMENT DETAILS\n");
	fprintf(f1,"      ");
	replicate(hl,15);
	
	fprintf(f1,"\n");
	//---------------\n");
	
//	fprintf(f1,"      ---------------\n\n");
	fprintf(f1,"      TYPE      : %-15s\n",d_slmt_short_desc.arr);
	fprintf(f1,"      DETAILS   : %-2s   %-20s\n",d_slmt_type_code.arr,d_slmt_doc_ref_desc.arr);
	fprintf(f1,"                  %-10s\n",d_slmt_doc_ref_date.arr); 
	fprintf(f1,"                  %-30s\n\n\n",d_slmt_doc_remarks.arr);

	
	if (d_tot_doc_amt >= 0)
	{
	fprintf(f1,"  **THIS IS A COMPUTER GENERATED RECEIPT. THEREFORE NO SIGNATURE REQUIRED**\n\n");

	fprintf(f1,"                              N.B\n\n");
	fprintf(f1,"                              1. THIS RECEIPT IS NOT VALID UNLESS CHEQUE \n");
	fprintf(f1,"                                 IS CLEARED FOR PAYMENT.\n");
    fprintf(f1,"                              2. FOR MATERNITY PATIENTS, NO REFUND FOR \n");
	fprintf(f1,"                                 MATERNITY DEPOSIT.\n");
	fprintf(f1,"                              3. PATIENTS ARE KINDLY REQUESTED TO PRESENT \n");
	fprintf(f1,"                                 THIS DEPOSIT RECEIPT UPON DISCHARGE.\n");
	}
	else
	{
	fprintf(f1,"      ");
	replicate(hl,41);
	fprintf(f1,"\n");
	fprintf(f1,"         ");
	fprintf(f1,"SIGNATURE\n\n");
	fprintf(f1,"         ");
	fprintf(f1,"FULL NAME  ____________________________");
	
	fprintf(f1,"\n\n");
	fprintf(f1,"         ");
	fprintf(f1,"ID or Passport No. :\n\n");
	fprintf(f1,"      ");
	replicate(hl,41);

	}

    line_no+=19;
	page_no++;
	for (line_no;line_no<58;line_no++) fprintf(f1,"\n");
	fprintf(f1,"                                                                 Page : %d",page_no);
}


/*--------replicate a print character   -----*/

void replicate(printchar,no_of_times)
int printchar;
int no_of_times;
{
int i;
   for (i = 0; i < no_of_times; i++)
       fprintf(f1,"%c",printchar);
	return;
}

/*--------replicate a print character and changing the font hight  -----*/

void replicate_vl(printchar,no_of_times)
int printchar;
int no_of_times;
{
int i;
    for (i = 0; i < no_of_times; i++)
	    
	    fprintf(f1,"%c",printchar);
	   	          
  	return;
}

/*  ------end of replicate prg    ------*/


print_formated(s_amt, l_amt)
double l_amt;
char *s_amt;
{

  char str_amt[30], fstr_amt[30];

  if(l_amt < 0){  

	    put_val(s_amt,-l_amt);
        format_amt(s_amt);        
        sprintf(str_amt,"%14s",s_amt);				
		ltrim (str_amt);		
		rtrim (str_amt);		
		strcpy(fstr_amt,"(-)");
		strcat(fstr_amt,str_amt);		
		ltrim (fstr_amt);		
		rtrim (fstr_amt);
		strcpy(s_amt,fstr_amt);

   }
 else {
       put_val(s_amt,l_amt);
       format_amt(s_amt);
       strcat(s_amt," ");
    }
}


/*****************************************************************/

