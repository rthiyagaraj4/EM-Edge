
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
           char  filnam[45];
};
static const struct sqlcxp sqlfpn =
{
    44,
    "T:\\temp\\Bl\\ganapathy\\JDWORK\\PROC\\Blrsrupd.pc"
};


static unsigned long sqlctx = 1267616933;


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

 static const char *sq0005 = 
"select ROWID ,BLNG_SERV_CODE ,LTRIM(TO_CHAR(IP_RATE,'999,990.99')) ,LTRIM(TO\
_CHAR(OP_RATE,'999,990.99')) ,LTRIM(TO_CHAR(REF_RATE,'999,990.99')) ,LTRIM(TO_\
CHAR(MIN_CHARGE_AMT,'999,990.99')) ,IP_RATE ,OP_RATE ,REF_RATE ,MIN_CHARGE_AMT\
  from BL_SERV_PRICE_UPDT where (EFF_DATE_TIME=TO_DATE(:b0,'DD/MM/YYYY HH24:MI\
') and BLNG_SERV_CODE between NVL(:b1,'!!!!!!!!!!') and NVL(:b2,'~~~~~~~~~~'))\
 order by BLNG_SERV_CODE            ";

 static const char *sq0006 = 
"select LTRIM(TO_CHAR(IP_RATE,'999,990.99')) ,LTRIM(TO_CHAR(OP_RATE,'999,990.\
99')) ,LTRIM(TO_CHAR(REF_RATE,'999,990.99')) ,LTRIM(TO_CHAR(MIN_CHARGE_AMT,'99\
9,990.99'))  from BL_SERV_CUST_PC_PRICE b where ((CUST_PC_IND='S' and BLNG_SER\
V_CODE between NVL(:b0,'!!!!!!!!!!') and NVL(:b1,'~~~~~~~~~~')) and (TRUNC(VAL\
ID_TO),BLNG_SERV_CODE) in (select max(TRUNC(VALID_TO)) ,BLNG_SERV_CODE  from B\
L_SERV_CUST_PC_PRICE C where ((NVL(VALID_TO,TRUNC(SYSDATE))<TO_DATE(:b2,'DD/MM\
/YYYY HH24:MI') and CUST_PC_IND='S') and B.BLNG_SERV_CODE=C.BLNG_SERV_CODE) gr\
oup by BLNG_SERV_CODE)) order by BLNG_SERV_CODE            ";

 static const char *sq0007 = 
"select blng_serv_code ,ip_rate ,op_rate ,ref_rate ,LTRIM(TO_CHAR(MIN_CHARGE_\
AMT,'999,990.99'))  from BL_SERV_CUST_PC_PRICE where ((CUST_PC_IND='S' and BLN\
G_SERV_CODE between NVL(:b0,'!!!!!!!!!!') and NVL(:b1,'~~~~~~~~~~')) and TO_DA\
TE(:b2,'DD/MM/YYYY HH24:MI') between trunc(VALID_FROM) and trunc(VALID_TO))   \
        ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,116,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,30,156,0,0,0,0,0,1,0,
51,0,0,3,174,0,4,177,0,0,9,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,1,0,0,2,9,0,0,2,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,
102,0,0,4,84,0,2,218,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
129,0,0,5,0,0,13,307,0,0,10,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,
184,0,0,8,69,0,4,333,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
207,0,0,6,0,0,13,371,0,0,4,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
238,0,0,7,0,0,13,377,0,0,5,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
273,0,0,9,69,0,4,402,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
296,0,0,5,424,0,9,421,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
323,0,0,5,0,0,15,439,0,0,0,0,0,1,0,
338,0,0,6,603,0,9,635,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
365,0,0,7,318,0,9,639,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
392,0,0,6,0,0,15,664,0,0,0,0,0,1,0,
407,0,0,7,0,0,15,668,0,0,0,0,0,1,0,
422,0,0,10,128,0,4,787,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
};


   

/************************************************************************/
/* CSS MEDICOM VER 2.0                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLRSRUPD.PC                                  */
/* AUTHOR				 :                                              */
/* DATE WRITTEN          :                                              */
/* MODIFIED BY           : V.SRIKANTH                                   */
/* DATE MODIFIED         : 23/03/1999                                   */
/*                                                                      */
/* FUNCTION              : BILLING SERVICE RATE UPDATION                */
/*                                                                      */
/*                                                                      */
/************************************************************************/
      
/*                                
#define DEBUG     
*/
// #define INIT_MESG "Report Generation In Progress"
#include <stdio.h>
#include <string.h>
#include "gl.h"
#include <bl.h>

/* EXEC SQL BEGIN DECLARE SECTION; */ 


    /* VARCHAR uid_pwd[95],
	    d_session_id[16],
	    d_pgm_date[14],
            rep_date[20],
            comp_name[50],
            oper_id[21],
            d_curr_pgm_name[15]; */ 
struct { unsigned short len; unsigned char arr[95]; } uid_pwd;

