
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
           char  filnam[44];
};
static const struct sqlcxp sqlfpn =
{
    43,
    "T:\\temp\\Bl\\robert\\Proc\\blrbgpri\\BLRBGPRI.PC"
};


static unsigned long sqlctx = 2024708157;


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
            void  *sqhstv[13];
   unsigned int   sqhstl[13];
            int   sqhsts[13];
            void  *sqindv[13];
            int   sqinds[13];
   unsigned int   sqharm[13];
   unsigned int   *sqharc[13];
   unsigned short  sqadto[13];
   unsigned short  sqtdso[13];
} sqlstm = {10,13};

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

 static const char *sq0009 = 
"select a.cust_pc_code ,c.short_desc ,a.blng_serv_code ,b.short_desc ,to_char\
(a.valid_from,'dd/mm/yyyy') ,to_char(a.valid_to,'dd/mm/yyyy') ,nvl(a.ip_rate,0\
) ,nvl(a.op_rate,0) ,nvl(a.ref_rate,0) ,nvl(a.emer_rate,0) ,nvl(a.daycare_rate\
,0)  from bl_serv_cust_pc_price a ,bl_blng_serv b ,bl_blng_grp c where (((((((\
a.cust_pc_code between nvl(:b0,'  ') and nvl(:b1,'~~') and a.blng_serv_code be\
tween nvl(:b2,'          ') and nvl(:b3,'~~~~~~~~~~')) and nvl(trunc(a.valid_f\
rom),to_date(:b4,'dd/mm/yyyy')) between to_date(:b4,'dd/mm/yyyy') and to_date(\
:b6,'dd/mm/yyyy')) and NVL(trunc(a.valid_to),to_date(:b6,'dd/mm/yyyy')) betwee\
n to_date(:b4,'dd/mm/yyyy') and to_date(:b6,'dd/mm/yyyy')) and a.blng_serv_cod\
e=b.blng_serv_code) and a.cust_pc_code=c.blng_grp_id) and a.cust_pc_ind='B') a\
nd NVL(b.status,'A')<>'S') order by 1,5            ";

 static const char *sq0011 = 
"select a.cust_pc_code ,c.short_desc ,b.prt_grp_hdr_code ,d.short_desc ,a.bln\
g_serv_code ,b.short_desc ,to_char(a.valid_from,'dd/mm/yyyy') ,to_char(a.valid\
_to,'dd/mm/yyyy') ,nvl(a.ip_rate,0) ,nvl(a.op_rate,0) ,nvl(a.ref_rate,0) ,nvl(\
a.emer_rate,0) ,nvl(a.daycare_rate,0)  from bl_serv_cust_pc_price a ,bl_blng_s\
erv b ,bl_blng_grp c ,bl_blng_prt_grp_hdr d where ((((((((a.cust_pc_code betwe\
en nvl(:b0,'  ') and nvl(:b1,'~~') and a.blng_serv_code between nvl(:b2,'     \
     ') and nvl(:b3,'~~~~~~~~~~')) and nvl(trunc(a.valid_from),to_date(:b4,'dd\
/mm/yyyy')) between to_date(:b4,'dd/mm/yyyy') and to_date(:b6,'dd/mm/yyyy')) a\
nd NVL(trunc(a.valid_to),to_date(:b6,'dd/mm/yyyy')) between to_date(:b4,'dd/mm\
/yyyy') and to_date(:b6,'dd/mm/yyyy')) and a.blng_serv_code=b.blng_serv_code) \
and a.cust_pc_code=c.blng_grp_id) and b.prt_grp_hdr_code=d.prt_grp_hdr_code) a\
nd a.cust_pc_ind='B') and NVL(b.status,'A')<>'S') order by 1,3,7            ";

 static const char *sq0013 = 
"select a.blng_serv_code ,b.short_desc ,a.cust_pc_code ,c.short_desc ,to_char\
(a.valid_from,'dd/mm/yyyy') ,to_char(a.valid_to,'dd/mm/yyyy') ,nvl(a.ip_rate,0\
) ,nvl(a.op_rate,0) ,nvl(a.ref_rate,0) ,nvl(a.emer_rate,0) ,nvl(a.daycare_rate\
,0)  from bl_serv_cust_pc_price a ,bl_blng_serv b ,bl_blng_grp c where (((((((\
a.cust_pc_code between nvl(:b0,'  ') and nvl(:b1,'~~') and a.blng_serv_code be\
tween nvl(:b2,'          ') and nvl(:b3,'~~~~~~~~~~')) and nvl(trunc(a.valid_f\
rom),to_date(:b4,'dd/mm/yyyy')) between to_date(:b4,'dd/mm/yyyy') and to_date(\
:b6,'dd/mm/yyyy')) and NVL(trunc(a.valid_to),to_date(:b6,'dd/mm/yyyy')) betwee\
n to_date(:b4,'dd/mm/yyyy') and to_date(:b6,'dd/mm/yyyy')) and a.blng_serv_cod\
e=b.blng_serv_code) and a.cust_pc_code=c.blng_grp_id) and a.cust_pc_ind='B') a\
nd NVL(b.status,'A')<>'S') order by 1,5            ";

 static const char *sq0015 = 
"select a.blng_serv_code ,b.short_desc ,b.prt_grp_hdr_code ,d.short_desc ,a.c\
ust_pc_code ,c.short_desc ,to_char(a.valid_from,'dd/mm/yyyy') ,to_char(a.valid\
_to,'dd/mm/yyyy') ,nvl(a.ip_rate,0) ,nvl(a.op_rate,0) ,nvl(a.ref_rate,0) ,nvl(\
a.emer_rate,0) ,nvl(a.daycare_rate,0)  from bl_serv_cust_pc_price a ,bl_blng_s\
erv b ,bl_blng_grp c ,bl_blng_prt_grp_hdr d where ((((((((a.cust_pc_code betwe\
en nvl(:b0,'  ') and nvl(:b1,'~~') and a.blng_serv_code between nvl(:b2,'     \
     ') and nvl(:b3,'~~~~~~~~~~')) and nvl(trunc(a.valid_from),to_date(:b4,'dd\
/mm/yyyy')) between to_date(:b4,'dd/mm/yyyy') and to_date(:b6,'dd/mm/yyyy')) a\
nd NVL(trunc(a.valid_to),to_date(:b6,'dd/mm/yyyy')) between to_date(:b4,'dd/mm\
/yyyy') and to_date(:b6,'dd/mm/yyyy')) and a.blng_serv_code=b.blng_serv_code) \
and a.cust_pc_code=c.blng_grp_id) and b.prt_grp_hdr_code=d.prt_grp_hdr_code) a\
nd a.cust_pc_ind='B') and NVL(b.status,'A')<>'S') order by 1,3,7            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,151,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,30,172,0,0,0,0,0,1,0,
51,0,0,3,0,0,32,180,0,0,0,0,0,1,0,
66,0,0,4,242,0,4,190,0,0,12,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
129,0,0,5,102,0,2,232,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
152,0,0,6,0,0,32,240,0,0,0,0,0,1,0,
167,0,0,7,128,0,4,251,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
198,0,0,8,0,0,32,273,0,0,0,0,0,1,0,
213,0,0,10,0,0,32,315,0,0,0,0,0,1,0,
228,0,0,12,0,0,32,363,0,0,0,0,0,1,0,
243,0,0,14,0,0,32,408,0,0,0,0,0,1,0,
258,0,0,16,0,0,32,457,0,0,0,0,0,1,0,
273,0,0,9,829,0,9,493,0,0,10,10,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
328,0,0,9,0,0,15,586,0,0,0,0,0,1,0,
343,0,0,11,932,0,9,589,0,0,10,10,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
398,0,0,11,0,0,15,743,0,0,0,0,0,1,0,
413,0,0,13,829,0,9,753,0,0,10,10,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
468,0,0,13,0,0,15,849,0,0,0,0,0,1,0,
483,0,0,15,932,0,9,852,0,0,10,10,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
538,0,0,15,0,0,15,950,0,0,0,0,0,1,0,
553,0,0,9,0,0,13,1049,0,0,11,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,
612,0,0,17,0,0,32,1077,0,0,0,0,0,1,0,
627,0,0,11,0,0,13,1084,0,0,13,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,
694,0,0,18,0,0,32,1115,0,0,0,0,0,1,0,
709,0,0,13,0,0,13,1122,0,0,11,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,
768,0,0,19,0,0,32,1149,0,0,0,0,0,1,0,
783,0,0,15,0,0,13,1156,0,0,13,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,
850,0,0,20,0,0,32,1187,0,0,0,0,0,1,0,
865,0,0,21,0,0,32,1268,0,0,0,0,0,1,0,
880,0,0,22,0,0,32,1325,0,0,0,0,0,1,0,
};


/****************************CSS MEDICOM ver 2.0*****************************
*  File	:   BLRBGPRI.pc   
   Author : Radha
   Date Created : 16/08/2000
   Date Modified : 20/12/2000  VSK BLENH 
   Date Modified : 22/02/2001  VSK BLENH    
                                 
*  Ver 2.10.01
   
*  Purpose : To print Billing Group Specific Prices
            
*  Input Parameters :     
                      Command line inputs 
		      		  1. Usr_id/Password
                      2. Session id
		      		  3. Program Date

                      Parameters from SY_PROG_PARAM table 
                      4.  From User ID
                      5.  To User ID
    	              6.  From Role
    	              7.  To Role
					  8.  From Function
					  9.  To Function
					  10. From Menu Name
					  11. To Menu Name
  
*  Table Accessed : bl_serv_cust_pc_price

*  Output File : BLRBGPRI.lis
 ****************************************************************************/  

#include <stdio.h>
#include <string.h>
#include "bl.h"
//#include <math.h>              

#define NODATAFOUND sqlca.sqlcode==1403
#define MAX_LINES 60
#define VER  "VER : 4.1\n"

/* #define INIT_MESG "Report Generation in Progress" */

/* EXEC SQL BEGIN DECLARE SECTION; */ 


/* increased the length all varchar variables by one to take care */
/* for null termination */

/* VARCHAR uid_pwd		         [42],
        d_blng_grp_id       [3],
		d_price_desc		[16], 
		d_valid_from		[11],
		d_valid_to			[11],
		d_blng_serv_code    [11],
		d_blng_serv_desc	[16],
		d_prt_grp_hdr_code  [3],
		d_prt_grp_desc      [16],    
        
		t_blng_grp_id		 [3],       
		t_price_desc		[16], 
		t_valid_from		[11],
		t_valid_to			[11],
		t_blng_serv_code    [11],
		t_blng_serv_desc	[16],
		t_prt_grp_hdr_code  [3],
		t_prt_grp_desc      [16],
		d_facility_id       [3],  
			
        nd_session_id        [16],
		nd_pgm_date	         [13],

		to_function_desc    [41],
        to_menu_option_desc [71],

		nd_fr_blng_grp_id           [3],
		nd_to_blng_grp_id           [3],
		nd_fr_blng_serv_code 	    [11],
		nd_to_blng_serv_code		[11],  
		nd_valid_from	      	    [11],
		nd_valid_to		      	    [11],
		nd_sort_order				[2],
		nd_breakup_by_prt_grp		[2],
		nd_patient_type				[2],

	    d_acc_entity_name    [41],
		d_user               [21],
		d_sysdate            [17]; */ 
