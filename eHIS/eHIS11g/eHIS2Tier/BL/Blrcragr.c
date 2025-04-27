
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/Blrcragr.pc"
};


static unsigned int sqlctx = 1288466619;


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
            void  *sqhstv[11];
   unsigned int   sqhstl[11];
            int   sqhsts[11];
            void  *sqindv[11];
            int   sqinds[11];
   unsigned int   sqharm[11];
   unsigned int   *sqharc[11];
   unsigned short  sqadto[11];
   unsigned short  sqtdso[11];
} sqlstm = {12,11};

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
5,0,0,0,0,0,27,101,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,30,147,0,0,0,0,0,1,0,
51,0,0,3,174,0,4,165,0,0,9,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,
102,0,0,4,84,0,2,194,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
129,0,0,5,293,0,4,206,0,0,11,5,0,1,0,2,9,0,0,2,4,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,1,3,0,0,
188,0,0,6,69,0,4,215,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
211,0,0,7,69,0,4,218,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
234,0,0,8,233,0,4,221,0,0,11,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
293,0,0,9,202,0,4,254,0,0,10,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
348,0,0,10,76,0,4,272,0,0,1,0,0,1,0,2,3,0,0,
};


#define ONLINE_PRINTING 1
#define ESC 0x1B
#include <stdio.h>
#include <string.h>          
#include "bl.h"           


/* EXEC SQL BEGIN DECLARE SECTION; */ 
   

    /* VARCHAR uid_pwd              [91],
	    d_session_id             [16],
		nd_facility_id           [3], 
	    d_pgm_date               [14],
        rep_date                 [20],
        oper_id                  [21],
        d_curr_pgm_name          [15]; */ 
struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[16]; } d_session_id;

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
	    nd_patient_name          [61],
        nd_sponsor_id            [11],
	    nd_sponsor_name          [31],
	    nd_bill_doc_type_code    [7],
		nd_ln1_res_add			 [31],
		nd_ln2_res_add			 [31],
		nd_ln3_res_add			 [31],
		nd_ln4_res_add			 [31],
        nd_res_phone_num		 [19],
        nd_ln1_off_add			 [31],
		nd_ln2_off_add			 [31],
		nd_ln3_off_add			 [31],
		nd_ln4_off_add			 [31],
        nd_off_phone_num		 [19],
		nd_inst_start_date       [11],
		nd_remarks1				 [61],
		nd_remarks2				 [61],
		nd_remarks3				 [61]; */ 
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

struct { unsigned short len; unsigned char arr[61]; } nd_patient_name;

struct { unsigned short len; unsigned char arr[11]; } nd_sponsor_id;

struct { unsigned short len; unsigned char arr[31]; } nd_sponsor_name;

struct { unsigned short len; unsigned char arr[7]; } nd_bill_doc_type_code;

struct { unsigned short len; unsigned char arr[31]; } nd_ln1_res_add;

struct { unsigned short len; unsigned char arr[31]; } nd_ln2_res_add;

struct { unsigned short len; unsigned char arr[31]; } nd_ln3_res_add;

struct { unsigned short len; unsigned char arr[31]; } nd_ln4_res_add;

struct { unsigned short len; unsigned char arr[19]; } nd_res_phone_num;

struct { unsigned short len; unsigned char arr[31]; } nd_ln1_off_add;

struct { unsigned short len; unsigned char arr[31]; } nd_ln2_off_add;

struct { unsigned short len; unsigned char arr[31]; } nd_ln3_off_add;

struct { unsigned short len; unsigned char arr[31]; } nd_ln4_off_add;

struct { unsigned short len; unsigned char arr[19]; } nd_off_phone_num;

struct { unsigned short len; unsigned char arr[11]; } nd_inst_start_date;

struct { unsigned short len; unsigned char arr[61]; } nd_remarks1;

struct { unsigned short len; unsigned char arr[61]; } nd_remarks2;

struct { unsigned short len; unsigned char arr[61]; } nd_remarks3;


double  nd_inst_amt_monthly,
	    nd_bill_outst_amt;

int     nd_hosp_name_len,
        nd_bill_doc_num,
	    nd_credit_agreement_num;
		

    int d_rfq_line_num,
        count;

    
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




#include "winproc.h"
char string_var[100];

char filename[150];
FILE *f1;

