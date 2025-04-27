
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/BLRLM006.PC"
};


static unsigned int sqlctx = 1288466315;


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
            void  *sqhstv[12];
   unsigned int   sqhstl[12];
            int   sqhsts[12];
            void  *sqindv[12];
            int   sqinds[12];
   unsigned int   sqharm[12];
   unsigned int   *sqharc[12];
   unsigned short  sqadto[12];
   unsigned short  sqtdso[12];
} sqlstm = {12,12};

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

 static const char *sq0005 = 
"VL(:b2,'01/01/1000'),'DD/MM/YYYY') and TO_DATE(NVL(:b3,'01/01/3000'),'DD/MM/\
YYYY')) and NVL(RECALCULATED_YN,'N')='Y') and :b4 in ('O','E')) and A.episode_\
type=:b4) order by 1,2,3,4            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,1,88,0,6,177,0,0,1,1,0,1,0,1,9,0,0,
24,0,0,2,0,0,30,222,0,0,0,0,0,1,0,
39,0,0,3,199,0,4,250,0,0,11,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
98,0,0,4,84,0,2,292,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
125,0,0,5,1216,0,9,354,0,0,12,12,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
188,0,0,5,0,0,15,362,0,0,0,0,0,1,0,
203,0,0,5,0,0,13,390,0,0,10,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,4,0,0,2,4,0,0,2,9,0,0,2,9,0,0,
258,0,0,6,158,0,4,578,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
293,0,0,0,0,0,27,644,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
324,0,0,8,56,0,4,666,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
347,0,0,9,132,0,4,695,0,0,3,2,0,1,0,1,9,0,0,2,9,0,0,1,9,0,0,
374,0,0,10,96,0,4,807,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
397,0,0,11,165,0,6,814,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
428,0,0,12,207,0,6,836,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.0                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLRLM006.PC                                  */
/* AUTHOR                :					                            */
/* DATE WRITTEN          : 12-FEB-2009                                  */
/*                                                                       */
/* CALLED FROM           :                                              */
/*                                                                      */
/*  FUNCTION             :                                              */
/*                                                                      */
/*  TABLE DETAILS                                                       */
/*                                                O                      */
/*        S. No.       TABLENAMES             INPUT/OUTPUT              */
/*                                                                      */
/*                                                                      */
/*  PARAMETERS           :            -                                 */
/*                                                                         */
/*  SUBROUTINES          :                                              */
/*                                                                      */
/*         1.        ERR_MESG            err_mesg                       */
/*                                                                      */
/*                                                                      */
/************************************************************************/
           
		                  
#include <stdio.h>
#include <string.h>
#include "gl.h"

#define OERROR (sqlca.sqlcode < 0)
#define LAST_ROW (sqlca.sqlcode == 1403)
#define NOT_FOUND (sqlca.sqlerrd[2] == 0)
#define RESOURCE_BUSY        (sqlca.sqlcode == -54)
#define DUPLICATE_KEY        (sqlca.sqlcode == -1)
#define ROW_COUNT            (sqlca.sqlerrd[2])
#define INIT_MESG "Report Generation In Progress"
#define ESC     0x1B
#define REP_WIDTH 154
#define VER  "VER : 10.03\n"



/* EXEC SQL BEGIN DECLARE SECTION; */ 


    /* VARCHAR hosp_name                                  [120],
            uid_pwd                                    [91],
            date_time                                  [20],
            user_id                                    [40],
            nd_session_id                              [16],
			nd_temp_date							   [21],
			nd_loc_date[21],
			date_convert[21],
            nd_pgm_date                                [25],
			p_language_id[3],
            d_curr_pgm_name                            [15]; */ 
struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[40]; } user_id;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[21]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[21]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[21]; } date_convert;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;


   

   /* VARCHAR	bl_patient_id		[21],
            nd_patient_name		[61],
			bl_episode_type     [2],
			bl_episode_id       [9],
			bl_visit_id         [3],
			bl_reason_code      [3],
			nd_old_blng_grp		[5],
			nd_new_blng_grp		[5],
			nd_reason_desc      [31],
			nd_user_id          [21],
			nd_user_name        [31],
			bl_recal_ind		[2],
			nd_clinic_code		[5],
			nd_episode_type		[2],
			nd_from_patient_id	[21],
			nd_to_patient_id	[21],
			nd_from_date		[11],
			nd_to_date			[11],
			nd_adm_date			[11],
			bl_recalc_date		[12],
			bl_recalc_by		[21],
			nd_from_date_flag	[2],
			nd_to_date_flag		[2],
			nd_rep_option		[2],
			nd_facility_id   [3],
			l_pk_value	[100],
			l_translated_value	        [201],
		    nd_operating_facility_id  [3]; */ 
struct { unsigned short len; unsigned char arr[21]; } bl_patient_id;

struct { unsigned short len; unsigned char arr[61]; } nd_patient_name;

struct { unsigned short len; unsigned char arr[2]; } bl_episode_type;

