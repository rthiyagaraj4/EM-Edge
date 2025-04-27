
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
           char  filnam[39];
};
static const struct sqlcxp sqlfpn =
{
    38,
    "D:\\work\\Balaraman\\BLRLM007\\BLRLM007.pc"
};


static unsigned long sqlctx = 1672546195;


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
            void  *sqhstv[10];
   unsigned int   sqhstl[10];
            int   sqhsts[10];
            void  *sqindv[10];
            int   sqinds[10];
   unsigned int   sqharm[10];
   unsigned int   *sqharc[10];
   unsigned short  sqadto[10];
   unsigned short  sqtdso[10];
} sqlstm = {10,10};

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

 static const char *sq0007 = 
"select PATIENT_ID ,A.BLNG_GRP_ID ,TO_CHAR(CLASSIFICATION_START_DATE,'DD/MM/Y\
YYY') ,TO_CHAR(CLASSIFICATION_END_DATE,'DD/MM/YYYY') ,B.SHORT_DESC  from BL_PA\
TIENT_FIN_DTLS A ,BL_BLNG_GRP B ,bl_classfctn_code C where (((((PATIENT_ID bet\
ween :b0 and :b1 and A.BLNG_GRP_ID=B.BLNG_GRP_ID) and A.CLASSIFICATION_CODE=C.\
CLASSIFICATION_CODE) and c.operating_facility_id=:b2) and A.BLNG_GRP_ID betwee\
n :b3 and :b4) and CLASSIFICATION_END_DATE<=(TRUNC(SYSDATE)+:b5)) order by PAT\
IENT_ID            ";

 static const char *sq0008 = 
"select PATIENT_ID  from OP_VISIT where (PATIENT_ID=:b0 and CANCELLED_YN<>'Y'\
)           ";

 static const char *sq0009 = 
"select PATIENT_ID  from IP_EPISODE where (PATIENT_ID=:b0 and cancellation_da\
te_time is null )           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,160,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,30,188,0,0,0,0,0,1,0,
51,0,0,3,243,0,4,226,0,0,10,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
106,0,0,4,88,0,6,273,0,0,1,1,0,1,0,1,9,0,0,
125,0,0,5,102,0,2,279,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
148,0,0,6,128,0,4,312,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
179,0,0,7,485,0,9,386,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,
218,0,0,8,88,0,9,417,0,0,1,1,0,1,0,1,9,0,0,
237,0,0,8,0,0,13,427,0,0,1,0,0,1,0,2,9,0,0,
256,0,0,9,104,0,9,458,0,0,1,1,0,1,0,1,9,0,0,
275,0,0,9,0,0,13,468,0,0,1,0,0,1,0,2,9,0,0,
294,0,0,10,85,0,4,525,0,0,2,1,0,1,0,2,3,0,0,1,9,0,0,
317,0,0,11,101,0,4,578,0,0,2,1,0,1,0,2,3,0,0,1,9,0,0,
340,0,0,12,101,0,4,611,0,0,2,1,0,1,0,2,3,0,0,1,9,0,0,
363,0,0,7,0,0,13,673,0,0,5,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
398,0,0,13,148,0,4,766,0,0,6,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,
9,0,0,
437,0,0,14,86,0,4,801,0,0,3,1,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,
464,0,0,8,0,0,15,1068,0,0,0,0,0,1,0,
479,0,0,9,0,0,15,1069,0,0,0,0,0,1,0,
494,0,0,7,0,0,15,1070,0,0,0,0,0,1,0,
509,0,0,15,96,0,4,1101,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
532,0,0,16,175,0,6,1108,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
563,0,0,17,207,0,6,1127,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
};


/******************************************************************************/
/* CCS MEDICOM VER 1.0                                                        */
/******************************************************************************/
/* PROGRAM NAME     : BLRLM007.PC                                             */
/* AUTHOR           : Irudhayaraj                                             */
/* DATE WRITTEN     : 29-FEB-2004                                              */
/*                                                                            */
/*                                                                            */
/* CALLED FROM      : BLRLM007.FMB 								              */
/*                                                                            */
/* INPUT PARAMETERS : USER_ID/PASSWORD                                        */
/*                  : SESSION_ID                                              */
/*                  : PGM_DATE                                                */
/*                  : PATIENT FROM AND TO ID                                  */
/*                  : BILLING GROUP FROM AND TO                               */
/*                  : CUT OFF DAYS FOR EXPIRY                                 */
/*                  : NUMBER OF VISITS                                        */
/*                  : NUMBER OF ADMISSION                                     */
/* TABLES ACCESSED  : SY_PROG_PARAM                                           */
/*                  : SY_ACC_ENTITY                                           */
/*                  : BL_PATIENT_FIN_DTLS                                     */
/*                  : OP_VISIT                                                */
/*                  : IP_EPISODE                                              */
/*                  : MP_PATIENT_MAST                                         */
/*                  : MP_PAT_OTHER_DTLS                                       */
/*					                                                */
/* OUTPUT FILE      : BLRLM007.lis                                            */
/*                                                                            */
/******************************************************************************/

#include <stdio.h>
#include <math.h>
#include <string.h>
/*#include <op.h>*/
#include "gl.h"



#define ESC     0x1B
  
#define OERROR (sqlca.sqlcode < 0)
#define NODATAFOUND sqlca.sqlcode==1403
#define MAX_LINES 55
#define VER  "VER : 1.10.01\n"

/* EXEC SQL BEGIN DECLARE SECTION; */ 


	/* VARCHAR uid_pwd		        [91],  /o Input Parameters       o/   
        nd_session_id           [16],
		nd_temp_date			[21],
		nd_loc_date				[21],
		date_convert			[21],
		nd_pgm_date	            [13],
	    nd_pgm_id               [15],

        h_acc_entity_name       [31],  /o SY_ACC_ENTITY header access o/
		h_user                  [21],
		h_sysdate               [17],

      /o SY_PROG_PARAM Parameters o/
          nd_from_patient_id                          [21],   
          nd_to_patient_id                            [21],   
	    nd_from_blng_grp_id                           [5],
	    nd_to_blng_grp_id                             [5],
         nd_cut_off_days                              [3],
          nd_num_of_visit                            [3],
          nd_num_of_adm                              [3],
		  nd_operating_facility_id					[3]; */ 
struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[21]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[21]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[21]; } date_convert;

