
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
           char  filnam[25];
};
static const struct sqlcxp sqlfpn =
{
    24,
    "d:\\speclabel\\btralcbu.pc"
};


static unsigned long sqlctx = 1171883587;


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
            void  *sqhstv[9];
   unsigned int   sqhstl[9];
            int   sqhsts[9];
            void  *sqindv[9];
            int   sqinds[9];
   unsigned int   sqharm[9];
   unsigned int   *sqharc[9];
   unsigned short  sqadto[9];
   unsigned short  sqtdso[9];
} sqlstm = {10,9};

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

 static const char *sq0010 = 
"select A.unit_no ,A.product_code ,((B.blood_group||' ')||B.rhesus_code) dono\
r_type ,((C.blood_group||' ')||C.rhesus_code) patient_type ,B.process_code ,D.\
process_desc ,TO_CHAR(B.expiry_date,'DD-MON-YYYY HH24:MI') ,A.issued_by  from \
bt_unit_request_dtl A ,bt_blood_units_mast B ,bt_patient_blgrp_rh_ant C ,(sele\
ct process_code ,SUBSTR(long_desc,1,40) process_desc  from bt_process_code_lan\
g_vw where language_id=:b0) D ,bt_unit_status E where ((((((((((A.specimen_no=\
:b1 and A.unit_no=B.unit_no) and A.product_code=B.product_code) and A.unit_sta\
tus=DECODE(:b2,'A','UA','R','UR','I','UI','T','UT',A.unit_status)) and A.opera\
ting_facility_id=B.operating_facility_id) and A.unit_no=:b3) and A.operating_f\
acility_id=:b4) and A.patient_id=C.patient_id) and B.process_code=D.process_co\
de(+)) and A.unit_status=E.unit_status_code) and E.active_status_yn='Y') order\
 by A.unit_no            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,273,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,75,0,4,285,0,0,2,1,0,1,0,1,9,0,0,2,9,0,0,
59,0,0,3,207,0,6,291,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
86,0,0,4,62,0,4,312,0,0,2,1,0,1,0,1,9,0,0,2,9,0,0,
109,0,0,5,203,0,6,318,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
136,0,0,6,0,0,30,379,0,0,0,0,0,1,0,
151,0,0,7,0,0,30,390,0,0,0,0,0,1,0,
166,0,0,8,110,0,6,398,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
189,0,0,9,136,0,6,413,0,0,2,2,0,1,0,2,9,0,0,1,3,0,0,
212,0,0,10,881,0,9,476,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
247,0,0,11,190,0,4,493,0,0,5,4,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
282,0,0,12,219,0,6,507,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
309,0,0,10,0,0,13,572,0,0,8,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,
356,0,0,13,251,0,6,609,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
383,0,0,14,105,0,4,657,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
410,0,0,15,158,0,4,720,0,0,6,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,
9,0,0,
449,0,0,16,501,0,4,778,0,0,9,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
500,0,0,17,324,0,4,858,0,0,7,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,1,9,0,0,
543,0,0,18,162,0,4,907,0,0,3,1,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,
570,0,0,19,128,0,4,960,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
601,0,0,20,116,0,4,992,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
632,0,0,21,98,0,4,1024,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
659,0,0,22,100,0,4,1057,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
686,0,0,23,1007,0,6,1086,0,0,8,8,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,2,9,0,0,
733,0,0,24,172,0,4,1160,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
764,0,0,25,111,0,4,1254,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
787,0,0,26,123,0,4,1292,0,0,5,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
822,0,0,27,224,0,3,1692,0,0,3,3,0,1,0,1,9,0,0,1,3,0,0,1,9,0,0,
849,0,0,28,58,0,4,1708,0,0,1,0,0,1,0,2,9,0,0,
};


/************************************************************************************
*
*	Name				BTRALCBU.PC
*
*	Author			MEDICOM LIS Team, Muscat.
*
*	Purpose			To print BT Tag Labels.
*
*	Input Arguments
*   ==========================================================================
*	No. Argument									Remarks
*   ==========================================================================
*	1.  DB Connect String (User/Password@DBName)		Mandatory
*	2.  Session Id							Mandatory
*	3.  Facility ID							Mandatory
*	4.  Specimen Number						Mandatory
*	5.  Unit Number for Barcode					Mandatory
*	6.  Unit Number							Mandatory
*	7.  Unit status							Mandatory
*	8.  Tag type(X, E, C)						Mandatory
*	9.  Reserved By							Mandatory
*	10. Reserved Date							Mandatory
*	11. Issued Date							Mandatory
*	12. Work Station Number						Mandatory
*   ==========================================================================
*
*	Modification History  
*   ==========================================================================
*	Date		Person		Version	Remarks
*   ==========================================================================
*	23/06/2005	Sai Dutt	 	4.1		Created
*
************************************************************************************/


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
                  

/* VARCHAR 	uid_pwd                 	[42],     
		nd_source_type	      	[10],
		nd_fm_source	        	[30],
        	d_no_copy				[5],
		nd_trx_ind			    	[10],
		nd_printer_type         	[10],

		d_facility_name         	[500],

        	nd_facility_id			[30],
		nd_session_id           	[300],
            nd_specimen_no           	[301],
			nd_specimen_no_b           	[301],
        	nd_product_code          	[301], 
        	nd_unit_no_b          		[301], 
  	     	nd_unit_no          		[301], 
        	nd_unit_status          	[301], 
        	nd_tagtype          		[41], 
            nd_tagtype_desc        		[301], 
        	nd_reserved_by          	[301], 
        	nd_reserved_date          	[100], 
			nd_reserved_date1          	[100], 
			nd_reserved_time          	[100], 
        	nd_issued_date          	[100], 
			nd_issued_date1          	[100], 
        	ld_issued_by	          	[100], 
        	nd_xmatch_date          	[100], 
			nd_xmatch_date1          	[100], 
			nd_issued_time          	[100], 
			nd_printer_id				[1000],
			nd_facility_ind				[10],
			nd_report_group_id			[500],
        	nd_ws_no          			[301], 
			d_Cmd_Line                  [1001], 
			nd_reserv_issue_wsno        [501], 
			d_product_desc_temp           [301],
			d_product_code_temp           [200],
            ld_source_type                [100],
            ld_episode_type               [60],
            ld_source_code                [10],
            ld_woc_desc        		[500], 
        	ld_unit_no          		[200], 
        	ld_product_code          	[200], 
        	ld_patient_id          		[200], 
			ld_patient_name        		[500], 
			ld_first_half				[500],
			ld_second_half				[500],
        	
			
			ld_nric_alt_id_num         [500],//added by babu ML-SD-CRF-20227 
			ld_national_id_num         [500],//added by babu ML-SD-CRF-20227
			ld_alter_id                [500],//added by babu ML-SD-CRF-20227

			
			ld_donor_type          		[41], 
        	ld_patient_type          	[41], 

        	ld_process_code          	[100], 
        	ld_process_desc          	[301], 
        	ld_process_date          	[100], 
        	ld_process_date1          	[100], 
		 
        	ad_unit_no          		[500][300], 
        	ad_product_code          	[500][300], 
        	ad_product_desc          	[500][300], 
        	ad_patient_id          		[500][300], 
        	ad_donor_type          		[500][300], 
        	ad_patient_type          	[500][300], 
        	ad_issued_by        		[500][300], 
        	ad_process_code        		[500][300], 
        	ad_process_desc        		[500][300], 
        	ad_process_date1        	[500][300], 

		d_flag						    	[2],  
    
		er_msg                  [171], 
		l_licence_no           [40],/oAdded by nandhinio/

/o**************** variables added for label_cur cursor **********o/

		a_ws_no					[100],
		a_cmd_line_arg			[1001],
		a_rowid					[100],
		a_pgm_id				[100],

		l_translated_value		 [1001],/oAdded by nandhinio/
		language_id			[5],
/o**************** variables added for enhancement **********o/

//		nd_file_no			[300],
		nd_print_source_type	[20],
		nd_print_source		[20],
			l_comp_tag                  [501], 
            l_emerg_tag                 [501], 
			l_emerg_tag2                [501], 
            l_xmatch_tag                [501]; */ 
struct { unsigned short len; unsigned char arr[42]; } uid_pwd;

struct { unsigned short len; unsigned char arr[10]; } nd_source_type;

struct { unsigned short len; unsigned char arr[30]; } nd_fm_source;

struct { unsigned short len; unsigned char arr[5]; } d_no_copy;

struct { unsigned short len; unsigned char arr[10]; } nd_trx_ind;

struct { unsigned short len; unsigned char arr[10]; } nd_printer_type;

struct { unsigned short len; unsigned char arr[500]; } d_facility_name;

struct { unsigned short len; unsigned char arr[30]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[300]; } nd_session_id;

struct { unsigned short len; unsigned char arr[301]; } nd_specimen_no;

struct { unsigned short len; unsigned char arr[301]; } nd_specimen_no_b;

struct { unsigned short len; unsigned char arr[301]; } nd_product_code;

struct { unsigned short len; unsigned char arr[301]; } nd_unit_no_b;

struct { unsigned short len; unsigned char arr[301]; } nd_unit_no;

struct { unsigned short len; unsigned char arr[301]; } nd_unit_status;

struct { unsigned short len; unsigned char arr[41]; } nd_tagtype;

struct { unsigned short len; unsigned char arr[301]; } nd_tagtype_desc;

struct { unsigned short len; unsigned char arr[301]; } nd_reserved_by;

struct { unsigned short len; unsigned char arr[100]; } nd_reserved_date;

struct { unsigned short len; unsigned char arr[100]; } nd_reserved_date1;

struct { unsigned short len; unsigned char arr[100]; } nd_reserved_time;

struct { unsigned short len; unsigned char arr[100]; } nd_issued_date;

struct { unsigned short len; unsigned char arr[100]; } nd_issued_date1;

struct { unsigned short len; unsigned char arr[100]; } ld_issued_by;

struct { unsigned short len; unsigned char arr[100]; } nd_xmatch_date;

struct { unsigned short len; unsigned char arr[100]; } nd_xmatch_date1;

struct { unsigned short len; unsigned char arr[100]; } nd_issued_time;

