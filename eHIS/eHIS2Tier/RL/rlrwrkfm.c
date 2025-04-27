
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
           char  filnam[24];
};
static const struct sqlcxp sqlfpn =
{
    23,
    "c:\\procconv\\rlrwrkfm.pc"
};


static unsigned long sqlctx = 582140867;


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
            void  *sqhstv[67];
   unsigned int   sqhstl[67];
            int   sqhsts[67];
            void  *sqindv[67];
            int   sqinds[67];
   unsigned int   sqharm[67];
   unsigned int   *sqharc[67];
   unsigned short  sqadto[67];
   unsigned short  sqtdso[67];
} sqlstm = {10,67};

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
5,0,0,1,0,0,27,175,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,30,206,0,0,0,0,0,1,0,
51,0,0,3,0,0,32,213,0,0,0,0,0,1,0,
66,0,0,4,1745,0,4,274,0,0,67,3,0,1,0,2,3,0,0,2,3,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,
9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,
2,3,0,0,2,3,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,3,0,
0,2,3,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,3,0,0,2,3,
0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,
9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,
2,3,0,0,2,3,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,
349,0,0,5,42,0,4,401,0,0,2,1,0,1,0,1,9,0,0,2,3,0,0,
372,0,0,6,0,0,32,407,0,0,0,0,0,1,0,
387,0,0,7,120,0,6,563,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
410,0,0,8,136,0,6,578,0,0,2,2,0,1,0,2,9,0,0,1,3,0,0,
};


/****************************OCS MEDICOM ver 1.0*****************************
*  File	: comb
   Author : DINESH
   Date Created  : 03/05/1999
   Last Modified : 03/05/1999

*  Ver 1.10.01
   
*  Purpose : To generate a FORMAT for WORKLIST

*  Input Parameters : 
              Command line inputs
	
		      1. Usr_id/Password
                
*  Table Accessed : RL_WORKLIST_FMT_HDR
	    

*  Output File : comb.lis
 ****************************************************************************/  

#include <stdio.h>
#include <math.h>
#include <string.h>
#include <gl.h>

#define MAX_LINES 55
#define OERROR (sqlca.sqlcode < 0)
#define NODATAFOUND sqlca.sqlcode==1403
#define VER  "VER : 1.10.01\n"

/*
#define VIEW_LOG_FILE 1
#define ONLINE_PRINTING 1
*/

/*
#define DEBUG 
*/

/* EXEC SQL BEGIN DECLARE SECTION; */ 


/* INPUT PARAMETERS TO MAIN */

	/* VARCHAR  nd_operating_facility_id   [3],
	    uid_pwd		                    [42],
		nd_user_id                      [31],
		nd_user					        [31],
		nd_reprint				        [2] , 
		nd_test					        [15],
        nd_file_no                      [15],
		nd_file_name			        [150]; */ 
struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[42]; } uid_pwd;

struct { unsigned short len; unsigned char arr[31]; } nd_user_id;

struct { unsigned short len; unsigned char arr[31]; } nd_user;

struct { unsigned short len; unsigned char arr[2]; } nd_reprint;

struct { unsigned short len; unsigned char arr[15]; } nd_test;

struct { unsigned short len; unsigned char arr[15]; } nd_file_no;

struct { unsigned short len; unsigned char arr[150]; } nd_file_name;


  /******** NEWLY ADDED            *****/
  
/* VARCHAR	    nd_cup_number			[32],
		nd_cup_indr				[32],
		nd_spec_no				[32],
		nd_wl_marker				[32],
		nd_pat_id			[32],
		nd_pat_name	     		[61],
		nd_worklist_name		[12],
		nd_section_code			[2],
		nd_age					[32],
		nd_dob					[32],
		nd_sex					[32],
		nd_source				[32],
		nd_consultant			[32],
		nd_urgency				[32],
		nd_comm_1				[32],
		nd_comm_2				[32],
		nd_comm_3				[32],
		nd_spec_date			[32],
		nd_assign_to			[32],
		nd_ref_location			[32],
		nd_category_no			[32],
		nd_collect_date			[32],
		nd_race					[32],
		nd_heading				[20],
		nd_field_type			[2]; */ 
struct { unsigned short len; unsigned char arr[32]; } nd_cup_number;

struct { unsigned short len; unsigned char arr[32]; } nd_cup_indr;

struct { unsigned short len; unsigned char arr[32]; } nd_spec_no;

struct { unsigned short len; unsigned char arr[32]; } nd_wl_marker;

struct { unsigned short len; unsigned char arr[32]; } nd_pat_id;

struct { unsigned short len; unsigned char arr[61]; } nd_pat_name;

struct { unsigned short len; unsigned char arr[12]; } nd_worklist_name;

struct { unsigned short len; unsigned char arr[2]; } nd_section_code;

struct { unsigned short len; unsigned char arr[32]; } nd_age;

struct { unsigned short len; unsigned char arr[32]; } nd_dob;

struct { unsigned short len; unsigned char arr[32]; } nd_sex;

struct { unsigned short len; unsigned char arr[32]; } nd_source;

struct { unsigned short len; unsigned char arr[32]; } nd_consultant;

struct { unsigned short len; unsigned char arr[32]; } nd_urgency;

struct { unsigned short len; unsigned char arr[32]; } nd_comm_1;

struct { unsigned short len; unsigned char arr[32]; } nd_comm_2;

struct { unsigned short len; unsigned char arr[32]; } nd_comm_3;

struct { unsigned short len; unsigned char arr[32]; } nd_spec_date;

struct { unsigned short len; unsigned char arr[32]; } nd_assign_to;

struct { unsigned short len; unsigned char arr[32]; } nd_ref_location;

struct { unsigned short len; unsigned char arr[32]; } nd_category_no;

struct { unsigned short len; unsigned char arr[32]; } nd_collect_date;

struct { unsigned short len; unsigned char arr[32]; } nd_race;

struct { unsigned short len; unsigned char arr[20]; } nd_heading;

struct { unsigned short len; unsigned char arr[2]; } nd_field_type;





/* Fields from table SY_ACC_ENTITY*/
	/* varchar 	d_acc_entity_name        [41],
				d_user                   [31],
				d_sysdate                [17],
				entity_name				 [80]; */ 
struct { unsigned short len; unsigned char arr[41]; } d_acc_entity_name;

struct { unsigned short len; unsigned char arr[31]; } d_user;

struct { unsigned short len; unsigned char arr[17]; } d_sysdate;

struct { unsigned short len; unsigned char arr[80]; } entity_name;


/**************ADDED FOR GLOBALIZATION**************/
	/* varchar	l_translated_value		 [100],
			language_id			[5]; */ 
struct { unsigned short len; unsigned char arr[100]; } l_translated_value;

struct { unsigned short len; unsigned char arr[5]; } language_id;


				

/* SQL statement storing in this Variable */
	char sql_stmt	[500] ;

	int num[21];
	int cou[21];
	char *ptr;
	char word[21][32];

	char detail[21][44];

	char temp_word[32];

	int test = 0;
