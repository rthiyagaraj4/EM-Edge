
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
           char  filnam[21];
};
static const struct sqlcxp sqlfpn =
{
    20,
    "c:\\temp1\\rlrshift.pc"
};


static unsigned long sqlctx = 72625979;


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
            void  *sqhstv[11];
   unsigned int   sqhstl[11];
            int   sqhsts[11];
            void  *sqindv[11];
            int   sqinds[11];
   unsigned int   sqharm[11];
   unsigned int   *sqharc[11];
   unsigned short  sqadto[11];
   unsigned short  sqtdso[11];
} sqlstm = {10,11};

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

 static const char *sq0011 = 
"select section_code ,TO_CHAR(specimen_date,'DD/MM/YYYY') ,NVL(request_shift_\
1,0) ,NVL(analyzer_shift_1,0) ,NVL(reported_shift_1,0) ,NVL(request_shift_2,0)\
 ,NVL(analyzer_shift_2,0) ,NVL(reported_shift_2,0) ,NVL(request_shift_3,0) ,NV\
L(analyzer_shift_3,0) ,NVL(reported_shift_3,0)  from RL_SHIFT_WISE_STATISTICS \
where (((specimen_date>(TO_DATE(:b0,'DD/MM/YYYY')-1) and specimen_date<(TO_DAT\
E(:b1,'DD/MM/YYYY')+1)) and section_code between NVL(:b2,'!') and NVL(:b3,'~')\
) and OPERATING_FACILITY_ID=:b4) order by section_code,specimen_date          \
  ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,164,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,30,185,0,0,0,0,0,1,0,
51,0,0,3,0,0,32,193,0,0,0,0,0,1,0,
66,0,0,4,187,0,4,297,0,0,7,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,
0,0,1,9,0,0,
109,0,0,5,109,0,2,333,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
132,0,0,6,0,0,32,341,0,0,0,0,0,1,0,
147,0,0,7,120,0,6,351,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
170,0,0,8,136,0,6,366,0,0,2,2,0,1,0,2,9,0,0,1,3,0,0,
193,0,0,9,142,0,4,417,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
228,0,0,10,0,0,32,441,0,0,0,0,0,1,0,
243,0,0,11,546,0,9,543,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
278,0,0,12,0,0,32,552,0,0,0,0,0,1,0,
293,0,0,11,0,0,13,577,0,0,11,0,0,1,0,2,9,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,3,0,0,2,
3,0,0,2,3,0,0,2,3,0,0,2,3,0,0,2,3,0,0,2,3,0,0,
352,0,0,11,0,0,15,602,0,0,0,0,0,1,0,
367,0,0,13,0,0,32,607,0,0,0,0,0,1,0,
382,0,0,14,100,0,4,722,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
409,0,0,15,101,0,6,860,0,0,1,1,0,1,0,2,3,0,0,
428,0,0,16,49,0,4,873,0,0,1,0,0,1,0,2,9,0,0,
};


/****************************OCS MEDICOM ver 1.0*****************************
*  File	: rlrshift.pc
   Author : C. Dinesh menon
   Date Created  : 10/06/2001
   Last Modified : 10/06/2001

*  Ver 1.10.01
   
*  Purpose : To generate a report for Shift Wise Statistics of Specimens Received 

*  Input Parameters :    
              Command line inputs
	
		      1. Usr_id/Password
              2. Session id
		      3. Program Date
                 Parameters from SY_PROG_PARAM table 
              4. Preferred range of Section Codes.
  
*  Table Accessed : RL_REQUEST_HEADER,RL_TEST_RESULT,
					RL_SECTION_CODE, RL_ONLINE_INSTRUMENT,
					RL_ONLINE_INSTRUMENT_TEST,
					OP_CLINIC, IP_WARD, RL_REFERRAL
		    

*  Output File : rlrshift.lis
 ****************************************************************************/  

#include <stdio.h>
#include <math.h>
#include <string.h>
#include <stdlib.h>
#include <gl.h>

#define REP_WIDTH 78
#define MAX_LINES 50
#define OERROR (sqlca.sqlcode < 0)
#define NODATAFOUND sqlca.sqlcode==1403
#define VER  "VER : 1.10.01\n"
/*
#define DEBUG 
*/

/* EXEC SQL BEGIN DECLARE SECTION; */ 

/* INPUT PARAMETERS TO MAIN */

	/* VARCHAR  nd_operating_facility_id [3],
	         uid_pwd		          [91],
		     nd_user_id               [31],
		     nd_session_id            [16],
		     nd_pgm_date	          [20], 
		     nd_user                  [15],
             nd_file_no               [15],
		     nd_file_name		      [150],
			 d_version_no			  [20],
			 d_version  			  [20],
			 l_translated_value		 [100],
			 language_id			[5]; */ 
struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[31]; } nd_user_id;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[20]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } nd_user;

struct { unsigned short len; unsigned char arr[15]; } nd_file_no;

struct { unsigned short len; unsigned char arr[150]; } nd_file_name;

struct { unsigned short len; unsigned char arr[20]; } d_version_no;

struct { unsigned short len; unsigned char arr[20]; } d_version;

struct { unsigned short len; unsigned char arr[100]; } l_translated_value;

struct { unsigned short len; unsigned char arr[5]; } language_id;





/* Fields from table RL_SECTION_CODE */
	 /* varchar      d_printer_name            [16]; */ 
struct { unsigned short len; unsigned char arr[16]; } d_printer_name;


/* Fields from table SY_ACC_ENTITY*/
	/* varchar 	d_acc_entity_name        [300],
				//d_acc_entity_name        [61], 
				d_user                   [21],
				d_sysdate                [17]; */ 
struct { unsigned short len; unsigned char arr[300]; } d_acc_entity_name;

struct { unsigned short len; unsigned char arr[21]; } d_user;

struct { unsigned short len; unsigned char arr[17]; } d_sysdate;


 /*INPUT PARAMETERS FROM SY_PROG_PARAM TABLE  */
	/* varchar nd_fm_section_code			[2],
			nd_to_section_code			[2],
	 		nd_fm_date					[11],
			nd_to_date					[11]; */ 
struct { unsigned short len; unsigned char arr[2]; } nd_fm_section_code;

struct { unsigned short len; unsigned char arr[2]; } nd_to_section_code;

struct { unsigned short len; unsigned char arr[11]; } nd_fm_date;

struct { unsigned short len; unsigned char arr[11]; } nd_to_date;



/* SQL statement storing in this Variable */
   char sql_stmt	[500] ;

	/* varchar d_section_code			[2],
			d_section_desc			[41],
			d_prev_section_code		[2],
			d_specimen_date			[11]; */ 
struct { unsigned short len; unsigned char arr[2]; } d_section_code;

struct { unsigned short len; unsigned char arr[41]; } d_section_desc;

struct { unsigned short len; unsigned char arr[2]; } d_prev_section_code;

struct { unsigned short len; unsigned char arr[11]; } d_specimen_date;


int d_request_shift_1 = 0, d_analyzer_shift_1 = 0, d_reported_shift_1 = 0,
	d_request_shift_2 = 0, d_analyzer_shift_2 = 0, d_reported_shift_2 = 0,
	d_request_shift_3 = 0, d_analyzer_shift_3 = 0, d_reported_shift_3 = 0;
int l_count = 0;

int  l_tab_exists ;
int  i;
char local_legend[15][100];


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
 
char string_var[100] ;

char hdr_line1[REP_WIDTH+1],
     hdr_line2[REP_WIDTH+1],
     hdr_line3[REP_WIDTH+1],
     hdr_line4[REP_WIDTH+1],
     hdr_line5[REP_WIDTH+1];

char rep_title1[] = " Shift Wise Statistics ";
char rep_title2[30];

int line_no = 0;
int page_no = 0 ;

int d_request_1 = 0, d_analyzer_1 = 0, d_reported_1 = 0,
	d_request_2 = 0, d_analyzer_2 = 0, d_reported_2 = 0,
	d_request_3 = 0, d_analyzer_3 = 0, d_reported_3 = 0;

long t_request_1 = 0, t_analyzer_1 = 0, t_reported_1 = 0,
	t_request_2 = 0, t_analyzer_2 = 0, t_reported_2 = 0,
	t_request_3 = 0, t_analyzer_3 = 0, t_reported_3 = 0;


FILE *f1;

void proc_main(argc, argv)
int argc;
char *argv[];
{
    void gen_file_name() ;
    void get_header_dtls() ;

   if(argc < 5) {
     disp_message(ORA_MESG,"Usage rlrshift uid/passwd pgm_date from section code to section code from date to date\n");
     proc_exit();
   }

   strcpy(uid_pwd.arr, argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr); 

   strcpy(nd_pgm_date.arr, argv[3]);
   nd_pgm_date.len = strlen(nd_pgm_date.arr); 

   strcpy(nd_operating_facility_id.arr, argv[4]);
   nd_operating_facility_id.len = strlen(nd_operating_facility_id.arr); 

   strcpy(OUTPUT_FILE_NAME, argv[5]);

   strcpy(nd_fm_section_code.arr, argv[6]);
   nd_fm_section_code.len = strlen(nd_fm_section_code.arr); 

   strcpy(nd_to_section_code.arr, argv[7]);
   nd_to_section_code.len = strlen(nd_to_section_code.arr); 

   strcpy(nd_fm_date.arr, argv[8]);
   nd_fm_date.len = strlen(nd_fm_date.arr); 

   strcpy(nd_to_date.arr, argv[9]);
   nd_to_date.len = strlen(nd_to_date.arr); 

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

  

   if(OERROR)
      disp_message(ORA_MESG,"Failed to connect using : \n");

    #ifdef DEBUG
      printf("Connected to ORACLE as user: %s \n", uid_pwd.arr);
    #endif  
    
	set_meduser_role();
    strcpy(language_id.arr,l_language_id.arr);
	language_id.len =l_language_id.len;
	language_id.arr[l_language_id.len]='\0';

	get_legend_value(12); 
	get_header_dtls() ;
	gen_file_name(); 

    do_report();

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


	   
	fclose(f1);

	return ;

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


   disp_message(ORA_MESG,"Oracle error at main() occured....\n");
   proc_exit();
}   


