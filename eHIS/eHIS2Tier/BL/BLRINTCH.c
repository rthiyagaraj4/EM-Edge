
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
    "C:\\temp\\PROC\\BLRINTCH.pc"
};


static unsigned long sqlctx = 1164422283;


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
            void  *sqhstv[14];
   unsigned int   sqhstl[14];
            int   sqhsts[14];
            void  *sqindv[14];
            int   sqinds[14];
   unsigned int   sqharm[14];
   unsigned int   *sqharc[14];
   unsigned short  sqadto[14];
   unsigned short  sqtdso[14];
} sqlstm = {10,14};

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
"select patient_id ,fr_episode_type ,nvl(fr_episode_id,99999999) ,nvl(fr_visi\
t_id,0)  from BL_INT_COMP_LOG_DTL where ((((fr_facility_id=:b0 and to_facility\
_id=:b1) and user_id=:b2) and SESSION_ID=:b3) and TO_CHAR(start_date_time,'DD/\
MM/RRRRHH24:MI:SS')=:b4)           ";

 static const char *sq0011 = 
"select patient_id ,fr_episode_type ,nvl(fr_episode_id,99999999) ,nvl(fr_visi\
t_id,0)  from BL_INT_COMP_LOG_DTL where ((((fr_facility_id=:b0 and to_facility\
_id=:b1) and user_id=:b2) and SESSION_ID=:b3) and TO_CHAR(start_date_time,'DD/\
MM/RRRRHH24:MI:SS')=:b4)           ";

 static const char *sq0013 = 
"select a.FR_FACILITY_ID ,a.TO_FACILITY_ID ,A.PATIENT_ID ,a.FR_EPISODE_TYPE ,\
nvl(a.FR_EPISODE_ID,99999999) ,nvl(a.FR_VISIT_ID,0) ,decode(:b0,'en',d.short_n\
ame,nvl(d.short_name_loc_lang,d.short_name)) ,a.TO_EPISODE_TYPE ,b.start_date_\
time ,a.FR_ITEM_CODE ,a.FR_SERV_ITEM_DESC ,a.SERVICE_PANEL_IND ,a.BLNG_SERV_PA\
NEL_CODE ,a.CHARGE_AMT  from BL_INT_COMP_LOG_SERV_DTL a ,BL_INT_COMP_LOG_DTL b\
 ,mp_patient_mast d where ((((((((((((A.patient_id=D.patient_id and a.patient_\
id=b.patient_id) and nvl(a.fr_episode_id,99999999)=nvl(b.fr_episode_id,9999999\
9)) and a.fr_episode_type=b.fr_episode_type) and a.user_id=b.user_id) and a.us\
er_id=:b1) and b.patient_id=:b2) and b.fr_episode_type=:b3) and nvl(b.fr_episo\
de_id,99999999)=:b4) and nvl(b.fr_visit_id,0)=:b5) and a.SESSION_ID=b.SESSION_\
ID) and b.SESSION_ID=:b6) and TO_CHAR(b.start_date_time,'DD/MM/RRRRHH24:MI:SS'\
)=:b7) order by TRUNC(b.start_date_time),A.PATIENT_ID            ";

 static const char *sq0014 = 
"select a.FR_FACILITY_ID ,a.TO_FACILITY_ID ,A.PATIENT_ID ,a.FR_EPISODE_TYPE ,\
nvl(a.FR_EPISODE_ID,99999999) ,nvl(a.FR_VISIT_ID,0) ,decode(:b0,'en',d.short_n\
ame,nvl(d.short_name_loc_lang,d.short_name)) ,a.TO_EPISODE_TYPE ,b.start_date_\
time ,a.FR_ITEM_CODE ,a.FR_SERV_ITEM_DESC ,a.SERVICE_PANEL_IND ,a.BLNG_SERV_PA\
NEL_CODE ,a.CHARGE_AMT  from BL_INT_COMP_LOG_SERV_DTL a ,BL_INT_COMP_LOG_DTL b\
 ,mp_patient_mast d where ((((((((((((A.patient_id=D.patient_id and a.patient_\
id=b.patient_id) and nvl(a.fr_episode_id,99999999)=nvl(b.fr_episode_id,9999999\
9)) and a.fr_episode_type=b.fr_episode_type) and a.user_id=b.user_id) and a.us\
er_id=:b1) and b.patient_id=:b2) and b.fr_episode_type=:b3) and nvl(b.fr_episo\
de_id,99999999)=:b4) and nvl(b.fr_visit_id,0)=:b5) and a.SESSION_ID=b.SESSION_\
ID) and b.SESSION_ID=:b6) and TO_CHAR(b.start_date_time,'DD/MM/RRRRHH24:MI:SS'\
)=:b7) order by TRUNC(b.start_date_time),A.PATIENT_ID            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,179,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,110,0,4,186,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
67,0,0,3,95,0,2,198,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
94,0,0,4,0,0,30,232,0,0,0,0,0,1,0,
109,0,0,5,0,0,32,238,0,0,0,0,0,1,0,
124,0,0,6,200,0,4,256,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
159,0,0,7,119,0,4,266,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
186,0,0,8,119,0,4,272,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
213,0,0,9,0,0,32,288,0,0,0,0,0,1,0,
228,0,0,10,267,0,9,337,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
263,0,0,11,267,0,9,339,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
298,0,0,12,0,0,32,345,0,0,0,0,0,1,0,
313,0,0,13,921,0,9,438,0,0,8,8,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,
360,0,0,14,921,0,9,440,0,0,8,8,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,
407,0,0,15,0,0,32,447,0,0,0,0,0,1,0,
422,0,0,10,0,0,13,465,0,0,4,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
453,0,0,11,0,0,13,473,0,0,4,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
484,0,0,16,0,0,32,493,0,0,0,0,0,1,0,
499,0,0,13,0,0,13,525,0,0,14,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,
570,0,0,14,0,0,13,542,0,0,14,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,
641,0,0,17,0,0,32,581,0,0,0,0,0,1,0,
656,0,0,13,0,0,15,596,0,0,0,0,0,1,0,
671,0,0,10,0,0,15,597,0,0,0,0,0,1,0,
686,0,0,14,0,0,15,601,0,0,0,0,0,1,0,
701,0,0,11,0,0,15,602,0,0,0,0,0,1,0,
716,0,0,18,100,0,4,730,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
743,0,0,19,96,0,4,746,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
770,0,0,20,96,0,4,861,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
793,0,0,21,165,0,6,868,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
824,0,0,22,218,0,6,928,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
851,0,0,23,204,0,6,969,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
};