int i;
char local_legend[100][100];

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
int i =  0;
int j = 0 ;
int k = 0;
int ctr = 0;
int str_len = 0 ;
int total = 0 ;
int l_report_length = 0;

FILE *f1;

void proc_main(argc, argv)
int argc;
char *argv[];
{

	char command_line[200] ;
    void file_name();	
	void fetching();
	void sorting();
	void prepare_heading();
	void print_dtl();


   if (argc < 6)
   {
      
      disp_message(ERR_MESG, "Not enough Parameters for running this program\n");
      disp_message(ERR_MESG, "Exiting...user id/password@connectstring Worklist Section");
      sprintf(string_var, "No of parameters passed is <%d>\n",argc);
      disp_message(ERR_MESG, string_var);
      proc_exit();
   }
   
  
   strcpy(uid_pwd.arr, argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr); 
   
   strcpy(nd_operating_facility_id.arr, argv[4]);
   nd_operating_facility_id.len = strlen(nd_operating_facility_id.arr);

   strcpy(nd_worklist_name.arr, argv[5]);
   nd_worklist_name.len = strlen(nd_worklist_name.arr); 

   strcpy(nd_section_code.arr, argv[6]);
   nd_section_code.len = strlen(nd_section_code.arr); 

   strcpy(nd_test.arr, argv[7]);
   nd_test.len = strlen(nd_test.arr); 

   strcpy(nd_user.arr, argv[8]);
   nd_user.len = strlen(nd_user.arr);


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

  

   if(OERROR)
      disp_message(ORA_MESG,"Failed to connect using : \n");

   #ifdef DEBUG
    printf("Connected to ORACLE as user: %s \n", uid_pwd.arr);
   #endif  
    
	set_meduser_role();
    strcpy(language_id.arr,l_language_id.arr);
	
	language_id.len =l_language_id.len;
	language_id.arr[l_language_id.len]='\0';
   get_legend_value(4);

	file_name();
	fetching();

	if (strcmp(nd_field_type.arr, "P") ==  0)
		l_report_length = 80;
	else
		l_report_length = 132;


	prepare_heading();

	fclose(f1);

		
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

/***** F E T C H I N G        *******/


 void fetching()
{

   nd_cup_number.arr[0] = '\0';
   nd_cup_number.len = 0 ;
   nd_cup_indr.arr[0] = '\0';
   nd_cup_indr.len = 0 ;
   nd_spec_no.arr[0] = '\0';
   nd_spec_no.len = 0 ;
   nd_wl_marker.arr[0] = '\0';
   nd_wl_marker.len = 0 ;
   nd_pat_id.arr[0] = '\0';
   nd_pat_id.len = 0 ;
   nd_pat_name.arr[0] = '\0';
   nd_pat_name.len = 0 ;
   nd_source.arr[0] = '\0';
   nd_source.len = 0 ;
   nd_consultant.arr[0] = '\0';
   nd_consultant.len = 0 ;
   nd_urgency.arr[0] = '\0';
   nd_urgency.len = 0 ;	
   nd_comm_1.arr[0] = '\0';
   nd_comm_1.len = 0 ;	
   nd_comm_2.arr[0] = '\0';
   nd_comm_2.len = 0 ;	
   nd_comm_3.arr[0] = '\0';
   nd_comm_3.len = 0 ;	
   nd_spec_date.arr[0] = '\0';
   nd_spec_date.len = 0 ;	
   nd_assign_to.arr[0]	= '\0';
   nd_assign_to.len		= 0;
   nd_ref_location.arr[0]	= '\0';
   nd_ref_location.len		= 0;
   nd_category_no.arr[0]	= '\0';
   nd_category_no.len		= 0;
   nd_collect_date.arr[0]	= '\0';
   nd_collect_date.len		= 0;
   nd_race.arr[0]			= '\0';
   nd_race.len				= 0;
   nd_field_type.arr[0]		= '\0';
   nd_field_type.len		= 0;
   
    for (i=0;i<21;i++)
    {
	   num[i] = 0;
	   cou[i] = 0;

	   strcpy(word[i],"0");
    }

	   
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   
   /* EXEC SQL 
   SELECT NVL(row_cup_number,0), NVL(col_cup_number,0),
		  NVL(l_cup_number,'0'), NVL(row_cup_indr,0), NVL(col_cup_indr,0),
		  NVL(l_cup_indr,'0'),NVL(row_wl_marker,0), NVL(col_wl_marker,0),
		  NVL(l_wl_marker,'0'), NVL(row_spec_no,0), NVL(col_spec_no,0),
		 NVL(l_spec_no,'0'),  NVL(row_patient_id,0), NVL(col_patient_id,0),
		 NVL(l_patient_id,'0'), NVL(row_pat_name,0), NVL(col_pat_name,0),
		 NVL(l_pat_name,'0'),NVL(row_age,0), NVL(col_age,0), NVL(l_age,'0'),
		 NVL(row_dob,0), NVL(col_dob,0), NVL(l_dob,'0'), NVL(row_sex,0), NVL(col_sex,0),
		 NVL(l_sex,'0'), NVL(row_source,0), NVL(col_source,0), NVL(l_source,'0'),
		 NVL(row_consultant,0), NVL(col_consultant,0), NVL(l_consultant,'0'),
		 NVL(row_urgency,0), NVL(col_urgency,0), NVL(l_urgency,'0'),
		 NVL(row_comm_1,0), NVL(col_comm_1,0),NVL(l_comm_1,'0'), NVL(row_comm_2,0),
		 NVL(col_comm_2,0), NVL(l_comm_2,0), NVL(row_comm_3,0), NVL(col_comm_3,0),
 	     NVL(l_comm_3,'0'), NVL(row_spec_date,0), NVL(col_spec_date,0),
		 NVL(l_spec_date,'0'), NVL(row_assign_to,0), NVL(col_assign_to,0),
		 NVL(l_assign_to,'0'), NVL(row_ref_location,0), NVL(col_ref_location,0),
		 NVL(l_ref_location,'0'), NVL(row_category_no,0), NVL(col_category_no,0),
		 NVL(l_category_no,'0'), NVL(row_collect_date,0), NVL(col_collect_date,0),
		 NVL(l_collect_date,'0'), NVL(row_race, 0), NVL(col_race, 0), NVL(l_race, '0'),
		 NVL(print_format, 'P')
   INTO  :num[0], :cou[0], :nd_cup_number,
		 :num[1], :cou[1], :nd_cup_indr,
		 :num[2], :cou[2], :nd_wl_marker,
		 :num[3], :cou[3], :nd_spec_no,
		 :num[4], :cou[4], :nd_pat_id,
		 :num[5], :cou[5], :nd_pat_name,
		 :num[6], :cou[6], :nd_age,
		 :num[7], :cou[7], :nd_dob,
		 :num[8], :cou[8], :nd_sex,
		 :num[9], :cou[9], :nd_source,
		 :num[10], :cou[10], :nd_consultant,
		 :num[11], :cou[11], :nd_urgency,
		 :num[12], :cou[12], :nd_comm_1,
		 :num[13], :cou[13], :nd_comm_2,
		 :num[14], :cou[14], :nd_comm_3,
		 :num[15], :cou[15], :nd_spec_date,
		 :num[16], :cou[16], :nd_assign_to,
		 :num[17], :cou[17], :nd_ref_location,
		 :num[18], :cou[18], :nd_category_no,
		 :num[19], :cou[19], :nd_collect_date,
		 :num[20], :cou[20], :nd_race,
		 :nd_field_type
   FROM   RL_WORKLIST_FMT_HDR
   WHERE  operating_facility_id = :nd_operating_facility_id
   AND worklist_name = :nd_worklist_name 
   AND section_code = :nd_section_code ; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 67;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlbuft((void **)0, 
     "select NVL(row_cup_number,0) ,NVL(col_cup_number,0) ,NVL(l_cup_number,\
'0') ,NVL(row_cup_indr,0) ,NVL(col_cup_indr,0) ,NVL(l_cup_indr,'0') ,NVL(row\
_wl_marker,0) ,NVL(col_wl_marker,0) ,NVL(l_wl_marker,'0') ,NVL(row_spec_no,0\
) ,NVL(col_spec_no,0) ,NVL(l_spec_no,'0') ,NVL(row_patient_id,0) ,NVL(col_pa\
tient_id,0) ,NVL(l_patient_id,'0') ,NVL(row_pat_name,0) ,NVL(col_pat_name,0)\
 ,NVL(l_pat_name,'0') ,NVL(row_age,0) ,NVL(col_age,0) ,NVL(l_age,'0') ,NVL(r\
ow_dob,0) ,NVL(col_dob,0) ,NVL(l_dob,'0') ,NVL(row_sex,0) ,NVL(col_sex,0) ,N\
VL(l_sex,'0') ,NVL(row_source,0) ,NVL(col_source,0) ,NVL(l_source,'0') ,NVL(\
row_consultant,0) ,NVL(col_consultant,0) ,NVL(l_consultant,'0') ,NVL(row_urg\
ency,0) ,NVL(col_urgency,0) ,NVL(l_urgency,'0') ,NVL(row_comm_1,0) ,NVL(col_\
comm_1,0) ,NVL(l_comm_1,'0') ,NVL(row_comm_2,0) ,NVL(col_comm_2,0) ,NVL(l_co\
mm_2,0) ,NVL(row_comm_3,0) ,NVL(col_comm_3,0) ,NVL(l_comm_3,'0') ,NVL(row_sp\
ec_date,0) ,NVL(col_spec_date,0) ,NVL(l_spec_date,'0') ,NVL(row_assign_to,0)\
 ,NVL(col_assign_to,0) ,NVL(l_assign_to,'0");
   sqlstm.stmt = "') ,NVL(row_ref_location,0) ,NVL(col_ref_location,0) ,NVL(\
l_ref_location,'0') ,NVL(row_category_no,0) ,NVL(col_category_no,0) ,NVL(l_cat\
egory_no,'0') ,NVL(row_collect_date,0) ,NVL(col_collect_date,0) ,NVL(l_collect\
_date,'0') ,NVL(row_race,0) ,NVL(col_race,0) ,NVL(l_race,'0') ,NVL(print_forma\
t,'P') into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12,:b13,:b14,:\
b15,:b16,:b17,:b18,:b19,:b20,:b21,:b22,:b23,:b24,:b25,:b26,:b27,:b28,:b29,:b30\
,:b31,:b32,:b33,:b34,:b35,:b36,:b37,:b38,:b39,:b40,:b41,:b42,:b43,:b44,:b45,:b\
46,:b47,:b48,:b49,:b50,:b51,:b52,:b53,:b54,:b55,:b56,:b57,:b58,:b59,:b60,:b61,\
:b62,:b63  from RL_WORKLIST_FMT_HDR where ((operating_facility_id=:b64 and wor\
klist_name=:b65) and section_code=:b66)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )66;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&num[0];
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&cou[0];
   sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_cup_number;
   sqlstm.sqhstl[2] = (unsigned int  )34;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&num[1];
   sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&cou[1];
   sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_cup_indr;
   sqlstm.sqhstl[5] = (unsigned int  )34;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&num[2];
   sqlstm.sqhstl[6] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&cou[2];
   sqlstm.sqhstl[7] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_wl_marker;
   sqlstm.sqhstl[8] = (unsigned int  )34;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&num[3];
   sqlstm.sqhstl[9] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&cou[3];
   sqlstm.sqhstl[10] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&nd_spec_no;
   sqlstm.sqhstl[11] = (unsigned int  )34;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&num[4];
   sqlstm.sqhstl[12] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&cou[4];
   sqlstm.sqhstl[13] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&nd_pat_id;
   sqlstm.sqhstl[14] = (unsigned int  )34;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&num[5];
   sqlstm.sqhstl[15] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&cou[5];
   sqlstm.sqhstl[16] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&nd_pat_name;
   sqlstm.sqhstl[17] = (unsigned int  )63;
   sqlstm.sqhsts[17] = (         int  )0;
   sqlstm.sqindv[17] = (         void  *)0;
   sqlstm.sqinds[17] = (         int  )0;
   sqlstm.sqharm[17] = (unsigned int  )0;
   sqlstm.sqadto[17] = (unsigned short )0;
   sqlstm.sqtdso[17] = (unsigned short )0;
   sqlstm.sqhstv[18] = (         void  *)&num[6];
   sqlstm.sqhstl[18] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[18] = (         int  )0;
   sqlstm.sqindv[18] = (         void  *)0;
   sqlstm.sqinds[18] = (         int  )0;
   sqlstm.sqharm[18] = (unsigned int  )0;
   sqlstm.sqadto[18] = (unsigned short )0;
   sqlstm.sqtdso[18] = (unsigned short )0;
   sqlstm.sqhstv[19] = (         void  *)&cou[6];
   sqlstm.sqhstl[19] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[19] = (         int  )0;
   sqlstm.sqindv[19] = (         void  *)0;
   sqlstm.sqinds[19] = (         int  )0;
   sqlstm.sqharm[19] = (unsigned int  )0;
   sqlstm.sqadto[19] = (unsigned short )0;
   sqlstm.sqtdso[19] = (unsigned short )0;
   sqlstm.sqhstv[20] = (         void  *)&nd_age;
   sqlstm.sqhstl[20] = (unsigned int  )34;
   sqlstm.sqhsts[20] = (         int  )0;
   sqlstm.sqindv[20] = (         void  *)0;
   sqlstm.sqinds[20] = (         int  )0;
   sqlstm.sqharm[20] = (unsigned int  )0;
   sqlstm.sqadto[20] = (unsigned short )0;
   sqlstm.sqtdso[20] = (unsigned short )0;
   sqlstm.sqhstv[21] = (         void  *)&num[7];
   sqlstm.sqhstl[21] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[21] = (         int  )0;
   sqlstm.sqindv[21] = (         void  *)0;
   sqlstm.sqinds[21] = (         int  )0;
   sqlstm.sqharm[21] = (unsigned int  )0;
   sqlstm.sqadto[21] = (unsigned short )0;
   sqlstm.sqtdso[21] = (unsigned short )0;
   sqlstm.sqhstv[22] = (         void  *)&cou[7];
   sqlstm.sqhstl[22] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[22] = (         int  )0;
   sqlstm.sqindv[22] = (         void  *)0;
   sqlstm.sqinds[22] = (         int  )0;
   sqlstm.sqharm[22] = (unsigned int  )0;
   sqlstm.sqadto[22] = (unsigned short )0;
   sqlstm.sqtdso[22] = (unsigned short )0;
   sqlstm.sqhstv[23] = (         void  *)&nd_dob;
   sqlstm.sqhstl[23] = (unsigned int  )34;
   sqlstm.sqhsts[23] = (         int  )0;
   sqlstm.sqindv[23] = (         void  *)0;
   sqlstm.sqinds[23] = (         int  )0;
   sqlstm.sqharm[23] = (unsigned int  )0;
   sqlstm.sqadto[23] = (unsigned short )0;
   sqlstm.sqtdso[23] = (unsigned short )0;
   sqlstm.sqhstv[24] = (         void  *)&num[8];
   sqlstm.sqhstl[24] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[24] = (         int  )0;
   sqlstm.sqindv[24] = (         void  *)0;
   sqlstm.sqinds[24] = (         int  )0;
   sqlstm.sqharm[24] = (unsigned int  )0;
   sqlstm.sqadto[24] = (unsigned short )0;
   sqlstm.sqtdso[24] = (unsigned short )0;
   sqlstm.sqhstv[25] = (         void  *)&cou[8];
   sqlstm.sqhstl[25] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[25] = (         int  )0;
   sqlstm.sqindv[25] = (         void  *)0;
   sqlstm.sqinds[25] = (         int  )0;
   sqlstm.sqharm[25] = (unsigned int  )0;
   sqlstm.sqadto[25] = (unsigned short )0;
   sqlstm.sqtdso[25] = (unsigned short )0;
   sqlstm.sqhstv[26] = (         void  *)&nd_sex;
   sqlstm.sqhstl[26] = (unsigned int  )34;
   sqlstm.sqhsts[26] = (         int  )0;
   sqlstm.sqindv[26] = (         void  *)0;
   sqlstm.sqinds[26] = (         int  )0;
   sqlstm.sqharm[26] = (unsigned int  )0;
   sqlstm.sqadto[26] = (unsigned short )0;
   sqlstm.sqtdso[26] = (unsigned short )0;
   sqlstm.sqhstv[27] = (         void  *)&num[9];
   sqlstm.sqhstl[27] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[27] = (         int  )0;
   sqlstm.sqindv[27] = (         void  *)0;
   sqlstm.sqinds[27] = (         int  )0;
   sqlstm.sqharm[27] = (unsigned int  )0;
   sqlstm.sqadto[27] = (unsigned short )0;
   sqlstm.sqtdso[27] = (unsigned short )0;
   sqlstm.sqhstv[28] = (         void  *)&cou[9];
   sqlstm.sqhstl[28] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[28] = (         int  )0;
   sqlstm.sqindv[28] = (         void  *)0;
   sqlstm.sqinds[28] = (         int  )0;
   sqlstm.sqharm[28] = (unsigned int  )0;
   sqlstm.sqadto[28] = (unsigned short )0;
   sqlstm.sqtdso[28] = (unsigned short )0;
   sqlstm.sqhstv[29] = (         void  *)&nd_source;
   sqlstm.sqhstl[29] = (unsigned int  )34;
   sqlstm.sqhsts[29] = (         int  )0;
   sqlstm.sqindv[29] = (         void  *)0;
   sqlstm.sqinds[29] = (         int  )0;
   sqlstm.sqharm[29] = (unsigned int  )0;
   sqlstm.sqadto[29] = (unsigned short )0;
   sqlstm.sqtdso[29] = (unsigned short )0;
   sqlstm.sqhstv[30] = (         void  *)&num[10];
   sqlstm.sqhstl[30] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[30] = (         int  )0;
   sqlstm.sqindv[30] = (         void  *)0;
   sqlstm.sqinds[30] = (         int  )0;
   sqlstm.sqharm[30] = (unsigned int  )0;
   sqlstm.sqadto[30] = (unsigned short )0;
   sqlstm.sqtdso[30] = (unsigned short )0;
   sqlstm.sqhstv[31] = (         void  *)&cou[10];
   sqlstm.sqhstl[31] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[31] = (         int  )0;
   sqlstm.sqindv[31] = (         void  *)0;
   sqlstm.sqinds[31] = (         int  )0;
   sqlstm.sqharm[31] = (unsigned int  )0;
   sqlstm.sqadto[31] = (unsigned short )0;
   sqlstm.sqtdso[31] = (unsigned short )0;
   sqlstm.sqhstv[32] = (         void  *)&nd_consultant;
   sqlstm.sqhstl[32] = (unsigned int  )34;
   sqlstm.sqhsts[32] = (         int  )0;
   sqlstm.sqindv[32] = (         void  *)0;
   sqlstm.sqinds[32] = (         int  )0;
   sqlstm.sqharm[32] = (unsigned int  )0;
   sqlstm.sqadto[32] = (unsigned short )0;
   sqlstm.sqtdso[32] = (unsigned short )0;
   sqlstm.sqhstv[33] = (         void  *)&num[11];
   sqlstm.sqhstl[33] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[33] = (         int  )0;
   sqlstm.sqindv[33] = (         void  *)0;
   sqlstm.sqinds[33] = (         int  )0;
   sqlstm.sqharm[33] = (unsigned int  )0;
   sqlstm.sqadto[33] = (unsigned short )0;
   sqlstm.sqtdso[33] = (unsigned short )0;
   sqlstm.sqhstv[34] = (         void  *)&cou[11];
   sqlstm.sqhstl[34] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[34] = (         int  )0;
   sqlstm.sqindv[34] = (         void  *)0;
   sqlstm.sqinds[34] = (         int  )0;
   sqlstm.sqharm[34] = (unsigned int  )0;
   sqlstm.sqadto[34] = (unsigned short )0;
   sqlstm.sqtdso[34] = (unsigned short )0;
   sqlstm.sqhstv[35] = (         void  *)&nd_urgency;
   sqlstm.sqhstl[35] = (unsigned int  )34;
   sqlstm.sqhsts[35] = (         int  )0;
   sqlstm.sqindv[35] = (         void  *)0;
   sqlstm.sqinds[35] = (         int  )0;
   sqlstm.sqharm[35] = (unsigned int  )0;
   sqlstm.sqadto[35] = (unsigned short )0;
   sqlstm.sqtdso[35] = (unsigned short )0;
   sqlstm.sqhstv[36] = (         void  *)&num[12];
   sqlstm.sqhstl[36] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[36] = (         int  )0;
   sqlstm.sqindv[36] = (         void  *)0;
   sqlstm.sqinds[36] = (         int  )0;
   sqlstm.sqharm[36] = (unsigned int  )0;
   sqlstm.sqadto[36] = (unsigned short )0;
   sqlstm.sqtdso[36] = (unsigned short )0;
   sqlstm.sqhstv[37] = (         void  *)&cou[12];
   sqlstm.sqhstl[37] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[37] = (         int  )0;
   sqlstm.sqindv[37] = (         void  *)0;
   sqlstm.sqinds[37] = (         int  )0;
   sqlstm.sqharm[37] = (unsigned int  )0;
   sqlstm.sqadto[37] = (unsigned short )0;
   sqlstm.sqtdso[37] = (unsigned short )0;
   sqlstm.sqhstv[38] = (         void  *)&nd_comm_1;
   sqlstm.sqhstl[38] = (unsigned int  )34;
   sqlstm.sqhsts[38] = (         int  )0;
   sqlstm.sqindv[38] = (         void  *)0;
   sqlstm.sqinds[38] = (         int  )0;
   sqlstm.sqharm[38] = (unsigned int  )0;
   sqlstm.sqadto[38] = (unsigned short )0;
   sqlstm.sqtdso[38] = (unsigned short )0;
   sqlstm.sqhstv[39] = (         void  *)&num[13];
   sqlstm.sqhstl[39] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[39] = (         int  )0;
   sqlstm.sqindv[39] = (         void  *)0;
   sqlstm.sqinds[39] = (         int  )0;
   sqlstm.sqharm[39] = (unsigned int  )0;
   sqlstm.sqadto[39] = (unsigned short )0;
   sqlstm.sqtdso[39] = (unsigned short )0;
   sqlstm.sqhstv[40] = (         void  *)&cou[13];
   sqlstm.sqhstl[40] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[40] = (         int  )0;
   sqlstm.sqindv[40] = (         void  *)0;
   sqlstm.sqinds[40] = (         int  )0;
   sqlstm.sqharm[40] = (unsigned int  )0;
   sqlstm.sqadto[40] = (unsigned short )0;
   sqlstm.sqtdso[40] = (unsigned short )0;
   sqlstm.sqhstv[41] = (         void  *)&nd_comm_2;
   sqlstm.sqhstl[41] = (unsigned int  )34;
   sqlstm.sqhsts[41] = (         int  )0;
   sqlstm.sqindv[41] = (         void  *)0;
   sqlstm.sqinds[41] = (         int  )0;
   sqlstm.sqharm[41] = (unsigned int  )0;
   sqlstm.sqadto[41] = (unsigned short )0;
   sqlstm.sqtdso[41] = (unsigned short )0;
   sqlstm.sqhstv[42] = (         void  *)&num[14];
   sqlstm.sqhstl[42] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[42] = (         int  )0;
   sqlstm.sqindv[42] = (         void  *)0;
   sqlstm.sqinds[42] = (         int  )0;
   sqlstm.sqharm[42] = (unsigned int  )0;
   sqlstm.sqadto[42] = (unsigned short )0;
   sqlstm.sqtdso[42] = (unsigned short )0;
   sqlstm.sqhstv[43] = (         void  *)&cou[14];
   sqlstm.sqhstl[43] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[43] = (         int  )0;
   sqlstm.sqindv[43] = (         void  *)0;
   sqlstm.sqinds[43] = (         int  )0;
   sqlstm.sqharm[43] = (unsigned int  )0;
   sqlstm.sqadto[43] = (unsigned short )0;
   sqlstm.sqtdso[43] = (unsigned short )0;
   sqlstm.sqhstv[44] = (         void  *)&nd_comm_3;
   sqlstm.sqhstl[44] = (unsigned int  )34;
   sqlstm.sqhsts[44] = (         int  )0;
   sqlstm.sqindv[44] = (         void  *)0;
   sqlstm.sqinds[44] = (         int  )0;
   sqlstm.sqharm[44] = (unsigned int  )0;
   sqlstm.sqadto[44] = (unsigned short )0;
   sqlstm.sqtdso[44] = (unsigned short )0;
   sqlstm.sqhstv[45] = (         void  *)&num[15];
   sqlstm.sqhstl[45] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[45] = (         int  )0;
   sqlstm.sqindv[45] = (         void  *)0;
   sqlstm.sqinds[45] = (         int  )0;
   sqlstm.sqharm[45] = (unsigned int  )0;
   sqlstm.sqadto[45] = (unsigned short )0;
   sqlstm.sqtdso[45] = (unsigned short )0;
   sqlstm.sqhstv[46] = (         void  *)&cou[15];
   sqlstm.sqhstl[46] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[46] = (         int  )0;
   sqlstm.sqindv[46] = (         void  *)0;
   sqlstm.sqinds[46] = (         int  )0;
   sqlstm.sqharm[46] = (unsigned int  )0;
   sqlstm.sqadto[46] = (unsigned short )0;
   sqlstm.sqtdso[46] = (unsigned short )0;
   sqlstm.sqhstv[47] = (         void  *)&nd_spec_date;
   sqlstm.sqhstl[47] = (unsigned int  )34;
   sqlstm.sqhsts[47] = (         int  )0;
   sqlstm.sqindv[47] = (         void  *)0;
   sqlstm.sqinds[47] = (         int  )0;
   sqlstm.sqharm[47] = (unsigned int  )0;
   sqlstm.sqadto[47] = (unsigned short )0;
   sqlstm.sqtdso[47] = (unsigned short )0;
   sqlstm.sqhstv[48] = (         void  *)&num[16];
   sqlstm.sqhstl[48] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[48] = (         int  )0;
   sqlstm.sqindv[48] = (         void  *)0;
   sqlstm.sqinds[48] = (         int  )0;
   sqlstm.sqharm[48] = (unsigned int  )0;
   sqlstm.sqadto[48] = (unsigned short )0;
   sqlstm.sqtdso[48] = (unsigned short )0;
   sqlstm.sqhstv[49] = (         void  *)&cou[16];
   sqlstm.sqhstl[49] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[49] = (         int  )0;
   sqlstm.sqindv[49] = (         void  *)0;
   sqlstm.sqinds[49] = (         int  )0;
   sqlstm.sqharm[49] = (unsigned int  )0;
   sqlstm.sqadto[49] = (unsigned short )0;
   sqlstm.sqtdso[49] = (unsigned short )0;
   sqlstm.sqhstv[50] = (         void  *)&nd_assign_to;
   sqlstm.sqhstl[50] = (unsigned int  )34;
   sqlstm.sqhsts[50] = (         int  )0;
   sqlstm.sqindv[50] = (         void  *)0;
   sqlstm.sqinds[50] = (         int  )0;
   sqlstm.sqharm[50] = (unsigned int  )0;
   sqlstm.sqadto[50] = (unsigned short )0;
   sqlstm.sqtdso[50] = (unsigned short )0;
   sqlstm.sqhstv[51] = (         void  *)&num[17];
   sqlstm.sqhstl[51] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[51] = (         int  )0;
   sqlstm.sqindv[51] = (         void  *)0;
   sqlstm.sqinds[51] = (         int  )0;
   sqlstm.sqharm[51] = (unsigned int  )0;
   sqlstm.sqadto[51] = (unsigned short )0;
   sqlstm.sqtdso[51] = (unsigned short )0;
   sqlstm.sqhstv[52] = (         void  *)&cou[17];
   sqlstm.sqhstl[52] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[52] = (         int  )0;
   sqlstm.sqindv[52] = (         void  *)0;
   sqlstm.sqinds[52] = (         int  )0;
   sqlstm.sqharm[52] = (unsigned int  )0;
   sqlstm.sqadto[52] = (unsigned short )0;
   sqlstm.sqtdso[52] = (unsigned short )0;
   sqlstm.sqhstv[53] = (         void  *)&nd_ref_location;
   sqlstm.sqhstl[53] = (unsigned int  )34;
   sqlstm.sqhsts[53] = (         int  )0;
   sqlstm.sqindv[53] = (         void  *)0;
   sqlstm.sqinds[53] = (         int  )0;
   sqlstm.sqharm[53] = (unsigned int  )0;
   sqlstm.sqadto[53] = (unsigned short )0;
   sqlstm.sqtdso[53] = (unsigned short )0;
   sqlstm.sqhstv[54] = (         void  *)&num[18];
   sqlstm.sqhstl[54] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[54] = (         int  )0;
   sqlstm.sqindv[54] = (         void  *)0;
   sqlstm.sqinds[54] = (         int  )0;
   sqlstm.sqharm[54] = (unsigned int  )0;
   sqlstm.sqadto[54] = (unsigned short )0;
   sqlstm.sqtdso[54] = (unsigned short )0;
   sqlstm.sqhstv[55] = (         void  *)&cou[18];
   sqlstm.sqhstl[55] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[55] = (         int  )0;
   sqlstm.sqindv[55] = (         void  *)0;
   sqlstm.sqinds[55] = (         int  )0;
   sqlstm.sqharm[55] = (unsigned int  )0;
   sqlstm.sqadto[55] = (unsigned short )0;
   sqlstm.sqtdso[55] = (unsigned short )0;
   sqlstm.sqhstv[56] = (         void  *)&nd_category_no;
   sqlstm.sqhstl[56] = (unsigned int  )34;
   sqlstm.sqhsts[56] = (         int  )0;
   sqlstm.sqindv[56] = (         void  *)0;
   sqlstm.sqinds[56] = (         int  )0;
   sqlstm.sqharm[56] = (unsigned int  )0;
   sqlstm.sqadto[56] = (unsigned short )0;
   sqlstm.sqtdso[56] = (unsigned short )0;
   sqlstm.sqhstv[57] = (         void  *)&num[19];
   sqlstm.sqhstl[57] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[57] = (         int  )0;
   sqlstm.sqindv[57] = (         void  *)0;
   sqlstm.sqinds[57] = (         int  )0;
   sqlstm.sqharm[57] = (unsigned int  )0;
   sqlstm.sqadto[57] = (unsigned short )0;
   sqlstm.sqtdso[57] = (unsigned short )0;
   sqlstm.sqhstv[58] = (         void  *)&cou[19];
   sqlstm.sqhstl[58] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[58] = (         int  )0;
   sqlstm.sqindv[58] = (         void  *)0;
   sqlstm.sqinds[58] = (         int  )0;
   sqlstm.sqharm[58] = (unsigned int  )0;
   sqlstm.sqadto[58] = (unsigned short )0;
   sqlstm.sqtdso[58] = (unsigned short )0;
   sqlstm.sqhstv[59] = (         void  *)&nd_collect_date;
   sqlstm.sqhstl[59] = (unsigned int  )34;
   sqlstm.sqhsts[59] = (         int  )0;
   sqlstm.sqindv[59] = (         void  *)0;
   sqlstm.sqinds[59] = (         int  )0;
   sqlstm.sqharm[59] = (unsigned int  )0;
   sqlstm.sqadto[59] = (unsigned short )0;
   sqlstm.sqtdso[59] = (unsigned short )0;
   sqlstm.sqhstv[60] = (         void  *)&num[20];
   sqlstm.sqhstl[60] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[60] = (         int  )0;
   sqlstm.sqindv[60] = (         void  *)0;
   sqlstm.sqinds[60] = (         int  )0;
   sqlstm.sqharm[60] = (unsigned int  )0;
   sqlstm.sqadto[60] = (unsigned short )0;
   sqlstm.sqtdso[60] = (unsigned short )0;
   sqlstm.sqhstv[61] = (         void  *)&cou[20];
   sqlstm.sqhstl[61] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[61] = (         int  )0;
   sqlstm.sqindv[61] = (         void  *)0;
   sqlstm.sqinds[61] = (         int  )0;
   sqlstm.sqharm[61] = (unsigned int  )0;
   sqlstm.sqadto[61] = (unsigned short )0;
   sqlstm.sqtdso[61] = (unsigned short )0;
   sqlstm.sqhstv[62] = (         void  *)&nd_race;
   sqlstm.sqhstl[62] = (unsigned int  )34;
   sqlstm.sqhsts[62] = (         int  )0;
   sqlstm.sqindv[62] = (         void  *)0;
   sqlstm.sqinds[62] = (         int  )0;
   sqlstm.sqharm[62] = (unsigned int  )0;
   sqlstm.sqadto[62] = (unsigned short )0;
   sqlstm.sqtdso[62] = (unsigned short )0;
   sqlstm.sqhstv[63] = (         void  *)&nd_field_type;
   sqlstm.sqhstl[63] = (unsigned int  )4;
   sqlstm.sqhsts[63] = (         int  )0;
   sqlstm.sqindv[63] = (         void  *)0;
   sqlstm.sqinds[63] = (         int  )0;
   sqlstm.sqharm[63] = (unsigned int  )0;
   sqlstm.sqadto[63] = (unsigned short )0;
   sqlstm.sqtdso[63] = (unsigned short )0;
   sqlstm.sqhstv[64] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[64] = (unsigned int  )5;
   sqlstm.sqhsts[64] = (         int  )0;
   sqlstm.sqindv[64] = (         void  *)0;
   sqlstm.sqinds[64] = (         int  )0;
   sqlstm.sqharm[64] = (unsigned int  )0;
   sqlstm.sqadto[64] = (unsigned short )0;
   sqlstm.sqtdso[64] = (unsigned short )0;
   sqlstm.sqhstv[65] = (         void  *)&nd_worklist_name;
   sqlstm.sqhstl[65] = (unsigned int  )14;
   sqlstm.sqhsts[65] = (         int  )0;
   sqlstm.sqindv[65] = (         void  *)0;
   sqlstm.sqinds[65] = (         int  )0;
   sqlstm.sqharm[65] = (unsigned int  )0;
   sqlstm.sqadto[65] = (unsigned short )0;
   sqlstm.sqtdso[65] = (unsigned short )0;
   sqlstm.sqhstv[66] = (         void  *)&nd_section_code;
   sqlstm.sqhstl[66] = (unsigned int  )4;
   sqlstm.sqhsts[66] = (         int  )0;
   sqlstm.sqindv[66] = (         void  *)0;
   sqlstm.sqinds[66] = (         int  )0;
   sqlstm.sqharm[66] = (unsigned int  )0;
   sqlstm.sqadto[66] = (unsigned short )0;
   sqlstm.sqtdso[66] = (unsigned short )0;
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




  nd_cup_number.arr[nd_cup_number.len] = '\0';
  nd_cup_indr.arr[nd_cup_indr.len]	   = '\0';
  nd_spec_no.arr[nd_spec_no.len]	   = '\0';
  nd_wl_marker.arr[nd_wl_marker.len]   = '\0';
  nd_pat_id.arr[nd_pat_id.len] = '\0';
  nd_pat_name.arr[nd_pat_name.len]     = '\0';
  nd_age.arr[nd_age.len]			   = '\0';
  nd_dob.arr[nd_dob.len]			   = '\0';
  nd_sex.arr[nd_sex.len]			   = '\0';
  nd_source.arr[nd_source.len]		   = '\0';
  nd_consultant.arr[nd_consultant.len] = '\0';
  nd_urgency.arr[nd_urgency.len]	   = '\0';
  nd_comm_1.arr[nd_comm_1.len]	       = '\0';
  nd_comm_2.arr[nd_comm_2.len]	       = '\0';
  nd_comm_3.arr[nd_comm_3.len]	       = '\0';
  nd_spec_date.arr[nd_spec_date.len]   = '\0';
  nd_assign_to.arr[nd_assign_to.len]   = '\0';
  nd_ref_location.arr[nd_ref_location.len]	= '\0';
  nd_category_no.arr[nd_category_no.len]	= '\0';
  nd_collect_date.arr[nd_collect_date.len]	= '\0';
  nd_race.arr[nd_race.len]					= '\0';
  nd_field_type.arr[nd_field_type.len]		= '\0';

/*
#ifdef DEBUG
   printf(" nd_source_code= %s\n", nd_source_code.arr);
   printf(" nd_consultant_code= %s\n", nd_consultant_code.arr);
   printf(" nd_blood_group=%s\n", nd_blood_group.arr) ;
   printf(" nd_rhesus_code=%s\n", nd_rhesus_code.arr) ;
   printf(" nd_antibody_code=%s\n", nd_antibody_code.arr) ;
#endif
*/

 
   strcpy(word[0], nd_cup_number.arr);
   strcpy(word[1], nd_cup_indr.arr);
   strcpy(word[2], nd_wl_marker.arr);
   strcpy(word[3], nd_spec_no.arr);
   strcpy(word[4], nd_pat_id.arr);
   strcpy(word[5], nd_pat_name.arr);
   strcpy(word[6], nd_age.arr);
   strcpy(word[7], nd_dob.arr);
   strcpy(word[8], nd_sex.arr);
   strcpy(word[9], nd_source.arr);
   strcpy(word[10], nd_consultant.arr);
   strcpy(word[11], nd_urgency.arr);
   strcpy(word[12], nd_comm_1.arr);
   strcpy(word[13], nd_comm_2.arr);
   strcpy(word[14], nd_comm_3.arr);
   strcpy(word[15], nd_spec_date.arr);
   strcpy(word[16], nd_assign_to.arr);
   strcpy(word[17], nd_ref_location.arr);
   strcpy(word[18], nd_category_no.arr);
   strcpy(word[19], nd_collect_date.arr);
   strcpy(word[20], nd_race.arr);

   strcpy(detail[0], "XXX");
   strcpy(detail[1], "X");
   strcpy(detail[2], "X");
   strcpy(detail[3], "XXXXXXXXX");
   strcpy(detail[4], "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
   strcpy(detail[5], "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
   strcpy(detail[6], "XXX XX XX");
   strcpy(detail[7], "XXXXXXXX");
   strcpy(detail[8], "X");
   strcpy(detail[9], "XXXX");
   strcpy(detail[10], "XXXXXX");
   strcpy(detail[11], "X");
   strcpy(detail[12], "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
   strcpy(detail[13], "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
   strcpy(detail[14], "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
   strcpy(detail[15], "XXXXXXXXXXXXXXXXXXX");
   strcpy(detail[16], "XXXXXXXXXXXXXXXXXXXX");
   strcpy(detail[17], "XXXXXXXXXX");
   strcpy(detail[18], "XXXX/XXXXX/XXXXXXXXXX");
   strcpy(detail[19], "XXXXXXXXXXXXXXXXXXX");
   strcpy(detail[20], "XXXX");

   /* EXEC SQL SELECT TO_NUMBER(:nd_test) INTO :test FROM DUAL; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 67;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select TO_NUMBER(:b0) into :b1  from DUAL ";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )349;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_test;
   sqlstm.sqhstl[0] = (unsigned int  )17;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&test;
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
   if (sqlca.sqlcode < 0) goto err_exit;
}



  return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 67;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )372;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_dept_printer() occured....\n");
   proc_exit();
}

/************************************************/

/*------------------ H E A D I N G ------------------*/
void prepare_heading()
{

    char heading[60] ;
	int p = 0;
	int q = 0;
	int length = 0;

	strcpy(heading, local_legend[3]);
	strcat(heading, nd_worklist_name.arr);
    length = (l_report_length - strlen(heading))/2 ;

	sorting();

		
    total = 0;
	ctr   = 1;

	fprintf(f1,"%*.*s", length,length,"");
	fprintf(f1,"%s\n", heading);
	fprintf(f1,"%*.*s", length,length,"");
	fprint_repeat(f1,'-',strlen(heading));		   
	fprintf(f1,"\n");

	fprintf(f1,"1........10........20........30........40........50");
	fprintf(f1,"........60........70........80");
	
	if (strcmp(nd_field_type.arr, "L") == 0)
	{
		fprintf(f1,"........90........100.......110");
		fprintf(f1,".......120.......130");
	}

	fprintf(f1,"\n");
	fprintf(f1,"\n");

	p = 19;
	while(p >= 0)
	{
		if (num[p] == 1)
		{
			if (strlen(word[p]) > strlen(detail[p]))
				q = strlen(word[p]);
			else
			    q = strlen(detail[p]);

			test = cou[p] + q;
			break;
			
		}

		p--;
	}

	fprintf(f1,"%*s",test,"    ");

	if (strcmp(nd_field_type.arr, "L") == 0)
	{
		fprintf(f1,"%s", local_legend[3]);
		for(i=7;i<l_report_length - test;i++)
			fprintf(f1,"-");
		fprintf(f1,">");
	}

	fprintf(f1,"\n");
	fprintf(f1,"\n");


	for(i=1;i<=21;i++)
	{

	 
	   k = i;

	   for (j=0;j<21;j++)
	   {
		
		
	      if (num[j] == ctr) 
	      {

		
			  if ((j > 0) && (num[j - 1] == num[j]) > 0)
			  {

			      total = cou[j - 1] ;
				  str_len = strlen(word[j - 1])  ;
				  
			  }
			
			  if ((j > 0) && (num[j - 1] == num[j]) > 0)
			  {
			     fprintf(f1,"%*s",(cou[j]   - (total + str_len)),"");
  		         fprintf(f1,"%s", word[j]);
			  }
			  else
			  {
				fprintf(f1,"%*s", cou[j] - 1, "");
				fprintf(f1,"%s", word[j]);
			  }

			  k = j ;		   
			  str_len = 0;
			  
	      }

		  

      }
	
	   i = k;
	   
	   if (num[i] > 0)
	   {
	      fprintf(f1,"\n");

		  fprintf(f1,"---------------------------------------------");
		  fprintf(f1,"-----------------------------------");
	
		  if (strcmp(nd_field_type.arr, "L") == 0)
		  {
			fprintf(f1, "-----------------------------------------------------");

		  }

	      fprintf(f1,"\n");
		  total = 0;

	  }

	   ctr = ctr + 1 ;

	}

	fprintf(f1,"\n");

	print_dtl();

	fprintf(f1,"\n");

	return ;
}

/************get_legend_value*******************/
get_legend_value(int cou)
 {
     
   
	/* EXEC SQL EXECUTE
	BEGIN
	  SM_POPULATE_REPORT_LEGEND.FETCH_LEGEND (:nd_operating_facility_id,:language_id,'RLRWRKFM.LEGEND_');
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 67;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin SM_POPULATE_REPORT_LEGEND . FETCH_LEGEND ( :nd_operati\
ng_facility_id , :language_id , 'RLRWRKFM.LEGEND_' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )387;
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
               :l_translated_value :=    GET_LEGEND(LTRIM(RTRIM('RLRWRKFM.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009'))))));
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 67;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin :l_translated_value := GET_LEGEND ( LTRIM ( RTRIM ( 'R\
LRWRKFM.LEGEND_' || LTRIM ( RTRIM ( TO_CHAR ( :i , '009' ) ) ) ) ) ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )410;
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
/****************End****************/

/*------------------ S O R T I N G ------------------*/
void sorting()
{

	for(i=0;i<21;i++)
	{
		for(j=i+1;j<21;j++)
		{
			if (((num[j] < num[i]) || (num[i] == 0))  && (num[j] > 0))
			{
				total  = num[i];
				num[i] = num[j];
				num[j] = total;

				total  = cou[i];
				cou[i] = cou[j];
				cou[j] = total;
			
				strcpy(temp_word,word[i]);
				strcpy(word[i], word[j]);
				strcpy(word[j], temp_word);

				strcpy(temp_word,detail[i]);
				strcpy(detail[i], detail[j]);
				strcpy(detail[j], temp_word);


			}
		
		}	
	
	}


	for(i=0;i<21;i++)
	{
		for(j=i+1;j<21;j++)
		{
			if ((num[j] == num[i]) && (num[j] > 0))
			{
				if (((cou[j] < cou[i]) || (cou[i] == 0)) && (cou[j] > 0))
				{
				   total = cou[i];
				   cou[i] = cou[j];
				   cou[j] = total;

				   strcpy(temp_word,word[i]);
				   strcpy(word[i], word[j]);
				   strcpy(word[j], temp_word);

				   strcpy(temp_word,detail[i]);
				   strcpy(detail[i], detail[j]);
				   strcpy(detail[j], temp_word);

				}

			}
		
		}	
	
	}

	
}

/*-----------------------------------------------------*/
fprint_repeat(l_fp,l_prn_chr,l_no)
FILE *l_fp;
char l_prn_chr;
int  l_no;
{
   int l_i = 0;

   for (l_i = 0;l_i < l_no;l_i++)
        fputc(l_prn_chr,l_fp);
}

/*-----------------------------------------------------*/
void print_dtl()
{

    total = 0;
	ctr   = 1;

	for(i=1;i<=21;i++)
	{

	 
	   k = i;

	   for (j=0;j<21;j++)
	   {
		
		
	      if (num[j] == ctr)
	      {

						 		
			  if ((j > 0) && (num[j - 1] == num[j]))
			  {
			      total = cou[j - 1] ;
			       str_len = strlen(detail[j - 1])  ;
			  }
			
			  if ((j > 0) && (num[j - 1] == num[j]) > 0)
			  {
			     fprintf(f1,"%*s",(cou[j]   - (total + str_len)),"");
  		         fprintf(f1,"%s", detail[j]);
			  }
			  else
			  {
				fprintf(f1,"%*s", cou[j] - 1, "");
				fprintf(f1,"%s", detail[j]);
			  }
			  

			  k = j ;		   
			  str_len = 0;
			  
	      }

		  

      }
	
	   i = k;
	   
	   if (num[i] > 0)
	   {
	      fprintf(f1,"\n");

		  fprintf(f1,"---------------------------------------------");
		  fprintf(f1,"-----------------------------------");
	
		  if (strcmp(nd_field_type.arr, "L") == 0)
		  {
			fprintf(f1, "-----------------------------------------------------");

		  }

	      fprintf(f1,"\n");
		  total = 0;

	  }

	   ctr = ctr + 1 ;

	}


	if (strcmp(nd_field_type.arr, "P") == 0)
	{
		
		fprintf(f1, "Tests %s\n", "___________");
	}

}


/*-----------------------------------------------------*/

void file_name()
{
     nd_file_name.arr[0]   = '\0';
     nd_file_name.len      = 0;

     
	 strcpy(nd_file_name.arr,WORKING_DIR) ;
     nd_file_name.len = strlen(nd_file_name.arr);
	 //strcat(nd_user.arr,".lis");
	 
	 strcat(nd_file_name.arr,"rlrwrkfm.lis");
	 nd_file_name.len = strlen(nd_file_name.arr);


	 if ((f1 = fopen(nd_file_name.arr,"w")) == NULL)
     {
       sprintf(string_var,"Error while opening file %s\n",nd_file_name.arr);
	   disp_message(ERR_MESG,string_var) ;
       proc_exit();
     }
    


}
#undef DEBUG
#undef OERROR
#undef NODATAFOUND
#undef MAX_LINES
#undef VER

