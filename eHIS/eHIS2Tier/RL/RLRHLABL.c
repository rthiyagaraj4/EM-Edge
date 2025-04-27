
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
           char  filnam[45];
};
static const struct sqlcxp sqlfpn =
{
    44,
    "d:\\durai\\proc\\facility_corr_proc\\rlrhlabl.pc"
};


static unsigned long sqlctx = 1033705157;


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
            void  *sqhstv[5];
   unsigned int   sqhstl[5];
            int   sqhsts[5];
            void  *sqindv[5];
            int   sqinds[5];
   unsigned int   sqharm[5];
   unsigned int   *sqharc[5];
   unsigned short  sqadto[5];
   unsigned short  sqtdso[5];
} sqlstm = {10,5};

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

 static const char *sq0004 = 
"select B.short_desc  from RL_specimen_anatomy_dtls A ,rl_test_code_lang_vw B\
 where (((A.SPECIMEN_NO=:b0 and A.OPERATING_FACILITY_ID=:b1) and A.test_code=B\
.test_code) and b.language_id=:b2)           ";

 static const char *sq0005 = 
"select B.short_desc  from RL_REQUEST_DETAIL A ,rl_test_code_lang_vw B where \
((((A.SPECIMEN_NO=:b0 and A.OPERATING_FACILITY_ID=:b1) and A.line_no=1) and A.\
test_code=B.test_code) and b.language_id=:b2)           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,169,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,30,196,0,0,0,0,0,1,0,
51,0,0,3,0,0,30,205,0,0,0,0,0,1,0,
66,0,0,4,199,0,9,221,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
93,0,0,5,210,0,9,242,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
120,0,0,6,42,0,4,256,0,0,2,1,0,1,0,1,9,0,0,2,9,0,0,
143,0,0,7,206,0,4,269,0,0,5,4,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
178,0,0,4,0,0,13,352,0,0,1,0,0,1,0,2,9,0,0,
197,0,0,5,0,0,13,381,0,0,1,0,0,1,0,2,9,0,0,
216,0,0,8,93,0,4,409,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
239,0,0,9,117,0,4,439,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
266,0,0,10,122,0,4,466,0,0,3,2,0,1,0,1,9,0,0,2,9,0,0,1,9,0,0,
293,0,0,11,122,0,4,474,0,0,3,2,0,1,0,1,9,0,0,2,9,0,0,1,9,0,0,
320,0,0,12,88,0,4,510,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
347,0,0,13,95,0,4,538,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
370,0,0,14,105,0,4,560,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
397,0,0,15,119,0,4,592,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
420,0,0,16,111,0,4,665,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
443,0,0,17,224,0,3,782,0,0,3,3,0,1,0,1,9,0,0,1,3,0,0,1,9,0,0,
};



#define NO_DATA_FOUND (sqlca.sqlcode == 1403)
#define VIEW_LOG_FILE 1
#define ONLINE_PRINTING 1
#define OERROR 		  (sqlca.sqlcode < 0)
#define INIT_MESG "Label Printing"
#define ESC 0x1B

#include <stdio.h>  
#include <string.h>
#include <math.h>
#include <malloc.h> 
#include <rl.h>

/* EXEC SQL BEGIN DECLARE SECTION; */ 
                  

/* VARCHAR uid_pwd                  [42],     
		nd_source_type	         [2],
		nd_fm_source	         [7],
        d_no_copy			     [2],
        nd_facility_id		     [3],
        //nd_facility_name	     [101],
		nd_facility_name	     [300],
        nd_ws_no                 [201],
        nd_trx_ind	             [2],
        nd_printer_type          [2],

        nd_pgm_date              [41],
        nd_session_id            [41],
        nd_specimen_no           [41],
        nd_sample_id             [41],
        nd_block_seq_no          [41],
        nd_task_code             [41],
        nd_slide_seq_no          [41],
        nd_category_code         [41],
        nd_category_year         [41],
        nd_category_number       [41],
        nd_patient_id            [41],
        nd_sample_block_slide    [41],
        nd_sample_indicator      [41],
        nd_section_code          [41],
		nd_identifier_or_tests   [541],
		nd_test_code             [41],

        d_flag			   [2],

		nd_blk_slide_trim        [11],

        er_msg                   [171], 

/o**************** variables added for **********o/

		a_ws_no               [41],
		a_pgm_id              [41],

/o**************** variables added for enhancement **********o/

//		nd_file_no			[100],
		nd_print_source_type	[2],
		nd_print_source		[2],

/o*************** variables added for CRF 0067 ****************o/
		nd_episode_type	     [5],
		nd_pat_name		     [240],
		language_id			   [5]; */ 
struct { unsigned short len; unsigned char arr[42]; } uid_pwd;

struct { unsigned short len; unsigned char arr[2]; } nd_source_type;

