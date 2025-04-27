
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/BLRBSVBG.pc"
};


static unsigned int sqlctx = 1288467059;


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

 static const char *sq0010 = 
"select b.blng_serv_code ,decode(b.blng_class_code,'**','All',b.blng_class_co\
de) ,to_char(b.ip_rate) ,to_char(b.op_rate) ,to_char(b.ref_rate) ,to_char(b.em\
er_rate) ,to_char(DAYCARE_RATE)  from BL_SERV_CUST_PC_PRICE b where (((b.cust_\
pc_ind='S' and (b.cust_pc_code=:b0 or (b.cust_pc_code='ALL' and 0=(select coun\
t(*)   from bl_serv_cust_pc_price where ((((cust_pc_code=:b0 and cust_pc_ind=b\
.cust_pc_ind) and blng_serv_code=b.blng_serv_code) and cust_pc_ind='S') and ro\
wnum=1))))) and TO_DATE(:b2,'DD/MM/YYYY') between TRUNC(b.valid_from) and NVL(\
trunc(b.VALID_TO),trunc(sysdate))) and b.blng_serv_code between NVL(:b3,'!!!!!\
!!!!!') and NVL(:b4,'~~~~~~~~~~')) order by 1,2            ";

 static const char *sq0011 = 
"select a.rate_factor_ind ,a.cust_pc_code ,a.blng_serv_code ,DECODE(a.blng_cl\
ass_code,'**','All',a.blng_class_code) ,to_char(a.ip_rate) ,to_char(a.op_rate)\
 ,to_char(a.ref_rate) ,to_char(a.emer_rate) ,to_char(DAYCARE_RATE)  from bl_se\
rv_cust_pc_price a where ((((((:b0='N' and a.blng_serv_code=:b1) and a.blng_cl\
ass_code=:b2) or (:b0='Y' and a.blng_serv_code between NVL(:b4,'!!!!!!!!!!') a\
nd NVL(:b5,'~~~~~~~~~~'))) and a.cust_pc_code in (:b6,:b7,:b8,:b9,:b10,:b11)) \
and TO_DATE(:b12,'DD/MM/YYYY') between NVL(a.valid_from(+),to_date('01011000',\
'DDMMYYYY')) and NVL(a.valid_to(+),to_date('01014000','DDMMYYYY'))) and a.cust\
_pc_ind(+)='B') order by a.blng_serv_code,a.blng_class_code desc ,a.cust_pc_co\
de            ";

 static const char *sq0012 = 
"select distinct blng_grp_id ,LPAD((' '||short_desc),15,'-')  from bl_blng_Gr\
p where blng_grp_id in (:b0,:b1,:b2,:b3,:b4,:b5) order by blng_Grp_id         \
   ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,131,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,30,143,0,0,0,0,0,1,0,
51,0,0,3,0,0,32,149,0,0,0,0,0,1,0,
66,0,0,4,336,0,4,175,0,0,14,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
137,0,0,5,91,0,2,220,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
160,0,0,6,0,0,32,230,0,0,0,0,0,1,0,
175,0,0,7,91,0,2,238,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
198,0,0,8,128,0,4,249,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
229,0,0,9,0,0,32,266,0,0,0,0,0,1,0,
244,0,0,10,681,0,9,348,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
279,0,0,13,0,0,32,354,0,0,0,0,0,1,0,
294,0,0,10,0,0,13,373,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,
337,0,0,14,0,0,32,398,0,0,0,0,0,1,0,
352,0,0,11,0,0,13,421,0,0,9,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
403,0,0,15,0,0,32,457,0,0,0,0,0,1,0,
418,0,0,12,0,0,13,470,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
441,0,0,16,0,0,32,485,0,0,0,0,0,1,0,
456,0,0,10,0,0,15,494,0,0,0,0,0,1,0,
471,0,0,11,714,0,9,537,0,0,13,13,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
538,0,0,17,210,0,4,543,0,0,8,7,0,1,0,2,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,
585,0,0,11,0,0,15,565,0,0,0,0,0,1,0,
600,0,0,11,714,0,9,573,0,0,13,13,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
667,0,0,18,210,0,4,593,0,0,8,7,0,1,0,2,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,
714,0,0,11,0,0,15,617,0,0,0,0,0,1,0,
729,0,0,12,157,0,9,834,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,
768,0,0,12,157,0,9,924,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,
};


/*************************************************************

Author    :  Harish A   24/12/2002
Name      :  Billing Service Price List for Billing Group
Project   :  HMC

*************************************************************/

#include <stdio.h>          
#include <string.h>      
#include <math.h>
#include <bl.h> 
 
#define MAX_LINES 55
#define OERROR (sqlca.sqlcode < 0) 
#define NODATAFOUND sqlca.sqlcode==1403
#define VER  "VER : 4.1\n"     
                          
/* EXEC SQL BEGIN DECLARE SECTION; */ 


	/* VARCHAR uid_pwd						[42],
			nd_session_id        		[16],
			nd_pgm_date	    			[20],

			//input parameters through from SY_PROG_PARAM 
			l_fm_blng_serv_id			[11],
			l_to_blng_serv_id			[11],
			l_price_class1				[10],
			l_price_class2				[10],
			l_price_class3				[10],
			l_price_class4				[10],
			l_price_class5				[10],
			l_price_class6				[10],
			l_as_on_date				[30],
			l_exclude_std_price			[5],
			d_facility_id				[10],

			//for header routine
			d_acc_entity_name			[41],
			d_user						[21],
			d_sysdate					[17],

			//Variable used inside the program
			l_pc_cust_pc_code			[11],	
			l_pc_blng_serv_code			[11],
			l_blng_serv_code			[11],
			l_current_blng_serv_code	[11],
			l_blng_class_code			[11],
			l_current_blng_class		[11],
			l_rate_factor_ind			[5],
			l_dist_pc_class				[10],
			l_blng_class				[11],
			l_pc_ip_rate				[10],
			l_pc_op_rate				[10],
			l_pc_ref_rate				[10],
			l_pc_emer_rate				[10],
			l_pc_dc_rate                            [10], //EPNH 31/10/2004
			l_blng_serv_ip_rate			[15],
			l_blng_serv_op_rate			[15],
			l_blng_serv_ref_rate		[15],
			l_blng_serv_emerg_rate		[15],
                        l_blng_serv_dc_rate		[15],  //EPNH 31/10/2004
			l_short_desc				[20]; */ 
struct { unsigned short len; unsigned char arr[42]; } uid_pwd;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[20]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[11]; } l_fm_blng_serv_id;

struct { unsigned short len; unsigned char arr[11]; } l_to_blng_serv_id;

struct { unsigned short len; unsigned char arr[10]; } l_price_class1;

struct { unsigned short len; unsigned char arr[10]; } l_price_class2;

struct { unsigned short len; unsigned char arr[10]; } l_price_class3;

struct { unsigned short len; unsigned char arr[10]; } l_price_class4;

struct { unsigned short len; unsigned char arr[10]; } l_price_class5;

