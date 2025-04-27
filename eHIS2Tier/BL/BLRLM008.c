
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
           char  filnam[32];
};
static const struct sqlcxp sqlfpn =
{
    31,
    "D:\\CRF-511\\BLRLM008\\BLRLM008.pc"
};


static unsigned long sqlctx = 1343297435;


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
            void  *sqhstv[24];
   unsigned int   sqhstl[24];
            int   sqhsts[24];
            void  *sqindv[24];
            int   sqinds[24];
   unsigned int   sqharm[24];
   unsigned int   *sqharc[24];
   unsigned short  sqadto[24];
   unsigned short  sqtdso[24];
} sqlstm = {10,24};

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
"d) and b.blng_grp_id=d.blng_grp_id) \
and d.settlement_ind='X') and d.adm_rec_flag=2) and b.blng_grp_id between nvl\
(:b2,'!!!!') and nvl(:b3,'~~~~')) and b.patient_id between nvl(:b4,'!!!!!!!!!\
!!!!!!!!!!!') and nvl(:b5,'~~~~~~~~~~~~~~~~~~~~')) and b.cust_code between nv\
l(:b6,'!!!!!!!!') and nvl(:b7,'~~~~~~~~')) and c.cur_ward_code between nvl(:b\
8,'!!!!') and nvl(:b9,'~~~~')) and trunc(c.admission_date_time) between trunc\
(to_date(nvl(:b10,'01/01/1000'),'dd/mm/yyyy')) and trunc(to_date(nvl(:b11,'01\
/01/4712'),'dd/mm/yyyy'))) group by a.patient_id,c.cur_ward_code,c.episode_id\
,b.blng_grp_id,b.cust_code,b.BED_BILL_BED_TYPE_CODE,to_char(c.admission_date_\
time,'dd/mm/yyyy hh24:mi'),(nvl(b.discharge_date_time,sysdate)-b.admission_da\
te_time),substr(a.ADDED_BY_ID,1,15),b.encounter_id order by b.blng_grp_id,(su\
m(a.APPROVED_AMT)-sum((NVL(b.tot_billed_amt,0)+NVL(b.tot_unbld_amt,0)))) desc\
             ";

 static const char *sq0009 = 
"episode_id) and a.episode_id=c.open_\
episode_id) and a.episode_id=d.episode_id) and b.blng_grp_id=a.blng_grp_id) a\
nd b.blng_grp_id=e.blng_grp_id) and e.settlement_ind='X') and e.adm_rec_flag=\
2) and b.blng_grp_id between nvl(:b2,'!!!!') and nvl(:b3,'~~~~')) and b.patie\
nt_id between nvl(:b4,'!!!!!!!!!!!!!!!!!!!!') and nvl(:b5,'~~~~~~~~~~~~~~~~~~\
~~')) and b.cust_code between nvl(:b6,'!!!!!!!!') and nvl(:b7,'~~~~~~~~')) an\
d d.cur_ward_code between nvl(:b8,'!!!!') and nvl(:b9,'~~~~')) and trunc(c.ad\
mission_date_time) between trunc(to_date(nvl(:b10,'01/01/1000'),'dd/mm/yyyy')\
) and trunc(to_date(nvl(:b11,'01/01/4712'),'dd/mm/yyyy'))) group by a.patient\
_id,d.cur_ward_code,c.open_episode_id,b.blng_grp_id,b.cust_code,b.BED_BILL_BE\
D_TYPE_CODE,to_char(c.admission_date_time,'dd/mm/yyyy hh24:mi'),(sysdate-b.ad\
mission_date_time),substr(a.ADDED_BY_ID,1,15),b.encounter_id order by b.blng_\
grp_id,(sum(a.APPROVED_AMT)-sum((NVL(b.tot_billed_amt,0)+NVL(b.tot_unbld_amt,\
0)))) desc             ";

 static const char *sq0012 = 
") and d.settlement_ind='X') and d.ad\
m_rec_flag=2) and b.blng_grp_id between nvl(:b2,'!!!!') and nvl(:b3,'~~~~')) \
and b.patient_id between nvl(:b4,'!!!!!!!!!!!!!!!!!!!!') and nvl(:b5,'~~~~~~~\
~~~~~~~~~~~~~')) and b.cust_code between nvl(:b6,'!!!!!!!!') and nvl(:b7,'~~~\
~~~~~')) and c.clinic_code between nvl(:b8,'!!!!') and nvl(:b9,'~~~~')) and t\
runc(c.visit_regn_date_time) between trunc(to_date(nvl(:b10,'1/1/1000'),'dd/m\
m/yyyy')) and trunc(to_date(nvl(:b11,'1/1/4712'),'dd/mm/yyyy'))) group by a.p\
atient_id,c.clinic_code,c.episode_id,c.visit_id,b.blng_grp_id,b.cust_code,to_\
char(c.visit_regn_date_time,'dd/mm/yyyy hh24:mi'),substr(a.ADDED_BY_ID,1,15),\
b.encounter_id order by b.blng_grp_id,(sum(a.APPROVED_AMT)-sum((NVL(b.tot_bil\
led_amt,0)+NVL(b.tot_unbld_amt,0)))) desc             ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,88,0,6,239,0,0,1,1,0,1,0,1,9,0,0,
24,0,0,2,0,0,30,275,0,0,0,0,0,1,0,
39,0,0,3,398,0,4,325,0,0,24,4,0,1,0,2,1,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,1,0,0,2,1,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
150,0,0,4,116,0,2,396,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
181,0,0,6,1920,0,9,873,0,0,12,12,0,1,0,1,9,0,0,1,1,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
244,0,0,9,2007,0,9,887,0,0,12,12,0,1,0,1,9,0,0,1,1,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
307,0,0,12,1807,0,9,902,0,0,12,12,0,1,0,1,9,0,0,1,1,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
370,0,0,6,0,0,15,920,0,0,0,0,0,1,0,
385,0,0,9,0,0,15,926,0,0,0,0,0,1,0,
400,0,0,12,0,0,15,933,0,0,0,0,0,1,0,
415,0,0,5,0,0,13,971,0,0,15,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,
490,0,0,8,0,0,13,989,0,0,15,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,
565,0,0,11,0,0,13,1008,0,0,15,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,
0,
640,0,0,6,0,0,13,1083,0,0,15,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,
715,0,0,9,0,0,13,1100,0,0,15,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,
790,0,0,12,0,0,13,1119,0,0,15,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,
0,
865,0,0,7,0,0,13,1182,0,0,9,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,4,0,0,2,3,0,0,2,9,0,0,
916,0,0,10,0,0,13,1193,0,0,9,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,4,0,0,2,3,0,0,2,9,0,0,
967,0,0,13,0,0,13,1206,0,0,9,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,4,0,0,2,3,0,0,2,9,0,0,
1018,0,0,14,167,0,4,1501,0,0,6,5,0,1,0,2,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,1,0,0,
1,9,0,0,
1057,0,0,15,167,0,4,1578,0,0,6,5,0,1,0,2,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,1,0,0,
1,9,0,0,
1096,0,0,16,150,0,4,1897,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
1131,0,0,17,0,0,27,1965,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
1162,0,0,18,132,0,4,1996,0,0,3,2,0,1,0,1,9,0,0,2,9,0,0,1,9,0,0,
1189,0,0,19,163,0,4,2020,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1220,0,0,20,155,0,4,2054,0,0,6,5,0,1,0,2,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,1,0,0,
1,9,0,0,
1259,0,0,21,96,0,4,2119,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
1286,0,0,22,96,0,4,2142,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
1309,0,0,23,165,0,6,2149,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
1340,0,0,24,207,0,6,2172,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
};


/************************************************************************/ 
/* OCS MEDICOM VER 1.0                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLRLM008.PC                                  */
/* AUTHOR                : Soby Varghese.                                    */
/* DATE WRITTEN          : 26-FEB-2003                                 */
/*                                                                      */
/* CALLED FROM           :                                              */
/*                                                                      */
/*  FUNCTION             :                                              */
/*                                                                      */
/*  TABLE DETAILS                                                       */
/*                                                                      */
/*        S. No.       TABLENAMES             INPUT/OUTPUT              */
/*                                                                      */
/*                                                                      */
/*  PARAMETERS           :            -                                 */
/*                                                                      */
/*  SUBROUTINES          :                                              */
/*                                                                      */
/*         1.            ERR_MESG            err_mesg                   */
/*                                                                      */
/*                                                                      */
/************************************************************************/ 

#include <stdio.h>
#include <string.h>
#include "gl.h"

#define OERROR (sqlca.sqlcode < 0)
#define LAST_ROW (sqlca.sqlcode == 1403)
#define NO_DATA_FOUND		(sqlca.sqlcode == 1403)
#define NOT_FOUND (sqlca.sqlerrd[2] == 0)
#define RESOURCE_BUSY        (sqlca.sqlcode == -54)
#define DUPLICATE_KEY        (sqlca.sqlcode == -1)
#define ROW_COUNT            (sqlca.sqlerrd[2])
#define INIT_MESG "Report Generation In Progress"
#define ESC     0x1B
#define REP_WIDTH 151

/*
#define DEBUG 0
*/


/* EXEC SQL BEGIN DECLARE SECTION; */ 


    /* VARCHAR hosp_name                                  [120],
            uid_pwd                                    [91],
            date_time                                  [20],
            user_id                                    [31],
            nd_session_id                              [16],
            nd_pgm_date                                [25],
            nd_from_adm_no                             [9],
            nd_to_adm_no                               [9],
	        nd_cutoff_dt                               [17],
	        nd_chk_dt                                  [17],
			 nd_facility_id   [3],
			
			p_language_id[3],
            d_curr_pgm_name                            [15],
			l_pk_value	[100],
			l_translated_value	        [201],
			nd_temp_date							   [21],
			nd_loc_date[21],
			date_convert[21]; */ 
struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[31]; } user_id;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[9]; } nd_from_adm_no;

struct { unsigned short len; unsigned char arr[9]; } nd_to_adm_no;

struct { unsigned short len; unsigned char arr[17]; } nd_cutoff_dt;

struct { unsigned short len; unsigned char arr[17]; } nd_chk_dt;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[21]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[21]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[21]; } date_convert;


   /* VARCHAR nd_patient_id                 [21],
           nd_patient_name               [41],
		   d_cust_code					 [9],
		   d_bed_type					 [3],
		   d_proc_code					 [11],
		   d_adm_date					 [19],
		   d_auth_by					 [21],
		   nd_episode_id				 [9],
		   nd_visit_id					 [5],
		   nd_fm_blng_grp_id             [5],
		   nd_to_blng_grp_id             [5],
		   nd_fm_patient_id				 [21],
		   nd_to_patient_id				 [21],
		   nd_fm_cust_code				 [9],
		   nd_to_cust_code				 [9],
		   nd_fm_ward_code				 [5],
		   nd_to_ward_code				 [5],
		   nd_fm_clinic_code			 [5],
		   nd_to_clinic_code			 [5],
		   nd_fm_adm_date				 [11],
		   nd_to_adm_date				 [11],
		   nd_fm_visit_date				 [11],
		   nd_to_visit_date				 [11],
		   nd_blng_grp_id                [5],
		   t_blng_grp_id                 [5],
		   nd_auth_amt                   [10],
		   nd_authorized_days            [6],
		   nd_auth_day                   [6],
		   nd_ward_code                  [5],
		   nd_blng_grp_desc              [41], 	
		   nd_operating_facility_id      [3],
		   nd_proc_code                  [11],
		   nd_encounter_id               [13]; */ 
struct { unsigned short len; unsigned char arr[21]; } nd_patient_id;

struct { unsigned short len; unsigned char arr[41]; } nd_patient_name;

struct { unsigned short len; unsigned char arr[9]; } d_cust_code;

struct { unsigned short len; unsigned char arr[3]; } d_bed_type;

struct { unsigned short len; unsigned char arr[11]; } d_proc_code;

struct { unsigned short len; unsigned char arr[19]; } d_adm_date;

struct { unsigned short len; unsigned char arr[21]; } d_auth_by;

struct { unsigned short len; unsigned char arr[9]; } nd_episode_id;

struct { unsigned short len; unsigned char arr[5]; } nd_visit_id;

struct { unsigned short len; unsigned char arr[5]; } nd_fm_blng_grp_id;

struct { unsigned short len; unsigned char arr[5]; } nd_to_blng_grp_id;

struct { unsigned short len; unsigned char arr[21]; } nd_fm_patient_id;

struct { unsigned short len; unsigned char arr[21]; } nd_to_patient_id;

struct { unsigned short len; unsigned char arr[9]; } nd_fm_cust_code;

struct { unsigned short len; unsigned char arr[9]; } nd_to_cust_code;

struct { unsigned short len; unsigned char arr[5]; } nd_fm_ward_code;

struct { unsigned short len; unsigned char arr[5]; } nd_to_ward_code;

struct { unsigned short len; unsigned char arr[5]; } nd_fm_clinic_code;

struct { unsigned short len; unsigned char arr[5]; } nd_to_clinic_code;

struct { unsigned short len; unsigned char arr[11]; } nd_fm_adm_date;

struct { unsigned short len; unsigned char arr[11]; } nd_to_adm_date;

struct { unsigned short len; unsigned char arr[11]; } nd_fm_visit_date;

struct { unsigned short len; unsigned char arr[11]; } nd_to_visit_date;

struct { unsigned short len; unsigned char arr[5]; } nd_blng_grp_id;

struct { unsigned short len; unsigned char arr[5]; } t_blng_grp_id;

struct { unsigned short len; unsigned char arr[10]; } nd_auth_amt;

struct { unsigned short len; unsigned char arr[6]; } nd_authorized_days;

struct { unsigned short len; unsigned char arr[6]; } nd_auth_day;

struct { unsigned short len; unsigned char arr[5]; } nd_ward_code;

struct { unsigned short len; unsigned char arr[41]; } nd_blng_grp_desc;

struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[11]; } nd_proc_code;

struct { unsigned short len; unsigned char arr[13]; } nd_encounter_id;


		   		    
   
   	/* varchar string_var[1000]; */ 
struct { unsigned short len; unsigned char arr[1000]; } string_var;

   double nd_current_bill_amount,
          nd_authorized_amount,nd_bill_amt;
		 
   int    nd_length_of_stay;
   int i;

   int    nblng_ctr = 0;
   int    ngblng_ctr = 0;
   int	  flag = 0; 
   
   int    c_hd_fl =1; 
   int    e_hd_fl =1;
   int    b_hd_fl =1;
   
   char loc_legend[999][201]; 
   char   nd_rep_option,
		  nd_inc_disc_pat,
		  from_blng[10],
		  to_blng[10],
		  from_pat[10],
		  to_pat[10],
		  from_cust[10],
		  to_cust[10],
		  from_ward[10],
		  to_ward[10],
		  from_date[10],
		  to_date[10],
		  from_clinic[10],
		  to_clinic[10],
		  nd_episode_type;
   
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

int s_lctr = 0,s_pctr = 0;
int d_lctr = 0,d_pctr = 0;
int pctr = 0;

FILE *f1, *f2;

int bill_ctr = 0;

double g_tot_outst;
double g_tot_amt,
       g_tot_billed_amt,
       g_tot_unbilled_amt,
       g_tot_disc_amt,
       g_tot_pmnt_recd,
       g_tot_ref_amt;

char hdr_line1[REP_WIDTH+1],
     hdr_line2[REP_WIDTH+1],
     hdr_line3[REP_WIDTH+1],
     hdr_line4[REP_WIDTH+1];

char rep_title[] = "AUTHORIZATION EXCEPTION REPORT";

