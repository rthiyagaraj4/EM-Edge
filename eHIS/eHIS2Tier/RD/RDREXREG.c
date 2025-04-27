
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
           char  filnam[50];
};
static const struct sqlcxp sqlfpn =
{
    49,
    "D:\\RISReports\\ProcReportsAll\\RDREXREG\\RDREXREG.pc"
};


static unsigned long sqlctx = 1566843677;


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

 static const char *sq0022 = 
"select B.EXAM_ROOM ,TO_CHAR(A.REQUEST_DATE,'DD/MM/YYYY') ,A.REQUEST_NUM ,B.R\
EQUEST_LINE_NUM ,B.EXAM_CODE ,A.ORDER_TYPE_CODE ,A.ORDER_ID ,A.PATIENT_ID ,A.E\
PISODE_TYPE ,A.EPISODE_ID ,A.TFR_VISIT_NUM ,A.REF_SOURCE_CODE ,A.PHYSICIAN_ID \
,B.STATUS  from RD_REQUEST A ,RD_EXAM_VIEW_REQUESTED B where ((((((((A.REQUEST\
_NUM=B.REQUEST_NUM and A.OPERATING_FACILITY_ID=B.OPERATING_FACILITY_ID) and A.\
OPERATING_FACILITY_ID=:b0) and B.SECTION_CODE=:b1) and A.WING_CODE=:b2) and RE\
QUEST_DATE>=TO_DATE(NVL(:b3,'01/01/1800'),'DD/MM/YYYY')) and REQUEST_DATE<(TO_\
DATE(NVL(:b4,'01/01/3000'),'DD/MM/YYYY')+1)) and NVL(A.STATUS,'!!')<>'99') and\
 (B.STATUS=decode(:b5,'X',B.STATUS,:b5) or B.STATUS=decode(:b5,'70','80','X'))\
) order by B.EXAM_ROOM,TO_CHAR(A.REQUEST_DATE,'YYYYMMDDHH24MI'),A.REQUEST_NUM \
           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,167,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,30,223,0,0,0,0,0,1,0,
51,0,0,3,179,0,4,238,0,0,9,4,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,
102,0,0,4,116,0,2,267,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
133,0,0,5,95,0,4,281,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
160,0,0,6,125,0,4,296,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
191,0,0,7,122,0,4,313,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
222,0,0,8,89,0,4,330,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
249,0,0,9,97,0,4,346,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
276,0,0,10,97,0,4,362,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
303,0,0,11,166,0,4,416,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
334,0,0,12,82,0,4,430,0,0,2,1,0,1,0,1,9,0,0,2,4,0,0,
357,0,0,13,63,0,4,456,0,0,2,1,0,1,0,1,9,0,0,2,4,0,0,
380,0,0,14,208,0,4,481,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
411,0,0,15,126,0,4,500,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
442,0,0,16,187,0,4,521,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
469,0,0,17,107,0,4,531,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
496,0,0,18,199,0,4,538,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
527,0,0,19,114,0,4,549,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
554,0,0,20,97,0,4,572,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
581,0,0,21,106,0,4,590,0,0,4,2,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
612,0,0,22,0,0,13,720,0,0,14,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
683,0,0,22,789,0,9,771,0,0,8,8,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,
730,0,0,23,165,0,4,1118,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
765,0,0,24,322,0,6,1219,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,3,3,0,0,2,9,0,0,
796,0,0,25,112,0,6,1256,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
819,0,0,26,136,0,6,1269,0,0,2,2,0,1,0,2,9,0,0,1,3,0,0,
};


#include <stdio.h>
#include <string.h>
#include <gl.h>

#define MAX_LINES 42
#define REP_WIDTH 130
#define REP_TITLE "LIST OF EXAM REGISTRATIONS"
#define VER  "VER : 10.2\n"
#define ESC  0x1B

/* EXEC SQL BEGIN DECLARE SECTION; */ 


    /* VARCHAR nd_facility_id		   [3],  --added by rvN 0n 06/Aug/2003
			nd_pgm_id    		   [9],  --added by rvN 0n 06/Aug/2003
			//uid_pwd		           [91], --size increased by rvN 0n 06/Aug/2003
			uid_pwd		           [122],	/o Length increased from 91 to 122 o/
			nd_session_id		   [16],
			nd_pgm_date		       [21], /o Input Parameters       o/
            
			rep_date[20],
            comp_name[301],               /oLength changed from 61 to 301 for internationalisationo/
            oper_id[31],
            d_curr_pgm_name[15]; */ 
struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[9]; } nd_pgm_id;

struct { unsigned short len; unsigned char arr[122]; } uid_pwd;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[21]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[20]; } rep_date;

struct { unsigned short len; unsigned char arr[301]; } comp_name;

struct { unsigned short len; unsigned char arr[31]; } oper_id;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;


    /* VARCHAR nd_wing_code			[2],
			nd_section_code			[5],
		    nd_fm_date				[21],
		    nd_to_date				[21],
			temp_nd_fm_date				[21],
		    temp_nd_to_date				[21],
		    nd_status				[3],
			nd_status_desc			[300],  /o30 to 300o/
			nd_status_desc1			[30],  
			nd_room_code			[5],
			h_wing_desc				[91] ,  /o31 to 91o/
	
            d_clinic_code           [5],
		    d_request_date          [21],
		    d_request_num           [11],
		    d_request_line_num      [4],
		    d_exam_code             [11],
		    d_order_type_code       [4],
		    d_order_id              [16],
		    d_patient_id            [21],
		    d_episode_type          [2],
		    d_episode_id            [13],
		    d_visit_id              [7],
		    d_ref_source_code       [5],
		    d_physician_id          [16],
			d_technician_id         [16],
		    d_status                [3],
			d_technician_id_1       [16],
			d_technician_name_1     [16],  /olength chaned from 16 to 45 for internationalisationo/
			d_technician_id_2       [16],
			d_technician_name_2     [45],  /olength chaned from 16 to 45 for internationalisationo/

            d_prv_clinic_code       [5],
		    d_prv_request_num       [11],
		    d_prv_order_type_code   [4],
		    d_prv_order_id          [16],
		    d_prv_patient_id        [21],
		    d_prv_episode_type      [2],
		    d_prv_episode_id        [13],
		    d_prv_visit_id          [7],
		    d_prv_ref_source_code   [5],
		    d_prv_physician_id      [16],
			d_prv_technician_id     [16],
		    d_prv_status            [3],
	
		    d_section_desc          [91],  /o31 to 91o/
		    d_room_desc             [91],  /o31 to 91o/
		    d_exam_desc             [91],  /o31 to 91o/
		    d_status_desc           [31],
		    d_pat_name              [181],  /o31 to 181o/
		    d_sex                   [2],
		    d_dob                   [11],

		    d_ward_no               [5],
		    d_bed_no                [9],
	
		    d_phys_name             [91],   /o Length changed from 31 to 91 for internationalisationo/
		    d_technician_name       [45],   /o Length changed from 16 to 45 for internationalisationo/
		    d_ref_source_desc       [301],  /o Lenght changed from 31 to 301 for internationalisation o/
			
			p_language_id		   [3],
			date_convert		   [21],
			nd_temp_date		   [21],
			nd_loc_date            [21],
			l_translated_value	   [200]; */ 
struct { unsigned short len; unsigned char arr[2]; } nd_wing_code;

struct { unsigned short len; unsigned char arr[5]; } nd_section_code;

struct { unsigned short len; unsigned char arr[21]; } nd_fm_date;

struct { unsigned short len; unsigned char arr[21]; } nd_to_date;

struct { unsigned short len; unsigned char arr[21]; } temp_nd_fm_date;

struct { unsigned short len; unsigned char arr[21]; } temp_nd_to_date;

struct { unsigned short len; unsigned char arr[3]; } nd_status;

struct { unsigned short len; unsigned char arr[300]; } nd_status_desc;

struct { unsigned short len; unsigned char arr[30]; } nd_status_desc1;

struct { unsigned short len; unsigned char arr[5]; } nd_room_code;

struct { unsigned short len; unsigned char arr[91]; } h_wing_desc;

struct { unsigned short len; unsigned char arr[5]; } d_clinic_code;

struct { unsigned short len; unsigned char arr[21]; } d_request_date;