/*************************************************************

Author    :  Harish A   24/01/2004
Name      :  Intercompany-Processed Encounters List
Project   :  BL

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
			l_function_id				[50],
			l_oper_facility_id			[10],
			l_start_date				[30],
			l_end_date					[30],
			l_gen_user_id				[30],
			nd_start_date               [30],
			l_cash_counter_code			[10],
			l_doc_type_code				[10],
			l_doc_num					[15],
			l_doc_date					[30],
			l_bill_nature_code			[10],
			l_bill_print_flag			[10],
			p_language_id			    [3],
			nd_facility_id				[3],
			l_fr_item_code              [30],
			l_fr_item_desc              [101],
			l_service_panel_ind         [4],
			l_blng_serv_panel_code      [20],
			l_blng_serv_panel_desc      [41],
			nd_temp_date				[21],
			nd_temp_date1				[21],
			date_convert				[21],
			date_convert1				[21],
			nd_loc_date					[21],
			nd_loc_date1			    [21],
			l_visit_regn_date_time		[30],
			l_discharge_date_time		[30],
			l_blng_grp_id				[10],
			l_patient_id				[25],
			l_episode_id				[20],
			l_visit_id					[10],
			l_short_name				[41],
			l_frm_facility_id			[4],
			l_to_facility_id			[4],
			nd_fr_facility_id			[4],
			nd_to_facility_id			[4],
			hdr_frm_facility_id			[4],
			hdr_to_facility_id			[4],
			hdr_patient_id              [25],
			hdr_episode_type            [4],
			hdr_episode_id              [9],
			hdr_to_episode_type         [2],
			hdr_visit_id                [5],
			l_frm_patient_id				[21],
			l_prog_id				        [21],
			l_frm_episode_id				[9],
			l_frm_visit_id					[5],
			l_frm_episode_type				[4],
			l_to_episode_type				[4],
			l_previous_visit_date		[30],
			l_previous_discharge_date	[30],	
			l_previous_blng_grp			[10],	
			l_episode_type				[20],
			d_acc_entity_name			[41],
			d_frm_acc_entity_name		[41],
			d_to_acc_entity_name		[41],
			d_user						[21],
			d_sysdate					[30],
			l_pk_value				   [100],
		    l_translated_value		   [201]; */ 
struct { unsigned short len; unsigned char arr[42]; } uid_pwd;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[20]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[50]; } l_function_id;

struct { unsigned short len; unsigned char arr[10]; } l_oper_facility_id;

struct { unsigned short len; unsigned char arr[30]; } l_start_date;

struct { unsigned short len; unsigned char arr[30]; } l_end_date;

struct { unsigned short len; unsigned char arr[30]; } l_gen_user_id;

struct { unsigned short len; unsigned char arr[30]; } nd_start_date;

struct { unsigned short len; unsigned char arr[10]; } l_cash_counter_code;

struct { unsigned short len; unsigned char arr[10]; } l_doc_type_code;

struct { unsigned short len; unsigned char arr[15]; } l_doc_num;

struct { unsigned short len; unsigned char arr[30]; } l_doc_date;

struct { unsigned short len; unsigned char arr[10]; } l_bill_nature_code;

struct { unsigned short len; unsigned char arr[10]; } l_bill_print_flag;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[30]; } l_fr_item_code;

struct { unsigned short len; unsigned char arr[101]; } l_fr_item_desc;

struct { unsigned short len; unsigned char arr[4]; } l_service_panel_ind;

struct { unsigned short len; unsigned char arr[20]; } l_blng_serv_panel_code;

struct { unsigned short len; unsigned char arr[41]; } l_blng_serv_panel_desc;

struct { unsigned short len; unsigned char arr[21]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[21]; } nd_temp_date1;

struct { unsigned short len; unsigned char arr[21]; } date_convert;

struct { unsigned short len; unsigned char arr[21]; } date_convert1;

struct { unsigned short len; unsigned char arr[21]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[21]; } nd_loc_date1;

struct { unsigned short len; unsigned char arr[30]; } l_visit_regn_date_time;

struct { unsigned short len; unsigned char arr[30]; } l_discharge_date_time;

struct { unsigned short len; unsigned char arr[10]; } l_blng_grp_id;

struct { unsigned short len; unsigned char arr[25]; } l_patient_id;

struct { unsigned short len; unsigned char arr[20]; } l_episode_id;

struct { unsigned short len; unsigned char arr[10]; } l_visit_id;

struct { unsigned short len; unsigned char arr[41]; } l_short_name;

struct { unsigned short len; unsigned char arr[4]; } l_frm_facility_id;

struct { unsigned short len; unsigned char arr[4]; } l_to_facility_id;

struct { unsigned short len; unsigned char arr[4]; } nd_fr_facility_id;

struct { unsigned short len; unsigned char arr[4]; } nd_to_facility_id;

struct { unsigned short len; unsigned char arr[4]; } hdr_frm_facility_id;

struct { unsigned short len; unsigned char arr[4]; } hdr_to_facility_id;

struct { unsigned short len; unsigned char arr[25]; } hdr_patient_id;

struct { unsigned short len; unsigned char arr[4]; } hdr_episode_type;

struct { unsigned short len; unsigned char arr[9]; } hdr_episode_id;

struct { unsigned short len; unsigned char arr[2]; } hdr_to_episode_type;

struct { unsigned short len; unsigned char arr[5]; } hdr_visit_id;

struct { unsigned short len; unsigned char arr[21]; } l_frm_patient_id;

struct { unsigned short len; unsigned char arr[21]; } l_prog_id;

struct { unsigned short len; unsigned char arr[9]; } l_frm_episode_id;

struct { unsigned short len; unsigned char arr[5]; } l_frm_visit_id;

struct { unsigned short len; unsigned char arr[4]; } l_frm_episode_type;

struct { unsigned short len; unsigned char arr[4]; } l_to_episode_type;

struct { unsigned short len; unsigned char arr[30]; } l_previous_visit_date;

struct { unsigned short len; unsigned char arr[30]; } l_previous_discharge_date;

struct { unsigned short len; unsigned char arr[10]; } l_previous_blng_grp;

struct { unsigned short len; unsigned char arr[20]; } l_episode_type;

struct { unsigned short len; unsigned char arr[41]; } d_acc_entity_name;

struct { unsigned short len; unsigned char arr[41]; } d_frm_acc_entity_name;

struct { unsigned short len; unsigned char arr[41]; } d_to_acc_entity_name;

struct { unsigned short len; unsigned char arr[21]; } d_user;

