
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/BLR00006.pc"
};


static unsigned int sqlctx = 1288460875;


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
            void  *sqhstv[7];
   unsigned int   sqhstl[7];
            int   sqhsts[7];
            void  *sqindv[7];
            int   sqinds[7];
   unsigned int   sqharm[7];
   unsigned int   *sqharc[7];
   unsigned short  sqadto[7];
   unsigned short  sqtdso[7];
} sqlstm = {12,7};

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

 static const char *sq0003 = 
"select doc_srno ,patient_id ,episode_id ,slmt_type_code ,TO_CHAR(doc_date,'D\
D/MM/RRRR HH24:MI:SS') ,added_by_id ,doc_amt  from bl_receipt_refund_HDRDTL_VW\
 where ((doc_type_code=:b0 and doc_number=:b1) and NVL(cancelled_ind,'N')<>'Y'\
)           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,131,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,29,163,0,0,0,0,0,1,0,
51,0,0,4,0,0,32,187,0,0,0,0,0,1,0,
66,0,0,3,244,0,9,197,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
89,0,0,5,171,0,4,219,0,0,7,5,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,
132,0,0,6,94,0,4,239,0,0,3,1,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,
159,0,0,7,161,0,4,254,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
186,0,0,3,0,0,15,274,0,0,0,0,0,1,0,
201,0,0,3,0,0,13,296,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,4,0,0,
244,0,0,8,0,0,32,311,0,0,0,0,0,1,0,
259,0,0,9,96,0,4,339,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
282,0,0,10,165,0,6,350,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
313,0,0,11,177,0,6,379,0,0,3,3,0,1,0,1,9,0,0,3,9,0,0,2,9,0,0,
340,0,0,12,55,0,4,398,0,0,1,0,0,1,0,2,9,0,0,
359,0,0,13,1048,0,6,415,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,
};


/************************************************************************/
/*  OCS MEDICOM VER 1.10                                                */
/************************************************************************/
/* PROGRAM NAME          :	BLR00006.PC                                  */
/* AUTHOR                :	HARISH. A                                   */
/* DATE WRITTEN          :	25/11/2003                                  */
/* DATE MODIFIED         :												*/
/************************************************************************/


#include <stdio.h>     
#include <string.h>       
#include <bl.h>  

#define OERROR (sqlca.sqlcode < 0)
#define NODATAFOUND sqlca.sqlcode == 1403
#define RESOURCE_BUSY (sqlca.sqlcode == -54)
#define INIT_MESG "Medical Report Printing In Progress"
#define MAX_LINE 60
#define LEGEND 1
#define LENGTH_WORDS 80 
#define ERR_MESG  4
#define ESC     0x1B
#define ONLINE_PRINTING 1
#define DEBUG  1

/* EXEC SQL BEGIN DECLARE SECTION; */ 


	/* VARCHAR	uid_pwd				[132],
			hosp_name			[120],
			date_time			[20],
			user_id				[20],
			nd_pgm_date			[35],
			nd_facility_name	[31],
			nd_session_id		[16],
			nd_calling_pgm_id	[20],
			nd_facility_id		[3]; */ 
struct { unsigned short len; unsigned char arr[132]; } uid_pwd;

struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[20]; } user_id;

struct { unsigned short len; unsigned char arr[35]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[31]; } nd_facility_name;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[20]; } nd_calling_pgm_id;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;


	/* VARCHAR l_doc_type_code		[7],
			l_doc_num			[9],
			l_doc_srno			[3],
			l_patient_id		[25],
			l_episode_id		[15],
			l_slmt_type_code	[4],
			l_added_by_id		[35],
			l_nric_num	[25],
			l_short_name		[35],
			l_facility_name		[50],
			l_slmt_desc			[20],
			l_currency			[20],
			l_doc_date			[30],
			l_translated_value	[201],
			l_pk_value			[100],
			p_language_id		[3],
			p_opr_modules		[501],
			p_mr_instal			[2],
			p_int_mode			[2],
			p_medical_officer	[16], 
			p_report_type		[31], 
			p_requestor			[31]; */ 
struct { unsigned short len; unsigned char arr[7]; } l_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } l_doc_num;