struct { unsigned short len; unsigned char arr[1000]; } nd_printer_id;

struct { unsigned short len; unsigned char arr[10]; } nd_facility_ind;

struct { unsigned short len; unsigned char arr[500]; } nd_report_group_id;

struct { unsigned short len; unsigned char arr[301]; } nd_ws_no;

struct { unsigned short len; unsigned char arr[1001]; } d_Cmd_Line;

struct { unsigned short len; unsigned char arr[501]; } nd_reserv_issue_wsno;

struct { unsigned short len; unsigned char arr[301]; } d_product_desc_temp;

struct { unsigned short len; unsigned char arr[200]; } d_product_code_temp;

struct { unsigned short len; unsigned char arr[100]; } ld_source_type;

struct { unsigned short len; unsigned char arr[60]; } ld_episode_type;

struct { unsigned short len; unsigned char arr[10]; } ld_source_code;

struct { unsigned short len; unsigned char arr[500]; } ld_woc_desc;

struct { unsigned short len; unsigned char arr[200]; } ld_unit_no;

struct { unsigned short len; unsigned char arr[200]; } ld_product_code;

struct { unsigned short len; unsigned char arr[200]; } ld_patient_id;

struct { unsigned short len; unsigned char arr[500]; } ld_patient_name;

struct { unsigned short len; unsigned char arr[500]; } ld_first_half;

struct { unsigned short len; unsigned char arr[500]; } ld_second_half;

struct { unsigned short len; unsigned char arr[500]; } ld_nric_alt_id_num;

struct { unsigned short len; unsigned char arr[500]; } ld_national_id_num;

struct { unsigned short len; unsigned char arr[500]; } ld_alter_id;

struct { unsigned short len; unsigned char arr[41]; } ld_donor_type;

struct { unsigned short len; unsigned char arr[41]; } ld_patient_type;

struct { unsigned short len; unsigned char arr[100]; } ld_process_code;

struct { unsigned short len; unsigned char arr[301]; } ld_process_desc;

struct { unsigned short len; unsigned char arr[100]; } ld_process_date;

struct { unsigned short len; unsigned char arr[100]; } ld_process_date1;

struct { unsigned short len; unsigned char arr[302]; } ad_unit_no[500];

struct { unsigned short len; unsigned char arr[302]; } ad_product_code[500];

struct { unsigned short len; unsigned char arr[302]; } ad_product_desc[500];

struct { unsigned short len; unsigned char arr[302]; } ad_patient_id[500];

struct { unsigned short len; unsigned char arr[302]; } ad_donor_type[500];

struct { unsigned short len; unsigned char arr[302]; } ad_patient_type[500];

struct { unsigned short len; unsigned char arr[302]; } ad_issued_by[500];

struct { unsigned short len; unsigned char arr[302]; } ad_process_code[500];

struct { unsigned short len; unsigned char arr[302]; } ad_process_desc[500];

struct { unsigned short len; unsigned char arr[302]; } ad_process_date1[500];

struct { unsigned short len; unsigned char arr[2]; } d_flag;

struct { unsigned short len; unsigned char arr[171]; } er_msg;

struct { unsigned short len; unsigned char arr[40]; } l_licence_no;

struct { unsigned short len; unsigned char arr[100]; } a_ws_no;

struct { unsigned short len; unsigned char arr[1001]; } a_cmd_line_arg;

struct { unsigned short len; unsigned char arr[100]; } a_rowid;

struct { unsigned short len; unsigned char arr[100]; } a_pgm_id;

struct { unsigned short len; unsigned char arr[1001]; } l_translated_value;

struct { unsigned short len; unsigned char arr[5]; } language_id;

struct { unsigned short len; unsigned char arr[20]; } nd_print_source_type;

struct { unsigned short len; unsigned char arr[20]; } nd_print_source;

struct { unsigned short len; unsigned char arr[501]; } l_comp_tag;

struct { unsigned short len; unsigned char arr[501]; } l_emerg_tag;

struct { unsigned short len; unsigned char arr[501]; } l_emerg_tag2;

struct { unsigned short len; unsigned char arr[501]; } l_xmatch_tag;

		

  int         d_volume[500],
              nd_volume,
              d_tot_no_products,
	  		  h_no_of_rec = 0;


 int space_req = 0;
 char string_var[500];

/*tern  char WORKING_DIR_NAME [75];*/

  int er_msg_type = 0;	
  int err_flag = 0;
  
  char string_char[1000];
  int i;
  
  /* VARCHAR l_customer_id [50]; */ 
struct { unsigned short len; unsigned char arr[50]; } l_customer_id;
  /*-- Added By Gopikannan for GHL-CRF-315 For MEDICITY --*/
  	
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
FILE *fp;/*Added by nandhini*/

char filename[150];
char filename1[150];

char *command;  
char gtt_yn = 'N';


char local_legend[40][100];/*Added by nandhini*/
int qq = 0, cntr = 0, z = 0, hell = 0, clt = 0, cmp = 0, t_rue = 0;/*Added by nandhini*/
char word1[2];/*Added by nandhini*/
char word[2];
void proc_main(argc,argv)
int argc;
char *argv[];
{
 err_flag = 0;

//ins_message(ERR_MESG,"rlrlbprn : Start");


  if(argc != 15) 
  {
     ins_message(ERR_MESG,"BTRALCBU : Usage -	 UID_PWD SESSION_ID FACILITY_ID SPECIMEN_NO PRODUCT_CODE UNIT_NO UNIT_STATUS TAGTYPE RESERVED_BY RESERVED_DATE RESERVED_TIME ISSUED_DATE ISSUED_TIME WS_NO arguments wrong\n");
  }

    strcpy(filename,WORKING_DIR);

    strcpy(a_pgm_id.arr,argv[0]);
    a_pgm_id.len = strlen(a_pgm_id.arr); 

    sprintf(filename, "%s%s%s", filename, a_pgm_id.arr, ".lis");

    strcpy(uid_pwd.arr,argv[1]);
    uid_pwd.len = strlen(uid_pwd.arr); 

    strcpy(nd_session_id.arr, argv[2]);
    nd_session_id.len = strlen(nd_session_id.arr);

    strcpy(nd_facility_id.arr,argv[3]);
    nd_facility_id.len = strlen(nd_facility_id.arr);

    strcpy(nd_specimen_no.arr,argv[4]);
    nd_specimen_no.len = strlen(nd_specimen_no.arr);

    strcpy(nd_product_code.arr,argv[5]);
    nd_product_code.len = strlen(nd_product_code.arr);

    strcpy(nd_unit_no_b.arr,argv[6]);
    nd_unit_no_b.len = strlen(nd_unit_no_b.arr);

    strcpy(nd_unit_no.arr, nd_unit_no_b.arr);
    nd_unit_no.len = strlen(nd_unit_no.arr);

    strcpy(nd_unit_status.arr,argv[7]);
    nd_unit_status.len = strlen(nd_unit_status.arr);

    strcpy(nd_tagtype.arr,argv[8]);
    nd_tagtype.len = strlen(nd_tagtype.arr);

    if (strcmp(nd_tagtype.arr, "X")==0)
    {
      strcpy(nd_tagtype_desc.arr, "Cross Match Tag");
      nd_tagtype_desc.len = strlen(nd_tagtype_desc.arr);
    }else if (strcmp(nd_tagtype.arr, "E")==0)
    {
      strcpy(nd_tagtype_desc.arr, "Emergency Tag");
      nd_tagtype_desc.len = strlen(nd_tagtype_desc.arr);
    }else if (strcmp(nd_tagtype.arr, "C")==0)
    {
      strcpy(nd_tagtype_desc.arr, "Component Tag");
      nd_tagtype_desc.len = strlen(nd_tagtype_desc.arr);
    }else
    {
      strcpy(nd_tagtype_desc.arr, "");
      nd_tagtype_desc.len = strlen(nd_tagtype_desc.arr);
    }

    strcpy(nd_reserved_by.arr,argv[9]);
    nd_reserved_by.len = strlen(nd_reserved_by.arr);

    strcpy(nd_reserved_date1.arr, argv[10]);
    nd_reserved_date1.len = strlen(nd_reserved_date1.arr);

    strcpy(nd_reserved_time.arr,argv[11]);
    nd_reserved_time.len = strlen(nd_reserved_time.arr);

    strcpy(nd_issued_date1.arr,argv[12]);
    nd_issued_date1.len = strlen(nd_issued_date1.arr);

    strcpy(nd_issued_time.arr,argv[13]);
    nd_issued_time.len = strlen(nd_issued_time.arr);

    strcpy(nd_ws_no.arr,argv[14]);
    nd_ws_no.len = strlen(nd_ws_no.arr);

    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

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
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
    if (sqlca.sqlcode < 0) goto err_exit;
}



    set_meduser_role();

   strcpy(language_id.arr,l_language_id.arr);
	language_id.len =l_language_id.len;
	language_id.arr[l_language_id.len]='\0';



    if ( strcmp(nd_reserved_date1.arr, "#NDF#") != 0)
	{
		/* EXEC SQL  SELECT  TO_CHAR(TO_DATE(:nd_reserved_date1, 'DD/MM/YYYY'), 'DD/MM/YYYY')
		          INTO   :nd_reserved_date
	              FROM   DUAL; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select TO_CHAR(TO_DATE(:b0,'DD/MM/YYYY'),'DD/MM/YYYY') into\
 :b1  from DUAL ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )36;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_reserved_date1;
  sqlstm.sqhstl[0] = (unsigned int  )102;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_reserved_date;
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
  if (sqlca.sqlcode < 0) goto err_exit;
}




		
			/* EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				BEGIN
				GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:nd_reserved_date1,'DD/MM/YYYY'), :language_id , t_date);
				:nd_reserved_date := to_char(t_date,'DD/MM/YYYY');
				END;
			END-EXEC; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "declare t_date date ; BEGIN GET_LOCALE_DATE . CONVERT_TO_L\
OCALE_DATE ( to_date ( :nd_reserved_date1 , 'DD/MM/YYYY' ) , :language_id , t_\
date ) ; :nd_reserved_date := to_char ( t_date , 'DD/MM/YYYY' ) ; END ;";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )59;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_reserved_date1;
   sqlstm.sqhstl[0] = (unsigned int  )102;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&language_id;
   sqlstm.sqhstl[1] = (unsigned int  )7;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_reserved_date;
   sqlstm.sqhstl[2] = (unsigned int  )102;
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
   if (sqlca.sqlcode < 0) goto err_exit;
}







    }
	else
	  strcpy(nd_reserved_date.arr, nd_reserved_date1.arr);

    nd_reserved_date.len = strlen(nd_reserved_date.arr);

    if ( strcmp(nd_issued_date1.arr, "#NDF#") != 0)
	{
		/* EXEC SQL  SELECT  TO_CHAR( TO_DATE(:nd_issued_date1), 'DD/MM/YYYY')
		          INTO   :nd_issued_date
	              FROM   DUAL; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select TO_CHAR(TO_DATE(:b0),'DD/MM/YYYY') into :b1  from DU\
AL ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )86;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_issued_date1;
  sqlstm.sqhstl[0] = (unsigned int  )102;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_issued_date;
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
  if (sqlca.sqlcode < 0) goto err_exit;
}





			/* EXEC SQL EXECUTE
				DECLARE
				s_date   date;
				BEGIN
				GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:nd_issued_date1,'DD/MM/YYYY'), :language_id , s_date);
				:nd_issued_date := to_char(s_date,'DD/MM/YYYY');
				END;
			END-EXEC; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "declare s_date date ; BEGIN GET_LOCALE_DATE . CONVERT_TO_L\
OCALE_DATE ( to_date ( :nd_issued_date1 , 'DD/MM/YYYY' ) , :language_id , s_da\
te ) ; :nd_issued_date := to_char ( s_date , 'DD/MM/YYYY' ) ; END ;";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )109;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_issued_date1;
   sqlstm.sqhstl[0] = (unsigned int  )102;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&language_id;
   sqlstm.sqhstl[1] = (unsigned int  )7;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_issued_date;
   sqlstm.sqhstl[2] = (unsigned int  )102;
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
   if (sqlca.sqlcode < 0) goto err_exit;
}







    }
	else
      strcpy(nd_issued_date.arr, nd_issued_date1.arr);

    nd_issued_date.len = strlen(nd_issued_date.arr);


     	
	
    get_facility_name();

    get_printer_type();

    get_trans_ind();

	get_printer_id_dtls();

	nd_printer_id.len = strlen(nd_printer_id.arr);


    get_woc_desc();
	
	get_site_customer_id();  /*-- Added By Gopikannan for GHL-CRF-315 For MEDICITY --*/

    if ( (strcmp(ld_episode_type.arr, "I")==0) || (strcmp(ld_episode_type.arr, "O")==0) ||
         (strcmp(ld_episode_type.arr, "H")==0) )
    {
      get_patient_name_mp();
    }else
    {
      get_patient_name_rl();
	  get_ext_per_nric_alt_id_num();//Added by babu againist ML-SD-CRF-20227

    }

    dclr_unit_tag_cur();

    while(fetch_un_screened_cur())
    {
      get_product_desc();
      h_no_of_rec = h_no_of_rec + 1;
    }

   get_legend_value(37);

	get_xmatch_date();  // added on 05/03/2009 wrt IN007762

    call_main_report();
    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 4;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )136;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
    if (sqlca.sqlcode < 0) goto err_exit;
}



	
    return;

