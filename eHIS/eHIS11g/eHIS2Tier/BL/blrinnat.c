
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
           char  filnam[41];
};
static const struct sqlcxp sqlfpn =
{
    40,
    "D:\\work\\october\\kauh_scf\\11g\\blrinnat.pc"
};


static unsigned long sqlctx = 507112459;


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
            void  *sqhstv[11];
   unsigned int   sqhstl[11];
            int   sqhsts[11];
            void  *sqindv[11];
            int   sqinds[11];
   unsigned int   sqharm[11];
   unsigned int   *sqharc[11];
   unsigned short  sqadto[11];
   unsigned short  sqtdso[11];
} sqlstm = {10,11};

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

 static const char *sq0006 = 
"select C.LONG_DESC ,A.BLNG_GRP_ID ,sum(NVL(A.ORG_NET_CHARGE_AMT,0))  from BL\
_PATIENT_CHARGES_FOLIO A ,MP_PATIENT_MAST B ,MP_COUNTRY_LANG_VW C ,BL_BLNG_PRT\
_GRP_HDR D where (((((((((((((A.OPERATING_FACILITY_ID=:b0 and language_id=:b1)\
 and TRUNC(A.TRX_DATE,'MI')>=TO_date(:b2,'DD/MM/YYYY HH24:MI')) and TRUNC(A.TR\
X_DATE,'MI')<=TO_date(:b3,'DD/MM/YYYY HH24:MI')) and A.PATIENT_ID=B.PATIENT_ID\
) and A.BLNG_GRP_ID>=NVL(:b4,'!!!!')) and A.BLNG_GRP_ID<=NVL(:b5,'~~~~')) and \
(NVL(A.PACKAGE_IND,'X')='S' or NVL(AVAILED_IND,'N') in ('U','Y'))) and A.TRX_F\
INALIZE_IND='Y') and A.PRT_GRP_HDR_CODE=D.PRT_GRP_HDR_CODE) and NVL(D.INCOME_Y\
N,'N')='Y') and C.COUNTRY_CODE=B.NATIONALITY_CODE) and B.NATIONALITY_CODE>=NVL\
(:b6,'!!!!!!!!!!!!')) and B.NATIONALITY_CODE<=NVL(:b7,'~~~~~~~~~~~~')) group b\
y C.LONG_DESC,A.BLNG_GRP_ID order by C.LONG_DESC,A.BLNG_GRP_ID            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4146,0,0,0,
5,0,0,1,0,0,27,120,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,229,0,4,148,0,0,11,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
95,0,0,3,158,0,4,198,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
130,0,0,4,0,0,30,228,0,0,0,0,0,1,0,
145,0,0,5,91,0,2,237,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
168,0,0,6,852,0,9,286,0,0,8,8,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,
215,0,0,7,96,0,4,307,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
242,0,0,6,0,0,13,388,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,4,0,0,
269,0,0,8,96,0,4,580,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
292,0,0,9,165,0,6,587,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
323,0,0,10,143,0,6,606,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
350,0,0,11,146,0,6,694,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
};


/*****************************************************************************/
/*                              BLRINNAT.PC                                  */
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
			nd_temp_date[21],
			nd_temp_date1[21],
			date_convert[21],
			date_convert4[21],
			date_convert1[21],
			date_convert2[21],
		    date_convert3[21],
		    nd_loc_date[21],
			nd_loc_date1[21]; */ 
struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[16]; } d_session_id;

struct { unsigned short len; unsigned char arr[14]; } d_pgm_date;

struct { unsigned short len; unsigned char arr[20]; } rep_date;

struct { unsigned short len; unsigned char arr[50]; } comp_name;

struct { unsigned short len; unsigned char arr[21]; } oper_id;

struct { unsigned short len; unsigned char arr[10]; } d_pgm_id;

struct { unsigned short len; unsigned char arr[21]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[21]; } nd_temp_date1;

struct { unsigned short len; unsigned char arr[21]; } date_convert;

struct { unsigned short len; unsigned char arr[21]; } date_convert4;