/********************* CHECK PAGE BREAK ************************/
chk_break(nol)
{
   if ((line_no + nol) >= MAX_LINES)
   {
/*     fprintf(f1,"");*/
	 form_hdr();
	 print_column_heading();
	 line_no = 1;
   }
}

/********************* FORM HDR ************************/
form_hdr()
{

    static int first = 1;
    char buf[15];
    int col;

        strcpy(rep_title2," from ");
        strcat(rep_title2, nd_fm_date.arr);
		strcat(rep_title2, " to ");
		strcat(rep_title2, nd_to_date.arr);

    if(first) 
	{
        memset(hdr_line1,' ',REP_WIDTH+1);
        memset(hdr_line2,' ',REP_WIDTH+1);
        memset(hdr_line4,' ',REP_WIDTH+1);
		memset(hdr_line5,'-',REP_WIDTH);
		hdr_line5[REP_WIDTH] = '\0';

        strncpy(hdr_line1,"MDL:RL",6);
        col = (int)(REP_WIDTH - strlen(d_acc_entity_name.arr))/2;
        strncpy(hdr_line1 + col -1,d_acc_entity_name.arr,strlen(d_acc_entity_name.arr));
        col = (REP_WIDTH-strlen(d_sysdate.arr));
		strcpy(hdr_line1+col+1,d_sysdate.arr);
    
        strncpy(hdr_line2,"OPR:",4);
        strcpy(hdr_line2+6,d_user.arr);

    }

    memset(hdr_line3,' ',REP_WIDTH+1);

    strncpy(hdr_line3,"REP:RLRSHIFT",12);
    col = (int)(REP_WIDTH-strlen(rep_title1))/2;
    strncpy(hdr_line3+col,rep_title1,strlen(rep_title1));
    sprintf(buf,"PAGE : %4d",page_no++);
    strcpy(hdr_line3+(REP_WIDTH-strlen(buf)),buf);

    col = (int)(REP_WIDTH-strlen(rep_title2))/2;
    strcpy(hdr_line4+col,rep_title2);

    if(first)
        fprintf(f1,"%s\n",hdr_line1);
    else
        fprintf(f1,"\f%s\n",hdr_line1);

    fprintf(f1,"%s\n",hdr_line2);
    fprintf(f1,"%s\n",hdr_line3);
    fprintf(f1,"%s\n",hdr_line4);
    fprintf(f1,"%s\n",hdr_line5);

    first = 0;
}

/********************* PRINT END OF REPORT ************************/
print_end_of_rep()
{
    int col;
    char buff[REP_WIDTH+1];

    memset(buff,' ',REP_WIDTH+1);
    col = (int)(REP_WIDTH-19)/2;

    strncpy(buff+col,"** END OF REPORT **",19);
    fprintf(f1,"\n%s\n",buff);
}

