
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BT/BTRLBISB.pc"
};


static unsigned int sqlctx = 1288503931;


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
            void  *sqhstv[5];
   unsigned int   sqhstl[5];
            int   sqhsts[5];
            void  *sqindv[5];
            int   sqinds[5];
   unsigned int   sqharm[5];
   unsigned int   *sqharc[5];
   unsigned short  sqadto[5];
   unsigned short  sqtdso[5];
} sqlstm = {12,5};

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
"select A.product_code ,A.unit_no ,A.blood_group ,A.rhesus_code ,TO_CHAR(A.ex\
piry_date,'DD/MM/YYYY')  from bd_component_label_vw A where (((A.donor_unit_no\
=:b0 and A.donor_product_code=:b1) and A.operating_facility_id=:b2) and (1=1 a\
nd (:b3='BTRLBISB' and NVL(A.add_to_stock_yn,'N')='Y')))           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,192,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,30,233,0,0,0,0,0,1,0,
51,0,0,3,0,0,30,243,0,0,0,0,0,1,0,
66,0,0,4,299,0,9,268,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
97,0,0,4,0,0,13,307,0,0,5,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
132,0,0,5,115,0,4,366,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
159,0,0,6,94,0,4,396,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
186,0,0,7,135,0,4,425,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
217,0,0,8,110,0,4,462,0,0,4,2,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
248,0,0,9,75,0,4,498,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
271,0,0,10,92,0,4,538,0,0,3,1,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,
298,0,0,11,82,0,4,567,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
321,0,0,12,119,0,4,599,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
344,0,0,13,111,0,4,788,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
367,0,0,14,224,0,3,946,0,0,3,3,0,1,0,1,9,0,0,1,3,0,0,1,9,0,0,
};



#define NO_DATA_FOUND (sqlca.sqlcode == 1403)
#define VIEW_LOG_FILE 1
#define ONLINE_PRINTING 1
#define OERROR 		  (sqlca.sqlcode < 0)
#define INIT_MESG "Label Printing"
#define ESC 0x1B

#include <stdio.h>  
#include <string.h>
#include <math.h>
#include <malloc.h> 
#include <rl.h>  

/* EXEC SQL BEGIN DECLARE SECTION; */ 
                  

/* VARCHAR uid_pwd                 [42],     
		nd_source_type	        [2],
		nd_fm_source	        [7],
        d_no_copy				[2],
        nd_facility_id			[3],
		nd_session_id           [50],
		nd_ws_no                [50],
		nd_trx_ind			    [2],
		nd_printer_type          [2],



		d_fm_unit_no	        [41],
		d_fm_product_code       [41],
		d_facility_id           [41],
		d_facility_name         [101],
        d_unit_barcode_value    [101],
		d_product_code_temp     [41], 
		d_product_desc_temp     [101],
		d_store_instr_code      [11],
		d_store_instr_desc_temp [41],

        nd_donation_date         [21],
        nd_donor_product_code    [41], 
        nd_donor_unit_no         [41],
        nd_product_code          [41], 
		nd_product_desc          [101], 
        nd_unit_no               [41],
        nd_blood_group           [41], 
        nd_rhesus_code           [41], 
        nd_expiry_date           [41],
        nd_screened_legend       [41],


        d_donation_date         [20][21],
        d_donor_product_code    [20][41], 
        d_donor_unit_no         [20][41],
        d_product_code          [20][41], 
		d_store_instr_desc      [20][101], 
		d_product_desc          [20][101], 
        d_unit_no               [20][41],
        d_blood_group           [20][41], 
        d_rhesus_code           [20][41], 
        d_expiry_date           [20][41],
        d_screened_legend       [20][41],

//Dhana changes
		nd_bld_grp_rh_barcode	 [15],	
		nd_prod_barcode_msg1	 [200],
		nd_prod_barcode_msg2	 [200],
		nd_donor_id				 [20],
		nd_center_code			 [4],
		nd_product_barcode_value [15],
		nd_donation_process		 [2],	



		d_bld_grp_rh_barcode	 [20][15],	
		d_prod_barcode_msg1		 [20][200],
		d_prod_barcode_msg2		 [20][200],
		d_donor_id				 [20][20],
		d_center_code			 [20][4],
		d_product_barcode_value	 [20][15],
		d_donation_process		 [20][2],	


		d_flag			[2],

		er_msg                  [171], 

/o**************** variables added for label_cur cursor **********o/

		a_ws_no					[41],
		a_cmd_line_arg			[500],
		a_rowid					[41],
		a_pgm_id				[41],

/o**************** variables added for enhancement **********o/

//		nd_file_no			[100],
		nd_print_source_type	[2],
		nd_print_source		[2]; */ 
struct { unsigned short len; unsigned char arr[42]; } uid_pwd;

struct { unsigned short len; unsigned char arr[2]; } nd_source_type;

struct { unsigned short len; unsigned char arr[7]; } nd_fm_source;

struct { unsigned short len; unsigned char arr[2]; } d_no_copy;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[50]; } nd_session_id;

struct { unsigned short len; unsigned char arr[50]; } nd_ws_no;

struct { unsigned short len; unsigned char arr[2]; } nd_trx_ind;

struct { unsigned short len; unsigned char arr[2]; } nd_printer_type;

struct { unsigned short len; unsigned char arr[41]; } d_fm_unit_no;