struct { unsigned short len; unsigned char arr[16]; } d_session_id;

struct { unsigned short len; unsigned char arr[14]; } d_pgm_date;

struct { unsigned short len; unsigned char arr[20]; } rep_date;

struct { unsigned short len; unsigned char arr[50]; } comp_name;

struct { unsigned short len; unsigned char arr[21]; } oper_id;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;


    /* VARCHAR nd_date_time             [17],
	    nd_date_time_1 [17],
	    nd_service_fm            [11],
		nd_operating_facility_id [3],
		nd_ws_no                 [31],
	    nd_service_to            [11],
	    d_rowid                  [25],
	    d_blng_serv_code         [11],
	    d_blng_serv_desc         [41],
	    d_ip_rate                [11],
	    d_op_rate                [11],
	    d_ref_rate               [11],
	    d_min_charge_amt         [11],
	    d_old_ip_rate            [11],
	    d_old_op_rate            [11],
	    d_old_ref_rate           [11],
	    d_old_min_charge_amt     [11]; */ 
struct { unsigned short len; unsigned char arr[17]; } nd_date_time;

struct { unsigned short len; unsigned char arr[17]; } nd_date_time_1;

struct { unsigned short len; unsigned char arr[11]; } nd_service_fm;

struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[31]; } nd_ws_no;

struct { unsigned short len; unsigned char arr[11]; } nd_service_to;

struct { unsigned short len; unsigned char arr[25]; } d_rowid;

struct { unsigned short len; unsigned char arr[11]; } d_blng_serv_code;

struct { unsigned short len; unsigned char arr[41]; } d_blng_serv_desc;

struct { unsigned short len; unsigned char arr[11]; } d_ip_rate;

struct { unsigned short len; unsigned char arr[11]; } d_op_rate;

struct { unsigned short len; unsigned char arr[11]; } d_ref_rate;

struct { unsigned short len; unsigned char arr[11]; } d_min_charge_amt;

struct { unsigned short len; unsigned char arr[11]; } d_old_ip_rate;

struct { unsigned short len; unsigned char arr[11]; } d_old_op_rate;

struct { unsigned short len; unsigned char arr[11]; } d_old_ref_rate;

struct { unsigned short len; unsigned char arr[11]; } d_old_min_charge_amt;


    double d_ip_rate_num,
           d_op_rate_num,
           d_ref_rate_num,
	   d_min_charge_amt_num;
	   

char        nd_option;  /* 
			   1 - Print Edit List only
			   2 - Update price and print revised list
			   3 - Print Revised List only
			*/

/* EXEC SQL END DECLARE SECTION; */ 


/* EXEC SQL INCLUDE SQLCA.H;
 */ 
/*
 * $Header:   T:/eHIS-102/archives/eHIS2Tier/BL/blrsrupd.c-arc   1.0   Apr 19 2007 17:07:12   vcm_th  $ sqlca.h 
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
 * $Header:   T:/eHIS-102/archives/eHIS2Tier/BL/blrsrupd.c-arc   1.0   Apr 19 2007 17:07:12   vcm_th  $ sqlda.h 
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

char hdr_line1[200],
     hdr_line2[200],
     hdr_line3[200],
     hdr_line4[200],
     hdr_line5[200];

char rep_title1[50],
     rep_title2[35];

FILE *f1;

int page_no,
    line_no,
    first_line,
    g_count;

char filename[150];

int rep_width;

void proc_main(argc,argv)
int argc;
char *argv[];
{
     if(argc  < 5) 
	{
        disp_message(ERR_MESG,"BLRSRUPD : Usage BLRSRUPD userid/password session_id pgm_date facility_id");
        proc_exit();
    }

    strcpy(g_pgm_id,"BLRSRUPD");

    strcpy(d_curr_pgm_name.arr,g_pgm_id); 
    d_curr_pgm_name.len = strlen(d_curr_pgm_name.arr); 

    strcpy(uid_pwd.arr,argv[1]);
    uid_pwd.len = strlen(uid_pwd.arr);

    strcpy(d_session_id.arr,argv[2]);
    d_session_id.len = strlen(d_session_id.arr);
    
    strcpy(d_pgm_date.arr,argv[3]);
    d_pgm_date.len = strlen(d_pgm_date.arr);

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
    sqlstm.sqhstl[0] = (unsigned int  )97;
    sqlstm.sqhsts[0] = (         int  )97;
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


	set_meduser_role();

    if(OERROR) {
        disp_message(ORA_MESG,"Unable to connect to oracle.");
        proc_exit();
    }

    fetch_prog_param();
    fetch_sys_info();

	strcpy(filename,WORKING_DIR);
    strcat(filename,"blrsrupd.lis");


//    strcpy(filename,"blrsrupd.lis");

    if( (f1=fopen(filename,"w")) == NULL) {
        disp_message(ERR_MESG,"Error in opening output file...\n");
	proc_exit();
    }

    page_no=1;
    line_no=1;

    decl_curs();

    /*put_inp_parm();*/

    if (nd_option == '1')
        do_report();
    else if (nd_option == '2')
	/*do_update();
    else */
	do_report1();

    print_end_of_rep();

    fclose(f1);

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



    return;
}

