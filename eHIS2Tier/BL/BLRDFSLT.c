
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
           char  filnam[28];
};
static const struct sqlcxp sqlfpn =
{
    27,
    "C:\\workdir\\proc\\BLRDFSLT.PC"
};


static unsigned long sqlctx = 784574683;


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
            void  *sqhstv[16];
   unsigned int   sqhstl[16];
            int   sqhsts[16];
            void  *sqindv[16];
            int   sqinds[16];
   unsigned int   sqharm[16];
   unsigned int   *sqharc[16];
   unsigned short  sqadto[16];
   unsigned short  sqtdso[16];
} sqlstm = {10,16};

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
"_IND='C' and :b9='C') or (C.SETTLEMENT_IND='R' and :b9='R')) or ((C.SETTLEME\
NT_IND='X' and C.ADM_REC_FLAG='1') and :b9='R')) or ((C.SETTLEMENT_IND='X' and\
 C.ADM_REC_FLAG='2') and :b9='I')) or :b9='A'))) and B.DF_SERVICE_IND in ('Y',\
'D')) order by 2,3            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,144,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,30,360,0,0,0,0,0,1,0,
51,0,0,3,239,0,4,398,0,0,14,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
122,0,0,4,84,0,2,443,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
149,0,0,5,1286,0,9,499,0,0,14,14,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
220,0,0,5,0,0,13,538,0,0,16,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,
2,4,0,0,
299,0,0,6,94,0,4,758,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
326,0,0,7,64,0,4,777,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
349,0,0,8,128,0,4,955,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
};


/************************************************************************/
/* PROGRAM NAME          : BLRDFSLT.PC                                  */
/* AUTHOR                : YESHODA ERAPPA                               */
/* DATE WRITTEN          : 10-11-2003                                   */
/* CALLED FROM           : BLRDFSLT.FMX                                 */
/************************************************************************/

#include <stdio.h>
#include <string.h>     
#include <bl.h>

#define OERROR (sqlca.sqlcode < 0)
#define LAST_ROW (sqlca.sqlcode == 1403)
#define NOT_FOUND (sqlca.sqlerrd[2] == 0)
//#define NO_DATA_FOUND (sqlca.sqlerrd[2]==0) 
#define RESOURCE_BUSY        (sqlca.sqlcode == -54)
#define DUPLICATE_KEY        (sqlca.sqlcode == -1)
#define ROW_COUNT            (sqlca.sqlerrd[2])
#define INIT_MESG "Report Generation In Progress"


/* EXEC SQL BEGIN DECLARE SECTION; */ 


 /* VARCHAR hosp_name                                      [120],
	     date_time                                  [20],
	     user_id                                    [40],
	     nd_pwd					[100],
	     nd_session_id                              [16],
	     nd_pgm_date                                [25],
	     d_curr_pgm_name                            [15],
	     d_facility_id				[10]; */ 
struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[40]; } user_id;

struct { unsigned short len; unsigned char arr[100]; } nd_pwd;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[10]; } d_facility_id;

		 
  /* VARCHAR    nd_fr_serv_date				[20],
  			nd_to_serv_date			[20],
			nd_fr_empl_code			[9],
			nd_to_empl_code			[9],
			nd_fr_phy_id			[16],
			nd_to_phy_id			[16],
			nd_fr_cust_code			[9],
			nd_to_cust_code			[9],
			nd_selection_option		[2],
			nd_report_option		[2]; */ 
struct { unsigned short len; unsigned char arr[20]; } nd_fr_serv_date;

struct { unsigned short len; unsigned char arr[20]; } nd_to_serv_date;

struct { unsigned short len; unsigned char arr[9]; } nd_fr_empl_code;

struct { unsigned short len; unsigned char arr[9]; } nd_to_empl_code;

struct { unsigned short len; unsigned char arr[16]; } nd_fr_phy_id;

struct { unsigned short len; unsigned char arr[16]; } nd_to_phy_id;

struct { unsigned short len; unsigned char arr[9]; } nd_fr_cust_code;

struct { unsigned short len; unsigned char arr[9]; } nd_to_cust_code;

struct { unsigned short len; unsigned char arr[2]; } nd_selection_option;

struct { unsigned short len; unsigned char arr[2]; } nd_report_option;


  /* VARCHAR	bl_org_customer			[9],
			bl_physician_id			[16],
			bl_customer				[9],
			bl_patient_id			[21],
			bl_blng_serv_code		[11],
			bl_blng_serv_date		[20],
			bl_bill_doc_type_code	[7],
			bl_bill_doc_type_num	[9],
			bl_bill_doc_date		[20],
			bl_prt_grp_hdr_code		[3],
			bl_prt_grp_line_code	[3],
			bl_charge_type_code		[2],
			bl_df_physician_id		[16]; */ 
struct { unsigned short len; unsigned char arr[9]; } bl_org_customer;

struct { unsigned short len; unsigned char arr[16]; } bl_physician_id;

struct { unsigned short len; unsigned char arr[9]; } bl_customer;

struct { unsigned short len; unsigned char arr[21]; } bl_patient_id;

struct { unsigned short len; unsigned char arr[11]; } bl_blng_serv_code;

struct { unsigned short len; unsigned char arr[20]; } bl_blng_serv_date;

struct { unsigned short len; unsigned char arr[7]; } bl_bill_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } bl_bill_doc_type_num;

struct { unsigned short len; unsigned char arr[20]; } bl_bill_doc_date;

struct { unsigned short len; unsigned char arr[3]; } bl_prt_grp_hdr_code;

struct { unsigned short len; unsigned char arr[3]; } bl_prt_grp_line_code;

struct { unsigned short len; unsigned char arr[2]; } bl_charge_type_code;

struct { unsigned short len; unsigned char arr[16]; } bl_df_physician_id;


 /* VARCHAR	nd_phys_name			[31],
			nd_customer_name		[16],
			physician_id			[16],
			customer_code			[9]; */ 
struct { unsigned short len; unsigned char arr[31]; } nd_phys_name;

struct { unsigned short len; unsigned char arr[16]; } nd_customer_name;

struct { unsigned short len; unsigned char arr[16]; } physician_id;

