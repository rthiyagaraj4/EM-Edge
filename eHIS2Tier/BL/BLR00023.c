
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
           char  filnam[18];
};
static const struct sqlcxp sqlfpn =
{
    17,
    "T:\\BL\\blr00023.pc"
};


static unsigned long sqlctx = 10093139;


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

 static const char *sq0003 = 
"select patient_id ,episode_id ,episode_type ,slmt_type_code ,recpt_nature_co\
de ,TO_CHAR(doc_date,'DD/MM/RRRR') ,slmt_doc_ref_desc ,TO_CHAR(slmt_doc_ref_da\
te,'DD/MM/RRRR') ,added_by_id ,((-1)* doc_amt) ,((bill_doc_type_code||' ')||bi\
ll_doc_number) ,payer_name  from bl_receipt_refund_hdrdtl_vw where ((doc_type_\
code=:b0 and doc_number=:b1) and NVL(cancelled_ind,'N')<>'Y')           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,152,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,29,182,0,0,0,0,0,1,0,
51,0,0,4,0,0,32,213,0,0,0,0,0,1,0,
66,0,0,3,382,0,9,223,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
89,0,0,5,90,0,4,237,0,0,3,1,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,
116,0,0,6,161,0,4,252,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
143,0,0,7,290,0,4,278,0,0,12,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
206,0,0,8,71,0,4,322,0,0,1,0,0,1,0,2,9,0,0,
225,0,0,9,184,0,4,333,0,0,5,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
260,0,0,10,65,0,4,356,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
283,0,0,3,0,0,15,370,0,0,0,0,0,1,0,
298,0,0,3,0,0,13,402,0,0,12,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,9,0,0,
361,0,0,11,0,0,32,419,0,0,0,0,0,1,0,
376,0,0,12,96,0,4,455,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
399,0,0,13,165,0,6,462,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
430,0,0,14,220,0,4,584,0,0,5,3,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
};


/************************************************************************/
/*  OCS MEDICOM VER 1.10                                                */
/************************************************************************/
/* PROGRAM NAME          :	BLR00023.PC                                  */
/* AUTHOR                :	HARISH. A                                   */
/* DATE WRITTEN          :	18/01/2004                                  */
/* DATE MODIFIED         :												*/
/************************************************************************/

#include <stdio.h>     
#include <string.h>       
#include <bl.h>  

#define OERROR (sqlca.sqlcode < 0)
#define NODATAFOUND sqlca.sqlcode == 1403
#define RESOURCE_BUSY (sqlca.sqlcode == -54)
#define INIT_MESG "Non Cash Refund Printing In Progress"
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
			l_doc_num			[20],
			l_doc_srno			[3],
			l_patient_id		[25],
			l_episode_id		[15],
			l_slmt_type_code	[4],
			l_slmt_doc_ref_desc	[25],
			l_slmt_doc_ref_date	[25],
			l_recpt_nature_code [10],
			l_added_by_id		[35],
			l_nric_num			[25],
			l_short_name		[35],
			l_facility_name		[50],
			l_slmt_desc			[20],
			l_sysdate			[50],
			l_currency			[20],
			l_doc_date			[30],
			l_episode_type		[10],
			l_org_doc_type_code [25],
			l_payers_name		[50],
			l_translated_value	[201],
			p_language_id		[3],
			l_pk_value			[100]; */ 
struct { unsigned short len; unsigned char arr[7]; } l_doc_type_code;

struct { unsigned short len; unsigned char arr[20]; } l_doc_num;

struct { unsigned short len; unsigned char arr[3]; } l_doc_srno;

struct { unsigned short len; unsigned char arr[25]; } l_patient_id;

struct { unsigned short len; unsigned char arr[15]; } l_episode_id;

struct { unsigned short len; unsigned char arr[4]; } l_slmt_type_code;

struct { unsigned short len; unsigned char arr[25]; } l_slmt_doc_ref_desc;

struct { unsigned short len; unsigned char arr[25]; } l_slmt_doc_ref_date;

struct { unsigned short len; unsigned char arr[10]; } l_recpt_nature_code;