struct { unsigned short len; unsigned char arr[3]; } l_doc_srno;

struct { unsigned short len; unsigned char arr[25]; } l_patient_id;

struct { unsigned short len; unsigned char arr[15]; } l_episode_id;

struct { unsigned short len; unsigned char arr[4]; } l_slmt_type_code;

struct { unsigned short len; unsigned char arr[35]; } l_added_by_id;

struct { unsigned short len; unsigned char arr[25]; } l_nric_num;

struct { unsigned short len; unsigned char arr[35]; } l_short_name;

struct { unsigned short len; unsigned char arr[50]; } l_facility_name;

struct { unsigned short len; unsigned char arr[20]; } l_slmt_desc;

struct { unsigned short len; unsigned char arr[20]; } l_currency;

struct { unsigned short len; unsigned char arr[30]; } l_doc_date;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[501]; } p_opr_modules;

struct { unsigned short len; unsigned char arr[2]; } p_mr_instal;

struct { unsigned short len; unsigned char arr[2]; } p_int_mode;

struct { unsigned short len; unsigned char arr[16]; } p_medical_officer;

struct { unsigned short len; unsigned char arr[31]; } p_report_type;

struct { unsigned short len; unsigned char arr[31]; } p_requestor;


	/* VARCHAR	nd_file_name [50],
			nd_lang_id	[4]; */ 
struct { unsigned short len; unsigned char arr[50]; } nd_file_name;

struct { unsigned short len; unsigned char arr[4]; } nd_lang_id;


	char    filename[300];
	char	l_mesg[300];
	char    nd_lang_ind;
	char    loc_legend[24][201];

	int		l_decimal = 0;
	int		l_page_no = 0;
	int     l_line_no = 0;
	int		i=0;

	double  l_doc_amt = 0;

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

FILE *fp, *fp1;
CHAR nd_str[1000];

void proc_main(argc,argv)
char *argv[];
int argc;
{
	char lv_msg[1024];
	
	if (argc != 8) 
	{
        disp_message (ERR_MESG,"Usage : BLR00006 username/pwd@connect_string session_id pgm_date facility_id Calling_Pgm_Id doc_type_Code doc_number\n");
        proc_exit();
	} 
    
	strcpy(uid_pwd.arr,argv[1]);
	uid_pwd.len = strlen(uid_pwd.arr);

	nd_session_id.arr[nd_session_id.len] = '\0';
	strcpy(nd_session_id.arr,argv[2]);
	nd_session_id.len = strlen(nd_session_id.arr);
	nd_session_id.arr[nd_session_id.len] = '\0'; 

	nd_pgm_date.len = 0;
	nd_pgm_date.arr[nd_pgm_date.len] = '\0';
   
	strcpy(nd_pgm_date.arr,argv[3]);
	nd_pgm_date.len = strlen(nd_pgm_date.arr);
	nd_pgm_date.arr[nd_pgm_date.len] = '\0';

	strcpy(nd_facility_id.arr,argv[4]);
	nd_facility_id.len = strlen(nd_facility_id.arr);
	nd_facility_id.arr[nd_facility_id.len] = '\0';

	strcpy(nd_calling_pgm_id.arr,argv[5]);		
	nd_calling_pgm_id.len = strlen(nd_calling_pgm_id.arr);	
	nd_calling_pgm_id.arr[nd_calling_pgm_id.len] = '\0';


	strcpy(l_doc_type_code.arr,argv[6]);		
	l_doc_type_code.len = strlen(l_doc_type_code.arr);	
	l_doc_type_code.arr[l_doc_type_code.len] = '\0';

	strcpy(l_doc_num.arr,argv[7]);		
	l_doc_num.len = strlen(l_doc_num.arr);	
	l_doc_num.arr[l_doc_num.len] = '\0';


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
 sqlstm.sqlcmax = (unsigned int )100;
 sqlstm.sqlcmin = (unsigned int )2;
 sqlstm.sqlcincr = (unsigned int )1;
 sqlstm.sqlctimeout = (unsigned int )0;
 sqlstm.sqlcnowait = (unsigned int )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	
	if(OERROR)
	{
		disp_message(ERR_MESG,"Error in connecting to Oracle\n");
	
		if (uid_pwd.len == 0)
			disp_message(ERR_MESG,"Null oracle uid/pwd\n\n\n");
	
		proc_exit();
	}

	set_meduser_role();

	strcpy(p_language_id.arr,l_language_id.arr);
    p_language_id.len = l_language_id.len;
    open_files(); 
	
	get_data_for_report();

	//fetch_legend_value();

	//get_req_rep_type_req_pract();

	//print_medical_report();

	fflush(fp);

	fclose(fp);  

	print_report();

	/* EXEC SQL COMMIT WORK; */ 

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


	return 1;	
}

