
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/blrinphy.pc"
};


static unsigned int sqlctx = 1288467683;


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
            void  *sqhstv[18];
   unsigned int   sqhstl[18];
            int   sqhsts[18];
            void  *sqindv[18];
            int   sqinds[18];
   unsigned int   sqharm[18];
   unsigned int   *sqharc[18];
   unsigned short  sqadto[18];
   unsigned short  sqtdso[18];
} sqlstm = {12,18};

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

 static const char *sq0006 = 
"D.PHYSICIAN_ID,A.PRT_GRP_HDR_CODE,A.PRT_GRP_LINE_CODE,A.EPISODE_TYPE order b\
y D.SHORT_NAME,D.PHYSICIAN_ID,A.PRT_GRP_HDR_CODE,A.PRT_GRP_LINE_CODE,A.EPISODE\
_TYPE            ";

 static const char *sq0007 = 
"select SHORT_DESC  from BL_BLNG_PRT_GRP_HDR where PRT_GRP_HDR_CODE=:b0      \
     ";

 static const char *sq0008 = 
"select SHORT_DESC  from BL_BLNG_PRT_GRP_LINE where (PRT_GRP_HDR_CODE=substr(\
:b0,1,(instr(:b0,' ',1)-1)) and PRT_GRP_LINE_CODE=substr(:b0,(instr(:b0,' ',1)\
+1)))           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,126,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,326,0,4,158,0,0,18,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,1,9,0,0,1,9,0,0,
123,0,0,3,128,0,4,228,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
154,0,0,4,0,0,30,256,0,0,0,0,0,1,0,
169,0,0,5,91,0,2,265,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
192,0,0,6,1195,0,9,332,0,0,14,14,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
263,0,0,6,0,0,13,514,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,4,0,0,
306,0,0,7,81,0,9,544,0,0,1,1,0,1,0,1,9,0,0,
325,0,0,7,0,0,13,549,0,0,1,0,0,1,0,2,9,0,0,
344,0,0,8,170,0,9,563,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
375,0,0,8,0,0,13,568,0,0,1,0,0,1,0,2,9,0,0,
394,0,0,9,96,0,4,823,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
417,0,0,10,165,0,6,830,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
};


/*****************************************************************************/
/* PROGRAM      : 	 BLRINPHY.PC                 			                 */
/*	                                                                         */
/* MODIFIED 	 :   PVSS Prasad/21-JUL-97			                         */
/*****************************************************************************/
  
#define REP_WIDTH 80
                         
#include <stdio.h>
#include <string.h>
#include <bl.h>
         
/* EXEC SQL BEGIN DECLARE SECTION; */ 
 

    /* VARCHAR uid_pwd						[91],
		    d_session_id				[16],
		    d_pgm_date					[14],
            rep_date					[20],
            comp_name					[50],
            oper_id						[21],
		    d_pgm_id					[10],
			l_pk_value					[100],
			l_translated_value			[201],
			p_language_id				[3],
			nd_facility_id				[3]; */ 
struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[16]; } d_session_id;

struct { unsigned short len; unsigned char arr[14]; } d_pgm_date;

struct { unsigned short len; unsigned char arr[20]; } rep_date;

struct { unsigned short len; unsigned char arr[50]; } comp_name;

struct { unsigned short len; unsigned char arr[21]; } oper_id;

struct { unsigned short len; unsigned char arr[10]; } d_pgm_id;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;


    /* VARCHAR nd_fm_trans_date           [11],
            nd_to_trans_date           [11],
            
            nd_fm_phy_id	           [16],
            nd_to_phy_id 	           [16],
            
            nd_fm_prt_grp_hdr          [3],
            nd_to_prt_grp_hdr          [3],

            nd_fm_prt_grp_hdr_1        [3],
            nd_to_prt_grp_hdr_1        [3],
            
            nd_fm_prt_grp_line         [3],
            nd_to_prt_grp_line         [3],
            nd_fm_income               [2],
            nd_to_income               [2],
            nd_report_type             [2],
			nd_operating_facility_id   [3],
			d_operating_facility_id    [3],
			nd_fr_facility             [3],
			nd_to_facility             [3]; */ 
struct { unsigned short len; unsigned char arr[11]; } nd_fm_trans_date;

struct { unsigned short len; unsigned char arr[11]; } nd_to_trans_date;

struct { unsigned short len; unsigned char arr[16]; } nd_fm_phy_id;

struct { unsigned short len; unsigned char arr[16]; } nd_to_phy_id;

struct { unsigned short len; unsigned char arr[3]; } nd_fm_prt_grp_hdr;

struct { unsigned short len; unsigned char arr[3]; } nd_to_prt_grp_hdr;

struct { unsigned short len; unsigned char arr[3]; } nd_fm_prt_grp_hdr_1;

struct { unsigned short len; unsigned char arr[3]; } nd_to_prt_grp_hdr_1;

struct { unsigned short len; unsigned char arr[3]; } nd_fm_prt_grp_line;

struct { unsigned short len; unsigned char arr[3]; } nd_to_prt_grp_line;

struct { unsigned short len; unsigned char arr[2]; } nd_fm_income;

struct { unsigned short len; unsigned char arr[2]; } nd_to_income;

struct { unsigned short len; unsigned char arr[2]; } nd_report_type;

struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[3]; } d_operating_facility_id;

struct { unsigned short len; unsigned char arr[3]; } nd_fr_facility;

struct { unsigned short len; unsigned char arr[3]; } nd_to_facility;

            
    /* VARCHAR d_short_name               [16],  
            d_phy_id                   [16],
            d_episode_type             [2],
            d_prt_grp_hdr_code         [3],
            d_prt_grp_hdr_line_code    [6]; */ 