struct { unsigned short len; unsigned char arr[35]; } l_added_by_id;

struct { unsigned short len; unsigned char arr[25]; } l_nric_num;

struct { unsigned short len; unsigned char arr[35]; } l_short_name;

struct { unsigned short len; unsigned char arr[50]; } l_facility_name;

struct { unsigned short len; unsigned char arr[20]; } l_slmt_desc;

struct { unsigned short len; unsigned char arr[50]; } l_sysdate;

struct { unsigned short len; unsigned char arr[20]; } l_currency;

struct { unsigned short len; unsigned char arr[30]; } l_doc_date;

struct { unsigned short len; unsigned char arr[10]; } l_episode_type;

struct { unsigned short len; unsigned char arr[25]; } l_org_doc_type_code;

struct { unsigned short len; unsigned char arr[50]; } l_payers_name;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;


	/* VARCHAR l_acc_entity_name	[35], 
			l_ln1_add			[35], 
			l_ln2_add			[35], 
			l_ln3_add			[35], 
			l_zip_code			[35], 
			l_telephone_num			[35], 
			l_telex_num			[35], 
			l_fax_num			[35],
			l_head_of_company_name	[50],
			l_head_of_company_desig	[50],
			l_admission_date	[15],
			l_discharge_date	[15],
			l_country_code		[40],
			l_country			[50],
			l_bill_add1_desc	[40],
			l_bill_add2_desc	[40],
			l_bill_add3_desc	[40]; */ 
struct { unsigned short len; unsigned char arr[35]; } l_acc_entity_name;

struct { unsigned short len; unsigned char arr[35]; } l_ln1_add;

struct { unsigned short len; unsigned char arr[35]; } l_ln2_add;

struct { unsigned short len; unsigned char arr[35]; } l_ln3_add;

struct { unsigned short len; unsigned char arr[35]; } l_zip_code;

struct { unsigned short len; unsigned char arr[35]; } l_telephone_num;

struct { unsigned short len; unsigned char arr[35]; } l_telex_num;

struct { unsigned short len; unsigned char arr[35]; } l_fax_num;

struct { unsigned short len; unsigned char arr[50]; } l_head_of_company_name;

struct { unsigned short len; unsigned char arr[50]; } l_head_of_company_desig;

struct { unsigned short len; unsigned char arr[15]; } l_admission_date;

struct { unsigned short len; unsigned char arr[15]; } l_discharge_date;

struct { unsigned short len; unsigned char arr[40]; } l_country_code;

struct { unsigned short len; unsigned char arr[50]; } l_country;

struct { unsigned short len; unsigned char arr[40]; } l_bill_add1_desc;

struct { unsigned short len; unsigned char arr[40]; } l_bill_add2_desc;

struct { unsigned short len; unsigned char arr[40]; } l_bill_add3_desc;


	/* VARCHAR	nd_file_name [50],
			nd_lang_id	[4]; */ 
struct { unsigned short len; unsigned char arr[50]; } nd_file_name;

struct { unsigned short len; unsigned char arr[4]; } nd_lang_id;


	char    filename[300];
	char	l_mesg[300];
	char    nd_lang_ind;
	char    loc_legend[40][201];

	int		l_decimal = 0;
	int		l_page_no = 0;
	int     l_line_no = 0;
	int		i=0;

	double  l_doc_amt = 0;

/* EXEC SQL END DECLARE SECTION; */ 


/* EXEC SQL INCLUDE SQLCA.H;
 */ 