struct { unsigned short len; unsigned char arr[21]; } date_convert1;

struct { unsigned short len; unsigned char arr[21]; } date_convert2;

struct { unsigned short len; unsigned char arr[21]; } date_convert3;

struct { unsigned short len; unsigned char arr[21]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[21]; } nd_loc_date1;

	    

    /* VARCHAR fm_trans_date           [20],
            to_trans_date           [20],
			fm_trans_date1           [20],
            to_trans_date1          [20],
            
            nd_fm_nat_code	           [5],
            nd_to_nat_code 	           [5],
            
            nd_fm_bill_grp             [5],
            nd_to_bill_grp             [5],
			nd_operating_facility_id   [3],
			l_pk_value		           [100],
		    l_translated_value	       [201],
			p_language_id		[3],
		    nd_facility_id	    [3]; */ 
struct { unsigned short len; unsigned char arr[20]; } fm_trans_date;

struct { unsigned short len; unsigned char arr[20]; } to_trans_date;

struct { unsigned short len; unsigned char arr[20]; } fm_trans_date1;

struct { unsigned short len; unsigned char arr[20]; } to_trans_date1;

struct { unsigned short len; unsigned char arr[5]; } nd_fm_nat_code;

struct { unsigned short len; unsigned char arr[5]; } nd_to_nat_code;

struct { unsigned short len; unsigned char arr[5]; } nd_fm_bill_grp;

struct { unsigned short len; unsigned char arr[5]; } nd_to_bill_grp;

struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;



                     
    /* VARCHAR d_nat_code                 [5],  
            d_nationality              [101], 
			l_blng_grp_desc			   [41], 
			l_prev_nationality		   [101], 	
            d_blng_grp_id              [5]; */ 
struct { unsigned short len; unsigned char arr[5]; } d_nat_code;

struct { unsigned short len; unsigned char arr[101]; } d_nationality;

struct { unsigned short len; unsigned char arr[41]; } l_blng_grp_desc;

struct { unsigned short len; unsigned char arr[101]; } l_prev_nationality;

struct { unsigned short len; unsigned char arr[5]; } d_blng_grp_id;

            
	char	l_message[200],
			f_net_charge_amt[25], 
			f_net_total_charge_amt[25],
			f_grand_total_charge_amt[25];

	 double  d_net_charge_amt ,		
	         l_net_charge_amt,
			l_tot_net_charge_amt,
			l_grand_net_charge_amt;	
			
	    char filename[150];
	    char x_msg[200];
	    char loc_legend[999][201];
	    char l_mesg[200];

	int i;		

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

FILE *f1;

char filename[150];

int page_no = 0,
    line_no,
    rec_cnt = 0,
    print_pos =0,
    g_count;

char file_name[15];

char hdr_line1[REP_WIDTH+1],
     hdr_line2[REP_WIDTH+1],
     hdr_line3[REP_WIDTH+1],
     hdr_line4[REP_WIDTH+1];
     hdr_line5[REP_WIDTH+1];
char rep_title[] = "REVENUE STATISTICS BY NATIONALITY";