struct { unsigned short len; unsigned char arr[30]; } d_sysdate;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;



	int		l_page_no		= 1;
	int		l_line_no		= 0;
	int		i;

	double 	l_charge_amt=0,
	        tot_charge_amt,
	        grand_tot_charge_amt;

	char	filename[150];
	char loc_legend[999][201];

	char	l_print_format_change;
	char    aMesg[300];
	char	f_bill_tot_amt[14];
	char	f_charge_amt[14];
	char	l_mesg[1000];
	char      v_num[10];

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

int  line_no=0, 
	 page_no=0;

void proc_main(argc, argv)
int argc;
char *argv[];
{

 void	    get_params(),
  			get_header_dtls(),
  			do_report();
	
	//	disp_message(ERR_MESG,v_num);
	//sprintf(v_num,"%d",argc);
			//disp_message(ERR_MESG,v_num);	
	if(argc != 11) 
	{
		disp_message(ERR_MESG,"Usage BLRINTCH uid/passwd session_id pgm_date facility_id start_date end_date user cash_counter");
		proc_exit();
	}
		
    strcpy(uid_pwd.arr,argv[1]);
    uid_pwd.len = strlen(uid_pwd.arr);

    strcpy(nd_session_id.arr,argv[2]);
    nd_session_id.len = strlen(nd_session_id.arr);
    strcpy(g_session_id,argv[2]);
  
    strcpy(nd_pgm_date.arr,argv[3]);
    nd_pgm_date.len = strlen(nd_pgm_date.arr);

    strcpy(g_pgm_id,"BLRINTCH");
    strcpy(g_pgm_date,argv[3]);

    strcpy(l_oper_facility_id.arr,argv[4]);
    l_oper_facility_id.len = strlen(l_oper_facility_id.arr);
	strcpy(g_facility_id, l_oper_facility_id.arr);

    strcpy(l_start_date.arr,argv[5]);
    l_start_date.len = strlen(l_start_date.arr);

    strcpy(l_end_date.arr,argv[6]);
    l_end_date.len = strlen(l_end_date.arr);

    strcpy(l_gen_user_id.arr,argv[7]);
    l_gen_user_id.len = strlen(l_gen_user_id.arr);

    strcpy(nd_fr_facility_id.arr,argv[8]);
    nd_fr_facility_id.len = strlen(nd_fr_facility_id.arr);

    strcpy(nd_to_facility_id.arr,argv[9]);
    nd_to_facility_id.len = strlen(nd_to_facility_id.arr);

    strcpy(l_prog_id.arr,argv[10]);
    l_prog_id.len = strlen(l_prog_id.arr);

	/*strcpy(filename,WORKING_DIR);
	strcat(filename,"blrintch.lis");
	
	
	if((f1 = fopen(filename, "w")) == NULL) 
	{
		disp_message(ERR_MESG,".... Error opening output file ....");
		proc_exit();
	} */

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
	strcpy(p_language_id.arr,l_language_id.arr);
    p_language_id.len = l_language_id.len;

	l_function_id.arr[0] = '\0';

	/* EXEC SQL SELECT PARAM1            /o FUNCTION ID o/
			 INTO :l_function_id
			 FROM   SY_PROG_PARAM
			 WHERE  PGM_ID     =:l_prog_id // 'BLTINTCH'
			 AND    PGM_DATE   = :nd_pgm_date
			 AND    SESSION_ID = TO_NUMBER(:nd_session_id); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select PARAM1 into :b0  from SY_PROG_PARAM where ((PGM_ID=:b\
1 and PGM_DATE=:b2) and SESSION_ID=TO_NUMBER(:b3))";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )36;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_function_id;
 sqlstm.sqhstl[0] = (unsigned int  )52;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_prog_id;
 sqlstm.sqhstl[1] = (unsigned int  )23;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_pgm_date;
 sqlstm.sqhstl[2] = (unsigned int  )22;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_session_id;
 sqlstm.sqhstl[3] = (unsigned int  )18;
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




    if(ERROR || NO_DATA_FOUND)
	    err_mesg("SELECT failed on table  SY_PROG_PARAM",0,"");


	/* EXEC SQL DELETE SY_PROG_PARAM
	 WHERE  PGM_ID     = :l_prog_id //'BLTINTCH' 
	 AND    PGM_DATE   = :nd_pgm_date
	 AND    SESSION_ID = TO_NUMBER(:nd_session_id); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID=:b0 and PGM_DATE=\
:b1) and SESSION_ID=TO_NUMBER(:b2))";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )67;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_prog_id;
 sqlstm.sqhstl[0] = (unsigned int  )23;
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
 sqlstm.sqhstv[2] = (         void  *)&nd_session_id;
 sqlstm.sqhstl[2] = (unsigned int  )18;
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



	  if(ERROR) 
	err_mesg("DELETE failed on table SY_PROG_PARAM",0,""); 

//	if (strcmp(l_function_id.arr,"BL_TRANSFER_FACILITY_CHARGES")==0)
//	 {
	strcpy(filename,WORKING_DIR);
	strcat(filename,"BLRINTCH.lis");
	// }
//	if (strcmp(l_function_id.arr,"BL_COPY_CHARGES_ENCOUNTERS")==0)
//	{
//	strcpy(filename,WORKING_DIR);
//	strcat(filename,"BLRCPYRF.lis");
//	}

	
	if((f1 = fopen(filename, "w")) == NULL) 
	{
		disp_message(ERR_MESG,".... Error opening output file ....");
		proc_exit();
	} 

    fetch_legend_value();
	get_header_dtls();
	declare_cursor1();
	//declare_cursor();
	do_report();
	close_cursors();
	fclose(f1);

	/* EXEC SQL COMMIT WORK RELEASE; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )94;
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

	   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 4;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )109;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	   disp_message(ERR_MESG,"Oracle error at main() occured....");
	   disp_message(ERR_MESG, sqlca.sqlerrm.sqlerrmc);
	   proc_exit();
}

//get the header details
void get_header_dtls()
{
    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


	d_acc_entity_name.arr[0] = '\0';
	d_user.arr[0]            = '\0';
	d_sysdate.arr[0]         = '\0';
	d_frm_acc_entity_name.arr[0] = '\0';
	d_to_acc_entity_name.arr[0] = '\0';


    /* EXEC SQL SELECT ltrim(rtrim(acc_entity_name)),
				    ltrim(rtrim(USER)),
				    ltrim(rtrim(TO_CHAR(SYSDATE, 'DD/MM/YYYY HH24:MI')))
		       INTO :d_acc_entity_name,
			  	    :d_user,
				    :d_sysdate
               FROM SY_ACC_ENTITY_LANG_VW
			  WHERE acc_entity_id = :l_oper_facility_id
			  AND language_id=:p_language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ltrim(rtrim(acc_entity_name)) ,ltrim(rtrim(USER)) \
,ltrim(rtrim(TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'))) into :b0,:b1,:b2  from SY\
_ACC_ENTITY_LANG_VW where (acc_entity_id=:b3 and language_id=:b4)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )124;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
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
    sqlstm.sqhstl[2] = (unsigned int  )32;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&l_oper_facility_id;
    sqlstm.sqhstl[3] = (unsigned int  )12;
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
    if (sqlca.sqlcode < 0) goto err_exit;
}



    /* EXEC SQL SELECT ltrim(rtrim(acc_entity_name))
		       INTO :d_frm_acc_entity_name
               FROM SY_ACC_ENTITY_LANG_VW
			  WHERE acc_entity_id = :nd_fr_facility_id
			  AND language_id=:p_language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ltrim(rtrim(acc_entity_name)) into :b0  from SY_AC\
C_ENTITY_LANG_VW where (acc_entity_id=:b1 and language_id=:b2)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )159;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_frm_acc_entity_name;
    sqlstm.sqhstl[0] = (unsigned int  )43;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_fr_facility_id;
    sqlstm.sqhstl[1] = (unsigned int  )6;
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
    if (sqlca.sqlcode < 0) goto err_exit;
}



   /* EXEC SQL SELECT ltrim(rtrim(acc_entity_name))
		       INTO :d_to_acc_entity_name
               FROM SY_ACC_ENTITY_LANG_VW
			  WHERE acc_entity_id = :nd_to_facility_id
			  AND language_id=:p_language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 5;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select ltrim(rtrim(acc_entity_name)) into :b0  from SY_ACC\
_ENTITY_LANG_VW where (acc_entity_id=:b1 and language_id=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )186;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_to_acc_entity_name;
   sqlstm.sqhstl[0] = (unsigned int  )43;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_to_facility_id;
   sqlstm.sqhstl[1] = (unsigned int  )6;
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
   if (sqlca.sqlcode < 0) goto err_exit;
}



	d_acc_entity_name.arr[d_acc_entity_name.len] = '\0';
	d_user.arr[d_user.len]                       = '\0';
	d_sysdate.arr[d_sysdate.len]                 = '\0';
	d_frm_acc_entity_name.arr[d_frm_acc_entity_name.len] = '\0';
	d_to_acc_entity_name.arr[d_to_acc_entity_name.len]   = '\0';

	return;

	err_exit:
	   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

	   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )213;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	   disp_message(ERR_MESG,"Oracle error at get_header_dtls() occured....");
	   disp_message(ERR_MESG, sqlca.sqlerrm.sqlerrmc);
	   proc_exit();
}

declare_cursor1()

{

	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


	if (strcmp(l_function_id.arr,"BL_TRANSFER_FACILITY_CHARGES")==0) {

   /* EXEC SQL DECLARE	    hdr_cur
	          CURSOR
			     FOR	
                 SELECT	patient_id,
						fr_episode_type,
						nvl(fr_episode_id,99999999),
						nvl(fr_visit_id,0)
				FROM	BL_INT_COMP_LOG_DTL
			   WHERE	fr_facility_id = :nd_fr_facility_id
			     AND    to_facility_id = :nd_to_facility_id
			     AND	user_id				  = :l_gen_user_id
				 and    SESSION_ID                   =:nd_session_id
				 AND    TO_CHAR(start_date_time,'DD/MM/RRRRHH24:MI:SS') = :l_start_date; */ 

	 }



	if (strcmp(l_function_id.arr,"BL_COPY_CHARGES_ENCOUNTER")==0) {

   /* EXEC SQL DECLARE	    hdr_cur1
	          CURSOR
			     FOR	
                 SELECT	patient_id,
						fr_episode_type,
						nvl(fr_episode_id,99999999),
						nvl(fr_visit_id,0)
				FROM	BL_INT_COMP_LOG_DTL
			   WHERE	fr_facility_id = :nd_fr_facility_id
			     AND    to_facility_id = :nd_to_facility_id
			     AND	user_id				  = :l_gen_user_id
				 and    SESSION_ID                   =:nd_session_id
				 AND    TO_CHAR(start_date_time,'DD/MM/RRRRHH24:MI:SS') = :l_start_date; */ 

	 }

	if (strcmp(l_function_id.arr,"BL_TRANSFER_FACILITY_CHARGES")==0)
	/* EXEC SQL OPEN hdr_cur; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0010;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )228;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_fr_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )6;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_to_facility_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&l_gen_user_id;
 sqlstm.sqhstl[2] = (unsigned int  )32;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_session_id;
 sqlstm.sqhstl[3] = (unsigned int  )18;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&l_start_date;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}


	if (strcmp(l_function_id.arr,"BL_COPY_CHARGES_ENCOUNTER")==0)
	/* EXEC SQL OPEN hdr_cur1; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0011;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )263;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_fr_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )6;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_to_facility_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&l_gen_user_id;
 sqlstm.sqhstl[2] = (unsigned int  )32;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_session_id;
 sqlstm.sqhstl[3] = (unsigned int  )18;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&l_start_date;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}


	return;

	err_exit:
	
		   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

		   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 5;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )298;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		   disp_message(ERR_MESG, sqlca.sqlerrm.sqlerrmc);
		   disp_message(ERR_MESG,"Oracle error at declare_cursor1() occured....");
		   proc_exit();
}	 

declare_cursor()

{

	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


	if (strcmp(l_function_id.arr,"BL_TRANSFER_FACILITY_CHARGES")==0) {

	/* EXEC SQL DECLARE	bill_dtl_cur
	          CURSOR
			     FOR
  			  SELECT	a.FR_FACILITY_ID,
						a.TO_FACILITY_ID,
						A.PATIENT_ID,
						a.FR_EPISODE_TYPE,
						nvl(a.FR_EPISODE_ID,99999999),
						nvl(a.FR_VISIT_ID,0),
						decode(:p_language_id,'en',d.short_name,nvl(d.short_name_loc_lang,d.short_name)),
						a.TO_EPISODE_TYPE,
						b.start_date_time,
						a.FR_ITEM_CODE,
						a.FR_SERV_ITEM_DESC,
						a.SERVICE_PANEL_IND,
						a.BLNG_SERV_PANEL_CODE,
						a.CHARGE_AMT
			    FROM	BL_INT_COMP_LOG_SERV_DTL a,BL_INT_COMP_LOG_DTL b,
						mp_patient_mast	d
			   WHERE	A.patient_id			=  D.patient_id
			   and      a.patient_id=b.patient_id
			   and      nvl(a.fr_episode_id,99999999)=nvl(b.fr_episode_id,99999999)
			   and      a.fr_episode_type=b.fr_episode_type
			   AND	    a.user_id				  =b.user_id
			   AND	    a.user_id				    = :l_gen_user_id
			   and      b.patient_id                =:hdr_patient_id
			   and      b.fr_episode_type              =:hdr_episode_type
			   and      nvl(b.fr_episode_id,99999999)                =:hdr_episode_id
			   and      nvl(b.fr_visit_id,0)           =:hdr_visit_id
			   and      a.SESSION_ID                   =b.SESSION_ID
			   and      b.SESSION_ID                   =:nd_session_id
	    AND	TO_CHAR(b.start_date_time,'DD/MM/RRRRHH24:MI:SS') = :l_start_date
			   ORDER 
			      BY    TRUNC(b.start_date_time),
				        A.PATIENT_ID; */ 


	 }

		if (strcmp(l_function_id.arr,"BL_COPY_CHARGES_ENCOUNTER")==0) {

	/* EXEC SQL DECLARE	bill_dtl_cur1
	          CURSOR
			     FOR
  			  SELECT	a.FR_FACILITY_ID,
						a.TO_FACILITY_ID,
						A.PATIENT_ID,
						a.FR_EPISODE_TYPE,
						nvl(a.FR_EPISODE_ID,99999999),
						nvl(a.FR_VISIT_ID,0),
						decode(:p_language_id,'en',d.short_name,nvl(d.short_name_loc_lang,d.short_name)),
						a.TO_EPISODE_TYPE,
						b.start_date_time,
						a.FR_ITEM_CODE,
						a.FR_SERV_ITEM_DESC,
						a.SERVICE_PANEL_IND,
						a.BLNG_SERV_PANEL_CODE,
						a.CHARGE_AMT
			    FROM	BL_INT_COMP_LOG_SERV_DTL a,BL_INT_COMP_LOG_DTL b,
						mp_patient_mast	d
			   WHERE	A.patient_id			=  D.patient_id
			   and      a.patient_id=b.patient_id
			   and      nvl(a.fr_episode_id,99999999)=nvl(b.fr_episode_id,99999999)
			   and      a.fr_episode_type=b.fr_episode_type
			   AND	    a.user_id				  =b.user_id
			   AND	    a.user_id				    = :l_gen_user_id
			   and      b.patient_id                =:hdr_patient_id
			   and      b.fr_episode_type              =:hdr_episode_type
			   and      nvl(b.fr_episode_id,99999999)                =:hdr_episode_id
			   and      nvl(b.fr_visit_id,0)           =:hdr_visit_id
			   and      a.SESSION_ID                   =b.SESSION_ID
			   and      b.SESSION_ID                   =:nd_session_id
	    AND	TO_CHAR(b.start_date_time,'DD/MM/RRRRHH24:MI:SS') = :l_start_date
			   ORDER 
			      BY    TRUNC(b.start_date_time),
				        A.PATIENT_ID; */ 


	 }
	 		
	if (strcmp(l_function_id.arr,"BL_TRANSFER_FACILITY_CHARGES")==0)
	/* EXEC SQL OPEN bill_dtl_cur; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 8;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0013;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )313;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&p_language_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_gen_user_id;
 sqlstm.sqhstl[1] = (unsigned int  )32;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&hdr_patient_id;
 sqlstm.sqhstl[2] = (unsigned int  )27;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&hdr_episode_type;
 sqlstm.sqhstl[3] = (unsigned int  )6;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&hdr_episode_id;
 sqlstm.sqhstl[4] = (unsigned int  )11;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&hdr_visit_id;
 sqlstm.sqhstl[5] = (unsigned int  )7;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&nd_session_id;
 sqlstm.sqhstl[6] = (unsigned int  )18;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&l_start_date;
 sqlstm.sqhstl[7] = (unsigned int  )32;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}


	if (strcmp(l_function_id.arr,"BL_COPY_CHARGES_ENCOUNTER")==0)
	/* EXEC SQL OPEN bill_dtl_cur1; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 8;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0014;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )360;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&p_language_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_gen_user_id;
 sqlstm.sqhstl[1] = (unsigned int  )32;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&hdr_patient_id;
 sqlstm.sqhstl[2] = (unsigned int  )27;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&hdr_episode_type;
 sqlstm.sqhstl[3] = (unsigned int  )6;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&hdr_episode_id;
 sqlstm.sqhstl[4] = (unsigned int  )11;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&hdr_visit_id;
 sqlstm.sqhstl[5] = (unsigned int  )7;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&nd_session_id;
 sqlstm.sqhstl[6] = (unsigned int  )18;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&l_start_date;
 sqlstm.sqhstl[7] = (unsigned int  )32;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}



	return;

	err_exit:
	
		   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

		   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 8;
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


		   disp_message(ERR_MESG, sqlca.sqlerrm.sqlerrmc);
		   disp_message(ERR_MESG,"Oracle error at declare_cursor() occured....");
		   proc_exit();
}

int fetch_hdr_cur()

{

	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


	hdr_patient_id.arr[0]	        = '\0';
	hdr_episode_type.arr[0]			= '\0';
	hdr_episode_id.arr[0]			= '\0';
	hdr_visit_id.arr[0]				= '\0'; 

   if (strcmp(l_function_id.arr,"BL_TRANSFER_FACILITY_CHARGES")==0) {           
	/* EXEC SQL FETCH  hdr_cur
             INTO      :hdr_patient_id,
					   :hdr_episode_type,
					   :hdr_episode_id,
					   :hdr_visit_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 8;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )422;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&hdr_patient_id;
 sqlstm.sqhstl[0] = (unsigned int  )27;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&hdr_episode_type;
 sqlstm.sqhstl[1] = (unsigned int  )6;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&hdr_episode_id;
 sqlstm.sqhstl[2] = (unsigned int  )11;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&hdr_visit_id;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}


   }

   if (strcmp(l_function_id.arr,"BL_COPY_CHARGES_ENCOUNTER")==0) {
	/* EXEC SQL FETCH  hdr_cur1
             INTO      :hdr_patient_id,
					   :hdr_episode_type,
					   :hdr_episode_id,
					   :hdr_visit_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 8;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )453;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&hdr_patient_id;
 sqlstm.sqhstl[0] = (unsigned int  )27;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&hdr_episode_type;
 sqlstm.sqhstl[1] = (unsigned int  )6;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&hdr_episode_id;
 sqlstm.sqhstl[2] = (unsigned int  )11;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&hdr_visit_id;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}


   }
//disp_message(ERR_MESG,hdr_episode_type.arr);
//disp_message(ERR_MESG,hdr_episode_id.arr);
	if (NODATAFOUND)
		return 0;

	hdr_patient_id.arr[hdr_patient_id.len]	= '\0';
	hdr_episode_type.arr[hdr_episode_type.len]		= '\0';
	hdr_episode_id.arr[hdr_episode_id.len]	= '\0';
	hdr_visit_id.arr[hdr_visit_id.len]		= '\0';
    
	return 1;
	
	err_exit:
		/* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

		/* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 8;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )484;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		disp_message(ERR_MESG,"Oracle error at fetch_hdr_cur() occured....");
		sprintf(aMesg,"Error: %-100s",sqlca.sqlerrm.sqlerrmc);
		disp_message(ERR_MESG,aMesg);
		proc_exit();
}




int fetch_bill_dtl_cur()

{

	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


	l_frm_facility_id.arr[0]	= '\0';
	l_to_facility_id.arr[0]			= '\0';
	l_frm_patient_id.arr[0]				= '\0';
	l_frm_episode_type.arr[0]				= '\0'; 
	l_frm_episode_id.arr[0]				= '\0';
	l_frm_visit_id.arr[0]				= '\0';
	l_short_name.arr[0]				= '\0';
	l_to_episode_type.arr[0]				= '\0'; 
	nd_start_date.arr[0]				= '\0';
	l_fr_item_code.arr[0]               	= '\0';
	l_fr_item_desc.arr[0]               	= '\0';
	l_service_panel_ind.arr[0]          	= '\0';
	l_blng_serv_panel_code.arr[0]       	= '\0';

	l_charge_amt = 0; 
      if (strcmp(l_function_id.arr,"BL_TRANSFER_FACILITY_CHARGES")==0) {               
	/* EXEC SQL FETCH  bill_dtl_cur
			  INTO  :l_frm_facility_id,
					:l_to_facility_id,
					:l_frm_patient_id,
					:l_frm_episode_type,
					:l_frm_episode_id,
					:l_frm_visit_id,
					:l_short_name,
					:l_to_episode_type,
					:nd_start_date,
					:l_fr_item_code,
					:l_fr_item_desc,
					:l_service_panel_ind,
					:l_blng_serv_panel_code,
					:l_charge_amt; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )499;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_frm_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )6;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_to_facility_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&l_frm_patient_id;
 sqlstm.sqhstl[2] = (unsigned int  )23;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&l_frm_episode_type;
 sqlstm.sqhstl[3] = (unsigned int  )6;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&l_frm_episode_id;
 sqlstm.sqhstl[4] = (unsigned int  )11;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&l_frm_visit_id;
 sqlstm.sqhstl[5] = (unsigned int  )7;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&l_short_name;
 sqlstm.sqhstl[6] = (unsigned int  )43;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&l_to_episode_type;
 sqlstm.sqhstl[7] = (unsigned int  )6;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&nd_start_date;
 sqlstm.sqhstl[8] = (unsigned int  )32;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&l_fr_item_code;
 sqlstm.sqhstl[9] = (unsigned int  )32;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&l_fr_item_desc;
 sqlstm.sqhstl[10] = (unsigned int  )103;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&l_service_panel_ind;
 sqlstm.sqhstl[11] = (unsigned int  )6;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&l_blng_serv_panel_code;
 sqlstm.sqhstl[12] = (unsigned int  )22;
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&l_charge_amt;
 sqlstm.sqhstl[13] = (unsigned int  )sizeof(double);
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


}
   if (strcmp(l_function_id.arr,"BL_COPY_CHARGES_ENCOUNTER")==0) {  
   	/* EXEC SQL FETCH  bill_dtl_cur1
			  INTO  :l_frm_facility_id,
					:l_to_facility_id,
					:l_frm_patient_id,
					:l_frm_episode_type,
					:l_frm_episode_id,
					:l_frm_visit_id,
					:l_short_name,
					:l_to_episode_type,
					:nd_start_date,
					:l_fr_item_code,
					:l_fr_item_desc,
					:l_service_panel_ind,
					:l_blng_serv_panel_code,
					:l_charge_amt; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 14;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )570;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&l_frm_facility_id;
    sqlstm.sqhstl[0] = (unsigned int  )6;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&l_to_facility_id;
    sqlstm.sqhstl[1] = (unsigned int  )6;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&l_frm_patient_id;
    sqlstm.sqhstl[2] = (unsigned int  )23;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&l_frm_episode_type;
    sqlstm.sqhstl[3] = (unsigned int  )6;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&l_frm_episode_id;
    sqlstm.sqhstl[4] = (unsigned int  )11;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&l_frm_visit_id;
    sqlstm.sqhstl[5] = (unsigned int  )7;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&l_short_name;
    sqlstm.sqhstl[6] = (unsigned int  )43;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&l_to_episode_type;
    sqlstm.sqhstl[7] = (unsigned int  )6;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_start_date;
    sqlstm.sqhstl[8] = (unsigned int  )32;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&l_fr_item_code;
    sqlstm.sqhstl[9] = (unsigned int  )32;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&l_fr_item_desc;
    sqlstm.sqhstl[10] = (unsigned int  )103;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&l_service_panel_ind;
    sqlstm.sqhstl[11] = (unsigned int  )6;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&l_blng_serv_panel_code;
    sqlstm.sqhstl[12] = (unsigned int  )22;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&l_charge_amt;
    sqlstm.sqhstl[13] = (unsigned int  )sizeof(double);
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


}
//disp_message(ERR_MESG,l_service_panel_ind.arr);
//disp_message(ERR_MESG,l_blng_serv_panel_code.arr);
	if (NODATAFOUND)
		return 0;

	l_frm_facility_id.arr[l_frm_facility_id.len]	= '\0';
	l_to_facility_id.arr[l_to_facility_id.len]		= '\0';
	l_frm_patient_id.arr[l_frm_patient_id.len]		= '\0';
	l_frm_episode_type.arr[l_frm_episode_type.len]	= '\0';
	l_frm_episode_id.arr[l_frm_episode_id.len]		= '\0';
	l_frm_visit_id.arr[l_frm_visit_id.len]			= '\0';
	l_short_name.arr[l_short_name.len]				= '\0';          
	l_to_episode_type.arr[l_to_episode_type.len]	= '\0';                
	nd_start_date.arr[nd_start_date.len]	        = '\0'; 
	l_fr_item_code.arr[l_fr_item_code.len]	        = '\0'; 
	l_fr_item_desc.arr[l_fr_item_desc.len]	        = '\0'; 
	l_service_panel_ind.arr[l_service_panel_ind.len]	        = '\0'; 
	l_blng_serv_panel_code.arr[l_blng_serv_panel_code.len]	        = '\0'; 	
    
	return 1;
	
	err_exit:
		/* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

		/* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )641;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		disp_message(ERR_MESG,"Oracle error at fetch_bill_dtl_cur() occured....");
		sprintf(aMesg,"Error: %-100s",sqlca.sqlerrm.sqlerrmc);
		disp_message(ERR_MESG,aMesg);
		proc_exit();
}




close_cursors()
{

	if (strcmp(l_function_id.arr,"BL_TRANSFER_FACILITY_CHARGES")==0)
	{
	/* EXEC SQL CLOSE bill_dtl_cur; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )656;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	/* EXEC SQL CLOSE hdr_cur; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )671;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	}
	if (strcmp(l_function_id.arr,"BL_COPY_CHARGES_ENCOUNTER")==0)
	{
	/* EXEC SQL CLOSE bill_dtl_cur1; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )686;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	/* EXEC SQL CLOSE hdr_cur1; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )701;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	}
	
}

void do_report()  
{
	print_parameter_page();

//	if (strcmp(l_function_id.arr,"BL_TRANSFER_FACILITY_CHARGES")==0)
	print_report();
	end_report();
}

print_parameter_page()
{
	print_page_title();

	fprintf(f1,"\n\n\n\n\n\n\t\t%-16.16s\n",loc_legend[1]);
	fprintf(f1,"\t\t----------------\n\n");


	fprintf(f1,"\t\t%-13.13s   :    %s\n\n",loc_legend[2],l_gen_user_id.arr);

	fprintf(f1,"\t\t%-13.13s   :    %s\n\n",loc_legend[9],d_frm_acc_entity_name.arr);

	fprintf(f1,"\t\t%-13.13s   :    %s\n\n",loc_legend[10],d_to_acc_entity_name.arr);
	init_date_temp_var();                              //pradeep
	strcpy(date_convert.arr,l_start_date.arr);            // pradeep
	fun_change_loc_date();
	fprintf(f1,"\t\t%-13.13s   :    %s\n\n",loc_legend[4],date_convert.arr);
	init_date_temp_var();                              //pradeep
	strcpy(date_convert.arr,l_end_date.arr);            // pradeep
	fun_change_loc_date();
	fprintf(f1,"\t\t%-13.13s   :    %s\n\n",loc_legend[5],date_convert.arr);
	check_page_end(55);
}

print_page_title()
{
	double l_report_width;
	double l_acc_entity_length;
	double l_start_point;
	double l_comp_name_end_point;
	int	   l_page_width;

	l_line_no= 0;
	l_report_width      = 147;
	l_acc_entity_length = strlen(d_acc_entity_name.arr);

	//Code for Line 1
	l_start_point=ceill((l_report_width/2)-(l_acc_entity_length/2));
	//fprintf(f1,"MDL : BL");
	fprintf(f1,"%-3.3s : %-2.2s",loc_legend[6],loc_legend[21]);
	l_start_point=l_start_point-8;
	print_spaces(l_start_point);
	fprintf(f1,"%s",d_acc_entity_name.arr);
	l_comp_name_end_point=l_start_point+8+l_acc_entity_length;
	l_start_point=((l_report_width-17)-l_comp_name_end_point);
	print_spaces(l_start_point);
	init_date_temp_var();                             
	strcpy(date_convert.arr,d_sysdate.arr);          
	fun_change_loc_date();
	fprintf(f1,"%s\n",date_convert.arr);

	//Code for Line 2
	l_start_point=0;
	fprintf(f1,"%-3.3s : %-15s",loc_legend[7],d_user.arr);
	l_start_point=ceill((l_report_width/2)-18);
	l_start_point=l_start_point-21;
	print_spaces(l_start_point);
	//if (strcmp(l_function_id.arr,"BL_TRANSFER_FACILITY_CHARGES")==0) 
	fprintf(f1,"%-40.40s\n",loc_legend[22]);

	//Code for Line 3
	l_start_point=0;

	//if (strcmp(l_function_id.arr,"BL_TRANSFER_FACILITY_CHARGES")==0) 
	fprintf(f1,"%-3.3s : BLRINTCH",loc_legend[8]);

	l_start_point=ceill((l_report_width/2)-8);
	l_start_point=l_start_point-14;
	print_spaces(l_start_point);
	fprintf(f1,"                 ");
	l_comp_name_end_point=l_start_point+14+16;
	l_start_point=((l_report_width-17)-l_comp_name_end_point);
	print_spaces(l_start_point);
	fprintf(f1,"%-4.4s : %d\n",loc_legend[24],l_page_no);
	line_no=3;

	l_page_width=l_report_width;
	print_line(l_page_width);
	fprintf(f1,"\n");
	l_line_no = l_line_no + 3; 

	if(l_page_no > 1)
	{
//	if (strcmp(l_function_id.arr,"BL_TRANSFER_FACILITY_CHARGES")==0) 
//{
		//fprintf(f1,"Patient No            Name                            Encounter\n");
		fprintf(f1,"%-12.12s          %-13.13s                   %-15.15s %-14.14s %-41.41s   %-15.15s\n",loc_legend[12],loc_legend[13],loc_legend[14],loc_legend[15],loc_legend[16],loc_legend[17]);
		print_line(l_page_width);
		fprintf(f1,"\n");	
		l_line_no = l_line_no + 2;
//}

	}
	l_page_no++;
}
  
print_report()
{
	int		l_width;
	tot_charge_amt =0;
	grand_tot_charge_amt =0;
	while(fetch_hdr_cur())
	{
	tot_charge_amt =0;
	  declare_cursor();
		while(fetch_bill_dtl_cur())
		{
			//if (strcmp(l_function_id.arr,"BL_TRANSFER_FACILITY_CHARGES")==0) 
			if (strcmp(l_service_panel_ind.arr,"S")==0) 
			{ 
			if(strlen(l_blng_serv_panel_code.arr)!=0)
			{
				l_blng_serv_panel_desc.arr[0] = '\0';

				/* EXEC SQL SELECT short_desc
						   INTO :l_blng_serv_panel_desc
						   FROM bl_blng_serv_lang_vw
						  WHERE language_id=:p_language_id
						  and BLNG_SERV_CODE = :l_blng_serv_panel_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 14;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select short_desc into :b0  from bl_blng_serv_lang_vw whe\
re (language_id=:b1 and BLNG_SERV_CODE=:b2)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )716;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&l_blng_serv_panel_desc;
    sqlstm.sqhstl[0] = (unsigned int  )43;
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
    sqlstm.sqhstv[2] = (         void  *)&l_blng_serv_panel_code;
    sqlstm.sqhstl[2] = (unsigned int  )22;
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


				
				l_blng_serv_panel_desc.arr[l_blng_serv_panel_desc.len] = '\0';
			 }
			 }
			 else
			 {
 
 			 if(strlen(l_blng_serv_panel_code.arr)!=0)
			 {
				l_blng_serv_panel_desc.arr[0] = '\0';

				/* EXEC SQL SELECT short_desc
						   INTO :l_blng_serv_panel_desc
						   FROM bl_panel_hdr_lang_vw
						  WHERE language_id=:p_language_id
						  and panel_code = :l_blng_serv_panel_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 14;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select short_desc into :b0  from bl_panel_hdr_lang_vw whe\
re (language_id=:b1 and panel_code=:b2)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )743;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&l_blng_serv_panel_desc;
    sqlstm.sqhstl[0] = (unsigned int  )43;
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
    sqlstm.sqhstv[2] = (         void  *)&l_blng_serv_panel_code;
    sqlstm.sqhstl[2] = (unsigned int  )22;
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


				
				l_blng_serv_panel_desc.arr[l_blng_serv_panel_desc.len] = '\0';
			  }
			 }
			fprintf(f1,"%-20.20s  %-30.30s  %-1.1s/%-8.8s/%-4.4s %-1.1s/%-13.13s %-41.41s",l_frm_patient_id.arr,l_short_name.arr,l_frm_episode_type.arr,l_frm_episode_id.arr,l_frm_visit_id.arr,l_service_panel_ind.arr,l_blng_serv_panel_code.arr,l_blng_serv_panel_desc.arr);
			print_formated(l_charge_amt);
			fprintf(f1,"\n");
			l_line_no++;
			check_page_end(l_line_no);	
            tot_charge_amt =tot_charge_amt+l_charge_amt;
		}
	 fprintf(f1,"                          %85.85s","");
	 fprintf(f1,"==============================");
	 fprintf(f1,"\n");
	 fprintf(f1,"                                                                                                                %-15.15s",loc_legend[25]);
     print_formated(tot_charge_amt);
	 fprintf(f1,"\n");
	 fprintf(f1,"                          %85.85s","");
	 fprintf(f1,"==============================");
	 fprintf(f1,"\n");
	 l_line_no++;
	 check_page_end(l_line_no);
	 grand_tot_charge_amt =grand_tot_charge_amt+tot_charge_amt;
	}
	 fprintf(f1,"                                                                                                                %-15.15s",loc_legend[26]);
     print_formated(grand_tot_charge_amt);
	 fprintf(f1,"\n");
	 l_line_no++;
	 check_page_end(l_line_no);
}


print_line(l_length)
int l_length;
{
	for(i=0;i<l_length;i++)
	{
		fprintf(f1,"-");
	}
}

print_double_line(l_length)
int l_length;
{
	for(i=0;i<l_length;i++)
	{
		fprintf(f1,"=");
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


check_page_end(l_line_no)
{
	if ((l_line_no + 5) >= MAX_LINES)
	{
		l_line_no=0;
		fprintf(f1,"\f");
	    print_page_title();
	}	
	return;
}

//Print the finishing line of the report 
end_report()
{
  fprintf(f1,"\n\n");
  fprintf(f1,"                                                   ");
  fprintf(f1,"%-15.15s",loc_legend[20]);
  fprintf(f1,"");
}

print_formated(loc_amount)
double loc_amount;
{
	char s_amt[30], str_amt[30];	

    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);        
        format_amt(s_amt);
	    strcat(s_amt,"-");
        sprintf(str_amt,"%14s",s_amt);
		l_ltrim(s_amt);
        fprintf(f1,"%14s",str_amt);
    }
    else 
	{
        put_val(s_amt,loc_amount);         
        format_amt(s_amt);
        sprintf(str_amt,"%14s",s_amt);
		l_ltrim(s_amt);
        fprintf(f1,"%14s ",str_amt);
    }

}
fetch_legend_value()
{
	for(i=1;i<=900;i++)
	{
		l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLRINTCH.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLRINTCH.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )770;
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
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility_id , 'S\
M' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_valu\
e , :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )793;
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


                     
init_date_temp_var()
{
nd_temp_date.arr[0] = '\0';
nd_temp_date1.arr[0] = '\0';
nd_loc_date.arr[0]  = '\0';
nd_loc_date1.arr[0]  = '\0';
date_convert.arr[0] = '\0';
date_convert1.arr[0] = '\0';


nd_temp_date.len = 0;
nd_temp_date1.len = 0;

nd_loc_date.len  = 0;
nd_loc_date1.len  = 0;

date_convert.len = 0;
date_convert1.len = 0;

}



fun_change_loc_date()
{

strcpy(nd_temp_date.arr,date_convert.arr);
nd_temp_date.len = strlen(nd_temp_date.arr);


get_local_date();

strcpy(date_convert.arr,nd_loc_date.arr); 

}

get_local_date()
{

	
	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;
	
	BEGIN
	
	  
       	get_locale_date.CONVERT_TO_LOCALE_DATE(to_date(:nd_temp_date,'DD/MM/YYYY HH24:MI:SS'),:p_language_id,t_date);  
      
	   :nd_loc_date := to_char(t_date,'DD/MM/YYYY HH24:MI');
	

	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . CONVERT_TO_LOC\
ALE_DATE ( to_date ( :nd_temp_date , 'DD/MM/YYYY HH24:MI:SS' ) , :p_language_i\
d , t_date ) ; :nd_loc_date := to_char ( t_date , 'DD/MM/YYYY HH24:MI' ) ; END\
 ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )824;
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


        

		if (OERROR)
        err_mesg("SELECTING Date failed",0,"");

}

fun_change_loc_date1()
{

strcpy(nd_temp_date1.arr,date_convert1.arr);
nd_temp_date1.len = strlen(nd_temp_date1.arr);


get_local_date1();

strcpy(date_convert1.arr,nd_loc_date1.arr); 

}

get_local_date1()
{

	
	/* EXEC SQL EXECUTE

	DECLARE

	t_date1  date;
	
	BEGIN
	
	  
       	get_locale_date.CONVERT_TO_LOCALE_DATE(to_date(:nd_temp_date1,'DD/MM/YYYY'),:p_language_id,t_date1);  
      
	   :nd_loc_date1 := to_char(t_date1,'DD/MM/YYYY');
	

	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date1 date ; BEGIN get_locale_date . CONVERT_TO_LO\
CALE_DATE ( to_date ( :nd_temp_date1 , 'DD/MM/YYYY' ) , :p_language_id , t_dat\
e1 ) ; :nd_loc_date1 := to_char ( t_date1 , 'DD/MM/YYYY' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )851;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_temp_date1;
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
 sqlstm.sqhstv[2] = (         void  *)&nd_loc_date1;
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
        err_mesg("SELECTING Date failed",0,"");

}



#undef DEBUG
#undef NODATAFOUND
#undef MAX_LINES
#undef VER