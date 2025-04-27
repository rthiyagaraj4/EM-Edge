
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/BLRLM002.PC"
};


static unsigned int sqlctx = 1288466283;


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
            void  *sqhstv[14];
   unsigned int   sqhstl[14];
            int   sqhsts[14];
            void  *sqindv[14];
            int   sqinds[14];
   unsigned int   sqharm[14];
   unsigned int   *sqharc[14];
   unsigned short  sqadto[14];
   unsigned short  sqtdso[14];
} sqlstm = {12,14};

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

 static const char *sq0004 = 
"ISIT A ,BL_VISIT_FIN_DTLS B ,BL_CLASSFCTN_CODE C where (((((((((((A.FACILITY\
_ID=B.OPERATING_FACILITY_ID and A.PATIENT_ID=B.PATIENT_ID) and B.OPERATING_FAC\
ILITY_ID=C.OPERATING_FACILITY_ID) and B.CLASSIFICATION_CODE=C.CLASSIFICATION_C\
ODE) and A.VISIT_REGN_DATE_TIME between TO_DATE(NVL(:b1,'01/01/1000'),'DD/MM/Y\
YYY') and TO_DATE(NVL(:b2,'01/01/3000'),'DD/MM/YYYY')) and A.EPISODE_ID=B.EPIS\
ODE_ID) and A.VISIT_ID=B.VISIT_ID) and NVL(A.VISIT_STATUS,'X')<>'9') and C.CLA\
SSIFICATION_TYPE='EX') and NVL(B.CLASSIFICATION_CODE,'!!!!!!') between NVL(:b3\
,'!!!!!!') and NVL(:b4,'~~~~~~')) and :b0 in ('O','E')) and A.episode_type=:b0\
) order by 2,3,1,4            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,1,0,0,30,204,0,0,0,0,0,1,0,
20,0,0,2,204,0,4,230,0,0,11,4,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
79,0,0,3,116,0,2,269,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
110,0,0,4,1676,0,9,361,0,0,14,14,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
181,0,0,4,0,0,15,369,0,0,0,0,0,1,0,
196,0,0,4,0,0,13,394,0,0,8,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,
243,0,0,5,165,0,4,569,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
278,0,0,0,0,0,27,634,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
309,0,0,7,132,0,4,687,0,0,3,2,0,1,0,1,9,0,0,2,9,0,0,1,9,0,0,
336,0,0,8,78,0,4,711,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
363,0,0,9,96,0,4,734,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
390,0,0,10,142,0,4,757,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
421,0,0,11,96,0,4,892,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
444,0,0,12,165,0,6,899,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
475,0,0,13,207,0,6,921,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.0                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLRLM002.PC                                  */
/* AUTHOR                :					                            */
/* DATE WRITTEN          : 22-MAR-2004                                  */
/*                                                                      */
/* CALLED FROM           :                                              */
/*                                                                      */
/*  FUNCTION             :                                              */
/*                                                                      */
/*  TABLE DETAILS                                                       */
/*                                                                      */
/*        S. No.       TABLENAMES             INPUT/OUTPUT              */
/*                                                                      */
/*                                                                      */
/*  PARAMETERS           :            -                                 */
/*                                                                      */
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
#define REP_WIDTH 175
#define VER  "VER : 10.03\n"



/* EXEC SQL BEGIN DECLARE SECTION; */ 


    /* VARCHAR hosp_name                                  [120],
            uid_pwd                                    [132],
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

struct { unsigned short len; unsigned char arr[132]; } uid_pwd;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[40]; } user_id;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[21]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[21]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[21]; } date_convert;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;


   

   /* VARCHAR	bl_patient_id                 [21],
            nd_patient_name				  [25],
			epi_type			               [2],
			bl_episode_id                 [13],
			bl_visit_id                   [7],
			bl_reason_code                [3],
			nd_blng_grp					  [5],
			nd_blng_desc                [12],
			nd_user_id                    [21],
			nd_user_name                  [81],
			bl_recal_ind				  [2],
			nd_clinic_code				  [5],
			l_pk_value	[100],
			nd_episode_type			[2],
        nd_from_patient_id		[21],
        nd_to_patient_id		[21],
	    nd_from_date			[17],
	    nd_to_date				[17],
		nd_adm_date				[17],
		nd_exemp_code			[7],
		nd_exemp_desc			[12],
		nd_from_date_flag		[2],
		nd_to_date_flag			[2],
		nd_from_exemp_code		[17],
	    nd_to_exemp_code		[17],
		bl_added_by				[31],
        nd_facility_id   [3],
		l_translated_value	        [201],
		nd_added_name			[31]; */ 
struct { unsigned short len; unsigned char arr[21]; } bl_patient_id;

struct { unsigned short len; unsigned char arr[25]; } nd_patient_name;

struct { unsigned short len; unsigned char arr[2]; } epi_type;

struct { unsigned short len; unsigned char arr[13]; } bl_episode_id;

struct { unsigned short len; unsigned char arr[7]; } bl_visit_id;

struct { unsigned short len; unsigned char arr[3]; } bl_reason_code;