struct { unsigned short len; unsigned char arr[13]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } nd_pgm_id;

struct { unsigned short len; unsigned char arr[31]; } h_acc_entity_name;

struct { unsigned short len; unsigned char arr[21]; } h_user;

struct { unsigned short len; unsigned char arr[17]; } h_sysdate;

struct { unsigned short len; unsigned char arr[21]; } nd_from_patient_id;

struct { unsigned short len; unsigned char arr[21]; } nd_to_patient_id;

struct { unsigned short len; unsigned char arr[5]; } nd_from_blng_grp_id;

struct { unsigned short len; unsigned char arr[5]; } nd_to_blng_grp_id;

struct { unsigned short len; unsigned char arr[3]; } nd_cut_off_days;

struct { unsigned short len; unsigned char arr[3]; } nd_num_of_visit;

struct { unsigned short len; unsigned char arr[3]; } nd_num_of_adm;

struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;
      

        /* VARCHAR bl_patient_id                 [21],  
		l_pk_value	[100],
		l_translated_value	        [201],
		   p_language_id                 [3], 
           nd_patient_name               [41],     
           bl_blng_grp_id                [5],
           nd_blng_desc                  [101],
           bl_start_date                 [11],
           bl_end_date                   [11],
	     nd_addr_line1                 [101],
	     nd_addr_line2                 [101],
	     nd_addr_line3                 [101],
	     nd_addr_line4                 [101],
           nd_tel_num                    [20],
	     nd_user_id                    [31],           
	     nd_user_name                  [101],
           rep_date                      [21],
           oper_id                       [21],
           op_episode_id                 [21],
           op_visit_id                   [5],
		   t_patient_id                  [21],    // modified by id
		   nd_postal_code                [7]; */ 
struct { unsigned short len; unsigned char arr[21]; } bl_patient_id;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[41]; } nd_patient_name;

struct { unsigned short len; unsigned char arr[5]; } bl_blng_grp_id;

struct { unsigned short len; unsigned char arr[101]; } nd_blng_desc;

struct { unsigned short len; unsigned char arr[11]; } bl_start_date;

struct { unsigned short len; unsigned char arr[11]; } bl_end_date;

struct { unsigned short len; unsigned char arr[101]; } nd_addr_line1;

struct { unsigned short len; unsigned char arr[101]; } nd_addr_line2;

struct { unsigned short len; unsigned char arr[101]; } nd_addr_line3;

struct { unsigned short len; unsigned char arr[101]; } nd_addr_line4;

struct { unsigned short len; unsigned char arr[20]; } nd_tel_num;

struct { unsigned short len; unsigned char arr[31]; } nd_user_id;

struct { unsigned short len; unsigned char arr[101]; } nd_user_name;

struct { unsigned short len; unsigned char arr[21]; } rep_date;

struct { unsigned short len; unsigned char arr[21]; } oper_id;

struct { unsigned short len; unsigned char arr[21]; } op_episode_id;

struct { unsigned short len; unsigned char arr[5]; } op_visit_id;

struct { unsigned short len; unsigned char arr[21]; } t_patient_id;

struct { unsigned short len; unsigned char arr[7]; } nd_postal_code;


		   int   v_dummy , v_flag , l_flag, nd_no_admn, nd_no_visit;
           int total_cl = 0;
		   int grand_tot_cl = 0;
		   int  tot_flag = 0;

		char filename[150],
		     g_facility_id[3];
			int i;
			char loc_legend[999][201];    
	/* VARCHAR   op_patient_id  [21],     
		    d_patient_id   [21]; */ 
struct { unsigned short len; unsigned char arr[21]; } op_patient_id;

struct { unsigned short len; unsigned char arr[21]; } d_patient_id;
       
      /* VARCHAR 	    op_print_status[2]; */ 
struct { unsigned short len; unsigned char arr[2]; } op_print_status;
 

      
	/* VARCHAR   ip_patient_id  [21],    
		    i_patient_id   [21]; */ 
struct { unsigned short len; unsigned char arr[21]; } ip_patient_id;

struct { unsigned short len; unsigned char arr[21]; } i_patient_id;
     
      /* VARCHAR 	    ip_print_status[2]; */ 
struct { unsigned short len; unsigned char arr[2]; } ip_print_status;
 



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

int line_no=0;
int page_no=0;
int clinic_tot = 0,g_clinic_tot  = 0;
int date_tot   = 0,  g_date_tot  = 0, d_lctr = 0;
char  string_var  [200];

FILE *f1;

void proc_main(argc, argv)
int argc;
char *argv[];
{
 
   void get_params(),
        get_header_dtls(),
        dclr_bl_cur(),
        do_report();

   strcpy(filename,WORKING_DIR);
   strcat(filename,"BLRLM007.lis");

   if((f1 = fopen(filename, "w")) == NULL) {
     disp_message (ERR_MESG, " Error in opening output file ....");
     proc_exit();
   } 

   if(argc != 6) {
     disp_message (ERR_MESG, "Usage BLRLM007 uid/passwd session_id pgm_date");
     proc_exit();
   }  
   
   strcpy(uid_pwd.arr, argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr); 

   strcpy(nd_session_id.arr, argv[2]);
   nd_session_id.len = strlen(nd_session_id.arr); 

   strcpy(nd_pgm_date.arr, argv[3]);
   nd_pgm_date.len = strlen(nd_pgm_date.arr); 

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
}

  
   if (OERROR) {
      disp_message (ORA_MESG, "USERID/PASSWORD failed to Connect");
      proc_exit();
      }
      
  set_meduser_role();
  	 strcpy(p_language_id.arr,l_language_id.arr);
     p_language_id.len = l_language_id.len;


   get_params();

   get_header_dtls();

   fetch_legend_value();

   dclr_bl_cur();

   do_report();

   end_of_rep();

   close_bl_cur();

   fprintf(f1,"\n\n\n\n\n");	  


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
}



/*-------------- Check for any error and No data found ----------------------*/

   if (OERROR) {
      disp_message (ORA_MESG, "COMMIT failed");
      proc_exit();
      }

/*-------------------------- End of Error Check ------------------------------*/

   fclose(f1);

   return;
}   