struct { unsigned short len; unsigned char arr[10]; } l_price_class6;

struct { unsigned short len; unsigned char arr[30]; } l_as_on_date;

struct { unsigned short len; unsigned char arr[5]; } l_exclude_std_price;

struct { unsigned short len; unsigned char arr[10]; } d_facility_id;

struct { unsigned short len; unsigned char arr[41]; } d_acc_entity_name;

struct { unsigned short len; unsigned char arr[21]; } d_user;

struct { unsigned short len; unsigned char arr[17]; } d_sysdate;

struct { unsigned short len; unsigned char arr[11]; } l_pc_cust_pc_code;

struct { unsigned short len; unsigned char arr[11]; } l_pc_blng_serv_code;

struct { unsigned short len; unsigned char arr[11]; } l_blng_serv_code;

struct { unsigned short len; unsigned char arr[11]; } l_current_blng_serv_code;

struct { unsigned short len; unsigned char arr[11]; } l_blng_class_code;

struct { unsigned short len; unsigned char arr[11]; } l_current_blng_class;

struct { unsigned short len; unsigned char arr[5]; } l_rate_factor_ind;

struct { unsigned short len; unsigned char arr[10]; } l_dist_pc_class;

struct { unsigned short len; unsigned char arr[11]; } l_blng_class;

struct { unsigned short len; unsigned char arr[10]; } l_pc_ip_rate;

struct { unsigned short len; unsigned char arr[10]; } l_pc_op_rate;

struct { unsigned short len; unsigned char arr[10]; } l_pc_ref_rate;

struct { unsigned short len; unsigned char arr[10]; } l_pc_emer_rate;

struct { unsigned short len; unsigned char arr[10]; } l_pc_dc_rate;

struct { unsigned short len; unsigned char arr[15]; } l_blng_serv_ip_rate;

struct { unsigned short len; unsigned char arr[15]; } l_blng_serv_op_rate;

struct { unsigned short len; unsigned char arr[15]; } l_blng_serv_ref_rate;

struct { unsigned short len; unsigned char arr[15]; } l_blng_serv_emerg_rate;

struct { unsigned short len; unsigned char arr[15]; } l_blng_serv_dc_rate;

struct { unsigned short len; unsigned char arr[20]; } l_short_desc;


	int		l_no_of_pc_cells = 0;
	int		l_pc_counter     = 0;
	int		i;

	double	l_print_position = 0;

	char	cl_blng_serv_ip_rate[15],
			cl_blng_serv_op_rate[15],
			cl_blng_serv_ref_rate[15],
			cl_blng_serv_emerg_rate[15],
			cl_blng_serv_dc_rate[15]; //EPNH 31/10/2004

	char	filename[10];
	char	l_print_format_change;
	char    aMesg[300];

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

int  line_no=0, 
	 page_no=0;

