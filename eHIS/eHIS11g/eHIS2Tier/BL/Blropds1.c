
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/Blropds1.pc"
};


static unsigned int sqlctx = 1288468051;


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
            void  *sqhstv[11];
   unsigned int   sqhstl[11];
            int   sqhsts[11];
            void  *sqindv[11];
            int   sqinds[11];
   unsigned int   sqharm[11];
   unsigned int   *sqharc[11];
   unsigned short  sqadto[11];
   unsigned short  sqtdso[11];
} sqlstm = {12,11};

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

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,1,224,0,4,128,0,0,11,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,1,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
64,0,0,2,0,0,30,244,0,0,0,0,0,1,0,
79,0,0,0,0,0,27,250,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.0                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLROPDS1.PC                                  */
/* AUTHOR                : M.NITIN KUMAR                                */
/* DATE WRITTEN          : 26-AUG-1993                                  */
/* Modified				 : V. Srikanth / 04/04/2000                     */
/*                                                                      */
/* CALLED FROM           :                                              */
/*                                                                      */  
/*  FUNCTION               :                                            */
/*                                                                      */ 
/*  TABLE DETAILS                                                       */
/*                                                                      */ 
/*  PARAMETERS           :            -                                 */
/*                                                                      */
/*  SUBROUTINES          :                                              */
/*                                                                      */
/*  Changes Made		 :	Program Compiled for the purpose of changing*/
/*							the Bill Format  VSK 22/06/2000             */
/*                                                                      */
/************************************************************************/
                                                                   
#include <stdio.h>   
#include <string.h>      
#include <bl.h>

#define LAST_ROW (sqlca.sqlcode == 1403)
#define NOT_FOUND (sqlca.sqlerrd[2] == 0)

/*
#define DEBUG 0
*/
                       
#define INIT_MESG "Outpatient Bill printing in Progress"
#define ONLINE_PRINTING     1
                       
/* EXEC SQL BEGIN DECLARE SECTION; */ 


   /* VARCHAR	uid_pwd      [132],
             nd_pgm_date  [35]; */ 
struct { unsigned short len; unsigned char arr[132]; } uid_pwd;

struct { unsigned short len; unsigned char arr[35]; } nd_pgm_date;


   /* VARCHAR nd_session_id              [16],
           nd_fm_doc_type             [7],
		   nd_facility_id	          [3],
           nd_to_doc_type             [7],
           nd_fm_doc_num              [9],
           nd_to_doc_num              [9],
           nd_fm_doc_date             [11],
           nd_to_doc_date             [11],
		   nd_title                   [31]; */ 
struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[7]; } nd_fm_doc_type;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[7]; } nd_to_doc_type;

struct { unsigned short len; unsigned char arr[9]; } nd_fm_doc_num;

struct { unsigned short len; unsigned char arr[9]; } nd_to_doc_num;

struct { unsigned short len; unsigned char arr[11]; } nd_fm_doc_date;

struct { unsigned short len; unsigned char arr[11]; } nd_to_doc_date;

struct { unsigned short len; unsigned char arr[31]; } nd_title;

   char    trx_type,
	       filename[100];

/* EXEC SQL END DECLARE SECTION; */ 


// EXEC ORACLE OPTION(HOLD_CURSOR = YES);
// EXEC ORACLE OPTION(REBIND = NO);

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
char string_var[100];
char p_print_name[9];