struct { unsigned short len; unsigned char arr[7]; } nd_fm_source;

struct { unsigned short len; unsigned char arr[2]; } d_no_copy;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[300]; } nd_facility_name;

struct { unsigned short len; unsigned char arr[201]; } nd_ws_no;

struct { unsigned short len; unsigned char arr[2]; } nd_trx_ind;

struct { unsigned short len; unsigned char arr[2]; } nd_printer_type;

struct { unsigned short len; unsigned char arr[41]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[41]; } nd_session_id;

struct { unsigned short len; unsigned char arr[41]; } nd_specimen_no;

struct { unsigned short len; unsigned char arr[41]; } nd_sample_id;

struct { unsigned short len; unsigned char arr[41]; } nd_block_seq_no;

struct { unsigned short len; unsigned char arr[41]; } nd_task_code;

struct { unsigned short len; unsigned char arr[41]; } nd_slide_seq_no;

struct { unsigned short len; unsigned char arr[41]; } nd_category_code;

struct { unsigned short len; unsigned char arr[41]; } nd_category_year;

struct { unsigned short len; unsigned char arr[41]; } nd_category_number;

struct { unsigned short len; unsigned char arr[41]; } nd_patient_id;

struct { unsigned short len; unsigned char arr[41]; } nd_sample_block_slide;

struct { unsigned short len; unsigned char arr[41]; } nd_sample_indicator;

struct { unsigned short len; unsigned char arr[41]; } nd_section_code;

struct { unsigned short len; unsigned char arr[541]; } nd_identifier_or_tests;

struct { unsigned short len; unsigned char arr[41]; } nd_test_code;

struct { unsigned short len; unsigned char arr[2]; } d_flag;

struct { unsigned short len; unsigned char arr[11]; } nd_blk_slide_trim;

struct { unsigned short len; unsigned char arr[171]; } er_msg;

struct { unsigned short len; unsigned char arr[41]; } a_ws_no;

struct { unsigned short len; unsigned char arr[41]; } a_pgm_id;

struct { unsigned short len; unsigned char arr[2]; } nd_print_source_type;

struct { unsigned short len; unsigned char arr[2]; } nd_print_source;

struct { unsigned short len; unsigned char arr[5]; } nd_episode_type;

struct { unsigned short len; unsigned char arr[240]; } nd_pat_name;

struct { unsigned short len; unsigned char arr[5]; } language_id;
 //added for globalisation


 char string_var[100];

/*tern  char WORKING_DIR_NAME [75];*/

  int no_of_rows = 0;

  int er_msg_type = 0;	
  int err_flag = 0;
  
  char string_char[100];
  	
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
char filename[150];
char filename1[150];

char *command;  
char gtt_yn = 'N';