void proc_main(argc, argv)
int argc;
char *argv[];
{
	void	get_params(),
  			get_header_dtls(),
  			do_report();
    
 
	if(argc < 5) 
	{
		disp_message(ERR_MESG,"Usage BLRBSVBG uid/passwd session_id pgm_date facility_id");
		proc_exit();
	}

    strcpy(uid_pwd.arr,argv[1]);
    uid_pwd.len = strlen(uid_pwd.arr);

    strcpy(nd_session_id.arr,argv[2]);
    nd_session_id.len = strlen(nd_session_id.arr);
    strcpy(g_session_id,argv[2]);
    
    strcpy(nd_pgm_date.arr,argv[3]);
    nd_pgm_date.len = strlen(nd_pgm_date.arr);


    strcpy(g_pgm_id,"BLRBSVBG");
    strcpy(g_pgm_date,argv[3]);

	strcpy(filename,WORKING_DIR);
	strcat(filename,"blrbsvbg.lis");

	if((f1 = fopen(filename, "w")) == NULL) 
	{
		disp_message(ERR_MESG,".... Error opening output file ....");
		proc_exit();
	} 

	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

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
 sqlstm.sqlcmax = (unsigned int )100;
 sqlstm.sqlcmin = (unsigned int )2;
 sqlstm.sqlcincr = (unsigned int )1;
 sqlstm.sqlctimeout = (unsigned int )0;
 sqlstm.sqlcnowait = (unsigned int )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
 if (sqlca.sqlcode < 0) goto err_exit;
}

  

	set_meduser_role();

	get_params();
	get_header_dtls();
	declare_cursor();
	do_report();
	delete_prog_param();
	close_cursors();
	fclose(f1);
	
	/* EXEC SQL COMMIT WORK RELEASE; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )36;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
 if (sqlca.sqlcode < 0) goto err_exit;
}



	return;
   
	err_exit:
	   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

	   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 4;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )51;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	   disp_message(ERR_MESG,"Oracle error at main() occured....");
	   disp_message(ERR_MESG, sqlca.sqlerrm.sqlerrmc);
	   proc_exit();
}


// get the parameters from the SY_PROG_PARM table and
// delete the record after reading it.
void get_params()
{

   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


	l_fm_blng_serv_id.arr[0]     = '\0';
	l_to_blng_serv_id.arr[0]     = '\0';
	l_price_class1.arr[0]		= '\0';
	l_price_class2.arr[0]		= '\0';
	l_price_class3.arr[0]		= '\0';
	l_price_class4.arr[0]		= '\0';
	l_price_class5.arr[0]		= '\0';
	l_price_class6.arr[0]		= '\0';
	l_as_on_date.arr[0]			= '\0';
	l_exclude_std_price.arr[0]  = '\0';
	d_facility_id.arr[0]		= '\0';

	/* EXEC SQL SELECT PARAM1,
			 	    PARAM2,
				    NVL(PARAM3,'!@#'),
				    NVL(PARAM4,'!@#'),
				    NVL(PARAM5,'!@#'),
				    NVL(PARAM6,'!@#'),
				    NVL(PARAM7,'!@#'),
				    NVL(PARAM8,'!@#'),
				    PARAM9,
				    PARAM10,
					PARAM11,
				    operating_facility_id
            INTO    :l_fm_blng_serv_id,
				    :l_to_blng_serv_id,
				    :l_price_class1,
				    :l_price_class2,
				    :l_price_class3,
				    :l_price_class4,
				    :l_price_class5,
				    :l_price_class6,
				    :l_as_on_date,
					:l_no_of_pc_cells,
					:l_exclude_std_price,
				    :d_facility_id
			   FROM SY_PROG_PARAM
			  WHERE PGM_ID		= 'BLRBSVBG'
		        AND	SESSION_ID	=  TO_NUMBER(:nd_session_id)
		        AND PGM_DATE	=  :nd_pgm_date; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select PARAM1 ,PARAM2 ,NVL(PARAM3,'!@#') ,NVL(PARAM4,'!@#') \
,NVL(PARAM5,'!@#') ,NVL(PARAM6,'!@#') ,NVL(PARAM7,'!@#') ,NVL(PARAM8,'!@#') ,P\
ARAM9 ,PARAM10 ,PARAM11 ,operating_facility_id into :b0,:b1,:b2,:b3,:b4,:b5,:b\
6,:b7,:b8,:b9,:b10,:b11  from SY_PROG_PARAM where ((PGM_ID='BLRBSVBG' and SESS\
ION_ID=TO_NUMBER(:b12)) and PGM_DATE=:b13)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )66;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_fm_blng_serv_id;
 sqlstm.sqhstl[0] = (unsigned int  )13;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_to_blng_serv_id;
 sqlstm.sqhstl[1] = (unsigned int  )13;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&l_price_class1;
 sqlstm.sqhstl[2] = (unsigned int  )12;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&l_price_class2;
 sqlstm.sqhstl[3] = (unsigned int  )12;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&l_price_class3;
 sqlstm.sqhstl[4] = (unsigned int  )12;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&l_price_class4;
 sqlstm.sqhstl[5] = (unsigned int  )12;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&l_price_class5;
 sqlstm.sqhstl[6] = (unsigned int  )12;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&l_price_class6;
 sqlstm.sqhstl[7] = (unsigned int  )12;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&l_as_on_date;
 sqlstm.sqhstl[8] = (unsigned int  )32;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&l_no_of_pc_cells;
 sqlstm.sqhstl[9] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&l_exclude_std_price;
 sqlstm.sqhstl[10] = (unsigned int  )7;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&d_facility_id;
 sqlstm.sqhstl[11] = (unsigned int  )12;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&nd_session_id;
 sqlstm.sqhstl[12] = (unsigned int  )18;
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&nd_pgm_date;
 sqlstm.sqhstl[13] = (unsigned int  )22;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}



	l_fm_blng_serv_id.arr[l_fm_blng_serv_id.len]      = '\0';
	l_to_blng_serv_id.arr[l_to_blng_serv_id.len]      = '\0';
	l_price_class1.arr[l_price_class1.len]			= '\0';
	l_price_class2.arr[l_price_class2.len]			= '\0';
	l_price_class3.arr[l_price_class3.len]			= '\0';
	l_price_class4.arr[l_price_class4.len]			= '\0';
	l_price_class5.arr[l_price_class5.len]			= '\0';
	l_price_class6.arr[l_price_class6.len]			= '\0';
	l_as_on_date.arr[l_as_on_date.len]				= '\0';
	d_facility_id.arr[d_facility_id.len]			= '\0';
	l_exclude_std_price.arr[l_exclude_std_price.len]= '\0';

	strcpy(g_facility_id, d_facility_id.arr);

    //delete the parameter record
    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    /* EXEC SQL DELETE SY_PROG_PARAM
	 		  WHERE PGM_ID		= 'BLRBSVBG'
	            AND SESSION_ID	= :nd_session_id
		        AND PGM_DATE	= :nd_pgm_date; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 14;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='BLRBSVBG' and\
 SESSION_ID=:b0) and PGM_DATE=:b1)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )137;
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
    if (sqlca.sqlcode < 0) goto err_exit;
}



	return;

  err_exit:

	/* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

	/* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )160;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	disp_message(ERR_MESG,"Oracle error at get_params() occured....");
	disp_message(ERR_MESG, sqlca.sqlerrm.sqlerrmc);
	proc_exit();
}
 
delete_prog_param()
{
   /* EXEC SQL DELETE SY_PROG_PARAM
			 WHERE PGM_ID		= 'BLRBSVBG'
	           AND SESSION_ID	= :nd_session_id
		       AND PGM_DATE		= :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='BLRBSVBG' and \
SESSION_ID=:b0) and PGM_DATE=:b1)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )175;
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


   return;
}

//get the header details
void get_header_dtls()
{
    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    /* EXEC SQL SELECT ACC_ENTITY_NAME,
				    USER,
				    TO_CHAR(SYSDATE, 'DD/MM/YYYY HH24:MI')
		      INTO :d_acc_entity_name,
			  	   :d_user,
				   :d_sysdate
              FROM SY_ACC_ENTITY
			 WHERE acc_entity_id = :d_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 14;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,USER ,TO_CHAR(SYSDATE,'DD/MM/YYYY\
 HH24:MI') into :b0,:b1,:b2  from SY_ACC_ENTITY where acc_entity_id=:b3";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )198;
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
    sqlstm.sqhstl[2] = (unsigned int  )19;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_facility_id;
    sqlstm.sqhstl[3] = (unsigned int  )12;
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
    if (sqlca.sqlcode < 0) goto err_exit;
}



	d_acc_entity_name.arr[d_acc_entity_name.len] = '\0';
	d_user.arr[d_user.len]                       = '\0';
	d_sysdate.arr[d_sysdate.len]                 = '\0';

	return;

	err_exit:
	   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

	   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 14;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )229;
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
 
declare_cursor()
{
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

	
	/* EXEC SQL DECLARE blng_serv_code_cur
	          CURSOR
			     FOR
			  SELECT b.blng_serv_code,
					 decode(b.blng_class_code,'**','All',b.blng_class_code),
				     to_char(b.ip_rate), 
				     to_char(b.op_rate),
				     to_char(b.ref_rate),
				     to_char(b.emer_rate),
				     to_char(DAYCARE_RATE) //EPNH 31/10/2004 
                FROM BL_SERV_CUST_PC_PRICE b
               WHERE b.cust_pc_ind    = 'S'
				 AND ((b.cust_pc_code = :d_facility_id)
	                  OR 
					 (b.cust_pc_code='ALL' and 0 = (SELECT COUNT(*) 
					                                  FROM bl_serv_cust_pc_price 												 WHERE cust_pc_code   = :d_facility_id
													   AND cust_pc_ind    = b.cust_pc_ind
													   AND blng_serv_code = b.blng_serv_code
													   AND cust_pc_ind    = 'S'
													   AND rownum = 1)))
                AND  TO_DATE(:l_as_on_date,'DD/MM/YYYY')
		    BETWEEN  TRUNC(b.valid_from) 
			    AND  NVL(trunc(b.VALID_TO),trunc(sysdate))
                AND  b.blng_serv_code  
		    BETWEEN  NVL(:l_fm_blng_serv_id,'!!!!!!!!!!')
			    AND  NVL(:l_to_blng_serv_id,'~~~~~~~~~~')
			  ORDER 
			     BY  1, 2; */ 


	/* EXEC SQL DECLARE price_class_cur
	          CURSOR
			     FOR
  			  SELECT a.rate_factor_ind,
					 a.cust_pc_code,
			  	     a.blng_serv_code,
					 DECODE(a.blng_class_code,'**','All',a.blng_class_code),
				     to_char(a.ip_rate),
				     to_char(a.op_rate),
				     to_char(a.ref_rate),
				     to_char(a.emer_rate),
				     to_char(DAYCARE_RATE) //EPNH 31/10/2004
			    FROM bl_serv_cust_pc_price a
			   WHERE ((:l_exclude_std_price =  'N' 
			          AND 
					  a.blng_serv_code      = :l_blng_serv_code
					  AND 
					  a.blng_class_code     = :l_blng_class)
					  OR
					  ((:l_exclude_std_price =  'Y'
					    AND 
						a.blng_serv_code BETWEEN NVL(:l_fm_blng_serv_id,'!!!!!!!!!!')
			                                 AND NVL(:l_to_blng_serv_id,'~~~~~~~~~~'))))
			     AND a.cust_pc_code        IN (:l_price_class1,:l_price_class2,:l_price_class3,:l_price_class4,:l_price_class5,:l_price_class6)
			     AND TO_DATE(:l_as_on_date,'DD/MM/YYYY')
		     BETWEEN NVL(a.valid_from(+),to_date('01011000','DDMMYYYY'))
			     AND NVL(a.valid_to(+),to_date('01014000','DDMMYYYY'))
			     AND a.cust_pc_ind(+) = 'B'
			   ORDER
			  	  BY a.blng_serv_code,
				     a.blng_class_code DESC,
				     a.cust_pc_code; */ 


	/* EXEC SQL DECLARE price_class_distinct_cur
	          CURSOR
			     FOR
			  SELECT distinct blng_grp_id,
					 LPAD(' '||short_desc,15,'-')
				FROM bl_blng_Grp
			   WHERE blng_grp_id IN (:l_price_class1,:l_price_class2,:l_price_class3,:l_price_class4,:l_price_class5,:l_price_class6)
			   ORDER 
				  BY blng_Grp_id; */ 


	/* EXEC SQL OPEN blng_serv_code_cur; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0010;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )244;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )12;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_facility_id;
 sqlstm.sqhstl[1] = (unsigned int  )12;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&l_as_on_date;
 sqlstm.sqhstl[2] = (unsigned int  )32;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&l_fm_blng_serv_id;
 sqlstm.sqhstl[3] = (unsigned int  )13;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&l_to_blng_serv_id;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}


	return;

	err_exit:
	
		   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

		   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 14;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )279;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		   disp_message(ERR_MESG, sqlca.sqlerrm.sqlerrmc);
		   disp_message(ERR_MESG,"Oracle error at ip_op_revenue_cur() occured....");
		   proc_exit();
}

int fetch_blng_serv_code_cur()
{
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


	l_blng_serv_code.arr[0]='\0';
	l_blng_class.arr[0] = '\0';
    l_blng_serv_ip_rate.arr[0] = '\0';
    l_blng_serv_op_rate.arr[0] = '\0';
    l_blng_serv_ref_rate.arr[0] = '\0';
    l_blng_serv_emerg_rate.arr[0] = '\0';
    l_blng_serv_dc_rate.arr[0] = '\0'; //EPNH 31/10/2004


	/* EXEC SQL FETCH blng_serv_code_cur
			  INTO :l_blng_serv_code, 
				   :l_blng_class,
				   :l_blng_serv_ip_rate,
				   :l_blng_serv_op_rate,
				   :l_blng_serv_ref_rate,
				   :l_blng_serv_emerg_rate,
				   :l_blng_serv_dc_rate ; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )294;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqfoff = (           int )0;
 sqlstm.sqfmod = (unsigned int )2;
 sqlstm.sqhstv[0] = (         void  *)&l_blng_serv_code;
 sqlstm.sqhstl[0] = (unsigned int  )13;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_blng_class;
 sqlstm.sqhstl[1] = (unsigned int  )13;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&l_blng_serv_ip_rate;
 sqlstm.sqhstl[2] = (unsigned int  )17;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&l_blng_serv_op_rate;
 sqlstm.sqhstl[3] = (unsigned int  )17;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&l_blng_serv_ref_rate;
 sqlstm.sqhstl[4] = (unsigned int  )17;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&l_blng_serv_emerg_rate;
 sqlstm.sqhstl[5] = (unsigned int  )17;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&l_blng_serv_dc_rate;
 sqlstm.sqhstl[6] = (unsigned int  )17;
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

 //EPNH 31/10/2004
	
	if (NODATAFOUND)
		return 0;

    l_blng_serv_code.arr[l_blng_serv_code.len]='\0';
    l_blng_class.arr[l_blng_class.len] = '\0';
    l_blng_serv_ip_rate.arr[l_blng_serv_ip_rate.len] = '\0';
    l_blng_serv_op_rate.arr[l_blng_serv_op_rate.len] = '\0';
    l_blng_serv_ref_rate.arr[l_blng_serv_ref_rate.len] = '\0';
    l_blng_serv_emerg_rate.arr[l_blng_serv_emerg_rate.len] = '\0';
    l_blng_serv_dc_rate.arr[l_blng_serv_dc_rate.len]='\0';  //EPNH 31/10/2004


    return 1;
	
	err_exit:
		/* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

		/* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )337;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		disp_message(ERR_MESG,"Oracle error at fetch_blng_serv_code_cur() occured....");
		sprintf(aMesg,"Error: %-100s",sqlca.sqlerrm.sqlerrmc);
		disp_message(ERR_MESG,aMesg);
		proc_exit();
}


int fetch_price_class_detail()
{
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


	l_rate_factor_ind.arr[0]	='\0';
	l_pc_cust_pc_code.arr[0]	='\0';
	l_pc_blng_serv_code.arr[0]	='\0';
	l_blng_class_code.arr[0]	='\0';	

	l_pc_ip_rate.arr[0]			='\0';
	l_pc_op_rate.arr[0]			='\0';
	l_pc_ref_rate.arr[0]		='\0';
	l_pc_emer_rate.arr[0]		='\0';
        l_pc_dc_rate.arr[0]		='\0';  //EPNH 31/10/2004

	/* EXEC SQL FETCH	price_class_cur
			  INTO	:l_rate_factor_ind,
					:l_pc_cust_pc_code,
					:l_pc_blng_serv_code,
					:l_blng_class_code,
					:l_pc_ip_rate,
					:l_pc_op_rate,
					:l_pc_ref_rate,
					:l_pc_emer_rate,
					:l_pc_dc_rate; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )352;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqfoff = (           int )0;
 sqlstm.sqfmod = (unsigned int )2;
 sqlstm.sqhstv[0] = (         void  *)&l_rate_factor_ind;
 sqlstm.sqhstl[0] = (unsigned int  )7;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_pc_cust_pc_code;
 sqlstm.sqhstl[1] = (unsigned int  )13;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&l_pc_blng_serv_code;
 sqlstm.sqhstl[2] = (unsigned int  )13;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&l_blng_class_code;
 sqlstm.sqhstl[3] = (unsigned int  )13;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&l_pc_ip_rate;
 sqlstm.sqhstl[4] = (unsigned int  )12;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&l_pc_op_rate;
 sqlstm.sqhstl[5] = (unsigned int  )12;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&l_pc_ref_rate;
 sqlstm.sqhstl[6] = (unsigned int  )12;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&l_pc_emer_rate;
 sqlstm.sqhstl[7] = (unsigned int  )12;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&l_pc_dc_rate;
 sqlstm.sqhstl[8] = (unsigned int  )12;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}

 //EPNH 31/10/2004

	
	if (NODATAFOUND)
	{
		return 0;
	}

	l_rate_factor_ind.arr[l_rate_factor_ind.len]	='\0';
	l_pc_cust_pc_code.arr[l_pc_cust_pc_code.len]	='\0';
	l_pc_blng_serv_code.arr[l_pc_blng_serv_code.len]='\0';
	l_pc_ip_rate.arr[l_pc_ip_rate.len]				='\0';
	l_pc_op_rate.arr[l_pc_op_rate.len]				='\0';
	l_pc_ref_rate.arr[l_pc_ref_rate.len]			='\0';
	l_pc_emer_rate.arr[l_pc_emer_rate.len]			='\0';
	l_pc_dc_rate.arr[l_pc_dc_rate.len]			='\0'; //EPNH 31/10/2004

	l_blng_class_code.arr[l_blng_class_code.len]	='\0';	
        
	
	//sprintf(aMesg,"BILLING GRP  %s  IP Rate  %s",l_pc_cust_pc_code.arr,l_pc_ip_rate.arr);
	//disp_message(ERR_MESG,aMesg);

    return 1;
	
	err_exit:
		/* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

		/* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )403;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		disp_message(ERR_MESG,"Oracle error at fetch_price_class_detail() occured....");
		sprintf(aMesg,"Error: %-100s",sqlca.sqlerrm.sqlerrmc);
		disp_message(ERR_MESG,aMesg);
		proc_exit();
}

int fetch_pc_distinct_cur()
{
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


	l_short_desc.arr[0] = '\0';

	/* EXEC SQL FETCH	price_class_distinct_cur
			  INTO  :l_dist_pc_class,
			        :l_short_desc; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )418;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqfoff = (           int )0;
 sqlstm.sqfmod = (unsigned int )2;
 sqlstm.sqhstv[0] = (         void  *)&l_dist_pc_class;
 sqlstm.sqhstl[0] = (unsigned int  )12;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_short_desc;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}



	l_fm_blng_serv_id.arr[l_fm_blng_serv_id.len]='\0';
	l_dist_pc_class.arr[l_dist_pc_class.len]='\0';
	l_short_desc.arr[l_short_desc.len] = '\0';

	if(NODATAFOUND)
		return 0;

    return 1;
	
	err_exit:
		/* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

		/* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 14;
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


		disp_message(ERR_MESG,"Oracle error at fetch_pc_distinct_cur() occured....");
		sprintf(aMesg,"Error: %-100s",sqlca.sqlerrm.sqlerrmc);
		disp_message(ERR_MESG,aMesg);
		proc_exit();
}

close_cursors()
{
	/* EXEC SQL CLOSE blng_serv_code_cur; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )456;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	//EXEC SQL CLOSE price_class_distinct_cur;
}

void do_report()  
{

	char f_blng_serv_ip_rate[10],
		 f_blng_serv_op_rate[10],
		 f_blng_serv_ref_rate[10],
		 f_blng_serv_emerg_rate[10],
		 f_blng_serv_dc_rate[10];

	//EXEC SQL WHENEVER SQLERROR GOTO err_exit;

	print_parameter_page();
	print_page_header();
	

	if(strcmp(l_exclude_std_price.arr,"N")==0)
	{
		while(fetch_blng_serv_code_cur())		
		{
			check_page_end();

			strcpy(cl_blng_serv_ip_rate,l_blng_serv_ip_rate.arr);
			strcpy(cl_blng_serv_op_rate,l_blng_serv_op_rate.arr);
			strcpy(cl_blng_serv_ref_rate,l_blng_serv_ref_rate.arr);
			strcpy(cl_blng_serv_emerg_rate,l_blng_serv_emerg_rate.arr);
                        strcpy(cl_blng_serv_dc_rate,l_blng_serv_dc_rate.arr);//EPNH 31/10/2004


			print_formated(f_blng_serv_ip_rate,cl_blng_serv_ip_rate);
			print_formated(f_blng_serv_op_rate,cl_blng_serv_op_rate);
			print_formated(f_blng_serv_ref_rate,cl_blng_serv_ref_rate);
			print_formated(f_blng_serv_emerg_rate,cl_blng_serv_emerg_rate);
                        print_formated(f_blng_serv_dc_rate,cl_blng_serv_dc_rate);//EPNH 31/10/2004
		
			fprintf(f1,"%-10s %-3s %10s %10s %10s %10s %10s",l_blng_serv_code.arr,
			l_blng_class.arr,f_blng_serv_ip_rate,f_blng_serv_dc_rate,f_blng_serv_op_rate,
			f_blng_serv_ref_rate,f_blng_serv_emerg_rate);
			l_pc_counter=0;

			/* EXEC SQL OPEN price_class_cur; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0011;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )471;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqcmod = (unsigned int )0;
   sqlstm.sqhstv[0] = (         void  *)&l_exclude_std_price;
   sqlstm.sqhstl[0] = (unsigned int  )7;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&l_blng_serv_code;
   sqlstm.sqhstl[1] = (unsigned int  )13;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&l_blng_class;
   sqlstm.sqhstl[2] = (unsigned int  )13;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&l_exclude_std_price;
   sqlstm.sqhstl[3] = (unsigned int  )7;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&l_fm_blng_serv_id;
   sqlstm.sqhstl[4] = (unsigned int  )13;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&l_to_blng_serv_id;
   sqlstm.sqhstl[5] = (unsigned int  )13;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&l_price_class1;
   sqlstm.sqhstl[6] = (unsigned int  )12;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&l_price_class2;
   sqlstm.sqhstl[7] = (unsigned int  )12;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&l_price_class3;
   sqlstm.sqhstl[8] = (unsigned int  )12;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&l_price_class4;
   sqlstm.sqhstl[9] = (unsigned int  )12;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&l_price_class5;
   sqlstm.sqhstl[10] = (unsigned int  )12;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&l_price_class6;
   sqlstm.sqhstl[11] = (unsigned int  )12;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&l_as_on_date;
   sqlstm.sqhstl[12] = (unsigned int  )32;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
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



			while(fetch_price_class_detail())
			{
				check_page_end();

				/* EXEC SQL SELECT c.rw
						   INTO :l_print_position
						   FROM (SELECT ROWNUM  rw,
										b.pc_code pc 
								   FROM (SELECT distinct blng_grp_id pc_code
										   FROM bl_blng_Grp
										  WHERE blng_grp_id IN (:l_price_class1,:l_price_class2,:l_price_class3,:l_price_class4,:l_price_class5,:l_price_class6)
										  ORDER 
										     BY blng_Grp_id) b
								) c
						  WHERE c.pc=:l_pc_cust_pc_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 14;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select c.rw into :b0  from (select ROWNUM rw ,b.pc_code p\
c  from (select distinct blng_grp_id pc_code  from bl_blng_Grp where blng_grp_\
id in (:b1,:b2,:b3,:b4,:b5,:b6) order by blng_Grp_id ) b ) c where c.pc=:b7";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )538;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&l_print_position;
    sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&l_price_class1;
    sqlstm.sqhstl[1] = (unsigned int  )12;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&l_price_class2;
    sqlstm.sqhstl[2] = (unsigned int  )12;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&l_price_class3;
    sqlstm.sqhstl[3] = (unsigned int  )12;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&l_price_class4;
    sqlstm.sqhstl[4] = (unsigned int  )12;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&l_price_class5;
    sqlstm.sqhstl[5] = (unsigned int  )12;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&l_price_class6;
    sqlstm.sqhstl[6] = (unsigned int  )12;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&l_pc_cust_pc_code;
    sqlstm.sqhstl[7] = (unsigned int  )13;
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



				print_rec();
				strcpy(l_current_blng_class.arr,l_blng_class_code.arr);
				l_current_blng_class.len = strlen(l_current_blng_class.arr);

				strcpy(l_current_blng_serv_code.arr,l_pc_blng_serv_code.arr);
				l_current_blng_serv_code.len = strlen(l_current_blng_serv_code.arr);
			}
			fprintf(f1,"\n");
			line_no=line_no+1;
			check_page_end();
			/* EXEC SQL CLOSE price_class_cur; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )585;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		}
	}
	else if(strcmp(l_exclude_std_price.arr,"Y")==0)
	{
		l_pc_counter=0;
		l_print_format_change='B';

		/* EXEC SQL OPEN price_class_cur; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0011;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )600;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqcmod = (unsigned int )0;
  sqlstm.sqhstv[0] = (         void  *)&l_exclude_std_price;
  sqlstm.sqhstl[0] = (unsigned int  )7;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&l_blng_serv_code;
  sqlstm.sqhstl[1] = (unsigned int  )13;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&l_blng_class;
  sqlstm.sqhstl[2] = (unsigned int  )13;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&l_exclude_std_price;
  sqlstm.sqhstl[3] = (unsigned int  )7;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&l_fm_blng_serv_id;
  sqlstm.sqhstl[4] = (unsigned int  )13;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&l_to_blng_serv_id;
  sqlstm.sqhstl[5] = (unsigned int  )13;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&l_price_class1;
  sqlstm.sqhstl[6] = (unsigned int  )12;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&l_price_class2;
  sqlstm.sqhstl[7] = (unsigned int  )12;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&l_price_class3;
  sqlstm.sqhstl[8] = (unsigned int  )12;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&l_price_class4;
  sqlstm.sqhstl[9] = (unsigned int  )12;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&l_price_class5;
  sqlstm.sqhstl[10] = (unsigned int  )12;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&l_price_class6;
  sqlstm.sqhstl[11] = (unsigned int  )12;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&l_as_on_date;
  sqlstm.sqhstl[12] = (unsigned int  )32;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
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


		while(fetch_price_class_detail())
		{
			if((strcmp(l_current_blng_serv_code.arr,l_pc_blng_serv_code.arr)!=0)&&(l_current_blng_serv_code.len>0))
			{
				fprintf(f1,"\n");
				l_print_format_change='B';
			}
			else
			{
				if((strcmp(l_current_blng_class.arr,l_blng_class_code.arr)!=0) && (l_current_blng_class.len>0))
				{
					fprintf(f1,"\n");
					l_print_format_change='C';
				}
			}
			if((l_print_format_change=='B')||(l_print_format_change=='C'))
				check_page_end();


			/* EXEC SQL SELECT c.rw
					   INTO :l_print_position
					   FROM (SELECT ROWNUM  rw,
									b.pc_code pc 
							   FROM (SELECT distinct blng_grp_id pc_code
									   FROM bl_blng_Grp
									  WHERE blng_grp_id IN (:l_price_class1,:l_price_class2,:l_price_class3,:l_price_class4,:l_price_class5,:l_price_class6)
									  ORDER 
										 BY blng_Grp_id) b
							) c
					  WHERE c.pc=:l_pc_cust_pc_code; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select c.rw into :b0  from (select ROWNUM rw ,b.pc_code pc\
  from (select distinct blng_grp_id pc_code  from bl_blng_Grp where blng_grp_i\
d in (:b1,:b2,:b3,:b4,:b5,:b6) order by blng_Grp_id ) b ) c where c.pc=:b7";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )667;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&l_print_position;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&l_price_class1;
   sqlstm.sqhstl[1] = (unsigned int  )12;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&l_price_class2;
   sqlstm.sqhstl[2] = (unsigned int  )12;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&l_price_class3;
   sqlstm.sqhstl[3] = (unsigned int  )12;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&l_price_class4;
   sqlstm.sqhstl[4] = (unsigned int  )12;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&l_price_class5;
   sqlstm.sqhstl[5] = (unsigned int  )12;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&l_price_class6;
   sqlstm.sqhstl[6] = (unsigned int  )12;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&l_pc_cust_pc_code;
   sqlstm.sqhstl[7] = (unsigned int  )13;
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



			print_rec();

			if((l_print_format_change=='B')||(l_print_format_change=='C'))
				check_page_end();

			strcpy(l_current_blng_class.arr,l_blng_class_code.arr);
			l_current_blng_class.len = strlen(l_current_blng_class.arr);

			strcpy(l_current_blng_serv_code.arr,l_pc_blng_serv_code.arr);
			l_current_blng_serv_code.len = strlen(l_current_blng_serv_code.arr);
		}
		fprintf(f1,"\n");
		/* EXEC SQL CLOSE price_class_cur; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )714;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	}
	end_report();

	/*err_exit:
	   EXEC SQL WHENEVER SQLERROR CONTINUE;
	   EXEC SQL ROLLBACK WORK RELEASE;
	   disp_message(ERR_MESG,"Oracle error at main() occured....");
	   disp_message(ERR_MESG, sqlca.sqlerrm.sqlerrmc);
	   proc_exit();*/

}