get_data_for_report()
{
	
	/* EXEC SQL  DECLARE receipt_cursor CURSOR FOR SELECT
					 doc_srno ,
					 patient_id,
			         episode_id,
					 slmt_type_code,
					 TO_CHAR(doc_date,'DD/MM/RRRR HH24:MI:SS'),
					 added_by_id,
					 doc_amt
				FROM bl_receipt_refund_HDRDTL_VW
			   WHERE doc_type_code = :l_doc_type_code
			     AND doc_number    = :l_doc_num
				 AND NVL(cancelled_ind,'N') != 'Y'; */ 
		

	if(sqlca.sqlcode == -54) 
	{
		/*sprintf(d_err_code,"%5d",sqlca.sqlerrd[2]);
		disp_message(ERR_MESG,d_err_code);*/
        /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 12;
        sqlstm.arrsiz = 4;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )51;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)4352;
        sqlstm.occurs = (unsigned int  )0;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		proc_exit();
	}    

    if (OERROR)
    {
         err_mesg("DECLARE failed on cursor receipt_cursor",0,"");
    }


/* EXEC SQL OPEN receipt_cursor; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 4;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = sq0003;
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )66;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)4352;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqcmod = (unsigned int )0;
sqlstm.sqhstv[0] = (         void  *)&l_doc_type_code;
sqlstm.sqhstl[0] = (unsigned int  )9;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&l_doc_num;
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
    {
         err_mesg("OPEN failed on cursor receipt_cursor",0,"");

    }	 
  

    while(fetch_receipt_cursor())
	{

	l_nric_num.arr[0]	= '\0';	
	l_short_name.arr[0]			= '\0';

	/*EXEC SQL SELECT national_id_num,
					short_name
			   INTO l_nric_num,
			        l_short_name
			   FROM mp_patient_mast
			  WHERE patient_id = :l_patient_id;*/

	/* EXEC SQL SELECT national_id_no,
					substr(patient_name, 1, 60)
			   INTO l_nric_num,
			        l_short_name
			   FROM mr_report_request_hdr
			   WHERE facility_id = :nd_facility_id
			   AND   (receipt_no	  = :l_doc_type_code||:l_doc_num or
					  addl_receipt_no = :l_doc_type_code||:l_doc_num 
					 ); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select national_id_no ,substr(patient_name,1,60) into :b0,:b\
1  from mr_report_request_hdr where (facility_id=:b2 and (receipt_no=(:b3||:b4\
) or addl_receipt_no=(:b3||:b4)))";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )89;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_nric_num;
 sqlstm.sqhstl[0] = (unsigned int  )27;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_short_name;
 sqlstm.sqhstl[1] = (unsigned int  )37;
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
 sqlstm.sqhstv[3] = (         void  *)&l_doc_type_code;
 sqlstm.sqhstl[3] = (unsigned int  )9;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&l_doc_num;
 sqlstm.sqhstl[4] = (unsigned int  )11;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&l_doc_type_code;
 sqlstm.sqhstl[5] = (unsigned int  )9;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&l_doc_num;
 sqlstm.sqhstl[6] = (unsigned int  )11;
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




	if(OERROR)
		err_mesg("SELECT failed on table MR_REPORT_REQUEST_HDR",0,"");

	l_nric_num.arr[l_nric_num.len]= '\0';	
	l_short_name.arr[l_short_name.len]			= '\0';

	l_facility_name.arr[0]		= '\0';
	l_currency.arr[0]			= '\0';

	/* EXEC SQL SELECT acc_entity_name,
				    base_currency
			   INTO :l_facility_name,
			        :l_currency
			   FROM sy_acc_entity
			  WHERE acc_entity_id = :nd_facility_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select acc_entity_name ,base_currency into :b0,:b1  from sy_\
acc_entity where acc_entity_id=:b2";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )132;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_facility_name;
 sqlstm.sqhstl[0] = (unsigned int  )52;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_currency;
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
		err_mesg("SELECT failed on cursor SY_ACC_ENTITY",0,"");

	l_facility_name.arr[l_facility_name.len]= '\0';
	l_currency.arr[l_currency.len]          = '\0';

	l_slmt_desc.arr[0] = '\0';

	/* EXEC SQL SELECT short_desc
	           INTO :l_slmt_desc
			   FROM bl_slmt_type
			  WHERE slmt_type_code  = :l_slmt_type_code
			    AND acc_entity_code = (SELECT acc_entity_code
				                         FROM sy_acc_entity
										WHERE acc_entity_id = :nd_facility_id); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select short_desc into :b0  from bl_slmt_type where (slmt_ty\
pe_code=:b1 and acc_entity_code=(select acc_entity_code  from sy_acc_entity wh\
ere acc_entity_id=:b2))";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )159;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_slmt_desc;
 sqlstm.sqhstl[0] = (unsigned int  )22;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_slmt_type_code;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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


	if (OERROR) 
		err_mesg("SELECT failed on table BL_SLMT_TYPE",0,"");

	l_slmt_desc.arr[l_slmt_desc.len] = '\0';
	
	fetch_legend_value();

	get_req_rep_type_req_pract();

	print_medical_report();

	}

	/* EXEC SQL CLOSE receipt_cursor; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )186;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



}


fetch_receipt_cursor()
{
	l_doc_srno.arr[0]		= '\0';
	l_patient_id.arr[0]		= '\0';
	l_episode_id.arr[0]		= '\0';
	l_slmt_type_code.arr[0]	= '\0';
	l_doc_date.arr[0]		= '\0';
	l_added_by_id.arr[0]	= '\0';	

	l_doc_srno.len		    = 0;
	l_patient_id.len		= 0;
	l_episode_id.len		= 0;
	l_slmt_type_code.len	= 0;
	l_doc_date.arr[0]		= 0;
	l_added_by_id.arr[0]	= 0;	


	/* EXEC SQL fetch receipt_cursor INTO 
					 :l_doc_srno,
					 :l_patient_id,
			         :l_episode_id,
					 :l_slmt_type_code,
					 :l_doc_date,
					 :l_added_by_id	,
					 :l_doc_amt; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )201;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqfoff = (           int )0;
 sqlstm.sqfmod = (unsigned int )2;
 sqlstm.sqhstv[0] = (         void  *)&l_doc_srno;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_patient_id;
 sqlstm.sqhstl[1] = (unsigned int  )27;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&l_episode_id;
 sqlstm.sqhstl[2] = (unsigned int  )17;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&l_slmt_type_code;
 sqlstm.sqhstl[3] = (unsigned int  )6;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&l_doc_date;
 sqlstm.sqhstl[4] = (unsigned int  )32;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&l_added_by_id;
 sqlstm.sqhstl[5] = (unsigned int  )37;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&l_doc_amt;
 sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
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





  if(sqlca.sqlcode == -54) 
	{
		/*sprintf(d_err_code,"%5d",sqlca.sqlerrd[2]);
		disp_message(ERR_MESG,d_err_code);*/
        /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 12;
        sqlstm.arrsiz = 7;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )244;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)4352;
        sqlstm.occurs = (unsigned int  )0;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		proc_exit();
	}   

    if (OERROR)
    {
         err_mesg("FETCH failed on cursor receipt_cursor",0,"");
    }

	if (NODATAFOUND) 
	  return(0);

	l_patient_id.arr[l_patient_id.len]			= '\0';
	l_episode_id.arr[l_episode_id.len]			= '\0';
	l_slmt_type_code.arr[l_slmt_type_code.len]	= '\0';
	l_doc_date.arr[l_doc_date.len]				= '\0';
	l_added_by_id.arr[l_added_by_id.len]		= '\0';	

	return(1);

}