struct { unsigned short len; unsigned char arr[9]; } customer_code;

			


	double bl_doctor_amt,
	       bl_cust_total,
	       bl_doctor_total, 
	       bl_grand_total ;			
      
  int    prt_select_flag;

  int l_counter = 0,
	  l_flag = 0,
	  nCnt1   = 0,
	  nCnt2   = 0;

  double   bl_bill_tot_amt, 
		bl_bill_amt,
	    bl_bill_tot_outst_amt, 
	    bl_ar_inv_doc_number,
	    bl_dcp_outst_amt,
		bl_bill_level_disc_amt,
		bl_line_level_disc_amt,
		bl_net_amt,
	    outst_amt,
		outst_amt_pdcp,
		d_rec_amt,
		d_rec_amt1,
		d_rec_amt2;

  char  filename[150];
  char  string_var [150];

/* EXEC SQL END DECLARE SECTION; */ 


/* EXEC SQL INCLUDE SQLCA.H;
 */ 
/*
 * $Header:   T:/eHIS-102/archives/eHIS2Tier/BL/BLRDFSLT.c-arc   1.0   Apr 19 2007 17:06:06   vcm_th  $ sqlca.h 
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
 * $Header:   T:/eHIS-102/archives/eHIS2Tier/BL/BLRDFSLT.c-arc   1.0   Apr 19 2007 17:06:06   vcm_th  $ sqlda.h 
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

int      lctr = 0,pctr = 0,rec_ctr=0 ;
double   bl_tot_net_amt		=0.0,
         bl_tot_ip_net_amt	= 0.0,
		 bl_tot_op_net_amt	= 0.0,
		 bl_tot_rf_net_amt	= 0.0,
         bl_grn_tot_net_amt = 0.0,
		 bl_phys_net_amt	= 0.0,
		 iptot				= 0.0,
		 optot				= 0.0,
		 rftot				= 0.0,
		 giptot				= 0.0,
		 goptot				= 0.0,
		 grftot				= 0.0,
		 ip_temp_tot		= 0.0,
		 ip_temp_gnd_tot	= 0.0,
		 op_temp_tot		= 0.0,
		 op_temp_gnd_tot	= 0.0;
	

char     blng_serv_code     [11], 
	     t_bill_stat_desc[3],
		 bill_settled_type[1],
	     dcp_outst_amt_desc[1];
	  
	 
FILE *fp;

void proc_main(argc,argv)
char *argv[];
int argc;
{
    if (argc < 5)
    {
     int i = 0;
       disp_message(ERR_MESG,"Not enough Parameters for running this program\n");
       proc_exit();
    }
 
    strcpy(g_pgm_id,"BLRDFSLT");

	 strcpy(nd_pwd.arr,argv[1]);
	 nd_pwd.len = strlen(nd_pwd.arr);

	 /* EXEC sql connect :nd_pwd; */ 

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
  sqlstm.sqhstv[0] = (         void  *)&nd_pwd;
  sqlstm.sqhstl[0] = (unsigned int  )102;
  sqlstm.sqhsts[0] = (         int  )102;
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


	  
	  if (sqlca.sqlcode < 0 )
	   {
        disp_message(ORA_MESG,"Error in connecting to Oracle");
        proc_exit();
        }
	set_meduser_role(); 

    strcpy(d_curr_pgm_name.arr,g_pgm_id); 
    d_curr_pgm_name.len = strlen(d_curr_pgm_name.arr); 

    strcpy(nd_session_id.arr,argv[2]);
    nd_session_id.len = strlen(nd_session_id.arr);
    strcpy(g_session_id,nd_session_id.arr);

    strcpy(nd_pgm_date.arr,argv[3]);
    nd_pgm_date.len = strlen(nd_pgm_date.arr);
    strcpy(g_pgm_date,nd_pgm_date.arr);

    //start_prog_msg();

    fetch_prog_param();


	fetch_hosp_name();



	declare_cur();

	 

	open_file();
	
	open_cur();
   
    l_flag = 1;  
	bl_cust_total = 0.0;
	bl_doctor_total = 0.0;

   
    
	while(fetch_cur())
    {
			if (l_flag == 1)
			{
			    if (strcmp(nd_report_option.arr , "D") == 0)
				{
					print_doctor_code();
					print_customer_code();	
				}
				 else
				{
					
					select_phys_name();
	                 fprintf(fp,"%-15s %-30s\n",bl_physician_id.arr,nd_phys_name.arr);

					//fprintf(fp,"CUSTOMER CODE :  ");
					get_customer_name();
	
					if (bl_customer.arr[0] == '\0') 
					{
						fprintf(fp,"                                     PRIVATE -- CASH PATIENT ");
						
					}
					else
					{
						fprintf(fp,"                                     %-8s %15s", bl_customer.arr, nd_customer_name.arr);
					}

				 } 


				lctr+=3;
				l_flag = 0;

			}

     		   if (strcmp(physician_id.arr,bl_physician_id.arr) == 0)
			   {
                  	if (strcmp(customer_code.arr,bl_customer.arr) == 0)
					{		
						if (strcmp(nd_report_option.arr , "D") == 0)
						  print_details();


						  bl_cust_total = bl_cust_total + bl_doctor_amt;
						  bl_doctor_total =  bl_doctor_total + bl_doctor_amt;
						  bl_grand_total = bl_grand_total + bl_doctor_amt;
					}
					else /* customer */
					{
						if (strcmp(nd_report_option.arr , "D") == 0)
						{
							print_customer_total();
							print_customer_code();
							print_details();
						 }
						 else
						 {
						    print_customer_total();
							get_customer_name();
							
                            if (bl_customer.arr[0] == '\0') 
							{
								fprintf(fp,"                                     PRIVATE -- CASH PATIENT ");
								
							}
							else
							{
								fprintf(fp,"                                     %-8s %15s", bl_customer.arr, nd_customer_name.arr);
							}
						 }
                             
             

					   
					      bl_cust_total = bl_cust_total + bl_doctor_amt;
						  bl_doctor_total =  bl_doctor_total + bl_doctor_amt;
						  bl_grand_total = bl_grand_total + bl_doctor_amt;
                       


					} /* end of customer */
				}
				else /* physician*/
				{
					
					//print_customer_total();
					
					//print_doctor_total();
					//bl_cust_total = 0.0;
					//bl_doctor_total = 0.0;

					
					lctr+=3;
                     
					if (strcmp(nd_report_option.arr , "D") == 0)
					{
					    print_customer_total();
					    print_doctor_total();
						//print_details();
						print_doctor_code();
						print_customer_code();
						print_details();

					}
					else
					{
						print_customer_total();
					    print_doctor_total();
						 select_phys_name();
	                     fprintf(fp,"%-15s %-30s\n",bl_physician_id.arr,nd_phys_name.arr);
						
		                
						get_customer_name();
						if (bl_customer.arr[0] == '\0') 
						{
							fprintf(fp,"                                     PRIVATE -- CASH PATIENT ");
							
						}
						else
						{
							fprintf(fp,"                                     %-8s %15s", bl_customer.arr, nd_customer_name.arr);
						} 
                     } 

					bl_cust_total = bl_cust_total + bl_doctor_amt;
					bl_doctor_total =  bl_doctor_total + bl_doctor_amt;
					bl_grand_total = bl_grand_total + bl_doctor_amt;
					

				}

        strcpy(physician_id.arr,bl_physician_id.arr);
		strcpy(customer_code.arr,bl_customer.arr);
   
   }/* end of while  fetch cur*/
 
  
   if (l_counter != 0)
   {
      
	
   
      if (strcmp(nd_report_option.arr , "D") == 0)
	  {
	      print_customer_total();
	      print_doctor_total();
		  fprintf(fp,"                                                       GRAND TOTAL     =       ");
		  print_formated1(bl_grand_total);
		  fprintf(fp,"\n");
		  fprintf(fp,"-----------------------------------------------------------------------------------------------\n");
	 }
	 else
	 {
		print_customer_total();
	    print_doctor_total();
		fprintf(fp,"                                                     GRAND TOTAL             ");
		print_formated1(bl_grand_total);
		fprintf(fp,"\n");
		fprintf(fp,"-----------------------------------------------------------------------------------------------\n");
		  

	 }


   }
  

   end_of_rep();

   fclose(fp);
   //end_prog_msg();

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


   if (OERROR)
	 err_mesg("COMMIT WORK RELEASE failed",0,"");

   return;
}