struct { unsigned short len; unsigned char arr[41]; } d_fm_product_code;

struct { unsigned short len; unsigned char arr[41]; } d_facility_id;

struct { unsigned short len; unsigned char arr[101]; } d_facility_name;

struct { unsigned short len; unsigned char arr[101]; } d_unit_barcode_value;

struct { unsigned short len; unsigned char arr[41]; } d_product_code_temp;

struct { unsigned short len; unsigned char arr[101]; } d_product_desc_temp;

struct { unsigned short len; unsigned char arr[11]; } d_store_instr_code;

struct { unsigned short len; unsigned char arr[41]; } d_store_instr_desc_temp;

struct { unsigned short len; unsigned char arr[21]; } nd_donation_date;

struct { unsigned short len; unsigned char arr[41]; } nd_donor_product_code;

struct { unsigned short len; unsigned char arr[41]; } nd_donor_unit_no;

struct { unsigned short len; unsigned char arr[41]; } nd_product_code;

struct { unsigned short len; unsigned char arr[101]; } nd_product_desc;

struct { unsigned short len; unsigned char arr[41]; } nd_unit_no;

struct { unsigned short len; unsigned char arr[41]; } nd_blood_group;

struct { unsigned short len; unsigned char arr[41]; } nd_rhesus_code;

struct { unsigned short len; unsigned char arr[41]; } nd_expiry_date;

struct { unsigned short len; unsigned char arr[41]; } nd_screened_legend;

struct { unsigned short len; unsigned char arr[22]; } d_donation_date[20];

struct { unsigned short len; unsigned char arr[42]; } d_donor_product_code[20];

struct { unsigned short len; unsigned char arr[42]; } d_donor_unit_no[20];

struct { unsigned short len; unsigned char arr[42]; } d_product_code[20];

struct { unsigned short len; unsigned char arr[102]; } d_store_instr_desc[20];

struct { unsigned short len; unsigned char arr[102]; } d_product_desc[20];

struct { unsigned short len; unsigned char arr[42]; } d_unit_no[20];

struct { unsigned short len; unsigned char arr[42]; } d_blood_group[20];

struct { unsigned short len; unsigned char arr[42]; } d_rhesus_code[20];

struct { unsigned short len; unsigned char arr[42]; } d_expiry_date[20];

struct { unsigned short len; unsigned char arr[42]; } d_screened_legend[20];

struct { unsigned short len; unsigned char arr[15]; } nd_bld_grp_rh_barcode;

struct { unsigned short len; unsigned char arr[200]; } nd_prod_barcode_msg1;

struct { unsigned short len; unsigned char arr[200]; } nd_prod_barcode_msg2;

struct { unsigned short len; unsigned char arr[20]; } nd_donor_id;

struct { unsigned short len; unsigned char arr[4]; } nd_center_code;

struct { unsigned short len; unsigned char arr[15]; } nd_product_barcode_value;

struct { unsigned short len; unsigned char arr[2]; } nd_donation_process;

struct { unsigned short len; unsigned char arr[18]; } d_bld_grp_rh_barcode[20];

struct { unsigned short len; unsigned char arr[202]; } d_prod_barcode_msg1[20];

struct { unsigned short len; unsigned char arr[202]; } d_prod_barcode_msg2[20];

struct { unsigned short len; unsigned char arr[22]; } d_donor_id[20];

struct { unsigned short len; unsigned char arr[6]; } d_center_code[20];

struct { unsigned short len; unsigned char arr[18]; } d_product_barcode_value[20];

struct { unsigned short len; unsigned char arr[2]; } d_donation_process[20];

struct { unsigned short len; unsigned char arr[2]; } d_flag;

struct { unsigned short len; unsigned char arr[171]; } er_msg;

struct { unsigned short len; unsigned char arr[41]; } a_ws_no;

struct { unsigned short len; unsigned char arr[500]; } a_cmd_line_arg;

struct { unsigned short len; unsigned char arr[41]; } a_rowid;

struct { unsigned short len; unsigned char arr[41]; } a_pgm_id;

struct { unsigned short len; unsigned char arr[2]; } nd_print_source_type;

struct { unsigned short len; unsigned char arr[2]; } nd_print_source;


  int         d_volume[500],
              nd_volume,
              d_tot_no_products,
	  		  h_no_of_rec = 0;


 char string_var[100];

/*tern  char WORKING_DIR_NAME [75];*/

  int er_msg_type = 0;	
  int err_flag = 0;
  
  char string_char[100];
  	
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
char filename[150];
char filename1[150];

char *command;  
char gtt_yn = 'N';