void proc_main(argc,argv)
char *argv[];
int argc;
{
   if (argc < 6)
   {
      disp_message(ERR_MESG,"Not enough Parameters for running this program\n");
      proc_exit();
   }

   strcpy(uid_pwd.arr,argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr);

   strcpy(nd_session_id.arr,argv[2]);
   nd_session_id.len = strlen(nd_session_id.arr);

   strcpy(g_pgm_id,"BLROPDS1");

   if(sql_connect() == -1)
   {
      disp_message(ORA_MESG,"Error in connecting to Oracle\n");
      if (uid_pwd.len == 0)
         disp_message(ERR_MESG,"Null oracle uid/pwd\n\n\n");
      proc_exit();
   }
   
   set_meduser_role();

   /***** CHECKING FOR ACTIVE FLAG IN SY_PROG_CONTROL *****/
   strcpy(g_pgm_date,argv[3]);

   strcpy(p_print_name,argv[5]);

   strcpy(nd_facility_id.arr,argv[4]);
   nd_facility_id.len = strlen(nd_facility_id.arr);
   
   strcpy(g_facility_id,nd_facility_id.arr);


/*
   chk_active();
*/

   strcpy(nd_pgm_date.arr,argv[3]);
   nd_pgm_date.len = strlen(nd_pgm_date.arr);

   nd_fm_doc_type.arr[0]    = '\0';
   nd_fm_doc_num.arr[0]     = '\0';
   nd_fm_doc_date.arr[0]    = '\0';
   nd_to_doc_type.arr[0]    = '\0';
   nd_to_doc_num.arr[0]     = '\0';
   nd_to_doc_date.arr[0]    = '\0';
   nd_title.arr[0]          = '\0';

   nd_fm_doc_type.len       = 0;
   nd_fm_doc_num.len        = 0;
   nd_fm_doc_date.len       = 0;
   nd_to_doc_type.len       = 0;
   nd_to_doc_num.len        = 0;
   nd_to_doc_date.len       = 0;
   nd_title.len             = 0;

   /* EXEC SQL SELECT PARAM1,PARAM2,PARAM3,PARAM4,PARAM5,PARAM6,PARAM7,PARAM16
            INTO   :nd_fm_doc_type, :nd_fm_doc_num,
                   :nd_to_doc_type, :nd_to_doc_num, 
				   :nd_fm_doc_date, :nd_to_doc_date,
				   :trx_type, :nd_title
              FROM SY_PROG_PARAM
              WHERE PGM_ID     = 'BLROPDS1'
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date
	       AND OPERATING_FACILITY_ID = :nd_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 ,PARAM5 ,PARAM6 ,PAR\
AM7 ,PARAM16 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7  from SY_PROG_PARAM where ((\
(PGM_ID='BLROPDS1' and SESSION_ID=:b8) and PGM_DATE=:b9) and OPERATING_FACILIT\
Y_ID=:b10)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )5;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_fm_doc_type;
   sqlstm.sqhstl[0] = (unsigned int  )9;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_fm_doc_num;
   sqlstm.sqhstl[1] = (unsigned int  )11;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_to_doc_type;
   sqlstm.sqhstl[2] = (unsigned int  )9;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_to_doc_num;
   sqlstm.sqhstl[3] = (unsigned int  )11;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_fm_doc_date;
   sqlstm.sqhstl[4] = (unsigned int  )13;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_to_doc_date;
   sqlstm.sqhstl[5] = (unsigned int  )13;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&trx_type;
   sqlstm.sqhstl[6] = (unsigned int  )1;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_title;
   sqlstm.sqhstl[7] = (unsigned int  )33;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[8] = (unsigned int  )18;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[9] = (unsigned int  )37;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_facility_id;
   sqlstm.sqhstl[10] = (unsigned int  )5;
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

   if (NOT_FOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");

   nd_fm_doc_type.arr[nd_fm_doc_type.len]    = '\0';
   nd_fm_doc_num.arr[nd_fm_doc_num.len]      = '\0';
   nd_to_doc_type.arr[nd_to_doc_type.len]    = '\0';
   nd_to_doc_num.arr[nd_to_doc_num.len]      = '\0';
   nd_fm_doc_date.arr[nd_fm_doc_date.len]    = '\0';
   nd_to_doc_date.arr[nd_to_doc_date.len]    = '\0';
   nd_title.arr[nd_title.len]                = '\0';

   start_prog_msg();

   prt_op_bill(&trx_type);


/*  Commented by Aldrin for AMH as report-writer program takes of deleting 
    it.  
     EXEC SQL DELETE FROM SY_PROG_PARAM
                  WHERE PGM_ID     = 'BLROPDS1'
                    AND SESSION_ID = :nd_session_id
                    AND PGM_DATE   = :nd_pgm_date
		    AND OPERATING_FACILITY_ID = :nd_facility_id;
   if (OERROR)   
        err_mesg("DELETE failed on table SY_PROG_PARAM",0,"");
    */
/* Added to cater to Online print Routing - Sridharan - 8/June/98 */

	if (strcmp(p_print_name, "BLRVSTD1") == 0)

		strcpy(filename,WORKING_DIR);    
		strcat(filename,"BLROPDS1.LIS");

			//print_online(uid_pwd.arr, "BLRVSTD1", "O", "", "BLROPDS1.LIS", "R");

   PrintDocument
   (
		uid_pwd.arr,		//char	*PUidPwd;
		nd_session_id.arr,	//char	*PSessionID;
		nd_facility_id.arr,	//char	*PFacilityID;
		"BL",				//char	*PModuleID;
		"BLRVSTD1",			//char	*PDocumentID;
		filename,			//char	*POnlinePrintFileNames;
		"O",				//char	*PLocationTypes;
		"",					//char	*PLocationCodes;
		1,					//int		PNumOfCopies;
		1,					//int		PPageFrom;
		99					//int		PPageTo;
	);
	

	
	if (strcmp(p_print_name, "BLRREFD1") == 0)
			//print_online(uid_pwd.arr, "BLRREFD1", "O", "", "BLROPDS1.LIS", "R");

		strcpy(filename,WORKING_DIR);   
		strcat(filename,"BLROPDS1.LIS");
   PrintDocument   
   (
		uid_pwd.arr,		//char	*PUidPwd;
		nd_session_id.arr,	//char	*PSessionID;
		nd_facility_id.arr,	//char	*PFacilityID;
		"BL",				//char	*PModuleID;
		"BLRREFD1",			//char	*PDocumentID;
		filename,			//char	*POnlinePrintFileNames;
		"O",				//char	*PLocationTypes;
		"",					//char	*PLocationCodes;
		1,					//int		PNumOfCopies;
		1,					//int		PPageFrom;
		99					//int		PPageTo;
	);
	


	
	if (strcmp(p_print_name, "BLRPHRBL") == 0)
			//print_online(uid_pwd.arr, "BLRPHRBL", "O", "", "BLROPDS1.LIS", "R");
		strcpy(filename,WORKING_DIR);   
		strcat(filename,"BLROPDS1.LIS");

   PrintDocument
   (
		uid_pwd.arr,		//char	*PUidPwd;
		nd_session_id.arr,	//char	*PSessionID;
		nd_facility_id.arr,	//char	*PFacilityID;
		"BL",				//char	*PModuleID;
		"BLRPHRBL",			//char	*PDocumentID;
		filename,			//char	*POnlinePrintFileNames;
		"O",				//char	*PLocationTypes;
		"",					//char	*PLocationCodes;
		1,					//int		PNumOfCopies;
		1,					//int		PPageFrom;
		99					//int		PPageTo;
	);



   end_prog_msg();
/*

   end_prog_control();
*/
   /* EXEC SQL COMMIT WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )64;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    return;
}

sql_connect()
{
  /* EXEC SQL CONNECT :uid_pwd; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )79;
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