print_rec()
{
	char f_pc_ip_rate[10],
		 f_pc_op_rate[10],
		 f_pc_ref_rate[10],
		 f_pc_emer_rate[10],
                 f_pc_dc_rate[10], //EPNH 31/10/2004
		 l_f_pc_ip_rate[10],
		 l_f_pc_op_rate[10],
		 l_f_pc_ref_rate[10],
		 l_f_pc_emer_rate[10],
		 l_f_pc_dc_rate[10]; //EPNH 31/10/2004

	int	l_func_ret;

	strcpy(l_f_pc_ip_rate,l_pc_ip_rate.arr);
        strcpy(l_f_pc_op_rate,l_pc_op_rate.arr);
	strcpy(l_f_pc_ref_rate,l_pc_ref_rate.arr);
	strcpy(l_f_pc_emer_rate,l_pc_emer_rate.arr); 
        strcpy(l_f_pc_dc_rate,l_pc_dc_rate.arr);  //EPNH 31/10/2004

	print_formated(f_pc_ip_rate,l_f_pc_ip_rate);
	print_formated(f_pc_op_rate,l_f_pc_op_rate);
	print_formated(f_pc_ref_rate,l_f_pc_ref_rate);
	print_formated(f_pc_emer_rate,l_f_pc_emer_rate);
	print_formated(f_pc_dc_rate,l_f_pc_dc_rate);  //EPNH 31/10/2004

	if(strcmp(l_exclude_std_price.arr,"Y")==0)
	{
		if(l_print_format_change=='B')
		{
			//fprintf(f1,"%-10s %-3s %-1s %10s  %10s  %10s  %10s",l_pc_blng_serv_code.arr,l_blng_class_code.arr, l_rate_factor_ind.arr, f_pc_ip_rate,f_pc_op_rate,f_pc_ref_rate,f_pc_emer_rate);
			fprintf(f1,"%-10s %-3s",l_pc_blng_serv_code.arr,l_blng_class_code.arr);

			if(l_print_position==1)
				l_print_position=1;
			else if(l_print_position>=2)
				l_print_position=(1+50*(l_print_position-1));

			print_spaces(l_print_position);
			l_print_position=0;
                         
                        //EPNH 31/10/2004  
			fprintf(f1,"%-1s %10s  %10s  %10s  %10s  %10s",l_rate_factor_ind.arr, 
			f_pc_ip_rate,f_pc_dc_rate,f_pc_op_rate,f_pc_ref_rate,f_pc_emer_rate);

			l_print_format_change='X';
			line_no=line_no+1;
		}
		else if(l_print_format_change=='C')
		{
			//fprintf(f1,"%-10s %-3s %-1s %10s  %10s  %10s  %10s"," ",l_blng_class_code.arr, l_rate_factor_ind.arr, f_pc_ip_rate,f_pc_op_rate,f_pc_ref_rate,f_pc_emer_rate);

			fprintf(f1,"%-10s %-3s"," ",l_blng_class_code.arr);

			if(l_print_position==1)
				l_print_position=1;
			else if(l_print_position>=2)
				l_print_position=(1+50*(l_print_position-1));

			print_spaces(l_print_position);
			l_print_position=0;			
			
			fprintf(f1,"%-1s %10s  %10s  %10s  %10s   %10s",l_rate_factor_ind.arr, f_pc_ip_rate,
			f_pc_dc_rate,f_pc_op_rate,f_pc_ref_rate,f_pc_emer_rate);

			l_print_format_change='X';
			line_no=line_no+1;
		}
		else if(l_print_format_change=='X') 
		{
			fprintf(f1,"  %-1s %10s  %10s  %10s  %10s  %10s",l_rate_factor_ind.arr, 
			f_pc_ip_rate,f_pc_dc_rate,f_pc_op_rate,f_pc_ref_rate,f_pc_emer_rate);
		}
	}
	else if(strcmp(l_exclude_std_price.arr,"N")==0)
	{
		fprintf(f1,"  %-1s %10s  %10s  %10s  %10s  %10s",l_rate_factor_ind.arr, 
		f_pc_ip_rate,f_pc_dc_rate,f_pc_op_rate,f_pc_ref_rate,f_pc_emer_rate);
	}
}