struct { unsigned short len; unsigned char arr[16]; } d_short_name;

struct { unsigned short len; unsigned char arr[16]; } d_phy_id;

struct { unsigned short len; unsigned char arr[2]; } d_episode_type;

struct { unsigned short len; unsigned char arr[3]; } d_prt_grp_hdr_code;

struct { unsigned short len; unsigned char arr[6]; } d_prt_grp_hdr_line_code;


    /* VARCHAR d_prev_phy_id	           [16],
            d_prev_grp_hdr_code        [3],
            d_prev_grp_hdr_line_code   [7]; */ 
struct { unsigned short len; unsigned char arr[16]; } d_prev_phy_id;

struct { unsigned short len; unsigned char arr[3]; } d_prev_grp_hdr_code;

struct { unsigned short len; unsigned char arr[7]; } d_prev_grp_hdr_line_code;


    /* VARCHAR d_prt_grp_line_desc        [16]; */ 
struct { unsigned short len; unsigned char arr[16]; } d_prt_grp_line_desc;


   double   d_net_charge_amt;

   int i;
	
	char g_facility_id[3];

    char filename[150];
	char x_msg[200];
	char loc_legend[999][201];
	char l_mesg[200];


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

FILE *f1;

int page_no = 0,
    line_no,
    first_line,
    g_count;


char hdr_line1[REP_WIDTH+1],
     hdr_line2[REP_WIDTH+1],
     hdr_line3[REP_WIDTH+1],
     hdr_line4[REP_WIDTH+1];

double inpatient_line_tot =0,
       outpatient_line_tot =0,
       combined_line_tot =0,
       inpatient_tot,
       outpatient_tot,
       combined_tot,
       g_inpatient_tot =0,
       g_outpatient_tot=0,
       g_combined_tot  =0;
       

