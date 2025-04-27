
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
    "T:\\temp\\Finance\\AR_VALID.PC"
};


static unsigned long sqlctx = 1862132747;


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
"select NVL(STATUS,'X') ,NVL(AR_VALID_FLAG,'X') ,NVL(DOC_PRINT_FLAG,'X')  fro\
m GL_ACC_ENTITY_DOC_TYPE_VW where DOC_TYPE_CODE=:b0           ";

 static const char *sq0007 = 
"select NVL(STATUS,'X')  from SY_DOC_TYPE_MASTER where DOC_TYPE_CODE=:b0     \
      ";

 static const char *sq0001 = 
"select TRN_TYPE_CODE  from AR_TRN_DOC_TYPE where DOC_TYPE_CODE=:b0          \
 ";

 static const char *sq0002 = 
"select 'X'  from SY_DOC_CONTROL where (DOC_TYPE_CODE=:b0 and DOC_NUM=:b1)   \
        ";

 static const char *sq0003 = 
"select NVL(STATUS,'X') ,PATIENT_FLAG  from AR_CUSTOMER where CUST_CODE=:b0  \
         ";

 static const char *sq0004 = 
"select NVL(STATUS,'X')  from AR_PMNT_TERMS where PMNT_TERMS_CODE=:b0        \
   ";

 static const char *sq0008 = 
"select NVL(STATUS,'X')  from BL_BLNG_GRP where BLNG_GRP_ID=:b0           ";

 static const char *sq0005 = 
"select NVL(PENDING_AMT,0)  from AR_PENDING_DOC where ((CUST_CODE=:b0 and DOC\
_TYPE_CODE=:b1) and DOC_NUM=:b2)           ";

 static const char *sq0010 = 
"select DOC_TYPE_CODE ,DOC_NUM ,PATIENT_ID ,INV_DOC_TYPE_CODE ,INV_DOC_NUM ,B\
ILL_DOC_TYPE_CODE ,BILL_NUM ,TO_CHAR(BILL_DATE,'YYYYMMDD') ,NVL(AMOUNT,0) ,ABS\
(nvl(AMOUNT,0)) ,ROWID  from AR_PATIENT_ALLOC_DTLS where (DOC_TYPE_CODE=:b0 an\
d DOC_NUM=:b1) order by DOC_TYPE_CODE,DOC_NUM            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,6,138,0,9,235,0,0,1,1,0,1,0,1,9,0,0,
24,0,0,6,0,0,13,247,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
51,0,0,7,82,0,9,276,0,0,1,1,0,1,0,1,9,0,0,
70,0,0,7,0,0,13,284,0,0,1,0,0,1,0,2,9,0,0,
89,0,0,1,77,0,9,297,0,0,1,1,0,1,0,1,9,0,0,
108,0,0,1,0,0,13,305,0,0,1,0,0,1,0,2,9,0,0,
127,0,0,2,84,0,9,320,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
150,0,0,2,0,0,13,325,0,0,1,0,0,1,0,2,9,0,0,
169,0,0,3,85,0,9,392,0,0,1,1,0,1,0,1,9,0,0,
188,0,0,3,0,0,13,403,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
211,0,0,10,0,0,13,452,0,0,11,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,9,0,0,
270,0,0,4,79,0,9,627,0,0,1,1,0,1,0,1,9,0,0,
289,0,0,4,0,0,13,635,0,0,1,0,0,1,0,2,9,0,0,
308,0,0,6,138,0,9,722,0,0,1,1,0,1,0,1,9,0,0,
327,0,0,6,0,0,13,735,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
354,0,0,7,82,0,9,756,0,0,1,1,0,1,0,1,9,0,0,
373,0,0,7,0,0,13,764,0,0,1,0,0,1,0,2,9,0,0,
392,0,0,8,73,0,9,788,0,0,1,1,0,1,0,1,9,0,0,
411,0,0,8,0,0,13,793,0,0,1,0,0,1,0,2,9,0,0,
430,0,0,5,119,0,9,839,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
457,0,0,5,0,0,13,844,0,0,1,0,0,1,0,2,4,0,0,
476,0,0,10,289,0,9,873,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
499,0,0,11,139,0,4,879,0,0,5,4,0,1,0,2,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
};


#include <stdio.h>
#include <math.h>
    
extern long atol();
                  
#define ERROR (sqlca.sqlcode < 0)

#define LAST_ROW (sqlca.sqlcode == 1403)

#define NOT_FOUND (sqlca.sqlerrd[2] == 0)

#define TABLE_ALREADY_EXISTS (sqlca.sqlcode == -955)
/*
#define DEBUG 0
*/

# define abs(x)			(x>=0 ? x : -(x))

/* EXEC SQL BEGIN DECLARE SECTION; */ 


/* VARCHAR     l_ar_hdr_doc_type_code                [7], 
            l_ar_hdr_doc_num                      [9],
            l_ar_hdr_cust_code                    [9],

            l_ar_chk_doc_type_code                [7], 

            l_ar_ihdr_doc_type_code              [7],
            l_ar_ihdr_doc_num                    [9],
            l_ar_ihdr_org_doc_type_code          [7],
            l_ar_ihdr_org_doc_num                [9],
            l_ar_ihdr_cust_code                  [8],

            l_ar_ihdr_patient_id                 [21],
            l_ar_ihdr_billing_group              [3],
            l_ar_ihdr_bill_doc_type_code         [7],
            l_ar_ihdr_pmnt_terms_code            [3],

            l_ar_trn_type_code            [3],
            l_ar_acc_status               [2],
            l_ar_acc_valid_flag           [2],
            l_customer_status             [2],
            l_customer_patient_flag       [2],
            l_pmnt_terms_status           [2],
            l_bl_blng_grp_status          [2],
            l_mast_status                 [2],
            l_sy_doc_print_flag           [3],

			l_ar_flag   [2],
			l_consolidated_yn             [2],

            l_dummy                       [10][10]; */ 
struct { unsigned short len; unsigned char arr[7]; } l_ar_hdr_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } l_ar_hdr_doc_num;

struct { unsigned short len; unsigned char arr[9]; } l_ar_hdr_cust_code;

struct { unsigned short len; unsigned char arr[7]; } l_ar_chk_doc_type_code;

struct { unsigned short len; unsigned char arr[7]; } l_ar_ihdr_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } l_ar_ihdr_doc_num;

struct { unsigned short len; unsigned char arr[7]; } l_ar_ihdr_org_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } l_ar_ihdr_org_doc_num;

struct { unsigned short len; unsigned char arr[8]; } l_ar_ihdr_cust_code;

struct { unsigned short len; unsigned char arr[21]; } l_ar_ihdr_patient_id;

struct { unsigned short len; unsigned char arr[3]; } l_ar_ihdr_billing_group;

struct { unsigned short len; unsigned char arr[7]; } l_ar_ihdr_bill_doc_type_code;

struct { unsigned short len; unsigned char arr[3]; } l_ar_ihdr_pmnt_terms_code;

struct { unsigned short len; unsigned char arr[3]; } l_ar_trn_type_code;

struct { unsigned short len; unsigned char arr[2]; } l_ar_acc_status;

struct { unsigned short len; unsigned char arr[2]; } l_ar_acc_valid_flag;

struct { unsigned short len; unsigned char arr[2]; } l_customer_status;

struct { unsigned short len; unsigned char arr[2]; } l_customer_patient_flag;

