
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
           char  filnam[36];
};
static const struct sqlcxp sqlfpn =
{
    35,
    "d:\\work\\proc\\5\\rdrxrlbl\\rdrxrlbl.pc"
};


static unsigned long sqlctx = 1932897253;


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
            void  *sqhstv[7];
   unsigned int   sqhstl[7];
            int   sqhsts[7];
            void  *sqindv[7];
            int   sqinds[7];
   unsigned int   sqharm[7];
   unsigned int   *sqharc[7];
   unsigned short  sqadto[7];
   unsigned short  sqtdso[7];
} sqlstm = {10,7};

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

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,128,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,184,0,4,137,0,0,2,1,0,1,0,1,9,0,0,2,9,0,0,
59,0,0,3,198,0,4,153,0,0,6,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,
0,0,
98,0,0,4,209,0,4,186,0,0,7,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,1,9,0,0,
141,0,0,5,198,0,4,199,0,0,7,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,1,9,0,0,
184,0,0,6,0,0,30,397,0,0,0,0,0,1,0,
199,0,0,7,0,0,32,403,0,0,0,0,0,1,0,
214,0,0,8,437,0,6,460,0,0,4,4,0,1,0,3,3,0,0,1,9,0,0,1,9,0,0,2,9,0,0,
245,0,0,9,112,0,6,508,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
268,0,0,10,136,0,6,521,0,0,2,2,0,1,0,2,9,0,0,1,3,0,0,
291,0,0,11,58,0,4,543,0,0,1,0,0,1,0,2,9,0,0,
};


/*
#define DEBUG
*/

#define NO_DATA_FOUND (sqlca.sqlcode == 1403)
#define VIEW_LOG_FILE 1
#define ONLINE_PRINTING 1

// -- 44837 Sandeep K Gujje 20-NOV-2013
#define NODATAFOUND				(sqlca.sqlcode == 1403)
#define OERROR 					(sqlca.sqlcode < 0)

/*#define SPACE1 0xA1
#define SPACE2 0x40*/

#include <stdio.h>  
#include <string.h>
#include <gl.h>
#include <math.h>

/* EXEC SQL BEGIN DECLARE SECTION; */ 


/* VARCHAR nd_pgm_id          [9],
		uid_pwd            [122], /o Length changed from 91 to 122 o/
		nd_session_id      [16],
        nd_pgm_date        [13],
		nd_facility_id     [3],
		
		d_request_num      [10],
        d_no_copy          [2],
		nd_trx_ind		   [2],
		nd_printer_type    [2],

		d_patient_id       [21],
		d_request_date     [11],
		d_pat_pregnant     [11],
		d_lmp_date         [11],

		d_pat_name         [101],
		d_date_of_birth    [11],
		d_national_id_num  [16],
		d_sex              [2],
		
		p_language_id	   [3],
		date_convert	   [21],
		nd_temp_date	   [21],
		nd_loc_date        [21],
		l_translated_value [200]; */ 
struct { unsigned short len; unsigned char arr[9]; } nd_pgm_id;

struct { unsigned short len; unsigned char arr[122]; } uid_pwd;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[13]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[10]; } d_request_num;

struct { unsigned short len; unsigned char arr[2]; } d_no_copy;

struct { unsigned short len; unsigned char arr[2]; } nd_trx_ind;

struct { unsigned short len; unsigned char arr[2]; } nd_printer_type;

struct { unsigned short len; unsigned char arr[21]; } d_patient_id;

struct { unsigned short len; unsigned char arr[11]; } d_request_date;

struct { unsigned short len; unsigned char arr[11]; } d_pat_pregnant;

struct { unsigned short len; unsigned char arr[11]; } d_lmp_date;

struct { unsigned short len; unsigned char arr[101]; } d_pat_name;

struct { unsigned short len; unsigned char arr[11]; } d_date_of_birth;

struct { unsigned short len; unsigned char arr[16]; } d_national_id_num;

struct { unsigned short len; unsigned char arr[2]; } d_sex;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[21]; } date_convert;

struct { unsigned short len; unsigned char arr[21]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[21]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[200]; } l_translated_value;


// -- 44837 Sandeep K Gujje 20-NOV-2013
/* VARCHAR l_customer_id	[10], d_pat_name1[15], d_pat_name2[30]; */ 
struct { unsigned short len; unsigned char arr[10]; } l_customer_id;

struct { unsigned short len; unsigned char arr[15]; } d_pat_name1;

