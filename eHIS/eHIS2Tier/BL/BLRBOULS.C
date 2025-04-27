
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
           char  filnam[22];
};
static const struct sqlcxp sqlfpn =
{
    21,
    "C:\\10xdev\\Blrbouls.pc"
};


static unsigned long sqlctx = 139598419;


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
            void  *sqhstv[12];
   unsigned int   sqhstl[12];
            int   sqhsts[12];
            void  *sqindv[12];
            int   sqinds[12];
   unsigned int   sqharm[12];
   unsigned int   *sqharc[12];
   unsigned short  sqadto[12];
   unsigned short  sqtdso[12];
} sqlstm = {10,12};

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
"select SLMT_DOC_REF_DESC ,TO_CHAR(SLMT_DOC_REF_DATE,'DD/MM/YYYY') ,SLMT_DOC\
_REMARKS ,TO_CHAR(DOC_AMT,'999,999,990.99') ,DOC_AMT ,PATIENT_ID ,EPISODE_TYP\
E ,LPAD(TO_CHAR(EPISODE_ID),8,'0') ,TO_CHAR(VISIT_ID) ,DOC_TYPE_CODE ,TO_CHAR\
(DOC_NUMBER) ,TO_CHAR(DOC_DATE,'DD/MM/YYYY')  from BL_RECEIPT_REFUND_HDRDTL_V\
W where ((((RECPT_REFUND_IND='R' and PATIENT_ID between NVL(:b0,'!!!!!!!!!!')\
 and NVL(:b0,'~~~~~~~~~~')) and NVL(BOUNCED_YN,'N')='Y') and BOUNCED_DATE bet\
ween TO_DATE(NVL(:b2,'01/01/1000'),'DD/MM/YYYY') and TO_DATE(NVL(:b3,'31/12/4\
712'),'DD/MM/YYYY')) and operating_facility_id=:b4) order by PATIENT_ID      \
      ";

 static const char *sq0007 = 
"select decode(:b0,'en',short_name,short_name_loc_lang)  from MP_PATIENT_MAS\
T where PATIENT_ID=:b1           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,127,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,168,0,4,153,0,0,6,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,
0,0,
75,0,0,3,185,0,4,186,0,0,6,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,
0,0,
114,0,0,4,0,0,30,222,0,0,0,0,0,1,0,
129,0,0,5,91,0,2,230,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
152,0,0,6,620,0,9,277,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
187,0,0,6,0,0,13,312,0,0,12,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
250,0,0,7,108,0,9,361,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
273,0,0,7,0,0,13,366,0,0,1,0,0,1,0,2,9,0,0,
292,0,0,8,511,0,6,381,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,3,9,0,0,
319,0,0,9,64,0,4,435,0,0,2,1,0,1,0,1,4,0,0,2,9,0,0,
342,0,0,10,96,0,4,602,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
365,0,0,11,165,0,6,609,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
396,0,0,12,207,0,6,632,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
423,0,0,13,200,0,6,654,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
};


/*****************************************************************************/
/*          Report to generate List of Currently Bounced Cheques             */
/*                                                                           */
/*                           BLRBOULS.PC                                     */
/*****************************************************************************/
/*   Converted To Windows : Prasad B G S 4/7/96                             */
/*
#define DEBUG   
*/
                
#include <stdio.h>
#include <string.h>  
#include <bl.h>  
  

/* EXEC SQL BEGIN DECLARE SECTION; */ 


    /* VARCHAR uid_pwd			[91],  //KGA 
			d_session_id	[16],
			d_pgm_date		[14],
            rep_date		[20],
			date_time		[20],
            comp_name		[50],   
            oper_id			[21]; */ 
struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[16]; } d_session_id;

struct { unsigned short len; unsigned char arr[14]; } d_pgm_date;

struct { unsigned short len; unsigned char arr[20]; } rep_date;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[50]; } comp_name;

struct { unsigned short len; unsigned char arr[21]; } oper_id;


   /* VARCHAR h_slmt_doc_ref_desc	[21],
           h_slmt_doc_ref_date	[13],
		   h_slmt_doc_ref_date1	[13],
           h_slmt_doc_remarks	[102],
           h_doc_amt			[16],
           h_patient_id			[21], //KGA
           h_patient_name		[61], //KGA
           h_patient_name1		[61], //KGA
	     h_patient_name_loc_lang[41], //KGA 
           d_short_name_full    [61],
           h_episode_type		[2],
           h_episode_id			[9],
           h_visit_id			[4],
           h_doc_type_code		[7],  
           h_doc_number			[9],
           h_doc_date			[13],
		   h_doc_date1			[13],
           nd_facility_id		[3],  //KGA 
		   l_pk_value		    [100],
	       l_translated_value	[201],
		   //l_language_id		[3],
	       p_language_id		[3]; */ 