struct { unsigned short len; unsigned char arr[5]; } nd_blng_grp;

struct { unsigned short len; unsigned char arr[12]; } nd_blng_desc;

struct { unsigned short len; unsigned char arr[21]; } nd_user_id;

struct { unsigned short len; unsigned char arr[81]; } nd_user_name;

struct { unsigned short len; unsigned char arr[2]; } bl_recal_ind;

struct { unsigned short len; unsigned char arr[5]; } nd_clinic_code;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[2]; } nd_episode_type;

struct { unsigned short len; unsigned char arr[21]; } nd_from_patient_id;

struct { unsigned short len; unsigned char arr[21]; } nd_to_patient_id;

struct { unsigned short len; unsigned char arr[17]; } nd_from_date;

struct { unsigned short len; unsigned char arr[17]; } nd_to_date;

struct { unsigned short len; unsigned char arr[17]; } nd_adm_date;

struct { unsigned short len; unsigned char arr[7]; } nd_exemp_code;

struct { unsigned short len; unsigned char arr[12]; } nd_exemp_desc;

struct { unsigned short len; unsigned char arr[2]; } nd_from_date_flag;

struct { unsigned short len; unsigned char arr[2]; } nd_to_date_flag;

struct { unsigned short len; unsigned char arr[17]; } nd_from_exemp_code;

struct { unsigned short len; unsigned char arr[17]; } nd_to_exemp_code;

struct { unsigned short len; unsigned char arr[31]; } bl_added_by;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[31]; } nd_added_name;


   int		prt_ctr = 0,first = 1;
   int i;
   char loc_legend[999][201]; 
   char   rep_title[50],string_var[200];
      
  
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
int inp_ctr = 1;
int op_ctr  = 1;
int ip_prt = 0;
int op_prt = 0;
int pctr = 0;

