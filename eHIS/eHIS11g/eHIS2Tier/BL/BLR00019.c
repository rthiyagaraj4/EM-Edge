
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/BLR00019.PC"
};


static unsigned int sqlctx = 1288460915;


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

 static const char *sq0004 = 
"0))* (nvl(d.ip_deposit_top_up_perc,0)/100))) and g.blng_grp_id=a.blng_grp_id\
) and a.episode_id between NVL(:b2,0) and NVL(:b3,99999999)) and c.cur_bed_cla\
ss_code between NVL(:b4,'!!!!') and NVL(:b5,'~~~~')) and g.blng_grp_catg betwe\
en NVL(:b6,'!!!!') and NVL(:b7,'~~~~')) and a.blng_grp_id between NVL(:b8,'!!!\
!') and NVL(:b9,'~~~~')) and c.cur_Ward_code between NVL(:b10,'!!!!') and NVL(\
:b11,'~~~~')) order by c.cur_bed_class_code,a.patient_id            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,1,91,0,2,173,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
28,0,0,2,0,0,30,182,0,0,0,0,0,1,0,
43,0,0,0,0,0,27,190,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
74,0,0,4,1480,0,9,238,0,0,12,12,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
137,0,0,4,0,0,13,271,0,0,11,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
196,0,0,5,334,0,4,330,0,0,12,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
259,0,0,6,128,0,4,441,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
290,0,0,7,96,0,4,504,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
313,0,0,8,165,0,6,511,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
344,0,0,9,71,0,4,585,0,0,2,1,0,1,0,1,97,0,0,2,9,0,0,
367,0,0,10,237,0,6,749,0,0,4,4,0,1,0,1,97,0,0,2,9,0,0,3,9,0,0,3,9,0,0,
398,0,0,11,242,0,4,794,0,0,7,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,
9,0,0,1,9,0,0,
441,0,0,12,0,0,32,818,0,0,0,0,0,1,0,
456,0,0,13,207,0,6,856,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
};


/************************************************************************/
/* PROGRAM NAME          : BLR00019.PC                                  */
/* AUTHOR                : D Ganesh Murthi                              */
/* DATE WRITTEN          : 15/02/2005                                	*/
/*                                                                      */
/* CALLED FROM           :                                              */
/*                                                                      */
/************************************************************************/

#include <stdio.h>
#include <string.h>  
#include <bl.h>
  
#define OERROR (sqlca.sqlcode < 0)
#define LAST_ROW (sqlca.sqlcode == 1403)
#define NOT_FOUND (sqlca.sqlerrd[2] == 0)
#define RESOURCE_BUSY        (sqlca.sqlcode == -54)
#define DUPLICATE_KEY        (sqlca.sqlcode == -1)
#define	MAX_LINES 60
#define ESC 0x1B

#define INIT_MESG "Report Generation is in progress"

/* EXEC SQL BEGIN DECLARE SECTION; */ 


	/* VARCHAR	uid_pwd				[132],
			hosp_name			[120],
			date_time			[21],
			user_id				[20],
			nd_pgm_date			[35],
			nd_facility_name	[31],
			nd_session_id		[16],
			nd_facility_id		[3],
            
			d_acc_entity_name			[41],
			d_user						[21],
			d_sysdate					[21],
			date						[21],
			p_language_id       [3],
			nd_temp_date		[21],
			nd_loc_date[21],
			date_convert[21]; */ 
struct { unsigned short len; unsigned char arr[132]; } uid_pwd;

struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[21]; } date_time;

struct { unsigned short len; unsigned char arr[20]; } user_id;

struct { unsigned short len; unsigned char arr[35]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[31]; } nd_facility_name;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[41]; } d_acc_entity_name;

struct { unsigned short len; unsigned char arr[21]; } d_user;

struct { unsigned short len; unsigned char arr[21]; } d_sysdate;

struct { unsigned short len; unsigned char arr[21]; } date;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[21]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[21]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[21]; } date_convert;

			
			
/* VARCHAR	nd_lang_id	[4]; */ 
struct { unsigned short len; unsigned char arr[4]; } nd_lang_id;


/* VARCHAR l_pk_value			[200],
		l_translated_value	[201],
		l_from_and_to_date  [41]; */ 
struct { unsigned short len; unsigned char arr[200]; } l_pk_value;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[41]; } l_from_and_to_date;


char loc_legend[40][201],l_mesg[1000];

int     l_line_no =0, l_rec_cnt = 0;
int     l_page_no=0;	
int		i;


/* VARCHAR		l_fr_ward_code			[6],
			l_to_ward_code			[6],
			l_fr_bed_class_code	    [3],
			l_to_bed_class_code		[3],
			l_fr_episode_id			[15],
			l_to_episode_id			[15],
			d_episode_id			[10],
			d_patient_id			[21],
			d_short_name			[61],
			d_ward_code             [6],
			d_bed_class             [3],
			d_bed_num		[10],
			d_prev_bed_class        [3],
			d_remark                [51],
			d_admission_date_time   [21],
			l_address_line1			[33],
			l_address_line2			[33],
			l_address_line3			[33],
			l_tel_number			[33],
			l_sysdate				[20],
			l_hospital_name			[50],
			l_str1[2000],
			l_str2[100],
			l_str3[100],
			l_fr_blng_grp_catg	    [5],
			l_to_blng_grp_catg		[5],
			l_fr_blng_grp			[5],
			l_to_blng_grp			[5],
			d_blng_grp_catg         [5],
		    d_blng_grp              [5]; */ 
struct { unsigned short len; unsigned char arr[6]; } l_fr_ward_code;

struct { unsigned short len; unsigned char arr[6]; } l_to_ward_code;

struct { unsigned short len; unsigned char arr[3]; } l_fr_bed_class_code;

struct { unsigned short len; unsigned char arr[3]; } l_to_bed_class_code;