struct { unsigned short len; unsigned char arr[2]; } l_pmnt_terms_status;

struct { unsigned short len; unsigned char arr[2]; } l_bl_blng_grp_status;

struct { unsigned short len; unsigned char arr[2]; } l_mast_status;

struct { unsigned short len; unsigned char arr[3]; } l_sy_doc_print_flag;

struct { unsigned short len; unsigned char arr[2]; } l_ar_flag;

struct { unsigned short len; unsigned char arr[2]; } l_consolidated_yn;

struct { unsigned short len; unsigned char arr[10]; } l_dummy[10];


/* VARCHAR    ar_pat_doc_type_code          [7],
           ar_pat_doc_num                [9],
           ar_pat_patient_id             [21],
           ar_pat_bill_doc_type_code     [7],
           ar_pat_bill_num               [9],
           ar_pat_inv_doc_type_code          [7],
           ar_pat_inv_doc_num                [9],
           ar_pat_bill_date              [12],
           ar_pat_rowid                  [31]; */ 
struct { unsigned short len; unsigned char arr[7]; } ar_pat_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } ar_pat_doc_num;

struct { unsigned short len; unsigned char arr[21]; } ar_pat_patient_id;

struct { unsigned short len; unsigned char arr[7]; } ar_pat_bill_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } ar_pat_bill_num;

struct { unsigned short len; unsigned char arr[7]; } ar_pat_inv_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } ar_pat_inv_doc_num;

struct { unsigned short len; unsigned char arr[12]; } ar_pat_bill_date;

struct { unsigned short len; unsigned char arr[31]; } ar_pat_rowid;



double      d_ar_pending_amt;

double      ar_pat_amount,
            ar_pat_tot_amt,
			ar_pat_abs_tot_amount ,
			ar_pat_abs_amount,
			pending_amt;


/* EXEC SQL END DECLARE SECTION; */ 


/* EXEC SQL INCLUDE SQLCA;
 */ 
/*
 * $Header:   E:/MEDICOM-MASTER/archives/MEDICOM-eHIS5/MEDSRC/AR/AR_VALID.C-arc   1.0   Nov 16 2005 16:13:28   Administrator  $ sqlca.h 
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


ar_declare_cursor()
{

#ifdef DEBUG
   printf("Before Declaring cursors ...\n");
#endif

   /* EXEC SQL DECLARE AR_TRN_DOC_TYPE_CUR CURSOR FOR
             SELECT TRN_TYPE_CODE
               FROM AR_TRN_DOC_TYPE
              WHERE DOC_TYPE_CODE = :l_ar_hdr_doc_type_code; */ 


   /* EXEC SQL DECLARE SY_DOC_CONTROL_CUR CURSOR FOR
             SELECT 'X'
               FROM SY_DOC_CONTROL
              WHERE DOC_TYPE_CODE = :l_ar_hdr_doc_type_code
                AND DOC_NUM       = :l_ar_hdr_doc_num; */ 

  
   /* EXEC SQL DECLARE AR_CUSTOMER_CUR CURSOR FOR
             SELECT NVL(STATUS,'X'),
                    PATIENT_FLAG
               FROM AR_CUSTOMER
              WHERE CUST_CODE        = :l_ar_hdr_cust_code; */ 


   /* EXEC SQL DECLARE AR_PMNT_TERMS_CUR CURSOR FOR
             SELECT NVL(STATUS,'X')
               FROM AR_PMNT_TERMS
              WHERE PMNT_TERMS_CODE = :l_ar_ihdr_pmnt_terms_code; */ 


   /* EXEC SQL DECLARE AR_PENDING_DOC_CUR CURSOR FOR
             SELECT NVL(PENDING_AMT,0)
               FROM AR_PENDING_DOC
              WHERE CUST_CODE        = :l_ar_ihdr_cust_code
                AND DOC_TYPE_CODE    = :l_ar_ihdr_org_doc_type_code
                AND DOC_NUM          = :l_ar_ihdr_org_doc_num; */ 


   /* EXEC SQL DECLARE SY_ACC_ENTITY_DOC_TYPE_CUR CURSOR FOR
             SELECT NVL(STATUS,'X'),
                    NVL(AR_VALID_FLAG,'X'),
                    NVL(DOC_PRINT_FLAG,'X')
               FROM GL_ACC_ENTITY_DOC_TYPE_VW
              WHERE DOC_TYPE_CODE   = :l_ar_chk_doc_type_code; */ 


    /* EXEC SQL DECLARE SY_DOC_TYPE_MAST_CUR CURSOR FOR
              SELECT NVL(STATUS,'X')
                FROM SY_DOC_TYPE_MASTER
               WHERE DOC_TYPE_CODE = :l_ar_chk_doc_type_code; */ 


    /* EXEC SQL DECLARE BL_BLNG_GRP_CUR CURSOR FOR
              SELECT NVL(STATUS,'X')
                FROM BL_BLNG_GRP
               WHERE BLNG_GRP_ID  = :l_ar_ihdr_billing_group; */ 


    /* EXEC SQL DECLARE MP_PATIENT_MAST_CUR CURSOR FOR
              SELECT 'X'
                FROM MP_PATIENT_MAST
               WHERE PATIENT_ID  = :l_ar_ihdr_patient_id; */ 



   /***********************************************************/

     /* EXEC SQL DECLARE AR_PATIENT_DTLS_CUR CURSOR FOR
              SELECT DOC_TYPE_CODE,
                     DOC_NUM,
                     PATIENT_ID,
					 INV_DOC_TYPE_CODE,
					 INV_DOC_NUM       ,     
                     BILL_DOC_TYPE_CODE,
                     BILL_NUM,
                     TO_CHAR(BILL_DATE,'YYYYMMDD'),
                     NVL(AMOUNT,0),
					  ABS(nvl(AMOUNT,0)),
                     ROWID
                FROM AR_PATIENT_ALLOC_DTLS
              WHERE DOC_TYPE_CODE = :l_ar_hdr_doc_type_code
                AND DOC_NUM       = :l_ar_hdr_doc_num
               ORDER BY DOC_TYPE_CODE , DOC_NUM; */ 




   /**********************************************************/

#ifdef DEBUG
   printf("After Declaring  & opening cursor CUR_DN_HDR...\n");
#endif
}   /* End od Declare Cusor*/




validate_ar_header(
            l_passed_doc_type_code, 
            l_passed_doc_num,
            l_passed_cust_code,
            l_ar_hdr_doc_date,
            l_ar_hdr_doc_amt_chk,
            l_ar_hdr_post_month,
            l_ar_hdr_post_year,
            l_ar_hdr_print_flag,
            l_curr_acc_year,
            l_curr_acc_month,
            l_sy_num_acc_per,
            l_proc_flag,
            l_prior_post_allow_flag,
            l_cus_pat_flag,         
            l_trn_type ,             /* C -> Credit note D -> Debit note  A -> Adjustments  */
			l_passed_ar_flag
)
char l_passed_doc_type_code    [ ], 
     l_passed_doc_num          [ ],
     l_passed_cust_code        [ ],
     l_ar_hdr_doc_date        [  ],
     l_ar_hdr_doc_amt_chk      [  ],
     l_ar_hdr_post_month       [ ],
     l_ar_hdr_post_year        [ ],
     l_ar_hdr_print_flag       [ ],
     l_proc_flag               [ ],
     l_prior_post_allow_flag   [ ],
     *l_cus_pat_flag,
     l_trn_type,
	 l_passed_ar_flag        [ ];