struct { unsigned short len; unsigned char arr[11]; } d_request_num;

struct { unsigned short len; unsigned char arr[4]; } d_request_line_num;

struct { unsigned short len; unsigned char arr[11]; } d_exam_code;

struct { unsigned short len; unsigned char arr[4]; } d_order_type_code;

struct { unsigned short len; unsigned char arr[16]; } d_order_id;

struct { unsigned short len; unsigned char arr[21]; } d_patient_id;

struct { unsigned short len; unsigned char arr[2]; } d_episode_type;

struct { unsigned short len; unsigned char arr[13]; } d_episode_id;

struct { unsigned short len; unsigned char arr[7]; } d_visit_id;

struct { unsigned short len; unsigned char arr[5]; } d_ref_source_code;

struct { unsigned short len; unsigned char arr[16]; } d_physician_id;

struct { unsigned short len; unsigned char arr[16]; } d_technician_id;

struct { unsigned short len; unsigned char arr[3]; } d_status;

struct { unsigned short len; unsigned char arr[16]; } d_technician_id_1;

struct { unsigned short len; unsigned char arr[16]; } d_technician_name_1;

struct { unsigned short len; unsigned char arr[16]; } d_technician_id_2;

struct { unsigned short len; unsigned char arr[45]; } d_technician_name_2;

struct { unsigned short len; unsigned char arr[5]; } d_prv_clinic_code;

struct { unsigned short len; unsigned char arr[11]; } d_prv_request_num;

struct { unsigned short len; unsigned char arr[4]; } d_prv_order_type_code;

struct { unsigned short len; unsigned char arr[16]; } d_prv_order_id;

struct { unsigned short len; unsigned char arr[21]; } d_prv_patient_id;

struct { unsigned short len; unsigned char arr[2]; } d_prv_episode_type;

struct { unsigned short len; unsigned char arr[13]; } d_prv_episode_id;

struct { unsigned short len; unsigned char arr[7]; } d_prv_visit_id;

struct { unsigned short len; unsigned char arr[5]; } d_prv_ref_source_code;

struct { unsigned short len; unsigned char arr[16]; } d_prv_physician_id;

struct { unsigned short len; unsigned char arr[16]; } d_prv_technician_id;

struct { unsigned short len; unsigned char arr[3]; } d_prv_status;

struct { unsigned short len; unsigned char arr[91]; } d_section_desc;

struct { unsigned short len; unsigned char arr[91]; } d_room_desc;

struct { unsigned short len; unsigned char arr[91]; } d_exam_desc;

struct { unsigned short len; unsigned char arr[31]; } d_status_desc;

struct { unsigned short len; unsigned char arr[181]; } d_pat_name;

struct { unsigned short len; unsigned char arr[2]; } d_sex;

struct { unsigned short len; unsigned char arr[11]; } d_dob;

struct { unsigned short len; unsigned char arr[5]; } d_ward_no;

struct { unsigned short len; unsigned char arr[9]; } d_bed_no;

struct { unsigned short len; unsigned char arr[91]; } d_phys_name;

struct { unsigned short len; unsigned char arr[45]; } d_technician_name;

struct { unsigned short len; unsigned char arr[301]; } d_ref_source_desc;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[21]; } date_convert;

struct { unsigned short len; unsigned char arr[21]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[21]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[200]; } l_translated_value;


			int i=0,
			    time_flag = 0;


float       mths,dys; 
int         desc_len;


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
char string_var[100];
char filename[150];

char loc_legend[999][200];

char hdr_line1[REP_WIDTH+1],
     hdr_line2[REP_WIDTH+1],
     hdr_line3[REP_WIDTH+1],
     hdr_line4[REP_WIDTH+1],
     hdr_line5[REP_WIDTH+1];

char rep_title1[] = "LIST OF EXAM REGISTRATIONS";
char rep_title2[50];

FILE *f1;

int page_no,
    line_no,
    first_line,
    g_count;

float yrs,days;
int   iyrs,imths,idays;
char age[5];

char file_name[15];

long g_room_tot,
     g_section_tot;

void proc_main(argc,argv)
int argc;
char *argv[];
{

    if(argc  != 6) {
        disp_message(ERR_MESG,"RDREXREG : Usage RDREXREG userid/password session_id pgm_date\n");
        proc_exit();
    }
  
	
    strcpy(g_pgm_id,"RDREXREG");

    strcpy(d_curr_pgm_name.arr,g_pgm_id); 
    d_curr_pgm_name.len = strlen(d_curr_pgm_name.arr); 

	strcpy(nd_pgm_id.arr, argv[0]);
	nd_pgm_id.len = strlen(nd_pgm_id.arr); 

	strcpy(uid_pwd.arr, argv[1]);
	uid_pwd.len = strlen(uid_pwd.arr); 

	strcpy(nd_session_id.arr, argv[2]);
	nd_session_id.len = strlen(nd_session_id.arr); 

	strcpy(nd_pgm_date.arr, argv[3]);
	nd_pgm_date.len = strlen(nd_pgm_date.arr); 

	strcpy(nd_facility_id.arr, argv[4]);
	nd_facility_id.len = strlen(nd_facility_id.arr);

	strcpy(OUTPUT_FILE_NAME, argv[5]);
	
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
 sqlstm.sqhstl[0] = (unsigned int  )124;
 sqlstm.sqhsts[0] = (         int  )124;
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



    if(ERROR) {
        disp_message(ORA_MESG,"Unable to connect to oracle.\n");
		/*printf("%s\n",sqlca.sqlerrm.sqlerrmc);                */
        proc_exit();
    }

	set_meduser_role();

	/*Code Included for internationalization*/
	strcpy(p_language_id.arr,l_language_id.arr);
	p_language_id.len = l_language_id.len;

	strcpy(filename,WORKING_DIR);
	//strcat(filename,"rdrexreg.lis");
	strcat(filename,OUTPUT_FILE_NAME);

	/* rintf("%s (1.10.01) : Program started.\n\n",g_pgm_id);  */

	fetch_legend_value();

    fetch_prog_param();
    
	get_section_desc();

    fetch_sys_info();

    sprintf(rep_title2,"FROM %s TO %s", 
	strlen(nd_fm_date.arr)?nd_fm_date.arr:"LOWEST", 
	strlen(nd_to_date.arr)?nd_to_date.arr:"HIGHEST");

    strcpy(file_name,"rdrexreg.lis");

    if( (f1=fopen(filename,"w")) == NULL) {
        disp_message(ERR_MESG,"Error in opening output file...\n");
	proc_exit();
    }

    page_no=0;
    line_no=1;

    decl_curs();

	fprintf(f1,"%c&k4S",ESC);
	fprintf(f1,"%c&l1O",ESC); 
	fprintf(f1,"%c&a5L",ESC);/*for landscape printing by rvNambiar on 26/Aug/2003 */
    
	put_inp_parm();

    do_report();
    
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



  /*  printf("%s (1.10.01) : Program ended.\n\n",g_pgm_id);   */

    return;

}


