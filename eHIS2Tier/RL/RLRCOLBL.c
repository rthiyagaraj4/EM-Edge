
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
    "d:\\durai\\proc\\facility_corr_proc\\rlrcolbl.pc"
};


static unsigned long sqlctx = 1033705253;


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
            void  *sqhstv[15];
   unsigned int   sqhstl[15];
            int   sqhsts[15];
            void  *sqindv[15];
            int   sqinds[15];
   unsigned int   sqharm[15];
   unsigned int   *sqharc[15];
   unsigned short  sqadto[15];
   unsigned short  sqtdso[15];
} sqlstm = {10,15};

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

 static const char *sq0008 = 
"select order_catalog_code  from or_order_line where ((order_type_code=:b0 an\
d order_id=:b1) and order_line_status not  in (select order_status_code  from \
OR_ORDER_STATUS_CODE where ORDER_STATUS_TYPE in ('93','96','99')))           ";

 static const char *sq0009 = 
"select test_code ,TO_CHAR(specimen_no) ,seq_no  from RL_INTERVAL_TEST_SPECIM\
ENS where ((interval_test_specimen_no=TO_NUMBER(:b0) and operating_facility_id\
=:b1) and specimen_no<>TO_NUMBER(:b0)) order by specimen_no            ";

 static const char *sq0021 = 
"select container_code ,NVL(volume,0) volume ,volume_unit ,NVL(SUBSTR(long_de\
sc,1,30),' ') long_desc ,ABS((NVL(volume,0)-:b0)) req_volume  from RL_SPECIMEN\
_CONTAINER where (container_code in (select container_code  from RL_AGE_SEX_SP\
EC_TYPE_CONT where (specimen_type_code=:b1 and TO_NUMBER(:b2) between calc_min\
_age_in_days and calc_max_age_in_days)) and NVL(volume_unit,'!!!!')=NVL(:b3,'!\
!!!')) order by req_volume            ";

 static const char *sq0022 = 
"select container_code ,NVL(volume,0) volume ,volume_unit ,NVL(SUBSTR(long_de\
sc,1,30),' ') long_desc ,ABS((NVL(volume,0)-:b0)) req_volume  from RL_SPECIMEN\
_CONTAINER where (container_code in (select container_code  from RL_CONTAINER_\
FOR_SPECIMEN_TYPE where specimen_type_code=:b1) and NVL(volume_unit,'!!!!')=NV\
L(:b2,'!!!!')) order by req_volume            ";

 static const char *sq0023 = 
"select contr_msr_panel_id  from or_order_catalog where ((contr_mod_id='RL' a\
nd order_type_code=:b0) and order_catalog_code in (select B.order_catalog_code\
  from or_order A ,or_order_line B where (((A.order_id=:b1 and A.order_id=B.or\
der_id) and A.order_type_code=:b0) and A.ordering_facility_id=:b3)))          \
 ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,195,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,646,0,4,239,0,0,15,5,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
111,0,0,3,77,0,4,286,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
134,0,0,4,0,0,30,361,0,0,0,0,0,1,0,
149,0,0,5,0,0,30,369,0,0,0,0,0,1,0,
164,0,0,6,198,0,4,396,0,0,6,2,0,1,0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,
9,0,0,
203,0,0,7,235,0,4,409,0,0,8,2,0,1,0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,1,9,0,0,
250,0,0,8,231,0,9,446,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
273,0,0,8,0,0,13,460,0,0,1,0,0,1,0,2,9,0,0,
292,0,0,9,225,0,9,503,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
319,0,0,9,0,0,15,514,0,0,0,0,0,1,0,
334,0,0,9,0,0,13,525,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,3,0,0,
361,0,0,10,152,0,4,592,0,0,5,3,0,1,0,2,3,0,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
396,0,0,11,105,0,4,605,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,3,0,0,
423,0,0,12,118,0,4,631,0,0,1,0,0,1,0,2,9,0,0,
442,0,0,13,126,0,4,652,0,0,1,0,0,1,0,2,9,0,0,
461,0,0,14,136,0,4,679,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
488,0,0,15,224,0,3,716,0,0,3,3,0,1,0,1,9,0,0,1,3,0,0,1,9,0,0,
515,0,0,16,87,0,4,731,0,0,1,0,0,1,0,2,9,0,0,
534,0,0,17,75,0,4,752,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
557,0,0,18,90,0,4,765,0,0,2,1,0,1,0,2,3,0,0,1,9,0,0,
580,0,0,19,85,0,4,775,0,0,2,1,0,1,0,2,3,0,0,1,9,0,0,
603,0,0,20,282,0,4,809,0,0,4,3,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
634,0,0,21,426,0,9,840,0,0,4,4,0,1,0,1,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
665,0,0,21,0,0,13,842,0,0,5,0,0,1,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,3,0,0,
700,0,0,21,0,0,15,849,0,0,0,0,0,1,0,
715,0,0,21,0,0,15,879,0,0,0,0,0,1,0,
730,0,0,22,356,0,9,903,0,0,3,3,0,1,0,1,3,0,0,1,9,0,0,1,9,0,0,
757,0,0,22,0,0,13,905,0,0,5,0,0,1,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,3,0,0,
792,0,0,22,0,0,15,912,0,0,0,0,0,1,0,
807,0,0,22,0,0,15,943,0,0,0,0,0,1,0,
822,0,0,23,311,0,9,970,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
853,0,0,23,0,0,13,982,0,0,1,0,0,1,0,2,9,0,0,
872,0,0,24,200,0,4,1026,0,0,5,3,0,1,0,2,3,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
907,0,0,25,139,0,4,1039,0,0,4,2,0,1,0,2,3,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
938,0,0,26,97,0,4,1050,0,0,3,1,0,1,0,2,3,0,0,2,9,0,0,1,9,0,0,
965,0,0,23,0,0,15,1122,0,0,0,0,0,1,0,
980,0,0,27,116,0,4,1239,0,0,3,1,0,1,0,2,3,0,0,2,9,0,0,1,9,0,0,
1007,0,0,28,175,0,4,1269,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1030,0,0,29,136,0,4,1301,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
1057,0,0,30,96,0,4,1332,0,0,2,1,0,1,0,2,97,0,0,1,9,0,0,
1080,0,0,31,61,0,4,1355,0,0,1,0,0,1,0,2,1,0,0,
1099,0,0,32,4047,0,6,1396,0,0,11,11,0,1,0,1,9,0,0,1,9,0,0,2,97,0,0,2,3,0,0,2,
97,0,0,2,97,0,0,2,3,0,0,2,97,0,0,2,97,0,0,2,97,0,0,2,3,0,0,
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
		nd_pgm_dt               [50],
		nd_trx_ind				[2],
		nd_printer_type         [2],
		d_patient_id            [21], 
		d_section_code          [3],
		d_specimen_type_code    [21],
		d_specimen_type_desc    [41],
		d_episode_type			[2],
		d_order_id				[21],
		d_order_type_code	    [5],
		d_order_catalog_code    [21],
		nd_catalog_code			[21],
		d_test_code             [21],
		d_test_code1            [21],
		d_specimen_no			[21], 
		d_urgent_indicator		[3],
		d_request_num			[21],
		d_flag					[2],
		d_pat_name              [61],
		d_source_type			[2],
		d_source_code			[7],
		d_patient_class			[5],	
		er_msg                  [171], 
		nd_interval_specimen_yn [2],

/o**************** variables added for enhancement **********o/
        //d_facility_name			[40],
		d_facility_name			[300],
		d_dob					[17],
		d_start_date_time		[17],
		d_start_date_time1		[10],
		d_actual_patient_id		[21],
		d_description			[21],
		d_desc_on_label			[31],
		d_ref_location			[21],
		nd_file_no				[100],
		d_container_code		[5],
		vol_specimen_no			[21],
		d_volume_unit			[5],
		d_prep_text				[41],
		d_pat_dob_no_of_days	[10],
		d_sex					[2],
		d_unit					[6],
		nd_print_source_type	[2],
		nd_print_source			[7]; */ 
struct { unsigned short len; unsigned char arr[42]; } uid_pwd;

struct { unsigned short len; unsigned char arr[2]; } nd_source_type;

struct { unsigned short len; unsigned char arr[7]; } nd_fm_source;

struct { unsigned short len; unsigned char arr[2]; } d_no_copy;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[50]; } nd_session_id;

struct { unsigned short len; unsigned char arr[50]; } nd_ws_no;

struct { unsigned short len; unsigned char arr[50]; } nd_pgm_dt;

struct { unsigned short len; unsigned char arr[2]; } nd_trx_ind;

struct { unsigned short len; unsigned char arr[2]; } nd_printer_type;

struct { unsigned short len; unsigned char arr[21]; } d_patient_id;

struct { unsigned short len; unsigned char arr[3]; } d_section_code;

struct { unsigned short len; unsigned char arr[21]; } d_specimen_type_code;

struct { unsigned short len; unsigned char arr[41]; } d_specimen_type_desc;

struct { unsigned short len; unsigned char arr[2]; } d_episode_type;

struct { unsigned short len; unsigned char arr[21]; } d_order_id;

struct { unsigned short len; unsigned char arr[5]; } d_order_type_code;

struct { unsigned short len; unsigned char arr[21]; } d_order_catalog_code;

struct { unsigned short len; unsigned char arr[21]; } nd_catalog_code;

struct { unsigned short len; unsigned char arr[21]; } d_test_code;

struct { unsigned short len; unsigned char arr[21]; } d_test_code1;

struct { unsigned short len; unsigned char arr[21]; } d_specimen_no;

struct { unsigned short len; unsigned char arr[3]; } d_urgent_indicator;

struct { unsigned short len; unsigned char arr[21]; } d_request_num;

struct { unsigned short len; unsigned char arr[2]; } d_flag;

struct { unsigned short len; unsigned char arr[61]; } d_pat_name;

struct { unsigned short len; unsigned char arr[2]; } d_source_type;

struct { unsigned short len; unsigned char arr[7]; } d_source_code;

struct { unsigned short len; unsigned char arr[5]; } d_patient_class;

struct { unsigned short len; unsigned char arr[171]; } er_msg;

struct { unsigned short len; unsigned char arr[2]; } nd_interval_specimen_yn;

struct { unsigned short len; unsigned char arr[300]; } d_facility_name;

struct { unsigned short len; unsigned char arr[17]; } d_dob;

struct { unsigned short len; unsigned char arr[17]; } d_start_date_time;

struct { unsigned short len; unsigned char arr[10]; } d_start_date_time1;

struct { unsigned short len; unsigned char arr[21]; } d_actual_patient_id;

struct { unsigned short len; unsigned char arr[21]; } d_description;

struct { unsigned short len; unsigned char arr[31]; } d_desc_on_label;

struct { unsigned short len; unsigned char arr[21]; } d_ref_location;

struct { unsigned short len; unsigned char arr[100]; } nd_file_no;

struct { unsigned short len; unsigned char arr[5]; } d_container_code;