fetch_legend_value()
{
	for(i=1;i<=24; i++)
	{
		l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLR00006.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 7;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLR00006.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )259;
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



		l_pk_value.arr[l_pk_value.len] = '\0';

		//sprintf(l_mesg,"%s",l_pk_value.arr);
		//disp_message(ERR_MESG,l_mesg);

		l_translated_value.arr[0] = '\0';

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
  sqlstm.arrsiz = 7;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility_id , 'S\
M' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_valu\
e , :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )282;
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

		//sprintf(l_mesg,"Loc Legend[%d]  :  %s",i,loc_legend[i],loc_legend[i]);
		//disp_message(ERR_MESG,l_mesg);

	}
}

get_req_rep_type_req_pract()
{
	
	p_opr_modules.arr[0]	= '\0';
	p_mr_instal.arr[0]		= '\0';
    p_int_mode.arr[0]		= '\0';

	/* EXEC SQL EXECUTE
	   BEGIN
	      GET_OPERATIONAL_MODULES(:nd_facility_id,:p_opr_modules);	
		
		  if instr(:p_opr_modules,'MR|') > 0 then  				--27/10/2005
	  		 :p_mr_instal := 'Y';
		  else
			 :p_mr_instal := 'N';
		  end if;	 
			
	   END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin GET_OPERATIONAL_MODULES ( :nd_facility_id , :p_opr_mod\
ules ) ; if instr ( :p_opr_modules , 'MR|' ) > 0 then :p_mr_instal := 'Y' ; el\
se :p_mr_instal := 'N' ; end if ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )313;
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
 sqlstm.sqhstv[1] = (         void  *)&p_opr_modules;
 sqlstm.sqhstl[1] = (unsigned int  )503;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&p_mr_instal;
 sqlstm.sqhstl[2] = (unsigned int  )4;
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



	p_opr_modules.arr[p_opr_modules.len]	= '\0';
	p_mr_instal.arr[p_mr_instal.len]		= '\0';

	if (strcmp(p_mr_instal.arr, "Y")==0) 
	{

	   /* EXEC SQL  SELECT MEDREP_PAY_INT_MODE
				 INTO   :p_int_mode
				 FROM   MR_PARAMETER; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 7;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select MEDREP_PAY_INT_MODE into :b0  from MR_PARAMETER ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )340;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&p_int_mode;
    sqlstm.sqhstl[0] = (unsigned int  )4;
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
	  	  strcpy(p_int_mode.arr, "N");   		

	   p_int_mode.arr[p_int_mode.len] = '\0';	
		
	   if (strcmp(p_int_mode.arr, "B")==0)	
	   {
		  
		  p_medical_officer.arr[0]	= '\0';
		  p_report_type.arr[0]		= '\0';
		  p_requestor.arr[0]		= '\0';


		  /* EXEC SQL EXECUTE
		  
		     DECLARE
			 p_requesting_pract_id		VARCHAR2(15);
			 p_report_type_code			VARCHAR2(4);		
			 p_requestor_code			VARCHAR2(10);
			 	
		     BEGIN
		            SELECT Requesting_pract_id, Report_type_code, requestor_code
					INTO   p_requesting_pract_id, p_report_type_code, p_requestor_code
					FROM  MR_REPORT_REQUEST_HDR a
					WHERE facility_id = :nd_facility_id
					AND   nvl(patient_id,'X') = nvl(:l_patient_id,'X')
					AND   (receipt_no	   = :l_doc_type_code||:l_doc_num or
						   addl_receipt_no = :l_doc_type_code||:l_doc_num 
						  );
										
					IF p_requesting_pract_id IS NOT NULL THEN
						SELECT short_name 
						INTO   :p_medical_officer
						FROM   sy_physician_mast 
						WHERE  facility_id  = :nd_facility_id 
						AND    physician_id = p_requesting_pract_id;
					END IF;

					IF p_report_type_code IS NOT NULL THEN
					   SELECT note_type_desc 
					   INTO   :p_report_type
					   FROM   ca_note_type 
					   WHERE  note_type = p_report_type_code; 
					END IF;

					IF p_requestor_code IS NOT NULL THEN
					   SELECT long_desc 
					   INTO   :p_requestor
					   FROM   mr_requestor  
					   WHERE  facility_id = :nd_facility_id 
					   AND    requestor_code = p_requestor_code;
					END IF;

			 EXCEPTION
				WHEN NO_DATA_FOUND THEN
					NULL;				
		     END;
		  END-EXEC; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 7;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlbuft((void **)0, 
      "declare p_requesting_pract_id VARCHAR2 ( 15 ) ; p_report_type_code VA\
RCHAR2 ( 4 ) ; p_requestor_code VARCHAR2 ( 10 ) ; BEGIN SELECT Requesting_pr\
act_id , Report_type_code , requestor_code INTO p_requesting_pract_id , p_re\
port_type_code , p_requestor_code FROM MR_REPORT_REQUEST_HDR a WHERE facilit\
y_id = :nd_facility_id AND nvl ( patient_id , 'X' ) = nvl ( :l_patient_id , \
'X' ) AND ( receipt_no = :l_doc_type_code || :l_doc_num or addl_receipt_no =\
 :l_doc_type_code || :l_doc_num ) ; IF p_requesting_pract_id IS NOT NULL THE\
N SELECT short_name INTO :p_medical_officer FROM sy_physician_mast WHERE fac\
ility_id = :nd_facility_id AND physician_id = p_requesting_pract_id ; END IF\
 ; IF p_report_type_code IS NOT NULL THEN SELECT note_type_desc INTO :p_repo\
rt_type FROM ca_note_type WHERE note_type = p_report_type_code ; END IF ; IF\
 p_requestor_code IS NOT NULL THEN SELECT long_desc INTO :p_requestor FROM m\
r_requestor WHERE facility_id = :nd_facility_id AND requestor_code = p_reque\
stor_code ; END IF ; EXCEPTION WHEN NO_DATA");
    sqlstm.stmt = "_FOUND THEN NULL ; END ;";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )359;
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
    sqlstm.sqhstv[1] = (         void  *)&l_patient_id;
    sqlstm.sqhstl[1] = (unsigned int  )27;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&l_doc_type_code;
    sqlstm.sqhstl[2] = (unsigned int  )9;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&l_doc_num;
    sqlstm.sqhstl[3] = (unsigned int  )11;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&p_medical_officer;
    sqlstm.sqhstl[4] = (unsigned int  )18;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&p_report_type;
    sqlstm.sqhstl[5] = (unsigned int  )33;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&p_requestor;
    sqlstm.sqhstl[6] = (unsigned int  )33;
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


		  

		  	
	      if(OERROR)
	  	     err_mesg("SELECT failed on table MR_REPORT_REQUEST_HDR",0,"");


		  p_medical_officer.arr[p_medical_officer.len] = '\0';	
		  p_report_type.arr[p_report_type.len]		   = '\0';	
		  p_requestor.arr[p_requestor.len]			   = '\0';	
	   }

	}

}


print_medical_report()
{
	fprintf(fp,"%c&k4S\n\n\n",ESC); 	/* To Set compressed mode */	
	print_report_section1();
	print_report_section2();
	print_report_section3();
	//fprintf(fp,"%cE",ESC);		/* To Reset the Printer */
	fprintf(fp,"%c@",ESC);	/* To Reset the Printer */
}


