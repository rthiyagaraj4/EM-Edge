
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/BLRBLSUM.PC"
};


static unsigned int sqlctx = 1288466867;


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
            void  *sqhstv[18];
   unsigned int   sqhstl[18];
            int   sqhsts[18];
            void  *sqindv[18];
            int   sqinds[18];
   unsigned int   sqharm[18];
   unsigned int   *sqharc[18];
   unsigned short  sqadto[18];
   unsigned short  sqtdso[18];
} sqlstm = {12,18};

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

 static const char *sq0005 = 
"select A.CUST_CODE ,A.BLNG_GRP_ID ,TO_CHAR(TRUNC(A.DOC_DATE),'DD-MON-YY') ,A\
.PATIENT_ID ,A.EPISODE_TYPE ,A.DOC_TYPE_CODE ,TO_CHAR(A.DOC_NUM,'00000009') ,T\
O_CHAR(A.EPISODE_ID) ,TO_CHAR(A.VISIT_ID) ,NVL(A.BILL_TOT_AMT,0) ,NVL(A.BILL_T\
OT_OUTST_AMT,0) ,CREDIT_DOC_REF_DESC ,TO_CHAR(CREDIT_DOC_REF_DATE,'DD/MM/RRRR'\
) ,ADDED_BY_ID ,TO_CHAR(ADDED_DATE,'DD/MM/RRRR HH24:MI') ,NVL(BILL_TOT_ADJUST_\
AMT,0) ,NVL(BILL_TOT_EXEMPT_AMT,0) ,NVL(BILL_TOT_WRITE_OFF_AMT,0)  from BL_BIL\
L_HDR A where (((((((A.OPERATING_FACILITY_ID=:b0 and TRUNC(A.DOC_DATE) between\
 TO_DATE(nvl(:b1,'01/01/0001'),'dd/mm/yyyy') and TO_DATE(nvl(:b2,'31/12/4712')\
,'dd/mm/yyyy')) and A.BILL_NATURE_CODE=:b3) and A.BILL_STATUS is null ) and A.\
BILL_TOT_OUTST_AMT<>0) and A.BLNG_GRP_ID between nvl(:b4,'!!') and nvl(:b5,'~~\
')) and NVL(A.CUST_CODE,NVL(:b6,'!!!!!!!!')) between NVL(:b6,'!!!!!!!!') and N\
VL(:b8,'~~~~~~~~')) and NVL(A.EPISODE_TYPE,'X')=DECODE(:b9,'A',A.EPISODE_TYPE,\
:b9)) order by A.CUST_CODE,A.BLNG_GRP_ID,TRUNC(A.DOC_DATE),A.DOC_NUM          \
  ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,152,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,30,227,0,0,0,0,0,1,0,
51,0,0,3,240,0,4,301,0,0,12,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
114,0,0,4,84,0,2,340,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
141,0,0,5,1014,0,9,393,0,0,11,11,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
200,0,0,5,0,0,13,428,0,0,18,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,4,0,0,2,4,0,0,2,4,0,0,
287,0,0,6,128,0,4,696,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
318,0,0,7,66,0,4,739,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
341,0,0,8,76,0,4,749,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
364,0,0,9,182,0,4,773,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
395,0,0,10,503,0,6,786,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,3,9,0,0,
422,0,0,11,96,0,4,827,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
445,0,0,12,165,0,6,834,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
476,0,0,13,223,0,6,853,0,0,3,3,0,1,0,3,9,0,0,1,9,0,0,1,9,0,0,
503,0,0,14,110,0,6,895,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
530,0,0,15,111,0,6,924,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
557,0,0,16,122,0,6,953,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.0                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLRBLREG.PC                                  */
/*                         Bills Outstanding Report                     */
/* AUTHOR                : S. SRIRAM                                    */
/* Converted To Windows  : Prasad B G S          4/7/96                 */
/* DATE WRITTEN          : 26-AUG-1993                                  */  
/* DATE MODIFIED         : 19-MAR-1997  for AMH/by PVSS Prasad          */
/* DATE MODIFIED         : 23-MAR-1997  CUST_CODE range/by PVSS Prasad  */
/* DATE MODIFIED         : 26-MAY-1997  pagebreak problem/by PVSS Prasad*/
/*                                                                      */
/* CALLED FROM           :                                              */
/*                                                                      */
/*  FUNCTION             :                                              */
/*                                                                      */
/*  TABLE DETAILS                                                       */
/*                                                                      */
/*        S. No.       TABLENAMES             INPUT/OUTPUT              */
/*                                                                      */
/*                                                                      */
/*  PARAMETERS           :            -                                 */
/*                                                                      */
/*  SUBROUTINES          :                                              */
/*                                                                      */
/*         1.        ERR_MESG            err_mesg                       */
/************************************************************************/

#include <stdio.h>
#include <string.h>            
#include <bl.h>     

#define OERROR (sqlca.sqlcode < 0)
#define LAST_ROW (sqlca.sqlcode == 1403)
#define NOT_FOUND (sqlca.sqlerrd[2] == 0)
#define RESOURCE_BUSY        (sqlca.sqlcode == -54)
#define DUPLICATE_KEY        (sqlca.sqlcode == -1)
#define ROW_COUNT            (sqlca.sqlerrd[2])
#define INIT_MESG "Report generation in progress... "
#define MAX_LINES			55

/*
#define DEBUG 0
*/


/* EXEC SQL BEGIN DECLARE SECTION; */ 


    /* VARCHAR hosp_name                                  [120],
            date_time                                  [20],
            user_id                                    [91],
			nd_pwd									   [100],
            nd_session_id                              [16],
			nd_temp_date                               [20],
			date_convert                               [20],
			nd_loc_date                                [20],
            nd_pgm_date                                [25],
            d_curr_pgm_name                            [15], 
			p_language_id                              [3],
            nd_fm_date                                 [20],
            nd_to_date                                 [20],
            nd_epi_type                                [2],
            
            nd_fr_bill_id                              [3],
            nd_to_bill_id                              [3],
            nd_bill_nature                             [2],

            nd_fr_cust_code                            [9],
            nd_to_cust_code                            [9],

			nd_operating_facility_id				   [3],
            
			bl_hdr_cust_code						   [9],
			bl_hdr_cust_code_brk					   [9],
            bl_hdr_blng_grp_id                         [3],
			bl_hdr_doc_date                            [13],
			l_credit_doc_ref_desc						[35],
			l_credit_doc_ref_date						[20],
			l_added_by_id								[35],
			l_added_date								[30],

			 

			bl_blng_desc                               [16],
			bl_cust_desc							   [41],
            d_short_name_full                                [61],
            d_short_name                               [61], 
			d_short_name1                              [31], 
            bl_hdr_blng_grp_id_brk                     [3],
            d_episode_type                             [2],
            bl_patient_id                              [21],
            d_episode_id                               [9],
            d_visit_id                                 [5],
            d_doc_type                                 [7],
            d_doc_num                                  [9],
			l_pk_value								   [100],
	 	    l_translated_value						   [201],
		    nd_facility_id							   [3]; */ 
struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[91]; } user_id;

struct { unsigned short len; unsigned char arr[100]; } nd_pwd;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[20]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[20]; } date_convert;

struct { unsigned short len; unsigned char arr[20]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[20]; } nd_fm_date;

struct { unsigned short len; unsigned char arr[20]; } nd_to_date;

struct { unsigned short len; unsigned char arr[2]; } nd_epi_type;

struct { unsigned short len; unsigned char arr[3]; } nd_fr_bill_id;

struct { unsigned short len; unsigned char arr[3]; } nd_to_bill_id;

struct { unsigned short len; unsigned char arr[2]; } nd_bill_nature;

struct { unsigned short len; unsigned char arr[9]; } nd_fr_cust_code;

struct { unsigned short len; unsigned char arr[9]; } nd_to_cust_code;

struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[9]; } bl_hdr_cust_code;

struct { unsigned short len; unsigned char arr[9]; } bl_hdr_cust_code_brk;

struct { unsigned short len; unsigned char arr[3]; } bl_hdr_blng_grp_id;

struct { unsigned short len; unsigned char arr[13]; } bl_hdr_doc_date;

struct { unsigned short len; unsigned char arr[35]; } l_credit_doc_ref_desc;

struct { unsigned short len; unsigned char arr[20]; } l_credit_doc_ref_date;

struct { unsigned short len; unsigned char arr[35]; } l_added_by_id;

struct { unsigned short len; unsigned char arr[30]; } l_added_date;

struct { unsigned short len; unsigned char arr[16]; } bl_blng_desc;

struct { unsigned short len; unsigned char arr[41]; } bl_cust_desc;

struct { unsigned short len; unsigned char arr[61]; } d_short_name_full;

struct { unsigned short len; unsigned char arr[61]; } d_short_name;

struct { unsigned short len; unsigned char arr[31]; } d_short_name1;

struct { unsigned short len; unsigned char arr[3]; } bl_hdr_blng_grp_id_brk;

struct { unsigned short len; unsigned char arr[2]; } d_episode_type;

struct { unsigned short len; unsigned char arr[21]; } bl_patient_id;

struct { unsigned short len; unsigned char arr[9]; } d_episode_id;

struct { unsigned short len; unsigned char arr[5]; } d_visit_id;

struct { unsigned short len; unsigned char arr[7]; } d_doc_type;

struct { unsigned short len; unsigned char arr[9]; } d_doc_num;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;


            

double     bl_hdr_bill_tot_amt_db = 0,
           bl_hdr_bill_tot_outst_amt = 0,
           gr_tot_amt = 0,
           brk1_tot_amt = 0,
           brk1_tot_outst_amt = 0,    
           gr_tot_outst_amt,
      	   bl_hdr_bill_tot_adjust_amt, //EPNH 28/10/2004
	   bl_hdr_bill_tot_exempt_amt,
           bl_hdr_bill_tot_write_off_amt; 

	int i;
	
	char g_facility_id[3];

    char filename[150];
	char x_msg[200];
	char loc_legend[999][201];
	char l_mesg[200];


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

int    lctr = 0,pctr = 0, tot_rec = 0;

FILE *fp;  