/* get the parameters from the SY_PROG_PARM table and */
/* delete the record after reading it.                 */
void get_params()
{
   nd_from_patient_id.arr[0]='\0';
   nd_to_patient_id.arr[0]='\0';
   nd_from_blng_grp_id.arr[0]='\0';
   nd_to_blng_grp_id.arr[0]='\0';
   nd_cut_off_days.arr[0] = '\0';
   nd_num_of_visit.arr[0] = '\0';
   nd_num_of_adm.arr[0] = '\0';
   nd_operating_facility_id.arr[0] = '\0';
   
   nd_from_patient_id.len=0;
   nd_to_patient_id.len=0;
   nd_from_blng_grp_id.len=0;
   nd_to_blng_grp_id.len=0;
   nd_cut_off_days.len=0;
   nd_num_of_visit.len=0;
   nd_num_of_adm.len=0;      
   nd_operating_facility_id.len=0;
   /* read the parameter record */
   /* EXEC SQL SELECT PARAM1,
		   PARAM2,
		   PARAM3,
		   PARAM4,
           nvl(PARAM5, '0'),
		   nvl(PARAM6,'0'),
           nvl(PARAM7, '0'),
		   OPERATING_FACILITY_ID
            INTO 
            :nd_from_patient_id,
            :nd_to_patient_id,
            :nd_from_blng_grp_id,
            :nd_to_blng_grp_id,
            :nd_cut_off_days,
            :nd_num_of_visit,
            :nd_num_of_adm,
			:nd_operating_facility_id   
         FROM SY_PROG_PARAM
	    WHERE   PGM_ID = 'BLRLM007'
		    AND SESSION_ID = TO_NUMBER(:nd_session_id)
		    AND PGM_DATE = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 10;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 ,nvl(PARAM5,'0') ,nv\
l(PARAM6,'0') ,nvl(PARAM7,'0') ,OPERATING_FACILITY_ID into :b0,:b1,:b2,:b3,:b4\
,:b5,:b6,:b7  from SY_PROG_PARAM where ((PGM_ID='BLRLM007' and SESSION_ID=TO_N\
UMBER(:b8)) and PGM_DATE=:b9)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )51;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
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
   sqlstm.sqhstv[2] = (         void  *)&nd_from_blng_grp_id;
   sqlstm.sqhstl[2] = (unsigned int  )7;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_to_blng_grp_id;
   sqlstm.sqhstl[3] = (unsigned int  )7;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_cut_off_days;
   sqlstm.sqhstl[4] = (unsigned int  )5;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_num_of_visit;
   sqlstm.sqhstl[5] = (unsigned int  )5;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_num_of_adm;
   sqlstm.sqhstl[6] = (unsigned int  )5;
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
   sqlstm.sqhstv[8] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[8] = (unsigned int  )18;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[9] = (unsigned int  )15;
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



/*-------------- Check for any error and No data found ----------------------*/

   if (OERROR) {
      disp_message(ORA_MESG, "SELECT failed on SY_PROG_PARAM");
      proc_exit();
      }

   if (NODATAFOUND) {
      disp_message(ORA_MESG,"No Data Found in the SY_PROG_PARAM");
      proc_exit();
      }

/*-------------------------- End of Error Check ------------------------------*/

   nd_from_patient_id.arr[nd_from_patient_id.len]='\0';
   nd_to_patient_id.arr[nd_to_patient_id.len]='\0';
   nd_from_blng_grp_id.arr[nd_from_blng_grp_id.len]='\0';
   nd_to_blng_grp_id.arr[nd_to_blng_grp_id.len]='\0';
   nd_cut_off_days.arr[nd_cut_off_days.len]='\0';
   nd_num_of_visit.arr[nd_num_of_visit.len]='\0';
   nd_num_of_adm.arr[nd_num_of_adm.len]='\0';  
   nd_operating_facility_id.arr[nd_operating_facility_id.len]='\0'; 
   
   strcpy(g_facility_id,nd_operating_facility_id.arr);
 
 /* EXEC SQL EXECUTE           
 BEGIN
 SM_SECURITY_POLICY.SET_CTX_FOR_FACILITY_ID(:nd_operating_facility_id);
 END;
 END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin SM_SECURITY_POLICY . SET_CTX_FOR_FACILITY_ID ( :nd_ope\
rating_facility_id ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )106;
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



   /* EXEC SQL DELETE FROM sy_prog_param
   WHERE PGM_ID = 'BLRLM007'
   AND SESSION_ID = TO_NUMBER(:nd_session_id)
   AND PGM_DATE = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 10;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from sy_prog_param  where ((PGM_ID='BLRLM007' and \
SESSION_ID=TO_NUMBER(:b0)) and PGM_DATE=:b1)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )125;
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
   sqlstm.sqhstl[1] = (unsigned int  )15;
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
	   disp_message(ORA_MESG,"Oracle error at sy_prog_param occured");
	   proc_exit();
      }
   
/*-------------- Check for any error and No data found ----------------------*/

   if (OERROR) {
      disp_message(ORA_MESG,"DELETE failed on SY_PROG_PARAM");
      proc_exit();
      }

   if (NODATAFOUND) {
      disp_message(ORA_MESG,"No Data Found in the SY_PROG_PARAM");
      proc_exit();
      }

/*------------------------- End of Error Check -------------------------------*/

  return;

}
 
/*--------------------------- get the header details -------------------------*/
void get_header_dtls()
{
   /* EXEC SQL SELECT ACC_ENTITY_NAME, 
				   USER,
				   TO_CHAR(SYSDATE, 'DD/MM/YYYY HH24:MI')
		    INTO   :h_acc_entity_name,
				   :h_user,
				   :h_sysdate
            FROM   SY_ACC_ENTITY
			WHERE ACC_ENTITY_ID = :nd_operating_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 10;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select ACC_ENTITY_NAME ,USER ,TO_CHAR(SYSDATE,'DD/MM/YYYY \
HH24:MI') into :b0,:b1,:b2  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b3";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )148;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&h_acc_entity_name;
   sqlstm.sqhstl[0] = (unsigned int  )33;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&h_user;
   sqlstm.sqhstl[1] = (unsigned int  )23;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&h_sysdate;
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


			//and language_id=:p_language_id;

/*-------------- Check for any error and No data found ----------------------*/

   if (OERROR) {
      disp_message(ORA_MESG, "SELECT failed on SY_ACC_ENTITY");
      proc_exit();
      }

	 if (NODATAFOUND) {
      disp_message (ORA_MESG, "No Data Found in the SY_ACC_ENTITY");
      proc_exit();
      }

/*------------------------- End of Error Check -------------------------------*/

  h_acc_entity_name.arr[h_acc_entity_name.len]   = '\0';
  h_user.arr[h_user.len]                         = '\0';
  h_sysdate.arr[h_sysdate.len]                   = '\0';


  return;
}
/*------------------------- End of Header access -----------------------------*/