fetch_prog_param()
{

	nd_fr_serv_date.arr[0]		= '\0';
  	nd_to_serv_date.arr[0]		= '\0';
	nd_fr_empl_code.arr[0]		= '\0';
	nd_to_empl_code.arr[0]		= '\0';
	nd_fr_phy_id.arr[0]			= '\0';
	nd_to_phy_id.arr[0]			= '\0';
	nd_fr_cust_code.arr[0]		= '\0';
	nd_to_cust_code.arr[0]		= '\0';
	nd_selection_option.arr[0]	= '\0';
	nd_report_option.arr[0]		= '\0';
	d_facility_id.arr[0]		= '\0';


	nd_fr_serv_date.len			= 0;
  	nd_to_serv_date.len			= 0;
	nd_fr_empl_code.len			= 0;
	nd_to_empl_code.len			= 0;
	nd_fr_phy_id.len			= 0;
	nd_to_phy_id.len			= 0;
	nd_fr_cust_code.len			= 0;
	nd_to_cust_code.len			= 0;
	nd_selection_option.len		= 0;
	nd_report_option.len		= 0;
	d_facility_id.len			= 0;


	

   /* EXEC SQL SELECT     	PARAM1,PARAM2,
                       	PARAM3,PARAM4,
                       	PARAM5,PARAM6,
                       	PARAM7,PARAM8,
                       	PARAM9,PARAM10,
						operating_facility_id
	       INTO      	:nd_fr_serv_date,
			     		:nd_to_serv_date,
						:nd_fr_empl_code,
						:nd_to_empl_code,
						:nd_fr_phy_id,
						:nd_to_phy_id,
						:nd_fr_cust_code,
						:nd_to_cust_code,
						:nd_selection_option,
						:nd_report_option,
						:d_facility_id
	     FROM SY_PROG_PARAM
	     WHERE PGM_ID     = :d_curr_pgm_name
	       AND SESSION_ID = :nd_session_id
	       AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 ,PARAM5 ,PARAM6 ,PAR\
AM7 ,PARAM8 ,PARAM9 ,PARAM10 ,operating_facility_id into :b0,:b1,:b2,:b3,:b4,:\
b5,:b6,:b7,:b8,:b9,:b10  from SY_PROG_PARAM where ((PGM_ID=:b11 and SESSION_ID\
=:b12) and PGM_DATE=:b13)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )51;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_fr_serv_date;
   sqlstm.sqhstl[0] = (unsigned int  )22;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_to_serv_date;
   sqlstm.sqhstl[1] = (unsigned int  )22;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_fr_empl_code;
   sqlstm.sqhstl[2] = (unsigned int  )11;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_to_empl_code;
   sqlstm.sqhstl[3] = (unsigned int  )11;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_fr_phy_id;
   sqlstm.sqhstl[4] = (unsigned int  )18;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_to_phy_id;
   sqlstm.sqhstl[5] = (unsigned int  )18;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_fr_cust_code;
   sqlstm.sqhstl[6] = (unsigned int  )11;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_to_cust_code;
   sqlstm.sqhstl[7] = (unsigned int  )11;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_selection_option;
   sqlstm.sqhstl[8] = (unsigned int  )4;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_report_option;
   sqlstm.sqhstl[9] = (unsigned int  )4;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&d_facility_id;
   sqlstm.sqhstl[10] = (unsigned int  )12;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&d_curr_pgm_name;
   sqlstm.sqhstl[11] = (unsigned int  )17;
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
   sqlstm.sqhstl[13] = (unsigned int  )27;
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
		err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   if (NOT_FOUND)
		err_mesg("No Record found in SY_PROG_PARAM",0,"");

    
	nd_fr_serv_date.arr[nd_fr_serv_date.len]		= '\0';
  	nd_to_serv_date.arr[nd_to_serv_date.len]		= '\0';
	nd_fr_empl_code.arr[nd_fr_empl_code.len]		= '\0';
	nd_to_empl_code.arr[nd_to_empl_code.len]		= '\0';
	nd_fr_phy_id.arr[nd_fr_phy_id.len]				= '\0';
	nd_to_phy_id.arr[nd_to_phy_id.len]				= '\0';
	nd_fr_cust_code.arr[nd_fr_cust_code.len]		= '\0';
	nd_to_cust_code.arr[nd_to_cust_code.len]		= '\0';
	nd_selection_option.arr[nd_selection_option.len]	= '\0';
	nd_report_option.arr[nd_report_option.len]		= '\0';
	d_facility_id.arr[d_facility_id.len]			= '\0';
	strcpy(g_facility_id,d_facility_id.arr);

   /* EXEC SQL DELETE SY_PROG_PARAM
	     WHERE PGM_ID     = :d_curr_pgm_name
	       AND SESSION_ID = :nd_session_id
	       AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID=:b0 and SESSION\
_ID=:b1) and PGM_DATE=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )122;
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

declare_cur()
{

  /* EXEC SQL DECLARE BL_CUR CURSOR FOR	   
		  SELECT	A.CUST_CODE ORGANIZATION, 
				B.PHYSICIAN_ID, 
				B.CUST_CODE CUSTOMER,
				B.PATIENT_ID, 
				B.PRT_GRP_HDR_CODE,
				B.PRT_GRP_LINE_CODE,
				B.CHARGE_TYPE_CODE,
				B.DF_PHYSICIAN_ID,
				B.BLNG_SERV_CODE, 
				to_char(B.SERVICE_DATE, 'dd/mm/yyyy'),
				B.BILL_DOC_TYPE_CODE, 
				B.BILL_DOC_NUM, 
				to_char(B.BILL_DOC_DATE, 'dd/mm/yyyy'),
				NVL(B.UPD_NET_CHARGE_AMT,0) DOCTOR_AMT,
				NVL(B.BILL_LEVEL_DISC_DSTRBTN_AMT,0),
				NVL(B.LINE_LEVEL_DISC_DSTRBTN_AMT,0)
		FROM		BL_PHYSICIANS_FOR_EMPLOYER A, BL_PATIENT_CHARGES_FOLIO B
		WHERE		B.operating_facility_id = :d_facility_id
		AND		B.PHYSICIAN_ID = A.PHYSICIAN_ID(+)
		AND		TRUNC(B.SERVICE_DATE) between to_date(NVL(:nd_fr_serv_date,'01/01/1000'),'DD/MM/YYYY')  and 
				                           to_date(NVL(:nd_to_serv_date,'01/01/3000'),'DD/MM/YYYY') 
		AND		NVL(A.CUST_CODE,'!!!!!!!!')    BETWEEN NVL(:nd_fr_empl_code,'!!!!!!!!')         and 
										   NVL(:nd_to_empl_code,'~~~~~~~~')
		AND		NVL(B.CUST_CODE,'!!!!!!!!')    BETWEEN NVL(:nd_fr_cust_code,'!!!!!!!!')         and 
										   NVL(:nd_to_cust_code,'~~~~~~~~')
		AND		B.PHYSICIAN_ID BETWEEN NVL(:nd_fr_phy_id,'!!!!!!!!!!!!!!!')         and 
										   NVL(:nd_to_phy_id,'~~~~~~~~~~~~~~~')
		AND		B.BLNG_GRP_ID IN (SELECT C.BLNG_GRP_ID 
				FROM BL_BLNG_GRP C
				WHERE	(C.SETTLEMENT_IND = 'C' AND :nd_selection_option = 'C')
				OR		(C.SETTLEMENT_IND = 'R' AND :nd_selection_option = 'R')
						OR		(C.SETTLEMENT_IND = 'X' AND C.ADM_REC_FLAG = '1' AND :nd_selection_option = 'R')
						OR		(C.SETTLEMENT_IND = 'X' AND C.ADM_REC_FLAG = '2' AND :nd_selection_option = 'I')
						OR		(:nd_selection_option      = 'A')
								)
		AND			B.DF_SERVICE_IND IN ('Y'  ,'D')
		order by 2 ,3; */ 


     
}