void proc_main(argc,argv)
int argc;
char *argv[];
{
 err_flag = 0;

//ins_message(ERR_MESG,"rlrlbprn : Start");

  if(argc < 15) 
  {
     ins_message(ERR_MESG,"rlrhlabl : Usage - PGM_ID UID_PWD PGM_DATE SESSION_ID SPECIMEN_NO SAMPLE_ID BLOCK_SEQ_NO TASK_CODE SLIDE_SEQ_NO PATIENT_ID SAMPLE_BLOCK_SLIDE SAMPLE_INDICATOR SECTION_CODE FACILITY_ID WS_NO CATEGORY_CODE CATEGORY_YEAR CATEGORY_NUMBER arguments wrong\n");
  }

    strcpy(filename,WORKING_DIR);

    strcpy(a_pgm_id.arr,argv[0]);
    a_pgm_id.len = strlen(a_pgm_id.arr); 

    strcpy(uid_pwd.arr,argv[1]);
    uid_pwd.len = strlen(uid_pwd.arr); 

    strcpy(nd_pgm_date.arr, argv[2]);
    nd_pgm_date.len = strlen(nd_pgm_date.arr);

    strcpy(nd_session_id.arr, argv[3]);
    nd_session_id.len = strlen(nd_session_id.arr);

    strcpy(nd_specimen_no.arr, argv[4]);
    nd_specimen_no.len = strlen(nd_specimen_no.arr);

    strcpy(nd_sample_id.arr, argv[5]);
    nd_sample_id.len = strlen(nd_sample_id.arr);

    strcpy(nd_block_seq_no.arr, argv[6]);
    nd_block_seq_no.len = strlen(nd_block_seq_no.arr);

    strcpy(nd_task_code.arr, argv[7]);
    nd_task_code.len = strlen(nd_task_code.arr);

    strcpy(nd_slide_seq_no.arr, argv[8]);
    nd_slide_seq_no.len = strlen(nd_slide_seq_no.arr);

    strcpy(nd_patient_id.arr, argv[9]);
    nd_patient_id.len = strlen(nd_patient_id.arr);

	strcpy(nd_sample_block_slide.arr, argv[10]);
    nd_sample_block_slide.len = strlen(nd_sample_block_slide.arr);

    strcpy(nd_sample_indicator.arr, argv[11]);
    nd_sample_indicator.len = strlen(nd_sample_indicator.arr);

    strcpy(nd_section_code.arr, argv[12]);
    nd_section_code.len = strlen(nd_section_code.arr);

    strcpy(nd_facility_id.arr, argv[13]);
    nd_facility_id.len = strlen(nd_facility_id.arr);

    strcpy(nd_ws_no.arr, argv[14]);
    nd_ws_no.len = strlen(nd_ws_no.arr);

    if (argc>15)
	{
      strcpy(nd_category_code.arr, argv[15]);
      nd_category_code.len = strlen(nd_category_code.arr);

	  strcpy(nd_category_year.arr, argv[16]);
      nd_category_year.len = strlen(nd_category_year.arr);

      strcpy(nd_category_number.arr, argv[17]);
      nd_category_number.len = strlen(nd_category_number.arr);
	}

    strcpy(filename1, a_pgm_id.arr);

    strcat(filename, strcat(filename1, ".lis"));

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
    sqlstm.sqhstl[0] = (unsigned int  )44;
    sqlstm.sqhsts[0] = (         int  )44;
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
 /*********************** added for globalisation ******************************/
    strcpy(language_id.arr,l_language_id.arr);
	language_id.len =l_language_id.len;
	language_id.arr[l_language_id.len]='\0';
/*********************** added for globalisation ******************************/

    get_facility_name();

    get_printer_type();

    get_trans_ind();

	get_sam_anatomy_ind();

//	get_identifier_or_test();  commented by preetham on 08/10/2007 wrt SD-CRF-0067

	get_pat_name();   // added by preetham on 08/10/2007 wrt SD-CRF-0067

//	get_task_slide_no();    commented by preetham on 08/10/2007 wrt SD-CRF-0067

	trim_block_slide();     // added by preetham on 07/01/2008 wrt ML-SD-SCF-2047
    
	call_main_report();

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

	fclose(f1);
    sprintf(string_var,"%s -> %s\n",nd_specimen_no.arr, sqlca.sqlerrm.sqlerrmc);
    ins_message(ORA_MESG,string_var);
    /* EXEC SQL COMMIT WORK RELEASE; */ 

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



}