fetch_prog_param()
{
    nd_date_time.arr[0]  = '\0';
    nd_service_fm.arr[0] = '\0';
    nd_service_to.arr[0] = '\0';
    nd_operating_facility_id.arr[0] = '\0';
	nd_ws_no.arr[0] = '\0';

    nd_date_time.len     = 0;
    nd_service_fm.len    = 0;
    nd_service_to.len    = 0;
    nd_operating_facility_id.len = 0;
    nd_ws_no.len = 0;

    nd_option = '\0';

   /* EXEC SQL SELECT PARAM1,
		   PARAM2,
		   PARAM3,
		   PARAM4,
		   PARAM5,
		   OPERATING_FACILITY_ID
              INTO :nd_date_time,
                   :nd_service_fm,
                   :nd_service_to,
				   :nd_option,
				   :nd_ws_no,
				   :nd_operating_facility_id
              FROM SY_PROG_PARAM
             WHERE PGM_ID     = :d_curr_pgm_name
               AND SESSION_ID = :d_session_id
               AND PGM_DATE   = :d_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 9;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 ,PARAM5 ,OPERATING_F\
ACILITY_ID into :b0,:b1,:b2,:b3,:b4,:b5  from SY_PROG_PARAM where ((PGM_ID=:b6\
 and SESSION_ID=:b7) and PGM_DATE=:b8)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )51;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_date_time;
   sqlstm.sqhstl[0] = (unsigned int  )19;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_service_fm;
   sqlstm.sqhstl[1] = (unsigned int  )13;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_service_to;
   sqlstm.sqhstl[2] = (unsigned int  )13;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_option;
   sqlstm.sqhstl[3] = (unsigned int  )1;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_ws_no;
   sqlstm.sqhstl[4] = (unsigned int  )33;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[5] = (unsigned int  )5;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&d_curr_pgm_name;
   sqlstm.sqhstl[6] = (unsigned int  )17;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&d_session_id;
   sqlstm.sqhstl[7] = (unsigned int  )18;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&d_pgm_date;
   sqlstm.sqhstl[8] = (unsigned int  )16;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
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

   if (NO_DATA_FOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");

    nd_date_time.arr[nd_date_time.len]                 = '\0';
    nd_service_fm.arr[nd_service_fm.len]               = '\0';
    nd_service_to.arr[nd_service_to.len]               = '\0';
	nd_operating_facility_id.arr[nd_operating_facility_id.len] = '\0';
    nd_ws_no.arr[nd_ws_no.len]               = '\0';

    if(nd_option == '1') {
	rep_width = 100;
        strcpy(rep_title1, "EDIT LIST FOR BILLING SERVICE PRICE UPDATE");
    }
    else {
	rep_width = 140;
        strcpy(rep_title1, "REVISED LIST FOR BILLING SERVICE PRICE UPDATE");
    }

    strcpy(rep_title2,"EFFECTIVE FROM ");
    strcat(rep_title2,nd_date_time.arr);

   /* EXEC SQL DELETE SY_PROG_PARAM
             WHERE PGM_ID     = :d_curr_pgm_name
               AND SESSION_ID = :d_session_id
               AND PGM_DATE   = :d_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 9;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID=:b0 and SESSION\
_ID=:b1) and PGM_DATE=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )102;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_curr_pgm_name;
   sqlstm.sqhstl[0] = (unsigned int  )17;
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
   sqlstm.sqhstv[2] = (         void  *)&d_pgm_date;
   sqlstm.sqhstl[2] = (unsigned int  )16;
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


decl_curs()
{

    /* EXEC SQL DECLARE PRICE_UPDT_CUR CURSOR FOR
	      SELECT ROWID,
		     BLNG_SERV_CODE,
		     LTRIM(TO_CHAR(IP_RATE, '999,990.99')),
		     LTRIM(TO_CHAR(OP_RATE, '999,990.99')),
		     LTRIM(TO_CHAR(REF_RATE,'999,990.99')),
		     LTRIM(TO_CHAR(MIN_CHARGE_AMT ,'999,990.99')),
		     IP_RATE,
		     OP_RATE,
		     REF_RATE,
		     MIN_CHARGE_AMT
		FROM BL_SERV_PRICE_UPDT
	       WHERE EFF_DATE_TIME = TO_DATE(:nd_date_time,'DD/MM/YYYY HH24:MI')
		 AND BLNG_SERV_CODE  BETWEEN NVL(:nd_service_fm,'!!!!!!!!!!') AND 
		       NVL(:nd_service_to,'~~~~~~~~~~')
	       ORDER BY BLNG_SERV_CODE; */ 


    /* EXEC SQL DECLARE REVISED_UPDT_CUR CURSOR FOR
		SELECT 
				LTRIM(TO_CHAR(IP_RATE, '999,990.99')),
				LTRIM(TO_CHAR(OP_RATE, '999,990.99')),
				LTRIM(TO_CHAR(REF_RATE,'999,990.99')),
                LTRIM(TO_CHAR(MIN_CHARGE_AMT ,'999,990.99'))

		FROM   BL_SERV_CUST_PC_PRICE b
		WHERE  CUST_PC_IND  ='S'
		AND    BLNG_SERV_CODE BETWEEN NVL(:nd_service_fm,'!!!!!!!!!!') AND 
		       NVL(:nd_service_to,'~~~~~~~~~~')
		AND   (TRUNC(VALID_TO), BLNG_SERV_CODE) IN
				(SELECT MAX(TRUNC(VALID_TO)), BLNG_SERV_CODE FROM   BL_SERV_CUST_PC_PRICE C
		WHERE NVL(VALID_TO,TRUNC(SYSDATE)) < TO_DATE(:nd_date_time,'DD/MM/YYYY HH24:MI')
		AND CUST_PC_IND  ='S'
		AND B.BLNG_SERV_CODE = C.BLNG_SERV_CODE
		GROUP BY BLNG_SERV_CODE)
		ORDER BY BLNG_SERV_CODE; */ 



    /* EXEC SQL DECLARE REVISED_UPDT_CUR1 CURSOR FOR
		 SELECT blng_serv_code,
				ip_rate,
				op_rate,
				ref_rate,
				LTRIM(TO_CHAR(MIN_CHARGE_AMT ,'999,990.99'))
		 FROM   BL_SERV_CUST_PC_PRICE 
		 WHERE  CUST_PC_IND    = 'S'
		 AND    BLNG_SERV_CODE BETWEEN NVL(:nd_service_fm,'!!!!!!!!!!') AND 
		        NVL(:nd_service_to,'~~~~~~~~~~')
		 AND    TO_DATE(:nd_date_time,'DD/MM/YYYY HH24:MI')
		        between trunc(VALID_FROM) and  trunc(VALID_TO); */ 

}