struct { unsigned short len; unsigned char arr[21]; } h_slmt_doc_ref_desc;

struct { unsigned short len; unsigned char arr[13]; } h_slmt_doc_ref_date;

struct { unsigned short len; unsigned char arr[13]; } h_slmt_doc_ref_date1;

struct { unsigned short len; unsigned char arr[102]; } h_slmt_doc_remarks;

struct { unsigned short len; unsigned char arr[16]; } h_doc_amt;

struct { unsigned short len; unsigned char arr[21]; } h_patient_id;

struct { unsigned short len; unsigned char arr[61]; } h_patient_name;

struct { unsigned short len; unsigned char arr[61]; } h_patient_name1;

struct { unsigned short len; unsigned char arr[41]; } h_patient_name_loc_lang;

struct { unsigned short len; unsigned char arr[61]; } d_short_name_full;

struct { unsigned short len; unsigned char arr[2]; } h_episode_type;

struct { unsigned short len; unsigned char arr[9]; } h_episode_id;

struct { unsigned short len; unsigned char arr[4]; } h_visit_id;

struct { unsigned short len; unsigned char arr[7]; } h_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } h_doc_number;

struct { unsigned short len; unsigned char arr[13]; } h_doc_date;

struct { unsigned short len; unsigned char arr[13]; } h_doc_date1;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;




   /* VARCHAR nd_fm_bounced_date [13],
		   nd_to_bounced_date [13],
		   nd_patient_id	  [21],  //KGA 
           nd_patient_desc    [41],  //KGA
		   nd_temp_date		  [20],  //28/06/2007
		   nd_loc_date		  [20],  //28/06/2007
		   nd_loc_date1	      [20],
		   date_convert		  [20],  //28/06/2007
           nd_tot_doc_amt     [23]; */ 
struct { unsigned short len; unsigned char arr[13]; } nd_fm_bounced_date;

struct { unsigned short len; unsigned char arr[13]; } nd_to_bounced_date;

struct { unsigned short len; unsigned char arr[21]; } nd_patient_id;

struct { unsigned short len; unsigned char arr[41]; } nd_patient_desc;

struct { unsigned short len; unsigned char arr[20]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[20]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[20]; } nd_loc_date1;

struct { unsigned short len; unsigned char arr[20]; } date_convert;

struct { unsigned short len; unsigned char arr[23]; } nd_tot_doc_amt;


double     doc_amt,
           tot_doc_amt;

char       nd_print_flag;

    int i,null_place;
	
	char g_facility_id[3];

    char filename[150];
	char x_msg[200];
	char loc_legend[999][201];
	char l_mesg[200];


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

int page_no,
    line_no,
    first_line,
    tot_rec,
    g_hdr_cnt,
    g_err_typ;

char filename[150],
     g_acct_code[41],
     g_err_id[8],
     g_err_msg[72];
	// g_facility_id[5];