/************* get_params ***************/
void get_params()
{
	nd_fm_section_code.arr[0] 		= '\0';
	nd_fm_section_code.len			= 0 ;
	nd_to_section_code.arr[0]		= '\0' ;
	nd_to_section_code.len			= 0;
	nd_fm_date.arr[0]				= '\0' ;
	nd_fm_date.len					= 0 ;
	nd_to_date.arr[0]				= '\0' ;
	nd_to_date.len					= 0 ;	

   if(OERROR)
      disp_message(ORA_MESG,"get parameter function using : \n");

   /* read the parameter record */
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL SELECT OPERATING_FACILITY_ID,
                   PARAM1,
				   PARAM2,
				   PARAM3,
				   PARAM4
		    INTO 
				:nd_operating_facility_id,
				:nd_fm_section_code ,  
				:nd_to_section_code ,
				:nd_fm_date ,
				:nd_to_date 
         FROM SY_PROG_PARAM
	     WHERE   UPPER(PGM_ID) = 'RLRSHIFT'
		    AND SESSION_ID = TO_NUMBER(:nd_session_id)
		    AND PGM_DATE = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,PARA\
M4 into :b0,:b1,:b2,:b3,:b4  from SY_PROG_PARAM where ((UPPER(PGM_ID)='RLRSHIF\
T' and SESSION_ID=TO_NUMBER(:b5)) and PGM_DATE=:b6)";
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
   sqlstm.sqhstv[1] = (         void  *)&nd_fm_section_code;
   sqlstm.sqhstl[1] = (unsigned int  )4;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_to_section_code;
   sqlstm.sqhstl[2] = (unsigned int  )4;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_fm_date;
   sqlstm.sqhstl[3] = (unsigned int  )13;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_to_date;
   sqlstm.sqhstl[4] = (unsigned int  )13;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[5] = (unsigned int  )18;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[6] = (unsigned int  )22;
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
   if (sqlca.sqlcode < 0) goto err_exit;
}



   
	/*strcpy(first_date.arr,nd_fm_date.arr) ;*/
   if(OERROR)
      disp_message(ORA_MESG,"get_parameter_function2 : \n");
   
  nd_fm_section_code.arr[nd_fm_section_code.len] 		= '\0';
  nd_to_section_code.arr[nd_to_section_code.len]		= '\0';
  nd_fm_date.arr[nd_fm_date.len]						= '\0';
  nd_to_date.arr[nd_to_date.len]						= '\0';

  #ifdef DEBUG
   printf("**********Parameters from SY_PROG_PARAM *******************\n");
   printf(" nd_fm_section_code = %s\n",nd_fm_section_code.arr);
   printf(" nd_to_section_code = %s\n",nd_to_section_code.arr);
   printf(" nd_fm_date = %s\n",nd_fm_date.arr);
   printf(" nd_to_date = %s\n",nd_to_date.arr);
   getchar();  
#endif
  /* delete the parameter record */
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL DELETE FROM SY_PROG_PARAM
	   WHERE UPPER(PGM_ID) = 'RLRSHIFT'
	         AND SESSION_ID = TO_NUMBER(:nd_session_id)
		 AND PGM_DATE = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((UPPER(PGM_ID)='RLRSHIF\
T' and SESSION_ID=TO_NUMBER(:b0)) and PGM_DATE=:b1)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )109;
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
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )132;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_params() occured....\n");
   proc_exit();
}