FILE *f2;

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
	

    if (argc < 6)
    {
     int i = 0;
       disp_message(ERR_MESG,"Not enough Parameters for running this program");
       proc_exit();
    }

	strcpy(uid_pwd.arr,argv[1]);
      uid_pwd.len = strlen(uid_pwd.arr);
 
      strcpy(g_pgm_id,"BLRLM002");


  if(sql_connect() == -1)
   {
      disp_message(ERR_MESG,"Error in connecting to Oracle");
      if (uid_pwd.len == 0)
         disp_message(ERR_MESG,"Null oracle uid/pwd");
      proc_exit();
   } 


	set_meduser_role();

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
    
 	//strcpy(OUTPUT_FILE_NAME, argv[5]);
   
    fetch_prog_param();
		fetch_legend_value();

    //strcpy(rep_title,"List of Visits/Admissions with Exemption");
	//strcpy(rep_title,"List of Exempted Encounters");
	strcpy(rep_title,loc_legend[001]);
       
    declare_exemp_cur();

    fetch_hosp_name();

    open_file();
     
    open_exemp_cursor(); 

	print_rep_header();

	print_head();

	prt_ctr = 0; 

	
      while(fetch_exemp_cursor())
        {
        print_rec();
        } 
    print_tot();
 
    close_exemp_cursor();     
    
    end_of_rep();
    
    fclose(f2);

    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 0;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )5;
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
   nd_from_date.arr[0]			='\0';
   nd_to_date.arr[0]			='\0';
   nd_episode_type.arr[0]		='\0';
   nd_from_date_flag.arr[0]		='\0';
   nd_to_date_flag.arr[0]		='\0';
   nd_from_exemp_code.arr[0]	='\0';
   nd_to_exemp_code.arr[0]		='\0';
   
   nd_from_date.len				=0;
   nd_to_date.len				=0;
   nd_episode_type.len			=0;
   nd_from_date_flag.len		=0;
   nd_to_date_flag.len			=0;
   nd_from_exemp_code.len		=0;
   nd_to_exemp_code.len			=0;
   
   /* EXEC SQL SELECT PARAM1,
		   PARAM2,
		   PARAM3,
		   PARAM4,
		   PARAM5,
		   PARAM6,
		   PARAM7
		    INTO 
			:nd_episode_type,
            :nd_from_date,
            :nd_to_date,
			:nd_from_date_flag,
			:nd_to_date_flag,
			:nd_from_exemp_code,
			:nd_to_exemp_code
              FROM SY_PROG_PARAM
             WHERE OPERATING_FACILITY_ID  = :nd_facility_id 
			   AND PGM_ID     = :d_curr_pgm_name
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 ,PARAM5 ,PARAM6 ,PAR\
AM7 into :b0,:b1,:b2,:b3,:b4,:b5,:b6  from SY_PROG_PARAM where (((OPERATING_FA\
CILITY_ID=:b7 and PGM_ID=:b8) and SESSION_ID=:b9) and PGM_DATE=:b10)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )20;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_episode_type;
   sqlstm.sqhstl[0] = (unsigned int  )4;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_from_date;
   sqlstm.sqhstl[1] = (unsigned int  )19;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_to_date;
   sqlstm.sqhstl[2] = (unsigned int  )19;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_from_date_flag;
   sqlstm.sqhstl[3] = (unsigned int  )4;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_to_date_flag;
   sqlstm.sqhstl[4] = (unsigned int  )4;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_from_exemp_code;
   sqlstm.sqhstl[5] = (unsigned int  )19;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_to_exemp_code;
   sqlstm.sqhstl[6] = (unsigned int  )19;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_facility_id;
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

   nd_from_date.arr[nd_from_date.len]				='\0';
   nd_to_date.arr[nd_to_date.len]					='\0';
   nd_episode_type.arr[nd_episode_type.len]			='\0';
   nd_from_date_flag.arr[nd_from_date_flag.len]		='\0';
   nd_to_date_flag.arr[nd_to_date_flag.len]			='\0';
   nd_from_exemp_code.arr[nd_from_exemp_code.len]				='\0';
   nd_to_exemp_code.arr[nd_to_exemp_code.len]					='\0';
   
   if (NOT_FOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");



   
  
   /* EXEC SQL DELETE SY_PROG_PARAM
             WHERE OPERATING_FACILITY_ID = :nd_facility_id 
			   AND PGM_ID     = :d_curr_pgm_name
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where (((OPERATING_FACILITY_ID\
=:b0 and PGM_ID=:b1) and SESSION_ID=:b2) and PGM_DATE=:b3)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )79;
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
   sqlstm.sqhstv[1] = (         void  *)&d_curr_pgm_name;
   sqlstm.sqhstl[1] = (unsigned int  )17;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[2] = (unsigned int  )18;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[3] = (unsigned int  )27;
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
         err_mesg("DELETE failed on table SY_PROG_PARAM",0,"");
   
}

declare_exemp_cur()
{
    /* EXEC SQL DECLARE BL_EXEMP_CUR CURSOR FOR
		SELECT DECODE(:nd_episode_type,'I','I','D','D') EP_TYPE,to_char(A.ADMISSION_DATE_TIME,'DD/MM/YYYY HH24:MI') ADM_DATE,
						  A.PATIENT_ID,A.EPISODE_ID,0 VISIT_ID, 
                          B.BLNG_GRP_ID, B.CLASSIFICATION_CODE,
						  A.ADDED_BY_ID
                   FROM IP_EPISODE A,BL_EPISODE_FIN_DTLS B, BL_CLASSFCTN_CODE C 
                   WHERE  A.FACILITY_ID = B.OPERATING_FACILITY_ID
				   AND   A.PATIENT_ID=B.PATIENT_ID
				   AND   B.OPERATING_FACILITY_ID = C.OPERATING_FACILITY_ID
				   AND   B.CLASSIFICATION_CODE = C.CLASSIFICATION_CODE
				   AND   A.ADMISSION_DATE_TIME BETWEEN TO_DATE(NVL(:nd_from_date,'01/01/1000'),'DD/MM/YYYY')
		                 AND TO_DATE(NVL(:nd_to_date,'01/01/3000'),'DD/MM/YYYY')
				   AND   A.EPISODE_ID=B.EPISODE_ID
				   AND   C.CLASSIFICATION_TYPE = 'EX'
				   AND   NVL(B.CLASSIFICATION_CODE,'!!!!!!') BETWEEN NVL(:nd_from_exemp_code,'!!!!!!')	AND NVL(:nd_to_exemp_code,'~~~~~~')
				   AND   NVL(A.EPISODE_STATUS,'X') != '9'
				   --AND   DECODE(:nd_episode_type,'B','I','I','I')='I' 
				   AND  :nd_episode_type IN('I','D')  
				   AND     A.episode_type=:nd_episode_type
				   UNION
	    SELECT DECODE(:nd_episode_type,'O','O','E','E') EP_TYPE,to_char(A.VISIT_REGN_DATE_TIME,'DD/MM/YYYY HH24:MI') ADM_DATE,
		                  A.PATIENT_ID,A.EPISODE_ID,A.VISIT_ID, 
                          B.BLNG_GRP_ID, B.CLASSIFICATION_CODE,
						  A.ADDED_BY_ID
                   FROM OP_VISIT A,BL_VISIT_FIN_DTLS B, BL_CLASSFCTN_CODE C
                   WHERE A.FACILITY_ID = B.OPERATING_FACILITY_ID
				   AND   A.PATIENT_ID=B.PATIENT_ID
				   AND   B.OPERATING_FACILITY_ID = C.OPERATING_FACILITY_ID
				   AND   B.CLASSIFICATION_CODE = C.CLASSIFICATION_CODE
				   AND  A.VISIT_REGN_DATE_TIME BETWEEN TO_DATE(NVL(:nd_from_date,'01/01/1000'),'DD/MM/YYYY')
						AND TO_DATE(NVL(:nd_to_date,'01/01/3000'),'DD/MM/YYYY')
				   AND  A.EPISODE_ID=B.EPISODE_ID
				   AND  A.VISIT_ID  = B.VISIT_ID
				   AND  NVL(A.VISIT_STATUS,'X') != '9'
				   AND  C.CLASSIFICATION_TYPE = 'EX'
				   AND   NVL(B.CLASSIFICATION_CODE,'!!!!!!') BETWEEN NVL(:nd_from_exemp_code,'!!!!!!')	AND NVL(:nd_to_exemp_code,'~~~~~~')
				   --AND  DECODE(:nd_episode_type,'B','O','O','O')='O'
				   AND  :nd_episode_type IN('O','E')
				   AND   A.episode_type=:nd_episode_type
				   ORDER BY 2,3,1,4; */ 

				   