void proc_main(argc,argv)
int argc;
char *argv[];
{

    if(argc < 4) {
      disp_message(ERR_MESG,"BLRBOULS : Usage BLRBOULS userid/password session_id pgm_date");
      proc_exit();
    }


    strcpy(uid_pwd.arr,argv[1]);
    uid_pwd.len = strlen(uid_pwd.arr);

    strcpy(d_session_id.arr,argv[2]);
    d_session_id.len = strlen(d_session_id.arr);
    strcpy(g_session_id,argv[2]);
    
    strcpy(d_pgm_date.arr,argv[3]);
    d_pgm_date.len = strlen(d_pgm_date.arr);

    strcpy(g_pgm_id,"BLRBOULS");
    strcpy(g_pgm_date,argv[3]);

    strcpy(nd_facility_id.arr,argv[4]);
   	nd_facility_id.len = strlen(nd_facility_id.arr);
   	strcpy(g_facility_id,nd_facility_id.arr);


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
}




    if(OERROR) {
		disp_message(ORA_MESG,"Unable to connect to oracle.");
		proc_exit();
    }

    set_meduser_role();
    strcpy(p_language_id.arr,l_language_id.arr);
	p_language_id.len = l_language_id.len;
    start_prog_msg();

    nd_patient_id.arr[0]      = '\0';
    nd_patient_id.len         = 0;
    nd_fm_bounced_date.arr[0] = '\0';
    nd_fm_bounced_date.len    = 0;
    nd_to_bounced_date.arr[0] = '\0';
    nd_to_bounced_date.len    = 0;
    nd_facility_id.arr[0]     = '\0'; //KGA Included 
    nd_facility_id.len        = 0;
   


  
   //KGA Included Facility Id 
   /* EXEC SQL SELECT OPERATING_FACILITY_ID,
                   PARAM1,       /o  PATIENT_ID          o/
                   PARAM2,       /o  FM_DISCHARGE_DATE   o/
                   PARAM3        /o  TO_DISCHARGE_DATE   o/
            INTO   :nd_facility_id,
                   :nd_patient_id,
                   :nd_fm_bounced_date,
                   :nd_to_bounced_date
            FROM   SY_PROG_PARAM
            WHERE  PGM_ID     = 'BLRBOULS'
            AND    PGM_DATE   = :d_pgm_date
            AND    SESSION_ID = TO_NUMBER(:d_session_id); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 6;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 into\
 :b0,:b1,:b2,:b3  from SY_PROG_PARAM where ((PGM_ID='BLRBOULS' and PGM_DATE=:\
b4) and SESSION_ID=TO_NUMBER(:b5))";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )36;
   sqlstm.selerr = (unsigned short)1;
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
   sqlstm.sqhstv[1] = (         void  *)&nd_patient_id;
   sqlstm.sqhstl[1] = (unsigned int  )23;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_fm_bounced_date;
   sqlstm.sqhstl[2] = (unsigned int  )15;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_to_bounced_date;
   sqlstm.sqhstl[3] = (unsigned int  )15;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_pgm_date;
   sqlstm.sqhstl[4] = (unsigned int  )16;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_session_id;
   sqlstm.sqhstl[5] = (unsigned int  )18;
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



    if(OERROR || NO_DATA_FOUND)
	    err_mesg("SELECT failed on table  SY_PROG_PARAM",0,"");

    nd_patient_id.arr[nd_patient_id.len]           = '\0';
    nd_fm_bounced_date.arr[nd_fm_bounced_date.len] = '\0';
    nd_to_bounced_date.arr[nd_to_bounced_date.len] = '\0';
    nd_facility_id.arr[nd_facility_id.len]         = '\0';

    strcpy(filename,WORKING_DIR);
    strcat(filename,"blrbouls.lis");
    //KGA Setting Facility Id 
    strcpy(g_facility_id,nd_facility_id.arr); //KGA 


    if( (f1=fopen(filename,"w")) == NULL) {
        disp_message(ERR_MESG,"Error in opening output file... BLRBOULS.LIS");
	proc_exit();
   }

    //KGA Included Facility Id 
    /* EXEC SQL SELECT ACC_ENTITY_NAME,
					TO_CHAR(SYSDATE,'DD/MM/YYYY'),
					TO_CHAR(SYSDATE,'HH24:MI:SS'),
                    USER 
	     INTO		:comp_name,
					:rep_date,
					:date_time,
					:oper_id
	     FROM		SY_ACC_ENTITY_LANG_VW
         WHERE      ACC_ENTITY_ID = :nd_facility_id 
		 AND        LANGUAGE_ID   = :p_language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 6;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY') ,T\
O_CHAR(SYSDATE,'HH24:MI:SS') ,USER into :b0,:b1,:b2,:b3  from SY_ACC_ENTITY_L\
ANG_VW where (ACC_ENTITY_ID=:b4 and LANGUAGE_ID=:b5)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )75;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
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
    sqlstm.sqhstv[2] = (         void  *)&date_time;
    sqlstm.sqhstl[2] = (unsigned int  )22;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&oper_id;
    sqlstm.sqhstl[3] = (unsigned int  )23;
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
    sqlstm.sqhstv[5] = (         void  *)&p_language_id;
    sqlstm.sqhstl[5] = (unsigned int  )5;
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
	    err_mesg("SELECT failed on table  SY_ACC_ENTITY",0,"");

    comp_name.arr[comp_name.len] = '\0';
    rep_date.arr[rep_date.len] = '\0';
	date_time.arr[date_time.len] ='\0';
    oper_id.arr[oper_id.len] = '\0';

    page_no=1;
    line_no=1;

    decl_curs();

	fetch_legend_value();

    put_inp_parm();

    do_report();

    fclose(f1);

    del_parm();
    end_prog_msg();

    /* EXEC SQL COMMIT RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 6;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )114;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    return;
}

del_parm()
{

    /* EXEC SQL DELETE SY_PROG_PARAM
         WHERE  PGM_ID     = 'BLRBOULS' 
         AND    PGM_DATE   = :d_pgm_date
         AND    SESSION_ID = :d_session_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 6;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='BLRBOULS' an\
d PGM_DATE=:b0) and SESSION_ID=:b1)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )129;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
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

decl_curs()
{
//KGA included Facility id  
/* EXEC SQL DECLARE BL_RECEIPT_REFUND_CUR CURSOR FOR
               SELECT SLMT_DOC_REF_DESC, 
                      TO_CHAR(SLMT_DOC_REF_DATE, 'DD/MM/YYYY'),
                      SLMT_DOC_REMARKS,
                      TO_CHAR(DOC_AMT, '999,999,990.99'),
                      DOC_AMT,
                      PATIENT_ID,
                      EPISODE_TYPE,
                      LPAD(TO_CHAR(EPISODE_ID),8,'0'),
                      TO_CHAR(VISIT_ID),
                      DOC_TYPE_CODE,
                      TO_CHAR(DOC_NUMBER),
                      TO_CHAR(DOC_DATE,'DD/MM/YYYY')
                 FROM BL_RECEIPT_REFUND_HDRDTL_VW 
                 WHERE RECPT_REFUND_IND = 'R'
                   AND PATIENT_ID BETWEEN 
                        NVL(:nd_patient_id, '!!!!!!!!!!')
                       AND NVL(:nd_patient_id, '~~~~~~~~~~')
                   AND NVL(BOUNCED_YN,'N') = 'Y'
                   AND BOUNCED_DATE BETWEEN
                       TO_DATE(NVL(:nd_fm_bounced_date,'01/01/1000')
                                   ,'DD/MM/YYYY')
                   AND TO_DATE(NVL(:nd_to_bounced_date,'31/12/4712')
                                   ,'DD/MM/YYYY')
                   And  operating_facility_id=:nd_facility_id 
		 ORDER BY PATIENT_ID; */ 


    /* EXEC SQL DECLARE MP_PATIENT_MAST_CUR CURSOR FOR
	     SELECT  /osubstr(SHORT_NAME,1,30),
		         decode(substr(short_name,31,60),NULL,' ',substr(short_name,31,60)) shortname1,o/
		         decode(:p_language_id,'en',short_name,short_name_loc_lang)
				 /oSHORT_NAME_LOC_LANG,short_nameo/
	     FROM    MP_PATIENT_MAST
	     WHERE   PATIENT_ID = :h_patient_id; */ 


    /* EXEC SQL OPEN BL_RECEIPT_REFUND_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 6;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0006;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )152;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_patient_id;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_patient_id;
    sqlstm.sqhstl[1] = (unsigned int  )23;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_fm_bounced_date;
    sqlstm.sqhstl[2] = (unsigned int  )15;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_to_bounced_date;
    sqlstm.sqhstl[3] = (unsigned int  )15;
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
	err_mesg("OPEN failed on cursor BL_RECEIPT_REFUND_CUR",0,"");

}

fetch_chq_dtl()
{

    h_slmt_doc_ref_desc.arr[0]                                        = '\0';
    h_slmt_doc_ref_date.arr[0]                                        = '\0';
    h_slmt_doc_remarks.arr[0]                                         = '\0';
    h_doc_amt.arr[0]                                                  = '\0';
    h_patient_id.arr[0]                                               = '\0';
    h_episode_type.arr[0]                                             = '\0';
    h_episode_id.arr[0]                                               = '\0';
    h_visit_id.arr[0]                                                 = '\0';
    h_doc_type_code.arr[0]                                            = '\0';
    h_doc_number.arr[0]                                               = '\0';
    h_doc_date.arr[0]                                                 = '\0';

    h_slmt_doc_ref_desc.len                                           = 0;
    h_slmt_doc_ref_date.len                                           = 0;
    h_slmt_doc_remarks.len                                            = 0;
    h_doc_amt.len                                                     = 0;
    h_patient_id.len                                                  = 0;
    h_episode_type.len                                                = 0;
    h_episode_id.len                                                  = 0;
    h_visit_id.len                                                    = 0;
    h_doc_type_code.len                                               = 0;
    h_doc_number.len                                                  = 0;
    h_doc_date.len                                                    = 0;

    doc_amt                                                           = 0;

     /* EXEC SQL FETCH BL_RECEIPT_REFUND_CUR
               INTO :h_slmt_doc_ref_desc,
                    :h_slmt_doc_ref_date,
                    :h_slmt_doc_remarks,
                    :h_doc_amt,
                    :doc_amt,
                    :h_patient_id,
                    :h_episode_type,
                    :h_episode_id,
                    :h_visit_id,
                    :h_doc_type_code,
                    :h_doc_number,
                    :h_doc_date; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 12;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )187;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&h_slmt_doc_ref_desc;
     sqlstm.sqhstl[0] = (unsigned int  )23;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&h_slmt_doc_ref_date;
     sqlstm.sqhstl[1] = (unsigned int  )15;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&h_slmt_doc_remarks;
     sqlstm.sqhstl[2] = (unsigned int  )104;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&h_doc_amt;
     sqlstm.sqhstl[3] = (unsigned int  )18;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&doc_amt;
     sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&h_patient_id;
     sqlstm.sqhstl[5] = (unsigned int  )23;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&h_episode_type;
     sqlstm.sqhstl[6] = (unsigned int  )4;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&h_episode_id;
     sqlstm.sqhstl[7] = (unsigned int  )11;
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&h_visit_id;
     sqlstm.sqhstl[8] = (unsigned int  )6;
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&h_doc_type_code;
     sqlstm.sqhstl[9] = (unsigned int  )9;
     sqlstm.sqhsts[9] = (         int  )0;
     sqlstm.sqindv[9] = (         void  *)0;
     sqlstm.sqinds[9] = (         int  )0;
     sqlstm.sqharm[9] = (unsigned int  )0;
     sqlstm.sqadto[9] = (unsigned short )0;
     sqlstm.sqtdso[9] = (unsigned short )0;
     sqlstm.sqhstv[10] = (         void  *)&h_doc_number;
     sqlstm.sqhstl[10] = (unsigned int  )11;
     sqlstm.sqhsts[10] = (         int  )0;
     sqlstm.sqindv[10] = (         void  *)0;
     sqlstm.sqinds[10] = (         int  )0;
     sqlstm.sqharm[10] = (unsigned int  )0;
     sqlstm.sqadto[10] = (unsigned short )0;
     sqlstm.sqtdso[10] = (unsigned short )0;
     sqlstm.sqhstv[11] = (         void  *)&h_doc_date;
     sqlstm.sqhstl[11] = (unsigned int  )15;
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



    if(OERROR)
	err_mesg("FETCH failed on cursor BL_RECEIPT_REFUND_CUR",0,"");

    if(NO_DATA_FOUND)
	return 0;

    h_slmt_doc_ref_desc.arr[h_slmt_doc_ref_desc.len]                     = '\0';
    h_slmt_doc_ref_date.arr[h_slmt_doc_ref_date.len]                     = '\0';
    h_slmt_doc_remarks.arr[h_slmt_doc_remarks.len]                       = '\0';
    h_doc_amt.arr[h_doc_amt.len]                                         = '\0';
    h_patient_id.arr[h_patient_id.len]                                   = '\0';
    h_episode_type.arr[h_episode_type.len]                               = '\0';
    h_episode_id.arr[h_episode_id.len]                                   = '\0';
    h_visit_id.arr[h_visit_id.len]                                       = '\0';
    h_doc_type_code.arr[h_doc_type_code.len]                             = '\0';
    h_doc_number.arr[h_doc_number.len]                                   = '\0';
    h_doc_date.arr[h_doc_date.len]                                       = '\0';

    tot_doc_amt += doc_amt;

    return 1;
    
}

fetch_patient_name()
{

    h_patient_name.arr[0]  = '\0';
	h_patient_name1.arr[0]  = '\0';
    h_patient_name_loc_lang.arr[0]  = '\0';

    h_patient_name.len  = 0;
	h_patient_name1.len  = 0;
    h_patient_name_loc_lang.len  = 0;

    /* EXEC SQL OPEN MP_PATIENT_MAST_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0007;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )250;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&p_language_id;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&h_patient_id;
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
	err_mesg("OPEN failed on cursor MP_PATIENT_MAST_CUR",0,"");

    /* EXEC SQL FETCH MP_PATIENT_MAST_CUR 
	     INTO  /o:h_patient_name;
			    :h_patient_name1
		        :h_patient_name_loc_lango/
                :d_short_name_full; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )273;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_short_name_full;
    sqlstm.sqhstl[0] = (unsigned int  )63;
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
	err_mesg("FETCH failed on table MP_PATIENT_MAST_CUR",0,"");

    h_patient_name.arr[h_patient_name.len]  = '\0';
	h_patient_name1.arr[h_patient_name1.len]  = '\0';
    h_patient_name_loc_lang.arr[h_patient_name_loc_lang.len]  = '\0';
    d_short_name_full.arr[d_short_name_full.len]               = '\0';
 
 
    /* EXEC SQL EXECUTE
    BEGIN

	DECLARE

      str1   varchar2(100);
      str2   varchar2(60);
     
    
   BEGIN
     blcommon.split_words(:d_short_name_full,30,'*',1,str1,str2);
        IF str2 IS NOT NULL THEN
         :h_patient_name   :=str2;
       END IF;
    blcommon.split_words(:d_short_name_full,30,'*',2,str1,str2);
       IF str2 IS NOT NULL THEN
         :h_patient_name1  := str2;
      END IF;
    blcommon.split_words(:d_short_name_full,30,'*',3,str1,str2);
        IF str2 IS NOT NULL THEN
         :h_patient_name1    := :h_patient_name1 || str2;
        END IF;
     
   END;
   END;
       
   END-EXEC; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "begin DECLARE str1 varchar2 ( 100 ) ; str2 varchar2 ( 60\
 ) ; BEGIN blcommon . split_words ( :d_short_name_full , 30 , '*' , 1 , str1 \
, str2 ) ; IF str2 IS NOT NULL THEN :h_patient_name := str2 ; END IF ; blcomm\
on . split_words ( :d_short_name_full , 30 , '*' , 2 , str1 , str2 ) ; IF str\
2 IS NOT NULL THEN :h_patient_name1 := str2 ; END IF ; blcommon . split_words\
 ( :d_short_name_full , 30 , '*' , 3 , str1 , str2 ) ; IF str2 IS NOT NULL TH\
EN :h_patient_name1 := :h_patient_name1 || str2 ; END IF ; END ; END ;";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )292;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_short_name_full;
    sqlstm.sqhstl[0] = (unsigned int  )63;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&h_patient_name;
    sqlstm.sqhstl[1] = (unsigned int  )63;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&h_patient_name1;
    sqlstm.sqhstl[2] = (unsigned int  )63;
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


   
   
     /*strcpy(h_patient_name.arr,d_short_name_full.arr);
     h_patient_name.len=strlen(h_patient_name.arr);*/
        	   
	   h_patient_name.arr[h_patient_name.len]    = '\0';
       h_patient_name1.arr[h_patient_name1.len]  = '\0';
      
}

