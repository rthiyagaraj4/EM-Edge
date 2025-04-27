
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
           char  filnam[61];
};
static const struct sqlcxp sqlfpn =
{
    60,
    "D:\\BLTEST\\12X\\IN57613_LEAP-INT-SCF-9450\\Resolved\\blrvstfn.pc"
};


static unsigned long sqlctx = 890862421;


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
            void  *sqhstv[18];
   unsigned int   sqhstl[18];
            int   sqhsts[18];
            void  *sqindv[18];
            int   sqinds[18];
   unsigned int   sqharm[18];
   unsigned int   *sqharc[18];
   unsigned short  sqadto[18];
   unsigned short  sqtdso[18];
} sqlstm = {10,18};

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
"select PRV_BLNG_GRP_ID ,PRV_BLNG_CLASS_CODE ,PRV_CUST_CODE ,PRV_CREDIT_DOC_R\
EF_DESC ,TO_CHAR(PRV_CREDIT_DOC_REF_DATE,'DD/MM/YYYY') ,PRV_SLMT_TYPE_CODE ,CH\
G_BLNG_GRP_ID ,CHG_BLNG_CLASS_CODE ,CHG_CREDIT_DOC_REF_DESC ,TO_CHAR(CHG_CREDI\
T_DOC_REF_DATE,'DD/MM/YYYY') ,CHG_CUST_CODE ,CHG_SLMT_TYPE_CODE ,PRV_MODIFIED_\
BY_ID ,TO_CHAR(PRV_MODIFIED_DATE,'DD/MM/YYYY') ,CHG_MODIFIED_BY_ID ,TO_CHAR(CH\
G_MODIFIED_DATE,'DD/MM/YYYY') ,ADDED_BY_ID ,TO_CHAR(ADDED_DATE,'DD/MM/YYYY')  \
from BL_FIN_DTLS_AUDIT_TRAIL where AUDIT_TRAIL_NO=to_number(:b0)           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,130,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,30,180,0,0,0,0,0,1,0,
51,0,0,3,128,0,4,195,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
82,0,0,4,202,0,4,228,0,0,10,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
137,0,0,5,84,0,2,261,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
164,0,0,7,69,0,4,308,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
187,0,0,8,246,0,4,341,0,0,11,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
246,0,0,9,99,0,4,368,0,0,2,1,0,1,0,2,3,0,0,1,9,0,0,
269,0,0,6,541,0,9,420,0,0,1,1,0,1,0,1,9,0,0,
288,0,0,6,0,0,13,426,0,0,18,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,
375,0,0,10,205,0,4,493,0,0,7,5,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,
418,0,0,11,66,0,4,506,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
441,0,0,12,66,0,4,512,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
464,0,0,13,72,0,4,518,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
487,0,0,14,72,0,4,524,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
510,0,0,15,64,0,4,532,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
533,0,0,16,64,0,4,540,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
556,0,0,17,70,0,4,548,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
579,0,0,18,70,0,4,554,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
602,0,0,19,201,0,6,707,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
629,0,0,20,222,0,6,728,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
};


#define ONLINE_PRINTING 1
#define ESC 0x1B 
#define bold 0x45
#define norm 0x46
#include <stdio.h>    
#include <string.h>      
#include "bl.h"
  
#define OERROR (sqlca.sqlcode < 0)   
 
#define LAST_ROW (sqlca.sqlcode == 1403)

/* EXEC SQL BEGIN DECLARE SECTION; */ 


    /* VARCHAR uid_pwd              [91],
	   d_session_id             [16],
 	   hosp_name                [120],
	   date_time                [20],
	   user_id                  [20],
	   nd_facility_id           [3],
	   d_pgm_date               [14],
       rep_date                 [20],
       oper_id                  [21],
       d_curr_pgm_name          [15]; */ 
struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[16]; } d_session_id;

struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[20]; } user_id;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[14]; } d_pgm_date;

struct { unsigned short len; unsigned char arr[20]; } rep_date;

struct { unsigned short len; unsigned char arr[21]; } oper_id;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;


    /* VARCHAR nd_hosp_name         [61],
		h_practice_num			 [31],
		h_ln1_add				 [31],
		h_ln2_add				 [31],
		h_ln3_add				 [31],
		h_zip_code				 [31],
		h_tel_num				 [31],
		h_fax_num			     [31],
        h_email_id   [31],
	    nd_patient_id            [21],
	    nd_audit_trail_no        [21],
		nd_episode_type 		[2],
	    nd_episode_id		[9],
	    nd_visit_id			[5],
	    nd_patient_name          [101],

		ND_PRV_BLNG_GRP_ID       [5],          
		ND_PRV_BLNG_CLASS_ID     [3],
 	    ND_PRV_CUST_CODE		 [9],       
   	    ND_PRV_CREDIT_DOC_REF    [31],        
	    ND_PRV_SLMT_TYPE_CODE     [3],             
	    ND_CHG_BLNG_GRP_ID        [5],                
		ND_CHG_BLNG_CLASS_ID      [3],
	    ND_CHG_CREDIT_DOC_REF_DESC [31],        
        ND_CHG_CUST_CODE          [9],                  
        ND_CHG_SLMT_TYPE_CODE     [3],
	    ND_PRV_MODIFIED_BY_ID     [31],     
	    ND_CHG_MODIFIED_BY_ID     [31],
        ND_ADDED_BY_ID            [31],    
		nd_prv_added_by_id        [31], 
		nd_prv_blng_grp_desc      [101],
		ND_CHG_BLNG_GRP_DESC      [101],
		nd_prv_blng_class_desc    [16],
		nd_chg_blng_class_desc    [16],
		nd_prv_cust_name   		  [101], 
		p_language_id				[3],
		nd_chg_cust_name    [101],
		nd_prv_sett_type_desc [16],
		nd_chg_sett_type_desc [16],
        ND_PRV_CREDIT_DOC_REF_DT [20],        
		ND_CHG_CREDIT_DOC_REF_DT [20],        
		ND_PRV_MODIFIED_DATE [20],
        ND_CHG_MODIFIED_DATE [20],
	    ND_ADDED_DATE [20],
		nd_prv_added_date [20],
		nd_report_id[10]; */ 
struct { unsigned short len; unsigned char arr[61]; } nd_hosp_name;

struct { unsigned short len; unsigned char arr[31]; } h_practice_num;

struct { unsigned short len; unsigned char arr[31]; } h_ln1_add;

struct { unsigned short len; unsigned char arr[31]; } h_ln2_add;

struct { unsigned short len; unsigned char arr[31]; } h_ln3_add;

