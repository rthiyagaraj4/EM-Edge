
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
           char  filnam[39];
};
static const struct sqlcxp sqlfpn =
{
    38,
    "T:\\BL\\CRF-0120\\AR\\WIP\\Proc\\Arrrecli.pc"
};


static unsigned long sqlctx = 1150831293;


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
            void  *sqhstv[13];
   unsigned int   sqhstl[13];
            int   sqhsts[13];
            void  *sqindv[13];
            int   sqinds[13];
   unsigned int   sqharm[13];
   unsigned int   *sqharc[13];
   unsigned short  sqadto[13];
   unsigned short  sqtdso[13];
} sqlstm = {10,13};

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
"select ORG_DOC_TYPE_CODE ,ORG_DOC_NUM ,AMT_LOCAL  from AR_REC_LINE where (DO\
C_TYPE_CODE=:b0 and DOC_NUM=:b1) order by ORG_DOC_TYPE_CODE,ORG_DOC_NUM       \
     ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,91,0,2,166,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
28,0,0,2,0,0,30,175,0,0,0,0,0,1,0,
43,0,0,3,147,0,4,188,0,0,5,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,1,9,0,0,
78,0,0,4,295,0,4,221,0,0,13,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
145,0,0,5,0,0,17,319,0,0,1,1,0,1,0,1,9,0,0,
164,0,0,5,0,0,45,354,0,0,10,10,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
219,0,0,5,0,0,13,385,0,0,8,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,4,0,0,
266,0,0,6,159,0,9,437,0,0,2,2,0,1,0,1,9,0,0,1,3,0,0,
289,0,0,7,85,0,4,442,0,0,3,2,0,1,0,2,3,0,0,1,9,0,0,1,3,0,0,
316,0,0,6,0,0,13,473,0,0,3,0,0,1,0,2,9,0,0,2,3,0,0,2,4,0,0,
343,0,0,6,0,0,13,482,0,0,3,0,0,1,0,2,9,0,0,2,3,0,0,2,4,0,0,
370,0,0,6,0,0,13,492,0,0,3,0,0,1,0,2,9,0,0,2,3,0,0,2,4,0,0,
397,0,0,6,0,0,13,502,0,0,3,0,0,1,0,2,9,0,0,2,3,0,0,2,4,0,0,
424,0,0,8,0,0,27,540,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
455,0,0,9,63,0,4,552,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
};


/* Date :- 17-JAN-98  */
  
#include <stdio.h>
#include <string.h>
#include "gl.h"    

#define LAST_ROW (sqlca.sqlcode == 1403)  
                                                         
#define NOT_FOUND (sqlca.sqlerrd[2] == 0)

/* EXEC SQL BEGIN DECLARE SECTION; */ 
 
                                                                  
   /* VARCHAR uid_pwd          			 [132],
           hosp_name       				 [120],
           date_time       				 [20],
           user_id          			 [20],
           nd_facility_id                [3],
		   nd_pgm_date     				 [35],
           nd_rep_type     				 [3],
           nd_session_id                 [16],
   		   nd_fm_doc_date				 [11],
   		   nd_to_doc_date				 [11],
   		   nd_fm_doc_type				 [7],
   		   nd_to_doc_type				 [7],
           nd_fm_cust_code               [9],
           nd_to_cust_code               [9],
           nd_order                      [11],
           nd_doc_date                   [11],
           nd_cust_code         		 [9],
           nd_doc_type_code              [7],
           nd_cheque_num				 [11],
		   nd_cheque_date                [11],
		   nd_bank_desc				     [31],
		   nd_org_doc_type_code          [7],
		   nd_org_doc_type_code1		 [7],
		   nd_org_doc_type_code2		 [7],		   
		   nd_org_doc_type_code3		 [7],		   
           nd_ar_select   			     [3000],
           nd_cust_name         		 [61],
  		   nd_fm_doc_num				 [9],
           nd_to_doc_num                 [9],
           ar_customer_long_name         [101],   -- CRF-0120
           ar_customer_short_name        [61],   -- CRF-0120
           ar_customer_alpha_code        [11]; */ 
struct { unsigned short len; unsigned char arr[132]; } uid_pwd;

struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[20]; } user_id;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[35]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[3]; } nd_rep_type;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[11]; } nd_fm_doc_date;

struct { unsigned short len; unsigned char arr[11]; } nd_to_doc_date;

struct { unsigned short len; unsigned char arr[7]; } nd_fm_doc_type;

struct { unsigned short len; unsigned char arr[7]; } nd_to_doc_type;

struct { unsigned short len; unsigned char arr[9]; } nd_fm_cust_code;

struct { unsigned short len; unsigned char arr[9]; } nd_to_cust_code;

struct { unsigned short len; unsigned char arr[11]; } nd_order;

struct { unsigned short len; unsigned char arr[11]; } nd_doc_date;

struct { unsigned short len; unsigned char arr[9]; } nd_cust_code;

struct { unsigned short len; unsigned char arr[7]; } nd_doc_type_code;

struct { unsigned short len; unsigned char arr[11]; } nd_cheque_num;

struct { unsigned short len; unsigned char arr[11]; } nd_cheque_date;

struct { unsigned short len; unsigned char arr[31]; } nd_bank_desc;

struct { unsigned short len; unsigned char arr[7]; } nd_org_doc_type_code;

struct { unsigned short len; unsigned char arr[7]; } nd_org_doc_type_code1;

struct { unsigned short len; unsigned char arr[7]; } nd_org_doc_type_code2;

struct { unsigned short len; unsigned char arr[7]; } nd_org_doc_type_code3;

struct { unsigned short len; unsigned char arr[3000]; } nd_ar_select;

struct { unsigned short len; unsigned char arr[61]; } nd_cust_name;

struct { unsigned short len; unsigned char arr[9]; } nd_fm_doc_num;

struct { unsigned short len; unsigned char arr[9]; } nd_to_doc_num;

struct { unsigned short len; unsigned char arr[101]; } ar_customer_long_name;

struct { unsigned short len; unsigned char arr[61]; } ar_customer_short_name;

struct { unsigned short len; unsigned char arr[11]; } ar_customer_alpha_code;


   /* VARCHAR file_name_arg				 [101]; */ 
struct { unsigned short len; unsigned char arr[101]; } file_name_arg;

   /* VARCHAR p_language_id				 [4]; */ 