void proc_main(argc,argv)
char *argv[];
int argc;
{
    int rec_ctr = 0;

   
    if (argc < 4)
    {
     int i = 0;
       disp_message(ERR_MESG,"Not enough Parameters for running this program");
       proc_exit();
    }

	  strcpy(uid_pwd.arr,argv[1]);
      uid_pwd.len = strlen(uid_pwd.arr);
 
      strcpy(g_pgm_id,"BLRLM008");

  if(sql_connect() == -1)
   {
      disp_message(ERR_MESG,"Error in connecting to Oracle");
      if (uid_pwd.len == 0)
         disp_message(ERR_MESG,"Null oracle uid/pwd");
      proc_exit();
   } 


   
    strcpy(d_curr_pgm_name.arr,g_pgm_id); 
    d_curr_pgm_name.len = strlen(d_curr_pgm_name.arr); 

    strcpy(nd_session_id.arr,argv[2]);
    nd_session_id.len = strlen(nd_session_id.arr);
    strcpy(g_session_id,nd_session_id.arr);

    strcpy(nd_pgm_date.arr,argv[3]);
    nd_pgm_date.len = strlen(nd_pgm_date.arr);
    strcpy(g_pgm_date,nd_pgm_date.arr);

    set_meduser_role();


     //ADDED BY SEN

 strcpy(d_curr_pgm_name.arr,g_pgm_id); 
    d_curr_pgm_name.len = strlen(d_curr_pgm_name.arr);
	
	strcpy(p_language_id.arr,l_language_id.arr);
	 p_language_id.len = l_language_id.len; 
	 

    strcpy(nd_session_id.arr,argv[2]);
    nd_session_id.len = strlen(nd_session_id.arr);
    strcpy(g_session_id,nd_session_id.arr);

    strcpy(nd_pgm_date.arr,argv[3]);
    nd_pgm_date.len = strlen(nd_pgm_date.arr);
    strcpy(g_pgm_date,nd_pgm_date.arr);

	strcpy(nd_facility_id.arr, argv[4]);
	nd_facility_id.len = strlen(nd_facility_id.arr);


    //


   //start_prog_msg();
    
    fetch_prog_param();
	fetch_legend_value();

  	strcpy(rep_title,loc_legend[146]);
  
	/* EXEC SQL EXECUTE
	BEGIN
	SM_SECURITY_POLICY.SET_CTX_FOR_FACILITY_ID(:nd_operating_facility_id);
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 1;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin SM_SECURITY_POLICY . SET_CTX_FOR_FACILITY_ID ( :nd_op\
erating_facility_id ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )5;
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


  
	if(nd_rep_option == 'I') 
    declare_cur_ip();
	else
	declare_cur_op();

    fetch_hosp_name();

    open_file();
     
    open_bl_exp_cur(); 	
	
	strcpy(t_blng_grp_id.arr,"!!!!!");
    t_blng_grp_id.len = strlen(t_blng_grp_id.arr);

    process();
    
	close_bl_exp_cur();
    
    

    end_of_rep();

    fprintf(f2,"\n\n\n\n\n");	  
    
    
    //end_prog_msg(); 
   	fprintf(f2,"%c(s10H",ESC);
    fprintf(f2,"%c&l0O",ESC);   
    fclose(f2);    
    
    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 1;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )24;
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
  nd_fm_blng_grp_id.arr[0]		= '\0';
  nd_to_blng_grp_id.arr[0]		= '\0';
  nd_auth_amt.arr[0]			= '\0';
  nd_auth_day.arr[0]			= '\0';
  nd_fm_patient_id.arr[0]		= '\0';
  nd_to_patient_id.arr[0]		= '\0';
  nd_fm_cust_code.arr[0]		= '\0';
  nd_to_cust_code.arr[0]		= '\0';
  nd_fm_adm_date.arr[0]			= '\0';
  nd_to_adm_date.arr[0]			= '\0';
  nd_fm_visit_date.arr[0]		= '\0';
  nd_to_visit_date.arr[0]		= '\0';
  nd_fm_ward_code.arr[0]		= '\0';
  nd_to_ward_code.arr[0]		= '\0';
  nd_fm_clinic_code.arr[0]		= '\0';
  nd_to_clinic_code.arr[0]		= '\0';
  nd_operating_facility_id.arr[0]		= '\0';
  
  nd_fm_blng_grp_id.len			= 0;
  nd_to_blng_grp_id.len			= 0; 
  nd_auth_amt.len				= 0;
  nd_auth_day.len				= 0; 
  nd_fm_patient_id.len			= 0;
  nd_to_patient_id.len			= 0; 
  nd_fm_cust_code.len			= 0;
  nd_to_cust_code.len			= 0; 
  nd_fm_adm_date.len			= 0;
  nd_to_adm_date.len			= 0; 
  nd_fm_visit_date.len			= 0;
  nd_to_visit_date.len			= 0; 
  nd_fm_ward_code.len			= 0;
  nd_to_ward_code.len			= 0; 
  nd_fm_clinic_code.len			= 0;
  nd_to_clinic_code.len			= 0; 
  nd_operating_facility_id.len			= 0;
  
 


   /* EXEC SQL SELECT          PARAM1,
                            PARAM2,
				            PARAM3 ,
				            PARAM4,
							PARAM5,
							PARAM6,
							PARAM7,
							PARAM8,
							PARAM9,
							PARAM10,
							PARAM11,
							PARAM12,
							PARAM13,
							PARAM14,
							PARAM15,
							PARAM16,
							PARAM17,
							PARAM18,
							PARAM19,
							OPERATING_FACILITY_ID
              INTO :nd_episode_type,
				   :nd_fm_blng_grp_id,
			       :nd_to_blng_grp_id,
				   :nd_auth_amt,
				   :nd_auth_day,
				   :nd_fm_patient_id,
				   :nd_to_patient_id,
				   :nd_fm_cust_code,
				   :nd_to_cust_code,
				   :nd_fm_adm_date,
				   :nd_to_adm_date,
				   :nd_fm_visit_date,
				   :nd_to_visit_date,
				   :nd_fm_ward_code,
				   :nd_to_ward_code,
				   :nd_fm_clinic_code,
				   :nd_to_clinic_code,
				   :nd_rep_option,
				   :nd_inc_disc_pat,
				   :nd_operating_facility_id
              FROM SY_PROG_PARAM
             WHERE OPERATING_FACILITY_ID  = :nd_facility_id 
			      AND PGM_ID     = :d_curr_pgm_name
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 ,PARAM5 ,PARAM6 ,PA\
RAM7 ,PARAM8 ,PARAM9 ,PARAM10 ,PARAM11 ,PARAM12 ,PARAM13 ,PARAM14 ,PARAM15 ,P\
ARAM16 ,PARAM17 ,PARAM18 ,PARAM19 ,OPERATING_FACILITY_ID into :b0,:b1,:b2,:b3\
,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12,:b13,:b14,:b15,:b16,:b17,:b18,:b19  f\
rom SY_PROG_PARAM where (((OPERATING_FACILITY_ID=:b20 and PGM_ID=:b21) and SE\
SSION_ID=:b22) and PGM_DATE=:b23)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )39;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_episode_type;
   sqlstm.sqhstl[0] = (unsigned int  )1;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_fm_blng_grp_id;
   sqlstm.sqhstl[1] = (unsigned int  )7;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_to_blng_grp_id;
   sqlstm.sqhstl[2] = (unsigned int  )7;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_auth_amt;
   sqlstm.sqhstl[3] = (unsigned int  )12;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_auth_day;
   sqlstm.sqhstl[4] = (unsigned int  )8;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_fm_patient_id;
   sqlstm.sqhstl[5] = (unsigned int  )23;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_to_patient_id;
   sqlstm.sqhstl[6] = (unsigned int  )23;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_fm_cust_code;
   sqlstm.sqhstl[7] = (unsigned int  )11;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_to_cust_code;
   sqlstm.sqhstl[8] = (unsigned int  )11;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_fm_adm_date;
   sqlstm.sqhstl[9] = (unsigned int  )13;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_to_adm_date;
   sqlstm.sqhstl[10] = (unsigned int  )13;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&nd_fm_visit_date;
   sqlstm.sqhstl[11] = (unsigned int  )13;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&nd_to_visit_date;
   sqlstm.sqhstl[12] = (unsigned int  )13;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&nd_fm_ward_code;
   sqlstm.sqhstl[13] = (unsigned int  )7;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&nd_to_ward_code;
   sqlstm.sqhstl[14] = (unsigned int  )7;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&nd_fm_clinic_code;
   sqlstm.sqhstl[15] = (unsigned int  )7;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&nd_to_clinic_code;
   sqlstm.sqhstl[16] = (unsigned int  )7;
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&nd_rep_option;
   sqlstm.sqhstl[17] = (unsigned int  )1;
   sqlstm.sqhsts[17] = (         int  )0;
   sqlstm.sqindv[17] = (         void  *)0;
   sqlstm.sqinds[17] = (         int  )0;
   sqlstm.sqharm[17] = (unsigned int  )0;
   sqlstm.sqadto[17] = (unsigned short )0;
   sqlstm.sqtdso[17] = (unsigned short )0;
   sqlstm.sqhstv[18] = (         void  *)&nd_inc_disc_pat;
   sqlstm.sqhstl[18] = (unsigned int  )1;
   sqlstm.sqhsts[18] = (         int  )0;
   sqlstm.sqindv[18] = (         void  *)0;
   sqlstm.sqinds[18] = (         int  )0;
   sqlstm.sqharm[18] = (unsigned int  )0;
   sqlstm.sqadto[18] = (unsigned short )0;
   sqlstm.sqtdso[18] = (unsigned short )0;
   sqlstm.sqhstv[19] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[19] = (unsigned int  )5;
   sqlstm.sqhsts[19] = (         int  )0;
   sqlstm.sqindv[19] = (         void  *)0;
   sqlstm.sqinds[19] = (         int  )0;
   sqlstm.sqharm[19] = (unsigned int  )0;
   sqlstm.sqadto[19] = (unsigned short )0;
   sqlstm.sqtdso[19] = (unsigned short )0;
   sqlstm.sqhstv[20] = (         void  *)&nd_facility_id;
   sqlstm.sqhstl[20] = (unsigned int  )5;
   sqlstm.sqhsts[20] = (         int  )0;
   sqlstm.sqindv[20] = (         void  *)0;
   sqlstm.sqinds[20] = (         int  )0;
   sqlstm.sqharm[20] = (unsigned int  )0;
   sqlstm.sqadto[20] = (unsigned short )0;
   sqlstm.sqtdso[20] = (unsigned short )0;
   sqlstm.sqhstv[21] = (         void  *)&d_curr_pgm_name;
   sqlstm.sqhstl[21] = (unsigned int  )17;
   sqlstm.sqhsts[21] = (         int  )0;
   sqlstm.sqindv[21] = (         void  *)0;
   sqlstm.sqinds[21] = (         int  )0;
   sqlstm.sqharm[21] = (unsigned int  )0;
   sqlstm.sqadto[21] = (unsigned short )0;
   sqlstm.sqtdso[21] = (unsigned short )0;
   sqlstm.sqhstv[22] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[22] = (unsigned int  )18;
   sqlstm.sqhsts[22] = (         int  )0;
   sqlstm.sqindv[22] = (         void  *)0;
   sqlstm.sqinds[22] = (         int  )0;
   sqlstm.sqharm[22] = (unsigned int  )0;
   sqlstm.sqadto[22] = (unsigned short )0;
   sqlstm.sqtdso[22] = (unsigned short )0;
   sqlstm.sqhstv[23] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[23] = (unsigned int  )27;
   sqlstm.sqhsts[23] = (         int  )0;
   sqlstm.sqindv[23] = (         void  *)0;
   sqlstm.sqinds[23] = (         int  )0;
   sqlstm.sqharm[23] = (unsigned int  )0;
   sqlstm.sqadto[23] = (unsigned short )0;
   sqlstm.sqtdso[23] = (unsigned short )0;
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
       
 
	   nd_fm_blng_grp_id.arr[nd_fm_blng_grp_id.len] = '\0';
       nd_to_blng_grp_id.arr[nd_to_blng_grp_id.len] = '\0';
       nd_auth_amt.arr[nd_auth_amt.len]				= '\0';
       nd_auth_day.arr[nd_auth_day.len]				= '\0';
	   nd_fm_patient_id.arr[nd_fm_patient_id.len]	= '\0';
       nd_to_patient_id.arr[nd_to_patient_id.len]	= '\0';
       nd_fm_cust_code.arr[nd_fm_cust_code.len]		= '\0';
       nd_to_cust_code.arr[nd_to_cust_code.len]		= '\0';
       nd_fm_adm_date.arr[nd_fm_adm_date.len]		= '\0';
       nd_to_adm_date.arr[nd_to_adm_date.len]		= '\0';
	   nd_fm_visit_date.arr[nd_fm_visit_date.len]	= '\0';
       nd_to_visit_date.arr[nd_to_visit_date.len]	= '\0';
	   nd_fm_ward_code.arr[nd_fm_ward_code.len]		= '\0';
       nd_to_ward_code.arr[nd_to_ward_code.len]		= '\0';
       nd_fm_clinic_code.arr[nd_fm_clinic_code.len]	= '\0';
       nd_to_clinic_code.arr[nd_to_clinic_code.len]	= '\0';
	   nd_operating_facility_id.arr[nd_operating_facility_id.len]	= '\0';
       
   if (NOT_FOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");

   /* EXEC SQL DELETE SY_PROG_PARAM
             WHERE OPERATING_FACILITY_ID = :nd_facility_id 
			     AND  PGM_ID     = :d_curr_pgm_name
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where (((OPERATING_FACILITY_I\
D=:b0 and PGM_ID=:b1) and SESSION_ID=:b2) and PGM_DATE=:b3)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )150;
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
   sqlstm.sqhstv[1] = (         void  *)&d_curr_pgm_name;
   sqlstm.sqhstl[1] = (unsigned int  )17;
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
   sqlstm.sqhstv[3] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[3] = (unsigned int  )27;
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
         err_mesg("DELETE failed on table SY_PROG_PARAM",0,"");
   
} 

declare_cur_ip()
{
    
		if(nd_inc_disc_pat == 'Y')
	{
	/* EXEC SQL DECLARE E_EXP_IP_CUR CURSOR FOR
	        select b.blng_grp_id,    
            a.patient_id,--sen
			b.cust_code,
			--a.bed_type, --sen
			b.BED_BILL_BED_TYPE_CODE,
			null, --a.proc_code,
			c.episode_id,
			0 visit_id,
			to_char(c.admission_date_time, 'dd/mm/yyyy hh24:mi'),
			sum (NVL(b.tot_billed_amt,0)+NVL(b.tot_unbld_amt,0)) Current_bill_amount,
            sum(NVL(a.APPROVED_AMT,0)) Authorized_amount,
            sum(NVL(a.APPROVED_DAYS,0))   Authorized_days,
			substr(a.ADDED_BY_ID,1,15),
            ROUND(nvl(b.discharge_date_time,sysdate)-b.admission_date_time) length_of_stay,
			c.cur_ward_code --a.ward_code sen
			,b.encounter_id
            from  bl_encounter_payer_priority a,
                bl_episode_fin_dtls b,
	        ip_episode c,
			bl_blng_grp d
            where a.episode_id=b.episode_id
			and   a.episode_id=c.episode_id
            and   a.episode_type=b.episode_type
			and   a.episode_type=c.episode_type
			and   a.OPERATING_FACILITY_ID=b.OPERATING_FACILITY_ID
			and   a.OPERATING_FACILITY_ID=c.FACILITY_ID
			and   a.OPERATING_FACILITY_ID=:nd_facility_id
            and   a.episode_type=:nd_episode_type --'I'
			and   a.episode_type in('I','D')
			and   nvl(c.episode_status,'0') != '9'
			and   b.blng_grp_id =a.blng_grp_id
            and   b.blng_grp_id=d.blng_grp_id
			and   d.settlement_ind='X' and d.adm_rec_flag=2
			and b.blng_grp_id between 
				    nvl(:nd_fm_blng_grp_id,'!!!!') and nvl(:nd_to_blng_grp_id,'~~~~')
			and b.patient_id between
					nvl(:nd_fm_patient_id,'!!!!!!!!!!!!!!!!!!!!') and nvl(:nd_to_patient_id,'~~~~~~~~~~~~~~~~~~~~')
			and b.cust_code between
					nvl(:nd_fm_cust_code,'!!!!!!!!') and nvl(:nd_to_cust_code,'~~~~~~~~')
			and c.cur_ward_code between
					nvl(:nd_fm_ward_code,'!!!!') and nvl(:nd_to_ward_code,'~~~~')
			and trunc(c.admission_date_time) between
			
				trunc(to_date(nvl(:nd_fm_adm_date,'01/01/1000'),'dd/mm/yyyy')) and 
					trunc(to_date(nvl(:nd_to_adm_date,'01/01/4712'),'dd/mm/yyyy'))
            group by	a.patient_id,c.CUR_WARD_CODE,c.episode_id,b.blng_grp_id,			
						b.cust_code, b.BED_BILL_BED_TYPE_CODE,to_char(c.admission_date_time, 'dd/mm/yyyy hh24:mi'),			
			(nvl(b.discharge_date_time,sysdate)-b.admission_date_time), substr(a.ADDED_BY_ID,1,15),b.encounter_id--, a.proc_code sen
			having (sum(NVL(b.tot_billed_amt,0)+NVL(b.tot_unbld_amt,0))-sum(a.APPROVED_AMT)) >= :nd_auth_amt
			        or
			       Round(nvl(b.discharge_date_time,sysdate)-b.admission_date_time) - sum(NVL(a.APPROVED_DAYS,0)) >= :nd_auth_day
            order by b.blng_grp_id,(sum(NVL(b.tot_billed_amt,0)+NVL(b.tot_unbld_amt,0))-sum(a.APPROVED_AMT)); */ 



     /* EXEC SQL DECLARE B_EXP_IP_CUR CURSOR FOR
	        select b.blng_grp_id,    
            a.patient_id,
			b.cust_code,
			--a.bed_type,
			b.BED_BILL_BED_TYPE_CODE,
			null, --a.proc_code,
			c.episode_id,
			0 visit_id,
			to_char(c.admission_date_time, 'dd/mm/yyyy hh24:mi'),
			sum (NVL(b.tot_billed_amt,0)+NVL(b.tot_unbld_amt,0)) Current_bill_amount,
            sum(NVL(a.APPROVED_AMT,0)) Authorized_amount,
            sum(NVL(a.APPROVED_DAYS,0))   Authorized_days,
			substr(a.ADDED_BY_ID,1,15),
            ROUND(nvl(b.discharge_date_time,sysdate)-b.admission_date_time) length_of_stay,
			c.cur_ward_code --,a.ward_code
			,b.encounter_id
            from bl_encounter_payer_priority a,--bl_credit_authorization a,
                bl_episode_fin_dtls b,
	        ip_episode c,
			bl_blng_grp d
            where 
			a.OPERATING_FACILITY_ID=b.OPERATING_FACILITY_ID
			and   a.OPERATING_FACILITY_ID=c.FACILITY_ID
			and   a.OPERATING_FACILITY_ID=:nd_facility_id
			and   a.episode_type=b.episode_type
			and   a.episode_type=c.episode_type
			and   a.episode_type in('I','D')
            and   a.episode_type=:nd_episode_type --'I'
			and   a.patient_id=b.patient_id
			and   a.patient_id=c.patient_id 
			and   a.episode_id=b.episode_id
			and   a.episode_id=c.episode_id
            and   nvl(c.episode_status,'0') != '9'
          	and   b.blng_grp_id =a.blng_grp_id
            and   b.blng_grp_id=d.blng_grp_id
			and   d.settlement_ind='X' and d.adm_rec_flag=2 
			and b.blng_grp_id between 
				    nvl(:nd_fm_blng_grp_id,'!!!!') and nvl(:nd_to_blng_grp_id,'~~~~')
			and b.patient_id between
					nvl(:nd_fm_patient_id,'!!!!!!!!!!!!!!!!!!!!') and nvl(:nd_to_patient_id,'~~~~~~~~~~~~~~~~~~~~')
			and b.cust_code between
					nvl(:nd_fm_cust_code,'!!!!!!!!') and nvl(:nd_to_cust_code,'~~~~~~~~')
			and c.cur_ward_code between
					nvl(:nd_fm_ward_code,'!!!!') and nvl(:nd_to_ward_code,'~~~~')
			and trunc(c.admission_date_time) between
			trunc(to_date(nvl(:nd_fm_adm_date,'01/01/1000'),'dd/mm/yyyy')) and 
					trunc(to_date(nvl(:nd_to_adm_date,'01/01/4712'),'dd/mm/yyyy')) 
            group by	a.patient_id,c.cur_ward_code,c.episode_id,b.blng_grp_id,			
						b.cust_code, b.BED_BILL_BED_TYPE_CODE,to_char(c.admission_date_time, 'dd/mm/yyyy hh24:mi'),			
			(nvl(b.discharge_date_time,sysdate)-b.admission_date_time),substr(a.ADDED_BY_ID,1,15),b.encounter_id--, a.proc_code
			--having sum(a.APPROVED_AMT)-(sum(NVL(b.tot_billed_amt,0)+NVL(b.tot_unbld_amt,0))) > 0
            order by b.blng_grp_id,(sum(a.APPROVED_AMT) - sum(NVL(b.tot_billed_amt,0)+NVL(b.tot_unbld_amt,0))) desc; */ 





     /* EXEC SQL DECLARE C_EXP_IP_CUR CURSOR FOR
	        select b.blng_grp_id,    
            c.patient_id,
			b.cust_code,
			c.episode_id,
			0 visit_id,
			to_char(c.admission_date_time, 'dd/mm/yyyy hh24:mi'),
			sum (NVL(b.tot_billed_amt,0)+NVL(b.tot_unbld_amt,0)) Current_bill_amount,
            ROUND(nvl(b.discharge_date_time,sysdate)-b.admission_date_time) length_of_stay
			,b.encounter_id
			from bl_episode_fin_dtls b,
            ip_episode c
            where b.episode_id=c.episode_id
			and   b.episode_type=c.episode_type   
			and   b.episode_type=:nd_episode_type  --sen
			and   b.OPERATING_FACILITY_ID=c.FACILITY_ID
			and   b.OPERATING_FACILITY_ID=:nd_facility_id
			and   nvl(c.episode_status,'0') != '9'
            and b.blng_grp_id between 
				    nvl(:nd_fm_blng_grp_id,'!!!!') and nvl(:nd_to_blng_grp_id,'~~~~')
			and b.patient_id between
					nvl(:nd_fm_patient_id,'!!!!!!!!!!!!!!!!!!!!') and nvl(:nd_to_patient_id,'~~~~~~~~~~~~~~~~~~~~')
			and b.cust_code between
					nvl(:nd_fm_cust_code,'!!!!!!!!') and nvl(:nd_to_cust_code,'~~~~~~~~')
			and trunc(c.admission_date_time) between
		trunc(to_date(nvl(:nd_fm_adm_date,'01/01/1000'),'dd/mm/yyyy')) and 
					trunc(to_date(nvl(:nd_to_adm_date,'01/01/4712'),'dd/mm/yyyy'))
			and b.patient_id not in(select patient_id from bl_encounter_payer_priority)
            group by	c.patient_id,c.episode_id,b.blng_grp_id,			
						b.cust_code,to_char(c.admission_date_time, 'dd/mm/yyyy hh24:mi'),			
			(nvl(b.discharge_date_time,sysdate)-b.admission_date_time),b.encounter_id
			order by 1; */ 


}
else
{

/* EXEC SQL DECLARE E1_EXP_IP_CUR CURSOR FOR
	        select b.blng_grp_id,    
            a.patient_id,
			b.cust_code,
			b.BED_BILL_BED_TYPE_CODE,
			null,--a.proc_code,
			c.open_episode_id,
			0 visit_id,
			to_char(c.admission_date_time, 'dd/mm/yyyy hh24:mi'),
			sum (NVL(b.tot_billed_amt,0)+NVL(b.tot_unbld_amt,0)) Current_bill_amount,
            sum(NVL(a.APPROVED_AMT,0)) Authorized_amount,
            sum(NVL(a.APPROVED_DAYS,0))   Authorized_days,
		    substr(a.ADDED_BY_ID,1,15),
            ROUND(sysdate-b.admission_date_time) length_of_stay,
			d.cur_ward_code
			,b.encounter_id
            from bl_encounter_payer_priority a,
                bl_episode_fin_dtls b,
	        ip_open_episode c,
			ip_episode d, --sen
			bl_blng_grp e
            where a.episode_id=b.episode_id
			and   a.episode_id=c.open_episode_id
			and   a.episode_id=d.episode_id
            and   a.episode_type=b.episode_type
			and   a.episode_type=c.episode_type
			and   a.episode_type=d.episode_type  
			and   a.OPERATING_FACILITY_ID=b.OPERATING_FACILITY_ID
			and   a.OPERATING_FACILITY_ID=c.FACILITY_ID
			and   a.OPERATING_FACILITY_ID=d.FACILITY_ID
			and   a.OPERATING_FACILITY_ID=:nd_facility_id
          	and   a.episode_type in('I','D')
            and   a.episode_type=:nd_episode_type
			and   b.blng_grp_id =a.blng_grp_id
            and   b.blng_grp_id=e.blng_grp_id
			and   e.settlement_ind='X' and e.adm_rec_flag=2 
			and b.blng_grp_id between 
				    nvl(:nd_fm_blng_grp_id,'!!!!') and nvl(:nd_to_blng_grp_id,'~~~~')
			and b.patient_id between
					nvl(:nd_fm_patient_id,'!!!!!!!!!!!!!!!!!!!!') and nvl(:nd_to_patient_id,'~~~~~~~~~~~~~~~~~~~~')
			and b.cust_code between
					nvl(:nd_fm_cust_code,'!!!!!!!!') and nvl(:nd_to_cust_code,'~~~~~~~~')
			and d.cur_ward_code between
					nvl(:nd_fm_ward_code,'!!!!') and nvl(:nd_to_ward_code,'~~~~')
			and trunc(c.admission_date_time) between
			trunc(to_date(nvl(:nd_fm_adm_date,'01/01/1000'),'dd/mm/yyyy')) and 
					trunc(to_date(nvl(:nd_to_adm_date,'01/01/4712'),'dd/mm/yyyy')) 
            group by	a.patient_id,d.cur_ward_code,c.open_episode_id,b.blng_grp_id,			
						b.cust_code, b.BED_BILL_BED_TYPE_CODE,to_char(c.admission_date_time, 'dd/mm/yyyy hh24:mi'),			
			(sysdate-b.admission_date_time),substr(a.ADDED_BY_ID,1,15),b.encounter_id--, a.proc_code
			having (sum(NVL(b.tot_billed_amt,0)+NVL(b.tot_unbld_amt,0))-sum(a.APPROVED_AMT)) >= :nd_auth_amt
			        or
			       Round(sysdate-b.admission_date_time) - sum(NVL(a.APPROVED_DAYS,0)) >= :nd_auth_day
            order by b.blng_grp_id,(sum(NVL(b.tot_billed_amt,0)+NVL(b.tot_unbld_amt,0))-sum(a.APPROVED_AMT)); */ 



     /* EXEC SQL DECLARE B1_EXP_IP_CUR CURSOR FOR
	        select b.blng_grp_id,    
            a.patient_id,
			b.cust_code,
			b.BED_BILL_BED_TYPE_CODE,--a.bed_type, sen
			null,--a.proc_code, sen
			c.open_episode_id,
			0 visit_id,
			to_char(c.admission_date_time, 'dd/mm/yyyy hh24:mi'),
			sum (NVL(b.tot_billed_amt,0)+NVL(b.tot_unbld_amt,0)) Current_bill_amount,
            sum(NVL(a.APPROVED_AMT,0)) Authorized_amount,
            sum(NVL(a.APPROVED_DAYS,0))   Authorized_days,
			substr(a.ADDED_BY_ID,1,15),
            ROUND(sysdate-b.admission_date_time) length_of_stay,
			d.cur_ward_code--a.ward_code
			,b.encounter_id
            from bl_encounter_payer_priority a,--bl_credit_authorization a, sen
                bl_episode_fin_dtls b,
	        ip_open_episode c,
			ip_episode d,  --sen
			bl_blng_grp e
            where a.OPERATING_FACILITY_ID=b.OPERATING_FACILITY_ID
			and   a.OPERATING_FACILITY_ID=c.FACILITY_ID
			and   a.OPERATING_FACILITY_ID=d.FACILITY_ID
			and   a.OPERATING_FACILITY_ID=:nd_facility_id
			and   a.episode_type=b.episode_type
			and   a.episode_type=c.episode_type
			and   a.episode_type=d.episode_type  
	        and   a.episode_type=:nd_episode_type
			and   a.episode_type in('I','D')
			and   a.patient_id=b.patient_id
			and   a.patient_id=c.patient_id
            and   a.patient_id=d.patient_id
			and   a.episode_id=b.episode_id
			and   a.episode_id=c.open_episode_id
			and   a.episode_id=d.episode_id --sen
    		and   b.blng_grp_id =a.blng_grp_id
            and   b.blng_grp_id=e.blng_grp_id
			and   e.settlement_ind='X' and e.adm_rec_flag=2 
			and b.blng_grp_id between 
				    nvl(:nd_fm_blng_grp_id,'!!!!') and nvl(:nd_to_blng_grp_id,'~~~~')
			and b.patient_id between
					nvl(:nd_fm_patient_id,'!!!!!!!!!!!!!!!!!!!!') and nvl(:nd_to_patient_id,'~~~~~~~~~~~~~~~~~~~~')
			and b.cust_code between
					nvl(:nd_fm_cust_code,'!!!!!!!!') and nvl(:nd_to_cust_code,'~~~~~~~~')
			and d.cur_ward_code between
					nvl(:nd_fm_ward_code,'!!!!') and nvl(:nd_to_ward_code,'~~~~')
			and trunc(c.admission_date_time) between
				trunc(to_date(nvl(:nd_fm_adm_date,'01/01/1000'),'dd/mm/yyyy')) and 
				trunc(to_date(nvl(:nd_to_adm_date,'01/01/4712'),'dd/mm/yyyy')) 
            group by	a.patient_id,d.cur_ward_code,c.open_episode_id,b.blng_grp_id,			
						b.cust_code, b.BED_BILL_BED_TYPE_CODE,to_char(c.admission_date_time, 'dd/mm/yyyy hh24:mi'),			
			(sysdate-b.admission_date_time),substr(a.ADDED_BY_ID,1,15),b.encounter_id--, a.proc_code
			--having sum(a.APPROVED_AMT)-(sum(NVL(b.tot_billed_amt,0)+NVL(b.tot_unbld_amt,0))) > 0
            order by b.blng_grp_id,(sum(a.APPROVED_AMT) - sum(NVL(b.tot_billed_amt,0)+NVL(b.tot_unbld_amt,0))) desc; */ 





     /* EXEC SQL DECLARE C1_EXP_IP_CUR CURSOR FOR
	        select b.blng_grp_id,    
            c.patient_id,
			b.cust_code,
			c.open_episode_id,
			0 visit_id,
			to_char(c.admission_date_time, 'dd/mm/yyyy hh24:mi'),
			sum (NVL(b.tot_billed_amt,0)+NVL(b.tot_unbld_amt,0)) Current_bill_amount,
            ROUND(sysdate-b.admission_date_time) length_of_stay
			,b.encounter_id
            from bl_episode_fin_dtls b,
	        ip_open_episode c
            where b.episode_id=c.open_episode_id
			and   b.episode_type=c.episode_type
			and   b.OPERATING_FACILITY_ID=c.FACILITY_ID
			and   b.OPERATING_FACILITY_ID=:nd_facility_id
            and b.blng_grp_id between 
				    nvl(:nd_fm_blng_grp_id,'!!!!') and nvl(:nd_to_blng_grp_id,'~~~~')
			and b.patient_id between
					nvl(:nd_fm_patient_id,'!!!!!!!!!!!!!!!!!!!!') and nvl(:nd_to_patient_id,'~~~~~~~~~~~~~~~~~~~~')
			and b.cust_code between
					nvl(:nd_fm_cust_code,'!!!!!!!!') and nvl(:nd_to_cust_code,'~~~~~~~~')
			and trunc(c.admission_date_time) between
				trunc(to_date(nvl(:nd_fm_adm_date,'1/1/1000'),'dd/mm/yyyy')) and 
					trunc(to_date(nvl(:nd_to_adm_date,'1/1/4712'),'dd/mm/yyyy')) 
			and b.patient_id not in(select patient_id from bl_encounter_payer_priority)--sen
            group by	c.patient_id,c.open_episode_id,b.blng_grp_id,			
						b.cust_code,to_char(c.admission_date_time, 'dd/mm/yyyy hh24:mi'),			
			(sysdate-b.admission_date_time),b.encounter_id
			order by 1; */ 

   }

}