struct { unsigned short len; unsigned char arr[15]; } l_fr_episode_id;

struct { unsigned short len; unsigned char arr[15]; } l_to_episode_id;

struct { unsigned short len; unsigned char arr[10]; } d_episode_id;

struct { unsigned short len; unsigned char arr[21]; } d_patient_id;

struct { unsigned short len; unsigned char arr[61]; } d_short_name;

struct { unsigned short len; unsigned char arr[6]; } d_ward_code;

struct { unsigned short len; unsigned char arr[3]; } d_bed_class;

struct { unsigned short len; unsigned char arr[10]; } d_bed_num;

struct { unsigned short len; unsigned char arr[3]; } d_prev_bed_class;

struct { unsigned short len; unsigned char arr[51]; } d_remark;

struct { unsigned short len; unsigned char arr[21]; } d_admission_date_time;

struct { unsigned short len; unsigned char arr[33]; } l_address_line1;

struct { unsigned short len; unsigned char arr[33]; } l_address_line2;

struct { unsigned short len; unsigned char arr[33]; } l_address_line3;

struct { unsigned short len; unsigned char arr[33]; } l_tel_number;

struct { unsigned short len; unsigned char arr[20]; } l_sysdate;

struct { unsigned short len; unsigned char arr[50]; } l_hospital_name;

struct { unsigned short len; unsigned char arr[2000]; } l_str1;

struct { unsigned short len; unsigned char arr[100]; } l_str2;

struct { unsigned short len; unsigned char arr[100]; } l_str3;

struct { unsigned short len; unsigned char arr[5]; } l_fr_blng_grp_catg;

struct { unsigned short len; unsigned char arr[5]; } l_to_blng_grp_catg;

struct { unsigned short len; unsigned char arr[5]; } l_fr_blng_grp;

struct { unsigned short len; unsigned char arr[5]; } l_to_blng_grp;

struct { unsigned short len; unsigned char arr[5]; } d_blng_grp_catg;

struct { unsigned short len; unsigned char arr[5]; } d_blng_grp;




double   d_dep_amt_paid;

char filename[200];
char string_var[200];

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

int    lctr = 0,pctr = 0;

FILE *fp;