struct { unsigned short len; unsigned char arr[9]; } bl_episode_id;

struct { unsigned short len; unsigned char arr[3]; } bl_visit_id;

struct { unsigned short len; unsigned char arr[3]; } bl_reason_code;

struct { unsigned short len; unsigned char arr[5]; } nd_old_blng_grp;

struct { unsigned short len; unsigned char arr[5]; } nd_new_blng_grp;

struct { unsigned short len; unsigned char arr[31]; } nd_reason_desc;

struct { unsigned short len; unsigned char arr[21]; } nd_user_id;

struct { unsigned short len; unsigned char arr[31]; } nd_user_name;

struct { unsigned short len; unsigned char arr[2]; } bl_recal_ind;

struct { unsigned short len; unsigned char arr[5]; } nd_clinic_code;

struct { unsigned short len; unsigned char arr[2]; } nd_episode_type;

struct { unsigned short len; unsigned char arr[21]; } nd_from_patient_id;

struct { unsigned short len; unsigned char arr[21]; } nd_to_patient_id;

struct { unsigned short len; unsigned char arr[11]; } nd_from_date;

struct { unsigned short len; unsigned char arr[11]; } nd_to_date;

struct { unsigned short len; unsigned char arr[11]; } nd_adm_date;

struct { unsigned short len; unsigned char arr[12]; } bl_recalc_date;

struct { unsigned short len; unsigned char arr[21]; } bl_recalc_by;

struct { unsigned short len; unsigned char arr[2]; } nd_from_date_flag;

struct { unsigned short len; unsigned char arr[2]; } nd_to_date_flag;

struct { unsigned short len; unsigned char arr[2]; } nd_rep_option;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;
 

   int		bl_recal_defn_no;
    	int i;

   int		prt_ctr = 0;

   double	nd_old_bill_amt,
			nd_new_bill_amt;
	  char loc_legend[999][201]; 
   char		rep_title[25];
      
  
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

int s_lctr = 0,s_pctr = 0;
int d_lctr = 0,d_pctr = 0;
int pctr = 0;

FILE *f1, *f2;

int bill_ctr = 0;


char hdr_line1[REP_WIDTH+1],
     hdr_line2[REP_WIDTH+1],
     hdr_line3[REP_WIDTH+1],
     hdr_line4[REP_WIDTH+1];

void proc_main(argc,argv)
char *argv[];
int argc;
{
    int rec_ctr = 0;
	

    if (argc < 4)
    {
     int i = 0;
       disp_message(ERR_MESG,"Not enough Parameters for running this program");
       proc_exit();
    }

	strcpy(uid_pwd.arr,argv[1]);
      uid_pwd.len = strlen(uid_pwd.arr);
 
      strcpy(g_pgm_id,"BLRLM006");

  if(sql_connect() == -1)
   {
      disp_message(ERR_MESG,"Error in connecting to Oracle");
      if (uid_pwd.len == 0)
         disp_message(ERR_MESG,"Null oracle uid/pwd");
      proc_exit();
   } 



    strcpy(d_curr_pgm_name.arr,g_pgm_id); 
    d_curr_pgm_name.len = strlen(d_curr_pgm_name.arr);
	
	
	strcpy(p_language_id.arr,l_language_id.arr);
	 p_language_id.len = l_language_id.len; 

    strcpy(nd_session_id.arr,argv[2]);
    nd_session_id.len = strlen(nd_session_id.arr);
    strcpy(g_session_id,nd_session_id.arr);

    strcpy(nd_pgm_date.arr,argv[3]);
    nd_pgm_date.len = strlen(nd_pgm_date.arr);
    strcpy(g_pgm_date,nd_pgm_date.arr);

	strcpy(nd_facility_id.arr, argv[4]);
	nd_facility_id.len = strlen(nd_facility_id.arr);

	

    set_meduser_role();

	//disp_message(ERR_MESG,p_language_id.arr);
	//disp_message(ERR_MESG,nd_facility_id.arr);
    
    fetch_prog_param();
	

	/* EXEC SQL EXECUTE
	BEGIN
SM_SECURITY_POLICY.SET_CTX_FOR_FACILITY_ID(:nd_operating_facility_id);
END;
END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 1;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin SM_SECURITY_POLICY . SET_CTX_FOR_FACILITY_ID ( :nd_ope\
rating_facility_id ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )5;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
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



  //disp_message(ERR_MESG,:nd_operating_facility_id);

    /*if (nd_episode_type.arr[0] == 'I')
    strcpy(rep_title,"List of Recalculated Admissions");
    
	if (nd_episode_type.arr[0] == 'O')
    strcpy(rep_title,"List of Recalculated Visits");*/
	
	fetch_legend_value();
	strcpy(rep_title,loc_legend[001]);
       
    declare_recal_cur();

    fetch_hosp_name();

    open_file();
     
    open_recal_cursor(); 

	print_rep_header();

	print_head();

	prt_ctr = 0; 
	
      while(fetch_recal_cursor())
        {

		print_rec();

	    } 
    print_tot();
 
    close_recal_cursor();     
    
    end_of_rep();
    
    fclose(f2);

    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 1;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )24;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR)
         err_mesg("COMMIT WORK RELEASE failed",0,"");  
    
    return;
}