int page_no,
    line_no,
    first_line,
    g_count;

char file_name[15];

void proc_main(argc,argv)
int argc;
char *argv[];
{

    if(argc != 5) {
disp_message(ERR_MESG,"BLRCRAGR : Usage BLRCRAGR userid/password session_id pgm_date facility_id \n");
proc_exit();
    }

    strcpy(g_pgm_id,"BLRCRAGR");
	strcpy(filename,"BLRCRAGR.LIS");

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



    if(OERROR) 
    {
      disp_message(ORA_MESG,"Unable to connect to oracle.\n");
      sprintf(string_var, "%s\n",sqlca.sqlerrm.sqlerrmc);
      disp_message(ORA_MESG,string_var);
      proc_exit();
    }

	set_meduser_role();	
    fetch_prog_param();

    strcpy(file_name,"blrcragr.lis");

    if( (f1=fopen(file_name,"w")) == NULL) 
    {
      disp_message(ERR_MESG,"Error in opening output file...\n");
      proc_exit();
    }

    decl_curs();

    print_agreement();
  
    
    fclose(f1);

 /*print_online(uid_pwd.arr, "BLRCRAGR", "O", "", "BLRCRAGR.LIS", "R"); */

   PrintDocument
      (
		uid_pwd.arr,		//char	*PUidPwd;
		d_session_id.arr,	//char	*PSessionID;
		nd_facility_id.arr,	//char	*PFacilityID;
		"BL",				//char	*PModuleID;
		"BLRCRAGR",			//char	*PDocumentID;
		filename,			//char	*POnlinePrintFileNames;
		"O",				//char	*PLocationTypes;
		"",				//char	*PLocationCodes;
		1,					//int		PNumOfCopies;
		1,					//int		PPageFrom;
		1					//int		PPageTo;
	);


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



    return;
}