struct { unsigned short len; unsigned char arr[21]; } vol_specimen_no;

struct { unsigned short len; unsigned char arr[5]; } d_volume_unit;

struct { unsigned short len; unsigned char arr[41]; } d_prep_text;

struct { unsigned short len; unsigned char arr[10]; } d_pat_dob_no_of_days;

struct { unsigned short len; unsigned char arr[2]; } d_sex;

struct { unsigned short len; unsigned char arr[6]; } d_unit;

struct { unsigned short len; unsigned char arr[2]; } nd_print_source_type;

struct { unsigned short len; unsigned char arr[7]; } nd_print_source;



		int  d_container_volume ,
		     d_test_volume = 0,
			 d_volume	   = 0,
			 d_no_labels   = 0,
			 d_total       = 0,
			 d_con_count   = 0,
			 d_label_cnt   = 1,	 
			 d_req_volume	,
			 d_testvolume     ;

 char string_var [100];
 short d_specimen_type_ind;       

/*tern  char WORKING_DIR_NAME [75];*/

       		int d_count = 0;
			int i_count = 0;
			int c_count = 0;
			int er_msg_type = 0;	
			int err_flag = 0;

  /*---- For Histopathology -----*/	
  char h_specimen_no[100][21];
  int  h_orderlinenum[100]; 
  char h_catalog_code[100][21];
  char h_sampleid[100][6];
  int  h_sampleseq[100];
  char h_fieldmnemonic[100][21];
  char h_fieldvalue[100][60];
  char h_testcode[100][21];
  char h_labeldesc[100][31];
  int  h_volume[100];
  char h_unit[100][5];   
  
  int  h_histo_count = 0;	
  char h_seq_type;
  char h_ind[3];

  /*------ For Volume Unit ------*/	
  struct str_volumeunit
  {
    char v_specimen_no[21];
    char v_testcode[1000];
	int  v_testvolume;
	char v_unit[5];
	char v_labeldesc[31];
	int  v_contvolume;
	int  v_nolabels;
	char v_contcode[5];	
	char v_testdesc[21];
  } s_volumeunit[500];

  /*------ For Interval test ------*/	
  struct str_intervaltest
  {
    char i_specimen_no[21];
	char i_testcode[21];
	int  i_testvolume;
	char i_unit[5];
	char i_labeldesc[31];
	int  i_contvolume;
	int  i_nolabels;
	char i_contcode[5];	
	char i_testdesc[21];
  } s_intervaltest[500];
  
int v_index	= 0,  
    v_interval_index = 0,
    v_i;
  	
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
char *command;  
char gtt_yn = 'N';

void proc_main(argc,argv)
int argc;
char *argv[];
{
  
  err_flag = 0;

  if(argc != 11) 
  {
        ins_message(ERR_MESG,"rlrcolbl : Usage -  arguments wrong\n");
   }
	
    strcpy(filename,WORKING_DIR);
    strcat(filename,"rlrcolbl.lis");

    strcpy(uid_pwd.arr,argv[1]);
    uid_pwd.len = strlen(uid_pwd.arr); 

    strcpy(nd_session_id.arr, argv[2]);
    nd_session_id.len = strlen(nd_session_id.arr);

    strcpy(nd_pgm_dt.arr, argv[3]);
    nd_pgm_dt.len = strlen(nd_pgm_dt.arr);

    strcpy(nd_facility_id.arr, argv[5]);
    nd_facility_id.len = strlen(nd_facility_id.arr);

    strcpy(d_order_type_code.arr,argv[6]);
    d_order_type_code.len = strlen(d_order_type_code.arr);

    strcpy(d_order_id.arr,argv[7]);
    d_order_id.len = strlen(d_order_id.arr);

    strcpy(nd_source_type.arr, argv[8]);
    nd_source_type.len = strlen(nd_source_type.arr);

    strcpy(nd_fm_source.arr, argv[9]);
    nd_fm_source.len = strlen(nd_fm_source.arr);

    strcpy(nd_ws_no.arr, argv[10]);
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



	//increment_file_no();

	if ( ( f1 = fopen ( filename, "w" ) ) == NULL ) 
	{
		ins_message(ERR_MESG,"Error in opening output file...\n");  
	 }

	/*
	* Enable or Disable tracing
	*/
	EnableOrDisableTracing();

      set_meduser_role();

 	d_patient_id.arr[0]				= '\0';
	d_patient_id.len				= 0;
	d_start_date_time.arr[0]		= '\0';			
	d_start_date_time.len			= 0;
	d_start_date_time1.arr[0]		= '\0';
	d_start_date_time1.len			= 0;
	d_episode_type.arr[0]			= '\0';
	d_episode_type.len				= 0;
	d_specimen_type_code.arr[0]		= '\0';
	d_specimen_type_code.len		= 0;
	d_urgent_indicator.arr[0]		= '\0';
	d_urgent_indicator.len			= 0;
	d_section_code.arr[0]			= '\0';
	d_section_code.len				= 0;
	d_request_num.arr[0]			= '\0';
	d_request_num.len				= 0;
	d_specimen_type_desc.arr[0]		= '\0';
	d_specimen_type_desc.len		= 0;
	d_source_type.arr[0]			= '\0';
	d_source_type.len				= 0;
	d_source_code.arr[0]			= '\0';
	d_source_code.len				= 0;
	d_patient_class.arr[0]			= '\0'; 
	d_patient_class.len				= 0;
	d_order_catalog_code.arr[0]		= '\0';
	d_order_catalog_code.len		= 0;


  	/* EXEC SQL SELECT  A.patient_id,
			     A.source_type, 
			     A.source_code,
			     A.patient_class,
			     decode(nvl(A.priority,'R'),'R','RO','S','ST','U','UR'),
			     TO_CHAR(B.start_date_time,'DD/MM/YYYY HH24:MI'),
				 TO_CHAR(B.start_date_time,'DDMONYY'),
			     B.accession_num,
			     B.order_catalog_code,
			     C.specimen_type
		      INTO :d_patient_id,
			     :d_source_type, 
			     :d_source_code,
			     :d_patient_class,
			     :d_urgent_indicator,
			     :d_start_date_time,
				 :d_start_date_time1,
			     :d_request_num,
			     :d_order_catalog_code,
			     :d_specimen_type_code INDICATOR :d_specimen_type_ind
		      FROM or_order A, or_order_line B, or_order_line_lb C
	          WHERE  A.order_id = :d_order_id
    			AND  B.order_id = :d_order_id
    			AND  C.order_id = :d_order_id
    			AND  A.order_id = B.order_id
    			AND  B.order_id = C.order_id
    			AND  A.order_id = C.order_id
    			AND  B.order_line_num = C.order_line_num
    			AND  B.order_line_num = 1
		      AND  A.order_type_code      = :d_order_type_code
			AND  A.ordering_facility_id = :nd_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select A.patient_id ,A.source_type ,A.source_code ,A.patie\
nt_class ,decode(nvl(A.priority,'R'),'R','RO','S','ST','U','UR') ,TO_CHAR(B.st\
art_date_time,'DD/MM/YYYY HH24:MI') ,TO_CHAR(B.start_date_time,'DDMONYY') ,B.a\
ccession_num ,B.order_catalog_code ,C.specimen_type into :b0,:b1,:b2,:b3,:b4,:\
b5,:b6,:b7,:b8,:b9:b10  from or_order A ,or_order_line B ,or_order_line_lb C w\
here (((((((((A.order_id=:b11 and B.order_id=:b11) and C.order_id=:b11) and A.\
order_id=B.order_id) and B.order_id=C.order_id) and A.order_id=C.order_id) and\
 B.order_line_num=C.order_line_num) and B.order_line_num=1) and A.order_type_c\
ode=:b14) and A.ordering_facility_id=:b15)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )36;
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
   sqlstm.sqhstv[1] = (         void  *)&d_source_type;
   sqlstm.sqhstl[1] = (unsigned int  )4;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_source_code;
   sqlstm.sqhstl[2] = (unsigned int  )9;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_patient_class;
   sqlstm.sqhstl[3] = (unsigned int  )7;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_urgent_indicator;
   sqlstm.sqhstl[4] = (unsigned int  )5;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_start_date_time;
   sqlstm.sqhstl[5] = (unsigned int  )19;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&d_start_date_time1;
   sqlstm.sqhstl[6] = (unsigned int  )12;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&d_request_num;
   sqlstm.sqhstl[7] = (unsigned int  )23;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&d_order_catalog_code;
   sqlstm.sqhstl[8] = (unsigned int  )23;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&d_specimen_type_code;
   sqlstm.sqhstl[9] = (unsigned int  )23;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)&d_specimen_type_ind;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&d_order_id;
   sqlstm.sqhstl[10] = (unsigned int  )23;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&d_order_id;
   sqlstm.sqhstl[11] = (unsigned int  )23;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&d_order_id;
   sqlstm.sqhstl[12] = (unsigned int  )23;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&d_order_type_code;
   sqlstm.sqhstl[13] = (unsigned int  )7;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&nd_facility_id;
   sqlstm.sqhstl[14] = (unsigned int  )5;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
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



	d_patient_class.arr[d_patient_class.len]	= '\0';

    if (NO_DATA_FOUND)
	{
		sprintf(string_var,"%s -> %s\n",d_order_id.arr,sqlca.sqlerrm.sqlerrmc);
		ins_message(ERR_MESG, string_var);
     }

    if (OERROR)
	{
		sprintf(string_var,"%s -> %s\n",d_order_id.arr,sqlca.sqlerrm.sqlerrmc);
		ins_message(ERR_MESG, string_var);
     }


	/* EXEC SQL SELECT  episode_type
			   INTO :d_episode_type
			   FROM  MP_EPISODE_TYPE_VW
			  WHERE  patient_class = :d_patient_class; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 15;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select episode_type into :b0  from MP_EPISODE_TYPE_VW where \
patient_class=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )111;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_episode_type;
 sqlstm.sqhstl[0] = (unsigned int  )4;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_patient_class;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}



     d_patient_id.arr[d_patient_id.len]				    = '\0';
	 d_start_date_time.arr[d_start_date_time.len]		= '\0';								
	 d_start_date_time1.arr[d_start_date_time1.len]		= '\0';								
	 d_episode_type.arr[d_episode_type.len]			    = '\0';
	 d_specimen_type_code.arr[d_specimen_type_code.len]	= '\0';
	 d_urgent_indicator.arr[d_urgent_indicator.len]		= '\0';
	 d_section_code.arr[d_section_code.len]			    = '\0';
	 d_request_num.arr[d_request_num.len]			    = '\0';
	 d_specimen_type_desc.arr[d_specimen_type_desc.len]	= '\0';
	 d_source_code.arr[d_source_code.len]			    = '\0';
	 d_source_type.arr[d_source_type.len]			    = '\0';	 
	 d_order_catalog_code.arr[d_order_catalog_code.len]	= '\0';


	 if(NO_DATA_FOUND)
	 {
		sprintf(string_var,"%s -> %s\n",d_order_id.arr,sqlca.sqlerrm.sqlerrmc);
		ins_message(ERR_MESG, string_var);
	  }

	 get_facility_name();
	 get_trans_ind();

   	 dclr_cur();

	 get_patient_details();
	 //get_prep_text(); [Commented] 

     get_printer_type();
	 get_test_code(); //Get the test code to calculate the volume 
	 d_no_labels = get_no_labels(d_request_num.arr); //Total number of labels to be print
	 d_count = 0;
 
     if (strcmp(nd_printer_type.arr,"3")!= 0)
  	   set_fonts();


	 check_flex_exist();


	 if (strcmp(h_ind,"SA") == 0)
	  {
	     get_sequence_type();
	     histo_label();
        }
	 else
	   {
		 for (v_i=0;v_i<v_index;v_i++)
		   {
			if ( ( f1 = fopen ( filename, "w" ) ) == NULL ) 
			  {
				ins_message(ERR_MESG,"Error in opening output file...\n");  
			  }

			 print_label(v_i);
			 print_test_code(v_i);
			 fclose(f1);
				
			 if (strcmp(nd_printer_type.arr,"3")!= 0) 
			   {
				fprintf(f1, "%cE", ESC);
				set_fonts();
			   }
			 if (err_flag == 0)
			   {
				print_barcode_label(s_volumeunit[v_i].v_nolabels);
			   }
              }    
	    }
	  	
    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 15;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )134;
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

    sprintf(string_var,"%s -> %s\n",d_order_id.arr, sqlca.sqlerrm.sqlerrmc);
    ins_message(ORA_MESG,string_var);
    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 15;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )149;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



}

get_patient_details()
{

	d_pat_name.arr[0]				= '\0';
	d_actual_patient_id.arr[0]		= '\0';
	d_ref_location.arr[0]			= '\0';	
	d_sex.arr[0]					= '\0';
	d_dob.arr[0]					= '\0';
	d_pat_dob_no_of_days.arr[0]		= '\0';

	d_actual_patient_id.len		= 0;
	d_pat_name.len				= 0;
	d_ref_location.len			= 0;
	d_sex.len					= 0;
	d_dob.len					= 0;
	d_pat_dob_no_of_days.len	= 0;



	if (strcmp(d_episode_type.arr, "I") == 0 || 
	    strcmp(d_episode_type.arr, "O") == 0 || 
	    strcmp(d_episode_type.arr, "H") == 0)
	{
			/* EXEC SQL SELECT SUBSTR(short_name, 1, 30),
					    sex,
						TO_CHAR(date_of_birth,'DDMONYY'),							
					    ROUND(TRUNC(TO_DATE(:d_start_date_time,'DD/MM/YYYY HH24:MI')) - DATE_OF_BIRTH)
				    INTO :d_pat_name,
					   :d_sex,
					   :d_dob,
					   :d_pat_dob_no_of_days
				    FROM MP_PATIENT_MAST
				   WHERE PATIENT_ID = :d_patient_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select SUBSTR(short_name,1,30) ,sex ,TO_CHAR(date_of_birth\
,'DDMONYY') ,ROUND((TRUNC(TO_DATE(:b0,'DD/MM/YYYY HH24:MI'))-DATE_OF_BIRTH)) i\
nto :b1,:b2,:b3,:b4  from MP_PATIENT_MAST where PATIENT_ID=:b5";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )164;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_start_date_time;
   sqlstm.sqhstl[0] = (unsigned int  )19;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_pat_name;
   sqlstm.sqhstl[1] = (unsigned int  )63;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_sex;
   sqlstm.sqhstl[2] = (unsigned int  )4;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_dob;
   sqlstm.sqhstl[3] = (unsigned int  )19;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_pat_dob_no_of_days;
   sqlstm.sqhstl[4] = (unsigned int  )12;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_patient_id;
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


	}
	else
	{
			/* EXEC SQL SELECT SUBSTR(short_name, 1, 30),
						actual_patient_id, 
						location,
						sex,
						TO_CHAR(date_of_birth,'DDMONYY'),							
						ROUND(TRUNC(TO_DATE(:d_start_date_time,'DD/MM/YYYY HH24:MI')) - DATE_OF_BIRTH)
				   INTO :d_pat_name, 
				        :d_actual_patient_id, 
						:d_ref_location,
						:d_sex,
						:d_dob,
						:d_pat_dob_no_of_days
					 FROM RL_PATIENT_MAST
					WHERE PATIENT_ID = :d_patient_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select SUBSTR(short_name,1,30) ,actual_patient_id ,locatio\
n ,sex ,TO_CHAR(date_of_birth,'DDMONYY') ,ROUND((TRUNC(TO_DATE(:b0,'DD/MM/YYYY\
 HH24:MI'))-DATE_OF_BIRTH)) into :b1,:b2,:b3,:b4,:b5,:b6  from RL_PATIENT_MAST\
 where PATIENT_ID=:b7";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )203;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_start_date_time;
   sqlstm.sqhstl[0] = (unsigned int  )19;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_pat_name;
   sqlstm.sqhstl[1] = (unsigned int  )63;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_actual_patient_id;
   sqlstm.sqhstl[2] = (unsigned int  )23;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_ref_location;
   sqlstm.sqhstl[3] = (unsigned int  )23;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_sex;
   sqlstm.sqhstl[4] = (unsigned int  )4;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_dob;
   sqlstm.sqhstl[5] = (unsigned int  )19;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&d_pat_dob_no_of_days;
   sqlstm.sqhstl[6] = (unsigned int  )12;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&d_patient_id;
   sqlstm.sqhstl[7] = (unsigned int  )23;
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

	d_pat_name.arr[d_pat_name.len]						= '\0';
	d_actual_patient_id.arr[d_actual_patient_id.len]	= '\0';
	d_ref_location.arr[d_ref_location.len]				= '\0';
	d_sex.arr[d_sex.len]								= '\0';
	d_dob.arr[d_dob.len]								= '\0';
	d_pat_dob_no_of_days.arr[d_pat_dob_no_of_days.len]	= '\0';

}

dclr_cur()
{
		/* EXEC SQL DECLARE c2 CURSOR FOR
			     SELECT order_catalog_code  
				 FROM or_order_line
				WHERE order_type_code = :d_order_type_code
				  AND order_id = :d_order_id
				  AND order_line_status NOT IN 
					(SELECT order_status_code 
					   FROM OR_ORDER_STATUS_CODE 
                        WHERE ORDER_STATUS_TYPE IN ('93','96','99')); */ 


		/* EXEC SQL OPEN c2; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 15;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0008;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )250;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_order_type_code;
  sqlstm.sqhstl[0] = (unsigned int  )7;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_order_id;
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

			
    
    if (OERROR) 
	{
	  sprintf(string_var,"%s  dclr_cur() -> %s\n", d_order_id.arr, sqlca.sqlerrm.sqlerrmc);
	  ins_message(ORA_MESG, string_var);
      }
}

int fetch_catalog_code() 
{

    d_order_catalog_code.arr[d_order_catalog_code.len]	= '\0';

    /* EXEC SQL FETCH c2 INTO :d_order_catalog_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 15;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )273;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_order_catalog_code;
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


 
    if (OERROR)
	{
	  sprintf(string_var,"%s  fetch_catalog_code() -> %s\n", d_order_id.arr, sqlca.sqlerrm.sqlerrmc);
	  ins_message(ORA_MESG, string_var);
      }

    if (NO_DATA_FOUND)
      return 0;
  
    d_order_catalog_code.arr[d_order_catalog_code.len]	       = '\0';
 
    return 1;  
}

print_test_code(int ind)
{
   int test_code ;
   int count= 1;
   int spaces ;

   fprintf(f1,"%-40.40s ",s_volumeunit[ind].v_testcode);

   if (i_count > 0)
		fprintf(f1, "\n%-25.25s", s_volumeunit[ind].v_testdesc);
	
   /*[Commented]
   if (d_prep_text.len > 0)
		fprintf(f1, "\n%-25.25s", d_prep_text.arr);*/
}