print_parameter_page()
{
	page_no=page_no+1;
	print_page_title();

	fprintf(f1,"\n\n\n\n\n\n\t\tINPUT PARAMETERS\n");
	fprintf(f1,"\t\t----------------\n\n");

	if(strcmp(l_fm_blng_serv_id.arr,"!!!!!!")==0)
		fprintf(f1,"\t\tBilling Service  FROM  :    LOWEST\n");
	else
		fprintf(f1,"\t\tBilling Service  FROM  :    %s\n,",l_fm_blng_serv_id.arr);


	if(strcmp(l_to_blng_serv_id.arr,"~~~~~~")==0)
		fprintf(f1,"\t\tBilling Service    TO  :    HIGHEST\n\n");
	else
		fprintf(f1,"\t\tBilling Service    TO  :    %s\n\n",l_to_blng_serv_id.arr);


	fprintf(f1,"\t\tBILLING GRPS   1       :    %s\n",l_price_class1.arr);
	

	if(strcmp(l_price_class2.arr,"!@#")==0)
		fprintf(f1,"\t\t               2       :    %s\n"," ");
	else
		fprintf(f1,"\t\t               2       :    %s\n",l_price_class2.arr);

	if(strcmp(l_price_class3.arr,"!@#")==0)
		fprintf(f1,"\t\t               3       :    %s\n"," ");
	else
		fprintf(f1,"\t\t               3       :    %s\n",l_price_class3.arr);

	if(strcmp(l_price_class4.arr,"!@#")==0)
		fprintf(f1,"\t\t               4       :    %s\n"," ");
	else
		fprintf(f1,"\t\t               4       :    %s\n",l_price_class4.arr);

	if(strcmp(l_price_class5.arr,"!@#")==0)
		fprintf(f1,"\t\t               5       :    %s\n"," ");
	else
		fprintf(f1,"\t\t               5       :    %s\n",l_price_class5.arr);

	if(strcmp(l_price_class6.arr,"!@#")==0)
		fprintf(f1,"\t\t               6       :    %s\n\n"," ");
	else
		fprintf(f1,"\t\t               6       :    %s\n\n",l_price_class6.arr);


	fprintf(f1,"\t\tAs On Date             :    %s\n\n",l_as_on_date.arr);

	fprintf(f1,"\t\tExclude Standard Price :    %s\n\n",l_exclude_std_price.arr);
	check_page_end(55);
}