fetch_prog_param()
{
   nd_from_patient_id.arr[0]	='\0';
   nd_to_patient_id.arr[0]		='\0';
   nd_from_date.arr[0]			='\0';
   nd_to_date.arr[0]			='\0';
   nd_episode_type.arr[0]		='\0';
   nd_from_date_flag.arr[0]		='\0';
   nd_to_date_flag.arr[0]		='\0';
   nd_rep_option.arr[0]			='\0';
   
   nd_from_patient_id.len		=0;
   nd_to_patient_id.len			=0;
   nd_from_date.len				=0;
   nd_to_date.len				=0;
   nd_episode_type.len			=0;
   nd_from_date_flag.len		=0;
   nd_to_date_flag.len			=0;
   nd_rep_option.len			=0;
   
   /* EXEC SQL SELECT PARAM1,
		   PARAM2,
		   PARAM3,
		   PARAM4,
		   PARAM5,
		   PARAM6,
		   PARAM7,
               operating_facility_id
            INTO 
            :nd_from_patient_id,
            :nd_to_patient_id,
            :nd_from_date,
            :nd_to_date,
			:nd_episode_type,
			:nd_from_date_flag,
			:nd_to_date_flag,
			:nd_operating_facility_id

              FROM SY_PROG_PARAM
             WHERE PGM_ID     = :d_curr_pgm_name
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 ,PARAM5 ,PARAM6 ,PAR\
AM7 ,operating_facility_id into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7  from SY_PROG_\
PARAM where ((PGM_ID=:b8 and SESSION_ID=:b9) and PGM_DATE=:b10)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )39;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_from_patient_id;
   sqlstm.sqhstl[0] = (unsigned int  )23;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_to_patient_id;
   sqlstm.sqhstl[1] = (unsigned int  )23;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_from_date;
   sqlstm.sqhstl[2] = (unsigned int  )13;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_to_date;
   sqlstm.sqhstl[3] = (unsigned int  )13;
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
   sqlstm.sqhstv[5] = (         void  *)&nd_from_date_flag;
   sqlstm.sqhstl[5] = (unsigned int  )4;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_to_date_flag;
   sqlstm.sqhstl[6] = (unsigned int  )4;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[7] = (unsigned int  )5;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&d_curr_pgm_name;
   sqlstm.sqhstl[8] = (unsigned int  )17;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[9] = (unsigned int  )18;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[10] = (unsigned int  )27;
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
        err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

    nd_from_patient_id.arr[nd_from_patient_id.len]	='\0';
   nd_to_patient_id.arr[nd_to_patient_id.len]		='\0';
   nd_from_date.arr[nd_from_date.len]				='\0';
   nd_to_date.arr[nd_to_date.len]					='\0';
   nd_episode_type.arr[nd_episode_type.len]			='\0';
   nd_from_date_flag.arr[nd_from_date_flag.len]		='\0';
   nd_to_date_flag.arr[nd_to_date_flag.len]			='\0';
   nd_rep_option.arr[nd_rep_option.len]				='\0';
   
   if (NOT_FOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");



   
  
   /* EXEC SQL DELETE SY_PROG_PARAM
             WHERE PGM_ID     = :d_curr_pgm_name
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID=:b0 and SESSION\
_ID=:b1) and PGM_DATE=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )98;
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
   sqlstm.sqhstv[1] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[1] = (unsigned int  )18;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_pgm_date;
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



   if (OERROR)
         err_mesg("DELETE failed on table SY_PROG_PARAM",0,"");
   
}

declare_recal_cur()
{
    /* EXEC SQL DECLARE BL_RECAL_CUR CURSOR FOR
		SELECT to_char(trunc(A.ADMISSION_DATE_TIME),'DD/MM/YYYY') ADM_DATE,
						A.PATIENT_ID, 
						A.EPISODE_ID,0 VISIT_ID, 
                        A.OLD_BLNG_GRP_ID,
						A.BLNG_GRP_ID,
						A.OLD_BILL_AMOUNT,
						A.NEW_BILL_AMOUNT,
						A.RECALCULATED_BY_ID,
						to_char(A.RECALCULATED_DATE,'DD/MM/YYYY') RECAL_DATE
                   FROM BL_EPISODE_FIN_DTLS A
                   WHERE  --A.EPISODE_ID = B.EPISODE_ID				   AND 
				      A.PATIENT_ID BETWEEN :nd_from_patient_id AND :nd_to_patient_id
				   AND    trunc(ADMISSION_DATE_TIME) BETWEEN TO_DATE(NVL(:nd_from_date,'01/01/1000'),'DD/MM/YYYY')
		                  AND TO_DATE(NVL(:nd_to_date,'01/01/3000'),'DD/MM/YYYY')
				   AND    NVL(RECALCULATED_YN,'N')='Y'
				   AND    :nd_episode_type IN('I','D') 
				   AND     A.episode_type=:nd_episode_type
				   UNION
	    SELECT to_char(trunc(B.VISIT_REGN_DATE_TIME),'DD/MM/YYYY') ADM_DATE,
						A.PATIENT_ID,
						A.EPISODE_ID,
						A.VISIT_ID, 
                        A.OLD_BLNG_GRP_ID,
						A.BLNG_GRP_ID,           
						A.OLD_BILL_AMOUNT,
						A.NEW_BILL_AMOUNT,
						A.RECALCULATED_BY_ID,
						to_char(A.RECALCULATED_DATE,'DD/MM/YYYY') RECAL_DATE
                   FROM BL_VISIT_FIN_DTLS A, OP_VISIT B
                   WHERE  A.PATIENT_ID = B.PATIENT_ID
				   AND    A.EPISODE_ID = B.EPISODE_ID
				   AND    A.VISIT_ID   = B.VISIT_ID
				   /oAND    A.EPISODE_ID = C.EPISODE_ID
				   AND    A.VISIT_ID = C.VISIT_IDo/
				   AND    A.PATIENT_ID BETWEEN :nd_from_patient_id AND :nd_to_patient_id
				   AND    trunc(B.VISIT_REGN_DATE_TIME) BETWEEN TO_DATE(NVL(:nd_from_date,'01/01/1000'),'DD/MM/YYYY')
						AND TO_DATE(NVL(:nd_to_date,'01/01/3000'),'DD/MM/YYYY')
				   AND    NVL(RECALCULATED_YN,'N')='Y' 
				   AND    :nd_episode_type IN('O','E')
				   AND   A.episode_type=:nd_episode_type
				   ORDER BY 1,2,3,4; */ 

		  
	

}