struct { unsigned short len; unsigned char arr[4]; } p_language_id;



   int          counter = 0,
    			cnt  	= 1,
    			x = 0,
				nd_no_of_decimal, 
   				nd_rec;

   long int	   	nd_doc_num_hdr,
   				nd_doc_num_line,
           		nd_org_doc_num,
           		nd_org_doc_num1,
           		nd_org_doc_num2,
           		nd_org_doc_num3,
           		nd_total_recs = 0;
           
   double  		nd_amt_local_hdr,
           		nd_amt_local_line,
           		nd_amt_local_line1,
           		nd_amt_local_line2,
           		nd_amt_local_line3,
           		nd_total_amt = 0;        
   
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

char string_var [100];

FILE *fp;
 
int lctr = 0,pctr =0;
char file_name[50];

void proc_main(argc,argv)
char *argv[];
int argc;
{
   char mesg1[50];
   

   strcpy(file_name,WORKING_DIR);

   if (argc != 7)
   {
    int i = 0;
      disp_message(ERR_MESG,"Not enough Parameters for running this program");
      proc_exit();
   }

   strcpy(uid_pwd.arr,argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr); 

   strcpy(nd_session_id.arr,argv[2]);
   nd_session_id.len = strlen(nd_session_id.arr);

   strcpy(g_pgm_id,"ARRRECLI");

   strcpy(nd_rep_type.arr,argv[6]);

   strcpy(file_name_arg.arr,argv[5]);

   if (nd_rep_type.arr[0] == 'S')
     strcpy(g_pgm_id,"ARRRECLS");
   else if (nd_rep_type.arr[0] == 'D')
      strcpy(g_pgm_id,"ARRRECLD");

   if(sql_connect() == -1)
   {
      disp_message(ERR_MESG,"Error in connecting to Oracle");
      sprintf(mesg1,"Error is %s\n",sqlca.sqlerrm.sqlerrmc);
      disp_message(ERR_MESG,mesg1);
      if (uid_pwd.len == 0)
         disp_message(ERR_MESG,"Null oracle uid/pwd");
      proc_exit();
   }

   /***** CHECKING FOR ACTIVE FLAG IN SY_PROG_CONTROL *****/
   strcpy(g_pgm_date,argv[3]);
   strcpy(g_facility_id,argv[4]);

 
   strcpy(nd_pgm_date.arr,argv[3]);
   nd_pgm_date.len = strlen(nd_pgm_date.arr);
 
   set_meduser_role();
   strcpy(p_language_id.arr,l_language_id.arr);
   p_language_id.len = l_language_id.len;
 
    
   fetch_param();
   start_prog_msg();
   fetch_desc();

   decl_curs();
   declare_line_cursors();
         
   open_files();
   print_title();
   print_head();

   if (nd_rep_type.arr[0] == 'S')
    { 
        fetch_hdr_cur(); 
    }                
    
   else if (nd_rep_type.arr[0] == 'D')
    { 
     fetch_hdr_cur();
     fetch_line_cur();  
    }

    print_total();
    print_end();

    /* EXEC SQL DELETE FROM SY_PROG_PARAM
                   WHERE PGM_ID     = 'ARRRECLI'
                     AND SESSION_ID = :nd_session_id
                     AND PGM_DATE   = :nd_pgm_date; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 2;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='ARRRECLI' and\
 SESSION_ID=:b0) and PGM_DATE=:b1)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )5;
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
    sqlstm.sqhstl[1] = (unsigned int  )37;
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
         err_mesg("DELETE failed on table SY_PROG_PARAM",0,"");

    end_prog_msg();
    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 2;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )28;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

fetch_desc()
{
   hosp_name.arr[0]      = '\0';
   date_time.arr[0]      = '\0';
   user_id.arr[0]        = '\0';

   hosp_name.len      = 0;
   date_time.len      = 0;
   user_id.len        = 0;

   /* EXEC SQL SELECT ACC_ENTITY_NAME, TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'), USER,NO_OF_DECIMAL
              INTO :hosp_name, :date_time, :user_id,:nd_no_of_decimal
              FROM SY_ACC_ENTITY
			 WHERE ACC_ENTITY_ID = :nd_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 5;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:M\
I') ,USER ,NO_OF_DECIMAL into :b0,:b1,:b2,:b3  from SY_ACC_ENTITY where ACC_EN\
TITY_ID=:b4";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )43;
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
   sqlstm.sqhstv[3] = (         void  *)&nd_no_of_decimal;
   sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
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



   if (OERROR)
         err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");

   hosp_name.arr[hosp_name.len]           = '\0';
   date_time.arr[date_time.len]           = '\0';
   user_id.arr[user_id.len]               = '\0';
}

fetch_param()
{
   nd_fm_doc_date.arr[0]		 = '\0';
   nd_to_doc_date.arr[0]		 = '\0';   
   nd_fm_cust_code.arr[0]        = '\0';
   nd_to_cust_code.arr[0]        = '\0';
   nd_fm_doc_type.arr[0]         = '\0';
   nd_to_doc_type.arr[0]         = '\0';
   nd_rep_type.arr[0]            = '\0';
   nd_order.arr[0]               = '\0';
   
   nd_fm_doc_date.len 	 		 = 0;
   nd_to_doc_date.len    		 = 0;   
   nd_fm_cust_code.len           = 0;
   nd_to_cust_code.len           = 0;
   nd_fm_doc_type.len			 = 0;
   nd_to_doc_type.len			 = 0;
   nd_rep_type.len               = 0;
   nd_order.len                  = 0;

   /* EXEC SQL SELECT OPERATING_FACILITY_ID,
				   PARAM1,PARAM2,
   				   NVL(PARAM3,'!!!!!!!!'),
   				   NVL(PARAM4,'~~~~~~~~'),
                   PARAM5,
                   PARAM6,
                   PARAM7,
                   PARAM8,
                   NVL(PARAM9,'S'),
                   NVL(PARAM10,'D')
              INTO :nd_facility_id,
				   :nd_fm_doc_date,
                   :nd_to_doc_date,
                   :nd_fm_cust_code,
                   :nd_to_cust_code,
                   :nd_fm_doc_type,
                   :nd_to_doc_type,
                   :nd_fm_doc_num,
                   :nd_to_doc_num,
                   :nd_rep_type,
                   :nd_order
              FROM SY_PROG_PARAM
             WHERE PGM_ID     = 'ARRRECLI'
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 13;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,NVL(PARAM3,'\
!!!!!!!!') ,NVL(PARAM4,'~~~~~~~~') ,PARAM5 ,PARAM6 ,PARAM7 ,PARAM8 ,NVL(PARAM9\
,'S') ,NVL(PARAM10,'D') into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10  fro\
m SY_PROG_PARAM where ((PGM_ID='ARRRECLI' and SESSION_ID=:b11) and PGM_DATE=:b\
12)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )78;
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
   sqlstm.sqhstv[1] = (         void  *)&nd_fm_doc_date;
   sqlstm.sqhstl[1] = (unsigned int  )13;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_to_doc_date;
   sqlstm.sqhstl[2] = (unsigned int  )13;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_fm_cust_code;
   sqlstm.sqhstl[3] = (unsigned int  )11;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_to_cust_code;
   sqlstm.sqhstl[4] = (unsigned int  )11;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_fm_doc_type;
   sqlstm.sqhstl[5] = (unsigned int  )9;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_to_doc_type;
   sqlstm.sqhstl[6] = (unsigned int  )9;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_fm_doc_num;
   sqlstm.sqhstl[7] = (unsigned int  )11;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_to_doc_num;
   sqlstm.sqhstl[8] = (unsigned int  )11;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_rep_type;
   sqlstm.sqhstl[9] = (unsigned int  )5;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_order;
   sqlstm.sqhstl[10] = (unsigned int  )13;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[11] = (unsigned int  )18;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[12] = (unsigned int  )37;
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

  
               
   if (OERROR)
        err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   if (NOT_FOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");

   nd_fm_doc_date.arr[nd_fm_doc_date.len]          = '\0';
   nd_to_doc_date.arr[nd_to_doc_date.len]          = '\0';
   nd_fm_cust_code.arr[nd_fm_cust_code.len]        = '\0';
   nd_to_cust_code.arr[nd_to_cust_code.len]        = '\0';
   nd_fm_doc_type.arr[nd_fm_doc_type.len]          = '\0';
   nd_to_doc_type.arr[nd_to_doc_type.len]          = '\0';
   nd_rep_type.arr[nd_rep_type.len]                = '\0';
   nd_order.arr[nd_order.len]                      = '\0';
}

open_files()
{
  //file_name[50], 
  char err_stmt[70];

   if (nd_rep_type.arr[0] == 'S')
     {
	 //strcpy(file_name,"arrrecls.lis");
	 //strcat(file_name,"arrrecls.lis");
	 //strcpy(OUTPUT_FILE_NAME,"arrrecls.lis");
	   strcpy(OUTPUT_FILE_NAME,file_name_arg.arr);
	   strcat(file_name,OUTPUT_FILE_NAME);
	 }
   else if (nd_rep_type.arr[0] == 'D')
     {
	 //strcpy(file_name,"arrrecld.lis");
	 //strcat(file_name,"arrrecld.lis");
	 //strcpy(OUTPUT_FILE_NAME,"arrrecld.lis");
	   strcpy(OUTPUT_FILE_NAME,file_name_arg.arr);
	   strcat(file_name,OUTPUT_FILE_NAME);
	 }

   if ((fp = fopen(file_name,"w")) == NULL) 
   {
        sprintf(err_stmt,"Error while opening File %s",file_name);
        err_mesg(err_stmt,0,"");
        proc_exit();
   } 
}

decl_curs()
{
strcpy(nd_ar_select.arr,
 "SELECT  to_char(DOC_DATE,'DD/MM/YYYY'), \
  CUST_CODE, DOC_TYPE_CODE, DOC_NUM, CHEQUE_NUM, \
  to_char(CHEQUE_DATE,'DD/MM/YYYY'), \
  BANK_DESC, AMT_LOCAL \
  FROM AR_REC_HDR \
  WHERE           \
  DOC_DATE BETWEEN \
  TO_DATE(NVL(:nd_fm_doc_date,'01/01/1800'),'DD/MM/YYYY') \
  AND  TO_DATE(NVL(:nd_to_doc_date,'31/12/4712'),'DD/MM/YYYY') \
  AND  CUST_CODE BETWEEN \
  NVL(:nd_fm_cust_code,'!!!!!!!!') AND  \
  NVL(:nd_to_cust_code,'~~~~~~~~') \
  AND  DOC_TYPE_CODE between nvl(:nd_fm_doc_type,'!!!!!!') \
  AND  nvl(:nd_to_doc_type,'~~~~~~') \
  AND  to_char(DOC_NUM) BETWEEN DECODE(:nd_fm_doc_num,NULL,0,:nd_fm_doc_num) \
  AND  DECODE(:nd_to_doc_num,NULL,99999999,:nd_to_doc_num) \
  AND  NVL(POSTED_FLAG,'N') = 'Y' \
 ");

      prep_order_by();   /* Append ORDER BY Clause */

      nd_ar_select.len = strlen(nd_ar_select.arr);

     /* EXEC SQL PREPARE AR_REC_HDR_SELECT FROM :nd_ar_select; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 13;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )145;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_ar_select;
     sqlstm.sqhstl[0] = (unsigned int  )3002;
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
	err_mesg("PREPARE failed on AR_REC_HDR_SELECT",0,"");

    /* EXEC SQL DECLARE  AR_REC_HDR_CUR CURSOR FOR AR_REC_HDR_SELECT; */ 


    if(OERROR)
	err_mesg("DECLARE failed on AR_REC_HDR_CUR",0,""); 
	
	open_ar_cursor();  
} 