print_report_section1()
{
	fprintf(fp,"\t                       %-s\n\n",loc_legend[1]);
	fprintf(fp,"\t%-s\n\n",loc_legend[2]);
	fprintf(fp,"\t%-16.16s : %-15.15s     %-8.8s : %-s",loc_legend[3],l_slmt_desc.arr,loc_legend[4],l_currency.arr);
	print_formated(l_doc_amt);
	fprintf(fp,"\n");
	fprintf(fp,"\t%-16.16s : %-6.6s/%-9.9s/%-3s    %-8.8s : %-s\n",loc_legend[5],l_doc_type_code.arr,l_doc_num.arr,l_doc_srno.arr,loc_legend[6],l_doc_date.arr);
	fprintf(fp,"\t%-16.16s : %-s\n",loc_legend[7],l_patient_id.arr);
	fprintf(fp,"\t%-16.16s : %-s\n",loc_legend[8],l_short_name.arr);
	fprintf(fp,"\t%-16.16s : %-s\n",loc_legend[9],l_nric_num.arr);
	fprintf(fp,"\t%-16.16s : %-s\n\n\n\n\n",loc_legend[10],l_added_by_id.arr);
	fprintf(fp,"\t                                          %-s :_____________________\n",loc_legend[11]);
	fprintf(fp,"\t__________________________________________________________________________\n");

}