/*
		SELECT 'I' EP_TYPE,to_char(A.ADMISSION_DATE_TIME,'DD/MM/YYYY HH24:MI') ADM_DATE,
						  A.PATIENT_ID,A.EPISODE_ID,0 VISIT_ID, 
                          B.BLNG_GRP_ID, A.EXEMPTION_CODE,
						  A.ADDED_BY_ID
                   FROM IP_EPISODE A,BL_EPISODE_FIN_DTLS B 
                   WHERE A.PATIENT_ID=B.PATIENT_ID
				   AND   A.ADMISSION_DATE_TIME BETWEEN TO_DATE(NVL(:nd_from_date,'01/01/1000 00:00'),'DD/MM/YYYY HH24:MI')
		                 AND TO_DATE(NVL(:nd_to_date,'01/01/3000 23:59'),'DD/MM/YYYY HH24:MI')
				   AND   A.EPISODE_ID=B.EPISODE_ID
				   AND   NVL(A.EXEMPTION_YN,'N')='Y'
				   AND   NVL(A.EXEMPTION_CODE,'!!!!') BETWEEN NVL(:nd_from_exemp_code,'!!!!!!')	AND NVL(:nd_to_exemp_code,'~~~~~~')
				   AND   NVL(A.EPISODE_STATUS,'X') != '9'
				   AND   DECODE(:nd_episode_type,'B','I','I','I')='I' 
				   UNION
	    SELECT 'O' EP_TYPE,to_char(A.VISIT_REGN_DATE_TIME,'DD/MM/YYYY HH24:MI') ADM_DATE,
		                  A.PATIENT_ID,A.EPISODE_ID,A.VISIT_ID, 
                          B.BLNG_GRP_ID, A.EXEMPTION_CODE,
						  A.ADDED_BY_ID
                   FROM OP_VISIT A,BL_VISIT_FIN_DTLS B
                   WHERE A.PATIENT_ID=B.PATIENT_ID
				   AND  a.VISIT_REGN_DATE_TIME BETWEEN TO_DATE(NVL(:nd_from_date,'01/01/1000 00:00'),'DD/MM/YYYY HH24:MI')
						AND TO_DATE(NVL(:nd_to_date,'01/01/3000 23:59'),'DD/MM/YYYY HH24:MI')
				   AND  A.EPISODE_ID=B.EPISODE_ID
				   AND  A.VISIT_ID  = B.VISIT_ID
				   AND  NVL(A.VISIT_STATUS,'X') != '9'
				   AND  NVL(A.EXEMPTION_YN,'N')='Y'
				   AND   NVL(A.EXEMPTION_CODE,'!!!!') BETWEEN NVL(:nd_from_exemp_code,'!!!!!!')	AND NVL(:nd_to_exemp_code,'~~~~~~')
				   AND  DECODE(:nd_episode_type,'B','O','O','O')='O'
				   ORDER BY 2,3,1,4;
*/		  
	

}