open_recal_cursor()
{
    /* EXEC SQL OPEN BL_RECAL_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlbuft((void **)0, 
      "select to_char(trunc(A.ADMISSION_DATE_TIME),'DD/MM/YYYY') ADM_DATE ,A\
.PATIENT_ID ,A.EPISODE_ID ,0 VISIT_ID ,A.OLD_BLNG_GRP_ID ,A.BLNG_GRP_ID ,A.O\
LD_BILL_AMOUNT ,A.NEW_BILL_AMOUNT ,A.RECALCULATED_BY_ID ,to_char(A.RECALCULA\
TED_DATE,'DD/MM/YYYY') RECAL_DATE  from BL_EPISODE_FIN_DTLS A where ((((A.PA\
TIENT_ID between :b0 and :b1 and trunc(ADMISSION_DATE_TIME) between TO_DATE(\
NVL(:b2,'01/01/1000'),'DD/MM/YYYY') and TO_DATE(NVL(:b3,'01/01/3000'),'DD/MM\
/YYYY')) and NVL(RECALCULATED_YN,'N')='Y') and :b4 in ('I','D')) and A.episo\
de_type=:b4) union select to_char(trunc(B.VISIT_REGN_DATE_TIME),'DD/MM/YYYY'\
) ADM_DATE ,A.PATIENT_ID ,A.EPISODE_ID ,A.VISIT_ID ,A.OLD_BLNG_GRP_ID ,A.BLN\
G_GRP_ID ,A.OLD_BILL_AMOUNT ,A.NEW_BILL_AMOUNT ,A.RECALCULATED_BY_ID ,to_cha\
r(A.RECALCULATED_DATE,'DD/MM/YYYY') RECAL_DATE  from BL_VISIT_FIN_DTLS A ,OP\
_VISIT B where (((((((A.PATIENT_ID=B.PATIENT_ID and A.EPISODE_ID=B.EPISODE_I\
D) and A.VISIT_ID=B.VISIT_ID) and A.PATIENT_ID between :b0 and :b1) and trun\
c(B.VISIT_REGN_DATE_TIME) between TO_DATE(N");
    sqlstm.stmt = sq0005;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )125;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_from_patient_id;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_to_patient_id;
    sqlstm.sqhstl[1] = (unsigned int  )23;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_from_date;
    sqlstm.sqhstl[2] = (unsigned int  )13;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_to_date;
    sqlstm.sqhstl[3] = (unsigned int  )13;
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
    sqlstm.sqhstv[5] = (         void  *)&nd_episode_type;
    sqlstm.sqhstl[5] = (unsigned int  )4;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_from_patient_id;
    sqlstm.sqhstl[6] = (unsigned int  )23;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_to_patient_id;
    sqlstm.sqhstl[7] = (unsigned int  )23;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_from_date;
    sqlstm.sqhstl[8] = (unsigned int  )13;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&nd_to_date;
    sqlstm.sqhstl[9] = (unsigned int  )13;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&nd_episode_type;
    sqlstm.sqhstl[10] = (unsigned int  )4;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&nd_episode_type;
    sqlstm.sqhstl[11] = (unsigned int  )4;
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
         err_mesg("OPEN failed on cursor BL_RECAL_CUR",0,"");
}


close_recal_cursor()
{
   /* EXEC SQL CLOSE BL_RECAL_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )188;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


 
}


fetch_recal_cursor()
{
  bl_patient_id.arr[0]		= '\0';
  bl_episode_id.arr[0]		= '\0';
  bl_visit_id.arr[0]		= '\0';
  nd_old_blng_grp.arr[0]	= '\0';
  nd_new_blng_grp.arr[0]	= '\0';
  bl_recalc_by.arr[0]		= '\0';
  bl_recalc_date.arr[0]		= '\0';
  nd_adm_date.arr[0]		= '\0';
  
  bl_patient_id.len		 	= 0;  
  bl_episode_id.len		 	= 0;  
  bl_visit_id.len		 	= 0;  
  nd_old_blng_grp.len    	= 0;  
  nd_new_blng_grp.len    	= 0;
  bl_recalc_by.len			= 0;  
  bl_recalc_date.len	 	= 0;  
  nd_adm_date.len		 	= 0;  

  nd_old_bill_amt = 0;
  nd_new_bill_amt = 0;

  /* EXEC SQL FETCH BL_RECAL_CUR
		INTO	:nd_adm_date,
				:bl_patient_id,
				:bl_episode_id,
				:bl_visit_id,	
				:nd_old_blng_grp,
				:nd_new_blng_grp,
				:nd_old_bill_amt,
				:nd_new_bill_amt,
				:bl_recalc_by,
				:bl_recalc_date; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 12;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )203;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&nd_adm_date;
  sqlstm.sqhstl[0] = (unsigned int  )13;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&bl_patient_id;
  sqlstm.sqhstl[1] = (unsigned int  )23;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&bl_episode_id;
  sqlstm.sqhstl[2] = (unsigned int  )11;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&bl_visit_id;
  sqlstm.sqhstl[3] = (unsigned int  )5;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_old_blng_grp;
  sqlstm.sqhstl[4] = (unsigned int  )7;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_new_blng_grp;
  sqlstm.sqhstl[5] = (unsigned int  )7;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_old_bill_amt;
  sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_new_bill_amt;
  sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&bl_recalc_by;
  sqlstm.sqhstl[8] = (unsigned int  )23;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&bl_recalc_date;
  sqlstm.sqhstl[9] = (unsigned int  )14;
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


				   
  if (LAST_ROW)
       return 0;

  bl_patient_id.arr[bl_patient_id.len] 		= '\0';
  bl_episode_id.arr[bl_episode_id.len] 		= '\0';
  bl_visit_id.arr[bl_visit_id.len] 			= '\0';
  nd_old_blng_grp.arr[nd_old_blng_grp.len] 	= '\0';
  nd_new_blng_grp.arr[nd_new_blng_grp.len] 	= '\0';  
  bl_recalc_by.arr[bl_recalc_by.len] 		= '\0';
  bl_recalc_date.arr[bl_recalc_date.len] 	= '\0';
  nd_adm_date.arr[nd_adm_date.len]			= '\0';

  
  return 1;    
}


print_rec()
{
  
     if (d_lctr > 42)
     print_head();

   get_patient_name();

  if(nd_episode_type.arr[0] == 'O' || nd_episode_type.arr[0] =='E' ) 
  {
 
 init_date_temp_var();                              
strcpy(date_convert.arr,nd_adm_date.arr);         
fun_change_loc_date();  
    
	 
  fprintf(f2,"%-10s %-20.20s %-30s %10s/%-3s %-4s %-4s %15.2f %15.2f %-12s %-20s \n",
           date_convert.arr,
	       bl_patient_id.arr,
		   nd_patient_name.arr,
	       bl_episode_id.arr,
           bl_visit_id.arr,
           nd_old_blng_grp.arr,
           nd_new_blng_grp.arr,
		   nd_old_bill_amt,
		   nd_new_bill_amt,
	       bl_recalc_date.arr,
		   bl_recalc_by.arr);
}

   if(nd_episode_type.arr[0] == 'I' || nd_episode_type.arr[0] == 'D') 
  
 { 
    
  
  init_date_temp_var();                              
strcpy(date_convert.arr,nd_adm_date.arr);         
fun_change_loc_date();     
 
  fprintf(f2,"%-10s %-20.20s %-30s %10s %-4s %-4s   %15.2f %15.2f %-12s %-20s \n",
           date_convert.arr,
	       bl_patient_id.arr,
		   nd_patient_name.arr,
	       bl_episode_id.arr,
           nd_old_blng_grp.arr,
           nd_new_blng_grp.arr,
		   nd_old_bill_amt,
		   nd_new_bill_amt,
	       bl_recalc_date.arr,
		   bl_recalc_by.arr);
		   }

  d_lctr++;
  prt_ctr++;
 }
  
print_tot()
{
   if (d_lctr > 42)
     print_head();

   if(nd_episode_type.arr[0] == 'O' || nd_episode_type.arr[0] == 'E') 
   //fprintf(f2," \n\nTotal Number of Visits : %-6d \n",prt_ctr);
     fprintf(f2," \n\n%s : %-6d \n",loc_legend[126],prt_ctr);
   else
   //fprintf(f2," \n\nTotal Number of Episode : %-6d \n",prt_ctr);
     fprintf(f2," \n\n%s : %-6d \n",loc_legend[127],prt_ctr);
   d_lctr++;
	       
}

open_file()
{
char filename[30];

 	strcpy(filename,WORKING_DIR);
	strcat(filename,"BLRLM006.lis");

    if ((f2 = fopen(filename,"w")) == NULL) 
     {
       disp_message(ERR_MESG,"Error in opening file BLRLM006.lis");
       proc_exit();
      }
 }


print_head()
{ 
    fprintf(f2,"");
    prt_head(f2,&d_pctr);
    if(nd_episode_type.arr[0] == 'I' || nd_episode_type.arr[0] == 'D')
	{
	//fprintf(f2,"Admission  Patient    Name                             Episode     Old   New         Old             New    Recalculated Recalculated \n");
	  fprintf(f2,"%s  %-20s %-30s     %s   %s   %s            %s             %s %s %s\n",loc_legend[106],loc_legend[107],loc_legend[129],loc_legend[108],loc_legend[109],loc_legend[110],loc_legend[109],loc_legend[110],loc_legend[111],loc_legend[111]);
	  //fprintf(f2,"Date       No                                          No          Blng  Blng        Bill            Bill   Date         By           \n");            
	    fprintf(f2,"%s       %s %55s        %s  %s          %s            %s   %s         %s           \n",loc_legend[112],loc_legend[113],loc_legend[113],loc_legend[114],loc_legend[114],loc_legend[115],loc_legend[115],loc_legend[112],loc_legend[116]);            
        //fprintf(f2,"                                                                   Group Group       Amount          Amount                             \n");  
		  fprintf(f2,"%82s %s       %s          %s                             \n",loc_legend[117],loc_legend[117],loc_legend[118],loc_legend[118]);   
	}
    if(nd_episode_type.arr[0] == 'O' || nd_episode_type.arr[0] == 'E')
	{
	//fprintf(f2,"Visit      Patient    Name                             Episode/    Old   New          Old             New    Recalculated Recalculated \n");
	  
	  fprintf(f2,"%s       %-20s %-30s  %s   %s   %s            %s             %s     %s %s\n",loc_legend[119],loc_legend[107],loc_legend[129],loc_legend[120],loc_legend[109],loc_legend[110],loc_legend[109],loc_legend[110],loc_legend[111],loc_legend[111]);
	
	//fprintf(f2,"Regn       No                                          Visit       Blng  Blng         Bill            Bill   Date         By           \n");  
		  fprintf(f2,"%s        %s %55s      %s  %s           %s            %s    %s         %s           \n",loc_legend[121],loc_legend[113],loc_legend[119],loc_legend[114],loc_legend[114],loc_legend[115],loc_legend[115],loc_legend[112],loc_legend[116]);                    
    
	//fprintf(f2,"Date                                                   No          Group Group        Amount          Amount                              \n");  
	fprintf(f2,"%s %62s         %s %s          %s          %s                              \n",loc_legend[112],loc_legend[113],loc_legend[117],loc_legend[117],loc_legend[118],loc_legend[118]);  
	}

    fprintf(f2,"%s\n",hdr_line4);
	d_lctr = 10;
  
}

print_head1()
{ 
    prt_head(f2,&d_pctr);
	
  
}


prt_head(fp,pctr)
//FILE *fp;
int *pctr;
{

    form_hdr(&pctr);

    fprintf(f2,"%c&l1O",ESC);   /* This will make the orientation as landscape */
    fprintf(f2,"%c&k4S",ESC); /* This makes the font size to increase to 2 */

    fprintf(f2,"%s\n",hdr_line1);
    fprintf(f2,"%s\n",hdr_line2);
    fprintf(f2,"%s\n",hdr_line3);
    fprintf(f2,"%s\n",hdr_line4);
 

fflush(f2);

}