struct { unsigned short len; unsigned char arr[31]; } h_zip_code;

struct { unsigned short len; unsigned char arr[31]; } h_tel_num;

struct { unsigned short len; unsigned char arr[31]; } h_fax_num;

struct { unsigned short len; unsigned char arr[31]; } h_email_id;

struct { unsigned short len; unsigned char arr[21]; } nd_patient_id;

struct { unsigned short len; unsigned char arr[21]; } nd_audit_trail_no;

struct { unsigned short len; unsigned char arr[2]; } nd_episode_type;

struct { unsigned short len; unsigned char arr[9]; } nd_episode_id;

struct { unsigned short len; unsigned char arr[5]; } nd_visit_id;

struct { unsigned short len; unsigned char arr[101]; } nd_patient_name;

struct { unsigned short len; unsigned char arr[5]; } ND_PRV_BLNG_GRP_ID;

struct { unsigned short len; unsigned char arr[3]; } ND_PRV_BLNG_CLASS_ID;

struct { unsigned short len; unsigned char arr[9]; } ND_PRV_CUST_CODE;

struct { unsigned short len; unsigned char arr[31]; } ND_PRV_CREDIT_DOC_REF;

struct { unsigned short len; unsigned char arr[3]; } ND_PRV_SLMT_TYPE_CODE;

struct { unsigned short len; unsigned char arr[5]; } ND_CHG_BLNG_GRP_ID;

struct { unsigned short len; unsigned char arr[3]; } ND_CHG_BLNG_CLASS_ID;

struct { unsigned short len; unsigned char arr[31]; } ND_CHG_CREDIT_DOC_REF_DESC;

struct { unsigned short len; unsigned char arr[9]; } ND_CHG_CUST_CODE;

struct { unsigned short len; unsigned char arr[3]; } ND_CHG_SLMT_TYPE_CODE;

struct { unsigned short len; unsigned char arr[31]; } ND_PRV_MODIFIED_BY_ID;

struct { unsigned short len; unsigned char arr[31]; } ND_CHG_MODIFIED_BY_ID;

struct { unsigned short len; unsigned char arr[31]; } ND_ADDED_BY_ID;

struct { unsigned short len; unsigned char arr[31]; } nd_prv_added_by_id;

struct { unsigned short len; unsigned char arr[101]; } nd_prv_blng_grp_desc;

struct { unsigned short len; unsigned char arr[101]; } ND_CHG_BLNG_GRP_DESC;

struct { unsigned short len; unsigned char arr[16]; } nd_prv_blng_class_desc;

struct { unsigned short len; unsigned char arr[16]; } nd_chg_blng_class_desc;

struct { unsigned short len; unsigned char arr[101]; } nd_prv_cust_name;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[101]; } nd_chg_cust_name;

struct { unsigned short len; unsigned char arr[16]; } nd_prv_sett_type_desc;

struct { unsigned short len; unsigned char arr[16]; } nd_chg_sett_type_desc;

struct { unsigned short len; unsigned char arr[20]; } ND_PRV_CREDIT_DOC_REF_DT;

struct { unsigned short len; unsigned char arr[20]; } ND_CHG_CREDIT_DOC_REF_DT;

struct { unsigned short len; unsigned char arr[20]; } ND_PRV_MODIFIED_DATE;

struct { unsigned short len; unsigned char arr[20]; } ND_CHG_MODIFIED_DATE;

struct { unsigned short len; unsigned char arr[20]; } ND_ADDED_DATE;

struct { unsigned short len; unsigned char arr[20]; } nd_prv_added_date;

struct { unsigned short len; unsigned char arr[10]; } nd_report_id;


/* VARCHAR     nd_temp_date[20],
			nd_loc_date	[20],
			date_convert[20]; */ 
struct { unsigned short len; unsigned char arr[20]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[20]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[20]; } date_convert;


/* VARCHAR     nd_temp_date1 [20],
			nd_loc_date1  [20],
			date_convert1 [20]; */ 
struct { unsigned short len; unsigned char arr[20]; } nd_temp_date1;

struct { unsigned short len; unsigned char arr[20]; } nd_loc_date1;

struct { unsigned short len; unsigned char arr[20]; } date_convert1;
			
		
int     nd_hosp_name_len,
        nd_bill_doc_num;

int d_rfq_line_num,pctr =0,
    count;

    
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




#include "winproc.h"
char string_var[100];

FILE *f1;

int page_no,
    line_no,
    first_line,
    g_count;

char file_name[500];

void proc_main(argc,argv)
int argc;
char *argv[];
{

    if(argc < 5) {
	  disp_message(ERR_MESG,"Usage BLRVSTFN userid/password session_id pgm_date facility_id \n");
	  proc_exit();
    }

    strcpy(g_pgm_id,"BLRVSTFN");


    strcpy(d_curr_pgm_name.arr,g_pgm_id); 
    d_curr_pgm_name.len = strlen(d_curr_pgm_name.arr); 

    strcpy(uid_pwd.arr,argv[1]);
    uid_pwd.len = strlen(uid_pwd.arr);

    strcpy(d_session_id.arr,argv[2]);
    d_session_id.len = strlen(d_session_id.arr);
    
    strcpy(d_pgm_date.arr,argv[3]);
    d_pgm_date.len = strlen(d_pgm_date.arr);
	

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



    if(OERROR) 
    {
      disp_message(ORA_MESG,"Unable to connect to oracle.\n");
      sprintf(string_var, "%s\n",sqlca.sqlerrm.sqlerrmc);
      disp_message(ORA_MESG,string_var);
      proc_exit();
    }

	set_meduser_role();	

    strcpy(p_language_id.arr,l_language_id.arr);
    p_language_id.len = l_language_id.len;
	
	fetch_prog_param();

    strcpy(file_name,WORKING_DIR);		
    strcat(file_name,"blrvstfn.lis");

    if( (f1=fopen(file_name,"w")) == NULL) 
    {
      disp_message(ERR_MESG,"Error in opening output file...\n");
      proc_exit();
    }
    fetch_desc();
    decl_curs();
    fetch_recs();    	
    print_notification();

    fclose(f1);

     /*print_online(uid_pwd.arr, "BLRCRAGR", "O", "", "BLRCRAGR.LIS", "R");*/

   PrintDocument 
      (
		uid_pwd.arr,		//char	*PUidPwd;
		d_session_id.arr,	//char	*PSessionID; 
		nd_facility_id.arr,	//char	*PFacilityID;  
		"BL",				//char	*PModuleID;
		nd_report_id.arr,  //"BLRVSTFN",			//char	*PDocumentID;
		file_name,			//char	*POnlinePrintFileNames;
		"O",				//char	*PLocationTypes;
		" ",				//char	*PLocationCodes;
		1,					//int		PNumOfCopies;
		1,					//int		PPageFrom;
		1					//int		PPageTo;
	);


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
}



    return;
}