print_page_title()
{
	double l_report_width;
	double l_acc_entity_length;
	double l_start_point;
	double l_comp_name_end_point;
	int	   l_page_width;

	line_no= 0;
	if(strcmp(l_exclude_std_price.arr,"N")==0)
	{	
		l_report_width=(58 + (58*(l_no_of_pc_cells)));
	}
	else if(strcmp(l_exclude_std_price.arr,"Y")==0)
	{
		l_report_width=(63 + (60*(l_no_of_pc_cells-1)));
	}
	l_acc_entity_length = strlen(d_acc_entity_name.arr);

	//Code for Line 1
	l_start_point=ceill((l_report_width/2)-(l_acc_entity_length/2));
	fprintf(f1,"MDL : BL");
	l_start_point=l_start_point-8;
	print_spaces(l_start_point);
	fprintf(f1,"%s",d_acc_entity_name.arr);
	l_comp_name_end_point=l_start_point+8+l_acc_entity_length;
	l_start_point=((l_report_width-17)-l_comp_name_end_point);
	print_spaces(l_start_point);
	fprintf(f1,"%s\n",d_sysdate.arr);

	//Code for Line 2
	l_start_point=0;
	fprintf(f1,"OPR : %-15s",d_user.arr);
	l_start_point=ceill((l_report_width/2)-22);
	l_start_point=l_start_point-21;
	print_spaces(l_start_point);
	fprintf(f1,"BILLING SERVICE PRICE LIST FOR BILLING GROUPS\n");

	//Code for Line 3
	l_start_point=0;
	fprintf(f1,"REP : BLRBSVBG");
	l_start_point=ceill((l_report_width/2)-8);
	l_start_point=l_start_point-14;
	print_spaces(l_start_point);
	fprintf(f1,"AS ON %s",l_as_on_date.arr);
	l_comp_name_end_point=l_start_point+14+16;
	l_start_point=((l_report_width-17)-l_comp_name_end_point);
	print_spaces(l_start_point);
	fprintf(f1,"PAGE : %d\n",page_no);
	line_no=3;

	if(page_no==1)
	{
		l_page_width=l_report_width;
		print_line(l_page_width);
	}
}
  