int  l_curr_acc_year,
     l_curr_acc_month,
     l_sy_num_acc_per;
{

#ifdef DEBUG
   printf("Inside Val dn header...\n");
   printf("doc type is <%s>\n",l_passed_doc_type_code);
   printf("doc num is <%s>\n",l_passed_doc_num);
   printf("cust cd is <%s>\n",l_passed_cust_code);
   printf("doc date is <%s>\n",l_ar_hdr_doc_date);
   printf("doc amt  is <%s>\n",l_ar_hdr_doc_amt_chk);
   printf("post mnt is <%s>\n",l_ar_hdr_post_month);
   printf("post yr  is <%s>\n",l_ar_hdr_post_year);
   printf("pr  flg  is <%s>\n",l_ar_hdr_print_flag);
   printf("proc flg is <%s>\n",l_proc_flag);
   printf("pr post  is <%s>\n",l_prior_post_allow_flag);
   printf("pat flg  is <%s>\n",l_cus_pat_flag);
   printf("trn type is <%c>\n",l_trn_type);
   printf("cur year is <%d>\n",l_curr_acc_year);
   printf("cur mont is <%d>\n",l_curr_acc_month);
   printf("sy num acc is <%d>\n",l_sy_num_acc_per);
   printf("trn type is <%c>\n",l_trn_type);
#endif

     strcpy(l_ar_hdr_doc_type_code.arr,  l_passed_doc_type_code);
     strcpy(l_ar_hdr_doc_num.arr,        l_passed_doc_num);
	 strcpy(l_ar_flag.arr , l_passed_ar_flag);

     l_ar_hdr_doc_type_code.len  = strlen(l_ar_hdr_doc_type_code.arr);
     l_ar_hdr_doc_num.len        = strlen(l_ar_hdr_doc_num.arr);
	 l_ar_flag.len = strlen(l_ar_flag.arr);

   strcpy(l_ar_chk_doc_type_code.arr,  l_ar_hdr_doc_type_code.arr);
   l_ar_chk_doc_type_code.len  = strlen(l_ar_chk_doc_type_code.arr);

   /* EXEC SQL OPEN SY_ACC_ENTITY_DOC_TYPE_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 1;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0006;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )5;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&l_ar_chk_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )9;
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


 
   if (ERROR) err_mesg("OPEN failed on cursor SY_ACC_ENTITY_DOC_TYPE_CUR",0,"");

   l_ar_acc_status.arr[0]     = '\0';
   l_ar_acc_valid_flag.arr[0] = '\0';
   l_sy_doc_print_flag.arr[0]   = '\0';

   l_ar_acc_valid_flag.len = 0;
   l_ar_acc_status.len     = 0;
   l_sy_doc_print_flag.len   = 0;

   /* EXEC SQL FETCH SY_ACC_ENTITY_DOC_TYPE_CUR
             INTO :l_ar_acc_status,
                  :l_ar_acc_valid_flag,
                  :l_sy_doc_print_flag; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 3;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )24;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&l_ar_acc_status;
   sqlstm.sqhstl[0] = (unsigned int  )4;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&l_ar_acc_valid_flag;
   sqlstm.sqhstl[1] = (unsigned int  )4;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&l_sy_doc_print_flag;
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


   
   if (ERROR)
        err_mesg("FETCH failed on cursor SY_ACC_ENTITY_DOC_TYPE_CUR",0,""); 

   l_ar_acc_status.arr[l_ar_acc_status.len]         = '\0';
   l_ar_acc_valid_flag.arr[l_ar_acc_valid_flag.len] = '\0';
   l_sy_doc_print_flag.arr[l_sy_doc_print_flag.len]     = '\0';
   
   if (NOT_FOUND)
         error_insert("9999","SY1610");
   else
   {
      if (l_ar_acc_valid_flag.arr[0] != 'Y')
            error_insert("9999","SY1700");
      if (l_ar_acc_status.arr[0] == 'S')
            error_insert("9999","SY1640");

      if (l_proc_flag[0] == 'P') 
      {
           if (l_sy_doc_print_flag.arr[0] == 'Y' &&
                   l_ar_hdr_print_flag[0] != 'Y')
               error_insert("9999","SY2370");
      }
   } 

   /* EXEC SQL OPEN SY_DOC_TYPE_MAST_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 3;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0007;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )51;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&l_ar_chk_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )9;
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



   if (ERROR)
       err_mesg("OPEN failed on cursor SY_DOC_TYPE_MAST_CUR",0,""); 

   l_mast_status.arr[0] = '\0';
   l_mast_status.len    = 0;

   /* EXEC SQL FETCH SY_DOC_TYPE_MAST_CUR
             INTO :l_mast_status; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 3;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )70;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&l_mast_status;
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


 
   if (ERROR)
       err_mesg("FETCH failed on cursor SY_DOC_TYPE_MAST_CUR",0,""); 

   l_mast_status.arr[l_mast_status.len] = '\0';
   
   if (NOT_FOUND)
        error_insert("9999","SY1610");
   else if (l_mast_status.arr[0] == 'S')
        error_insert("9999","SY2190");
   
   /* EXEC SQL OPEN AR_TRN_DOC_TYPE_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 3;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0001;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )89;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&l_ar_hdr_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )9;
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



   if (ERROR)
        err_mesg("OPEN failed on cursor AR_TRN_DOC_TYPE_CUR",0,"");

   l_ar_trn_type_code.arr[0] = '\0';
   l_ar_trn_type_code.len    = 0;
 
   /* EXEC SQL FETCH AR_TRN_DOC_TYPE_CUR
             INTO :l_ar_trn_type_code; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 3;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )108;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&l_ar_trn_type_code;
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



   if (ERROR)
        err_mesg("FETCH failed on cursor AR_TRN_DOC_TYPE_CUR",0,"");

   l_ar_trn_type_code.arr[l_ar_trn_type_code.len] = '\0';

   if (l_trn_type == 'D' && l_ar_trn_type_code.arr[0] != '2')
        error_insert("9999","AR1890");
   else if (l_trn_type == 'C' && l_ar_trn_type_code.arr[0] != '3')
        error_insert("9999","AR1890");
   else if (l_trn_type == 'A' && l_ar_trn_type_code.arr[0] != '4')
        error_insert("9999","AR1890");

   /* EXEC SQL OPEN SY_DOC_CONTROL_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 3;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0002;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )127;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&l_ar_hdr_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )9;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&l_ar_hdr_doc_num;
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



   if (ERROR)
        err_mesg("OPEN failed on cursor SY_DOC_CONTROL_CUR",0,"");

   /* EXEC SQL FETCH SY_DOC_CONTROL_CUR
             INTO :l_dummy; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 3;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )10;
   sqlstm.offset = (unsigned int  )150;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)l_dummy;
   sqlstm.sqhstl[0] = (unsigned int  )12;
   sqlstm.sqhsts[0] = (         int  )12;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqharc[0] = (unsigned int   *)0;
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



   if (ERROR)
        err_mesg("FETCH failed on cursor SY_DOC_CONTROL_CUR",0,"");

   if (!NOT_FOUND)   /*   Record Exists   */
        error_insert("9999","AR1080");
  
   if (l_trn_type != 'A')
   {
      ar_cust_check(l_passed_cust_code,l_cus_pat_flag,"9999");
   }

   if (atoi(l_ar_hdr_post_month) > l_sy_num_acc_per)
          error_insert("9999","GL2290");

   if (atoi(l_ar_hdr_post_year) < l_curr_acc_year)
          error_insert("9999","GL1595");

   if ( (atoi(l_ar_hdr_post_year) == l_curr_acc_year && 
            atoi(l_ar_hdr_post_month) < l_curr_acc_month) &&
             l_prior_post_allow_flag[0] != 'Y' )
          error_insert("9999","GL1310");

     if (strlen(l_ar_hdr_doc_date) == 0)
            error_insert_null("9999","SY1470","Field = DOC DATE");
     if (strlen(l_ar_hdr_doc_amt_chk) == 0)
            error_insert_null("9999","SY1470","Field = DOC AMT");

     if (strlen(l_ar_hdr_post_month) == 0)
            error_insert_null("9999","SY1470","Field = POST MONTH");
     if (strlen(l_ar_hdr_post_year) == 0)
            error_insert_null("9999","SY1470","Field = POST YEAR");

	if ((strcmp(l_ar_flag.arr  , "1") == 0)  || (strcmp(l_ar_flag.arr  , "2") == 0))
    {
         if (strlen(l_ar_hdr_doc_amt_chk) != 0)
	    {
		    error_insert("9999","AR2395");
	     }

     }


#ifdef DEBUG
   printf("pat flg is <%s>\n",l_cus_pat_flag);
   printf("After Val header...\n");
#endif
} /* End of Validate AR_header*/