struct { unsigned short len; unsigned char arr[42]; } uid_pwd;

struct { unsigned short len; unsigned char arr[3]; } d_blng_grp_id;

struct { unsigned short len; unsigned char arr[16]; } d_price_desc;

struct { unsigned short len; unsigned char arr[11]; } d_valid_from;

struct { unsigned short len; unsigned char arr[11]; } d_valid_to;

struct { unsigned short len; unsigned char arr[11]; } d_blng_serv_code;

struct { unsigned short len; unsigned char arr[16]; } d_blng_serv_desc;

struct { unsigned short len; unsigned char arr[3]; } d_prt_grp_hdr_code;

struct { unsigned short len; unsigned char arr[16]; } d_prt_grp_desc;

struct { unsigned short len; unsigned char arr[3]; } t_blng_grp_id;

struct { unsigned short len; unsigned char arr[16]; } t_price_desc;

struct { unsigned short len; unsigned char arr[11]; } t_valid_from;

struct { unsigned short len; unsigned char arr[11]; } t_valid_to;

struct { unsigned short len; unsigned char arr[11]; } t_blng_serv_code;

struct { unsigned short len; unsigned char arr[16]; } t_blng_serv_desc;

struct { unsigned short len; unsigned char arr[3]; } t_prt_grp_hdr_code;

struct { unsigned short len; unsigned char arr[16]; } t_prt_grp_desc;

struct { unsigned short len; unsigned char arr[3]; } d_facility_id;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[13]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[41]; } to_function_desc;

struct { unsigned short len; unsigned char arr[71]; } to_menu_option_desc;

struct { unsigned short len; unsigned char arr[3]; } nd_fr_blng_grp_id;

struct { unsigned short len; unsigned char arr[3]; } nd_to_blng_grp_id;

struct { unsigned short len; unsigned char arr[11]; } nd_fr_blng_serv_code;

struct { unsigned short len; unsigned char arr[11]; } nd_to_blng_serv_code;

struct { unsigned short len; unsigned char arr[11]; } nd_valid_from;

struct { unsigned short len; unsigned char arr[11]; } nd_valid_to;

struct { unsigned short len; unsigned char arr[2]; } nd_sort_order;

struct { unsigned short len; unsigned char arr[2]; } nd_breakup_by_prt_grp;

struct { unsigned short len; unsigned char arr[2]; } nd_patient_type;

struct { unsigned short len; unsigned char arr[41]; } d_acc_entity_name;

struct { unsigned short len; unsigned char arr[21]; } d_user;

struct { unsigned short len; unsigned char arr[17]; } d_sysdate;


float	nd_total_months, nd_days_old;
int		nd_trunc_total_months;
double   d_ip_rate,d_op_rate,d_ref_rate, d_emer_rate, d_daycare; 

char filename[150];
char l_mesg[200];

/* EXEC SQL END DECLARE SECTION; */ 


/* EXEC SQL INCLUDE SQLCA.H;
 */ 
/*
 * $Header:   T:/eHIS-102/archives/eHIS2Tier/BL/BLRBGPRI.c-arc   1.0   Apr 19 2007 17:05:32   vcm_th  $ sqlca.h 
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
 * $Header:   T:/eHIS-102/archives/eHIS2Tier/BL/BLRBGPRI.c-arc   1.0   Apr 19 2007 17:05:32   vcm_th  $ sqlda.h 
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






#include "winproc.h"

int   line_no=0, page_no=0;
int   totl_blng_serv = 0;
int   totl_price_class = 0;
int	  totl_blng_serv_fr_prt_grp = 0;
long  grand_totl_rec = 0, totl_detl_rec = 0;

FILE *f1;

void proc_main(argc, argv)
int argc;
char *argv[];
{
  void  get_params(),
     	get_header_dtls(),
		dclr_bl_pc_no_prtgrp_cur(),
		dclr_bl_pc_prtgrp_cur(),
		dclr_bl_bs_no_prtgrp_cur(),
		dclr_bl_bs_prtgrp_cur(),
  		do_report();

   //sprintf(l_mesg,"Arg  %d   Arg5  %s ",argc,argv[4]);
   //disp_message(ERR_MESG,l_mesg);
   if(argc < 5) 
   {
     disp_message (ERR_MESG,"Usage blrbgpri uid/passwd session_id pgm_date");
     proc_exit();
   }

   strcpy(filename,WORKING_DIR);
   strcat(filename,"blrbgpri.lis");

   if((f1 = fopen(filename, "w")) == NULL) 
   {
     disp_message (ERR_MESG, " Error opening output file ....");
     proc_exit();
   } 

   strcpy(uid_pwd.arr, argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr); 

   strcpy(nd_session_id.arr, argv[2]);
   nd_session_id.len = strlen(nd_session_id.arr); 

   strcpy(nd_pgm_date.arr, argv[3]);
   nd_pgm_date.len = strlen(nd_pgm_date.arr); 

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

   get_params();
   
   get_header_dtls();
   
   dclr_bl_pc_no_prtgrp_cur();
		
   dclr_bl_pc_prtgrp_cur();
   
   dclr_bl_bs_no_prtgrp_cur();
   
   dclr_bl_bs_prtgrp_cur();
   
   do_report();
   

   /*EXEC SQL CLOSE SY_MAST_CUR;*/
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

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
   if (sqlca.sqlcode < 0) goto err_exit;
}



   fclose(f1);

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
   sqlstm.offset = (unsigned int  )51;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message (ORA_MESG, "Oracle error at main() occured....");
   proc_exit();
}   


void get_params()
{
   
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL SELECT PARAM1,
				   PARAM2,
				   PARAM3,
				   PARAM4,
				   PARAM5,
				   PARAM6,
				   PARAM7,
				   PARAM8,
				   PARAM9,
				   OPERATING_FACILITY_ID
	        	INTO   :nd_fr_blng_grp_id,
			       :nd_to_blng_grp_id,
			       :nd_fr_blng_serv_code,
			       :nd_to_blng_serv_code,
			       :nd_valid_from,
				   :nd_valid_to,
				   :nd_sort_order,
				   :nd_breakup_by_prt_grp,
				   :nd_patient_type,
				   :d_facility_id
            	FROM   SY_PROG_PARAM
	        WHERE  PGM_ID = 'BLRBGPRI'
		    AND    SESSION_ID =  TO_NUMBER(:nd_session_id)
		    AND    PGM_DATE = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 ,PARAM5 ,PARAM6 ,PAR\
AM7 ,PARAM8 ,PARAM9 ,OPERATING_FACILITY_ID into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b\
7,:b8,:b9  from SY_PROG_PARAM where ((PGM_ID='BLRBGPRI' and SESSION_ID=TO_NUMB\
ER(:b10)) and PGM_DATE=:b11)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )66;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_fr_blng_grp_id;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_to_blng_grp_id;
   sqlstm.sqhstl[1] = (unsigned int  )5;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_fr_blng_serv_code;
   sqlstm.sqhstl[2] = (unsigned int  )13;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_to_blng_serv_code;
   sqlstm.sqhstl[3] = (unsigned int  )13;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_valid_from;
   sqlstm.sqhstl[4] = (unsigned int  )13;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_valid_to;
   sqlstm.sqhstl[5] = (unsigned int  )13;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_sort_order;
   sqlstm.sqhstl[6] = (unsigned int  )4;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_breakup_by_prt_grp;
   sqlstm.sqhstl[7] = (unsigned int  )4;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_patient_type;
   sqlstm.sqhstl[8] = (unsigned int  )4;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&d_facility_id;
   sqlstm.sqhstl[9] = (unsigned int  )5;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[10] = (unsigned int  )18;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[11] = (unsigned int  )15;
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
   if (sqlca.sqlcode < 0) goto err_exit;
}



  nd_fr_blng_grp_id.arr[nd_fr_blng_grp_id.len]		= '\0';
  nd_to_blng_grp_id.arr[nd_to_blng_grp_id.len]		= '\0';

  nd_fr_blng_serv_code.arr[nd_fr_blng_serv_code.len]			= '\0';
  nd_to_blng_serv_code.arr[nd_to_blng_serv_code.len]			= '\0';
  
  nd_valid_from.arr[nd_valid_from.len]			= '\0';
  nd_valid_to.arr[nd_valid_to.len]			= '\0';
  nd_sort_order.arr[nd_sort_order.len]	= '\0';
  nd_breakup_by_prt_grp.arr[nd_breakup_by_prt_grp.len]	= '\0';
  nd_patient_type.arr[nd_patient_type.len] = '\0';
     
  d_facility_id.arr[d_facility_id.len]			= '\0';
  strcpy(g_facility_id,d_facility_id.arr);	

  /* delete the parameter record */
  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  /* EXEC SQL DELETE SY_PROG_PARAM
	   WHERE PGM_ID = 'BLRBGPRI'
	         AND SESSION_ID = TO_NUMBER(:nd_session_id)
		 AND PGM_DATE = :nd_pgm_date; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 12;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='BLRBGPRI' and S\
ESSION_ID=TO_NUMBER(:b0)) and PGM_DATE=:b1)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )129;
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
  if (sqlca.sqlcode < 0) goto err_exit;
}



  return;
 err_exit:  
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 
  
   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )152;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message (ORA_MESG, "Oracle error at get_params() occured....");
   proc_exit();

}
 

/* get the header details */
void get_header_dtls()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL SELECT ACC_ENTITY_NAME, /o description of the institution o/
				   USER,
				   TO_CHAR(SYSDATE, 'DD/MM/YYYY HH24:MI')
		    INTO   :d_acc_entity_name,
				   :d_user,
				   :d_sysdate
	        FROM   SY_ACC_ENTITY
		   WHERE   acc_entity_id = :d_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select ACC_ENTITY_NAME ,USER ,TO_CHAR(SYSDATE,'DD/MM/YYYY \
HH24:MI') into :b0,:b1,:b2  from SY_ACC_ENTITY where acc_entity_id=:b3";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )167;
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
   sqlstm.sqhstl[2] = (unsigned int  )19;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_facility_id;
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
   if (sqlca.sqlcode < 0) goto err_exit;
}


		   
   d_acc_entity_name.arr[d_acc_entity_name.len] = '\0';
   d_user.arr[d_user.len]                       = '\0';
   d_sysdate.arr[d_sysdate.len]                 = '\0';

   if (NODATAFOUND)
   {
    disp_message (ORA_MESG, "Hospital not defined in SY_ACC_ENTITY. Error in get_params() occured....");
    proc_exit();    
   }
   return;

 err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )198;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message (ORA_MESG, "Oracle error at get_header_dtls() occured....");
   proc_exit();
}
 