print_page_header()
{
	int l_page_width=0;
	int l_return_val;

	fprintf(f1,"\f");
	page_no=page_no+1; 
	
	print_page_title();
	/* EXEC SQL OPEN price_class_distinct_cur; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0012;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )729;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlstm.sqhstv[0] = (         void  *)&l_price_class1;
 sqlstm.sqhstl[0] = (unsigned int  )12;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_price_class2;
 sqlstm.sqhstl[1] = (unsigned int  )12;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&l_price_class3;
 sqlstm.sqhstl[2] = (unsigned int  )12;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&l_price_class4;
 sqlstm.sqhstl[3] = (unsigned int  )12;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&l_price_class5;
 sqlstm.sqhstl[4] = (unsigned int  )12;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&l_price_class6;
 sqlstm.sqhstl[5] = (unsigned int  )12;
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


	if(l_no_of_pc_cells==1)
	{
		if(strcmp(l_exclude_std_price.arr,"N")==0)
		{
			l_return_val=fetch_pc_distinct_cur();
			fprintf(f1,"------------------------------------------------------------------------------------------------------------------------------------\n");
			fprintf(f1,"           Blg -----------------STANDARD-------------------------  ---------------  %15s --------------------------------\n",l_short_desc.arr);
			fprintf(f1,"Blng Serv  Cls.        IP        DC        OP        EXT        EMER     R/F    IP        DC         OP        EXT        EMER    \n");
			fprintf(f1,"----------------------------------------------------------------------------------------------------------------------------------\n");
			line_no = line_no + 4;
		}
		else if(strcmp(l_exclude_std_price.arr,"Y")==0)
		{
			l_return_val=fetch_pc_distinct_cur();
			fprintf(f1,"---------------------------------------------------------------------------\n");
			fprintf(f1,"          Blng ----------------%15s ----------------------\n",l_short_desc.arr);
			fprintf(f1,"Blng Serv  Cls R/F        IP        DC        OP        EXT        EMER   \n");
			fprintf(f1,"----------------------------------------------------------------------------\n");
			line_no = line_no + 4;
		}
	}
	else if(l_no_of_pc_cells>1)
	{
		l_return_val=fetch_pc_distinct_cur();
		if(strcmp(l_exclude_std_price.arr,"N")==0)
		{	
			l_page_width=(78 + (60*(l_no_of_pc_cells)));
		}
		else if(strcmp(l_exclude_std_price.arr,"Y")==0)
		{
			l_page_width=(88 + (60*(l_no_of_pc_cells-1)));
		}
		print_line(l_page_width);
		fprintf(f1,"\n");
		
		if(strcmp(l_exclude_std_price.arr,"N")==0)
			fprintf(f1,"           Blg -----------------STANDARD--------------------------  -------------------  %8s -----------------------------------",l_dist_pc_class.arr);
		else
			fprintf(f1,"          Blng ----------------%15s ------------------------------",l_short_desc.arr);

		for(i=0;i<l_no_of_pc_cells-1;i++)
		{
			l_return_val=fetch_pc_distinct_cur();
			if(strcmp(l_exclude_std_price.arr,"N")==0)
			{
				fprintf(f1,"  --------------- %15s -----------------------------",l_short_desc.arr);
			}
			else if(strcmp(l_exclude_std_price.arr,"Y")==0)
			{
				fprintf(f1,"  ----------------%15s -------------------------------",l_short_desc.arr);				
			}
		}
		fprintf(f1,"\n");

		
		if(strcmp(l_exclude_std_price.arr,"N")==0)
		{
			for(i=0;i<=l_no_of_pc_cells;i++)
			{
				if(i==0)
				{
					fprintf(f1,"Blng Serv  Cls.         IP         DC         OP        EXT      EMER   ");
				}
				else
				{
					fprintf(f1,"  R/F         IP         DC         OP         EXT        EMER    ");
				}
			}

		}
		else if(strcmp(l_exclude_std_price.arr,"Y")==0)
		{
			for(i=0;i<l_no_of_pc_cells;i++)
			{
				if(i==0)
				{
					fprintf(f1,"Blng Serv  Cls R/F         IP         DC         OP         EXT         EMER   ");
				}
				else
				{
					fprintf(f1,"R/F         IP         DC         OP         EXT         EMER   ");	
				}
			}
		}
		fprintf(f1,"\n");
		print_line(l_page_width);
		fprintf(f1,"\n");
		line_no = line_no + 4;

		/* EXEC SQL OPEN price_class_distinct_cur; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0012;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )768;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqcmod = (unsigned int )0;
  sqlstm.sqhstv[0] = (         void  *)&l_price_class1;
  sqlstm.sqhstl[0] = (unsigned int  )12;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&l_price_class2;
  sqlstm.sqhstl[1] = (unsigned int  )12;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&l_price_class3;
  sqlstm.sqhstl[2] = (unsigned int  )12;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&l_price_class4;
  sqlstm.sqhstl[3] = (unsigned int  )12;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&l_price_class5;
  sqlstm.sqhstl[4] = (unsigned int  )12;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&l_price_class6;
  sqlstm.sqhstl[5] = (unsigned int  )12;
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


	}
}

print_line(l_length)
int l_length;
{
	for(i=0;i<l_length;i++)
	{
		fprintf(f1,"-");
	}
}

print_spaces(l_length)
double l_length;
{
	for(i=0;i<l_length;i++)
	{
		fprintf(f1," ");
	}
}


check_page_end()
{
	if ((line_no + 5) >= MAX_LINES)
	{
		line_no=0;
	    print_page_header();
	}	
	return;
}

//Print the finishing line of the report 
end_report()
{
  fprintf(f1,"\n\n");
  fprintf(f1,"                                                   ");
  fprintf(f1,"** End of Report **");
  fprintf(f1,"");
}

print_formated(l_char_digit,l_double_digit)
char	l_double_digit[10];
char	l_char_digit[10];
{
	strcpy(l_char_digit,l_double_digit);
	if(strlen(l_char_digit)>0)
		format_amt(l_char_digit);

	return l_char_digit;
}

set_format(l_char_digit)
char	l_char_digit[10];
{
	format_amt(l_char_digit);
	return l_char_digit;
}

#undef DEBUG
#undef NODATAFOUND
#undef MAX_LINES
#undef VER