/*------------------------- Cursor Declaration------------------------------*/
void dclr_bl_cur()
{
   /* EXEC SQL DECLARE  BL_CUR CURSOR FOR
                   SELECT PATIENT_ID, 
                          A.BLNG_GRP_ID, 
                          TO_CHAR(START_DATE_CLASSIFICATION, 'DD/MM/YYYY'),
                          TO_CHAR(END_DATE_CLASSIFICATION, 'DD/MM/YYYY'),
				  B.SHORT_DESC 
                   FROM BL_PATIENT_FIN_DTLS A, BL_BLNG_GRP B
                   WHERE  PATIENT_ID BETWEEN :nd_from_patient_id AND :nd_to_patient_id
				   AND    A.BLNG_GRP_ID = B.BLNG_GRP_ID 
			       AND    CREDIT_YN IS NOT NULL
                   AND    A.BLNG_GRP_ID BETWEEN :nd_from_blng_grp_id AND :nd_to_blng_grp_id
                   AND    END_DATE_CLASSIFICATION <= TRUNC(SYSDATE) + :nd_cut_off_days
				   ORDER BY PATIENT_ID;  */


					/* EXEC SQL DECLARE  BL_CUR CURSOR FOR
					SELECT PATIENT_ID,A.BLNG_GRP_ID, 
                    TO_CHAR(CLASSIFICATION_START_DATE, 'DD/MM/YYYY'),
                    TO_CHAR(CLASSIFICATION_END_DATE, 'DD/MM/YYYY'),
				  B.SHORT_DESC 
                   FROM BL_PATIENT_FIN_DTLS A, BL_BLNG_GRP B,bl_classfctn_code C
                   WHERE  PATIENT_ID BETWEEN :nd_from_patient_id AND :nd_to_patient_id
				   AND    A.BLNG_GRP_ID = B.BLNG_GRP_ID 
				 AND   A.CLASSIFICATION_CODE = C.CLASSIFICATION_CODE
				AND c.operating_facility_id =:nd_operating_facility_id
                   AND    A.BLNG_GRP_ID BETWEEN :nd_from_blng_grp_id AND :nd_to_blng_grp_id
                   AND    CLASSIFICATION_END_DATE <= TRUNC(SYSDATE) + :nd_cut_off_days
				   ORDER BY PATIENT_ID; */ 
	
		
/*-------------- Check for any error and No data found ----------------------*/

   if (OERROR) {
      disp_message (ORA_MESG, "SELECT failed on BL_PATIENT_FIN_DTLS");
      proc_exit();
      }

/*------------------------- End of Error Check -------------------------------*/

  /* EXEC SQL OPEN BL_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 10;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0007;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )179;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
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
  sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[2] = (unsigned int  )5;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_from_blng_grp_id;
  sqlstm.sqhstl[3] = (unsigned int  )7;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_to_blng_grp_id;
  sqlstm.sqhstl[4] = (unsigned int  )7;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_cut_off_days;
  sqlstm.sqhstl[5] = (unsigned int  )5;
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
}



/*-------------- Check for any error and No data found ----------------------*/

   if (OERROR) {
      disp_message (ORA_MESG, "OPEN failed on BL_CUR");
      proc_exit();
      }

/*------------------------- End of Error Check -------------------------------*/
  return;
/*------------------------- End of OP Cursor -------------------------------*/
}