void proc_main(argc,argv)
char *argv[];
int argc;
{
    if (argc < 4)
    {
     int i = 0;
       disp_message(ERR_MESG,"Not enough Parameters for running this program");
       proc_exit();
    }

	strcpy(uid_pwd.arr,argv[1]);
	uid_pwd.len = strlen(uid_pwd.arr);

	nd_session_id.len = 0;
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

	if(sql_connect() == -1)
	{
		disp_message(ERR_MESG,"Error in connecting to Oracle\n");
		if (uid_pwd.len == 0)
			disp_message(ERR_MESG,"Null oracle uid/pwd\n\n\n");
		proc_exit();
	}

	set_meduser_role();


     strcpy(p_language_id.arr,l_language_id.arr);
	 p_language_id.len = l_language_id.len;

	fetch_prog_param();

    declare_cursors();

    //fetch_prog_param();

    fetch_hosp_name();
    
    open_file();

    fetch_legend_value();
    
    //fprintf(fp,"%c",0x0F); /*** set Dot-matrix printer to compressed mode ***/
    print_param_header();
    print_report();

    //fprintf(fp,"%c",0x12); /*** Set Dot-matrix Printer to Normal Mode ***/

    end_of_rep();

	/* EXEC SQL DELETE SY_PROG_PARAM
            WHERE PGM_ID   = 'BLR00019'
            AND SESSION_ID = :nd_session_id
            AND PGM_DATE   = :nd_pgm_date; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 2;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='BLR00019' and SE\
SSION_ID=:b0) and PGM_DATE=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )5;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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

    
    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 2;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )28;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
         err_mesg("COMMIT WORK RELEASE failed",0,"");

}

sql_connect()
{
  /* EXEC SQL CONNECT :uid_pwd; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )43;
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

declare_cursors()
{
	/* EXEC SQL DECLARE TOPUP_DEP CURSOR FOR 
	SELECT 	a.patient_id, 
		a.episode_id, 
		decode(:p_language_id,'en', substr(b.short_name,1,60),substr(nvl(b.SHORT_NAME_LOC_LANG,b.short_name),1,60)),
		g.blng_grp_catg, 
		a.blng_grp_id,
		c.cur_Ward_code, 
		c.cur_bed_class_code, 
		(nvl(tot_unadj_dep_amt,0)+nvl(tot_unadj_prep_amt,0)) Deposit_amt_paid, 
		a.remark, 
		a.admission_date_time,
		c.cur_bed_num
	FROM	ip_open_episode e, 
		bl_episode_fin_dtls a, 
		mp_patient_mast b,
		ip_episode c,  
		bl_parameters d,
		bl_blng_grp_by_catg g
	WHERE	e.facility_id	= :nd_facility_id
	AND	a.operating_facility_id	= e.facility_id
	AND	a.episode_id		= e.open_episode_id
	AND	a.episode_type 	in ('I','D')   
	AND	a.episode_id		= c.episode_id
	AND	a.patient_id		= b.patient_id
	AND	a.episode_status	= '0'
	AND	a.operating_facility_id	= c.facility_id
	AND	a.operating_facility_id	= d.operating_facility_id
	AND	((d.discharge_billing_stage = '1' and NVL(a.discharge_bill_gen_ind,'N') = 'N') 
		OR (d.discharge_billing_stage= '2' and NVL(a.discharged_yn,'N') = 'N'))
	AND	(nvl(tot_unadj_dep_amt,0)+nvl(tot_unadj_prep_amt,0))
	        < ((nvl(tot_unbld_amt,0) + nvl(tot_outst_amt,0)) * (nvl(d.ip_deposit_top_up_perc,0)/100)) 
	and g.blng_grp_id=a.blng_grp_id		
	AND	a.episode_id between NVL(:l_fr_episode_id,0) AND NVL(:l_to_episode_id,99999999)
	AND	c.cur_bed_class_code BETWEEN NVL(:l_fr_bed_class_code,'!!!!') AND NVL(:l_to_bed_class_code,'~~~~')
	AND	g.blng_grp_catg BETWEEN NVL(:l_fr_blng_grp_catg,'!!!!') AND NVL(:l_to_blng_grp_catg,'~~~~')
	AND	a.blng_grp_id BETWEEN NVL(:l_fr_blng_grp,'!!!!') AND NVL(:l_to_blng_grp,'~~~~')
	AND c.cur_Ward_code BETWEEN NVL(:l_fr_ward_code,'!!!!') AND NVL(:l_to_ward_code,'~~~~')
	Order By c.cur_bed_class_code, a.patient_id; */ 


/* EXEC SQL OPEN TOPUP_DEP; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 12;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlbuft((void **)0, 
  "select a.patient_id ,a.episode_id ,decode(:b0,'en',substr(b.short_name,1,\
60),substr(nvl(b.SHORT_NAME_LOC_LANG,b.short_name),1,60)) ,g.blng_grp_catg ,\
a.blng_grp_id ,c.cur_Ward_code ,c.cur_bed_class_code ,(nvl(tot_unadj_dep_amt\
,0)+nvl(tot_unadj_prep_amt,0)) Deposit_amt_paid ,a.remark ,a.admission_date_\
time ,c.cur_bed_num  from ip_open_episode e ,bl_episode_fin_dtls a ,mp_patie\
nt_mast b ,ip_episode c ,bl_parameters d ,bl_blng_grp_by_catg g where ((((((\
((((((((((e.facility_id=:b1 and a.operating_facility_id=e.facility_id) and a\
.episode_id=e.open_episode_id) and a.episode_type in ('I','D')) and a.episod\
e_id=c.episode_id) and a.patient_id=b.patient_id) and a.episode_status='0') \
and a.operating_facility_id=c.facility_id) and a.operating_facility_id=d.ope\
rating_facility_id) and ((d.discharge_billing_stage='1' and NVL(a.discharge_\
bill_gen_ind,'N')='N') or (d.discharge_billing_stage='2' and NVL(a.discharge\
d_yn,'N')='N'))) and (nvl(tot_unadj_dep_amt,0)+nvl(tot_unadj_prep_amt,0))<((\
nvl(tot_unbld_amt,0)+nvl(tot_outst_amt,");
sqlstm.stmt = sq0004;
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )74;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)4352;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqcmod = (unsigned int )0;
sqlstm.sqhstv[0] = (         void  *)&p_language_id;
sqlstm.sqhstl[0] = (unsigned int  )5;
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
sqlstm.sqhstv[2] = (         void  *)&l_fr_episode_id;
sqlstm.sqhstl[2] = (unsigned int  )17;
sqlstm.sqhsts[2] = (         int  )0;
sqlstm.sqindv[2] = (         void  *)0;
sqlstm.sqinds[2] = (         int  )0;
sqlstm.sqharm[2] = (unsigned int  )0;
sqlstm.sqadto[2] = (unsigned short )0;
sqlstm.sqtdso[2] = (unsigned short )0;
sqlstm.sqhstv[3] = (         void  *)&l_to_episode_id;
sqlstm.sqhstl[3] = (unsigned int  )17;
sqlstm.sqhsts[3] = (         int  )0;
sqlstm.sqindv[3] = (         void  *)0;
sqlstm.sqinds[3] = (         int  )0;
sqlstm.sqharm[3] = (unsigned int  )0;
sqlstm.sqadto[3] = (unsigned short )0;
sqlstm.sqtdso[3] = (unsigned short )0;
sqlstm.sqhstv[4] = (         void  *)&l_fr_bed_class_code;
sqlstm.sqhstl[4] = (unsigned int  )5;
sqlstm.sqhsts[4] = (         int  )0;
sqlstm.sqindv[4] = (         void  *)0;
sqlstm.sqinds[4] = (         int  )0;
sqlstm.sqharm[4] = (unsigned int  )0;
sqlstm.sqadto[4] = (unsigned short )0;
sqlstm.sqtdso[4] = (unsigned short )0;
sqlstm.sqhstv[5] = (         void  *)&l_to_bed_class_code;
sqlstm.sqhstl[5] = (unsigned int  )5;
sqlstm.sqhsts[5] = (         int  )0;
sqlstm.sqindv[5] = (         void  *)0;
sqlstm.sqinds[5] = (         int  )0;
sqlstm.sqharm[5] = (unsigned int  )0;
sqlstm.sqadto[5] = (unsigned short )0;
sqlstm.sqtdso[5] = (unsigned short )0;
sqlstm.sqhstv[6] = (         void  *)&l_fr_blng_grp_catg;
sqlstm.sqhstl[6] = (unsigned int  )7;
sqlstm.sqhsts[6] = (         int  )0;
sqlstm.sqindv[6] = (         void  *)0;
sqlstm.sqinds[6] = (         int  )0;
sqlstm.sqharm[6] = (unsigned int  )0;
sqlstm.sqadto[6] = (unsigned short )0;
sqlstm.sqtdso[6] = (unsigned short )0;
sqlstm.sqhstv[7] = (         void  *)&l_to_blng_grp_catg;
sqlstm.sqhstl[7] = (unsigned int  )7;
sqlstm.sqhsts[7] = (         int  )0;
sqlstm.sqindv[7] = (         void  *)0;
sqlstm.sqinds[7] = (         int  )0;
sqlstm.sqharm[7] = (unsigned int  )0;
sqlstm.sqadto[7] = (unsigned short )0;
sqlstm.sqtdso[7] = (unsigned short )0;
sqlstm.sqhstv[8] = (         void  *)&l_fr_blng_grp;
sqlstm.sqhstl[8] = (unsigned int  )7;
sqlstm.sqhsts[8] = (         int  )0;
sqlstm.sqindv[8] = (         void  *)0;
sqlstm.sqinds[8] = (         int  )0;
sqlstm.sqharm[8] = (unsigned int  )0;
sqlstm.sqadto[8] = (unsigned short )0;
sqlstm.sqtdso[8] = (unsigned short )0;
sqlstm.sqhstv[9] = (         void  *)&l_to_blng_grp;
sqlstm.sqhstl[9] = (unsigned int  )7;
sqlstm.sqhsts[9] = (         int  )0;
sqlstm.sqindv[9] = (         void  *)0;
sqlstm.sqinds[9] = (         int  )0;
sqlstm.sqharm[9] = (unsigned int  )0;
sqlstm.sqadto[9] = (unsigned short )0;
sqlstm.sqtdso[9] = (unsigned short )0;
sqlstm.sqhstv[10] = (         void  *)&l_fr_ward_code;
sqlstm.sqhstl[10] = (unsigned int  )8;
sqlstm.sqhsts[10] = (         int  )0;
sqlstm.sqindv[10] = (         void  *)0;
sqlstm.sqinds[10] = (         int  )0;
sqlstm.sqharm[10] = (unsigned int  )0;
sqlstm.sqadto[10] = (unsigned short )0;
sqlstm.sqtdso[10] = (unsigned short )0;
sqlstm.sqhstv[11] = (         void  *)&l_to_ward_code;
sqlstm.sqhstl[11] = (unsigned int  )8;
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

  

	if(OERROR)	   
	  err_mesg("OPEN failed on cursor TOPUP_DEP",0,"");

}

fetch_cursors()
{
    d_episode_id.arr[0]         = '\0';
    d_patient_id.arr[0]         = '\0';
    d_short_name.arr[0]         = '\0';
    d_ward_code.arr[0]          = '\0';
    d_bed_class.arr[0]          = '\0';
    d_bed_num.arr[0]		= '\0';
    d_remark.arr[0]             = '\0';
    d_admission_date_time.arr[0]= '\0';
	d_blng_grp_catg.arr[0]         = '\0';
    d_blng_grp.arr[0]              = '\0';

    d_episode_id.len            = 0;
    d_patient_id.len            = 0;
    d_short_name.len		= 0;
    d_ward_code.len		= 0;
    d_bed_class.len		= 0;
    d_bed_num.len		= 0;
    d_remark.len		= 0;
    d_admission_date_time.len   = 0;
    d_blng_grp_catg.len         = 0;
    d_blng_grp.len              = 0;

    d_dep_amt_paid		= 0;

    /* EXEC SQL FETCH TOPUP_DEP INTO  
		   :d_patient_id,
		   :d_episode_id,
		   :d_short_name,
		   :d_blng_grp_catg,
		   :d_blng_grp,
		   :d_ward_code,
		   :d_bed_class,
		   :d_dep_amt_paid,
		   :d_remark,
		   :d_admission_date_time,
		   :d_bed_num; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )137;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_patient_id;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_episode_id;
    sqlstm.sqhstl[1] = (unsigned int  )12;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_short_name;
    sqlstm.sqhstl[2] = (unsigned int  )63;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_blng_grp_catg;
    sqlstm.sqhstl[3] = (unsigned int  )7;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_blng_grp;
    sqlstm.sqhstl[4] = (unsigned int  )7;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_ward_code;
    sqlstm.sqhstl[5] = (unsigned int  )8;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_bed_class;
    sqlstm.sqhstl[6] = (unsigned int  )5;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_dep_amt_paid;
    sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&d_remark;
    sqlstm.sqhstl[8] = (unsigned int  )53;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&d_admission_date_time;
    sqlstm.sqhstl[9] = (unsigned int  )23;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&d_bed_num;
    sqlstm.sqhstl[10] = (unsigned int  )12;
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

     

    if(OERROR)
	err_mesg("FETCH failed on cursor TOPUP_DEP",0,"");

    if(NO_DATA_FOUND)
	return 0;

    d_episode_id.arr[d_episode_id.len]               = '\0';
    d_patient_id.arr[d_patient_id.len]               = '\0';
    d_short_name.arr[d_short_name.len]               = '\0';
    d_admission_date_time.arr[d_admission_date_time.len]     = '\0';
    d_remark.arr[d_remark.len]						 = '\0';
    d_bed_class.arr[d_bed_class.len]                 = '\0';
    d_bed_num.arr[d_bed_num.len]			= '\0';
    d_ward_code.arr[d_ward_code.len]                 = '\0';
	d_blng_grp_catg.arr[d_blng_grp_catg.len]		     = '\0';
    d_blng_grp.arr[d_blng_grp.len]                     = '\0';

    l_rec_cnt = l_rec_cnt + 1;

    return 1;
}

fetch_prog_param()
{    
    l_fr_episode_id.arr[0]			    ='\0'; 
    l_to_episode_id.arr[0]		   	    ='\0';
    l_fr_bed_class_code.arr[0]			='\0';
    l_to_bed_class_code.arr[0]			='\0';
	l_fr_blng_grp_catg.arr[0]			='\0';
    l_to_blng_grp_catg.arr[0]			='\0';
	l_fr_blng_grp.arr[0]		    	='\0';
    l_to_blng_grp.arr[0]		    	='\0';
	l_fr_ward_code.arr[0]		    	='\0';
    l_to_ward_code.arr[0]		    	='\0';

    l_fr_episode_id.len				= 0;
    l_to_episode_id.len				= 0;
    l_fr_bed_class_code.len			= 0;
    l_to_bed_class_code.len			= 0;   
	l_fr_blng_grp_catg.len		    = 0;
    l_to_blng_grp_catg.len			= 0;
    l_fr_blng_grp.len		    	= 0;
    l_to_blng_grp.len		    	= 0;  
    l_fr_ward_code.len		    	= 0;
    l_to_ward_code.len		    	= 0;  
 
   /* EXEC SQL SELECT  NVL(PARAM1,'!!'),NVL(PARAM2,'~~'),NVL(PARAM3,'0'),NVL(PARAM4,'99999999'),
                    NVL(PARAM5,'!!!!'),NVL(PARAM6,'~~~~'),NVL(PARAM7,'!!!!'),NVL(PARAM8,'~~~~'),
					NVL(PARAM9,'!!!!'),NVL(PARAM10,'~~~~')
            INTO    :l_fr_bed_class_code,:l_to_bed_class_code,
		    :l_fr_episode_id, :l_to_episode_id,:l_fr_blng_grp_catg,l_to_blng_grp_catg,
			:l_fr_blng_grp,:l_to_blng_grp,:l_fr_ward_code,:l_to_ward_code
            FROM SY_PROG_PARAM
            WHERE PGM_ID   = 'BLR00019'
            AND SESSION_ID = :nd_session_id
            AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select NVL(PARAM1,'!!') ,NVL(PARAM2,'~~') ,NVL(PARAM3,'0')\
 ,NVL(PARAM4,'99999999') ,NVL(PARAM5,'!!!!') ,NVL(PARAM6,'~~~~') ,NVL(PARAM7,'\
!!!!') ,NVL(PARAM8,'~~~~') ,NVL(PARAM9,'!!!!') ,NVL(PARAM10,'~~~~') into :b0,:\
b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9  from SY_PROG_PARAM where ((PGM_ID='BLR0001\
9' and SESSION_ID=:b10) and PGM_DATE=:b11)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )196;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&l_fr_bed_class_code;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&l_to_bed_class_code;
   sqlstm.sqhstl[1] = (unsigned int  )5;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&l_fr_episode_id;
   sqlstm.sqhstl[2] = (unsigned int  )17;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&l_to_episode_id;
   sqlstm.sqhstl[3] = (unsigned int  )17;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&l_fr_blng_grp_catg;
   sqlstm.sqhstl[4] = (unsigned int  )7;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&l_to_blng_grp_catg;
   sqlstm.sqhstl[5] = (unsigned int  )7;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&l_fr_blng_grp;
   sqlstm.sqhstl[6] = (unsigned int  )7;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&l_to_blng_grp;
   sqlstm.sqhstl[7] = (unsigned int  )7;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&l_fr_ward_code;
   sqlstm.sqhstl[8] = (unsigned int  )8;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&l_to_ward_code;
   sqlstm.sqhstl[9] = (unsigned int  )8;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[10] = (unsigned int  )18;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[11] = (unsigned int  )37;
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
        err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   if (NOT_FOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");

	l_fr_episode_id.arr[l_fr_episode_id.len]		 = '\0';
	l_to_episode_id.arr[l_to_episode_id.len]		 = '\0';
	l_fr_bed_class_code.arr[l_fr_bed_class_code.len] = '\0';
    l_to_bed_class_code.arr[l_to_bed_class_code.len] = '\0';

	l_fr_blng_grp_catg.arr[l_fr_blng_grp_catg.len]	 = '\0';
	l_to_blng_grp_catg.arr[l_to_blng_grp_catg.len]	 = '\0';
	l_fr_blng_grp.arr[l_fr_blng_grp.len]             = '\0';
    l_to_blng_grp.arr[l_to_blng_grp.len]             = '\0';
  	l_fr_ward_code.arr[l_fr_ward_code.len]             = '\0';
    l_to_ward_code.arr[l_to_ward_code.len]             = '\0';


}

end_of_rep()
{
	fprintf(fp,"\n %55s***  END OF REPORT ***\n\f"," ");
	fflush(fp);
}

open_file()
{
    strcpy(filename,WORKING_DIR);
	strcat(filename,"blr00019.lis");

    if ((fp = fopen(filename,"w")) == NULL)
    {
       disp_message(ERR_MESG,"Error in opening file blr00019.lis");
       proc_exit();
    }
}

print_letter_deposit_detail()
{
   

	fprintf(fp,"%-20.20s %-10.10s %-29.29s %-8.8s %-6.6s %-8.8s %-9.9s",
	d_patient_id.arr,d_episode_id.arr,d_short_name.arr,d_blng_grp_catg.arr,d_blng_grp.arr,
        d_ward_code.arr,d_bed_num.arr);
        print_formated(d_dep_amt_paid);
	fprintf(fp,"%-20.20s \n",d_remark.arr);
	
	l_line_no++;
	check_page_break();
}

print_report()
{
	d_prev_bed_class.arr[0] = '\0';
	d_prev_bed_class.len = 0;	

	while(fetch_cursors())
	{
		
		if (d_prev_bed_class.arr[0] == '\0')
		  { 
		    
			strcpy( d_prev_bed_class.arr,d_bed_class.arr);
		//	d_prev_bed_class.arr[d_prev_bed_class.len] = '\0';
			l_line_no=0;
			print_page_header();
            
			print_letter_deposit_detail();
		  }       
		  
		else
		  {
		   if (strcmp(d_prev_bed_class.arr, d_bed_class.arr) != 0)
		     {  strcpy(d_prev_bed_class.arr,d_bed_class.arr);
				fprintf(fp,"\f\n");
				l_line_no=0;
				print_page_header();  
				print_letter_deposit_detail();
		     }

		   else if (strcmp(d_prev_bed_class.arr, d_bed_class.arr) == 0)
		      print_letter_deposit_detail();
		  }	    
	}

	if (l_rec_cnt == 0) 
		print_page_header();
}

fetch_hosp_name()
{
    hosp_name.arr[0] = '\0';
    date_time.arr[0] = '\0';
    user_id.arr[0]   = '\0';
    hosp_name.len    = 0;
    date_time.len    = 0;
    user_id.len      = 0;

    /* EXEC SQL   SELECT ACC_ENTITY_NAME, 
	       TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
	       USER
         INTO  :hosp_name, :date_time, :user_id
         FROM  SY_ACC_ENTITY
	 where acc_entity_id = :nd_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:\
MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY where acc_entity_id=:b3";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )259;
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
    sqlstm.sqhstl[1] = (unsigned int  )23;
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
    sqlstm.sqhstv[3] = (         void  *)&nd_facility_id;
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



       if (OERROR) err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");

hosp_name.arr[hosp_name.len]           = '\0';
date_time.arr[date_time.len]           = '\0';
user_id.arr[user_id.len]               = '\0';
}


print_formated(loc_amount)  
double loc_amount;
{
    char s_amt[30], str_amt[30];	
    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);        
        format_amt(s_amt);
	  //  strcat(s_amt,"-");
        sprintf(str_amt,"%14s",s_amt);
		l_ltrim(s_amt);
        fprintf(fp,"%14s-",str_amt);
    }
    else 
	{
        put_val(s_amt,loc_amount);         
        format_amt(s_amt);
        sprintf(str_amt,"%14s",s_amt);
		l_ltrim(s_amt);
        fprintf(fp,"%14s ",str_amt);
    }
}

check_page_break()
{
	if (l_line_no >= 60)	
	{
	        l_line_no = 1;
		fprintf(fp,"\f\n");
		print_page_header();
	}
}


print_spaces(l_length)
double l_length;
{
	for(i=0;i<l_length;i++)
	{
		fprintf(fp," ");
	}
}

fetch_legend_value()
{
    for(i=1;i<50;i++)
	{	l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLR00019.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		         INTO :l_pk_value
				 FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 12;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLR00019.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )290;
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
  sqlstm.sqhstl[1] = (unsigned int  )202;
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
			blcommon.get_local_lang_desc(	
				:nd_facility_id,
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
  sqlstm.sqhstv[1] = (         void  *)&l_pk_value;
  sqlstm.sqhstl[1] = (unsigned int  )202;
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

print_page_title()
{
	double l_report_width;
	double l_acc_entity_length;
	double l_start_point;
	double l_comp_name_end_point;
	int    l_page_width;

	
	l_report_width=132;

       get_header_dtls();

	l_acc_entity_length = strlen(d_acc_entity_name.arr);

	//Code for Line 1

	l_start_point=(l_report_width/2)-(l_acc_entity_length/2);
	fprintf(fp,"%s           : %s",loc_legend[27],loc_legend[26]);
	l_start_point=l_start_point-18;
	print_spaces(l_start_point);
	fprintf(fp,"%s",d_acc_entity_name.arr);
	l_comp_name_end_point=l_start_point+18+l_acc_entity_length;
	l_start_point=(l_report_width-(15+strlen(date.arr))-l_comp_name_end_point);
	print_spaces(l_start_point);
	init_date_temp_var();                              
	strcpy(date_convert.arr,date.arr); 
	fun_change_loc_date();
	fprintf(fp," %-9.8s : %s\n",loc_legend[11],date_convert.arr);

	//Code for Line 2  
	l_from_and_to_date.arr[0] = '\0';
	l_from_and_to_date.len = 0;
	
	l_start_point=0;
	l_start_point=(l_report_width/2)-((strlen(loc_legend[01]))/2);
	fprintf(fp,"%s           : %s",loc_legend[28],d_user.arr);
	l_start_point=l_start_point-(strlen(d_user.arr)+16);
	print_spaces(l_start_point);
	fprintf(fp,"%s",loc_legend[01]);
	l_comp_name_end_point=l_start_point+(strlen(d_user.arr)+16)+strlen(loc_legend[01]);
	l_start_point=(l_report_width-(17+strlen(date_time.arr))-l_comp_name_end_point);
	print_spaces(l_start_point);
	fprintf(fp," %-9.8s : %s\n",loc_legend[12],date_time.arr);

	//Code for Line 3  
	
	l_from_and_to_date.arr[0] = '\0';
	l_from_and_to_date.len = 0;

	init_date_temp_var(); 
       
	strcpy(date_convert.arr,date.arr); 
	fun_change_loc_date();

	/* EXEC SQL SELECT :loc_legend[10]||' '||to_char(sysdate,'DD/MM/YYYY')
	           INTO :l_from_and_to_date
	           FROM dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 12;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select ((:b0||' ')||to_char(sysdate,'DD/MM/YYYY')) into :b1 \
 from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )344;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)loc_legend[10];
 sqlstm.sqhstl[0] = (unsigned int  )201;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_from_and_to_date;
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


	l_from_and_to_date.arr[l_from_and_to_date.len] = '\0';
	l_start_point=0;	
	l_start_point=(l_report_width/2)-((strlen(l_from_and_to_date.arr))/2);
	fprintf(fp,"%-14.14s: BLR00019",loc_legend[14]);
	l_start_point=l_start_point-24;
	print_spaces(l_start_point);


	fprintf(fp,"%-s %-s ",loc_legend[10],date_convert.arr);
  
	l_comp_name_end_point=l_start_point+24+strlen(l_from_and_to_date.arr);
	l_start_point=(l_report_width-(24+1)-l_comp_name_end_point);
	print_spaces(l_start_point);
	fprintf(fp,"%-9.8s : %d\n",loc_legend[13],++l_page_no);

	//Code for Line 4  

	l_start_point=0;
	l_start_point=(l_report_width/2)-((strlen(loc_legend[8]))/2);
	//fprintf(fp,"%-14.14s: BLR00019",loc_legend[14]);
	l_start_point=l_start_point;
	print_spaces(l_start_point);
	fprintf(fp,"%s %s",loc_legend[8], d_bed_class.arr);
	l_comp_name_end_point=l_start_point+24+strlen(loc_legend[8]);
	l_start_point=(l_report_width-(18+9)-l_comp_name_end_point);
	print_spaces(l_start_point);
	fprintf(fp,"\n");
	//fprintf(fp,"%-15.15s : %d\n",loc_legend[13],++l_page_no);

	l_line_no= l_line_no + 4;
//	print_page_header();	
	l_line_no= l_line_no + 4; 
}  
//-----------
print_param_header()
{
int l1,rep_width=132;
//fprintf (fp,"%c&l1O",ESC);
fprintf (fp, "%c(s17H", ESC);
fprintf(fp,"\n");
  print_page_title();

  print_line(136);
  fprintf(fp,"\n\n\n\n\n");
  //fprintf(fp,"%12s %3s: 10.4 \n"," ",loc_legend[32]);
  fprintf(fp,"%12s %15s \n"," ",loc_legend[33]);
  fprintf(fp,"%12s--------------- \n"," ");
  

		if (strcmp(l_fr_blng_grp_catg.arr,"!!!!")==0) 

		   if (strcmp(l_to_blng_grp_catg.arr,"~~~~")==0) 

		         fprintf(fp,"%12s %-14s: %-9s \n"," ",loc_legend[15],loc_legend[23]);
		   else
		         fprintf(fp,"%12s %-14s: %-8s %-8s %-4s %-8s\n"," ",loc_legend[15],loc_legend[17],loc_legend[21],loc_legend[18],l_to_blng_grp_catg.arr);  
		else
		    if (strcmp(l_to_blng_grp_catg.arr,"~~~~")==0) 

		         fprintf(fp,"%12s %-14s: %-8s %-8s %-4s %-8s\n"," ",loc_legend[15],loc_legend[17],l_fr_blng_grp_catg.arr,loc_legend[18],loc_legend[22]);  
		    else

		         fprintf(fp,"%12s %-14s: %-8s %-8s %-4s %-8s\n"," ",loc_legend[15],loc_legend[17],l_fr_blng_grp_catg.arr,loc_legend[18],l_to_blng_grp_catg.arr);  

    if(strcmp(l_fr_blng_grp.arr,"!!!!")==0)

		   if (strcmp(l_to_blng_grp.arr,"~~~~")==0) 

			  fprintf(fp,"%12s %-22s: %-9s \n"," ",loc_legend[16],loc_legend[23]);
		   else

			  fprintf(fp,"%12s %-22s: %-8s %-8s %-4s %-8s\n"," ",loc_legend[16],loc_legend[17],loc_legend[21],loc_legend[18],l_to_blng_grp.arr);  
       else

		   if  (strcmp(l_to_blng_grp.arr,"~~~~")==0) 
		   fprintf(fp,"%12s %-22s: %-8s %-8s %-4s %-8s\n"," ",loc_legend[16],loc_legend[17],l_fr_blng_grp.arr,loc_legend[18],loc_legend[22]);  
		   else

		   fprintf(fp,"%12s %-22s: %-8s %-8s %-4s %-8s\n"," ",loc_legend[16],loc_legend[17],l_fr_blng_grp.arr,loc_legend[18],l_to_blng_grp.arr);  


 if (strcmp(l_fr_ward_code.arr,"!!!!")==0)

		   if (strcmp(l_to_ward_code.arr,"~~~~")==0) 

			  fprintf(fp,"%12s %-22s: %-9s \n"," ",loc_legend[29],loc_legend[23]);
		   else

			  fprintf(fp,"%12s %-22s: %-8s %-8s %-4s %-8s\n"," ",loc_legend[29],loc_legend[17],loc_legend[21],loc_legend[18],l_to_ward_code.arr);  
     else

		   if  (strcmp(l_to_ward_code.arr,"~~~~")==0) 

		      fprintf(fp,"%12s %-22s: %-8s %-8s %-4s %-8s\n"," ",loc_legend[29],loc_legend[17],l_fr_ward_code.arr,loc_legend[18],loc_legend[22]);  
		   else

		   fprintf(fp,"%12s %-22s: %-8s %-8s %-4s %-8s\n"," ",loc_legend[29],loc_legend[17],l_fr_ward_code.arr,loc_legend[18],l_to_ward_code.arr);  

   



   if (strcmp(l_fr_bed_class_code.arr,"!!")==0)

		   if (strcmp(l_to_bed_class_code.arr,"~~")==0) 

			  fprintf(fp,"%12s %-22s: %-9s \n"," ",loc_legend[19],loc_legend[23]);
		   else

			  fprintf(fp,"%12s %-22s: %-8s %-8s %-4s %-8s\n"," ",loc_legend[19],loc_legend[17],loc_legend[21],loc_legend[18],l_to_bed_class_code.arr);  
     else

		   if  (strcmp(l_to_bed_class_code.arr,"~~")==0) 

		      fprintf(fp,"%12s %-22s: %-8s %-8s %-4s %-8s\n"," ",loc_legend[19],loc_legend[17],l_fr_bed_class_code.arr,loc_legend[18],loc_legend[22]);  
		   else

		   fprintf(fp,"%12s %-22s: %-8s %-8s %-4s %-8s\n"," ",loc_legend[19],loc_legend[17],l_fr_bed_class_code.arr,loc_legend[18],l_to_bed_class_code.arr);  

   
      if (strcmp(l_fr_episode_id.arr,"0")==0)

		   if (strcmp(l_to_episode_id.arr,"99999999")==0) 

			  fprintf(fp,"%12s %-22s: %-9s \n"," ",loc_legend[20],loc_legend[23]);
		   else

			  fprintf(fp,"%12s %-22s: %-8s %-8s %-4s %-8s\n"," ",loc_legend[20],loc_legend[17],loc_legend[21],loc_legend[18],l_to_episode_id.arr);  
     else

		   if  (strcmp(l_to_episode_id.arr,"99999999")==0) 

		      fprintf(fp,"%12s %-22s: %-8s %-8s %-4s %-8s\n"," ",loc_legend[20],loc_legend[17],l_fr_episode_id.arr,loc_legend[18],loc_legend[22]);  
		   else

		   fprintf(fp,"%12s %-22s: %-8s %-8s %-4s %-8s\n"," ",loc_legend[20],loc_legend[17],l_fr_episode_id.arr,loc_legend[18],l_to_episode_id.arr);  

   
   
   

      fprintf(fp,"\f");



}

//----------------
print_page_header()
{
	l_str1.arr[0] = '\0';
	l_str1.len = 0;	

	l_str2.arr[0] = '\0';
	l_str2.len = 0;	

	l_str3.arr[0] = '\0';
	l_str3.len = 0;

	strcpy(l_mesg,loc_legend[6]);	

	/* EXEC SQL EXECUTE
	BEGIN
		blcommon.split_words(:l_mesg,15,'*',1,:l_str1,:l_str2);
		blcommon.split_words(:l_mesg,15,'*',2,:l_str1,:l_str3);       

		:l_str2 := ltrim(rtrim(:l_str2));
		:l_str3 := ltrim(rtrim(:l_str3));
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 12;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin blcommon . split_words ( :l_mesg , 15 , '*' , 1 , :l_s\
tr1 , :l_str2 ) ; blcommon . split_words ( :l_mesg , 15 , '*' , 2 , :l_str1 , \
:l_str3 ) ; :l_str2 := ltrim ( rtrim ( :l_str2 ) ) ; :l_str3 := ltrim ( rtrim \
( :l_str3 ) ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )367;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)l_mesg;
 sqlstm.sqhstl[0] = (unsigned int  )1000;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_str1;
 sqlstm.sqhstl[1] = (unsigned int  )2002;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&l_str2;
 sqlstm.sqhstl[2] = (unsigned int  )102;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&l_str3;
 sqlstm.sqhstl[3] = (unsigned int  )102;
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

	

	l_str1.arr[l_str1.len] = '\0';
	l_str2.arr[l_str2.len] = '\0';
	l_str3.arr[l_str3.len] = '\0';
    fprintf(fp,"\n");
    print_page_title();
	print_line(136);
	fprintf(fp,"\n");

	//fprintf(fp,"%-20.20s %-10.10s %-40.40s %-10.10s %-10.10s %-15.15s %-20.20s \n",loc_legend[2],loc_legend[3],loc_legend[4],loc_legend[24],loc_legend[304],loc_legend[5],loc_legend[9],loc_legend[6],loc_legend[7]);	
	
	fprintf(fp,"%-20.20s %-10.10s %-29.29s %-8.8s %-5.5s %-8.8s %-9.9s %14.14s %-20.20s \n",loc_legend[2],loc_legend[3],loc_legend[4],loc_legend[24],loc_legend[30],loc_legend[5],loc_legend[9],l_str2.arr,loc_legend[7]);		
		fprintf(fp,"%70.70s %-5.5s\n",loc_legend[25],loc_legend[31]);	
	if (l_str3.arr[0] != '\0')
	{
	fprintf(fp,"%-20.20s %-10.10s %-29.29s %-8.8s %-5.5s %-8.8s %-9.9s %14.14s %-20.20s \n",
			"","","","","","",l_str3.arr,"");	
		l_line_no = l_line_no+1;
	}

	print_line(136);
	fprintf(fp,"\n");
	l_line_no = l_line_no+3;
}

print_line(l_length)
int l_length;
{
	for(i=0;i<l_length;i++)
	{
		fprintf(fp,"-");
	}
}
get_header_dtls()
{
    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    /* EXEC SQL SELECT ACC_ENTITY_NAME,
				    USER,
				    TO_CHAR(SYSDATE, 'DD/MM/YYYY HH24:MI'),
					TO_CHAR(SYSDATE,'DD/MM/YYYY'),
					TO_CHAR(SYSDATE,'HH24:MI:SS')
		      INTO :d_acc_entity_name,
			  	   :d_user,
				   :d_sysdate,
				   :date,
				   :date_time
              FROM SY_ACC_ENTITY_LANG_VW
			 WHERE acc_entity_id = :nd_facility_id
			 AND upper(language_id)=upper(:p_language_id); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,USER ,TO_CHAR(SYSDATE,'DD/MM/YYYY\
 HH24:MI') ,TO_CHAR(SYSDATE,'DD/MM/YYYY') ,TO_CHAR(SYSDATE,'HH24:MI:SS') into \
:b0,:b1,:b2,:b3,:b4  from SY_ACC_ENTITY_LANG_VW where (acc_entity_id=:b5 and u\
pper(language_id)=upper(:b6))";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )398;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_acc_entity_name;
    sqlstm.sqhstl[0] = (unsigned int  )43;
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
    sqlstm.sqhstl[2] = (unsigned int  )23;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&date;
    sqlstm.sqhstl[3] = (unsigned int  )23;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&date_time;
    sqlstm.sqhstl[4] = (unsigned int  )23;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_facility_id;
    sqlstm.sqhstl[5] = (unsigned int  )5;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&p_language_id;
    sqlstm.sqhstl[6] = (unsigned int  )5;
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



	d_acc_entity_name.arr[d_acc_entity_name.len] = '\0';
	d_user.arr[d_user.len]                       = '\0';
	d_sysdate.arr[d_sysdate.len]                 = '\0';
    date.arr[date.len]							 = '\0';
    date_time.arr[date_time.len]				 = '\0';	

	return;

	err_exit:
	   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

	   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )441;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	   disp_message(ERR_MESG,"Oracle error at get_header_dtls() occured....");
	   disp_message(ERR_MESG, sqlca.sqlerrm.sqlerrmc);
	   proc_exit();
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
 sqlstm.offset = (unsigned int  )456;
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