struct { unsigned short len; unsigned char arr[30]; } d_pat_name2;
		

		int i=0,
			time_flag = 0;


char   d_chin_name_yn;        
char string_var [100];
/*tern  char WORKING_DIR_NAME [75];*/

float       mths,dys; 

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

char loc_legend[999][200];

void proc_main(argc,argv)
int argc;
char *argv[];
{
   char  *command;
   int i;
   float yrs,days;
   int   iyrs,imths,idays;
   char age[5];

	if(argc < 6) {
		disp_message(ERR_MESG,"rdrxrlbl : Usage - rdrxrlbl uid/pwd request_num\n");
        proc_exit();
	}
	/* strcpy(OUTPUT_FILE_NAME,"normal.lis");*/
	
	strcpy(filename,WORKING_DIR);
	strcat(filename,"rdrxrlbl.lis");

	if ( ( f1 = fopen ( filename, "w" ) ) == NULL ) 
	{
		disp_message(ERR_MESG,"Error in opening output file...\n");
		proc_exit();
    }
	
	strcpy(nd_pgm_id.arr,argv[0]);
    nd_pgm_id.len = strlen(nd_pgm_id.arr);
	
    strcpy(uid_pwd.arr,argv[1]);
    uid_pwd.len = strlen(uid_pwd.arr);

    strcpy(nd_session_id.arr, argv[2]);
    nd_session_id.len = strlen(nd_session_id.arr); 
     
    strcpy(nd_pgm_date.arr, argv[3]);
    nd_pgm_date.len = strlen(nd_pgm_date.arr); 
     
    strcpy(nd_facility_id.arr, argv[4]);
    nd_facility_id.len = strlen(nd_facility_id.arr); 
	 
	strcpy(d_request_num.arr,argv[5]);
    d_request_num.len = strlen(d_request_num.arr);

    strcpy(nd_trx_ind.arr, argv[6]);
    nd_trx_ind.len = strlen(nd_trx_ind.arr); 

	//rcpy(nd_printer_type.arr, argv[7]);
    //_printer_type.len = strlen(nd_printer_type.arr);  
	
	strcpy(d_no_copy.arr,argv[7]);
    d_no_copy.len = strlen(d_no_copy.arr);
    
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
    sqlstm.sqhstl[0] = (unsigned int  )124;
    sqlstm.sqhsts[0] = (         int  )124;
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

	/*Code Included for internationalization*/
	strcpy(p_language_id.arr,l_language_id.arr);
	p_language_id.len = l_language_id.len;

	/*Ravi Shankar, 09/02/2012, Leap year changes*/
	/* EXEC SQL SELECT NVL(print_language_id,:p_language_id)
			   INTO :p_language_id
			   FROM SM_REPORT
			  WHERE MODULE_ID = 'RD'
				AND REPORT_ID  = 'RDRXRLBL'
				AND SYSDATE BETWEEN NVL(eff_from_date,SYSDATE) AND NVL(eff_to_date,SYSDATE); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select NVL(print_language_id,:b0) into :b0  from SM_REPORT w\
here ((MODULE_ID='RD' and REPORT_ID='RDRXRLBL') and SYSDATE between NVL(eff_fr\
om_date,SYSDATE) and NVL(eff_to_date,SYSDATE))";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )36;
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
 sqlstm.sqhstv[1] = (         void  *)&p_language_id;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}



	    if(NO_DATA_FOUND)
			disp_message(ERR_MESG,"no data found");
		
	    if(OERROR)
			disp_message(ERR_MESG,"Failed at Select SM_REPORT");
	////////////
		
	fetch_legend_value();

    /* EXEC SQL SELECT PATIENT_ID, TO_CHAR(REQUEST_DATE,'DD/MM/YYYY'),
			        PATIENT_PREGNANT_YN, TO_CHAR(LMP_DATE,'DD/MM/YYYY')
			   INTO :d_patient_id, :d_request_date,
					:d_pat_pregnant, :d_lmp_date
			   FROM RD_REQUEST
			  WHERE OPERATING_FACILITY_ID = :nd_facility_id
				AND REQUEST_NUM           = :d_request_num; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 6;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select PATIENT_ID ,TO_CHAR(REQUEST_DATE,'DD/MM/YYYY') ,PA\
TIENT_PREGNANT_YN ,TO_CHAR(LMP_DATE,'DD/MM/YYYY') into :b0,:b1,:b2,:b3  from R\
D_REQUEST where (OPERATING_FACILITY_ID=:b4 and REQUEST_NUM=:b5)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )59;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_patient_id;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_request_date;
    sqlstm.sqhstl[1] = (unsigned int  )13;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_pat_pregnant;
    sqlstm.sqhstl[2] = (unsigned int  )13;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_lmp_date;
    sqlstm.sqhstl[3] = (unsigned int  )13;
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
    sqlstm.sqhstv[5] = (         void  *)&d_request_num;
    sqlstm.sqhstl[5] = (unsigned int  )12;
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
    if (sqlca.sqlcode < 0) goto err_exit;
}



    if(NO_DATA_FOUND)
	{
		disp_message(ERR_MESG,"no data found");
		proc_exit();
    }

/*    EXEC SQL SELECT DECODE(SHORT_NAME_LOC_LANG,
			          //CHIN_CODE_FOR_FOREIGN_PAT, SHORT_NAME,
			          NULL, SHORT_NAME,
			          SHORT_NAME_LOC_LANG),
                      DECODE(SHORT_NAME_LOC_LANG,
			          //CHIN_CODE_FOR_FOREIGN_PAT, 'N',       
			          NULL, 'N', Y'),
					  TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY'),
					  SEX, NATIONAL_ID_NUM 
				INTO :d_pat_name,
					 :d_chin_name_yn,
					 :d_date_of_birth,
					 :d_sex,
					 :d_national_id_num   
				FROM MP_PATIENT_MAST, MP_PARAM
			   WHERE PATIENT_ID = :d_patient_id; */

	// -- 44837 Sandeep K Gujje 20-NOV-2013
	// -- Added substr columns to the select list
    /* EXEC SQL SELECT SHORT_NAME, TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY'),
					SEX, NATIONAL_ID_NUM,
					SUBSTR(SHORT_NAME, 1, 12), SUBSTR(SHORT_NAME, 13, 21)
			   INTO :d_pat_name, :d_date_of_birth,
					:d_sex, :d_national_id_num, 
					:d_pat_name1, :d_pat_name2
			   FROM MP_PATIENT_MAST, MP_PARAM
			  WHERE PATIENT_ID = :d_patient_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 7;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select SHORT_NAME ,TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY') ,S\
EX ,NATIONAL_ID_NUM ,SUBSTR(SHORT_NAME,1,12) ,SUBSTR(SHORT_NAME,13,21) into :b\
0,:b1,:b2,:b3,:b4,:b5  from MP_PATIENT_MAST ,MP_PARAM where PATIENT_ID=:b6";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )98;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_pat_name;
    sqlstm.sqhstl[0] = (unsigned int  )103;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_date_of_birth;
    sqlstm.sqhstl[1] = (unsigned int  )13;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_sex;
    sqlstm.sqhstl[2] = (unsigned int  )4;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_national_id_num;
    sqlstm.sqhstl[3] = (unsigned int  )18;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_pat_name1;
    sqlstm.sqhstl[4] = (unsigned int  )17;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_pat_name2;
    sqlstm.sqhstl[5] = (unsigned int  )32;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_patient_id;
    sqlstm.sqhstl[6] = (unsigned int  )23;
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



			if(NO_DATA_FOUND)
			{
				// -- 44837 Sandeep K Gujje 20-NOV-2013
				// -- Added substr columns to the select list
				/* EXEC SQL SELECT PERSON_NAME, TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY'),
					SEX, NATIONAL_ID_NO,
					SUBSTR(PERSON_NAME, 1, 12), SUBSTR(PERSON_NAME, 13, 21)
			   INTO :d_pat_name, :d_date_of_birth,
					:d_sex, :d_national_id_num,
					:d_pat_name1, :d_pat_name2
			   FROM MP_EXT_PERSON
			  WHERE PERSON_ID = :d_patient_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 7;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select PERSON_NAME ,TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY') ,\
SEX ,NATIONAL_ID_NO ,SUBSTR(PERSON_NAME,1,12) ,SUBSTR(PERSON_NAME,13,21) into \
:b0,:b1,:b2,:b3,:b4,:b5  from MP_EXT_PERSON where PERSON_ID=:b6";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )141;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_pat_name;
    sqlstm.sqhstl[0] = (unsigned int  )103;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_date_of_birth;
    sqlstm.sqhstl[1] = (unsigned int  )13;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_sex;
    sqlstm.sqhstl[2] = (unsigned int  )4;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_national_id_num;
    sqlstm.sqhstl[3] = (unsigned int  )18;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_pat_name1;
    sqlstm.sqhstl[4] = (unsigned int  )17;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_pat_name2;
    sqlstm.sqhstl[5] = (unsigned int  )32;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_patient_id;
    sqlstm.sqhstl[6] = (unsigned int  )23;
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


			 }

    d_patient_id.arr[d_patient_id.len]        = '\0';
    d_request_date.arr[d_request_date.len]    = '\0';
	d_pat_pregnant.arr[d_pat_pregnant.len]    = '\0';	
    d_lmp_date.arr[d_lmp_date.len]		      = '\0';	
    d_pat_name.arr[d_pat_name.len]            = '\0';
    d_date_of_birth.arr[d_date_of_birth.len]  = '\0';
    d_sex.arr[d_sex.len]                      = '\0';
	d_national_id_num.arr[d_national_id_num.len]          = '\0';
	
	// -- 44837 Sandeep K Gujje 20-NOV-2013
	d_pat_name1.arr[d_pat_name1.len]            = '\0';
	d_pat_name2.arr[d_pat_name2.len]            = '\0';

    /*if(d_chin_name_yn == 'Y')
   	   centre_name();
	 */
    
  
	/*
    yrs= mths= days= imths= iyrs= idays= 0;
    EXEC SQL SELECT ABS(MONTHS_BETWEEN(SYSDATE,
                        TO_DATE(:d_date_of_birth,'DD/MM/YYYY')))
	     INTO   :mths
	     FROM   DUAL;
   age[0] = '\0';

   if(mths > 1 && mths <= 24) {
       imths = mths;
       sprintf(age,"%dM",imths);
   }
   else {

       if(mths > 1) {
           yrs= days=0;
           imths = mths;
        
           if (imths > 0)
               yrs = (int)mths/12;
        
           iyrs = yrs;
           imths = imths - (iyrs * 12);
           
           days = (mths - (int)mths) * 31;
           idays = days;
       }
       else {

            EXEC SQL SELECT (SYSDATE - TO_DATE(:d_date_of_birth,'DD/MM/YYYY'))
	             INTO   :dys
	             FROM   DUAL;
            idays = dys;
        }
    
        if(iyrs != 0)
            sprintf(age,"%dY",iyrs);
        else if(imths != 0)
            sprintf(age,"%dM",imths);
        else
            sprintf(age,"%dD",idays);
    }*/

	// -- 44837 Sandeep K Gujje 20-NOV-2013 
	// -- Added get_site_customer_id() and 
	// -- if and else condition to make this report different from other sites (AMS)
	
	get_site_customer_id();
	
	if (strcmp(l_customer_id.arr, "AMS") == 0)
	{
		fprintf(f1,"%-7s: %-10s  \n",  loc_legend[1],d_patient_id.arr);

		fprintf(f1,"%-7s: %s",  loc_legend[2],d_sex.arr);

		fprintf(f1,"/");
		
		init_date_temp_var();
		strcpy(date_convert.arr, d_date_of_birth.arr);
		time_flag = 0;
		fun_change_loc_date();
		strcpy(d_date_of_birth.arr, date_convert.arr);

		fprintf(f1,"%10s\n", d_date_of_birth.arr);

		fprintf(f1,"Pt Name: %12.12s \n",d_pat_name1.arr);
		
		fprintf(f1,"%-21.21s \n",d_pat_name2.arr);

		//-- 44837 Sandeep K Gujje 30-DEC-2013
		//-- Changed Req Num to Req Date
		//--fprintf(f1,"%-7s: %s \n",loc_legend[3],d_request_num.arr);
		fprintf(f1,"%-7s: %s\n",  loc_legend[4],d_request_date.arr);

	}
	else
	{
		//fprintf(f1,"Pt No  : %-10s  \n",  d_patient_id.arr);
		fprintf(f1,"%-7s: %-10s  \n",  loc_legend[1],d_patient_id.arr);
		//fprintf(f1,"Sex/DOB: %s",  d_sex.arr);
		fprintf(f1,"%-7s: %s",  loc_legend[2],d_sex.arr);
		fprintf(f1,"/");
		
		/*Ravi Shankar, 09/02/2012, Leap year changes*/
		init_date_temp_var();
		strcpy(date_convert.arr, d_date_of_birth.arr);
		time_flag = 0;
		fun_change_loc_date();
		strcpy(d_date_of_birth.arr, date_convert.arr);
		///////////////////////////

		fprintf(f1,"%10s\n", d_date_of_birth.arr);
	/*	fprintf(f1,"ID No: %-15s\n",d_national_id_num.arr); 
		if (strcmp(d_pat_pregnant.arr,"Y") == 0) 
		{
		fprintf(f1,"ID No: %-15s",d_national_id_num.arr);
		fprintf(f1,"   Pregnant\n");
		}
		fprintf(f1,"%s\n",  d_pat_name.arr);
		if (strcmp(d_pat_pregnant.arr,"Y") == 0) 
		{
		fprintf(f1,"                   LMP:%10s\n",d_lmp_date.arr);
		}
		print_barcode(f1, d_request_num.arr, 0, 0, 30, 150,atoi(nd_printer_type.arr));
		fprintf(f1,"\n");
	*/	
		// -- 44837 Sandeep K Gujje 07-NOV-2013
		// fprintf(f1,"Pt Name: %s \n",d_pat_name.arr);
		fprintf(f1,"Pt Name: %13.13s \n",d_pat_name.arr);
		
		//fprintf(f1,"Regn No: %s \n",d_request_num.arr);
		fprintf(f1,"%-7s: %s \n",loc_legend[3],d_request_num.arr);


		init_date_temp_var();
		strcpy(date_convert.arr, d_request_date.arr);
		time_flag = 0;
		fun_change_loc_date();
		strcpy(d_request_date.arr, date_convert.arr);
		//fprintf(f1,"Date   :%s\n",  d_request_date.arr);
		fprintf(f1,"%-7s: %s\n",  loc_legend[4],d_request_date.arr);
	}
	
    fclose(f1);
	
	PrintDocument
	(
		uid_pwd.arr,
		nd_session_id.arr,
		nd_facility_id.arr,
		"RD",
		"RDRXRLBL",
		filename,
		"O",
		" ",
		1,
		1,
		99
	);
			
	//If printer Type is equal to 1 or 2 , then send it to Laser.Epsoni.e : Appointment Slip
    /*
	if ((atoi(nd_printer_type.arr) == 1) ||
        (atoi(nd_printer_type.arr) == 2))
	{

      if (strcmp(nd_trx_ind.arr,"Y") == 0)
	     //This condition will never come , since Id label is non Txn Based
	  {
	  	   disp_message(ERR_MESG,"This is not a Transaction based Report...Can not print...");
		   proc_exit();
	  }
	  else
	  {
		//for(i=0;i<atoi(d_no_copy.arr);i++)
		   	print_online(uid_pwd.arr,"RDRXRLBL","O","","rdrxrlbl.lis","S");
	  }
	}
	else if (strcmp(nd_printer_type.arr,"3")==0)
	{
		command = (char*) malloc(300*sizeof(char));
		if (strcmp(nd_trx_ind.arr,"Y")!=0)
		{
     		sprintf(command,"syzebcon %s %s %s %s %s %s",uid_pwd.arr,"RDRXRLBL","rdrxrlbl.lis",d_no_copy.arr,"O","");
  	        WinExec (command,SW_SHOWNORMAL);
			
		}
	 }
	*/
	
	/* EXEC SQL COMMIT WORK RELEASE; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )184;
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
    sqlstm.arrsiz = 7;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )199;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    disp_message(ORA_MESG,"Oracle error occured...\n");
    sprintf(string_var,"%s\n",sqlca.sqlerrm.sqlerrmc);
    disp_message(ORA_MESG,string_var);
    proc_exit();
}

/*centre_name()
{
    char t_name[31];
    int spaces;
    int i;

    spaces = (31-strlen(d_pat_name.arr))/4;
	sprintf(string_var,"%d",spaces);

    i = 0;
    while(spaces--) {
	t_name[i++] = ' ';
	t_name[i++] = ' ';
  }

    strcpy(t_name+i, d_pat_name.arr);
    strcpy(d_pat_name.arr, t_name);

}*/


init_date_temp_var()
{
nd_temp_date.arr[0] = '\0';
nd_loc_date.arr[0]  = '\0';
date_convert.arr[0] = '\0';

nd_temp_date.len = 0;
nd_loc_date.len  = 0;
date_convert.len = 0;
}


fun_change_loc_date()
{

strcpy(nd_temp_date.arr,date_convert.arr);
nd_temp_date.len = strlen(nd_temp_date.arr);
nd_temp_date.arr[nd_temp_date.len]='\0';

get_local_date();

strcpy(date_convert.arr,nd_loc_date.arr); 

}

get_local_date()
{


	/* EXEC SQL EXECUTE

	DECLARE

	//t_date  date;
	t_date  varchar2(30);

	
	BEGIN
	  
	  /oRavi Shankar, 09/02/2012, Leap year changeso/
       	/oget_locale_date.CONVERT_TO_LOCALE_DATE(to_date(:nd_temp_date,'DD/MM/YYYY HH24:MI'),:p_language_id,t_date);

		IF :time_flag = 1 THEN
		   :nd_loc_date := to_char(t_date,'DD/MM/YYYY HH24:MI');
		   :time_flag := 0;
		ELSE

	       :nd_loc_date := to_char(t_date,'DD/MM/YYYY');

		END IF;
	o/
	
		IF :time_flag = 1 THEN
		   get_locale_date_2t.CONVERT_TO_LOCALE_DATE(to_date(:nd_temp_date,'DD/MM/YYYY HH24:MI'),:p_language_id,t_date,'DD/MM/YYYY HH24:MI');
		   :nd_loc_date := t_date;
		   :time_flag := 0;
		ELSE
			get_locale_date_2t.CONVERT_TO_LOCALE_DATE(to_date(:nd_temp_date,'DD/MM/YYYY HH24:MI'),:p_language_id,t_date,'DD/MM/YYYY');
			:nd_loc_date := t_date;
		END IF;

	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date varchar2 ( 30 ) ; BEGIN IF :time_flag = 1 THE\
N get_locale_date_2t . CONVERT_TO_LOCALE_DATE ( to_date ( :nd_temp_date , 'DD/\
MM/YYYY HH24:MI' ) , :p_language_id , t_date , 'DD/MM/YYYY HH24:MI' ) ; :nd_lo\
c_date := t_date ; :time_flag := 0 ; ELSE get_locale_date_2t . CONVERT_TO_LOCA\
LE_DATE ( to_date ( :nd_temp_date , 'DD/MM/YYYY HH24:MI' ) , :p_language_id , \
t_date , 'DD/MM/YYYY' ) ; :nd_loc_date := t_date ; END IF ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )214;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&time_flag;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_temp_date;
 sqlstm.sqhstl[1] = (unsigned int  )23;
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
 sqlstm.sqhstv[3] = (         void  *)&nd_loc_date;
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



		nd_loc_date.arr[nd_loc_date.len]='\0';		     

		if (OERROR)
		disp_message(ERR_MESG,"Date conversion failed...\n");
        //err_mesg("SELECTING Date failed",0,"");

}

fetch_legend_value()
{
	
	int i=0;
	/* EXEC SQL EXECUTE
	BEGIN	      
  	   sm_populate_report_legend.fetch_legend(:nd_facility_id,:p_language_id,'RDRXRLBL.LEGEND_');
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin sm_populate_report_legend . fetch_legend ( :nd_facilit\
y_id , :p_language_id , 'RDRXRLBL.LEGEND_' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )245;
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
 sqlstm.sqhstv[1] = (         void  *)&p_language_id;
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





	for (i=1; i<=100; i++)
	{

	l_translated_value.arr[0]		= '\0';
	
	/* EXEC SQL EXECUTE
	BEGIN
       :l_translated_value := GET_LEGEND(LTRIM(RTRIM('RDRXRLBL.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009'))))));
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin :l_translated_value := GET_LEGEND ( LTRIM ( RTRIM ( 'R\
DRXRLBL.LEGEND_' || LTRIM ( RTRIM ( TO_CHAR ( :i , '009' ) ) ) ) ) ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )268;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_translated_value;
 sqlstm.sqhstl[0] = (unsigned int  )202;
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

	//disp_message(ERR_MESG,l_translated_value.arr);

	strcpy(loc_legend[i],l_translated_value.arr);

	}

}

// --44837 Sandeep K Gujje 20-NOV-2013
get_site_customer_id()
{
	l_customer_id.arr[0]		= '\0';
	l_customer_id.len		= 0;

	/* EXEC SQL SELECT NVL(customer_id, '!!')
		INTO l_customer_id
		FROM SM_SITE_PARAM; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select NVL(customer_id,'!!') into :b0  from SM_SITE_PARAM ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )291;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_customer_id;
 sqlstm.sqhstl[0] = (unsigned int  )12;
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



	l_customer_id.arr[l_customer_id.len]	= '\0';

	if (NODATAFOUND);

	if (OERROR);

}