print_report_section2()
{
	fprintf(fp,"\t%-s\n\n",loc_legend[12]);

	fprintf(fp,"\t%-16.16s : %s\n",loc_legend[8],l_short_name.arr); 
	fprintf(fp,"\t%-16.16s : %s\n",loc_legend[13], p_requestor.arr);					//29/10/2005
	fprintf(fp,"\t%-16.16s : %s\n",loc_legend[14], p_report_type.arr);					//29/10/2005
	fprintf(fp,"\t%-s : %s\n",loc_legend[15], p_medical_officer.arr);						//29/10/2005
	//fprintf(fp,"\t%-16.16s : %s\n",loc_legend[9],l_nric_num.arr); 
	fprintf(fp,"\t%-16.16s : \n",loc_legend[9]); 
	fprintf(fp,"\t%-16.16s : \n",loc_legend[16]); 
	fprintf(fp,"\t%-16.16s : \n",loc_legend[17]); 
	fprintf(fp,"\t%-s : \n\n\n\n",loc_legend[18]); 

	fprintf(fp,"\t%-16.16s :                        %-s :_____________________\n",loc_legend[19],loc_legend[11]);
	fprintf(fp,"\t                                               %-s\n",loc_legend[20]);
	fprintf(fp,"\t__________________________________________________________________________\n");
}