open_exemp_cursor()
{
    /* EXEC SQL OPEN BL_EXEMP_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 14;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlbuft((void **)0, 
      "select DECODE(:b0,'I','I','D','D') EP_TYPE ,to_char(A.ADMISSION_DATE_\
TIME,'DD/MM/YYYY HH24:MI') ADM_DATE ,A.PATIENT_ID ,A.EPISODE_ID ,0 VISIT_ID \
,B.BLNG_GRP_ID ,B.CLASSIFICATION_CODE ,A.ADDED_BY_ID  from IP_EPISODE A ,BL_\
EPISODE_FIN_DTLS B ,BL_CLASSFCTN_CODE C where ((((((((((A.FACILITY_ID=B.OPER\
ATING_FACILITY_ID and A.PATIENT_ID=B.PATIENT_ID) and B.OPERATING_FACILITY_ID\
=C.OPERATING_FACILITY_ID) and B.CLASSIFICATION_CODE=C.CLASSIFICATION_CODE) a\
nd A.ADMISSION_DATE_TIME between TO_DATE(NVL(:b1,'01/01/1000'),'DD/MM/YYYY')\
 and TO_DATE(NVL(:b2,'01/01/3000'),'DD/MM/YYYY')) and A.EPISODE_ID=B.EPISODE\
_ID) and C.CLASSIFICATION_TYPE='EX') and NVL(B.CLASSIFICATION_CODE,'!!!!!!')\
 between NVL(:b3,'!!!!!!') and NVL(:b4,'~~~~~~')) and NVL(A.EPISODE_STATUS,'\
X')<>'9') and :b0 in ('I','D')) and A.episode_type=:b0) union select DECODE(\
:b0,'O','O','E','E') EP_TYPE ,to_char(A.VISIT_REGN_DATE_TIME,'DD/MM/YYYY HH2\
4:MI') ADM_DATE ,A.PATIENT_ID ,A.EPISODE_ID ,A.VISIT_ID ,B.BLNG_GRP_ID ,B.CL\
ASSIFICATION_CODE ,A.ADDED_BY_ID  from OP_V");
    sqlstm.stmt = sq0004;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )110;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_episode_type;
    sqlstm.sqhstl[0] = (unsigned int  )4;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_from_date;
    sqlstm.sqhstl[1] = (unsigned int  )19;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_to_date;
    sqlstm.sqhstl[2] = (unsigned int  )19;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_from_exemp_code;
    sqlstm.sqhstl[3] = (unsigned int  )19;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_to_exemp_code;
    sqlstm.sqhstl[4] = (unsigned int  )19;
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
    sqlstm.sqhstv[6] = (         void  *)&nd_episode_type;
    sqlstm.sqhstl[6] = (unsigned int  )4;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_episode_type;
    sqlstm.sqhstl[7] = (unsigned int  )4;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_from_date;
    sqlstm.sqhstl[8] = (unsigned int  )19;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&nd_to_date;
    sqlstm.sqhstl[9] = (unsigned int  )19;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&nd_from_exemp_code;
    sqlstm.sqhstl[10] = (unsigned int  )19;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&nd_to_exemp_code;
    sqlstm.sqhstl[11] = (unsigned int  )19;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&nd_episode_type;
    sqlstm.sqhstl[12] = (unsigned int  )4;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&nd_episode_type;
    sqlstm.sqhstl[13] = (unsigned int  )4;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
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
         err_mesg("OPEN failed on cursor BL_EXEMP_CUR",0,"");
}


close_exemp_cursor()
{
   /* EXEC SQL CLOSE BL_EXEMP_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )181;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


 
}


fetch_exemp_cursor()
{
  epi_type.arr[0]			= '\0';
  bl_patient_id.arr[0]		= '\0';
  bl_episode_id.arr[0]		= '\0';
  bl_visit_id.arr[0]		= '\0';
  nd_blng_grp.arr[0]		= '\0';
  nd_exemp_code.arr[0]		= '\0';
  nd_adm_date.arr[0]		= '\0';
  bl_added_by.arr[0]		= '\0';

  epi_type.len			 	= 0;  
  bl_patient_id.len		 	= 0;  
  bl_episode_id.len		 	= 0;  
  bl_visit_id.len		 	= 0;  
  nd_blng_grp.len		 	= 0;
  nd_exemp_code.len			= 0;  
  nd_adm_date.len		 	= 0;  
  bl_added_by.len		 	= 0;  	

  /* EXEC SQL FETCH BL_EXEMP_CUR
		INTO	:epi_type,
		        :nd_adm_date,
				:bl_patient_id,
				:bl_episode_id,
				:bl_visit_id,	
				:nd_blng_grp,
				:nd_exemp_code,
				:bl_added_by; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )196;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&epi_type;
  sqlstm.sqhstl[0] = (unsigned int  )4;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_adm_date;
  sqlstm.sqhstl[1] = (unsigned int  )19;
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
  sqlstm.sqhstv[3] = (         void  *)&bl_episode_id;
  sqlstm.sqhstl[3] = (unsigned int  )15;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&bl_visit_id;
  sqlstm.sqhstl[4] = (unsigned int  )9;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_blng_grp;
  sqlstm.sqhstl[5] = (unsigned int  )7;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_exemp_code;
  sqlstm.sqhstl[6] = (unsigned int  )9;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&bl_added_by;
  sqlstm.sqhstl[7] = (unsigned int  )33;
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
         err_mesg("Fetch failed on cursor BL_EXEMP_CUR",0,"");
				   
  if (LAST_ROW)
       return 0;
  
  /*sprintf(string_var,"%s %s %s %s",bl_patient_id.arr,bl_episode_id.arr,bl_visit_id.arr,nd_blng_grp.arr);
  disp_message(ERR_MESG,string_var);*/
  epi_type.arr[epi_type.len]					= '\0';
  nd_adm_date.arr[nd_adm_date.len]			= '\0';
  bl_patient_id.arr[bl_patient_id.len] 		= '\0';
  bl_episode_id.arr[bl_episode_id.len] 		= '\0';
  bl_visit_id.arr[bl_visit_id.len] 			= '\0';
  nd_blng_grp.arr[nd_blng_grp.len] 			= '\0';  
  nd_exemp_code.arr[nd_exemp_code.len] 		= '\0';
  bl_added_by.arr[bl_added_by.len] 			= '\0';


  return 1;    
}