void dclr_bl_pc_no_prtgrp_cur()
{

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  /* EXEC SQL DECLARE BL_PC_NO_PRTGRP_CUR CURSOR FOR
     select a.cust_pc_code,
			c.short_desc,
			a.blng_serv_code,
			b.short_desc,
			to_char(a.valid_from,'dd/mm/yyyy'),
			to_char(a.valid_to,'dd/mm/yyyy'),
			nvl(a.ip_rate,0),
			nvl(a.op_rate,0),
			nvl(a.ref_rate,0),
			nvl(a.emer_rate,0),
			nvl(a.daycare_rate,0)		//30/10/2004
	   from bl_serv_cust_pc_price a,
			bl_blng_serv b,
			bl_blng_grp c
	   where a.cust_pc_code between nvl(:nd_fr_blng_grp_id,'  ') and nvl(:nd_to_blng_grp_id,'~~')
	     and a.blng_serv_code between nvl(:nd_fr_blng_serv_code,'          ') and nvl(:nd_to_blng_serv_code,'~~~~~~~~~~')
		 and nvl(trunc(a.valid_from), to_date(:nd_valid_from,'dd/mm/yyyy'))
			between to_date(:nd_valid_from,'dd/mm/yyyy') and
								  to_date(:nd_valid_to,'dd/mm/yyyy')
		 and NVL(trunc(a.valid_to),to_date(:nd_valid_to,'dd/mm/yyyy')) between   to_date(:nd_valid_from,'dd/mm/yyyy') and
							      to_date(:nd_valid_to,'dd/mm/yyyy')
		 and a.blng_serv_code = b.blng_serv_code
	     and a.cust_pc_code = c.blng_grp_id
		 and a.cust_pc_ind = 'B'
		 and NVL(b.status, 'A')	 != 'S'
		order by 1,5; */ 
   	  	
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

 
     return;
  err_exit:
     /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

     /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 12;
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


     disp_message (ORA_MESG, "Oracle error at dclr_bl_pc_no_prtgrp_cur() occured....");
     proc_exit();
}

void dclr_bl_pc_prtgrp_cur()
{
		 /*and (to_date(to_char(a.valid_from,'dd/mm/yyyy'),'dd/mm/yyyy') between to_date(:nd_valid_from,'dd/mm/yyyy') and to_date(:nd_valid_to,'dd/mm/yyyy'))
		 and (to_date(to_char(a.valid_to,'dd/mm/yyyy'),'dd/mm/yyyy') between to_date(:nd_valid_from,'dd/mm/yyyy') and to_date(:nd_valid_to,'dd/mm/yyyy'))*/

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  /* EXEC SQL DECLARE BL_PC_PRTGRP_CUR CURSOR FOR
     select a.cust_pc_code,
			c.short_desc,
			b.prt_grp_hdr_code,
			d.short_desc,
			a.blng_serv_code,
			b.short_desc,
			to_char(a.valid_from,'dd/mm/yyyy'),
			to_char(a.valid_to,'dd/mm/yyyy'),
			nvl(a.ip_rate,0),
			nvl(a.op_rate,0),
			nvl(a.ref_rate,0),
			nvl(a.emer_rate,0),
			nvl(a.daycare_rate,0)		//30/10/2004
	   from bl_serv_cust_pc_price a,
			bl_blng_serv b,
			bl_blng_grp c,
			bl_blng_prt_grp_hdr d
	   where a.cust_pc_code between nvl(:nd_fr_blng_grp_id,'  ') and nvl(:nd_to_blng_grp_id,'~~')
	     and a.blng_serv_code between nvl(:nd_fr_blng_serv_code,'          ') and nvl(:nd_to_blng_serv_code,'~~~~~~~~~~')
		 and nvl(trunc(a.valid_from), to_date(:nd_valid_from,'dd/mm/yyyy'))
			between to_date(:nd_valid_from,'dd/mm/yyyy') and
								  to_date(:nd_valid_to,'dd/mm/yyyy')
		 and NVL(trunc(a.valid_to),to_date(:nd_valid_to,'dd/mm/yyyy')) between   to_date(:nd_valid_from,'dd/mm/yyyy') and
							      to_date(:nd_valid_to,'dd/mm/yyyy')
		 and a.blng_serv_code = b.blng_serv_code
	     and a.cust_pc_code = c.blng_grp_id
		 and b.prt_grp_hdr_code = d.prt_grp_hdr_code
		 and a.cust_pc_ind = 'B'
		 and NVL(b.status,'A')	   != 'S'
		order by 1,3,7; */ 
   	
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    
 
     return;
  err_exit:
     /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

     /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 12;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )228;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


     disp_message (ORA_MESG, "Oracle error at dclr_bl_pc_prtgrp_cur() occured....");
     proc_exit();
}

void dclr_bl_bs_no_prtgrp_cur()
{

		 /*and (to_date(to_char(a.valid_from,'dd/mm/yyyy'),'dd/mm/yyyy') between to_date(:nd_valid_from,'dd/mm/yyyy') and to_date(:nd_valid_to,'dd/mm/yyyy'))
		 and (to_date(to_char(a.valid_to,'dd/mm/yyyy'),'dd/mm/yyyy') between to_date(:nd_valid_from,'dd/mm/yyyy') and to_date(:nd_valid_to,'dd/mm/yyyy'))*/

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  /* EXEC SQL DECLARE BL_BS_NO_PRTGRP_CUR CURSOR FOR
     select a.blng_serv_code,
			b.short_desc,
			a.cust_pc_code,
			c.short_desc,
			to_char(a.valid_from,'dd/mm/yyyy'),
			to_char(a.valid_to,'dd/mm/yyyy'),
			nvl(a.ip_rate,0),
			nvl(a.op_rate,0),
			nvl(a.ref_rate,0),
			nvl(a.emer_rate,0),
			nvl(a.daycare_rate,0)		//30/10/2004
	   from bl_serv_cust_pc_price a,
			bl_blng_serv b,
			bl_blng_grp c
	   where a.cust_pc_code between nvl(:nd_fr_blng_grp_id,'  ') and nvl(:nd_to_blng_grp_id,'~~')
	     and a.blng_serv_code between nvl(:nd_fr_blng_serv_code,'          ') and nvl(:nd_to_blng_serv_code,'~~~~~~~~~~')
		 and nvl(trunc(a.valid_from), to_date(:nd_valid_from,'dd/mm/yyyy'))
			between to_date(:nd_valid_from,'dd/mm/yyyy') and
								  to_date(:nd_valid_to,'dd/mm/yyyy')
		 and NVL(trunc(a.valid_to),to_date(:nd_valid_to,'dd/mm/yyyy')) between   to_date(:nd_valid_from,'dd/mm/yyyy') and
							      to_date(:nd_valid_to,'dd/mm/yyyy')
		 and a.blng_serv_code = b.blng_serv_code
	     and a.cust_pc_code = c.blng_grp_id
		 and a.cust_pc_ind = 'B'
		 and NVL(b.status,'A')	   != 'S'
		order by 1,5; */ 
   	
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    
 
     return;
  err_exit:
     /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

     /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 12;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )243;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


     disp_message (ORA_MESG, "Oracle error at dclr_bl_bs_no_prtgrp_cur() occured....");
     proc_exit();
}

void dclr_bl_bs_prtgrp_cur()
{

		 /*and to_date(to_char(a.valid_from,'dd/mm/yyyy'),'dd/mm/yyyy') between to_date(:nd_valid_from,'dd/mm/yyyy') and to_date(:nd_valid_to,'dd/mm/yyyy')
		 and to_date(to_char(a.valid_to,'dd/mm/yyyy'),'dd/mm/yyyy') between to_date(:nd_valid_from,'dd/mm/yyyy') and to_date(:nd_valid_to,'dd/mm/yyyy')*/

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  /* EXEC SQL DECLARE BL_BS_PRTGRP_CUR CURSOR FOR
     select a.blng_serv_code,
			b.short_desc,
			b.prt_grp_hdr_code,
			d.short_desc,
			a.cust_pc_code,
			c.short_desc,
			to_char(a.valid_from,'dd/mm/yyyy'),
			to_char(a.valid_to,'dd/mm/yyyy'),
			nvl(a.ip_rate,0),
			nvl(a.op_rate,0),
			nvl(a.ref_rate,0),
			nvl(a.emer_rate,0),
			nvl(a.daycare_rate,0)		//30/10/2004	
	   from bl_serv_cust_pc_price a,
			bl_blng_serv b,
			bl_blng_grp c,
			bl_blng_prt_grp_hdr d
	   where a.cust_pc_code between nvl(:nd_fr_blng_grp_id,'  ') and nvl(:nd_to_blng_grp_id,'~~')
	     and a.blng_serv_code between nvl(:nd_fr_blng_serv_code,'          ') and nvl(:nd_to_blng_serv_code,'~~~~~~~~~~')
		 and nvl(trunc(a.valid_from), to_date(:nd_valid_from,'dd/mm/yyyy'))
			between to_date(:nd_valid_from,'dd/mm/yyyy') and
		to_date(:nd_valid_to,'dd/mm/yyyy')
		 and NVL(trunc(a.valid_to),to_date(:nd_valid_to,'dd/mm/yyyy')) between   to_date(:nd_valid_from,'dd/mm/yyyy') and
		 to_date(:nd_valid_to,'dd/mm/yyyy')
		 and a.blng_serv_code = b.blng_serv_code
	     and a.cust_pc_code = c.blng_grp_id
		 and b.prt_grp_hdr_code = d.prt_grp_hdr_code
		 and a.cust_pc_ind = 'B'
		 and NVL(b.status,'A')	   != 'S'	
		order by 1,3,7; */ 
   	
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    
 
     return;
  err_exit:
     /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

     /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 12;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )258;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


     disp_message (ORA_MESG, "Oracle error at dclr_bl_bs_prtgrp_cur() occured....");
     proc_exit();
}