ar_cust_check(local_cust_code,local_cus_pat_flag,l_error)
char local_cust_code[],
     *local_cus_pat_flag,
     l_error[];
{
     strcpy(l_ar_hdr_cust_code.arr,      local_cust_code);
     l_ar_hdr_cust_code.len      = strlen(l_ar_hdr_cust_code.arr);

     /****   AR_CUSTOMER Validation   *****/
  
     if (l_ar_hdr_cust_code.len == 0)
            error_insert_null(l_error,"SY1470","Field = CUST CODE");

     /* EXEC SQL OPEN AR_CUSTOMER_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 3;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0003;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )169;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&l_ar_hdr_cust_code;
     sqlstm.sqhstl[0] = (unsigned int  )11;
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



     if (ERROR)
          err_mesg("OPEN failed on cursor AR_CUSTOMER_CUR",0,"");

     l_customer_status.arr[0]       = '\0';
     l_customer_patient_flag.arr[0] = '\0';

     l_customer_status.len       = 0;
     l_customer_patient_flag.len = 0;

     /* EXEC SQL FETCH AR_CUSTOMER_CUR
               INTO :l_customer_status,
                    :l_customer_patient_flag; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 3;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )188;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&l_customer_status;
     sqlstm.sqhstl[0] = (unsigned int  )4;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&l_customer_patient_flag;
     sqlstm.sqhstl[1] = (unsigned int  )4;
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



     l_customer_status.arr[l_customer_status.len]             = '\0';
     l_customer_patient_flag.arr[l_customer_patient_flag.len] = '\0';

     *local_cus_pat_flag = l_customer_patient_flag.arr[0];
     *(local_cus_pat_flag+1) = '\0';

     if (ERROR)
          err_mesg("FETCH failed on cursor AR_CUSTOMER_CUR",0,"");

     if (NOT_FOUND)
          error_insert(l_error,"AR1210");
     else
       if (l_customer_status.arr[0] == 'S')
          error_insert(l_error,"AR1220");
} /* End or ar_check*/


/*************************************************************/

fetch_patient_dtls()
{
ar_pat_doc_type_code.arr[0]       = '\0';
ar_pat_doc_num.arr[0]             = '\0';
ar_pat_patient_id.arr[0]          = '\0';
ar_pat_bill_doc_type_code.arr[0]  = '\0';
ar_pat_bill_num.arr[0]            = '\0';
ar_pat_bill_date.arr[0]           = '\0';
ar_pat_inv_doc_type_code.arr[0] = '\0';
ar_pat_inv_doc_num.arr[0] = '\0';
ar_pat_rowid.arr[0]               = '\0';

ar_pat_doc_type_code.len          = 0;
ar_pat_doc_num.len                = 0;
ar_pat_patient_id.len             = 0;
ar_pat_bill_doc_type_code.len     = 0;
ar_pat_bill_num.len               = 0;
ar_pat_bill_date.len              = 0;
ar_pat_inv_doc_type_code.len = 0;
ar_pat_inv_doc_num.len = 0;

ar_pat_rowid.len                  = 0;

ar_pat_amount                     = 0;
ar_pat_abs_amount  =0;

   /* EXEC SQL FETCH AR_PATIENT_DTLS_CUR
             INTO :ar_pat_doc_type_code,
                  :ar_pat_doc_num,
                  :ar_pat_patient_id,
				  :ar_pat_inv_doc_type_code,
                  :ar_pat_inv_doc_num,
                  :ar_pat_bill_doc_type_code,
                  :ar_pat_bill_num,
                  :ar_pat_bill_date,
                  :ar_pat_amount,
                  :ar_pat_abs_amount,
                  :ar_pat_rowid; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )211;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&ar_pat_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )9;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&ar_pat_doc_num;
   sqlstm.sqhstl[1] = (unsigned int  )11;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&ar_pat_patient_id;
   sqlstm.sqhstl[2] = (unsigned int  )23;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&ar_pat_inv_doc_type_code;
   sqlstm.sqhstl[3] = (unsigned int  )9;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&ar_pat_inv_doc_num;
   sqlstm.sqhstl[4] = (unsigned int  )11;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&ar_pat_bill_doc_type_code;
   sqlstm.sqhstl[5] = (unsigned int  )9;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&ar_pat_bill_num;
   sqlstm.sqhstl[6] = (unsigned int  )11;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&ar_pat_bill_date;
   sqlstm.sqhstl[7] = (unsigned int  )14;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&ar_pat_amount;
   sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&ar_pat_abs_amount;
   sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&ar_pat_rowid;
   sqlstm.sqhstl[10] = (unsigned int  )33;
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




   if (ERROR)
       err_mesg("FETCH failed on cursor AR_PATIENT_DTLS_CUR",0,"");


ar_pat_doc_type_code.arr[ar_pat_doc_type_code.len]           = '\0';
ar_pat_doc_num.arr[ar_pat_doc_num.len]                       = '\0';
ar_pat_patient_id.arr[ar_pat_patient_id.len]                 = '\0';
ar_pat_bill_doc_type_code.arr[ar_pat_bill_doc_type_code.len] = '\0';
ar_pat_bill_num.arr[ar_pat_bill_num.len]                     = '\0';
ar_pat_bill_date.arr[ar_pat_bill_date.len]                   = '\0';
ar_pat_rowid.arr[ar_pat_rowid.len]                           = '\0';
ar_pat_inv_doc_type_code.arr[ar_pat_inv_doc_type_code.len] = '\0';
ar_pat_inv_doc_num.arr[ar_pat_inv_doc_num.len]= '\0';

ar_pat_tot_amt += ar_pat_amount;
ar_pat_abs_tot_amount  += ar_pat_abs_amount;



   if (LAST_ROW)
       return (0);
   else 
       return (1);
}
 /* End of ar_patient_dtls fetch*/
/************************************************************/



validate_ar_inv_header(
            l_passed_doc_type_code, 
            l_passed_doc_num,
            l_passed_org_doc_type_code, 
            l_passed_org_doc_num,
            l_passed_cust_code,
            l_ar_ihdr_doc_date,
            l_ar_ihdr_due_date,
            l_ar_ihdr_settlement_date,
            l_ar_ihdr_settlement_perc,
            l_ar_ihdr_doc_amt,
            l_ar_ihdr_doc_amt_len,
            l_ar_ihdr_gross_amt,
            l_ar_ihdr_gross_amt_len,
            l_ar_ihdr_payable_amt,
            l_ar_ihdr_payable_amt_len,
            l_ar_ihdr_discount_amt,
            l_ar_ihdr_bill_date,
            l_ar_ihdr_doctor_fee_amt,
            l_passed_pmnt_terms_code,
            l_ar_ihdr_bill_num_len,
            l_bl_instal_flag,
            l_mp_instal_flag,
            l_cus_pat_flag,
            l_passed_bill_doc_type_code,
            l_passed_billing_group,
            l_passed_patient_id,
            l_ar_ihdr_base_date,
            l_trn_type,             /* C -> Credit note D -> Debit note    */
                                    /* A -> Adjustments                    */
            l_adj_type,              /* C -> Credit      D -> Debit         */
			l_passed_consolidated_yn
)
char        l_passed_doc_type_code        [ ], 
            l_passed_doc_num              [ ],
            l_passed_org_doc_type_code    [ ], 
            l_passed_org_doc_num          [ ],
            l_passed_cust_code            [ ],
            l_ar_ihdr_doc_date            [ ],
            l_ar_ihdr_due_date            [ ],
            l_ar_ihdr_settlement_date     [ ],
            l_ar_ihdr_settlement_perc     [ ],
            l_ar_ihdr_bill_date           [ ],
            l_passed_pmnt_terms_code      [ ],
            l_bl_instal_flag              [ ],
            l_mp_instal_flag              [ ],
            l_cus_pat_flag                [ ],
            l_passed_bill_doc_type_code   [ ],
            l_passed_billing_group        [ ],
            l_passed_patient_id           [ ],
            l_ar_ihdr_base_date           [ ],
            l_trn_type,
            l_adj_type,
			l_passed_consolidated_yn[];

int         l_ar_ihdr_doc_amt_len,
            l_ar_ihdr_gross_amt_len,
            l_ar_ihdr_payable_amt_len,
            l_ar_ihdr_bill_num_len;

double      l_ar_ihdr_gross_amt,
            l_ar_ihdr_payable_amt,
            l_ar_ihdr_discount_amt,
            l_ar_ihdr_doctor_fee_amt,
            l_ar_ihdr_doc_amt;
{
   char chk1_arr[30],chk2_arr[30];

#ifdef DEBUG
   printf("Inside Val ar inv hdr\n");
   printf("doc type is <%s>\n",l_passed_doc_type_code);
   printf("doc num  is <%s>\n",l_passed_doc_num);
   printf("o doc type is <%s>\n",l_passed_org_doc_type_code);
   printf("o doc num  is <%s>\n",l_passed_org_doc_num);
   printf("pat flg is <%s>\n",l_cus_pat_flag);
   printf("trn typ is <%c>\n",l_trn_type);
   printf("adj typ is <%c>\n",l_adj_type);
#endif
  
     strcpy(l_ar_ihdr_doc_type_code.arr,  l_passed_doc_type_code);
     strcpy(l_ar_ihdr_doc_num.arr,        l_passed_doc_num);
     strcpy(l_ar_ihdr_org_doc_type_code.arr,  l_passed_org_doc_type_code);
     strcpy(l_ar_ihdr_org_doc_num.arr,        l_passed_org_doc_num);
     strcpy(l_ar_ihdr_cust_code.arr,      l_passed_cust_code);
     strcpy(l_ar_ihdr_bill_doc_type_code.arr,l_passed_bill_doc_type_code);
     strcpy(l_ar_ihdr_pmnt_terms_code.arr,l_passed_pmnt_terms_code);
     strcpy(l_ar_ihdr_billing_group.arr,  l_passed_billing_group);
     strcpy(l_ar_ihdr_patient_id.arr,      l_passed_patient_id);
	 strcpy(l_consolidated_yn.arr , l_passed_consolidated_yn),

     l_ar_ihdr_doc_type_code.len      = strlen(l_ar_ihdr_doc_type_code.arr);
     l_ar_ihdr_doc_num.len            = strlen(l_ar_ihdr_doc_num.arr);
     l_ar_ihdr_org_doc_type_code.len  = strlen(l_ar_ihdr_org_doc_type_code.arr);
     l_ar_ihdr_org_doc_num.len        = strlen(l_ar_ihdr_org_doc_num.arr);
     l_ar_ihdr_cust_code.len          = strlen(l_ar_ihdr_cust_code.arr);
     l_ar_ihdr_bill_doc_type_code.len = strlen(l_ar_ihdr_bill_doc_type_code.arr);
     l_ar_ihdr_pmnt_terms_code.len    = strlen(l_ar_ihdr_pmnt_terms_code.arr);
     l_ar_ihdr_billing_group.len      = strlen(l_ar_ihdr_billing_group.arr);
     l_ar_ihdr_patient_id.len         = strlen(l_ar_ihdr_patient_id.arr);
	 l_consolidated_yn.len       = strlen(l_consolidated_yn.arr);
     
#ifdef DEBUG
   printf("Inside validate dn inv header\n");
   printf("DOC_TYPE_CODE is <%s> - <%d>\n",l_ar_ihdr_doc_type_code.arr,
                 l_ar_ihdr_doc_type_code.len);
   printf("DOC_NUM       is <%s> - <%d>\n",l_ar_ihdr_doc_num.arr,
                 l_ar_ihdr_doc_num.len);
#endif

   if (l_trn_type == 'A')
   {
      strcpy(l_ar_hdr_cust_code.arr, l_ar_ihdr_cust_code.arr);
      l_ar_hdr_cust_code.len     = strlen(l_ar_hdr_cust_code.arr);

      ar_cust_check(l_passed_cust_code,l_cus_pat_flag,"9998");
   }

   if (l_ar_ihdr_doc_amt_len == 0)
          error_insert_null("9998","SY1470","Field = AMOUNT");

   if ((strcmp(l_ar_ihdr_doc_type_code.arr,l_ar_ihdr_org_doc_type_code.arr)==0)  &&
       (strcmp(l_ar_ihdr_doc_num.arr,l_ar_ihdr_org_doc_num.arr) == 0))
   {

    if (l_adj_type == 'D')
    {
        /****   AR_PMNT_TERMS  Validation   *****/

        if (l_ar_ihdr_pmnt_terms_code.len == 0)
            error_insert_null("9998","SY1470","Field = PAY TERMS");
        else
        {
            /* EXEC SQL OPEN AR_PMNT_TERMS_CUR; */ 

{
            struct sqlexd sqlstm;
            sqlstm.sqlvsn = 10;
            sqlstm.arrsiz = 11;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.stmt = sq0004;
            sqlstm.iters = (unsigned int  )1;
            sqlstm.offset = (unsigned int  )270;
            sqlstm.selerr = (unsigned short)1;
            sqlstm.cud = sqlcud0;
            sqlstm.sqlest = (unsigned char  *)&sqlca;
            sqlstm.sqlety = (unsigned short)256;
            sqlstm.occurs = (unsigned int  )0;
            sqlstm.sqhstv[0] = (         void  *)&l_ar_ihdr_pmnt_terms_code;
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



            if (ERROR)
                err_mesg("OPEN failed on cursor AR_PMNT_TERMS_CUR",0,"");

            l_pmnt_terms_status.arr[0] = '\0';
            l_pmnt_terms_status.len    = 0;

            /* EXEC SQL FETCH AR_PMNT_TERMS_CUR
                      INTO :l_pmnt_terms_status; */ 

{
            struct sqlexd sqlstm;
            sqlstm.sqlvsn = 10;
            sqlstm.arrsiz = 11;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.iters = (unsigned int  )1;
            sqlstm.offset = (unsigned int  )289;
            sqlstm.cud = sqlcud0;
            sqlstm.sqlest = (unsigned char  *)&sqlca;
            sqlstm.sqlety = (unsigned short)256;
            sqlstm.occurs = (unsigned int  )0;
            sqlstm.sqhstv[0] = (         void  *)&l_pmnt_terms_status;
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



            l_pmnt_terms_status.arr[l_pmnt_terms_status.len] = '\0';

            if (ERROR)
                 err_mesg("FETCH failed on cursor AR_PMNT_TERMS_CUR",0,"");

            if (NOT_FOUND)
                 error_insert("9998","AR1240");
            else
               if (l_pmnt_terms_status.arr[0] == 'S')
                    error_insert("9998","AR1250");
          }

      if (atol(l_ar_ihdr_base_date) <  atol(l_ar_ihdr_doc_date))
                  error_insert("9998","AR1090");

      if (atol(l_ar_ihdr_due_date) <  atol(l_ar_ihdr_base_date))
                  error_insert("9998","AR1100");

      if (strlen(l_ar_ihdr_settlement_date) != 0)
      {
          if (atol(l_ar_ihdr_settlement_date) < atol(l_ar_ihdr_base_date) ||
              atol(l_ar_ihdr_settlement_date) > atol(l_ar_ihdr_due_date))
                  error_insert("9998","AR1110");

          if (strlen(l_ar_ihdr_settlement_perc) == 0)
                  error_insert("9998","AR1130");
      }
      else if (strlen(l_ar_ihdr_settlement_perc) != 0)
              error_insert("9998","AR1120");
       
      if (l_ar_ihdr_gross_amt <= 0)
                error_insert("9998","AR1140");

      if (l_ar_ihdr_payable_amt > l_ar_ihdr_gross_amt)
                error_insert("9998","AR1150");
  
      sprintf(chk1_arr,"%15.3f",l_ar_ihdr_discount_amt);
      sprintf(chk2_arr,"%15.3f",l_ar_ihdr_gross_amt - 
                                l_ar_ihdr_payable_amt);

      if (strcmp(chk1_arr,chk2_arr))
             error_insert("9998","AR1160");

      if (strlen(l_ar_ihdr_base_date) == 0)
            error_insert_null("9998","SY1470","Field = BASE DATE");
      if (strlen(l_ar_ihdr_due_date) == 0)
             error_insert_null("9998","SY1470","Field = DUE DATE");
      if (l_ar_ihdr_gross_amt_len == 0)
             error_insert_null("9998","SY1470","Field = GROSS AMT");
      if (l_ar_ihdr_payable_amt_len == 0)
             error_insert_null("9998","SY1470","Field = PAYABLE AMT");
     }
         /* End of  (l_adj_type == 'D') check  */

     if (l_cus_pat_flag[0] == 'Y')
     {
          if (atol(l_ar_ihdr_bill_date) > atol(l_ar_ihdr_doc_date))
                  error_insert("9998","AR1170");

          if (l_ar_ihdr_doctor_fee_amt != 0.00)
          {
                if (l_adj_type == 'D')
                {
                   if (l_ar_ihdr_doctor_fee_amt > l_ar_ihdr_payable_amt)
                          error_insert("9998","AR1180");
  
                 }
                 else if (l_ar_ihdr_doctor_fee_amt > l_ar_ihdr_doc_amt)
                               error_insert("9998","AR1180");
          }
						
          if (l_ar_ihdr_bill_num_len == 0)
               error_insert_null("9998","SY1470","Field = BILL NUM");
          if (strlen(l_ar_ihdr_bill_date) == 0)
               error_insert_null("9998","SY1470","Field = BILL DATE");
          if (l_ar_ihdr_bill_doc_type_code.len == 0)
               error_insert_null("9998","SY1470","Field = BILL DOC TYPE");
          else
          {
              strcpy(l_ar_chk_doc_type_code.arr,
                         l_ar_ihdr_bill_doc_type_code.arr);
              l_ar_chk_doc_type_code.len  = 
                         strlen(l_ar_chk_doc_type_code.arr);

              /* EXEC SQL OPEN SY_ACC_ENTITY_DOC_TYPE_CUR; */ 

{
              struct sqlexd sqlstm;
              sqlstm.sqlvsn = 10;
              sqlstm.arrsiz = 11;
              sqlstm.sqladtp = &sqladt;
              sqlstm.sqltdsp = &sqltds;
              sqlstm.stmt = sq0006;
              sqlstm.iters = (unsigned int  )1;
              sqlstm.offset = (unsigned int  )308;
              sqlstm.selerr = (unsigned short)1;
              sqlstm.cud = sqlcud0;
              sqlstm.sqlest = (unsigned char  *)&sqlca;
              sqlstm.sqlety = (unsigned short)256;
              sqlstm.occurs = (unsigned int  )0;
              sqlstm.sqhstv[0] = (         void  *)&l_ar_chk_doc_type_code;
              sqlstm.sqhstl[0] = (unsigned int  )9;
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


 
             if (ERROR)
              err_mesg("OPEN failed on cursor SY_ACC_ENTITY_DOC_TYPE_CUR",0,"");

              l_ar_acc_status.arr[0]     = '\0';
              l_ar_acc_valid_flag.arr[0] = '\0';
              l_sy_doc_print_flag.arr[0]   = '\0';

              l_ar_acc_valid_flag.len = 0;
              l_ar_acc_status.len     = 0;
              l_sy_doc_print_flag.len   = 0;

              /* EXEC SQL FETCH SY_ACC_ENTITY_DOC_TYPE_CUR
                        INTO :l_ar_acc_status,
                             :l_ar_acc_valid_flag,
                             :l_sy_doc_print_flag; */ 

{
              struct sqlexd sqlstm;
              sqlstm.sqlvsn = 10;
              sqlstm.arrsiz = 11;
              sqlstm.sqladtp = &sqladt;
              sqlstm.sqltdsp = &sqltds;
              sqlstm.iters = (unsigned int  )1;
              sqlstm.offset = (unsigned int  )327;
              sqlstm.cud = sqlcud0;
              sqlstm.sqlest = (unsigned char  *)&sqlca;
              sqlstm.sqlety = (unsigned short)256;
              sqlstm.occurs = (unsigned int  )0;
              sqlstm.sqhstv[0] = (         void  *)&l_ar_acc_status;
              sqlstm.sqhstl[0] = (unsigned int  )4;
              sqlstm.sqhsts[0] = (         int  )0;
              sqlstm.sqindv[0] = (         void  *)0;
              sqlstm.sqinds[0] = (         int  )0;
              sqlstm.sqharm[0] = (unsigned int  )0;
              sqlstm.sqadto[0] = (unsigned short )0;
              sqlstm.sqtdso[0] = (unsigned short )0;
              sqlstm.sqhstv[1] = (         void  *)&l_ar_acc_valid_flag;
              sqlstm.sqhstl[1] = (unsigned int  )4;
              sqlstm.sqhsts[1] = (         int  )0;
              sqlstm.sqindv[1] = (         void  *)0;
              sqlstm.sqinds[1] = (         int  )0;
              sqlstm.sqharm[1] = (unsigned int  )0;
              sqlstm.sqadto[1] = (unsigned short )0;
              sqlstm.sqtdso[1] = (unsigned short )0;
              sqlstm.sqhstv[2] = (         void  *)&l_sy_doc_print_flag;
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


   
              if (ERROR)
                   err_mesg("FETCH failed on cursor SY_ACC_ENTITY_DOC_TYPE_CUR",0,""); 

              l_ar_acc_status.arr[l_ar_acc_status.len]         = '\0';
              l_ar_acc_valid_flag.arr[l_ar_acc_valid_flag.len] = '\0';
              l_sy_doc_print_flag.arr[l_sy_doc_print_flag.len]     = '\0';
   
              if (NOT_FOUND)
                    error_insert_null("9998","SY1610","(BILL DOC TYPE)");
              else
              {
                 if (l_ar_acc_status.arr[0] == 'S')
                       error_insert_null("9998","SY1640","(BILL DOC TYPE)");

              } 

              /* EXEC SQL OPEN SY_DOC_TYPE_MAST_CUR; */ 

{
              struct sqlexd sqlstm;
              sqlstm.sqlvsn = 10;
              sqlstm.arrsiz = 11;
              sqlstm.sqladtp = &sqladt;
              sqlstm.sqltdsp = &sqltds;
              sqlstm.stmt = sq0007;
              sqlstm.iters = (unsigned int  )1;
              sqlstm.offset = (unsigned int  )354;
              sqlstm.selerr = (unsigned short)1;
              sqlstm.cud = sqlcud0;
              sqlstm.sqlest = (unsigned char  *)&sqlca;
              sqlstm.sqlety = (unsigned short)256;
              sqlstm.occurs = (unsigned int  )0;
              sqlstm.sqhstv[0] = (         void  *)&l_ar_chk_doc_type_code;
              sqlstm.sqhstl[0] = (unsigned int  )9;
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



              if (ERROR)
                  err_mesg("OPEN failed on cursor SY_DOC_TYPE_MAST_CUR",0,""); 

              l_mast_status.arr[0] = '\0';
              l_mast_status.len    = 0;

              /* EXEC SQL FETCH SY_DOC_TYPE_MAST_CUR
                        INTO :l_mast_status; */ 

{
              struct sqlexd sqlstm;
              sqlstm.sqlvsn = 10;
              sqlstm.arrsiz = 11;
              sqlstm.sqladtp = &sqladt;
              sqlstm.sqltdsp = &sqltds;
              sqlstm.iters = (unsigned int  )1;
              sqlstm.offset = (unsigned int  )373;
              sqlstm.cud = sqlcud0;
              sqlstm.sqlest = (unsigned char  *)&sqlca;
              sqlstm.sqlety = (unsigned short)256;
              sqlstm.occurs = (unsigned int  )0;
              sqlstm.sqhstv[0] = (         void  *)&l_mast_status;
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


 
              if (ERROR)
                  err_mesg("FETCH failed on cursor SY_DOC_TYPE_MAST_CUR",0,""); 

              l_mast_status.arr[l_mast_status.len] = '\0';
   
              if (NOT_FOUND)
                   error_insert_null("9998","SY1610","(BILL DOC TYPE)");
              else if (l_mast_status.arr[0] == 'S')
                   error_insert_null("9998","SY2190","(BILL DOC TYPE)");
          }

          if (l_ar_ihdr_patient_id.len == 0)
               error_insert_null("9998","SY1470","Field = PATIENT NO");

   /****   PATIENT_MAST & BL_BLNG_GRP Validation    *****/

          if (l_bl_instal_flag[0] == 'Y')
          {
              l_bl_blng_grp_status.arr[0] = '\0';
              l_bl_blng_grp_status.len    = 0;

              /* EXEC SQL OPEN BL_BLNG_GRP_CUR; */ 

{
              struct sqlexd sqlstm;
              sqlstm.sqlvsn = 10;
              sqlstm.arrsiz = 11;
              sqlstm.sqladtp = &sqladt;
              sqlstm.sqltdsp = &sqltds;
              sqlstm.stmt = sq0008;
              sqlstm.iters = (unsigned int  )1;
              sqlstm.offset = (unsigned int  )392;
              sqlstm.selerr = (unsigned short)1;
              sqlstm.cud = sqlcud0;
              sqlstm.sqlest = (unsigned char  *)&sqlca;
              sqlstm.sqlety = (unsigned short)256;
              sqlstm.occurs = (unsigned int  )0;
              sqlstm.sqhstv[0] = (         void  *)&l_ar_ihdr_billing_group;
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


 
              if (ERROR)
                  err_mesg("OPEN failed on cursor BL_BLNG_GRP_CUR",0,"");

              /* EXEC SQL FETCH BL_BLNG_GRP_CUR
                        INTO :l_bl_blng_grp_status; */ 

{
              struct sqlexd sqlstm;
              sqlstm.sqlvsn = 10;
              sqlstm.arrsiz = 11;
              sqlstm.sqladtp = &sqladt;
              sqlstm.sqltdsp = &sqltds;
              sqlstm.iters = (unsigned int  )1;
              sqlstm.offset = (unsigned int  )411;
              sqlstm.cud = sqlcud0;
              sqlstm.sqlest = (unsigned char  *)&sqlca;
              sqlstm.sqlety = (unsigned short)256;
              sqlstm.occurs = (unsigned int  )0;
              sqlstm.sqhstv[0] = (         void  *)&l_bl_blng_grp_status;
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



              l_bl_blng_grp_status.arr[l_bl_blng_grp_status.len] = '\0';

              if (ERROR)
                  err_mesg("FETCH failed on cursor BL_BLNG_GRP_CUR",0,"");

              if (NOT_FOUND)
                 error_insert("9998","SY0110");
              else if (l_bl_blng_grp_status.arr[0] == 'S')
                 error_insert("9998","BL0026");

           }
           /*
           if (l_mp_instal_flag[0] == 'Y')
           {
#ifdef DEBUG
   printf("patient id is <%s> - <%d>\n",l_ar_ihdr_patient_id.arr,l_ar_ihdr_patient_id.len);
#endif
               EXEC SQL OPEN MP_PATIENT_MAST_CUR;

               if (ERROR)
                   err_mesg("OPEN failed on cursor MP_PATIENT_MAST_CUR",0,"");

               EXEC SQL FETCH MP_PATIENT_MAST_CUR
                         INTO :l_dummy;

               if (ERROR)
                    err_mesg("FETCH failed on cursor MP_PATIENT_MAST_CUR",0,"");

#ifdef DEBUG
   printf("No of records found in patient mast is <%d>\n",sqlca.sqlerrd[2]);
#endif
               if (NOT_FOUND)
                  error_insert("9998","SY2021");
 
         }
         */

      } /***** If ends Patient check  */
   }     /*****  If ends for Unalloc check  *****/
   else
   {
      d_ar_pending_amt = 0;

      /* EXEC SQL OPEN AR_PENDING_DOC_CUR; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 11;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = sq0005;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )430;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&l_ar_ihdr_cust_code;
      sqlstm.sqhstl[0] = (unsigned int  )10;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&l_ar_ihdr_org_doc_type_code;
      sqlstm.sqhstl[1] = (unsigned int  )9;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&l_ar_ihdr_org_doc_num;
      sqlstm.sqhstl[2] = (unsigned int  )11;
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


  
      if (ERROR)
         err_mesg("OPEN failed on cursor AR_PENDING_DOC_CUR",0,"");

      /* EXEC SQL FETCH AR_PENDING_DOC_CUR
                INTO :d_ar_pending_amt; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 11;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )457;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&d_ar_pending_amt;
      sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
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


      
      if (ERROR)
         err_mesg("FETCH failed on cursor AR_PENDING_DOC_CUR",0,"");

      if (NOT_FOUND)
             error_insert("9998","AR1810");
      else 
	  {

         if (l_adj_type == 'C')
         {
            if (l_ar_ihdr_doc_amt > d_ar_pending_amt && d_ar_pending_amt > 0)
                  error_insert("9998","AR1840");
         }
         else if (l_adj_type == 'D')
         {
            if (l_ar_ihdr_doc_amt > abs(d_ar_pending_amt) &&
                            d_ar_pending_amt < 0)
                  error_insert("9998","AR1840");
         }
      }

     /************************************************************/

 	 if (strcmp(l_consolidated_yn.arr , "Y") == 0) 
	{

            /* EXEC SQL OPEN AR_PATIENT_DTLS_CUR; */ 

{
            struct sqlexd sqlstm;
            sqlstm.sqlvsn = 10;
            sqlstm.arrsiz = 11;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.stmt = sq0010;
            sqlstm.iters = (unsigned int  )1;
            sqlstm.offset = (unsigned int  )476;
            sqlstm.selerr = (unsigned short)1;
            sqlstm.cud = sqlcud0;
            sqlstm.sqlest = (unsigned char  *)&sqlca;
            sqlstm.sqlety = (unsigned short)256;
            sqlstm.occurs = (unsigned int  )0;
            sqlstm.sqhstv[0] = (         void  *)&l_ar_hdr_doc_type_code;
            sqlstm.sqhstl[0] = (unsigned int  )9;
            sqlstm.sqhsts[0] = (         int  )0;
            sqlstm.sqindv[0] = (         void  *)0;
            sqlstm.sqinds[0] = (         int  )0;
            sqlstm.sqharm[0] = (unsigned int  )0;
            sqlstm.sqadto[0] = (unsigned short )0;
            sqlstm.sqtdso[0] = (unsigned short )0;
            sqlstm.sqhstv[1] = (         void  *)&l_ar_hdr_doc_num;
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



			 while(fetch_patient_dtls())
			 {
		            pending_amt = 0;

                    /* EXEC SQL SELECT PEND_AMOUNT
					into  :pending_amt
					from   AR_PATIENT_DTLS
					WHERE  DOC_TYPE_CODE = :ar_pat_inv_doc_type_code
					AND    DOC_NUM       = :ar_pat_inv_doc_num
					AND    BILL_DOC_TYPE_CODE = :ar_pat_bill_doc_type_code
					AND    BILL_NUM = :ar_pat_bill_num; */ 

{
                    struct sqlexd sqlstm;
                    sqlstm.sqlvsn = 10;
                    sqlstm.arrsiz = 11;
                    sqlstm.sqladtp = &sqladt;
                    sqlstm.sqltdsp = &sqltds;
                    sqlstm.stmt = "select PEND_AMOUNT into :b0  from AR_PATI\
ENT_DTLS where (((DOC_TYPE_CODE=:b1 and DOC_NUM=:b2) and BILL_DOC_TYPE_CODE=:b\
3) and BILL_NUM=:b4)";
                    sqlstm.iters = (unsigned int  )1;
                    sqlstm.offset = (unsigned int  )499;
                    sqlstm.selerr = (unsigned short)1;
                    sqlstm.cud = sqlcud0;
                    sqlstm.sqlest = (unsigned char  *)&sqlca;
                    sqlstm.sqlety = (unsigned short)256;
                    sqlstm.occurs = (unsigned int  )0;
                    sqlstm.sqhstv[0] = (         void  *)&pending_amt;
                    sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
                    sqlstm.sqhsts[0] = (         int  )0;
                    sqlstm.sqindv[0] = (         void  *)0;
                    sqlstm.sqinds[0] = (         int  )0;
                    sqlstm.sqharm[0] = (unsigned int  )0;
                    sqlstm.sqadto[0] = (unsigned short )0;
                    sqlstm.sqtdso[0] = (unsigned short )0;
                    sqlstm.sqhstv[1] = (         void  *)&ar_pat_inv_doc_type_code;
                    sqlstm.sqhstl[1] = (unsigned int  )9;
                    sqlstm.sqhsts[1] = (         int  )0;
                    sqlstm.sqindv[1] = (         void  *)0;
                    sqlstm.sqinds[1] = (         int  )0;
                    sqlstm.sqharm[1] = (unsigned int  )0;
                    sqlstm.sqadto[1] = (unsigned short )0;
                    sqlstm.sqtdso[1] = (unsigned short )0;
                    sqlstm.sqhstv[2] = (         void  *)&ar_pat_inv_doc_num;
                    sqlstm.sqhstl[2] = (unsigned int  )11;
                    sqlstm.sqhsts[2] = (         int  )0;
                    sqlstm.sqindv[2] = (         void  *)0;
                    sqlstm.sqinds[2] = (         int  )0;
                    sqlstm.sqharm[2] = (unsigned int  )0;
                    sqlstm.sqadto[2] = (unsigned short )0;
                    sqlstm.sqtdso[2] = (unsigned short )0;
                    sqlstm.sqhstv[3] = (         void  *)&ar_pat_bill_doc_type_code;
                    sqlstm.sqhstl[3] = (unsigned int  )9;
                    sqlstm.sqhsts[3] = (         int  )0;
                    sqlstm.sqindv[3] = (         void  *)0;
                    sqlstm.sqinds[3] = (         int  )0;
                    sqlstm.sqharm[3] = (unsigned int  )0;
                    sqlstm.sqadto[3] = (unsigned short )0;
                    sqlstm.sqtdso[3] = (unsigned short )0;
                    sqlstm.sqhstv[4] = (         void  *)&ar_pat_bill_num;
                    sqlstm.sqhstl[4] = (unsigned int  )11;
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




						
				if (ERROR)
					err_mesg("SELECT  failed on   AR_PATIENT_DTLS",0,"");

				if (NOT_FOUND)
					error_insert_null("   0","SY1470","Field = AR PAT DTLS");

              if (l_adj_type == 'C')
              {
                 if (  ar_pat_abs_amount > pending_amt )
			     {
                     error_insert("   0","AR2393");
                  }
			   }
		 
			}

    		 if (doubcmp(ar_pat_abs_tot_amount,l_ar_ihdr_doc_amt) != 0) 
                    error_insert_null("   0","AR2180","Mismatch with Line Amt and Bill Amt");

	  }


     

	 /**************************************************************/

    }
#ifdef DEBUG
   printf("after validate dn inv header\n");
#endif
}   /* end of validate dn inv header*/