prep_order_by()
{
  switch (nd_order.arr[0])
  {
     case  'D' :  
                  strcat(nd_ar_select.arr,
                     " ORDER BY DOC_DATE ");
                  break;
     case  'C' :  
                  strcat(nd_ar_select.arr,
                     " ORDER BY CUST_CODE ");
                  break;       
     case  'N' :  
                  strcat(nd_ar_select.arr,
                     " ORDER BY DOC_NUM ");
                  break;       
                  
  }
}
  
open_ar_cursor()
{  
   /* EXEC SQL OPEN AR_REC_HDR_CUR USING 
   				   :nd_fm_doc_date, :nd_to_doc_date,
   				   :nd_fm_cust_code,:nd_to_cust_code,
   				   :nd_fm_doc_type,
   				   :nd_to_doc_type,
                   :nd_fm_doc_num,:nd_fm_doc_num,
                   :nd_to_doc_num,:nd_to_doc_num; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 13;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )164;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_fm_doc_date;
   sqlstm.sqhstl[0] = (unsigned int  )13;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_to_doc_date;
   sqlstm.sqhstl[1] = (unsigned int  )13;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_fm_cust_code;
   sqlstm.sqhstl[2] = (unsigned int  )11;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_to_cust_code;
   sqlstm.sqhstl[3] = (unsigned int  )11;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_fm_doc_type;
   sqlstm.sqhstl[4] = (unsigned int  )9;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_to_doc_type;
   sqlstm.sqhstl[5] = (unsigned int  )9;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_fm_doc_num;
   sqlstm.sqhstl[6] = (unsigned int  )11;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_fm_doc_num;
   sqlstm.sqhstl[7] = (unsigned int  )11;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_to_doc_num;
   sqlstm.sqhstl[8] = (unsigned int  )11;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_to_doc_num;
   sqlstm.sqhstl[9] = (unsigned int  )11;
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
      err_mesg("OPEN failed on Cursor AR_REC_HDR_CUR",0,"");
}
   
fetch_hdr_cur()
{ 
   for(;;)
   {
   nd_doc_date.arr       [0] = '\0';
   nd_cust_code.arr      [0] = '\0';
   nd_doc_type_code.arr  [0] = '\0';
   nd_cheque_num.arr     [0] = '\0';
   nd_cheque_date.arr    [0] = '\0';
   nd_bank_desc.arr      [0] = '\0';

   nd_doc_date.len      = 0;
   nd_cust_code.len     = 0;
   nd_doc_type_code.len = 0;
   nd_cheque_num.len    = 0;
   nd_cheque_date.len   = 0;
   nd_bank_desc.len     = 0;
   
       {
           /* EXEC SQL FETCH AR_REC_HDR_CUR INTO 
           				  :nd_doc_date,
                          :nd_cust_code,
                          :nd_doc_type_code,
                          :nd_doc_num_hdr,
                          :nd_cheque_num,
                          :nd_cheque_date,
                          :nd_bank_desc,
                          :nd_amt_local_hdr; */ 

{
           struct sqlexd sqlstm;
           sqlstm.sqlvsn = 10;
           sqlstm.arrsiz = 13;
           sqlstm.sqladtp = &sqladt;
           sqlstm.sqltdsp = &sqltds;
           sqlstm.iters = (unsigned int  )1;
           sqlstm.offset = (unsigned int  )219;
           sqlstm.cud = sqlcud0;
           sqlstm.sqlest = (unsigned char  *)&sqlca;
           sqlstm.sqlety = (unsigned short)256;
           sqlstm.occurs = (unsigned int  )0;
           sqlstm.sqhstv[0] = (         void  *)&nd_doc_date;
           sqlstm.sqhstl[0] = (unsigned int  )13;
           sqlstm.sqhsts[0] = (         int  )0;
           sqlstm.sqindv[0] = (         void  *)0;
           sqlstm.sqinds[0] = (         int  )0;
           sqlstm.sqharm[0] = (unsigned int  )0;
           sqlstm.sqadto[0] = (unsigned short )0;
           sqlstm.sqtdso[0] = (unsigned short )0;
           sqlstm.sqhstv[1] = (         void  *)&nd_cust_code;
           sqlstm.sqhstl[1] = (unsigned int  )11;
           sqlstm.sqhsts[1] = (         int  )0;
           sqlstm.sqindv[1] = (         void  *)0;
           sqlstm.sqinds[1] = (         int  )0;
           sqlstm.sqharm[1] = (unsigned int  )0;
           sqlstm.sqadto[1] = (unsigned short )0;
           sqlstm.sqtdso[1] = (unsigned short )0;
           sqlstm.sqhstv[2] = (         void  *)&nd_doc_type_code;
           sqlstm.sqhstl[2] = (unsigned int  )9;
           sqlstm.sqhsts[2] = (         int  )0;
           sqlstm.sqindv[2] = (         void  *)0;
           sqlstm.sqinds[2] = (         int  )0;
           sqlstm.sqharm[2] = (unsigned int  )0;
           sqlstm.sqadto[2] = (unsigned short )0;
           sqlstm.sqtdso[2] = (unsigned short )0;
           sqlstm.sqhstv[3] = (         void  *)&nd_doc_num_hdr;
           sqlstm.sqhstl[3] = (unsigned int  )sizeof(long);
           sqlstm.sqhsts[3] = (         int  )0;
           sqlstm.sqindv[3] = (         void  *)0;
           sqlstm.sqinds[3] = (         int  )0;
           sqlstm.sqharm[3] = (unsigned int  )0;
           sqlstm.sqadto[3] = (unsigned short )0;
           sqlstm.sqtdso[3] = (unsigned short )0;
           sqlstm.sqhstv[4] = (         void  *)&nd_cheque_num;
           sqlstm.sqhstl[4] = (unsigned int  )13;
           sqlstm.sqhsts[4] = (         int  )0;
           sqlstm.sqindv[4] = (         void  *)0;
           sqlstm.sqinds[4] = (         int  )0;
           sqlstm.sqharm[4] = (unsigned int  )0;
           sqlstm.sqadto[4] = (unsigned short )0;
           sqlstm.sqtdso[4] = (unsigned short )0;
           sqlstm.sqhstv[5] = (         void  *)&nd_cheque_date;
           sqlstm.sqhstl[5] = (unsigned int  )13;
           sqlstm.sqhsts[5] = (         int  )0;
           sqlstm.sqindv[5] = (         void  *)0;
           sqlstm.sqinds[5] = (         int  )0;
           sqlstm.sqharm[5] = (unsigned int  )0;
           sqlstm.sqadto[5] = (unsigned short )0;
           sqlstm.sqtdso[5] = (unsigned short )0;
           sqlstm.sqhstv[6] = (         void  *)&nd_bank_desc;
           sqlstm.sqhstl[6] = (unsigned int  )33;
           sqlstm.sqhsts[6] = (         int  )0;
           sqlstm.sqindv[6] = (         void  *)0;
           sqlstm.sqinds[6] = (         int  )0;
           sqlstm.sqharm[6] = (unsigned int  )0;
           sqlstm.sqadto[6] = (unsigned short )0;
           sqlstm.sqtdso[6] = (unsigned short )0;
           sqlstm.sqhstv[7] = (         void  *)&nd_amt_local_hdr;
           sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
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
                 err_mesg("FETCH failed on cursor AR_REC_HDR_CUR",0,"");
        }

    nd_doc_date.arr[nd_doc_date.len]           = '\0';
    nd_cust_code.arr[nd_cust_code.len]         = '\0';
    nd_doc_type_code.arr[nd_doc_type_code.len] = '\0';
    nd_cheque_num.arr[nd_cheque_num.len]       = '\0';
    nd_cheque_date.arr[nd_cheque_date.len]     = '\0';
    nd_bank_desc.arr[nd_bank_desc.len]         = '\0'; 

    if (LAST_ROW)
       return(0);
    else
        nd_total_amt = nd_total_amt+nd_amt_local_hdr;
        nd_total_recs++;
        fetch_description();
        print_hdr();

    if (nd_rep_type.arr[0] == 'D')    
    {                                                                        
        fetch_line_cur();
    }     
        
    }
     return(1);
}