/***************GET_LEGEND_VAUE********************/
get_legend_value(int cou)
 {


	/* EXEC SQL EXECUTE
	BEGIN
	  SM_POPULATE_REPORT_LEGEND.FETCH_LEGEND (:nd_operating_facility_id,:language_id,'RLRSHIFT.LEGEND_');
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin SM_POPULATE_REPORT_LEGEND . FETCH_LEGEND ( :nd_operati\
ng_facility_id , :language_id , 'RLRSHIFT.LEGEND_' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )147;
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
 sqlstm.sqhstv[1] = (         void  *)&language_id;
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






 for (i=1; i<=cou; i++)
	{


	l_translated_value.arr[0]		= '\0';
	
	/* EXEC SQL EXECUTE
	BEGIN
               :l_translated_value :=    GET_LEGEND(LTRIM(RTRIM('RLRSHIFT.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009'))))));
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin :l_translated_value := GET_LEGEND ( LTRIM ( RTRIM ( 'R\
LRSHIFT.LEGEND_' || LTRIM ( RTRIM ( TO_CHAR ( :i , '009' ) ) ) ) ) ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )170;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_translated_value;
 sqlstm.sqhstl[0] = (unsigned int  )102;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&i;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
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


	
	l_translated_value.arr[l_translated_value.len] = '\0';

	//sp_message(ERR_MESG,l_translated_value.arr);

	strcpy(local_legend[i],l_translated_value.arr);

	

	}
	

 }
/*************END**************/









/************ GET_HEADER_DETAILS****************/
void get_header_dtls()
{
     d_acc_entity_name.arr[0]   = '\0';
	 d_acc_entity_name.len		= 0;
	 d_user.arr[0]				= '\0';
	 d_user.len                 = 0;
	 d_sysdate.arr[0]			= '\0';
	 d_sysdate.len              = 0;

   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /*
   EXEC SQL SELECT SUBSTR(LPAD(ACC_ENTITY_NAME,
		       TRUNC(15 + 0.5*LENGTH(ACC_ENTITY_NAME))),1,30),
		   USER,
		   TO_CHAR(SYSDATE, 'DD/MM/YYYY HH24:MI')
	    INTO :d_acc_entity_name,
		 :d_user,
		 :d_sysdate
            FROM SY_ACC_ENTITY_LANG_VW
			WHERE LANGUAGE_ID = :language_id;
   */

   /* EXEC SQL SELECT ACC_ENTITY_NAME,
		       USER,
		       TO_CHAR(SYSDATE, 'DD/MM/YYYY')
	    INTO :d_acc_entity_name,
		 :d_user,
		 :d_sysdate
             FROM SY_ACC_ENTITY
             WHERE ACC_ENTITY_ID = :nd_operating_facility_id
			 AND LANGUAGE_ID = :language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select ACC_ENTITY_NAME ,USER ,TO_CHAR(SYSDATE,'DD/MM/YYYY'\
) into :b0,:b1,:b2  from SY_ACC_ENTITY where (ACC_ENTITY_ID=:b3 and LANGUAGE_I\
D=:b4)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )193;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_acc_entity_name;
   sqlstm.sqhstl[0] = (unsigned int  )302;
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
   if (sqlca.sqlcode < 0) goto err_exit;
}



  d_acc_entity_name.arr[d_acc_entity_name.len] = '\0';
  d_user.arr[d_user.len]                       = '\0';
  d_sysdate.arr[d_sysdate.len]                 = '\0';

#ifdef DEBUG
   printf("d_acc_entity_name = %s\n", d_acc_entity_name.arr);
   printf("d_user = %s\n", d_user.arr);
   printf("d_sysdate = %s\n", d_sysdate.arr);
#endif

  return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )228;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_header_dtls() occured....\n");
   proc_exit();
}

/*************** GENERATE FILE NAME ***************/
void gen_file_name()
{

 	 /* For a constant file name (4 lines) */
  	 strcpy(nd_file_name.arr,WORKING_DIR) ;
     nd_file_name.len = strlen(nd_file_name.arr);
	 //strcat(nd_file_name.arr,"rlrshift.lis");
	 strcat(nd_file_name.arr,OUTPUT_FILE_NAME);
	 nd_file_name.len = strlen(nd_file_name.arr);

	 if ((f1 = fopen(nd_file_name.arr,"w")) == NULL)
     {
       sprintf(string_var,"Error while opening file %s\n",nd_file_name.arr);
	   disp_message(ERR_MESG,string_var) ;
       proc_exit();
     }
}

/*********** PRINT REPORT HEADER **************/
void print_rep_header()
{
  char nd_fm_section_desc[10],
       nd_to_section_desc[10];

  if(strcmp(nd_fm_section_code.arr, "!") == 0)
    strcpy(nd_fm_section_desc, "LOWEST");
    else strcpy(nd_fm_section_desc, nd_fm_section_code.arr);

  if(strcmp(nd_to_section_code.arr, "~") == 0)
    strcpy(nd_to_section_desc, "HIGHEST");
    else strcpy(nd_to_section_desc, nd_to_section_code.arr);

  #ifdef DEBUG
      printf("before report header()\n");
  #endif

  form_hdr();

  #ifdef DEBUG
      printf("after page header()\n");
  #endif
/*  page_no++ ;*/

  get_version_no();   ///// added 01.07.2003

////////// 01.07.2003  fprintf(f1,VER);

  fprintf(f1,"%s\n",d_version.arr);

  fprintf(f1,"\n\n\n\n");
  fprintf(f1,"        ");
  fprintf(f1,"%s\n",local_legend[2]);
  fprintf(f1,"        ");
  fprintf(f1,"------------------\n\n");
  fprintf(f1,"                ");
  fprintf(f1,"%-40.40s : %s\n", local_legend[3],nd_fm_section_desc);
  fprintf(f1,"                ");
  fprintf(f1,"%-40.40s : %s\n",local_legend[4], nd_to_section_desc);
  fprintf(f1,"\n");
/*  fprintf(f1,""); */
}

/***************PRINT  COLUMN HEADING *************/
print_column_heading()
{
 //fprintf(f1,"%4.4s         	        %5.5s 1                               %5.5s 2                           %5.5s 3\n");
 fprintf(f1,"%4.4s             %5.5s 1              %5.5s 2             %5.5s 3\n",local_legend[5],local_legend[6],local_legend[6],local_legend[6]);
 fprintf(f1,"------------------------------------------------------------------------------------------------------------------------------------\n");
 //fprintf(f1,"              <----- No. of Requests ----->        <----- No. of Requests ----->     <----- No. of Requests ----->\n");
 fprintf(f1,"              <- %10.10s->     <- %10.10s->     <- %10.10s->\n",local_legend[7],local_legend[7],local_legend[7]);
 //fprintf(f1,"              Booked   Analysers  Reported          Booked    Analysers Reported       Booked    Analysers  Reported\n");
 fprintf(f1,"              %15.15s     %15.15s     %15.15s\n",local_legend[8],local_legend[8],local_legend[8]);
 fprintf(f1,"------------------------------------------------------------------------------------------------------------------------------------\n");

 line_no += 5;
}

/********* DECLARE SHIFT CURSOR **********/
 dclr_shift_cursor()
 {
	
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

	/* EXEC SQL DECLARE shift_cursor CURSOR FOR
			SELECT section_code, TO_CHAR(specimen_date, 'DD/MM/YYYY'),
					NVL(request_shift_1, 0), NVL(analyzer_shift_1, 0), NVL(reported_shift_1, 0),
					NVL(request_shift_2, 0), NVL(analyzer_shift_2, 0), NVL(reported_shift_2, 0),
					NVL(request_shift_3, 0), NVL(analyzer_shift_3, 0), NVL(reported_shift_3, 0)
			FROM RL_SHIFT_WISE_STATISTICS
			WHERE specimen_date > TO_DATE(:nd_fm_date, 'DD/MM/YYYY') - 1
			AND specimen_date < TO_DATE(:nd_to_date, 'DD/MM/YYYY') + 1
			AND section_code BETWEEN NVL(:nd_fm_section_code, '!')
				AND NVL(:nd_to_section_code, '~')
		    AND OPERATING_FACILITY_ID = :nd_operating_facility_id
			ORDER BY section_code, specimen_date; */ 



	/* EXEC SQL OPEN shift_cursor; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0011;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )243;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_fm_date;
 sqlstm.sqhstl[0] = (unsigned int  )13;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_to_date;
 sqlstm.sqhstl[1] = (unsigned int  )13;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_fm_section_code;
 sqlstm.sqhstl[2] = (unsigned int  )4;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_to_section_code;
 sqlstm.sqhstl[3] = (unsigned int  )4;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}



#ifdef DEBUG
    printf("leaving dclr_shift_cursor_cur()\n");
    fflush(stdout);
#endif
  return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )278;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at dclr_shift_cursor_cur() occured....\n");
   proc_exit();	
  }

/*********** FETCH SHIFT CURSOR **********/
int fetch_shift_cursor()
{

	d_specimen_date.arr[0]		= '\0';
	d_section_code.arr[0]		= '\0';

	d_specimen_date.len			= 0;
	d_section_code.len			= 0;

	d_request_shift_1 = 0;
	d_analyzer_shift_1 = 0;
	d_reported_shift_1 = 0;
	d_request_shift_2 = 0;
	d_analyzer_shift_2 = 0;
	d_reported_shift_2 = 0;
	d_request_shift_3 = 0;
	d_analyzer_shift_3 = 0;
	d_reported_shift_3 = 0;

    /* EXEC SQL FETCH shift_cursor
              INTO :d_section_code,:d_specimen_date,
				   :d_request_shift_1, :d_analyzer_shift_1, 
				   :d_reported_shift_1, 
				   :d_request_shift_2, :d_analyzer_shift_2, 
				   :d_reported_shift_2, 
				   :d_request_shift_3, :d_analyzer_shift_3, 
				   :d_reported_shift_3; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )293;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_section_code;
    sqlstm.sqhstl[0] = (unsigned int  )4;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_specimen_date;
    sqlstm.sqhstl[1] = (unsigned int  )13;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_request_shift_1;
    sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_analyzer_shift_1;
    sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_reported_shift_1;
    sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_request_shift_2;
    sqlstm.sqhstl[5] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_analyzer_shift_2;
    sqlstm.sqhstl[6] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_reported_shift_2;
    sqlstm.sqhstl[7] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&d_request_shift_3;
    sqlstm.sqhstl[8] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&d_analyzer_shift_3;
    sqlstm.sqhstl[9] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&d_reported_shift_3;
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

 

	if (OERROR)
        err_mesg(ORA_MESG,"FETCH failed on cursor RL_SHIFT_WISE_STATISTICS");

	if (NO_DATA_FOUND)
		return 0;

	d_specimen_date.arr[d_specimen_date.len]		= '\0';
	d_section_code.arr[d_section_code.len]			= '\0';

	return 1;
}

close_shift_cursor()
{

	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

	/* EXEC SQL CLOSE shift_cursor; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )352;
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
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )367;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at dclr_shift_cursor_cur() occured....\n");
   proc_exit();	

}

/********************* DO REPORT ************************/
do_report()
{
	
   char first_time = 'Y';
      
   d_prev_section_code.arr[0]	= '\0';
   d_prev_section_code.len		= 0;

   page_no = 1;
   line_no = 1;

   print_rep_header();
   line_no = 59;
   chk_break(1);

    d_request_1 = 0;
	d_request_2 = 0; 
	d_request_3 = 0; 
	d_analyzer_1 = 0;
	d_analyzer_2 = 0;
	d_analyzer_3 = 0;
	d_reported_2 = 0;
	d_reported_1 = 0;
	d_reported_3 = 0;

	t_request_1 = 0;
	t_analyzer_1 = 0;
	t_reported_1 = 0;
	t_request_2 = 0;
	t_analyzer_2 = 0;
	t_reported_2 = 0;
	t_request_3 = 0;
	t_analyzer_3 = 0;
	t_reported_3 = 0;

      
   dclr_shift_cursor();
   
   while(fetch_shift_cursor())
   {


	   if (strcmp(d_prev_section_code.arr, d_section_code.arr) != 0)
	   {

		   strcpy(d_prev_section_code.arr, d_section_code.arr);
		   d_prev_section_code.len = strlen(d_prev_section_code.arr);
		   
		   if (first_time == 'N')
		   {
			   print_total();
			   
			}

		   get_section_desc();
		   print_dept_dtl();
		   first_time = 'N';
	   }

	   print_dtl();

   		d_request_1 = d_request_1 + d_request_shift_1;
		d_analyzer_1 = d_analyzer_1 + d_analyzer_shift_1;
		d_reported_1 = d_reported_1 + d_reported_shift_1;
		d_request_2 = d_request_2 + d_request_shift_2;
		d_analyzer_2 = d_analyzer_2 + d_analyzer_shift_2;
		d_reported_2 = d_reported_2 + d_reported_shift_2;
		d_request_3 = d_request_3 + d_request_shift_3;
		d_analyzer_3 = d_analyzer_3 + d_analyzer_shift_3;
		d_reported_3 = d_reported_3 + d_reported_shift_3;

   		t_request_1 = t_request_1 + d_request_shift_1;
		t_analyzer_1 = t_analyzer_1 + d_analyzer_shift_1;
		t_reported_1 = t_reported_1 + d_reported_shift_1;
		t_request_2 = t_request_2 + d_request_shift_2;
		t_analyzer_2 = t_analyzer_2 + d_analyzer_shift_2;
		t_reported_2 = t_reported_2 + d_reported_shift_2;
		t_request_3 = t_request_3 + d_request_shift_3;
		t_analyzer_3 = t_analyzer_3 + d_analyzer_shift_3;
		t_reported_3 = t_reported_3 + d_reported_shift_3;


   }

   print_total();

   print_grand_total();

   close_shift_cursor();


}

/************** PRINT DEPARTMENT COLUMN HEADING ***************/
print_dept_dtl()
{
	chk_break(1);
	fprintf(f1,"%10.10s : %-40s\n",local_legend[9],d_section_desc.arr);
	fprintf(f1,"-----------------------------------\n");
    line_no += 2 ;
 
}

get_section_desc()
{
	d_section_desc.arr[0]	= '\0';
	d_section_desc.len		= 0;

	/* EXEC SQL SELECT long_name 
			 INTO :d_section_desc
			 FROM RL_SECTION_CODE_LANG_VW
			 WHERE section_code = :d_section_code
			 AND   language_id = :language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select long_name into :b0  from RL_SECTION_CODE_LANG_VW wher\
e (section_code=:b1 and language_id=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )382;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_section_desc;
 sqlstm.sqhstl[0] = (unsigned int  )43;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_section_code;
 sqlstm.sqhstl[1] = (unsigned int  )4;
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



	d_section_desc.arr[d_section_desc.len]		= '\0';

}

print_total()
{
	chk_break(3);

/****
	sprintf(string_var, "%s  %s  %d  %d   %d", 
				d_specimen_date.arr, d_section_code.arr, 
					d_request_1, d_analyzer_1, d_reported_1);
	disp_message(ERR_MESG, string_var);
*****/
/*
	fprintf(f1,"                --------------------------------------------------------------------------------------------------------------------\n");
	fprintf(f1,"%5.5s    ",local_legend[10]);
	fprintf(f1,"      %4d        %4d      %4d",
			d_request_1, d_analyzer_1, d_reported_1);
	fprintf(f1,"            %4d         %4d     %4d",
			d_request_2, d_analyzer_2, d_reported_2);
	fprintf(f1,"         %4d         %4d      %4d\n",
			d_request_3, d_analyzer_3, d_reported_3);				       
	fprintf(f1,"                --------------------------------------------------------------------------------------------------------------------\n");
*/
	
	fprintf(f1,"            --------------------------------------------------------------------------------------------------------------------\n");
	fprintf(f1,"%5.5s        ",local_legend[10]);
	fprintf(f1,"%4d  %4d  %4d",
			d_request_1, d_analyzer_1, d_reported_1);
	fprintf(f1,"    %4d  %4d  %4d",
			d_request_2, d_analyzer_2, d_reported_2);
	fprintf(f1,"    %4d  %4d  %4d\n",
			d_request_3, d_analyzer_3, d_reported_3);				       
	fprintf(f1,"            --------------------------------------------------------------------------------------------------------------------\n");

	line_no += 3;

	d_request_1 = 0;
	d_analyzer_1 = 0;
	d_reported_1 = 0;
	d_request_2 = 0;
	d_analyzer_2 = 0;
	d_reported_2 = 0;
	d_request_3 = 0;
	d_analyzer_3 = 0;
	d_reported_3 = 0;

}


print_grand_total()
{
	chk_break(5);

	fprintf(f1, "\n\n");

/*
	fprintf(f1,"                --------------------------------------------------------------------------------------------------------------------\n");
	fprintf(f1,"Grand Total");
	fprintf(f1,"   %6ld      %6ld    %6ld",
			t_request_1, t_analyzer_1, t_reported_1);
	fprintf(f1,"          %6ld       %6ld   %6ld",
			t_request_2, t_analyzer_2, t_reported_2);
	fprintf(f1,"       %6ld       %6ld    %6d\n",
			t_request_3, t_analyzer_3, t_reported_3);				       
	fprintf(f1,"                --------------------------------------------------------------------------------------------------------------------\n");
*/

	fprintf(f1,"            --------------------------------------------------------------------------------------------------------------------\n");
	fprintf(f1,"%11.11s",local_legend[11]);
	fprintf(f1,"%6ld%6ld%6ld",
			t_request_1, t_analyzer_1, t_reported_1);
	fprintf(f1,"  %6ld%6ld%6ld",
			t_request_2, t_analyzer_2, t_reported_2);
	fprintf(f1,"  %6ld%6ld%6d\n",
			t_request_3, t_analyzer_3, t_reported_3);				       
	fprintf(f1,"            --------------------------------------------------------------------------------------------------------------------\n");

	line_no += 3;

	t_request_1 = 0;
	t_analyzer_1 = 0;
	t_reported_1 = 0;
	t_request_2 = 0;
	t_analyzer_2 = 0;
	t_reported_2 = 0;
	t_request_3 = 0;
	t_analyzer_3 = 0;
	t_reported_3 = 0;

}

print_dtl()
{

	chk_break(1);
/*
	fprintf(f1, "%-10s      %4d        %4d      %4d",
			d_specimen_date.arr, d_request_shift_1, 
			d_analyzer_shift_1, d_reported_shift_1);
	fprintf(f1,"            %4d         %4d     %4d",
			d_request_shift_2, d_analyzer_shift_2, d_reported_shift_2);
	fprintf(f1,"         %4d         %4d      %4d\n",
			d_request_shift_3, d_analyzer_shift_3, d_reported_shift_3);				       
*/
	fprintf(f1, "%-10s   %4d  %4d  %4d",
			d_specimen_date.arr, d_request_shift_1, 
			d_analyzer_shift_1, d_reported_shift_1);
	fprintf(f1, "    %4d  %4d  %4d",
			d_request_shift_2, d_analyzer_shift_2, d_reported_shift_2);
	fprintf(f1, "    %4d  %4d  %4d\n",
			d_request_shift_3, d_analyzer_shift_3, d_reported_shift_3);				       

	line_no++;


}

////////////////// 

get_version_no()
{

////////    This function is used to get the version number of the product.
///////      Added by Srinivas on 1 July 2003

     d_version_no.arr[0] = '\0';
     d_version_no.len    =  0;

     strcpy(d_version.arr,"VER : ");

	 /* EXEC SQL EXECUTE 
	      begin
			if SM_INSTALLATION_TAB_CHECK THEN
			   :l_tab_exists := 1;
			else
			   :l_tab_exists := 0;
			end if;
		  end;
	 END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin if SM_INSTALLATION_TAB_CHECK THEN :l_tab_exists := 1 \
; else :l_tab_exists := 0 ; end if ; end ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )409;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&l_tab_exists;
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




    if (l_tab_exists) 
    {
	    /* EXEC SQL SELECT VERSION_NO INTO :d_version_no 
                 FROM   SM_INSTALLATION; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 11;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select VERSION_NO into :b0  from SM_INSTALLATION ";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )428;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&d_version_no;
     sqlstm.sqhstl[0] = (unsigned int  )22;
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

 
        d_version_no.arr[d_version_no.len] = '\0';
    }
    else
	    strcpy(d_version_no.arr,"2.1");

	    strcat(d_version.arr,d_version_no.arr);


    if (OERROR)
	{
	    strcpy(d_version_no.arr,"2.1");
	    strcat(d_version.arr,d_version_no.arr);
    }

}
//////////// UPTO HERE   




#undef DEBUG
#undef OERROR
#undef NODATAFOUND
#undef MAX_LINES
#undef VER