void proc_main(argc,argv)
char *argv[];
int argc;
{   
    void print_detl(),
         get_blng_desc();
    int rec_left;
    if (argc < 5)
    {
      int i = 0;
      disp_message(ERR_MESG,"Not enough Parameters for running this program");
      proc_exit();
    }
 
    strcpy(g_pgm_id,"BLRBLSUM");


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
  sqlstm.sqhstl[0] = (unsigned int  )102;
  sqlstm.sqhsts[0] = (         int  )102;
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

    strcpy(d_curr_pgm_name.arr,g_pgm_id); 
    d_curr_pgm_name.len = strlen(d_curr_pgm_name.arr); 

    strcpy(nd_session_id.arr,argv[2]);
    nd_session_id.len = strlen(nd_session_id.arr);
    strcpy(g_session_id,nd_session_id.arr);
	 
    		strcpy(p_language_id.arr,l_language_id.arr);
		p_language_id.len = l_language_id.len;

    strcpy(nd_pgm_date.arr,argv[3]);
    nd_pgm_date.len = strlen(nd_pgm_date.arr);  
    strcpy(g_pgm_date,nd_pgm_date.arr); 
	
	strcpy(nd_facility_id.arr,argv[4]);
    nd_facility_id.len = strlen(nd_facility_id.arr);
    strcpy(g_facility_id,nd_facility_id.arr); 

    set_meduser_role();
  
    start_prog_msg();

	fetch_legend_value();

    fetch_prog_param();
    declare_cur();
    fetch_hosp_name();
    open_file();
    open_hdr();
    
    rec_left = fetch_hdr();
    if (rec_left) print_brk1_hdr(FALSE);
    while(rec_left)
     {
       strcpy(bl_hdr_cust_code_brk.arr,bl_hdr_cust_code.arr);
       strcpy(bl_hdr_blng_grp_id_brk.arr,bl_hdr_blng_grp_id.arr);
 	   print_detl(); 
       tot_rec++;     	  
 	   lctr += 2; //EPNH 28/10/2004
 	   if(lctr >= MAX_LINES)
	   {
    	  fprintf(fp,"");
    	  print_head();
   	      print_brk1_hdr(FALSE);
   		 }
   		 
	    /*--------------------------- read the next cursor record --------------------*/
    	rec_left = fetch_hdr();
    	if (((strcmp(bl_hdr_blng_grp_id_brk.arr,bl_hdr_blng_grp_id.arr)!= 0)  ||
    	    (strcmp(bl_hdr_cust_code_brk.arr,bl_hdr_cust_code.arr)!= 0) 
        	) && rec_left){
        	if(lctr + 2 >= MAX_LINES){
           		fprintf(fp,"");
           		print_head();
          		} 
   	      print_brk1_hdr(TRUE);
     	  } 
  	 }       

    if (tot_rec)
     {
      print_brk1_tot();
      print_grand_tot();
     }
    end_of_rep();
    end_prog_msg();

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
print_brk1_hdr(break_tot)
int break_tot;
{
    if (break_tot)
       print_brk1_tot();

    if (lctr + 2 > MAX_LINES) {
           		fprintf(fp,"");
           		print_head();
        }                               
                               
    get_blng_desc(); 
/*     
    if (bl_hdr_cust_code.len) 
*/    
      fprintf(fp,"%8s : %-8.8s %-40.40s \t %13s : %-2s %-15s\n\n",loc_legend[270],
      				bl_hdr_cust_code.arr,bl_cust_desc.arr,
                 	loc_legend[260],bl_hdr_blng_grp_id.arr,bl_blng_desc.arr);
/*
     else                	
      fprintf(fp,"%13s : %-2s %-15s\n\n",loc_legend[260],
                	bl_hdr_blng_grp_id.arr,bl_blng_desc.arr);
*/
                	
    lctr += 2;
}

print_brk1_tot()
{
    if (lctr + 3 > MAX_LINES) {
   	  fprintf(fp,"");
      print_head(0);
      }

    fprintf(fp,"                                                                                                                                                         ------------------------------------\n");
    fprintf(fp,"%9s                                                                                                                                              ",loc_legend[330]);
    print_formated(brk1_tot_amt, fp);  
    fprintf(fp,"     ");
    print_formated(brk1_tot_outst_amt, fp);  
    fprintf(fp,"\n");
    fprintf(fp,"                                                                                                                                                         ------------------------------------\n");

    lctr += 3;  
    brk1_tot_amt		= 0;
 	brk1_tot_outst_amt	= 0;
              
}  

fetch_prog_param()
{
    nd_fm_date.arr[0]                   = '\0';
    nd_to_date.arr[0]                   = '\0';
    nd_fr_bill_id.arr[0]                = '\0';
    nd_to_bill_id.arr[0]                = '\0';
    nd_epi_type.arr[0]                  = '\0';
    nd_bill_nature.arr[0]               = '\0';
    nd_fr_cust_code.arr[0]              = '\0';
    nd_to_cust_code.arr[0]              = '\0';
    

    nd_fm_date.len                      = 0;
    nd_to_date.len                      = 0;
    nd_fr_bill_id.len                   = 0;
    nd_to_bill_id.len                   = 0;
    nd_epi_type.len                     = 0;
    nd_bill_nature.len                  = 0; 
    nd_fr_cust_code.len                 = 0; 
    nd_to_cust_code.len                 = 0; 
        
   /* EXEC SQL SELECT 
				OPERATING_FACILITY_ID,
				PARAM1,PARAM2,PARAM3,
				ltrim(rtrim(PARAM4)),
				ltrim(rtrim(PARAM5)),PARAM6,PARAM7,PARAM8
				INTO 
				 :nd_operating_facility_id,
				 :nd_epi_type,
            	 :nd_fr_bill_id,
                 :nd_to_bill_id,
                 :nd_fm_date,
                 :nd_to_date,
                 :nd_bill_nature, 
                 :nd_fr_cust_code,
   				 :nd_to_cust_code

            FROM SY_PROG_PARAM
            WHERE PGM_ID     = :d_curr_pgm_name
            AND SESSION_ID = :nd_session_id
            AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,ltri\
m(rtrim(PARAM4)) ,ltrim(rtrim(PARAM5)) ,PARAM6 ,PARAM7 ,PARAM8 into :b0,:b1,:b\
2,:b3,:b4,:b5,:b6,:b7,:b8  from SY_PROG_PARAM where ((PGM_ID=:b9 and SESSION_I\
D=:b10) and PGM_DATE=:b11)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )51;
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
   sqlstm.sqhstv[1] = (         void  *)&nd_epi_type;
   sqlstm.sqhstl[1] = (unsigned int  )4;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_fr_bill_id;
   sqlstm.sqhstl[2] = (unsigned int  )5;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_to_bill_id;
   sqlstm.sqhstl[3] = (unsigned int  )5;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_fm_date;
   sqlstm.sqhstl[4] = (unsigned int  )22;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_to_date;
   sqlstm.sqhstl[5] = (unsigned int  )22;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_bill_nature;
   sqlstm.sqhstl[6] = (unsigned int  )4;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_fr_cust_code;
   sqlstm.sqhstl[7] = (unsigned int  )11;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_to_cust_code;
   sqlstm.sqhstl[8] = (unsigned int  )11;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&d_curr_pgm_name;
   sqlstm.sqhstl[9] = (unsigned int  )17;
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
   sqlstm.sqhstv[11] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[11] = (unsigned int  )27;
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



   if (OERROR)
        err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   if (NOT_FOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");

   nd_epi_type.arr[nd_epi_type.len]                   = '\0';
   nd_fm_date.arr[nd_fm_date.len]                     = '\0';
   nd_to_date.arr[nd_to_date.len]                     = '\0';
   nd_fr_bill_id.arr[nd_fr_bill_id.len]               = '\0';
   nd_to_bill_id.arr[nd_to_bill_id.len]               = '\0';
   nd_bill_nature.arr[nd_bill_nature.len]             = '\0';
   nd_fr_cust_code.arr[nd_fr_cust_code.len]           = '\0';
   nd_to_cust_code.arr[nd_to_cust_code.len]           = '\0';
   
   strcpy(g_facility_id, nd_operating_facility_id.arr);


   /* EXEC SQL DELETE SY_PROG_PARAM
            WHERE PGM_ID     = :d_curr_pgm_name
            AND SESSION_ID = :nd_session_id
            AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID=:b0 and SESSION\
_ID=:b1) and PGM_DATE=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )114;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_curr_pgm_name;
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
                                     
declare_cur()
{

     /* EXEC SQL DECLARE BL_BILL_HDR_CUR CURSOR FOR
               SELECT A.CUST_CODE,
               		  A.BLNG_GRP_ID,
                      TO_CHAR(TRUNC(A.DOC_DATE),'DD-MON-YY'),
					  A.PATIENT_ID,
                      A.EPISODE_TYPE,
                      A.DOC_TYPE_CODE,
                      TO_CHAR(A.DOC_NUM,'00000009'),
                      TO_CHAR(A.EPISODE_ID),   
                      TO_CHAR(A.VISIT_ID),
                      NVL(A.BILL_TOT_AMT,0),
					  NVL(A.BILL_TOT_OUTST_AMT,0),
					  CREDIT_DOC_REF_DESC,
					  TO_CHAR(CREDIT_DOC_REF_DATE,'DD/MM/RRRR'),
					  ADDED_BY_ID,
					  //TO_CHAR(ADDED_DATE,'DD/MM/RRRR HH24:MI:SS'),
					  TO_CHAR(ADDED_DATE,'DD/MM/RRRR HH24:MI'),
					  NVL(BILL_TOT_ADJUST_AMT,0),   // EPNH 28/10/2004  
                                          NVL(BILL_TOT_EXEMPT_AMT,0),    
                                          NVL(BILL_TOT_WRITE_OFF_AMT,0)  
               FROM BL_BILL_HDR A
               WHERE A.OPERATING_FACILITY_ID = :nd_operating_facility_id
			   AND   TRUNC(A.DOC_DATE) BETWEEN
                     TO_DATE(nvl(:nd_fm_date,'01/01/0001'),'dd/mm/yyyy')
			   AND   TO_DATE(nvl(:nd_to_date,'31/12/4712'),'dd/mm/yyyy')
			   AND   A.BILL_NATURE_CODE = :nd_bill_nature 
			   AND   A.BILL_STATUS IS NULL 
			   AND   A.BILL_TOT_OUTST_AMT != 0
			   AND   A.BLNG_GRP_ID BETWEEN nvl(:nd_fr_bill_id,'!!') AND nvl(:nd_to_bill_id,'~~')
               AND   NVL(A.CUST_CODE,NVL(:nd_fr_cust_code,'!!!!!!!!')) 
 			         BETWEEN  
                     NVL(:nd_fr_cust_code,'!!!!!!!!') 
               AND   NVL(:nd_to_cust_code,'~~~~~~~~')                                                     
			   AND   NVL(A.EPISODE_TYPE,'X') = DECODE(:nd_epi_type, 'A', A.EPISODE_TYPE, :nd_epi_type) //CHANGED ON 9/5/2005 
               ORDER BY A.CUST_CODE, A.BLNG_GRP_ID, TRUNC(A.DOC_DATE), A.DOC_NUM; */ 

              
}

open_hdr()
{
    /* EXEC SQL OPEN BL_BILL_HDR_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0005;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )141;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_fm_date;
    sqlstm.sqhstl[1] = (unsigned int  )22;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_to_date;
    sqlstm.sqhstl[2] = (unsigned int  )22;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_bill_nature;
    sqlstm.sqhstl[3] = (unsigned int  )4;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_fr_bill_id;
    sqlstm.sqhstl[4] = (unsigned int  )5;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_to_bill_id;
    sqlstm.sqhstl[5] = (unsigned int  )5;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_fr_cust_code;
    sqlstm.sqhstl[6] = (unsigned int  )11;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_fr_cust_code;
    sqlstm.sqhstl[7] = (unsigned int  )11;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_to_cust_code;
    sqlstm.sqhstl[8] = (unsigned int  )11;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&nd_epi_type;
    sqlstm.sqhstl[9] = (unsigned int  )4;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&nd_epi_type;
    sqlstm.sqhstl[10] = (unsigned int  )4;
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


    if (OERROR)
         err_mesg("OPEN failed on cursor BL_BILL_HDR_CUR",0,"");
}

fetch_hdr()
{
	bl_hdr_cust_code.arr[0]                                          = '\0';
	bl_hdr_blng_grp_id.arr[0]                                        = '\0';
	bl_hdr_doc_date.arr[0]                                           = '\0';
	d_episode_id.arr[0]                                              = '\0';
	d_visit_id.arr[0]                                                = '\0';
	d_doc_type.arr[0]                                                = '\0';
	d_doc_num.arr[0]                                                 = '\0';
	l_credit_doc_ref_desc.arr[0]									 = '\0';
	l_credit_doc_ref_date.arr[0]									 = '\0';
	l_added_by_id.arr[0]											 = '\0';		
	l_added_date.arr[0]												 = '\0';

	bl_hdr_cust_code.len	                                         = 0;
	bl_hdr_blng_grp_id.len                                           = 0;
	bl_hdr_doc_date.len                                              = 0;
	d_episode_id.len                                                 = 0;
	d_visit_id.len                                                   = 0;
	d_doc_type.len                                                   = 0;
	d_doc_num.len                                                    = 0;
	l_credit_doc_ref_desc.len										 = 0;
	l_credit_doc_ref_date.len										 = 0;
	l_added_by_id.len												 = 0;		
	l_added_date.len												 = 0;

	bl_hdr_bill_tot_amt_db                                           = 0;
	bl_hdr_bill_tot_outst_amt                                        = 0; 


      /* EXEC SQL FETCH BL_BILL_HDR_CUR INTO  
               		 :bl_hdr_cust_code,
               		 :bl_hdr_blng_grp_id,
                     :bl_hdr_doc_date,
                     :bl_patient_id,
                     :d_episode_type, 
                     :d_doc_type,
                     :d_doc_num,
                     :d_episode_id,
                     :d_visit_id, 
                     :bl_hdr_bill_tot_amt_db,                           
                     :bl_hdr_bill_tot_outst_amt,
					 :l_credit_doc_ref_desc,
					 :l_credit_doc_ref_date,
					 :l_added_by_id,
					 :l_added_date,
        	 	    	         :bl_hdr_bill_tot_adjust_amt, //EPNH 28/10/2004
                                         :bl_hdr_bill_tot_exempt_amt, 
                                         :bl_hdr_bill_tot_write_off_amt; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 12;
      sqlstm.arrsiz = 18;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )200;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)4352;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqfoff = (           int )0;
      sqlstm.sqfmod = (unsigned int )2;
      sqlstm.sqhstv[0] = (         void  *)&bl_hdr_cust_code;
      sqlstm.sqhstl[0] = (unsigned int  )11;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&bl_hdr_blng_grp_id;
      sqlstm.sqhstl[1] = (unsigned int  )5;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&bl_hdr_doc_date;
      sqlstm.sqhstl[2] = (unsigned int  )15;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&bl_patient_id;
      sqlstm.sqhstl[3] = (unsigned int  )23;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&d_episode_type;
      sqlstm.sqhstl[4] = (unsigned int  )4;
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&d_doc_type;
      sqlstm.sqhstl[5] = (unsigned int  )9;
      sqlstm.sqhsts[5] = (         int  )0;
      sqlstm.sqindv[5] = (         void  *)0;
      sqlstm.sqinds[5] = (         int  )0;
      sqlstm.sqharm[5] = (unsigned int  )0;
      sqlstm.sqadto[5] = (unsigned short )0;
      sqlstm.sqtdso[5] = (unsigned short )0;
      sqlstm.sqhstv[6] = (         void  *)&d_doc_num;
      sqlstm.sqhstl[6] = (unsigned int  )11;
      sqlstm.sqhsts[6] = (         int  )0;
      sqlstm.sqindv[6] = (         void  *)0;
      sqlstm.sqinds[6] = (         int  )0;
      sqlstm.sqharm[6] = (unsigned int  )0;
      sqlstm.sqadto[6] = (unsigned short )0;
      sqlstm.sqtdso[6] = (unsigned short )0;
      sqlstm.sqhstv[7] = (         void  *)&d_episode_id;
      sqlstm.sqhstl[7] = (unsigned int  )11;
      sqlstm.sqhsts[7] = (         int  )0;
      sqlstm.sqindv[7] = (         void  *)0;
      sqlstm.sqinds[7] = (         int  )0;
      sqlstm.sqharm[7] = (unsigned int  )0;
      sqlstm.sqadto[7] = (unsigned short )0;
      sqlstm.sqtdso[7] = (unsigned short )0;
      sqlstm.sqhstv[8] = (         void  *)&d_visit_id;
      sqlstm.sqhstl[8] = (unsigned int  )7;
      sqlstm.sqhsts[8] = (         int  )0;
      sqlstm.sqindv[8] = (         void  *)0;
      sqlstm.sqinds[8] = (         int  )0;
      sqlstm.sqharm[8] = (unsigned int  )0;
      sqlstm.sqadto[8] = (unsigned short )0;
      sqlstm.sqtdso[8] = (unsigned short )0;
      sqlstm.sqhstv[9] = (         void  *)&bl_hdr_bill_tot_amt_db;
      sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[9] = (         int  )0;
      sqlstm.sqindv[9] = (         void  *)0;
      sqlstm.sqinds[9] = (         int  )0;
      sqlstm.sqharm[9] = (unsigned int  )0;
      sqlstm.sqadto[9] = (unsigned short )0;
      sqlstm.sqtdso[9] = (unsigned short )0;
      sqlstm.sqhstv[10] = (         void  *)&bl_hdr_bill_tot_outst_amt;
      sqlstm.sqhstl[10] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[10] = (         int  )0;
      sqlstm.sqindv[10] = (         void  *)0;
      sqlstm.sqinds[10] = (         int  )0;
      sqlstm.sqharm[10] = (unsigned int  )0;
      sqlstm.sqadto[10] = (unsigned short )0;
      sqlstm.sqtdso[10] = (unsigned short )0;
      sqlstm.sqhstv[11] = (         void  *)&l_credit_doc_ref_desc;
      sqlstm.sqhstl[11] = (unsigned int  )37;
      sqlstm.sqhsts[11] = (         int  )0;
      sqlstm.sqindv[11] = (         void  *)0;
      sqlstm.sqinds[11] = (         int  )0;
      sqlstm.sqharm[11] = (unsigned int  )0;
      sqlstm.sqadto[11] = (unsigned short )0;
      sqlstm.sqtdso[11] = (unsigned short )0;
      sqlstm.sqhstv[12] = (         void  *)&l_credit_doc_ref_date;
      sqlstm.sqhstl[12] = (unsigned int  )22;
      sqlstm.sqhsts[12] = (         int  )0;
      sqlstm.sqindv[12] = (         void  *)0;
      sqlstm.sqinds[12] = (         int  )0;
      sqlstm.sqharm[12] = (unsigned int  )0;
      sqlstm.sqadto[12] = (unsigned short )0;
      sqlstm.sqtdso[12] = (unsigned short )0;
      sqlstm.sqhstv[13] = (         void  *)&l_added_by_id;
      sqlstm.sqhstl[13] = (unsigned int  )37;
      sqlstm.sqhsts[13] = (         int  )0;
      sqlstm.sqindv[13] = (         void  *)0;
      sqlstm.sqinds[13] = (         int  )0;
      sqlstm.sqharm[13] = (unsigned int  )0;
      sqlstm.sqadto[13] = (unsigned short )0;
      sqlstm.sqtdso[13] = (unsigned short )0;
      sqlstm.sqhstv[14] = (         void  *)&l_added_date;
      sqlstm.sqhstl[14] = (unsigned int  )32;
      sqlstm.sqhsts[14] = (         int  )0;
      sqlstm.sqindv[14] = (         void  *)0;
      sqlstm.sqinds[14] = (         int  )0;
      sqlstm.sqharm[14] = (unsigned int  )0;
      sqlstm.sqadto[14] = (unsigned short )0;
      sqlstm.sqtdso[14] = (unsigned short )0;
      sqlstm.sqhstv[15] = (         void  *)&bl_hdr_bill_tot_adjust_amt;
      sqlstm.sqhstl[15] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[15] = (         int  )0;
      sqlstm.sqindv[15] = (         void  *)0;
      sqlstm.sqinds[15] = (         int  )0;
      sqlstm.sqharm[15] = (unsigned int  )0;
      sqlstm.sqadto[15] = (unsigned short )0;
      sqlstm.sqtdso[15] = (unsigned short )0;
      sqlstm.sqhstv[16] = (         void  *)&bl_hdr_bill_tot_exempt_amt;
      sqlstm.sqhstl[16] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[16] = (         int  )0;
      sqlstm.sqindv[16] = (         void  *)0;
      sqlstm.sqinds[16] = (         int  )0;
      sqlstm.sqharm[16] = (unsigned int  )0;
      sqlstm.sqadto[16] = (unsigned short )0;
      sqlstm.sqtdso[16] = (unsigned short )0;
      sqlstm.sqhstv[17] = (         void  *)&bl_hdr_bill_tot_write_off_amt;
      sqlstm.sqhstl[17] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[17] = (         int  )0;
      sqlstm.sqindv[17] = (         void  *)0;
      sqlstm.sqinds[17] = (         int  )0;
      sqlstm.sqharm[17] = (unsigned int  )0;
      sqlstm.sqadto[17] = (unsigned short )0;
      sqlstm.sqtdso[17] = (unsigned short )0;
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
          err_mesg("FETCH failed on cursor BL_BILL_HDR_CUR",0,"");

		bl_hdr_cust_code.arr[bl_hdr_cust_code.len]						 = '\0';
		bl_hdr_doc_date.arr[bl_hdr_doc_date.len]    	                 = '\0';
		bl_hdr_blng_grp_id.arr[bl_hdr_blng_grp_id.len]                   = '\0';
		bl_patient_id.arr[bl_patient_id.len]   			                 = '\0';
		d_episode_id.arr[d_episode_id.len]                               = '\0';
		d_visit_id.arr[d_visit_id.len]                                   = '\0';
		d_doc_type.arr[d_doc_type.len]                                   = '\0';
		d_doc_num.arr[d_doc_num.len]                                     = '\0';
		l_credit_doc_ref_desc.arr[l_credit_doc_ref_desc.len]			= '\0';
		l_credit_doc_ref_date.arr[l_credit_doc_ref_date.len]			= '\0';
		l_added_by_id.arr[l_added_by_id.len]							= '\0';		
		l_added_date.arr[l_added_date.len]								= '\0';

    return(LAST_ROW?0:1);
}

print_grand_tot()
{
    if (lctr > MAX_LINES) 
    {
       fprintf(fp,"");
       print_head(0); 
    }     

    fprintf(fp,"                                                                                                                                                         ------------------------------------\n");
    fprintf(fp,"%11s                                                                                                                                           ",loc_legend[320]);
    print_formated(gr_tot_amt, fp);  
    fprintf(fp,"     ");
    print_formated(gr_tot_outst_amt, fp);  
    fprintf(fp,"\n");
    fprintf(fp,"                                                                                                                                                         ------------------------------------\n");
}

end_of_rep()
{
	fprintf(fp,"                                                                                                      ***  END OF REPORT ***\n");
	fflush(fp);
}

open_file()
{
char file_name[30];

    strcpy(filename,WORKING_DIR);
    strcat(filename,"blrblsum.lis");

   // if ((fp = fopen("blrblsum.lis","w")) == NULL)
    if ((fp = fopen(filename,"w")) == NULL)
    {
       disp_message(ERR_MESG,"Error in opening file blrblsum.lis");
       proc_exit();
    }
    print_title();
    print_head(0);
}

print_title()
{
//fprintf(fp,"MDL : %2s                                                                                                %-30s                                                                                         %-16s\n",loc_legend[150],hosp_name.arr,date_time.arr);

					 init_date_temp_var();                              

					  strcpy(date_convert.arr,date_time.arr);            
 					  fun_change_loc_date_time(); 
fprintf(fp,"MDL : %2s                                                                                                %-30s                                                                                         %-16s\n",loc_legend[150],hosp_name.arr,date_convert.arr);

fprintf(fp,"OPR : %-10s \n", user_id.arr);
fprintf(fp,"REP : %-8s                                                                                            %s                                                                                           %4s : %4d\n",loc_legend[40],loc_legend[50],loc_legend[30],++pctr);
	fprintf(fp,"------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
fprintf(fp,"VER : 4.1\n");
fflush(fp);

fprintf(fp,"\n\n\n\n        %16s :\n        ----------------\n\n",loc_legend[80]);
fprintf(fp,"                            %12s         : %s\n\n",loc_legend[90],nd_epi_type.arr);

fprintf(fp,"                            %10s      %4s : %s\n",loc_legend[120],loc_legend[60],nd_fr_bill_id.arr);
fprintf(fp,"                                              %2s : %s\n\n",loc_legend[70],nd_to_bill_id.arr);

fprintf(fp,"                            %9s            : %s\n\n",loc_legend[130],nd_bill_nature.arr);

if (nd_fm_date.arr[0] != '\0')
 {
					 init_date_temp_var();                              
					  strcpy(date_convert.arr,nd_fm_date.arr);            
 					  fun_change_loc_date(); 

fprintf(fp,"                            %9s       %4s : %-10.10s\n",loc_legend[100],loc_legend[60],date_convert.arr);
}
else
{
fprintf(fp,"                            %9s       %4s : %s\n",loc_legend[100],loc_legend[60],loc_legend[370]);
}
if (nd_to_date.arr[0] != '\0')
 {
					 init_date_temp_var();                              
 					  strcpy(date_convert.arr,nd_to_date.arr);            
 					  fun_change_loc_date(); 

fprintf(fp,"                                              %2s : %-10.10s\n\n",loc_legend[70],date_convert.arr);
}
else
{
fprintf(fp,"                                              %2s : %s\n\n",loc_legend[70],loc_legend[380]);
}

fprintf(fp,"                            %8s        %4s : %s\n",loc_legend[140],loc_legend[60],nd_fr_cust_code.arr);
fprintf(fp,"                                              %2s : %s\n\n",loc_legend[70],nd_to_cust_code.arr);
fprintf(fp,"");

}

print_head(l_flg)
int l_flg;
{
//	fprintf(fp,"MDL : %2s                                                                                                %-30s                                                                                         %-16s\n",loc_legend[150],hosp_name.arr,date_time.arr);
					 init_date_temp_var();                              
 					  strcpy(date_convert.arr,date_time.arr);            
 					  fun_change_loc_date_time(); 

	fprintf(fp,"MDL : %2s                                                                                                %-30s                                                                                         %-16s\n",loc_legend[150],hosp_name.arr,date_convert.arr);
	fprintf(fp,"OPR : %-10s \n", user_id.arr);
    fprintf(fp,"REP : %-8s                                                                                            %s                                                                                           %4s : %4d\n",loc_legend[40],loc_legend[50],loc_legend[30],++pctr);

//	fprintf(fp,"                                                                                                         (%-10s TO %-10s)\n",nd_fm_date.arr,nd_to_date.arr);
if (nd_fm_date.arr[0] != '\0')
 {
					 init_date_temp_var();                              
					  strcpy(date_convert.arr,nd_fm_date.arr);            
 					  fun_change_loc_date(); 

	fprintf(fp,"                                                                                                         (%-10.10s TO",date_convert.arr);
	}
else
{
fprintf(fp,"                                                                                                         (%-10.10s TO",loc_legend[370]);
}

if (nd_to_date.arr[0] != '\0')
 {
					 init_date_temp_var();                              
					  strcpy(date_convert.arr,nd_to_date.arr);            
 					  fun_change_loc_date(); 

	fprintf(fp," %-10.10s)\n",date_convert.arr);
	}
else
{
fprintf(fp," %-10.10s)\n",loc_legend[380]);
}




	//EPNH 28/10/2004 
	fprintf(fp,"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
	fprintf(fp,"%12s %16s %10s               %4s                      %12s/%2s     %12s    %12s        %12s      %13s    %18s      %20s       %15s\n",loc_legend[160],loc_legend[170],loc_legend[180],loc_legend[190],loc_legend[90],loc_legend[200],loc_legend[280],loc_legend[290],loc_legend[300],loc_legend[210],loc_legend[220],loc_legend[230],loc_legend[240]);
	fprintf(fp,"%10s                      %12s                                                                                                                                                                                 \n",loc_legend[250],loc_legend[310]);
	fprintf(fp,"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
	fflush(fp);
	lctr = 8;
}
  

void print_detl()
{ 
	 void get_patient_name();
	 get_patient_name();
//	 fprintf(fp,"%s   ",bl_hdr_doc_date.arr);  
					 init_date_temp_var();                              
					  strcpy(date_convert.arr,bl_hdr_doc_date.arr);            
 	 				  fun_change_loc_dt_format(); 
  
	 fprintf(fp,"%-10.10s   ",date_convert.arr);  
	 fprintf(fp,"%-6s/%-8s ",d_doc_type.arr,d_doc_num.arr);  
	 fprintf(fp,"%-20s ",bl_patient_id.arr);  
	 fprintf(fp,"%-30.30s ",d_short_name.arr);  
	 fprintf(fp,"%s/",d_episode_type.arr);  
	 fprintf(fp,"%-8s/",d_episode_id.arr);  
	 fprintf(fp,"%-4s  ",d_visit_id.arr);  
 
	 gr_tot_amt		  = gr_tot_amt + bl_hdr_bill_tot_amt_db;
	 gr_tot_outst_amt = gr_tot_outst_amt + bl_hdr_bill_tot_outst_amt;

	 brk1_tot_amt		= brk1_tot_amt + bl_hdr_bill_tot_amt_db;
	 brk1_tot_outst_amt	= brk1_tot_outst_amt + bl_hdr_bill_tot_outst_amt;
         
	 //EPNH 28/10/2004
	 print_formated(bl_hdr_bill_tot_adjust_amt,fp);
         fprintf(fp,"  ");
         print_formated(bl_hdr_bill_tot_exempt_amt,fp);
         fprintf(fp,"  ");
         print_formated(bl_hdr_bill_tot_write_off_amt,fp);
         fprintf(fp,"  ");


	 print_formated(bl_hdr_bill_tot_amt_db,fp);
	 fprintf(fp,"     ");
	 print_formated(bl_hdr_bill_tot_outst_amt,fp);

	 fprintf(fp,"        ");
	 fprintf(fp,"%-30.30s",l_credit_doc_ref_desc.arr);  
	 fprintf(fp," ");
	 //fprintf(fp,"%-10.10s",l_credit_doc_ref_date.arr); 
	 if(l_credit_doc_ref_date.arr[0]!='\0')
	 {
					 init_date_temp_var();         
 					  strcpy(date_convert.arr,l_credit_doc_ref_date.arr);            
 					  fun_change_loc_date(); 
	  
	 fprintf(fp,"%-10.10s",date_convert.arr);  
	 }
	 fprintf(fp,"\n");
	 fprintf(fp,"%-30.30s",l_added_by_id.arr);  	
	 fprintf(fp,"  ");
	 if(l_added_date.arr[0]!='\0')
	 {
					 init_date_temp_var();         
 					  strcpy(date_convert.arr,l_added_date.arr);            
 					  fun_change_loc_date_time1(); 
					  fprintf(fp,"%-16.16s",date_convert.arr); 	 
					//  fprintf(fp,"%-30.30s",l_added_date.arr);  
	}

  
	 fprintf(fp,"\n");
	 if(strlen(d_short_name1.arr) > 2)
	 {
		fprintf(fp,"%49s %s \n"," ",d_short_name1.arr);
	 }
}  



fetch_hosp_name()
{
    hosp_name.arr[0] = '\0';
    date_time.arr[0] = '\0';
    user_id.arr[0]   = '\0';
    hosp_name.len    = 0;
    date_time.len    = 0;
    user_id.len      = 0;

/*-- Y2K correction. Format introduced for year as YYYY instead of YY 
     VSK 15/11/1999 */

    /* EXEC SQL SELECT ACC_ENTITY_NAME, TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
                    USER
             INTO :hosp_name, :date_time, :user_id
             FROM SY_ACC_ENTITY
			 WHERE ACC_ENTITY_ID = :nd_operating_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 18;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:\
MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b3";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )287;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&hosp_name;
    sqlstm.sqhstl[0] = (unsigned int  )122;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&date_time;
    sqlstm.sqhstl[1] = (unsigned int  )22;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&user_id;
    sqlstm.sqhstl[2] = (unsigned int  )93;
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



       if (OERROR) err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");

hosp_name.arr[hosp_name.len]           = '\0';
date_time.arr[date_time.len]           = '\0';
user_id.arr[user_id.len]               = '\0';
}

print_formated(loc_amount, fp)
double loc_amount;
FILE *fp;
{
	char s_amt[30], str_amt[30];	

    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);
        //ltrim(s_amt);
        format_amt(s_amt);
        //strcat(s_amt,"-");
      sprintf(str_amt,"%14s",s_amt);
        fprintf(fp,"%-14sCR",str_amt);
        }
    else 
	{
        put_val(s_amt,loc_amount);
          //      ltrim(s_amt);
        format_amt(s_amt);
        //strcat(s_amt," ");
      sprintf(str_amt,"%14s",s_amt);
        fprintf(fp,"%-14s  ",str_amt);
        }
}

                   
void get_blng_desc()
{
  bl_blng_desc.len  = 0;
  /* EXEC SQL SELECT 	SHORT_DESC
           INTO    :bl_blng_desc
 	       FROM    BL_BLNG_GRP
	       WHERE   BLNG_GRP_ID = :bl_hdr_blng_grp_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 18;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select SHORT_DESC into :b0  from BL_BLNG_GRP where BLNG_GRP\
_ID=:b1";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )318;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&bl_blng_desc;
  sqlstm.sqhstl[0] = (unsigned int  )18;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&bl_hdr_blng_grp_id;
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

	

  bl_blng_desc.arr[bl_blng_desc.len] = '\0';

  bl_cust_desc.len  = 0;
  if (bl_hdr_cust_code.len) 
    {  
  /* EXEC SQL SELECT  NVL(LONG_NAME,'*****')
           INTO    :bl_cust_desc
 	       FROM    AR_CUSTOMER
	       WHERE   CUST_CODE = :bl_hdr_cust_code; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 18;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select NVL(LONG_NAME,'*****') into :b0  from AR_CUSTOMER wh\
ere CUST_CODE=:b1";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )341;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&bl_cust_desc;
  sqlstm.sqhstl[0] = (unsigned int  )43;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&bl_hdr_cust_code;
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
        err_mesg("SELECT failed on table AR_CUSTOMER",0,"");

   if (NOT_FOUND)  
      {  
         strcpy(bl_cust_desc.arr,"*****");  
         bl_cust_desc.len = 5;
      } 
	}       

  bl_cust_desc.arr[bl_cust_desc.len] = '\0';
   
  return;
}
                          
  
void get_patient_name()
{
  bl_blng_desc.arr[0]  = '\0';
  /* EXEC SQL SELECT 	substr(SHORT_NAME,1,30),
                    decode(substr(short_name,31,60),NULL,' ',substr(short_name,31,60)) shortname1,
                     short_name
           INTO     :d_short_name,
		            :d_short_name1,
                    :d_short_name_full
 	       FROM     MP_PATIENT_MAST
	       WHERE    PATIENT_ID = :bl_patient_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 18;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select substr(SHORT_NAME,1,30) ,decode(substr(short_name,31\
,60),null ,' ',substr(short_name,31,60)) shortname1 ,short_name into :b0,:b1,:\
b2  from MP_PATIENT_MAST where PATIENT_ID=:b3";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )364;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_short_name;
  sqlstm.sqhstl[0] = (unsigned int  )63;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_short_name1;
  sqlstm.sqhstl[1] = (unsigned int  )33;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_short_name_full;
  sqlstm.sqhstl[2] = (unsigned int  )63;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&bl_patient_id;
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

	

  d_short_name.arr[d_short_name.len] = '\0';
    d_short_name1.arr[d_short_name1.len] = '\0';
   d_short_name_full.arr[d_short_name_full.len] = '\0';
 
/* EXEC SQL EXECUTE
 BEGIN
 declare
      str1   varchar2(100);
     str2   varchar2(60);
     
    
   BEGIN
     blcommon.split_words(:d_short_name_full,30,'*',1,str1,str2);
        IF str2 IS NOT NULL THEN
         :d_short_name   :=str2;
       END IF;
    blcommon.split_words(:d_short_name_full,30,'*',2,str1,str2);
       IF str2 IS NOT NULL THEN
         :d_short_name1  := str2;
      END IF;
    blcommon.split_words(:d_short_name_full,30,'*',3,str1,str2);
        IF str2 IS NOT NULL THEN
         :d_short_name1    := :d_short_name1 || str2;
       end if;

	 
     
 END;
  END;
       
   END-EXEC; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 18;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "begin declare str1 varchar2 ( 100 ) ; str2 varchar2 ( 60 ) ; \
BEGIN blcommon . split_words ( :d_short_name_full , 30 , '*' , 1 , str1 , str2\
 ) ; IF str2 IS NOT NULL THEN :d_short_name := str2 ; END IF ; blcommon . spli\
t_words ( :d_short_name_full , 30 , '*' , 2 , str1 , str2 ) ; IF str2 IS NOT N\
ULL THEN :d_short_name1 := str2 ; END IF ; blcommon . split_words ( :d_short_n\
ame_full , 30 , '*' , 3 , str1 , str2 ) ; IF str2 IS NOT NULL THEN :d_short_na\
me1 := :d_short_name1 || str2 ; end if ; END ; END ;";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )395;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)4352;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&d_short_name_full;
sqlstm.sqhstl[0] = (unsigned int  )63;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&d_short_name;
sqlstm.sqhstl[1] = (unsigned int  )63;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&d_short_name1;
sqlstm.sqhstl[2] = (unsigned int  )33;
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


       d_short_name.arr[d_short_name.len]  = '\0';
       d_short_name1.arr[d_short_name1.len]  = '\0';

   
  return;
}


fetch_legend_value()
{
	for(i=1;i<=900;i++)
	{
		l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLRBLSUM.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 18;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLRBLSUM.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )422;
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
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 18;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility_id , 'S\
M' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_valu\
e , :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )445;
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
}
get_local_date_time()
{

  	/* EXEC SQL EXECUTE
 
 	
	BEGIN
	
	:nd_loc_date :=sm_convert_datetime_2t(TO_DATE(:nd_temp_date,'DD/MM/YYYY HH24:MI'),:p_language_id);  
	:nd_loc_date :=TO_CHAR(TO_DATE(:nd_loc_date,'DD/MM/YYYY HH24:MI'),'DD/MM/YYYY HH24:MI');
  	END;

	END-EXEC; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 18;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "begin :nd_loc_date := sm_convert_datetime_2t ( TO_DATE ( :\
nd_temp_date , 'DD/MM/YYYY HH24:MI' ) , :p_language_id ) ; :nd_loc_date := TO_\
CHAR ( TO_DATE ( :nd_loc_date , 'DD/MM/YYYY HH24:MI' ) , 'DD/MM/YYYY HH24:MI' \
) ; END ;";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )476;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_loc_date;
   sqlstm.sqhstl[0] = (unsigned int  )22;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_temp_date;
   sqlstm.sqhstl[1] = (unsigned int  )22;
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

fun_change_loc_date_time()
{

strcpy(nd_temp_date.arr,date_convert.arr);
nd_temp_date.len = strlen(nd_temp_date.arr);

get_local_date_time();

strcpy(date_convert.arr,nd_loc_date.arr); 

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

get_local_date()
{

  	/* EXEC SQL EXECUTE
 
 	
	BEGIN
	
	:nd_loc_date :=sm_convert_date_2t(TO_DATE(:nd_temp_date,'DD/MM/YYYY'),:p_language_id);  
  	END;

	END-EXEC; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 18;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "begin :nd_loc_date := sm_convert_date_2t ( TO_DATE ( :nd_t\
emp_date , 'DD/MM/YYYY' ) , :p_language_id ) ; END ;";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )503;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_loc_date;
   sqlstm.sqhstl[0] = (unsigned int  )22;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_temp_date;
   sqlstm.sqhstl[1] = (unsigned int  )22;
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

fun_change_loc_date()
{

strcpy(nd_temp_date.arr,date_convert.arr);
nd_temp_date.len = strlen(nd_temp_date.arr);

get_local_date();

strcpy(date_convert.arr,nd_loc_date.arr); 

}
get_local_dt_format()
{
   	/* EXEC SQL EXECUTE
 
 	
	BEGIN
	
	:nd_loc_date :=sm_convert_date_2t(TO_DATE(:nd_temp_date,'DD-MON-rrRR'),:p_language_id); 
  	END;

	END-EXEC; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 18;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "begin :nd_loc_date := sm_convert_date_2t ( TO_DATE ( :nd_\
temp_date , 'DD-MON-rrRR' ) , :p_language_id ) ; END ;";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )530;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_loc_date;
    sqlstm.sqhstl[0] = (unsigned int  )22;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_temp_date;
    sqlstm.sqhstl[1] = (unsigned int  )22;
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

fun_change_loc_dt_format()
{

strcpy(nd_temp_date.arr,date_convert.arr);
nd_temp_date.len = strlen(nd_temp_date.arr);

get_local_dt_format();

strcpy(date_convert.arr,nd_loc_date.arr); 

}
get_local_date_time1()
{

  	/* EXEC SQL EXECUTE
 
 	
	BEGIN
	
	:nd_loc_date :=sm_convert_datetime_2t(TO_DATE(:nd_temp_date,'DD/MM/YYYY HH24:MI'),:p_language_id);  
   	END;

	END-EXEC; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 18;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "begin :nd_loc_date := sm_convert_datetime_2t ( TO_DATE ( :\
nd_temp_date , 'DD/MM/YYYY HH24:MI' ) , :p_language_id ) ; END ;";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )557;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_loc_date;
   sqlstm.sqhstl[0] = (unsigned int  )22;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_temp_date;
   sqlstm.sqhstl[1] = (unsigned int  )22;
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

fun_change_loc_date_time1()
{

strcpy(nd_temp_date.arr,date_convert.arr);
nd_temp_date.len = strlen(nd_temp_date.arr);

get_local_date_time1();

strcpy(date_convert.arr,nd_loc_date.arr); 

}