/* fetches the record from the BL_PRICE_CLASS_CUR and calls the routine to   */
/* calculate the date of birth in days, months and years and then the */
/* routine to print the records.                                      */
void do_report()
{
  void prepare_new_price_page();
  void prepare_new_bs_page();
  void print_bs_detl_rec();
  void print_price_detl_rec();
  void print_rep_header();
  void print_page_header();
  void print_bs_col_heading();
  void print_price_col_heading();
  void print_master_rec();
  void print_totl_per_regn_date();
  void print_totl_per_report();
  void print_page_title();
  int fetch_bl_pc_no_prtgrp_cur();
  int fetch_bl_pc_prtgrp_cur();
  int fetch_bl_bs_no_prtgrp_cur();
  int fetch_bl_bs_prtgrp_cur();
  int still_rec_left1,still_rec_left2,still_rec_left3,still_rec_left4,
		 posted = 0;


  
  /* read the first cursor record */
  if (strcmp(nd_sort_order.arr,"P")==0)
   {
    if (strcmp(nd_breakup_by_prt_grp.arr,"N")==0)

    { /* EXEC SQL OPEN BL_PC_NO_PRTGRP_CUR; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 12;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = sq0009;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )273;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&nd_fr_blng_grp_id;
      sqlstm.sqhstl[0] = (unsigned int  )5;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&nd_to_blng_grp_id;
      sqlstm.sqhstl[1] = (unsigned int  )5;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&nd_fr_blng_serv_code;
      sqlstm.sqhstl[2] = (unsigned int  )13;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&nd_to_blng_serv_code;
      sqlstm.sqhstl[3] = (unsigned int  )13;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&nd_valid_from;
      sqlstm.sqhstl[4] = (unsigned int  )13;
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&nd_valid_from;
      sqlstm.sqhstl[5] = (unsigned int  )13;
      sqlstm.sqhsts[5] = (         int  )0;
      sqlstm.sqindv[5] = (         void  *)0;
      sqlstm.sqinds[5] = (         int  )0;
      sqlstm.sqharm[5] = (unsigned int  )0;
      sqlstm.sqadto[5] = (unsigned short )0;
      sqlstm.sqtdso[5] = (unsigned short )0;
      sqlstm.sqhstv[6] = (         void  *)&nd_valid_to;
      sqlstm.sqhstl[6] = (unsigned int  )13;
      sqlstm.sqhsts[6] = (         int  )0;
      sqlstm.sqindv[6] = (         void  *)0;
      sqlstm.sqinds[6] = (         int  )0;
      sqlstm.sqharm[6] = (unsigned int  )0;
      sqlstm.sqadto[6] = (unsigned short )0;
      sqlstm.sqtdso[6] = (unsigned short )0;
      sqlstm.sqhstv[7] = (         void  *)&nd_valid_to;
      sqlstm.sqhstl[7] = (unsigned int  )13;
      sqlstm.sqhsts[7] = (         int  )0;
      sqlstm.sqindv[7] = (         void  *)0;
      sqlstm.sqinds[7] = (         int  )0;
      sqlstm.sqharm[7] = (unsigned int  )0;
      sqlstm.sqadto[7] = (unsigned short )0;
      sqlstm.sqtdso[7] = (unsigned short )0;
      sqlstm.sqhstv[8] = (         void  *)&nd_valid_from;
      sqlstm.sqhstl[8] = (unsigned int  )13;
      sqlstm.sqhsts[8] = (         int  )0;
      sqlstm.sqindv[8] = (         void  *)0;
      sqlstm.sqinds[8] = (         int  )0;
      sqlstm.sqharm[8] = (unsigned int  )0;
      sqlstm.sqadto[8] = (unsigned short )0;
      sqlstm.sqtdso[8] = (unsigned short )0;
      sqlstm.sqhstv[9] = (         void  *)&nd_valid_to;
      sqlstm.sqhstl[9] = (unsigned int  )13;
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


      still_rec_left1 = fetch_bl_pc_no_prtgrp_cur();
      strcpy(t_blng_grp_id.arr,d_blng_grp_id.arr);
	  strcpy(t_valid_from.arr,d_valid_from.arr);

   //prepare_new_bs_page();
  {
   page_no += 1;
   print_page_header();
   prepare_new_price_page();
   fprintf(f1,"Billing Group/Description: ");
	   fprintf(f1,"%-9s/%-16s\n",d_blng_grp_id.arr,d_price_desc.arr);	
	   fprintf(f1,"From Date: %11s\n",d_valid_from.arr);
	   fprintf(f1,"  To Date: %11s\n",d_valid_to.arr);
   print_bs_col_heading(); 
   line_no = 12;
  }

  while(still_rec_left1)
  {
    
	if((strcmp(t_blng_grp_id.arr,d_blng_grp_id.arr)==0)&&
	   (strcmp(t_valid_from.arr,d_valid_from.arr)==0))
	{

	   if ((line_no + 2) >= MAX_LINES)
	 {  
	   prepare_new_bs_page();
	   fprintf(f1,"Billing Group/Description: ");
	   fprintf(f1,"%9s/%-16s\n",d_blng_grp_id.arr,d_price_desc.arr);	
	   fprintf(f1,"From Date: %11s\n",d_valid_from.arr);
	   fprintf(f1,"  To Date: %11s\n",d_valid_to.arr);
	   line_no = line_no + 3;
  	   print_bs_col_heading();
	   print_bs_detl_rec();
	   line_no += 4;
	   totl_blng_serv += 1;
	   strcpy(t_blng_grp_id.arr,d_blng_grp_id.arr);
	   strcpy(t_valid_from.arr,d_valid_from.arr);
	   still_rec_left1 = fetch_bl_pc_no_prtgrp_cur();
       	  
		 }
		 else
		 { 
		  print_bs_detl_rec();
		  line_no += 1;
		  totl_blng_serv += 1;
		  strcpy(t_blng_grp_id.arr,d_blng_grp_id.arr);
		  strcpy(t_valid_from.arr,d_valid_from.arr);
	   	  still_rec_left1 = fetch_bl_pc_no_prtgrp_cur();
         }
	   }	
	else
		{ 
		  fprintf(f1,"No. of Service Codes: %d\n",totl_blng_serv);
		  fprintf(f1,"--------------------------------------------------------------------------------\n\n");
		  totl_blng_serv = 0;
		  line_no = line_no + 3;
		  if ((line_no + 2)>= MAX_LINES)
		  {
		    prepare_new_bs_page();
	   fprintf(f1,"Billing Group/Description: ");
	   fprintf(f1,"%-9s/%-16s\n",d_blng_grp_id.arr,d_price_desc.arr);	
	   fprintf(f1,"From Date: %11s\n",d_valid_from.arr);
	   fprintf(f1,"  To Date: %11s\n",d_valid_to.arr);
	   line_no = line_no + 3;
  	   print_bs_col_heading();
	   print_bs_detl_rec();
	   line_no += 4;
	   totl_blng_serv += 1;
	   strcpy(t_blng_grp_id.arr,d_blng_grp_id.arr);
	   strcpy(t_valid_from.arr,d_valid_from.arr);
	   still_rec_left1 = fetch_bl_pc_no_prtgrp_cur(); 
			   }
		   else				 	 	
           {
		     fprintf(f1,"Billing Group/Description: ");
	   fprintf(f1,"%-9s/%-16s\n",d_blng_grp_id.arr,d_price_desc.arr);	
	   fprintf(f1,"From Date: %11s\n",d_valid_from.arr);
	   fprintf(f1,"  To Date: %11s\n",d_valid_to.arr);
	   line_no = line_no + 3;
  	   print_bs_col_heading();
	   print_bs_detl_rec();
	   line_no += 4;
	   totl_blng_serv += 1;
	   strcpy(t_blng_grp_id.arr,d_blng_grp_id.arr);
	   strcpy(t_valid_from.arr,d_valid_from.arr);
	   still_rec_left1 = fetch_bl_pc_no_prtgrp_cur(); 
		  
	   }  
	  }
       
     }	 	
    /* EXEC SQL CLOSE BL_PC_NO_PRTGRP_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )328;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	}
  else
    {/* EXEC SQL OPEN BL_PC_PRTGRP_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 12;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0011;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )343;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_fr_blng_grp_id;
     sqlstm.sqhstl[0] = (unsigned int  )5;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&nd_to_blng_grp_id;
     sqlstm.sqhstl[1] = (unsigned int  )5;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&nd_fr_blng_serv_code;
     sqlstm.sqhstl[2] = (unsigned int  )13;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&nd_to_blng_serv_code;
     sqlstm.sqhstl[3] = (unsigned int  )13;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&nd_valid_from;
     sqlstm.sqhstl[4] = (unsigned int  )13;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&nd_valid_from;
     sqlstm.sqhstl[5] = (unsigned int  )13;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&nd_valid_to;
     sqlstm.sqhstl[6] = (unsigned int  )13;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&nd_valid_to;
     sqlstm.sqhstl[7] = (unsigned int  )13;
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&nd_valid_from;
     sqlstm.sqhstl[8] = (unsigned int  )13;
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&nd_valid_to;
     sqlstm.sqhstl[9] = (unsigned int  )13;
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

    
	 still_rec_left2 = fetch_bl_pc_prtgrp_cur();
      strcpy(t_blng_grp_id.arr,d_blng_grp_id.arr);
	  strcpy(t_prt_grp_hdr_code.arr,d_prt_grp_hdr_code.arr);
	  strcpy(t_valid_from.arr,d_valid_from.arr);


   //prepare_new_price_page();
  {
   page_no += 1;
   print_page_header();
   prepare_new_price_page();
   fprintf(f1,"Billing Group/Description: ");
	   fprintf(f1,"%-9s/%-16s\n",d_blng_grp_id.arr,d_price_desc.arr);	
	   fprintf(f1,"From Date: %11s\n",d_valid_from.arr);
	   fprintf(f1,"  To Date: %11s\n",d_valid_to.arr);
	   fprintf(f1,"Print Group Code: %-3s\n",d_prt_grp_hdr_code.arr);
   print_bs_col_heading(); 
   line_no = 13;
  }

  while(still_rec_left2)
  {
    
	if(strcmp(t_blng_grp_id.arr,d_blng_grp_id.arr)==0)
	{
	  if ((strcmp(t_prt_grp_hdr_code.arr,d_prt_grp_hdr_code.arr)==0)&&
	      (strcmp(t_valid_from.arr,d_valid_from.arr)==0))
	  {	
	   if ((line_no + 2) >= MAX_LINES)
	 {  
	   prepare_new_bs_page();
	   fprintf(f1,"Billing Group/Description: ");
	   fprintf(f1,"%-9s/%-16s\n",d_blng_grp_id.arr,d_price_desc.arr);	
	   fprintf(f1,"From Date: %11s\n",d_valid_from.arr);
	   fprintf(f1,"  To Date: %11s\n",d_valid_to.arr);
	   fprintf(f1,"Print Group Code: %-3s\n",d_prt_grp_hdr_code.arr);
	   line_no = line_no + 4;
  	   print_bs_col_heading();
	   print_bs_detl_rec();
	   line_no += 4;
	   totl_blng_serv += 1;
	   totl_blng_serv_fr_prt_grp += 1;
	   strcpy(t_blng_grp_id.arr,d_blng_grp_id.arr);
	   strcpy(t_prt_grp_hdr_code.arr,d_prt_grp_hdr_code.arr);
	   strcpy(t_valid_from.arr,d_valid_from.arr);
	   still_rec_left2 = fetch_bl_pc_prtgrp_cur();
       	  
		 }
		 else
		 { 
		  print_bs_detl_rec();
		  line_no += 1;
		  totl_blng_serv += 1;
		  totl_blng_serv_fr_prt_grp += 1;
		  strcpy(t_blng_grp_id.arr,d_blng_grp_id.arr);
		  strcpy(t_prt_grp_hdr_code.arr,d_prt_grp_hdr_code.arr);
		  strcpy(t_valid_from.arr,d_valid_from.arr);
	   	  still_rec_left2 = fetch_bl_pc_prtgrp_cur();
         }
	   }	
	else
		{ 
		  fprintf(f1,"No. of Service Codes for the print group: %d\n",totl_blng_serv_fr_prt_grp);
		  fprintf(f1,"--------------------------------------------------------------------------------\n\n");
		  totl_blng_serv_fr_prt_grp = 0;
		  line_no = line_no + 3;
		  if ((line_no + 2)>= MAX_LINES)
		  {
		    prepare_new_bs_page();
	   fprintf(f1,"Billing Group/Description: ");
	   fprintf(f1,"%-9s/%-16s\n",d_blng_grp_id.arr,d_price_desc.arr);	
	   fprintf(f1,"From Date: %11s\n",d_valid_from.arr);
	   fprintf(f1,"  To Date: %11s\n",d_valid_to.arr);
	   fprintf(f1,"Print Group Code: %-3s\n",d_prt_grp_hdr_code.arr);
	   line_no = line_no + 4;
  	   print_bs_col_heading();
	   print_bs_detl_rec();
	   line_no += 4;
	   totl_blng_serv += 1;
	   totl_blng_serv_fr_prt_grp += 1;
	   strcpy(t_blng_grp_id.arr,d_blng_grp_id.arr);
	   strcpy(t_prt_grp_hdr_code.arr,d_prt_grp_hdr_code.arr);
	   strcpy(t_valid_from.arr,d_valid_from.arr);
	   still_rec_left2 = fetch_bl_pc_prtgrp_cur();	 
			   }
		   else				 	 	
           {
		   	   fprintf(f1,"Billing Group/Description: ");
	   fprintf(f1,"%-9s/%-16s\n",d_blng_grp_id.arr,d_price_desc.arr);	
	   fprintf(f1,"From Date: %11s\n",d_valid_from.arr);
	   fprintf(f1,"  To Date: %11s\n",d_valid_to.arr);
		     fprintf(f1,"Print Group Code: %-3s\n",d_prt_grp_hdr_code.arr);
  	   	   line_no = line_no + 4;
	   print_bs_col_heading();
	   print_bs_detl_rec();
	   line_no += 5;
	   totl_blng_serv += 1;
	   totl_blng_serv_fr_prt_grp += 1;
	   strcpy(t_blng_grp_id.arr,d_blng_grp_id.arr);
	   strcpy(t_prt_grp_hdr_code.arr,d_prt_grp_hdr_code.arr);
	   strcpy(t_valid_from.arr,d_valid_from.arr);
	   still_rec_left2 = fetch_bl_pc_prtgrp_cur();	 
		  
	   }  
	  }
     }
	 else
	 {       fprintf(f1,"No. of Service Codes for the print group: %d\n",totl_blng_serv_fr_prt_grp);
		  totl_blng_serv_fr_prt_grp = 0;
	      fprintf(f1,"No. of Service Codes: %d\n",totl_blng_serv);
		  fprintf(f1,"--------------------------------------------------------------------------------\n\n");
		  totl_blng_serv = 0;
		  line_no = line_no + 4;
	   if ((line_no + 2) >= MAX_LINES)
	   {  
	   prepare_new_bs_page();
	   fprintf(f1,"Billing Group/Description: ");
	   fprintf(f1,"%-9s/%-16s\n",d_blng_grp_id.arr,d_price_desc.arr);	
	   fprintf(f1,"From Date: %11s\n",d_valid_from.arr);
	   fprintf(f1,"  To Date: %11s\n",d_valid_to.arr);
	   fprintf(f1,"Print Group Code: %-3s\n",d_prt_grp_hdr_code.arr);
  	   line_no =line_no + 4;
	   print_bs_col_heading();
	   print_bs_detl_rec();
	   line_no += 4;
	   totl_blng_serv += 1;
	   totl_blng_serv_fr_prt_grp += 1;
	   strcpy(t_blng_grp_id.arr,d_blng_grp_id.arr);
	   strcpy(t_prt_grp_hdr_code.arr,d_prt_grp_hdr_code.arr);
	   strcpy(t_valid_from.arr,d_valid_from.arr);
	   still_rec_left2 = fetch_bl_pc_prtgrp_cur();
       	  
	   }
		 else
		 { 
		  fprintf(f1,"Billing Group/Description: ");
		  fprintf(f1,"%-9s/%-16s\n",d_blng_grp_id.arr,d_price_desc.arr);	
	      fprintf(f1,"From Date: %11s\n",d_valid_from.arr);
	      fprintf(f1,"  To Date: %11s\n",d_valid_to.arr);
	      fprintf(f1,"Print Group Code: %-3s\n",d_prt_grp_hdr_code.arr);
  	      line_no = line_no + 4;
		  print_bs_col_heading();
		  print_bs_detl_rec();
		  line_no += 4;
		  totl_blng_serv += 1;
		  totl_blng_serv_fr_prt_grp += 1;
		  strcpy(t_blng_grp_id.arr,d_blng_grp_id.arr);
		  strcpy(t_prt_grp_hdr_code.arr,d_prt_grp_hdr_code.arr);
		  strcpy(t_valid_from.arr,d_valid_from.arr);
	   	  still_rec_left2 = fetch_bl_pc_prtgrp_cur();
         }
	   }	
	 }
    /* EXEC SQL CLOSE BL_PC_PRTGRP_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )398;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

		 
   }
  
   
  }
 
 else
 {  
   if (strcmp(nd_breakup_by_prt_grp.arr,"N")==0)

    { /* EXEC SQL OPEN BL_BS_NO_PRTGRP_CUR; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 12;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = sq0013;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )413;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&nd_fr_blng_grp_id;
      sqlstm.sqhstl[0] = (unsigned int  )5;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&nd_to_blng_grp_id;
      sqlstm.sqhstl[1] = (unsigned int  )5;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&nd_fr_blng_serv_code;
      sqlstm.sqhstl[2] = (unsigned int  )13;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&nd_to_blng_serv_code;
      sqlstm.sqhstl[3] = (unsigned int  )13;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&nd_valid_from;
      sqlstm.sqhstl[4] = (unsigned int  )13;
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&nd_valid_from;
      sqlstm.sqhstl[5] = (unsigned int  )13;
      sqlstm.sqhsts[5] = (         int  )0;
      sqlstm.sqindv[5] = (         void  *)0;
      sqlstm.sqinds[5] = (         int  )0;
      sqlstm.sqharm[5] = (unsigned int  )0;
      sqlstm.sqadto[5] = (unsigned short )0;
      sqlstm.sqtdso[5] = (unsigned short )0;
      sqlstm.sqhstv[6] = (         void  *)&nd_valid_to;
      sqlstm.sqhstl[6] = (unsigned int  )13;
      sqlstm.sqhsts[6] = (         int  )0;
      sqlstm.sqindv[6] = (         void  *)0;
      sqlstm.sqinds[6] = (         int  )0;
      sqlstm.sqharm[6] = (unsigned int  )0;
      sqlstm.sqadto[6] = (unsigned short )0;
      sqlstm.sqtdso[6] = (unsigned short )0;
      sqlstm.sqhstv[7] = (         void  *)&nd_valid_to;
      sqlstm.sqhstl[7] = (unsigned int  )13;
      sqlstm.sqhsts[7] = (         int  )0;
      sqlstm.sqindv[7] = (         void  *)0;
      sqlstm.sqinds[7] = (         int  )0;
      sqlstm.sqharm[7] = (unsigned int  )0;
      sqlstm.sqadto[7] = (unsigned short )0;
      sqlstm.sqtdso[7] = (unsigned short )0;
      sqlstm.sqhstv[8] = (         void  *)&nd_valid_from;
      sqlstm.sqhstl[8] = (unsigned int  )13;
      sqlstm.sqhsts[8] = (         int  )0;
      sqlstm.sqindv[8] = (         void  *)0;
      sqlstm.sqinds[8] = (         int  )0;
      sqlstm.sqharm[8] = (unsigned int  )0;
      sqlstm.sqadto[8] = (unsigned short )0;
      sqlstm.sqtdso[8] = (unsigned short )0;
      sqlstm.sqhstv[9] = (         void  *)&nd_valid_to;
      sqlstm.sqhstl[9] = (unsigned int  )13;
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


	  

      still_rec_left3 = fetch_bl_bs_no_prtgrp_cur();
      strcpy(t_blng_serv_code.arr,d_blng_serv_code.arr);
	  strcpy(t_valid_from.arr,d_valid_from.arr);
		  

   //prepare_new_bs_page();
  {
   page_no += 1;
   print_page_header();
   prepare_new_price_page();
   fprintf(f1,"Billing Service Code/Description: ");
	   fprintf(f1,"%-10s/%-16s\n",d_blng_serv_code.arr,d_blng_serv_desc.arr);	
	   fprintf(f1,"From Date: %11s\n",d_valid_from.arr);
	   fprintf(f1,"  To Date: %11s\n",d_valid_to.arr);
   print_price_col_heading(); 
   line_no = 12;
  }

  while(still_rec_left3)
  {
    
	if((strcmp(t_blng_serv_code.arr,d_blng_serv_code.arr)==0)&&
	   (strcmp(t_valid_from.arr,d_valid_from.arr)==0))
	{

	   if ((line_no + 2) >= MAX_LINES)
	 {  
	   prepare_new_price_page();
	   fprintf(f1,"Billing Service Code/Description: ");
	   fprintf(f1,"%-10s/%-16s\n",d_blng_serv_code.arr,d_blng_serv_desc.arr);	
	   fprintf(f1,"From Date: %11s\n",d_valid_from.arr);
	   fprintf(f1,"  To Date: %11s\n",d_valid_to.arr);
	   line_no = line_no + 3;
	   print_price_col_heading(); 
       print_price_detl_rec();
	   line_no += 4;
	   totl_price_class += 1;
	   strcpy(t_blng_serv_code.arr,d_blng_serv_code.arr);
	   strcpy(t_valid_from.arr,d_valid_from.arr);
	   still_rec_left3 = fetch_bl_bs_no_prtgrp_cur();
       	  
		 }
		 else
		 { 
		  print_price_detl_rec();
		  line_no += 1;
		  totl_price_class += 1;
		  strcpy(t_blng_serv_code.arr,d_blng_serv_code.arr);
		  strcpy(t_valid_from.arr,d_valid_from.arr);
	   	  still_rec_left3 = fetch_bl_bs_no_prtgrp_cur();
         }
	   }	
	else
		{ 
		  fprintf(f1,"No. of Billing Groups: %d\n",totl_price_class);
		  fprintf(f1,"--------------------------------------------------------------------------------\n\n");
		  totl_price_class = 0;
		  line_no = line_no + 3;
		  if ((line_no + 2)>= MAX_LINES)
		  {
		    prepare_new_price_page();
	   fprintf(f1,"Billing Service Code/Description: ");
	   fprintf(f1,"%-10s/%-16s\n",d_blng_serv_code.arr,d_blng_serv_desc.arr);	
	   fprintf(f1,"From Date: %11s\n",d_valid_from.arr);
	   fprintf(f1,"  To Date: %11s\n",d_valid_to.arr);
	   line_no = line_no + 3;
	   print_price_col_heading(); 
	   print_price_detl_rec();
	   line_no += 4;
	   totl_price_class += 1;
	   strcpy(t_blng_serv_code.arr,d_blng_serv_code.arr);
	   strcpy(t_valid_from.arr,d_valid_from.arr);
	   still_rec_left3 = fetch_bl_bs_no_prtgrp_cur(); 
			   }
		   else				 	 	
           {
		     fprintf(f1,"Billing Service Code/Description: ");
	   fprintf(f1,"%-10s/%-16s\n",d_blng_serv_code.arr,d_blng_serv_desc.arr);	
	   fprintf(f1,"From Date: %11s\n",d_valid_from.arr);
	   fprintf(f1,"  To Date: %11s\n",d_valid_to.arr);
	   line_no = line_no + 3;
	   print_price_col_heading(); 
	   print_price_detl_rec();
	   line_no += 4;
	   totl_price_class += 1;
	   strcpy(t_blng_serv_code.arr,d_blng_serv_code.arr);
	   strcpy(t_valid_from.arr,d_valid_from.arr);
	   still_rec_left3 = fetch_bl_bs_no_prtgrp_cur(); 
		  
	   }  
	  }
       
     }	 	
    /* EXEC SQL CLOSE BL_BS_NO_PRTGRP_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )468;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	}
	else
	{ /* EXEC SQL OPEN BL_BS_PRTGRP_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0015;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )483;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_fr_blng_grp_id;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_to_blng_grp_id;
   sqlstm.sqhstl[1] = (unsigned int  )5;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_fr_blng_serv_code;
   sqlstm.sqhstl[2] = (unsigned int  )13;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_to_blng_serv_code;
   sqlstm.sqhstl[3] = (unsigned int  )13;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_valid_from;
   sqlstm.sqhstl[4] = (unsigned int  )13;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_valid_from;
   sqlstm.sqhstl[5] = (unsigned int  )13;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_valid_to;
   sqlstm.sqhstl[6] = (unsigned int  )13;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_valid_to;
   sqlstm.sqhstl[7] = (unsigned int  )13;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_valid_from;
   sqlstm.sqhstl[8] = (unsigned int  )13;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_valid_to;
   sqlstm.sqhstl[9] = (unsigned int  )13;
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


      still_rec_left4 = fetch_bl_bs_prtgrp_cur();
      strcpy(t_blng_serv_code.arr,d_blng_serv_code.arr);
	  strcpy(t_valid_from.arr,d_valid_from.arr);
	  

   //prepare_new_bs_page();
  {
   page_no += 1;
   print_page_header();
   prepare_new_price_page();
   fprintf(f1,"Billing Service Code/Description: ");
	   fprintf(f1,"%-10s/%-16s\n",d_blng_serv_code.arr,d_blng_serv_desc.arr);	
	   fprintf(f1,"From Date: %11s\n",d_valid_from.arr);
	   fprintf(f1,"  To Date: %11s\n",d_valid_to.arr);
	   fprintf(f1,"Print Group Code: %-3s\n",d_prt_grp_hdr_code.arr); 
   print_price_col_heading(); 
   line_no = 13;
  }

  while(still_rec_left4)
  {
    
	if((strcmp(t_blng_serv_code.arr,d_blng_serv_code.arr)==0)&&
	   (strcmp(t_valid_from.arr,d_valid_from.arr)==0))
	{

	   if ((line_no + 2) >= MAX_LINES)
	 {  
	   prepare_new_price_page();
	   fprintf(f1,"Billing Service Code/Description: ");
	   fprintf(f1,"%-10s/%-16s\n",d_blng_serv_code.arr,d_blng_serv_desc.arr);	
	   fprintf(f1,"From Date: %11s\n",d_valid_from.arr);
	   fprintf(f1,"  To Date: %11s\n",d_valid_to.arr);
	   fprintf(f1,"Print Group Code: %-3s\n",d_prt_grp_hdr_code.arr);
	   line_no = line_no + 4;
	   print_price_col_heading(); 
       print_price_detl_rec();
	   line_no += 4;
	   totl_price_class += 1;
	   strcpy(t_blng_serv_code.arr,d_blng_serv_code.arr);
	   strcpy(t_valid_from.arr,d_valid_from.arr);
	   still_rec_left4 = fetch_bl_bs_prtgrp_cur();
       	  
		 }
		 else
		 { 
		  print_price_detl_rec();
		  line_no += 1;
		  totl_price_class += 1;
		  strcpy(t_blng_serv_code.arr,d_blng_serv_code.arr);
		  strcpy(t_valid_from.arr,d_valid_from.arr);
	   	  still_rec_left4 = fetch_bl_bs_prtgrp_cur();
         }
	   }	
	else
		{ 
		  fprintf(f1,"No. of Billing Groups: %d\n",totl_price_class);
		  fprintf(f1,"--------------------------------------------------------------------------------\n\n");
		  totl_price_class = 0;
		  line_no = line_no + 3;
		  if ((line_no + 2)>= MAX_LINES)
		  {
		    prepare_new_price_page();
	   fprintf(f1,"Billing Service Code/Description: ");
	   fprintf(f1,"%-10s/%-16s\n",d_blng_serv_code.arr,d_blng_serv_desc.arr);	
	   fprintf(f1,"From Date: %11s\n",d_valid_from.arr);
	   fprintf(f1,"  To Date: %11s\n",d_valid_to.arr);
	   fprintf(f1,"Print Group Code: %-3s\n",d_prt_grp_hdr_code.arr);
	   line_no = line_no + 4;
	   print_price_col_heading(); 
	   print_price_detl_rec();
	   line_no += 4;
	   totl_price_class += 1;
	   strcpy(t_blng_serv_code.arr,d_blng_serv_code.arr);
	   strcpy(t_valid_from.arr,d_valid_from.arr);
	   still_rec_left4 = fetch_bl_bs_prtgrp_cur(); 
			   }
		   else				 	 	
           {
		     fprintf(f1,"Billing Service Code/Description: ");
	   fprintf(f1,"%-10s/%-16s\n",d_blng_serv_code.arr,d_blng_serv_desc.arr);	
	   fprintf(f1,"From Date: %11s\n",d_valid_from.arr);
	   fprintf(f1,"  To Date: %11s\n",d_valid_to.arr);
	   fprintf(f1,"Print Group Code: %-3s\n",d_prt_grp_hdr_code.arr);
	   line_no = line_no + 4;
	   print_price_col_heading(); 
	   print_price_detl_rec();
	   line_no += 4;
	   totl_price_class += 1;
	   strcpy(t_blng_serv_code.arr,d_blng_serv_code.arr);
	   strcpy(t_valid_from.arr,d_valid_from.arr);
	   still_rec_left4 = fetch_bl_bs_prtgrp_cur(); 
		  
	   }  
	  }
       
     }	 	
    /* EXEC SQL CLOSE BL_BS_PRTGRP_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )538;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	}

   }
    
      print_totl_per_report();

    
}


/* prepares for the new page */
void prepare_new_bs_page()
{
   page_no += 1;
   fprintf(f1,"\n");
   if (page_no == 1)
   {
   print_page_header();
   line_no = 9; 
   }
   else
   {
    if (strcmp(nd_sort_order.arr,"P")==0)
	{
	if (strcmp(nd_breakup_by_prt_grp.arr,"N")==0)
   
		print_page_title(80,"BL",d_acc_entity_name.arr,d_sysdate.arr,d_user.arr,\
                   "BLRBGPRI","LIST OF BILLING SERVICES BY BILLING GROUP",d_sysdate.arr,page_no);
   
	else
   
		print_page_title(80,"BL",d_acc_entity_name.arr,d_sysdate.arr,d_user.arr,\
                   "BLRBGPRI","LIST OF BILLING SERVICES BY BILLING GROUP / PRINT GROUP",d_sysdate.arr,page_no);
	}
	else
	{
	if (strcmp(nd_breakup_by_prt_grp.arr,"N")==0)
  
		print_page_title(80,"BL",d_acc_entity_name.arr,d_sysdate.arr,d_user.arr,\
                   "BLRBGPRI","LIST OF BILLING GROUP BY BILLING SERVICES",d_sysdate.arr,page_no);
   
	else
   
		print_page_title(90,"BL",d_acc_entity_name.arr,d_sysdate.arr,d_user.arr,\
                   "BLRBGPRI","LIST OF BILLING GROUP BY BILLING SERVICES / PRINT GROUP",d_sysdate.arr,page_no);
  
	}
   fprintf(f1,"--------------------------------------------------------------------------------\n\n");
   line_no = 6; 
  }
   
}
void prepare_new_price_page()
{
   page_no += 1;
   fprintf(f1,"\n");
   if (page_no == 1)
   {
   print_page_header();
   line_no = 9; 
   }
   else
   {
    if (strcmp(nd_sort_order.arr,"P")==0)
	{
	if (strcmp(nd_breakup_by_prt_grp.arr,"N")==0)
   
		print_page_title(80,"BL",d_acc_entity_name.arr,d_sysdate.arr,d_user.arr,\
                   "BLRBGPRI","LIST OF BILLING SERVICES BY BILLING GROUP",d_sysdate.arr,page_no);
   
	else
   
		print_page_title(80,"BL",d_acc_entity_name.arr,d_sysdate.arr,d_user.arr,\
                   "BLRBGPRI","LIST OF BILLING SERVICES BY BILLING GROUP / PRINT GROUP",d_sysdate.arr,page_no);
	}
	else
	{
	if (strcmp(nd_breakup_by_prt_grp.arr,"N")==0)
  
		print_page_title(80,"BL",d_acc_entity_name.arr,d_sysdate.arr,d_user.arr,\
                   "BLRBGPRI","LIST OF BILLING GROUP BY BILLING SERVICES",d_sysdate.arr,page_no);
   
	else
   
		print_page_title(90,"BL",d_acc_entity_name.arr,d_sysdate.arr,d_user.arr,\
                   "BLRBGPRI","LIST OF BILLING GROUP BY BILLING SERVICES / PRINT GROUP",d_sysdate.arr,page_no);
  
	}
 fprintf(f1,"--------------------------------------------------------------------------------\n\n");
	    line_no = 6; 
 }
   
}
 
int fetch_bl_pc_no_prtgrp_cur()
{
  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


  /* EXEC SQL FETCH BL_PC_NO_PRTGRP_CUR INTO
			     :d_blng_grp_id, 
				 :d_price_desc, 
				 :d_blng_serv_code,
				 :d_blng_serv_desc,
	   			 :d_valid_from,
				 :d_valid_to,
				 :d_ip_rate,
				 :d_op_rate,
				 :d_ref_rate,     
				 :d_emer_rate,
				 :d_daycare; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 12;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )553;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_blng_grp_id;
  sqlstm.sqhstl[0] = (unsigned int  )5;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_price_desc;
  sqlstm.sqhstl[1] = (unsigned int  )18;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_blng_serv_code;
  sqlstm.sqhstl[2] = (unsigned int  )13;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_blng_serv_desc;
  sqlstm.sqhstl[3] = (unsigned int  )18;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_valid_from;
  sqlstm.sqhstl[4] = (unsigned int  )13;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_valid_to;
  sqlstm.sqhstl[5] = (unsigned int  )13;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&d_ip_rate;
  sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&d_op_rate;
  sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&d_ref_rate;
  sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&d_emer_rate;
  sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&d_daycare;
  sqlstm.sqhstl[10] = (unsigned int  )sizeof(double);
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
  if (sqlca.sqlcode < 0) goto err_exit;
}

	//30/10/2004
				 		
   if (NODATAFOUND)       
      return 0;

   
   d_price_desc.arr[d_price_desc.len] = '\0';
   d_blng_serv_code.arr[d_blng_serv_code.len]         = '\0';
   d_blng_serv_desc.arr[d_blng_serv_desc.len]           = '\0';
   d_valid_from.arr[d_valid_from.len]   = '\0';
   d_valid_to.arr[d_valid_to.len]         = '\0';
   d_blng_grp_id.arr[d_blng_grp_id.len]   = '\0';
   	     
   return 1;

 err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )612;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message (ORA_MESG, "Oracle error at fetch_bl_pc_no_prtgrp_cur() occured....");
   proc_exit();
}
int fetch_bl_pc_prtgrp_cur()
{
  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  /* EXEC SQL FETCH BL_PC_PRTGRP_CUR INTO
			     :d_blng_grp_id, 
				 :d_price_desc, 
				 :d_prt_grp_hdr_code,
				 :d_prt_grp_desc,
				 :d_blng_serv_code,
				 :d_blng_serv_desc,
	   			 :d_valid_from,
				 :d_valid_to,
				 :d_ip_rate,
				 :d_op_rate,
				 :d_ref_rate,
				 :d_emer_rate,
				 :d_daycare; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 13;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )627;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_blng_grp_id;
  sqlstm.sqhstl[0] = (unsigned int  )5;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_price_desc;
  sqlstm.sqhstl[1] = (unsigned int  )18;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_prt_grp_hdr_code;
  sqlstm.sqhstl[2] = (unsigned int  )5;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_prt_grp_desc;
  sqlstm.sqhstl[3] = (unsigned int  )18;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_blng_serv_code;
  sqlstm.sqhstl[4] = (unsigned int  )13;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_blng_serv_desc;
  sqlstm.sqhstl[5] = (unsigned int  )18;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&d_valid_from;
  sqlstm.sqhstl[6] = (unsigned int  )13;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&d_valid_to;
  sqlstm.sqhstl[7] = (unsigned int  )13;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&d_ip_rate;
  sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&d_op_rate;
  sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&d_ref_rate;
  sqlstm.sqhstl[10] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&d_emer_rate;
  sqlstm.sqhstl[11] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&d_daycare;
  sqlstm.sqhstl[12] = (unsigned int  )sizeof(double);
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
  if (sqlca.sqlcode < 0) goto err_exit;
}

		//30/10/2004
		
   if (NODATAFOUND)
       return 0;

   d_blng_grp_id.arr[d_blng_grp_id.len]   = '\0';
   d_price_desc.arr[d_price_desc.len] = '\0';
   d_prt_grp_hdr_code.arr[d_prt_grp_hdr_code.len]   = '\0';
   d_prt_grp_desc.arr[d_prt_grp_desc.len] = '\0';
   d_blng_serv_code.arr[d_blng_serv_code.len]         = '\0';
   d_blng_serv_desc.arr[d_blng_serv_desc.len]           = '\0';
   d_valid_from.arr[d_valid_from.len]   = '\0';
   d_valid_to.arr[d_valid_to.len]         = '\0';
   	     
   return 1;

 err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 13;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )694;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message (ORA_MESG, "Oracle error at fetch_bl_pc_prtgrp_cur() occured....");
   proc_exit();
}
int fetch_bl_bs_no_prtgrp_cur()
{
  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  /* EXEC SQL FETCH BL_BS_NO_PRTGRP_CUR INTO
			     :d_blng_serv_code,
				 :d_blng_serv_desc,
	   			 :d_blng_grp_id, 
				 :d_price_desc, 
				 :d_valid_from,
				 :d_valid_to,
				 :d_ip_rate,
				 :d_op_rate,
				 :d_ref_rate,
				 :d_emer_rate,
				 :d_daycare; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 13;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )709;
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
  sqlstm.sqhstv[1] = (         void  *)&d_blng_serv_desc;
  sqlstm.sqhstl[1] = (unsigned int  )18;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_blng_grp_id;
  sqlstm.sqhstl[2] = (unsigned int  )5;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_price_desc;
  sqlstm.sqhstl[3] = (unsigned int  )18;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_valid_from;
  sqlstm.sqhstl[4] = (unsigned int  )13;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_valid_to;
  sqlstm.sqhstl[5] = (unsigned int  )13;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&d_ip_rate;
  sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&d_op_rate;
  sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&d_ref_rate;
  sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&d_emer_rate;
  sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&d_daycare;
  sqlstm.sqhstl[10] = (unsigned int  )sizeof(double);
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
  if (sqlca.sqlcode < 0) goto err_exit;
}

	//30/10/2004
		
   if (NODATAFOUND)
       return 0;

   d_blng_grp_id.arr[d_blng_grp_id.len]   = '\0';
   d_price_desc.arr[d_price_desc.len] = '\0';
   d_blng_serv_code.arr[d_blng_serv_code.len]         = '\0';
   d_blng_serv_desc.arr[d_blng_serv_desc.len]           = '\0';
   d_valid_from.arr[d_valid_from.len]   = '\0';
   d_valid_to.arr[d_valid_to.len]         = '\0';
   	     
   return 1;

 err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 13;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )768;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message (ORA_MESG, "Oracle error at fetch_bl_bs_no_prtgrp_cur() occured....");
   proc_exit();
}
int fetch_bl_bs_prtgrp_cur()
{
  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  /* EXEC SQL FETCH BL_BS_PRTGRP_CUR INTO
			     :d_blng_serv_code,
				 :d_blng_serv_desc,
	   			 :d_prt_grp_hdr_code,
				 :d_prt_grp_desc,
				 :d_blng_grp_id, 
				 :d_price_desc, 
				 :d_valid_from,
				 :d_valid_to,
				 :d_ip_rate,
				 :d_op_rate,
				 :d_ref_rate,
				 :d_emer_rate,
				 :d_daycare; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 13;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )783;
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
  sqlstm.sqhstv[1] = (         void  *)&d_blng_serv_desc;
  sqlstm.sqhstl[1] = (unsigned int  )18;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_prt_grp_hdr_code;
  sqlstm.sqhstl[2] = (unsigned int  )5;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_prt_grp_desc;
  sqlstm.sqhstl[3] = (unsigned int  )18;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_blng_grp_id;
  sqlstm.sqhstl[4] = (unsigned int  )5;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_price_desc;
  sqlstm.sqhstl[5] = (unsigned int  )18;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&d_valid_from;
  sqlstm.sqhstl[6] = (unsigned int  )13;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&d_valid_to;
  sqlstm.sqhstl[7] = (unsigned int  )13;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&d_ip_rate;
  sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&d_op_rate;
  sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&d_ref_rate;
  sqlstm.sqhstl[10] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&d_emer_rate;
  sqlstm.sqhstl[11] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&d_daycare;
  sqlstm.sqhstl[12] = (unsigned int  )sizeof(double);
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
  if (sqlca.sqlcode < 0) goto err_exit;
}

	//30/10/2004
		
   if (NODATAFOUND)
       return 0;

   d_blng_grp_id.arr[d_blng_grp_id.len]   = '\0';
   d_price_desc.arr[d_price_desc.len] = '\0';
   d_prt_grp_hdr_code.arr[d_prt_grp_hdr_code.len]   = '\0';
   d_prt_grp_desc.arr[d_prt_grp_desc.len] = '\0';
   d_blng_serv_code.arr[d_blng_serv_code.len]         = '\0';
   d_blng_serv_desc.arr[d_blng_serv_desc.len]           = '\0';
   d_valid_from.arr[d_valid_from.len]   = '\0';
   d_valid_to.arr[d_valid_to.len]         = '\0';
   	     
   return 1;

 err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 13;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )850;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message (ORA_MESG, "Oracle error at fetch_bl_bs_prtgrp_cur() occured....");
   proc_exit();
}


/* print total number of detail records in the report */
void print_totl_per_report()
{
  fprintf(f1,"\n");
  if (strcmp(nd_sort_order.arr,"P")==0)
  {
  if (strcmp(nd_breakup_by_prt_grp.arr,"N")==0)
   fprintf(f1,"No. of Service Codes: %d\n",totl_blng_serv);
  else
   fprintf(f1,"No. of Service Codes for the print group: %d\n",totl_blng_serv_fr_prt_grp);
  }
 else 
 
  fprintf(f1,"No. of Billing Groups: %d\n",totl_price_class);
  

  fprintf(f1,"==============================================================================\n\n");
  fprintf(f1,"                              ");
  fprintf(f1,"** End of Report **");
  fprintf(f1,"");
}


 /*to print the detailed record with to horizontal summeries*/ 
void print_bs_detl_rec()
{
  
       fprintf(f1,"%-10s     ",d_blng_serv_code.arr);
	   fprintf(f1,"%-18s",d_blng_serv_desc.arr);
	   if (strcmp(nd_patient_type.arr,"I")==0)
	   {print_formated1(d_ip_rate);
		fprintf(f1,"\n");}
	   else
	   {
	    if (strcmp(nd_patient_type.arr,"O")==0)
		   {print_formated1(d_op_rate);
		   fprintf(f1,"\n");}
	    else
		 {
		  if (strcmp(nd_patient_type.arr,"R")==0)   
			{print_formated1(d_ref_rate);
		    fprintf(f1,"\n");}
	      else
		  {
		   if (strcmp(nd_patient_type.arr, "E")==0)
		      {print_formated1(d_emer_rate);
			   fprintf(f1,"\n");}

		   else
		   {
		   if (strcmp(nd_patient_type.arr, "D")==0) //30/10/2004
		   {
		      print_formated1(d_daycare);
			   fprintf(f1,"\n");
		   }
		   else
		   {
			print_formated1(d_ip_rate);
			print_formated1(d_daycare);
			print_formated1(d_op_rate);
			print_formated1(d_emer_rate);
			print_formated1(d_ref_rate);
			
		    fprintf(f1,"\n");
			}

		   }
		  }
		 } 	
		}
    
return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 13;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )865;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message (ORA_MESG, "Oracle error at print_bs_detl_rec() occured....");
   proc_exit();
}
void print_price_detl_rec()
{
  
       fprintf(f1,"%-13s     ",d_blng_grp_id.arr);
	   fprintf(f1,"%-18s",d_price_desc.arr);
	   if (strcmp(nd_patient_type.arr,"I")==0)
		{print_formated1(d_ip_rate);
		fprintf(f1,"\n");}
	   else
	   {
	    if (strcmp(nd_patient_type.arr,"O")==0)
		   {print_formated1(d_op_rate);
		   fprintf(f1,"\n");}
	    else
		 {
		 if (strcmp(nd_patient_type.arr,"R")==0)   
			{print_formated1(d_ref_rate);
		    fprintf(f1,"\n");}
	    else
		 {
		  if (strcmp(nd_patient_type.arr, "E")==0)
		     {print_formated1(d_emer_rate);
			  fprintf(f1,"\n");}
		 else
		 {
			if (strcmp(nd_patient_type.arr, "D")==0)	//30/10/2004
			{
			  print_formated1(d_daycare);
			  fprintf(f1,"\n");
			}
			else
			{
			print_formated1(d_ip_rate);
			print_formated1(d_daycare);
			print_formated1(d_op_rate);
			print_formated1(d_emer_rate);
			print_formated1(d_ref_rate);
			
			
		    fprintf(f1,"\n");
			}
		  }	
		 }
		 } 	

		}
    
    
    
return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 13;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )880;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message (ORA_MESG, "Oracle error at print_price_detl_rec() occured....");
   proc_exit();
}


/* to print flexible page headers the header details */ 
void print_page_header()
{
  char fr_price_class_desc  [9], to_price_class_desc     [9],
       fr_blng_serv_desc    [7], to_blng_serv_desc      [7],
	   valid_from_desc      [11], valid_to_desc         [11];
  if(strcmp(nd_fr_blng_grp_id.arr, "!!") == 0)
    strcpy(fr_price_class_desc, "LOWEST");
    else strcpy(fr_price_class_desc, nd_fr_blng_grp_id.arr);

 if(strcmp(nd_to_blng_grp_id.arr, "~~") == 0)
    strcpy(to_price_class_desc, "HIGHEST");
    else strcpy(to_price_class_desc, nd_to_blng_grp_id.arr);
	
 if(strcmp(nd_fr_blng_serv_code.arr, "!!!!!!!!!!") == 0)
    strcpy(fr_blng_serv_desc, "LOWEST");
    else strcpy(fr_blng_serv_desc, nd_fr_blng_serv_code.arr);

  if(strcmp(nd_to_blng_serv_code.arr, "~~~~~~~~~~") == 0)
    strcpy(to_blng_serv_desc, "HIGHEST");
    else strcpy(to_blng_serv_desc, nd_to_blng_serv_code.arr);

 if(strcmp(nd_valid_from.arr, "01/01/1800") == 0)
    strcpy(valid_from_desc, "LOWEST");
    else strcpy(valid_from_desc, nd_valid_from.arr);

  if(strcmp(nd_valid_to.arr, "31/12/4712") == 0)
    strcpy(valid_to_desc, "HIGHEST");
    else strcpy(valid_to_desc, nd_valid_to.arr);

 if (strcmp(nd_sort_order.arr,"P")==0)
 {
  if (strcmp(nd_breakup_by_prt_grp.arr,"N")==0)
   
   print_page_title(80,"BL",d_acc_entity_name.arr,d_sysdate.arr,d_user.arr,\
                   "BLRBGPRI","LIST OF BILLING SERVICES BY BILLING GROUP",d_sysdate.arr,page_no);
   
  else
   
   print_page_title(80,"BL",d_acc_entity_name.arr,d_sysdate.arr,d_user.arr,\
                   "BLRBGPRI","LIST OF BILLING SERVICES BY BILLING GROUP / PRINT GROUP",d_sysdate.arr,page_no);
 }
else
 {
  if (strcmp(nd_breakup_by_prt_grp.arr,"N")==0)
  
   print_page_title(80,"BL",d_acc_entity_name.arr,d_sysdate.arr,d_user.arr,\
                   "BLRBGPRI","LIST OF BILLING GROUP BY BILLING SERVICES",d_sysdate.arr,page_no);
   
  else
   
   print_page_title(90,"BL",d_acc_entity_name.arr,d_sysdate.arr,d_user.arr,\
                   "BLRBGPRI","LIST OF BILLING GROUP BY BILLING SERVICES / PRINT GROUP",d_sysdate.arr,page_no);
  
 }

 fprintf(f1,"--------------------------------------------------------------------------------\n\n");
      
 
 fprintf(f1,"\n\n\n\n");
 fprintf(f1,"                     ");  
 fprintf(f1,"INPUT PARAMETERS\n");
 fprintf(f1,"                     ");  
 fprintf(f1,"----------------\n\n");


fprintf(f1,"                     ");  
 fprintf(f1,"PATIENT TYPE              :");	

	if (strcmp(nd_patient_type.arr,"I")==0)
	  {		
		fprintf(f1," INPATIENT\n\n");
	   }
	if (strcmp(nd_patient_type.arr,"D")==0)		//30/10/2004
	  {		
		fprintf(f1," DAYCARE\n\n");
	   }
	if (strcmp(nd_patient_type.arr,"O")==0)
	   {
		fprintf(f1," OUTPATIENT\n\n");
	   }	  
	if (strcmp(nd_patient_type.arr,"R")==0)
	   {
	    fprintf(f1," EXTERNAL PATIENT\n\n");  
	   }
	if (strcmp(nd_patient_type.arr,"E")==0)
	   {
	    fprintf(f1," EMERGENCY PATIENT\n\n");  
	   }

	if (strcmp(nd_patient_type.arr,"A")==0)
	   {
	    fprintf(f1," ALL\n\n");  
	   }



 
 fprintf(f1,"\n");
 fprintf(f1,"                     ");  
 fprintf(f1,"BILLING GROUP        FROM : %-11s\n ", fr_price_class_desc);
 fprintf(f1,"                                           TO : %-9s\n\n", to_price_class_desc);

 
 fprintf(f1,"                     ");  
 fprintf(f1,"BILLING SERVICE CODE FROM : %-11s\n ", fr_blng_serv_desc);
 fprintf(f1,"                                           TO : %-7s\n\n", to_blng_serv_desc);
 
fprintf(f1,"                     ");  
 fprintf(f1,"VALID  DATE          FROM : %-11s\n", valid_from_desc);
 fprintf(f1,"                     ");  
 fprintf(f1,"                       TO : %-11s\n\n", valid_to_desc);
 

fprintf(f1,"                     ");  
 fprintf(f1,"SORT ORDER                :");	


	if (strcmp(nd_sort_order.arr,"B")==0)
	  {		
		fprintf(f1," BILLING SERVICE\n\n");
	   }
	if (strcmp(nd_sort_order.arr,"P")==0)
	   {
		fprintf(f1," Billing Group\n\n");
	   }	  

fprintf(f1,"                     ");  
 fprintf(f1,"BREAK UP BY PRINT GROUP   : %s\n",nd_breakup_by_prt_grp.arr);	
 	    	
    
 fprintf(f1,"\n");
 
}


/* print the heading */
void print_bs_col_heading()
{
  if (strcmp(nd_patient_type.arr,"I")==0)
  { 
  fprintf(f1,"--------------------------------------------------------------------------------\n");
  fprintf(f1,"Billing Service   Description        IP  \n");
  fprintf(f1,"--------------------------------------------------------------------------------\n");
  }	
else
  {
   if (strcmp(nd_patient_type.arr,"O")==0)
   {
	  fprintf(f1,"--------------------------------------------------------------------------------\n");
	  fprintf(f1,"Billing Service   Description         OP  \n");
	  fprintf(f1,"--------------------------------------------------------------------------------\n");
   }
   else
   {
    if (strcmp(nd_patient_type.arr,"R")==0)
    {
     fprintf(f1,"--------------------------------------------------------------------------------\n");
     fprintf(f1,"Billing Service   Description       EXT  \n");
     fprintf(f1,"--------------------------------------------------------------------------------\n");
    }
    else
    {
     if (strcmp(nd_patient_type.arr,"E")==0)
     {
       fprintf(f1,"--------------------------------------------------------------------------------\n");
       fprintf(f1,"Billing Service   Description   Emergency \n");
       fprintf(f1,"--------------------------------------------------------------------------------\n");
     }
     else
	 {
	  if (strcmp(nd_patient_type.arr,"D")==0)	//30/10/2004
	  {
       fprintf(f1,"--------------------------------------------------------------------------------\n");
       fprintf(f1,"Billing Service   Description     Daycare \n");
       fprintf(f1,"--------------------------------------------------------------------------------\n");
	  }	
      else
	  {		
	    fprintf(f1,"--------------------------------------------------------------------------------\n");
	    fprintf(f1,"Billing Service    Description        IP       DC       OP    Emerg.     EXT     \n");
        fprintf(f1,"--------------------------------------------------------------------------------\n");
	  }
	 }
   }
   }
  }
}  	

void print_price_col_heading()
{
  if (strcmp(nd_patient_type.arr,"I")==0)
  { 
  fprintf(f1,"--------------------------------------------------------------------------------\n");
  fprintf(f1,"Billing Group     Description           IP  \n");
  fprintf(f1,"--------------------------------------------------------------------------------\n");
  }	
  else
  {
   if (strcmp(nd_patient_type.arr,"O")==0)
  {
  fprintf(f1,"--------------------------------------------------------------------------------\n");
  fprintf(f1,"Billing Group     Description           OP  \n");
  fprintf(f1,"--------------------------------------------------------------------------------\n");
  }
  else
  {
    if (strcmp(nd_patient_type.arr,"R")==0)
    {
     fprintf(f1,"--------------------------------------------------------------------------------\n");
     fprintf(f1,"Billing Group      Description          EXT  \n");
     fprintf(f1,"--------------------------------------------------------------------------------\n");
    }
	else
	{
	  if (strcmp(nd_patient_type.arr,"E")==0)
      {
       fprintf(f1,"--------------------------------------------------------------------------------\n");
       fprintf(f1,"Billing Group      Description        Emerg.  \n");
       fprintf(f1,"--------------------------------------------------------------------------------\n");
      }
	  else
	  {
	    if (strcmp(nd_patient_type.arr,"D")==0)
		{
			fprintf(f1,"--------------------------------------------------------------------------------\n");
			fprintf(f1,"Billing Group      Description          DC  \n");
			fprintf(f1,"--------------------------------------------------------------------------------\n");
		}
		else
		{		
		  fprintf(f1,"--------------------------------------------------------------------------------\n");
		  fprintf(f1,"Billing Group     Description            IP       DC       OP   Emerg.      EXT  \n");
		  fprintf(f1,"--------------------------------------------------------------------------------\n");
		} 
			
	  }
	}
   }
  }
 }

void print_page_title(nd_rep_width,
						 nd_mod_id,
						 nd_hospital_name,
						 nd_date,
						 nd_user,
						 nd_rep_id,
						 nd_rep_name,
						 nd_date,
						 page_number)

char nd_mod_id[3],nd_hospital_name[31],nd_date[16], nd_rep_id[9],nd_rep_name[101],
     nd_user[21];
int  nd_rep_width, page_number;
{
	/******************* Line 1 : Hospital Name ******************/
	int i = 0 , pos = 0 , len = 0, len_date = 0 , pos_date = 0,
	    len_page_no = 0,  pos_page_no = 0;

    /*Find the length of Hospital Name*/
    for(len = 0; nd_hospital_name[len] != '\0'; len++);

    /*Find the length of Date*/
    for(len_date = 0; nd_date[len_date] != '\0'; len_date++);

    len = len / 2;

    pos = (nd_rep_width / 2	) - len;

	pos_date = nd_rep_width - len_date;

	fprintf(f1,"MDL : %2s",nd_mod_id);

	for(i = 9; i < pos ; fprintf(f1," "),i++);

	fprintf(f1,"%s",nd_hospital_name);

	for(i = i + (len * 2) ; i < pos_date ; fprintf(f1," "),i++);

    fprintf(f1,"%s\n",nd_date);

    /******************* Line 2 : User Name ******************/

	fprintf(f1,"IPR : %-20s\n",nd_user);
	
	/******************* Line 3 : Report Name ******************/
	i = 0 ; 
	pos = 0 ; 
	len = 0; 
	len_page_no = 0 ; 
	pos_page_no = 0;

    /*Find the length of Report Name*/
    for(len = 0; nd_rep_name[len] != '\0'; len++);

    len = len / 2;

    pos = (nd_rep_width / 2	) - len;

	pos_page_no = nd_rep_width - 10;

	fprintf(f1,"REP : %8s",nd_rep_id);

	for(i = 15; i < pos ; fprintf(f1," "),i++);

	fprintf(f1,"%-24s",nd_rep_name);		
     
	for(i = i + (len * 2) ; i < pos_page_no - 7; fprintf(f1," "),i++);

    fprintf(f1,"Page : %d\n",page_number);

	
}

print_formated1(loc_amount)
double loc_amount;
{
	char *s_amt;
	char out_str[30],out_str1[30];

   if (loc_amount >= 0)
   {
      /*sprintf(out_str,"%8.2f",loc_amount);
      ltrim(out_str);str_comma(out_str);
      sprintf(out_str1,"%8s",out_str);*/

       put_val(out_str,loc_amount);
       format_amt(out_str);
       strcat(out_str," ");
       fprintf(f1,"%8s ",out_str);
   }
   else
   {
      /*sprintf(out_str,"%8.2f",-loc_amount);
      ltrim(out_str);str_comma(out_str);
      sprintf(out_str1,"%8s",out_str);*/
 
      put_val(out_str,-loc_amount);
      format_amt(out_str);
      strcat(out_str,"-");
 
      fprintf(f1,"%8s-",out_str);      
   }
}    
        
#undef NODATAFOUND
#undef MAX_LINES
#undef VER