void proc_main(argc,argv)
int argc;
char *argv[];
{
    if(argc != 5) 
	{
        disp_message(ERR_MESG,"BLRINNAT : Usage BLRINNPAT userid/password session_id pgm_date facility_id \n");
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
    	//strcpy(g_facility_id,nd_facility_id.arr);

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



    if(OERROR) 
	{
		disp_message(ORA_MESG,"Unable to connect to oracle.\n");
		proc_exit();
    }

    set_meduser_role();

	
	strcpy(p_language_id.arr,l_language_id.arr);
	p_language_id.len = l_language_id.len;

    fm_trans_date.arr[0]    = '\0';
    to_trans_date.arr[0]    = '\0';

    fm_trans_date1.arr[0]    = '\0';
    to_trans_date1.arr[0]    = '\0';


    nd_fm_nat_code.arr[0]  	   = '\0';
    nd_to_nat_code.arr[0] 	   = '\0';
                               
    nd_fm_bill_grp.arr[0]      = '\0';
    nd_to_bill_grp.arr[0]      = '\0';
          
          
 	/* EXEC SQL SELECT OPERATING_FACILITY_ID,
					PARAM1,
					PARAM2,
					PARAM3,
					PARAM4,
					PARAM5,
					PARAM6,
					PARAM7,
					PARAM8
			 INTO   :nd_operating_facility_id,
					:fm_trans_date,
	                :to_trans_date,
	                :nd_fm_nat_code,
	                :nd_to_nat_code,
	                :nd_fm_bill_grp,
                    :nd_to_bill_grp,
				    :fm_trans_date1,
	                :to_trans_date1
     		 FROM   SY_PROG_PARAM
			 WHERE  PGM_ID     = 'BLRINNAT'
			 AND    PGM_DATE   = :d_pgm_date
			 AND    SESSION_ID = TO_NUMBER(:d_session_id); */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,PARAM\
4 ,PARAM5 ,PARAM6 ,PARAM7 ,PARAM8 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8  fr\
om SY_PROG_PARAM where ((PGM_ID='BLRINNAT' and PGM_DATE=:b9) and SESSION_ID=TO\
_NUMBER(:b10))";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )36;
  sqlstm.selerr = (unsigned short)1;
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
  sqlstm.sqhstv[1] = (         void  *)&fm_trans_date;
  sqlstm.sqhstl[1] = (unsigned int  )22;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&to_trans_date;
  sqlstm.sqhstl[2] = (unsigned int  )22;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_fm_nat_code;
  sqlstm.sqhstl[3] = (unsigned int  )7;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_to_nat_code;
  sqlstm.sqhstl[4] = (unsigned int  )7;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_fm_bill_grp;
  sqlstm.sqhstl[5] = (unsigned int  )7;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_to_bill_grp;
  sqlstm.sqhstl[6] = (unsigned int  )7;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&fm_trans_date1;
  sqlstm.sqhstl[7] = (unsigned int  )22;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&to_trans_date1;
  sqlstm.sqhstl[8] = (unsigned int  )22;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&d_pgm_date;
  sqlstm.sqhstl[9] = (unsigned int  )16;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&d_session_id;
  sqlstm.sqhstl[10] = (unsigned int  )18;
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


 
    if(OERROR||NO_DATA_FOUND) 
		err_mesg("SELECT failed on table  SY_PROG_PARAM",0,"");


 
    fm_trans_date.arr[fm_trans_date.len]       = '\0';
    to_trans_date.arr[to_trans_date.len]       = '\0';

    fm_trans_date1.arr[fm_trans_date1.len]       = '\0';
    to_trans_date1.arr[to_trans_date1.len]       = '\0';
	
	nd_fm_nat_code.arr[nd_fm_nat_code.len]	         = '\0';
    nd_to_nat_code.arr[nd_to_nat_code.len]	         = '\0';
                               
    nd_fm_bill_grp.arr[nd_fm_bill_grp.len]		     = '\0';
    nd_to_bill_grp.arr[nd_to_bill_grp.len]     		 = '\0';
    
    strcpy(filename,WORKING_DIR);                          
    strcat(filename,"blrinnat.lis");
    strcpy(g_facility_id, nd_operating_facility_id.arr);

    if((f1=fopen(filename,"w")) == NULL) 
    {
       disp_message(ERR_MESG,"Error in opening output file...\n");
       proc_exit();
    }
 
    /* EXEC SQL SELECT ACC_ENTITY_NAME,
				    TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
                    USER 
		       INTO :comp_name,
				    :rep_date,
				    :oper_id
		       FROM SY_ACC_ENTITY_LANG_VW
			  WHERE ACC_ENTITY_ID = :nd_operating_facility_id
			  AND		language_id=:p_language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:\
MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY_LANG_VW where (ACC_ENTITY_ID=:\
b3 and language_id=:b4)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )95;
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



 
    if(OERROR)
		err_mesg("SELECT failed on table  SY_ACC_ENTITY",0,"");

    comp_name.arr[comp_name.len] = '\0';
    rep_date.arr[rep_date.len]   = '\0';
    oper_id.arr[oper_id.len]     = '\0';

	fetch_legend_value();
 
    decl_curs();
 
    do_report();
 
    fclose(f1);
 

    del_parm();
 

    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )130;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


 

    return;
}

del_parm()
{
 
    /* EXEC SQL DELETE SY_PROG_PARAM
	         WHERE  PGM_ID     = 'BLRINNAT' 
	         AND    PGM_DATE   = :d_pgm_date
	         AND    SESSION_ID = :d_session_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='BLRINNAT' and\
 PGM_DATE=:b0) and SESSION_ID=:b1)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )145;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
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

decl_curs()
{
 
	/* EXEC SQL DECLARE TRANS_LIST_CUR 
			 CURSOR 
				FOR
			 SELECT  C.LONG_DESC ,
					 A.BLNG_GRP_ID,
      				 SUM(NVL(A.ORG_NET_CHARGE_AMT,0))
    		   FROM  BL_PATIENT_CHARGES_FOLIO A, 
		 			 MP_PATIENT_MAST B,
					 MP_COUNTRY_LANG_VW C ,
					 BL_BLNG_PRT_GRP_HDR D
			  WHERE  A.OPERATING_FACILITY_ID =  :nd_operating_facility_id
			   AND		language_id=:p_language_id
            	AND  TRUNC(A.TRX_DATE,'MI')    >= TO_date(:fm_trans_date,'DD/MM/YYYY HH24:MI')
				AND  TRUNC(A.TRX_DATE,'MI')    <= TO_date(:to_trans_date,'DD/MM/YYYY HH24:MI')
//				AND  A.TRX_DATE    >= TO_DATE(NVL(:fm_trans_date||' 00:00','01/01/1000 00:00'),'DD/MM/YYYY HH24:MI')
//				AND  A.TRX_DATE    <= TO_DATE(NVL(:to_trans_date||' 23:59','01/01/3000 23:59'),'DD/MM/YYYY HH24:MI')
				AND  A.PATIENT_ID   = B.PATIENT_ID
				AND  A.BLNG_GRP_ID >= NVL(:nd_fm_bill_grp,'!!!!')
				AND  A.BLNG_GRP_ID <= NVL(:nd_to_bill_grp,'~~~~')   
				AND  (NVL(A.PACKAGE_IND,'X') = 'S' 		          
					 OR 
					 NVL(AVAILED_IND,'N') IN('U','Y'))             
				AND  A.TRX_FINALIZE_IND    = 'Y'
				AND  A.PRT_GRP_HDR_CODE    = D.PRT_GRP_HDR_CODE
				AND  NVL(D.INCOME_YN,'N')  = 'Y'
				AND  C.COUNTRY_CODE        = B.NATIONALITY_CODE
				AND  B.NATIONALITY_CODE   >= NVL(:nd_fm_nat_code,'!!!!!!!!!!!!')
				AND  B.NATIONALITY_CODE   <= NVL(:nd_to_nat_code,'~~~~~~~~~~~~')
			  GROUP 
				 BY	 C.LONG_DESC,
					 A.BLNG_GRP_ID
			  ORDER 
				 BY	 C.LONG_DESC,
					 A.BLNG_GRP_ID; */ 


 
	/* EXEC SQL OPEN TRANS_LIST_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0006;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )168;
 sqlstm.selerr = (unsigned short)1;
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
 sqlstm.sqhstv[1] = (         void  *)&p_language_id;
 sqlstm.sqhstl[1] = (unsigned int  )5;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&fm_trans_date;
 sqlstm.sqhstl[2] = (unsigned int  )22;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&to_trans_date;
 sqlstm.sqhstl[3] = (unsigned int  )22;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_fm_bill_grp;
 sqlstm.sqhstl[4] = (unsigned int  )7;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_to_bill_grp;
 sqlstm.sqhstl[5] = (unsigned int  )7;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&nd_fm_nat_code;
 sqlstm.sqhstl[6] = (unsigned int  )7;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&nd_to_nat_code;
 sqlstm.sqhstl[7] = (unsigned int  )7;
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



    if(OERROR)
		err_mesg("OPEN failed on cursor TRANS_LIST_CUR",0,"");
}


do_report()
{
 
    int cnt,hdr_cnt,first,i;
    hdr_cnt=0;
    line_no = 1;
    g_count = 1;
    form_hdr(); 
	l_tot_net_charge_amt   = 0; 
	l_grand_net_charge_amt = 0; 
     while(fetch_trans_list()) 
	{
 
		l_blng_grp_desc.arr[0] = '\0'; 
		/* EXEC SQL SELECT short_desc
		           INTO :l_blng_grp_desc
				   FROM bl_blng_grp_LANG_VW
				  WHERE blng_grp_id = 	:d_blng_grp_id
				  AND		language_id=:p_language_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select short_desc into :b0  from bl_blng_grp_LANG_VW where \
(blng_grp_id=:b1 and language_id=:b2)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )215;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&l_blng_grp_desc;
  sqlstm.sqhstl[0] = (unsigned int  )43;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_blng_grp_id;
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



		l_blng_grp_desc.arr[l_blng_grp_desc.len] = '\0';
 

		print_formated(f_net_charge_amt,d_net_charge_amt);  
		if(l_prev_nationality.arr[0]=='\0')
          
	        fprintf(f1,"%-27.27s%2s%-4s %-24.24s%2s%20s\n",d_nationality.arr," ",d_blng_grp_id.arr,l_blng_grp_desc.arr," ",f_net_charge_amt);	 
			             
 		//	fprintf(f1,"%-28.28s  %-2.2s   %-15.15s  %20s\n",d_nationality.arr,d_blng_grp_id.arr,l_blng_grp_desc.arr,f_net_charge_amt);	 commented by saikiran
		else if(strcmp(l_prev_nationality.arr,d_nationality.arr)!=0)
		{
		        
			line_no = line_no+4;
			chk_break(3);
			print_formated(f_net_total_charge_amt,l_tot_net_charge_amt); 
			fprintf(f1,"                                                             -------------------\n");
			//fprintf(f1,"                              %10s            %20s\n",loc_legend[10],f_net_total_charge_amt);commented by saikiran
			fprintf(f1,"%-35.35s%-23.23s %21s\n"," ",loc_legend[10],f_net_total_charge_amt);
			fprintf(f1,"                                                             -------------------\n\n");
			//fprintf(f1,"%-28.28s  %-4.4s   %-15.15s  %20s\n",d_nationality.arr,d_blng_grp_id.arr,l_blng_grp_desc.arr,f_net_charge_amt);	commented by saikiran
			fprintf(f1,"%-27.27s%2s%-4s %-24.24s%2s%20s\n",d_nationality.arr," ",d_blng_grp_id.arr,l_blng_grp_desc.arr," ",f_net_charge_amt);

			l_tot_net_charge_amt=0;
		}
		else
			//fprintf(f1,"%-28.28s  %-4.4s   %-15.15s   %20s\n"," ",d_blng_grp_id.arr,l_blng_grp_desc.arr,f_net_charge_amt);	commented by saikiran
			fprintf(f1,"%-29.29s%-4.4s %-24.24s%2s%20s\n"," ",d_blng_grp_id.arr,l_blng_grp_desc.arr," ",f_net_charge_amt);
 
		l_tot_net_charge_amt   = l_tot_net_charge_amt   + d_net_charge_amt; 
		l_grand_net_charge_amt = l_grand_net_charge_amt + d_net_charge_amt; 
 
		l_prev_nationality.len = 0;
		strcpy(l_prev_nationality.arr,d_nationality.arr);
		l_prev_nationality.len = strlen(l_prev_nationality.arr);
		line_no++;
		chk_break(3);
    } 
 
	line_no = line_no+3;
	chk_break(3);

	print_formated(f_net_total_charge_amt,l_tot_net_charge_amt); 
	fprintf(f1,"                                                             -------------------\n");
	//fprintf(f1,"                              %10.10s            %20s\n",loc_legend[10],f_net_total_charge_amt);commented by saikiran
	fprintf(f1,"%-35.35s%-23.23s %21s\n"," ",loc_legend[10],f_net_total_charge_amt);
	fprintf(f1,"                                                             -------------------\n");
	
	line_no = line_no+2;
	chk_break(3);

	print_formated(f_grand_total_charge_amt,l_grand_net_charge_amt); 
	//fprintf(f1,"                              %17.17s     %20s\n",loc_legend[20],f_grand_total_charge_amt);commented by saikiran
	fprintf(f1,"%-35.35s%-23.23s %21s\n"," ",loc_legend[20],f_grand_total_charge_amt);
	fprintf(f1,"                                                             -------------------\n");
	l_grand_net_charge_amt=0;

	line_no ++;
	chk_break(3);
	print_end_of_rep();
}

fetch_trans_list()
{

    d_nat_code.arr[0]          = '\0';
    d_nationality.arr[0]       = '\0';
    d_blng_grp_id.arr[0]	   = '\0';

    d_nat_code.len             = 0;
    d_nationality.len 	       = 0;
    d_blng_grp_id.len 		   = 0;

    d_net_charge_amt           = 0;
 

    /* EXEC SQL FETCH TRANS_LIST_CUR INTO
            	   :d_nationality,
                   :d_blng_grp_id,
                   :d_net_charge_amt; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )242;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_nationality;
    sqlstm.sqhstl[0] = (unsigned int  )103;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_blng_grp_id;
    sqlstm.sqhstl[1] = (unsigned int  )7;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_net_charge_amt;
    sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
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
		err_mesg("FETCH failed on cursor TRANS_LIST_CUR",0,"");

    if(NO_DATA_FOUND)
		return 0;
 
    d_nat_code.arr[d_nat_code.len]        = '\0';
    d_nationality.arr[d_nationality.len]  = '\0';
    d_blng_grp_id.arr[d_blng_grp_id.len]  = '\0';
    return 1;
}

chk_break(nol)
int nol;
{
	if(line_no+nol >= 55) 
	{
       fprintf(f1,"");
	   g_count = 1;
       form_hdr();
	}
}

print_end_of_rep()
{
    fprintf(f1,"\n\n                            ** %17s **\n",loc_legend[140]);
}


print_formated(s_amt, l_amt)
double l_amt;
char s_amt[500];
{

    if(l_amt < 0)
	{
       
		put_val(s_amt,-l_amt); 
        format_amt(s_amt); 
        strcat(s_amt,"-");
    }
    else 
	{
        put_val(s_amt,l_amt);
        format_amt(s_amt);
        strcat(s_amt," ");
    }
}


form_hdr()
{
    static int first = 1;
    char buf[17];
    char ctmp[50];
	char dtmp[50];
    int col;
	int i;

    char fm_nat_code   [150];
    char to_nat_code   [150];
    char fm_bill_grp   [150];
    char to_bill_grp   [150]; 


    if(strcmp(nd_fm_nat_code.arr,"!!!!") == 0)
      strcpy(fm_nat_code, loc_legend[120]);
    else 
      strcpy(fm_nat_code, nd_fm_nat_code.arr);      
      
    if(strcmp(nd_to_nat_code.arr,"~~~~") == 0)
       strcpy(to_nat_code, loc_legend[130]);
    else 
       strcpy(to_nat_code, nd_to_nat_code.arr);
          

    if(strcmp(nd_fm_bill_grp.arr,"!!") == 0)
       strcpy(fm_bill_grp, loc_legend[120]);
    else 
       strcpy(fm_bill_grp, nd_fm_bill_grp.arr); 
    
    if(strcmp(nd_to_bill_grp.arr,"~~") == 0)
      strcpy(to_bill_grp, loc_legend[130]);
    else 
      strcpy(to_bill_grp, nd_to_bill_grp.arr);
    
    ++page_no; 

    if(first) 
	{ 
        memset(hdr_line1,' ',REP_WIDTH+1);
        memset(hdr_line2,' ',REP_WIDTH+1);

        strcpy(hdr_line1,"MDL : ");
		strcat(hdr_line1,loc_legend[50]);
        col = (int)(REP_WIDTH-strlen(comp_name.arr))/2;
        strncpy(hdr_line1+col,comp_name.arr,strlen(comp_name.arr));

		init_date_temp_var();
		strcpy(date_convert4.arr,rep_date.arr);
		fun_change_loc_date4();
        col = (REP_WIDTH-strlen(date_convert4.arr));
        strcpy(hdr_line1+col,date_convert4.arr);
    
        strncpy(hdr_line2,"OPR :",5);
        strcpy(hdr_line2+6,oper_id.arr);

		first = 0;
    } 
    memset(hdr_line3,' ',REP_WIDTH+1);

    strcpy(hdr_line3,"REP : ");
	strcat(hdr_line3,loc_legend[40]);
    col = (int)(REP_WIDTH-strlen(rep_title))/2;
    strncpy(hdr_line3+col,rep_title,strlen(rep_title));
    sprintf(buf,"%4s%4s :  %4d"," ",loc_legend[30],page_no);
    strcpy(hdr_line3+(REP_WIDTH-16),buf); 
    fprintf(f1,"%s            %-s\n",hdr_line1, comp_name.arr);
    fprintf(f1,"%s \n",hdr_line2);
    fprintf(f1,"%s      %-29s\n",hdr_line3, hdr_line3+col);

	 memset(hdr_line4,' ',REP_WIDTH+1);        
	 //memset(hdr_line5,' ',REP_WIDTH+1); 

 

	init_date_temp_var();
     strcpy(date_convert.arr,fm_trans_date1.arr);
     fun_change_loc_date();
    strcpy(date_convert1.arr,date_convert.arr);

	sprintf(ctmp,"%6s %2s :%s",loc_legend[80],loc_legend[60],date_convert1.arr);	                                   
    
	init_date_temp_var();
    strcpy(date_convert.arr,to_trans_date1.arr);
 	fun_change_loc_date();
	strcpy(date_convert2.arr,date_convert.arr);
	sprintf(dtmp,"%2s :%s",loc_legend[70],date_convert2.arr);
  
	init_date_temp_var();
    strcpy(date_convert3.arr,fm_trans_date.arr);
    fun_change_loc_date1();
    strcpy(fm_trans_date.arr,date_convert3.arr);

	init_date_temp_var();
    strcpy(date_convert3.arr,to_trans_date.arr);
    fun_change_loc_date1();
    strcpy(to_trans_date.arr,date_convert3.arr); 

   
    col = (int)(REP_WIDTH-strlen(ctmp))/2;
    strncpy(hdr_line4+col,ctmp,strlen(ctmp));
    //col = (int)(REP_WIDTH-strlen(dtmp))/2;
    strncpy(hdr_line5,dtmp,strlen(dtmp));

	//fprintf(f1,"%s %s\n",hdr_line4,hdr_line5);
	fprintf(f1,"                       %13s %4s\n",ctmp,dtmp);   
    fprintf(f1,"                      %11s %4s %s %2s %s\n",loc_legend[90],loc_legend[60],fm_nat_code,loc_legend[70],to_nat_code);  
    fprintf(f1,"                     %13s %4s %s %2s %s\n",loc_legend[100],loc_legend[60],fm_bill_grp,loc_legend[70],to_bill_grp);  
                     
 
    for (i=0;i<REP_WIDTH;i++)
		fprintf(f1,"-"); 
    
	fprintf(f1,"\n"); 
       
    fprintf(f1,"%-27.27s%2s%-28.28s%2s%21s\n",loc_legend[90]," ",loc_legend[100], " ",loc_legend[110]); 

    for (i=0;i<REP_WIDTH;i++)
		fprintf(f1,"-"); 
	fprintf(f1,"\n"); 
 
	line_no=10;   
}

print_spaces(n)
{
	int j=0;
	for(j=0;j<n;j++)
	fprintf(f1," ");
}

fetch_legend_value()
{
	for(i=1;i<=900;i++)
	{
		l_pk_value.arr[0] = '\0'; 
		/* EXEC SQL SELECT LTRIM(RTRIM('BLRINNAT.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLRINNAT.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )269;
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
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility_id , 'S\
M' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_valu\
e , :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )292;
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
get_local_date()
{
 	
	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;
	
	BEGIN
	  
      // 	get_locale_date.CONVERT_TO_LOCALE_DATE(to_date(:nd_temp_date,'DD/MM/YYYY HH24:MI'),:p_language_id,t_date);  
      
	  // :nd_loc_date := to_char(t_date,'DD/MM/YYYY');
	   :nd_loc_date :=  	sm_convert_date_2t(to_date(:nd_temp_date,'DD/MM/YYYY HH24:MI:SS'),:p_language_id);  
	
      
	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN :nd_loc_date := sm_convert_date_\
2t ( to_date ( :nd_temp_date , 'DD/MM/YYYY HH24:MI:SS' ) , :p_language_id ) ; \
END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )323;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_loc_date;
 sqlstm.sqhstl[0] = (unsigned int  )23;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_temp_date;
 sqlstm.sqhstl[1] = (unsigned int  )23;
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
        err_mesg("SELECTING Date failed",0,"");

}

                     
init_date_temp_var()
{
nd_temp_date.arr[0] = '\0';
nd_temp_date1.arr[0] = '\0';
nd_loc_date.arr[0]  = '\0';
nd_loc_date1.arr[0]  = '\0';
date_convert.arr[0] = '\0';
date_convert4.arr[0] = '\0';
date_convert1.arr[0] = '\0';
date_convert2.arr[0] = '\0';
date_convert3.arr[0] = '\0';

nd_temp_date.len = 0;
nd_loc_date.len  = 0;
nd_temp_date1.len = 0;
nd_loc_date1.len  = 0;

date_convert.len = 0;
date_convert1.len = 0;
date_convert2.len = 0;
date_convert3.len = 0;
date_convert4.len = '0';
}


fun_change_loc_date()
{
 
strcpy(nd_temp_date.arr,date_convert.arr);
nd_temp_date.len = strlen(nd_temp_date.arr); 
 
get_local_date();
 strcpy(date_convert.arr,nd_loc_date.arr); 
 
}


fun_change_loc_date4()
{ 

strcpy(nd_temp_date.arr,date_convert4.arr);
nd_temp_date.len = strlen(nd_temp_date.arr); 
 
get_local_date();
 strcpy(date_convert4.arr,nd_loc_date.arr); 
 
}



fun_change_loc_date1()
{
  
strcpy(nd_temp_date1.arr,date_convert3.arr);
nd_temp_date1.len = strlen(nd_temp_date1.arr);

get_local_date1();
strcpy(date_convert3.arr,nd_loc_date1.arr);
}

get_local_date1()
{

	
	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;
	
	BEGIN
	  
  //     	get_locale_date.CONVERT_TO_LOCALE_DATE(to_date(:nd_temp_date1,'DD/MM/YYYY HH24:MI'),:p_language_id,t_date);  
      
//	   :nd_loc_date1 := to_char(t_date,'DD/MM/YYYY HH24:MI');
	
  	   :nd_loc_date1 :=  	sm_convert_datetime_2t(to_date(:nd_temp_date1,'DD/MM/YYYY HH24:MI'),:p_language_id);  
    
	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN :nd_loc_date1 := sm_convert_date\
time_2t ( to_date ( :nd_temp_date1 , 'DD/MM/YYYY HH24:MI' ) , :p_language_id )\
 ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )350;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_loc_date1;
 sqlstm.sqhstl[0] = (unsigned int  )23;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_temp_date1;
 sqlstm.sqhstl[1] = (unsigned int  )23;
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
        err_mesg("SELECTING get_local_date1 failed",0,"");

}