dclr_spec_anat_test_cur()
{
 
		/* EXEC SQL DECLARE c_spec_anat_test
                             CURSOR FOR
                             SELECT B.short_desc
                             FROM   RL_specimen_anatomy_dtls A, rl_test_code_lang_vw B
                             WHERE  A.SPECIMEN_NO = :nd_specimen_no
                             AND    A.OPERATING_FACILITY_ID = :nd_facility_id
							 AND    A.test_code = B.test_code
							 and	b.language_id = :language_id; */ 


		/* EXEC SQL OPEN c_spec_anat_test; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0004;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )66;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_specimen_no;
  sqlstm.sqhstl[0] = (unsigned int  )43;
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
  sqlstm.sqhstv[2] = (         void  *)&language_id;
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



    if (OERROR) 
    {
      ins_message (ORA_MESG, "OPEN Cursor c_spec_anat_test Failed ");
    }
}

dclr_test_cur()
{
 
		/* EXEC SQL DECLARE c_test
                             CURSOR FOR
                             SELECT B.short_desc
                             FROM RL_REQUEST_DETAIL A, rl_test_code_lang_vw B
                             WHERE A.SPECIMEN_NO = :nd_specimen_no
                             AND   A.OPERATING_FACILITY_ID = :nd_facility_id
							 AND   A.line_no = 1
							 AND   A.test_code =  B.test_code
							 and   b.language_id = :language_id; */ 


		/* EXEC SQL OPEN c_test; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0005;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )93;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_specimen_no;
  sqlstm.sqhstl[0] = (unsigned int  )43;
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
  sqlstm.sqhstv[2] = (         void  *)&language_id;
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



    if (OERROR) 
    {
      ins_message (ORA_MESG, "OPEN Cursor c_test Failed ");
    }
}

trim_block_slide()        // added by preetham on 07-01-2008 wrt ML-SD-SCF-2047
{

   nd_blk_slide_trim.arr[0] = '\0';
   nd_blk_slide_trim.len = 0;

   /* EXEC SQL select ltrim(:nd_sample_block_slide,'-') into nd_blk_slide_trim from dual; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select ltrim(:b0,'-') into :b1  from dual ";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )120;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_sample_block_slide;
   sqlstm.sqhstl[0] = (unsigned int  )43;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_blk_slide_trim;
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



   nd_blk_slide_trim.len = strlen(nd_blk_slide_trim.arr);
   strcpy(nd_sample_block_slide.arr, nd_blk_slide_trim.arr);
   nd_sample_block_slide.len = strlen(nd_sample_block_slide.arr);

}

get_identifier_or_test()
{

  if (strcmp(nd_sample_indicator.arr, "AT") == 0 )
  {
    /* EXEC SQL SELECT B.short_desc
  	          INTO   nd_identifier_or_tests
  	          FROM   RL_SAMPLE_DETAILS A, RL_TEST_CODE_lang_vw B
  	          WHERE  SPECIMEN_NO = :nd_specimen_no
  	          AND    OPERATING_FACILITY_ID = :nd_facility_id
  	          AND    SAMPLE_ID   = :nd_sample_id
			  AND	A.test_code = B.test_code
			  and	b.language_id = :language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select B.short_desc into :b0  from RL_SAMPLE_DETAILS A ,R\
L_TEST_CODE_lang_vw B where ((((SPECIMEN_NO=:b1 and OPERATING_FACILITY_ID=:b2)\
 and SAMPLE_ID=:b3) and A.test_code=B.test_code) and b.language_id=:b4)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )143;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_identifier_or_tests;
    sqlstm.sqhstl[0] = (unsigned int  )543;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_specimen_no;
    sqlstm.sqhstl[1] = (unsigned int  )43;
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
    sqlstm.sqhstv[3] = (         void  *)&nd_sample_id;
    sqlstm.sqhstl[3] = (unsigned int  )43;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&language_id;
    sqlstm.sqhstl[4] = (unsigned int  )7;
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
    {
	  strcpy(nd_identifier_or_tests.arr, "");
	  sprintf(string_var,"%s get_identifier_or_test()-> %s\n", nd_facility_id.arr, sqlca.sqlerrm.sqlerrmc);
      ins_message(ORA_MESG, string_var);
    }
    if(NO_DATA_FOUND)
    {
	  strcpy(nd_identifier_or_tests.arr, "");
      nd_identifier_or_tests.arr[nd_identifier_or_tests.len]   = '\0';
      nd_identifier_or_tests.len = strlen(nd_identifier_or_tests.arr);
    }

    nd_identifier_or_tests.arr[nd_identifier_or_tests.len]   = '\0';
    nd_identifier_or_tests.len = strlen(nd_identifier_or_tests.arr);

    if (strlen(nd_identifier_or_tests.arr) == 0 )
	{
	  strcpy(nd_identifier_or_tests.arr, "");
	  nd_identifier_or_tests.len = strlen(nd_identifier_or_tests.arr);

	  dclr_spec_anat_test_cur();
      while(fetch_spec_anat_test_cur())
      {
	    if (strlen(nd_identifier_or_tests.arr) > 0 )
		{
          sprintf(nd_identifier_or_tests.arr,"%s, %s", nd_identifier_or_tests.arr, nd_test_code.arr);
          nd_identifier_or_tests.len = strlen(nd_identifier_or_tests.arr);
		}
		else
		{
          sprintf(nd_identifier_or_tests.arr,"%s", nd_test_code.arr);
          nd_identifier_or_tests.len = strlen(nd_identifier_or_tests.arr);
		}
      }


      if (no_of_rows == 0)
	  {
  	    dclr_test_cur();
        while(fetch_test_cur())
        {
	      if (strlen(nd_identifier_or_tests.arr) > 0 )
		  {
            sprintf(nd_identifier_or_tests.arr,"%s, %s", nd_identifier_or_tests.arr, nd_test_code.arr);
            nd_identifier_or_tests.len = strlen(nd_identifier_or_tests.arr);
		  }
		  else
		  {
            sprintf(nd_identifier_or_tests.arr,"%s", nd_test_code.arr);
            nd_identifier_or_tests.len = strlen(nd_identifier_or_tests.arr);
		  }
        }
      }
	}
  }
  else
  {
    strcpy(nd_identifier_or_tests.arr, nd_sample_block_slide.arr);
  }

//sprintf(string_var, " Identifier  %s", nd_identifier_or_tests.arr);
//disp_message(ERR_MESG, string_var);

}


int fetch_spec_anat_test_cur()
{

  nd_test_code.len = 0;
  nd_test_code.arr[nd_test_code.len] = '\0';

      /* EXEC SQL FETCH c_spec_anat_test INTO
                     :nd_test_code; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 5;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )178;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&nd_test_code;
      sqlstm.sqhstl[0] = (unsigned int  )43;
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
	{
		sprintf(string_var,"%s fetch_spec_anat_test_cur()-> %s\n", nd_facility_id.arr, sqlca.sqlerrm.sqlerrmc);
        ins_message (ORA_MESG, "FETCH failed c_test_cur ");
		return 0;
      }

    if (NO_DATA_FOUND)
      return 0;

    nd_test_code.arr[nd_test_code.len] = '\0';
    nd_test_code.len = strlen(nd_test_code.arr);

  no_of_rows = no_of_rows + 1;
  if (no_of_rows == 2)
    return 0;
  else
    return 1;
  
}

int fetch_test_cur()
{

  nd_test_code.len = 0;
  nd_test_code.arr[nd_test_code.len] = '\0';

      /* EXEC SQL FETCH c_test INTO
                     :nd_test_code; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 5;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )197;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&nd_test_code;
      sqlstm.sqhstl[0] = (unsigned int  )43;
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
	{
		sprintf(string_var,"%s fetch_test_cur()-> %s\n", nd_facility_id.arr, sqlca.sqlerrm.sqlerrmc);
        ins_message (ORA_MESG, "FETCH failed c_test_cur ");
		return 0;
      }

    if (NO_DATA_FOUND)
      return 0;

    nd_test_code.arr[nd_test_code.len] = '\0';
    nd_test_code.len = strlen(nd_test_code.arr);

  no_of_rows = no_of_rows + 1;
  if (no_of_rows == 2)
    return 0;
  else
    return 1;
  
}

get_sam_anatomy_ind()
{
  nd_sample_indicator.len = 0;
  nd_sample_indicator.arr[nd_sample_indicator.len] = '\0';

    /* EXEC SQL SELECT NVL(use_sample_anatomy_ind, 'NA')
             INTO   :nd_sample_indicator
             FROM   rl_section_code
             WHERE  section_code = :nd_section_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select NVL(use_sample_anatomy_ind,'NA') into :b0  from rl\
_section_code where section_code=:b1";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )216;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_sample_indicator;
    sqlstm.sqhstl[0] = (unsigned int  )43;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_section_code;
    sqlstm.sqhstl[1] = (unsigned int  )43;
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
    {
	  strcpy(nd_sample_indicator.arr, "");
	  sprintf(string_var,"%s get_sam_anatomy_ind()-> %s\n", nd_section_code.arr, sqlca.sqlerrm.sqlerrmc);
      ins_message(ORA_MESG, string_var);
    }
    if(NO_DATA_FOUND)
    {
	  strcpy(nd_sample_indicator.arr, "");
      nd_sample_indicator.arr[nd_sample_indicator.len]   = '\0';
      nd_sample_indicator.len = strlen(nd_sample_indicator.arr);
    }
    nd_sample_indicator.arr[nd_sample_indicator.len]   = '\0';
    nd_sample_indicator.len = strlen(nd_sample_indicator.arr);

}

/************************** added by preetham on 08/10/2007 wrt SD-CRF-0067 ***********/
get_pat_name()
{
	nd_episode_type.arr[0]		= '\0';
	nd_pat_name.arr[0]			= '\0';

	nd_episode_type.len		= 0;
	nd_pat_name.len			= 0;
	
    /* EXEC SQL SELECT episode_type
             INTO   :nd_episode_type
             FROM   RL_REQUEST_HEADER
             WHERE  specimen_no = TO_NUMBER(:nd_specimen_no)
			 AND    operating_facility_id  = :nd_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select episode_type into :b0  from RL_REQUEST_HEADER wher\
e (specimen_no=TO_NUMBER(:b1) and operating_facility_id=:b2)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )239;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_episode_type;
    sqlstm.sqhstl[0] = (unsigned int  )7;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_specimen_no;
    sqlstm.sqhstl[1] = (unsigned int  )43;
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
	  sprintf(string_var,"%s episode type()-> %s\n", nd_facility_id.arr, sqlca.sqlerrm.sqlerrmc);
      ins_message(ORA_MESG, string_var);
    }

    if(NO_DATA_FOUND)
    {
	  strcpy(nd_episode_type.arr, "");
      nd_episode_type.arr[nd_episode_type.len]   = '\0';
      nd_episode_type.len = strlen(nd_episode_type.arr);
  	  sprintf(string_var,"%s get_pat_name()-> %s\n", nd_facility_id.arr, sqlca.sqlerrm.sqlerrmc);
      ins_message(ORA_MESG, string_var);
    }

    nd_episode_type.arr[nd_episode_type.len]   = '\0';
    nd_episode_type.len = strlen(nd_episode_type.arr);

  if  ( strcmp(nd_episode_type.arr , "I") == 0  || 
			strcmp(nd_episode_type.arr , "O") == 0 || strcmp(nd_episode_type.arr , "H") == 0 )
  {
    /* EXEC SQL SELECT DECODE(:language_id, 'en', SHORT_NAME, 'th', SHORT_NAME_LOC_LANG) short_name
             INTO   :nd_pat_name
             FROM   MP_PATIENT_MAST
             WHERE  patient_id = :nd_patient_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select DECODE(:b0,'en',SHORT_NAME,'th',SHORT_NAME_LOC_LAN\
G) short_name into :b1  from MP_PATIENT_MAST where patient_id=:b2";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )266;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&language_id;
    sqlstm.sqhstl[0] = (unsigned int  )7;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_pat_name;
    sqlstm.sqhstl[1] = (unsigned int  )242;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_patient_id;
    sqlstm.sqhstl[2] = (unsigned int  )43;
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
  else
  {
    /* EXEC SQL SELECT DECODE(:language_id, 'en', SHORT_NAME, 'th', SHORT_NAME_LOC_LANG) short_name
             INTO   :nd_pat_name
             FROM   RL_PATIENT_MAST
             WHERE  patient_id=:nd_patient_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select DECODE(:b0,'en',SHORT_NAME,'th',SHORT_NAME_LOC_LAN\
G) short_name into :b1  from RL_PATIENT_MAST where patient_id=:b2";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )293;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&language_id;
    sqlstm.sqhstl[0] = (unsigned int  )7;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_pat_name;
    sqlstm.sqhstl[1] = (unsigned int  )242;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_patient_id;
    sqlstm.sqhstl[2] = (unsigned int  )43;
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

   if(OERROR)
   {
	  strcpy(nd_pat_name.arr, "");
	  sprintf(string_var,"%s get_pat_name()-> %s\n", nd_facility_id.arr, sqlca.sqlerrm.sqlerrmc);
      ins_message(ORA_MESG, string_var);
    }
    if(NO_DATA_FOUND)
    {
	  strcpy(nd_pat_name.arr, "");
      nd_pat_name.arr[nd_pat_name.len]   = '\0';
      nd_pat_name.len = strlen(nd_pat_name.arr);
	  
	  sprintf(string_var,"%s get_pat_name()-> %s\n", nd_facility_id.arr, sqlca.sqlerrm.sqlerrmc);
      ins_message(ORA_MESG, string_var);

    }

    nd_pat_name.arr[nd_pat_name.len]   = '\0';
    nd_pat_name.len = strlen(nd_pat_name.arr);


}

/**************************** till here ***********************************************/

get_task_slide_no()
{
  if (strcmp(nd_sample_indicator.arr, "SA") == 0 )
  {
    /* EXEC SQL SELECT short_desc
             INTO   :nd_slide_seq_no
             FROM   RL_TASK_MAST
             WHERE  task_code=:nd_task_code
			 AND    section_code = :nd_section_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select short_desc into :b0  from RL_TASK_MAST where (task\
_code=:b1 and section_code=:b2)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )320;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_slide_seq_no;
    sqlstm.sqhstl[0] = (unsigned int  )43;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_task_code;
    sqlstm.sqhstl[1] = (unsigned int  )43;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_section_code;
    sqlstm.sqhstl[2] = (unsigned int  )43;
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
    {
	  strcpy(nd_slide_seq_no.arr, "");
	  sprintf(string_var,"%s get_task_slide_no()-> %s\n", nd_facility_id.arr, sqlca.sqlerrm.sqlerrmc);
      ins_message(ORA_MESG, string_var);
    }
    if(NO_DATA_FOUND)
    {
	  strcpy(nd_slide_seq_no.arr, "");
      nd_slide_seq_no.arr[nd_slide_seq_no.len]   = '\0';
      nd_slide_seq_no.len = strlen(nd_slide_seq_no.arr);
    }
    nd_slide_seq_no.arr[nd_slide_seq_no.len]   = '\0';
    nd_slide_seq_no.len = strlen(nd_slide_seq_no.arr);
  }
}

get_facility_name()
{

	nd_facility_name.arr[0]		= '\0';
	nd_facility_name.len		= 0;

	/* EXEC SQL  SELECT facility_short_name
	            INTO :nd_facility_name
	            FROM rl_param_for_facility
               WHERE operating_facility_id = :nd_facility_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select facility_short_name into :b0  from rl_param_for_facil\
ity where operating_facility_id=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )347;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_facility_name;
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
		sprintf(string_var,"%s get_facility_name(1)-> %s\n", nd_facility_id.arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
	}

	nd_facility_name.arr[nd_facility_name.len]   = '\0';
	nd_facility_name.len = strlen(nd_facility_name.arr);

    if(NO_DATA_FOUND)
    {
      nd_facility_name.arr[nd_facility_name.len]   = '\0';
      nd_facility_name.len = strlen(nd_facility_name.arr);
    }

    if (strlen(nd_facility_name.arr) <= 0 )
	{
		/* EXEC SQL  SELECT facility_name
			      INTO   :nd_facility_name
				  FROM   sm_facility_param_lang_vw
				  WHERE  facility_id = :nd_facility_id
				  and language_id = :language_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select facility_name into :b0  from sm_facility_param_lang_\
vw where (facility_id=:b1 and language_id=:b2)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )370;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_facility_name;
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
  sqlstm.sqhstv[2] = (         void  *)&language_id;
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



		if(OERROR)
		{
			sprintf(string_var,"%s get_facility_name()-> %s\n", nd_facility_id.arr, sqlca.sqlerrm.sqlerrmc);
			ins_message(ORA_MESG, string_var);
		}

		nd_facility_name.arr[nd_facility_name.len]   = '\0';
		nd_facility_name.len = strlen(nd_facility_name.arr);

		if(NO_DATA_FOUND)
		{
		nd_facility_name.arr[nd_facility_name.len]   = '\0';
		nd_facility_name.len = strlen(nd_facility_name.arr);
		}
	}

}

/**************************select transaction based or not ***************/
get_trans_ind()
{

	
	nd_trx_ind.arr[0]		= '\0';
	nd_trx_ind.len		= 0;

	/* EXEC SQL  SELECT NVL(TRANSACTION_BASED_YN, 'N')
	            INTO :nd_trx_ind
	            FROM sy_online_print_id
               WHERE MODULE_ID = 'RL'
   		         AND ONLINE_PRINT_NAME = :a_pgm_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select NVL(TRANSACTION_BASED_YN,'N') into :b0  from sy_onlin\
e_print_id where (MODULE_ID='RL' and ONLINE_PRINT_NAME=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )397;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_trx_ind;
 sqlstm.sqhstl[0] = (unsigned int  )4;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&a_pgm_id;
 sqlstm.sqhstl[1] = (unsigned int  )43;
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
	{
		sprintf(string_var,"%s get_trans_ind()-> %s\n", nd_specimen_no.arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
	}

    if(NO_DATA_FOUND)
      nd_trx_ind.arr[nd_trx_ind.len]   = '\0';
		
	 if (strcmp(nd_trx_ind.arr, "Y") == 0)
	 {
		strcpy(nd_print_source_type.arr, nd_source_type.arr);
		strcpy(nd_print_source.arr, nd_fm_source.arr);
	 }
	 else
	 {
		strcpy(nd_print_source_type.arr, "O");
		strcpy(nd_print_source.arr, " ");
	 }

}

call_main_report()
{
  call_print_label();
}

set_fonts()
{

/*	fprintf(f1,"%c&k4S",ESC); This will make the font condensed */	
/*  fprintf(fp,"%c(s4B",ESC); This will make the font bold      */
	fprintf(f1, "%c(s15H", ESC);/* Reduce the font size*/
	fprintf(f1,"%c&a0L",ESC);/* This will make the left margin to reduce to 0 */
	fprintf(f1,"%c&l0E\n",ESC);	/* This will make the top margin to reduce to 0 */
	fprintf(f1,"%c&l12D",ESC);/* This will make no. of lines per inch to 8 */
}

call_print_label()
{

    if ( ( f1 = fopen ( filename, "w" ) ) == NULL ) 
    {
      ins_message(ERR_MESG,"Error in opening output file...\n");  
    }

    print_sample_label(1);
    fclose(f1);

    if (strcmp(nd_printer_type.arr,"3")!= 0)
    {	
      fprintf(f1, "%cE", ESC);
      set_fonts();
    }
    if (err_flag == 0)
    {
       print_barcode_label(1);
    }
}

/******************* added on 28.07.2003 ********/
get_printer_type()
{

	  strcpy(nd_printer_type.arr, "3");
	  nd_printer_type.len = strlen(nd_printer_type.arr);

	  /* EXEC SQL SELECT NVL(printer_type, '1')
  	           INTO  :nd_printer_type
  	           FROM   SY_ONLINE_PRINT_ID
	           WHERE  module_id = 'RL'
	           AND    online_print_name = :a_pgm_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 5;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select NVL(printer_type,'1') into :b0  from SY_ONLINE_PRIN\
T_ID where (module_id='RL' and online_print_name=:b1)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )420;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_printer_type;
   sqlstm.sqhstl[0] = (unsigned int  )4;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&a_pgm_id;
   sqlstm.sqhstl[1] = (unsigned int  )43;
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

 

        if(NO_DATA_FOUND)
   		strcpy(nd_printer_type.arr, "3");
		nd_printer_type.len = strlen(nd_printer_type.arr);
  	  if(OERROR)
   		strcpy(nd_printer_type.arr, "3");
		nd_printer_type.len = strlen(nd_printer_type.arr);

	  nd_printer_type.arr[nd_printer_type.len]  = '\0';
	  nd_printer_type.len = 0;

}

/*  added by preetham on 08/10/2007 wrt SD-CRF-0067*/
print_sample_label(int v_ind)
{
	fprintf(f1, "%-13.13s\n", nd_facility_name.arr);
	fprintf(f1, "%-13.13s\n", nd_pat_name.arr);
	fprintf(f1, "%-s\n", nd_patient_id.arr);
	if (strlen(nd_category_code.arr) > 0)
	{
      fprintf(f1, "%-s-%-c%-c-%-s\n", nd_category_code.arr, nd_category_year.arr[2], nd_category_year.arr[3], nd_category_number.arr);
	}
	fprintf(f1, "%-s %s\n", nd_sample_block_slide.arr, nd_task_code.arr );
}


/*  commented by preetham on 08/10/2007 wrt SD-CRF-0067
print_sample_label(int v_ind)
{
	fprintf(f1, "%-13.13s\n", nd_facility_name.arr);
//	fprintf(f1, "%-s\n", nd_specimen_no.arr);
	if (strlen(nd_category_code.arr) > 0)
	{
      fprintf(f1, "%-s-%-s-%-s\n", nd_category_code.arr, nd_category_year.arr, nd_category_number.arr);
	}
	fprintf(f1, "%-s\n", nd_patient_id.arr);
	fprintf(f1, "%-s\n", nd_identifier_or_tests.arr);
	fprintf(f1, "%-s\n", nd_slide_seq_no.arr);
}
*/

/***************** Print BarCode Label ********************/
print_barcode_label(int nolabel)
 {
    int i;
    int WSPrintstatus;

    for(i=0;i<nolabel;i++)
		  {

		 		if (nd_source_type.arr[0]	== '!')
				{					

					 WSPrintDocument 
						   (
							uid_pwd.arr,		//char	*PUidPwd;
							nd_session_id.arr,	//char	*PSessionID;
							nd_facility_id.arr,	//char	*PFacilityID;
							"RL",				//char	*PModuleID;
							a_pgm_id.arr,			//char	*PDocumentID;
							filename,	    	//char	*POnlinePrintFileNames;
							"O",				//char	*PLocationTypes;
							" ",				//char	*PLocationCodes;
							1,			//int	PNumOfCopies;
							1,				    //int	PPageFrom;
							9999,				//int	PPageTo;
							nd_ws_no.arr,		//char	*PWorkstationID
							WORKING_DIR			//char	*PReportOutputDir
						   );
				}						   
				else
				{


					WSPrintstatus =		 WSPrintDocument
						   (
							uid_pwd.arr,				//char	*PUidPwd;
							nd_session_id.arr,			//char	*PSessionID;
							nd_facility_id.arr,			//char	*PFacilityID;
							"RL",						//char	*PModuleID;
							a_pgm_id.arr,					//char	*PDocumentID;
							filename,	    			//char	*POnlinePrintFileNames;
							nd_print_source_type.arr,	//char	*PLocationTypes;
							nd_print_source.arr,	    //char	*PLocationCodes;
							1,					//int	PNumOfCopies;
							1,							//int	PPageFrom;
							9999,						//int	PPageTo;
							nd_ws_no.arr,				//char	*PWorkstationID
							WORKING_DIR					//char	*PReportOutputDir
						   );

				}	  					   
		  }
 
 }


/*--------------------------------------------------*/
ins_message(int msg_type,char msg[])
{
   er_msg.arr[0] = '\0';
   er_msg.len = 0;
   

   er_msg_type = 0;

   strcpy(er_msg.arr,msg);
   er_msg.len = strlen(er_msg.arr);
 
   er_msg_type = msg_type;   

   /* EXEC SQL

   INSERT INTO SY_PROG_MSG
         (OPERATING_FACILITY_ID,PGM_ID,MSG_TYPE,MSG_NUM,MSG_DESC,MSG_DATE_TIME,SESSION_ID,PGM_DATE)
   VALUES 
         (:nd_facility_id,'RLRHLABL',:er_msg_type,NULL, SUBSTR(:er_msg, 1, 70),SYSDATE,USERENV('sessionid'),TO_CHAR(SYSDATE,'DD/MM/YYYY')); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 5;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "insert into SY_PROG_MSG (OPERATING_FACILITY_ID,PGM_ID,MSG_\
TYPE,MSG_NUM,MSG_DESC,MSG_DATE_TIME,SESSION_ID,PGM_DATE) values (:b0,'RLRHLABL\
',:b1,null ,SUBSTR(:b2,1,70),SYSDATE,USERENV('sessionid'),TO_CHAR(SYSDATE,'DD/\
MM/YYYY'))";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )443;
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
   sqlstm.sqhstv[1] = (         void  *)&er_msg_type;
   sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&er_msg;
   sqlstm.sqhstl[2] = (unsigned int  )173;
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



   err_flag = 1;
}