/*	***********************	Sub Programm'S	***********************		*/

 
fetch_prog_param()
{

   /* EXEC SQL SELECT PARAM1,
				   PARAM2,
				   PARAM3,
				   PARAM4,
				   PARAM5
              INTO :nd_wing_code ,
			       :nd_section_code,
				   :nd_fm_date,
                   :nd_to_date,
				   :nd_status
                   
              FROM SY_PROG_PARAM
             WHERE OPERATING_FACILITY_ID = :nd_facility_id
			   AND PGM_ID				 = :nd_pgm_id
               AND SESSION_ID			 = :nd_session_id
               AND PGM_DATE				 = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 9;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 ,PARAM5 into :b0,:b1\
,:b2,:b3,:b4  from SY_PROG_PARAM where (((OPERATING_FACILITY_ID=:b5 and PGM_ID\
=:b6) and SESSION_ID=:b7) and PGM_DATE=:b8)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )51;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_wing_code;
   sqlstm.sqhstl[0] = (unsigned int  )4;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_section_code;
   sqlstm.sqhstl[1] = (unsigned int  )7;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_fm_date;
   sqlstm.sqhstl[2] = (unsigned int  )23;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_to_date;
   sqlstm.sqhstl[3] = (unsigned int  )23;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_status;
   sqlstm.sqhstl[4] = (unsigned int  )5;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_facility_id;
   sqlstm.sqhstl[5] = (unsigned int  )5;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_pgm_id;
   sqlstm.sqhstl[6] = (unsigned int  )11;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[7] = (unsigned int  )18;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[8] = (unsigned int  )23;
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



   if (ERROR) 
        disp_message(ERR_MESG,"SELECT failed on table SY_PROG_PARAM");

   if (NO_DATA_FOUND)
        disp_message(ERR_MESG,"No Record found in SY_PROG_PARAM");

    nd_wing_code.arr[nd_wing_code.len]       = '\0';
    nd_fm_date.arr[nd_fm_date.len]           = '\0';
    nd_to_date.arr[nd_to_date.len]           = '\0';
    nd_section_code.arr[nd_section_code.len] = '\0';
    nd_room_code.arr[nd_room_code.len]       = '\0';

	/* EXEC SQL DELETE SY_PROG_PARAM
			  WHERE OPERATING_FACILITY_ID = :nd_facility_id
			    AND PGM_ID				  = :nd_pgm_id
                AND SESSION_ID			  = :nd_session_id
                AND PGM_DATE			  = :nd_pgm_date; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 9;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from SY_PROG_PARAM  where (((OPERATING_FACILITY_ID=:\
b0 and PGM_ID=:b1) and SESSION_ID=:b2) and PGM_DATE=:b3)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )102;
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
 sqlstm.sqhstv[1] = (         void  *)&nd_pgm_id;
 sqlstm.sqhstl[1] = (unsigned int  )11;
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



	if (ERROR)
		disp_message(ERR_MESG,"DELETE failed on table SY_PROG_PARAM" );
   
}

get_section_desc()
{

    /* EXEC SQL SELECT LONG_DESC
		       INTO :d_section_desc
		       FROM RD_SECTION_LANG_VW
		      WHERE SECTION_CODE = :nd_section_code
			  AND   LANGUAGE_ID = :p_language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 9;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select LONG_DESC into :b0  from RD_SECTION_LANG_VW where \
(SECTION_CODE=:b1 and LANGUAGE_ID=:b2)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )133;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_section_desc;
    sqlstm.sqhstl[0] = (unsigned int  )93;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_section_code;
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



    if(ERROR)
	disp_message(ERR_MESG,"SELECT failed on table RD_SECTION" );

    d_section_desc.arr[d_section_desc.len]  = '\0';

}

get_room_desc()
{
    /* EXEC SQL SELECT LONG_DESC
			   INTO :d_room_desc
			   FROM RD_CLINIC_LANG_VW
			  WHERE OPERATING_FACILITY_ID = :nd_facility_id
				AND CLINIC_CODE = :d_clinic_code
				AND LANGUAGE_ID = :p_language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 9;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select LONG_DESC into :b0  from RD_CLINIC_LANG_VW where (\
(OPERATING_FACILITY_ID=:b1 and CLINIC_CODE=:b2) and LANGUAGE_ID=:b3)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )160;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_room_desc;
    sqlstm.sqhstl[0] = (unsigned int  )93;
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
    sqlstm.sqhstv[2] = (         void  *)&d_clinic_code;
    sqlstm.sqhstl[2] = (unsigned int  )7;
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



    d_room_desc.arr[d_room_desc.len]  = '\0';
}

/*------ gets the Wing desc for the Wing code ----------------------------*/
void get_wing_desc()
{
  
  h_wing_desc.arr [0]   = '\0';
  h_wing_desc.len     = 0;

   /* EXEC SQL SELECT LONG_DESC
			  INTO :h_wing_desc
			  FROM RD_WINGS_LANG_VW
			 WHERE OPERATING_FACILITY_ID = :nd_facility_id
			   AND WING_CODE = :nd_wing_code
			   AND LANGUAGE_ID = :p_language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 9;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select LONG_DESC into :b0  from RD_WINGS_LANG_VW where ((O\
PERATING_FACILITY_ID=:b1 and WING_CODE=:b2) and LANGUAGE_ID=:b3)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )191;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&h_wing_desc;
   sqlstm.sqhstl[0] = (unsigned int  )93;
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
   sqlstm.sqhstv[2] = (         void  *)&nd_wing_code;
   sqlstm.sqhstl[2] = (unsigned int  )4;
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

	

  h_wing_desc.arr [ h_wing_desc.len ] = '\0';
  return;
}
/*-------------------- End of Wing Desc ------------------------------------*/



get_exam_desc()
{

    /* EXEC SQL SELECT SHORT_DESC 
	           INTO :d_exam_desc
	           FROM RD_EXAMINATION
	          WHERE EXAM_CODE = :d_exam_code
			  AND   LANGUAGE_ID = :p_language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 9;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select SHORT_DESC into :b0  from RD_EXAMINATION where (EX\
AM_CODE=:b1 and LANGUAGE_ID=:b2)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )222;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_exam_desc;
    sqlstm.sqhstl[0] = (unsigned int  )93;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_exam_code;
    sqlstm.sqhstl[1] = (unsigned int  )13;
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



    if(ERROR)
	disp_message(ERR_MESG,"SELECT failed on table RD_EXAMINATION");

    d_exam_desc.arr[d_exam_desc.len]    = '\0';

}

get_status_desc()
{

    /* EXEC SQL SELECT STATUS_DESC
	           INTO :d_status_desc
	           FROM RD_STATUSES_LANG_VW
	           WHERE STATUS_CODE = :d_status
			   AND LANGUAGE_ID   = :p_language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 9;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select STATUS_DESC into :b0  from RD_STATUSES_LANG_VW whe\
re (STATUS_CODE=:b1 and LANGUAGE_ID=:b2)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )249;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_status_desc;
    sqlstm.sqhstl[0] = (unsigned int  )33;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_status;
    sqlstm.sqhstl[1] = (unsigned int  )5;
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



    if(ERROR)
	disp_message(ERR_MESG,"SELECT failed on table RD_STATUSES");

    d_status_desc.arr[d_status_desc.len]    = '\0';

}

get_status_desc1()
{

    /* EXEC SQL SELECT STATUS_DESC
	           INTO :nd_status_desc
	           FROM RD_STATUSES_LANG_VW
	           WHERE STATUS_CODE = :nd_status
			   AND   LANGUAGE_ID = :p_language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 9;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select STATUS_DESC into :b0  from RD_STATUSES_LANG_VW whe\
re (STATUS_CODE=:b1 and LANGUAGE_ID=:b2)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )276;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_status_desc;
    sqlstm.sqhstl[0] = (unsigned int  )302;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_status;
    sqlstm.sqhstl[1] = (unsigned int  )5;
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



    if(ERROR)
	disp_message(ERR_MESG,"SELECT failed on table RD_STATUSES 1");

    nd_status_desc.arr[nd_status_desc.len]    = '\0';

}

/*get_status_desc(stat,stat_desc)
char *stat,*stat_desc;
{
   if (strcmp(stat,"20") == 0)
      //strcpy(stat_desc,"Order Registered");
	  strcpy(stat_desc,loc_legend[29]);
   else if (strcmp(stat,"30") == 0)
      //strcpy(stat_desc,"Appointment Given");
	  strcpy(stat_desc,loc_legend[30]);
   else if (strcmp(stat,"40") == 0)
      //strcpy(stat_desc,"Exam Registered");
	  strcpy(stat_desc,loc_legend[31]);
   else if (strcmp(stat,"45") == 0)
      //strcpy(stat_desc,"Exam Started");
	  strcpy(stat_desc,loc_legend[32]);
   else if (strcmp(stat,"50") == 0)
      //strcpy(stat_desc,"Exam Completed");
	  strcpy(stat_desc,loc_legend[33]);
   else if (strcmp(stat,"60") == 0)
      //strcpy(stat_desc,"Result Reported");
	  strcpy(stat_desc,loc_legend[33]);
   else if (strcmp(stat,"70") == 0)
      //strcpy(stat_desc,"Result Authorized");
	  strcpy(stat_desc,loc_legend[34]);
   else if (strcmp(stat,"85") == 0)
      //strcpy(stat_desc,"Result Modified");
	  strcpy(stat_desc,loc_legend[35]);
   else if (strcmp(stat,"99") == 0)
      //strcpy(stat_desc,"Cancelled");
	  strcpy(stat_desc,loc_legend[36]);
	else if (strcmp(stat,"X") == 0)
      //strcpy(stat_desc,"All Reports");
	  strcpy(stat_desc,loc_legend[37]);
}
*/

get_patient_name()
{

    d_prv_patient_id.len = strlen(d_prv_patient_id.arr);

    /* EXEC SQL SELECT NVL(substr(SHORT_NAME_LOC_LANG,1,16), SHORT_NAME) PAT_NAME,
		    		TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY'),
		    		SEX
	       INTO :d_pat_name,
			    :d_dob,
			    :d_sex
	       FROM MP_PATIENT_MAST
	       WHERE PATIENT_ID = :d_prv_patient_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 9;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select NVL(substr(SHORT_NAME_LOC_LANG,1,16),SHORT_NAME) P\
AT_NAME ,TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY') ,SEX into :b0,:b1,:b2  from MP_PA\
TIENT_MAST where PATIENT_ID=:b3";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )303;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_pat_name;
    sqlstm.sqhstl[0] = (unsigned int  )183;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_dob;
    sqlstm.sqhstl[1] = (unsigned int  )13;
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
    sqlstm.sqhstv[3] = (         void  *)&d_prv_patient_id;
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



    d_pat_name.arr[d_pat_name.len]     = '\0';
    d_dob.arr[d_dob.len]               = '\0';
    d_sex.arr[d_sex.len]               = '\0';

     yrs= mths= days= imths= iyrs= idays= 0;
     /* EXEC SQL SELECT ABS(MONTHS_BETWEEN(SYSDATE,
                         TO_DATE(:d_dob,'DD/MM/YYYY')))
	      INTO   :mths
	      FROM   DUAL; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 9;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select ABS(MONTHS_BETWEEN(SYSDATE,TO_DATE(:b0,'DD/MM/YYY\
Y'))) into :b1  from DUAL ";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )334;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&d_dob;
     sqlstm.sqhstl[0] = (unsigned int  )13;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&mths;
     sqlstm.sqhstl[1] = (unsigned int  )sizeof(float);
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



     age[0] = '\0';

     if(mths > 1 && mths <= 24) {
         imths = mths;
         sprintf(age,"%dM",imths);
     }
     else {
       if(mths > 1) {
           yrs= days=0;
           imths = mths;
        
           if (imths > 0)
               yrs = (int)mths/12;
        
           iyrs = yrs;
           imths = imths - (iyrs * 12);
           
           days = (mths - (int)mths) * 31;
           idays = days;
       }
       else {
            /* EXEC SQL SELECT (SYSDATE - TO_DATE(:d_dob,'DD/MM/YYYY'))
	             INTO   :dys
	             FROM   DUAL; */ 

{
            struct sqlexd sqlstm;
            sqlstm.sqlvsn = 10;
            sqlstm.arrsiz = 9;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.stmt = "select (SYSDATE-TO_DATE(:b0,'DD/MM/YYYY')) into :\
b1  from DUAL ";
            sqlstm.iters = (unsigned int  )1;
            sqlstm.offset = (unsigned int  )357;
            sqlstm.selerr = (unsigned short)1;
            sqlstm.cud = sqlcud0;
            sqlstm.sqlest = (unsigned char  *)&sqlca;
            sqlstm.sqlety = (unsigned short)256;
            sqlstm.occurs = (unsigned int  )0;
            sqlstm.sqhstv[0] = (         void  *)&d_dob;
            sqlstm.sqhstl[0] = (unsigned int  )13;
            sqlstm.sqhsts[0] = (         int  )0;
            sqlstm.sqindv[0] = (         void  *)0;
            sqlstm.sqinds[0] = (         int  )0;
            sqlstm.sqharm[0] = (unsigned int  )0;
            sqlstm.sqadto[0] = (unsigned short )0;
            sqlstm.sqtdso[0] = (unsigned short )0;
            sqlstm.sqhstv[1] = (         void  *)&dys;
            sqlstm.sqhstl[1] = (unsigned int  )sizeof(float);
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


            idays = dys;
        }
    
        if(iyrs != 0)
            sprintf(age,"%dY",iyrs);
        else if(imths != 0)
            sprintf(age,"%dM",imths);
        else
            sprintf(age,"%dD",idays);
     }
}

get_physician_name()
{
    d_prv_physician_id.len = strlen(d_prv_physician_id.arr);

   /*EXEC SQL SELECT FULL_NAME
            INTO   :d_phys_name
			FROM   SY_PHYSICIAN_MAST
			WHERE  FACILITY_ID  = :nd_facility_id
			AND    PHYSICIAN_ID = :d_prv_physician_id;	  */

	/* EXEC SQL SELECT A.PRACTITIONER_NAME
            INTO   :d_phys_name
			FROM   AM_PRACTITIONER_LANG_VW A,AM_PRACT_FOR_FACILITY B
			WHERE  B.FACILITY_ID  = :nd_facility_id
			AND    A.PRACTITIONER_ID = :d_prv_physician_id
			AND    A.PRACTITIONER_ID = B.PRACTITIONER_ID
			AND    LANGUAGE_ID = :p_language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 9;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select A.PRACTITIONER_NAME into :b0  from AM_PRACTITIONER_LA\
NG_VW A ,AM_PRACT_FOR_FACILITY B where (((B.FACILITY_ID=:b1 and A.PRACTITIONER\
_ID=:b2) and A.PRACTITIONER_ID=B.PRACTITIONER_ID) and LANGUAGE_ID=:b3)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )380;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_phys_name;
 sqlstm.sqhstl[0] = (unsigned int  )93;
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
 sqlstm.sqhstv[2] = (         void  *)&d_prv_physician_id;
 sqlstm.sqhstl[2] = (unsigned int  )18;
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


				
    if(ERROR)
	disp_message(ERR_MESG,"SELECT failed on table SY_PHYSICIAN_MAST" );

    d_phys_name.arr[d_phys_name.len]  = '\0';

}

get_technician_name()
{

    d_prv_technician_id.len = strlen(d_prv_technician_id.arr);
   /* EXEC SQL SELECT SHORT_NAME
            INTO   :d_technician_name
			FROM   RD_TECHNICIAN
			WHERE  OPERATIONAL_FACILITY_ID = :nd_facility_id
			AND    TECHNICIAN_ID         = :d_prv_technician_id
			AND    LANGUAGE_ID           = :p_language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 9;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select SHORT_NAME into :b0  from RD_TECHNICIAN where ((OPE\
RATIONAL_FACILITY_ID=:b1 and TECHNICIAN_ID=:b2) and LANGUAGE_ID=:b3)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )411;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_technician_name;
   sqlstm.sqhstl[0] = (unsigned int  )47;
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
   sqlstm.sqhstv[2] = (         void  *)&d_prv_technician_id;
   sqlstm.sqhstl[2] = (unsigned int  )18;
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

	

    if(ERROR)
	disp_message(ERR_MESG,"SELECT failed on table RD_TECHNICIAN" );

    d_technician_name.arr[d_technician_name.len]  = '\0';
}

get_tech_id()
{

    d_technician_id_1.arr[0]  = '\0';
    d_technician_id_2.arr[0]  = '\0';
    d_technician_name_1.arr[0]  = '\0';
    d_technician_name_2.arr[0]  = '\0';

	/* EXEC  SQL 	SELECT PRACTITIONER_ID
	into d_technician_id_1
	FROM  RD_REQUEST_OTH_PERSONNEL
	WHERE  REQUEST_NUM = :d_request_num
    AND  REQUEST_LINE_NUM = :d_request_line_num
	AND  PRACT_TYPE = 'RT'
	AND ROWNUM = 1
	ORDER BY REQUEST_NUM, REQUEST_LINE_NUM ; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 9;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select PRACTITIONER_ID into :b0  from RD_REQUEST_OTH_PERSONN\
EL where (((REQUEST_NUM=:b1 and REQUEST_LINE_NUM=:b2) and PRACT_TYPE='RT') and\
 ROWNUM=1) order by REQUEST_NUM,REQUEST_LINE_NUM ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )442;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_technician_id_1;
 sqlstm.sqhstl[0] = (unsigned int  )18;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_request_num;
 sqlstm.sqhstl[1] = (unsigned int  )13;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_request_line_num;
 sqlstm.sqhstl[2] = (unsigned int  )6;
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




    /* EXEC SQL SELECT SHORT_NAME INTO :d_technician_name_1
	FROM RD_TECHNICIAN
	WHERE  TECHNICIAN_ID = :d_technician_id_1
	AND ROWNUM = 1
	AND LANGUAGE_ID = :p_language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 9;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select SHORT_NAME into :b0  from RD_TECHNICIAN where ((TE\
CHNICIAN_ID=:b1 and ROWNUM=1) and LANGUAGE_ID=:b2)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )469;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_technician_name_1;
    sqlstm.sqhstl[0] = (unsigned int  )18;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_technician_id_1;
    sqlstm.sqhstl[1] = (unsigned int  )18;
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




	/* EXEC  SQL 	SELECT PRACTITIONER_ID
	into d_technician_id_2
	FROM  RD_REQUEST_OTH_PERSONNEL
	WHERE  REQUEST_NUM = :d_request_num
    AND  REQUEST_LINE_NUM = :d_request_line_num
	AND  PRACT_TYPE = 'RT'
	AND  PRACTITIONER_ID !=  :d_technician_id_1
	ORDER BY REQUEST_NUM, REQUEST_LINE_NUM ; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 9;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select PRACTITIONER_ID into :b0  from RD_REQUEST_OTH_PERSONN\
EL where (((REQUEST_NUM=:b1 and REQUEST_LINE_NUM=:b2) and PRACT_TYPE='RT') and\
 PRACTITIONER_ID<>:b3) order by REQUEST_NUM,REQUEST_LINE_NUM ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )496;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_technician_id_2;
 sqlstm.sqhstl[0] = (unsigned int  )18;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_request_num;
 sqlstm.sqhstl[1] = (unsigned int  )13;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_request_line_num;
 sqlstm.sqhstl[2] = (unsigned int  )6;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_technician_id_1;
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
}




if(strlen(d_technician_id_2.arr)) 
    /* EXEC SQL SELECT ','||SHORT_NAME INTO :d_technician_name_2
	FROM RD_TECHNICIAN
	WHERE  TECHNICIAN_ID = :d_technician_id_2
	AND ROWNUM = 1
	AND LANGUAGE_ID = :p_language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 9;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select (','||SHORT_NAME) into :b0  from RD_TECHNICIAN whe\
re ((TECHNICIAN_ID=:b1 and ROWNUM=1) and LANGUAGE_ID=:b2)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )527;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_technician_name_2;
    sqlstm.sqhstl[0] = (unsigned int  )47;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_technician_id_2;
    sqlstm.sqhstl[1] = (unsigned int  )18;
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



    if(ERROR)
	disp_message(ERR_MESG,"SELECT failed on table RD_REQUEST_OTH_PERSONNEL1");

    d_technician_id_1.arr[d_technician_id_1.len]   = '\0';
    d_technician_name_1.arr[d_technician_name_1.len]   = '\0';

    d_technician_id_2.arr[d_technician_id_2.len]   = '\0';
    d_technician_name_2.arr[d_technician_name_2.len]   = '\0';

}



get_ref_source_desc()
{
    d_prv_ref_source_code.len = strlen(d_prv_ref_source_code.arr);

    /* EXEC SQL SELECT LONG_DESC
               INTO :d_ref_source_desc
	       FROM SY_REFERRAL_LANG_VW
	      WHERE REFERRAL_CODE = :d_prv_ref_source_code
		  AND   LANGUAGE_ID = :p_language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 9;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select LONG_DESC into :b0  from SY_REFERRAL_LANG_VW where\
 (REFERRAL_CODE=:b1 and LANGUAGE_ID=:b2)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )554;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_ref_source_desc;
    sqlstm.sqhstl[0] = (unsigned int  )303;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_prv_ref_source_code;
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



    if(ERROR)
	disp_message(ERR_MESG,"SELECT failed on table SY_REFERRAL");

    d_ref_source_desc.arr[d_ref_source_desc.len]   = '\0';

}

get_ip_dtls()
{

    d_prv_episode_id.len = strlen(d_prv_episode_id.arr);

   /* EXEC SQL SELECT CUR_WARD_CODE,
                   CUR_BED_NUM
              INTO :d_ward_no,
                   :d_bed_no
              FROM IP_EPISODE
             WHERE FACILITY_ID = :nd_facility_id 
			   AND EPISODE_ID  = :d_prv_episode_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 9;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select CUR_WARD_CODE ,CUR_BED_NUM into :b0,:b1  from IP_EP\
ISODE where (FACILITY_ID=:b2 and EPISODE_ID=:b3)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )581;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_ward_no;
   sqlstm.sqhstl[0] = (unsigned int  )7;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_bed_no;
   sqlstm.sqhstl[1] = (unsigned int  )11;
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
   sqlstm.sqhstv[3] = (         void  *)&d_prv_episode_id;
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



    if(ERROR)
	disp_message(ERR_MESG,"SELECT failed on table IP_EPISODE" );

    d_ward_no.arr[d_ward_no.len]  = '\0';
    d_bed_no.arr[d_bed_no.len]    = '\0';

}

decl_curs()
{

     /* EXEC SQL DECLARE RD_REQUEST_CUR CURSOR FOR
               SELECT B.EXAM_ROOM,
				      TO_CHAR(A.REQUEST_DATE, 'DD/MM/YYYY'),
				      A.REQUEST_NUM,
					  B.REQUEST_LINE_NUM,
				      B.EXAM_CODE,
				      A.ORDER_TYPE_CODE,
                      A.ORDER_ID,
                      A.PATIENT_ID,
                      A.EPISODE_TYPE,
                      A.EPISODE_ID,
                      A.TFR_VISIT_NUM,
				      A.REF_SOURCE_CODE,
				      A.PHYSICIAN_ID,
					 -- B.TECHNICIAN_ID,
				      B.STATUS
                 FROM RD_REQUEST A, 
				      RD_EXAM_VIEW_REQUESTED B
		        WHERE A.REQUEST_NUM  = B.REQUEST_NUM
				AND	  A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID
				AND	  A.OPERATING_FACILITY_ID = :nd_facility_id 
				AND	  B.SECTION_CODE		  = :nd_section_code
				AND   A.WING_CODE             = :nd_wing_code
                AND	  REQUEST_DATE >=
						TO_DATE(NVL(:nd_fm_date,'01/01/1800'),'DD/MM/YYYY')
                AND	  REQUEST_DATE <
						TO_DATE(NVL(:nd_to_date,'01/01/3000'),'DD/MM/YYYY')+1
                AND   NVL(A.STATUS,'!!') <> '99' 
				AND   (B.STATUS = decode(:nd_status, 'X' , B.STATUS, :nd_status)
				 OR    B.STATUS = decode(:nd_status, '70', '80', 'X'))
			 ORDER BY B.EXAM_ROOM, TO_CHAR(A.REQUEST_DATE,'YYYYMMDDHH24MI'),
					  A.REQUEST_NUM; */ 




/*     EXEC SQL DECLARE RD_REQUEST_CUR CURSOR FOR
               SELECT C.CLINIC_CODE,
				      TO_CHAR(A.REQUEST_DATE, 'DD/MM/YYYY'),
				      A.REQUEST_NUM,
				      B.EXAM_CODE,
				      A.ORDER_TYPE_CODE,
                      A.ORDER_ID,
                      A.PATIENT_ID,
                      A.EPISODE_TYPE,
                      A.EPISODE_ID,
                      A.TFR_VISIT_NUM,
				      A.REF_SOURCE_CODE,
				      A.PHYSICIAN_ID,
				      B.STATUS
                 FROM RD_REQUEST A, 
				      RD_EXAM_VIEW_REQUESTED B,
				      RD_EXAMINATION C ,
					  RD_CLINIC  E 
//					  RD_EXAMS_FOR_CLINIC D   
		        WHERE A.REQUEST_NUM  = B.REQUEST_NUM
				AND B.EXAM_CODE    = C.EXAM_CODE
				AND	A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID
				AND	A.OPERATING_FACILITY_ID = E.OPERATING_FACILITY_ID
				AND	A.OPERATING_FACILITY_ID = :nd_facility_id 
				AND A.SECTION_CODE = :nd_section_code
			    AND A.SECTION_CODE = E.SECTION_CODE 
			    AND A.WING_CODE    = E.WING_CODE
			    AND A.WING_CODE    = :nd_wing_code
	//		  AND A.CLINIC_CODE  = E.CLINIC_CODE
	//		  AND D.EXAM_CODE    = C.EXAM_CODE  
	//		  AND D.CLINIC_CODE   = NVL(:nd_room_code,D.CLINIC_CODE)
					  AND REQUEST_DATE >=
				 TO_DATE(NVL(:nd_fm_date,'01/01/1800'),'DD/MM/YYYY')
					  AND REQUEST_DATE <
				 TO_DATE(NVL(:nd_to_date,'01/01/3000'),'DD/MM/YYYY')+1
	     ORDER BY C.CLINIC_CODE,
		      TO_CHAR(A.REQUEST_DATE,'YYYYMMDDHH24MI'),
		      A.REQUEST_NUM;
*/
}

fetch_req_dtls()
{

    d_clinic_code.arr[0]      = '\0';
    d_request_date.arr[0]     = '\0';
    d_request_num.arr[0]      = '\0';
    d_request_line_num.arr[0] = '\0';
    d_exam_code.arr[0]        = '\0';
    d_order_type_code.arr[0]  = '\0';
    d_order_id.arr[0]         = '\0';
    d_patient_id.arr[0]       = '\0';
    d_episode_type.arr[0]     = '\0';
    d_episode_id.arr[0]       = '\0';
    d_visit_id.arr[0]         = '\0';
    d_ref_source_code.arr[0]  = '\0';
    d_physician_id.arr[0]     = '\0';
//    d_technician_id.arr[0]    = '\0';
    d_status.arr[0]           = '\0';

    d_clinic_code.len         = 0;
    d_request_date.len        = 0;
    d_request_num.len         = 0;
    d_request_line_num.len    = 0;
    d_exam_code.len           = 0;
    d_order_type_code.len     = 0;
    d_order_id.len            = 0;
    d_patient_id.len          = 0;
    d_episode_type.len        = 0;
    d_episode_id.len          = 0;
    d_visit_id.len            = 0;
    d_ref_source_code.len     = 0;
    d_physician_id.len        = 0;
//	d_technician_id.len       = 0;
    d_status.len              = 0;

    /* EXEC SQL FETCH RD_REQUEST_CUR 
		      INTO :d_clinic_code,
                   :d_request_date,
                   :d_request_num,
                   :d_request_line_num,
                   :d_exam_code,
                   :d_order_type_code,
                   :d_order_id,
                   :d_patient_id,
                   :d_episode_type,
                   :d_episode_id,
                   :d_visit_id,
                   :d_ref_source_code,
                   :d_physician_id,
//				   :d_technician_id,
                   :d_status; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 14;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )612;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_clinic_code;
    sqlstm.sqhstl[0] = (unsigned int  )7;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_request_date;
    sqlstm.sqhstl[1] = (unsigned int  )23;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_request_num;
    sqlstm.sqhstl[2] = (unsigned int  )13;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_request_line_num;
    sqlstm.sqhstl[3] = (unsigned int  )6;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_exam_code;
    sqlstm.sqhstl[4] = (unsigned int  )13;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_order_type_code;
    sqlstm.sqhstl[5] = (unsigned int  )6;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_order_id;
    sqlstm.sqhstl[6] = (unsigned int  )18;
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
    sqlstm.sqhstv[8] = (         void  *)&d_episode_type;
    sqlstm.sqhstl[8] = (unsigned int  )4;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&d_episode_id;
    sqlstm.sqhstl[9] = (unsigned int  )15;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&d_visit_id;
    sqlstm.sqhstl[10] = (unsigned int  )9;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&d_ref_source_code;
    sqlstm.sqhstl[11] = (unsigned int  )7;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&d_physician_id;
    sqlstm.sqhstl[12] = (unsigned int  )18;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&d_status;
    sqlstm.sqhstl[13] = (unsigned int  )5;
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



    if(ERROR)
	disp_message(ERR_MESG,"FETCH failed on cursor V" );

    if(NO_DATA_FOUND)
	return 0;

    d_clinic_code.arr[d_clinic_code.len]           = '\0';
    d_request_date.arr[d_request_date.len]         = '\0';
    d_request_num.arr[d_request_num.len]           = '\0';
    d_request_line_num.arr[d_request_line_num.len] = '\0';
    d_exam_code.arr[d_exam_code.len]               = '\0';
    d_order_type_code.arr[d_order_type_code.len]   = '\0';
    d_order_id.arr[d_order_id.len]                 = '\0';
    d_patient_id.arr[d_patient_id.len]             = '\0';
    d_episode_type.arr[d_episode_type.len]         = '\0';
    d_episode_id.arr[d_episode_id.len]             = '\0';
    d_visit_id.arr[d_visit_id.len]                 = '\0';
    d_ref_source_code.arr[d_ref_source_code.len]   = '\0';
    d_physician_id.arr[d_physician_id.len]         = '\0';
//	d_technician_id.arr[d_technician_id.len]       = '\0';
    d_status.arr[d_status.len]                     = '\0';

    return 1;
}


do_report()
{
    int first;
    int cnt;
//	int desc_len;

    put_hdr();

    /* EXEC SQL OPEN RD_REQUEST_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 14;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0022;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )683;
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
    sqlstm.sqhstv[1] = (         void  *)&nd_section_code;
    sqlstm.sqhstl[1] = (unsigned int  )7;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_wing_code;
    sqlstm.sqhstl[2] = (unsigned int  )4;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_fm_date;
    sqlstm.sqhstl[3] = (unsigned int  )23;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_to_date;
    sqlstm.sqhstl[4] = (unsigned int  )23;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_status;
    sqlstm.sqhstl[5] = (unsigned int  )5;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_status;
    sqlstm.sqhstl[6] = (unsigned int  )5;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_status;
    sqlstm.sqhstl[7] = (unsigned int  )5;
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


    if(ERROR)
	disp_message(ERR_MESG,"OPEN failed on cursor RD_REQUEST_CUR" );

    d_prv_clinic_code.arr[0] = '\0';
    cnt = 0;
    first = 1;

    g_room_tot = 0;
    g_section_tot = 0;


    while(fetch_req_dtls()) {

	if(strcmp(d_prv_clinic_code.arr, d_clinic_code.arr)) {

	    if(!first) {
		print_other_dtls();
		print_subtot();
	    }
	    chk_break(1);
		get_wing_desc();
	    get_room_desc();
	//	fprintf(f1,"Wing         : %-30s\n\n",h_wing_desc.arr);
	    //fprintf(f1,"Room : %s\n", d_room_desc.arr);
		fprintf(f1,"%s : %s\n", loc_legend[28],d_room_desc.arr);
		
		desc_len = strlen(d_room_desc.arr) + 7;
		print_line('-', desc_len); 
		
		line_no += 2;

	    copy_dtls();
	    cnt = 0;
	    g_room_tot = 0;

	}

//	copy_dtls();

	if(strcmp(d_prv_request_num.arr, d_request_num.arr)) {
	    print_other_dtls();
	    copy_dtls();
	    cnt = 0;
	}

	get_exam_desc();
	get_patient_name();
//    get_status_desc(d_status.arr,d_status_desc.arr);
    get_status_desc();
	get_technician_name();

	get_tech_id();
	chk_break(1);

	init_date_temp_var();
	strcpy ( date_convert.arr, d_request_date.arr );
	time_flag = 0;
    fun_change_loc_date();
	strcpy ( d_request_date.arr, date_convert.arr );

	if(cnt == 0)
	    fprintf(f1,"%-10s %-30.30s %-10s %-30s %-17s %s%-s\n",
	        d_request_date.arr,
	        d_pat_name.arr,
	        d_exam_code.arr,
	        d_exam_desc.arr,
	        d_status_desc.arr,
			d_technician_name_1.arr, d_technician_name_2.arr);
	else
	    fprintf(f1,"%-10s %-30.30s %-10s %-30s %-17s %s%-s\n",
	        "",
	        "",
	        d_exam_code.arr,
	        d_exam_desc.arr,
	        d_status_desc.arr,
			d_technician_name_1.arr, d_technician_name_2.arr);



	line_no ++;
	cnt = 1;
	first = 0;
	g_room_tot ++;
        strcpy(d_prv_clinic_code.arr, d_clinic_code.arr);
        strcpy(d_prv_request_num.arr, d_request_num.arr);
    }

    if(!first) {
	print_other_dtls();
	print_section_tot();
    }
}

print_other_dtls()
{
    chk_break(1);
    d_ward_no.arr[0]  = '\0';
    d_bed_no.arr[0]   = '\0';
    if(d_prv_episode_type.arr[0] == 'I')
	get_ip_dtls();
    get_physician_name();
    if(strlen(d_prv_ref_source_code.arr) && !strlen(d_phys_name.arr))
		get_ref_source_desc();
	    fprintf(f1,"%-10s %-20s%2s/%-8s%-4s/%-15.15s %1s/%-12s/%-6s %-4s/%-11s %-30s \n\n",
	    d_prv_request_num.arr,
	    d_prv_patient_id.arr,
	    d_sex.arr,
        age,
	    d_prv_order_type_code.arr,
	    d_prv_order_id.arr,
	    d_prv_episode_type.arr,
	    d_prv_episode_id.arr,
	    d_prv_visit_id.arr,
	    d_ward_no.arr,
	    d_bed_no.arr,
	    strlen(d_phys_name.arr)? d_phys_name.arr:d_ref_source_desc.arr);
    line_no += 2;
}

print_subtot()
{
    chk_break(1);
    //fprintf(f1,"ROOM TOTAL : %ld\n", g_room_tot);
	fprintf(f1,"%s : %ld\n", loc_legend[26],g_room_tot);
    fprintf(f1,"%s\n",hdr_line5);
    line_no += 2;
    g_section_tot += g_room_tot;
}

print_section_tot()
{
    print_subtot();
    chk_break(1);
    //fprintf(f1,"SECTION TOTAL : %ld\n", g_section_tot);
	fprintf(f1,"%s : %ld\n", loc_legend[27],g_section_tot);
	fprintf(f1,"%s\n",hdr_line5);
    line_no += 2;
}

copy_dtls()
{

    strcpy(d_prv_clinic_code.arr, d_clinic_code.arr);
    strcpy(d_prv_request_num.arr, d_request_num.arr);
    strcpy(d_prv_order_type_code.arr, d_order_type_code.arr);
    strcpy(d_prv_order_id.arr, d_order_id.arr);
    strcpy(d_prv_patient_id.arr, d_patient_id.arr);
    strcpy(d_prv_episode_type.arr, d_episode_type.arr);
    strcpy(d_prv_episode_id.arr, d_episode_id.arr);
    strcpy(d_prv_visit_id.arr, d_visit_id.arr);
    strcpy(d_prv_ref_source_code.arr, d_ref_source_code.arr);
    strcpy(d_prv_physician_id.arr, d_physician_id.arr);
	strcpy(d_prv_technician_id.arr,d_technician_id.arr);
    strcpy(d_prv_status.arr, d_status.arr);

}

put_inp_parm()
{
	int i;

	form_hdr();
	fprintf(f1,VER);

	temp_nd_fm_date.arr[0] = '\0';
	temp_nd_fm_date.len = 0;

	temp_nd_to_date.arr[0] = '\0';
	temp_nd_to_date.len = 0;


	if (strcmp(nd_fm_date.arr,"01/01/1800")==0)
		strcpy ( temp_nd_fm_date.arr, loc_legend[4] );
	else
	{
		init_date_temp_var();
		strcpy ( date_convert.arr, nd_fm_date.arr );
		time_flag = 0;
		fun_change_loc_date();
		strcpy ( temp_nd_fm_date.arr, date_convert.arr );
    }

	if (strcmp(nd_to_date.arr,"31/12/4712")==0)
		strcpy ( temp_nd_to_date.arr, loc_legend[5] );
	else
	{
	    init_date_temp_var();
		strcpy ( date_convert.arr, nd_to_date.arr );
		time_flag = 0;
		fun_change_loc_date();
		strcpy ( temp_nd_to_date.arr, date_convert.arr );
    }

	fprintf(f1,"\n\n\n\n");
  //fprintf(f1,"\t\t\t\tINPUT PARAMETERS :\n");
	fprintf(f1,"\t\t\t\t%s :\n",loc_legend[7]);
	fprintf(f1,"\t\t\t\t------------------\n\n");
  //fprintf(f1,"\t\t\t\t\tWING CODE             : %s\n\n", nd_wing_code.arr);
	fprintf(f1,"\t\t\t\t\t%-30s: %s\n\n",loc_legend[8], nd_wing_code.arr);
  //fprintf(f1,"\t\t\t\t\tSECTION CODE          : %-4s\n\n",nd_section_code.arr);
	fprintf(f1,"\t\t\t\t\t%-30s: %-4s\n\n",loc_legend[9],nd_section_code.arr);
	/*       fprintf(f1,"\t\tROOM CODE             : %-4s\n\n",nd_room_code.arr); */
    /*fprintf(f1,"\t\tPERIOD          FROM  : %-13s\n\n",nd_fm_date.arr);*/
  //fprintf(f1,"\t\t\t\t\tPERIOD          FROM  : %-13s\n\n",(strcmp(nd_fm_date.arr,"01/01/1800")==0)?"LOWEST":nd_fm_date.arr);
	fprintf(f1,"\t\t\t\t\t%-22s %-7s: %-13s\n\n",loc_legend[10],loc_legend[2],temp_nd_fm_date.arr);
	/*fprintf(f1,"\t\t\t\t\t                TO  : %-13s\n\n",nd_to_date.arr);*/
	fprintf(f1,"\t\t\t\t\t%-22s %-7s: %-13s\n\n","",loc_legend[3],temp_nd_to_date.arr);
	
	//fprintf(f1,"\t\t\t\t\t            STATUS    : ");
	fprintf(f1,"\t\t\t\t\t%-30s: ",loc_legend[11]);
	
	if (strcmp(nd_status.arr, "X")==0)
		//strcpy(nd_status_desc.arr, "ALL");
		strcpy(nd_status_desc.arr, loc_legend[39]);
	else
		get_status_desc1(nd_status.arr, nd_status_desc.arr);

	
	for(i=0; i<strlen(nd_status_desc.arr); i++)
	{
		if (nd_status_desc.arr[i] == '\0') {
			break;
		}
		else {
				fprintf(f1,"%c", toupper(nd_status_desc.arr[i]));
		}
	}
	
	fprintf(f1,"\n\n"); fprintf(f1,"\f");

}

print_end_of_rep()
{
    chk_break(1);
	fprintf(f1,"\n");
	horz_skip(42);
	//fprintf(f1,"*****   End of Report   *****");
	fprintf(f1,"*****   %s   *****",loc_legend[25]);
	fprintf(f1,"%cE",ESC); /*for resetting to default mode by 
							  rvNambiar on 26/Aug/2003 */
}


put_hdr()
{
    form_hdr();
    //fprintf(f1,"Regn Date  Patient Name                   Exam Code and Description                 Status            Technologist(s)  \n");
	fprintf(f1,"%-11s%-31s%-42s%-18s%-16s\n",loc_legend[14],loc_legend[15],loc_legend[16],loc_legend[11],loc_legend[17]);
    //fprintf(f1,"Regn. No.  Patient ID          Sex/Age    Order Type/No         Episode/Visit         Ward/Bed No.    Referral Doctor/Source\n");
	fprintf(f1,"%-11s%-20s%-11s%-22s%-22s%-16s%-21s\n",loc_legend[18],loc_legend[19],loc_legend[20],loc_legend[21],loc_legend[22],loc_legend[23],loc_legend[24]);
  	print_line('-',REP_WIDTH);	            
	fprintf(f1,"\n");
    line_no=10;
}

form_hdr()
{
    static int first = 1;
    char buf[15];
    int col;

	int hosp_nm_len, rep_title_len = 10, s1, s2;
	char v_rep_title[200];
	
	fprintf(f1,"MDL : RD");
	hosp_nm_len  =  comp_name.len;
	s1 = (REP_WIDTH-hosp_nm_len)/2;
	horz_skip(s1-8);
	fprintf(f1,"%s", comp_name.arr);
	s2 = (REP_WIDTH-s1-hosp_nm_len);
	horz_skip(s2-16);

    init_date_temp_var();
	strcpy(date_convert.arr,rep_date.arr);
	time_flag = 1;
    fun_change_loc_date();
	//fprintf(f1,"%s", rep_date.arr);
	fprintf(f1,"%s", date_convert.arr);
    
	fprintf(f1,"\n"); fprintf(f1,"OPR : %s", oper_id.arr); fprintf(f1,"\n");
	
	fprintf(f1,"REP : %s",nd_pgm_id.arr);

	//strcpy(v_rep_title,REP_TITLE);
	strcpy(v_rep_title,loc_legend[1]);
	rep_title_len = strlen(v_rep_title);
	s1 = (REP_WIDTH-rep_title_len)/2;
	horz_skip(s1-14);

	//fprintf(f1,"%s",REP_TITLE);
	fprintf(f1,"%s",v_rep_title);
	s2 = (REP_WIDTH-s1-rep_title_len);
	horz_skip(s2-10);
	//fprintf(f1,"PAGE :%4d\n",++page_no);
	fprintf(f1,"%s :%4d\n",loc_legend[6],++page_no);
    
	horz_skip(50);

	temp_nd_fm_date.arr[0] = '\0';
	temp_nd_fm_date.len = 0;

	temp_nd_to_date.arr[0] = '\0';
	temp_nd_to_date.len = 0;

	if (strcmp(nd_fm_date.arr,"01/01/1800")==0)
		strcpy ( temp_nd_fm_date.arr, loc_legend[4] );
	else
	{
		init_date_temp_var();
		strcpy ( date_convert.arr, nd_fm_date.arr );
		time_flag = 0;
		fun_change_loc_date();
		strcpy ( temp_nd_fm_date.arr , date_convert.arr );
    }

	if (strcmp(nd_to_date.arr,"31/12/4712")==0)
		strcpy ( temp_nd_to_date.arr, loc_legend[5] );
	else
	{
	    init_date_temp_var();
		strcpy ( date_convert.arr, nd_to_date.arr );
		time_flag = 0;
		fun_change_loc_date();
		strcpy ( temp_nd_to_date.arr, date_convert.arr );
    }

	//fprintf(f1,"FROM : %-10s",(strcmp(nd_fm_date.arr,"01/01/1800")==0)?"LOWEST":nd_fm_date.arr);
	fprintf(f1,"%-5s: %-10s",loc_legend[2],temp_nd_fm_date.arr);
	//fprintf(f1,"  TO : %-10s\n",(strcmp(nd_to_date.arr,"31/12/4712")==0)?"HIGHEST":nd_to_date.arr);
	fprintf(f1,"%5s: %-10s\n",loc_legend[3],temp_nd_to_date.arr);
		
	if (first == 0) {
		get_wing_desc();
		//fprintf(f1,"WING:  %-30s     SECTION :  %s\n",h_wing_desc.arr,d_section_desc.arr);
		fprintf(f1,"%s:  %-34s %-s :  %s\n",loc_legend[12],h_wing_desc.arr,loc_legend[13],d_section_desc.arr);
    }
	first = 0;
	
	print_line('-',REP_WIDTH);
		
}

fetch_sys_info()
{

    /* EXEC SQL SELECT upper(ACC_ENTITY_NAME),
				    TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
                    USER 
		     INTO   :comp_name,
				    :rep_date,
				    :oper_id
		     FROM   SY_ACC_ENTITY_LANG_VW
			 WHERE  ACC_ENTITY_ID = :nd_facility_id
			 AND    LANGUAGE_ID = :p_language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 14;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select upper(ACC_ENTITY_NAME) ,TO_CHAR(SYSDATE,'DD/MM/YYY\
Y HH24:MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY_LANG_VW where (ACC_ENTI\
TY_ID=:b3 and LANGUAGE_ID=:b4)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )730;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&comp_name;
    sqlstm.sqhstl[0] = (unsigned int  )303;
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



    if(ERROR)
	    disp_message(ERR_MESG,"SELECT failed on table  SY_ACC_ENTITY");

    comp_name.arr[comp_name.len] = '\0';
    rep_date.arr[rep_date.len] = '\0';
    oper_id.arr[oper_id.len] = '\0';
}

chk_break(nol)
int nol;
{
    if(line_no+nol >= MAX_LINES) {
       line_no = 1;
	   g_count = 1;
	   fprintf(f1,"\f");
	   put_hdr();
   	   //fprintf(f1,"Room : %s\n", d_room_desc.arr);
	   fprintf(f1,"%s : %s\n", loc_legend[28], d_room_desc.arr);
	   desc_len = strlen(d_room_desc.arr) + 7;
	   print_line('-', desc_len); 
		
	   line_no += 3;
	}

}

print_line(ch,n) /* this is to obtain required characters */
  char ch;
  int n;
{
	int i;
	for(i=0;i<n;i++)
	fprintf(f1,"%c",ch);  fprintf(f1,"\n");
}

horz_skip(num) /* this is to obtain required blank space */
int num;
{
	int i;
	for(i=0;i<num;i++)fprintf(f1," ");
}

print_formated(s_amt, l_amt)
double l_amt;
char *s_amt;
{

    if(l_amt < 0){
       /* put_val(s_amt,-l_amt);
        put_comma(s_amt); */
        strcat(s_amt,"-");
    }
    else {
      /*  put_val(s_amt,l_amt);
        put_comma(s_amt); */
        strcat(s_amt," ");
    }
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
nd_temp_date.arr[nd_temp_date.len]='\0';

get_local_date();

strcpy(date_convert.arr,nd_loc_date.arr); 

}

get_local_date()
{


	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;

	
	BEGIN
	  
       	get_locale_date.CONVERT_TO_LOCALE_DATE(to_date(:nd_temp_date,'DD/MM/YYYY HH24:MI'),:p_language_id,t_date);

		IF :time_flag = 1 THEN
		   :nd_loc_date := to_char(t_date,'DD/MM/YYYY HH24:MI');
		   :time_flag := 0;
		ELSE

	       :nd_loc_date := to_char(t_date,'DD/MM/YYYY');

		END IF;
	

	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . CONVERT_TO_LOC\
ALE_DATE ( to_date ( :nd_temp_date , 'DD/MM/YYYY HH24:MI' ) , :p_language_id ,\
 t_date ) ; IF :time_flag = 1 THEN :nd_loc_date := to_char ( t_date , 'DD/MM/Y\
YYY HH24:MI' ) ; :time_flag := 0 ; ELSE :nd_loc_date := to_char ( t_date , 'DD\
/MM/YYYY' ) ; END IF ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )765;
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
 sqlstm.sqhstv[2] = (         void  *)&time_flag;
 sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_loc_date;
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



		nd_loc_date.arr[nd_loc_date.len]='\0';		     

		if (OERROR)
		disp_message(ERR_MESG,"Date conversion failed...\n");
        //err_mesg("SELECTING Date failed",0,"");

}

fetch_legend_value()
{
	
	int i=0;
	/* EXEC SQL EXECUTE
	BEGIN	      
  	   sm_populate_report_legend.fetch_legend(:nd_facility_id,:p_language_id,'RDREXREG.LEGEND_');
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin sm_populate_report_legend . fetch_legend ( :nd_facilit\
y_id , :p_language_id , 'RDREXREG.LEGEND_' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )796;
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
 sqlstm.sqhstv[1] = (         void  *)&p_language_id;
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





	for (i=1; i<=100; i++)
	{

	l_translated_value.arr[0]		= '\0';
	
	/* EXEC SQL EXECUTE
	BEGIN
       :l_translated_value := GET_LEGEND(LTRIM(RTRIM('RDREXREG.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009'))))));
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin :l_translated_value := GET_LEGEND ( LTRIM ( RTRIM ( 'R\
DREXREG.LEGEND_' || LTRIM ( RTRIM ( TO_CHAR ( :i , '009' ) ) ) ) ) ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )819;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_translated_value;
 sqlstm.sqhstl[0] = (unsigned int  )202;
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

	//disp_message(ERR_MESG,l_translated_value.arr);

	strcpy(loc_legend[i],l_translated_value.arr);

	}

}