/*
 * $Header:   T:/eHIS-102/archives/eHIS2Tier/BL/BLR00023.c-arc   1.0   Apr 19 2007 17:04:52   vcm_th  $ sqlca.h 
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
 * $Header:   T:/eHIS-102/archives/eHIS2Tier/BL/BLR00023.c-arc   1.0   Apr 19 2007 17:04:52   vcm_th  $ sqlda.h 
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

FILE *fp, *fp1;
CHAR nd_str[1000];

void proc_main(argc,argv)
char *argv[];
int argc;
{
	char lv_msg[1024];

	if (argc != 9) 
	{
        disp_message (ERR_MESG,"Usage : BLR00023 username/pwd@connect_string session_id pgm_date facility_id Calling_Pgm_Id doc_type_Code doc_number doc_srno\n");
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

	strcpy(l_doc_srno.arr,argv[8]);
	l_doc_srno.len = strlen(l_doc_srno.arr);	
	l_doc_srno.arr[l_doc_srno.len] = '\0';
	
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


	
	if(OERROR)
	{
		disp_message(ERR_MESG,"Error in connecting to Oracle\n");
	
		if (uid_pwd.len == 0)
			disp_message(ERR_MESG,"Null oracle uid/pwd\n\n\n");
	
		proc_exit();
	}

	set_meduser_role();

	strcpy(p_language_id.arr,l_language_id.arr);

    open_files(); 
	
	get_data_for_report();

	//fetch_legend_value();

	//print_non_cheque_report();

	fflush(fp);

	fclose(fp);  

	print_report();

	/* EXEC SQL COMMIT WORK; */ 

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


	return 1;	
}