err_exit:
    /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

	fclose(f1);
    sprintf(string_var,"%s -> %s\n",nd_unit_no.arr, sqlca.sqlerrm.sqlerrmc);
    ins_message(ORA_MESG,string_var);

    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 4;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )151;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



}

get_legend_value(int cou)
 {


	/* EXEC SQL EXECUTE
	BEGIN
	  SM_POPULATE_REPORT_LEGEND.FETCH_LEGEND (:nd_facility_id,:language_id,'BTRALCBU.LEGEND_');
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin SM_POPULATE_REPORT_LEGEND . FETCH_LEGEND ( :nd_facilit\
y_id , :language_id , 'BTRALCBU.LEGEND_' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )166;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )32;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&language_id;
 sqlstm.sqhstl[1] = (unsigned int  )7;
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






 for (i=1; i<=cou; i++)
	{


	l_translated_value.arr[0]		= '\0';
	
	/* EXEC SQL EXECUTE
	BEGIN
               :l_translated_value :=    GET_LEGEND(LTRIM(RTRIM('BTRALCBU.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009'))))));/oaDDED NANDHINIo/
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin :l_translated_value := GET_LEGEND ( LTRIM ( RTRIM ( 'B\
TRALCBU.LEGEND_' || LTRIM ( RTRIM ( TO_CHAR ( :i , '009' ) ) ) ) ) ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )189;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_translated_value;
 sqlstm.sqhstl[0] = (unsigned int  )1003;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&i;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
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


	
	l_translated_value.arr[l_translated_value.len] = '\0';

	//sp_message(ERR_MESG,l_translated_value.arr);
	strcpy(local_legend[i],l_translated_value.arr);
	
	//sprintf(string_var, "l_translated_value00 is  ", l_translated_value.arr); 
   //disp_message(ERR_MESG, string_var); 


	

	}
	

 }











dclr_unit_tag_cur()
{
 
		/* EXEC SQL DECLARE c_tag CURSOR FOR
                       SELECT	A.unit_no, 
                              A.product_code, 
//                              A.patient_id,
                              B.blood_group||' '||B.rhesus_code donor_type,
                              C.blood_group ||' '|| C.rhesus_code patient_type,
							  B.process_code, 
							  D.process_desc,
							  TO_CHAR(B.expiry_date,'DD-MON-YYYY HH24:MI'),
							  A.issued_by
                       FROM   bt_unit_request_dtl A, bt_blood_units_mast B,
							  bt_patient_blgrp_rh_ant C, 
							  (select process_code, SUBSTR(long_desc,1,40) process_desc
							  from bt_process_code_lang_vw  where language_id = :language_id) D,
							  bt_unit_status E
                       WHERE  A.specimen_no = :nd_specimen_no
                       AND    A.unit_no = B.unit_no
                       AND    A.product_code = B.product_code
                       AND    A.unit_status = DECODE(:nd_unit_status, 'A', 'UA', 'R', 'UR', 'I', 'UI', 'T', 'UT', A.unit_status)
                       AND	  A.operating_facility_id = B.operating_facility_id
                       AND    A.unit_no = :nd_unit_no
                       AND	  A.operating_facility_id=:nd_facility_id
                       AND    A.patient_id = C.patient_id 
					   AND    B.process_code = D.process_code(+)
					   AND	  A.unit_status = E.unit_status_code
					   AND	  E.active_status_yn = 'Y'	
                       ORDER BY A.unit_no; */ 


		/* EXEC SQL OPEN c_tag; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0010;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )212;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&language_id;
  sqlstm.sqhstl[0] = (unsigned int  )7;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_specimen_no;
  sqlstm.sqhstl[1] = (unsigned int  )303;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_unit_status;
  sqlstm.sqhstl[2] = (unsigned int  )303;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_unit_no;
  sqlstm.sqhstl[3] = (unsigned int  )303;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_facility_id;
  sqlstm.sqhstl[4] = (unsigned int  )32;
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


  
    if (OERROR) 
	{
        ins_message (ORA_MESG, "OPEN Cursor c_tag Failed ");
    }

}


get_xmatch_date()
{
	nd_xmatch_date.arr[0]	= '\0';
	nd_xmatch_date.len		= 0;
	nd_xmatch_date1.arr[0]	= '\0';
	nd_xmatch_date1.len		= 0;

	/* EXEC SQL  SELECT	TO_CHAR( MAX(performed_date), 'DD/MM/YYYY HH24:MI')
			  INTO		:nd_xmatch_date1		
			  FROM		BT_SPECIMEN_TEST_VALUES
			  WHERE		specimen_no 	= :nd_specimen_no
     		  AND 		unit_no			= :nd_unit_no
			  AND		product_code	= :d_product_code_temp
			  AND		operating_facility_id = :nd_facility_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select TO_CHAR(max(performed_date),'DD/MM/YYYY HH24:MI') int\
o :b0  from BT_SPECIMEN_TEST_VALUES where (((specimen_no=:b1 and unit_no=:b2) \
and product_code=:b3) and operating_facility_id=:b4)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )247;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_xmatch_date1;
 sqlstm.sqhstl[0] = (unsigned int  )102;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_specimen_no;
 sqlstm.sqhstl[1] = (unsigned int  )303;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_unit_no;
 sqlstm.sqhstl[2] = (unsigned int  )303;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_product_code_temp;
 sqlstm.sqhstl[3] = (unsigned int  )202;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_facility_id;
 sqlstm.sqhstl[4] = (unsigned int  )32;
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

  

	nd_xmatch_date1.arr[nd_xmatch_date1.len]   = '\0';
	


	if (strlen(nd_xmatch_date1.arr) > 0)
	{
		/* EXEC SQL EXECUTE
			DECLARE
			s_date   date;
			BEGIN
			GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:nd_xmatch_date1,'DD/MM/YYYY HH24:MI'), :language_id , s_date);
			:nd_xmatch_date := to_char(s_date,'DD/MM/YYYY HH24:MI');
			END;
		END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "declare s_date date ; BEGIN GET_LOCALE_DATE . CONVERT_TO_LO\
CALE_DATE ( to_date ( :nd_xmatch_date1 , 'DD/MM/YYYY HH24:MI' ) , :language_id\
 , s_date ) ; :nd_xmatch_date := to_char ( s_date , 'DD/MM/YYYY HH24:MI' ) ; E\
ND ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )282;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_xmatch_date1;
  sqlstm.sqhstl[0] = (unsigned int  )102;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&language_id;
  sqlstm.sqhstl[1] = (unsigned int  )7;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_xmatch_date;
  sqlstm.sqhstl[2] = (unsigned int  )102;
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


	}

	nd_xmatch_date.len = strlen(nd_xmatch_date.arr);

    if (OERROR)
	{
		sprintf(string_var,"%s get_xmatch_date()-> %s\n", nd_xmatch_date.arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
      }

    if(NO_DATA_FOUND)
    {
		nd_xmatch_date1.arr[0] = '\0';
		nd_xmatch_date1.len   = 0;

		nd_xmatch_date.arr[0]   = '\0';
		nd_xmatch_date.len	 = 0;
		
    }

}



int fetch_un_screened_cur()
{

  ld_unit_no.len = 0;
  ld_unit_no.arr[ld_unit_no.len] = '\0';

  ld_product_code.len = 0;
  ld_product_code.arr[ld_product_code.len] = '\0';

//  ld_patient_id.len = 0;
//  ld_patient_id.arr[ld_patient_id.len] = '\0';

  ld_donor_type.len = 0;
  ld_donor_type.arr[ld_donor_type.len] = '\0';

  ld_patient_type.len = 0;
  ld_patient_type.arr[ld_patient_type.len] = '\0';

  ld_issued_by.len = 0;
  ld_issued_by.arr[ld_issued_by.len] = '\0';

  ld_process_code.len = 0;
  ld_process_code.arr[ld_process_code.len] = '\0';

  ld_process_desc.len = 0;
  ld_process_desc.arr[ld_process_desc.len] = '\0';

  ld_process_date.len = 0;
  ld_process_date.arr[ld_process_date.len] = '\0';

  ld_process_date1.len = 0;
  ld_process_date1.arr[ld_process_date1.len] = '\0';

      /* EXEC SQL FETCH c_tag INTO
                        :ld_unit_no,
                        :ld_product_code,
//                        :ld_patient_id,
                        :ld_donor_type,
                        :ld_patient_type,
						:ld_process_code,
						:ld_process_desc,
						:ld_process_date,
						:ld_issued_by; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 8;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )309;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&ld_unit_no;
      sqlstm.sqhstl[0] = (unsigned int  )202;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&ld_product_code;
      sqlstm.sqhstl[1] = (unsigned int  )202;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&ld_donor_type;
      sqlstm.sqhstl[2] = (unsigned int  )43;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&ld_patient_type;
      sqlstm.sqhstl[3] = (unsigned int  )43;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&ld_process_code;
      sqlstm.sqhstl[4] = (unsigned int  )102;
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&ld_process_desc;
      sqlstm.sqhstl[5] = (unsigned int  )303;
      sqlstm.sqhsts[5] = (         int  )0;
      sqlstm.sqindv[5] = (         void  *)0;
      sqlstm.sqinds[5] = (         int  )0;
      sqlstm.sqharm[5] = (unsigned int  )0;
      sqlstm.sqadto[5] = (unsigned short )0;
      sqlstm.sqtdso[5] = (unsigned short )0;
      sqlstm.sqhstv[6] = (         void  *)&ld_process_date;
      sqlstm.sqhstl[6] = (unsigned int  )102;
      sqlstm.sqhsts[6] = (         int  )0;
      sqlstm.sqindv[6] = (         void  *)0;
      sqlstm.sqinds[6] = (         int  )0;
      sqlstm.sqharm[6] = (unsigned int  )0;
      sqlstm.sqadto[6] = (unsigned short )0;
      sqlstm.sqtdso[6] = (unsigned short )0;
      sqlstm.sqhstv[7] = (         void  *)&ld_issued_by;
      sqlstm.sqhstl[7] = (unsigned int  )102;
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
	{
//		sprintf(string_var,"%s get_facility_name()-> %s\n", nd_facility_id.arr, sqlca.sqlerrm.sqlerrmc);
        ins_message (ORA_MESG, "FETCH failed c2 ");
		return 0;
      }

    if (NO_DATA_FOUND)
      return 0;

  
//  ld_patient_id.arr[ld_patient_id.len] = '\0';
//  ld_patient_id.len = strlen(ld_patient_id.arr);

  ld_unit_no.arr[ld_unit_no.len] = '\0';
  ld_product_code.arr[ld_product_code.len] = '\0';
  ld_donor_type.arr[ld_donor_type.len] = '\0';
  ld_patient_type.arr[ld_patient_type.len] = '\0';
  ld_issued_by.arr[ld_issued_by.len] = '\0';
  ld_process_code.arr[ld_process_code.len] = '\0';
  ld_process_desc.arr[ld_process_desc.len] = '\0';
  ld_process_date.arr[ld_process_date.len] = '\0';
  

	/* EXEC SQL EXECUTE
		DECLARE
		t_date   date;
		string_var varchar2(100);
		BEGIN
		GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:ld_process_date,'DD/MM/YYYY HH24:MI'), :language_id , t_date);
		:ld_process_date1 := to_char(t_date,'DD/MM/YYYY HH24:MI');
		END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 8;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; string_var varchar2 ( 100 ) ; BEGIN GE\
T_LOCALE_DATE . CONVERT_TO_LOCALE_DATE ( to_date ( :ld_process_date , 'DD/MM/Y\
YYY HH24:MI' ) , :language_id , t_date ) ; :ld_process_date1 := to_char ( t_da\
te , 'DD/MM/YYYY HH24:MI' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )356;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&ld_process_date;
 sqlstm.sqhstl[0] = (unsigned int  )102;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&language_id;
 sqlstm.sqhstl[1] = (unsigned int  )7;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&ld_process_date1;
 sqlstm.sqhstl[2] = (unsigned int  )102;
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



   ld_process_date1.len = strlen(ld_process_date1.arr);

  sprintf(ad_unit_no[h_no_of_rec].arr,"%s", ld_unit_no.arr);
  ad_unit_no[h_no_of_rec].len = strlen(ad_unit_no[h_no_of_rec].arr);

  sprintf(ad_product_code[h_no_of_rec].arr,"%s", ld_product_code.arr);
  ad_product_code[h_no_of_rec].len = strlen(ad_product_code[h_no_of_rec].arr);

  sprintf(ad_patient_id[h_no_of_rec].arr,"%s", ld_patient_id.arr);
  ad_patient_id[h_no_of_rec].len = strlen(ad_patient_id[h_no_of_rec].arr);

  sprintf(ad_donor_type[h_no_of_rec].arr,"%s", ld_donor_type.arr);
  ad_donor_type[h_no_of_rec].len = strlen(ad_donor_type[h_no_of_rec].arr);

  sprintf(ad_patient_type[h_no_of_rec].arr,"%s", ld_patient_type.arr);
  ad_patient_type[h_no_of_rec].len = strlen(ad_patient_type[h_no_of_rec].arr);

  sprintf(ad_issued_by[h_no_of_rec].arr,"%s", ld_issued_by.arr);
  ad_issued_by[h_no_of_rec].len = strlen(ad_issued_by[h_no_of_rec].arr);

  sprintf(ad_process_code[h_no_of_rec].arr,"%s", ld_process_code.arr);
  ad_process_code[h_no_of_rec].len = strlen(ad_process_code[h_no_of_rec].arr);

  sprintf(ad_process_desc[h_no_of_rec].arr,"%s", ld_process_desc.arr);
  ad_process_desc[h_no_of_rec].len = strlen(ad_process_desc[h_no_of_rec].arr);

  sprintf(ad_process_date1[h_no_of_rec].arr,"%s", ld_process_date1.arr);
  ad_process_date1[h_no_of_rec].len = strlen(ad_process_date1[h_no_of_rec].arr);

  return 1;
  
}

get_facility_name()
{
	d_facility_name.arr[0]		= '\0';
	d_facility_name.len		= 0;

	/* EXEC SQL  SELECT facility_name
	            INTO :d_facility_name
	            FROM sm_facility_param_lang_vw
               WHERE facility_id = :nd_facility_id
	       and language_id =:language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 8;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select facility_name into :b0  from sm_facility_param_lang_v\
w where (facility_id=:b1 and language_id=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )383;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_facility_name;
 sqlstm.sqhstl[0] = (unsigned int  )502;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_facility_id;
 sqlstm.sqhstl[1] = (unsigned int  )32;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&language_id;
 sqlstm.sqhstl[2] = (unsigned int  )7;
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
	{
		sprintf(string_var,"%s get_facility_name()-> %s\n", nd_facility_id.arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
	}

	d_facility_name.arr[d_facility_name.len]   = '\0';
	

    if(NO_DATA_FOUND)
    {
      d_facility_name.arr[0]   = '\0';
	  d_facility_name.len	= 0;
      
    }
}

get_woc_desc()
{
  get_source_code();

  if (strcmp(ld_source_type.arr, "W")==0)
  {
    get_ward_desc();
  }
  else if (strcmp(ld_source_type.arr, "C")==0)
  {

    get_clinic_desc();
  }
  else if (strcmp(ld_source_type.arr, "E")==0)
  {
    get_referral_desc();
  }
  else
  {
    strcpy(ld_woc_desc.arr, "");
	ld_woc_desc.arr[0]	= '\0';
    ld_woc_desc.len = 0;
  }
}

get_source_code()
{

	ld_source_type.arr[0]		 = '\0';
	ld_source_type.len		 = 0;

	ld_source_code.arr[0]		 = '\0';
	ld_source_code.len		 = 0;

	ld_patient_id.arr[0]		 = '\0';
	ld_patient_id.len			 = 0;

	ld_episode_type.arr[0]		 = '\0';
	ld_episode_type.len		 = 0;

	/* EXEC SQL  
		SELECT source_type, source_code, patient_id, episode_type
            INTO	 :ld_source_type, :ld_source_code , :ld_patient_id, :ld_episode_type
		FROM   bt_unit_request_hdr
		WHERE  specimen_no = :nd_specimen_no
		AND	 operating_facility_id= :nd_facility_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 8;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select source_type ,source_code ,patient_id ,episode_type in\
to :b0,:b1,:b2,:b3  from bt_unit_request_hdr where (specimen_no=:b4 and operat\
ing_facility_id=:b5)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )410;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&ld_source_type;
 sqlstm.sqhstl[0] = (unsigned int  )102;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&ld_source_code;
 sqlstm.sqhstl[1] = (unsigned int  )12;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&ld_patient_id;
 sqlstm.sqhstl[2] = (unsigned int  )202;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&ld_episode_type;
 sqlstm.sqhstl[3] = (unsigned int  )62;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_specimen_no;
 sqlstm.sqhstl[4] = (unsigned int  )303;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_facility_id;
 sqlstm.sqhstl[5] = (unsigned int  )32;
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

 

	if(OERROR)
	{
		sprintf(string_var,"%s get_source_code()-> %s\n", nd_unit_no.arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
	}

    if(NO_DATA_FOUND)
    {
      ld_source_type.arr[0]		=	'\0';
	  ld_source_type.len   = 0;

      ld_source_code.arr[0]   = '\0';
	  ld_source_code.len	= 0;

      ld_patient_id.arr[0]     = '\0';
	  ld_patient_id.len			= 0;
      
      ld_episode_type.arr[0] = '\0';
	  ld_episode_type.len		= 0;
      
    }

    ld_source_type.arr[strlen(ld_source_type.arr)]   = '\0';
    ld_source_code.arr[strlen(ld_source_code.arr)]   = '\0';
    ld_patient_id.arr[strlen(ld_patient_id.arr)]     = '\0';
    ld_episode_type.arr[strlen(ld_episode_type.arr)] = '\0';
    
}

get_patient_name_mp()
{

	ld_patient_name.arr[0]		 = '\0';
	ld_patient_name.len		 = 0;

	ld_first_half.arr[0]		 = '\0';
	ld_first_half.len		 = 0;

	ld_second_half.arr[0]		 = '\0';
	ld_second_half.len		 = 0;


	//Added by babu againist ML-SD-CRF-20227
	ld_nric_alt_id_num.arr[0]                ='\0';
	ld_nric_alt_id_num.len           = 0;

	ld_national_id_num.arr[0]  ='\0';
	ld_national_id_num.len = 0;
   //Up to here


	/* EXEC SQL  
    /oCommented by babu for ML-SD-CRF-20227

		SELECT SUBSTR(short_name,1,80) 
            INTO	 :ld_patient_name
		FROM   mp_patient_mast
		WHERE  patient_id = :ld_patient_id;o/

	//Added by babu againist ML-SD-CRF-20227
		SELECT DECODE(PROTECTION_IND, '5', CODED_PSEUDO_NAME, 
			SUBSTR(DECODE(:language_id, 'en',PATIENT_NAME,NVL(PATIENT_NAME_LOC_LANG,PATIENT_NAME)),1,80))SHORT_NAME,
			   nvl(ALT_ID1_NO,nvl(ALT_ID2_NO,nvl(ALT_ID3_NO,nvl(ALT_ID4_NO,nvl(OTH_ALT_ID_NO,' '))))),
			   NATIONAL_ID_NO, SUBSTR(DECODE(:language_id, 'en',PATIENT_NAME,NVL(PATIENT_NAME_LOC_LANG,PATIENT_NAME)), 1, 52 ) first_half, 
			   SUBSTR(DECODE(:language_id, 'en',PATIENT_NAME,NVL(PATIENT_NAME_LOC_LANG,PATIENT_NAME)), 53) second_half
		INTO	 :ld_patient_name,:ld_nric_alt_id_num,:ld_national_id_num,
					:ld_first_half, :ld_second_half
		FROM   mp_patient
		WHERE  patient_id = :ld_patient_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 9;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select DECODE(PROTECTION_IND,'5',CODED_PSEUDO_NAME,SUBSTR(DE\
CODE(:b0,'en',PATIENT_NAME,NVL(PATIENT_NAME_LOC_LANG,PATIENT_NAME)),1,80)) SHO\
RT_NAME ,nvl(ALT_ID1_NO,nvl(ALT_ID2_NO,nvl(ALT_ID3_NO,nvl(ALT_ID4_NO,nvl(OTH_A\
LT_ID_NO,' '))))) ,NATIONAL_ID_NO ,SUBSTR(DECODE(:b0,'en',PATIENT_NAME,NVL(PAT\
IENT_NAME_LOC_LANG,PATIENT_NAME)),1,52) first_half ,SUBSTR(DECODE(:b0,'en',PAT\
IENT_NAME,NVL(PATIENT_NAME_LOC_LANG,PATIENT_NAME)),53) second_half into :b3,:b\
4,:b5,:b6,:b7  from mp_patient where patient_id=:b8";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )449;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&language_id;
 sqlstm.sqhstl[0] = (unsigned int  )7;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&language_id;
 sqlstm.sqhstl[1] = (unsigned int  )7;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&language_id;
 sqlstm.sqhstl[2] = (unsigned int  )7;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&ld_patient_name;
 sqlstm.sqhstl[3] = (unsigned int  )502;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&ld_nric_alt_id_num;
 sqlstm.sqhstl[4] = (unsigned int  )502;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&ld_national_id_num;
 sqlstm.sqhstl[5] = (unsigned int  )502;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&ld_first_half;
 sqlstm.sqhstl[6] = (unsigned int  )502;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&ld_second_half;
 sqlstm.sqhstl[7] = (unsigned int  )502;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&ld_patient_id;
 sqlstm.sqhstl[8] = (unsigned int  )202;
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



	if(OERROR)
	{
		sprintf(string_var,"%s get_patient_name_mp()-> %s\n", ld_patient_id.arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
	}

    if(NO_DATA_FOUND)
    {
      ld_patient_name.arr[0]   = '\0';
	  ld_patient_name.len	= 0;
     
      ld_first_half.arr[0]   = '\0';
	  ld_first_half.len	=0;
      

      ld_second_half.arr[0]   = '\0';
	  ld_second_half.len	= 0;
      

    	  //Added by babu agaginist ML-SD-CRF-20227
	  ld_nric_alt_id_num.arr[0] = '\0';
	  ld_nric_alt_id_num.len = 0;
	  
	  ld_national_id_num.arr[0] = '\0';
	  ld_national_id_num.len	= 0;
	  
	  //Upto here


	}

    ld_patient_name.arr[ld_patient_name.len]   = '\0';
    

      ld_first_half.arr[ld_first_half.len]   = '\0';
      
      ld_second_half.arr[ld_second_half.len]   = '\0';
      

	//Added by babu agaginist ML-SD-CRF-20227
	ld_nric_alt_id_num.arr[ld_nric_alt_id_num.len] = '\0';
	
    ld_national_id_num.arr[ld_national_id_num.len] = '\0';
	
	 //Upto here

}

get_patient_name_rl()
{

	ld_patient_name.arr[0]		 = '\0';
	ld_patient_name.len		 = 0;

	ld_first_half.arr[0]		 = '\0';
	ld_first_half.len		 = 0;

	ld_second_half.arr[0]		 = '\0';
	ld_second_half.len		 = 0;


	/* EXEC SQL  
		SELECT SUBSTR(DECODE(:language_id, 'en',person_name,NVL(person_name_loc_lang,person_name)) ,1,80),
					SUBSTR(DECODE(:language_id, 'en',person_name,NVL(person_name_loc_lang,person_name)) ,1,52) first_name,
					SUBSTR(DECODE(:language_id, 'en',person_name,NVL(person_name_loc_lang,person_name)) ,53) last_name
            INTO	 :ld_patient_name, :ld_first_half, :ld_second_half
//		   FROM   rl_patient_mast
		FROM   mp_ext_person
//		   WHERE  patient_id = :ld_patient_id;
	    WHERE  person_id = :ld_patient_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 9;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select SUBSTR(DECODE(:b0,'en',person_name,NVL(person_name_lo\
c_lang,person_name)),1,80) ,SUBSTR(DECODE(:b0,'en',person_name,NVL(person_name\
_loc_lang,person_name)),1,52) first_name ,SUBSTR(DECODE(:b0,'en',person_name,N\
VL(person_name_loc_lang,person_name)),53) last_name into :b3,:b4,:b5  from mp_\
ext_person where person_id=:b6";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )500;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&language_id;
 sqlstm.sqhstl[0] = (unsigned int  )7;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&language_id;
 sqlstm.sqhstl[1] = (unsigned int  )7;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&language_id;
 sqlstm.sqhstl[2] = (unsigned int  )7;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&ld_patient_name;
 sqlstm.sqhstl[3] = (unsigned int  )502;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&ld_first_half;
 sqlstm.sqhstl[4] = (unsigned int  )502;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&ld_second_half;
 sqlstm.sqhstl[5] = (unsigned int  )502;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&ld_patient_id;
 sqlstm.sqhstl[6] = (unsigned int  )202;
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
	{
		sprintf(string_var,"%s get_patient_name_rl()-> %s\n", ld_patient_id.arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
	}

    if(NO_DATA_FOUND)
    {
      ld_patient_name.arr[0]   = '\0';
	  ld_patient_name.len	= 0;

      
      ld_first_half.arr[0]   = '\0';
	  ld_first_half.len	= 0;
      
      ld_second_half.arr[0]   = '\0';
	  ld_second_half.len	= 0;
      
    }

    ld_patient_name.arr[ld_patient_name.len]   = '\0';
    
    ld_first_half.arr[ld_first_half.len]   = '\0';
    
    ld_second_half.arr[ld_second_half.len]   = '\0';
    
}

//Added by babu againist ML-SD-CRF-20227

get_ext_per_nric_alt_id_num()
{
	ld_nric_alt_id_num.arr[0]                ='\0';
	ld_nric_alt_id_num.len           = 0;
	
	//Added by babu againist ML-SD-CRF-20227
	ld_national_id_num.arr[0]                ='\0';
	ld_national_id_num.len           = 0;
	//UP TO HERE.

	/* EXEC SQL  
		
		/ocommented by babu againist ML-SD-CRF-20227
		SELECT COALESCE(NATIONAL_ID_NO,ALT_ID1_NO,ALT_ID2_NO,ALT_ID3_NO,ALT_ID4_NO,OTH_ALT_ID_NO)
		INTO   :ld_nric_alt_id_num
		FROM   mp_ext_person
		WHERE  person_id = :ld_patient_id;
		UP TO HTERE o/
	
	//Added by babu againist ML-SD-CRF-20227
		SELECT nvl(ALT_ID1_NO,nvl(ALT_ID2_NO,nvl(ALT_ID3_NO,nvl(ALT_ID4_NO,nvl(OTH_ALT_ID_NO,' '))))),
			   NATIONAL_ID_NO 
		INTO   :ld_nric_alt_id_num,:ld_national_id_num
		FROM   mp_ext_person
		WHERE  person_id = :ld_patient_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 9;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select nvl(ALT_ID1_NO,nvl(ALT_ID2_NO,nvl(ALT_ID3_NO,nvl(ALT_\
ID4_NO,nvl(OTH_ALT_ID_NO,' '))))) ,NATIONAL_ID_NO into :b0,:b1  from mp_ext_pe\
rson where person_id=:b2";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )543;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&ld_nric_alt_id_num;
 sqlstm.sqhstl[0] = (unsigned int  )502;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&ld_national_id_num;
 sqlstm.sqhstl[1] = (unsigned int  )502;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&ld_patient_id;
 sqlstm.sqhstl[2] = (unsigned int  )202;
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


		//UPTO HERE
	
	if(OERROR)
	{
		sprintf(string_var,"%s gget_ext_per_nric_alt_id_num()-> %s\n", ld_patient_id.arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
	}

    if(NO_DATA_FOUND)
    {
      
	  ld_nric_alt_id_num.arr[0] = '\0';
	  ld_nric_alt_id_num.len	= 0;
	  
	
	//Added by babu againist ML-SD-CRF-20227
	  ld_national_id_num.arr[0] = '\0';
	  ld_national_id_num.len	= 0;
	  
	//Upto here	
	}

    	
	ld_nric_alt_id_num.arr[ld_nric_alt_id_num.len] = '\0';
	
	//Added by babu againist ML-SD-CRF-20227
	  ld_national_id_num.arr[ld_national_id_num.len] = '\0';
	
	//Upto here	
}
//END BY BABU

get_ward_desc()
{

	ld_woc_desc.arr[0]		 = '\0';
	ld_woc_desc.len		 = 0;

	/* EXEC SQL  
		SELECT short_desc
            INTO	 :ld_woc_desc
		//FROM   ip_ward_lang_vw  ML-SD-CRF-20227
		//WHERE  ward_code = :ld_source_code  ML-SD-CRF-20227
		FROM IP_NURSING_UNIT_LANG_VW  //ML-SD-CRF-20227
		WHERE nursing_unit_code =:ld_source_code //ML-SD-CRF-20227
		AND	 facility_id= :nd_facility_id
		and language_id = :language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 9;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select short_desc into :b0  from IP_NURSING_UNIT_LANG_VW whe\
re ((nursing_unit_code=:b1 and facility_id=:b2) and language_id=:b3)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )570;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&ld_woc_desc;
 sqlstm.sqhstl[0] = (unsigned int  )502;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&ld_source_code;
 sqlstm.sqhstl[1] = (unsigned int  )12;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_facility_id;
 sqlstm.sqhstl[2] = (unsigned int  )32;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&language_id;
 sqlstm.sqhstl[3] = (unsigned int  )7;
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
	{
		sprintf(string_var,"%s get_ward_code()-> %s\n", ld_source_code.arr, sqlca.sqlerrm.sqlerrmc);
//		ins_message(ORA_MESG, string_var);
	}

    if(NO_DATA_FOUND)
    {
      ld_woc_desc.arr[0]   = '\0';
	  ld_woc_desc.len  = 0;
      
    }

    ld_woc_desc.arr[ld_woc_desc.len]   = '\0';
 }

get_clinic_desc()
{

	ld_woc_desc.arr[0]		 = '\0';
	ld_woc_desc.len		 = 0;

	/* EXEC SQL  
		SELECT short_desc
            INTO	 :ld_woc_desc
		FROM   op_clinic_lang_vw
		WHERE  clinic_code = :ld_source_code
		AND	 facility_id= :nd_facility_id
		AND  language_id= :language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 9;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select short_desc into :b0  from op_clinic_lang_vw where ((c\
linic_code=:b1 and facility_id=:b2) and language_id=:b3)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )601;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&ld_woc_desc;
 sqlstm.sqhstl[0] = (unsigned int  )502;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&ld_source_code;
 sqlstm.sqhstl[1] = (unsigned int  )12;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_facility_id;
 sqlstm.sqhstl[2] = (unsigned int  )32;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&language_id;
 sqlstm.sqhstl[3] = (unsigned int  )7;
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
	{
		sprintf(string_var,"%s get_clinic_code()-> %s\n", ld_source_code.arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
	}

    if(NO_DATA_FOUND)
    {
      ld_woc_desc.arr[0]   = '\0';
		ld_woc_desc.len		= 0;

    }

    ld_woc_desc.arr[ld_woc_desc.len]   = '\0';
}

get_referral_desc()
{

	ld_woc_desc.arr[0]		 = '\0';
	ld_woc_desc.len		 = 0;

	/* EXEC SQL  
		SELECT short_desc
            INTO	 :ld_woc_desc
		FROM   sy_referral_lang_vw
		WHERE  referral_code = :ld_source_code
		AND language_id = :language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 9;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select short_desc into :b0  from sy_referral_lang_vw where (\
referral_code=:b1 and language_id=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )632;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&ld_woc_desc;
 sqlstm.sqhstl[0] = (unsigned int  )502;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&ld_source_code;
 sqlstm.sqhstl[1] = (unsigned int  )12;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&language_id;
 sqlstm.sqhstl[2] = (unsigned int  )7;
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
	{
		sprintf(string_var,"%s get_referral_code()-> %s\n", ld_source_code.arr, sqlca.sqlerrm.sqlerrmc);
//		ins_message(ORA_MESG, string_var);
	}

    if(NO_DATA_FOUND)
    {
      ld_woc_desc.arr[0]   = '\0';
		ld_woc_desc.len = 0;

    }

    ld_woc_desc.arr[ld_woc_desc.len]   = '\0';
}


get_product_desc()
{

	ad_product_desc[h_no_of_rec].arr[0]		 = '\0';
	ad_product_desc[h_no_of_rec].len		 = 0;

	strcpy(d_product_code_temp.arr, ad_product_code[h_no_of_rec].arr);
	d_product_code_temp.len = strlen(d_product_code_temp.arr);

	/* EXEC SQL  SELECT long_desc
	            INTO :d_product_desc_temp
	            FROM bt_product_mast_lang_vw
               WHERE product_code = :d_product_code_temp
		and language_id=:language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 9;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select long_desc into :b0  from bt_product_mast_lang_vw wher\
e (product_code=:b1 and language_id=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )659;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_product_desc_temp;
 sqlstm.sqhstl[0] = (unsigned int  )303;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_product_code_temp;
 sqlstm.sqhstl[1] = (unsigned int  )202;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&language_id;
 sqlstm.sqhstl[2] = (unsigned int  )7;
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
	{
		sprintf(string_var,"%s get_product_desc()-> %s\n", d_product_code_temp.arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
	}

    if(NO_DATA_FOUND)
    {
		ad_product_desc[h_no_of_rec].arr[0]		 = '\0';
		ad_product_desc[h_no_of_rec].len		 = 0;

    }

    strcpy(ad_product_desc[h_no_of_rec].arr, d_product_desc_temp.arr );
    ad_product_desc[h_no_of_rec].len = strlen(ad_product_desc[h_no_of_rec].arr);

}


/**************************get printer id details ***************/
get_printer_id_dtls()
{

		/* EXEC SQL EXECUTE
				DECLARE
 						p_location_varray	APPPRINT.location_varray_type := APPPRINT.LOCATION_VARRAY_TYPE();
						p_printer_id		VARCHAR2(1000);
						p_printer			VARCHAR2(1000);
						p_printer_types		VARCHAR2(1000);
						p_queue				VARCHAR2(1000);
						p_copies			VARCHAR2(50);
						p_error_text		VARCHAR2(1000);
						p_facility_yn		VARCHAR2(100);
						p_report_group		VARCHAR2(1000);
						p_trans_ind			VARCHAR2 (100);
				BEGIN
						  
						  p_location_varray.extend(10);
						  p_location_varray(1).location_type := :nd_print_source_type;
						  p_location_varray(1).location_code := :nd_print_source;

						  p_facility_yn	:= :nd_facility_ind;
						  p_report_group := :nd_report_group_id;
						  p_trans_ind := :nd_trx_ind;


--						  p_location_varray(1).location_type := 'O';
--						  p_location_varray(1).location_code :=  NULL;
--						  p_report_group := NULL;
--						  p_facility_yn	:= 'Y';
--						  p_trans_ind := 'N';
						  


				APPPRINT.get_routing_printer_property(:nd_ws_no,
						  	    :nd_facility_id,
								'BT',
								'BTRALCBU',
								 p_location_varray,
								 p_facility_yn,
								 p_trans_ind,
								 p_report_group,
								 p_printer_id,
								 p_printer,
								 p_printer_types,
								 p_queue,
								 p_copies,
								 p_error_text);

					
					IF p_printer_id LIKE 'ZPL%' THEN
						:nd_printer_id := 'ZPL';
					ELSE
						:nd_printer_id := 'EPL';
					END IF;

				END;
		END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 9;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "declare p_location_varray APPPRINT . location_varray_type :\
= APPPRINT . LOCATION_VARRAY_TYPE ( ) ; p_printer_id VARCHAR2 ( 1000 ) ; p_pri\
nter VARCHAR2 ( 1000 ) ; p_printer_types VARCHAR2 ( 1000 ) ; p_queue VARCHAR2 \
( 1000 ) ; p_copies VARCHAR2 ( 50 ) ; p_error_text VARCHAR2 ( 1000 ) ; p_facil\
ity_yn VARCHAR2 ( 100 ) ; p_report_group VARCHAR2 ( 1000 ) ; p_trans_ind VARCH\
AR2 ( 100 ) ; BEGIN p_location_varray . extend ( 10 ) ; p_location_varray ( 1 \
) . location_type := :nd_print_source_type ; p_location_varray ( 1 ) . locatio\
n_code := :nd_print_source ; p_facility_yn := :nd_facility_ind ; p_report_grou\
p := :nd_report_group_id ; p_trans_ind := :nd_trx_ind ; APPPRINT . get_routing\
_printer_property ( :nd_ws_no , :nd_facility_id , 'BT' , 'BTRALCBU' , p_locati\
on_varray , p_facility_yn , p_trans_ind , p_report_group , p_printer_id , p_pr\
inter , p_printer_types , p_queue , p_copies , p_error_text ) ; IF p_printer_i\
d LIKE 'ZPL%' THEN :nd_printer_id := 'ZPL' ; ELSE :nd_printer_id := 'EPL' ; EN\
D IF ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )686;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_print_source_type;
  sqlstm.sqhstl[0] = (unsigned int  )22;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_print_source;
  sqlstm.sqhstl[1] = (unsigned int  )22;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_facility_ind;
  sqlstm.sqhstl[2] = (unsigned int  )12;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_report_group_id;
  sqlstm.sqhstl[3] = (unsigned int  )502;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_trx_ind;
  sqlstm.sqhstl[4] = (unsigned int  )12;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_ws_no;
  sqlstm.sqhstl[5] = (unsigned int  )303;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_facility_id;
  sqlstm.sqhstl[6] = (unsigned int  )32;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_printer_id;
  sqlstm.sqhstl[7] = (unsigned int  )1002;
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




}



/**************************select transaction based or not ***************/
get_trans_ind()
{
	
	nd_trx_ind.arr[0]		= '\0';
	nd_trx_ind.len		= 0;

	nd_facility_ind.arr[0]	= '\0';
	nd_facility_ind.len		= 0;

	nd_report_group_id.arr[0]	= '\0';
	nd_report_group_id.len		= 0;

	/* EXEC SQL  SELECT NVL(TRANSACTION_BASED_YN, 'N') , NVL(facility_based_yn, 'N'), report_group_id
	            INTO :nd_trx_ind, :nd_facility_ind, :nd_report_group_id
	            FROM sy_online_print_id
               WHERE MODULE_ID = 'BT'
   		         AND ONLINE_PRINT_NAME = :a_pgm_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 9;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select NVL(TRANSACTION_BASED_YN,'N') ,NVL(facility_based_yn,\
'N') ,report_group_id into :b0,:b1,:b2  from sy_online_print_id where (MODULE_\
ID='BT' and ONLINE_PRINT_NAME=:b3)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )733;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_trx_ind;
 sqlstm.sqhstl[0] = (unsigned int  )12;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_facility_ind;
 sqlstm.sqhstl[1] = (unsigned int  )12;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_report_group_id;
 sqlstm.sqhstl[2] = (unsigned int  )502;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&a_pgm_id;
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



	if(OERROR)
	{
		sprintf(string_var,"%s get_trans_ind()-> %s\n", nd_unit_no.arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
	}

	nd_trx_ind.arr[nd_trx_ind.len]   = '\0';
	nd_facility_ind.arr[nd_facility_ind.len]   = '\0';
	nd_report_group_id.arr[nd_report_group_id.len]   = '\0';

    if(NO_DATA_FOUND)
	{
	  nd_trx_ind.arr[0]   = '\0';
	  nd_trx_ind.len = 0;
	}
		
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

	nd_print_source_type.len = strlen(nd_print_source_type.arr);
	nd_print_source.len = strlen(nd_print_source.arr);

}

call_main_report()
{
  call_print_label();
}

set_fonts()
{

/*	fprintf(f1,"%c&k4S",ESC); This will make the font condensed */	
/*  fprintf(fp,"%c(s4B",ESC); This will make the font bold      */
	fprintf(f1, "%c(s15H", ESC);/* Reduce the font size*/
	fprintf(f1,"%c&a0L",ESC);/* This will make the left margin to reduce to 0 */
	fprintf(f1,"%c&l0E\n",ESC);	/* This will make the top margin to reduce to 0 */
	fprintf(f1,"%c&l12D",ESC);/* This will make no. of lines per inch to 8 */
}


call_print_label()
{
  int v_i = 0;

  for (v_i=0;v_i<h_no_of_rec;v_i++)
  {
    if ( ( f1 = fopen ( filename, "w" ) ) == NULL ) 
    {
      ins_message(ERR_MESG,"Error in opening output file...\n");  
    }

    if (strcmp(nd_printer_type.arr,"3")!= 0)
    {
      fprintf(f1, "%cE", ESC);
      set_fonts();
    }

    print_tag_label(v_i);
    fclose(f1);

    if (strcmp(nd_printer_type.arr,"3")!= 0)
    {	
      fprintf(f1, "%cE", ESC);
      set_fonts();
    }
	if (err_flag == 0)
    {
       print_barcode_label(1);
    }
  }
}

/******************* added on 28.07.2003 ********/
get_printer_type()
{

	  strcpy(nd_printer_type.arr, "3");
	  nd_printer_type.len = strlen(nd_printer_type.arr);

	  /* EXEC SQL SELECT NVL(printer_type, '1')
  	           INTO  :nd_printer_type
  	           FROM   SY_ONLINE_PRINT_ID
	           WHERE  module_id = 'BT'
	           AND    online_print_name = :a_pgm_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 9;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select NVL(printer_type,'1') into :b0  from SY_ONLINE_PRIN\
T_ID where (module_id='BT' and online_print_name=:b1)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )764;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_printer_type;
   sqlstm.sqhstl[0] = (unsigned int  )12;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&a_pgm_id;
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

 

        if(NO_DATA_FOUND)
		{
   			strcpy(nd_printer_type.arr, "3");
			nd_printer_type.len = strlen(nd_printer_type.arr);
		}

  	  if(OERROR)
	  {
   		strcpy(nd_printer_type.arr, "3");
		nd_printer_type.len = strlen(nd_printer_type.arr);
	   }

	  nd_printer_type.arr[nd_printer_type.len]  = '\0';
	  
}

print_tag_label(int v_ind)
{

  int xx;
  int i = 0;

	l_xmatch_tag.arr[0]		= '\0';
	l_xmatch_tag.len		= 0;
	l_comp_tag.arr[0]		= '\0';
	l_comp_tag.len		    = 0;
	l_emerg_tag.arr[0]		= '\0';
	l_emerg_tag.len		    = 0;
	l_emerg_tag2.arr[0]		= '\0';
	l_emerg_tag2.len		    = 0;


	/* EXEC SQL SELECT emerg_tag_desc,
                     compn_tag_desc,
                     xmtch_tag_desc,
					 emerg_tag_desc2,
					 LICENCE_NO
              INTO   :l_emerg_tag, :l_comp_tag, :l_xmatch_tag, :l_emerg_tag2,:l_licence_no/oAdded by nandhinio/
              FROM   BT_PARAM; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 9;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select emerg_tag_desc ,compn_tag_desc ,xmtch_tag_desc ,emerg\
_tag_desc2 ,LICENCE_NO into :b0,:b1,:b2,:b3,:b4  from BT_PARAM ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )787;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_emerg_tag;
 sqlstm.sqhstl[0] = (unsigned int  )503;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_comp_tag;
 sqlstm.sqhstl[1] = (unsigned int  )503;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&l_xmatch_tag;
 sqlstm.sqhstl[2] = (unsigned int  )503;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&l_emerg_tag2;
 sqlstm.sqhstl[3] = (unsigned int  )503;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&l_licence_no;
 sqlstm.sqhstl[4] = (unsigned int  )42;
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




	l_xmatch_tag.arr[l_xmatch_tag.len]		= '\0';
	l_comp_tag.arr[l_comp_tag.len]			= '\0';
	l_emerg_tag.arr[l_emerg_tag.len]		= '\0';
	l_emerg_tag2.arr[l_emerg_tag2.len]		= '\0';
	l_licence_no.arr[l_licence_no.len]		= '\0';/*Added by nandhini*/



//    for(xx= 0; xx <= ((34 - strlen(nd_tagtype_desc.arr))/2);xx++)
//	  fprintf(f1, "%s", " ");
//	fprintf(f1, "%s\n", nd_tagtype_desc.arr);

    for(xx= 0; xx <= (abs((34 - strlen(d_facility_name.arr)))/2);xx++)
	  fprintf(f1, "%s", " ");
	  fprintf(f1, "%s\n", d_facility_name.arr);
	/*Added by nandhini AGAINST ghl-crf-570 ON 08/FEB/2018*/
	if (strcmp(l_customer_id.arr,"MC")== 0)
	{	
    	for(xx= 0; xx <= (abs((34 - strlen(l_licence_no.arr)))/2);xx++)
	    fprintf(f1, "%s", " ");
	    fprintf(f1, "%s %-s\n",local_legend[37], l_licence_no.arr);
	}
	/*uPTO HERE by nandhini AGAINST ghl-crf-570 ON 08/FEB/2018*/
	for(xx= 0; xx <= (abs((34 - strlen(ld_woc_desc.arr)))/2);xx++)
	fprintf(f1, "%s", " ");
	fprintf(f1, "%s\n", ld_woc_desc.arr);

	if (strcmp(nd_printer_type.arr,"3")!=0)	
	{
	  print_barcode(f1,nd_unit_no.arr, 0, 0, 40, 250,atoi(nd_printer_type.arr));
	  fprintf(f1,"\n");  
	}
	else
	{
	  print_barcode(f1, nd_unit_no.arr, 0, 0, 40, 250,atoi(nd_printer_type.arr));		
	  fprintf(f1,"\n");
	}

	fprintf(f1, "%s: %-s\n",local_legend[4], nd_unit_no.arr);
	fprintf(f1, "%s: %-s\n",local_legend[5],ad_product_desc[v_ind].arr);

	fprintf(f1, "%s: %-s\n",local_legend[6],ld_first_half.arr);

	space_req = strlen(local_legend[6]);
	if (strlen(ld_patient_name.arr) > 52) 
	{

		strcpy(string_var, "");
		for (i=0;i<space_req;i++)
		{	
			sprintf(string_var, "%s", strcat(string_var," "));
		}	
		
		fprintf(f1, "%s: %-s\n",string_var,ld_second_half.arr);
	}
	else
	{
		fprintf(f1, "\n");
	}

/*  commented by preetham to match the approved label of mafraq 
	if (strcmp(nd_printer_id.arr, "ZPL") != 0) // added by preetham wrt common functions for all sites 
	{

		if (ld_national_id_num.len)  //commented by preetham on 23/01/2009 to match the layout which was accepted by MAFRAQ site (needs to be reverted later)
		{
		fprintf(f1, "%s: %-s\n",local_legend[16],ld_national_id_num.arr);
		}
		else
		{
		fprintf(f1, "%s: %-s\n",local_legend[16],ld_nric_alt_id_num.arr);
		}
	}

*/
	fprintf(f1, "%s: %-s\n",local_legend[7], ld_patient_id.arr);
	fprintf(f1, "%s: %-s\n",local_legend[8], ad_patient_type[v_ind].arr);
	fprintf(f1, "%s: %-s\n",local_legend[9], ad_donor_type[v_ind].arr);

	if (strcmp(nd_printer_type.arr,"3")!=0)	
	{
	   print_barcode(f1,nd_specimen_no.arr, 0, 0, 40, 250,atoi(nd_printer_type.arr));
	   fprintf(f1,"\n");  
	}
	else
	{
	     print_barcode(f1, nd_specimen_no.arr, 0, 0, 40, 250,atoi(nd_printer_type.arr));		
	     fprintf(f1,"\n");
	}


	fprintf(f1, "%s: %-s\n",local_legend[10],nd_specimen_no.arr);

//	if (strcmp(nd_tagtype.arr, "C")!=0)  commented by preetham on 23/01/2009 wrt mafraq enhancement to display all data
//	{

      if ( strcmp(nd_reserved_by.arr, "#NDF#") != 0 && strcmp(nd_tagtype.arr, "C")!=0)
{
      fprintf(f1, "%s: %-s\n",local_legend[11],nd_reserved_by.arr);
	  fprintf(f1, "%s: %-s\n",local_legend[19],nd_xmatch_date.arr);
}
      else
{
      fprintf(f1, "%s: %-s\n",local_legend[11], " ");
      fprintf(f1, "%s: %-s\n",local_legend[19], " ");
}
	  if (strcmp(l_customer_id.arr,"MC") != 0) /*-- Added By Gopikannan for GHL-CRF-315 For MEDICITY --*/
	  {
		if ( strcmp(nd_reserved_date.arr, "#NDF#") != 0)
		{
			fprintf(f1, "%s: %-s %-5.5s\n",local_legend[12],nd_reserved_date.arr, nd_reserved_time.arr);
		}	
		else
		{
			fprintf(f1, "%s: %-s\n",local_legend[12], " ");
		}
	  }
	  

//	}

// 

	if ( strcmp(nd_issued_date.arr, "#NDF#") != 0 )
	{
	  	  if (strcmp(nd_printer_id.arr, "ZPL") != 0) // added to keep MF Tag layout intact
	  	  {
	  		fprintf(f1, "%s: %-s\n",local_legend[21], ad_issued_by[v_ind].arr);
	  	  }
	  fprintf(f1, "%s: %-s %-5.5s\n",local_legend[13], nd_issued_date.arr, nd_issued_time.arr);
	}
	else
	{
		  if (strcmp(nd_printer_id.arr, "ZPL") != 0) // added to keep MF Tag layout intact
		  {
	  		fprintf(f1, "%s: %-s\n",local_legend[21], " ");
		  }
	  fprintf(f1, "%s: %-s\n",local_legend[13], " ");
	}
	
	fprintf(f1, "%s: %-s %-s\n",local_legend[17], ad_process_code[v_ind].arr, ad_process_desc[v_ind].arr);
	fprintf(f1, "%s: %-s\n",local_legend[18], ad_process_date1[v_ind].arr);
	
//	if (strcmp(nd_tagtype.arr, "C")==0)
//	  fprintf(f1, "\n\n");

	if (strcmp(nd_tagtype.arr, "C")==0 )
	{
		if (l_comp_tag.len == 0)
		{
			fprintf(f1, "%-s\n", local_legend[14]);
		}
		else
		{
	       splitting(l_comp_tag.arr);
			//fprintf(f1, "%-s\n", l_comp_tag.arr);
		}
	}
	if (strcmp(nd_tagtype.arr, "X")==0) 
	{  
		if (l_xmatch_tag.len == 0)
			fprintf(f1, "%-s\n", local_legend[14]);
		else
		splitting(l_xmatch_tag.arr);
	/*fprintf(f1, "%-s\n", l_xmatch_tag.arr);*/
	}

	if (strcmp(nd_tagtype.arr, "E")==0)
	{

		if (l_emerg_tag.len == 0)
		{
			fprintf(f1, "%-s\n", local_legend[15]);
		}
		else
		{
		splitting(l_emerg_tag.arr);
			//fprintf(f1, "%-s\n", l_emerg_tag.arr);
		}
			
		if (strlen(l_emerg_tag2.arr) > 0)

		{
		splitting(l_emerg_tag2.arr);
		
			//fprintf(f1, "%-s\n", l_emerg_tag2.arr);
		}

/************
	  if (strcmp(nd_printer_id.arr, "ZPL") != 0) // added by preetham wrt common functions for all sites 
	  {
		if (l_emerg_tag2.len == 0)
		{
			fprintf(f1, "%-s\n", local_legend[20]);
		}
		else
		{
			fprintf(f1, "%-s\n", l_emerg_tag2.arr);
		}
	  }
********************/
}
}
/* SPLITTING THE VARCHAR 2000 INTO 70 CHARACTERS   */
/************************************************/
splitting(char *P_legend_tag)
{
	char word[2];
  
    strcpy(word1,"F");
		  
      hell = strlen(P_legend_tag);
  	
        z = 0;
	     clt = 0;
	     strcpy(word1,"F");
	     cntr = 1;
	     qq = 0;
	  
			  
         while(z<hell)
         {
		 	 word[0] = P_legend_tag[z];
 		     word[1] = '\0';

		    if (strcmp(word,"\n") == 0)
		     { 
		       cntr = 0;
		       strcpy(word1,"N");
		       qq = z ;
			   
 	      }
			  
  		      if(cntr >= 51)
		      {
		   	    cmp = cntr;
			     while((P_legend_tag[z] != 32) && (cmp > 1))
			     {
			         z--;
				     cmp--;
  			      }
				  qq = z;
	  			   
			      word[0] = P_legend_tag[z];
   			      word[1] = '\0';
				  
	  	      if (cmp == 1)
				     strcpy(word1,"W");
			      else
			         strcpy(word1,"T");
			    } 
				
		       
				if (((z == hell) || (z == hell - 1)) && (strcmp(word1,"F") == 0))
				{
			   
				   for(i=clt;i < z + 1;i++)
		           {
				 
				        fprintf(f1,"%c",P_legend_tag[i]);
		   		}
			       fprintf	(f1,"\n");
				   cntr = 0 ;
				   clt = clt + 70 ;
				   z = clt ;
			       qq = 0;
				   strcpy(word1,"F");
				}
		
		       if (strcmp(word1,"N") == 0) 
		       {
			  
				  for(i=clt;i<=qq;i++)
		          {
			   		fprintf(f1,"%c",P_legend_tag[i]);
				   }
					
			      strcpy(word1,"F");
			      cntr = 0 ;
			      clt = qq + 1;
		          qq = 0;
	   	       }

		      if (strcmp(word1,"T") == 0)
		       {
		 	  
				  for(i=clt;i<= qq;i++)
		          {
		         fprintf(f1,"%c",P_legend_tag[i]);
     			  }

			       fprintf	(f1,"\n");
			       cntr = 0 ;
				   clt = qq + 1 ;
			       qq = 0;
				   strcpy(word1,"F");
		        }

		       if (strcmp(word1,"W") == 0)
		        {
		 	   for(i=clt;i < clt + 70;i++)
		           {
		      		fprintf(f1,"%c",P_legend_tag[i]);
				    }
				   
			       fprintf(f1,"\n");
				   cntr = 0 ;
				   clt = clt + 70 ;
				   z = clt ;
			       qq = 0;
				   strcpy(word1,"F");
		        }
			//w_flag = 'T';	  
	       cntr += 1;
	       z++ ;
          }
   }
   /***************** Print BarCode Label ********************/
print_barcode_label(int nolabel)
 {
    int i;
    int WSPrintstatus;

    for(i=0;i<nolabel;i++)
		  {

//sprintf(string_var, "%s  %s  %s   %s ", uid_pwd.arr, nd_facility_id.arr, a_pgm_id.arr, filename);
//disp_message(ERR_MESG, string_var);

		 		if (nd_source_type.arr[0]	== '!')
				{	
								

					 WSPrintDocument 
						   (
							uid_pwd.arr,		//char	*PUidPwd;
							nd_session_id.arr,	//char	*PSessionID;
							nd_facility_id.arr,	//char	*PFacilityID;
							"BT",				//char	*PModuleID;
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
							nd_facility_id.arr,			//char	*PFacilityID;
							"BT",						//char	*PModuleID;
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
         (:nd_facility_id,'BTRALCBU',:er_msg_type,NULL, SUBSTR(:er_msg, 1, 70),SYSDATE,USERENV('sessionid'),TO_CHAR(SYSDATE,'DD/MM/YYYY')); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 9;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "insert into SY_PROG_MSG (OPERATING_FACILITY_ID,PGM_ID,MSG_\
TYPE,MSG_NUM,MSG_DESC,MSG_DATE_TIME,SESSION_ID,PGM_DATE) values (:b0,'BTRALCBU\
',:b1,null ,SUBSTR(:b2,1,70),SYSDATE,USERENV('sessionid'),TO_CHAR(SYSDATE,'DD/\
MM/YYYY'))";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )822;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )32;
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

/*-- Added By Gopikannan for GHL-CRF-315 For MEDICITY --*/	
get_site_customer_id()
{
	l_customer_id.arr[0]	= '\0';
	l_customer_id.len		= 0;

	/* EXEC SQL SELECT NVL(customer_id, '!!')
		     INTO 	l_customer_id
		     FROM 	SM_SITE_PARAM; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 9;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select NVL(customer_id,'!!') into :b0  from SM_SITE_PARAM ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )849;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_customer_id;
 sqlstm.sqhstl[0] = (unsigned int  )52;
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



	l_customer_id.arr[l_customer_id.len]	= '\0';

	if (NO_DATA_FOUND);

	if (OERROR);	
}