print_report_section3()
{
	fprintf(fp,"\t%-s\n\n",loc_legend[21]);
	fprintf(fp,"\t%-s.\n\n\n\n\n",loc_legend[22]);
	fprintf(fp,"\t%-s :\n\n",loc_legend[6]);
	fprintf(fp,"\t                                          %-s :_____________________\n",loc_legend[11]);
	fprintf(fp,"\t%-30.30s                      %s\n",l_facility_name.arr,loc_legend[23]);
	fprintf(fp,"\t%-30.30s                      %s\n"," ",loc_legend[24]);
}

open_files()
{
   strcpy(filename,WORKING_DIR);

   strcat(filename,"BLR00006.lis");

   if ((fp = fopen(filename,"w")) == NULL)
   {
        err_mesg("Error while opening output file",0,"");
        proc_exit();
   }
}

print_formated(loc_amount)
double loc_amount;
{
	char s_amt[30], str_amt[30];	

    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);        
        format_amt(s_amt);
	    strcat(s_amt,"-");
        sprintf(str_amt,"%-14s",s_amt);
		l_ltrim(s_amt);
        fprintf(fp,"%-14s",str_amt);
    }
    else 
	{
        put_val(s_amt,loc_amount);         
        format_amt(s_amt);
        sprintf(str_amt,"%-14s",s_amt);
		l_ltrim(s_amt);
        fprintf(fp,"%-14s ",str_amt);
    }

}

print_report()
{
	PrintDocument(  uid_pwd.arr,		//char	*PUidPwd;
					nd_session_id.arr,	//char	*PSessionID;
					nd_facility_id.arr,	//char	*PFacilityID;
					"BL",				//char	*PModuleID;
					"BLR00006",			//char	*PDocumentID;
					filename,			//char	*POnlinePrintFileNames;
					"O",				//char	*PLocationTypes;
					" ",				//char	*PLocationCodes;
					1,					//int		PNumOfCopies;
					1,					//int		PPageFrom;
					9999);				//int		PPageTo;);

}

/*check_page_break()
{
	if(l_line_no + 4 >= 61)
	{
		fprintf(fp,"\f");
		l_line_no = 0;
	}
}*/