get_data_for_report()
{
	

	/* EXEC SQL  DECLARE receipt_cursor CURSOR FOR 
			  SELECT patient_id,
			         episode_id,
					 episode_type,
					 slmt_type_code,
					 recpt_nature_code,
					 TO_CHAR(doc_date,'DD/MM/RRRR'),
					 slmt_doc_ref_desc,
					 TO_CHAR(slmt_doc_ref_date,'DD/MM/RRRR'),
					 added_by_id,
					 (-1*doc_amt),
					 bill_doc_type_code||' '||bill_doc_number,
					 payer_name
			   FROM bl_receipt_refund_hdrdtl_vw
			   WHERE doc_type_code = :l_doc_type_code
			     AND doc_number    = :l_doc_num
				 //AND doc_srno	   = :l_doc_srno
				 AND NVL(cancelled_ind,'N') != 'Y'; */ 
		

	if(sqlca.sqlcode == -54) 
	{
		/*sprintf(d_err_code,"%5d",sqlca.sqlerrd[2]);
		disp_message(ERR_MESG,d_err_code);*/
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


		proc_exit();
	}    

    if (OERROR)
    {
         err_mesg("DECLARE failed on cursor receipt_cursor",0,"");
    }


/* EXEC SQL OPEN receipt_cursor; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 4;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = sq0003;
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )66;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&l_doc_type_code;
sqlstm.sqhstl[0] = (unsigned int  )9;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&l_doc_num;
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
}

 

    if (OERROR)
    {
         err_mesg("OPEN failed on cursor receipt_cursor",0,"");

    }	 

	while(fetch_receipt_cursor())
	{

	l_nric_num.arr[0]		= '\0';	
	l_short_name.arr[0]		= '\0';

	/* EXEC SQL SELECT national_id_num,
					short_name
			   INTO l_nric_num,
			        l_short_name
			   FROM mp_patient_mast
			  WHERE patient_id = :l_patient_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select national_id_num ,short_name into :b0,:b1  from mp_pat\
ient_mast where patient_id=:b2";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )89;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
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
 sqlstm.sqhstv[2] = (         void  *)&l_patient_id;
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



	if(OERROR)
		err_mesg("SELECT failed on table MP_PATIENT_MAST",0,"");

	l_nric_num.arr[l_nric_num.len]			= '\0';	
	l_short_name.arr[l_short_name.len]		= '\0';

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
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select short_desc into :b0  from bl_slmt_type where (slmt_ty\
pe_code=:b1 and acc_entity_code=(select acc_entity_code  from sy_acc_entity wh\
ere acc_entity_id=:b2))";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )116;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
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

	l_acc_entity_name.arr[0]		= '\0';
	l_ln1_add.arr[0]				= '\0';
	l_ln2_add.arr[0]				= '\0';
	l_ln3_add.arr[0]				= '\0'; 
	l_zip_code.arr[0]				= '\0'; 
	l_telephone_num.arr[0]			= '\0'; 
	l_telex_num.arr[0]				= '\0'; 
	l_fax_num.arr[0]				= '\0';
	l_facility_name.arr[0]			= '\0';
	l_currency.arr[0]				= '\0';
	l_head_of_company_name.arr[0]	= '\0';
	l_head_of_company_desig.arr[0]	= '\0';


	/* EXEC SQL SELECT UPPER(acc_entity_name), 
				    UPPER(ln1_add)||',', 
				    UPPER(ln2_add)||',', 
				    UPPER(ln3_add)||'.',
				    zip_code, 
				    tel_num, 
				    tlx_num,
				    fax_num,
					head_of_company_name,
					head_of_company_desig,
				    base_currency
			   INTO :l_acc_entity_name, 
				    :l_ln1_add, 
				    :l_ln2_add, 
				    :l_ln3_add,
				    :l_zip_code, 
				    :l_telephone_num, 
				    :l_telex_num,
				    :l_fax_num,
					:l_head_of_company_name,
					:l_head_of_company_desig,
			        :l_currency
			   FROM sy_acc_entity
			  WHERE acc_entity_id = :nd_facility_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 12;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select UPPER(acc_entity_name) ,(UPPER(ln1_add)||',') ,(UPPER\
(ln2_add)||',') ,(UPPER(ln3_add)||'.') ,zip_code ,tel_num ,tlx_num ,fax_num ,h\
ead_of_company_name ,head_of_company_desig ,base_currency into :b0,:b1,:b2,:b3\
,:b4,:b5,:b6,:b7,:b8,:b9,:b10  from sy_acc_entity where acc_entity_id=:b11";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )143;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_acc_entity_name;
 sqlstm.sqhstl[0] = (unsigned int  )37;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_ln1_add;
 sqlstm.sqhstl[1] = (unsigned int  )37;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&l_ln2_add;
 sqlstm.sqhstl[2] = (unsigned int  )37;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&l_ln3_add;
 sqlstm.sqhstl[3] = (unsigned int  )37;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&l_zip_code;
 sqlstm.sqhstl[4] = (unsigned int  )37;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&l_telephone_num;
 sqlstm.sqhstl[5] = (unsigned int  )37;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&l_telex_num;
 sqlstm.sqhstl[6] = (unsigned int  )37;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&l_fax_num;
 sqlstm.sqhstl[7] = (unsigned int  )37;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&l_head_of_company_name;
 sqlstm.sqhstl[8] = (unsigned int  )52;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&l_head_of_company_desig;
 sqlstm.sqhstl[9] = (unsigned int  )52;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&l_currency;
 sqlstm.sqhstl[10] = (unsigned int  )22;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&nd_facility_id;
 sqlstm.sqhstl[11] = (unsigned int  )5;
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
		err_mesg("SELECT failed on cursor SY_ACC_ENTITY",0,"");

	l_acc_entity_name.arr[l_acc_entity_name.len]			= '\0';
	l_ln1_add.arr[l_ln1_add.len]							= '\0';
	l_ln2_add.arr[l_ln2_add.len]							= '\0';
	l_ln3_add.arr[l_ln3_add.len]							= '\0'; 
	l_zip_code.arr[l_zip_code.len]							= '\0'; 
	l_telephone_num.arr[l_telephone_num.len]				= '\0'; 
	l_telex_num.arr[l_telex_num.len]						= '\0'; 
	l_fax_num.arr[l_fax_num.len]							= '\0';
	l_head_of_company_name.arr[l_head_of_company_name.len]	= '\0';
	l_head_of_company_desig.arr[l_head_of_company_desig.len]= '\0';
	l_facility_name.arr[l_facility_name.len]				= '\0';
	l_currency.arr[l_currency.len]							= '\0';


	l_sysdate.arr[0] = '\0';

	/* EXEC SQL SELECT INITCAP(TO_CHAR(SYSDATE,'DDth MONTH RRRR')) 
		       INTO l_sysdate
		       FROM dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 12;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select INITCAP(TO_CHAR(SYSDATE,'DDth MONTH RRRR')) into :b0 \
 from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )206;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_sysdate;
 sqlstm.sqhstl[0] = (unsigned int  )52;
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



	l_sysdate.arr[l_sysdate.len] = '\0';

	l_country_code.arr[0] = '\0';
	l_bill_add1_desc.arr[0] = '\0';
	l_bill_add2_desc.arr[0] = '\0';
	l_bill_add3_desc.arr[0] = '\0';

	/* EXEC SQL SELECT substr(ln1_mail_add,1,40),
					substr(ln2_mail_add,1,40),
					substr(ln3_mail_add,1,40),
					substr(mail_country_code,1,40)
			   INTO :l_bill_add1_desc,
					:l_bill_add2_desc,
					:l_bill_add3_desc,
					:l_country_code
			   FROM mp_pat_other_dtls
			  WHERE patient_id = :l_patient_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 12;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select substr(ln1_mail_add,1,40) ,substr(ln2_mail_add,1,40) \
,substr(ln3_mail_add,1,40) ,substr(mail_country_code,1,40) into :b0,:b1,:b2,:b\
3  from mp_pat_other_dtls where patient_id=:b4";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )225;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_bill_add1_desc;
 sqlstm.sqhstl[0] = (unsigned int  )42;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_bill_add2_desc;
 sqlstm.sqhstl[1] = (unsigned int  )42;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&l_bill_add3_desc;
 sqlstm.sqhstl[2] = (unsigned int  )42;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&l_country_code;
 sqlstm.sqhstl[3] = (unsigned int  )42;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&l_patient_id;
 sqlstm.sqhstl[4] = (unsigned int  )27;
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
				err_mesg("SELECT failed on table MP_PAT_OTHER_DTLS",0,"");
	
	l_country_code.arr[l_country_code.len] = '\0';
	l_bill_add1_desc.arr[l_bill_add1_desc.len] = '\0';
	l_bill_add2_desc.arr[l_bill_add2_desc.len] = '\0';
	l_bill_add3_desc.arr[l_bill_add3_desc.len] = '\0';

	if(l_country_code.len > 0)
	{
		l_country.len = 0;

		/* EXEC SQL SELECT long_name
				   INTO :l_country
				   FROM mp_country
				  WHERE country_code = :l_country_code; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 12;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select long_name into :b0  from mp_country where country_co\
de=:b1";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )260;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&l_country;
  sqlstm.sqhstl[0] = (unsigned int  )52;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&l_country_code;
  sqlstm.sqhstl[1] = (unsigned int  )42;
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



		l_country.arr[l_country.len] = '\0';
	}
	
	fetch_legend_value();

	print_non_cheque_report();

  }

  /* EXEC SQL CLOSE receipt_cursor; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 12;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )283;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

fetch_receipt_cursor()
{


	l_patient_id.arr[0]			= '\0';
	l_episode_id.arr[0]			= '\0';
	l_episode_type.arr[0]		= '\0';
	l_slmt_type_code.arr[0]		= '\0';
	l_doc_date.arr[0]			= '\0';
	l_added_by_id.arr[0]		= '\0';	
	l_slmt_doc_ref_desc.arr[0]	= '\0';
	l_slmt_doc_ref_date.arr[0]	= '\0';
	l_recpt_nature_code.arr[0]	= '\0';
	l_org_doc_type_code.arr[0]	= '\0';
	l_payers_name.arr[0]			= '\0';

	l_patient_id.len		= 0;
	l_episode_id.len		= 0;
	l_episode_type.len		= 0;
	l_slmt_type_code.len	= 0;
	l_doc_date.len			= 0;
	l_added_by_id.len		= 0;	
	l_slmt_doc_ref_desc.len	= 0;
	l_slmt_doc_ref_date.len	= 0;
	l_recpt_nature_code.len	= 0;
	l_org_doc_type_code.len	= 0;
	l_payers_name.len		= 0;


	/* EXEC SQL fetch receipt_cursor INTO :l_patient_id,
									 :l_episode_id,
									 :l_episode_type,
									 :l_slmt_type_code,
									 :l_recpt_nature_code,
									 :l_doc_date,
									 :l_slmt_doc_ref_desc,
									 :l_slmt_doc_ref_date,
									 :l_added_by_id	,
									 :l_doc_amt,
									 :l_org_doc_type_code,
									 :l_payers_name; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 12;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )298;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_patient_id;
 sqlstm.sqhstl[0] = (unsigned int  )27;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_episode_id;
 sqlstm.sqhstl[1] = (unsigned int  )17;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&l_episode_type;
 sqlstm.sqhstl[2] = (unsigned int  )12;
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
 sqlstm.sqhstv[4] = (         void  *)&l_recpt_nature_code;
 sqlstm.sqhstl[4] = (unsigned int  )12;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&l_doc_date;
 sqlstm.sqhstl[5] = (unsigned int  )32;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&l_slmt_doc_ref_desc;
 sqlstm.sqhstl[6] = (unsigned int  )27;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&l_slmt_doc_ref_date;
 sqlstm.sqhstl[7] = (unsigned int  )27;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&l_added_by_id;
 sqlstm.sqhstl[8] = (unsigned int  )37;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&l_doc_amt;
 sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&l_org_doc_type_code;
 sqlstm.sqhstl[10] = (unsigned int  )27;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&l_payers_name;
 sqlstm.sqhstl[11] = (unsigned int  )52;
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


	
	if(sqlca.sqlcode == -54) 
	{
		/*sprintf(d_err_code,"%5d",sqlca.sqlerrd[2]);
		disp_message(ERR_MESG,d_err_code);*/
        /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 12;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )361;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		proc_exit();
	}   

    if (OERROR)
    {
         err_mesg("FETCH failed on cursor receipt_cursor",0,"");
    }


    if(NODATAFOUND)
	  return(0);

	l_patient_id.arr[l_patient_id.len]					= '\0';
	l_episode_id.arr[l_episode_id.len]					= '\0';
	l_episode_type.arr[l_episode_type.len]				= '\0';
	l_slmt_type_code.arr[l_slmt_type_code.len]			= '\0';
	l_doc_date.arr[l_doc_date.len]						= '\0';
	l_added_by_id.arr[l_added_by_id.len]				= '\0';	
	l_slmt_doc_ref_desc.arr[l_slmt_doc_ref_desc.len]	= '\0';
	l_slmt_doc_ref_date.arr[l_slmt_doc_ref_date.len]	= '\0';
	l_recpt_nature_code.arr[l_recpt_nature_code.len]	= '\0';
	l_org_doc_type_code.arr[l_org_doc_type_code.len]	= '\0';
	l_payers_name.arr[l_payers_name.len]					= '\0';
	
	return(1); 
 

}