declare_line_cursors()
{
         /* EXEC SQL DECLARE AR_REC_LINE_CUR CURSOR FOR
                   SELECT ORG_DOC_TYPE_CODE, ORG_DOC_NUM, AMT_LOCAL
                     FROM AR_REC_LINE
                    WHERE DOC_TYPE_CODE = :nd_doc_type_code
                      AND DOC_NUM = :nd_doc_num_hdr    
                    ORDER BY ORG_DOC_TYPE_CODE, ORG_DOC_NUM; */ 

}

fetch_line_cur()
{
   int count,cunt,mj;
   
       /* EXEC SQL OPEN AR_REC_LINE_CUR; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 13;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = sq0006;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )266;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&nd_doc_type_code;
       sqlstm.sqhstl[0] = (unsigned int  )9;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&nd_doc_num_hdr;
       sqlstm.sqhstl[1] = (unsigned int  )sizeof(long);
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
            err_mesg("OPEN failed on cursor AR_REC_LINE_CUR",0,"");  
             
       /* EXEC SQL SELECT COUNT(*) INTO :nd_rec
            FROM AR_REC_LINE
            WHERE DOC_TYPE_CODE = :nd_doc_type_code
            AND DOC_NUM = :nd_doc_num_hdr; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 13;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = "select count(*)  into :b0  from AR_REC_LINE where (DOC\
_TYPE_CODE=:b1 and DOC_NUM=:b2)";
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )289;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&nd_rec;
       sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&nd_doc_type_code;
       sqlstm.sqhstl[1] = (unsigned int  )9;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&nd_doc_num_hdr;
       sqlstm.sqhstl[2] = (unsigned int  )sizeof(long);
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

   

  count=nd_rec;
  cunt=1;           
  mj = 0;
  mj = count;

  //sprintf(string_var, "count value %d",nd_rec);
  //disp_message(ERR_MESG,string_var);

   if (mj != 0)
   {
     fprintf(fp,"\n");
   }
   


   while(count!=0)
   {
   	nd_org_doc_type_code.arr   [0] = '\0';
   	nd_org_doc_type_code1.arr  [0] = '\0';
   	nd_org_doc_type_code2.arr  [0] = '\0';   
   	nd_org_doc_type_code3.arr  [0] = '\0';   
    nd_org_doc_type_code.len       = 0;
   	nd_org_doc_type_code1.len      = 0;
   	nd_org_doc_type_code2.len      = 0;
   	nd_org_doc_type_code3.len      = 0;   	
    
           /* EXEC SQL FETCH AR_REC_LINE_CUR
                     INTO :nd_org_doc_type_code,
                          :nd_org_doc_num,
                          :nd_amt_local_line; */ 

{
           struct sqlexd sqlstm;
           sqlstm.sqlvsn = 10;
           sqlstm.arrsiz = 13;
           sqlstm.sqladtp = &sqladt;
           sqlstm.sqltdsp = &sqltds;
           sqlstm.iters = (unsigned int  )1;
           sqlstm.offset = (unsigned int  )316;
           sqlstm.cud = sqlcud0;
           sqlstm.sqlest = (unsigned char  *)&sqlca;
           sqlstm.sqlety = (unsigned short)256;
           sqlstm.occurs = (unsigned int  )0;
           sqlstm.sqhstv[0] = (         void  *)&nd_org_doc_type_code;
           sqlstm.sqhstl[0] = (unsigned int  )9;
           sqlstm.sqhsts[0] = (         int  )0;
           sqlstm.sqindv[0] = (         void  *)0;
           sqlstm.sqinds[0] = (         int  )0;
           sqlstm.sqharm[0] = (unsigned int  )0;
           sqlstm.sqadto[0] = (unsigned short )0;
           sqlstm.sqtdso[0] = (unsigned short )0;
           sqlstm.sqhstv[1] = (         void  *)&nd_org_doc_num;
           sqlstm.sqhstl[1] = (unsigned int  )sizeof(long);
           sqlstm.sqhsts[1] = (         int  )0;
           sqlstm.sqindv[1] = (         void  *)0;
           sqlstm.sqinds[1] = (         int  )0;
           sqlstm.sqharm[1] = (unsigned int  )0;
           sqlstm.sqadto[1] = (unsigned short )0;
           sqlstm.sqtdso[1] = (unsigned short )0;
           sqlstm.sqhstv[2] = (         void  *)&nd_amt_local_line;
           sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
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


                          
           nd_org_doc_type_code.arr[nd_org_doc_type_code.len] = '\0';

           if(count>1)
           {                                                        
                /* EXEC SQL FETCH AR_REC_LINE_CUR
                     INTO :nd_org_doc_type_code1,
                          :nd_org_doc_num1,
                          :nd_amt_local_line1; */ 

{
                struct sqlexd sqlstm;
                sqlstm.sqlvsn = 10;
                sqlstm.arrsiz = 13;
                sqlstm.sqladtp = &sqladt;
                sqlstm.sqltdsp = &sqltds;
                sqlstm.iters = (unsigned int  )1;
                sqlstm.offset = (unsigned int  )343;
                sqlstm.cud = sqlcud0;
                sqlstm.sqlest = (unsigned char  *)&sqlca;
                sqlstm.sqlety = (unsigned short)256;
                sqlstm.occurs = (unsigned int  )0;
                sqlstm.sqhstv[0] = (         void  *)&nd_org_doc_type_code1;
                sqlstm.sqhstl[0] = (unsigned int  )9;
                sqlstm.sqhsts[0] = (         int  )0;
                sqlstm.sqindv[0] = (         void  *)0;
                sqlstm.sqinds[0] = (         int  )0;
                sqlstm.sqharm[0] = (unsigned int  )0;
                sqlstm.sqadto[0] = (unsigned short )0;
                sqlstm.sqtdso[0] = (unsigned short )0;
                sqlstm.sqhstv[1] = (         void  *)&nd_org_doc_num1;
                sqlstm.sqhstl[1] = (unsigned int  )sizeof(long);
                sqlstm.sqhsts[1] = (         int  )0;
                sqlstm.sqindv[1] = (         void  *)0;
                sqlstm.sqinds[1] = (         int  )0;
                sqlstm.sqharm[1] = (unsigned int  )0;
                sqlstm.sqadto[1] = (unsigned short )0;
                sqlstm.sqtdso[1] = (unsigned short )0;
                sqlstm.sqhstv[2] = (         void  *)&nd_amt_local_line1;
                sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
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


              nd_org_doc_type_code1.arr[nd_org_doc_type_code1.len] = '\0';
              cunt++;
           }

     	   if(count>2)
     	   {
                /* EXEC SQL FETCH AR_REC_LINE_CUR
                    INTO :nd_org_doc_type_code2,
                         :nd_org_doc_num2,
                         :nd_amt_local_line2; */ 

{
                struct sqlexd sqlstm;
                sqlstm.sqlvsn = 10;
                sqlstm.arrsiz = 13;
                sqlstm.sqladtp = &sqladt;
                sqlstm.sqltdsp = &sqltds;
                sqlstm.iters = (unsigned int  )1;
                sqlstm.offset = (unsigned int  )370;
                sqlstm.cud = sqlcud0;
                sqlstm.sqlest = (unsigned char  *)&sqlca;
                sqlstm.sqlety = (unsigned short)256;
                sqlstm.occurs = (unsigned int  )0;
                sqlstm.sqhstv[0] = (         void  *)&nd_org_doc_type_code2;
                sqlstm.sqhstl[0] = (unsigned int  )9;
                sqlstm.sqhsts[0] = (         int  )0;
                sqlstm.sqindv[0] = (         void  *)0;
                sqlstm.sqinds[0] = (         int  )0;
                sqlstm.sqharm[0] = (unsigned int  )0;
                sqlstm.sqadto[0] = (unsigned short )0;
                sqlstm.sqtdso[0] = (unsigned short )0;
                sqlstm.sqhstv[1] = (         void  *)&nd_org_doc_num2;
                sqlstm.sqhstl[1] = (unsigned int  )sizeof(long);
                sqlstm.sqhsts[1] = (         int  )0;
                sqlstm.sqindv[1] = (         void  *)0;
                sqlstm.sqinds[1] = (         int  )0;
                sqlstm.sqharm[1] = (unsigned int  )0;
                sqlstm.sqadto[1] = (unsigned short )0;
                sqlstm.sqtdso[1] = (unsigned short )0;
                sqlstm.sqhstv[2] = (         void  *)&nd_amt_local_line2;
                sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
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


                nd_org_doc_type_code2.arr[nd_org_doc_type_code2.len] = '\0';
                cunt++;
            }          
              
     	   if(count>3)
     	   {
                /* EXEC SQL FETCH AR_REC_LINE_CUR
                    INTO :nd_org_doc_type_code3,
                         :nd_org_doc_num3,
                         :nd_amt_local_line3; */ 

{
                struct sqlexd sqlstm;
                sqlstm.sqlvsn = 10;
                sqlstm.arrsiz = 13;
                sqlstm.sqladtp = &sqladt;
                sqlstm.sqltdsp = &sqltds;
                sqlstm.iters = (unsigned int  )1;
                sqlstm.offset = (unsigned int  )397;
                sqlstm.cud = sqlcud0;
                sqlstm.sqlest = (unsigned char  *)&sqlca;
                sqlstm.sqlety = (unsigned short)256;
                sqlstm.occurs = (unsigned int  )0;
                sqlstm.sqhstv[0] = (         void  *)&nd_org_doc_type_code3;
                sqlstm.sqhstl[0] = (unsigned int  )9;
                sqlstm.sqhsts[0] = (         int  )0;
                sqlstm.sqindv[0] = (         void  *)0;
                sqlstm.sqinds[0] = (         int  )0;
                sqlstm.sqharm[0] = (unsigned int  )0;
                sqlstm.sqadto[0] = (unsigned short )0;
                sqlstm.sqtdso[0] = (unsigned short )0;
                sqlstm.sqhstv[1] = (         void  *)&nd_org_doc_num3;
                sqlstm.sqhstl[1] = (unsigned int  )sizeof(long);
                sqlstm.sqhsts[1] = (         int  )0;
                sqlstm.sqindv[1] = (         void  *)0;
                sqlstm.sqinds[1] = (         int  )0;
                sqlstm.sqharm[1] = (unsigned int  )0;
                sqlstm.sqadto[1] = (unsigned short )0;
                sqlstm.sqtdso[1] = (unsigned short )0;
                sqlstm.sqhstv[2] = (         void  *)&nd_amt_local_line3;
                sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
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


                nd_org_doc_type_code3.arr[nd_org_doc_type_code3.len] = '\0';
                cunt++;
            }          

           if (OERROR)
                 err_mesg("FETCH failed on cursor AR_REC_LINE_CUR",0,"");

           print_det_line(cunt);
           count=count-cunt;               
           cunt=1;        
     }

   if (mj != 0)
   {
     fprintf(fp,"\n");
   }
   
  return(1);
}


ltrim(l_str)
char *l_str;
{
   char *ptr;
   ptr = l_str;
   while (*ptr== ' ') ptr++;
   for(;*ptr!='\0';ptr++,l_str++)
    *l_str = *ptr;
   *l_str = '\0';
}

sql_connect() 
{
  /* EXEC SQL CONNECT :uid_pwd; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 13;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )424;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&uid_pwd;
  sqlstm.sqhstl[0] = (unsigned int  )134;
  sqlstm.sqhsts[0] = (         int  )134;
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



  if (sqlca.sqlcode < 0)
      return(-1);
  return(0);
}

fetch_description()
{
     nd_cust_name.arr[0]  = '\0';
     nd_cust_name.len     = 0;
     
  /* EXEC SQL SELECT LONG_NAME 
           INTO   :nd_cust_name
           FROM   AR_CUSTOMER
           WHERE  CUST_CODE = :nd_cust_code; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 13;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LONG_NAME into :b0  from AR_CUSTOMER where CUST_CODE\
=:b1";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )455;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_cust_name;
  sqlstm.sqhstl[0] = (unsigned int  )63;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_cust_code;
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

     nd_cust_name.arr[nd_cust_name.len]='\0';
}

        /************ PRINT THE REPORT FRONT PAGE ************/
        
print_title()
{
  void print_hospital_name();
  /*
  fprintf(fp,
"\n\nMDL : AR                                         %-30s                                        %-15s\n",
      hosp_name.arr,date_time.arr);
  */
  print_hospital_name(136,"AR",hosp_name.arr,date_time.arr);

     fprintf(fp,
"OPR : %-10s\n",
user_id.arr);

  fprintf(fp,
"REP : %-8s                                         %-28s                                          PAGE : %4d\n",
    g_pgm_id,
    (nd_rep_type.arr[0] == 'S')? "RECEIPTS LIST - SUMMARY":
     "RECEIPTS LIST - DETAIL ",
     ++pctr);
 {
fprintf(fp,
"----------------------------------------------------------------------------------------------------------------------------------------\n");
 }
//fprintf(fp,"VER : 1.10.01\n");
  fflush(fp); 

fprintf(fp,"\n\n\n\n        INPUT PARAMETERS :\n        ----------------\n\n");

       if (nd_order.arr[0] == "D")   
			fprintf(fp,"                REPORT ORDER         : %-10s\n\n","DOC DATE");
       else if (nd_order.arr[0] == "C")
			fprintf(fp,"                REPORT ORDER         : %-10s\n\n","CUST CODE");
       else  
	   fprintf(fp,"                REPORT ORDER         : %-10s\n\n","DOC NUMBER");
 
fprintf(fp,"                DOC DATE      - FROM : %-10s\n",nd_fm_doc_date.arr);
fprintf(fp,"                DOC DATE      - TO   : %-10s\n\n",nd_to_doc_date.arr);

     if (strcmp(nd_fm_cust_code.arr,"!!!!!!!!")!=0)
       strcpy(nd_fm_cust_code.arr,nd_fm_cust_code.arr);
     else                                            
       strcpy(nd_fm_cust_code.arr,"LOWEST");  

fprintf(fp,"                CUSTOMER CODE - FROM : %-8s\n",nd_fm_cust_code.arr);

     if (strcmp(nd_to_cust_code.arr,"~~~~~~~~")!=0)
       strcpy(nd_to_cust_code.arr,nd_to_cust_code.arr);
     else                                            
       strcpy(nd_to_cust_code.arr,"HIGHEST");  

fprintf(fp,"                CUSTOMER CODE - TO   : %-8s\n\n",nd_to_cust_code.arr);
                                                    
fprintf(fp,"                DOC TYPE CODE        : %-6s\n\n",
strcmp(nd_fm_doc_type.arr,"!!!!!!")?nd_fm_doc_type.arr:"      ");
fprintf(fp,"                DOC NUMBER    - FROM : %-8s\n",nd_fm_doc_num.arr);
fprintf(fp,"                DOC NUMBER    - TO   : %-8s\n\n",nd_to_doc_num.arr);

fprintf(fp,"                REPORT TYPE          : %s\n\n",
   (nd_rep_type.arr[0] == 'D')?"DETAIL":"SUMMARY");
fprintf(fp,"\f");   
  fflush(fp);  
} 

            /************ PRINT THE PAGE HEADING ************/
        
print_head()
{
  /*
  fprintf(fp,
"MDL : AR                                     %-30s                                          %-15s\n",
      hosp_name.arr,date_time.arr);
  */

  print_hospital_name(136,"AR",hosp_name.arr,date_time.arr);

     fprintf(fp,
"OPR : %-10s\n",
user_id.arr);
  fprintf(fp,
"REP : %-8s                                         %-28s                                          PAGE : %4d\n",
    g_pgm_id,
    (nd_rep_type.arr[0] == 'S')?"RECEIPTS LIST - SUMMARY":
                                "RECEIPTS LIST - DETAIL ",
    ++pctr);

fprintf(fp,
"----------------------------------------------------------------------------------------------------------------------------------------\n");

fprintf(fp,
"DATE       CUSTOMER                                          DOC NUMBER      CHEQUE NO. CHEQUE DATE             RECEIPT AMOUNT \n");
fprintf(fp,
"                                                                             BANK\n");
fprintf(fp,
"----------------------------------------------------------------------------------------------------------------------------------------\n");

  fflush(fp);
  lctr = 10;
}

            /************ PRINT THE HEADER RECORDS ************/
            
print_hdr()
{
 fprintf(fp, "%-10s %-8s %-40.40s %6s/%-8ld %-10s %-10s              ",
             nd_doc_date.arr, nd_cust_code.arr, nd_cust_name.arr, 
             nd_doc_type_code.arr, nd_doc_num_hdr, nd_cheque_num.arr, 
             nd_cheque_date.arr); 
 print_formated(nd_amt_local_hdr); 

 fprintf(fp, "\n");
 fprintf(fp, "                                                                             %-30s ",nd_bank_desc.arr); 
 fprintf(fp, "\n");   
 lctr+= 2;
 chk_break(1);
}

            /************ PRINT THE DETAIL HEADING ************/

print_detail()
{

if (nd_rec == 1) 
{
fprintf(fp,
"-----------------------------------\n");

fprintf(fp,
"CUSTOMER                 AMOUNT\n");

fprintf(fp,
"-----------------------------------\n");
}

if (nd_rec == 2)
{
fprintf(fp,
"-----------------------------------          -----------------------------------\n");

fprintf(fp,
"CUSTOMER                 AMOUNT              CUSTOMER                 AMOUNT\n");

fprintf(fp,
"-----------------------------------          -----------------------------------\n");
}

if (nd_rec > 2) 
{
fprintf(fp,
"-----------------------------------          -----------------------------------          -----------------------------------\n");
       
fprintf(fp,
"CUSTOMER                 AMOUNT              CUSTOMER                 AMOUNT              CUSTOMER                 AMOUNT\n");

fprintf(fp,
"-----------------------------------          -----------------------------------          -----------------------------------\n");
} 
lctr+=3;
}

            /************ PRINT THE DETAIL RECORDS ************/
            
print_det_line(int nd_recs)
{
   char out_str[30],out_str1[30];
   if (nd_rep_type.arr[0] == 'S')
         return(0);

  if (nd_recs == 1)
  {  
    fprintf(fp,"      %6s%-8ld ",
               nd_org_doc_type_code.arr,
               nd_org_doc_num);
    print_formated(nd_amt_local_line);
  }
    
  if (nd_recs == 2)
  {
    fprintf(fp,"      %6s/%-8ld ",
               nd_org_doc_type_code.arr,
               nd_org_doc_num);
    print_formated(nd_amt_local_line); 
    fprintf(fp, "   ");
    
    fprintf(fp,"%6s/%-8ld ",
               nd_org_doc_type_code1.arr,
               nd_org_doc_num1);
    print_formated(nd_amt_local_line1); 
  }

  if (nd_recs == 3)
  {
    fprintf(fp,"      %6s/%-8ld ",
               nd_org_doc_type_code.arr,
               nd_org_doc_num);
    print_formated(nd_amt_local_line); 
    fprintf(fp, "   ");

    fprintf(fp,"%6s/%-8ld ",
               nd_org_doc_type_code1.arr,
               nd_org_doc_num1);
    print_formated(nd_amt_local_line1); 
    fprintf(fp, "   ");

    fprintf(fp,"%6s/%-8ld ",
               nd_org_doc_type_code2.arr,
               nd_org_doc_num2);
    print_formated(nd_amt_local_line2);

/*
    if ((cnt%3) == 1) 
    {
    fprintf(fp,"\n");   
    }
    cnt++;
*/
  }

  if (nd_recs > 3)
  {
    fprintf(fp,"      %6s/%-8ld ",
               nd_org_doc_type_code.arr,
               nd_org_doc_num);
    print_formated(nd_amt_local_line); 
    fprintf(fp, "   ");

    fprintf(fp,"%6s/%-8ld ",
               nd_org_doc_type_code1.arr,
               nd_org_doc_num1);
    print_formated(nd_amt_local_line1); 
    fprintf(fp, "   ");    

    fprintf(fp,"%6s/%-8ld ",
               nd_org_doc_type_code2.arr,
               nd_org_doc_num2);
    print_formated(nd_amt_local_line2);
    fprintf(fp, "   ");
    
    fprintf(fp,"%6s/%-8ld ",
               nd_org_doc_type_code3.arr,
               nd_org_doc_num3);
    print_formated(nd_amt_local_line3);

    if ((cnt%4) == 1) 
    {
    fprintf(fp,"");   
    }
    cnt++;
  }

   	fprintf(fp, "\n");
  
  fflush(fp);
  lctr +=3;
  chk_break(3);
}

            /************ PRINT THE TOTALS ************/

print_total()
{
 fprintf(fp,
"                                                                                                                ------------------------\n");

 fprintf(fp, "                                                                                        TOTAL AMOUNT         :  "); 
 print_formated(nd_total_amt); 
 fprintf(fp, "\n");
 fprintf(fp,
"                                                                                                                ------------------------\n");
 fprintf(fp, "                                                                                        TOTAL  TRANSACTIONS  :  ");  
 fprintf(fp, "   %ld\n", nd_total_recs);
}

            /************ PRINT THE REPORT FOOTER ************/
            
print_end()
{
fprintf(fp,
"\n\n                                                      **   END  OF  REPORT   ** \n\n");
  fflush(fp);
  fclose(fp);
}

print_formated(loc_amount)
double loc_amount;
{
   char out_str[30],out_str1[30];
   if (nd_no_of_decimal==3)
      sprintf(out_str,"%11.3f",loc_amount);
   else
      sprintf(out_str,"%11.2f",loc_amount);

      format_amt(out_str,nd_no_of_decimal);

   if (loc_amount == 0)
      fprintf(fp,"%-14s"," ");
   else if (loc_amount > 0)
   {
      fprintf(fp,"%14s",out_str);
   }
   else
   {
      fprintf(fp,"%14s-",out_str);
   }

   
   /*
   if (loc_amount == 0)
      fprintf(fp,"%-14s"," ");
   else if (loc_amount > 0)
   {
      sprintf(out_str,"%11.2f",loc_amount);
      ltrim(out_str);put_comma(out_str);
      sprintf(out_str1,"%14s",out_str);
      fprintf(fp,"%-14s",out_str1);
   }
   else
   {
      sprintf(out_str,"%11.2f",-loc_amount);
      ltrim(out_str);put_comma(out_str);
      sprintf(out_str1,"%14s",out_str);
      fprintf(fp,"%-14s-",out_str1);
   }
   */
}

void print_hospital_name(nd_rep_width    ,
                         nd_mod_id       ,
                         nd_hospital_name,
                         nd_date          )
int  nd_rep_width;
char nd_mod_id[3];
char nd_hospital_name[31];
char nd_date[17];
{
    int i = 0 , pos = 0 , len = 0, len_date = 0 , pos_date = 0, len1=0;

    /*Find the length of Hospital Name*/
    for(len = 0; nd_hospital_name[len] != '\0'; len++);

    /*Find the length of Date*/
    for(len_date = 0; nd_date[len_date] != '\0'; len_date++);

    len1 = (len % 2);

    if (len1==0)
       len1=9;
    else
       len1=10;

    len = len / 2;

    pos = (nd_rep_width / 2	) - len;

	pos_date = nd_rep_width - len_date;

	fprintf(fp,"MDL : %2s",nd_mod_id);

	for(i = len1; i < pos ; fprintf(fp," "),i++);

	fprintf(fp,"%s",nd_hospital_name);

	for(i = i + (len * 2) ; i < pos_date + 1; fprintf(fp," "),i++);

    fprintf(fp,"%s\n",nd_date);
}

chk_break(nol)
int nol;
{    
   if(lctr + nol >= 55)
   {
      fprintf(fp,"\f");  
      lctr = 1;
      print_head();
   }
}