print_rec()
{
   if (d_lctr  > 42)
     print_head();

   get_patient_name();
   get_blng_desc();
   get_exemp_desc();
   get_user_name();

  if(epi_type.arr[0] == 'O' || epi_type.arr[0] == 'E')
     {

	  init_date_temp_var();                              
strcpy(date_convert.arr,nd_adm_date.arr);         
fun_change_loc_date();  
  fprintf(f2,"%-17s %-20.20s %-30s %-8s  %3s  %-4s %-15s  %-4s %-15s  %-20s %-30s\n",
           date_convert.arr,
	       bl_patient_id.arr,
		   nd_patient_name.arr,
		   bl_episode_id.arr,
           bl_visit_id.arr,
           nd_blng_grp.arr,
		   nd_blng_desc.arr,
	       nd_exemp_code.arr,
		   nd_exemp_desc.arr,
		   bl_added_by.arr,
		   nd_user_name.arr);
   }
   if(epi_type.arr[0] == 'I' || epi_type.arr[0] == 'D')
   {

     	  init_date_temp_var();                              
strcpy(date_convert.arr,nd_adm_date.arr);         
fun_change_loc_date(); 

  fprintf(f2,"%-17s %-20.20s %-30s %-8s       %-4s %-15s  %-4s %-15s  %-20s %-30s\n",
           date_convert.arr,
	       bl_patient_id.arr,
		   nd_patient_name.arr,
		   bl_episode_id.arr,
           nd_blng_grp.arr,
    	   nd_blng_desc.arr,
	       nd_exemp_code.arr,
		   nd_exemp_desc.arr,
		   bl_added_by.arr,
		   nd_user_name.arr);

   }
  prt_ctr++;   
  d_lctr++;
 }
  
print_tot()
{
   if (d_lctr > 42)
     print_head();
   if (prt_ctr > 0)
   //fprintf(f2," \n\nTotal Number of Visits/Admissions : %-6d \n",prt_ctr);
     fprintf(f2," \n\n%s : %-6d \n",loc_legend[136],prt_ctr);
   d_lctr++;
	       
}


open_file()
{
char filename[30];

 	strcpy(filename,WORKING_DIR);
	strcat(filename,"BLRLM002.lis");

    if ((f2 = fopen(filename,"w")) == NULL) 
     {
       disp_message(ERR_MESG,"Error in opening file BLRLM002.lis");
       proc_exit();
      }
 }