fetch_data()
{

    d_rowid.arr[0]             = '\0';
    d_blng_serv_code.arr[0]    = '\0';
    d_blng_serv_desc.arr[0]    = '\0';
    d_ip_rate.arr[0]           = '\0';
    d_op_rate.arr[0]           = '\0';
    d_ref_rate.arr[0]          = '\0';
    d_min_charge_amt.arr[0]    = '\0';

    d_rowid.len                = 0;
    d_blng_serv_code.len       = 0;
    d_blng_serv_desc.len       = 0;
    d_ip_rate.len              = 0;
    d_op_rate.len              = 0;
    d_ref_rate.len             = 0;
    d_min_charge_amt.len       = 0;

    d_ip_rate_num              = 0;
    d_op_rate_num              = 0;
    d_ref_rate_num             = 0;
    d_min_charge_amt_num       = 0;

    /* EXEC SQL FETCH PRICE_UPDT_CUR
	      INTO :d_rowid,
		   :d_blng_serv_code,
                   :d_ip_rate,
                   :d_op_rate,
                   :d_ref_rate,
                   :d_min_charge_amt,
                   :d_ip_rate_num,
                   :d_op_rate_num,
                   :d_ref_rate_num,
                   :d_min_charge_amt_num; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )129;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_rowid;
    sqlstm.sqhstl[0] = (unsigned int  )27;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_blng_serv_code;
    sqlstm.sqhstl[1] = (unsigned int  )13;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_ip_rate;
    sqlstm.sqhstl[2] = (unsigned int  )13;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_op_rate;
    sqlstm.sqhstl[3] = (unsigned int  )13;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_ref_rate;
    sqlstm.sqhstl[4] = (unsigned int  )13;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_min_charge_amt;
    sqlstm.sqhstl[5] = (unsigned int  )13;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_ip_rate_num;
    sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_op_rate_num;
    sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&d_ref_rate_num;
    sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&d_min_charge_amt_num;
    sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
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



    if(OERROR)
	err_mesg("FETCH failed on cursor PRICE_UPDT_CUR",0,"");

    if(NO_DATA_FOUND)
	return 0;

    d_rowid.arr[d_rowid.len]                    = '\0';
    d_blng_serv_code.arr[d_blng_serv_code.len]  = '\0';
    d_ip_rate.arr[d_ip_rate.len]                = '\0';
    d_op_rate.arr[d_op_rate.len]                = '\0';
    d_ref_rate.arr[d_ref_rate.len]              = '\0';
    d_min_charge_amt.arr[d_min_charge_amt.len]  = '\0';


    /* EXEC SQL SELECT LONG_DESC
	       INTO :d_blng_serv_desc
	       FROM BL_BLNG_SERV
	      WHERE BLNG_SERV_CODE = :d_blng_serv_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select LONG_DESC into :b0  from BL_BLNG_SERV where BLNG_S\
ERV_CODE=:b1";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )184;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_blng_serv_desc;
    sqlstm.sqhstl[0] = (unsigned int  )43;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_blng_serv_code;
    sqlstm.sqhstl[1] = (unsigned int  )13;
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
	err_mesg("SELECT failed on table BL_BLNG_SERV",0,"");

    d_blng_serv_desc.arr[d_blng_serv_desc.len]  = '\0';

    return 1;
}

fetch_data1()
{

    d_blng_serv_code.arr[0]    = '\0';
    d_blng_serv_desc.arr[0]    = '\0';
    d_ip_rate.arr[0]           = '\0';
    d_op_rate.arr[0]           = '\0';
    d_ref_rate.arr[0]          = '\0';
    d_min_charge_amt.arr[0]    = '\0';
    d_old_ip_rate.arr[0]       = '\0';
    d_old_op_rate.arr[0]       = '\0';
    d_old_ref_rate.arr[0]      = '\0';
    d_old_min_charge_amt.arr[0]= '\0';

    d_blng_serv_code.len       = 0;
    d_blng_serv_desc.len       = 0;
    d_ip_rate.len              = 0;
    d_op_rate.len              = 0;
    d_ref_rate.len             = 0;
    d_min_charge_amt.len       = 0;
    d_old_ip_rate.len          = 0;
    d_old_op_rate.len          = 0;
    d_old_ref_rate.len         = 0;
    d_old_min_charge_amt.len   = 0;

    /* EXEC SQL FETCH REVISED_UPDT_CUR
	      INTO     :d_old_ip_rate,
                   :d_old_op_rate,
                   :d_old_ref_rate,
                   :d_old_min_charge_amt; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )207;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_old_ip_rate;
    sqlstm.sqhstl[0] = (unsigned int  )13;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_old_op_rate;
    sqlstm.sqhstl[1] = (unsigned int  )13;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_old_ref_rate;
    sqlstm.sqhstl[2] = (unsigned int  )13;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_old_min_charge_amt;
    sqlstm.sqhstl[3] = (unsigned int  )13;
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



	/* EXEC SQL FETCH REVISED_UPDT_CUR1
	       INTO  :d_blng_serv_code,
		         :d_ip_rate,
				 :d_op_rate,
				 :d_ref_rate,
				 :d_min_charge_amt; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )238;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_blng_serv_code;
 sqlstm.sqhstl[0] = (unsigned int  )13;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_ip_rate;
 sqlstm.sqhstl[1] = (unsigned int  )13;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_op_rate;
 sqlstm.sqhstl[2] = (unsigned int  )13;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_ref_rate;
 sqlstm.sqhstl[3] = (unsigned int  )13;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_min_charge_amt;
 sqlstm.sqhstl[4] = (unsigned int  )13;
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




    if(OERROR)
	err_mesg("FETCH failed on cursor REVISED_UPDT_CUR",0,"");

    if(NO_DATA_FOUND)
	return 0;

    d_blng_serv_code.arr[d_blng_serv_code.len]          = '\0';
    d_ip_rate.arr[d_ip_rate.len]                        = '\0';
    d_op_rate.arr[d_op_rate.len]                        = '\0';
    d_ref_rate.arr[d_ref_rate.len]                      = '\0';
    d_min_charge_amt.arr[d_min_charge_amt.len]          = '\0';
    d_old_ip_rate.arr[d_old_ip_rate.len]                = '\0';
    d_old_op_rate.arr[d_old_op_rate.len]                = '\0';
    d_old_ref_rate.arr[d_old_ref_rate.len]              = '\0';
    d_old_min_charge_amt.arr[d_old_min_charge_amt.len]  = '\0';


    /* EXEC SQL SELECT LONG_DESC
	       INTO :d_blng_serv_desc
	       FROM BL_BLNG_SERV
	      WHERE BLNG_SERV_CODE = :d_blng_serv_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select LONG_DESC into :b0  from BL_BLNG_SERV where BLNG_S\
ERV_CODE=:b1";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )273;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_blng_serv_desc;
    sqlstm.sqhstl[0] = (unsigned int  )43;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_blng_serv_code;
    sqlstm.sqhstl[1] = (unsigned int  )13;
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
	err_mesg("SELECT failed on table BL_BLNG_SERV",0,"");

    d_blng_serv_desc.arr[d_blng_serv_desc.len]  = '\0';

    return 1;
}


do_report()
{

    put_hdr();

    /* EXEC SQL OPEN PRICE_UPDT_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0005;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )296;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_date_time;
    sqlstm.sqhstl[0] = (unsigned int  )19;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_service_fm;
    sqlstm.sqhstl[1] = (unsigned int  )13;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_service_to;
    sqlstm.sqhstl[2] = (unsigned int  )13;
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
	err_mesg("OPEN failed on cursor PRICE_UPDT_CUR",0,"");

    while(fetch_data()) {

	chk_break(1);
	fprintf(f1,"%-10s %-40s %10s %10s %10s %10s\n",
                  d_blng_serv_code.arr,
                  d_blng_serv_desc.arr,
                  d_ip_rate.arr,
                  d_op_rate.arr,
                  d_ref_rate.arr,
                  d_min_charge_amt.arr);
	line_no ++;

    }

    /* EXEC SQL CLOSE PRICE_UPDT_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )323;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if(OERROR)
	err_mesg("CLOSE failed on cursor PRICE_UPDT_CUR",0,"");
}

do_update()
{
/*

//--Store the date time for updating audit table. 
	nd_date_time_1.arr[0] = '\0';
    EXEC SQL SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') INTO :nd_date_time_1 FROM DUAL;    
	nd_date_time_1.arr[nd_date_time_1.len] = '\0';

    EXEC SQL OPEN PRICE_UPDT_CUR;
    if(OERROR)
	err_mesg("OPEN failed on cursor PRICE_UPDT_CUR",0,"");

    while(fetch_data()) 
	{
	    EXEC SQL UPDATE BL_BLNG_SERV
	            SET OLD_IP_RATE        = IP_RATE,
	                OLD_OP_RATE        = OP_RATE,
	                OLD_REF_RATE       = REF_RATE,
	                OLD_MIN_CHARGE_AMT = MIN_CHARGE_AMT,
	                IP_RATE            = :d_ip_rate_num,
	                OP_RATE            = :d_op_rate_num,
	                REF_RATE           = :d_ref_rate_num,
	                MIN_CHARGE_AMT     = :d_min_charge_amt_num,
	                PRICE_REVISED_DATE = 
	                        TO_DATE(:nd_date_time,'DD/MM/YYYY HH24:MI'),
			MODIFIED_BY_ID     = USER,
			MODIFIED_DATE      =   SYSDATE,
			MODIFIED_AT_WS_NO  = :nd_ws_no,
			MODIFIED_FACILITY_ID = :nd_operating_facility_id
		  WHERE BLNG_SERV_CODE     = :d_blng_serv_code;

	    if(OERROR)
	         err_mesg("UPDATE failed on table BL_BLNG_SERV",0,"");

//INSERT RECORDS IN BL_BLNG_SERV_AUDIT_DTLS ON EVERY SERVICE PRICE 
//    UPDATION. VSK 23/03/1999 

    EXEC SQL  INSERT INTO BL_BLNG_SERV_AUDIT_DTLS (
		 BLNG_SERV_CODE                 ,
		 LONG_DESC                      ,
		 SHORT_DESC                     ,
		 LOC_LANG_LONG_DESC     ,
		 LOC_LANG_SHORT_DESC    ,
		 SERV_GRP_CODE                 ,
		 SERV_CLASSIFICATION_CODE,
		 PRT_GRP_HDR_CODE              ,
		 PRT_GRP_LINE_CODE              ,
		 SOURCE_MODULE_DEPT_FLAG        ,
		 DEPT_CODE                      ,
		 ICD_CODE                       ,
		 BLNG_GRP_PC_PRICE_YN           ,
		 DR_FEE_FLAG                    ,
		 DIR_ENTRY_FLAG                ,
		 SOURCE_MODULE_RATE_FLAG        ,
		 RATE_ENTRY_BY_USER_FLAG        ,
		 DEF_CHARGE                     ,
		 DEF_REF_BILL_TYPE_CODE,
		 IP_RATE                        ,
		 OP_RATE                       ,
		 REF_RATE                      ,
		 EMER_RATE      		              ,
		 DAYCARE_RATE               ,
		 MIN_CHARGE_AMT            ,
		 BASE_QTY                       ,
		 SERV_LOCN_CODE           ,
		 SERV_ANAL_GRP1             ,
		 SERV_ANAL_GRP2              ,
		 OLD_IP_RATE                    ,
		 OLD_OP_RATE                   ,
		 OLD_REF_RATE                  ,
		 OLD_EMER_RATE                ,
		 OLD_DAYCARE_RATE           ,
		 OLD_MIN_CHARGE_AMT        ,
		 PRICE_REVISED_DATE           ,
		 ADDED_BY_ID                    ,
		 MODIFIED_BY_ID            ,
		 ADDED_DATE                     ,
		 MODIFIED_DATE              ,
		 STATUS                         ,
		 PHYS_CAT_CODE             ,
		 MISC_SERV_YN                 ,
		 NURSING_SERV_YN           ,
		 TRX_DATE_TIME                  ,
		 TRX_USER_ID                    ,
		 TRX_TYPE                       ,
		 TRX_REMARKS                ,
		 ADDED_AT_WS_NO          ,
		 ADDED_FACILITY_ID          ,
		 MODIFIED_AT_WS_NO       ,
		 MODIFIED_FACILITY_ID              )

		SELECT   BLNG_SERV_CODE                 ,
			 LONG_DESC                      ,
			 SHORT_DESC                     ,
			 LOC_LANG_LONG_DESC     ,
			 LOC_LANG_SHORT_DESC    ,
			 SERV_GRP_CODE                 ,
			 SERV_CLASSIFICATION_CODE,
			 PRT_GRP_HDR_CODE              ,
			 PRT_GRP_LINE_CODE              ,
			 SOURCE_MODULE_DEPT_FLAG        ,
			 DEPT_CODE                      ,
			 ICD_CODE                       ,
			 BLNG_GRP_PC_PRICE_YN           ,
			 DR_FEE_FLAG                    ,
			 DIR_ENTRY_FLAG                ,
			 SOURCE_MODULE_RATE_FLAG        ,
			 RATE_ENTRY_BY_USER_FLAG        ,
			 DEF_CHARGE                     ,
			 DEF_REF_BILL_TYPE_CODE,
			 IP_RATE                        ,
			 OP_RATE                       ,
			 REF_RATE                      ,
			 EMERG_RATE                    ,
			 DAYCARE_RATE               ,
			 MIN_CHARGE_AMT            ,
			 BASE_QTY                       ,
			 SERV_LOCN_CODE           ,
			 SERV_ANAL_GRP1             ,
			 SERV_ANAL_GRP2              ,
			 OLD_IP_RATE                    ,
			 OLD_OP_RATE                   ,
			 OLD_REF_RATE                  ,
			 OLD_EMER_RATE                ,
			 OLD_DAYCARE_RATE           ,
			 OLD_MIN_CHARGE_AMT        ,
			 PRICE_REVISED_DATE           ,
			 ADDED_BY_ID                    ,
			 user,
			 ADDED_DATE                     ,
			 sysdate,
			 STATUS                         ,
			 PHYS_CAT_CODE             ,
			 MISC_SERV_YN                 ,
			 NURSING_SERV_YN           ,
			 null                  ,
			 null                    ,
			 null                       ,
			 null               ,
			 ADDED_AT_WS_NO          ,
			 ADDED_FACILITY_ID          ,
			 :nd_ws_no,--MODIFIED_AT_WS_NO       ,
			 :nd_operating_facility_id
			 FROM BL_BLNG_SERV
		         WHERE BLNG_SERV_CODE = :d_blng_serv_code;        

if(OERROR)
			err_mesg("INSERT failed on table BL_BLNG_SERV_AUDIT_DTLS",0,"");


    }


//--UPDATE THE FOLLOWING FIELDS IN AUDIT_DTLS FILE VSK 23/03/1999 
	
	EXEC SQL UPDATE BL_BLNG_SERV_AUDIT_DTLS
				SET TRX_DATE_TIME = SYSDATE,
					TRX_TYPE = 'M',
					TRX_USER_ID = USER ,
					TRX_REMARKS = 'FUTURE PRICE REVISION',
					MODIFIED_BY_ID = USER,        
					MODIFIED_DATE  = SYSDATE,        
					MODIFIED_AT_WS_NO = :nd_ws_no,
					MODIFIED_FACILITY_ID  = :nd_operating_facility_id 
				WHERE   TO_DATE(TO_CHAR(MODIFIED_DATE,
					'DD/MM/YYYY HH24:MI'),'DD/MM/YYYY HH24:MI') >= 
						TO_DATE(:nd_date_time_1,'DD/MM/YYYY HH24:MI');

    if(OERROR)
	    err_mesg("UPDATE failed on table BL_BLNG_SERV_audit_dtls",0,"");

    EXEC SQL CLOSE PRICE_UPDT_CUR;
    if(OERROR)
	err_mesg("CLOSE failed on cursor PRICE_UPDT_CUR",0,"");

    EXEC SQL DELETE BL_SERV_PRICE_UPDT
              WHERE EFF_DATE_TIME = TO_DATE(:nd_date_time,'DD/MM/YYYY HH24:MI');

    if(OERROR)
        err_mesg("DELETE failed on BL_SERV_PRICE_UPDT",0,"");
*/
    do_report1();

}   