open_cur()
{
	  /* EXEC SQL OPEN BL_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlbuft((void **)0, 
     "select A.CUST_CODE ORGANIZATION ,B.PHYSICIAN_ID ,B.CUST_CODE CUSTOMER \
,B.PATIENT_ID ,B.PRT_GRP_HDR_CODE ,B.PRT_GRP_LINE_CODE ,B.CHARGE_TYPE_CODE ,\
B.DF_PHYSICIAN_ID ,B.BLNG_SERV_CODE ,to_char(B.SERVICE_DATE,'dd/mm/yyyy') ,B\
.BILL_DOC_TYPE_CODE ,B.BILL_DOC_NUM ,to_char(B.BILL_DOC_DATE,'dd/mm/yyyy') ,\
NVL(B.UPD_NET_CHARGE_AMT,0) DOCTOR_AMT ,NVL(B.BILL_LEVEL_DISC_DSTRBTN_AMT,0)\
 ,NVL(B.LINE_LEVEL_DISC_DSTRBTN_AMT,0)  from BL_PHYSICIANS_FOR_EMPLOYER A ,B\
L_PATIENT_CHARGES_FOLIO B where (((((((B.operating_facility_id=:b0 and B.PHY\
SICIAN_ID=A.PHYSICIAN_ID(+)) and TRUNC(B.SERVICE_DATE) between to_date(NVL(:\
b1,'01/01/1000'),'DD/MM/YYYY') and to_date(NVL(:b2,'01/01/3000'),'DD/MM/YYYY\
')) and NVL(A.CUST_CODE,'!!!!!!!!') between NVL(:b3,'!!!!!!!!') and NVL(:b4,\
'~~~~~~~~')) and NVL(B.CUST_CODE,'!!!!!!!!') between NVL(:b5,'!!!!!!!!') and\
 NVL(:b6,'~~~~~~~~')) and B.PHYSICIAN_ID between NVL(:b7,'!!!!!!!!!!!!!!!') \
and NVL(:b8,'~~~~~~~~~~~~~~~')) and B.BLNG_GRP_ID in (select C.BLNG_GRP_ID  \
from BL_BLNG_GRP C where (((((C.SETTLEMENT");
   sqlstm.stmt = sq0005;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )149;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )12;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_fr_serv_date;
   sqlstm.sqhstl[1] = (unsigned int  )22;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_to_serv_date;
   sqlstm.sqhstl[2] = (unsigned int  )22;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_fr_empl_code;
   sqlstm.sqhstl[3] = (unsigned int  )11;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_to_empl_code;
   sqlstm.sqhstl[4] = (unsigned int  )11;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_fr_cust_code;
   sqlstm.sqhstl[5] = (unsigned int  )11;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_to_cust_code;
   sqlstm.sqhstl[6] = (unsigned int  )11;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_fr_phy_id;
   sqlstm.sqhstl[7] = (unsigned int  )18;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_to_phy_id;
   sqlstm.sqhstl[8] = (unsigned int  )18;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_selection_option;
   sqlstm.sqhstl[9] = (unsigned int  )4;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_selection_option;
   sqlstm.sqhstl[10] = (unsigned int  )4;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&nd_selection_option;
   sqlstm.sqhstl[11] = (unsigned int  )4;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&nd_selection_option;
   sqlstm.sqhstl[12] = (unsigned int  )4;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&nd_selection_option;
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
			err_mesg("OPEN failed on cursor BL_CUR",0,"");
}

fetch_cur()
{
	bl_org_customer.arr[0]			= '\0';
	bl_physician_id.arr[0]			= '\0';
	bl_customer.arr[0]			= '\0';
	bl_patient_id.arr[0]			= '\0';
	bl_prt_grp_hdr_code.arr[0]		= '\0';
	bl_prt_grp_line_code.arr[0]		= '\0';
	bl_charge_type_code.arr[0]		= '\0';
	bl_df_physician_id.arr[0]		= '\0';
	bl_blng_serv_code.arr[0]		= '\0';
	bl_blng_serv_date.arr[0]		= '\0';
	bl_bill_doc_type_code.arr[0]		= '\0';
	bl_bill_doc_type_num.arr[0]		= '\0';
	bl_bill_doc_date.arr[0]			= '\0';
	
	bl_org_customer.len			= 0;
	bl_physician_id.len			= 0;
	bl_customer.len				= 0;
	bl_patient_id.len			= 0;
	bl_prt_grp_hdr_code.len			= 0;
	bl_prt_grp_line_code.len		= 0;
	bl_charge_type_code.len			= 0;
	bl_df_physician_id.len			= 0;
	bl_blng_serv_code.len			= 0;
	bl_blng_serv_date.len			= 0;
	bl_bill_doc_type_code.len		= 0;
	bl_bill_doc_type_num.len		= 0;
	bl_bill_doc_date.len			= 0;

	bl_doctor_amt = 0.0;
	bl_bill_level_disc_amt = 0.0;
	bl_line_level_disc_amt = 0.0;

     /* EXEC SQL FETCH BL_CUR
	       INTO :bl_org_customer,
		:bl_physician_id,
		:bl_customer,
		:bl_patient_id,
		:bl_prt_grp_hdr_code,
		:bl_prt_grp_line_code,
		:bl_charge_type_code,
		:bl_df_physician_id,
		:bl_blng_serv_code,
		:bl_blng_serv_date,
		:bl_bill_doc_type_code,
		:bl_bill_doc_type_num,
		:bl_bill_doc_date,
		:bl_doctor_amt,
		:bl_bill_level_disc_amt,
		:bl_line_level_disc_amt; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 16;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )220;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_org_customer;
     sqlstm.sqhstl[0] = (unsigned int  )11;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&bl_physician_id;
     sqlstm.sqhstl[1] = (unsigned int  )18;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&bl_customer;
     sqlstm.sqhstl[2] = (unsigned int  )11;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&bl_patient_id;
     sqlstm.sqhstl[3] = (unsigned int  )23;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&bl_prt_grp_hdr_code;
     sqlstm.sqhstl[4] = (unsigned int  )5;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&bl_prt_grp_line_code;
     sqlstm.sqhstl[5] = (unsigned int  )5;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&bl_charge_type_code;
     sqlstm.sqhstl[6] = (unsigned int  )4;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&bl_df_physician_id;
     sqlstm.sqhstl[7] = (unsigned int  )18;
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&bl_blng_serv_code;
     sqlstm.sqhstl[8] = (unsigned int  )13;
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&bl_blng_serv_date;
     sqlstm.sqhstl[9] = (unsigned int  )22;
     sqlstm.sqhsts[9] = (         int  )0;
     sqlstm.sqindv[9] = (         void  *)0;
     sqlstm.sqinds[9] = (         int  )0;
     sqlstm.sqharm[9] = (unsigned int  )0;
     sqlstm.sqadto[9] = (unsigned short )0;
     sqlstm.sqtdso[9] = (unsigned short )0;
     sqlstm.sqhstv[10] = (         void  *)&bl_bill_doc_type_code;
     sqlstm.sqhstl[10] = (unsigned int  )9;
     sqlstm.sqhsts[10] = (         int  )0;
     sqlstm.sqindv[10] = (         void  *)0;
     sqlstm.sqinds[10] = (         int  )0;
     sqlstm.sqharm[10] = (unsigned int  )0;
     sqlstm.sqadto[10] = (unsigned short )0;
     sqlstm.sqtdso[10] = (unsigned short )0;
     sqlstm.sqhstv[11] = (         void  *)&bl_bill_doc_type_num;
     sqlstm.sqhstl[11] = (unsigned int  )11;
     sqlstm.sqhsts[11] = (         int  )0;
     sqlstm.sqindv[11] = (         void  *)0;
     sqlstm.sqinds[11] = (         int  )0;
     sqlstm.sqharm[11] = (unsigned int  )0;
     sqlstm.sqadto[11] = (unsigned short )0;
     sqlstm.sqtdso[11] = (unsigned short )0;
     sqlstm.sqhstv[12] = (         void  *)&bl_bill_doc_date;
     sqlstm.sqhstl[12] = (unsigned int  )22;
     sqlstm.sqhsts[12] = (         int  )0;
     sqlstm.sqindv[12] = (         void  *)0;
     sqlstm.sqinds[12] = (         int  )0;
     sqlstm.sqharm[12] = (unsigned int  )0;
     sqlstm.sqadto[12] = (unsigned short )0;
     sqlstm.sqtdso[12] = (unsigned short )0;
     sqlstm.sqhstv[13] = (         void  *)&bl_doctor_amt;
     sqlstm.sqhstl[13] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[13] = (         int  )0;
     sqlstm.sqindv[13] = (         void  *)0;
     sqlstm.sqinds[13] = (         int  )0;
     sqlstm.sqharm[13] = (unsigned int  )0;
     sqlstm.sqadto[13] = (unsigned short )0;
     sqlstm.sqtdso[13] = (unsigned short )0;
     sqlstm.sqhstv[14] = (         void  *)&bl_bill_level_disc_amt;
     sqlstm.sqhstl[14] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[14] = (         int  )0;
     sqlstm.sqindv[14] = (         void  *)0;
     sqlstm.sqinds[14] = (         int  )0;
     sqlstm.sqharm[14] = (unsigned int  )0;
     sqlstm.sqadto[14] = (unsigned short )0;
     sqlstm.sqtdso[14] = (unsigned short )0;
     sqlstm.sqhstv[15] = (         void  *)&bl_line_level_disc_amt;
     sqlstm.sqhstl[15] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[15] = (         int  )0;
     sqlstm.sqindv[15] = (         void  *)0;
     sqlstm.sqinds[15] = (         int  )0;
     sqlstm.sqharm[15] = (unsigned int  )0;
     sqlstm.sqadto[15] = (unsigned short )0;
     sqlstm.sqtdso[15] = (unsigned short )0;
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
			err_mesg("FETCH failed on cursor BL_CUR",0,"");
     
      if(LAST_ROW)
	  {
		 
		return 0;
	  }



	bl_org_customer.arr[bl_org_customer.len]				= '\0';
	bl_physician_id.arr[bl_physician_id.len]				= '\0';
	bl_customer.arr[bl_customer.len]						= '\0';
	bl_patient_id.arr[bl_patient_id.len]					= '\0';
	bl_prt_grp_hdr_code.arr[bl_prt_grp_hdr_code.len]		= '\0';
	bl_prt_grp_line_code.arr[bl_prt_grp_line_code.len]		= '\0';
	bl_charge_type_code.arr[bl_charge_type_code.len]		= '\0';
	bl_df_physician_id.arr[bl_df_physician_id.len]			= '\0';
	bl_blng_serv_code.arr[bl_blng_serv_code.len]			= '\0';
	bl_blng_serv_date.arr[bl_blng_serv_date.len]			= '\0';
	bl_bill_doc_type_code.arr[bl_bill_doc_type_code.len]	= '\0';
	bl_bill_doc_type_num.arr[bl_bill_doc_type_num.len]		= '\0';
	bl_bill_doc_date.arr[bl_bill_doc_date.len]				= '\0';
	

	if ((bl_bill_level_disc_amt + bl_line_level_disc_amt) > bl_doctor_amt  && bl_doctor_amt > 0)
	   bl_doctor_amt = 0;
	else
	   bl_doctor_amt = bl_doctor_amt - bl_bill_level_disc_amt - bl_line_level_disc_amt;

	

	

    l_counter = l_counter + 1;

    if (l_counter == 1 )
	{
	    strcpy(physician_id.arr,bl_physician_id.arr);
		strcpy(customer_code.arr,bl_customer.arr);
	}


      
   return 1;

 	
}


open_file()
{

  strcpy(g_facility_id, d_facility_id.arr);

   strcpy(filename,WORKING_DIR);
   strcat(filename,"blrdfslt.lis");

       if ((fp = fopen(filename,"w")) == NULL)
    {
       disp_message(ERR_MESG,"Error in opening file blrdfslt.lis");
       proc_exit();
    }
    if (strcmp(nd_report_option.arr , "D") == 0)
	{
		print_title_dtl();  
		print_head_dtl();
	}
	else
	{
		print_title_summary();  
		print_head_summary();
	}

}


print_customer_total()
{

   if (strcmp(nd_report_option.arr , "D") == 0)
   {
		fprintf(fp , "                                                       CUSTOMER TOTAL  =       ");
		print_formated1(bl_cust_total);
		fprintf(fp,"\n\n");
   }
   else
   {
    	fprintf(fp , "                ");
		print_formated1(bl_cust_total);
		fprintf(fp,"\n");

   }
		
		bl_cust_total = 0.0;
}



print_customer_code()
{

	get_customer_name();

	fprintf(fp,"CUSTOMER CODE :  ");
	
	if (bl_customer.arr[0] == '\0') 
	{
		fprintf(fp,"PRIVATE -- CASH PATIENT");
		fprintf(fp , "\n");
	}
	else
	{
		fprintf(fp,"%-8s %-15s\n", bl_customer.arr ,nd_customer_name.arr);
	}

}

print_doctor_total()
{

    if (strcmp(nd_report_option.arr , "D") == 0)
	{
		fprintf(fp,"-----------------------------------------------------------------------------------------------\n");
		fprintf(fp , "                                                       DOCTOR TOTAL    =       ");
		print_formated1(bl_doctor_total);
		fprintf(fp,"\n\n");
		fprintf(fp,"-----------------------------------------------------------------------------------------------\n");
	}
	else
	{
		fprintf(fp,"                                                    -------------------------------------------\n");
		fprintf(fp , "                                                     DOCTOR TOTAL            ");
		print_formated1(bl_doctor_total);
		fprintf(fp,"\n");
		fprintf(fp,"                                                    -------------------------------------------\n");			
	}



	bl_doctor_total = 0.0;

}


print_doctor_code()
{

	fprintf(fp,"DOCTOR CODE   :  ");
	select_phys_name();
	fprintf(fp,"%-15s %-30s\n",bl_physician_id.arr,nd_phys_name.arr);

}

print_details()

{
  

     if (lctr > 60)
	    print_head_dtl();


		fprintf(fp, "%-20s  ",bl_patient_id.arr);
		fprintf(fp, "%-10s    ",bl_blng_serv_code.arr);
		fprintf(fp, "%-10s    ",bl_blng_serv_date.arr);
		
		if ((bl_bill_doc_type_code.arr[0] != '\0') && (bl_bill_doc_type_num.arr[0] != '\0'))
		  fprintf(fp, "%-6s/%-8s  ",bl_bill_doc_type_code.arr , bl_bill_doc_type_num.arr);
		else
		 fprintf(fp, "                 ");


  
		fprintf(fp, "%-10s  ", bl_bill_doc_date.arr);
		print_formated1(bl_doctor_amt);
		fprintf(fp , "\n");

	
	  

	  
	  
    lctr++;



	
   fflush(fp);
}





select_phys_name()
{
	nd_phys_name.arr[0] = '\0';
	nd_phys_name.len    = 0;
	

	/* EXEC SQL SELECT	 FULL_NAME into :nd_phys_name
			 FROM     SY_PHYSICIAN_MAST
			 WHERE   PHYSICIAN_ID    = :bl_physician_id
			   AND   facility_id     = :d_facility_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 16;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select FULL_NAME into :b0  from SY_PHYSICIAN_MAST where (PHY\
SICIAN_ID=:b1 and facility_id=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )299;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_phys_name;
 sqlstm.sqhstl[0] = (unsigned int  )33;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&bl_physician_id;
 sqlstm.sqhstl[1] = (unsigned int  )18;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_facility_id;
 sqlstm.sqhstl[2] = (unsigned int  )12;
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
	    err_mesg("SELECT failed on table   SY_PHYSICIAN_MAST",0,"");

nd_phys_name.arr[nd_phys_name.len]           = '\0';

}

get_customer_name()
{

	nd_customer_name.arr[0] = '\0';
	nd_customer_name.len    = 0;
	

	/* EXEC SQL SELECT	 SHORT_NAME into :nd_customer_name
			 FROM     AR_CUSTOMER
			 WHERE   CUST_CODE    = :bl_customer; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 16;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select SHORT_NAME into :b0  from AR_CUSTOMER where CUST_CODE\
=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )326;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_customer_name;
 sqlstm.sqhstl[0] = (unsigned int  )18;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&bl_customer;
 sqlstm.sqhstl[1] = (unsigned int  )11;
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
	    err_mesg("SELECT failed on table   AR_CUSTOMER",0,"");

nd_customer_name.arr[nd_customer_name.len]           = '\0';


}


end_of_rep()
{
fprintf(fp,"\n\n                                      ***  END OF REPORT ***\n");
fflush(fp);
}


/***** Printing of the Title    **********/

print_title_dtl()
{
fprintf(fp,
"\fMDL : BL                       %-30s                  %-16s\n",
hosp_name.arr,date_time.arr);
fprintf(fp,"OPR : %-10s \n", user_id.arr);
fprintf(fp,
"REP : %-8s       %s               PAGE : %4d\n",
"BLRDFSLT"," DOCTOR CHARGE  BY SETTLEMENT/CUSTOMER -- DETAIL",++pctr);



fprintf(fp,
"-----------------------------------------------------------------------------------------------\n");
fprintf(fp,"VER : 4.1\n");
fflush(fp);


fprintf(fp,"\n\n\n\n        INPUT PARAMETERS :\n        ----------------\n\n");



fprintf(fp,"                 SERVICE DATE      FROM : %s\n",strcmp(nd_fr_serv_date.arr , "01/01/1000")?nd_fr_serv_date.arr:"LOWEST");
fprintf(fp,"                                   TO   : %s\n\n",strcmp(nd_to_serv_date.arr , "01/01/3000")?nd_to_serv_date.arr:"HIGHEST");


fprintf(fp,"              DOCTOR EMPLOYER      FROM : %s\n",strcmp(nd_fr_empl_code.arr,"!!!!!!!!")?nd_fr_empl_code.arr:"LOWEST");
fprintf(fp,"                                   TO   : %s\n\n",strcmp(nd_to_empl_code.arr,"~~~~~~~~")?nd_to_empl_code.arr:"HIGHEST");



fprintf(fp,"                 DOCTOR ID         FROM : %s\n",strcmp(nd_fr_phy_id.arr,"!!!!!!!!!!!!!!!")?nd_fr_phy_id.arr:"LOWEST");
fprintf(fp,"                                   TO   : %s\n\n",strcmp(nd_to_phy_id.arr,"~~~~~~~~~~~~~~~")?nd_to_phy_id.arr:"HIGHEST");


fprintf(fp,"                 CUSTOMER CODE     FROM : %s\n",strcmp(nd_fr_cust_code.arr,"!!!!!!!!")?nd_fr_cust_code.arr:"LOWEST");
fprintf(fp,"                                   TO   : %s\n\n",strcmp(nd_to_cust_code.arr,"~~~~~~~~")?nd_to_cust_code.arr:"HIGHEST");


if  (strcmp(nd_selection_option.arr, "C") == 0)
	fprintf(fp,"                 SETTLEMENT OPTION      :CASH PATIENT\n");
else if (strcmp(nd_selection_option.arr, "R") == 0)
	fprintf(fp,"                 SETTLEMENT OPTION      :CREDIT PATIENT\n");
else if (strcmp(nd_selection_option.arr, "I") == 0)
	fprintf(fp,"                 SETTLEMENT OPTION      :INSURANCE PATIENT\n");
else
	fprintf(fp,"                 SETTLEMENT OPTION      :ALL PATIENT\n");


}


print_title_summary()
{
fprintf(fp,
"\fMDL : BL                       %-30s                  %-16s\n",
hosp_name.arr,date_time.arr);
fprintf(fp,"OPR : %-10s \n", user_id.arr);
fprintf(fp,
"REP : %-8s       %s              PAGE : %4d\n",
"BLRDFSLT"," DOCTOR CHARGE  BY SETTLEMENT/CUSTOMER -- SUMMARY",++pctr);



fprintf(fp,
"-----------------------------------------------------------------------------------------------\n");
fprintf(fp,"VER : 4.1\n");
fflush(fp);


fprintf(fp,"\n\n\n\n        INPUT PARAMETERS :\n        ----------------\n\n");



fprintf(fp,"                 SERVICE DATE      FROM : %s\n",strcmp(nd_fr_serv_date.arr , "01/01/1000")?nd_fr_serv_date.arr:"LOWEST");
fprintf(fp,"                                   TO   : %s\n\n",strcmp(nd_to_serv_date.arr , "01/01/3000")?nd_to_serv_date.arr:"HIGHEST");


fprintf(fp,"              DOCTOR EMPLOYER      FROM : %s\n",strcmp(nd_fr_empl_code.arr,"!!!!!!!!")?nd_fr_empl_code.arr:"LOWEST");
fprintf(fp,"                                   TO   : %s\n\n",strcmp(nd_to_empl_code.arr,"~~~~~~~~")?nd_to_empl_code.arr:"HIGHEST");



fprintf(fp,"                 DOCTOR ID         FROM : %s\n",strcmp(nd_fr_phy_id.arr,"!!!!!!!!!!!!!!!")?nd_fr_phy_id.arr:"LOWEST");
fprintf(fp,"                                   TO   : %s\n\n",strcmp(nd_to_phy_id.arr,"~~~~~~~~~~~~~~~")?nd_to_phy_id.arr:"HIGHEST");


fprintf(fp,"                 CUSTOMER CODE     FROM : %s\n",strcmp(nd_fr_cust_code.arr,"!!!!!!!!")?nd_fr_cust_code.arr:"LOWEST");
fprintf(fp,"                                   TO   : %s\n\n",strcmp(nd_to_cust_code.arr,"~~~~~~~~")?nd_to_cust_code.arr:"HIGHEST");


if  (strcmp(nd_selection_option.arr, "C") == 0)
	fprintf(fp,"                 SETTLEMENT OPTION      :CASH PATIENT\n");
else if (strcmp(nd_selection_option.arr, "R") == 0)
	fprintf(fp,"                 SETTLEMENT OPTION      :CREDIT PATIENT\n");
else if (strcmp(nd_selection_option.arr, "I") == 0)
	fprintf(fp,"                 SETTLEMENT OPTION      :INSURANCE PATIENT\n");
else
	fprintf(fp,"                 SETTLEMENT OPTION      :ALL PATIENT\n");


}

  

/***** Printing of the Header    **********/

print_head_dtl()
{
fprintf(fp,
"\fMDL : BL                       %-30s                  %-16s\n",
hosp_name.arr,date_time.arr);

fprintf(fp,"OPR : %-10s \n", user_id.arr);
fprintf(fp,
"REP : %-8s       %s               PAGE : %4d\n",
"BLRDFSLT"," DOCTOR CHARGE  BY SETTLEMENT/CUSTOMER -- DETAIL",++pctr);


fprintf(fp,"-----------------------------------------------------------------------------------------------\n");

fprintf(fp, "PATIENT ID            SERVICE CODE  SERVICE DATE  BILL NO          BILL DATE      DOCTOR AMOUNT\n");

fprintf(fp,"-----------------------------------------------------------------------------------------------\n");
fflush(fp);
lctr = 13;
}

print_head_summary()
{
fprintf(fp,
"\fMDL : BL                       %-30s                 %-16s\n",
hosp_name.arr,date_time.arr);

fprintf(fp,"OPR : %-10s \n", user_id.arr);
fprintf(fp,
"REP : %-8s       %s             PAGE : %4d\n",
"BLRDFSLT"," DOCTOR CHARGE  BY SETTLEMENT/CUSTOMER -- SUMMARY",++pctr);
fprintf(fp,"-----------------------------------------------------------------------------------------------\n");
fprintf(fp,"DOCTOR                               CUSTOMER                                        AMOUNT\n");
fprintf(fp,"-----------------------------------------------------------------------------------------------\n");
fflush(fp);
lctr = 13;
}


fetch_hosp_name()
{
    hosp_name.arr[0] = '\0';
    date_time.arr[0] = '\0';
    user_id.arr[0]   = '\0';
    hosp_name.len    = 0;
    date_time.len    = 0;
    user_id.len      = 0;

    /* EXEC SQL SELECT ACC_ENTITY_NAME, TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
		    USER
	     INTO :hosp_name, :date_time, :user_id
	     FROM SY_ACC_ENTITY
		WHERE acc_entity_id = :d_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 16;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:\
MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY where acc_entity_id=:b3";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )349;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
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
}



       if (OERROR) err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");

hosp_name.arr[hosp_name.len]           = '\0';
date_time.arr[date_time.len]           = '\0';
user_id.arr[user_id.len]               = '\0';
}


print_formated(loc_amount)
double loc_amount;
{
   char out_str[30],out_str1[30];

   if (loc_amount >= 0)
   {
      /*sprintf(out_str,"%15.2f",loc_amount);  
      //ltrim(out_str);
	  str_comma(out_str);
      sprintf(out_str1,"%25s",out_str);*/

      put_val(out_str1,loc_amount);
      format_amt(out_str1);

      fprintf(fp,"%25s ",out_str1);
   }
   else
   {
      /*sprintf(out_str,"%15.2f",-loc_amount);
      //ltrim(out_str);
	  str_comma(out_str);
      sprintf(out_str1,"%25s",out_str);*/

      put_val(out_str1,-loc_amount);
      format_amt(out_str1);

      fprintf(fp,"%25s-",out_str1);
   }
}

print_formated1(loc_amount)
double loc_amount;
{
   char out_str[30],out_str1[30];

   if (loc_amount >= 0)
   {
      /*sprintf(out_str,"%15.2f",loc_amount);
      //ltrim(out_str);
	  str_comma(out_str);
      sprintf(out_str1,"%15s",out_str);*/

      put_val(out_str1,loc_amount);
      format_amt(out_str1);

      fprintf(fp,"%15s ",out_str1);
   }
   else
   {
      /*sprintf(out_str,"%15.2f",-loc_amount);
      //ltrim(out_str);
	  str_comma(out_str);
      sprintf(out_str1,"%15s",out_str);*/

      put_val(out_str1,-loc_amount);
      format_amt(out_str1);

      //fprintf(fp,"%15s-",out_str1);
	  fprintf(fp,"%15sCR",out_str1);
   }
}