get_interval_specimens()
{

    /* EXEC SQL DECLARE interval_curs CURSOR FOR
		  SELECT test_code, TO_CHAR(specimen_no),	seq_no
		    FROM RL_INTERVAL_TEST_SPECIMENS
		   WHERE interval_test_specimen_no = TO_NUMBER(:d_request_num)
                 AND operating_facility_id = :nd_facility_id
		     AND specimen_no <> TO_NUMBER(:d_request_num)
		ORDER BY specimen_no; */ 


	/* EXEC SQL OPEN interval_curs; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 15;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0009;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )292;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_request_num;
 sqlstm.sqhstl[0] = (unsigned int  )23;
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
 sqlstm.sqhstv[2] = (         void  *)&d_request_num;
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

     

	while(fetch_interval_curs())
	{
	    strcpy(s_intervaltest[v_interval_index].i_specimen_no,d_specimen_no.arr);
	    strcpy(s_intervaltest[v_interval_index].i_testcode,d_test_code.arr);		
	    get_interval_desc();
	    strcpy(s_intervaltest[v_interval_index].i_testdesc,d_description.arr);
	    v_interval_index += 1;
	}

	/* EXEC SQL CLOSE interval_curs; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 15;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )319;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

int fetch_interval_curs()
{

	d_test_code.arr[d_test_code.len]		= '\0';
	d_specimen_no.arr[d_specimen_no.len]	= '\0';
	d_count = 0;


      /* EXEC SQL FETCH interval_curs INTO :d_test_code, :d_specimen_no , d_count; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 15;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )334;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&d_test_code;
      sqlstm.sqhstl[0] = (unsigned int  )23;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&d_specimen_no;
      sqlstm.sqhstl[1] = (unsigned int  )23;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&d_count;
      sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
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
	{
	  sprintf(string_var,"%s fetch_interval_curs()-> %s\n", d_order_id.arr, sqlca.sqlerrm.sqlerrmc);
	  ins_message(ORA_MESG, string_var);

     }

   if (NO_DATA_FOUND)
     return 0;
  
   d_test_code.arr[d_test_code.len]	      = '\0';
   d_specimen_no.arr[d_specimen_no.len]   = '\0';
 
   return 1;
  
}


print_label(int v_ind)
{

	fprintf(f1, "%s\n", d_facility_name.arr);
	if (strlen(s_volumeunit[v_ind].v_labeldesc) > 0) 
	  {	
	   fprintf(f1, "%s", s_volumeunit[v_ind].v_labeldesc);	   

	   if (s_volumeunit[v_ind].v_contvolume > 0) 
		 {
		  fprintf(f1," %d",s_volumeunit[v_ind].v_contvolume);
		   if (strcmp(s_volumeunit[v_ind].v_unit,"!!!!")!=0)
			 {fprintf(f1,"%s",s_volumeunit[v_ind].v_unit);}
		  }
	      fprintf(f1,"\n");	
       } 

	if (strcmp(nd_printer_type.arr,"3")!=0)	
	  {
	     print_barcode(f1,s_volumeunit[v_ind].v_specimen_no, 0, 0, 40, 250,atoi(nd_printer_type.arr));
	     fprintf(f1,"\n");  
	  }
	else
	 {
	     print_barcode(f1,s_volumeunit[v_ind].v_specimen_no, 0, 0, 40, 250,atoi(nd_printer_type.arr));		
	     fprintf(f1,"\n");
	 }

	fprintf(f1, "%-s", s_volumeunit[v_ind].v_specimen_no);	
	fprintf(f1," %s",d_urgent_indicator.arr);
	fprintf(f1," %s\n",d_start_date_time1.arr);
	fprintf(f1,"%-20s\n",  d_pat_name.arr);
	fprintf(f1, "%-4s   ", d_source_code.arr);

	if (strlen(d_actual_patient_id.arr) > 0)
	   fprintf(f1, "%-s", d_actual_patient_id.arr);
	else
	   fprintf(f1, "%-s", d_patient_id.arr);

	fprintf(f1, " %s", d_sex.arr);
    fprintf(f1, " %s\n", d_dob.arr);

//	fprintf(f1, "\n");
}

get_interval_test()
{
	/* EXEC SQL SELECT seq_no, seq_no
		     INTO :i_count, :d_count
		     FROM RL_INTERVAL_TEST_SPECIMENS
		    WHERE specimen_no = TO_NUMBER(:d_request_num)
			AND operating_facility_id = :nd_facility_id
			AND test_code = :d_test_code1; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 15;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select seq_no ,seq_no into :b0,:b1  from RL_INTERVAL_TEST_SP\
ECIMENS where ((specimen_no=TO_NUMBER(:b2) and operating_facility_id=:b3) and \
test_code=:b4)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )361;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&i_count;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_count;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_request_num;
 sqlstm.sqhstl[2] = (unsigned int  )23;
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
 sqlstm.sqhstv[4] = (         void  *)&d_test_code1;
 sqlstm.sqhstl[4] = (unsigned int  )23;
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


}

get_interval_desc()
{
	d_description.arr[0]		= '\0';
	d_description.len			= 0;

	/* EXEC SQL SELECT SUBSTR(description, 1, 20)
		     INTO :d_description
		     FROM RL_INTERVAL_TEST_DESC
		    WHERE test_code = :d_test_code1
			  AND seq_no = :d_count; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 15;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select SUBSTR(description,1,20) into :b0  from RL_INTERVAL_T\
EST_DESC where (test_code=:b1 and seq_no=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )396;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_description;
 sqlstm.sqhstl[0] = (unsigned int  )23;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_test_code1;
 sqlstm.sqhstl[1] = (unsigned int  )23;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_count;
 sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
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


	
	d_description.arr[d_description.len]  = '\0';	
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

/******************* added on 28.07.2003 ********/
get_printer_type()
{

	  strcpy(nd_printer_type.arr, "3");
	  
	  /* EXEC SQL SELECT NVL(printer_type, '1')
  	           INTO  :nd_printer_type
  	           FROM   SY_ONLINE_PRINT_ID
	           WHERE  module_id = 'RL'
	           AND    online_print_name = 'RLRCOLBL'; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select NVL(printer_type,'1') into :b0  from SY_ONLINE_PRIN\
T_ID where (module_id='RL' and online_print_name='RLRCOLBL')";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )423;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_printer_type;
   sqlstm.sqhstl[0] = (unsigned int  )4;
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

 

        if(NO_DATA_FOUND)
   		strcpy(nd_printer_type.arr, "3");
  	  if(OERROR)
   		strcpy(nd_printer_type.arr, "3");

	  nd_printer_type.arr[nd_printer_type.len]  = '\0';

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
   		         AND ONLINE_PRINT_NAME = 'RLRCOLBL'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 15;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select NVL(TRANSACTION_BASED_YN,'N') into :b0  from sy_onlin\
e_print_id where (MODULE_ID='RL' and ONLINE_PRINT_NAME='RLRCOLBL')";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )442;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_trx_ind;
 sqlstm.sqhstl[0] = (unsigned int  )4;
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
	{
		sprintf(string_var,"%s get_trans_ind()-> %s\n", d_order_id.arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
	}

	nd_trx_ind.arr[nd_trx_ind.len]   = '\0';

      if(NO_DATA_FOUND)
		return 0;
		
	return 1;

}

get_test_code()
{
	
	d_test_code.arr[0]	= '\0';
	d_test_code.len		= 0;

	/* EXEC SQL  SELECT CONTR_MSR_PANEL_ID
			INTO :d_test_code
			FROM OR_ORDER_CATALOG
		   WHERE CONTR_MOD_ID    = 'RL'
			 AND ORDER_TYPE_CODE = :d_order_type_code
	         AND ORDER_CATALOG_CODE = :d_order_catalog_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 15;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select CONTR_MSR_PANEL_ID into :b0  from OR_ORDER_CATALOG wh\
ere ((CONTR_MOD_ID='RL' and ORDER_TYPE_CODE=:b1) and ORDER_CATALOG_CODE=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )461;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_test_code;
 sqlstm.sqhstl[0] = (unsigned int  )23;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_order_type_code;
 sqlstm.sqhstl[1] = (unsigned int  )7;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_order_catalog_code;
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



    if(NO_DATA_FOUND)
	{
		sprintf(string_var,"%s get_test_code()-> %s\n", d_order_id.arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
	}

	if(OERROR)
	{
		sprintf(string_var,"%s get_test_code()-> %s\n", d_order_id.arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
	}

	d_test_code.arr[d_test_code.len]			= '\0';

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
         (:nd_facility_id,'RLRCOLBL',:er_msg_type,NULL, SUBSTR(:er_msg, 1, 70),SYSDATE,USERENV('sessionid'),TO_CHAR(SYSDATE,'DD/MM/YYYY')); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "insert into SY_PROG_MSG (OPERATING_FACILITY_ID,PGM_ID,MSG_\
TYPE,MSG_NUM,MSG_DESC,MSG_DATE_TIME,SESSION_ID,PGM_DATE) values (:b0,'RLRCOLBL\
',:b1,null ,SUBSTR(:b2,1,70),SYSDATE,USERENV('sessionid'),TO_CHAR(SYSDATE,'DD/\
MM/YYYY'))";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )488;
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
/**************************************/
increment_file_no()
{
     nd_file_no.arr[0]   = '\0';   
     nd_file_no.len      = 0;

     /* EXEC SQL 
	          SELECT LTRIM(RTRIM(TO_CHAR(RL_PRINT_CTL_SEQ.NEXTVAL,'00000009')))
	            INTO :nd_file_no
	            FROM DUAL; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 15;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select LTRIM(RTRIM(TO_CHAR(RL_PRINT_CTL_SEQ.nextval ,'00\
000009'))) into :b0  from DUAL ";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )515;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_file_no;
     sqlstm.sqhstl[0] = (unsigned int  )102;
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



     if (OERROR)
         ins_message(ORA_MESG,"Fetch failed on while getting file number");
      
     nd_file_no.arr[nd_file_no.len] = '\0';

	strcat(filename, "_");
	strcat(filename, nd_file_no.arr);

}

/************** Hospital name **********/
get_facility_name()
{
  d_facility_name.arr[0] = '\0';
  d_facility_name.len    = 0;

  /* EXEC SQL
     SELECT FACILITY_NAME 
       INTO :d_facility_name
       FROM SM_FACILITY_PARAM
      WHERE FACILITY_ID = :nd_facility_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 15;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select FACILITY_NAME into :b0  from SM_FACILITY_PARAM where\
 FACILITY_ID=:b1";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )534;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_facility_name;
  sqlstm.sqhstl[0] = (unsigned int  )302;
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



  d_facility_name.arr[d_facility_name.len] = '\0';
}

/****************** Get Container Code *******************/
int check_container_code()
{
 
    /* EXEC SQL 
    SELECT count(1) 
      INTO :d_con_count
      FROM RL_CONTAINER_FOR_SPECIMEN_TYPE
     WHERE specimen_type_code = :d_specimen_type_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 15;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select count(1) into :b0  from RL_CONTAINER_FOR_SPECIMEN_\
TYPE where specimen_type_code=:b1";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )557;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_con_count;
    sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_specimen_type_code;
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

    

    if (d_con_count > 0)
	  return 1;
    else      
	  {
		/* EXEC SQL
		SELECT count(1)
		  INTO :d_con_count
		  FROM RL_AGE_SEX_SPEC_TYPE_CONT
		 WHERE specimen_type_code = :d_specimen_type_code; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 15;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select count(1) into :b0  from RL_AGE_SEX_SPEC_TYPE_CONT wh\
ere specimen_type_code=:b1";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )580;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_con_count;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_specimen_type_code;
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


		
		if (d_con_count > 0)
		   return 1;
		else      
		   return 0;
       }
    
	 if (OERROR)
	  {
	    sprintf(string_var,"%s  check_container_code() -> %s\n", d_order_id.arr, 			
			sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
        }
 
 }

/***************** Get Container Label and Volume ********************/
 get_container_volume(int ind,char interval_yn)
{
	int j,k;    	
	
	d_container_code.arr[0]	= '\0';
    d_container_code.len	= 0;
	d_desc_on_label.arr[0]	= '\0';
	d_desc_on_label.len		= 0;
	d_volume_unit.arr[0]	= '\0';
	d_volume_unit.len   	= 0;


	/* EXEC SQL SELECT COUNT(1) INTO :c_count
	           FROM RL_AGE_SEX_SPEC_TYPE_CONT  
	          WHERE specimen_type_code = :d_specimen_type_code	
	            AND TO_NUMBER(:d_pat_dob_no_of_days)
	        BETWEEN calc_min_age_in_days AND calc_max_age_in_days
			    AND container_code IN
				    (
					  SELECT container_code 
					    FROM RL_SPECIMEN_CONTAINER
					   WHERE NVL(volume_unit,'!!!!') = NVL(:d_unit,'!!!!')
					 ); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 15;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select count(1) into :b0  from RL_AGE_SEX_SPEC_TYPE_CONT whe\
re ((specimen_type_code=:b1 and TO_NUMBER(:b2) between calc_min_age_in_days an\
d calc_max_age_in_days) and container_code in (select container_code  from RL_\
SPECIMEN_CONTAINER where NVL(volume_unit,'!!!!')=NVL(:b3,'!!!!')))";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )603;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&c_count;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_specimen_type_code;
 sqlstm.sqhstl[1] = (unsigned int  )23;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_pat_dob_no_of_days;
 sqlstm.sqhstl[2] = (unsigned int  )12;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_unit;
 sqlstm.sqhstl[3] = (unsigned int  )8;
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



    if (c_count > 0)
      {

			/* EXEC SQL DECLARE age_con_code_cur CURSOR FOR
					  SELECT container_code,
							 NVL(volume,0) volume,
							 volume_unit,
							 NVL(SUBSTR(long_desc,1,30),' ')  long_desc,
							 ABS(NVL(volume,0) - :d_testvolume) req_volume
						FROM RL_SPECIMEN_CONTAINER
					   WHERE container_code IN (
							    SELECT container_code
								FROM RL_AGE_SEX_SPEC_TYPE_CONT  
								WHERE specimen_type_code = :d_specimen_type_code	
								AND TO_NUMBER(:d_pat_dob_no_of_days)
								BETWEEN calc_min_age_in_days AND calc_max_age_in_days)
					     AND NVL(volume_unit,'!!!!') = NVL(:d_unit,'!!!!')
					   ORDER BY req_volume; */ 
		   

	    /* EXEC SQL OPEN age_con_code_cur; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 15;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0021;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )634;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&d_testvolume;
     sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_specimen_type_code;
     sqlstm.sqhstl[1] = (unsigned int  )23;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&d_pat_dob_no_of_days;
     sqlstm.sqhstl[2] = (unsigned int  )12;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&d_unit;
     sqlstm.sqhstl[3] = (unsigned int  )8;
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



		/* EXEC SQL FETCH age_con_code_cur INTO 
						:d_container_code,
						:d_container_volume,
						:d_volume_unit,
						:d_desc_on_label,
						:d_req_volume; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 15;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )665;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_container_code;
  sqlstm.sqhstl[0] = (unsigned int  )7;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_container_volume;
  sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_volume_unit;
  sqlstm.sqhstl[2] = (unsigned int  )7;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_desc_on_label;
  sqlstm.sqhstl[3] = (unsigned int  )33;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_req_volume;
  sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
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



		/* EXEC SQL CLOSE age_con_code_cur; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 15;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )700;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		d_container_code.arr[d_container_code.len]	= '\0';
		d_desc_on_label.arr[d_desc_on_label.len]	= '\0';
		d_volume_unit.arr[d_volume_unit.len]		= '\0';	

 	    if ( interval_yn == 'N')
		 {
			strcpy(s_volumeunit[ind].v_labeldesc,d_desc_on_label.arr);
			s_volumeunit[ind].v_contvolume = d_container_volume;
			strcpy(s_volumeunit[ind].v_contcode,d_container_code.arr);
		 }	
		else if ( interval_yn == 'Y')
		 {
			for (k=0;k<v_interval_index;k++)			
			 {
			   strcpy(s_intervaltest[k].i_labeldesc,d_desc_on_label.arr);
			   s_intervaltest[k].i_contvolume = d_container_volume;
			   strcpy(s_intervaltest[k].i_contcode,d_container_code.arr);
			  }
		  }	
		if (OERROR)
		{
		  sprintf(string_var,"%s  get_container_volume age() -> %s\n", d_specimen_no.arr,
				sqlca.sqlerrm.sqlerrmc);
			ins_message(ORA_MESG, string_var);
		}

		if (NO_DATA_FOUND)
			{
				/* EXEC SQL CLOSE age_con_code_cur; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 15;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )715;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


				return 0;   }
		
		return 1;

	   }
	else
	 {

		/* EXEC SQL DECLARE con_code_cur CURSOR FOR
				  SELECT container_code,
						 NVL(volume,0) volume,
						 volume_unit,
						 NVL(SUBSTR(long_desc,1,30),' ')  long_desc,
						 ABS(NVL(volume,0) - :d_testvolume) req_volume
				    FROM RL_SPECIMEN_CONTAINER
				   WHERE container_code IN (
    						SELECT container_code
    						FROM  RL_CONTAINER_FOR_SPECIMEN_TYPE
    						WHERE specimen_type_code = :d_specimen_type_code)
					 AND NVL(volume_unit,'!!!!') = NVL(:d_unit,'!!!!')
		           ORDER BY req_volume; */ 
	

	
	    /* EXEC SQL OPEN con_code_cur; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 15;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0022;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )730;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&d_testvolume;
     sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_specimen_type_code;
     sqlstm.sqhstl[1] = (unsigned int  )23;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&d_unit;
     sqlstm.sqhstl[2] = (unsigned int  )8;
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



		/* EXEC SQL FETCH con_code_cur INTO 
						:d_container_code,
						:d_container_volume,
						:d_volume_unit,
						:d_desc_on_label,
						:d_req_volume; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 15;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )757;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_container_code;
  sqlstm.sqhstl[0] = (unsigned int  )7;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_container_volume;
  sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_volume_unit;
  sqlstm.sqhstl[2] = (unsigned int  )7;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_desc_on_label;
  sqlstm.sqhstl[3] = (unsigned int  )33;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_req_volume;
  sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
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



		/* EXEC SQL CLOSE con_code_cur; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 15;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )792;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		d_container_code.arr[d_container_code.len]	= '\0';
		d_desc_on_label.arr[d_desc_on_label.len]	= '\0';
		d_volume_unit.arr[d_volume_unit.len]		= '\0';	

 	    if ( interval_yn == 'N') 
		 {
			strcpy(s_volumeunit[ind].v_labeldesc,d_desc_on_label.arr);
			s_volumeunit[ind].v_contvolume = d_container_volume;
			strcpy(s_volumeunit[ind].v_contcode,d_container_code.arr);
		 }	
		else if ( interval_yn == 'Y')
		 {
			for (k=0;k<v_interval_index;k++)			
			 {
			   strcpy(s_intervaltest[k].i_labeldesc,d_desc_on_label.arr);
			   s_intervaltest[k].i_contvolume = d_container_volume;
			   strcpy(s_intervaltest[k].i_contcode,d_container_code.arr);
			  }
		  }	

		if (OERROR)
		{
		sprintf(string_var,"%s  get_container_volume() -> %s\n", d_order_id.arr,
				sqlca.sqlerrm.sqlerrmc);
			ins_message(ORA_MESG, string_var);
			}

		if (NO_DATA_FOUND)
			{
				/* EXEC SQL CLOSE con_code_cur; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 15;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )807;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


				return 0;   }
		
		return 1;
 
	}
	

 }
 
 /********************  Get test codes   ************************/
void dclr_test_cur()
{
 
		/* EXEC SQL DECLARE test_cur CURSOR FOR
			     SELECT contr_msr_panel_id
				 FROM or_order_catalog
				 WHERE contr_mod_id = 'RL'
				 AND order_type_code = :d_order_type_code
				 AND order_catalog_code IN 
					( SELECT B.order_catalog_code
					  FROM   or_order A, or_order_line B
					  WHERE	 A.order_id = :d_order_id
					  AND	 A.order_id = B.order_id
					  AND    A.order_type_code = :d_order_type_code
					  AND    A.ordering_facility_id = :nd_facility_id); */ 


		/* EXEC SQL OPEN test_cur; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 15;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0023;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )822;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_order_type_code;
  sqlstm.sqhstl[0] = (unsigned int  )7;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_order_id;
  sqlstm.sqhstl[1] = (unsigned int  )23;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_order_type_code;
  sqlstm.sqhstl[2] = (unsigned int  )7;
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


		

     return;
}

int fetch_test()
{

	d_test_code1.arr[0]	= '\0';
	d_test_code1.len		= 0;

      /* EXEC SQL FETCH test_cur INTO :d_test_code1; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 15;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )853;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&d_test_code1;
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


 
    if (OERROR)
	{
		sprintf(string_var,"%s  fetch_test() -> %s\n", d_order_id.arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
     }

	 if (NO_DATA_FOUND)
        return 0;
  
    d_test_code1.arr[d_test_code1.len] = '\0';

    return 1;
      
}  


 /***************** Get volume for all Tests ********************/
 get_test_volume()

 {  
   int ins_test_yn = 1,
       int_test_yn = 0;
   int j,k; 	
   dclr_test_cur();	

   while(fetch_test())
   {	  

	 d_volume_unit.arr[0]		= '\0';
	 d_volume_unit.len		= 0;


	 if (i_count == 0)
		{	
			get_interval_test();	
			get_interval_desc(); 
			
			if (i_count > 0) 
				int_test_yn = 1; 
		}

	  /*-- Volume for specific age range --*/	
 	    /* EXEC SQL SELECT NVL(volume,0),
				  NVL(volume_unit,'!!!!')
			   INTO  :d_volume,
				   :d_volume_unit
			   FROM   RL_AGE_SEX_TEST_VOLUME
			   WHERE  TEST_CODE = :d_test_code1
			   AND	  specimen_type_code = :d_specimen_type_code
			   AND   :d_pat_dob_no_of_days
			   BETWEEN CALC_MIN_AGE_IN_DAYS AND CALC_MAX_AGE_IN_DAYS; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 15;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "select NVL(volume,0) ,NVL(volume_unit,'!!!!') into :b0,\
:b1  from RL_AGE_SEX_TEST_VOLUME where ((TEST_CODE=:b2 and specimen_type_code=\
:b3) and :b4 between CALC_MIN_AGE_IN_DAYS and CALC_MAX_AGE_IN_DAYS)";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )872;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&d_volume;
      sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&d_volume_unit;
      sqlstm.sqhstl[1] = (unsigned int  )7;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&d_test_code1;
      sqlstm.sqhstl[2] = (unsigned int  )23;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&d_specimen_type_code;
      sqlstm.sqhstl[3] = (unsigned int  )23;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&d_pat_dob_no_of_days;
      sqlstm.sqhstl[4] = (unsigned int  )12;
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



      if (NO_DATA_FOUND)
		{
			/*-- Volume for specimen type --*/
			/* EXEC SQL SELECT NVL(volume,0),
					    NVL(volume_unit,'!!!!')
					 INTO	:d_volume,
						:d_volume_unit
					 FROM   RL_SPECIMEN_TYPE_FOR_TEST
					 WHERE  test_code = :d_test_code1
					 AND	  specimen_type_code = :d_specimen_type_code; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select NVL(volume,0) ,NVL(volume_unit,'!!!!') into :b0,:b1\
  from RL_SPECIMEN_TYPE_FOR_TEST where (test_code=:b2 and specimen_type_code=:\
b3)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )907;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_volume;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_volume_unit;
   sqlstm.sqhstl[1] = (unsigned int  )7;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_test_code1;
   sqlstm.sqhstl[2] = (unsigned int  )23;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_specimen_type_code;
   sqlstm.sqhstl[3] = (unsigned int  )23;
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


		
				if(NO_DATA_FOUND)
				  {
						/*-- Volume for Test --*/
						/* EXEC SQL SELECT NVL(volume,0),
								    NVL(volume_unit,'!!!!') 
								 INTO   :d_volume,
									  :d_volume_unit 
 								 FROM   RL_TEST_CODE
								 WHERE  test_code = :d_test_code1; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 15;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "select NVL(volume,0) ,NVL(volume_unit,'!!!!') into :b0,\
:b1  from RL_TEST_CODE where test_code=:b2";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )938;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&d_volume;
      sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&d_volume_unit;
      sqlstm.sqhstl[1] = (unsigned int  )7;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&d_test_code1;
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


				
					
						if(NO_DATA_FOUND)
							d_volume = 0;
				  }
		}
	

      if (OERROR)
		{
			sprintf(string_var,"%s get_test_volume() -> %s\n", d_order_id.arr,
					sqlca.sqlerrm.sqlerrmc);
			ins_message(ORA_MESG, string_var);  
        }
	 
	 d_volume_unit.arr[d_volume_unit.len] = '\0';
	 

		 for (j=0;j<v_index;j++)
		  {
			if (strcmp(s_volumeunit[j].v_unit,d_volume_unit.arr) == 0) //If unit is exist
			  {
		  		strcat(s_volumeunit[j].v_testcode,",");
				strcat(s_volumeunit[j].v_testcode,d_test_code1.arr);
				s_volumeunit[j].v_testvolume += d_volume;											
				ins_test_yn = 0;
				
				if (int_test_yn > 0)
			  	  { 				   
					strcpy(s_volumeunit[j].v_testdesc,d_description.arr);
					get_interval_specimens();
					for (k=0;k<v_interval_index;k++)
				 	{
				   	  s_intervaltest[k].i_testvolume = d_volume;
				      strcpy(s_intervaltest[k].i_unit,d_volume_unit.arr);
				  	}					
					int_test_yn = 0;
			        }
				break;
			   }
		   }

	 if (ins_test_yn) //For new volume unit
	  {		
		strcpy(s_volumeunit[v_index].v_specimen_no,d_request_num.arr);
		strcpy(s_volumeunit[v_index].v_testcode,d_test_code1.arr);
		s_volumeunit[v_index].v_testvolume  = d_volume;		
		strcpy(s_volumeunit[v_index].v_unit,d_volume_unit.arr);

		if (int_test_yn > 0)
		  { 				   
			strcpy(s_volumeunit[v_index].v_testdesc,d_description.arr);	
			get_interval_specimens();
			for (k=0;k<v_interval_index;k++)
			 {
			   s_intervaltest[k].i_testvolume = d_volume;
			   strcpy(s_intervaltest[k].i_unit,d_volume_unit.arr);
			  }					
			int_test_yn = 0;
		   }

		v_index += 1;
	  }

	}

	/* EXEC SQL CLOSE test_cur; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 15;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )965;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	return 1;
 }

/****************** Get Total Number of Labels Required ********************/
 int get_no_labels(char *l_specimen_no)
{		 
    double t_test_vol,t_con_vol,t_tot;
    int k;    

    strcpy(vol_specimen_no.arr,l_specimen_no);
    vol_specimen_no.len = strlen(vol_specimen_no.arr);	

	d_test_volume = 0;
	get_test_volume();	   			//Populate array with all test

	if (d_specimen_type_ind != -1)  //If specimen type exists
	 { 
	   if (check_container_code())	//If container exist, calculate volume & label cnt
		 {
			  // Non GTT specimen
			  for (k=0;k<v_index;k++)
				{
				  d_testvolume = s_volumeunit[k].v_testvolume;
				  strcpy(d_unit.arr,s_volumeunit[k].v_unit);
				  d_unit.len = strlen(d_unit.arr);

				  get_container_volume(k,'N');
				  if (s_volumeunit[k].v_testvolume > s_volumeunit[k].v_contvolume)
				   {
				     d_label_cnt = 1; //to reset
					 t_test_vol = s_volumeunit[k].v_testvolume; 
					 t_con_vol  = s_volumeunit[k].v_contvolume;

					 d_total = ceil(t_test_vol/t_con_vol);
					 d_label_cnt = d_total * d_label_cnt;					
					 s_volumeunit[k].v_nolabels = d_label_cnt;
				   }		
				  else // If test volume is less than container volume
				   {
					 s_volumeunit[k].v_nolabels = 1;
					} 	 
				}
			
			// GTT specimen
 			if (strlen(s_intervaltest[0].i_testcode) > 0) 
			  {	
				d_testvolume = s_intervaltest[0].i_testvolume;
				strcpy(d_unit.arr,s_intervaltest[0].i_unit);
				d_unit.len = strlen(d_unit.arr);

				get_container_volume(0,'Y');			
				if (s_intervaltest[0].i_testvolume > s_intervaltest[0].i_contvolume)			   
 				  { 
				     d_label_cnt = 1; //to reset
					 t_test_vol = s_intervaltest[0].i_testvolume; 
					 t_con_vol  = s_intervaltest[0].i_contvolume;

					 d_total = ceil(t_test_vol/t_con_vol);
					 d_label_cnt = d_total * d_label_cnt;					
					 s_intervaltest[0].i_nolabels = d_label_cnt;
				   }
				  else // If test volume is less than container volume
				   {
					 s_intervaltest[k].i_nolabels = 1;
					}
				}

		 }
	   else				//If container not exists, get label cnt from master
	     {		   
		   get_label_cnt_master();
		   for (k=0;k<v_index;k++)
		     {
				strcpy(s_volumeunit[k].v_labeldesc,d_desc_on_label.arr);
				s_volumeunit[k].v_nolabels = d_label_cnt;
			 }
		  }
	 }
	else					// If no specimen type
	 {
	     for (k=0;k<v_index;k++)
		  {
			s_volumeunit[k].v_nolabels = 1;
		  }
	 }
	
	if (strlen(s_intervaltest[0].i_testdesc) > 0)
	{
	  			 
       for(k=0;k<v_interval_index;k++)
	    {
	     s_intervaltest[k].i_nolabels = d_label_cnt;

		 strcpy(s_volumeunit[v_index].v_specimen_no,s_intervaltest[k].i_specimen_no);
		 strcpy(s_volumeunit[v_index].v_testcode,s_intervaltest[k].i_testcode);
		 strcpy(s_volumeunit[v_index].v_unit,s_intervaltest[k].i_unit);
		 strcpy(s_volumeunit[v_index].v_labeldesc,s_intervaltest[k].i_labeldesc);
		 strcpy(s_volumeunit[v_index].v_contcode,s_intervaltest[k].i_contcode);
		 strcpy(s_volumeunit[v_index].v_testdesc,s_intervaltest[k].i_testdesc);
		 s_volumeunit[v_index].v_testvolume = s_intervaltest[k].i_testvolume;
		 s_volumeunit[v_index].v_contvolume = s_intervaltest[k].i_contvolume;
		 s_volumeunit[v_index].v_nolabels = s_intervaltest[k].i_nolabels;
		 v_index += 1;
		}
	 }
    return 1;		
}

/***************** Get the Label Count from Master *********************/
get_label_cnt_master()

{

	d_desc_on_label.arr[0]		= '\0';
	d_desc_on_label.len			= 0;

	/* EXEC SQL 
	SELECT NVL(no_of_coll_labels,1) ,
	       desc_on_label	
	  INTO :d_label_cnt,
		 :d_desc_on_label
	  FROM RL_SPECIMEN_TYPE_CODE 
	 WHERE specimen_type_code = :d_specimen_type_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 15;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select NVL(no_of_coll_labels,1) ,desc_on_label into :b0,:b1 \
 from RL_SPECIMEN_TYPE_CODE where specimen_type_code=:b2";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )980;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_label_cnt;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_desc_on_label;
 sqlstm.sqhstl[1] = (unsigned int  )33;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_specimen_type_code;
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



	d_desc_on_label.arr[d_desc_on_label.len] = '\0';

    if (OERROR)
	{
	  sprintf(string_var,"%s  get_label_cnt_master() -> %s\n", d_order_id.arr,
			sqlca.sqlerrm.sqlerrmc);
	  ins_message(ORA_MESG, string_var);
      }

    if (NO_DATA_FOUND)		
        return 0;   

    return 1;
}

/*************** Get the Preparation Text from Order ********************/
int get_prep_text()
{

	d_prep_text.arr[0] = '\0';
	d_prep_text.len = 0;

	/* EXEC SQL
	SELECT substr(order_line_field_value,1,30)
	INTO  :d_prep_text
	FROM   OR_ORDER_LINE_FIELD_VALUES
	WHERE  order_id = :d_order_id
	AND	 order_line_num = 1
	AND    order_line_field_mnemonic = 'PAT_PREPS_TEXT'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 15;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select substr(order_line_field_value,1,30) into :b0  from OR\
_ORDER_LINE_FIELD_VALUES where ((order_id=:b1 and order_line_num=1) and order_\
line_field_mnemonic='PAT_PREPS_TEXT')";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1007;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_prep_text;
 sqlstm.sqhstl[0] = (unsigned int  )43;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_order_id;
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



    d_prep_text.arr[d_prep_text.len] = '\0';

	if (OERROR)
	{
	  sprintf(string_var,"%s  get_prep_text() -> %s\n", d_order_id.arr,
			sqlca.sqlerrm.sqlerrmc);
	  ins_message(ORA_MESG, string_var);
      }

    if (NO_DATA_FOUND)
        return 0;   

    return 1;  

}

/******************* Get Catalog Code ***************/

get_catalog_from_test()
{
	
	nd_catalog_code.arr[0]	= '\0';
	nd_catalog_code.len		= 0;

	/* EXEC SQL  SELECT ORDER_CATALOG_CODE
		    INTO  :nd_catalog_code
		    FROM   OR_ORDER_CATALOG
		    WHERE  CONTR_MOD_ID    = 'RL'
		    AND    ORDER_TYPE_CODE = :d_order_type_code
	        AND    CONTR_MSR_PANEL_ID = :d_test_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 15;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select ORDER_CATALOG_CODE into :b0  from OR_ORDER_CATALOG wh\
ere ((CONTR_MOD_ID='RL' and ORDER_TYPE_CODE=:b1) and CONTR_MSR_PANEL_ID=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1030;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_catalog_code;
 sqlstm.sqhstl[0] = (unsigned int  )23;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_order_type_code;
 sqlstm.sqhstl[1] = (unsigned int  )7;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_test_code;
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



    if(NO_DATA_FOUND)
	{
		sprintf(string_var,"%s get_catalog_code()-> %s\n", d_order_id.arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
	}

	if(OERROR)
	{
		sprintf(string_var,"%s get_catalog_code()-> %s\n", d_order_id.arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
	}


	nd_catalog_code.arr[nd_catalog_code.len]			= '\0';

}

/*------------------------- Histo Samples -------------------------*/


/****************** Check Flex Exists *********************/
check_flex_exist()
{

     /* EXEC SQL 
    SELECT NVL(USE_SAMPLE_ANATOMY_IND,'!!') 
      INTO :h_ind
      FROM RL_SECTION_CODE
     WHERE ORDER_TYPE_CODE = :d_order_type_code; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 15;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select NVL(USE_SAMPLE_ANATOMY_IND,'!!') into :b0  from R\
L_SECTION_CODE where ORDER_TYPE_CODE=:b1";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1057;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)h_ind;
     sqlstm.sqhstl[0] = (unsigned int  )3;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_order_type_code;
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



    if(NO_DATA_FOUND)
	{
		sprintf(string_var,"%s check_flex_exist()-> %s\n", d_order_id.arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
	}

	if(OERROR)
	{
		sprintf(string_var,"%s check_flex_exist()-> %s\n", d_order_id.arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
	}

}

/***************** Histo Sequence Type ********************/
get_sequence_type()
{
	/* EXEC SQL
	SELECT NVL(SAMPLE_SEQUENCE_TYPE,'N')
	  INTO :h_seq_type
	  FROM RL_PARAM; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 15;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select NVL(SAMPLE_SEQUENCE_TYPE,'N') into :b0  from RL_PARAM\
 ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1080;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&h_seq_type;
 sqlstm.sqhstl[0] = (unsigned int  )1;
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



    if(NO_DATA_FOUND)
	{
		sprintf(string_var,"%s get_sequence_type()-> %s\n", d_order_id.arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
	}

	if(OERROR)
	{
		sprintf(string_var,"%s get_sequence_type()-> %s\n", d_order_id.arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
	}
}


/********************* Histo Label ************************/
histo_label()
{
  int i=1;

  get_sample_details();
  get_label_desc();
  for (i=0;i< h_histo_count;i++)
   {
	if ( ( f1 = fopen ( filename, "w" ) ) == NULL ) 
		{
   	  	    ins_message(ERR_MESG,"Error in opening output file...\n");  
		}
		print_histo_label(i);
   }

}


/********************* get_sample_details *****************/
get_sample_details()
{
  /* EXEC SQL EXECUTE
	DECLARE 
		CURSOR c1 IS	
		SELECT B.accession_num,
			   B.order_line_num,
			   B.order_catalog_code,
			   A.order_line_field_mnemonic,
			   substr(A.order_line_field_value,1,50) order_line_field_value
		FROM   OR_ORDER_LINE_FIELD_VALUES A, OR_ORDER_LINE_HIS_VW B
		WHERE  A.ORDER_ID = :d_order_id		
		AND    A.ORDER_ID = B.ORDER_ID
		AND    A.ORDER_LINE_NUM  = B.ORDER_LINE_NUM
		AND    A.ORDER_LINE_FIELD_MNEMONIC IN ('ANATOMY_SITE','TISSUE_DESC','FIXATIVE')
		AND    B.ORDER_LINE_STATUS IN (SELECT ORDER_STATUS_CODE 
							   FROM OR_ORDER_STATUS_CODE 
							  WHERE ORDER_STATUS_TYPE NOT IN ('93','96','99'))
		ORDER BY B.order_line_num,order_line_seq_num;

	      v_stat	     VARCHAR2(1);
		q_stat	     VARCHAR2(1);
		d_stat	     VARCHAR2(1);

		l_anatomy_yn     VARCHAR2(2);
		l_fixative_yn    VARCHAR2(2);
		l_tissue_desc_yn VARCHAR2(2);
		l_sample_yn		 VARCHAR2(2);
		
		l_anatomy_code   VARCHAR2(60);
		l_fixative_code  VARCHAR2(60);
		l_tissue_desc    VARCHAR2(60);
		l_test_code	     VARCHAR2(21);
		l_old_catalog 	 VARCHAR2(21);

		v_sample_id      VARCHAR2(6);
		v_seq_no         NUMBER := 1;
		  

		PROCEDURE GEN_ALPHA_NUMERIC_SERIES(V_SEQ_NO	IN	 NUMBER,
							     V_ALPHA_SEQ	IN OUT VARCHAR2,
							     V_STAT		   OUT VARCHAR2) IS			
			l_string   VARCHAR2(50);
			v_no	     NUMBER;
		BEGIN
		   v_stat      := 'Y';
		   v_alpha_seq := 0;
				
		   l_string := 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
		   v_no := v_seq_no;

		   IF v_seq_no BETWEEN 53 AND 78 THEN
   				v_alpha_seq	:= 'B';
  				v_no := v_seq_no - 52;
  				v_alpha_seq := v_alpha_seq || SUBSTR(l_string, v_no, 1);	
		   ELSIF v_seq_no BETWEEN 27 AND 52 THEN
  				v_alpha_seq	:= 'A';
  				v_no := v_seq_no - 26;
  				v_alpha_seq := v_alpha_seq || SUBSTR(l_string, v_no, 1);	
		   ELSE
  			  v_alpha_seq := SUBSTR(l_string, v_no, 1);
		   END IF;

		EXCEPTION
		  WHEN OTHERS THEN 
  			 V_STAT := 'N';	
		END;		 	
	
	BEGIN

		l_anatomy_yn	 := 'N';
		l_fixative_yn	 := 'N';
		l_tissue_desc_yn := 'N';
	    l_sample_yn      := 'N';

		FOR cnt IN c1
	      LOOP		 		   
		  	
			IF nvl(l_old_catalog,'!') <> cnt.order_catalog_code then
				l_sample_yn := 'N';
				l_old_catalog := cnt.order_catalog_code;
			
				BEGIN
					SELECT CONTR_MSR_PANEL_ID
					INTO   l_test_code
					FROM   OR_ORDER_CATALOG
					WHERE  CONTR_MOD_ID    = 'RL'
					AND    ORDER_TYPE_CODE = :d_order_type_code
					AND    ORDER_CATALOG_CODE = cnt.order_catalog_code;						  
				EXCEPTION
					WHEN NO_DATA_FOUND THEN
					   l_test_code := cnt.order_catalog_code;
				END;

			END IF;

			IF cnt.order_line_field_mnemonic IN ('ANATOMY_SITE') THEN
				l_anatomy_yn := 'Y';
				l_anatomy_code := cnt.order_line_field_value;	
			ELSIF cnt.order_line_field_mnemonic IN ('FIXATIVE') THEN
				l_fixative_yn := 'Y';
				l_fixative_code := cnt.order_line_field_value;
			ELSIF cnt.order_line_field_mnemonic IN ('TISSUE_DESC') THEN
				l_tissue_desc_yn := 'Y';	    
				l_tissue_desc := cnt.order_line_field_value;
			END IF;


			IF NVL(l_anatomy_yn, 'N')     = 'Y' AND 
			   NVL(l_fixative_yn, 'N')    = 'Y' AND 
			   NVL(l_tissue_desc_yn, 'N') = 'Y' THEN 	     	
			
			   l_anatomy_yn		:= 'N';
			   l_fixative_yn	:= 'N';
			   l_tissue_desc_yn := 'N';
			   
			   v_stat := 'N';
			   q_stat := 'N';	
			   d_stat := 'N';			      
		       
			   IF l_anatomy_code IS NOT NULL THEN
			      v_stat := 'Y';
				  
				  IF l_fixative_code IS NOT NULL THEN
			         q_stat := 'Y';
		          END IF;
		   
		          IF l_tissue_desc IS NOT NULL THEN
			         d_stat := 'Y';
		          END IF;

		          IF NVL(v_stat, 'N') = 'Y' AND 
				     NVL(q_stat, 'N') = 'Y' AND   
					 NVL(d_stat, 'N') = 'Y' THEN 
					 
					 l_sample_yn := 'Y';

					 GEN_ALPHA_NUMERIC_SERIES(v_seq_no,v_sample_id,v_stat); 
					 
					 :h_specimen_no(v_seq_no)   := cnt.accession_num;
					 :h_orderlinenum(v_seq_no)  := cnt.order_line_num; 
					 :h_catalog_code(v_seq_no)  := cnt.order_catalog_code;					 
					 :h_sampleid(v_seq_no)	    := v_sample_id;
					 :h_sampleseq(v_seq_no)     := v_seq_no;
					 :h_fieldmnemonic(v_seq_no) := cnt.order_line_field_mnemonic;
					 :h_fieldvalue(v_seq_no)    := cnt.order_line_field_value;
					 :h_testcode(v_seq_no)		:= l_test_code;
					  v_seq_no := v_seq_no + 1;

				  END IF;
			   END IF;
		    
	          IF  l_sample_yn = 'N' THEN
				:h_specimen_no(v_seq_no)   := cnt.accession_num;
				:h_orderlinenum(v_seq_no)  := cnt.order_line_num; 
		 		:h_catalog_code(v_seq_no)  := cnt.order_catalog_code;
				:h_testcode(v_seq_no)	   := l_test_code;
				 
				 l_sample_yn := 'Y';
				 v_seq_no := v_seq_no + 1;

		      END IF;

			END IF;	
	    END LOOP;
		:h_histo_count := v_seq_no - 1;
	END;

  END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 15;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlbuft((void **)0, 
    "declare CURSOR c1 IS SELECT B . accession_num , B . order_line_num , B \
. order_catalog_code , A . order_line_field_mnemonic , substr ( A . order_li\
ne_field_value , 1 , 50 ) order_line_field_value FROM OR_ORDER_LINE_FIELD_VA\
LUES A , OR_ORDER_LINE_HIS_VW B WHERE A . ORDER_ID = :d_order_id AND A . ORD\
ER_ID = B . ORDER_ID AND A . ORDER_LINE_NUM = B . ORDER_LINE_NUM AND A . ORD\
ER_LINE_FIELD_MNEMONIC IN ( 'ANATOMY_SITE' , 'TISSUE_DESC' , 'FIXATIVE' ) AN\
D B . ORDER_LINE_STATUS IN ( SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_C\
ODE WHERE ORDER_STATUS_TYPE NOT IN ( '93' , '96' , '99' ) ) ORDER BY B . ord\
er_line_num , order_line_seq_num ; v_stat VARCHAR2 ( 1 ) ; q_stat VARCHAR2 (\
 1 ) ; d_stat VARCHAR2 ( 1 ) ; l_anatomy_yn VARCHAR2 ( 2 ) ; l_fixative_yn V\
ARCHAR2 ( 2 ) ; l_tissue_desc_yn VARCHAR2 ( 2 ) ; l_sample_yn VARCHAR2 ( 2 )\
 ; l_anatomy_code VARCHAR2 ( 60 ) ; l_fixative_code VARCHAR2 ( 60 ) ; l_tiss\
ue_desc VARCHAR2 ( 60 ) ; l_test_code VARCHAR2 ( 21 ) ; l_old_catalog VARCHA\
R2 ( 21 ) ; v_sample_id VARCHAR2 ( 6 ) ; ");
  sqlbuft((void **)0, 
    "v_seq_no NUMBER := 1 ; PROCEDURE GEN_ALPHA_NUMERIC_SERIES ( V_SEQ_NO IN\
 NUMBER , V_ALPHA_SEQ IN OUT VARCHAR2 , V_STAT OUT VARCHAR2 ) IS l_string VA\
RCHAR2 ( 50 ) ; v_no NUMBER ; BEGIN v_stat := 'Y' ; v_alpha_seq := 0 ; l_str\
ing := 'ABCDEFGHIJKLMNOPQRSTUVWXYZ' ; v_no := v_seq_no ; IF v_seq_no BETWEEN\
 53 AND 78 THEN v_alpha_seq := 'B' ; v_no := v_seq_no -52 ; v_alpha_seq := v\
_alpha_seq || SUBSTR ( l_string , v_no , 1 ) ; ELSIF v_seq_no BETWEEN 27 AND\
 52 THEN v_alpha_seq := 'A' ; v_no := v_seq_no -26 ; v_alpha_seq := v_alpha_\
seq || SUBSTR ( l_string , v_no , 1 ) ; ELSE v_alpha_seq := SUBSTR ( l_strin\
g , v_no , 1 ) ; END IF ; EXCEPTION WHEN OTHERS THEN V_STAT := 'N' ; END ; B\
EGIN l_anatomy_yn := 'N' ; l_fixative_yn := 'N' ; l_tissue_desc_yn := 'N' ; \
l_sample_yn := 'N' ; FOR cnt IN c1 LOOP IF nvl ( l_old_catalog , '!' ) <> cn\
t . order_catalog_code then l_sample_yn := 'N' ; l_old_catalog := cnt . orde\
r_catalog_code ; BEGIN SELECT CONTR_MSR_PANEL_ID INTO l_test_code FROM OR_OR\
DER_CATALOG WHERE CONTR_MOD_ID = 'RL' AND");
  sqlbuft((void **)0, 
    " ORDER_TYPE_CODE = :d_order_type_code AND ORDER_CATALOG_CODE = cnt . or\
der_catalog_code ; EXCEPTION WHEN NO_DATA_FOUND THEN l_test_code := cnt . or\
der_catalog_code ; END ; END IF ; IF cnt . order_line_field_mnemonic IN ( 'A\
NATOMY_SITE' ) THEN l_anatomy_yn := 'Y' ; l_anatomy_code := cnt . order_line\
_field_value ; ELSIF cnt . order_line_field_mnemonic IN ( 'FIXATIVE' ) THEN \
l_fixative_yn := 'Y' ; l_fixative_code := cnt . order_line_field_value ; ELS\
IF cnt . order_line_field_mnemonic IN ( 'TISSUE_DESC' ) THEN l_tissue_desc_y\
n := 'Y' ; l_tissue_desc := cnt . order_line_field_value ; END IF ; IF NVL (\
 l_anatomy_yn , 'N' ) = 'Y' AND NVL ( l_fixative_yn , 'N' ) = 'Y' AND NVL ( \
l_tissue_desc_yn , 'N' ) = 'Y' THEN l_anatomy_yn := 'N' ; l_fixative_yn := '\
N' ; l_tissue_desc_yn := 'N' ; v_stat := 'N' ; q_stat := 'N' ; d_stat := 'N'\
 ; IF l_anatomy_code IS NOT NULL THEN v_stat := 'Y' ; IF l_fixative_code IS \
NOT NULL THEN q_stat := 'Y' ; END IF ; IF l_tissue_desc IS NOT NULL THEN d_s\
tat := 'Y' ; END IF ; IF NVL ( v_stat , '");
  sqlstm.stmt = "N' ) = 'Y' AND NVL ( q_stat , 'N' ) = 'Y' AND NVL ( d_stat \
, 'N' ) = 'Y' THEN l_sample_yn := 'Y' ; GEN_ALPHA_NUMERIC_SERIES ( v_seq_no , \
v_sample_id , v_stat ) ; :h_specimen_no ( v_seq_no ) := cnt . accession_num ; \
:h_orderlinenum ( v_seq_no ) := cnt . order_line_num ; :h_catalog_code ( v_seq\
_no ) := cnt . order_catalog_code ; :h_sampleid ( v_seq_no ) := v_sample_id ; \
:h_sampleseq ( v_seq_no ) := v_seq_no ; :h_fieldmnemonic ( v_seq_no ) := cnt .\
 order_line_field_mnemonic ; :h_fieldvalue ( v_seq_no ) := cnt . order_line_fi\
eld_value ; :h_testcode ( v_seq_no ) := l_test_code ; v_seq_no := v_seq_no + 1\
 ; END IF ; END IF ; IF l_sample_yn = 'N' THEN :h_specimen_no ( v_seq_no ) := \
cnt . accession_num ; :h_orderlinenum ( v_seq_no ) := cnt . order_line_num ; :\
h_catalog_code ( v_seq_no ) := cnt . order_catalog_code ; :h_testcode ( v_seq_\
no ) := l_test_code ; l_sample_yn := 'Y' ; v_seq_no := v_seq_no + 1 ; END IF ;\
 END IF ; END LOOP ; :h_histo_count := v_seq_no -1 ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1099;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_order_id;
  sqlstm.sqhstl[0] = (unsigned int  )23;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_order_type_code;
  sqlstm.sqhstl[1] = (unsigned int  )7;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)h_specimen_no;
  sqlstm.sqhstl[2] = (unsigned int  )21;
  sqlstm.sqhsts[2] = (         int  )21;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )100;
  sqlstm.sqharc[2] = (unsigned int   *)0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)h_orderlinenum;
  sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[3] = (         int  )sizeof(int);
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )100;
  sqlstm.sqharc[3] = (unsigned int   *)0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)h_catalog_code;
  sqlstm.sqhstl[4] = (unsigned int  )21;
  sqlstm.sqhsts[4] = (         int  )21;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )100;
  sqlstm.sqharc[4] = (unsigned int   *)0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)h_sampleid;
  sqlstm.sqhstl[5] = (unsigned int  )6;
  sqlstm.sqhsts[5] = (         int  )6;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )100;
  sqlstm.sqharc[5] = (unsigned int   *)0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)h_sampleseq;
  sqlstm.sqhstl[6] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[6] = (         int  )sizeof(int);
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )100;
  sqlstm.sqharc[6] = (unsigned int   *)0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)h_fieldmnemonic;
  sqlstm.sqhstl[7] = (unsigned int  )21;
  sqlstm.sqhsts[7] = (         int  )21;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )100;
  sqlstm.sqharc[7] = (unsigned int   *)0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)h_fieldvalue;
  sqlstm.sqhstl[8] = (unsigned int  )60;
  sqlstm.sqhsts[8] = (         int  )60;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )100;
  sqlstm.sqharc[8] = (unsigned int   *)0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)h_testcode;
  sqlstm.sqhstl[9] = (unsigned int  )21;
  sqlstm.sqhsts[9] = (         int  )21;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )100;
  sqlstm.sqharc[9] = (unsigned int   *)0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&h_histo_count;
  sqlstm.sqhstl[10] = (unsigned int  )sizeof(int);
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

	

} 

/**************** Get Label Desc **************************/
get_label_desc()
{
	int i,j;
	
	for (j=0;j<v_index;j++) 
	{
	  for (i=0;i<h_histo_count;i++)
	   {
		 if (strlen(s_volumeunit[j].v_labeldesc)>0)
		 {	
			if ( strstr(s_volumeunit[j].v_testcode,h_testcode[i]))
		     {
				strcpy(h_labeldesc[i],s_volumeunit[j].v_labeldesc);				
				h_volume[i] = s_volumeunit[j].v_contvolume;
				strcpy(h_unit[i],s_volumeunit[j].v_unit);
              }
		  }
	
        }
	}
}

/****************** Print Histo Label *********************/
print_histo_label(int h_seq)
 {

	fprintf(f1, "%s\n", d_facility_name.arr);
	
	if (strlen(h_labeldesc[h_seq]) > 0)
	  {	
		fprintf(f1, "%s", h_labeldesc[h_seq]);
		
		if (h_volume[h_seq]>0)	
		{
		  fprintf(f1, " %d",h_volume[h_seq]);
		  if (strcmp(h_unit[h_seq],"!!!!") != 0) 
			{fprintf(f1, "%s",h_unit[h_seq]);}
		 }	  
	  }		

	if (strcmp(nd_printer_type.arr,"3")!=0)	
	  {
		print_barcode(f1, d_request_num.arr, 0, 0, 40, 250,atoi(nd_printer_type.arr));
		fprintf(f1,"\n");  
	  }
	else
	  {
		print_barcode(f1, d_request_num.arr, 0, 0, 40, 250,atoi(nd_printer_type.arr));
		fprintf(f1,"\n");
	  }

	fprintf(f1, "%-s", d_request_num.arr);	

	 /*--------  Sample ID ------------------*/
	 if (h_sampleseq[h_seq] > 0 )
	  {
		if (h_seq_type == 'A') 
		  fprintf(f1, "/%s", h_sampleid[h_seq]);
		else 
		  fprintf(f1, "/%d", h_sampleseq[h_seq]);
       }
	/*---------------------------------------*/

	fprintf(f1," %s",d_urgent_indicator.arr);
	fprintf(f1," %s\n",d_start_date_time1.arr);

	fprintf(f1,"%-20s\n",  d_pat_name.arr);
	fprintf(f1, "%-4s ", d_source_code.arr);

    /*---------- Anatomy (commented)---------
	if (strlen(h_fieldvalue[h_cnt]) > 0 )    
	  fprintf(f1, "%-4s ", h_fieldvalue[h_seq]);
	  ---------------------------------------*/

	if (strlen(d_actual_patient_id.arr) > 0)
		fprintf(f1, "%-s", d_actual_patient_id.arr);
	else
		fprintf(f1, "%-s", d_patient_id.arr);

	fprintf(f1, " %s", d_sex.arr);
    fprintf(f1, " %s\n", d_dob.arr);
		
	fprintf(f1,"%s\n",h_testcode[h_seq]);	
	//fprintf(f1, "%-25.25s", d_description.arr);   


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
/***************** Print BarCode Label ********************/
print_barcode_label(int nolabel)
 {
    int i;

    for(i=0;i<nolabel;i++)
		  {
		 		if (nd_source_type.arr[0]	== '!')
				{					

					 WSPrintDocument 
						   (
							uid_pwd.arr,		//char	*PUidPwd;
							nd_session_id.arr,	//char	*PSessionID;
							nd_facility_id.arr,	//char	*PFacilityID;
							"RL",				//char	*PModuleID;
							"RLRCOLBL",			//char	*PDocumentID;
							filename,	    	//char	*POnlinePrintFileNames;
							"O",				//char	*PLocationTypes;
							" ",				//char	*PLocationCodes;
							1,					//int	PNumOfCopies;
							1,				    //int	PPageFrom;
							9999,				//int	PPageTo;
							nd_ws_no.arr,		//char	*PWorkstationID
							WORKING_DIR			//char	*PReportOutputDir
						   );
				}						   
				else
				{
					 
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


					 WSPrintDocument
						   (
							uid_pwd.arr,				//char	*PUidPwd;
							nd_session_id.arr,			//char	*PSessionID;
							nd_facility_id.arr,			//char	*PFacilityID;
							"RL",						//char	*PModuleID;
							"RLRCOLBL",					//char	*PDocumentID;
							filename,	    			//char	*POnlinePrintFileNames;
							nd_print_source_type.arr,	//char	*PLocationTypes;
							nd_print_source.arr,	    //char	*PLocationCodes;
							1,							//int	PNumOfCopies;
							1,							//int	PPageFrom;
							9999,						//int	PPageTo;
							nd_ws_no.arr,				//char	*PWorkstationID
							WORKING_DIR					//char	*PReportOutputDir

						   );
				}	  					   
		  }
 
 }