fetch_desc()
{
   hosp_name.arr[0]      = '\0';
   date_time.arr[0]      = '\0';
   user_id.arr[0]        = '\0';

   hosp_name.len      = 0;
   date_time.len      = 0;
   user_id.len        = 0;

   /* EXEC SQL SELECT ACCOUNTING_NAME, TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
		   USER
	      INTO :hosp_name, :date_time, :user_id
	      FROM SY_ACC_ENTITY
		  WHERE acc_entity_id = :nd_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select ACCOUNTING_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:M\
I') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY where acc_entity_id=:b3";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )51;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
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
   sqlstm.sqhstl[2] = (unsigned int  )22;
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

   hosp_name.arr[hosp_name.len]           = '\0';
   date_time.arr[date_time.len]           = '\0';
   user_id.arr[user_id.len]               = '\0';

}


fetch_prog_param()
{
   	nd_facility_id.arr[0]    = '\0';
    nd_audit_trail_no.arr[0] = '\0';
	nd_patient_id.arr[0]     = '\0';
	nd_episode_type.arr[0]   = '\0';
    nd_episode_id.arr[0]     = '\0';
    nd_visit_id.arr[0]     = '\0';

	nd_facility_id.len       = 0;
	nd_patient_id.len        = 0;   
	nd_audit_trail_no.len    = 0;   
    nd_episode_type.len      = 0;
	nd_episode_id.len        = 0;   
    nd_visit_id.len    = 0;

   
	/* EXEC SQL SELECT operating_facility_id,
			PARAM1, /o  PATIENT_ID           o/
			PARAM2,         /o  EPSODE TYPE   o/
			PARAM3,         /o  EPISODE ID         o/
			PARAM4,         /o  AUDIT TRAIL NO  o/
			param5,
			NVL(PARAM6,'BLRVSTFN')
	 INTO   :nd_facility_id,
	        :nd_patient_id,
  	        :nd_episode_type,
		    :nd_episode_id,
			:nd_visit_id,
		    :nd_audit_trail_no,
			:nd_report_id
	 FROM   SY_PROG_PARAM
     WHERE  PGM_ID     = :d_curr_pgm_name
     AND    SESSION_ID = :d_session_id
     AND    PGM_DATE   = :d_pgm_date; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select operating_facility_id ,PARAM1 ,PARAM2 ,PARAM3 ,PARAM4\
 ,param5 ,NVL(PARAM6,'BLRVSTFN') into :b0,:b1,:b2,:b3,:b4,:b5,:b6  from SY_PRO\
G_PARAM where ((PGM_ID=:b7 and SESSION_ID=:b8) and PGM_DATE=:b9)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )82;
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
 sqlstm.sqhstv[2] = (         void  *)&nd_episode_type;
 sqlstm.sqhstl[2] = (unsigned int  )4;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_episode_id;
 sqlstm.sqhstl[3] = (unsigned int  )11;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_visit_id;
 sqlstm.sqhstl[4] = (unsigned int  )7;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_audit_trail_no;
 sqlstm.sqhstl[5] = (unsigned int  )23;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&nd_report_id;
 sqlstm.sqhstl[6] = (unsigned int  )12;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&d_curr_pgm_name;
 sqlstm.sqhstl[7] = (unsigned int  )17;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&d_session_id;
 sqlstm.sqhstl[8] = (unsigned int  )18;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&d_pgm_date;
 sqlstm.sqhstl[9] = (unsigned int  )16;
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


  
   if ( OERROR) 
        err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   if (NO_DATA_FOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");

	nd_facility_id.arr[nd_facility_id.len] 			= '\0';
    nd_patient_id.arr[nd_patient_id.len]                  = '\0';
	nd_episode_type.arr[nd_episode_type.len]  		= '\0';
	nd_episode_id.arr[nd_episode_id.len]                  = '\0';
	nd_audit_trail_no.arr[nd_audit_trail_no.len]          = '\0';
	nd_visit_id.arr[nd_visit_id.len]          = '\0';
	nd_report_id.arr[nd_report_id.len] = '\0';

   /* EXEC SQL DELETE SY_PROG_PARAM
             WHERE PGM_ID     = :d_curr_pgm_name
               AND SESSION_ID = :d_session_id
               AND PGM_DATE   = :d_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 10;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID=:b0 and SESSION\
_ID=:b1) and PGM_DATE=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )137;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_curr_pgm_name;
   sqlstm.sqhstl[0] = (unsigned int  )17;
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
   sqlstm.sqhstv[2] = (         void  *)&d_pgm_date;
   sqlstm.sqhstl[2] = (unsigned int  )16;
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

decl_curs()
{
  /* EXEC SQL DECLARE FIN_DTLS_AUDIT_TRAIL_CUR CURSOR FOR
  	   SELECT PRV_BLNG_GRP_ID,  
  	    PRV_BLNG_CLASS_CODE ,
	    PRV_CUST_CODE,
   	    PRV_CREDIT_DOC_REF_DESC,        
	    TO_CHAR(PRV_CREDIT_DOC_REF_DATE, 'DD/MM/YYYY'), 
		--PRV_CREDIT_DOC_REF_DATE 9450
	    PRV_SLMT_TYPE_CODE,             
	    CHG_BLNG_GRP_ID,                
		CHG_BLNG_CLASS_CODE,
	    CHG_CREDIT_DOC_REF_DESC,        
        TO_CHAR(CHG_CREDIT_DOC_REF_DATE ,'DD/MM/YYYY'),   
        --CHG_CREDIT_DOC_REF_DATE		,9450
        CHG_CUST_CODE,                  
        CHG_SLMT_TYPE_CODE,
	    PRV_MODIFIED_BY_ID,     
	    TO_CHAR(PRV_MODIFIED_DATE, 'DD/MM/YYYY') ,
		--PRV_MODIFIED_DATE,9450
	    CHG_MODIFIED_BY_ID,
        TO_CHAR(CHG_MODIFIED_DATE , 'DD/MM/YYYY'),
		--CHG_MODIFIED_DATE,9450
        ADDED_BY_ID,    
	    TO_CHAR(ADDED_DATE , 'DD/MM/YYYY')
		--ADDED_DATE,9450
   FROM  BL_FIN_DTLS_AUDIT_TRAIL
   WHERE AUDIT_TRAIL_NO  = to_number(:nd_audit_trail_no); */ 

   
	      
		  /*PATIENT_ID      = :nd_patient_id  AND
          EPISODE_TYPE    = :nd_episode_type   AND
          episode_id      = to_number(:nd_episode_id) AND
          visit_id        = to_number(:nd_visit_id); */

     nd_patient_name.arr[0]     = '\0';
     nd_patient_name.len       = 0;

     /* EXEC SQL SELECT  SHORT_NAME INTO :nd_patient_name FROM MP_PATIENT_MAST
     WHERE   PATIENT_ID = :nd_patient_id; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 10;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select SHORT_NAME into :b0  from MP_PATIENT_MAST where P\
ATIENT_ID=:b1";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )164;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_patient_name;
     sqlstm.sqhstl[0] = (unsigned int  )103;
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
         err_mesg("SELECT  failed on table MP_PATIENT_MAST",0,"");

     nd_patient_name.arr[nd_patient_name.len] 			= '\0';

	 nd_hosp_name.len    = 0;
	 h_practice_num.len    = 0; 
	 h_ln1_add.len		   = 0;
	 h_ln2_add.len		   = 0;
	 h_ln3_add.len		   = 0;
	 h_zip_code.len		   = 0;
	 h_tel_num.len		   = 0;
	 h_fax_num.len		   = 0;
	 h_email_id.len		   = 0;
 
    date_time.arr[0]      = '\0';
	date_time.len  = 0;

	 nd_hosp_name.arr [ nd_hosp_name.len ]		   = '\0';
	 h_practice_num.arr [ h_practice_num.len ]		   = '\0';
	 h_ln1_add.arr [ h_ln1_add.len ]		   = '\0';
	 h_ln2_add.arr [ h_ln2_add.len ]		   = '\0';
	 h_ln3_add.arr [ h_ln3_add.len ]		   = '\0';
	 h_zip_code.arr [ h_zip_code.len ]		   = '\0';
	 h_tel_num.arr [ h_tel_num.len ]				   = '\0';
	 h_fax_num.arr [ h_fax_num.len ]				   = '\0';
	 h_email_id.arr [ h_email_id.len ]				   = '\0';



/* EXEC SQL SELECT accounting_name, 
           TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'), 
		   PRACTICE_NUM, LN1_ADD, LN2_ADD, LN3_ADD,
					 TEL_NUM, FAX_NUM, ZIP_CODE, ACC_ENTITY_NAME_LOC_LANG
		 INTO	:nd_hosp_name, 
		        :date_time, :h_practice_num, :h_ln1_add, :h_ln2_add, :h_ln3_add,
				:h_tel_num, :h_fax_num, :h_zip_code, :h_email_id
		 FROM	SY_ACC_ENTITY
		 WHERE acc_entity_id = :nd_facility_id; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 11;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select accounting_name ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI')\
 ,PRACTICE_NUM ,LN1_ADD ,LN2_ADD ,LN3_ADD ,TEL_NUM ,FAX_NUM ,ZIP_CODE ,ACC_ENT\
ITY_NAME_LOC_LANG into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9  from SY_ACC_EN\
TITY where acc_entity_id=:b10";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )187;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&nd_hosp_name;
sqlstm.sqhstl[0] = (unsigned int  )63;
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
sqlstm.sqhstv[2] = (         void  *)&h_practice_num;
sqlstm.sqhstl[2] = (unsigned int  )33;
sqlstm.sqhsts[2] = (         int  )0;
sqlstm.sqindv[2] = (         void  *)0;
sqlstm.sqinds[2] = (         int  )0;
sqlstm.sqharm[2] = (unsigned int  )0;
sqlstm.sqadto[2] = (unsigned short )0;
sqlstm.sqtdso[2] = (unsigned short )0;
sqlstm.sqhstv[3] = (         void  *)&h_ln1_add;
sqlstm.sqhstl[3] = (unsigned int  )33;
sqlstm.sqhsts[3] = (         int  )0;
sqlstm.sqindv[3] = (         void  *)0;
sqlstm.sqinds[3] = (         int  )0;
sqlstm.sqharm[3] = (unsigned int  )0;
sqlstm.sqadto[3] = (unsigned short )0;
sqlstm.sqtdso[3] = (unsigned short )0;
sqlstm.sqhstv[4] = (         void  *)&h_ln2_add;
sqlstm.sqhstl[4] = (unsigned int  )33;
sqlstm.sqhsts[4] = (         int  )0;
sqlstm.sqindv[4] = (         void  *)0;
sqlstm.sqinds[4] = (         int  )0;
sqlstm.sqharm[4] = (unsigned int  )0;
sqlstm.sqadto[4] = (unsigned short )0;
sqlstm.sqtdso[4] = (unsigned short )0;
sqlstm.sqhstv[5] = (         void  *)&h_ln3_add;
sqlstm.sqhstl[5] = (unsigned int  )33;
sqlstm.sqhsts[5] = (         int  )0;
sqlstm.sqindv[5] = (         void  *)0;
sqlstm.sqinds[5] = (         int  )0;
sqlstm.sqharm[5] = (unsigned int  )0;
sqlstm.sqadto[5] = (unsigned short )0;
sqlstm.sqtdso[5] = (unsigned short )0;
sqlstm.sqhstv[6] = (         void  *)&h_tel_num;
sqlstm.sqhstl[6] = (unsigned int  )33;
sqlstm.sqhsts[6] = (         int  )0;
sqlstm.sqindv[6] = (         void  *)0;
sqlstm.sqinds[6] = (         int  )0;
sqlstm.sqharm[6] = (unsigned int  )0;
sqlstm.sqadto[6] = (unsigned short )0;
sqlstm.sqtdso[6] = (unsigned short )0;
sqlstm.sqhstv[7] = (         void  *)&h_fax_num;
sqlstm.sqhstl[7] = (unsigned int  )33;
sqlstm.sqhsts[7] = (         int  )0;
sqlstm.sqindv[7] = (         void  *)0;
sqlstm.sqinds[7] = (         int  )0;
sqlstm.sqharm[7] = (unsigned int  )0;
sqlstm.sqadto[7] = (unsigned short )0;
sqlstm.sqtdso[7] = (unsigned short )0;
sqlstm.sqhstv[8] = (         void  *)&h_zip_code;
sqlstm.sqhstl[8] = (unsigned int  )33;
sqlstm.sqhsts[8] = (         int  )0;
sqlstm.sqindv[8] = (         void  *)0;
sqlstm.sqinds[8] = (         int  )0;
sqlstm.sqharm[8] = (unsigned int  )0;
sqlstm.sqadto[8] = (unsigned short )0;
sqlstm.sqtdso[8] = (unsigned short )0;
sqlstm.sqhstv[9] = (         void  *)&h_email_id;
sqlstm.sqhstl[9] = (unsigned int  )33;
sqlstm.sqhsts[9] = (         int  )0;
sqlstm.sqindv[9] = (         void  *)0;
sqlstm.sqinds[9] = (         int  )0;
sqlstm.sqharm[9] = (unsigned int  )0;
sqlstm.sqadto[9] = (unsigned short )0;
sqlstm.sqtdso[9] = (unsigned short )0;
sqlstm.sqhstv[10] = (         void  *)&nd_facility_id;
sqlstm.sqhstl[10] = (unsigned int  )5;
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
        err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");

	 nd_hosp_name.arr [ nd_hosp_name.len ]		   = '\0';

	 date_time.arr [ date_time.len ]		   = '\0';

	 h_practice_num.arr [ h_practice_num.len ]		   = '\0';
	 h_ln1_add.arr [ h_ln1_add.len ]		   = '\0';
	 h_ln2_add.arr [ h_ln2_add.len ]		   = '\0';
	 h_ln3_add.arr [ h_ln3_add.len ]		   = '\0';
     h_tel_num.arr [ h_tel_num.len ]				   = '\0';
	 h_fax_num.arr [ h_fax_num.len ]				   = '\0';
	 h_zip_code.arr [ h_zip_code.len ]		   = '\0';
	 h_email_id.arr [ h_email_id.len ]		   = '\0';
	 

/* EXEC SQL SELECT round((61-length(ACC_ENTITY_NAME))/2) INTO :nd_hosp_name_len 
FROM SY_ACC_ENTITY
WHERE acc_entity_id = :nd_facility_id; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 11;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select round(((61-length(ACC_ENTITY_NAME))/2)) into :b0  from\
 SY_ACC_ENTITY where acc_entity_id=:b1";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )246;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&nd_hosp_name_len;
sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
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
}


 fetch_recs()
{

   	    ND_PRV_BLNG_GRP_ID.arr[0]           = '\0';
		ND_PRV_BLNG_CLASS_ID.arr[0]         = '\0';
	    ND_PRV_CUST_CODE.arr[0]             = '\0';
   	    ND_PRV_CREDIT_DOC_REF.arr[0]        = '\0';
	    ND_PRV_CREDIT_DOC_REF_DT.arr[0]     = '\0';
	    ND_PRV_SLMT_TYPE_CODE.arr[0]        = '\0';
	    ND_CHG_BLNG_GRP_ID.arr[0]           = '\0';
		ND_CHG_BLNG_CLASS_ID.arr[0]			= '\0';
	    ND_CHG_CREDIT_DOC_REF_DESC.arr[0]   = '\0';
        ND_CHG_CREDIT_DOC_REF_DT.arr[0]     = '\0';
        ND_CHG_CUST_CODE.arr[0]             = '\0';
        ND_CHG_SLMT_TYPE_CODE.arr[0]        = '\0';
	    ND_PRV_MODIFIED_BY_ID.arr[0]        = '\0';
	    ND_PRV_MODIFIED_DATE.arr[0]         = '\0';
	    ND_CHG_MODIFIED_BY_ID.arr[0]        = '\0';
        ND_CHG_MODIFIED_DATE.arr[0]         = '\0';
        ND_ADDED_BY_ID.arr[0]               = '\0';
	    ND_ADDED_DATE.arr[0]                = '\0';

	    ND_PRV_BLNG_GRP_ID.len = 0;
		ND_PRV_BLNG_CLASS_ID.len = 0;
	    ND_PRV_CUST_CODE.len = 0;
   	    ND_PRV_CREDIT_DOC_REF.len = 0;
	    ND_PRV_CREDIT_DOC_REF_DT.len = 0;
	    ND_PRV_SLMT_TYPE_CODE.len = 0;
	    ND_CHG_BLNG_GRP_ID.len = 0;
		ND_CHG_BLNG_GRP_ID.len = 0;
	    ND_CHG_CREDIT_DOC_REF_DESC.len = 0;
        ND_CHG_CREDIT_DOC_REF_DT.len = 0;
        ND_CHG_CUST_CODE.len = 0;
        ND_CHG_SLMT_TYPE_CODE.len = 0;
	    ND_PRV_MODIFIED_BY_ID.len = 0;
	    ND_PRV_MODIFIED_DATE.len = 0;
	    ND_CHG_MODIFIED_BY_ID.len = 0;
        ND_CHG_MODIFIED_DATE.len = 0;
        ND_ADDED_BY_ID.len = 0;
	    ND_ADDED_DATE.len = 0;

	
   /* EXEC SQL OPEN FIN_DTLS_AUDIT_TRAIL_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0006;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )269;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_audit_trail_no;
   sqlstm.sqhstl[0] = (unsigned int  )23;
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



    if (OERROR)
         err_mesg("OPEN failed on cursor FIN_DTLS_AUDIT_TRAIL_CUR",0,"");


   /* EXEC SQL FETCH FIN_DTLS_AUDIT_TRAIL_CUR 
	    INTO  :ND_PRV_BLNG_GRP_ID,          
		:ND_PRV_BLNG_CLASS_ID,
	    :ND_PRV_CUST_CODE,                  
   	    :ND_PRV_CREDIT_DOC_REF,        
	    :ND_PRV_CREDIT_DOC_REF_DT,        
	    :ND_PRV_SLMT_TYPE_CODE,             
	    :ND_CHG_BLNG_GRP_ID,
		:ND_CHG_BLNG_CLASS_ID,
	    :ND_CHG_CREDIT_DOC_REF_DESC,        
        :ND_CHG_CREDIT_DOC_REF_DT,        
        :ND_CHG_CUST_CODE,                  
        :ND_CHG_SLMT_TYPE_CODE,
	    :ND_PRV_MODIFIED_BY_ID,     
	    :ND_PRV_MODIFIED_DATE ,
	    :ND_CHG_MODIFIED_BY_ID,
        :ND_CHG_MODIFIED_DATE ,
        :ND_ADDED_BY_ID,    
	    :ND_ADDED_DATE ; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 18;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )288;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&ND_PRV_BLNG_GRP_ID;
   sqlstm.sqhstl[0] = (unsigned int  )7;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&ND_PRV_BLNG_CLASS_ID;
   sqlstm.sqhstl[1] = (unsigned int  )5;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&ND_PRV_CUST_CODE;
   sqlstm.sqhstl[2] = (unsigned int  )11;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&ND_PRV_CREDIT_DOC_REF;
   sqlstm.sqhstl[3] = (unsigned int  )33;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&ND_PRV_CREDIT_DOC_REF_DT;
   sqlstm.sqhstl[4] = (unsigned int  )22;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&ND_PRV_SLMT_TYPE_CODE;
   sqlstm.sqhstl[5] = (unsigned int  )5;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&ND_CHG_BLNG_GRP_ID;
   sqlstm.sqhstl[6] = (unsigned int  )7;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&ND_CHG_BLNG_CLASS_ID;
   sqlstm.sqhstl[7] = (unsigned int  )5;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&ND_CHG_CREDIT_DOC_REF_DESC;
   sqlstm.sqhstl[8] = (unsigned int  )33;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&ND_CHG_CREDIT_DOC_REF_DT;
   sqlstm.sqhstl[9] = (unsigned int  )22;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&ND_CHG_CUST_CODE;
   sqlstm.sqhstl[10] = (unsigned int  )11;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&ND_CHG_SLMT_TYPE_CODE;
   sqlstm.sqhstl[11] = (unsigned int  )5;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&ND_PRV_MODIFIED_BY_ID;
   sqlstm.sqhstl[12] = (unsigned int  )33;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&ND_PRV_MODIFIED_DATE;
   sqlstm.sqhstl[13] = (unsigned int  )22;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&ND_CHG_MODIFIED_BY_ID;
   sqlstm.sqhstl[14] = (unsigned int  )33;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&ND_CHG_MODIFIED_DATE;
   sqlstm.sqhstl[15] = (unsigned int  )22;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&ND_ADDED_BY_ID;
   sqlstm.sqhstl[16] = (unsigned int  )33;
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&ND_ADDED_DATE;
   sqlstm.sqhstl[17] = (unsigned int  )22;
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



   if (OERROR)
         err_mesg("FETCH failed on cursor FIN_DTLS_AUDIT_TRAIL_CUR",0,"");



	    ND_PRV_BLNG_GRP_ID.arr[ND_PRV_BLNG_GRP_ID.len]           = '\0';
		ND_PRV_BLNG_CLASS_ID.arr[ND_PRV_BLNG_CLASS_ID.len]		 = '\0';
	    ND_PRV_CUST_CODE.arr[ND_PRV_CUST_CODE.len]           = '\0';
   	    ND_PRV_CREDIT_DOC_REF.arr[ND_PRV_CREDIT_DOC_REF.len]           = '\0';
	    ND_PRV_CREDIT_DOC_REF_DT.arr[ND_PRV_CREDIT_DOC_REF_DT.len]           = '\0';
	    ND_PRV_SLMT_TYPE_CODE.arr[ND_PRV_SLMT_TYPE_CODE.len]           = '\0';
	    ND_CHG_BLNG_GRP_ID.arr[ND_CHG_BLNG_GRP_ID.len]           = '\0';
		ND_CHG_BLNG_CLASS_ID.arr[ND_CHG_BLNG_GRP_ID.len]  = '\0';
	    ND_CHG_CREDIT_DOC_REF_DESC.arr[ND_CHG_CREDIT_DOC_REF_DESC.len]           = '\0';
        ND_CHG_CREDIT_DOC_REF_DT.arr[ND_CHG_CREDIT_DOC_REF_DT.len]           = '\0';
        ND_CHG_CUST_CODE.arr[ND_CHG_CUST_CODE.len]           = '\0';
        ND_CHG_SLMT_TYPE_CODE.arr[ND_CHG_SLMT_TYPE_CODE.len]           = '\0';
	    ND_PRV_MODIFIED_BY_ID.arr[ND_PRV_MODIFIED_BY_ID.len]           = '\0';
	    ND_PRV_MODIFIED_DATE.arr[ND_PRV_MODIFIED_DATE.len]           = '\0';
	    ND_CHG_MODIFIED_BY_ID.arr[ND_CHG_MODIFIED_BY_ID.len]           = '\0';
        ND_CHG_MODIFIED_DATE.arr[ND_CHG_MODIFIED_DATE.len]           = '\0';
        ND_ADDED_BY_ID.arr[ND_ADDED_BY_ID.len]           = '\0';
	    ND_ADDED_DATE.arr[ND_ADDED_DATE.len]           = '\0';


	    nd_prv_added_by_id.arr[0]     = '\0';
	    nd_prv_added_date.arr[0]     = '\0';
	    nd_prv_blng_grp_desc.arr[0]     = '\0';
		nd_prv_blng_class_desc.arr[0]   = '\0';
	    ND_CHG_BLNG_GRP_DESC.arr[0]     = '\0';
		nd_chg_blng_class_desc.arr[0]     = '\0';
	    nd_prv_cust_name.arr[0]     = '\0'; 
	    nd_chg_cust_name.arr[0]     = '\0';
	    nd_prv_sett_type_desc.arr[0]     = '\0';
	    nd_chg_sett_type_desc.arr[0]     = '\0';

	    nd_prv_added_by_id.len     = 0;    
	    nd_prv_added_date.len     = 0;
	    nd_prv_blng_grp_desc.len= 0;
	    ND_CHG_BLNG_GRP_DESC.len= 0;
		nd_chg_blng_class_desc.len =0;
	    nd_prv_cust_name.len= 0;
		nd_prv_blng_class_desc.len =0;
	    nd_chg_cust_name.len= 0;
	    nd_prv_sett_type_desc.len= 0;
	    nd_chg_sett_type_desc.len= 0;

   /* EXEC SQL SELECT added_by_id , to_char(added_date,'DD/MM/YYYY') 
            INTO :nd_prv_added_by_id , :nd_prv_added_date
            from bl_visit_fin_dtls 
		   where operating_facility_id = :nd_facility_id AND
	   	         PATIENT_ID      = :nd_patient_id  AND
		         EPISODE_TYPE    = :nd_episode_type   AND
	             episode_id      = :nd_episode_id  AND
                 visit_id        = :nd_visit_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 18;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select added_by_id ,to_char(added_date,'DD/MM/YYYY') into \
:b0,:b1  from bl_visit_fin_dtls where ((((operating_facility_id=:b2 and PATIEN\
T_ID=:b3) and EPISODE_TYPE=:b4) and episode_id=:b5) and visit_id=:b6)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )375;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_prv_added_by_id;
   sqlstm.sqhstl[0] = (unsigned int  )33;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_prv_added_date;
   sqlstm.sqhstl[1] = (unsigned int  )22;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_facility_id;
   sqlstm.sqhstl[2] = (unsigned int  )5;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_patient_id;
   sqlstm.sqhstl[3] = (unsigned int  )23;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_episode_type;
   sqlstm.sqhstl[4] = (unsigned int  )4;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_episode_id;
   sqlstm.sqhstl[5] = (unsigned int  )11;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_visit_id;
   sqlstm.sqhstl[6] = (unsigned int  )7;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
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
         err_mesg("SELECT failed on table BL_VISIT_FIN_DTLS",0,"");
           

   /* EXEC SQL select SHORT_DESC into :nd_prv_blng_grp_desc from  bl_blng_grp
   WHERE blng_grp_id = :ND_PRV_BLNG_GRP_ID ; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 18;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select SHORT_DESC into :b0  from bl_blng_grp where blng_gr\
p_id=:b1";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )418;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_prv_blng_grp_desc;
   sqlstm.sqhstl[0] = (unsigned int  )103;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&ND_PRV_BLNG_GRP_ID;
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



   if (OERROR)
         err_mesg("SELECT failed on table BL_BLNG_GRP",0,"");

   /* EXEC SQL select SHORT_DESC into :ND_CHG_BLNG_GRP_DESC from  bl_blng_grp
   WHERE blng_grp_id = :ND_CHG_BLNG_GRP_ID ; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 18;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select SHORT_DESC into :b0  from bl_blng_grp where blng_gr\
p_id=:b1";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )441;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&ND_CHG_BLNG_GRP_DESC;
   sqlstm.sqhstl[0] = (unsigned int  )103;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&ND_CHG_BLNG_GRP_ID;
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



   if (OERROR)
         err_mesg("SELECT failed on table BL_BLNG_GRP",0,"");

   /* EXEC SQL select SHORT_DESC into :nd_prv_blng_class_desc from  bl_blng_class
   WHERE BLNG_CLASS_CODE = :ND_PRV_BLNG_CLASS_ID ; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 18;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select SHORT_DESC into :b0  from bl_blng_class where BLNG_\
CLASS_CODE=:b1";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )464;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_prv_blng_class_desc;
   sqlstm.sqhstl[0] = (unsigned int  )18;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&ND_PRV_BLNG_CLASS_ID;
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



   if (OERROR)
         err_mesg("SELECT failed on table BL_BLNG_CLASS",0,"");

   /* EXEC SQL select SHORT_DESC into :nd_chg_blng_class_desc from  bl_blng_class
   WHERE BLNG_CLASS_CODE = :ND_CHG_BLNG_CLASS_ID ; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 18;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select SHORT_DESC into :b0  from bl_blng_class where BLNG_\
CLASS_CODE=:b1";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )487;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_chg_blng_class_desc;
   sqlstm.sqhstl[0] = (unsigned int  )18;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&ND_CHG_BLNG_CLASS_ID;
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



   if (OERROR)
         err_mesg("SELECT failed on table BL_BLNG_CLASS",0,"");



   /* EXEC SQL SELECT  SHORT_NAME 
			INTO :nd_prv_cust_name 
			FROM AR_CUSTOMER
			WHERE   CUST_CODE = :ND_PRV_CUST_CODE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 18;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select SHORT_NAME into :b0  from AR_CUSTOMER where CUST_CO\
DE=:b1";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )510;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_prv_cust_name;
   sqlstm.sqhstl[0] = (unsigned int  )103;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&ND_PRV_CUST_CODE;
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

   /* EXEC SQL SELECT  SHORT_NAME 
			INTO :nd_chg_cust_name 
			FROM AR_CUSTOMER
			WHERE   CUST_CODE = :ND_CHG_CUST_CODE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 18;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select SHORT_NAME into :b0  from AR_CUSTOMER where CUST_CO\
DE=:b1";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )533;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_chg_cust_name;
   sqlstm.sqhstl[0] = (unsigned int  )103;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&ND_CHG_CUST_CODE;
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

   /* EXEC SQL select SHORT_DESC into :nd_prv_sett_type_desc from  bl_slmt_type
   WHERE SLMT_TYPE_CODE = :ND_PRV_SLMT_TYPE_CODE ; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 18;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select SHORT_DESC into :b0  from bl_slmt_type where SLMT_T\
YPE_CODE=:b1";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )556;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_prv_sett_type_desc;
   sqlstm.sqhstl[0] = (unsigned int  )18;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&ND_PRV_SLMT_TYPE_CODE;
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



   if (OERROR)
         err_mesg("SELECT failed on table BL_SLMT_TYPE",0,"");

   /* EXEC SQL select SHORT_DESC 
   into :nd_chg_sett_type_desc from  bl_slmt_type
   WHERE SLMT_TYPE_CODE = :ND_CHG_SLMT_TYPE_CODE ; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 18;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select SHORT_DESC into :b0  from bl_slmt_type where SLMT_T\
YPE_CODE=:b1";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )579;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_chg_sett_type_desc;
   sqlstm.sqhstl[0] = (unsigned int  )18;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&ND_CHG_SLMT_TYPE_CODE;
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



   if (OERROR)
         err_mesg("SELECT failed on table BL_SLMT_TYPE",0,"");

   if (LAST_ROW) return (0);
   else return (1);
}

print_notification()
{
int spc=0;
int i=0;
char s_amt[22];
char a_amt[22];

  fprintf(f1,"\n%25s %-30s \n", "",hosp_name.arr);
  fprintf(f1,"%-12s %40s \n","",     "NOTIFICATION ON FINANCIAL DETAILS OF PATIENT/EPISODE ");   
  if(date_time.arr[0]!='\0')
	 {
	   init_date_temp_var1();
       strcpy(date_convert1.arr,date_time.arr);
       fun_change_loc_date1();	   
     } 
  fprintf(f1,"%-1s %20s %-20s\n","","				 CHANGED ON:",date_convert1.arr);
  fprintf(f1,"  ----------------------------------------------------------------------\n\n\n");

  fprintf(f1,"FACILITY ID       :  %-3s\n\n", nd_facility_id.arr);

  fprintf(f1,"PATIENT No/NAME   :  %-20s  %-60s\n\n", nd_patient_id.arr,nd_patient_name.arr);

  fprintf(f1,"EPISODE DETAILS	  :  %-2s / %s / %s\n\n", nd_episode_type.arr, nd_episode_id.arr, nd_visit_id.arr);

  fprintf(f1,"FINANCIAL DETAILS BEFORE MODIFICATION \n");
  fprintf(f1,"------------------------------------- \n");

  fprintf(f1,"BILLING GROUP        :  %-3s %s\n\n", ND_PRV_BLNG_GRP_ID.arr,nd_prv_blng_grp_desc.arr);
  fprintf(f1,"BILLING CLASS        :  %-3s %s\n\n", ND_PRV_BLNG_CLASS_ID.arr,  nd_prv_blng_class_desc.arr);
  fprintf(f1,"CUSTOMER             :  %-9s %s\n\n", ND_PRV_CUST_CODE.arr,nd_prv_cust_name.arr);
  fprintf(f1,"CREDIT DOC REF       :  %-31s\n\n",ND_PRV_CREDIT_DOC_REF.arr);
    init_date_temp_var();
	if(ND_PRV_CREDIT_DOC_REF_DT.arr[0]!='\0')
	 {
	   init_date_temp_var();
       strcpy(date_convert.arr,ND_PRV_CREDIT_DOC_REF_DT.arr);
       fun_change_loc_date(); 
     } 	 
  fprintf(f1,"EXPIRY DATE          :  %-31s\n\n",date_convert.arr);
  fprintf(f1,"SETTLEMENT TYPE      :  %-11s\n\n",ND_PRV_SLMT_TYPE_CODE.arr);
  fprintf(f1,"ENTERED BY           :  %-30s\n\n",nd_prv_added_by_id.arr);
    if(nd_prv_added_date.arr[0]!='\0')
	 {
	   init_date_temp_var();
       strcpy(date_convert.arr,nd_prv_added_date.arr);
       fun_change_loc_date(); 
     }
  fprintf(f1,"ENTERED DATE 	     :  %-11s\n\n",date_convert.arr);
  fprintf(f1,"LAST MODIFIED BY     :  %-31s\n\n",ND_PRV_MODIFIED_BY_ID.arr);
    if(ND_PRV_MODIFIED_DATE.arr[0]!='\0')
	 {
	   init_date_temp_var();
       strcpy(date_convert.arr,ND_PRV_MODIFIED_DATE.arr);
       fun_change_loc_date(); 
     }
  fprintf(f1,"LAST MODIFIED DATE   :  %-11s\n\n",date_convert.arr);

  fprintf(f1,"FINANCIAL DETAILS AFTER MODIFICATION\n");
  fprintf(f1,"------------------------------------\n");
  fprintf(f1,"BILLING GROUP        :  %-3s  %-16s\n\n", ND_CHG_BLNG_GRP_ID.arr,ND_CHG_BLNG_GRP_DESC.arr);
  fprintf(f1,"BILLING CLASS        :  %-3s %s\n\n", ND_CHG_BLNG_CLASS_ID.arr,  nd_chg_blng_class_desc.arr);
  fprintf(f1,"CUSTOMER             :  %-9s  %-16s\n\n", ND_CHG_CUST_CODE.arr,nd_chg_cust_name.arr);
  fprintf(f1,"CREDIT DOC REF       :  %-31s  \n\n",ND_CHG_CREDIT_DOC_REF_DESC.arr);
	if(ND_CHG_CREDIT_DOC_REF_DT.arr[0]!='\0')
	 {
	   init_date_temp_var();
       strcpy(date_convert.arr,ND_CHG_CREDIT_DOC_REF_DT.arr);
       fun_change_loc_date(); 
     }
  fprintf(f1,"EXPIRY DATE          :  %-31s\n\n",date_convert.arr);
  fprintf(f1,"SETTLEMENT TYPE      :  %-3s\n\n",ND_CHG_SLMT_TYPE_CODE.arr);
  fprintf(f1,"ENTERED BY           :  %-30s\n\n",ND_ADDED_BY_ID.arr);
    if(ND_ADDED_DATE.arr[0]!='\0')
	 {
	   init_date_temp_var();
       strcpy(date_convert.arr,ND_ADDED_DATE.arr);
       fun_change_loc_date(); 
     }
  fprintf(f1,"ENTERED DATE 	     :  %-11s\n\n",date_convert.arr);
  fprintf(f1,"MODIFIED BY          :  %-31s\n\n",ND_CHG_MODIFIED_BY_ID.arr);
	if(ND_CHG_MODIFIED_DATE.arr[0]!='\0')
	 {
	   init_date_temp_var();
       strcpy(date_convert.arr,ND_CHG_MODIFIED_DATE.arr);
       fun_change_loc_date(); 
     }
  fprintf(f1,"MODIFIED DATE	     :  %-11s\n\n",date_convert.arr);

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

init_date_temp_var1()
{
nd_temp_date1.arr[0] = '\0';
nd_loc_date1.arr[0]  = '\0';
date_convert1.arr[0] = '\0';

nd_temp_date1.len = 0;
nd_loc_date1.len  = 0;
date_convert1.len = 0;
}

fun_change_loc_date()
{

strcpy(nd_temp_date.arr,date_convert.arr);
nd_temp_date.len = strlen(nd_temp_date.arr);
nd_temp_date.arr[nd_temp_date.len]='\0';


get_local_date();

strcpy(date_convert.arr,nd_loc_date.arr); 


}

fun_change_loc_date1()
{
strcpy(nd_temp_date1.arr,date_convert1.arr);
nd_temp_date1.len = strlen(nd_temp_date1.arr);
nd_temp_date1.arr[nd_temp_date1.len]='\0';

get_local_date1();

strcpy(date_convert1.arr,nd_loc_date1.arr); 

} 

get_local_date()
{

	/* EXEC SQL EXECUTE
	
	DECLARE
    	
		t_date varchar2(20);		
		BEGIN
		
		get_locale_date_2t.convert_to_locale_date(to_date(:nd_temp_date,'DD/MM/YYYY'),:p_language_id,t_date,'DD/MM/YYYY');
    	:nd_loc_date := t_date;		 		
   	

	    END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 18;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date varchar2 ( 20 ) ; BEGIN get_locale_date_2t . \
convert_to_locale_date ( to_date ( :nd_temp_date , 'DD/MM/YYYY' ) , :p_languag\
e_id , t_date , 'DD/MM/YYYY' ) ; :nd_loc_date := t_date ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )602;
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

get_local_date1()
{
	
	/* EXEC SQL EXECUTE

	DECLARE
	
	t_date1 varchar2(20);
	
	BEGIN
		
		get_locale_date_2t.convert_to_locale_date(to_date(:nd_temp_date1,'DD/MM/YYYY HH24:MI'),:p_language_id,t_date1,'DD/MM/YYYY HH24:MI');
    	:nd_loc_date1 := t_date1; 
        
	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 18;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date1 varchar2 ( 20 ) ; BEGIN get_locale_date_2t .\
 convert_to_locale_date ( to_date ( :nd_temp_date1 , 'DD/MM/YYYY HH24:MI' ) , \
:p_language_id , t_date1 , 'DD/MM/YYYY HH24:MI' ) ; :nd_loc_date1 := t_date1 ;\
 END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )629;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_temp_date1;
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