fetch_legend_value()
{
	for(i=1;i<=33; i++)
	{
		l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLR00023.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 12;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLR00023.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )376;
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



		l_pk_value.arr[l_pk_value.len] = '\0';
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
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 12;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility_id , 'S\
M' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_valu\
e , :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )399;
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

print_non_cheque_report()
{
	fprintf(fp,"%c&k4S\n\n\n",ESC); 	// To Set compressed mode
	print_letter_header();
	print_letter_reference();
	print_letter_body();
	print_letter_tail();
	fprintf(fp,"%cE",ESC);		        // To Reset the Printer
}

print_letter_header()
{
	fprintf(fp,"\t                %-s\n",l_acc_entity_name.arr);
	fprintf(fp,"\t                %-30.30s          %-3.3s: %-s\n",l_ln1_add.arr,loc_legend[1],l_telephone_num.arr);
	fprintf(fp,"\t                %-30.30s          %-3.3s  %-s\n",l_ln2_add.arr," ",l_telex_num.arr);
	fprintf(fp,"\t                %-30.30s          %-3.3s: %-s\n",l_ln3_add.arr,loc_legend[2],l_fax_num.arr);
	fprintf(fp,"\t_______________________________________________________________________________\n");
	fprintf(fp,"\n");
}

print_letter_reference()
{
	fprintf(fp,"%-32.32s%-19.19s:\n\n"," ",loc_legend[3]);
	fprintf(fp,"%-32.32s%-19.19s:%s\n\n"," ",loc_legend[4],loc_legend[5]);
	fprintf(fp,"%-32.32s%16.16s   :%s\n\n"," ",loc_legend[6],l_sysdate.arr);

	if(strlen(l_payers_name.arr)>0)
		fprintf(fp,"\t%s\n",l_payers_name.arr);
	else			
		fprintf(fp,"\t%s\n",l_short_name.arr);
	
	fprintf(fp,"\t%s",l_bill_add1_desc.arr);
	if(strlen(l_bill_add1_desc.arr)>0) 
		fprintf(fp,",\n");

	fprintf(fp,"\t%s",l_bill_add2_desc.arr);
	if(strlen(l_bill_add2_desc.arr)>0) 
		fprintf(fp,",\n");

	fprintf(fp,"\t%s\n",l_bill_add3_desc.arr);
	if(strlen(l_bill_add3_desc.arr)>0) 
		fprintf(fp,",\n");

	fprintf(fp,"\t%s\n\n",l_country.arr);
	if(strlen(l_country.arr)>0) 
		fprintf(fp,".\n");

}