void proc_main(argc,argv)
int argc;
char *argv[];
{
    if(argc < 5) {
        disp_message(ERR_MESG,"BLRTRSUM : Usage BLRTRSUM userid/password session_id pgm_date facility_id \n");
        proc_exit();
    }


    strcpy(uid_pwd.arr,argv[1]);
    uid_pwd.len = strlen(uid_pwd.arr);

    strcpy(d_session_id.arr,argv[2]);
    d_session_id.len = strlen(d_session_id.arr);
    
    strcpy(d_pgm_date.arr,argv[3]);
    d_pgm_date.len = strlen(d_pgm_date.arr);

	strcpy(nd_facility_id.arr,argv[4]);
    nd_facility_id.len = strlen(nd_facility_id.arr);
    strcpy(g_facility_id,nd_facility_id.arr);

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



    if(OERROR) {
		disp_message(ORA_MESG,"Unable to connect to oracle.\n");
		proc_exit();
    }


    set_meduser_role();

	strcpy(p_language_id.arr,l_language_id.arr);

    nd_fm_trans_date.arr[0]    = '\0';
    nd_to_trans_date.arr[0]    = '\0';

    nd_fm_phy_id.arr[0]   	   = '\0';
    nd_to_phy_id.arr[0]    	   = '\0';
                               
    nd_fm_prt_grp_hdr.arr[0]   = '\0';
    nd_to_prt_grp_hdr.arr[0]   = '\0';
                              
    nd_fm_prt_grp_hdr_1.arr[0] = '\0';
    nd_to_prt_grp_hdr_1.arr[0] = '\0';
    
    nd_fm_prt_grp_line.arr[0]  = '\0';
    nd_to_prt_grp_line.arr[0]  = '\0';     
    
    nd_fm_income.arr[0]        = '\0';
    nd_to_income.arr[0]        = '\0';
    
    nd_report_type.arr[0]      = '\0';
    
 	/* EXEC SQL SELECT OPERATING_FACILITY_ID,
					PARAM1,
					PARAM2,
					PARAM3,
					PARAM4,
					PARAM5,
					PARAM6,
					PARAM7,
					PARAM8,
					PARAM9,
					PARAM10,
					PARAM11,
					PARAM12,
					PARAM13,
					PARAM14,
					PARAM15
			 INTO   :nd_operating_facility_id,
			        :nd_fm_trans_date,
	                :nd_to_trans_date,
	                :nd_fm_phy_id,
	                :nd_to_phy_id,
	                :nd_fm_prt_grp_hdr,
                    :nd_to_prt_grp_hdr,
                    :nd_fm_prt_grp_hdr_1,
    		        :nd_to_prt_grp_hdr_1,
		            :nd_fm_prt_grp_line,
            		:nd_to_prt_grp_line,
            		:nd_report_type,
            		:nd_fm_income,
            		:nd_to_income,
					:nd_fr_facility,
					:nd_to_facility
     		 FROM   SY_PROG_PARAM
			 WHERE  PGM_ID     = 'BLRINPHY'
			 AND    PGM_DATE   = :d_pgm_date
			 AND    SESSION_ID = TO_NUMBER(:d_session_id); */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 18;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,PARAM\
4 ,PARAM5 ,PARAM6 ,PARAM7 ,PARAM8 ,PARAM9 ,PARAM10 ,PARAM11 ,PARAM12 ,PARAM13 \
,PARAM14 ,PARAM15 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12,\
:b13,:b14,:b15  from SY_PROG_PARAM where ((PGM_ID='BLRINPHY' and PGM_DATE=:b16\
) and SESSION_ID=TO_NUMBER(:b17))";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )36;
  sqlstm.selerr = (unsigned short)1;
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
  sqlstm.sqhstv[1] = (         void  *)&nd_fm_trans_date;
  sqlstm.sqhstl[1] = (unsigned int  )13;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_to_trans_date;
  sqlstm.sqhstl[2] = (unsigned int  )13;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_fm_phy_id;
  sqlstm.sqhstl[3] = (unsigned int  )18;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_to_phy_id;
  sqlstm.sqhstl[4] = (unsigned int  )18;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_fm_prt_grp_hdr;
  sqlstm.sqhstl[5] = (unsigned int  )5;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_to_prt_grp_hdr;
  sqlstm.sqhstl[6] = (unsigned int  )5;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_fm_prt_grp_hdr_1;
  sqlstm.sqhstl[7] = (unsigned int  )5;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&nd_to_prt_grp_hdr_1;
  sqlstm.sqhstl[8] = (unsigned int  )5;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&nd_fm_prt_grp_line;
  sqlstm.sqhstl[9] = (unsigned int  )5;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&nd_to_prt_grp_line;
  sqlstm.sqhstl[10] = (unsigned int  )5;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&nd_report_type;
  sqlstm.sqhstl[11] = (unsigned int  )4;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&nd_fm_income;
  sqlstm.sqhstl[12] = (unsigned int  )4;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&nd_to_income;
  sqlstm.sqhstl[13] = (unsigned int  )4;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&nd_fr_facility;
  sqlstm.sqhstl[14] = (unsigned int  )5;
  sqlstm.sqhsts[14] = (         int  )0;
  sqlstm.sqindv[14] = (         void  *)0;
  sqlstm.sqinds[14] = (         int  )0;
  sqlstm.sqharm[14] = (unsigned int  )0;
  sqlstm.sqadto[14] = (unsigned short )0;
  sqlstm.sqtdso[14] = (unsigned short )0;
  sqlstm.sqhstv[15] = (         void  *)&nd_to_facility;
  sqlstm.sqhstl[15] = (unsigned int  )5;
  sqlstm.sqhsts[15] = (         int  )0;
  sqlstm.sqindv[15] = (         void  *)0;
  sqlstm.sqinds[15] = (         int  )0;
  sqlstm.sqharm[15] = (unsigned int  )0;
  sqlstm.sqadto[15] = (unsigned short )0;
  sqlstm.sqtdso[15] = (unsigned short )0;
  sqlstm.sqhstv[16] = (         void  *)&d_pgm_date;
  sqlstm.sqhstl[16] = (unsigned int  )16;
  sqlstm.sqhsts[16] = (         int  )0;
  sqlstm.sqindv[16] = (         void  *)0;
  sqlstm.sqinds[16] = (         int  )0;
  sqlstm.sqharm[16] = (unsigned int  )0;
  sqlstm.sqadto[16] = (unsigned short )0;
  sqlstm.sqtdso[16] = (unsigned short )0;
  sqlstm.sqhstv[17] = (         void  *)&d_session_id;
  sqlstm.sqhstl[17] = (unsigned int  )18;
  sqlstm.sqhsts[17] = (         int  )0;
  sqlstm.sqindv[17] = (         void  *)0;
  sqlstm.sqinds[17] = (         int  )0;
  sqlstm.sqharm[17] = (unsigned int  )0;
  sqlstm.sqadto[17] = (unsigned short )0;
  sqlstm.sqtdso[17] = (unsigned short )0;
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



    if(OERROR || NO_DATA_FOUND)
	    err_mesg("SELECT failed on table  SY_PROG_PARAM",0,"");

    nd_fm_trans_date.arr[nd_fm_trans_date.len]       = '\0';
    nd_to_trans_date.arr[nd_to_trans_date.len]       = '\0';
    
    nd_fm_income.arr[nd_fm_income.len]				 = '\0';
    nd_to_income.arr[nd_to_income.len]				 = '\0';
    
    nd_fm_phy_id.arr[nd_fm_phy_id.len] 		         = '\0';
    nd_to_phy_id.arr[nd_to_phy_id.len]		         = '\0';
                               
    nd_fm_prt_grp_hdr.arr[nd_fm_prt_grp_hdr.len]     = '\0';
    nd_to_prt_grp_hdr.arr[nd_to_prt_grp_hdr.len]     = '\0';
                              
    nd_fm_prt_grp_hdr_1.arr[nd_fm_prt_grp_hdr_1.len] = '\0';
    nd_to_prt_grp_hdr_1.arr[nd_to_prt_grp_hdr_1.len] = '\0';
    
    nd_fm_prt_grp_line.arr[nd_fm_prt_grp_line.len]   = '\0';
    nd_to_prt_grp_line.arr[nd_to_prt_grp_line.len]   = '\0';

    nd_report_type.arr[nd_report_type.len] 	         = '\0';

    strcpy(filename,WORKING_DIR);
    strcat(filename,"blrinphy.lis");
	strcpy(g_facility_id, nd_operating_facility_id.arr);

    if((f1=fopen(filename,"w")) == NULL) 
      {
       disp_message(ERR_MESG,"Error in opening output file...\n");
       proc_exit();
      }

    /* EXEC SQL SELECT ACCOUNTING_NAME,
				    TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
                    USER 
		     INTO   :comp_name,
				    :rep_date,
				    :oper_id
		     FROM   SY_ACC_ENTITY
			 WHERE  ACC_ENTITY_ID = :nd_operating_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 18;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACCOUNTING_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:\
MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b3";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )123;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&comp_name;
    sqlstm.sqhstl[0] = (unsigned int  )52;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&rep_date;
    sqlstm.sqhstl[1] = (unsigned int  )22;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&oper_id;
    sqlstm.sqhstl[2] = (unsigned int  )23;
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
	    err_mesg("SELECT failed on table  SY_ACC_ENTITY",0,"");

    comp_name.arr[comp_name.len] = '\0';
    rep_date.arr[rep_date.len]   = '\0';
    oper_id.arr[oper_id.len]     = '\0';

    line_no=1;

    decl_curs();

	fetch_legend_value();

    do_report();

    fclose(f1);

    del_parm();

    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 18;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )154;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    return;
}

/*****************************************************************/
del_parm()
{

    /* EXEC SQL DELETE SY_PROG_PARAM
	         WHERE  PGM_ID     = 'BLRINPHY' 
	         AND    PGM_DATE   = :d_pgm_date
	         AND    SESSION_ID = :d_session_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 18;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='BLRINPHY' and\
 PGM_DATE=:b0) and SESSION_ID=:b1)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )169;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_pgm_date;
    sqlstm.sqhstl[0] = (unsigned int  )16;
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
        err_mesg("DELETE failed on table SY_PROG_PARAM",0,""); 
}
/*****************************************************************/
decl_curs()  
{
    /* EXEC SQL DECLARE TRANS_LIST_CUR CURSOR FOR
          SELECT A.OPERATING_FACILITY_ID,
		         A.EPISODE_TYPE, 
                 D.SHORT_NAME,	    
                 D.PHYSICIAN_ID,
			     A.PRT_GRP_HDR_CODE, 
			     A.PRT_GRP_HDR_CODE || ' ' || A.PRT_GRP_LINE_CODE,
			     SUM(NVL(A.ORG_NET_CHARGE_AMT,0)) 
	      FROM   BL_PATIENT_CHARGES_FOLIO A,BL_BLNG_PRT_GRP_HDR C, 
	             SY_PHYSICIAN_MAST D
		WHERE   (NVL(A.PACKAGE_IND,'X') = 'S' 
				         OR 
				( AVAILED_IND IN('U','Y') )
				 //( NVL(PACKAGE_TRX_IND,'X')  = 'N' AND 
		           //NVL(PACKAGE_IND,'X')      = 'P' AND 
			       //NVL(INS_PKG_PAT_IND,'X')  = 'K')
				)           
          AND    A.TRX_FINALIZE_IND 	= 'Y'       
          AND    A.PHYSICIAN_ID         = D.PHYSICIAN_ID 
          AND    A.PRT_GRP_HDR_CODE     = C.PRT_GRP_HDR_CODE
          AND    TRUNC(A.TRX_DATE)  BETWEEN
	             TO_DATE(NVL(:nd_fm_trans_date,'01/01/1000'),'DD/MM/YYYY')
		  AND    TO_DATE(NVL(:nd_to_trans_date,'01/01/3000'),'DD/MM/YYYY')
	      AND    A.PHYSICIAN_ID     BETWEEN
	             NVL(:nd_fm_phy_id,'!!!!!!')
		  AND    NVL(:nd_to_phy_id,'~~~~~~')
	      AND    A.PRT_GRP_HDR_CODE BETWEEN
	             NVL(:nd_fm_prt_grp_hdr,'!!')
		  AND    NVL(:nd_to_prt_grp_hdr,'~~')
	      AND    A.PRT_GRP_HDR_CODE BETWEEN
	             NVL(:nd_fm_prt_grp_hdr_1,'!!')
		  AND    NVL(:nd_to_prt_grp_hdr_1,'~~')
	      AND    A.PRT_GRP_LINE_CODE BETWEEN
	             NVL(:nd_fm_prt_grp_line,'!!')
    	  AND    NVL(:nd_to_prt_grp_line,'~~') 
	      AND    NVL(C.INCOME_YN,'N')
          BETWEEN  :nd_fm_income 
          AND      :nd_to_income
		  AND    A.OPERATING_FACILITY_ID BETWEEN NVL(:nd_fr_facility, A.OPERATING_FACILITY_ID)
		                               AND     NVL(:nd_to_facility, A.OPERATING_FACILITY_ID)
          GROUP BY A.OPERATING_FACILITY_ID, D.SHORT_NAME,D.PHYSICIAN_ID,A.PRT_GRP_HDR_CODE,A.PRT_GRP_LINE_CODE,A.EPISODE_TYPE 
          ORDER BY D.SHORT_NAME,D.PHYSICIAN_ID,A.PRT_GRP_HDR_CODE,A.PRT_GRP_LINE_CODE,A.EPISODE_TYPE ; */ 

    
    
    /* EXEC SQL DECLARE PRT_GRP_LINE_CUR CURSOR FOR
		     SELECT  SHORT_DESC 
		     FROM    BL_BLNG_PRT_GRP_HDR
		     WHERE   PRT_GRP_HDR_CODE  = :d_prev_grp_hdr_code; */ 


    /* EXEC SQL DECLARE PRT_GRP_HDR_LINE_CUR CURSOR FOR
		     SELECT  SHORT_DESC 
		     FROM    BL_BLNG_PRT_GRP_LINE
		     WHERE   PRT_GRP_HDR_CODE  =
		             substr(:d_prev_grp_hdr_line_code,1,instr(:d_prev_grp_hdr_line_code,' ',1) -1)
		     AND     PRT_GRP_LINE_CODE = substr(:d_prev_grp_hdr_line_code,instr(:d_prev_grp_hdr_line_code,' ',1)+1); */ 
       
		     
   /* EXEC SQL OPEN TRANS_LIST_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 18;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlbuft((void **)0, 
     "select A.OPERATING_FACILITY_ID ,A.EPISODE_TYPE ,D.SHORT_NAME ,D.PHYSIC\
IAN_ID ,A.PRT_GRP_HDR_CODE ,((A.PRT_GRP_HDR_CODE||' ')||A.PRT_GRP_LINE_CODE)\
 ,sum(NVL(A.ORG_NET_CHARGE_AMT,0))  from BL_PATIENT_CHARGES_FOLIO A ,BL_BLNG\
_PRT_GRP_HDR C ,SY_PHYSICIAN_MAST D where (((((((((((NVL(A.PACKAGE_IND,'X')=\
'S' or AVAILED_IND in ('U','Y')) and A.TRX_FINALIZE_IND='Y') and A.PHYSICIAN\
_ID=D.PHYSICIAN_ID) and A.PRT_GRP_HDR_CODE=C.PRT_GRP_HDR_CODE) and TRUNC(A.T\
RX_DATE) between TO_DATE(NVL(:b0,'01/01/1000'),'DD/MM/YYYY') and TO_DATE(NVL\
(:b1,'01/01/3000'),'DD/MM/YYYY')) and A.PHYSICIAN_ID between NVL(:b2,'!!!!!!\
') and NVL(:b3,'~~~~~~')) and A.PRT_GRP_HDR_CODE between NVL(:b4,'!!') and N\
VL(:b5,'~~')) and A.PRT_GRP_HDR_CODE between NVL(:b6,'!!') and NVL(:b7,'~~')\
) and A.PRT_GRP_LINE_CODE between NVL(:b8,'!!') and NVL(:b9,'~~')) and NVL(C\
.INCOME_YN,'N') between :b10 and :b11) and A.OPERATING_FACILITY_ID between N\
VL(:b12,A.OPERATING_FACILITY_ID) and NVL(:b13,A.OPERATING_FACILITY_ID)) grou\
p by A.OPERATING_FACILITY_ID,D.SHORT_NAME,");
   sqlstm.stmt = sq0006;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )192;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqcmod = (unsigned int )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_fm_trans_date;
   sqlstm.sqhstl[0] = (unsigned int  )13;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_to_trans_date;
   sqlstm.sqhstl[1] = (unsigned int  )13;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_fm_phy_id;
   sqlstm.sqhstl[2] = (unsigned int  )18;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_to_phy_id;
   sqlstm.sqhstl[3] = (unsigned int  )18;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_fm_prt_grp_hdr;
   sqlstm.sqhstl[4] = (unsigned int  )5;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_to_prt_grp_hdr;
   sqlstm.sqhstl[5] = (unsigned int  )5;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_fm_prt_grp_hdr_1;
   sqlstm.sqhstl[6] = (unsigned int  )5;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_to_prt_grp_hdr_1;
   sqlstm.sqhstl[7] = (unsigned int  )5;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_fm_prt_grp_line;
   sqlstm.sqhstl[8] = (unsigned int  )5;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_to_prt_grp_line;
   sqlstm.sqhstl[9] = (unsigned int  )5;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_fm_income;
   sqlstm.sqhstl[10] = (unsigned int  )4;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&nd_to_income;
   sqlstm.sqhstl[11] = (unsigned int  )4;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&nd_fr_facility;
   sqlstm.sqhstl[12] = (unsigned int  )5;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&nd_to_facility;
   sqlstm.sqhstl[13] = (unsigned int  )5;
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



   if(OERROR)
	err_mesg("OPEN failed on cursor TRANS_LIST_CUR",0,"");
}

/*****************************************************************/

do_report()
{
    int cnt,hdr_cnt,first;
    hdr_cnt = 0;
    line_no = 1;
    g_count = 1;
    init_prev_values();
    init_phy_totals();
    first = 1;
    form_hdr();
    while(fetch_trans_list())
     {
   	  if(phy_brk()) { 
	    if(!first) {
          print_rec();
          print_phy_totals(); 
          calculate_g_phy_tot();
          init_phy_totals();
          init_line_amt();
          fprintf(f1,"");
          form_hdr();
          put_col_heading();
          init_grp_values();
          first = 1;
          //++page_no;
	      }
	     else
           put_col_heading();
	    } 

	  /*** Print Based on the group type ***/
	  if(strcmp(nd_report_type.arr,"G") == 0) {    
	     if(prt_grp_brk()) {
	        if (!first) {
               print_rec();
               init_grp_values();
               init_line_amt();
             } 
          }       
       }    
      else
       if(prt_grp_brk()) {
          if (!first) {
             print_rec();
             init_grp_values();
             init_line_amt();
           } 
         }  

      calculate_amt();         
      calculate_phy_tot();
         
      copy_val();
      copy_grp_val();
      first = 0;
	  hdr_cnt = 1;
	  chk_break(9);
    }                 /* end of while fetch trans list */

    if(hdr_cnt) {
    print_rec();
	print_phy_totals();  
	calculate_g_phy_tot();
	print_grand_totals();
    print_end_of_rep();
    }
}
/*****************************************************************/
calculate_amt()
{                                                            
 if(strcmp(d_episode_type.arr,"I") == 0 || strcmp(d_episode_type.arr,"D") == 0  )
   inpatient_line_tot = inpatient_line_tot  + d_net_charge_amt;
 else if(strcmp(d_episode_type.arr,"O") == 0 || strcmp(d_episode_type.arr,"E") == 0 )
   outpatient_line_tot = outpatient_line_tot  + d_net_charge_amt;
 combined_line_tot     = inpatient_line_tot + outpatient_line_tot;
}
/*****************************************************************/
calculate_phy_tot()
{                                                            
 if(strcmp(d_episode_type.arr,"I") == 0 || strcmp(d_episode_type.arr,"D") == 0 )
   inpatient_tot = inpatient_tot  + d_net_charge_amt;
 else if(strcmp(d_episode_type.arr,"O") == 0 || strcmp(d_episode_type.arr,"E") == 0 ) 
   outpatient_tot = outpatient_tot  + d_net_charge_amt;
 combined_tot   = inpatient_tot + outpatient_tot;
}
/******************************************************************/
calculate_g_phy_tot()
{                                                            
   g_inpatient_tot   = g_inpatient_tot    + inpatient_tot;
   g_outpatient_tot  = g_outpatient_tot  + outpatient_tot;
   g_combined_tot    = g_inpatient_tot + g_outpatient_tot;
}
/*****************************************************************/
print_rec()
{
   char s_net_amt[20], s_gross_amt[20], s_disc_amt[20];

   print_formated(s_net_amt,     inpatient_line_tot);
   print_formated(s_gross_amt,   outpatient_line_tot);
   print_formated(s_disc_amt,    combined_line_tot);
   
   chk_break(1);

   if(strcmp(nd_report_type.arr,"G") == 0){     
      fetch_prt_line_desc();
      fprintf(f1,"%-2s %-2s  %-15s            %14s  %14s %14s\n",
        		d_operating_facility_id.arr,d_prev_grp_hdr_code.arr,d_prt_grp_line_desc.arr,
		        s_net_amt,s_gross_amt,s_disc_amt);
     }		        
   else  
     {                   
      fetch_prt_hdr_line_desc(); 
      fprintf(f1,"%-2s %-5s  %-15s         %14s  %14s %14s\n",
        		d_operating_facility_id.arr,d_prev_grp_hdr_line_code.arr,d_prt_grp_line_desc.arr,
		        s_net_amt,s_gross_amt,s_disc_amt);
	 }	        
   		        
   line_no ++;
}
/*****************************************************************/
print_phy_totals()
{
 char  s_net_amt[20], s_gross_amt[20], s_disc_amt[20];

 print_formated(s_net_amt,   inpatient_tot);
 print_formated(s_gross_amt, outpatient_tot);
 print_formated(s_disc_amt,  combined_tot);
 chk_break(3);                         
 fprintf(f1,"                              --------------------------------------------------\n");
 fprintf(f1,"                                  %14s  %14s %14s\n",s_net_amt,s_gross_amt,s_disc_amt);
 fprintf(f1,"                              ==================================================\n\n\n");

 line_no += 6;
}

/*****************************************************************/
print_grand_totals()
{
 char s_net_amt[20], s_gross_amt[20], s_disc_amt[20];

 print_formated(s_net_amt,   g_inpatient_tot);
 print_formated(s_gross_amt, g_outpatient_tot);
 print_formated(s_disc_amt,  g_combined_tot);

 fprintf(f1,"");
 line_no = 1;
 form_hdr();

 fprintf(f1,"\n\n\n\n\n"); 
 fprintf(f1,"                                      %3s %s %3s       %3s %s %3s          %5s\n",loc_legend[220],"&",loc_legend[230],loc_legend[240],"&",loc_legend[250],loc_legend[260]);
 fprintf(f1,"                              --------------------------------------------------\n");
 fprintf(f1,"      %11s                 %14s  %14s %14s\n",loc_legend[270],s_net_amt,s_gross_amt,s_disc_amt);
 fprintf(f1,"                              ==================================================\n\n\n");
 
 line_no += 4;
}
/*****************************************************************/
fetch_trans_list()
{ 
    d_episode_type.arr[0]  		    = '\0';
    d_prt_grp_hdr_code.arr[0]       = '\0';
    d_prt_grp_hdr_line_code.arr[0]  = '\0';
    d_short_name.arr[0]		        = '\0';
    d_phy_id.arr[0]                 = '\0';
    
    d_episode_type.len     			= 0;
    d_prt_grp_hdr_code.len      	= 0;
    d_prt_grp_hdr_line_code.len     = 0;
    d_short_name.len                = 0;
    d_phy_id.len				    = 0;
    
    d_net_charge_amt 	      		= 0;
    

    /* EXEC SQL FETCH TRANS_LIST_CUR INTO
                   :d_operating_facility_id,
				   :d_episode_type,
                   :d_short_name, 
                   :d_phy_id,
                   :d_prt_grp_hdr_code,
                   :d_prt_grp_hdr_line_code,
				   :d_net_charge_amt; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 18;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )263;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_operating_facility_id;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_episode_type;
    sqlstm.sqhstl[1] = (unsigned int  )4;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_short_name;
    sqlstm.sqhstl[2] = (unsigned int  )18;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_phy_id;
    sqlstm.sqhstl[3] = (unsigned int  )18;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_prt_grp_hdr_code;
    sqlstm.sqhstl[4] = (unsigned int  )5;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_prt_grp_hdr_line_code;
    sqlstm.sqhstl[5] = (unsigned int  )8;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_net_charge_amt;
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



    
    if(OERROR)
	err_mesg("FETCH failed on cursor TRANS_LIST_CUR",0,"");

    if(NO_DATA_FOUND)
	return 0;

    d_episode_type.arr[d_episode_type.len]                    = '\0';
    d_short_name.arr[d_short_name.len]						  = '\0';
    d_phy_id.arr[d_phy_id.len]								  = '\0';
    d_prt_grp_hdr_code.arr[d_prt_grp_hdr_code.len]            = '\0';
    d_prt_grp_hdr_line_code.arr[d_prt_grp_hdr_line_code.len]  = '\0';
    return 1;

}
/*****************************************************************/
fetch_prt_line_desc()
{
    d_prt_grp_line_desc.arr[0]  = '\0';
    d_prt_grp_line_desc.len     = 0;

    /* EXEC SQL OPEN PRT_GRP_LINE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 18;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0007;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )306;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&d_prev_grp_hdr_code;
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



    if(OERROR)
	err_mesg("OPEN failed on cursor PRT_GRP_LINE_CUR",0,"");

    /* EXEC SQL FETCH PRT_GRP_LINE_CUR
    	     INTO  :d_prt_grp_line_desc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 18;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )325;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_prt_grp_line_desc;
    sqlstm.sqhstl[0] = (unsigned int  )18;
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
	err_mesg("FETCH failed on cursor PRT_GRP_LINE_CUR",0,"");

    d_prt_grp_line_desc.arr[d_prt_grp_line_desc.len]  = '\0';
}
/*****************************************************************/
fetch_prt_hdr_line_desc()
{
    d_prt_grp_line_desc.arr[0]  = '\0';
    d_prt_grp_line_desc.len     = 0;

    /* EXEC SQL OPEN PRT_GRP_HDR_LINE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 18;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0008;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )344;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&d_prev_grp_hdr_line_code;
    sqlstm.sqhstl[0] = (unsigned int  )9;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_prev_grp_hdr_line_code;
    sqlstm.sqhstl[1] = (unsigned int  )9;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_prev_grp_hdr_line_code;
    sqlstm.sqhstl[2] = (unsigned int  )9;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_prev_grp_hdr_line_code;
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



    if(OERROR)
	err_mesg("OPEN failed on cursor PRT_GRP_LINE_CUR",0,"");

    /* EXEC SQL FETCH PRT_GRP_HDR_LINE_CUR
    	     INTO  :d_prt_grp_line_desc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 18;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )375;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_prt_grp_line_desc;
    sqlstm.sqhstl[0] = (unsigned int  )18;
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
	err_mesg("FETCH failed on cursor PRT_GRP_LINE_CUR",0,"");

    d_prt_grp_line_desc.arr[d_prt_grp_line_desc.len]  = '\0';
}
/*****************************************************************/
put_col_heading()
{
    fprintf(f1,"\n\n%6s : %-15s    %-6s",loc_legend[280], d_short_name.arr,d_phy_id.arr);
    fprintf(f1,"\n\n");
    fprintf(f1,"%5s  %15s                %3s %s %3s       %3s %s %3s          %s\n\n",loc_legend[200],loc_legend[210],loc_legend[220],"&",loc_legend[230],loc_legend[240],"&",loc_legend[250],loc_legend[260]);
    
    line_no=9;
} 
/*****************************************************************/
chk_break(nol)
int nol;
{
	if(line_no+nol >= 55) {
      fprintf(f1,"");
      line_no = 1;
      g_count = 1;
	  form_hdr();
	  put_col_heading();
     }
}
/*****************************************************************/
print_end_of_rep()
{
    fprintf(f1,"\n\n                       ** END OF REPORT **\n");
}
/*****************************************************************/
init_prev_values()
{
  d_prev_phy_id.arr[0]  = '\0';
  d_prev_phy_id.len     = 0;
}
/*****************************************************************/
copy_val()
{
  strcpy(d_prev_phy_id.arr,d_phy_id.arr);
  d_prev_phy_id.len = strlen(d_prev_phy_id.arr);
}

/*****************************************************************/
copy_grp_val()
{ 
if (strcmp(nd_report_type.arr,"G") ==  0) {
  strcpy(d_prev_grp_hdr_code.arr,d_prt_grp_hdr_code.arr);
  d_prev_grp_hdr_code.len = strlen(d_prt_grp_hdr_code.arr);  
  }
else 
  {
  strcpy(d_prev_grp_hdr_line_code.arr,d_prt_grp_hdr_line_code.arr);
  d_prev_grp_hdr_line_code.len = strlen(d_prt_grp_hdr_line_code.arr);
  } 
}
/*****************************************************************/
prt_grp_brk()
{ 
 if(strcmp(nd_report_type.arr,"G") == 0)     
   return (strcmp(d_prev_grp_hdr_code.arr,d_prt_grp_hdr_code.arr));
 else
   return (strcmp(d_prev_grp_hdr_line_code.arr,d_prt_grp_hdr_line_code.arr));
}
/*****************************************************************/
init_grp_values()
{
  d_prev_grp_hdr_code.arr[0]       = '\0';
  d_prev_grp_hdr_code.len          = 0;
  d_prev_grp_hdr_line_code.arr[0]  = '\0';
  d_prev_grp_hdr_line_code.len    = 0;
}
/*****************************************************************/
phy_brk()
{
  return (strcmp(d_prev_phy_id.arr,d_phy_id.arr));
}
/*****************************************************************/
init_line_amt()
{
  inpatient_line_tot    = 0;
  outpatient_line_tot   = 0;
  combined_line_tot     = 0;
}
/*****************************************************************/

init_phy_totals()
{
  inpatient_tot    = 0;
  outpatient_tot   = 0;
  combined_tot     = 0;
}
/*****************************************************************/
print_formated(s_amt, l_amt)
double l_amt;
char *s_amt;
{
  if(l_amt < 0){
     put_val(s_amt,-l_amt);
     format_amt(s_amt);
     strcat(s_amt,"-");
   }
 else {
       put_val(s_amt,l_amt);
       format_amt(s_amt);
       strcat(s_amt," ");
    }
}
/*****************************************************************/
form_hdr()
{

    static int first = 1;
    char buf[17];
    char ctmp[50];
    int col;
    char fm_phy_id     [20];
    char to_phy_id     [20];
    char fm_prt_hdr    [20];
    char to_prt_hdr    [20];
    char fm_prt_hdr_1  [20];
    char to_prt_hdr_1  [20];
    char fm_prt_line   [20];
    char to_prt_line   [20];
    char income_type   [20];

  if(strcmp(nd_fm_phy_id.arr,"!!!!!!") == 0)
    strcpy(fm_phy_id,loc_legend[190]);
  else 
    strcpy(fm_phy_id, nd_fm_phy_id.arr);      
      
  if(strcmp(nd_to_phy_id.arr,"~~~~~~") == 0)
    strcpy(to_phy_id,loc_legend[180]);
  else 
    strcpy(to_phy_id, nd_to_phy_id.arr);
          

  if(strcmp(nd_fm_prt_grp_hdr.arr,"!!") == 0)
    strcpy(fm_prt_hdr,loc_legend[190]);
  else 
    strcpy(fm_prt_hdr, nd_fm_prt_grp_hdr.arr); 
    
  if(strcmp(nd_to_prt_grp_hdr.arr,"~~") == 0)
    strcpy(to_prt_hdr,loc_legend[180]);
  else 
    strcpy(to_prt_hdr, nd_to_prt_grp_hdr.arr);
    

  if(strcmp(nd_fm_prt_grp_hdr_1.arr,"!!") == 0)
    strcpy(fm_prt_hdr_1, "");
  else 
    strcpy(fm_prt_hdr_1, nd_fm_prt_grp_hdr_1.arr); 
    
  if(strcmp(nd_to_prt_grp_hdr_1.arr,"~~") == 0)
    strcpy(to_prt_hdr_1, "");
  else 
    strcpy(to_prt_hdr_1, nd_to_prt_grp_hdr_1.arr);
    
    
  if(strcmp(nd_fm_prt_grp_line.arr,"!!") == 0)
    strcpy(fm_prt_line, "");
  else 
    strcpy(fm_prt_line, nd_fm_prt_grp_line.arr); 
    
  if(strcmp(nd_to_prt_grp_line.arr,"~~") == 0)
    strcpy(to_prt_line, "");
  else 
    strcpy(to_prt_line, nd_to_prt_grp_line.arr);
    
  if(strcmp(nd_fm_income.arr,"!") == 0)
    strcpy(income_type,loc_legend[140]);
  else if (strcmp(nd_fm_income.arr,"Y") == 0)
    strcpy(income_type,loc_legend[160]);
  else  
    strcpy(income_type,loc_legend[170]);
    
                 
   ++page_no;
   if(first) {
        memset(hdr_line1,' ',REP_WIDTH+1);
        memset(hdr_line2,' ',REP_WIDTH+1);

        strcpy(hdr_line1,"MDL : ");
		strcat(hdr_line1,loc_legend[150]);
        col = (int)(REP_WIDTH-strlen(comp_name.arr))/2;
        strncpy(hdr_line1+col,comp_name.arr,strlen(comp_name.arr));
        col = (REP_WIDTH-strlen(rep_date.arr));
        strcpy(hdr_line1+col,rep_date.arr);
    
        strncpy(hdr_line2,"OPR :",5);
        strcpy(hdr_line2+6,oper_id.arr);

	first = 0;
    }

    memset(hdr_line3,' ',REP_WIDTH+1);

    strcpy(hdr_line3,"REP : ");
	strcat(hdr_line3,loc_legend[40]);
    col = (int)(REP_WIDTH-strlen(loc_legend[50]))/2;
    strncpy(hdr_line3+col,loc_legend[50],strlen(loc_legend[50]));
    sprintf(buf,"%4s :      %4d",loc_legend[30],page_no);
    strcpy(hdr_line3+(REP_WIDTH-16),buf);

    fprintf(f1,"\n\n\n\n\n%s\n",hdr_line1);
    fprintf(f1,"%s\n",hdr_line2);
    fprintf(f1,"%s\n",hdr_line3); 
 
    memset(hdr_line4,' ',REP_WIDTH+1);
    sprintf(ctmp,"%14s : %s %2s %s",loc_legend[80],nd_fm_trans_date.arr,loc_legend[70],
                  nd_to_trans_date.arr);
    col = (int)(REP_WIDTH-strlen(ctmp))/2;
    strncpy(hdr_line4+col,ctmp,strlen(ctmp));
    fprintf(f1,"%s\n",hdr_line4);    
      
 
    fprintf(f1,"                        %12s %4s %s %2s %s\n",loc_legend[90],loc_legend[60],fm_phy_id,loc_legend[70],
                                                                      to_phy_id);  

    fprintf(f1,"                              %11s %4s %s %2s %s\n",loc_legend[100],loc_legend[60],nd_fr_facility.arr,loc_legend[70],
                                                                      nd_to_facility.arr);  
                                                              
    if(strcmp(nd_report_type.arr,"G") == 0)
       fprintf(f1,"                           %11s %4s %s %2s %s\n",loc_legend[110],loc_legend[60],fm_prt_hdr,loc_legend[70],
                                                                  to_prt_hdr);  
    else
    {
    if((strcmp(nd_fm_prt_grp_hdr_1.arr,"!!") == 0) &&
      (strcmp(nd_fm_prt_grp_line.arr,"!!") == 0))
       fprintf(f1,"                        %10s %4s  %6s",loc_legend[120],loc_legend[60],loc_legend[190]);
    else                                                                                        
       fprintf(f1,"                        %10s %4s  %s-%s",loc_legend[120],loc_legend[60],fm_prt_hdr_1, fm_prt_line);               
    
    if((strcmp(nd_to_prt_grp_hdr_1.arr,"~~") == 0) &&
      (strcmp(nd_to_prt_grp_line.arr,"~~") == 0))
       fprintf(f1," %2s %7s\n",loc_legend[70],loc_legend[180]);       
	else
       fprintf(f1," %2s %s-%s\n",loc_legend[70],to_prt_hdr_1,to_prt_line);               
    }                                                                                        
    fprintf(f1,"                                  %11s %-19s\n",loc_legend[130],income_type);               
    
    fprintf(f1,"--------------------------------------------------------------------------------\n");    
    
}                    

fetch_legend_value()
{
	for(i=1;i<=900;i++)
	{
		l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLRINPHY.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 18;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLRINPHY.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )394;
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
  sqlstm.arrsiz = 18;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility_id , 'S\
M' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_valu\
e , :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )417;
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


/*****************************************************************/