fetch_hosp_name()
{
    hosp_name.arr[0] = '\0';
    date_time.arr[0] = '\0';
    user_id.arr[0]   = '\0';
    hosp_name.len    = 0;
    date_time.len    = 0;
    user_id.len      = 0;

    /*EXEC SQL SELECT ACC_ENTITY_NAME, TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
                    USER
               INTO :hosp_name, :date_time, :user_id
               FROM SY_ACC_ENTITY;*/

	/* EXEC SQL SELECT ACC_ENTITY_NAME, TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
                    USER
               INTO :hosp_name, :date_time, :user_id
               FROM SY_ACC_ENTITY_LANG_VW
			   WHERE ACC_ENTITY_ID  = :nd_facility_id
			   AND language_id=:p_language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 12;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'\
) ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY_LANG_VW where (ACC_ENTITY_ID=:b3 \
and language_id=:b4)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )258;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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
 sqlstm.sqhstl[2] = (unsigned int  )42;
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
 sqlstm.sqhstv[4] = (         void  *)&p_language_id;
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


;

       if (OERROR) err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");

hosp_name.arr[hosp_name.len]           = '\0';
date_time.arr[date_time.len]           = '\0';
user_id.arr[user_id.len]               = '\0';
}



form_hdr(page_no)
int **page_no;
{

    static int first = 1;
    char buf[15];
    int col;
    	
    if(first) {
        memset(hdr_line1,' ',REP_WIDTH+1);
        memset(hdr_line2,' ',REP_WIDTH+1);
		memset(hdr_line4,'-',REP_WIDTH);
		hdr_line4[REP_WIDTH] = '\0';

        //strncpy(hdr_line1,"MDL : BL",8);
		  strncpy(hdr_line1,loc_legend[122],strlen(loc_legend[122]));
        col = (int)(REP_WIDTH-strlen(hosp_name.arr))/2;
        strncpy(hdr_line1+col,hosp_name.arr,strlen(hosp_name.arr));
         
		col = (REP_WIDTH-strlen(date_time.arr));
		
		init_date_temp_var();                              
        strcpy(date_convert.arr,date_time.arr);         
        fun_change_loc_date(); 

        strcpy(hdr_line1+col,date_convert.arr);
    
        //strncpy(hdr_line2,"OPR :",5);
		  strncpy(hdr_line2,loc_legend[123],strlen(loc_legend[123]));
        strcpy(hdr_line2+6,user_id.arr);

	first = 0;
    }

    memset(hdr_line3,' ',REP_WIDTH+1);

    //strncpy(hdr_line3,"REP : BLRLM006",14);
	  strncpy(hdr_line3,loc_legend[124],strlen(loc_legend[124]));
    col = (int)(REP_WIDTH-strlen(rep_title))/2;
    strncpy(hdr_line3+col,rep_title,strlen(rep_title));
    sprintf(buf,"%s %4d",loc_legend[125],++*(*page_no));
    strcpy(hdr_line3+(REP_WIDTH-strlen(buf)),buf);


}


sql_connect()
{
  /* EXEC SQL CONNECT :uid_pwd; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 12;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )293;
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



  if (sqlca.sqlcode < 0)
      return(-1);
  return(0);
}

end_of_rep()
{

      if (s_lctr > 48)
         print_head();

	fprintf(f2,"\n\n                                                     ***  %s ***\n",loc_legend[128]);

}

get_user_name()
{
 nd_user_name.arr[0] = '\0';
 nd_user_name.len    = 0;

 /* EXEC SQL SELECT USERNAME 
        INTO :nd_user_name
	    FROM SY_USER
	    WHERE USER_ID = :nd_user_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 12;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select USERNAME into :b0  from SY_USER where USER_ID=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )324;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_user_name;
 sqlstm.sqhstl[0] = (unsigned int  )33;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_user_id;
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
        err_mesg("SELECT failed on table SY_USER",0,"");

 nd_user_name.arr[nd_user_name.len] = '\0';		    


 if (NOT_FOUND)
        err_mesg("No Record found in SY_USER",0,"");

 
}

get_patient_name()
{

 nd_patient_name.arr[0] = '\0';

 nd_patient_name.len    = 0;

 /*EXEC SQL SELECT short_name
		  INTO  :nd_patient_name
          FROM MP_PATIENT_MAST
          WHERE PATIENT_ID = :bl_patient_id;*/

  /* EXEC SQL SELECT decode(:p_language_id,'en', substr(short_name,1,60),substr(SHORT_NAME_LOC_LANG,1,60))
		  INTO  :nd_patient_name
          FROM MP_PATIENT_MAST
          WHERE PATIENT_ID = :bl_patient_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 12;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select decode(:b0,'en',substr(short_name,1,60),substr(SHORT\
_NAME_LOC_LANG,1,60)) into :b1  from MP_PATIENT_MAST where PATIENT_ID=:b2";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )347;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&p_language_id;
  sqlstm.sqhstl[0] = (unsigned int  )5;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_patient_name;
  sqlstm.sqhstl[1] = (unsigned int  )63;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&bl_patient_id;
  sqlstm.sqhstl[2] = (unsigned int  )23;
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
       disp_message(ERR_MESG,"SELECT failed on table MP_PATIENT_MAST");

 
 nd_patient_name.arr[nd_patient_name.len] = '\0';
 
 return;

}


print_rep_header()
{
  char from_pat_id[11],  to_pat_id[11];
  char from_date[10], to_date[10];
  

  if(strcmp(nd_from_patient_id.arr, "!!!!!!!!!!") == 0)
    //strcpy(from_pat_id, "Lowest");
	  strcpy(from_pat_id, loc_legend[104]);
    else strcpy(from_pat_id, nd_from_patient_id.arr);

  if(strcmp(nd_to_patient_id.arr, "~~~~~~~~~~") == 0)
    //strcpy(to_pat_id, "Highest");
	  strcpy(to_pat_id, loc_legend[105]);
    else strcpy(to_pat_id, nd_to_patient_id.arr);

  
  if(nd_from_date_flag.arr[0] == 'N')
    //strcpy(from_date, "Lowest");
	  strcpy(from_date, loc_legend[104]);
    else 
		init_date_temp_var();                              
		strcpy(date_convert.arr,nd_from_date.arr);         
		fun_change_loc_date(); 
    	strcpy(from_date,date_convert.arr);

  if(nd_to_date_flag.arr[0] == 'N')
    //strcpy(to_date, "Highest");
	  strcpy(to_date, loc_legend[105]);
    else
		init_date_temp_var();                              
		strcpy(date_convert.arr,nd_to_date.arr);         
		fun_change_loc_date(); 
		strcpy(to_date, date_convert.arr);

  
  print_head1();
  fprintf(f2,VER);
  fprintf(f2,"\n\n");
  fprintf(f2,"        ");
  //fprintf(f2,"INPUT PARAMETERS :\n");
  fprintf(f2,"%s\n",loc_legend[002]);
  fprintf(f2,"        ");
  fprintf(f2,"------------------\n\n");
  fprintf(f2,"                              ");
  //fprintf(f2,"EPISODE TYPE                : ");
  fprintf(f2,"%s                : ",loc_legend[003]);
  /*if (nd_episode_type.arr[0] == 'I')
   fprintf(f2,"Inpatient \n\n");
  else
  fprintf(f2,"Outpatient \n\n");*/

  if (nd_episode_type.arr[0] == 'I')
        fprintf(f2,"%s \n\n",loc_legend[004]);
	   else if (nd_episode_type.arr[0] == 'D')
		 fprintf(f2,"%s \n\n",loc_legend[005]);
	   else if  (nd_episode_type.arr[0] == 'E')
		 fprintf(f2,"%s \n\n",loc_legend[006]);
  else
   fprintf(f2,"%s \n\n",loc_legend[007]);

  fprintf(f2,"                              ");
  //fprintf(f2,"PATIENT ID     FROM         : %s\n", from_pat_id);
  fprintf(f2,"%s         : %s\n",loc_legend[100], from_pat_id);
  fprintf(f2,"                              ");
  //fprintf(f2,"               TO           : %s\n", to_pat_id);
    fprintf(f2,"               %s           : %s\n",loc_legend[101], to_pat_id);
  fprintf(f2,"\n");
  fprintf(f2,"                              ");

  if (nd_episode_type.arr[0] == 'I' || nd_episode_type.arr[0] == 'D')
    //fprintf(f2,"ADMISSION DATE FROM         : %s\n", from_date);
    
	
    fprintf(f2,"%s         : %s\n",loc_legend[102],from_date);

  else
 
  //fprintf(f2,"VISIT DATE     FROM         : %s\n", from_date);
    fprintf(f2,"%s         : %s\n",loc_legend[103], from_date); 
  fprintf(f2,"                              ");
  //fprintf(f2,"               TO           : %s\n", to_date);
    fprintf(f2,"               %s           : %s\n",loc_legend[101],to_date); 
  fprintf(f2,"\n");
  fprintf(f2,"                              ");
  fprintf(f2,"\n");

 }