print_head()
{ 
    fprintf(f2,"");
    prt_head(f2,&d_pctr);
    
	//fprintf(f2,"Visit/Admission   Patient No Name                          Episode Episode Visit  Billing Group/Desc  Exemption Code/Desc   Added by Id          Added by Name\n");
	  fprintf(f2,"%s   %-20.20s %-30s %s %4s  %s  %s   %s          %s\n",loc_legend[119],loc_legend[120],loc_legend[121],loc_legend[122],loc_legend[123],loc_legend[124],loc_legend[125],loc_legend[126],loc_legend[127]); 
    //fprintf(f2,"Date                                                       Type    No      No                                                                                 \n");           
	  fprintf(f2,"%s           %57s %8s                                                                                 \n",loc_legend[128],loc_legend[130],loc_legend[130]);           
	
    fprintf(f2,"%s\n",hdr_line4);
	inp_ctr = 1;
	op_ctr  = 1;
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
   // fprintf(f2,"%c&k2S",ESC); 
								/* This makes the font size to increase to 2 */

	fprintf(f2,"%c(s17H",ESC);
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

    /*EXEC SQL SELECT UPPER(ACC_ENTITY_NAME), TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
                    USER
               INTO :hosp_name, :date_time, :user_id
               FROM SY_ACC_ENTITY 
			   WHERE ACC_ENTITY_ID  = :nd_facility_id;*/

      /* EXEC SQL SELECT UPPER(ACC_ENTITY_NAME), TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
                    USER
               INTO :hosp_name, :date_time, :user_id
               FROM SY_ACC_ENTITY_LANG_VW 
			   WHERE ACC_ENTITY_ID  = :nd_facility_id
			   AND language_id=:p_language_id; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 12;
      sqlstm.arrsiz = 14;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "select UPPER(ACC_ENTITY_NAME) ,TO_CHAR(SYSDATE,'DD/MM/Y\
YYY HH24:MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY_LANG_VW where (ACC_EN\
TITY_ID=:b3 and language_id=:b4)";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )243;
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
		  strncpy(hdr_line1,loc_legend[133],strlen(loc_legend[133]));
        col = (int)(REP_WIDTH-strlen(hosp_name.arr))/2;
        strncpy(hdr_line1+col,hosp_name.arr,strlen(hosp_name.arr));
		
        col = (REP_WIDTH-strlen(date_time.arr));
         
	    init_date_temp_var();                              
        strcpy(date_convert.arr,date_time.arr);         
        fun_change_loc_date(); 

        strcpy(hdr_line1+col,date_convert.arr);
    
        //strncpy(hdr_line2,"OPR :",5);
		strncpy(hdr_line2,loc_legend[134],strlen(loc_legend[134]));
        strcpy(hdr_line2+6,user_id.arr);

	first = 0;
    }

    memset(hdr_line3,' ',REP_WIDTH+1);

    //strncpy(hdr_line3,"REP : BLRLM002",14);
	  strncpy(hdr_line3,loc_legend[135],strlen(loc_legend[135]));
    col = (int)(REP_WIDTH-strlen(rep_title))/2;
    strncpy(hdr_line3+col,rep_title,strlen(rep_title));
    sprintf(buf,"PAGE : %4d",++*(*page_no));
    strcpy(hdr_line3+(REP_WIDTH-strlen(buf)),buf);


}


sql_connect()
{
  /* EXEC SQL CONNECT :uid_pwd; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )278;
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



  if (sqlca.sqlcode < 0)
      return(-1);
  return(0);
}

end_of_rep()
{

      if (s_lctr > 48)
         print_head();

	//fprintf(f2,"\n\n                                                     ***  END OF REPORT ***\n");
	  fprintf(f2,"\n\n                                                     ***  %s ***\n",loc_legend[137]);

}

/*get_user_name()
{
 nd_added_name.arr[0] = '\0';
 nd_added_name.len    = 0;

 EXEC SQL SELECT USERNAME 
        INTO :nd_added_name
	    FROM SY_USER
	    WHERE FACILITY_ID  = :nd_facility_id 
		AND   USER_ID = :nd_added_by;

 if (OERROR)
        err_mesg("SELECT failed on table SY_USER",0,"");

 nd_added_name.arr[nd_added_name.len] = '\0';		    


 if (NOT_FOUND)
        err_mesg("No Record found in SY_USER",0,"");

 
}
*/
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
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select decode(:b0,'en',substr(short_name,1,60),substr(SHOR\
T_NAME_LOC_LANG,1,60)) into :b1  from MP_PATIENT_MAST where PATIENT_ID=:b2";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )309;
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
   sqlstm.sqhstl[1] = (unsigned int  )27;
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


get_user_name()
{
 nd_user_name.arr[0] = '\0';

 nd_user_name.len    = 0;

 /* EXEC SQL SELECT username
		  INTO  :nd_user_name
          FROM SY_USER
          WHERE USER_ID = :bl_added_by
		  AND FACILITY_ID = :nd_facility_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select username into :b0  from SY_USER where (USER_ID=:b1 an\
d FACILITY_ID=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )336;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_user_name;
 sqlstm.sqhstl[0] = (unsigned int  )83;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&bl_added_by;
 sqlstm.sqhstl[1] = (unsigned int  )33;
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
       disp_message(ERR_MESG,"SELECT failed on table SY_USER ");

 
 nd_user_name.arr[nd_user_name.len] = '\0';
 
 return;

}

get_blng_desc()
{

 nd_blng_desc.arr[0] = '\0';
 nd_blng_desc.len    = 0;

 /* EXEC SQL SELECT short_desc
		  INTO  :nd_blng_desc
          FROM BL_BLNG_GRP_LANG_VW
          WHERE blng_grp_id = :nd_blng_grp
		  AND LANGUAGE_ID=:p_language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select short_desc into :b0  from BL_BLNG_GRP_LANG_VW where (\
blng_grp_id=:b1 and LANGUAGE_ID=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )363;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_blng_desc;
 sqlstm.sqhstl[0] = (unsigned int  )14;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_blng_grp;
 sqlstm.sqhstl[1] = (unsigned int  )7;
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
       disp_message(ERR_MESG,"SELECT failed on table BL_BLNG_GRP");

 
 nd_blng_desc.arr[nd_blng_desc.len] = '\0';
 
 return;

}


get_exemp_desc()
{

 nd_exemp_desc.arr[0] = '\0';
 nd_exemp_desc.len    = 0;

 /* EXEC SQL SELECT short_desc
		  INTO  :nd_exemp_desc
          FROM BL_CLASSFCTN_CODE_LANG_VW
          WHERE OPERATING_FACILITY_ID  = :nd_facility_id
		  AND LANGUAGE_ID=:p_language_id
		  and CLASSIFICATION_CODE = :nd_exemp_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select short_desc into :b0  from BL_CLASSFCTN_CODE_LANG_VW w\
here ((OPERATING_FACILITY_ID=:b1 and LANGUAGE_ID=:b2) and CLASSIFICATION_CODE=\
:b3)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )390;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_exemp_desc;
 sqlstm.sqhstl[0] = (unsigned int  )14;
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
 sqlstm.sqhstv[2] = (         void  *)&p_language_id;
 sqlstm.sqhstl[2] = (unsigned int  )5;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_exemp_code;
 sqlstm.sqhstl[3] = (unsigned int  )9;
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
       disp_message(ERR_MESG,"SELECT failed on table BL_EXEMPTION_MST");

 
 nd_exemp_desc.arr[nd_exemp_desc.len] = '\0';
 
 return;

}

print_rep_header()
{
  char from_pat_id[21],  to_pat_id[21];
  char from_date[17], to_date[17];
  char from_exemp[17], to_exemp[17];

  if(strcmp(nd_from_patient_id.arr, "!!!!!!!!!!!!!!!!!!!!") == 0)
    //strcpy(from_pat_id, "Lowest");
	strcpy(from_pat_id, loc_legend[105]);
    else strcpy(from_pat_id, nd_from_patient_id.arr);

  if(strcmp(nd_to_patient_id.arr, "~~~~~~~~~~~~~~~~~~~~") == 0)
    //strcpy(to_pat_id, "Highest");
	strcpy(to_pat_id, loc_legend[106]);
    else
		strcpy(to_pat_id, nd_to_patient_id.arr);

  
  if(nd_from_date_flag.arr[0] == 'N')
    //strcpy(from_date, "Lowest");
		strcpy(from_date, loc_legend[105]);
    else 
		init_date_temp_var();                              
		strcpy(date_convert.arr,nd_from_date.arr);         
		fun_change_loc_date(); 
		strcpy(from_date,date_convert.arr);

  if(nd_to_date_flag.arr[0] == 'N')
    //strcpy(to_date, "Highest");
		strcpy(to_date, loc_legend[106]);
    else 
		init_date_temp_var();                              
		strcpy(date_convert.arr, nd_to_date.arr);         
		fun_change_loc_date(); 
		strcpy(to_date,date_convert.arr);

  if(nd_from_exemp_code.arr[0] == '\0')
    //strcpy(from_exemp, "Lowest");
	strcpy(from_exemp,loc_legend[105]);
    else strcpy(from_exemp, nd_from_exemp_code.arr);

  if(nd_to_exemp_code.arr[0] == '\0')
    //strcpy(to_exemp, "Highest");
	strcpy(to_exemp, loc_legend[106]);
    else strcpy(to_exemp, nd_to_exemp_code.arr);

  
  print_head1();
  fprintf(f2,VER);
  fprintf(f2,"\n\n");
  fprintf(f2,"        ");
  //fprintf(f2,"INPUT PARAMETERS :\n");
    fprintf(f2,"%s :\n",loc_legend[002]);
  fprintf(f2,"        ");
  fprintf(f2,"------------------\n\n");
  fprintf(f2,"                              ");
  //fprintf(f2,"EPISODE TYPE                : ");
    fprintf(f2,"%s                : ",loc_legend[003]); 
  /*if (nd_episode_type.arr[0] == 'I' || nd_episode_type.arr[0]=='D')
  fprintf(f2,"Inpatient \n\n");
  if (nd_episode_type.arr[0] == 'O' || nd_episode_type.arr[0]=='E')
  fprintf(f2,"Outpatient \n\n");
  if (nd_episode_type.arr[0] == 'B')
  fprintf(f2,"Both \n\n");*/

  if (nd_episode_type.arr[0] == 'I')
   
     fprintf(f2,"%s \n\n",loc_legend[004]);
	   else if (nd_episode_type.arr[0] == 'D')
	   fprintf(f2,"%s \n\n",loc_legend[005]);
	   else if (nd_episode_type.arr[0] == 'O') 
	   fprintf(f2,"%s \n\n",loc_legend[007]);
  else
      fprintf(f2,"%s \n\n",loc_legend[006]);   
  
    fprintf(f2,"                              ");
  if (nd_episode_type.arr[0] == 'I' || nd_episode_type.arr[0] == 'D')
  {
  //fprintf(f2,"ADMISSION DATE       FROM   : %s\n", from_date);
    fprintf(f2,"%s   : %s\n",loc_legend[102], from_date);
  fprintf(f2,"                              ");
  //fprintf(f2,"                     TO     : %s\n", to_date);
    fprintf(f2,"                     %s     : %s\n",loc_legend[101],to_date);
  }
  
  if (nd_episode_type.arr[0] == 'O' || nd_episode_type.arr[0] == 'E')
  {
  //fprintf(f2,"VISIT DATE           FROM   : %s\n", from_date);
    fprintf(f2,"%s   : %s\n",loc_legend[103], from_date);
  fprintf(f2,"                              ");
  //fprintf(f2,"                     TO     : %s\n", to_date);
    fprintf(f2,"                     %s     : %s\n", loc_legend[101],to_date);
  }

  if (nd_episode_type.arr[0] == 'B')
  {
  fprintf(f2,"ADMISSION/VISIT DATE FROM   : %s\n", from_date);
  fprintf(f2,"                              ");
  fprintf(f2,"                     TO     : %s\n", to_date);
  }
  fprintf(f2,"\n");

  fprintf(f2,"                              ");
  //fprintf(f2,"EXEMPTION CODE       FROM   : %s\n", from_exemp);
    fprintf(f2,"%s   : %s\n",loc_legend[104],from_exemp);
  fprintf(f2,"                              ");
  //fprintf(f2,"                     TO     : %s\n", to_exemp);
    fprintf(f2,"                     %s     : %s\n",loc_legend[101],to_exemp);
  fprintf(f2,"\n");

 }

fetch_legend_value()
{
	for(i=1;i<=900;i++)
	{
		l_pk_value.arr[0] = '\0';

	/* EXEC SQL SELECT LTRIM(RTRIM('BLRLM002.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		        INTO :l_pk_value
			   FROM dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select LTRIM(RTRIM(('BLRLM002.LEGEND_'||LTRIM(RTRIM(TO_CHAR(\
:b0,'009')))))) into :b1  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )421;
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
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility_id , 'S\
M' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_valu\
e , :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )444;
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
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . CONVERT_TO_LOC\
ALE_DATE ( to_date ( :nd_temp_date , 'DD/MM/YYYY HH24:MI' ) , :p_language_id ,\
 t_date ) ; :nd_loc_date := to_char ( t_date , 'DD/MM/YYYY' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )475;
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