do_report1()
{

    put_hdr();

    /* EXEC SQL OPEN REVISED_UPDT_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0006;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )338;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_service_fm;
    sqlstm.sqhstl[0] = (unsigned int  )13;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_service_to;
    sqlstm.sqhstl[1] = (unsigned int  )13;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_date_time;
    sqlstm.sqhstl[2] = (unsigned int  )19;
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
	err_mesg("OPEN failed on cursor REVISED_UPDT_CUR",0,"");

   /* EXEC SQL OPEN REVISED_UPDT_CUR1; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 10;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0007;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )365;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_service_fm;
   sqlstm.sqhstl[0] = (unsigned int  )13;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_service_to;
   sqlstm.sqhstl[1] = (unsigned int  )13;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_date_time;
   sqlstm.sqhstl[2] = (unsigned int  )19;
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
	err_mesg("OPEN failed on cursor REVISED_UPDT_CUR1",0,"");




    while(fetch_data1()) {

	chk_break(1);
	fprintf(f1,"%-10s %-40s %10s %10s %10s %10s %10s %10s %10s %10s\n",
                  d_blng_serv_code.arr,
                  d_blng_serv_desc.arr,
                  d_old_ip_rate.arr,
                  d_ip_rate.arr,
                  d_old_op_rate.arr,
                  d_op_rate.arr,
                  d_old_ref_rate.arr,
                  d_ref_rate.arr,
                  d_old_min_charge_amt.arr,
                  d_min_charge_amt.arr);
	line_no ++;

    }

    /* EXEC SQL CLOSE REVISED_UPDT_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )392;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if(OERROR)
	err_mesg("CLOSE failed on cursor REVISED_UPDT_CUR",0,"");

    /* EXEC SQL CLOSE REVISED_UPDT_CUR1; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )407;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if(OERROR)
	err_mesg("CLOSE failed on cursor REVISED_UPDT_CUR1",0,"");
}

chk_break(nol)
int nol;
{

	if(line_no+nol >= 55) {
           line_no = 1;
	   g_count = 1;
	   put_hdr();
	}

}

put_inp_parm()
{

    form_hdr();
    fprintf(f1,"VER : 1.10.01\n");
    fprintf(f1,"\n\n\n\n");
    fprintf(f1,"\tINPUT PARAMETERS\n");
    fprintf(f1,"\t----------------\n\n");
    fprintf(f1,"\t\tEFFECTIVE DATE/TIME   : %s\n",nd_date_time.arr);

}

print_end_of_rep()
{
    int col;
    char buff[200];

    memset(buff,' ',rep_width+1);
    col = (int)(rep_width-19)/2;

    strcpy(buff+col,"** END OF REPORT **",19);
    fprintf(f1,"\n%s\n",buff);
}

put_hdr()
{

    form_hdr();

    if(nd_option == '1')
        fprintf(f1,"BILLING SERVICE CODE AND DESCRIPTION               IP RATE    OP RATE   REF RATE MIN CHARGE\n");
    else {
        fprintf(f1,"BILLING SERVICE CODE AND DESCRIPTION             <------IP RATE-----> <------OP RATE------> <-----REF RATE------> <----MIN CHARGE----->\n");
        fprintf(f1,"                                                  PREVIOUS    REVISED   PREVIOUS    REVISED   PREVIOUS    REVISED   PREVIOUS    REVISED\n");
    }


/*
XXXXXX XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX 999,990.99 999,990.99 999,990.99 999,990.99
*/

/*
XXXXXX XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX 999,990.99 999,990.99 999,990.99 999,990.99 999,990.99 999,990.99 999,990.99 999,990.99
*/

    fprintf(f1,"%s\n",hdr_line5);
    fprintf(f1,"\n");
    line_no=9;

}