fetch_prog_param()
{
   	nd_facility_id.arr[0]  = '\0';
	nd_patient_id.arr[0]          = '\0';
	nd_bill_doc_type_code.arr[0]  = '\0';
    nd_sponsor_id.arr[0]          = '\0';

	nd_facility_id.len  = 0;
	nd_patient_id.len             = 0;   
	nd_bill_doc_type_code.len     = 0;   
	nd_sponsor_id.len             = 0;   

   
	/* EXEC SQL SELECT operating_facility_id,
			PARAM1, /o  PATIENT_ID           o/
			PARAM2,         /o  BILL_DOC_TYPE_CODE   o/
			PARAM3,         /o  BILL_DOC_NUM         o/
			PARAM4,         /o  CREDIT_AGREEMENT_NO  o/
            PARAM5         /o  SPONSOR_ID           o/
	 INTO   :nd_facility_id,
	        :nd_patient_id,
			:nd_bill_doc_type_code,
			:nd_bill_doc_num,
			:nd_credit_agreement_num,
			:nd_sponsor_id
	 FROM   SY_PROG_PARAM
     WHERE  PGM_ID     = :d_curr_pgm_name
     AND    SESSION_ID = :d_session_id
     AND    PGM_DATE   = :d_pgm_date; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 9;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select operating_facility_id ,PARAM1 ,PARAM2 ,PARAM3 ,PARAM4\
 ,PARAM5 into :b0,:b1,:b2,:b3,:b4,:b5  from SY_PROG_PARAM where ((PGM_ID=:b6 a\
nd SESSION_ID=:b7) and PGM_DATE=:b8)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )51;
 sqlstm.selerr = (unsigned short)1;
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
 sqlstm.sqhstv[1] = (         void  *)&nd_patient_id;
 sqlstm.sqhstl[1] = (unsigned int  )23;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_bill_doc_type_code;
 sqlstm.sqhstl[2] = (unsigned int  )9;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_bill_doc_num;
 sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_credit_agreement_num;
 sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_sponsor_id;
 sqlstm.sqhstl[5] = (unsigned int  )13;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&d_curr_pgm_name;
 sqlstm.sqhstl[6] = (unsigned int  )17;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&d_session_id;
 sqlstm.sqhstl[7] = (unsigned int  )18;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&d_pgm_date;
 sqlstm.sqhstl[8] = (unsigned int  )16;
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



   if ( OERROR) 
        err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   if (NO_DATA_FOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");

	nd_facility_id.arr[nd_facility_id.len] = '\0';
    nd_patient_id.arr[nd_patient_id.len]                  = '\0';
	nd_bill_doc_type_code.arr[nd_bill_doc_type_code.len]  = '\0';
    nd_sponsor_id.arr[nd_sponsor_id.len]                  = '\0';
	strcpy(g_facility_id,nd_facility_id.arr);

   /* EXEC SQL DELETE SY_PROG_PARAM
             WHERE PGM_ID     = :d_curr_pgm_name
               AND SESSION_ID = :d_session_id
               AND PGM_DATE   = :d_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 9;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID=:b0 and SESSION\
_ID=:b1) and PGM_DATE=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )102;
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

/* EXEC SQL SELECT TRUNC(INST_START_DATE), INST_AMT_MONTHLY, BILL_OUTSTANDING_AMT, REMARKS_1, REMARKS_2, REMARKS_3
INTO   :nd_inst_start_date, :nd_inst_amt_monthly, :nd_bill_outst_amt, :nd_remarks1, :nd_remarks2, :nd_remarks3
FROM   BL_CREDIT_AGREEMENT
WHERE  operating_facility_id = :nd_facility_id AND
PATIENT_ID          = :nd_patient_id 
AND    BILL_DOC_TYPE_CODE  = :nd_bill_doc_type_code
AND    BILL_DOC_NUM        = :nd_bill_doc_num
AND    CREDIT_AGREEMENT_NO = :nd_credit_agreement_num; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 11;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select TRUNC(INST_START_DATE) ,INST_AMT_MONTHLY ,BILL_OUTSTAN\
DING_AMT ,REMARKS_1 ,REMARKS_2 ,REMARKS_3 into :b0,:b1,:b2,:b3,:b4,:b5  from B\
L_CREDIT_AGREEMENT where ((((operating_facility_id=:b6 and PATIENT_ID=:b7) and\
 BILL_DOC_TYPE_CODE=:b8) and BILL_DOC_NUM=:b9) and CREDIT_AGREEMENT_NO=:b10)";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )129;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)4352;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&nd_inst_start_date;
sqlstm.sqhstl[0] = (unsigned int  )13;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&nd_inst_amt_monthly;
sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&nd_bill_outst_amt;
sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
sqlstm.sqhsts[2] = (         int  )0;
sqlstm.sqindv[2] = (         void  *)0;
sqlstm.sqinds[2] = (         int  )0;
sqlstm.sqharm[2] = (unsigned int  )0;
sqlstm.sqadto[2] = (unsigned short )0;
sqlstm.sqtdso[2] = (unsigned short )0;
sqlstm.sqhstv[3] = (         void  *)&nd_remarks1;
sqlstm.sqhstl[3] = (unsigned int  )63;
sqlstm.sqhsts[3] = (         int  )0;
sqlstm.sqindv[3] = (         void  *)0;
sqlstm.sqinds[3] = (         int  )0;
sqlstm.sqharm[3] = (unsigned int  )0;
sqlstm.sqadto[3] = (unsigned short )0;
sqlstm.sqtdso[3] = (unsigned short )0;
sqlstm.sqhstv[4] = (         void  *)&nd_remarks2;
sqlstm.sqhstl[4] = (unsigned int  )63;
sqlstm.sqhsts[4] = (         int  )0;
sqlstm.sqindv[4] = (         void  *)0;
sqlstm.sqinds[4] = (         int  )0;
sqlstm.sqharm[4] = (unsigned int  )0;
sqlstm.sqadto[4] = (unsigned short )0;
sqlstm.sqtdso[4] = (unsigned short )0;
sqlstm.sqhstv[5] = (         void  *)&nd_remarks3;
sqlstm.sqhstl[5] = (unsigned int  )63;
sqlstm.sqhsts[5] = (         int  )0;
sqlstm.sqindv[5] = (         void  *)0;
sqlstm.sqinds[5] = (         int  )0;
sqlstm.sqharm[5] = (unsigned int  )0;
sqlstm.sqadto[5] = (unsigned short )0;
sqlstm.sqtdso[5] = (unsigned short )0;
sqlstm.sqhstv[6] = (         void  *)&nd_facility_id;
sqlstm.sqhstl[6] = (unsigned int  )5;
sqlstm.sqhsts[6] = (         int  )0;
sqlstm.sqindv[6] = (         void  *)0;
sqlstm.sqinds[6] = (         int  )0;
sqlstm.sqharm[6] = (unsigned int  )0;
sqlstm.sqadto[6] = (unsigned short )0;
sqlstm.sqtdso[6] = (unsigned short )0;
sqlstm.sqhstv[7] = (         void  *)&nd_patient_id;
sqlstm.sqhstl[7] = (unsigned int  )23;
sqlstm.sqhsts[7] = (         int  )0;
sqlstm.sqindv[7] = (         void  *)0;
sqlstm.sqinds[7] = (         int  )0;
sqlstm.sqharm[7] = (unsigned int  )0;
sqlstm.sqadto[7] = (unsigned short )0;
sqlstm.sqtdso[7] = (unsigned short )0;
sqlstm.sqhstv[8] = (         void  *)&nd_bill_doc_type_code;
sqlstm.sqhstl[8] = (unsigned int  )9;
sqlstm.sqhsts[8] = (         int  )0;
sqlstm.sqindv[8] = (         void  *)0;
sqlstm.sqinds[8] = (         int  )0;
sqlstm.sqharm[8] = (unsigned int  )0;
sqlstm.sqadto[8] = (unsigned short )0;
sqlstm.sqtdso[8] = (unsigned short )0;
sqlstm.sqhstv[9] = (         void  *)&nd_bill_doc_num;
sqlstm.sqhstl[9] = (unsigned int  )sizeof(int);
sqlstm.sqhsts[9] = (         int  )0;
sqlstm.sqindv[9] = (         void  *)0;
sqlstm.sqinds[9] = (         int  )0;
sqlstm.sqharm[9] = (unsigned int  )0;
sqlstm.sqadto[9] = (unsigned short )0;
sqlstm.sqtdso[9] = (unsigned short )0;
sqlstm.sqhstv[10] = (         void  *)&nd_credit_agreement_num;
sqlstm.sqhstl[10] = (unsigned int  )sizeof(int);
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


   
/* EXEC SQL SELECT  SHORT_NAME INTO :nd_patient_name FROM MP_PATIENT_MAST
WHERE   PATIENT_ID = :nd_patient_id; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 11;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select SHORT_NAME into :b0  from MP_PATIENT_MAST where PATIEN\
T_ID=:b1";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )188;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)4352;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&nd_patient_name;
sqlstm.sqhstl[0] = (unsigned int  )63;
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



/* EXEC SQL SELECT  SHORT_NAME INTO :nd_sponsor_name FROM MP_PATIENT_MAST
WHERE   PATIENT_ID = :nd_sponsor_id; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 11;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select SHORT_NAME into :b0  from MP_PATIENT_MAST where PATIEN\
T_ID=:b1";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )211;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)4352;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&nd_sponsor_name;
sqlstm.sqhstl[0] = (unsigned int  )33;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&nd_sponsor_id;
sqlstm.sqhstl[1] = (unsigned int  )13;
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



/* EXEC SQL SELECT LN1_RES_ADD, LN2_RES_ADD, LN3_RES_ADD, LN4_RES_ADD,
       CONTACT_TEL_NUM,
       LN1_OFF_ADD, LN2_OFF_ADD, LN3_OFF_ADD, LN4_OFF_ADD,
       OFFICE_TEL_NUM
INTO   :nd_ln1_res_add, :nd_ln2_res_add, :nd_ln3_res_add, :nd_ln4_res_add,
       :nd_res_phone_num,
       :nd_ln1_off_add, :nd_ln2_off_add, :nd_ln3_off_add, :nd_ln4_off_add,
       :nd_off_phone_num  
FROM   MP_PAT_OTHER_DTLS
WHERE  PATIENT_ID = :nd_sponsor_id; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 11;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select LN1_RES_ADD ,LN2_RES_ADD ,LN3_RES_ADD ,LN4_RES_ADD ,CO\
NTACT_TEL_NUM ,LN1_OFF_ADD ,LN2_OFF_ADD ,LN3_OFF_ADD ,LN4_OFF_ADD ,OFFICE_TEL_\
NUM into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9  from MP_PAT_OTHER_DTLS where\
 PATIENT_ID=:b10";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )234;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)4352;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&nd_ln1_res_add;
sqlstm.sqhstl[0] = (unsigned int  )33;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&nd_ln2_res_add;
sqlstm.sqhstl[1] = (unsigned int  )33;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&nd_ln3_res_add;
sqlstm.sqhstl[2] = (unsigned int  )33;
sqlstm.sqhsts[2] = (         int  )0;
sqlstm.sqindv[2] = (         void  *)0;
sqlstm.sqinds[2] = (         int  )0;
sqlstm.sqharm[2] = (unsigned int  )0;
sqlstm.sqadto[2] = (unsigned short )0;
sqlstm.sqtdso[2] = (unsigned short )0;
sqlstm.sqhstv[3] = (         void  *)&nd_ln4_res_add;
sqlstm.sqhstl[3] = (unsigned int  )33;
sqlstm.sqhsts[3] = (         int  )0;
sqlstm.sqindv[3] = (         void  *)0;
sqlstm.sqinds[3] = (         int  )0;
sqlstm.sqharm[3] = (unsigned int  )0;
sqlstm.sqadto[3] = (unsigned short )0;
sqlstm.sqtdso[3] = (unsigned short )0;
sqlstm.sqhstv[4] = (         void  *)&nd_res_phone_num;
sqlstm.sqhstl[4] = (unsigned int  )21;
sqlstm.sqhsts[4] = (         int  )0;
sqlstm.sqindv[4] = (         void  *)0;
sqlstm.sqinds[4] = (         int  )0;
sqlstm.sqharm[4] = (unsigned int  )0;
sqlstm.sqadto[4] = (unsigned short )0;
sqlstm.sqtdso[4] = (unsigned short )0;
sqlstm.sqhstv[5] = (         void  *)&nd_ln1_off_add;
sqlstm.sqhstl[5] = (unsigned int  )33;
sqlstm.sqhsts[5] = (         int  )0;
sqlstm.sqindv[5] = (         void  *)0;
sqlstm.sqinds[5] = (         int  )0;
sqlstm.sqharm[5] = (unsigned int  )0;
sqlstm.sqadto[5] = (unsigned short )0;
sqlstm.sqtdso[5] = (unsigned short )0;
sqlstm.sqhstv[6] = (         void  *)&nd_ln2_off_add;
sqlstm.sqhstl[6] = (unsigned int  )33;
sqlstm.sqhsts[6] = (         int  )0;
sqlstm.sqindv[6] = (         void  *)0;
sqlstm.sqinds[6] = (         int  )0;
sqlstm.sqharm[6] = (unsigned int  )0;
sqlstm.sqadto[6] = (unsigned short )0;
sqlstm.sqtdso[6] = (unsigned short )0;
sqlstm.sqhstv[7] = (         void  *)&nd_ln3_off_add;
sqlstm.sqhstl[7] = (unsigned int  )33;
sqlstm.sqhsts[7] = (         int  )0;
sqlstm.sqindv[7] = (         void  *)0;
sqlstm.sqinds[7] = (         int  )0;
sqlstm.sqharm[7] = (unsigned int  )0;
sqlstm.sqadto[7] = (unsigned short )0;
sqlstm.sqtdso[7] = (unsigned short )0;
sqlstm.sqhstv[8] = (         void  *)&nd_ln4_off_add;
sqlstm.sqhstl[8] = (unsigned int  )33;
sqlstm.sqhsts[8] = (         int  )0;
sqlstm.sqindv[8] = (         void  *)0;
sqlstm.sqinds[8] = (         int  )0;
sqlstm.sqharm[8] = (unsigned int  )0;
sqlstm.sqadto[8] = (unsigned short )0;
sqlstm.sqtdso[8] = (unsigned short )0;
sqlstm.sqhstv[9] = (         void  *)&nd_off_phone_num;
sqlstm.sqhstl[9] = (unsigned int  )21;
sqlstm.sqhsts[9] = (         int  )0;
sqlstm.sqindv[9] = (         void  *)0;
sqlstm.sqinds[9] = (         int  )0;
sqlstm.sqharm[9] = (unsigned int  )0;
sqlstm.sqadto[9] = (unsigned short )0;
sqlstm.sqtdso[9] = (unsigned short )0;
sqlstm.sqhstv[10] = (         void  *)&nd_sponsor_id;
sqlstm.sqhstl[10] = (unsigned int  )13;
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



	 nd_hosp_name.len    = 0;
	 h_practice_num.len    = 0;
	 h_ln1_add.len		   = 0;
	 h_ln2_add.len		   = 0;
	 h_ln3_add.len		   = 0;
	 h_zip_code.len		   = 0;
	 h_tel_num.len		   = 0;
	 h_fax_num.len		   = 0;
	 h_email_id.len		   = 0;

	 nd_hosp_name.arr [ nd_hosp_name.len ]		   = '\0';
	 h_practice_num.arr [ h_practice_num.len ]		   = '\0';
	 h_ln1_add.arr [ h_ln1_add.len ]		   = '\0';
	 h_ln2_add.arr [ h_ln2_add.len ]		   = '\0';
	 h_ln3_add.arr [ h_ln3_add.len ]		   = '\0';
	 h_zip_code.arr [ h_zip_code.len ]		   = '\0';
	 h_tel_num.arr [ h_tel_num.len ]				   = '\0';
	 h_fax_num.arr [ h_fax_num.len ]				   = '\0';
	 h_email_id.arr [ h_email_id.len ]				   = '\0';



/* EXEC SQL SELECT accounting_name, PRACTICE_NUM, LN1_ADD, LN2_ADD, LN3_ADD,
					 TEL_NUM, FAX_NUM, ZIP_CODE, ACC_ENTITY_NAME_LOC_LANG
		 INTO	:nd_hosp_name, :h_practice_num, :h_ln1_add, :h_ln2_add, :h_ln3_add,
				:h_tel_num, :h_fax_num, :h_zip_code, :h_email_id
		 FROM	SY_ACC_ENTITY
		 WHERE acc_entity_id = :nd_facility_id; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 11;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select accounting_name ,PRACTICE_NUM ,LN1_ADD ,LN2_ADD ,LN3_A\
DD ,TEL_NUM ,FAX_NUM ,ZIP_CODE ,ACC_ENTITY_NAME_LOC_LANG into :b0,:b1,:b2,:b3,\
:b4,:b5,:b6,:b7,:b8  from SY_ACC_ENTITY where acc_entity_id=:b9";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )293;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)4352;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&nd_hosp_name;
sqlstm.sqhstl[0] = (unsigned int  )63;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&h_practice_num;
sqlstm.sqhstl[1] = (unsigned int  )33;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&h_ln1_add;
sqlstm.sqhstl[2] = (unsigned int  )33;
sqlstm.sqhsts[2] = (         int  )0;
sqlstm.sqindv[2] = (         void  *)0;
sqlstm.sqinds[2] = (         int  )0;
sqlstm.sqharm[2] = (unsigned int  )0;
sqlstm.sqadto[2] = (unsigned short )0;
sqlstm.sqtdso[2] = (unsigned short )0;
sqlstm.sqhstv[3] = (         void  *)&h_ln2_add;
sqlstm.sqhstl[3] = (unsigned int  )33;
sqlstm.sqhsts[3] = (         int  )0;
sqlstm.sqindv[3] = (         void  *)0;
sqlstm.sqinds[3] = (         int  )0;
sqlstm.sqharm[3] = (unsigned int  )0;
sqlstm.sqadto[3] = (unsigned short )0;
sqlstm.sqtdso[3] = (unsigned short )0;
sqlstm.sqhstv[4] = (         void  *)&h_ln3_add;
sqlstm.sqhstl[4] = (unsigned int  )33;
sqlstm.sqhsts[4] = (         int  )0;
sqlstm.sqindv[4] = (         void  *)0;
sqlstm.sqinds[4] = (         int  )0;
sqlstm.sqharm[4] = (unsigned int  )0;
sqlstm.sqadto[4] = (unsigned short )0;
sqlstm.sqtdso[4] = (unsigned short )0;
sqlstm.sqhstv[5] = (         void  *)&h_tel_num;
sqlstm.sqhstl[5] = (unsigned int  )33;
sqlstm.sqhsts[5] = (         int  )0;
sqlstm.sqindv[5] = (         void  *)0;
sqlstm.sqinds[5] = (         int  )0;
sqlstm.sqharm[5] = (unsigned int  )0;
sqlstm.sqadto[5] = (unsigned short )0;
sqlstm.sqtdso[5] = (unsigned short )0;
sqlstm.sqhstv[6] = (         void  *)&h_fax_num;
sqlstm.sqhstl[6] = (unsigned int  )33;
sqlstm.sqhsts[6] = (         int  )0;
sqlstm.sqindv[6] = (         void  *)0;
sqlstm.sqinds[6] = (         int  )0;
sqlstm.sqharm[6] = (unsigned int  )0;
sqlstm.sqadto[6] = (unsigned short )0;
sqlstm.sqtdso[6] = (unsigned short )0;
sqlstm.sqhstv[7] = (         void  *)&h_zip_code;
sqlstm.sqhstl[7] = (unsigned int  )33;
sqlstm.sqhsts[7] = (         int  )0;
sqlstm.sqindv[7] = (         void  *)0;
sqlstm.sqinds[7] = (         int  )0;
sqlstm.sqharm[7] = (unsigned int  )0;
sqlstm.sqadto[7] = (unsigned short )0;
sqlstm.sqtdso[7] = (unsigned short )0;
sqlstm.sqhstv[8] = (         void  *)&h_email_id;
sqlstm.sqhstl[8] = (unsigned int  )33;
sqlstm.sqhsts[8] = (         int  )0;
sqlstm.sqindv[8] = (         void  *)0;
sqlstm.sqinds[8] = (         int  )0;
sqlstm.sqharm[8] = (unsigned int  )0;
sqlstm.sqadto[8] = (unsigned short )0;
sqlstm.sqtdso[8] = (unsigned short )0;
sqlstm.sqhstv[9] = (         void  *)&nd_facility_id;
sqlstm.sqhstl[9] = (unsigned int  )5;
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



	 nd_hosp_name.arr [ nd_hosp_name.len ]		   = '\0';
	 h_practice_num.arr [ h_practice_num.len ]		   = '\0';
	 h_ln1_add.arr [ h_ln1_add.len ]		   = '\0';
	 h_ln2_add.arr [ h_ln2_add.len ]		   = '\0';
	 h_ln3_add.arr [ h_ln3_add.len ]		   = '\0';
     h_tel_num.arr [ h_tel_num.len ]				   = '\0';
	 h_fax_num.arr [ h_fax_num.len ]				   = '\0';
	 h_zip_code.arr [ h_zip_code.len ]		   = '\0';
	 h_email_id.arr [ h_email_id.len ]		   = '\0';
	 

/* EXEC SQL SELECT round((61-length(ACC_ENTITY_NAME))/2) INTO :nd_hosp_name_len FROM SY_ACC_ENTITY; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 11;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select round(((61-length(ACC_ENTITY_NAME))/2)) into :b0  from\
 SY_ACC_ENTITY ";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )348;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)4352;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&nd_hosp_name_len;
sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
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


}


print_agreement()
{
int spc=0;
int i=0;
char s_amt[22];
char a_amt[22];


    fprintf(f1, "\n\n\n\n");

    for (i=0;i<(80-nd_hosp_name.len)/2;i++)
		fprintf(f1," ");
    fprintf(f1,"%c(s3B",ESC);
	fprintf(f1,"%s", nd_hosp_name.arr);
    fprintf(f1,"%c(s0B",ESC);
	fprintf(f1,"\n\n\n");

     spc = strlen(h_ln1_add.arr) ; 
	 if(spc>0) 
	 {
	     fprintf(f1,"%c(s12H",ESC);
	 	 for(i=1;i<(96-spc)/2;i++) fprintf(f1," ");
		 fprintf(f1,"%s", h_ln1_add.arr); 
 		 fprintf(f1,"%c(s10H \n",ESC);
	 }
	 spc = strlen(h_ln2_add.arr) ; 
	 if(spc>0) 
	 {
	     fprintf(f1,"%c(s12H",ESC);
		 for(i=1;i<(96-spc)/2;i++) fprintf(f1," ");
		 fprintf(f1,"%s", h_ln2_add.arr); 
		 fprintf(f1,"%c(s10H \n",ESC);
	 }
	 spc = strlen(h_ln3_add.arr); 
	 if(spc>0) 
	 {
	    fprintf(f1,"%c(s12H",ESC);
		for(i=1;i<(96-spc)/2;i++) fprintf(f1," ");
		fprintf(f1,"%s", h_ln3_add.arr); 
		fprintf(f1,"%c(s10H \n",ESC);
	 }
	 spc = strlen(h_zip_code.arr); 
	 if(spc>0) 
	 {
	    fprintf(f1,"%c(s12H",ESC);
		for(i=1;i<(96-spc)/2;i++) fprintf(f1," ");
		fprintf(f1,"%s", h_zip_code.arr); 
		fprintf(f1,"%c(s10H \n",ESC);
	 }
     fprintf(f1,"%c(s12H",ESC);
 	 fprintf(f1,"Email Id	 : %s \n",h_email_id.arr);
	 fprintf(f1,"Phone No    : %s \n",h_tel_num.arr);
	 fprintf(f1,"Fax No      : %s \n",h_fax_num.arr);
	 fprintf(f1,"Practice No : %s \n",h_practice_num.arr);
	 fprintf(f1, " %c(s10H",ESC);
     fprintf(f1,"\n_________________________________________________");
     fprintf(f1,"\n\n");

    	
	fprintf(f1,"                                CREDIT AGREEMENT        NO : %d \n\n\n\n", nd_credit_agreement_num);

    fprintf(f1,"     PATIENT ID          :  %-20s\n\n", nd_patient_id.arr);

    fprintf(f1,"     PATIENT'S NAME      :  %-60s\n\n", nd_patient_name.arr);

    fprintf(f1,"     BILL NUMBER         :  %-7s / %-9d\n\n", nd_bill_doc_type_code.arr, nd_bill_doc_num);
    
	
	sprintf(s_amt, "%15.2f",nd_bill_outst_amt);

	format_amt(s_amt);

	fprintf(f1,"     OUTSTANDING AMOUNT  :  %-17s \n\n", s_amt);
	

	fprintf(f1,"     SPONSOR PATIENT ID  :  %-11s\n\n",nd_sponsor_id.arr);

    fprintf(f1,"     SPONSOR NAME        :  %-31s\n\n", nd_sponsor_name.arr);

    fprintf(f1,"     RESIDENCE ADDRESS   :  %-31s\n", nd_ln1_res_add.arr);
    fprintf(f1,"                            %-31s\n", nd_ln2_res_add.arr);
    fprintf(f1,"                            %-31s\n", nd_ln3_res_add.arr);
    fprintf(f1,"                            %-31s\n\n", nd_ln4_res_add.arr);

    fprintf(f1,"              TELEPHONE  :  %-19s\n\n", nd_res_phone_num.arr);

    fprintf(f1,"     OFFICE ADDRESS      :  %-31s\n", nd_ln1_off_add.arr);
    fprintf(f1,"                            %-31s\n", nd_ln2_off_add.arr);
    fprintf(f1,"                            %-31s\n", nd_ln3_off_add.arr);
    fprintf(f1,"                            %-31s\n\n", nd_ln4_off_add.arr);

    fprintf(f1,"              TELEPHONE  :  %-19s\n\n\n\n", nd_off_phone_num.arr);

    fprintf(f1,"         I, %-31s, herewith undertake to repay \n", nd_sponsor_name.arr);

	sprintf(a_amt, "%15.2f",nd_inst_amt_monthly);

	format_amt(a_amt);

    fprintf(f1,"     the above mentioned amount in monthly instalments of %-17s \n", a_amt);

	fprintf(f1,"     starting from %-10s.  In the event that I neglect to repay the\n",nd_inst_start_date.arr);
    fprintf(f1,"     amount, legal steps can be taken against me and I will be held \n");
    fprintf(f1,"     responsible for all legal costs incurred.\n\n\n");

  if((nd_remarks1.arr != NULL)&&
    (nd_remarks2.arr != NULL)&&
	(nd_remarks3.arr != NULL)){
    fprintf(f1,"     %-61s\n", nd_remarks1.arr);
    fprintf(f1,"     %-61s\n", nd_remarks2.arr);
    fprintf(f1,"     %-61s\n\n\n", nd_remarks3.arr);
	}
	fprintf(f1,"     SIGNED BY                                         ON   \n\n\n");
	fprintf(f1,"     ACCEPTED / APPROVED \n\n\n");

	fprintf(f1,"     HOSPITAL REPRESENTATIVE  :                        DATE  :");
}