fetch_legend_value()
{
	for(i=1;i<=900;i++)
	{
		l_pk_value.arr[0] = '\0';

	/* EXEC SQL SELECT LTRIM(RTRIM('BLRLM006.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		        INTO :l_pk_value
			   FROM dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 12;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select LTRIM(RTRIM(('BLRLM006.LEGEND_'||LTRIM(RTRIM(TO_CHAR(\
:b0,'009')))))) into :b1  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )374;
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
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 12;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility_id , 'S\
M' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_valu\
e , :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )397;
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
	}
}


get_local_date()
{

	
	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;
	
	BEGIN
	
	  
       	get_locale_date.CONVERT_TO_LOCALE_DATE(to_date(:nd_temp_date,'DD/MM/YYYY HH24:MI'),:p_language_id,t_date);  
      
	   :nd_loc_date := to_char(t_date,'DD/MM/YYYY');
	

	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 12;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . CONVERT_TO_LOC\
ALE_DATE ( to_date ( :nd_temp_date , 'DD/MM/YYYY HH24:MI' ) , :p_language_id ,\
 t_date ) ; :nd_loc_date := to_char ( t_date , 'DD/MM/YYYY' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )428;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_temp_date;
 sqlstm.sqhstl[0] = (unsigned int  )23;
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
 sqlstm.sqhstl[2] = (unsigned int  )23;
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


get_local_date();

strcpy(date_convert.arr,nd_loc_date.arr); 

}