declare_cur_op()
{
    
	/* EXEC SQL DECLARE E_EXP_OP_CUR CURSOR FOR
	        select b.blng_grp_id,    
            a.patient_id,
			b.cust_code,
			null,--sen changed in group by also a.BED_BILL_BED_TYPE_CODE
			null,--a.proc_code,
			c.episode_id,
			c.visit_id,
			to_char(c.visit_regn_date_time, 'dd/mm/yyyy hh24:mi'),
			sum (NVL(b.tot_billed_amt,0)+NVL(b.tot_unbld_amt,0)) Current_bill_amount,
            sum(NVL(a.APPROVED_AMT,0)) Authorized_amount,
            sum(NVL(a.APPROVED_DAYS,0))   Authorized_days,
			substr(a.ADDED_BY_ID,1,15), 
            1 length_of_stay,
			c.clinic_code
			,b.encounter_id
            from bl_encounter_payer_priority a,--bl_credit_authorization a,
                bl_visit_fin_dtls b,
				op_visit c,
				bl_blng_grp d
            where a.episode_id=b.episode_id
			and   a.visit_id  =b.visit_id
			and   a.episode_id=c.episode_id
			and   a.visit_id  =c.visit_id
			and   a.episode_type=b.episode_type
			and   a.episode_type=c.episode_type 
			and   a.OPERATING_FACILITY_ID=b.OPERATING_FACILITY_ID
			and   a.OPERATING_FACILITY_ID=c.FACILITY_ID
			and   a.OPERATING_FACILITY_ID=:nd_facility_id
            and   a.episode_type in('O','E')
			and   a.episode_type =:nd_episode_type
			and   nvl(c.visit_status,'0') != '9'
			and   b.blng_grp_id =a.blng_grp_id
            and   b.blng_grp_id=d.blng_grp_id
			and   d.settlement_ind='X' and d.adm_rec_flag=2 
			and b.blng_grp_id between 
				    nvl(:nd_fm_blng_grp_id,'!!!!') and nvl(:nd_to_blng_grp_id,'~~~~')
			and b.patient_id between
					nvl(:nd_fm_patient_id,'!!!!!!!!!!!!!!!!!!!!') and nvl(:nd_to_patient_id,'~~~~~~~~~~~~~~~~~~~~')
			and b.cust_code between
					nvl(:nd_fm_cust_code,'!!!!!!!!') and nvl(:nd_to_cust_code,'~~~~~~~~')
			and c.clinic_code between
					nvl(:nd_fm_clinic_code,'!!!!') and nvl(:nd_to_clinic_code,'~~~~')
			and trunc(c.visit_regn_date_time) between
        	trunc(to_date(nvl(:nd_fm_visit_date,'1/1/1000'),'dd/mm/yyyy')) and 
					trunc(to_date(nvl(:nd_to_visit_date,'1/1/4712'),'dd/mm/yyyy')) 
            group by	a.patient_id,c.clinic_code,c.episode_id,c.visit_id,b.blng_grp_id,			
						b.cust_code,to_char(c.visit_regn_date_time, 'dd/mm/yyyy hh24:mi'),			
			1, substr(a.ADDED_BY_ID,1,15),b.encounter_id--, a.proc_code
			having (sum(NVL(b.tot_billed_amt,0)+NVL(b.tot_unbld_amt,0))-sum(a.APPROVED_AMT)) >= :nd_auth_amt
			order by b.blng_grp_id,(sum(NVL(b.tot_billed_amt,0)+NVL(b.tot_unbld_amt,0))-sum(a.APPROVED_AMT)); */ 



     /* EXEC SQL DECLARE B_EXP_OP_CUR CURSOR FOR
	        select b.blng_grp_id,    
            a.patient_id,
			b.cust_code,
			null,--a.bed_type, sen removed from group by also
			null,--a.proc_code,
			c.episode_id,
			c.visit_id,
			to_char(c.visit_regn_date_time, 'dd/mm/yyyy hh24:mi'),
			sum (NVL(b.tot_billed_amt,0)+NVL(b.tot_unbld_amt,0)) Current_bill_amount,
            sum(NVL(a.APPROVED_AMT,0)) Authorized_amount,
            sum(NVL(a.APPROVED_DAYS,0))   Authorized_days,
			substr(a.ADDED_BY_ID,1,15),
            1 length_of_stay,
			c.clinic_code
			,b.encounter_id
            from  --bl_credit_authorization a, sen
			    bl_encounter_payer_priority a, 
                bl_visit_fin_dtls b,
	            op_visit c,
                bl_blng_grp d
            where a.OPERATING_FACILITY_ID=b.OPERATING_FACILITY_ID
			and   a.OPERATING_FACILITY_ID=c.FACILITY_ID
			and   a.OPERATING_FACILITY_ID=:nd_facility_id
			and   a.episode_type=b.episode_type
			and   a.episode_type=c.episode_type 
		    and   a.episode_type in ('O','E')
            and   a.episode_type=:nd_episode_type 
			and   a.patient_id=b.patient_id
			and   a.patient_id=c.patient_id
			and   a.episode_id=b.episode_id
			and   a.episode_id=c.episode_id
			and   a.visit_id  =b.visit_id
		    and   a.visit_id  =c.visit_id
          	and   nvl(c.visit_status,'0') != '9'
			and   b.blng_grp_id =a.blng_grp_id
            and   b.blng_grp_id=d.blng_grp_id
			and   d.settlement_ind='X' and d.adm_rec_flag=2 
			and b.blng_grp_id between 
				    nvl(:nd_fm_blng_grp_id,'!!!!') and nvl(:nd_to_blng_grp_id,'~~~~')
			and b.patient_id between
					nvl(:nd_fm_patient_id,'!!!!!!!!!!!!!!!!!!!!') and nvl(:nd_to_patient_id,'~~~~~~~~~~~~~~~~~~~~')
			and b.cust_code between
					nvl(:nd_fm_cust_code,'!!!!!!!!') and nvl(:nd_to_cust_code,'~~~~~~~~')
			and c.clinic_code between
					nvl(:nd_fm_clinic_code,'!!!!') and nvl(:nd_to_clinic_code,'~~~~')
			and trunc(c.visit_regn_date_time) between
			trunc(to_date(nvl(:nd_fm_visit_date,'1/1/1000'),'dd/mm/yyyy')) and 
					trunc(to_date(nvl(:nd_to_visit_date,'1/1/4712'),'dd/mm/yyyy')) 
            group by	a.patient_id,c.clinic_code,c.episode_id,c.visit_id,b.blng_grp_id,			
						b.cust_code, to_char(c.visit_regn_date_time, 'dd/mm/yyyy hh24:mi')			
						,substr(a.ADDED_BY_ID,1,15),b.encounter_id--, a.proc_code
			--having sum(a.APPROVED_AMT)-(sum(NVL(b.tot_billed_amt,0)+NVL(b.tot_unbld_amt,0))) > 0
            order by b.blng_grp_id,(sum(a.APPROVED_AMT) - sum(NVL(b.tot_billed_amt,0)+NVL(b.tot_unbld_amt,0))) desc; */ 





     /* EXEC SQL DECLARE C_EXP_OP_CUR CURSOR FOR
	        select b.blng_grp_id,    
            c.patient_id,
			b.cust_code,
			c.episode_id,
			c.visit_id,
			to_char(c.visit_regn_date_time, 'dd/mm/yyyy hh24:mi'),
			sum (NVL(b.tot_billed_amt,0)+NVL(b.tot_unbld_amt,0)) Current_bill_amount,
            1 length_of_stay
			,b.encounter_id
            from bl_visit_fin_dtls b,
	        op_visit c
            where b.episode_id=c.episode_id
			and   b.visit_id = c.visit_id
			and   b.episode_type=c.episode_type
			and   b.OPERATING_FACILITY_ID=c.FACILITY_ID
			and   b.OPERATING_FACILITY_ID=:nd_facility_id
			and   nvl(c.visit_status,'0') != '9'
			and   b.episode_type=:nd_episode_type --sen
            and b.blng_grp_id between 
				    nvl(:nd_fm_blng_grp_id,'!!!!') and nvl(:nd_to_blng_grp_id,'~~~~')
			and b.patient_id between
					nvl(:nd_fm_patient_id,'!!!!!!!!!!!!!!!!!!!!') and nvl(:nd_to_patient_id,'~~~~~~~~~~~~~~~~~~~~')
			and b.cust_code between
					nvl(:nd_fm_cust_code,'!!!!!!!!') and nvl(:nd_to_cust_code,'~~~~~~~~')
			and trunc(c.visit_regn_date_time) between
				trunc(to_date(nvl(:nd_fm_visit_date,'1/1/1000'),'dd/mm/yyyy')) and 
					trunc(to_date(nvl(:nd_to_visit_date,'1/1/4712'),'dd/mm/yyyy'))
			and b.patient_id not in(select patient_id from bl_encounter_payer_priority)
            group by	c.patient_id,c.episode_id,c.visit_id,b.blng_grp_id,			
						b.cust_code,to_char(c.visit_regn_date_time, 'dd/mm/yyyy hh24:mi')
						,b.encounter_id 
			order by 1; */ 



}