void proc_main(argc,argv)
int argc;
char *argv[];
{
 err_flag = 0;
 

//ins_message(ERR_MESG,"rlrlbprn : Start");


  if(argc != 7) 
  {
     ins_message(ERR_MESG,"bdrlabel : Usage - BTRLBISB UID_PWD SESSION_ID PGM_ID UNIT_NO PRODUCT_CODE FACILITY_ID WS_NO arguments wrong\n");
  }


    strcpy(filename,WORKING_DIR);



    strcpy(a_pgm_id.arr,argv[0]);
    a_pgm_id.len = strlen(a_pgm_id.arr); 


    strcpy(uid_pwd.arr,argv[1]);
    uid_pwd.len = strlen(uid_pwd.arr); 


    strcpy(nd_session_id.arr, argv[2]);
    nd_session_id.len = strlen(nd_session_id.arr);


    strcpy(a_pgm_id.arr,argv[3]);
    a_pgm_id.len = strlen(a_pgm_id.arr); 
	

    strcpy(filename1, a_pgm_id.arr);

    strcat(filename, strcat(filename1, ".lis"));

    if (strcmp(strupr(a_pgm_id.arr), "BTRLBISB") == 0)
    {

	strcpy(d_fm_unit_no.arr,argv[4]);
	d_fm_unit_no.len = strlen(d_fm_unit_no.arr);

    
	strcpy(d_fm_product_code.arr,argv[5]);
	d_fm_product_code.len = strlen(d_fm_product_code.arr);



	strcpy(d_facility_id.arr,argv[6]);
	d_facility_id.len = strlen(d_facility_id.arr);


	strcpy(nd_ws_no.arr, argv[7]);
	nd_ws_no.len = strlen(nd_ws_no.arr);


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




	printf("connected/n");

    set_meduser_role();

    get_facility_name();

    get_printer_type();

	get_trans_ind();





	if (strcmp(strupr(a_pgm_id.arr), "BTRLBISB") == 0)
    {


      dclr_un_screened_cur();
			
      while(fetch_un_screened_cur())
	  {	  
	  get_product_desc();	  
      get_graph_barcode();
	  get_center_code();
	  get_product_barcode_msg();
	  get_donation_details();  
	  
        h_no_of_rec = h_no_of_rec + 1;
      }
	  
    }  

	   
	
    call_main_report();

	
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

	fclose(f1);
    sprintf(string_var,"%s -> %s\n",d_fm_unit_no.arr, sqlca.sqlerrm.sqlerrmc);
    ins_message(ORA_MESG,string_var);
//	disp_message(ERR_MESG, string_var);
    /* EXEC SQL COMMIT WORK RELEASE; */ 

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





	//fclose(f2);
}


dclr_un_screened_cur()
{
 
   
		/* EXEC SQL DECLARE c_scr CURSOR FOR
                       SELECT A.product_code, 
                              A.unit_no, 
							  A.blood_group,
							  A.rhesus_code,                              
                              TO_CHAR(A.expiry_date, 'DD/MM/YYYY')                              
                       FROM   bd_component_label_vw A
                       WHERE  A.donor_unit_no = :d_fm_unit_no
                       AND    A.donor_product_code = :d_fm_product_code 
                       AND    A.operating_facility_id = :d_facility_id
					   AND    (1=1 and ( :a_pgm_id = 'BTRLBISB' AND NVL(A.add_to_stock_yn, 'N') = 'Y' )					          
					          ) ; */ 


		/* EXEC SQL OPEN c_scr; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0004;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )66;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqcmod = (unsigned int )0;
  sqlstm.sqhstv[0] = (         void  *)&d_fm_unit_no;
  sqlstm.sqhstl[0] = (unsigned int  )43;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_fm_product_code;
  sqlstm.sqhstl[1] = (unsigned int  )43;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_facility_id;
  sqlstm.sqhstl[2] = (unsigned int  )43;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&a_pgm_id;
  sqlstm.sqhstl[3] = (unsigned int  )43;
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
	{
        ins_message (ORA_MESG, "OPEN Cursor c_scr Failed ");

    }

}





int fetch_un_screened_cur()
{




nd_product_code.arr[0] ='\0';
nd_product_code.len =0;

nd_unit_no.arr[0] ='\0';
nd_unit_no.len =0;

nd_blood_group.arr[0] ='\0';
nd_blood_group.len =0;

nd_rhesus_code.arr[0] ='\0';
nd_rhesus_code.len =0;

nd_expiry_date.arr[0] ='\0';
nd_expiry_date.len =0;




      /* EXEC SQL FETCH c_scr INTO
                        :nd_product_code,
                        :nd_unit_no,
                        :nd_blood_group,
                        :nd_rhesus_code,						
                        :nd_expiry_date; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 12;
      sqlstm.arrsiz = 5;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )97;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)4352;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqfoff = (           int )0;
      sqlstm.sqfmod = (unsigned int )2;
      sqlstm.sqhstv[0] = (         void  *)&nd_product_code;
      sqlstm.sqhstl[0] = (unsigned int  )43;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&nd_unit_no;
      sqlstm.sqhstl[1] = (unsigned int  )43;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&nd_blood_group;
      sqlstm.sqhstl[2] = (unsigned int  )43;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&nd_rhesus_code;
      sqlstm.sqhstl[3] = (unsigned int  )43;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&nd_expiry_date;
      sqlstm.sqhstl[4] = (unsigned int  )43;
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

						                       


					 
// disp_message(ERR_MESG, "s1");
    if (OERROR)
	{
//		sprintf(string_var,"%s get_facility_name()-> %s\n", d_facility_id.arr, sqlca.sqlerrm.sqlerrmc);
//		disp_message(ERR_MESG, string_var);
        ins_message (ORA_MESG, "FETCH failed c2 ");
		return 0;
      }

    if (NO_DATA_FOUND)
      return 0;

  nd_unit_no.arr[nd_unit_no.len]='\0';
  nd_expiry_date.arr[nd_expiry_date.len]='\0';

  sprintf(d_product_code[h_no_of_rec].arr,"%s", nd_product_code.arr);
  d_product_code[h_no_of_rec].len = strlen(d_product_code[h_no_of_rec].arr);

  sprintf(d_unit_no[h_no_of_rec].arr,"%s", nd_unit_no.arr);
  d_unit_no[h_no_of_rec].len = strlen(d_unit_no[h_no_of_rec].arr);

  sprintf(d_blood_group[h_no_of_rec].arr,"%s", nd_blood_group.arr);
  d_blood_group[h_no_of_rec].len = strlen(d_blood_group[h_no_of_rec].arr);

  sprintf(d_rhesus_code[h_no_of_rec].arr,"%s", nd_rhesus_code.arr);
  d_rhesus_code[h_no_of_rec].len = strlen(d_rhesus_code[h_no_of_rec].arr);

  sprintf(d_expiry_date[h_no_of_rec].arr,"%s", nd_expiry_date.arr);
  d_expiry_date[h_no_of_rec].len = strlen(d_expiry_date[h_no_of_rec].arr);

  

  d_volume[h_no_of_rec] = nd_volume;

  return 1;
  
}




//start Dhana

get_graph_barcode()
{

nd_bld_grp_rh_barcode.arr[0]='\0';
nd_bld_grp_rh_barcode.len=0;


/* EXEC SQL	SELECT BLOOD_GRP_RH_BARCODE_CODE INTO :nd_bld_grp_rh_barcode
			FROM BT_BLOOD_GRP_RH_BARCODE  
			WHERE 	BLOOD_GROUP=:d_blood_group[h_no_of_rec]
			AND RHESUS_CODE=:d_rhesus_code[h_no_of_rec]; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 5;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select BLOOD_GRP_RH_BARCODE_CODE into :b0  from BT_BLOOD_GRP_\
RH_BARCODE where (BLOOD_GROUP=:b1 and RHESUS_CODE=:b2)";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )132;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)4352;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&nd_bld_grp_rh_barcode;
sqlstm.sqhstl[0] = (unsigned int  )17;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&d_blood_group[h_no_of_rec];
sqlstm.sqhstl[1] = (unsigned int  )43;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&d_rhesus_code[h_no_of_rec];
sqlstm.sqhstl[2] = (unsigned int  )43;
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



	nd_bld_grp_rh_barcode.arr[nd_bld_grp_rh_barcode.len]='\0';



  sprintf(d_bld_grp_rh_barcode[h_no_of_rec].arr,"%s", nd_bld_grp_rh_barcode.arr);
  d_bld_grp_rh_barcode[h_no_of_rec].len = strlen(nd_bld_grp_rh_barcode.arr);



if(OERROR)
	{
		sprintf(string_var,"%s and %s and %s  get_graph_barcode-> %s\n", d_product_code[h_no_of_rec].arr,d_blood_group[h_no_of_rec].arr,d_rhesus_code[h_no_of_rec].arr,sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
	}
}


get_center_code()
 {

nd_center_code.arr[0]='\0';
nd_center_code.len=0;



/* EXEC SQL SELECT CENTRE_CODE into :nd_center_code
		FROM BD_BLOOD_UNITS_MAST 
	WHERE UNIT_NO=:d_unit_no[h_no_of_rec]
	and product_code=:d_product_code[h_no_of_rec]; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 5;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select CENTRE_CODE into :b0  from BD_BLOOD_UNITS_MAST where (\
UNIT_NO=:b1 and product_code=:b2)";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )159;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)4352;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&nd_center_code;
sqlstm.sqhstl[0] = (unsigned int  )6;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&d_unit_no[h_no_of_rec];
sqlstm.sqhstl[1] = (unsigned int  )43;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&d_product_code[h_no_of_rec];
sqlstm.sqhstl[2] = (unsigned int  )43;
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






 sprintf(d_center_code[h_no_of_rec].arr,"%s", nd_center_code.arr);
  d_center_code[h_no_of_rec].len = strlen(nd_center_code.arr);


if(OERROR)
	{
		sprintf(string_var,"%s get_center_code-> %s\n", d_unit_no[h_no_of_rec].arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
	}

 }


get_product_barcode_msg()
 {


nd_prod_barcode_msg1.arr[0]='\0';
nd_prod_barcode_msg1.len=0;


/* EXEC SQL SELECT PRODUCT_BARCODE_MESS1,PRODUCT_BARCODE_MESS2,PRODUCT_BARCODE_CODE into :nd_prod_barcode_msg1,:nd_prod_barcode_msg2,:nd_product_barcode_value
			  FROM BT_PRODUCT_MAST 
			 //WHERE PRODUCT_CODE=:d_product_code[h_no_of_rec];
			 WHERE PRODUCT_CODE=:d_fm_product_code; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 5;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select PRODUCT_BARCODE_MESS1 ,PRODUCT_BARCODE_MESS2 ,PRODUCT_\
BARCODE_CODE into :b0,:b1,:b2  from BT_PRODUCT_MAST where PRODUCT_CODE=:b3";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )186;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)4352;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&nd_prod_barcode_msg1;
sqlstm.sqhstl[0] = (unsigned int  )202;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&nd_prod_barcode_msg2;
sqlstm.sqhstl[1] = (unsigned int  )202;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&nd_product_barcode_value;
sqlstm.sqhstl[2] = (unsigned int  )17;
sqlstm.sqhsts[2] = (         int  )0;
sqlstm.sqindv[2] = (         void  *)0;
sqlstm.sqinds[2] = (         int  )0;
sqlstm.sqharm[2] = (unsigned int  )0;
sqlstm.sqadto[2] = (unsigned short )0;
sqlstm.sqtdso[2] = (unsigned short )0;
sqlstm.sqhstv[3] = (         void  *)&d_fm_product_code;
sqlstm.sqhstl[3] = (unsigned int  )43;
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





  sprintf(d_prod_barcode_msg1[h_no_of_rec].arr,"%s", nd_prod_barcode_msg1.arr);
  d_prod_barcode_msg1[h_no_of_rec].len = strlen(nd_prod_barcode_msg1.arr);

  sprintf(d_prod_barcode_msg2[h_no_of_rec].arr,"%s", nd_prod_barcode_msg2.arr);
  d_prod_barcode_msg2[h_no_of_rec].len = strlen(nd_prod_barcode_msg2.arr);


  sprintf(d_product_barcode_value[h_no_of_rec].arr,"%s", nd_product_barcode_value.arr);
  d_product_barcode_value[h_no_of_rec].len = strlen(nd_product_barcode_value.arr);

 if(OERROR)
	{
		sprintf(string_var,"%s get_center_code-> %s\n", d_unit_no[h_no_of_rec].arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
	}
 
 }

 get_donation_details()
  {



nd_donor_id.arr[0]='\0';
nd_donor_id.len=0;


nd_donation_process.arr[0]='\0';
nd_donation_process.len=0;

/* EXEC SQL 	 SELECT DONOR_ID,DONATION_PROCESS
				 INTO :nd_donor_id,:nd_donation_process
				 FROM BD_DONOR_Q_P_HDR
				 WHERE UNIT_NO=:d_unit_no[h_no_of_rec] AND PRODUCT_CODE=:d_fm_product_code; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 5;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select DONOR_ID ,DONATION_PROCESS into :b0,:b1  from BD_DONOR\
_Q_P_HDR where (UNIT_NO=:b2 and PRODUCT_CODE=:b3)";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )217;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)4352;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&nd_donor_id;
sqlstm.sqhstl[0] = (unsigned int  )22;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&nd_donation_process;
sqlstm.sqhstl[1] = (unsigned int  )4;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&d_unit_no[h_no_of_rec];
sqlstm.sqhstl[2] = (unsigned int  )43;
sqlstm.sqhsts[2] = (         int  )0;
sqlstm.sqindv[2] = (         void  *)0;
sqlstm.sqinds[2] = (         int  )0;
sqlstm.sqharm[2] = (unsigned int  )0;
sqlstm.sqadto[2] = (unsigned short )0;
sqlstm.sqtdso[2] = (unsigned short )0;
sqlstm.sqhstv[3] = (         void  *)&d_fm_product_code;
sqlstm.sqhstl[3] = (unsigned int  )43;
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

         


//fprintf(f2,"\nDONOR_ID = %s  DONATION_PROCESS=%s",nd_donor_id.arr,nd_donation_process.arr);

nd_donor_id.arr[nd_donor_id.len]='\0';

sprintf(d_donor_id[h_no_of_rec].arr,"%s", nd_donor_id.arr);
d_donor_id[h_no_of_rec].len = strlen(nd_donor_id.arr);

  sprintf(d_donation_process[h_no_of_rec].arr,"%s", nd_donation_process.arr);
  d_donation_process[h_no_of_rec].len = strlen(nd_donation_process.arr);


if(OERROR)
	{
		sprintf(string_var,"%s get_center_code-> %s\n", d_unit_no[h_no_of_rec].arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
	}
  }




//End Dhana



get_facility_name()
{
	d_facility_name.arr[0]		= '\0';
	d_facility_name.len		= 0;

	/* EXEC SQL  SELECT facility_name
	            INTO :d_facility_name
	            FROM sm_facility_param
               WHERE facility_id = :d_facility_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select facility_name into :b0  from sm_facility_param where \
facility_id=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )248;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_facility_name;
 sqlstm.sqhstl[0] = (unsigned int  )103;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_facility_id;
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



	if(OERROR)
	{
		sprintf(string_var,"%s get_facility_name()-> %s\n", d_facility_id.arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
	}

	d_facility_name.arr[d_facility_name.len]   = '\0';
	d_facility_name.len = strlen(d_facility_name.arr);

    if(NO_DATA_FOUND)
    {
      d_facility_name.arr[d_facility_name.len]   = '\0';
      d_facility_name.len = strlen(d_facility_name.arr);
    }
}

get_product_desc()
{

    d_store_instr_code.arr[0]		     = '\0';
	d_store_instr_code.len		         = 0;

    d_store_instr_desc_temp.arr[0]	     = '\0';
	d_store_instr_desc_temp.len		     = 0;

	d_product_desc[h_no_of_rec].arr[0]	 = '\0';
	d_product_desc[h_no_of_rec].len		 = 0;

	d_store_instr_desc[h_no_of_rec].arr[0]	 = '\0';
	d_store_instr_desc[h_no_of_rec].len		 = 0;

	strcpy(d_product_code_temp.arr, d_product_code[h_no_of_rec].arr);
	d_product_code_temp.arr[strlen(d_product_code_temp.arr)]='\0';
	d_product_code_temp.len = strlen(d_product_code_temp.arr);

	/* EXEC SQL  SELECT store_instr_code, long_desc
	            INTO :d_store_instr_code, :d_product_desc_temp
	            FROM bt_product_mast
               WHERE product_code = :d_product_code_temp; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select store_instr_code ,long_desc into :b0,:b1  from bt_pro\
duct_mast where product_code=:b2";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )271;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_store_instr_code;
 sqlstm.sqhstl[0] = (unsigned int  )13;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_product_desc_temp;
 sqlstm.sqhstl[1] = (unsigned int  )103;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_product_code_temp;
 sqlstm.sqhstl[2] = (unsigned int  )43;
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



	//fprintf(f2,"\nstore_instr_code = %s long_desc=%s",d_store_instr_code.arr,d_product_desc_temp.arr);

	if(OERROR)
	{
		sprintf(string_var,"%s get_product_desc()-> %s\n", d_fm_unit_no.arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
	}

    if(NO_DATA_FOUND)
    {
      d_product_desc[h_no_of_rec].arr[d_product_desc[h_no_of_rec].len]   = '\0';
      d_product_desc[h_no_of_rec].len = strlen(d_product_desc[h_no_of_rec].arr);
    }

	d_product_desc_temp.arr[d_product_desc_temp.len]   = '\0';
	d_product_desc_temp.len = strlen(d_product_desc_temp.arr);

	strcpy(d_product_desc[h_no_of_rec].arr, d_product_desc_temp.arr );
    d_product_desc[h_no_of_rec].arr[strlen(d_product_desc[h_no_of_rec].arr)]   = '\0';
    d_product_desc[h_no_of_rec].len = strlen(d_product_desc[h_no_of_rec].arr);

    d_store_instr_code.arr[strlen(d_store_instr_code.arr)]   = '\0';
    d_store_instr_code.len = strlen(d_store_instr_code.arr);

	/* EXEC SQL  SELECT short_desc
	            INTO :d_store_instr_desc_temp
	            FROM bd_storage_instruction
               WHERE store_instr_code = :d_store_instr_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select short_desc into :b0  from bd_storage_instruction wher\
e store_instr_code=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )298;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_store_instr_desc_temp;
 sqlstm.sqhstl[0] = (unsigned int  )43;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_store_instr_code;
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
	{
		sprintf(string_var,"%s get_product_desc()-> %s\n", d_fm_unit_no.arr, sqlca.sqlerrm.sqlerrmc);
	}

    if(NO_DATA_FOUND)
    {
      d_store_instr_desc_temp.arr[d_store_instr_desc_temp.len]   = '\0';
      d_store_instr_desc_temp.len = strlen(d_store_instr_desc_temp.arr);
    }

    d_store_instr_desc_temp.arr[strlen(d_store_instr_desc_temp.arr)]   = '\0';
    d_store_instr_desc_temp.len = strlen(d_store_instr_desc_temp.arr);

	strcpy(d_store_instr_desc[h_no_of_rec].arr, d_store_instr_desc_temp.arr );
    d_store_instr_desc[h_no_of_rec].arr[strlen(d_store_instr_desc[h_no_of_rec].arr)]   = '\0';
    d_store_instr_desc[h_no_of_rec].len = strlen(d_store_instr_desc[h_no_of_rec].arr);

}

/**************************select transaction based or not ***************/
get_trans_ind()
{
	
	nd_trx_ind.arr[0]		= '\0';
	nd_trx_ind.len		= 0;

	/* EXEC SQL  SELECT NVL(TRANSACTION_BASED_YN, 'N')
	            INTO :nd_trx_ind
	            FROM sy_online_print_id
               WHERE MODULE_ID = 'RL'
   		         AND ONLINE_PRINT_NAME = :a_pgm_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select NVL(TRANSACTION_BASED_YN,'N') into :b0  from sy_onlin\
e_print_id where (MODULE_ID='RL' and ONLINE_PRINT_NAME=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )321;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_trx_ind;
 sqlstm.sqhstl[0] = (unsigned int  )4;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&a_pgm_id;
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



	if(OERROR)
	{
		sprintf(string_var,"%s get_trans_ind()-> %s\n", d_fm_unit_no.arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
	}

	nd_trx_ind.arr[nd_trx_ind.len]   = '\0';

    if(NO_DATA_FOUND)
	  nd_trx_ind.arr[nd_trx_ind.len]   = '\0';
		
     if (strcmp(nd_trx_ind.arr, "Y") == 0)
	 {
		strcpy(nd_print_source_type.arr, nd_source_type.arr);
		strcpy(nd_print_source.arr, nd_fm_source.arr);
	 }
	 else
	 {
        strcpy(nd_print_source_type.arr, "O");
        strcpy(nd_print_source.arr, " ");
	 }

}

call_main_report()
{
  call_print_label();
}

set_fonts()
{

	fprintf(f1,"%c&a0L",ESC);	/* This will make the left margin to reduce	 to 0 */
	fprintf(f1,"%c&l0E\n",ESC);	/* This will make the top margin to reduce	 to 0 */
	fprintf(f1,"%c&l12D",ESC);	/* This will make no. of lines per inch		 to 8 */
}


call_print_label()
{
  int v_i = 0;

  //fprintf(f2,"enter print label");

  
   
	for (v_i=0;v_i<h_no_of_rec;v_i++)
   {  
   //fprintf(f2,"enter in to for loop print label");   
      print_isb_label(v_i);
	}
	

 	
   
  
}


/* print_bar_code (char *dat,int x,int y)
 {

    print_barcode(f1,dat, x, y, 40, 250,atoi(nd_printer_type.arr));
    fprintf(f1,"\n");  

//fprintf(f1,"%c%-s%c\n",2,dat,5);

 } */










print_isb_label(int position)
{

//Barcode

 if ( ( f1 = fopen ( filename, "w" ) ) == NULL ) 
    {	
      ins_message(ERR_MESG,"Error in opening output file...\n");  
    }

 
    if (strcmp(nd_printer_type.arr,"3")!= 0)
    {
      fprintf(f1, "%cE", ESC);
      set_fonts();
    }




//atoi(nd_printer_type.arr)

nd_printer_type.arr[0]='3';
nd_printer_type.arr[1]='\0';


print_barcode(f1,d_unit_no[position].arr, 0, 0, 60, 250,atoi(nd_printer_type.arr));
fprintf(f1,"\n"); 
print_barcode(f1,d_bld_grp_rh_barcode[position].arr, 0,25,  60, 250,atoi(nd_printer_type.arr));
fprintf(f1,"\n"); 

fprintf(f1,"%-s\n",d_unit_no[position].arr);
fprintf(f1,"%-s\n",d_bld_grp_rh_barcode[position].arr);


 



 //Value
 



 
 

 fprintf(f1,"%-s\n",d_center_code[position].arr);
 fprintf(f1,"%-s\n",d_prod_barcode_msg1[position].arr);


fprintf(f1,"%-s\n",d_blood_group[position].arr);
 

 fprintf(f1,"%-s\n",d_donation_process[position].arr);

fprintf(f1,"%-s\n",d_rhesus_code[position].arr);
 

//Barcode

//atoi(nd_printer_type.arr)

print_barcode(f1,d_donor_id[position].arr,22,0,  60, 250,atoi(nd_printer_type.arr));
fprintf(f1,"\n");

 //fprintf(f1,"\nX%-sX",d_donor_id[position].arr,135,135);


print_barcode(f1,d_expiry_date[position].arr, 22,25,  60, 250,atoi(nd_printer_type.arr));
fprintf(f1,"\n");

fprintf(f1,"%-s\n",d_donor_id[position].arr); 
fprintf(f1,"%-s\n",d_expiry_date[position].arr); 

//fprintf(f1,"\nX%-sX",d_expiry_date[position].arr);



//Value






 fprintf(f1,"%-s\n",d_product_barcode_value[position].arr);

 fprintf(f1,"%s\n",d_prod_barcode_msg2[position].arr);

 fclose(f1);
print_barcode_label(1);
 


}


/******************* added on 28.07.2003 ********/
get_printer_type()
{

	  strcpy(nd_printer_type.arr, "3");
	  nd_printer_type.len = strlen(nd_printer_type.arr);

	  /* EXEC SQL SELECT NVL(printer_type, '1')
  	           INTO  :nd_printer_type
  	           FROM   SY_ONLINE_PRINT_ID
	           WHERE  module_id = 'RL'
	           AND    online_print_name = :a_pgm_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 5;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select NVL(printer_type,'1') into :b0  from SY_ONLINE_PRIN\
T_ID where (module_id='RL' and online_print_name=:b1)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )344;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_printer_type;
   sqlstm.sqhstl[0] = (unsigned int  )4;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&a_pgm_id;
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

 

        if(NO_DATA_FOUND)
   		strcpy(nd_printer_type.arr, "3");
		nd_printer_type.len = strlen(nd_printer_type.arr);
  	  if(OERROR)
   		strcpy(nd_printer_type.arr, "3");
		nd_printer_type.len = strlen(nd_printer_type.arr);

	  nd_printer_type.arr[nd_printer_type.len]  = '\0';
	  nd_printer_type.len = 0;

}

print_unit_label(int v_ind)
{

	if (strcmp(nd_printer_type.arr,"3")!=0)	
	  {
	     print_barcode(f1,d_fm_unit_no.arr, 0, 0, 40, 250,atoi(nd_printer_type.arr));
	     fprintf(f1,"\n");  
	  }
	else
	 {
	     print_barcode(f1, d_fm_unit_no.arr, 0, 0, 40, 250,atoi(nd_printer_type.arr));		
	     fprintf(f1,"\n");
	 }
	fprintf(f1, "%-20s\n", d_fm_unit_no.arr);
}

print_unscreened_label(int v_ind)
{

	fprintf(f1, "%-13s", d_donation_date[v_ind].arr);
	fprintf(f1, "%-s\n", d_product_desc[v_ind].arr);
	sprintf(d_unit_barcode_value.arr,"%s %s ", d_unit_no[v_ind].arr, d_product_code[v_ind].arr);
//	sprintf(d_unit_barcode_value.arr,"%s %s %d/%d", d_unit_no[v_ind].arr, d_product_code[v_ind].arr, v_ind+1, h_no_of_rec);

	if (strcmp(nd_printer_type.arr,"3")!=0)	
	  {
	     print_barcode(f1,d_unit_barcode_value.arr, 0, 0, 40, 250,atoi(nd_printer_type.arr));
	     fprintf(f1,"\n");  
	  }
	else
	 {
	     print_barcode(f1, d_unit_barcode_value.arr, 0, 0, 40, 250,atoi(nd_printer_type.arr));		
	     fprintf(f1,"\n");
	 }
	fprintf(f1, "%-s\n", d_blood_group[v_ind].arr);
	fprintf(f1, "%-s\n", d_rhesus_code[v_ind].arr);
	fprintf(f1, "%-d\n", d_volume[v_ind]);
	fprintf(f1, "%-s    ", d_unit_barcode_value.arr);
	fprintf(f1, "%-s\n", "UNSCREENED");
}

print_screened_label(int v_ind)
{

	fprintf(f1, "%-s\n", d_facility_name.arr);
	fprintf(f1, "%-s\n", d_product_desc[v_ind].arr);
	fprintf(f1, "Storage   : %-s\n", d_store_instr_desc[v_ind].arr);
	fprintf(f1, "Collected : %-s\n", d_donation_date[v_ind].arr);
	fprintf(f1, "Expires   : %-s\n", d_expiry_date[v_ind].arr);
//	fprintf(f1, "FOR FRACTIONATION\n");
	fprintf(f1, "%-s\n", d_blood_group[v_ind].arr);
	fprintf(f1, "%-d\n", d_volume[v_ind]);
	fprintf(f1, "%-s\n", d_rhesus_code[v_ind].arr);
	sprintf(d_unit_barcode_value.arr,"%s %s", d_unit_no[v_ind].arr, d_product_code[v_ind].arr);
//	sprintf(d_unit_barcode_value.arr,"%s %s %d/%d", d_unit_no[v_ind].arr, d_product_code[v_ind].arr, v_ind+1, h_no_of_rec);
	if (strcmp(nd_printer_type.arr,"3")!=0)	
	  {
	     print_barcode(f1,d_unit_barcode_value.arr, 0, 0, 40, 250,atoi(nd_printer_type.arr));
	     fprintf(f1,"\n");  
	  }
	else
	 {
	     print_barcode(f1, d_unit_barcode_value.arr, 0, 0, 40, 250,atoi(nd_printer_type.arr));		
	     fprintf(f1,"\n");
	 }
	fprintf(f1, "    %-s\n", d_unit_barcode_value.arr);
	fprintf(f1, "    SCREENED");
}


/***************** Print BarCode Label ********************/
print_barcode_label(int nolabel)
 {
    int i;
    int WSPrintstatus;

    for(i=0;i<nolabel;i++)
		  {

		 		if (nd_source_type.arr[0]	== '!')
				{					

					 WSPrintDocument 
						   (
							uid_pwd.arr,		//char	*PUidPwd;
							nd_session_id.arr,	//char	*PSessionID;
							d_facility_id.arr,	//char	*PFacilityID;
							"RL",				//char	*PModuleID;
							a_pgm_id.arr,			//char	*PDocumentID;
							filename,	    	//char	*POnlinePrintFileNames;
							"O",				//char	*PLocationTypes;
							" ",				//char	*PLocationCodes;
							1,			//int	PNumOfCopies;
							1,				    //int	PPageFrom;
							9999,				//int	PPageTo;
							nd_ws_no.arr,		//char	*PWorkstationID
							WORKING_DIR			//char	*PReportOutputDir
						   );
				}						   
				else
				{


					WSPrintstatus =		 WSPrintDocument
						   (
							uid_pwd.arr,				//char	*PUidPwd;
							nd_session_id.arr,			//char	*PSessionID;
							d_facility_id.arr,			//char	*PFacilityID;
							"RL",						//char	*PModuleID;
							a_pgm_id.arr,					//char	*PDocumentID;
							filename,	    			//char	*POnlinePrintFileNames;
							nd_print_source_type.arr,	//char	*PLocationTypes;
							nd_print_source.arr,	    //char	*PLocationCodes;
							1,					//int	PNumOfCopies;
							1,							//int	PPageFrom;
							9999,						//int	PPageTo;
							nd_ws_no.arr,				//char	*PWorkstationID
							WORKING_DIR					//char	*PReportOutputDir
						   );

				}	  					   
		  }
 
 }


/*--------------------------------------------------*/
ins_message(int msg_type,char msg[])
{
   er_msg.arr[0] = '\0';
   er_msg.len = 0;
   
   er_msg_type = 0;

   strcpy(er_msg.arr,msg);
   er_msg.len = strlen(er_msg.arr);
 
   er_msg_type = msg_type;   


   /* EXEC SQL

   INSERT INTO SY_PROG_MSG
         (OPERATING_FACILITY_ID,PGM_ID,MSG_TYPE,MSG_NUM,MSG_DESC,MSG_DATE_TIME,SESSION_ID,PGM_DATE)
   VALUES 
         (:nd_facility_id,'BTRLBISB',:er_msg_type,NULL, SUBSTR(:er_msg, 1, 70),SYSDATE,USERENV('sessionid'),TO_CHAR(SYSDATE,'DD/MM/YYYY')); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 5;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "insert into SY_PROG_MSG (OPERATING_FACILITY_ID,PGM_ID,MSG_\
TYPE,MSG_NUM,MSG_DESC,MSG_DATE_TIME,SESSION_ID,PGM_DATE) values (:b0,'BTRLBISB\
',:b1,null ,SUBSTR(:b2,1,70),SYSDATE,USERENV('sessionid'),TO_CHAR(SYSDATE,'DD/\
MM/YYYY'))";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )367;
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
   sqlstm.sqhstv[1] = (         void  *)&er_msg_type;
   sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&er_msg;
   sqlstm.sqhstl[2] = (unsigned int  )173;
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



   err_flag = 1;
}