do_report()
{
    tot_rec = 0;
    tot_doc_amt = 0;
    line_no = 1;
    put_hdr();

    while(fetch_chq_dtl()) {

	fetch_patient_name();
        put_chq_dtl();
        line_no += 1;
        ++tot_rec;
    }
    if(tot_rec) {
        chk_break(3);
        fprintf(f1,"                                                ---------------\n");
        /* EXEC SQL SELECT LTRIM(TO_CHAR(:tot_doc_amt,'999,999,990.99'))
                 INTO   :nd_tot_doc_amt
                 FROM   DUAL; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 12;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "select LTRIM(TO_CHAR(:b0,'999,999,990.99')) into :b1\
  from DUAL ";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )319;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&tot_doc_amt;
        sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&nd_tot_doc_amt;
        sqlstm.sqhstl[1] = (unsigned int  )25;
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


        nd_tot_doc_amt.arr[nd_tot_doc_amt.len] = '\0';

		fprintf(f1,"%-24s%-10s : %-11s%15s\n"," ",loc_legend[230]," ",nd_tot_doc_amt.arr);
        fprintf(f1,"                                                ---------------\n");
        line_no += 3;
    }
    print_end_of_rep();

}
 
put_hdr()
{

    get_initialize();
	strcpy(nd_temp_date.arr,rep_date.arr);
	get_local_date_convn1();
	strcpy(date_convert.arr,nd_loc_date.arr);
	
	fprintf(f1,"%-7s : %-6s %-42s%-30.30s%-18s%-15.15s : %s\n",loc_legend[240],loc_legend[150]," ",comp_name.arr," ",loc_legend[10],date_convert.arr);
	fprintf(f1,"%-7s : %s%92s%-15.15s : %-s\n",loc_legend[250],oper_id.arr,"",loc_legend[20],date_time.arr);
	fprintf(f1,"%-7s : %-12s%-31s %-40s%-20s%-8.8s : %d\n",loc_legend[260],loc_legend[40]," ",loc_legend[50]," ",loc_legend[30],page_no);
    fprintf(f1,"----------------------------------------------------------------------------------------------------------------------------------------\n");
    fprintf(f1,"%-18s %-29s %14s %-14s & %-20s %-19s %s\n",loc_legend[120],loc_legend[130],loc_legend[140],loc_legend[160],loc_legend[170],loc_legend[180],loc_legend[190]);
	//fprintf(f1,"%s            %s                           %s %s & %s                        %s %s \n",loc_legend[120],loc_legend[130],loc_legend[140],loc_legend[160],loc_legend[170],loc_legend[180],loc_legend[190]);
/*              XXXXXXXXXXXXXXXXXXXX XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX 999,999,999.99 XXXXXXXXXX XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX X 99999999 9999 XXXXXX/99999999 */
    fprintf(f1,"%-18s %s\n",loc_legend[200],loc_legend[210]);
    //fprintf(f1,"%s          %s\n",loc_legend[200],loc_legend[210]);
/*              XXXXXXXXXX           XX/XX/XXXX                                                 */
    fprintf(f1,"----------------------------------------------------------------------------------------------------------------------------------------\n");

    line_no=7;

}

put_chq_dtl()
{
    
  chk_break(2);
   
  fprintf(f1,"%-18s %-27.27s%15s %-10s  %-25s %s %-8s %-8s %-6s/%s \n",
		  h_slmt_doc_ref_desc.arr, h_slmt_doc_remarks.arr,
		  h_doc_amt.arr, h_patient_id.arr,h_patient_name.arr,
		  h_episode_type.arr,h_episode_id.arr, h_visit_id.arr,
		  h_doc_type_code.arr, h_doc_number.arr);
  

  /*fprintf(f1,"%-20s %-30s %-15s %-20.20s %-30.30s %1s %-8s %-4s %-6s/%-8s \n"
 , h_slmt_doc_ref_desc.arr, h_slmt_doc_remarks.arr,
   h_doc_amt.arr, h_patient_id.arr, h_patient_name.arr, h_episode_type.arr,
   h_episode_id.arr, h_visit_id.arr, h_doc_type_code.arr, h_doc_number.arr);*/
/*            XXXXXXXXXXXXXXXXXXXX XXXXXXXXXX XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
 999,999,999.99 XXXXXXXXXX XXXXXXXXXXXXXXX X 99999999 9999 XXXXXX/99999999 */ 
   
    if(h_slmt_doc_ref_date.arr[0]!='\0')
	{
	get_initialize();
	strcpy(nd_temp_date.arr,h_slmt_doc_ref_date.arr);
	get_local_date_convn();
	strcpy(h_slmt_doc_ref_date1.arr,nd_loc_date1.arr);
	}

	if(h_doc_date.arr[0]!='\0')
	{
	get_initialize();
	strcpy(nd_temp_date.arr,h_doc_date.arr);
	get_local_date_convn();
	strcpy(h_doc_date1.arr,nd_loc_date1.arr);
	}
   fprintf(f1,"%-18s %s\n",h_slmt_doc_ref_date1.arr,h_doc_date1.arr);
   
/*              XXXXXXXXXX                                                 */

if(strlen(h_patient_name1.arr) > 2)
{
 fprintf(f1,"%88s %s \n"," ",h_patient_name1.arr);
 line_no++;
}


    line_no += 1;
  
}

chk_break(nol)
int nol;
{

	if(line_no+nol >= 55) {
           fprintf(f1,"");
           line_no = 1;
           ++page_no;
	   put_hdr();
	}

}

put_inp_parm()
{

     if (strcmp(nd_patient_id.arr,"\0")== 0)
    {  
        strcpy(nd_patient_desc.arr, loc_legend[220]);
    }
    else
    {
        strcpy(nd_patient_desc.arr, nd_patient_id.arr);
    }

    get_initialize();
	strcpy(nd_temp_date.arr,rep_date.arr);
	get_local_date_convn1();
	strcpy(date_convert.arr,nd_loc_date.arr);
	
	fprintf(f1,"%-7s : %-6s %-42s%-30s%-15s%-15.15s : %s\n",loc_legend[240],loc_legend[150]," ",comp_name.arr," ",loc_legend[10],date_convert.arr);
	fprintf(f1,"%-7s : %s%89s%-15.15s : %-s\n",loc_legend[250],oper_id.arr,"",loc_legend[20],date_time.arr);
	fprintf(f1,"%-7s : %-12s%-31s %-40s%-17s%-8.8s : %d\n",loc_legend[260],loc_legend[40]," ",loc_legend[50]," ",loc_legend[30],page_no);
	fprintf(f1,"------------------------------------------------------------------------------------------------------------------------------------\n");
    fprintf(f1,"VER : 1.10.01\n");
    fprintf(f1,"\n\n\n\n");
    fprintf(f1,"\t%s\n",loc_legend[80]);
    fprintf(f1,"\t--------------------\n\n");
    fprintf(f1,"\t\t%-25s : %s\n",loc_legend[90],nd_patient_desc.arr);
    
	if( nd_fm_bounced_date.arr[0]!= '\0')
	{
	get_initialize();
	strcpy(nd_temp_date.arr,nd_fm_bounced_date.arr);
	get_local_date_convn();
	strcpy(nd_fm_bounced_date.arr,nd_loc_date1.arr);
	}
	else
	strcpy(nd_fm_bounced_date.arr,loc_legend[29]);

    fprintf(f1,"\t\t%-16s %-8s : %s\n",loc_legend[100],loc_legend[60],nd_fm_bounced_date.arr);

    if( nd_to_bounced_date.arr[0]!= '\0')
	{
	get_initialize();
	strcpy(nd_temp_date.arr,nd_to_bounced_date.arr);
	get_local_date_convn();
	strcpy(nd_to_bounced_date.arr,nd_loc_date1.arr);
	}
	else
	strcpy(nd_to_bounced_date.arr,loc_legend[28]);

	fprintf(f1,"\t\t%-16s %-8s : %s\n"," ",loc_legend[70],nd_to_bounced_date.arr);
	fprintf(f1,"");
    ++page_no;

}


print_end_of_rep()
{
    fprintf(f1,"\n\n\t\t %s %d \n",loc_legend[110],tot_rec);
    fprintf(f1,"\n\n\n                                              %s                                                             \n",loc_legend[270]);
}

fetch_legend_value()
{
	for(i=1;i<=900;i++)
	{
		l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLRBOULS.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 12;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLRBOULS.LEGEND_'||LTRIM(RTRIM(TO_CHA\
R(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )342;
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
  sqlstm.arrsiz = 12;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility_id , '\
SM' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_va\
lue , :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )365;
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

/* FOR CONVERTING THAI DATE 28/06/2007*/

get_local_date1()
{

	
	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;
	
	BEGIN
		get_locale_date.convert_to_locale_date(to_date(:nd_temp_date,'DD/MM/YYYY HH24:MI'),:p_language_id,t_date);
															
		:nd_loc_date := to_char(t_date,'DD/MM/YYYY');

	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 12;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . convert_to_lo\
cale_date ( to_date ( :nd_temp_date , 'DD/MM/YYYY HH24:MI' ) , :p_language_id\
 , t_date ) ; :nd_loc_date := to_char ( t_date , 'DD/MM/YYYY' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )396;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_temp_date;
 sqlstm.sqhstl[0] = (unsigned int  )22;
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
 sqlstm.sqhstv[2] = (         void  *)&nd_loc_date;
 sqlstm.sqhstl[2] = (unsigned int  )22;
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
get_local_date()
{

	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;
	
	BEGIN
		get_locale_date.convert_to_locale_date(to_date(:nd_temp_date,'DD/MM/YYYY'),:p_language_id,t_date);
															
	   :nd_loc_date1 := to_char(t_date,'DD/MM/YYYY');

	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 12;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . convert_to_lo\
cale_date ( to_date ( :nd_temp_date , 'DD/MM/YYYY' ) , :p_language_id , t_dat\
e ) ; :nd_loc_date1 := to_char ( t_date , 'DD/MM/YYYY' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )423;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_temp_date;
 sqlstm.sqhstl[0] = (unsigned int  )22;
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
 sqlstm.sqhstv[2] = (         void  *)&nd_loc_date1;
 sqlstm.sqhstl[2] = (unsigned int  )22;
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

  

get_initialize()
{
nd_temp_date.arr[0] = '\0';
nd_loc_date.arr[0]  = '\0';
nd_loc_date1.arr[0] = '\0';

nd_temp_date.len = 0;
nd_loc_date.len  = 0;
nd_loc_date1.len = 0;
}
  
get_local_date_convn1()
{

nd_temp_date.len = strlen(nd_temp_date.arr);

get_local_date1();

}
get_local_date_convn()
{

nd_temp_date.len = strlen(nd_temp_date.arr);

get_local_date();

}