open_bl_exp_cur()
{
    if(nd_episode_type == 'I' || nd_episode_type=='D') 
	{
			if(nd_inc_disc_pat == 'Y') 
		{
				//EXEC SQL OPEN E_EXP_IP_CUR;
		//if (OERROR)
         //err_mesg("OPEN failed on cursor E_EXP_IP_CUR",0,"");

		/* EXEC SQL OPEN B_EXP_IP_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 24;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlbuft((void **)0,
    "select b.blng_grp_id ,a.patient_id ,b.cust_code ,b.BED_BILL_BED_TYPE_CO\
DE ,null  ,c.episode_id ,0 visit_id ,to_char(c.admission_date_time,'dd/mm/yy\
yy hh24:mi') ,sum((NVL(b.tot_billed_amt,0)+NVL(b.tot_unbld_amt,0))) Current_\
bill_amount ,sum(NVL(a.APPROVED_AMT,0)) Authorized_amount ,sum(NVL(a.APPROVE\
D_DAYS,0)) Authorized_days ,substr(a.ADDED_BY_ID,1,15) ,ROUND((nvl(b.dischar\
ge_date_time,sysdate)-b.admission_date_time)) length_of_stay ,c.cur_ward_cod\
e ,b.encounter_id  from bl_encounter_payer_priority a ,bl_episode_fin_dtls b\
 ,ip_episode c ,bl_blng_grp d where ((((((((((((((((((((a.OPERATING_FACILITY\
_ID=b.OPERATING_FACILITY_ID and a.OPERATING_FACILITY_ID=c.FACILITY_ID) and a\
.OPERATING_FACILITY_ID=:b0) and a.episode_type=b.episode_type) and a.episode\
_type=c.episode_type) and a.episode_type in ('I','D')) and a.episode_type=:b\
1) and a.patient_id=b.patient_id) and a.patient_id=c.patient_id) and a.episo\
de_id=b.episode_id) and a.episode_id=c.episode_id) and nvl(c.episode_status,\
'0')<>'9') and b.blng_grp_id=a.blng_grp_i");
  sqlstm.stmt = sq0006;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )181;
  sqlstm.selerr = (unsigned short)1;
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
  sqlstm.sqhstv[1] = (         void  *)&nd_episode_type;
  sqlstm.sqhstl[1] = (unsigned int  )1;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_fm_blng_grp_id;
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
  sqlstm.sqhstv[4] = (         void  *)&nd_fm_patient_id;
  sqlstm.sqhstl[4] = (unsigned int  )23;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_to_patient_id;
  sqlstm.sqhstl[5] = (unsigned int  )23;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_fm_cust_code;
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
  sqlstm.sqhstv[8] = (         void  *)&nd_fm_ward_code;
  sqlstm.sqhstl[8] = (unsigned int  )7;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&nd_to_ward_code;
  sqlstm.sqhstl[9] = (unsigned int  )7;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&nd_fm_adm_date;
  sqlstm.sqhstl[10] = (unsigned int  )13;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&nd_to_adm_date;
  sqlstm.sqhstl[11] = (unsigned int  )13;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
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
         err_mesg("OPEN failed on cursor B_EXP_IP_CUR",0,"");

		//EXEC SQL OPEN C_EXP_IP_CUR;
		//if (OERROR)
         //err_mesg("OPEN failed on cursor C_EXP_IP_CUR",0,"");
		}
		else
		{
		//EXEC SQL OPEN E1_EXP_IP_CUR;
		//if (OERROR)
         //err_mesg("OPEN failed on cursor E1_EXP_IP_CUR",0,"");

		/* EXEC SQL OPEN B1_EXP_IP_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 24;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlbuft((void **)0,
    "select b.blng_grp_id ,a.patient_id ,b.cust_code ,b.BED_BILL_BED_TYPE_CO\
DE ,null  ,c.open_episode_id ,0 visit_id ,to_char(c.admission_date_time,'dd/\
mm/yyyy hh24:mi') ,sum((NVL(b.tot_billed_amt,0)+NVL(b.tot_unbld_amt,0))) Cur\
rent_bill_amount ,sum(NVL(a.APPROVED_AMT,0)) Authorized_amount ,sum(NVL(a.AP\
PROVED_DAYS,0)) Authorized_days ,substr(a.ADDED_BY_ID,1,15) ,ROUND((sysdate-\
b.admission_date_time)) length_of_stay ,d.cur_ward_code ,b.encounter_id  fro\
m bl_encounter_payer_priority a ,bl_episode_fin_dtls b ,ip_open_episode c ,i\
p_episode d ,bl_blng_grp e where (((((((((((((((((((((((a.OPERATING_FACILITY\
_ID=b.OPERATING_FACILITY_ID and a.OPERATING_FACILITY_ID=c.FACILITY_ID) and a\
.OPERATING_FACILITY_ID=d.FACILITY_ID) and a.OPERATING_FACILITY_ID=:b0) and a\
.episode_type=b.episode_type) and a.episode_type=c.episode_type) and a.episo\
de_type=d.episode_type) and a.episode_type=:b1) and a.episode_type in ('I','\
D')) and a.patient_id=b.patient_id) and a.patient_id=c.patient_id) and a.pat\
ient_id=d.patient_id) and a.episode_id=b.");
  sqlstm.stmt = sq0009;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )244;
  sqlstm.selerr = (unsigned short)1;
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
  sqlstm.sqhstv[1] = (         void  *)&nd_episode_type;
  sqlstm.sqhstl[1] = (unsigned int  )1;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_fm_blng_grp_id;
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
  sqlstm.sqhstv[4] = (         void  *)&nd_fm_patient_id;
  sqlstm.sqhstl[4] = (unsigned int  )23;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_to_patient_id;
  sqlstm.sqhstl[5] = (unsigned int  )23;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_fm_cust_code;
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
  sqlstm.sqhstv[8] = (         void  *)&nd_fm_ward_code;
  sqlstm.sqhstl[8] = (unsigned int  )7;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&nd_to_ward_code;
  sqlstm.sqhstl[9] = (unsigned int  )7;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&nd_fm_adm_date;
  sqlstm.sqhstl[10] = (unsigned int  )13;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&nd_to_adm_date;
  sqlstm.sqhstl[11] = (unsigned int  )13;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
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
         err_mesg("OPEN failed on cursor B1_EXP_IP_CUR",0,"");

		//EXEC SQL OPEN C1_EXP_IP_CUR;
		//if (OERROR)
         //err_mesg("OPEN failed on cursor C1_EXP_IP_CUR",0,"");
		}
	}
	else
	{
		//EXEC SQL OPEN E_EXP_OP_CUR;
		//if (OERROR)
         //err_mesg("OPEN failed on cursor E_EXP_OP_CUR",0,"");

		/* EXEC SQL OPEN B_EXP_OP_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 24;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlbuft((void **)0,
    "select b.blng_grp_id ,a.patient_id ,b.cust_code ,null  ,null  ,c.episod\
e_id ,c.visit_id ,to_char(c.visit_regn_date_time,'dd/mm/yyyy hh24:mi') ,sum(\
(NVL(b.tot_billed_amt,0)+NVL(b.tot_unbld_amt,0))) Current_bill_amount ,sum(N\
VL(a.APPROVED_AMT,0)) Authorized_amount ,sum(NVL(a.APPROVED_DAYS,0)) Authori\
zed_days ,substr(a.ADDED_BY_ID,1,15) ,1 length_of_stay ,c.clinic_code ,b.enc\
ounter_id  from bl_encounter_payer_priority a ,bl_visit_fin_dtls b ,op_visit\
 c ,bl_blng_grp d where ((((((((((((((((((((((a.OPERATING_FACILITY_ID=b.OPER\
ATING_FACILITY_ID and a.OPERATING_FACILITY_ID=c.FACILITY_ID) and a.OPERATING\
_FACILITY_ID=:b0) and a.episode_type=b.episode_type) and a.episode_type=c.ep\
isode_type) and a.episode_type in ('O','E')) and a.episode_type=:b1) and a.p\
atient_id=b.patient_id) and a.patient_id=c.patient_id) and a.episode_id=b.ep\
isode_id) and a.episode_id=c.episode_id) and a.visit_id=b.visit_id) and a.vi\
sit_id=c.visit_id) and nvl(c.visit_status,'0')<>'9') and b.blng_grp_id=a.bln\
g_grp_id) and b.blng_grp_id=d.blng_grp_id");
  sqlstm.stmt = sq0012;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )307;
  sqlstm.selerr = (unsigned short)1;
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
  sqlstm.sqhstv[1] = (         void  *)&nd_episode_type;
  sqlstm.sqhstl[1] = (unsigned int  )1;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_fm_blng_grp_id;
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
  sqlstm.sqhstv[4] = (         void  *)&nd_fm_patient_id;
  sqlstm.sqhstl[4] = (unsigned int  )23;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_to_patient_id;
  sqlstm.sqhstl[5] = (unsigned int  )23;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_fm_cust_code;
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
  sqlstm.sqhstv[8] = (         void  *)&nd_fm_clinic_code;
  sqlstm.sqhstl[8] = (unsigned int  )7;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&nd_to_clinic_code;
  sqlstm.sqhstl[9] = (unsigned int  )7;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&nd_fm_visit_date;
  sqlstm.sqhstl[10] = (unsigned int  )13;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&nd_to_visit_date;
  sqlstm.sqhstl[11] = (unsigned int  )13;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
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
         err_mesg("OPEN failed on cursor B_EXP_OP_CUR",0,"");

		//EXEC SQL OPEN C_EXP_OP_CUR;
		//if (OERROR)
         //err_mesg("OPEN failed on cursor C_EXP_OP_CUR",0,"");
	
    }
}

close_bl_exp_cur()
{
   if(nd_episode_type == 'I' || nd_episode_type == 'D')
    {
		if (nd_inc_disc_pat == 'Y')
		{	
		//EXEC SQL CLOSE E_EXP_IP_CUR;
		/* EXEC SQL CLOSE B_EXP_IP_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 24;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )370;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		//EXEC SQL CLOSE C_EXP_IP_CUR;
		}
		else
		{
		//EXEC SQL CLOSE E1_EXP_IP_CUR;
		/* EXEC SQL CLOSE B1_EXP_IP_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 24;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )385;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		//EXEC SQL CLOSE C1_EXP_IP_CUR;
		}
	}
	else
	{
		//EXEC SQL CLOSE E_EXP_OP_CUR;
		/* EXEC SQL CLOSE B_EXP_OP_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 24;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )400;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		//EXEC SQL CLOSE C_EXP_OP_CUR;
	}   
}


fetch_e_exp_dtls()
{    
    nd_patient_id.arr[0]    = '\0';
    d_cust_code.arr[0]		= '\0';
	d_bed_type.arr[0]		= '\0';
	d_proc_code.arr[0]		= '\0';
	d_adm_date.arr[0]		= '\0';
	d_auth_by.arr[0]		= '\0';
	nd_episode_id.arr[0]    = '\0';
	nd_visit_id.arr[0]		= '\0';
	nd_blng_grp_id.arr[0]   = '\0';
	nd_ward_code.arr[0]     = '\0';
	nd_encounter_id.arr[0]     = '\0';
	nd_authorized_days.arr[0] = '\0';
  
    nd_patient_id.len       = 0;
    d_cust_code.len			= 0;
    d_bed_type.len			= 0;
    d_proc_code.len			= 0;
    d_adm_date.len			= 0;
    d_auth_by.len			= 0;
    nd_episode_id.len		= 0;
	nd_visit_id.len			= 0;
	nd_blng_grp_id.len		= 0;
	nd_authorized_days.len  = 0;
	nd_ward_code.len		= 0;
	nd_encounter_id.len	    = 0;

   if (nd_episode_type == 'I' || nd_episode_type == 'D') 
   {	  
   if (nd_inc_disc_pat == 'Y')
   {
   /* EXEC SQL FETCH E_EXP_IP_CUR
             INTO :nd_blng_grp_id,
			      :nd_patient_id,
				  :d_cust_code,
				  :d_bed_type,
				  :d_proc_code,
				  :nd_episode_id,
				  :nd_visit_id,
				  :d_adm_date,
				  :nd_current_bill_amount,
			      :nd_authorized_amount,
				  :nd_authorized_days,
				  :d_auth_by,
				  :nd_length_of_stay,
				  :nd_ward_code,
				  :nd_encounter_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )415;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_blng_grp_id;
   sqlstm.sqhstl[0] = (unsigned int  )7;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_patient_id;
   sqlstm.sqhstl[1] = (unsigned int  )23;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_cust_code;
   sqlstm.sqhstl[2] = (unsigned int  )11;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_bed_type;
   sqlstm.sqhstl[3] = (unsigned int  )5;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_proc_code;
   sqlstm.sqhstl[4] = (unsigned int  )13;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_episode_id;
   sqlstm.sqhstl[5] = (unsigned int  )11;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_visit_id;
   sqlstm.sqhstl[6] = (unsigned int  )7;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&d_adm_date;
   sqlstm.sqhstl[7] = (unsigned int  )21;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_current_bill_amount;
   sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_authorized_amount;
   sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_authorized_days;
   sqlstm.sqhstl[10] = (unsigned int  )8;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&d_auth_by;
   sqlstm.sqhstl[11] = (unsigned int  )23;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&nd_length_of_stay;
   sqlstm.sqhstl[12] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&nd_ward_code;
   sqlstm.sqhstl[13] = (unsigned int  )7;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&nd_encounter_id;
   sqlstm.sqhstl[14] = (unsigned int  )15;
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
}


  }
  else
  /* EXEC SQL FETCH E1_EXP_IP_CUR
             INTO :nd_blng_grp_id,
			      :nd_patient_id,
				  :d_cust_code,
				  :d_bed_type,
				  :d_proc_code,
				  :nd_episode_id,
				  :nd_visit_id,
				  :d_adm_date,
				  :nd_current_bill_amount,
			      :nd_authorized_amount,
				  :nd_authorized_days,
				  :d_auth_by,
				  :nd_length_of_stay,
				  :nd_ward_code,
				  :nd_encounter_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 24;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )490;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_blng_grp_id;
  sqlstm.sqhstl[0] = (unsigned int  )7;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_patient_id;
  sqlstm.sqhstl[1] = (unsigned int  )23;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_cust_code;
  sqlstm.sqhstl[2] = (unsigned int  )11;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_bed_type;
  sqlstm.sqhstl[3] = (unsigned int  )5;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_proc_code;
  sqlstm.sqhstl[4] = (unsigned int  )13;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_episode_id;
  sqlstm.sqhstl[5] = (unsigned int  )11;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_visit_id;
  sqlstm.sqhstl[6] = (unsigned int  )7;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&d_adm_date;
  sqlstm.sqhstl[7] = (unsigned int  )21;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&nd_current_bill_amount;
  sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&nd_authorized_amount;
  sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&nd_authorized_days;
  sqlstm.sqhstl[10] = (unsigned int  )8;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&d_auth_by;
  sqlstm.sqhstl[11] = (unsigned int  )23;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&nd_length_of_stay;
  sqlstm.sqhstl[12] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&nd_ward_code;
  sqlstm.sqhstl[13] = (unsigned int  )7;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&nd_encounter_id;
  sqlstm.sqhstl[14] = (unsigned int  )15;
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
}


  }
  else
  {
   /* EXEC SQL FETCH E_EXP_OP_CUR
             INTO :nd_blng_grp_id,
			      :nd_patient_id,
				  :d_cust_code,
				  :d_bed_type,
				  :d_proc_code,
				  :nd_episode_id,
				  :nd_visit_id,
				  :d_adm_date,
				  :nd_current_bill_amount,
			      :nd_authorized_amount,
				  :nd_authorized_days,
				  :d_auth_by,
				  :nd_length_of_stay,
				  :nd_ward_code,
				  :nd_encounter_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )565;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_blng_grp_id;
   sqlstm.sqhstl[0] = (unsigned int  )7;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_patient_id;
   sqlstm.sqhstl[1] = (unsigned int  )23;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_cust_code;
   sqlstm.sqhstl[2] = (unsigned int  )11;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_bed_type;
   sqlstm.sqhstl[3] = (unsigned int  )5;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_proc_code;
   sqlstm.sqhstl[4] = (unsigned int  )13;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_episode_id;
   sqlstm.sqhstl[5] = (unsigned int  )11;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_visit_id;
   sqlstm.sqhstl[6] = (unsigned int  )7;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&d_adm_date;
   sqlstm.sqhstl[7] = (unsigned int  )21;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_current_bill_amount;
   sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_authorized_amount;
   sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_authorized_days;
   sqlstm.sqhstl[10] = (unsigned int  )8;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&d_auth_by;
   sqlstm.sqhstl[11] = (unsigned int  )23;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&nd_length_of_stay;
   sqlstm.sqhstl[12] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&nd_ward_code;
   sqlstm.sqhstl[13] = (unsigned int  )7;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&nd_encounter_id;
   sqlstm.sqhstl[14] = (unsigned int  )15;
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
}


  }
   get_patient_name();
  

    if (LAST_ROW)
         return 0;
    
    nd_patient_id.arr[nd_patient_id.len]        = '\0';
    d_cust_code.arr[d_cust_code.len]			= '\0';
	d_bed_type.arr[d_bed_type.len]				= '\0';
	d_proc_code.arr[d_proc_code.len]			= '\0';
	d_adm_date.arr[d_adm_date.len]				= '\0';
	d_auth_by.arr[d_auth_by.len]				= '\0';
	nd_episode_id.arr[nd_episode_id.len]        = '\0';
	nd_visit_id.arr[nd_visit_id.len]	        = '\0';
	nd_blng_grp_id.arr[nd_blng_grp_id.len]		= '\0';
	nd_authorized_days.arr[nd_authorized_days.len] = '\0';
	nd_ward_code.arr[nd_ward_code.len]			= '\0';
//	nd_encounter_id.arr[nd_encounter_id.len]			= '\0';

     get_proc_code(); 
	 
	return 1;
    
}

fetch_b_exp_dtls()
{    
    nd_patient_id.arr[0]		= '\0';
    d_cust_code.arr[0]			= '\0';
	d_bed_type.arr[0]			= '\0';
	d_proc_code.arr[0]			= '\0';
	d_adm_date.arr[0]			= '\0';
	d_auth_by.arr[0]			= '\0';
	nd_episode_id.arr[0]		= '\0';
	nd_visit_id.arr[0]			= '\0';
	nd_blng_grp_id.arr[0]		= '\0';
	nd_ward_code.arr[0]			= '\0';
	nd_encounter_id.arr[0]			= '\0';
	nd_authorized_days.arr[0]   = '\0';
   


    nd_patient_id.len       = 0;
    d_cust_code.len			= 0;
    d_bed_type.len			= 0;
    d_proc_code.len			= 0;
    d_adm_date.len			= 0;
    d_auth_by.len			= 0;
    nd_episode_id.len		= 0;
	nd_visit_id.len			= 0;
	nd_blng_grp_id.len		= 0;
	nd_authorized_days.len  = 0;
	nd_ward_code.len		= 0;
	nd_encounter_id.len		= 0;
  
   if(nd_episode_type == 'I' || nd_episode_type == 'D')
   {
   if(nd_inc_disc_pat == 'Y')
   /* EXEC SQL FETCH B_EXP_IP_CUR
             INTO :nd_blng_grp_id,
			      :nd_patient_id,
				  :d_cust_code,
				  :d_bed_type,
				  :d_proc_code,
				  :nd_episode_id,
				  :nd_visit_id,
				  :d_adm_date,
				  :nd_current_bill_amount,
			      :nd_authorized_amount,
				  :nd_authorized_days,
				  :d_auth_by,
				  :nd_length_of_stay,
				  :nd_ward_code,
				  :nd_encounter_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )640;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_blng_grp_id;
   sqlstm.sqhstl[0] = (unsigned int  )7;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_patient_id;
   sqlstm.sqhstl[1] = (unsigned int  )23;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_cust_code;
   sqlstm.sqhstl[2] = (unsigned int  )11;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_bed_type;
   sqlstm.sqhstl[3] = (unsigned int  )5;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_proc_code;
   sqlstm.sqhstl[4] = (unsigned int  )13;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_episode_id;
   sqlstm.sqhstl[5] = (unsigned int  )11;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_visit_id;
   sqlstm.sqhstl[6] = (unsigned int  )7;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&d_adm_date;
   sqlstm.sqhstl[7] = (unsigned int  )21;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_current_bill_amount;
   sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_authorized_amount;
   sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_authorized_days;
   sqlstm.sqhstl[10] = (unsigned int  )8;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&d_auth_by;
   sqlstm.sqhstl[11] = (unsigned int  )23;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&nd_length_of_stay;
   sqlstm.sqhstl[12] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&nd_ward_code;
   sqlstm.sqhstl[13] = (unsigned int  )7;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&nd_encounter_id;
   sqlstm.sqhstl[14] = (unsigned int  )15;
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
}


	else
	/* EXEC SQL FETCH B1_EXP_IP_CUR
             INTO :nd_blng_grp_id,
			      :nd_patient_id,
				  :d_cust_code,
				  :d_bed_type,
				  :d_proc_code,
				  :nd_episode_id,
				  :nd_visit_id,
				  :d_adm_date,
				  :nd_current_bill_amount,
			      :nd_authorized_amount,
				  :nd_authorized_days,
				  :d_auth_by,
				  :nd_length_of_stay,
				  :nd_ward_code,
				  :nd_encounter_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 24;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )715;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_blng_grp_id;
 sqlstm.sqhstl[0] = (unsigned int  )7;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_patient_id;
 sqlstm.sqhstl[1] = (unsigned int  )23;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_cust_code;
 sqlstm.sqhstl[2] = (unsigned int  )11;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_bed_type;
 sqlstm.sqhstl[3] = (unsigned int  )5;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_proc_code;
 sqlstm.sqhstl[4] = (unsigned int  )13;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_episode_id;
 sqlstm.sqhstl[5] = (unsigned int  )11;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&nd_visit_id;
 sqlstm.sqhstl[6] = (unsigned int  )7;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&d_adm_date;
 sqlstm.sqhstl[7] = (unsigned int  )21;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&nd_current_bill_amount;
 sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&nd_authorized_amount;
 sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&nd_authorized_days;
 sqlstm.sqhstl[10] = (unsigned int  )8;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&d_auth_by;
 sqlstm.sqhstl[11] = (unsigned int  )23;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&nd_length_of_stay;
 sqlstm.sqhstl[12] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&nd_ward_code;
 sqlstm.sqhstl[13] = (unsigned int  )7;
 sqlstm.sqhsts[13] = (         int  )0;
 sqlstm.sqindv[13] = (         void  *)0;
 sqlstm.sqinds[13] = (         int  )0;
 sqlstm.sqharm[13] = (unsigned int  )0;
 sqlstm.sqadto[13] = (unsigned short )0;
 sqlstm.sqtdso[13] = (unsigned short )0;
 sqlstm.sqhstv[14] = (         void  *)&nd_encounter_id;
 sqlstm.sqhstl[14] = (unsigned int  )15;
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
}


	}
	else
	{
	/* EXEC SQL FETCH B_EXP_OP_CUR
             INTO :nd_blng_grp_id,
			      :nd_patient_id,
				  :d_cust_code,
				  :d_bed_type,
				  :d_proc_code,
				  :nd_episode_id,
				  :nd_visit_id,
				  :d_adm_date,
				  :nd_current_bill_amount,
			      :nd_authorized_amount,
				  :nd_authorized_days,
				  :d_auth_by,
				  :nd_length_of_stay,
				  :nd_ward_code,
				  :nd_encounter_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 24;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )790;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_blng_grp_id;
 sqlstm.sqhstl[0] = (unsigned int  )7;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_patient_id;
 sqlstm.sqhstl[1] = (unsigned int  )23;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_cust_code;
 sqlstm.sqhstl[2] = (unsigned int  )11;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_bed_type;
 sqlstm.sqhstl[3] = (unsigned int  )5;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_proc_code;
 sqlstm.sqhstl[4] = (unsigned int  )13;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_episode_id;
 sqlstm.sqhstl[5] = (unsigned int  )11;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&nd_visit_id;
 sqlstm.sqhstl[6] = (unsigned int  )7;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&d_adm_date;
 sqlstm.sqhstl[7] = (unsigned int  )21;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&nd_current_bill_amount;
 sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&nd_authorized_amount;
 sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&nd_authorized_days;
 sqlstm.sqhstl[10] = (unsigned int  )8;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&d_auth_by;
 sqlstm.sqhstl[11] = (unsigned int  )23;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&nd_length_of_stay;
 sqlstm.sqhstl[12] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&nd_ward_code;
 sqlstm.sqhstl[13] = (unsigned int  )7;
 sqlstm.sqhsts[13] = (         int  )0;
 sqlstm.sqindv[13] = (         void  *)0;
 sqlstm.sqinds[13] = (         int  )0;
 sqlstm.sqharm[13] = (unsigned int  )0;
 sqlstm.sqadto[13] = (unsigned short )0;
 sqlstm.sqtdso[13] = (unsigned short )0;
 sqlstm.sqhstv[14] = (         void  *)&nd_encounter_id;
 sqlstm.sqhstl[14] = (unsigned int  )15;
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
}


	}

   get_patient_name();
   

    if (LAST_ROW)
         return 0;
    
    nd_patient_id.arr[nd_patient_id.len]		= '\0';
    d_cust_code.arr[d_cust_code.len]			= '\0';
	d_bed_type.arr[d_bed_type.len]				= '\0';
	d_proc_code.arr[d_proc_code.len]			= '\0';
	d_adm_date.arr[d_adm_date.len]				= '\0';
	d_auth_by.arr[d_auth_by.len]				= '\0';
	nd_episode_id.arr[nd_episode_id.len]        = '\0';
	nd_visit_id.arr[nd_visit_id.len]			= '\0';
	nd_blng_grp_id.arr[nd_blng_grp_id.len]		= '\0';
	nd_authorized_days.arr[nd_authorized_days.len] = '\0';
	nd_ward_code.arr[nd_ward_code.len]			= '\0';
//	nd_encounter_id.arr[nd_encounter_id.len]			= '\0';
    
	get_proc_code();

	return 1;
    
}

fetch_c_exp_dtls()
{    
    nd_patient_id.arr[0]  = '\0';
    d_cust_code.arr[0]    = '\0';
	d_adm_date.arr[0]     = '\0';
	nd_episode_id.arr[0]  = '\0';
	nd_visit_id.arr[0]	  = '\0';
	nd_blng_grp_id.arr[0] = '\0';
   

    nd_patient_id.len     = 0;
    d_cust_code.len       = 0;
    d_adm_date.len        = 0;
    nd_episode_id.len     = 0;
	nd_visit_id.len		  = 0;
	nd_blng_grp_id.len    = 0;
    
   if(nd_episode_type == 'I' || nd_episode_type == 'D')
   {
   if(nd_inc_disc_pat == 'Y')
   /* EXEC SQL FETCH C_EXP_IP_CUR
             INTO :nd_blng_grp_id,
			      :nd_patient_id,
				  :d_cust_code,
				  :nd_episode_id,
				  :nd_visit_id,
				  :d_adm_date,
				  :nd_current_bill_amount,
			      :nd_length_of_stay,
				  :nd_encounter_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )865;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_blng_grp_id;
   sqlstm.sqhstl[0] = (unsigned int  )7;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_patient_id;
   sqlstm.sqhstl[1] = (unsigned int  )23;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_cust_code;
   sqlstm.sqhstl[2] = (unsigned int  )11;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_episode_id;
   sqlstm.sqhstl[3] = (unsigned int  )11;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_visit_id;
   sqlstm.sqhstl[4] = (unsigned int  )7;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_adm_date;
   sqlstm.sqhstl[5] = (unsigned int  )21;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_current_bill_amount;
   sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_length_of_stay;
   sqlstm.sqhstl[7] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_encounter_id;
   sqlstm.sqhstl[8] = (unsigned int  )15;
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


   else
   /* EXEC SQL FETCH C1_EXP_IP_CUR
             INTO :nd_blng_grp_id,
			      :nd_patient_id,
				  :d_cust_code,
				  :nd_episode_id,
				  :nd_visit_id,
				  :d_adm_date,
				  :nd_current_bill_amount,
			      :nd_length_of_stay,
				  :nd_encounter_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )916;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_blng_grp_id;
   sqlstm.sqhstl[0] = (unsigned int  )7;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_patient_id;
   sqlstm.sqhstl[1] = (unsigned int  )23;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_cust_code;
   sqlstm.sqhstl[2] = (unsigned int  )11;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_episode_id;
   sqlstm.sqhstl[3] = (unsigned int  )11;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_visit_id;
   sqlstm.sqhstl[4] = (unsigned int  )7;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_adm_date;
   sqlstm.sqhstl[5] = (unsigned int  )21;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_current_bill_amount;
   sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_length_of_stay;
   sqlstm.sqhstl[7] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_encounter_id;
   sqlstm.sqhstl[8] = (unsigned int  )15;
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


   	}
	else
	{
   /* EXEC SQL FETCH C_EXP_OP_CUR
             INTO :nd_blng_grp_id,
			      :nd_patient_id,
				  :d_cust_code,
				  :nd_episode_id,
				  :nd_visit_id,
				  :d_adm_date,
				  :nd_current_bill_amount,
			      :nd_length_of_stay,
				  :nd_encounter_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )967;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_blng_grp_id;
   sqlstm.sqhstl[0] = (unsigned int  )7;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_patient_id;
   sqlstm.sqhstl[1] = (unsigned int  )23;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_cust_code;
   sqlstm.sqhstl[2] = (unsigned int  )11;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_episode_id;
   sqlstm.sqhstl[3] = (unsigned int  )11;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_visit_id;
   sqlstm.sqhstl[4] = (unsigned int  )7;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_adm_date;
   sqlstm.sqhstl[5] = (unsigned int  )21;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_current_bill_amount;
   sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_length_of_stay;
   sqlstm.sqhstl[7] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_encounter_id;
   sqlstm.sqhstl[8] = (unsigned int  )15;
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


   	}		      
   get_patient_name();
   

    if (LAST_ROW)
         return 0;
    
    nd_patient_id.arr[nd_patient_id.len]   = '\0';
    d_cust_code.arr[d_cust_code.len]       = '\0';
	d_adm_date.arr[d_adm_date.len]         = '\0';
	nd_episode_id.arr[nd_episode_id.len]   = '\0';
	nd_visit_id.arr[nd_visit_id.len]   = '\0';
	nd_blng_grp_id.arr[nd_blng_grp_id.len] = '\0';
	get_proc_code();
	return 1;
    
}

process()
{
  if(nd_rep_option == 'C' )
  {
  
  while(fetch_c_exp_dtls())
    {
	   if(c_hd_fl)
       print_c_head();     
	   
	   if (d_lctr > 55)
		  print_head();
	   
	   if(strcmp(t_blng_grp_id.arr,nd_blng_grp_id.arr))
	      print_blng_grp();
		     
	   print_rec_n();
	   d_lctr++; 
	   c_hd_fl=0;
	   nblng_ctr++;
	   ngblng_ctr++;
	} 
  }
   if (nblng_ctr)
     {
	    if (d_lctr > 55)
          {
		  print_head();
		  print_blng_grp();
		  }

     //fprintf(f2,"                  Total No. of Patients : %-5d\n",nblng_ctr);
	 fprintf(f2,"                  %s : %-5d\n",loc_legend[117],nblng_ctr);
     nblng_ctr = 0;
	 d_lctr++;
	 }

  if(nd_rep_option == 'E' )// || nd_rep_option == 'A')
  {
  
  while(fetch_e_exp_dtls())
    {
  	     if(e_hd_fl)
		    {
            if(nd_rep_option == 'A')
                print_head();
             print_e_head(); 
			 }
            
	   if (d_lctr > 55)
		  print_head();
	   
	        
	   if(strcmp(t_blng_grp_id.arr,nd_blng_grp_id.arr))
	     {
	      print_blng_grp();   
		  }
	   print_rec();

	   d_lctr++; 
	   e_hd_fl = 0;
	   nblng_ctr++;
	   ngblng_ctr++;
	} 
  }
   if (nblng_ctr)
     {
	   if (d_lctr > 55)
          {
		  print_head();
		  print_blng_grp();
		  }

     //fprintf(f2,"                  Total No. of Patients : %-5d\n",nblng_ctr);
	 fprintf(f2,"                  %s : %-5d\n",loc_legend[117],nblng_ctr);
     nblng_ctr = 0;
	 d_lctr++;
	 }


  if(nd_rep_option == 'B' || nd_rep_option == 'A')
  {
    while(fetch_b_exp_dtls())
       {  
           if(b_hd_fl)
		    {
            if(nd_rep_option == 'A')
                print_head();
             print_b_head(); 
			 }
           

	   if (d_lctr > 87)
		  print_head();
	        
	   if(strcmp(t_blng_grp_id.arr,nd_blng_grp_id.arr))
	      print_blng_grp();   
	   print_rec();
	   d_lctr++; 
       b_hd_fl = 0;
	   nblng_ctr++;
	   ngblng_ctr++;
	} 
  }
   if (nblng_ctr)
     {
     if (d_lctr > 87)
          {
		  print_head();
		  print_blng_grp();
		  }
     //fprintf(f2,"                  Total No. of Patients : %-5d\n",nblng_ctr);
	 fprintf(f2,"                  %s : %-5d\n",loc_legend[117],nblng_ctr);
     nblng_ctr = 0;
	 d_lctr++;
	 }
   if (ngblng_ctr)
     {
     if (d_lctr > 87)
          {
		  print_head();
		  print_blng_grp();
		  }
  //fprintf(f2,"            Grand Total No. of Patients : %-5d\n",ngblng_ctr);
  fprintf(f2,"            %s : %-5d\n",loc_legend[145],ngblng_ctr);
     ngblng_ctr = 0;
	 d_lctr++;
	 }
}

print_head()
{
  
     prt_head(f2,&d_pctr);
     d_lctr = 10;
  
}

prt_head(fp,pctr)
FILE *fp;
int *pctr;
{

    form_hdr(&pctr);

 /* This makes the font size to increase to 2 */
    
    fprintf(fp,"\f%s\n",hdr_line1);
    fprintf(fp,"%s\n",hdr_line2);
    fprintf(fp,"%s\n",hdr_line3);
    fprintf(fp,"%s\n",hdr_line4);

	if (nd_episode_type == 'I' || nd_episode_type == 'D')
	{

      fprintf(f2,"%-12s %-28s %-8.8s %-4.4s %-4.4s %-10.10s %-27.27s %10.10s %-32.32s %7.7s\n",
//commented by saikiran as it is printing patient id in 10chars instead of 12chars
//    fprintf(f2,"%10s %-30s %-8.8s %-4.4s %-4.4s %-10.10s %-27.27s %10.10s %-32.32s %7.7s\n",
	           loc_legend[147],
               loc_legend[140],
			   loc_legend[123],
			   loc_legend[124],
			   loc_legend[125],
               loc_legend[126],
			   loc_legend[127],
               loc_legend[128],
               loc_legend[129],
			   loc_legend[130]);
    
	fprintf(f2,"%-12s %-28s %-8.8s %-4.4s %-4.4s %-10.10s %-8.8s %-18.18s %10.10s %10.10s %5.5s %-15.15s %7.7s\n",   
//commented by saikiran as it is printing patient id in 10chars instead of 12chars
//    fprintf(f2,"%10s %-30s %-8.8s %-4.4s %-4.4s %-10.10s %-8.8s %-18.18s %10.10s %10.10s %5.5s %-15.15s %7.7s\n",
	           " ",
               " ",
			   loc_legend[131],
			   loc_legend[131],
			   loc_legend[132],
			   " ",
			   loc_legend[133],
			   loc_legend[134],
               loc_legend[135],
               loc_legend[136],
			   loc_legend[137],
			   loc_legend[138],
			   loc_legend[139]);
	}
	else
	{
	fprintf(f2,"%-12s %-28s %-8.8s %-6.6s %-10.10s %-32.32s %10.10s %-32.32s \n",	
//commented by saikiran as it is printing patient id in 10chars instead of 12chars
//	fprintf(f2,"%10s %-30s %-8.8s %-6.6s %-10.10s %-32.32s %10.10s %-32.32s \n",
	           loc_legend[147],
               loc_legend[140],
			   loc_legend[123],
			   loc_legend[141],
			   loc_legend[126],
			   loc_legend[148],
               loc_legend[128],
               loc_legend[129]);

	fprintf(f2,"%-12s %-28s %-8.8s %-6.6s %-10.10s %-12.12s %-19.19s %10.10s %10.10s %5.5s %-15.15s\n",   
//commented by saikiran as it is printing patient id in 10chars instead of 12chars    
//	fprintf(f2,"%10s %-30s %-8.8s %-6.6s %-10.10s %-12.12s %-19.19s %10.10s %10.10s %5.5s %-15.15s\n",
	           " ",
               " ",
			   loc_legend[131],
			   loc_legend[131],
			   " ",
			   loc_legend[133],
			   loc_legend[134],
               loc_legend[135],
               loc_legend[136],
			   " ",
			   loc_legend[138]);
	}
//fprintf(fp,"Patient ID Patient Name                  Admn No.      Auth    Current   Auth. Length of\n");
//fprintf(fp,"                                                       Amount  Bill Amt. Days  Stay\n");
  

fprintf(fp,"%s\n",hdr_line4);


fflush(fp);
}


print_e_head()
{
//fprintf(f2,"\nExceeding Authorized Amount\n"); 
fprintf(f2,"\n%s\n",loc_legend[001]); 
fprintf(f2,"----------------------------\n\n"); 
d_lctr+4;
}  

print_b_head()
{
//fprintf(f2,"\nBalance Authorized Amount\n"); 
fprintf(f2,"\n%s\n",loc_legend[002]); 
fprintf(f2,"----------------------------\n\n"); 
d_lctr+4;
}  

print_c_head()
{
//fprintf(f2,"\nNo Credit Authorization Details\n"); 
fprintf(f2,"\n%s\n",loc_legend[003]); 
fprintf(f2,"--------------------------------\n\n"); 
d_lctr+3;
}  


print_rec()
{
  
   if (d_lctr > 67)
   {
       print_head();
	   //if (flag = 1)
	       print_blng_grp();
   }
      
	    init_date_temp_var();                              
		strcpy(date_convert.arr,d_adm_date.arr);         
		fun_change_loc_date();
          
        nd_bill_amt=0; 

		/* EXEC SQL SELECT sum(nvl(bill_amt,0))
		INTO  :nd_bill_amt
		FROM BL_BILL_HDR
		WHERE PATIENT_ID = :nd_patient_id
		and blng_grp_id=:nd_blng_grp_id 
		and episode_id =:nd_episode_id
		and episode_type=:nd_episode_type
		and NVL(visit_id,0)=:nd_visit_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 24;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select sum(nvl(bill_amt,0)) into :b0  from BL_BILL_HDR whe\
re ((((PATIENT_ID=:b1 and blng_grp_id=:b2) and episode_id=:b3) and episode_ty\
pe=:b4) and NVL(visit_id,0)=:b5)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1018;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_bill_amt;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_patient_id;
  sqlstm.sqhstl[1] = (unsigned int  )23;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_blng_grp_id;
  sqlstm.sqhstl[2] = (unsigned int  )7;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_episode_id;
  sqlstm.sqhstl[3] = (unsigned int  )11;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_episode_type;
  sqlstm.sqhstl[4] = (unsigned int  )1;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_visit_id;
  sqlstm.sqhstl[5] = (unsigned int  )7;
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


		
		

			if (OERROR)
			{
			err_mesg("SELECT failed on table BL_BILL_AMT",0,"");
			}

    if (nd_episode_type == 'I' || nd_episode_type == 'D')
 

		fprintf(f2,"%-12.12s %-28.28s %-8.8s %-4.4s %-4.4s %-10.10s %-8.8s %-18.18s %10.2f %10.2f %5s %-15.15s %7d\n",
//  following line is commented by saikiran as it is printing patient id in 10chars instead of 12chars    
//	fprintf(f2,"%10.10s %-30.30s %-8.8s %4.4s %-4.4s %-10.10s %-8.8s %-18.18s %10.2f %10.2f %5s %-15.15s %7d\n",
	           nd_patient_id.arr,
               nd_patient_name.arr,
			   d_cust_code.arr,
			   nd_ward_code.arr,			   
			   d_bed_type.arr,
			   nd_proc_code.arr,
			   nd_episode_id.arr,
			   date_convert.arr,
               nd_bill_amt,
               nd_authorized_amount,
			   nd_authorized_days.arr,
			   d_auth_by.arr,
			   nd_length_of_stay);

	else
	
    fprintf(f2,"%-12.12s %-28.28s %-8.8s %-6.6s %-10.10s %-8.8s/%-4.4s %-18.18s %10.2f %10.2f %5s %-15.15s\n",
//  following line is commented by saikiran as it is printing patient id in 10chars instead of 12chars    	
//	fprintf(f2,"%10.10s %-30.30s %-8.8s %6.6s %-10.10s %-8.8s/%-4.4s %-18.18s %10.2f %10.2f %5s %-15.15s\n",
	           nd_patient_id.arr,
               nd_patient_name.arr,
			   d_cust_code.arr,
			   nd_ward_code.arr,
			   nd_proc_code.arr,
			   nd_episode_id.arr,
			   nd_visit_id.arr,
			   date_convert.arr,
               nd_bill_amt,
               nd_authorized_amount,
			   " ",
			   d_auth_by.arr);
	strcpy(t_blng_grp_id.arr,nd_blng_grp_id.arr);
    t_blng_grp_id.len = strlen(t_blng_grp_id.arr);

	       d_lctr++;
    }

 
print_rec_n()
{
  
   if (d_lctr > 35)
   {
       print_head();
	   //if (flag = 1)
	       print_blng_grp();
   }

    
		init_date_temp_var();                              
		strcpy(date_convert.arr,d_adm_date.arr);         
		fun_change_loc_date();

		 nd_bill_amt=0; 

		/* EXEC SQL SELECT sum(nvl(bill_amt,0))
		INTO  :nd_bill_amt
		FROM BL_BILL_HDR
		WHERE PATIENT_ID = :nd_patient_id
		and blng_grp_id=:nd_blng_grp_id 
		and episode_id =:nd_episode_id
		and episode_type=:nd_episode_type
		and NVL(visit_id,0)=:nd_visit_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 24;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select sum(nvl(bill_amt,0)) into :b0  from BL_BILL_HDR whe\
re ((((PATIENT_ID=:b1 and blng_grp_id=:b2) and episode_id=:b3) and episode_ty\
pe=:b4) and NVL(visit_id,0)=:b5)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1057;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_bill_amt;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_patient_id;
  sqlstm.sqhstl[1] = (unsigned int  )23;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_blng_grp_id;
  sqlstm.sqhstl[2] = (unsigned int  )7;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_episode_id;
  sqlstm.sqhstl[3] = (unsigned int  )11;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_episode_type;
  sqlstm.sqhstl[4] = (unsigned int  )1;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_visit_id;
  sqlstm.sqhstl[5] = (unsigned int  )7;
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



	

			if (OERROR)
			{
			err_mesg("SELECT failed on table BL_BILL_AMT",0,"");
			}

    if (nd_episode_type == 'I' || nd_episode_type == 'D')
    
	fprintf(f2,"%-12.12s %-28.28s %-8.8s %4.4s %-4.4s %-10.10s %-8.8s %-18.18s %10.2f %32s %7d\n",
//  following line is commented by saikiran as it is printing patient id in 10chars instead of 12chars    	
//  fprintf(f2,"%10.10s %-30.30s %-8.8s %4.4s %-4.4s %-10.10s %-8.8s %-18.18s %10.2f %32s %7d\n",
	           nd_patient_id.arr,
               nd_patient_name.arr,
			   d_cust_code.arr,
			   nd_ward_code.arr,			   
			   d_bed_type.arr,
			   nd_proc_code.arr,
			   nd_episode_id.arr,			
			   date_convert.arr,
               nd_bill_amt,
			   " ",
			   nd_length_of_stay);
    else

    fprintf(f2,"%-12.12s %-28.28s %-8.8s %-6.6s %-10.10s %-8.8s/%-4.4s %-18.18s %10.2f %32s\n",
//  following line is commented by saikiran as it is printing patient id in 10chars instead of 12chars    	
//  fprintf(f2,"%10.10s %-30.30s %-8.8s %-6.6s %-10.10s %-8.8s/%-4.4s %-18.18s %10.2f %32s\n",
	           nd_patient_id.arr,
               nd_patient_name.arr,
			   d_cust_code.arr,
			   nd_ward_code.arr,
			    nd_proc_code.arr,
			   nd_episode_id.arr,		
			   nd_visit_id.arr,	
			   date_convert.arr,
               nd_bill_amt,
			   " ");
    
	strcpy(t_blng_grp_id.arr,nd_blng_grp_id.arr);
    t_blng_grp_id.len = strlen(t_blng_grp_id.arr);

	       d_lctr++;
    }
  

open_file()
{
char filename[30];

    
  	strcpy(filename,WORKING_DIR);
      strcat(filename,"BLRLM008.lis");

    if ((f2 = fopen(filename,"w")) == NULL) {
       disp_message(ERR_MESG,"Error in opening file BLRLM008.lis");
       proc_exit();
    }
     
 
	 fprintf(f2,"%c&l1O",ESC);   

     fprintf(f2,"%c(s14H",ESC); 
	 
   
    print_title();
	print_head();
    
  }


print_title()

{
       prt_title(f2,&d_pctr);

}

prt_title(fp,pctr)
FILE *fp;
int *pctr;
{

    form_hdr(&pctr);
    
	if(strcmp(nd_fm_blng_grp_id.arr, "!!!!") == 0)
    //strcpy(from_blng, "LOWEST");
	  strcpy(from_blng, loc_legend[142]);
    else strcpy(from_blng, nd_fm_blng_grp_id.arr);

	if(strcmp(nd_to_blng_grp_id.arr, "~~~~") == 0)
    //strcpy(to_blng, "HIGHEST");
	 strcpy(to_blng, loc_legend[143]);
    else strcpy(to_blng, nd_to_blng_grp_id.arr);
	   
	 if(strcmp(nd_fm_patient_id.arr, "!!!!!!!!!!") == 0)
    //strcpy(from_pat, "LOWEST");
	strcpy(from_pat, loc_legend[142]);
    else strcpy(from_pat, nd_fm_patient_id.arr);

	if(strcmp(nd_to_patient_id.arr, "~~~~~~~~~~") == 0)
    //strcpy(to_pat, "HIGHEST");
	strcpy(to_pat, loc_legend[143]);
    else strcpy(to_pat, nd_to_patient_id.arr);

	if(strcmp(nd_fm_cust_code.arr, "!!!!!!") == 0)
    //strcpy(from_cust, "LOWEST");
	  strcpy(from_cust, loc_legend[142]);
    else strcpy(from_cust,nd_fm_cust_code.arr);

	if(strcmp(nd_to_cust_code.arr, "~~~~~~") == 0)
    //strcpy(to_cust, "HIGHEST");
	  strcpy(to_cust, loc_legend[143]);
    else strcpy(to_cust, nd_to_cust_code.arr);
	   
	   if(strcmp(nd_fm_ward_code.arr, "!!!!!") == 0)
    //strcpy(from_ward, "LOWEST");
	  strcpy(from_ward,loc_legend[142]);

    else strcpy(from_ward,nd_fm_ward_code.arr);

	if(strcmp(nd_to_ward_code.arr, "~~~~~") == 0)
    strcpy(to_ward, loc_legend[143]);
    else strcpy(to_ward,nd_to_ward_code.arr);

/* ADDED by saikiran as it is printing wrong values in INPUT PARAMETERS */

if (nd_episode_type == 'I' || nd_episode_type == 'D')
{

	if(strcmp(nd_fm_adm_date.arr, "01/01/1000") == 0)
	{   
    strcpy(from_date, loc_legend[142]);
	}
    else
	{
		init_date_temp_var();                              
		strcpy(date_convert.arr,nd_fm_adm_date.arr);   
		fun_change_loc_date();  
	 strcpy(from_date, date_convert.arr);
	 }
 

	if(strcmp(nd_to_adm_date.arr, "01/01/4712") == 0)
	{
    strcpy(to_date, loc_legend[143]);
	}
    else 
	{
	init_date_temp_var();                              
		strcpy(date_convert.arr,nd_to_adm_date.arr);         
		fun_change_loc_date();
	strcpy(to_date,date_convert.arr);
	}
}
else 
{

	if(strcmp(nd_fm_visit_date.arr, "01/01/1000") == 0)   
	{
    strcpy(from_date, loc_legend[142]);
	}

    else 
	{
	init_date_temp_var();                              
	strcpy(date_convert.arr,nd_fm_visit_date.arr);         
	fun_change_loc_date();  
	strcpy(from_date,date_convert.arr);
	}


	if(strcmp(nd_to_visit_date.arr, "01/01/4712") == 0)
	{
    strcpy(to_date, loc_legend[143]);
	}
    else 
	{
	init_date_temp_var();                              
	strcpy(date_convert.arr,nd_to_visit_date.arr);         
	fun_change_loc_date();
	strcpy(to_date,date_convert.arr);
	}

}

	  
	  if(strcmp(nd_fm_clinic_code.arr, "!!!!!") == 0)
    strcpy(from_clinic, loc_legend[142]);
    else  strcpy(from_clinic, nd_fm_clinic_code.arr); 
	
	//strcpy(from_clinic, nd_fm_adm_date.arr); commented by saikiran as it is printing wrong value

	if(strcmp(nd_to_clinic_code.arr, "~~~~~") == 0)
    strcpy(to_clinic, loc_legend[143]);
    else strcpy(to_clinic, nd_to_clinic_code.arr);

	fprintf(fp,"%s\n",hdr_line1); 
	//fprintf(fp,"\f%s\n",hdr_line1);saikiran
    fprintf(fp,"%s\n",hdr_line2);
    fprintf(fp,"%s\n",hdr_line3);
    fprintf(fp,"%s\n",hdr_line4);



//fprintf(fp,"VER : 1.10.01\n");
fprintf(fp,"VER : 10\n");
fflush(fp);
//fprintf(fp,"\n\n\n\n        INPUT PARAMETERS :\n        ----------------\n\n");
fprintf(fp,"\n\n\n\n        %s\n        ----------------\n\n",loc_legend[004]);

if (nd_episode_type == 'I')
fprintf(fp,"                  %s              : %s\n\n",loc_legend[005],loc_legend[006]);
else if (nd_episode_type == 'O')
fprintf(fp,"                  %s              : %s\n\n",loc_legend[005],loc_legend[100]);
else if (nd_episode_type == 'E')
fprintf(fp,"                  %s              : %s\n\n",loc_legend[005],loc_legend[101]);
else 
fprintf(fp,"                  %s              : %s\n\n",loc_legend[005],loc_legend[102]);



//fprintf(fp,"                  BILLING GROUP        FROM : %s\n",from_blng);
fprintf(fp,"                  %s        %s : %s\n",loc_legend[103],loc_legend[104],from_blng);
//fprintf(fp,"                                         TO : %s\n\n",to_blng);
fprintf(fp,"                                         %s : %s\n\n",loc_legend[105],to_blng);
//fprintf(fp,"                  PATIENT ID           FROM : %s\n",from_pat);
fprintf(fp,"                  %s           %s : %s\n",loc_legend[106],loc_legend[104],from_pat);
//fprintf(fp,"                                         TO : %s\n\n",to_pat);
fprintf(fp,"                                         %s : %s\n\n",loc_legend[105],to_pat);
//fprintf(fp,"                  CUSTOMER CODE        FROM : %s\n",from_cust);
fprintf(fp,"                  %s        %s : %s\n",loc_legend[107],loc_legend[104],from_cust);
//fprintf(fp,"                                         TO : %s\n\n",loc_legend[105]);
fprintf(fp,"                                         %s : %s\n\n",loc_legend[105],to_cust);
if (nd_episode_type == 'I' || nd_episode_type == 'D')
{
//fprintf(fp,"                  ADMISSION DATE       FROM : %s\n",from_date);

fprintf(fp,"                  %s       %s : %s\n",loc_legend[108],loc_legend[104],from_date);
//fprintf(fp,"                                         TO : %s\n\n",to_date);
fprintf(fp,"                                         %s : %s\n\n",loc_legend[105],to_date);
}
else
{
//fprintf(fp,"                  VIST DATE            FROM : %s\n",from_date);
fprintf(fp,"                  %s           %s : %s\n",loc_legend[109],loc_legend[104],from_date);
//fprintf(fp,"                                         TO : %s\n\n",to_date);
fprintf(fp,"                                         %s : %s\n\n",loc_legend[105],to_date);
/* commented by saikiran to print correct parameters 
fprintf(fp,"                  VIST DATE            FROM : %s\n",nd_fm_visit_date.arr);
fprintf(fp,"                                         TO : %s\n\n",nd_to_visit_date.arr);
*/
}
if (nd_episode_type == 'I' || nd_episode_type == 'D')
{
//fprintf(fp,"                  WARD CODE            FROM : %s\n",from_ward);

fprintf(fp,"                  %s            %s : %s\n",loc_legend[110],loc_legend[104],from_ward);
//fprintf(fp,"                                         TO : %s\n\n",to_ward);
fprintf(fp,"                                         %s : %s\n\n",loc_legend[105],to_ward);
}
else
{
//fprintf(fp,"                  CLINIC CODE          FROM : %s\n",from_clinic);
fprintf(fp,"                  %s          %s : %s\n",loc_legend[111],loc_legend[104],from_clinic);
//fprintf(fp,"                                         TO : %s\n\n",to_clinic);
fprintf(fp,"                                         %s : %s\n\n",loc_legend[105],to_clinic);
}
//fprintf(fp,"                              Report Option : ");
fprintf(fp,"                              %s : ",loc_legend[112]);

if(nd_rep_option == 'E') 
//fprintf(fp,"Exceeding Authorized Amount\n\n");
fprintf(fp,"%s\n\n",loc_legend[001]);
if(nd_rep_option == 'B') 
//fprintf(fp,"Balance Authorized Amount\n\n");
fprintf(fp,"%s\n\n",loc_legend[002]);
if(nd_rep_option == 'C') 
//fprintf(fp,"No Credit Authorization Details\n\n");
fprintf(fp,"%s\n\n",loc_legend[003]);
if(nd_rep_option == 'A') 
//fprintf(fp,"All\n\n");
fprintf(fp,"%s\n\n",loc_legend[144]);

//fprintf(fp,"        Minimum Exceeding Authorized Amount : %s\n\n",nd_auth_amt.arr);
//fprintf(fp,"        %s : %s\n\n",loc_legend[118],nd_auth_amt.arr);
//fprintf(fp,"        Minimum Exceeding Auhtorized Days   : %s\n\n",nd_auth_day.arr);
//fprintf(fp,"        %s   : %s\n\n",loc_legend[119],nd_auth_day.arr);
//fprintf(fp,"             Including Discharge Patients   : ");
fprintf(fp,"             %s   : ",loc_legend[120]);

if(nd_inc_disc_pat == 'Y') 
//fprintf(fp,"Yes\n\n");
fprintf(fp,"%s\n\n",loc_legend[113]);
else
//fprintf(fp,"No\n\n");
fprintf(fp,"%s\n\n",loc_legend[114]);

}


fetch_hosp_name()
{
    hosp_name.arr[0] = '\0';
    date_time.arr[0] = '\0';
    user_id.arr[0]   = '\0';
    hosp_name.len    = 0;
    date_time.len	 = 0;
    user_id.len      = 0;

    /* EXEC SQL SELECT ACC_ENTITY_NAME, TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
                    USER
               INTO :hosp_name, :date_time, :user_id
               FROM SY_ACC_ENTITY  
			    WHERE ACC_ENTITY_ID  = :nd_facility_id
			   AND language_id=:p_language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 24;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24\
:MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY where (ACC_ENTITY_ID=:b3 and\
 language_id=:b4)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1096;
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
    sqlstm.sqhstl[2] = (unsigned int  )33;
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


			   

       if (OERROR) err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");

hosp_name.arr[hosp_name.len]           = '\0';
date_time.arr[date_time.len]           = '\0';
user_id.arr[user_id.len]               = '\0';
}



form_hdr(page_no)
int **page_no;
{

    static int first = 1;
    char buf[15];
    int col;

    if(first) {
        memset(hdr_line1,' ',REP_WIDTH+1);
        memset(hdr_line2,' ',REP_WIDTH+1);
	memset(hdr_line4,'-',REP_WIDTH);
	hdr_line4[REP_WIDTH] = '\0';

        strncpy(hdr_line1,"MDL : BL",8);
        col = (int)(REP_WIDTH-strlen(hosp_name.arr))/2;
        strncpy(hdr_line1+col,hosp_name.arr,strlen(hosp_name.arr));
        col = (REP_WIDTH-strlen(date_time.arr));
        
		/*init_date_temp_var();                              
        strcpy(date_convert.arr,date_time.arr);         
        fun_change_loc_date();*/

        strcpy(hdr_line1+col,date_time.arr);
		
    
        strncpy(hdr_line2,"OPR :",5);
        strcpy(hdr_line2+6,user_id.arr);

	first = 0;
    }

    memset(hdr_line3,' ',REP_WIDTH+1);

    strncpy(hdr_line3,"REP : BLRLM008",14);
    col = (int)(REP_WIDTH-strlen(rep_title))/2;
    strncpy(hdr_line3+col,rep_title,strlen(rep_title));
    sprintf(buf,"PAGE : %4d",++*(*page_no));
    strcpy(hdr_line3+(REP_WIDTH-strlen(buf)),buf);

/*
    fprintf(f1,"%s\n",hdr_line1);
    fprintf(f1,"%s\n",hdr_line2);
    fprintf(f1,"%s\n",hdr_line3);
    fprintf(f1,"%s\n",hdr_line4);
*/
}


sql_connect()
{
  /* EXEC SQL CONNECT :uid_pwd; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 24;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )1131;
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


  if (sqlca.sqlcode < 0)
      return(-1);
  return(0);
}


end_of_rep()

{  
    if (s_lctr > 48)
         print_head();

	//fprintf(f2,"\n\n                                   ***  END OF REPORT ***    \n");
	fprintf(f2,"\n\n                                   ***  %s ***    \n",loc_legend[115]);

  fflush(f2);
  }

get_patient_name()

 {
  nd_patient_name.arr[0]    = '\0';

  nd_patient_name.len       = 0;

  /*EXEC SQL SELECT   SHORT_NAME
              INTO :nd_patient_name
              FROM MP_PATIENT_MAST
             WHERE PATIENT_ID=:nd_patient_id;*/

     /* EXEC SQL SELECT decode(:p_language_id,'en', substr(short_name,1,60),substr(SHORT_NAME_LOC_LANG,1,60))
		  INTO  :nd_patient_name
          FROM MP_PATIENT_MAST
          WHERE PATIENT_ID = :nd_patient_id; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 24;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select decode(:b0,'en',substr(short_name,1,60),substr(S\
HORT_NAME_LOC_LANG,1,60)) into :b1  from MP_PATIENT_MAST where PATIENT_ID=:b2";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1162;
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
     sqlstm.sqhstv[1] = (         void  *)&nd_patient_name;
     sqlstm.sqhstl[1] = (unsigned int  )43;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&nd_patient_id;
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
        err_mesg("SELECT failed on table MP_PATIENT_MAST",0,"");

   nd_patient_name.arr[nd_patient_name.len] = '\0';
   

   
}

get_proc_code()

 {

  nd_proc_code.arr[0]    = '\0';

  nd_proc_code.len       = 0;


     /* EXEC SQL SELECT PROC_CODE
		  INTO  :nd_proc_code
          FROM MR_PROCEDURE_RECODING_DTL
          WHERE PATIENT_ID = :nd_patient_id
		  and Stage_no = '0' AND Stage_Srl_no=1
		  and FACILITY_ID=:nd_facility_id
		  and Encounter_id=:nd_encounter_id; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 24;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select PROC_CODE into :b0  from MR_PROCEDURE_RECODING_D\
TL where ((((PATIENT_ID=:b1 and Stage_no='0') and Stage_Srl_no=1) and FACILIT\
Y_ID=:b2) and Encounter_id=:b3)";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1189;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_proc_code;
     sqlstm.sqhstl[0] = (unsigned int  )13;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&nd_patient_id;
     sqlstm.sqhstl[1] = (unsigned int  )23;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&nd_facility_id;
     sqlstm.sqhstl[2] = (unsigned int  )5;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&nd_encounter_id;
     sqlstm.sqhstl[3] = (unsigned int  )15;
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
        err_mesg("SELECT failed on table MR_PROCEDURE_RECODING_DTL",0,"");
	}
	//if (NO_DATA_FOUND)
	 //{
     //nd_proc_code.arr[nd_proc_code.len] = '\0';
	 //nd_proc_code.len       = 0;
	 //}
	 nd_proc_code.arr[nd_proc_code.len] = '\0';
	 
  
   
}


 get_bill_amt()

 {

  
  nd_bill_amt= 0;


     /* EXEC SQL SELECT bill_amt
		  INTO  :nd_bill_amt
          FROM BL_BILL_HDR
          WHERE PATIENT_ID = :nd_patient_id
	         and blng_grp_id=:nd_blng_grp_id 
		 and episode_id =:nd_episode_id
		 and episode_type=:nd_episode_type
		 and NVL(visit_id,0)=:nd_visit_id; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 24;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select bill_amt into :b0  from BL_BILL_HDR where ((((PA\
TIENT_ID=:b1 and blng_grp_id=:b2) and episode_id=:b3) and episode_type=:b4) a\
nd NVL(visit_id,0)=:b5)";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1220;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_bill_amt;
     sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&nd_patient_id;
     sqlstm.sqhstl[1] = (unsigned int  )23;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&nd_blng_grp_id;
     sqlstm.sqhstl[2] = (unsigned int  )7;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&nd_episode_id;
     sqlstm.sqhstl[3] = (unsigned int  )11;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&nd_episode_type;
     sqlstm.sqhstl[4] = (unsigned int  )1;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&nd_visit_id;
     sqlstm.sqhstl[5] = (unsigned int  )7;
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




  


   if (OERROR)
    {
        err_mesg("SELECT failed on table BL_BILL_AMT",0,"");
	}
	//if (NO_DATA_FOUND)
	 //{
     //nd_proc_code.arr[nd_proc_code.len] = '\0';
	 //nd_proc_code.len       = 0;
	 //}
   
}


print_blng_grp()
{
  get_blng_name();

  if (d_lctr == 10)
     {
     //fprintf(f2,"Billing Group Code/Description : %3s/%-31s\n", 
	 fprintf(f2,"%s : %5s/%-31s\n",loc_legend[116] , 
	                        nd_blng_grp_id.arr,
							nd_blng_grp_desc.arr);
     d_lctr++;
     }
  else
     {
	 if (nblng_ctr)
     {

     //fprintf(f2,"                  Total No. of Patients : %-5d\n",nblng_ctr);
	   fprintf(f2,"                  %s : %-5d\n",loc_legend[117],nblng_ctr);
     nblng_ctr = 0;
	 d_lctr++;
	 }
     fprintf(f2,"\n%s : %5s/%-31s\n",loc_legend[116] ,
	                        nd_blng_grp_id.arr,
							nd_blng_grp_desc.arr);
     d_lctr=d_lctr+2;

     }
  fprintf(f2,"\n");
  d_lctr++;  	
}

get_blng_name()

 {
  nd_blng_grp_desc.arr[0]    = '\0';

  nd_blng_grp_desc.len       = 0;

  /* EXEC SQL SELECT   SHORT_DESC
              INTO :nd_blng_grp_desc
              FROM BL_BLNG_GRP_LANG_VW
             WHERE BLNG_GRP_ID=:nd_blng_grp_id
			 AND language_id=:p_language_id ; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 24;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select SHORT_DESC into :b0  from BL_BLNG_GRP_LANG_VW where\
 (BLNG_GRP_ID=:b1 and language_id=:b2)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1259;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_blng_grp_desc;
  sqlstm.sqhstl[0] = (unsigned int  )43;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_blng_grp_id;
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



   if (OERROR)
        err_mesg("SELECT failed on table BL_BLNG_GRP",0,"");

   nd_blng_grp_desc.arr[nd_blng_grp_desc.len] = '\0';
   

   
}



fetch_legend_value()
{
	for(i=1;i<=900;i++)
	{
		l_pk_value.arr[0] = '\0';

	/* EXEC SQL SELECT LTRIM(RTRIM('BLRLM008.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		        INTO :l_pk_value
			   FROM dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 24;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select LTRIM(RTRIM(('BLRLM008.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1286;
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
  sqlstm.arrsiz = 24;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility_id , '\
SM' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_va\
lue , :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1309;
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
	
	  
       	get_locale_date.CONVERT_TO_LOCALE_DATE(to_date(:nd_temp_date,'DD/MM/YYYY HH24:MI'),:p_language_id,t_date);  
      
	   :nd_loc_date := to_char(t_date,'DD/MM/YYYY');
	

	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 24;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . CONVERT_TO_LO\
CALE_DATE ( to_date ( :nd_temp_date , 'DD/MM/YYYY HH24:MI' ) , :p_language_id\
 , t_date ) ; :nd_loc_date := to_char ( t_date , 'DD/MM/YYYY' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1340;
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

                     
init_date_temp_var()
{
nd_temp_date.arr[0] = '\0';
nd_loc_date.arr[0]  = '\0';
date_convert.arr[0] = '\0';

nd_temp_date.len = 0;
nd_loc_date.len  = 0;
date_convert.len = 0;
}



fun_change_loc_date()
{

strcpy(nd_temp_date.arr,date_convert.arr);
nd_temp_date.len = strlen(nd_temp_date.arr);


get_local_date();

strcpy(date_convert.arr,nd_loc_date.arr); 

}