print_letter_body()
{
	fprintf(fp,"\t%s,\n\n",loc_legend[7]);
	fprintf(fp,"\t%s : %s ",loc_legend[8],loc_legend[9]);

	if(strcmp(l_recpt_nature_code.arr,"AD")==0)
	{
		fprintf(fp,"%s",loc_legend[11]);
	}
	else if(strcmp(l_recpt_nature_code.arr,"RD")==0)
	{
		fprintf(fp,"%s",loc_legend[12]);
	}
	else if(strcmp(l_recpt_nature_code.arr,"MI")==0)
	{
		fprintf(fp,"%s",loc_legend[13]);
	}
	else
	{
		fprintf(fp,"%s",loc_legend[10]);
	}
	fprintf(fp,"\n\n");

	fprintf(fp,"\t%s.\n\n\n",loc_legend[14]);
	//fprintf(fp,"\t%s.\n\n",loc_legend[15]);

	fprintf(fp,"\t%s %s %s %s\n",loc_legend[16],l_slmt_doc_ref_desc.arr,loc_legend[17],l_slmt_doc_ref_date.arr,loc_legend[18]);
	
	fprintf(fp,"\t%s %s ",loc_legend[19],l_currency.arr);
	print_formated(l_doc_amt);
	fprintf(fp," %s ",loc_legend[21]);

	if(strcmp(l_recpt_nature_code.arr,"AD")==0)
	{
		fprintf(fp,"%s ",loc_legend[27]);
	}
	else if(strcmp(l_recpt_nature_code.arr,"RD")==0)
	{
		fprintf(fp,"%s ",loc_legend[28]);
	}
	else if(strcmp(l_recpt_nature_code.arr,"MI")==0)
	{
		fprintf(fp,"%s ",loc_legend[29]);
	}
	else
	{
		fprintf(fp,"%s ",loc_legend[30]);
	}
	
	fprintf(fp,"%s",loc_legend[22]);

	if(strcmp(l_episode_type.arr,"I")==0 || strcmp(l_episode_type.arr,"D")==0)
	{
	    l_admission_date.arr[0]='\0';
	    l_discharge_date.arr[0]='\0';

		/* EXEC SQL SELECT TO_CHAR(admission_date_time,'DD.MM.RRRR'),
		                NVL(TO_CHAR(discharge_date_time,'DD.MM.RRRR'),TO_CHAR(SYSDATE,'DD.MM.RRRR'))
				   INTO :l_admission_date,
				        :l_discharge_date
				   FROM ip_episode
				  WHERE facility_id = :nd_facility_id
				    AND episode_id  = :l_episode_id
					AND patient_id  = :l_patient_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 12;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select TO_CHAR(admission_date_time,'DD.MM.RRRR') ,NVL(TO_CH\
AR(discharge_date_time,'DD.MM.RRRR'),TO_CHAR(SYSDATE,'DD.MM.RRRR')) into :b0,:\
b1  from ip_episode where ((facility_id=:b2 and episode_id=:b3) and patient_id\
=:b4)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )430;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&l_admission_date;
  sqlstm.sqhstl[0] = (unsigned int  )17;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&l_discharge_date;
  sqlstm.sqhstl[1] = (unsigned int  )17;
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
  sqlstm.sqhstv[3] = (         void  *)&l_episode_id;
  sqlstm.sqhstl[3] = (unsigned int  )17;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&l_patient_id;
  sqlstm.sqhstl[4] = (unsigned int  )27;
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



	    l_admission_date.arr[l_admission_date.len]='\0';
	    l_discharge_date.arr[l_discharge_date.len]='\0';
		
		fprintf(fp," %s\n",loc_legend[23]);
		fprintf(fp,"\t%s %s %s, ",l_admission_date.arr,loc_legend[24],l_discharge_date.arr);

		if(strcmp(l_recpt_nature_code.arr,"AD")==0)
		{
			fprintf(fp,"%s ",loc_legend[34]);
		}
		else if(strcmp(l_recpt_nature_code.arr,"RD")==0)
		{
			fprintf(fp,"%s ",loc_legend[35]);
		}
		else if(strcmp(l_recpt_nature_code.arr,"MI")==0)
		{
			fprintf(fp,"%s ",loc_legend[36]);
		}
		else
		{
			fprintf(fp,"%s ",loc_legend[37]);
		}

		fprintf(fp,"%s %s %s.\n",loc_legend[25],l_org_doc_type_code.arr,loc_legend[26]);
	}
	else if(strcmp(l_episode_type.arr,"O")==0 || strcmp(l_episode_type.arr,"E")==0)
	{
		if(strcmp(l_recpt_nature_code.arr,"AD")==0)
		{
			fprintf(fp,"%s ",loc_legend[34]);
		}
		else if(strcmp(l_recpt_nature_code.arr,"RD")==0)
		{
			fprintf(fp,"%s ",loc_legend[35]);
		}
		else if(strcmp(l_recpt_nature_code.arr,"MI")==0)
		{
			fprintf(fp,"%s ",loc_legend[36]);
		}
		else
		{
			fprintf(fp,"%s ",loc_legend[37]);
		}
		fprintf(fp,"\n\t");

		fprintf(fp,"%s %s %s.\n",loc_legend[25],l_org_doc_type_code.arr,loc_legend[26]);
	}
	fprintf(fp,"\n");
}

print_letter_tail()
{
	fprintf(fp,"\t%s\n\n",loc_legend[31]);
	fprintf(fp,"\t%s\n\n",loc_legend[32]);
	fprintf(fp,"\t%s\n\n\n\n\n",loc_legend[33]);

	fprintf(fp,"\t(%s)\n",l_head_of_company_name.arr);
	fprintf(fp,"\t%s,\n",l_head_of_company_desig.arr);
	fprintf(fp,"\t%s\n",l_acc_entity_name.arr);
}

open_files()
{
   strcpy(filename,WORKING_DIR);

   strcat(filename,"BLR00023.lis");

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
        sprintf(str_amt,"%-",s_amt);
		l_ltrim(s_amt);
        fprintf(fp,"%-s",str_amt);
    }
    else 
	{
        put_val(s_amt,loc_amount);         
        format_amt(s_amt);
        sprintf(str_amt,"%-s",s_amt);
		l_ltrim(s_amt);
        fprintf(fp,"%-s ",str_amt);
    }

}

print_report()
{
	PrintDocument(  uid_pwd.arr,		//char	*PUidPwd;
					nd_session_id.arr,	//char	*PSessionID;
					nd_facility_id.arr,	//char	*PFacilityID;
					"BL",				//char	*PModuleID;
					"BLR00023",			//char	*PDocumentID;
					filename,			//char	*POnlinePrintFileNames;
					"O",				//char	*PLocationTypes;
					" ",				//char	*PLocationCodes;
					1,					//int		PNumOfCopies;
					1,					//int		PPageFrom;
					9999);				//int		PPageTo;);

}