form_hdr()
{

    static int first = 1;
    char buf[15];
    int col;

    if(first) {
        memset(hdr_line1,' ',rep_width+1);
        memset(hdr_line2,' ',rep_width+1);
        memset(hdr_line4,' ',rep_width+1);
	memset(hdr_line5,'-',rep_width);
	hdr_line5[rep_width] = '\0';

        strncpy(hdr_line1,"MDL : BL",8);
        col = (int)(rep_width-strlen(comp_name.arr))/2;
        strncpy(hdr_line1+col,comp_name.arr,strlen(comp_name.arr));
        col = (rep_width-strlen(rep_date.arr));
        strcpy(hdr_line1+col,rep_date.arr);
    
        strncpy(hdr_line2,"OPR :",5);
        strcpy(hdr_line2+6,oper_id.arr);

    }

    memset(hdr_line3,' ',rep_width+1);

    strncpy(hdr_line3,"REP : BLRSRUPD",14);
    col = (int)(rep_width-strlen(rep_title1))/2;
    strncpy(hdr_line3+col,rep_title1,strlen(rep_title1));
    sprintf(buf,"PAGE : %4d",page_no++);
    strcpy(hdr_line3+(rep_width-strlen(buf)),buf);

    col = (int)(rep_width-strlen(rep_title2))/2;
    strcpy(hdr_line4+col,rep_title2);

    if(first)
        fprintf(f1,"%s\n",hdr_line1);
    else
        fprintf(f1,"\f%s\n",hdr_line1);
    fprintf(f1,"%s\n",hdr_line2);
    fprintf(f1,"%s\n",hdr_line3);
    fprintf(f1,"%s\n",hdr_line4);
    fprintf(f1,"%s\n",hdr_line5);

    first = 0;
}

fetch_sys_info()
{

    /* EXEC SQL SELECT accounting_name,
		    TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
                    USER 
	     INTO   :comp_name,
		    :rep_date,
		    :oper_id
	     FROM   SY_ACC_ENTITY
		 WHERE ACC_ENTITY_ID = :nd_operating_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select accounting_name ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:\
MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b3";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )422;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
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
    rep_date.arr[rep_date.len] = '\0';
    oper_id.arr[oper_id.len] = '\0';
}

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