dclr_op_cur(CHAR *v_patient_id)
{
strcpy(d_patient_id.arr,v_patient_id);
d_patient_id.len = strlen(d_patient_id.arr);

//disp_message(ERR_MESG,strcat(d_patient_id.arr,"op"));

 /* EXEC SQL DECLARE OP_CUR CURSOR FOR
          SELECT PATIENT_ID
          FROM OP_VISIT
          WHERE PATIENT_ID = :d_patient_id		 
  	    AND   CANCELLED_YN <> 'Y'; */ 


 if (OERROR)
       disp_message(ERR_MESG,"SELECT failed on table OP_VISIT");
 
 /* EXEC SQL OPEN OP_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0008;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )218;
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

 
 return;
}

int fetch_op_cur()
{

	op_patient_id.arr[0] = '\0';
	op_patient_id.arr[op_patient_id.len] = 0;

 	/* EXEC SQL FETCH op_cur INTO :op_patient_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 10;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )237;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&op_patient_id;
  sqlstm.sqhstl[0] = (unsigned int  )23;
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


	
    op_patient_id.arr[op_patient_id.len] = '\0';

  if (NODATAFOUND)
      return 0;

   if (OERROR) {
      disp_message (ORA_MESG, "FETCH failed");
      proc_exit();
      }

  return 1;
}

 
dclr_ip_cur(CHAR *v_patient_id)
{
strcpy(i_patient_id.arr,v_patient_id);
i_patient_id.len = strlen(i_patient_id.arr);
//disp_message(ERR_MESG,strcat(i_patient_id.arr,"ip"));

 /* EXEC SQL DECLARE IP_CUR CURSOR FOR
          SELECT PATIENT_ID
          FROM IP_EPISODE
          WHERE PATIENT_ID = :i_patient_id		 
  	    AND   cancellation_date_time IS NULL; */ 


 if (OERROR)
       disp_message(ERR_MESG,"SELECT failed on table IP_EPISODE");
 
 /* EXEC SQL OPEN IP_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0009;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )256;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&i_patient_id;
 sqlstm.sqhstl[0] = (unsigned int  )23;
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

 
 return;
}

int fetch_ip_cur()
{

	ip_patient_id.arr[0] = '\0';
	ip_patient_id.arr[ip_patient_id.len] = 0;

 	/* EXEC SQL FETCH ip_cur INTO :ip_patient_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 10;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )275;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&ip_patient_id;
  sqlstm.sqhstl[0] = (unsigned int  )23;
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


	
    ip_patient_id.arr[ip_patient_id.len] = '\0';

  if (NODATAFOUND)
      return 0;

   if (OERROR) {
      disp_message (ORA_MESG, "FETCH failed");
      proc_exit();
      }

  return 1;
}



/*------------------------- Fetching from Appt Cursor ------------------------*/
void do_report()
{
  void print_page_header(),
       print_rep_header(),       
       print_col_heading(),
	 print_detl_rec(),
	 print_hospital_name();

  int fetch_bl_cur();

  int still_rec_left = 0;
  int still_op_rec_left = 0;
  int op_cnt	= 0;
  int still_ip_rec_left = 0;
  int ip_cnt	= 0;


  page_no += 1;
  print_rep_header();  /* once for the report */

  page_no += 1;
  print_page_header();
  print_col_heading();

  /*---------------------- read the first cursor record ----------------------*/
   still_rec_left = fetch_bl_cur();
 
  while(still_rec_left)
  {
	strcpy(op_print_status.arr , "N");    
    op_cnt =  0;

	strcpy(ip_print_status.arr , "N");    
    ip_cnt =  0;
			

	if (atoi(nd_num_of_visit.arr) > 0)
	{	
		nd_no_visit = 0;
		/* EXEC SQL SELECT	COUNT(*)
				 INTO   nd_no_visit
				 FROM   OP_VISIT
				 WHERE  PATIENT_ID = :bl_patient_id
				 AND    CANCELLED_YN <> 'Y' ; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 10;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select count(*)  into :b0  from OP_VISIT where (PATIENT_ID=\
:b1 and CANCELLED_YN<>'Y')";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )294;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_no_visit;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
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


		if (nd_no_visit >= atoi(nd_num_of_visit.arr)) 
			{
			   strcpy(op_print_status.arr , "Y");	
			   op_print_status.len = strlen(op_print_status.arr);	
			}				
/*	    dclr_op_cur(bl_patient_id.arr);
	    still_op_rec_left = fetch_op_cur();
		while(still_op_rec_left)
		{	
	      op_cnt +=  1;
		 //disp_message(ERR_MESG,"B");	

			if (op_cnt == atoi(nd_num_of_visit.arr))		
			  {
			   strcpy(op_print_status.arr , "Y");	
			   op_print_status.len = strlen(op_print_status.arr);	
			   //disp_message(ERR_MESG,"C");			   
			   break;			   
			  }
		  still_op_rec_left = fetch_op_cur();	   			  		  
		  }	
		  */
		  //break;	     	
	  }



      if (atoi(nd_num_of_visit.arr) == 0)
      {
        if (atoi(nd_num_of_adm.arr) > 0)
        {
/*          dclr_ip_cur(bl_patient_id.arr);
	      still_ip_rec_left = fetch_ip_cur();
		  while(still_ip_rec_left)
		  {	
	        ip_cnt +=  1;
			//disp_message(ERR_MESG,"i1B");
		 
			 if (ip_cnt == atoi(nd_num_of_adm.arr))		
			  {
			   strcpy(ip_print_status.arr , "Y");	
			   ip_print_status.len = strlen(ip_print_status.arr);
			   //disp_message(ERR_MESG,"i1C");	
			   break;			   
			  }
		   still_ip_rec_left = fetch_ip_cur();	   			  		  
		  }	*/
		nd_no_admn = 0;
		/* EXEC SQL SELECT	COUNT(*)
				 INTO   nd_no_admn
				 FROM   IP_EPISODE
				 WHERE  PATIENT_ID = :bl_patient_id
				 AND    CANCELLATION_DATE_TIME IS NULL  ; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 10;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select count(*)  into :b0  from IP_EPISODE where (PATIENT_I\
D=:b1 and CANCELLATION_DATE_TIME is null )";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )317;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_no_admn;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
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


		if (nd_no_admn >= atoi(nd_num_of_adm.arr)) 
			{
			   strcpy(ip_print_status.arr , "Y");	
			   ip_print_status.len = strlen(ip_print_status.arr);
			}				
        }
      }
      else
      {
        if (atoi(nd_num_of_adm.arr) > 0 && op_print_status.arr[0] == 'N')
        {
/*          dclr_ip_cur(bl_patient_id.arr);
	      still_ip_rec_left = fetch_ip_cur();
		  while(still_ip_rec_left)
		  {	
	        ip_cnt +=  1;
		     //disp_message(ERR_MESG,"i2B");
			 if (ip_cnt == atoi(nd_num_of_adm.arr))		
			  {
			   strcpy(ip_print_status.arr , "Y");	
			   ip_print_status.len = strlen(ip_print_status.arr);
			   //disp_message(ERR_MESG,"i2C");	
			   break;			   
			  }
		   still_ip_rec_left = fetch_ip_cur();	   			  		  
		  }	
*/
		nd_no_admn = 0;
		/* EXEC SQL SELECT	COUNT(*)
				 INTO   nd_no_admn
				 FROM   IP_EPISODE
				 WHERE  PATIENT_ID = :bl_patient_id
				 AND    CANCELLATION_DATE_TIME IS NULL ; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 10;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select count(*)  into :b0  from IP_EPISODE where (PATIENT_I\
D=:b1 and CANCELLATION_DATE_TIME is null )";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )340;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_no_admn;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
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


		if (nd_no_admn >= atoi(nd_num_of_adm.arr)) 
			{
			   strcpy(ip_print_status.arr , "Y");	
			   ip_print_status.len = strlen(ip_print_status.arr);
			}		
        }
      }


	    if ((atoi(nd_num_of_visit.arr) == 0 && atoi(nd_num_of_adm.arr) == 0) ||       
              (atoi(nd_num_of_visit.arr) > 0 && op_print_status.arr[0] == 'Y') ||
              (atoi(nd_num_of_adm.arr) > 0 && ip_print_status.arr[0] == 'Y')
	       ) 	
	    {
	      
	      if (line_no > 42)
		  {	         
		    fprintf(f1,"");
		    page_no += 1;
		    print_page_header();
		    print_col_heading();
		    print_detl_rec();
		  }
		  else
		  {
		  		 
		    print_detl_rec();
		  }      
        }
  	 
  still_rec_left = fetch_bl_cur();
 }	
   return 1;

}

/* -------------------------- End of Report function -------------------------*/

/* fetches the next record from BL_CUR     */
/* returns 0 if the end of cursor is reached */
/* else returns 1.                           */
int fetch_bl_cur()
{

    bl_patient_id.arr[0]       = '\0';
    bl_blng_grp_id.arr[0]      = '\0';
    bl_start_date.arr[0]       = '\0';
    bl_end_date.arr[0]         = '\0';
	nd_blng_desc.arr[0]        = '\0';

    bl_patient_id.len          = 0;
    bl_blng_grp_id.len         = 0;
    bl_start_date.len          = 0;
    bl_end_date.len            = 0;
	nd_blng_desc.len           = 0;


  /* EXEC SQL FETCH BL_CUR INTO
                          :bl_patient_id,
			        :bl_blng_grp_id,
				  :bl_start_date,
                          :bl_end_date,
						  :nd_blng_desc; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 10;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )363;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&bl_patient_id;
  sqlstm.sqhstl[0] = (unsigned int  )23;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&bl_blng_grp_id;
  sqlstm.sqhstl[1] = (unsigned int  )7;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&bl_start_date;
  sqlstm.sqhstl[2] = (unsigned int  )13;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&bl_end_date;
  sqlstm.sqhstl[3] = (unsigned int  )13;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_blng_desc;
  sqlstm.sqhstl[4] = (unsigned int  )103;
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

						  

   if (OERROR) {
      disp_message (ORA_MESG, "FETCH failed");
      proc_exit();
      }

    bl_patient_id.arr[bl_patient_id.len]             = '\0';
    bl_blng_grp_id.arr[bl_blng_grp_id.len]           = '\0';
    bl_start_date.arr[bl_start_date.len]             = '\0';
    bl_end_date.arr[bl_end_date.len]                 = '\0';
	nd_blng_desc.arr[nd_blng_desc.len]               = '\0';


  if (NODATAFOUND)
      return 0;

   if (OERROR) {
      disp_message (ORA_MESG, "FETCH failed");
      proc_exit();
      }

  return 1;
}
       



/* to print the detailed record with to horizontal summeries */

void print_detl_rec()

{

void get_patient_name(),
     get_pat_address();


     get_patient_name();
     get_pat_address();

	 
     /*************First Line *********************/
       
	 fprintf(f1, "%-10.10s ", bl_patient_id.arr);    
	 fprintf(f1, "%-30s " , nd_patient_name.arr);
	 fprintf(f1, "%-5s %-15s " , bl_blng_grp_id.arr,nd_blng_desc.arr);
     //fprintf(f1, "%-10s " , bl_start_date.arr);
	 strcpy(date_convert.arr,bl_start_date.arr);
	 fun_change_loc_date(); 
	 fprintf(f1, "%-10s " , date_convert.arr);

     //fprintf(f1, "   %-10s " , bl_end_date.arr);
	 strcpy(date_convert.arr,bl_end_date.arr);
	 fun_change_loc_date(); 
	 fprintf(f1, "   %-10s " , date_convert.arr);
	 fprintf(f1, "     %-19s" , nd_tel_num.arr);
     fprintf(f1, "\n"); 
	  /*********** Second Line ******************************/

	 //fprintf(f1 , "Address:   %-30s %-30s\n" ,nd_addr_line1.arr , nd_addr_line2.arr);
	 fprintf(f1,loc_legend[116]);
	 fprintf(f1 , nd_addr_line1.arr , nd_addr_line2.arr);
     fprintf(f1 , "           %-30s %-30s   %-6s\n\n" ,nd_addr_line3.arr , nd_addr_line4.arr , nd_postal_code.arr);
  	line_no = line_no +4; 	 

}



void get_pat_address()
{

 nd_addr_line1.arr[0] = '\0';
 nd_addr_line2.arr[0] = '\0';
 nd_addr_line3.arr[0] = '\0';
 nd_addr_line4.arr[0] = '\0';
 nd_postal_code.arr[0]= '\0';
 

 nd_addr_line1.len    = 0;
 nd_addr_line2.len    = 0;
 nd_addr_line3.len    = 0;
 nd_addr_line4.len    = 0;
 nd_postal_code.len   = 0;
 

 
 /* EXEC SQL SELECT LN1_MAIL_ADD,LN2_MAIL_ADD, 
                 LN3_MAIL_ADD,LN4_MAIL_ADD,
				 RES_POSTAL_CODE
			INTO :nd_addr_line1,:nd_addr_line2,
			     :nd_addr_line3,:nd_addr_line4,
				 :nd_postal_code
	        FROM MP_PAT_OTHER_DTLS
		   WHERE PATIENT_ID = :bl_patient_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select LN1_MAIL_ADD ,LN2_MAIL_ADD ,LN3_MAIL_ADD ,LN4_MAIL_AD\
D ,RES_POSTAL_CODE into :b0,:b1,:b2,:b3,:b4  from MP_PAT_OTHER_DTLS where PATI\
ENT_ID=:b5";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )398;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_addr_line1;
 sqlstm.sqhstl[0] = (unsigned int  )103;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_addr_line2;
 sqlstm.sqhstl[1] = (unsigned int  )103;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_addr_line3;
 sqlstm.sqhstl[2] = (unsigned int  )103;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_addr_line4;
 sqlstm.sqhstl[3] = (unsigned int  )103;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_postal_code;
 sqlstm.sqhstl[4] = (unsigned int  )9;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&bl_patient_id;
 sqlstm.sqhstl[5] = (unsigned int  )23;
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
}



//if (OERROR)
       //disp_message(ERR_MESG,"SELECT failed on table MP_PAT_OTHER_DTLS");


 nd_addr_line1.arr[nd_addr_line1.len] = '\0';
 nd_addr_line2.arr[nd_addr_line2.len] = '\0';
 nd_addr_line3.arr[nd_addr_line3.len] = '\0';
 nd_addr_line4.arr[nd_addr_line4.len] = '\0';
 nd_postal_code.arr[nd_postal_code.len] = '\0';
 


  return;
}

/*------ gets the Patient name for the Patient Id ----------------------------*/

void get_patient_name()
{

 nd_patient_name.arr[0] = '\0';
 nd_tel_num.arr[0] = '\0';

 nd_patient_name.len    = 0;
 nd_tel_num.len  = 0;

 /* EXEC SQL SELECT short_name ,RES_TEL_NUM
          INTO  :nd_patient_name,:nd_tel_num
          FROM MP_PATIENT_MAST
          WHERE PATIENT_ID = :bl_patient_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select short_name ,RES_TEL_NUM into :b0,:b1  from MP_PATIENT\
_MAST where PATIENT_ID=:b2";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )437;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_patient_name;
 sqlstm.sqhstl[0] = (unsigned int  )43;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_tel_num;
 sqlstm.sqhstl[1] = (unsigned int  )22;
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
 nd_tel_num.arr[nd_tel_num.len] = '\0';

 return;

}

/*-------------------- End of Patient name ------------------------------------*/




/*-------------------- to print the header page for the report ---------------*/

void print_rep_header()
{
   char from_pat_id[11],  to_pat_id[11];
  char from_billing_group[10], to_billing_group[10];
  char nd_cut_off[3], nd_visit[3], nd_adm[3];
  
  if(strcmp(nd_from_patient_id.arr, "!!!!!!!!!!") == 0)
    strcpy(from_pat_id, "LOWEST");
    else strcpy(from_pat_id, nd_from_patient_id.arr);

  if(strcmp(nd_to_patient_id.arr, "~~~~~~~~~~") == 0)
    strcpy(to_pat_id, "HIGHEST");
    else strcpy(to_pat_id, nd_to_patient_id.arr);

  
  if(strcmp(nd_from_blng_grp_id.arr, "!!") == 0)
    strcpy(from_billing_group, "LOWEST");
    else strcpy(from_billing_group, nd_from_blng_grp_id.arr);

  if(strcmp(nd_to_blng_grp_id.arr, "~~") == 0)
    strcpy(to_billing_group, "HIGHEST");
    else strcpy(to_billing_group, nd_to_blng_grp_id.arr);

  if(strcmp(nd_cut_off_days.arr, "0") == 0)
   strcpy(nd_cut_off, "\0");
   else strcpy(nd_cut_off, nd_cut_off_days.arr);

  if(strcmp(nd_num_of_visit.arr, "0") == 0)
   strcpy(nd_visit, "\0");
   else strcpy(nd_visit, nd_num_of_visit.arr);

  if(strcmp(nd_num_of_adm.arr, "0") == 0)
   strcpy(nd_adm, "\0");
   else strcpy(nd_adm, nd_num_of_adm.arr);
 
print_page_header();
  fprintf(f1,"-------------------------------------------------------------------------------------------------------------\n");
  //fprintf(f1,VER);
  fprintf(f1,loc_legend[006]);
  fprintf(f1,"\n\n");
  fprintf(f1,"        ");
  //fprintf(f1,"INPUT PARAMETERS :\n");
  fprintf(f1,loc_legend[007]);
  fprintf(f1,"\n");
  fprintf(f1,"        ");
  fprintf(f1,"------------------\n\n");
  fprintf(f1,"                ");
  fprintf(f1,"              ");
  
  //fprintf(f1,"PATIENT ID     FROM         : %s\n", from_pat_id);
  fprintf(f1,loc_legend[100]);
  fprintf(f1,from_pat_id);
  fprintf(f1,"\n");
  fprintf(f1,"                                ");
  //fprintf(f1,"               TO         : %s\n", to_pat_id);
  fprintf(f1,loc_legend[101]);
  fprintf(f1, to_pat_id);
  fprintf(f1,"\n\n");
  fprintf(f1,"                ");
  fprintf(f1,"              ");
  //fprintf(f1,"BILLING GROUP   FROM        : %s\n", from_billing_group);
  fprintf(f1,loc_legend[102]);
  fprintf(f1,from_billing_group);
  fprintf(f1,"\n");
  fprintf(f1,"                                ");
  //fprintf(f1,"                TO        : %s\n", to_billing_group);
  fprintf(f1,loc_legend[103]);
  fprintf(f1,to_billing_group);
  fprintf(f1,"\n\n");
  fprintf(f1,"                              ");
  //fprintf(f1,"CUT OFF DAYS FOR EXPIRY     : %s\n", nd_cut_off);
  fprintf(f1,loc_legend[104]);
  fprintf(f1,nd_cut_off);
  fprintf(f1,"\n\n");
  fprintf(f1,"                              ");
  //fprintf(f1,"NUMBER OF VISITS            : %s\n", nd_visit);
  fprintf(f1,loc_legend[105]);
  fprintf(f1,nd_visit);
  fprintf(f1,"\n");
  fprintf(f1,"\n");
  fprintf(f1,"                              ");
  //fprintf(f1,"NUMBER OF ADMISSIONS        : %s\n", nd_adm);
  fprintf(f1,loc_legend[106]);
  fprintf(f1,nd_adm);
  fprintf(f1,"\n");
  fprintf(f1,"\n");
  fprintf(f1,"");

 }


/* to print page headers the header details */ 
void print_page_header()
{
  char from_pat_id[11],  to_pat_id[11];
  char from_billing_group[10], to_billing_group[10];
  char nd_cut_off[3], nd_visit[3], nd_adm[3];
  
  if(strcmp(nd_from_patient_id.arr, "!!!!!!!!!!") == 0)
    strcpy(from_pat_id, "LOWEST");
    else strcpy(from_pat_id, nd_from_patient_id.arr);

  if(strcmp(nd_to_patient_id.arr, "~~~~~~~~~~") == 0)
    strcpy(to_pat_id, "HIGHEST");
    else strcpy(to_pat_id, nd_to_patient_id.arr);

  
  if(strcmp(nd_from_blng_grp_id.arr, "!!!!") == 0)
    strcpy(from_billing_group, "LOWEST");
    else strcpy(from_billing_group, nd_from_blng_grp_id.arr);

  if(strcmp(nd_to_blng_grp_id.arr, "~~~~") == 0)
    strcpy(to_billing_group, "HIGHEST");
    else strcpy(to_billing_group, nd_to_blng_grp_id.arr);

  if(strcmp(nd_cut_off_days.arr, "!!") == 0)
   strcpy(nd_cut_off, "!!");
   else strcpy(nd_cut_off, nd_cut_off_days.arr);

  if(strcmp(nd_num_of_visit.arr, "!!") == 0)
   strcpy(nd_visit, "!!");
   else strcpy(nd_visit, nd_num_of_visit.arr);

  if(strcmp(nd_num_of_adm.arr, "!!") == 0)
   strcpy(nd_adm, "!!");
   else strcpy(nd_adm, nd_num_of_adm.arr);
  
 fprintf(f1,"%c&l1O",ESC);   /* This will make the orientation as landscape */
 fprintf(f1,"%c&k4S",ESC); /* This makes the font size to increase to 2 */


  
 print_hospital_name(109,"BL",h_acc_entity_name.arr,h_sysdate.arr);    
 //fprintf(f1,"OPR : %s", h_user.arr);
 fprintf(f1,loc_legend[117]);
 fprintf(f1,h_user.arr);
 fprintf(f1,"\n"); 
 //fprintf(f1,"REP : BLRLM007");
 fprintf(f1,loc_legend[003]);
 fprintf(f1,"                          ");  
 //fprintf(f1,"Reassessment Reminder Notice");
 fprintf(f1,loc_legend[004]);
 fprintf(f1,"                             ");  
 //fprintf(f1,"Page  : %4d", page_no);
 fprintf(f1,loc_legend[005]);
 fprintf(f1,"%4d", page_no);
 fprintf(f1,"\n\n"); 
/*
 fprintf(f1,"                              ");
   
 fprintf(f1,"PATIENT ID FROM  %s", from_pat_id);
 fprintf(f1,"  TO  %s\n", to_pat_id);
 fprintf(f1,"                              ");
 fprintf(f1,"BILLING GROUP FROM  %s", from_billing_group);
 fprintf(f1,"      TO  %s\n", to_billing_group);
 fprintf(f1,"                              ");
 fprintf(f1,"CUT OFF DAYS FOR EXPIRY  %s\n", nd_cut_off);
 fprintf(f1,"                              ");
 fprintf(f1,"NUMBER OF VISITS  %s\n", nd_visit);
 fprintf(f1,"                              ");
 fprintf(f1,"NUMBER OF ADMISSIONS  %s\n", nd_adm);
*/
 line_no = 4;
 
}

/* print the heading */
void print_col_heading()
{
 fprintf(f1,"-------------------------------------------------------------------------------------------------------------\n");
 //          12345678901345678901234567890123567890123567890123456789012345678901234567890
 //fprintf(f1,"                                                           <--Classification Period-->\n");
 fprintf(f1,"                                                           ");
 fprintf(f1,loc_legend[115]);
 fprintf(f1,"\n"); 
 //fprintf(f1,"Patient No Patient Name                   Billing Group      Start Date    End Date        Telphone No\n");
 fprintf(f1,loc_legend[107]);
 fprintf(f1,loc_legend[110]);
 fprintf(f1,loc_legend[111]);
 fprintf(f1,loc_legend[112]);
 fprintf(f1,loc_legend[113]);
 fprintf(f1,loc_legend[114]);
 fprintf(f1,"\n"); 

           //xxxxxxxxxx xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx xx xxxxxxxxxxxxxxx 99/99/9999    99/99/9999      xxxxxxxxxxxxxxxxxx

 fprintf(f1,"-------------------------------------------------------------------------------------------------------------");
 fprintf(f1,"\n");
  line_no = line_no + 3;
}
 

/*------------------------------ end Header ----------------------------------*/
void print_hospital_name(nd_rep_width    ,
                         nd_mod_id       ,
                         nd_hospital_name,
                         nd_date          )
int  nd_rep_width;
char nd_mod_id[3];
char nd_hospital_name[31];
char nd_date[17];
{
		int i = 0 , pos = 0 , len = 0, len_date = 0 , pos_date = 0,len1 = 0;

    /*Find the length of Hospital Name*/
    for(len = 0; nd_hospital_name[len] != '\0'; len++);

    /*Find the length of Date*/
    for(len_date = 0; nd_date[len_date] != '\0'; len_date++);
    
    len1 = (len % 2 );

	if (len1 == 0)
	  len1=9;
	else 
	   len1=10;
 
	
    len = (len / 2 )  ;

    pos = (nd_rep_width / 2	) - len;

	pos_date = nd_rep_width - len_date;

	//fprintf(f1,"MDL : %2s",nd_mod_id);
	fprintf(f1,loc_legend[001], "%2s",nd_mod_id);
	fprintf(f1,nd_mod_id);
     
    
	for(i = len1; i < pos ; fprintf(f1," "),i++);

	fprintf(f1,"%s",nd_hospital_name);

	for(i = i + (len * 2) ; i < pos_date + 1; fprintf(f1," "),i++);
	strcpy(date_convert.arr,nd_date);
	fun_change_loc_date(); 
    //fprintf(f1,"%s\n",nd_date);
	fprintf(f1,"%s\n",date_convert.arr);

}
 

close_bl_cur()
{
   /* EXEC SQL CLOSE OP_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 10;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )464;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   /* EXEC SQL CLOSE IP_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 10;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )479;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   /* EXEC SQL CLOSE BL_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 10;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )494;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


 
}



end_of_rep()
{  
  fprintf(f1,"\n");
  fprintf(f1,"-------------------------------------------------------------------------------------------------------------\n");
  //fprintf(f1,"\n                  **********  END OF REPORT **********\n");
  fprintf(f1,"\n                  ");
  fprintf(f1,loc_legend[002]);
  fprintf(f1,"\n\n");
  
}



#undef DEBUG
#undef NODATAFOUND
#undef OERROR
#undef MAX_LINES
#undef VER

fetch_legend_value()
{
	for(i=1;i<=900;i++)
	{
		l_pk_value.arr[0] = '\0';

	/* EXEC SQL SELECT LTRIM(RTRIM('BLRLM007.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		        INTO :l_pk_value
			   FROM dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select LTRIM(RTRIM(('BLRLM007.LEGEND_'||LTRIM(RTRIM(TO_CHAR(\
:b0,'009')))))) into :b1  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )509;
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


			
		l_pk_value.arr[l_pk_value.len]	= '\0';
		l_translated_value.arr[0]		= '\0';

		/* EXEC SQL EXECUTE
		BEGIN
			blcommon.get_local_lang_desc(:nd_operating_facility_id,
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
  sqlstm.arrsiz = 10;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_operating_facili\
ty_id , 'SM' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_trans\
lated_value , :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )532;
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
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . CONVERT_TO_LOC\
ALE_DATE ( to_date ( :nd_temp_date , 'DD/MM/YYYY HH24:MI' ) , :p_language_id ,\
 t_date ) ; :nd_loc_date := to_char ( t_date , 'DD/MM/YYYY' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )563;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
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


		/*if (OERROR)
        err_mesg("SELECTING Date failed",0,"");*/
}

fun_change_loc_date()
{

strcpy(nd_temp_date.arr,date_convert.arr);
nd_temp_date.len = strlen(nd_temp_date.arr);


get_local_date();

strcpy(date_convert.arr,nd_loc_date.arr); 

}
