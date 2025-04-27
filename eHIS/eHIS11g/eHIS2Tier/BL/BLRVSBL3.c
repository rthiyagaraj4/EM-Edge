
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/BLRVSBL3.PC"
};


static unsigned int sqlctx = 1288468979;


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
            void  *sqhstv[46];
   unsigned int   sqhstl[46];
            int   sqhsts[46];
            void  *sqindv[46];
            int   sqinds[46];
   unsigned int   sqharm[46];
   unsigned int   *sqharc[46];
   unsigned short  sqadto[46];
   unsigned short  sqtdso[46];
} sqlstm = {12,46};

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

 static const char *sq0020 = 
"TO_CHAR(POLICY_EXPIRY_DATE,'DD/MM/YYYY') ,CASH_COUNTER_CODE ,SHIFT_ID ,CASHI\
ER_BY_ID ,NVL(SPL_AGENCY_DEP_ADJ_AMT,0)  from BL_BILL_PRINT_TEMP where SESSION\
_ID=:b0 order by 1,2            ";

 static const char *sq0022 = 
"select A.DOC_TYPE_CODE ,A.PRT_GRP_HDR_CODE ,A.PRT_GRP_LINE_CODE ,sum(NVL(A.G\
ROSS_AMT,0)) GROSS_AMT ,sum(NVL(A.NET_AMT,0)) ,C.LONG_DESC ,D.LONG_DESC ,NVL(A\
.MPI_ID,(A.DOC_TYPE_CODE||A.DOC_NUM)) MPI_ID ,sum((NVL(A.SERV_DISC_AMT,0)+NVL(\
MAN_DISC_AMT,0)))  from BL_BILL_LINE A ,BL_BLNG_PRT_GRP_HDR C ,BL_BLNG_PRT_GRP\
_LINE D where (((((A.DOC_TYPE_CODE between :b0 and :b1 and A.DOC_NUM between T\
O_NUMBER(:b2) and TO_NUMBER(:b3)) and C.PRT_GRP_HDR_CODE=D.PRT_GRP_HDR_CODE) a\
nd A.PRT_GRP_HDR_CODE=D.PRT_GRP_HDR_CODE(+)) and A.PRT_GRP_LINE_CODE=D.PRT_GRP\
_LINE_CODE(+)) and NVL(A.MPI_ID,(A.DOC_TYPE_CODE||A.DOC_NUM))=:b4) group by A.\
DOC_TYPE_CODE,A.PRT_GRP_HDR_CODE,A.PRT_GRP_LINE_CODE,C.LONG_DESC,D.LONG_DESC,N\
VL(A.MPI_ID,(A.DOC_TYPE_CODE||A.DOC_NUM)) order by A.PRT_GRP_HDR_CODE,A.PRT_GR\
P_LINE_CODE            ";

 static const char *sq0023 = 
"select A.DOC_TYPE_CODE ,A.DOC_NUM ,TO_CHAR(A.DOC_DATE,'DD/MM/YYYY') ,DECODE(\
:b0,'Y',nvl(A.BILL_AMT,0),nvl(A.GROSS_AMT,0)) BILL_TOT_AMT ,A.MPI_IND ,A.MPI_I\
D MPI_ID ,B.SHORT_NAME  from BL_BILL_HDR A ,AR_CUSTOMER B where (((((((A.DOC_T\
YPE_CODE between :b1 and :b2 and A.DOC_NUM between TO_NUMBER(:b3) and TO_NUMBE\
R(:b4)) and A.CUST_CODE=B.CUST_CODE(+)) and A.DOC_TYPE_CODE=:b5) and A.DOC_NUM\
<>:b6) and TO_CHAR(A.DOC_DATE,'DD/MM/YYYY')=:b7) and b.acc_entity_code(+)=:b8)\
 and NVL(A.MPI_ID,(A.DOC_TYPE_CODE||A.DOC_NUM))=:b9)           ";

 static const char *sq0025 = 
"select DOC_TYPE_CODE ,((DOC_NUMBER||'   ')||TO_CHAR(DOC_DATE,'DD/MM/YYYY')) \
DOC_NUMBER ,PATIENT_ID ,EPISODE_ID ,DOC_AMT  from BL_RECEIPT_REFUND_HDR where \
(((((EPISODE_TYPE in ('E','O','R') and RECPT_NATURE_CODE='AD') and ((EPISODE_I\
D=:b0 and :b1 in ('E','O')) or :b1='R')) and PATIENT_ID=:b3) and (DOC_TYPE_COD\
E,DOC_NUMBER) in (select ORG_DOC_TYPE_CODE ,ORG_DOC_NUM  from BL_PATIENT_LEDGE\
R where ((RECPT_NATURE_CODE='AD' and AD_PR_ADJ_BILL_DOC_TYPE=:b4) and AD_PR_AD\
J_BILL_DOC_NUM=:b5))) and CASH_COUNTER_FACILITY_ID=:b6)           ";

 static const char *sq0026 = 
"select DOC_TYPE_CODE ,((DOC_NUMBER||'   ')||TO_CHAR(DOC_DATE,'DD/MM/YYYY')) \
DOC_NUMBER ,PATIENT_ID ,EPISODE_ID ,DOC_AMT  from BL_RECEIPT_REFUND_HDR where \
(((((EPISODE_TYPE in ('E','O','R') and CASH_COUNTER_FACILITY_ID=:b0) and RECPT\
_NATURE_CODE='PR') and ((EPISODE_ID=:b1 and :b2 in ('E','O')) or :b2='R')) and\
 (DOC_TYPE_CODE,DOC_NUMBER) in (select ORG_DOC_TYPE_CODE ,ORG_DOC_NUM  from BL\
_PATIENT_LEDGER where ((RECPT_NATURE_CODE='PR' and AD_PR_ADJ_BILL_DOC_TYPE=:b4\
) and AD_PR_ADJ_BILL_DOC_NUM=:b5))) and PATIENT_ID=:b6)           ";

 static const char *sq0027 = 
"IND=B.PACKAGE_IND) and B.BLNG_SERV_CODE=C.BLNG_SERV_CODE(+)) and B.PACKAGE_S\
ERVICE_CODE=D.PACKAGE_CODE(+)) and A.AMT_SIGN_IND=0) and (trx_status is null  \
or ((trx_status='C' and (orig_doc_ref is null  and 0=(select count(1)  from bl\
_patient_charges_folio where (((((operating_facility_id=:b0 and bill_doc_type_\
code=:b1) and bill_doc_num=:b2) and orig_doc_ref=b.trx_doc_ref) and orig_doc_r\
ef_line_num=b.trx_doc_ref_line_num) and orig_doc_ref_seq_num=b.trx_doc_ref_seq\
_num)))) or (orig_doc_ref is  not null  and 0=(select count(1)  from bl_patien\
t_charges_folio where (((((operating_facility_id=:b0 and bill_doc_type_code=:b\
1) and bill_doc_num=:b2) and trx_doc_ref=b.orig_doc_ref) and trx_doc_ref_line_\
num=b.orig_doc_ref_line_num) and trx_doc_ref_seq_num=b.orig_doc_ref_seq_num)))\
))) order by 3,1            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,518,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,300,0,4,585,0,0,8,2,0,1,0,1,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,1,9,0,0,
83,0,0,3,104,0,4,662,0,0,5,4,0,1,0,1,3,0,0,1,3,0,0,1,9,0,0,1,9,0,0,2,9,0,0,
118,0,0,4,104,0,4,672,0,0,5,4,0,1,0,1,3,0,0,1,3,0,0,1,9,0,0,1,9,0,0,2,9,0,0,
153,0,0,5,110,0,6,725,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,1,0,0,2,9,0,0,
184,0,0,6,420,0,4,777,0,0,7,6,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,
227,0,0,7,199,0,4,934,0,0,6,2,0,1,0,2,4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,1,9,0,0,1,
9,0,0,
266,0,0,8,153,0,4,1014,0,0,3,2,0,1,0,2,4,0,0,1,9,0,0,1,9,0,0,
293,0,0,9,85,0,5,1133,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
316,0,0,10,308,0,6,1197,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
2,9,0,0,
355,0,0,11,53,0,2,1239,0,0,1,1,0,1,0,1,9,0,0,
374,0,0,12,91,0,2,1245,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
397,0,0,13,314,0,5,1256,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,
436,0,0,14,0,0,29,1265,0,0,0,0,0,1,0,
451,0,0,15,365,0,6,1287,0,0,5,5,0,1,0,1,9,0,0,3,9,0,0,2,9,0,0,3,9,0,0,2,9,0,0,
486,0,0,16,292,0,6,1327,0,0,5,5,0,1,0,1,9,0,0,2,9,0,0,2,9,0,0,3,9,0,0,2,9,0,0,
521,0,0,17,184,0,6,1366,0,0,3,3,0,1,0,1,9,0,0,3,9,0,0,3,9,0,0,
548,0,0,18,1517,0,6,1391,0,0,13,13,0,1,0,1,9,0,0,1,9,0,0,2,1,0,0,3,3,0,0,3,3,0,
0,1,9,0,0,1,9,0,0,2,9,0,0,2,9,0,0,3,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
615,0,0,19,443,0,4,1544,0,0,22,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,1,0,0,2,1,0,0,2,1,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,1,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
718,0,0,20,1210,0,9,1683,0,0,1,1,0,1,0,1,9,0,0,
737,0,0,20,0,0,13,1771,0,0,46,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,
2,4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,4,0,0,
936,0,0,20,0,0,15,1880,0,0,0,0,0,1,0,
951,0,0,21,99,0,4,1893,0,0,3,2,0,1,0,2,1,0,0,1,9,0,0,1,9,0,0,
978,0,0,24,268,0,4,1981,0,0,10,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
1033,0,0,22,801,0,9,2076,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1068,0,0,22,0,0,13,2103,0,0,9,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,
1119,0,0,27,0,0,13,2233,0,0,10,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,4,0,0,
2,4,0,0,2,4,0,0,2,3,0,0,2,3,0,0,2,9,0,0,
1174,0,0,23,529,0,9,2266,0,0,10,10,0,1,0,1,1,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1229,0,0,23,0,0,13,2291,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,
1272,0,0,25,532,0,9,2323,0,0,7,7,0,1,0,1,9,0,0,1,1,0,0,1,1,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,
1315,0,0,25,0,0,13,2345,0,0,5,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,
1350,0,0,26,532,0,9,2373,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,1,0,0,1,1,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,
1393,0,0,26,0,0,13,2395,0,0,5,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,
1428,0,0,28,157,0,4,2442,0,0,6,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,
1,9,0,0,
1467,0,0,29,75,0,4,2466,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1490,0,0,30,57,0,4,2476,0,0,1,0,0,1,0,2,9,0,0,
1509,0,0,27,1830,0,9,3257,0,0,20,20,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1604,0,0,27,0,0,15,3333,0,0,0,0,0,1,0,
1619,0,0,31,118,0,4,3352,0,0,3,2,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,
1646,0,0,32,218,0,4,3368,0,0,6,5,0,1,0,1,1,0,0,2,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,
1685,0,0,33,148,0,6,3380,0,0,3,3,0,1,0,3,4,0,0,1,9,0,0,2,4,0,0,
1712,0,0,34,94,0,4,3417,0,0,3,2,0,1,0,2,4,0,0,1,9,0,0,1,9,0,0,
1739,0,0,35,65,0,4,3527,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1762,0,0,36,142,0,4,3532,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1785,0,0,37,108,0,4,3540,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
1812,0,0,38,32,0,4,3547,0,0,1,0,0,1,0,2,9,0,0,
1831,0,0,39,283,0,4,3612,0,0,6,5,0,1,0,2,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,1,0,0,
1,1,0,0,
1870,0,0,40,128,0,4,3624,0,0,2,1,0,1,0,2,4,0,0,1,9,0,0,
1893,0,0,41,268,0,4,4161,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1916,0,0,42,91,0,4,4174,0,0,1,0,0,1,0,2,9,0,0,
1935,0,0,43,268,0,4,4186,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1958,0,0,44,91,0,4,4198,0,0,1,0,0,1,0,2,9,0,0,
1977,0,0,45,268,0,4,4209,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
2000,0,0,46,91,0,4,4221,0,0,1,0,0,1,0,2,9,0,0,
2019,0,0,47,268,0,4,4232,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
2042,0,0,48,91,0,4,4244,0,0,1,0,0,1,0,2,9,0,0,
2061,0,0,49,268,0,4,4254,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
2084,0,0,50,91,0,4,4266,0,0,1,0,0,1,0,2,9,0,0,
2103,0,0,51,268,0,4,4277,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
2126,0,0,52,91,0,4,4289,0,0,1,0,0,1,0,2,9,0,0,
2145,0,0,53,255,0,4,4300,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
2168,0,0,54,91,0,4,4312,0,0,1,0,0,1,0,2,9,0,0,
2187,0,0,55,255,0,4,4323,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
2210,0,0,56,91,0,4,4335,0,0,1,0,0,1,0,2,9,0,0,
2229,0,0,57,268,0,4,4346,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
2252,0,0,58,91,0,4,4358,0,0,1,0,0,1,0,2,9,0,0,
2271,0,0,59,268,0,4,4369,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
2294,0,0,60,91,0,4,4381,0,0,1,0,0,1,0,2,9,0,0,
2313,0,0,61,268,0,4,4392,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
2336,0,0,62,91,0,4,4404,0,0,1,0,0,1,0,2,9,0,0,
2355,0,0,63,268,0,4,4414,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
2378,0,0,64,91,0,4,4426,0,0,1,0,0,1,0,2,9,0,0,
2397,0,0,65,268,0,4,4436,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
2420,0,0,66,91,0,4,4448,0,0,1,0,0,1,0,2,9,0,0,
2439,0,0,67,268,0,4,4459,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
2462,0,0,68,91,0,4,4471,0,0,1,0,0,1,0,2,9,0,0,
2481,0,0,69,268,0,4,4482,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
2504,0,0,70,91,0,4,4494,0,0,1,0,0,1,0,2,9,0,0,
2523,0,0,71,268,0,4,4504,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
2546,0,0,72,91,0,4,4516,0,0,1,0,0,1,0,2,9,0,0,
2565,0,0,73,268,0,4,4527,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
2588,0,0,74,91,0,4,4539,0,0,1,0,0,1,0,2,9,0,0,
2607,0,0,75,268,0,4,4550,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
2630,0,0,76,91,0,4,4562,0,0,1,0,0,1,0,2,9,0,0,
2649,0,0,77,268,0,4,4572,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
2672,0,0,78,91,0,4,4584,0,0,1,0,0,1,0,2,9,0,0,
2691,0,0,79,268,0,4,4595,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
2714,0,0,80,91,0,4,4607,0,0,1,0,0,1,0,2,9,0,0,
2733,0,0,81,268,0,4,4617,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
2756,0,0,82,91,0,4,4629,0,0,1,0,0,1,0,2,9,0,0,
2775,0,0,83,268,0,4,4640,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
2798,0,0,84,91,0,4,4652,0,0,1,0,0,1,0,2,9,0,0,
2817,0,0,85,268,0,4,4662,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
2840,0,0,86,91,0,4,4674,0,0,1,0,0,1,0,2,9,0,0,
2859,0,0,87,268,0,4,4684,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
2882,0,0,88,91,0,4,4696,0,0,1,0,0,1,0,2,9,0,0,
2901,0,0,89,268,0,4,4707,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
2924,0,0,90,91,0,4,4719,0,0,1,0,0,1,0,2,9,0,0,
2943,0,0,91,268,0,4,4729,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
2966,0,0,92,91,0,4,4741,0,0,1,0,0,1,0,2,9,0,0,
2985,0,0,93,268,0,4,4752,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
3008,0,0,94,91,0,4,4764,0,0,1,0,0,1,0,2,9,0,0,
3027,0,0,95,268,0,4,4774,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
3050,0,0,96,91,0,4,4786,0,0,1,0,0,1,0,2,9,0,0,
3069,0,0,97,255,0,4,4797,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
3092,0,0,98,91,0,4,4809,0,0,1,0,0,1,0,2,9,0,0,
3111,0,0,99,350,0,4,4821,0,0,3,2,0,1,0,1,3,0,0,2,9,0,0,1,9,0,0,
3138,0,0,100,268,0,4,4834,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
3161,0,0,101,91,0,4,4847,0,0,1,0,0,1,0,2,9,0,0,
3180,0,0,102,268,0,4,4858,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
3203,0,0,103,91,0,4,4870,0,0,1,0,0,1,0,2,9,0,0,
3222,0,0,104,350,0,4,4882,0,0,3,2,0,1,0,1,3,0,0,2,9,0,0,1,9,0,0,
3249,0,0,105,268,0,4,4894,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
3272,0,0,106,91,0,4,4907,0,0,1,0,0,1,0,2,9,0,0,
3291,0,0,107,350,0,4,4919,0,0,3,2,0,1,0,1,3,0,0,2,9,0,0,1,9,0,0,
3318,0,0,108,268,0,4,4931,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
3341,0,0,109,91,0,4,4945,0,0,1,0,0,1,0,2,9,0,0,
3360,0,0,110,268,0,4,4955,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
3383,0,0,111,91,0,4,4967,0,0,1,0,0,1,0,2,9,0,0,
3402,0,0,112,268,0,4,4977,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
3425,0,0,113,91,0,4,4989,0,0,1,0,0,1,0,2,9,0,0,
3444,0,0,114,268,0,4,4999,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
3467,0,0,115,91,0,4,5011,0,0,1,0,0,1,0,2,9,0,0,
3486,0,0,116,350,0,4,5023,0,0,3,2,0,1,0,1,3,0,0,2,9,0,0,1,9,0,0,
3513,0,0,117,198,0,4,5035,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
3536,0,0,118,350,0,4,5047,0,0,3,2,0,1,0,1,3,0,0,2,9,0,0,1,9,0,0,
3563,0,0,119,198,0,4,5059,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
3586,0,0,120,248,0,4,5072,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
3609,0,0,121,91,0,4,5084,0,0,1,0,0,1,0,2,9,0,0,
3628,0,0,122,248,0,4,5096,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
3651,0,0,123,91,0,4,5108,0,0,1,0,0,1,0,2,9,0,0,
3670,0,0,124,248,0,4,5119,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
3693,0,0,125,91,0,4,5131,0,0,1,0,0,1,0,2,9,0,0,
3712,0,0,126,248,0,4,5143,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
3735,0,0,127,91,0,4,5155,0,0,1,0,0,1,0,2,9,0,0,
3754,0,0,128,248,0,4,5167,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
3777,0,0,129,91,0,4,5179,0,0,1,0,0,1,0,2,9,0,0,
3796,0,0,130,248,0,4,5191,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
3819,0,0,131,91,0,4,5203,0,0,1,0,0,1,0,2,9,0,0,
3838,0,0,132,248,0,4,5215,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
3861,0,0,133,91,0,4,5227,0,0,1,0,0,1,0,2,9,0,0,
3880,0,0,134,248,0,4,5239,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
3903,0,0,135,91,0,4,5251,0,0,1,0,0,1,0,2,9,0,0,
3922,0,0,136,248,0,4,5266,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
3945,0,0,137,91,0,4,5278,0,0,1,0,0,1,0,2,9,0,0,
3964,0,0,138,248,0,4,5291,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
3987,0,0,139,91,0,4,5303,0,0,1,0,0,1,0,2,9,0,0,
4006,0,0,140,248,0,4,5315,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
4029,0,0,141,91,0,4,5327,0,0,1,0,0,1,0,2,9,0,0,
4048,0,0,142,248,0,4,5341,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
4071,0,0,143,91,0,4,5353,0,0,1,0,0,1,0,2,9,0,0,
4090,0,0,144,248,0,4,5365,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
4113,0,0,145,91,0,4,5377,0,0,1,0,0,1,0,2,9,0,0,
4132,0,0,146,248,0,4,5390,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
4155,0,0,147,91,0,4,5402,0,0,1,0,0,1,0,2,9,0,0,
4174,0,0,148,248,0,4,5414,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
4197,0,0,149,91,0,4,5426,0,0,1,0,0,1,0,2,9,0,0,
4216,0,0,150,248,0,4,5437,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
4239,0,0,151,91,0,4,5449,0,0,1,0,0,1,0,2,9,0,0,
4258,0,0,152,248,0,4,5461,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
4281,0,0,153,91,0,4,5473,0,0,1,0,0,1,0,2,9,0,0,
4300,0,0,154,248,0,4,5483,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
4323,0,0,155,91,0,4,5495,0,0,1,0,0,1,0,2,9,0,0,
4342,0,0,156,248,0,4,5505,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
4365,0,0,157,91,0,4,5517,0,0,1,0,0,1,0,2,9,0,0,
4384,0,0,158,248,0,4,5527,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
4407,0,0,159,91,0,4,5539,0,0,1,0,0,1,0,2,9,0,0,
4426,0,0,160,248,0,4,5549,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
4449,0,0,161,91,0,4,5561,0,0,1,0,0,1,0,2,9,0,0,
4468,0,0,162,248,0,4,5571,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
4491,0,0,163,91,0,4,5583,0,0,1,0,0,1,0,2,9,0,0,
4510,0,0,164,248,0,4,5594,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
4533,0,0,165,91,0,4,5606,0,0,1,0,0,1,0,2,9,0,0,
4552,0,0,166,248,0,4,5616,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
4575,0,0,167,91,0,4,5628,0,0,1,0,0,1,0,2,9,0,0,
4594,0,0,168,248,0,4,5638,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
4617,0,0,169,91,0,4,5650,0,0,1,0,0,1,0,2,9,0,0,
4636,0,0,22,0,0,15,5832,0,0,0,0,0,1,0,
4651,0,0,26,0,0,15,5838,0,0,0,0,0,1,0,
4666,0,0,25,0,0,15,5843,0,0,0,0,0,1,0,
4681,0,0,23,0,0,15,5848,0,0,0,0,0,1,0,
4696,0,0,170,97,0,4,5892,0,0,2,1,0,1,0,2,3,0,0,1,9,0,0,
4719,0,0,171,228,0,4,5963,0,0,7,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,1,9,0,0,
4762,0,0,172,255,0,4,5984,0,0,7,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,1,9,0,0,
4805,0,0,173,65,0,4,6015,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
4828,0,0,174,150,0,4,6089,0,0,7,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,1,9,0,0,
4871,0,0,175,65,0,4,6126,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
4894,0,0,176,177,0,4,6304,0,0,7,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,1,9,0,0,
4937,0,0,177,65,0,4,6347,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
4960,0,0,178,363,0,4,6528,0,0,7,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,
5003,0,0,179,254,0,4,6543,0,0,6,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,
5042,0,0,180,74,0,4,6579,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
5065,0,0,181,103,0,4,6665,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
5088,0,0,182,139,0,4,6679,0,0,4,3,0,1,0,2,1,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
5119,0,0,183,140,0,4,6688,0,0,3,2,0,1,0,2,1,0,0,1,9,0,0,1,9,0,0,
5146,0,0,184,139,0,4,6703,0,0,4,3,0,1,0,2,1,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
5177,0,0,185,140,0,4,6712,0,0,3,2,0,1,0,2,1,0,0,1,9,0,0,1,9,0,0,
};


/************************************************************************/
/*  OCS MEDICOM VER 1.10                                                */
/************************************************************************/
/* PROGRAM NAME          :	BLRVSBL1.PC                             */
/* AUTHOR                :	K.SARAVANAN                             */
/* DATE WRITTEN          :	14-AUG-2003                             */
/* DATE MODIFIED         :						*/
/* CALLED FROM           :						*/
/*                                                                      */
/* FUNCTION              :	TO PRINT CASH BILL CUM RECEIPT,         */
/*				PRINT_VISIT_BILL, PRINT_VISIT_BILL_NO_DISC,*/
/*				PRINT VISIT BILL - NO SETTLEMENT DTLS	*/
/************************************************************************/
/* UPGRADED TO 4.1 */

#include <stdio.h>     
#include <string.h>       
#include <bl.h>  



#define OERROR (sqlca.sqlcode < 0)

#define NODATAFOUND sqlca.sqlcode == 1403
#define RESOURCE_BUSY (sqlca.sqlcode == -54)


#define INIT_MESG "Visit Bill Printing in progress"

#define ONLINE_PRINTING 1

#define DEBUG  1
        
#define maxlines 11

#define LEGEND 1

#define LENGTH_WORDS 80 

#define ERR_MESG  4

#define ESC     0x1B

/* EXEC SQL BEGIN DECLARE SECTION; */ 

		
/* VARCHAR nd_fm_doc_type  [31],
		trx_type 		[2],
		uid_pwd      	[132],		
		nd_episode_id 	[9],
		nd_visit_id 	[5],
		nd_fm_doc_num   [31],
		nd_to_doc_type  [31],  
		nd_to_doc_num   [31],
		nd_fm_doc_date  [31],
		d_cashfacility_id [3],
		nd_to_doc_date  [31],
		nd_facility_name[31],
		nd_acc_name	[31],
		nd_facility	[31],
		p_cash_counter	[3],
		p_document_id	[31],
		p_shift		[2],
		nd_pgm_date	[13],
		nd_session_id	[16],
		nd_ws_no	[40],
		l_printer_ids   [1000],
		l_printer_names [1000],
		l_printer_types [1000],
	        l_queue_names   [1000],
	        l_no_of_copies  [1000],
	        l_errortext     [1000],
		l_logo_yniflaser[1000],
		LOGO_DIR[1000],
	        l_logo_name[1000],
		l_errorlevel[10],
		l_sysmessageid[10],		
  	        currency 	[16],
	        sub_cur  	[10],
	        nn_cc_code      [3],
	        nd_curr_date    [20],
                nn_shift_id     [2],
		nn_cc_id        [31],
                nn_cc_name      [16],
		nd_user		[31],
		nd_calling_pgm_id[10],
		nd_logo_pgm_id[1000],
		bill_title[40]; */ 
struct { unsigned short len; unsigned char arr[31]; } nd_fm_doc_type;

struct { unsigned short len; unsigned char arr[2]; } trx_type;

struct { unsigned short len; unsigned char arr[132]; } uid_pwd;

struct { unsigned short len; unsigned char arr[9]; } nd_episode_id;

struct { unsigned short len; unsigned char arr[5]; } nd_visit_id;

struct { unsigned short len; unsigned char arr[31]; } nd_fm_doc_num;

struct { unsigned short len; unsigned char arr[31]; } nd_to_doc_type;

struct { unsigned short len; unsigned char arr[31]; } nd_to_doc_num;

struct { unsigned short len; unsigned char arr[31]; } nd_fm_doc_date;

struct { unsigned short len; unsigned char arr[3]; } d_cashfacility_id;

struct { unsigned short len; unsigned char arr[31]; } nd_to_doc_date;

struct { unsigned short len; unsigned char arr[31]; } nd_facility_name;

struct { unsigned short len; unsigned char arr[31]; } nd_acc_name;

struct { unsigned short len; unsigned char arr[31]; } nd_facility;

struct { unsigned short len; unsigned char arr[3]; } p_cash_counter;

struct { unsigned short len; unsigned char arr[31]; } p_document_id;

struct { unsigned short len; unsigned char arr[2]; } p_shift;

struct { unsigned short len; unsigned char arr[13]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[40]; } nd_ws_no;

struct { unsigned short len; unsigned char arr[1000]; } l_printer_ids;

struct { unsigned short len; unsigned char arr[1000]; } l_printer_names;

struct { unsigned short len; unsigned char arr[1000]; } l_printer_types;

struct { unsigned short len; unsigned char arr[1000]; } l_queue_names;

struct { unsigned short len; unsigned char arr[1000]; } l_no_of_copies;

struct { unsigned short len; unsigned char arr[1000]; } l_errortext;

struct { unsigned short len; unsigned char arr[1000]; } l_logo_yniflaser;

struct { unsigned short len; unsigned char arr[1000]; } LOGO_DIR;

struct { unsigned short len; unsigned char arr[1000]; } l_logo_name;

struct { unsigned short len; unsigned char arr[10]; } l_errorlevel;

struct { unsigned short len; unsigned char arr[10]; } l_sysmessageid;

struct { unsigned short len; unsigned char arr[16]; } currency;

struct { unsigned short len; unsigned char arr[10]; } sub_cur;

struct { unsigned short len; unsigned char arr[3]; } nn_cc_code;

struct { unsigned short len; unsigned char arr[20]; } nd_curr_date;

struct { unsigned short len; unsigned char arr[2]; } nn_shift_id;

struct { unsigned short len; unsigned char arr[31]; } nn_cc_id;

struct { unsigned short len; unsigned char arr[16]; } nn_cc_name;

struct { unsigned short len; unsigned char arr[31]; } nd_user;

struct { unsigned short len; unsigned char arr[10]; } nd_calling_pgm_id;

struct { unsigned short len; unsigned char arr[1000]; } nd_logo_pgm_id;

struct { unsigned short len; unsigned char arr[40]; } bill_title;


/* VARCHAR dc_doc_type_code [7],
	    d_no			 [17],
	    d_doc_date		 [11],
	    dc_episode_id	 [9],
	    dc_epi_id		 [9],
	    dc_visit_id		 [5],
	    dc_admn_date	 [17],
	    dc_physician_id  [16],
	    dc_blng_grp_id	 [3],
	    dc_patient_id	 [21],
	    dc_cust_code	 [9],
	    dc_bill_type_code [3],
	    dc_clinic_code [5],
	    dc_bill_print_flag [2], 
	dc_credit_doc_ref_desc [51],
        dc_short_name [81],
	dc_short_name1 [81],
	dc_short_name2 [81],
	dc_short_name3 [81],
        dc_short_name_loc_lang [81], 
	dc_date_of_birth [11],
        dc_sex [10],
        dc_full_name [61],
        dc_long_name [61],
	dc_long_desc [51],
	    dc_blng_grp_desc [51],
 	    dc_short_desc [51],
        dc_ind [10],
	    dc_mpi_id [100],
   	    dc_credit_doc_ref_date [11],
	    dc_policy_type_code    [21] ,  
	    dc_policy_number        [31],
	    dc_policy_expiry_date [11],
		d1_doc_type_code [7],
		d1_prt_grp_hdr_code [3],
		d1_prt_grp_line_code [3],
        d1_long_desc [51],
        d1_long_desc1 [51],
		d1_mpi_id [47],
		d2_doc_type_code [7],
		d2_doc_date [11],
		d2_mpi_ind [2],
		d2_mpi_id [47],
		d2_short_name[16],
		d3_doc_type_code [7],
		d3_patient_id [21],
		d3_episode_id [9],
		d4_doc_type_code [7],
		d4_patient_id [21],
		d4_episode_id [9],
	
		d_bill_trx_type_code [41],
		d_bill_nature_code [2],
		d_nationality_num [21],
		d_doc_num [9],
		d2_doc_num [9],
		d3_doc_num [20],
		d4_doc_num [20],
		dc_tot_dep_paid_amt [21],
		last_recpt_doc_type_code [7],
		last_recpt_doc_num [9],
		slmt_short_desc [16],
		slmt_doc_ref_desc [21],
		slmt_doc_ref_date [11],
		slmt_remarks [31],
		temp  [10],
	        d_service_code[11],
	        d_service_date[12],
	        d_service_desc[41],
		d_dis_date[17],
		l_dflt_bill_print_in_summ_yn[5],

		l_line1[50],
		l_line2[50],
		l_line3[50],
		l_line4[50],
		l_line5[50],
		l_line6[50],
		l_line7[50],

		l_bill_contact_name[50],

		l_bill_contact_name_p[50],
		l_bill_contact_name_p1[50],
		l_bill_contact_name_p2[50],

		l_bill_contact_name_c[50],
		l_bill_contact_name_c1[50],
		l_bill_contact_name_c2[50],

		l_bill_contact_name_title[50],
		l_bill_contact_name_title_p[50],
		l_bill_contact_name_title_p1[50],
		l_bill_contact_name_title_p2[50],

		l_bill_contact_name_title_c[50],
		l_bill_contact_name_title_c1[50],
		l_bill_contact_name_title_c2[50],

		
		l_bill_long_desc[40],

		l_bill_long_desc_p[40],
		l_bill_long_desc_p1[40],
		l_bill_long_desc_p2[40],

		l_bill_long_desc_c[40],
		l_bill_long_desc_c1[40],
		l_bill_long_desc_c2[40],

		l_bill_add1_desc[40],

		l_bill_add1_desc_p[40],
		l_bill_add1_desc_p1[40],
		l_bill_add1_desc_p2[40],

		l_bill_add1_desc_c[40],
		l_bill_add1_desc_c1[40],
		l_bill_add1_desc_c2[40],

		l_bill_add2_desc[40],

		l_bill_add2_desc_p[40],
		l_bill_add2_desc_p1[40],
		l_bill_add2_desc_p2[40],

		l_bill_add2_desc_c[40],
		l_bill_add2_desc_c1[40],
		l_bill_add2_desc_c2[40],

		l_bill_add3_desc[40],

		l_bill_add3_desc_p[40],
		l_bill_add3_desc_p1[40],
		l_bill_add3_desc_p2[40],

		l_bill_add3_desc_c[40],
		l_bill_add3_desc_c1[40],
		l_bill_add3_desc_c2[40],

		l_bill_add3_desc_temp[40],
		l_episode_settlement_ind[4],
		l_episode_cust_code[10],
		l_nric_number[25],
		l_gl_holder_name[61],
		l_gl_holder_name1[45],
		l_gl_holder_name2[45],
		l_gl_ic[1000],
		l_pat_reln_with_gl_holder[35],
		l_pat_reln_with_gl_holder1[35],
		l_pat_reln_with_gl_holder2[35],
		l_detail_report_flag[3],
		l_print_without_disc_func[4],
		l_no_settlement_details[5],
		l_credit_doc_ref_desc[30],
		l_credit_doc_ref_desc1[30],
		l_credit_doc_ref_desc2[30],
		nd_acc_entity_code[5],
		nd_facility_id[3]; */ 
struct { unsigned short len; unsigned char arr[7]; } dc_doc_type_code;

struct { unsigned short len; unsigned char arr[17]; } d_no;

struct { unsigned short len; unsigned char arr[11]; } d_doc_date;

struct { unsigned short len; unsigned char arr[9]; } dc_episode_id;

struct { unsigned short len; unsigned char arr[9]; } dc_epi_id;

struct { unsigned short len; unsigned char arr[5]; } dc_visit_id;

struct { unsigned short len; unsigned char arr[17]; } dc_admn_date;

struct { unsigned short len; unsigned char arr[16]; } dc_physician_id;

struct { unsigned short len; unsigned char arr[3]; } dc_blng_grp_id;

struct { unsigned short len; unsigned char arr[21]; } dc_patient_id;

struct { unsigned short len; unsigned char arr[9]; } dc_cust_code;

struct { unsigned short len; unsigned char arr[3]; } dc_bill_type_code;

struct { unsigned short len; unsigned char arr[5]; } dc_clinic_code;

struct { unsigned short len; unsigned char arr[2]; } dc_bill_print_flag;

struct { unsigned short len; unsigned char arr[51]; } dc_credit_doc_ref_desc;

struct { unsigned short len; unsigned char arr[81]; } dc_short_name;

struct { unsigned short len; unsigned char arr[81]; } dc_short_name1;

struct { unsigned short len; unsigned char arr[81]; } dc_short_name2;

struct { unsigned short len; unsigned char arr[81]; } dc_short_name3;

struct { unsigned short len; unsigned char arr[81]; } dc_short_name_loc_lang;

struct { unsigned short len; unsigned char arr[11]; } dc_date_of_birth;

struct { unsigned short len; unsigned char arr[10]; } dc_sex;

struct { unsigned short len; unsigned char arr[61]; } dc_full_name;

struct { unsigned short len; unsigned char arr[61]; } dc_long_name;

struct { unsigned short len; unsigned char arr[51]; } dc_long_desc;

struct { unsigned short len; unsigned char arr[51]; } dc_blng_grp_desc;

struct { unsigned short len; unsigned char arr[51]; } dc_short_desc;

struct { unsigned short len; unsigned char arr[10]; } dc_ind;

struct { unsigned short len; unsigned char arr[100]; } dc_mpi_id;

struct { unsigned short len; unsigned char arr[11]; } dc_credit_doc_ref_date;

struct { unsigned short len; unsigned char arr[21]; } dc_policy_type_code;

struct { unsigned short len; unsigned char arr[31]; } dc_policy_number;

struct { unsigned short len; unsigned char arr[11]; } dc_policy_expiry_date;

struct { unsigned short len; unsigned char arr[7]; } d1_doc_type_code;

struct { unsigned short len; unsigned char arr[3]; } d1_prt_grp_hdr_code;

struct { unsigned short len; unsigned char arr[3]; } d1_prt_grp_line_code;

struct { unsigned short len; unsigned char arr[51]; } d1_long_desc;

struct { unsigned short len; unsigned char arr[51]; } d1_long_desc1;

struct { unsigned short len; unsigned char arr[47]; } d1_mpi_id;

struct { unsigned short len; unsigned char arr[7]; } d2_doc_type_code;

struct { unsigned short len; unsigned char arr[11]; } d2_doc_date;

struct { unsigned short len; unsigned char arr[2]; } d2_mpi_ind;

struct { unsigned short len; unsigned char arr[47]; } d2_mpi_id;

struct { unsigned short len; unsigned char arr[16]; } d2_short_name;

struct { unsigned short len; unsigned char arr[7]; } d3_doc_type_code;

struct { unsigned short len; unsigned char arr[21]; } d3_patient_id;

struct { unsigned short len; unsigned char arr[9]; } d3_episode_id;

struct { unsigned short len; unsigned char arr[7]; } d4_doc_type_code;

struct { unsigned short len; unsigned char arr[21]; } d4_patient_id;

struct { unsigned short len; unsigned char arr[9]; } d4_episode_id;

struct { unsigned short len; unsigned char arr[41]; } d_bill_trx_type_code;

struct { unsigned short len; unsigned char arr[2]; } d_bill_nature_code;

struct { unsigned short len; unsigned char arr[21]; } d_nationality_num;

struct { unsigned short len; unsigned char arr[9]; } d_doc_num;

struct { unsigned short len; unsigned char arr[9]; } d2_doc_num;

struct { unsigned short len; unsigned char arr[20]; } d3_doc_num;

struct { unsigned short len; unsigned char arr[20]; } d4_doc_num;

struct { unsigned short len; unsigned char arr[21]; } dc_tot_dep_paid_amt;

struct { unsigned short len; unsigned char arr[7]; } last_recpt_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } last_recpt_doc_num;

struct { unsigned short len; unsigned char arr[16]; } slmt_short_desc;

struct { unsigned short len; unsigned char arr[21]; } slmt_doc_ref_desc;

struct { unsigned short len; unsigned char arr[11]; } slmt_doc_ref_date;

struct { unsigned short len; unsigned char arr[31]; } slmt_remarks;

struct { unsigned short len; unsigned char arr[10]; } temp;

struct { unsigned short len; unsigned char arr[11]; } d_service_code;

struct { unsigned short len; unsigned char arr[12]; } d_service_date;

struct { unsigned short len; unsigned char arr[41]; } d_service_desc;

struct { unsigned short len; unsigned char arr[17]; } d_dis_date;

struct { unsigned short len; unsigned char arr[5]; } l_dflt_bill_print_in_summ_yn;

struct { unsigned short len; unsigned char arr[50]; } l_line1;

struct { unsigned short len; unsigned char arr[50]; } l_line2;

struct { unsigned short len; unsigned char arr[50]; } l_line3;

struct { unsigned short len; unsigned char arr[50]; } l_line4;

struct { unsigned short len; unsigned char arr[50]; } l_line5;

struct { unsigned short len; unsigned char arr[50]; } l_line6;

struct { unsigned short len; unsigned char arr[50]; } l_line7;

struct { unsigned short len; unsigned char arr[50]; } l_bill_contact_name;

struct { unsigned short len; unsigned char arr[50]; } l_bill_contact_name_p;

struct { unsigned short len; unsigned char arr[50]; } l_bill_contact_name_p1;

struct { unsigned short len; unsigned char arr[50]; } l_bill_contact_name_p2;

struct { unsigned short len; unsigned char arr[50]; } l_bill_contact_name_c;

struct { unsigned short len; unsigned char arr[50]; } l_bill_contact_name_c1;

struct { unsigned short len; unsigned char arr[50]; } l_bill_contact_name_c2;

struct { unsigned short len; unsigned char arr[50]; } l_bill_contact_name_title;

struct { unsigned short len; unsigned char arr[50]; } l_bill_contact_name_title_p;

struct { unsigned short len; unsigned char arr[50]; } l_bill_contact_name_title_p1;

struct { unsigned short len; unsigned char arr[50]; } l_bill_contact_name_title_p2;

struct { unsigned short len; unsigned char arr[50]; } l_bill_contact_name_title_c;

struct { unsigned short len; unsigned char arr[50]; } l_bill_contact_name_title_c1;

struct { unsigned short len; unsigned char arr[50]; } l_bill_contact_name_title_c2;

struct { unsigned short len; unsigned char arr[40]; } l_bill_long_desc;

struct { unsigned short len; unsigned char arr[40]; } l_bill_long_desc_p;

struct { unsigned short len; unsigned char arr[40]; } l_bill_long_desc_p1;

struct { unsigned short len; unsigned char arr[40]; } l_bill_long_desc_p2;

struct { unsigned short len; unsigned char arr[40]; } l_bill_long_desc_c;

struct { unsigned short len; unsigned char arr[40]; } l_bill_long_desc_c1;

struct { unsigned short len; unsigned char arr[40]; } l_bill_long_desc_c2;

struct { unsigned short len; unsigned char arr[40]; } l_bill_add1_desc;

struct { unsigned short len; unsigned char arr[40]; } l_bill_add1_desc_p;

struct { unsigned short len; unsigned char arr[40]; } l_bill_add1_desc_p1;

struct { unsigned short len; unsigned char arr[40]; } l_bill_add1_desc_p2;

struct { unsigned short len; unsigned char arr[40]; } l_bill_add1_desc_c;

struct { unsigned short len; unsigned char arr[40]; } l_bill_add1_desc_c1;

struct { unsigned short len; unsigned char arr[40]; } l_bill_add1_desc_c2;

struct { unsigned short len; unsigned char arr[40]; } l_bill_add2_desc;

struct { unsigned short len; unsigned char arr[40]; } l_bill_add2_desc_p;

struct { unsigned short len; unsigned char arr[40]; } l_bill_add2_desc_p1;

struct { unsigned short len; unsigned char arr[40]; } l_bill_add2_desc_p2;

struct { unsigned short len; unsigned char arr[40]; } l_bill_add2_desc_c;

struct { unsigned short len; unsigned char arr[40]; } l_bill_add2_desc_c1;

struct { unsigned short len; unsigned char arr[40]; } l_bill_add2_desc_c2;

struct { unsigned short len; unsigned char arr[40]; } l_bill_add3_desc;

struct { unsigned short len; unsigned char arr[40]; } l_bill_add3_desc_p;

struct { unsigned short len; unsigned char arr[40]; } l_bill_add3_desc_p1;

struct { unsigned short len; unsigned char arr[40]; } l_bill_add3_desc_p2;

struct { unsigned short len; unsigned char arr[40]; } l_bill_add3_desc_c;

struct { unsigned short len; unsigned char arr[40]; } l_bill_add3_desc_c1;

struct { unsigned short len; unsigned char arr[40]; } l_bill_add3_desc_c2;

struct { unsigned short len; unsigned char arr[40]; } l_bill_add3_desc_temp;

struct { unsigned short len; unsigned char arr[4]; } l_episode_settlement_ind;

struct { unsigned short len; unsigned char arr[10]; } l_episode_cust_code;

struct { unsigned short len; unsigned char arr[25]; } l_nric_number;

struct { unsigned short len; unsigned char arr[61]; } l_gl_holder_name;

struct { unsigned short len; unsigned char arr[45]; } l_gl_holder_name1;

struct { unsigned short len; unsigned char arr[45]; } l_gl_holder_name2;

struct { unsigned short len; unsigned char arr[1000]; } l_gl_ic;

struct { unsigned short len; unsigned char arr[35]; } l_pat_reln_with_gl_holder;

struct { unsigned short len; unsigned char arr[35]; } l_pat_reln_with_gl_holder1;

struct { unsigned short len; unsigned char arr[35]; } l_pat_reln_with_gl_holder2;

struct { unsigned short len; unsigned char arr[3]; } l_detail_report_flag;

struct { unsigned short len; unsigned char arr[4]; } l_print_without_disc_func;

struct { unsigned short len; unsigned char arr[5]; } l_no_settlement_details;

struct { unsigned short len; unsigned char arr[30]; } l_credit_doc_ref_desc;

struct { unsigned short len; unsigned char arr[30]; } l_credit_doc_ref_desc1;

struct { unsigned short len; unsigned char arr[30]; } l_credit_doc_ref_desc2;

struct { unsigned short len; unsigned char arr[5]; } nd_acc_entity_code;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;


/* VARCHAR	nd_blng_grp			[31],
		nd_nationality		[16],
		nd_cash_counter		[16],
		nd_base_rate_qty	[20]; */ 
struct { unsigned short len; unsigned char arr[31]; } nd_blng_grp;

struct { unsigned short len; unsigned char arr[16]; } nd_nationality;

struct { unsigned short len; unsigned char arr[16]; } nd_cash_counter;

struct { unsigned short len; unsigned char arr[20]; } nd_base_rate_qty;
	

/* VARCHAR	d_bill_type_desc[31],
		d_remarks_1[61],
		d_remarks_2[61],
		d_remarks_3[61],
		d_remarks_4[61],
		d_remarks_5[61],
		d_remarks_6[61],
		d_remarks_7[61]; */ 
struct { unsigned short len; unsigned char arr[31]; } d_bill_type_desc;

struct { unsigned short len; unsigned char arr[61]; } d_remarks_1;

struct { unsigned short len; unsigned char arr[61]; } d_remarks_2;

struct { unsigned short len; unsigned char arr[61]; } d_remarks_3;

struct { unsigned short len; unsigned char arr[61]; } d_remarks_4;

struct { unsigned short len; unsigned char arr[61]; } d_remarks_5;

struct { unsigned short len; unsigned char arr[61]; } d_remarks_6;

struct { unsigned short len; unsigned char arr[61]; } d_remarks_7;



		
/* VARCHAR	nd_file_name [50],
		nd_hosp_name    [1000],
		nd_add		[1000],
		nd_add_ln	[1000],
		nd_add_ln1	[1000],
		nd_add_ln2	[1000],
		nd_add_ln3	[1000],
	        nd_tel_fax	[1000],
		nd_telfax	[1000],

		nd_lang_id	[4],
		loc_legend1	[201],
		loc_legend2	[201],
		loc_legend3	[201],
		loc_legend4	[201],
		loc_legend5	[201],
		loc_legend6	[201],
		loc_legend7	[201],
		loc_legend8	[201],
		loc_legend9	[201],
		loc_legend10[201],
		loc_legend11[201],
		loc_legend12[201],
		loc_legend13[201],
		loc_legend14[201],
		loc_legend15[201],
		loc_legend16[201],
		loc_legend17[201],
		loc_legend18[201],
		loc_legend19[201],
		loc_legend20[201],
		loc_legend21[201],
		loc_legend22[201],
		loc_legend23[201],
		loc_legend24[201],
		loc_legend25[201],
		loc_legend26[201],
		loc_legend27[201],
		loc_legend28[201],
		loc_legend29[201],
		loc_legend30[201],
		loc_legend31[201],
		loc_legend32[201],
		loc_legend33[201],
		loc_legend34[201],
		loc_legend35[201],
		loc_legend36[201],
		loc_legend37[201],
		loc_legend38[201],
					/o----22/09/2005----o/
		loc_legend39[201],
		loc_legend40[201],
		loc_legend41[201],
		loc_legend42[201],
		loc_legend43[201],
		loc_legend44[201],
		loc_legend45[201],
		loc_legend46[201],
		loc_legend47[201],
		loc_legend48[201],
		loc_legend49[201],
		loc_legend50[201],
		loc_legend51[201],
		loc_legend52[201],
		loc_legend53[201],
		loc_legend54[201],
		loc_legend55[201],
		loc_legend56[201],
		loc_legend57[201],
		loc_legend58[201],
		loc_legend59[201],
		loc_legend60[201],
		loc_legend61[201],
		loc_legend62[201],
		loc_legend63[201]; */ 
struct { unsigned short len; unsigned char arr[50]; } nd_file_name;

struct { unsigned short len; unsigned char arr[1000]; } nd_hosp_name;

struct { unsigned short len; unsigned char arr[1000]; } nd_add;

struct { unsigned short len; unsigned char arr[1000]; } nd_add_ln;

struct { unsigned short len; unsigned char arr[1000]; } nd_add_ln1;

struct { unsigned short len; unsigned char arr[1000]; } nd_add_ln2;

struct { unsigned short len; unsigned char arr[1000]; } nd_add_ln3;

struct { unsigned short len; unsigned char arr[1000]; } nd_tel_fax;

struct { unsigned short len; unsigned char arr[1000]; } nd_telfax;

struct { unsigned short len; unsigned char arr[4]; } nd_lang_id;

struct { unsigned short len; unsigned char arr[201]; } loc_legend1;

struct { unsigned short len; unsigned char arr[201]; } loc_legend2;

struct { unsigned short len; unsigned char arr[201]; } loc_legend3;

struct { unsigned short len; unsigned char arr[201]; } loc_legend4;

struct { unsigned short len; unsigned char arr[201]; } loc_legend5;

struct { unsigned short len; unsigned char arr[201]; } loc_legend6;

struct { unsigned short len; unsigned char arr[201]; } loc_legend7;

struct { unsigned short len; unsigned char arr[201]; } loc_legend8;

struct { unsigned short len; unsigned char arr[201]; } loc_legend9;

struct { unsigned short len; unsigned char arr[201]; } loc_legend10;

struct { unsigned short len; unsigned char arr[201]; } loc_legend11;

struct { unsigned short len; unsigned char arr[201]; } loc_legend12;

struct { unsigned short len; unsigned char arr[201]; } loc_legend13;

struct { unsigned short len; unsigned char arr[201]; } loc_legend14;

struct { unsigned short len; unsigned char arr[201]; } loc_legend15;

struct { unsigned short len; unsigned char arr[201]; } loc_legend16;

struct { unsigned short len; unsigned char arr[201]; } loc_legend17;

struct { unsigned short len; unsigned char arr[201]; } loc_legend18;

struct { unsigned short len; unsigned char arr[201]; } loc_legend19;

struct { unsigned short len; unsigned char arr[201]; } loc_legend20;

struct { unsigned short len; unsigned char arr[201]; } loc_legend21;

struct { unsigned short len; unsigned char arr[201]; } loc_legend22;

struct { unsigned short len; unsigned char arr[201]; } loc_legend23;

struct { unsigned short len; unsigned char arr[201]; } loc_legend24;

struct { unsigned short len; unsigned char arr[201]; } loc_legend25;

struct { unsigned short len; unsigned char arr[201]; } loc_legend26;

struct { unsigned short len; unsigned char arr[201]; } loc_legend27;

struct { unsigned short len; unsigned char arr[201]; } loc_legend28;

struct { unsigned short len; unsigned char arr[201]; } loc_legend29;

struct { unsigned short len; unsigned char arr[201]; } loc_legend30;

struct { unsigned short len; unsigned char arr[201]; } loc_legend31;

struct { unsigned short len; unsigned char arr[201]; } loc_legend32;

struct { unsigned short len; unsigned char arr[201]; } loc_legend33;

struct { unsigned short len; unsigned char arr[201]; } loc_legend34;

struct { unsigned short len; unsigned char arr[201]; } loc_legend35;

struct { unsigned short len; unsigned char arr[201]; } loc_legend36;

struct { unsigned short len; unsigned char arr[201]; } loc_legend37;

struct { unsigned short len; unsigned char arr[201]; } loc_legend38;

struct { unsigned short len; unsigned char arr[201]; } loc_legend39;

struct { unsigned short len; unsigned char arr[201]; } loc_legend40;

struct { unsigned short len; unsigned char arr[201]; } loc_legend41;

struct { unsigned short len; unsigned char arr[201]; } loc_legend42;

struct { unsigned short len; unsigned char arr[201]; } loc_legend43;

struct { unsigned short len; unsigned char arr[201]; } loc_legend44;

struct { unsigned short len; unsigned char arr[201]; } loc_legend45;

struct { unsigned short len; unsigned char arr[201]; } loc_legend46;

struct { unsigned short len; unsigned char arr[201]; } loc_legend47;

struct { unsigned short len; unsigned char arr[201]; } loc_legend48;

struct { unsigned short len; unsigned char arr[201]; } loc_legend49;

struct { unsigned short len; unsigned char arr[201]; } loc_legend50;

struct { unsigned short len; unsigned char arr[201]; } loc_legend51;

struct { unsigned short len; unsigned char arr[201]; } loc_legend52;

struct { unsigned short len; unsigned char arr[201]; } loc_legend53;

struct { unsigned short len; unsigned char arr[201]; } loc_legend54;

struct { unsigned short len; unsigned char arr[201]; } loc_legend55;

struct { unsigned short len; unsigned char arr[201]; } loc_legend56;

struct { unsigned short len; unsigned char arr[201]; } loc_legend57;

struct { unsigned short len; unsigned char arr[201]; } loc_legend58;

struct { unsigned short len; unsigned char arr[201]; } loc_legend59;

struct { unsigned short len; unsigned char arr[201]; } loc_legend60;

struct { unsigned short len; unsigned char arr[201]; } loc_legend61;

struct { unsigned short len; unsigned char arr[201]; } loc_legend62;

struct { unsigned short len; unsigned char arr[201]; } loc_legend63;
		
		
	   /*------Up To here------*/	

					
char nd_reprint_yn, discount_print_yn, sett_print_yn, l_include_refund;
char print_y, rec_out, grp_out, sec_box_out;
		
char    filename[300];
char	l_mesg[300];
char    d_summary_yn,nd_episode_type, nd_lang_ind, nd_online_print_yn,l_print_option;

long    d_age, max_lines = 11;

int l_lno = 0;

int     l_bill_print_opt_for_disc_print,cnt=0;
int	l_page_no = 0,l_dmp = 0, l_lsr = 0,l_margin_len= 30,l_bill_page_no = 0,
        l_main_hdr = 1;

int r_ctr = 0;
		
double     d_serv_disc_amt = 0,
		   d_man_disc_amt = 0,
		   d_overall_disc_amt = 0,
		   d_prepay_adj_amt = 0,
		   d_deposit_adj_amt = 0,
		   d_bill_paid_amt = 0,
		   l_rounding_amt = 0,
		   tot_amt = 0,
		   d_gross_amt = 0,
		   d_tot_bus_man_disc_amt = 0,
		   d_deposit_amt = 0,
		   d_tot_paid_amt = 0,
		   d1_gross_amt = 0,
		   grp_gross_amt = 0,
		   l_disc_grp_gross_amt,
		   l_disc_grp_disc_amt,
		   less_disc = 0,
		   vst_amt = 0,
		   p_vst_ded = 0,
		   d2_bill_tot_amt = 0,
	           vd_sub_total_amt=0,
		   net_total = 0,
		   d_deposit_doc_num = 0,
		   dcp_outst_amt = 0,
		   out_adj_amt = 0,
		   balance_due = 0,
		   bill_outst_amt = 0,
		   d4_doc_amt = 0,
		   d3_doc_amt = 0,
		   d1_net_amt = 0,
		   bill_paid_amt = 0,
		   d_service_amt = 0,
		   d_service_net = 0,
		   d_service_disc = 0,
		   nd_tot_spl_agency_amt = 0,
		   nd_spl_agency_amt = 0,
		   d_service_amt_tot = 0,
		   deposit_tot		 = 0,
		   bi_tot			 = 0,
		   amt_payable		 = 0,
		   l_bill_line_pr_gp_disc_amt = 0,
		   l_bill_rounding_amt = 0,
		   l_bill_tot_adjust_amt = 0,
		   l_bill_tot_exempt_amt = 0,
		   l_bill_tot_write_off_amt = 0,
		   less_billed_amt;

char	l_bill_tot_adjust_amt_str[100];
char	l_bill_tot_exempt_amt_str[100];
char	l_bill_tot_write_off_amt_str[100];
char	l_less_amt_str[1000],l_less_ins_amt_str[1000],l_less_ins_amt_dtl[1000]; 		   

int				hl		 = 196,
				vl		 = 179,
				tlc		 = 218,
				trc		 = 191,
				blc		 = 192,
				brc		 = 217,
				vlti	 = 195,
				vrti	 = 180,
				htti	 = 194,
				hbti	 = 193,
				plus	 = 197;

long 	ccount  = 0,
		glcheck = 1,
		gcount  = 0,
		rcheck	= 0,
		last_line_check = 0,
     	d_service_qty,
		d_base_rate,
		d_base_qty;






int mcount = 0, nd_decimal = 0,l_tit_len=0;

//char WORKING_DIR [300];

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

char string_var[200], font_wide_on[200], font_wide_off[200], buf[200];

int v_lno = 0,  v_pno = 0;  

FILE *fp, *fp1;
CHAR nd_str[1000];
/* Main Part */

void proc_main(argc,argv)
char *argv[];
int argc;
{
	if (argc < 6)
	{    
		disp_message (ERR_MESG,"Usage : blrvsbl1 username/pwd@connect_string session_id pgm_date facility_id calling_pgm_id [filename]\n");
		proc_exit();
	}

   strcpy(uid_pwd.arr,argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr);

   nd_session_id.len = 0;
   nd_session_id.arr[nd_session_id.len] = '\0';

   strcpy(nd_session_id.arr,argv[2]);
   nd_session_id.len = strlen(nd_session_id.arr);
   nd_session_id.arr[nd_session_id.len] = '\0'; 

   nd_pgm_date.len = 0;
   nd_pgm_date.arr[nd_pgm_date.len] = '\0';
   
   strcpy(nd_pgm_date.arr,argv[3]);
   nd_pgm_date.len = strlen(nd_pgm_date.arr);
   nd_pgm_date.arr[nd_pgm_date.len] = '\0';

   strcpy(nd_facility_id.arr,argv[4]);
   nd_facility_id.len = strlen(nd_facility_id.arr);
   nd_facility_id.arr[nd_facility_id.len] = '\0';

   strcpy(nd_calling_pgm_id.arr,argv[5]);		
	nd_calling_pgm_id.len = strlen(nd_calling_pgm_id.arr);	
	nd_calling_pgm_id.arr[nd_calling_pgm_id.len] = '\0';

   if (argc > 6) 
   	   strcpy(nd_file_name.arr,argv[6]);
	else 
		strcpy(nd_file_name.arr,"blrvsbil.lis");

	   nd_file_name.len = strlen(nd_file_name.arr);
	   nd_file_name.arr[nd_file_name.len] = '\0';

   nd_fm_doc_type.arr[0]    = '\0';
   nd_fm_doc_num.arr[0]     = '\0';
   nd_fm_doc_date.arr[0]    = '\0';
   nd_to_doc_type.arr[0]    = '\0';
   nd_to_doc_num.arr[0]     = '\0';
   nd_to_doc_date.arr[0]    = '\0';
   trx_type.arr[0]			= '\0';

   nd_fm_doc_type.len       = 0;
   nd_fm_doc_num.len        = 0;
   nd_fm_doc_date.len       = 0;
   nd_to_doc_type.len       = 0;
   nd_to_doc_num.len        = 0;
   nd_to_doc_date.len       = 0;

   trx_type.len				= 0;


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
   sqlstm.sqhstl[0] = (unsigned int  )134;
   sqlstm.sqhsts[0] = (         int  )134;
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
}


	
  if(OERROR)
   {
      disp_message (ORA_MESG,"Error in connecting to Oracle\n");
      if (uid_pwd.len == 0)
         disp_message (ERR_MESG,"Null oracle uid/pwd\n\n\n");
         proc_exit();
   }

   set_meduser_role();

   fetch_sy_prog_param();
   
	//prepare_file();
	
	get_print_routing();

	l_logo_yniflaser.arr[0] = 'N';

	//get_logo_dtl();	

	get_left_margin();

	prepare_file();


   nd_hosp_name.arr[0] = '\0';
   nd_hosp_name.len = 0;            

   nd_acc_entity_code.arr[0] = '\0';
   nd_acc_entity_code.len = 0;

   nd_add_ln1.arr[0] = '\0';
   nd_add_ln1.len = 0;
   
   nd_add_ln2.arr[0] = '\0';
   nd_add_ln2.len = 0;

   nd_add_ln3.arr[0] = '\0';
   nd_add_ln3.len = 0;

   nd_tel_fax.arr[0] = '\0';
   nd_tel_fax.len = 0;


   if (l_lsr != 0 && l_dmp == 0)
   {	
	if ( l_logo_yniflaser.arr[0] == 'Y')	
	{
		max_lines = 58;  //25
	}
	else
	{
		max_lines = 56;  //25
	}

	l_print_option = 'L';
   }
  else
   {
	max_lines = 11;
	l_print_option = 'D';

   }  


   /* EXEC SQL select acc_entity_code,
            lpad(' ',round((:l_margin_len-length(rtrim(substr(UPPER(ACC_ENTITY_NAME),1,50))))/2),' ')||UPPER(rtrim(substr(UPPER(ACC_ENTITY_NAME),1,50))),
	     LN1_ADD,LN2_ADD,LN3_ADD,
	    'TEL:'||TEL_NUM ||'  FAX:'||FAX_NUM        
            into :nd_acc_entity_code ,
	    :nd_hosp_name,
	    :nd_add_ln1,:nd_add_ln2,:nd_add_ln3,
	    :nd_tel_fax
	    from sy_acc_entity 
	    where acc_entity_id = :nd_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 8;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select acc_entity_code ,(lpad(' ',round(((:b0-length(rtrim\
(substr(UPPER(ACC_ENTITY_NAME),1,50))))/2)),' ')||UPPER(rtrim(substr(UPPER(ACC\
_ENTITY_NAME),1,50)))) ,LN1_ADD ,LN2_ADD ,LN3_ADD ,((('TEL:'||TEL_NUM)||'  FAX\
:')||FAX_NUM) into :b1,:b2,:b3,:b4,:b5,:b6  from sy_acc_entity where acc_entit\
y_id=:b7";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )36;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&l_margin_len;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_acc_entity_code;
   sqlstm.sqhstl[1] = (unsigned int  )7;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_hosp_name;
   sqlstm.sqhstl[2] = (unsigned int  )1002;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_add_ln1;
   sqlstm.sqhstl[3] = (unsigned int  )1002;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_add_ln2;
   sqlstm.sqhstl[4] = (unsigned int  )1002;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_add_ln3;
   sqlstm.sqhstl[5] = (unsigned int  )1002;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_tel_fax;
   sqlstm.sqhstl[6] = (unsigned int  )1002;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_facility_id;
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



	if (OERROR)
	{ 
	    disp_message (ERR_MESG,"Select failed in SY_ACC_ENTITY");
	    proc_exit();
	}


	nd_acc_entity_code.arr[nd_acc_entity_code.len] = '\0';
	nd_hosp_name.arr[nd_hosp_name.len] = '\0';

	nd_add_ln1.arr[nd_add_ln1.len] = '\0';
	nd_add_ln2.arr[nd_add_ln2.len] = '\0';
	nd_add_ln3.arr[nd_add_ln3.len] = '\0';

	nd_tel_fax.arr[nd_tel_fax.len] = '\0';

	nd_add_ln.arr[0] = '\0';
	nd_add_ln.len = 0;
	
	if (nd_add_ln1.arr[0] != '\0')
	{
		strcpy(nd_add_ln.arr,nd_add_ln1.arr);
		nd_add_ln.len = strlen(nd_add_ln.arr);
	}

	if (nd_add_ln1.arr[0] == '\0' && nd_add_ln2.arr[0] != '\0')
	{
		strcpy(nd_add_ln.arr,nd_add_ln2.arr);
		nd_add_ln.len = strlen(nd_add_ln.arr);
	}
	else if (nd_add_ln1.arr[0] != '\0' && nd_add_ln2.arr[0] != '\0')
	{
		strcat(nd_add_ln.arr,", ");
		nd_add_ln.len = strlen(nd_add_ln.arr);

		strcat(nd_add_ln.arr,nd_add_ln2.arr);
		nd_add_ln.len = strlen(nd_add_ln.arr);
	}

	if (nd_add_ln1.arr[0] == '\0' && nd_add_ln2.arr[0] == '\0' && nd_add_ln3.arr[0] != '\0')
	{
		strcpy(nd_add_ln.arr,nd_add_ln2.arr);
		nd_add_ln.len = strlen(nd_add_ln.arr);
	}
	else if ((nd_add_ln1.arr[0] != '\0' || nd_add_ln2.arr[0] != '\0') && 
				nd_add_ln3.arr[0] != '\0')
	{
		strcat(nd_add_ln.arr,", ");
		nd_add_ln.len = strlen(nd_add_ln.arr);

		strcat(nd_add_ln.arr,nd_add_ln3.arr);
		nd_add_ln.len = strlen(nd_add_ln.arr);
	}

	if (l_lsr != 0 && l_dmp == 0)
	{
	    if ( l_logo_yniflaser.arr[0] == 'Y')	
	        l_tit_len = 0;
	    else
		l_tit_len = 32;
	}

 
	nd_add.arr[0] = '\0';
	nd_add.len = 0;

	/* EXEC SQL SELECT lpad(' ',round((:l_margin_len+:l_tit_len-length(rtrim(:nd_add_ln)))/2),' ')||UPPER(rtrim(:nd_add_ln))
	into :nd_add from dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 8;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select (lpad(' ',round((((:b0+:b1)-length(rtrim(:b2)))/2)),'\
 ')||UPPER(rtrim(:b2))) into :b4  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )83;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_margin_len;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_tit_len;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_add_ln;
 sqlstm.sqhstl[2] = (unsigned int  )1002;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_add_ln;
 sqlstm.sqhstl[3] = (unsigned int  )1002;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_add;
 sqlstm.sqhstl[4] = (unsigned int  )1002;
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



	nd_add.arr[nd_add.len] = '\0';


	nd_telfax.arr[0] = '\0';
	nd_telfax.len = 0;
	

	/* EXEC SQL SELECT lpad(' ',round((:l_margin_len+:l_tit_len-length(rtrim(:nd_tel_fax)))/2),' ')||UPPER(rtrim(:nd_tel_fax))
	into :nd_telfax from dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 8;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select (lpad(' ',round((((:b0+:b1)-length(rtrim(:b2)))/2)),'\
 ')||UPPER(rtrim(:b2))) into :b4  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )118;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_margin_len;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_tit_len;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_tel_fax;
 sqlstm.sqhstl[2] = (unsigned int  )1002;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_tel_fax;
 sqlstm.sqhstl[3] = (unsigned int  )1002;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_telfax;
 sqlstm.sqhstl[4] = (unsigned int  )1002;
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



	nd_telfax.arr[nd_telfax.len] = '\0';
	
   

	declare_master_cur();

	open_master_cur();

	nd_tot_spl_agency_amt = 0;

	get_print_net_gross();

	

	while(fetch_master_cur())
	{
		v_pno = 1;

		l_bill_page_no = 0;

		if (l_lsr != 0 && l_dmp == 0)
		{
			
			l_main_hdr = 1;
			
			if ( l_logo_yniflaser.arr[0] != 'Y')
			  {
				if (l_page_no > 0)
				{
					l_page_no = 0;
					fprintf(fp,"\n");
					fprintf(fp,"");
					fprintf(fp,"\n");
				}
			  }
		}
		else
		{
			if(l_page_no > 1)
			{
				l_page_no = 0;
				fprintf(fp,"\n");
				fprintf(fp,"");
				fprintf(fp,"\n");
			}
		}

		nd_lang_id.arr[0] = '\0';
		nd_lang_id.len = 0;

		/* EXEC SQL EXECUTE
		BEGIN
			blcommon.get_language_ind_id(
				:nd_facility_id,
				:dc_patient_id,
				:nd_lang_ind,
				:nd_lang_id);
		END;
		END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 8;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_language_ind_id ( :nd_facility_id , :d\
c_patient_id , :nd_lang_ind , :nd_lang_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )153;
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
  sqlstm.sqhstv[1] = (         void  *)&dc_patient_id;
  sqlstm.sqhstl[1] = (unsigned int  )23;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_lang_ind;
  sqlstm.sqhstl[2] = (unsigned int  )1;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_lang_id;
  sqlstm.sqhstl[3] = (unsigned int  )6;
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


 
		nd_lang_id.arr[strlen(nd_lang_id.arr)] = '\0';

		fetch_legend_value();

		declare_grp_hdr_cur();

		declare_cust_cur();

		declare_refund_cur();

		declare_prepay_cur();

		rec_out = 'N';
		grp_out = 'N';
		sec_box_out = 'N';		

		if (l_lsr != 0 && l_dmp == 0)
		{
		     get_bill_address_lsr();

		     if ( l_logo_yniflaser.arr[0] != 'Y')
		     {
		      fprintf(fp,"%c&a2L",ESC); 	/* To Set the Left margin */
		      fprintf(fp,"%c(s12H",ESC); 	/* To set the font size	  */
		      fprintf(fp,"%c(s3B",ESC); 	/* To set Bold style 	  */	      
		      }
		}
		else
		{
			get_bill_address();

			fprintf(fp,"%cg",ESC); 	/* To Set compressed mode */
		}

		print_report_head();

		open_grp_hdr_cur();

		grp_gross_amt = 0;
		l_disc_grp_gross_amt = 0;
		l_disc_grp_disc_amt = 0;

		/* EXEC SQL SELECT count(*) 
		         INTO :gcount	
			 FROM BL_BILL_LINE A,
			      BL_BLNG_PRT_GRP_HDR C,
			      BL_BLNG_PRT_GRP_LINE D
			 WHERE A.DOC_TYPE_CODE 
			 BETWEEN :nd_fm_doc_type 
			 AND :nd_to_doc_type 	
			 AND A.DOC_NUM 
			 BETWEEN TO_NUMBER(:nd_fm_doc_num) 
			 AND TO_NUMBER(:nd_to_doc_num)
			 AND C.PRT_GRP_HDR_CODE = D.PRT_GRP_HDR_CODE
			 AND A.PRT_GRP_HDR_CODE  = D.PRT_GRP_HDR_CODE (+)
			 AND A.PRT_GRP_LINE_CODE = D.PRT_GRP_LINE_CODE (+)
			 AND	NVL(A.MPI_ID,A.DOC_TYPE_CODE || A.DOC_NUM) = :dc_mpi_id
			 AND	A.OPERATING_FACILITY_ID = :nd_facility_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 8;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select count(*)  into :b0  from BL_BILL_LINE A ,BL_BLNG_PRT\
_GRP_HDR C ,BL_BLNG_PRT_GRP_LINE D where ((((((A.DOC_TYPE_CODE between :b1 and\
 :b2 and A.DOC_NUM between TO_NUMBER(:b3) and TO_NUMBER(:b4)) and C.PRT_GRP_HD\
R_CODE=D.PRT_GRP_HDR_CODE) and A.PRT_GRP_HDR_CODE=D.PRT_GRP_HDR_CODE(+)) and A\
.PRT_GRP_LINE_CODE=D.PRT_GRP_LINE_CODE(+)) and NVL(A.MPI_ID,(A.DOC_TYPE_CODE||\
A.DOC_NUM))=:b5) and A.OPERATING_FACILITY_ID=:b6)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )184;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&gcount;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(long);
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_fm_doc_type;
  sqlstm.sqhstl[1] = (unsigned int  )33;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_to_doc_type;
  sqlstm.sqhstl[2] = (unsigned int  )33;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_fm_doc_num;
  sqlstm.sqhstl[3] = (unsigned int  )33;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_to_doc_num;
  sqlstm.sqhstl[4] = (unsigned int  )33;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&dc_mpi_id;
  sqlstm.sqhstl[5] = (unsigned int  )102;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_facility_id;
  sqlstm.sqhstl[6] = (unsigned int  )5;
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



		ccount = 0;

		while(fetch_grp_hdr_cur())
		{ 	
			ccount = ccount + 1;				
			print_prt_grp_hdr();
		}

		if (l_lsr != 0 && l_dmp == 0 )
		{
			l_main_hdr = 0;
			fprintf(fp,"\n");
			v_lno = v_lno+1;	
			if (v_lno > max_lines) print_next_page1();
		}
		else
		{
			while(v_lno <= max_lines)
			{
				fprintf(fp,"\n");
				v_lno++;
			}
		}

		if (l_lsr != 0 && l_dmp == 0 )
		{
			fprintf(fp,"%-50.50s ",loc_legend13.arr," ");
		}
		else
		{
			fprintf(fp,"%20.20s %30s",loc_legend13.arr," ");
		}

		//Included by Harish against Point # 18 Customization document
		if(l_bill_print_opt_for_disc_print==3)
		{
			print_formated_amt_total(grp_gross_amt);
		}
		else
		{
			print_formated_amt_total(l_disc_grp_gross_amt);
		}
		fprintf(fp,"\n");

		if (l_lsr != 0 && l_dmp == 0 )
		{	
			l_main_hdr = 0;
			v_lno = v_lno+1;	
			if (v_lno > max_lines) print_next_page1();
		}
		
		amt_payable = grp_gross_amt - d_man_disc_amt - d_overall_disc_amt;

		if(l_bill_print_opt_for_disc_print==2)
		{
			fprintf(fp,"%20.20s %30s",loc_legend20.arr," ");
			print_formated_amt_total(l_disc_grp_disc_amt);
			fprintf(fp,"\n");
			if (l_lsr != 0 && l_dmp == 0 )
			{		
				l_main_hdr = 0;
				v_lno = v_lno+1;	
				if (v_lno > max_lines) print_next_page1();
			}
		}		

		open_cust_cur();
		print_ins_bill();
		print_ins_ded();

		get_ins_amt();  // to get l_less_ins_amt_str

		if (less_billed_amt != 0 && l_print_option == 'L')
		{
			fprintf(fp,"%20.20s %-30.30s",loc_legend34.arr,l_less_ins_amt_str);
			print_formated_amt_total(-less_billed_amt);
			fprintf(fp,"\n");
			if (l_lsr != 0 && l_dmp == 0 )
			{		
				l_main_hdr = 0;
				v_lno = v_lno+1;	
				if (v_lno > max_lines) print_next_page1();
			}
			else
			{
				v_lno++;
			}
			if (p_vst_ded != 0)
			{
				fprintf(fp,"%20.20s %30.30s",loc_legend35.arr,"");
				print_formated_amt_total(p_vst_ded);
				fprintf(fp,"\n");
				if (l_lsr != 0 && l_dmp == 0 )
				{		
					l_main_hdr = 0;
					v_lno = v_lno+1;	
					if (v_lno > max_lines) print_next_page1();
				}
				else
				{
					v_lno++;
				}
			}
		}
		if (l_lsr != 0 && l_dmp == 0)
		{	
			if ( less_billed_amt != 0 && l_print_option == 'D')
			{
				fprintf(fp,"%-20.20s(%-30.30s",loc_legend14.arr,l_less_ins_amt_str);
			}
			else
			{
				fprintf(fp,"%-50.50s ",loc_legend14.arr,"");
			}
		}
		else
		{
			if ( less_billed_amt != 0 && l_print_option == 'D')
				fprintf(fp,"%20.20s(%30.30s",loc_legend14.arr,l_less_ins_amt_str);
			else
				fprintf(fp,"%20.20s %30.30s",loc_legend14.arr,"");
		}

		print_formated_amt_total(amt_payable);

		prt_ins_ded_amt();
		fprintf(fp,"\n");	

		if (l_lsr != 0 && l_dmp == 0 )
		{		
			l_main_hdr = 0;
			v_lno = v_lno+1;	
			if (v_lno > max_lines) print_next_page1();
		}
		
		l_bill_rounding_amt =0;
		l_bill_tot_adjust_amt = 0;
		l_bill_tot_exempt_amt = 0;
		l_bill_tot_write_off_amt = 0;

		/* EXEC SQL SELECT nvl(bill_rounding_amt,0),
				nvl(bill_tot_adjust_amt,0),            
				nvl(bill_tot_exempt_amt,0),            
				nvl(bill_tot_write_off_amt,0)         
		         INTO	l_bill_rounding_amt,
				l_bill_tot_adjust_amt,
				l_bill_tot_exempt_amt,
				l_bill_tot_write_off_amt
			 FROM bl_bill_hdr
			 WHERE doc_type_code = :nd_fm_doc_type 
			 AND doc_num = :nd_fm_doc_num; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 8;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select nvl(bill_rounding_amt,0) ,nvl(bill_tot_adjust_amt,0)\
 ,nvl(bill_tot_exempt_amt,0) ,nvl(bill_tot_write_off_amt,0) into :b0,:b1,:b2,:\
b3  from bl_bill_hdr where (doc_type_code=:b4 and doc_num=:b5)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )227;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&l_bill_rounding_amt;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&l_bill_tot_adjust_amt;
  sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&l_bill_tot_exempt_amt;
  sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&l_bill_tot_write_off_amt;
  sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_fm_doc_type;
  sqlstm.sqhstl[4] = (unsigned int  )33;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_fm_doc_num;
  sqlstm.sqhstl[5] = (unsigned int  )33;
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
			disp_message (ERR_MESG,"SELECT failed on BL_BILL_HDR");
			proc_exit();
		}

		if(l_bill_rounding_amt!=0)
		{
			fprintf(fp,"%20.20s %30s",loc_legend22.arr," ");
			print_formated_amt_total(l_bill_rounding_amt);
			fprintf(fp,"\n");
			if (l_lsr != 0 && l_dmp == 0 )
			{		
				l_main_hdr = 0;
				v_lno = v_lno+1;	
				if (v_lno > max_lines) print_next_page1();
			}
		}
				
		grp_out = 'Y';


		//open_cust_cur();

		//print_ins_bill();

		print_less_total();

		print_less_disc();

		//print_ins_ded();

		if (sett_print_yn == 'N')
		{

			/*if (d_deposit_adj_amt > 0)
			{	
				open_refund_cur();

				while(fetch_refund_cur())
 				{	
					deposit_tot = deposit_tot + d_deposit_adj_amt;
				}
				close_refund_cur();
			}
		
			if (d_prepay_adj_amt > 0)
			{	    
				open_prepay_cur();

				while(fetch_prepay_cur())
 				{	
					deposit_tot = deposit_tot + d_prepay_adj_amt;
				}
					
				close_prepay_cur();
			}*/
			
			deposit_tot = deposit_tot + d_deposit_adj_amt;
			deposit_tot = deposit_tot + d_prepay_adj_amt;
		}

		if(strcmp(l_no_settlement_details.arr,"Y")==0)
		{
			deposit_tot = deposit_tot + nd_tot_spl_agency_amt;
		}
		else
		{
			/* EXEC SQL SELECT SUM(NVL(DOC_AMT,0)) 
					   INTO :bi_tot 
					   FROM BL_RECEIPT_REFUND_HDRDTL_VW
					  WHERE BILL_DOC_TYPE_CODE = :dc_doc_type_code
						AND BILL_DOC_NUMBER = :d_doc_num
						AND RECPT_NATURE_CODE = 'BI'; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 8;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select sum(NVL(DOC_AMT,0)) into :b0  from BL_RECEIPT_REFUN\
D_HDRDTL_VW where ((BILL_DOC_TYPE_CODE=:b1 and BILL_DOC_NUMBER=:b2) and RECPT_\
NATURE_CODE='BI')";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )266;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&bi_tot;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&dc_doc_type_code;
   sqlstm.sqhstl[1] = (unsigned int  )9;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_doc_num;
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



			deposit_tot = deposit_tot + bi_tot + nd_tot_spl_agency_amt;
		}

		sec_box_out = 'Y';

		get_ins_dtl();

		if (l_lsr != 0 && l_dmp == 0)
		{
			if ( less_billed_amt != 0 && l_print_option == 'D')
			{
				fprintf(fp,"%-20.20s%-30.30s)",loc_legend15.arr,l_less_ins_amt_dtl);
			}
			else
			{
				fprintf(fp,"%-50.50s ",loc_legend15.arr,"");
			}
		}
		else
		{
			if ( less_billed_amt != 0  && l_print_option == 'D')
				fprintf(fp,"%20.20s%30.30s)",loc_legend15.arr,l_less_ins_amt_dtl);
			else
				fprintf(fp,"%20.20s %30.30s",loc_legend15.arr,"");
		}

		print_formated_amt_total(-deposit_tot);
		fprintf(fp,"\n");

		if (l_lsr != 0 && l_dmp == 0 )
		{		
			l_main_hdr = 0;
			v_lno = v_lno+1;	
			if (v_lno > max_lines) print_next_page1();
		}

		//	Exemption / Adjustment Printing

		if (l_bill_tot_adjust_amt != 0||l_bill_tot_exempt_amt != 0||l_bill_tot_write_off_amt != 0) 
		{
			print_formated_amt_varstr(l_bill_tot_adjust_amt_str,l_bill_tot_adjust_amt);
			print_formated_amt_varstr(l_bill_tot_exempt_amt_str,l_bill_tot_exempt_amt);
			print_formated_amt_varstr(l_bill_tot_write_off_amt_str,l_bill_tot_write_off_amt);

			sprintf(l_less_amt_str,"%4.4s(",loc_legend25.arr); 

			if (l_bill_tot_adjust_amt != 0 )					
			{
				sprintf(l_less_amt_str,"%s%3.3s:%s",  l_less_amt_str,
								loc_legend26.arr,
								l_bill_tot_adjust_amt_str); 
				if (l_bill_tot_exempt_amt != 0||l_bill_tot_write_off_amt != 0)		
				sprintf(l_less_amt_str,"%s ",l_less_amt_str); 
			}
		
			if (l_bill_tot_exempt_amt != 0)		
			{		
				sprintf(l_less_amt_str,"%s%3.3s:%s", l_less_amt_str,
								      loc_legend27.arr,
								      l_bill_tot_exempt_amt_str);
				if (l_bill_tot_write_off_amt != 0)		
				sprintf(l_less_amt_str,"%s ",l_less_amt_str); 
				
			}

			if (l_bill_tot_write_off_amt != 0 )				
					sprintf(l_less_amt_str,"%s%2.2s:%s",l_less_amt_str, 
								     loc_legend28.arr,
								     l_bill_tot_write_off_amt_str); 

			sprintf(l_less_amt_str,"%s) ",l_less_amt_str); 

	
		
			fprintf(fp,"                %-35.35s",l_less_amt_str);
			print_formated_amt_total(l_bill_tot_adjust_amt + l_bill_tot_exempt_amt + l_bill_tot_write_off_amt);
			fprintf(fp,"\n");		
			if (l_lsr != 0 && l_dmp == 0 )
			{		
				l_main_hdr = 0;
				v_lno = v_lno+1;	
				if (v_lno > max_lines) print_next_page1();
			}
		
		}
	
		if (l_lsr != 0 && l_dmp == 0)
		{
			fprintf(fp,"%-50.50s ",loc_legend16.arr," ");
		}
		else
		{
			fprintf(fp,"%20.20s %30s",loc_legend16.arr," ");
		}

		print_formated_amt_total(amt_payable - deposit_tot + l_bill_rounding_amt
			- l_bill_tot_adjust_amt - l_bill_tot_exempt_amt - l_bill_tot_write_off_amt);

		fprintf(fp,"\n");

		if (l_lsr != 0 && l_dmp == 0 )
		{		
			l_main_hdr = 0;
			v_lno = v_lno+1;	
			if (v_lno > max_lines) print_next_page1();
		}

		print_net_total();

		print_balance_due1();


		/* EXEC SQL UPDATE BL_BILL_HDR
		  		    SET BILL_PRINT_FLAG = 'Y'
			      WHERE DOC_TYPE_CODE = :dc_doc_type_code 
				    AND	DOC_NUM  =  :d_doc_num; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 8;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "update BL_BILL_HDR  set BILL_PRINT_FLAG='Y' where (DOC_TYPE\
_CODE=:b0 and DOC_NUM=:b1)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )293;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&dc_doc_type_code;
  sqlstm.sqhstl[0] = (unsigned int  )9;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_doc_num;
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


	
	}

	close_cust_cur();
	close_grp_hdr_cur();
	close_master_cur();
	//fprintf(fp,"%c@",ESC);	/* To Reset the Printer */

	if ( l_logo_yniflaser.arr[0] != 'Y')
	{
		fprintf(fp,"");   /* Page break  */
	}

	if (l_lsr != 0 && l_dmp == 0)
	{
	     if ( l_logo_yniflaser.arr[0] != 'Y')
	     {
		fprintf(fp,"%cE",ESC);  /* To Reset Printer */			
	     }
	}

	fflush(fp);
	fclose(fp);  

	if (strcmp(nd_calling_pgm_id.arr,"BLTBILVT") == 0 )
	{	
		strcpy(nd_calling_pgm_id.arr,"BLRBILVT");
		nd_calling_pgm_id.arr[nd_calling_pgm_id.len] = '\0';
	}
 
    /*sprintf(nd_str,"[%s] [%s] [%s] [%s] [%s] ", uid_pwd.arr,nd_session_id.arr,
						d_cashfacility_id.arr, nd_calling_pgm_id.arr,
					filename);
    disp_message(ERR_MESG,nd_str);*/

	if (nd_online_print_yn == 'Y')
	{
		if (l_logo_yniflaser.arr[0] != 'Y')
		{
				PrintDocument(  uid_pwd.arr,		//char	*PUidPwd;
						nd_session_id.arr,	//char	*PSessionID;
						d_cashfacility_id.arr,	//char	*PFacilityID;
						"BL",				//char	*PModuleID;
						nd_calling_pgm_id.arr,			//char	*PDocumentID;
						filename,			//char	*POnlinePrintFileNames;
						"O",				//char	*PLocationTypes;
						" ",				//char	*PLocationCodes;
						1,					//int		PNumOfCopies;
						1,					//int		PPageFrom;
						9999);					//int		PPageTo;);
		}
	}
	else
	{
		if (l_lsr != 0 && l_dmp == 0 && l_logo_yniflaser.arr[0] == 'Y')
		{		

		l_errortext.arr[0] = '\0';
		l_errortext.len = 0;			

		/* EXEC SQL EXECUTE
		DECLARE
			l_print_status BOOLEAN;
		BEGIN		
	
			 
			APPPRINT.SUBMIT_ORACLE_REPORT
				 (:nd_ws_no,
				  :d_cashfacility_id,
				  'BL',
				  :nd_logo_pgm_id,
				  'P', --p_report_option
				  '',  --p_outputfile_format
				  '',  --p_outputfile_name
				  'O',
				  ' ', --p_location_code
				  NULL, --:l_printer_names,
				  NULL,
				  NULL, --p_page_from
				  NULL, --p_page_to
				  NULL, --p_print_mode
				  'P_FILE_NAME='||:nd_file_name||'+'||'P_LOGO_NAME='||:l_logo_name, --p_param_list
				  l_print_status, --OUT BOOLEAN,
				  :l_errortext);			  
		
		END;
		END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 8;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "declare l_print_status BOOLEAN ; BEGIN APPPRINT . SUBMIT_OR\
ACLE_REPORT ( :nd_ws_no , :d_cashfacility_id , 'BL' , :nd_logo_pgm_id , 'P' , \
'' , '' , 'O' , ' ' , NULL , NULL , NULL , NULL , NULL , 'P_FILE_NAME=' || :nd\
_file_name || '+' || 'P_LOGO_NAME=' || :l_logo_name , l_print_status , :l_erro\
rtext ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )316;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_ws_no;
  sqlstm.sqhstl[0] = (unsigned int  )42;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_cashfacility_id;
  sqlstm.sqhstl[1] = (unsigned int  )5;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_logo_pgm_id;
  sqlstm.sqhstl[2] = (unsigned int  )1002;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_file_name;
  sqlstm.sqhstl[3] = (unsigned int  )52;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&l_logo_name;
  sqlstm.sqhstl[4] = (unsigned int  )1002;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&l_errortext;
  sqlstm.sqhstl[5] = (unsigned int  )1002;
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



		if (l_errortext.arr[0] != '\0')
		{
			disp_message(ERR_MESG,l_errortext.arr);			
			proc_exit(0);
			
		}
	

	     }
	}


	if (nd_online_print_yn == 'N')
	{
		/* EXEC SQL DELETE 
		           FROM BL_BILL_PRINT_TEMP
				  WHERE SESSION_ID = :nd_session_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 8;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "delete  from BL_BILL_PRINT_TEMP  where SESSION_ID=:b0";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )355;
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

	
	/* EXEC SQL DELETE FROM SY_PROG_PARAM
			  WHERE PGM_ID     = 'BLRVSBIL'
				AND SESSION_ID = :nd_session_id
				AND PGM_DATE   = :nd_pgm_date; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 8;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='BLRVSBIL' and SE\
SSION_ID=:b0) and PGM_DATE=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )374;
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
}


	
	//KGA COMMENT 
	/*
	sprintf(l_mesg,"Doc Type Code   :   %s   Doc Num Fm  :   %s   To  :  %s   Doc Date  Fm  :  %s  To  :  %s",nd_fm_doc_type.arr,nd_fm_doc_num.arr,nd_to_doc_num.arr,nd_fm_doc_date.arr,nd_to_doc_date.arr);
	disp_message(ERR_MESG,l_mesg);
	*/

	/* EXEC SQL UPDATE BL_BILL_HDR
				SET BILL_PRINT_FLAG = 'Y'
			  WHERE DOC_TYPE_CODE = :nd_fm_doc_type 
				AND	DOC_NUM  BETWEEN  NVL(:nd_fm_doc_num,0) AND 			NVL(:nd_to_doc_num,99999999) 
				AND	TRUNC(DOC_DATE) BETWEEN 			TO_DATE(NVL(:nd_fm_doc_date,'01/01/1800'),'DD/MM/YYYY')
				AND TO_DATE(NVL(:nd_to_doc_date,'31/12/4712'),'DD/MM/YYYY')
				AND	NVL(BILL_TRX_TYPE_CODE,'X') = :trx_type
				AND	NVL(BILL_STATUS,'Z') != 'C'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 8;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "update BL_BILL_HDR  set BILL_PRINT_FLAG='Y' where ((((DOC_TY\
PE_CODE=:b0 and DOC_NUM between NVL(:b1,0) and NVL(:b2,99999999)) and TRUNC(DO\
C_DATE) between TO_DATE(NVL(:b3,'01/01/1800'),'DD/MM/YYYY') and TO_DATE(NVL(:b\
4,'31/12/4712'),'DD/MM/YYYY')) and NVL(BILL_TRX_TYPE_CODE,'X')=:b5) and NVL(BI\
LL_STATUS,'Z')<>'C')";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )397;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_fm_doc_type;
 sqlstm.sqhstl[0] = (unsigned int  )33;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_fm_doc_num;
 sqlstm.sqhstl[1] = (unsigned int  )33;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_to_doc_num;
 sqlstm.sqhstl[2] = (unsigned int  )33;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_fm_doc_date;
 sqlstm.sqhstl[3] = (unsigned int  )33;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_to_doc_date;
 sqlstm.sqhstl[4] = (unsigned int  )33;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&trx_type;
 sqlstm.sqhstl[5] = (unsigned int  )4;
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

 

	/* EXEC SQL COMMIT WORK; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 8;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )436;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	return 1;
}

get_logo_dtl()
{
	
	  l_logo_yniflaser.arr[0] = 'N';

	  l_errorlevel.arr[0] = '\0';
	  l_errorlevel.len = 0;

	  l_sysmessageid.arr[0] = '\0';
	  l_sysmessageid.len = 0;

	  l_errortext.arr[0] = '\0';
	  l_errortext.len = 0;
			

	   if (l_lsr != 0 && l_dmp == 0)
	   {
		/* EXEC SQL EXECUTE	
		BEGIN					
			
			BLOPIN.GET_PRINT_SETUP_COL_VALUE(
				:nd_facility_id,
				'BLRVSBL1',
				'PRINT_LOGO_YN_IF_LASER',
				:l_logo_yniflaser,
				:l_errorlevel,
				:l_sysmessageid,
				:l_errortext) ;
				
			:l_logo_yniflaser := nvl(:l_logo_yniflaser,'N');

			if :l_sysmessageid is not null then
				:l_errorlevel := '10';
				:l_errortext := blcommon.get_error_text(:l_sysmessageid);
			end if;

		END;
		END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 8;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin BLOPIN . GET_PRINT_SETUP_COL_VALUE ( :nd_facility_id \
, 'BLRVSBL1' , 'PRINT_LOGO_YN_IF_LASER' , :l_logo_yniflaser , :l_errorlevel , \
:l_sysmessageid , :l_errortext ) ; :l_logo_yniflaser := nvl ( :l_logo_yniflase\
r , 'N' ) ; if :l_sysmessageid is not null then :l_errorlevel := '10' ; :l_err\
ortext := blcommon . get_error_text ( :l_sysmessageid ) ; end if ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )451;
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
  sqlstm.sqhstv[1] = (         void  *)&l_logo_yniflaser;
  sqlstm.sqhstl[1] = (unsigned int  )1002;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&l_errorlevel;
  sqlstm.sqhstl[2] = (unsigned int  )12;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&l_sysmessageid;
  sqlstm.sqhstl[3] = (unsigned int  )12;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&l_errortext;
  sqlstm.sqhstl[4] = (unsigned int  )1002;
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



		if (strcmp(l_errorlevel.arr,"10") == 0 && l_errortext.arr[0] != '\0')
		{
			disp_message(ERR_MESG,l_errortext.arr);
			proc_exit(0);
		}

		l_errorlevel.arr[0] = '\0';
		l_errorlevel.len = 0;

		l_sysmessageid.arr[0] = '\0';
		l_sysmessageid.len = 0;

		l_errortext.arr[0] = '\0';
		l_errortext.len = 0;
	
		
		if (l_logo_yniflaser.arr[0] == 'Y')
		{
			/* EXEC SQL EXECUTE	
			BEGIN				
				BLOPIN.GET_PRINT_SETUP_COL_VALUE(
					:nd_facility_id,
					'BLRBILLO',
					'LOGO_NAME',
					:l_logo_name,
					:l_errorlevel,
					:l_sysmessageid,
					:l_errortext) ;
				

				if :l_sysmessageid is not null then
					:l_errorlevel := '10';
					:l_errortext := blcommon.get_error_text(:l_sysmessageid);
				end if;

			END;
			END-EXEC; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 8;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "begin BLOPIN . GET_PRINT_SETUP_COL_VALUE ( :nd_facility_id\
 , 'BLRBILLO' , 'LOGO_NAME' , :l_logo_name , :l_errorlevel , :l_sysmessageid ,\
 :l_errortext ) ; if :l_sysmessageid is not null then :l_errorlevel := '10' ; \
:l_errortext := blcommon . get_error_text ( :l_sysmessageid ) ; end if ; END ;";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )486;
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
   sqlstm.sqhstv[1] = (         void  *)&l_logo_name;
   sqlstm.sqhstl[1] = (unsigned int  )1002;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&l_errorlevel;
   sqlstm.sqhstl[2] = (unsigned int  )12;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&l_sysmessageid;
   sqlstm.sqhstl[3] = (unsigned int  )12;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&l_errortext;
   sqlstm.sqhstl[4] = (unsigned int  )1002;
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


			if (strcmp(l_errorlevel.arr,"10") == 0 && l_errortext.arr[0] != '\0')
			{
				disp_message(ERR_MESG,l_errortext.arr);
				proc_exit(0);
			}

			LOGO_DIR.arr[0] = '\0';
			LOGO_DIR.len = 0;

		       l_errorlevel.arr[0] = '\0';
		       l_errorlevel.len = 0;

		       l_sysmessageid.arr[0] = '\0';
		       l_sysmessageid.len = 0;

		       l_errortext.arr[0] = '\0';
		       l_errortext.len = 0;	

			if (nd_online_print_yn == 'N')
			{			
				/* EXEC SQL EXECUTE	
				BEGIN				
					WORKSTATION.GET_WS_PARAM(
						:nd_ws_no,				
						'BLLOGODIR',
						:LOGO_DIR,
						:l_errortext);			
					if :l_errortext is not null then 
						:l_errortext	:= 'BLLOGODIR:'||:l_errortext;
					end if;

				END;
				END-EXEC; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 8;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "begin WORKSTATION . GET_WS_PARAM ( :nd_ws_no , 'BLLOGODIR\
' , :LOGO_DIR , :l_errortext ) ; if :l_errortext is not null then :l_errortext\
 := 'BLLOGODIR:' || :l_errortext ; end if ; END ;";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )521;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_ws_no;
    sqlstm.sqhstl[0] = (unsigned int  )42;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&LOGO_DIR;
    sqlstm.sqhstl[1] = (unsigned int  )1002;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&l_errortext;
    sqlstm.sqhstl[2] = (unsigned int  )1002;
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


				if (l_errortext.arr[0] != '\0')
				{
					disp_message(ERR_MESG,l_errortext.arr);
					proc_exit(0);
				}		
			}
		}
	    }
   }

get_print_routing()
{
	/* EXEC SQL EXECUTE
	DECLARE
		l_sys_mesg_id VARCHAR2(10);
		l_err_level VARCHAR2(10);
		l_err_text VARCHAR2(1000);
		l_document_value blcommon.rectype_Tab;
		l_format_type VARCHAR2(200);
		l_report_tool_ind VARCHAR2(1);
	BEGIN
	
		blcommon.get_doc_print_format_Tab(
     			:nd_facility_id,
			:nd_calling_pgm_id,
			l_document_value,
			l_sys_mesg_id,
			l_err_level,
			l_err_text);						

		FOR i IN l_document_value.FIRST..l_document_value.LAST LOOP
			if  l_document_value(i).id = 'FORMAT_TYPE' then
				l_format_type := l_document_value(i).value;
			end if;				
			
			if l_document_value(i).id = 'REPORT_TOOL_IND' then 
				l_report_tool_ind := l_document_value(i).value;
			end if;		 	

			if l_document_value(i).id = 'INCL_PRV_RFND_AMT_IN_TOT_OUTST' then 
				:l_include_refund := NVL(l_document_value(i).value,'N');
			end if;		 			
		END LOOP;		

		if l_format_type = 'DMP_PREPRINTED' then
			:l_dmp := 1;
			:l_lsr := 0;
		elsif l_format_type in('LASER_WITH_LOGO','LASER_WITHOUT_LOGO') then
			:l_dmp := 0;
			:l_lsr := 1;
		else
			:l_dmp := 0;
			:l_lsr := 0;
		end if;
		
		if :l_dmp = 0 and :l_lsr = 0 then

			APPPRINT.GET_ROUTING_PRINTERS(
			 :nd_ws_no,
			 :d_cashfacility_id,
			 'BL',
			 :nd_calling_pgm_id,
			 'O',
			 ' ',
			 :l_printer_ids,
			 :l_printer_names,
			 :l_printer_types, 
			 :l_queue_names,
			 :l_no_of_copies,
			 :l_errortext);

			 :l_dmp := NVL(instr(:l_printer_types,'D'),0);
			 :l_lsr := NVL(instr(:l_printer_types,'S'),0);			 

			 if :l_dmp != 0 and :l_lsr != 0 then 
			    :l_dmp := 0;
			    --if there is a laser setup, then output format will be laser
			 end if;	

			 if :l_dmp = 0 and :l_lsr = 0 then 
			    :l_lsr := 1;
			    --Default is Laser Format
			 end if;	 		 
		end if;

END;
END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "declare l_sys_mesg_id VARCHAR2 ( 10 ) ; l_err_level VARCHAR2 ( 10 ) ; l_\
err_text VARCHAR2 ( 1000 ) ; l_document_value blcommon . rectype_Tab ; l_for\
mat_type VARCHAR2 ( 200 ) ; l_report_tool_ind VARCHAR2 ( 1 ) ; BEGIN blcommo\
n . get_doc_print_format_Tab ( :nd_facility_id , :nd_calling_pgm_id , l_docu\
ment_value , l_sys_mesg_id , l_err_level , l_err_text ) ; FOR i IN l_documen\
t_value . FIRST .. l_document_value . LAST LOOP if l_document_value ( i ) . \
id = 'FORMAT_TYPE' then l_format_type := l_document_value ( i ) . value ; en\
d if ; if l_document_value ( i ) . id = 'REPORT_TOOL_IND' then l_report_tool\
_ind := l_document_value ( i ) . value ; end if ; if l_document_value ( i ) \
. id = 'INCL_PRV_RFND_AMT_IN_TOT_OUTST' then :l_include_refund := NVL ( l_do\
cument_value ( i ) . value , 'N' ) ; end if ; END LOOP ; if l_format_type = \
'DMP_PREPRINTED' then :l_dmp := 1 ; :l_lsr := 0 ; elsif l_format_type in ( '\
LASER_WITH_LOGO' , 'LASER_WITHOUT_LOGO' ) then :l_dmp := 0 ; :l_lsr := 1 ; e\
lse :l_dmp := 0 ; :l_lsr := 0 ; end if ;");
 sqlstm.stmt = " if :l_dmp = 0 and :l_lsr = 0 then APPPRINT . GET_ROUTING_PR\
INTERS ( :nd_ws_no , :d_cashfacility_id , 'BL' , :nd_calling_pgm_id , 'O' , ' \
' , :l_printer_ids , :l_printer_names , :l_printer_types , :l_queue_names , :l\
_no_of_copies , :l_errortext ) ; :l_dmp := NVL ( instr ( :l_printer_types , 'D\
' ) , 0 ) ; :l_lsr := NVL ( instr ( :l_printer_types , 'S' ) , 0 ) ; if :l_dmp\
 != 0 and :l_lsr != 0 then :l_dmp := 0 ; end if ; if :l_dmp = 0 and :l_lsr = 0\
 then :l_lsr := 1 ; end if ; end if ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )548;
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
 sqlstm.sqhstv[1] = (         void  *)&nd_calling_pgm_id;
 sqlstm.sqhstl[1] = (unsigned int  )12;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&l_include_refund;
 sqlstm.sqhstl[2] = (unsigned int  )1;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&l_dmp;
 sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&l_lsr;
 sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_ws_no;
 sqlstm.sqhstl[5] = (unsigned int  )42;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&d_cashfacility_id;
 sqlstm.sqhstl[6] = (unsigned int  )5;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&l_printer_ids;
 sqlstm.sqhstl[7] = (unsigned int  )1002;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&l_printer_names;
 sqlstm.sqhstl[8] = (unsigned int  )1002;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&l_printer_types;
 sqlstm.sqhstl[9] = (unsigned int  )1002;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&l_queue_names;
 sqlstm.sqhstl[10] = (unsigned int  )1002;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&l_no_of_copies;
 sqlstm.sqhstl[11] = (unsigned int  )1002;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&l_errortext;
 sqlstm.sqhstl[12] = (unsigned int  )1002;
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



		if ( l_errortext.arr[0] != '\0')
		{
			l_errortext.arr[0] = '\0';
			l_errortext.len = 0;
		}


}

get_ins_dtl()
{
	char l_str1[1000];	

	strcpy(l_str1,print_formated(-less_billed_amt));

	if (less_billed_amt != 0)
	{
		if (dc_ind.arr[0] == 'I')
			sprintf(l_less_ins_amt_dtl,"%s/%s:%s",d2_doc_type_code.arr,d2_doc_num.arr,l_str1);
		else
			sprintf(l_less_ins_amt_dtl,"%s/%s:%s",d2_doc_type_code.arr,d2_doc_num.arr,l_str1);
	}
}

prt_ins_ded_amt()
{
	char l_str1[1000];
	
	if (p_vst_ded != 0 &&  l_print_option == 'D')
	{
	    strcpy(l_str1,print_formated(p_vst_ded));	    
	    fprintf(fp,"(%s:%s)",loc_legend35.arr,l_str1);
	}
	

}

get_ins_amt()
{
	char l_str1[1000];

	amt_payable = amt_payable - less_billed_amt;

	amt_payable = amt_payable + p_vst_ded;

	strcpy(l_str1,print_formated(-less_billed_amt));
	
	if (less_billed_amt != 0 && l_print_option == 'D')
	{
	   if (dc_ind.arr[0] == 'I' )
		sprintf(l_less_ins_amt_str,"%-s %-s",loc_legend34.arr,loc_legend36.arr);
	   else
		sprintf(l_less_ins_amt_str,"%-s %-s",loc_legend34.arr,d2_short_name.arr);
	}
	else
	{
	   if (dc_ind.arr[0] == 'I' )
		sprintf(l_less_ins_amt_str,"%-s (%-s/%-s)",loc_legend36.arr,d2_doc_type_code.arr,d2_doc_num.arr);
	   else
		sprintf(l_less_ins_amt_str,"%-s (%-s/%-s)",d2_short_name.arr,d2_doc_type_code.arr,d2_doc_num.arr);
	}
}

/* Procedure Part */

fetch_sy_prog_param()
{
	l_detail_report_flag.arr[0] = '\0';
   l_print_without_disc_func.arr[0] = '\0';
   l_no_settlement_details.arr[0] = '\0';   
   nd_ws_no.arr[0] = '\0';
   nd_ws_no.len = 0;
   nd_logo_pgm_id.arr[0]	= '\0';

   nd_logo_pgm_id.len	= 0;
   
   
   /* EXEC SQL SELECT OPERATING_FACILITY_ID,PARAM1,NVL(PARAM2,0),PARAM3,
					NVL(PARAM4,99999999), PARAM5,PARAM6,PARAM7,PARAM8,
					'Y',NVL(PARAM10,'N'),PARAM20,PARAM21,
					NVL(PARAM22,operating_facility_id), NVL(PARAM30,'Y'),
					PARAM14, PARAM15, NVL(PARAM25,'N'),
					PARAM29,
					PARAM28
             INTO  :nd_facility_id,:nd_fm_doc_type,:nd_fm_doc_num,
                   :nd_to_doc_type,:nd_to_doc_num, 
   				   :nd_fm_doc_date,:nd_to_doc_date,
   				   :trx_type,:nd_reprint_yn,:discount_print_yn, 
				   :sett_print_yn,:p_cash_counter,:p_shift,
				   :d_cashfacility_id, :nd_online_print_yn,
				   :l_detail_report_flag, :l_print_without_disc_func,
				   :l_no_settlement_details,
				   :nd_ws_no,
				   :nd_logo_pgm_id
              FROM SY_PROG_PARAM
              WHERE PGM_ID     = 'BLRVSBIL'
              AND SESSION_ID = :nd_session_id
              AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 22;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,NVL(PARAM2,0) ,PARAM\
3 ,NVL(PARAM4,99999999) ,PARAM5 ,PARAM6 ,PARAM7 ,PARAM8 ,'Y' ,NVL(PARAM10,'N')\
 ,PARAM20 ,PARAM21 ,NVL(PARAM22,operating_facility_id) ,NVL(PARAM30,'Y') ,PARA\
M14 ,PARAM15 ,NVL(PARAM25,'N') ,PARAM29 ,PARAM28 into :b0,:b1,:b2,:b3,:b4,:b5,\
:b6,:b7,:b8,:b9,:b10,:b11,:b12,:b13,:b14,:b15,:b16,:b17,:b18,:b19  from SY_PRO\
G_PARAM where ((PGM_ID='BLRVSBIL' and SESSION_ID=:b20) and PGM_DATE=:b21)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )615;
   sqlstm.selerr = (unsigned short)1;
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
   sqlstm.sqhstv[1] = (         void  *)&nd_fm_doc_type;
   sqlstm.sqhstl[1] = (unsigned int  )33;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_fm_doc_num;
   sqlstm.sqhstl[2] = (unsigned int  )33;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_to_doc_type;
   sqlstm.sqhstl[3] = (unsigned int  )33;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_to_doc_num;
   sqlstm.sqhstl[4] = (unsigned int  )33;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_fm_doc_date;
   sqlstm.sqhstl[5] = (unsigned int  )33;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_to_doc_date;
   sqlstm.sqhstl[6] = (unsigned int  )33;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&trx_type;
   sqlstm.sqhstl[7] = (unsigned int  )4;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_reprint_yn;
   sqlstm.sqhstl[8] = (unsigned int  )1;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&discount_print_yn;
   sqlstm.sqhstl[9] = (unsigned int  )1;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&sett_print_yn;
   sqlstm.sqhstl[10] = (unsigned int  )1;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&p_cash_counter;
   sqlstm.sqhstl[11] = (unsigned int  )5;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&p_shift;
   sqlstm.sqhstl[12] = (unsigned int  )4;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&d_cashfacility_id;
   sqlstm.sqhstl[13] = (unsigned int  )5;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&nd_online_print_yn;
   sqlstm.sqhstl[14] = (unsigned int  )1;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&l_detail_report_flag;
   sqlstm.sqhstl[15] = (unsigned int  )5;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&l_print_without_disc_func;
   sqlstm.sqhstl[16] = (unsigned int  )6;
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&l_no_settlement_details;
   sqlstm.sqhstl[17] = (unsigned int  )7;
   sqlstm.sqhsts[17] = (         int  )0;
   sqlstm.sqindv[17] = (         void  *)0;
   sqlstm.sqinds[17] = (         int  )0;
   sqlstm.sqharm[17] = (unsigned int  )0;
   sqlstm.sqadto[17] = (unsigned short )0;
   sqlstm.sqtdso[17] = (unsigned short )0;
   sqlstm.sqhstv[18] = (         void  *)&nd_ws_no;
   sqlstm.sqhstl[18] = (unsigned int  )42;
   sqlstm.sqhsts[18] = (         int  )0;
   sqlstm.sqindv[18] = (         void  *)0;
   sqlstm.sqinds[18] = (         int  )0;
   sqlstm.sqharm[18] = (unsigned int  )0;
   sqlstm.sqadto[18] = (unsigned short )0;
   sqlstm.sqtdso[18] = (unsigned short )0;
   sqlstm.sqhstv[19] = (         void  *)&nd_logo_pgm_id;
   sqlstm.sqhstl[19] = (unsigned int  )1002;
   sqlstm.sqhsts[19] = (         int  )0;
   sqlstm.sqindv[19] = (         void  *)0;
   sqlstm.sqinds[19] = (         int  )0;
   sqlstm.sqharm[19] = (unsigned int  )0;
   sqlstm.sqadto[19] = (unsigned short )0;
   sqlstm.sqtdso[19] = (unsigned short )0;
   sqlstm.sqhstv[20] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[20] = (unsigned int  )18;
   sqlstm.sqhsts[20] = (         int  )0;
   sqlstm.sqindv[20] = (         void  *)0;
   sqlstm.sqinds[20] = (         int  )0;
   sqlstm.sqharm[20] = (unsigned int  )0;
   sqlstm.sqadto[20] = (unsigned short )0;
   sqlstm.sqtdso[20] = (unsigned short )0;
   sqlstm.sqhstv[21] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[21] = (unsigned int  )15;
   sqlstm.sqhsts[21] = (         int  )0;
   sqlstm.sqindv[21] = (         void  *)0;
   sqlstm.sqinds[21] = (         int  )0;
   sqlstm.sqharm[21] = (unsigned int  )0;
   sqlstm.sqadto[21] = (unsigned short )0;
   sqlstm.sqtdso[21] = (unsigned short )0;
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

   if (NODATAFOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");




   nd_facility_id.arr[nd_facility_id.len]				= '\0';
   nd_fm_doc_type.arr[nd_fm_doc_type.len]				= '\0';
   nd_fm_doc_num.arr[nd_fm_doc_num.len]					= '\0';
   nd_to_doc_type.arr[nd_to_doc_type.len]				= '\0';
   nd_to_doc_num.arr[nd_to_doc_num.len]					= '\0';
   nd_fm_doc_date.arr[nd_fm_doc_date.len]				= '\0';
   nd_to_doc_date.arr[nd_to_doc_date.len]				= '\0';
   d_cashfacility_id.arr[d_cashfacility_id.len]			= '\0';
   p_cash_counter.arr[p_cash_counter.len]				= '\0';
   p_shift.arr[p_shift.len]  							= '\0';
   trx_type.arr[trx_type.len]	  						= '\0';
   l_detail_report_flag.arr[l_detail_report_flag.len]	= '\0';
   l_print_without_disc_func.arr[l_print_without_disc_func.len]	= '\0';
   l_no_settlement_details.arr[l_no_settlement_details.len] = '\0';
   nd_ws_no.arr[nd_ws_no.len] = '\0';
   nd_logo_pgm_id.arr[nd_logo_pgm_id.len]		= '\0';

   	
	strcpy(g_facility_id,nd_facility_id.arr);


}

prepare_file()
{
	if (LOGO_DIR.arr[0] != '\0') 
		strcpy(filename,LOGO_DIR.arr);
	else 
		strcpy(filename,WORKING_DIR);

		
	strcat(filename,nd_file_name.arr);

	strcpy (OUTPUT_FILE_NAME, filename);

	if ((fp = fopen(filename,"w")) == NULL)
		{ 		disp_message (ERR_MESG,"Error Opening Output File");
				proc_exit();
		}

		return;
}

declare_master_cur()
{
	/* EXEC SQL DECLARE BL_BILL_PRINT_TEMP_CUR CURSOR FOR
	SELECT	DOC_TYPE_CODE,
			DOC_NUM,	
			DOC_TYPE_CODE ||'/'||LTRIM(TO_CHAR(DOC_NUM,'00000009')) No,
			TO_CHAR(DOC_DATE,'DD/MM/YYYY') DOC_DATE,
			SERV_DISC_AMT,
			MAN_DISC_AMT,
			OVERALL_DISC_AMT,
			NVL(PREPAY_ADJ_AMT,0) PREPAY_ADJ_AMT,
			NVL(DEPOSIT_ADJ_AMT,0) DEPOSIT_ADJ_AMT,
			NVL(TOT_PAID_AMT,0) TOT_PAID_AMT,
			EPISODE_ID,
			LTRIM(TO_CHAR(EPISODE_ID,'00000009')) EPI_ID,
			VISIT_ID,
			TO_CHAR(ADMISSION_DATE,'DD/MM/YYYY HH24:MI'),
			PHYSICIAN_ID,
			BLNG_GRP_ID,
			PATIENT_ID,
			BILL_NATURE_CODE,
			CUST_CODE,
			BILL_TYPE_CODE,
			CLINIC_CODE,
			BILL_TRX_TYPE_CODE,
			BILL_PRINT_FLAG,
			NVL(TOT_BUS_MAN_DISC_AMT,0) TOT_BUS_MAN_DISC_AMT,
			NVL(TOT_DEP_PAID_AMT,0),
			CREDIT_DOC_REF_DESC,
			BLNG_GRP_DESC,
			SHORT_NAME,
			SHORT_NAME_LOC_LANG, 
			TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY'),
			TRUNC((ABS(MONTHS_BETWEEN(SYSDATE,DATE_OF_BIRTH))/12)),
			DECODE(SEX,'M','MALE','F','FEMALE') SEX,
			FULL_NAME,
			CUST_NAME LONG_NAME,
			BILL_TYPE_DESC LONG_DESC,
 			SHORT_DESC,
			MPI_IND IND,
			NVL(MPI_ID,DOC_TYPE_CODE || DOC_NUM) MPI_ID,
   			TO_CHAR(CREDIT_DOC_REF_DATE,'DD/MM/YYYY'),
			POLICY_TYPE_CODE     ,  
			POLICY_NUMBER          ,
			TO_CHAR(POLICY_EXPIRY_DATE,'DD/MM/YYYY') ,
			CASH_COUNTER_CODE,
			SHIFT_ID,
			CASHIER_BY_ID,
            NVL(SPL_AGENCY_DEP_ADJ_AMT,0)                  	  
	FROM    BL_BILL_PRINT_TEMP
	WHERE	SESSION_ID = :nd_session_id
	ORDER	BY 1,2; */ 


	if (OERROR)
	{ 
		disp_message (ERR_MESG,"Declare Master Cursor failed");
		proc_exit();
	}
	
	return;
}


open_master_cur()
{ 
	/* EXEC SQL OPEN BL_BILL_PRINT_TEMP_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "select DOC_TYPE_CODE ,DOC_NUM ,((DOC_TYPE_CODE||'/')||LTRIM(TO_CHAR(DOC_\
NUM,'00000009'))) No ,TO_CHAR(DOC_DATE,'DD/MM/YYYY') DOC_DATE ,SERV_DISC_AMT\
 ,MAN_DISC_AMT ,OVERALL_DISC_AMT ,NVL(PREPAY_ADJ_AMT,0) PREPAY_ADJ_AMT ,NVL(\
DEPOSIT_ADJ_AMT,0) DEPOSIT_ADJ_AMT ,NVL(TOT_PAID_AMT,0) TOT_PAID_AMT ,EPISOD\
E_ID ,LTRIM(TO_CHAR(EPISODE_ID,'00000009')) EPI_ID ,VISIT_ID ,TO_CHAR(ADMISS\
ION_DATE,'DD/MM/YYYY HH24:MI') ,PHYSICIAN_ID ,BLNG_GRP_ID ,PATIENT_ID ,BILL_\
NATURE_CODE ,CUST_CODE ,BILL_TYPE_CODE ,CLINIC_CODE ,BILL_TRX_TYPE_CODE ,BIL\
L_PRINT_FLAG ,NVL(TOT_BUS_MAN_DISC_AMT,0) TOT_BUS_MAN_DISC_AMT ,NVL(TOT_DEP_\
PAID_AMT,0) ,CREDIT_DOC_REF_DESC ,BLNG_GRP_DESC ,SHORT_NAME ,SHORT_NAME_LOC_\
LANG ,TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY') ,TRUNC((ABS(MONTHS_BETWEEN(SYSDATE\
,DATE_OF_BIRTH))/12)) ,DECODE(SEX,'M','MALE','F','FEMALE') SEX ,FULL_NAME ,C\
UST_NAME LONG_NAME ,BILL_TYPE_DESC LONG_DESC ,SHORT_DESC ,MPI_IND IND ,NVL(M\
PI_ID,(DOC_TYPE_CODE||DOC_NUM)) MPI_ID ,TO_CHAR(CREDIT_DOC_REF_DATE,'DD/MM/Y\
YYY') ,POLICY_TYPE_CODE ,POLICY_NUMBER ,");
 sqlstm.stmt = sq0020;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )718;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_session_id;
 sqlstm.sqhstl[0] = (unsigned int  )18;
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
	{ disp_message (ERR_MESG,"Open BL_BILL_PRINT_TEMP_CUR cursor failed");
		proc_exit();
    }
return;
}

fetch_master_cur()
{

		dc_doc_type_code.arr[0] = '\0';
		dc_doc_type_code.len = 0;
		d_doc_num.arr[0] = '\0';
		d_doc_num.len = 0;
   		d_no.arr[0] = '\0';
		d_no.len = 0;
	   	d_doc_date.arr[0] = '\0';
		d_doc_date.len = 0;
	    dc_episode_id.arr[0] = '\0';
		dc_episode_id.len = 0;
	    dc_epi_id.arr[0] = '\0';
		dc_epi_id.len = 0;
	    dc_visit_id.arr[0] = '\0';
		dc_visit_id.len = 0;
	    dc_admn_date.arr[0] = '\0';
		dc_admn_date.len = 0;
	    dc_physician_id.arr[0] = '\0';
		dc_physician_id.len = 0;
	    dc_blng_grp_id.arr[0] = '\0';
		dc_blng_grp_id.len = 0;
	    dc_patient_id.arr[0] = '\0';
		dc_patient_id.len = 0;
		d_bill_nature_code.arr[0] = '\0';
		d_bill_nature_code.len = 0;
		d_bill_trx_type_code.arr[0] = '\0';
		d_bill_trx_type_code.len = 0;
	    dc_cust_code.arr[0] = '\0';
		dc_cust_code.len = 0;
	    dc_bill_type_code.arr[0] = '\0';
		dc_bill_type_code.len = 0;
	    dc_clinic_code.arr[0] = '\0';
		dc_clinic_code.len = 0;
	    dc_bill_print_flag.arr[0] = '\0';
		dc_bill_print_flag.len = 0;
		dc_tot_dep_paid_amt.arr[0] = '\0';
		dc_tot_dep_paid_amt.len = 0;
        dc_credit_doc_ref_desc.arr[0] = '\0';
		dc_credit_doc_ref_desc.len = 0;
        dc_blng_grp_desc.arr[0] = '\0';
		dc_blng_grp_desc.len = 0;
		dc_short_name.arr[0] = '\0';
		dc_short_name.len = 0;
	    dc_short_name_loc_lang.arr[0] = '\0';
		dc_short_name_loc_lang.len = 0;
	    dc_date_of_birth.arr[0] = '\0';
		dc_date_of_birth.len = 0;
        dc_sex.arr[0] = '\0';
		dc_sex.len = 0;
        dc_full_name.arr[0] = '\0';
		dc_full_name.len = 0;
        dc_long_name.arr[0] = '\0';
		dc_long_name.len = 0;
	    dc_long_desc.arr[0] = '\0';
		dc_long_desc.len = 0;
 	    dc_short_desc.arr[0] = '\0';
		dc_short_desc.len = 0;
        dc_ind.arr[0] = '\0';
		dc_ind.len = 0;
	    dc_mpi_id.arr[0] = '\0';
		dc_mpi_id.len = 0;
   	   	dc_credit_doc_ref_date.arr[0] = '\0';
		dc_credit_doc_ref_date.len = 0;
	   	dc_policy_type_code.arr[0] = '\0' ;
		dc_policy_type_code.len = 0;
	   	dc_policy_number.arr[0] = '\0';
		dc_policy_number.len = 0;
	   	dc_policy_expiry_date.arr[0] = '\0';
		dc_policy_expiry_date.len = 0;
	    nn_cc_code.arr[0] = '\0';
        nn_shift_id.arr[0] = '\0';
		nn_cc_id.arr[0] = '\0';
	    nn_cc_name.arr[0] = '\0';
	    nd_spl_agency_amt = 0;

                

	/* EXEC SQL FETCH BL_BILL_PRINT_TEMP_CUR INTO 
 			:dc_doc_type_code,
			:d_doc_num,
			:d_no,
			:d_doc_date,
			:d_serv_disc_amt,
			:d_man_disc_amt,
			:d_overall_disc_amt,
			:d_prepay_adj_amt,
			:d_deposit_adj_amt,
			:d_tot_paid_amt,
			:dc_episode_id,
			:dc_epi_id,
			:dc_visit_id,
			:dc_admn_date,
			:dc_physician_id,
			:dc_blng_grp_id,
			:dc_patient_id,
			:d_bill_nature_code,
			:dc_cust_code,
			:dc_bill_type_code,
			:dc_clinic_code,
			:d_bill_trx_type_code,
			:dc_bill_print_flag,
	        :d_tot_bus_man_disc_amt,
            :dc_tot_dep_paid_amt,
		    :dc_credit_doc_ref_desc,
	        :dc_blng_grp_desc,
			:dc_short_name,
            :dc_short_name_loc_lang, 
			:dc_date_of_birth,
            :d_age,
			:dc_sex,
            :dc_full_name,
            :dc_long_name,
			:dc_long_desc,
 			:dc_short_desc,
            :dc_ind,
			:dc_mpi_id,
   			:dc_credit_doc_ref_date,
			:dc_policy_type_code,  
			:dc_policy_number   ,
			:dc_policy_expiry_date,
	 	    :nn_cc_code,
			:nn_shift_id,
		    :nn_cc_id,
		   	:nd_spl_agency_amt; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )737;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqfoff = (           int )0;
 sqlstm.sqfmod = (unsigned int )2;
 sqlstm.sqhstv[0] = (         void  *)&dc_doc_type_code;
 sqlstm.sqhstl[0] = (unsigned int  )9;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_doc_num;
 sqlstm.sqhstl[1] = (unsigned int  )11;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_no;
 sqlstm.sqhstl[2] = (unsigned int  )19;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_doc_date;
 sqlstm.sqhstl[3] = (unsigned int  )13;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_serv_disc_amt;
 sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&d_man_disc_amt;
 sqlstm.sqhstl[5] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&d_overall_disc_amt;
 sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&d_prepay_adj_amt;
 sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&d_deposit_adj_amt;
 sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&d_tot_paid_amt;
 sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&dc_episode_id;
 sqlstm.sqhstl[10] = (unsigned int  )11;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&dc_epi_id;
 sqlstm.sqhstl[11] = (unsigned int  )11;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&dc_visit_id;
 sqlstm.sqhstl[12] = (unsigned int  )7;
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&dc_admn_date;
 sqlstm.sqhstl[13] = (unsigned int  )19;
 sqlstm.sqhsts[13] = (         int  )0;
 sqlstm.sqindv[13] = (         void  *)0;
 sqlstm.sqinds[13] = (         int  )0;
 sqlstm.sqharm[13] = (unsigned int  )0;
 sqlstm.sqadto[13] = (unsigned short )0;
 sqlstm.sqtdso[13] = (unsigned short )0;
 sqlstm.sqhstv[14] = (         void  *)&dc_physician_id;
 sqlstm.sqhstl[14] = (unsigned int  )18;
 sqlstm.sqhsts[14] = (         int  )0;
 sqlstm.sqindv[14] = (         void  *)0;
 sqlstm.sqinds[14] = (         int  )0;
 sqlstm.sqharm[14] = (unsigned int  )0;
 sqlstm.sqadto[14] = (unsigned short )0;
 sqlstm.sqtdso[14] = (unsigned short )0;
 sqlstm.sqhstv[15] = (         void  *)&dc_blng_grp_id;
 sqlstm.sqhstl[15] = (unsigned int  )5;
 sqlstm.sqhsts[15] = (         int  )0;
 sqlstm.sqindv[15] = (         void  *)0;
 sqlstm.sqinds[15] = (         int  )0;
 sqlstm.sqharm[15] = (unsigned int  )0;
 sqlstm.sqadto[15] = (unsigned short )0;
 sqlstm.sqtdso[15] = (unsigned short )0;
 sqlstm.sqhstv[16] = (         void  *)&dc_patient_id;
 sqlstm.sqhstl[16] = (unsigned int  )23;
 sqlstm.sqhsts[16] = (         int  )0;
 sqlstm.sqindv[16] = (         void  *)0;
 sqlstm.sqinds[16] = (         int  )0;
 sqlstm.sqharm[16] = (unsigned int  )0;
 sqlstm.sqadto[16] = (unsigned short )0;
 sqlstm.sqtdso[16] = (unsigned short )0;
 sqlstm.sqhstv[17] = (         void  *)&d_bill_nature_code;
 sqlstm.sqhstl[17] = (unsigned int  )4;
 sqlstm.sqhsts[17] = (         int  )0;
 sqlstm.sqindv[17] = (         void  *)0;
 sqlstm.sqinds[17] = (         int  )0;
 sqlstm.sqharm[17] = (unsigned int  )0;
 sqlstm.sqadto[17] = (unsigned short )0;
 sqlstm.sqtdso[17] = (unsigned short )0;
 sqlstm.sqhstv[18] = (         void  *)&dc_cust_code;
 sqlstm.sqhstl[18] = (unsigned int  )11;
 sqlstm.sqhsts[18] = (         int  )0;
 sqlstm.sqindv[18] = (         void  *)0;
 sqlstm.sqinds[18] = (         int  )0;
 sqlstm.sqharm[18] = (unsigned int  )0;
 sqlstm.sqadto[18] = (unsigned short )0;
 sqlstm.sqtdso[18] = (unsigned short )0;
 sqlstm.sqhstv[19] = (         void  *)&dc_bill_type_code;
 sqlstm.sqhstl[19] = (unsigned int  )5;
 sqlstm.sqhsts[19] = (         int  )0;
 sqlstm.sqindv[19] = (         void  *)0;
 sqlstm.sqinds[19] = (         int  )0;
 sqlstm.sqharm[19] = (unsigned int  )0;
 sqlstm.sqadto[19] = (unsigned short )0;
 sqlstm.sqtdso[19] = (unsigned short )0;
 sqlstm.sqhstv[20] = (         void  *)&dc_clinic_code;
 sqlstm.sqhstl[20] = (unsigned int  )7;
 sqlstm.sqhsts[20] = (         int  )0;
 sqlstm.sqindv[20] = (         void  *)0;
 sqlstm.sqinds[20] = (         int  )0;
 sqlstm.sqharm[20] = (unsigned int  )0;
 sqlstm.sqadto[20] = (unsigned short )0;
 sqlstm.sqtdso[20] = (unsigned short )0;
 sqlstm.sqhstv[21] = (         void  *)&d_bill_trx_type_code;
 sqlstm.sqhstl[21] = (unsigned int  )43;
 sqlstm.sqhsts[21] = (         int  )0;
 sqlstm.sqindv[21] = (         void  *)0;
 sqlstm.sqinds[21] = (         int  )0;
 sqlstm.sqharm[21] = (unsigned int  )0;
 sqlstm.sqadto[21] = (unsigned short )0;
 sqlstm.sqtdso[21] = (unsigned short )0;
 sqlstm.sqhstv[22] = (         void  *)&dc_bill_print_flag;
 sqlstm.sqhstl[22] = (unsigned int  )4;
 sqlstm.sqhsts[22] = (         int  )0;
 sqlstm.sqindv[22] = (         void  *)0;
 sqlstm.sqinds[22] = (         int  )0;
 sqlstm.sqharm[22] = (unsigned int  )0;
 sqlstm.sqadto[22] = (unsigned short )0;
 sqlstm.sqtdso[22] = (unsigned short )0;
 sqlstm.sqhstv[23] = (         void  *)&d_tot_bus_man_disc_amt;
 sqlstm.sqhstl[23] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[23] = (         int  )0;
 sqlstm.sqindv[23] = (         void  *)0;
 sqlstm.sqinds[23] = (         int  )0;
 sqlstm.sqharm[23] = (unsigned int  )0;
 sqlstm.sqadto[23] = (unsigned short )0;
 sqlstm.sqtdso[23] = (unsigned short )0;
 sqlstm.sqhstv[24] = (         void  *)&dc_tot_dep_paid_amt;
 sqlstm.sqhstl[24] = (unsigned int  )23;
 sqlstm.sqhsts[24] = (         int  )0;
 sqlstm.sqindv[24] = (         void  *)0;
 sqlstm.sqinds[24] = (         int  )0;
 sqlstm.sqharm[24] = (unsigned int  )0;
 sqlstm.sqadto[24] = (unsigned short )0;
 sqlstm.sqtdso[24] = (unsigned short )0;
 sqlstm.sqhstv[25] = (         void  *)&dc_credit_doc_ref_desc;
 sqlstm.sqhstl[25] = (unsigned int  )53;
 sqlstm.sqhsts[25] = (         int  )0;
 sqlstm.sqindv[25] = (         void  *)0;
 sqlstm.sqinds[25] = (         int  )0;
 sqlstm.sqharm[25] = (unsigned int  )0;
 sqlstm.sqadto[25] = (unsigned short )0;
 sqlstm.sqtdso[25] = (unsigned short )0;
 sqlstm.sqhstv[26] = (         void  *)&dc_blng_grp_desc;
 sqlstm.sqhstl[26] = (unsigned int  )53;
 sqlstm.sqhsts[26] = (         int  )0;
 sqlstm.sqindv[26] = (         void  *)0;
 sqlstm.sqinds[26] = (         int  )0;
 sqlstm.sqharm[26] = (unsigned int  )0;
 sqlstm.sqadto[26] = (unsigned short )0;
 sqlstm.sqtdso[26] = (unsigned short )0;
 sqlstm.sqhstv[27] = (         void  *)&dc_short_name;
 sqlstm.sqhstl[27] = (unsigned int  )83;
 sqlstm.sqhsts[27] = (         int  )0;
 sqlstm.sqindv[27] = (         void  *)0;
 sqlstm.sqinds[27] = (         int  )0;
 sqlstm.sqharm[27] = (unsigned int  )0;
 sqlstm.sqadto[27] = (unsigned short )0;
 sqlstm.sqtdso[27] = (unsigned short )0;
 sqlstm.sqhstv[28] = (         void  *)&dc_short_name_loc_lang;
 sqlstm.sqhstl[28] = (unsigned int  )83;
 sqlstm.sqhsts[28] = (         int  )0;
 sqlstm.sqindv[28] = (         void  *)0;
 sqlstm.sqinds[28] = (         int  )0;
 sqlstm.sqharm[28] = (unsigned int  )0;
 sqlstm.sqadto[28] = (unsigned short )0;
 sqlstm.sqtdso[28] = (unsigned short )0;
 sqlstm.sqhstv[29] = (         void  *)&dc_date_of_birth;
 sqlstm.sqhstl[29] = (unsigned int  )13;
 sqlstm.sqhsts[29] = (         int  )0;
 sqlstm.sqindv[29] = (         void  *)0;
 sqlstm.sqinds[29] = (         int  )0;
 sqlstm.sqharm[29] = (unsigned int  )0;
 sqlstm.sqadto[29] = (unsigned short )0;
 sqlstm.sqtdso[29] = (unsigned short )0;
 sqlstm.sqhstv[30] = (         void  *)&d_age;
 sqlstm.sqhstl[30] = (unsigned int  )sizeof(long);
 sqlstm.sqhsts[30] = (         int  )0;
 sqlstm.sqindv[30] = (         void  *)0;
 sqlstm.sqinds[30] = (         int  )0;
 sqlstm.sqharm[30] = (unsigned int  )0;
 sqlstm.sqadto[30] = (unsigned short )0;
 sqlstm.sqtdso[30] = (unsigned short )0;
 sqlstm.sqhstv[31] = (         void  *)&dc_sex;
 sqlstm.sqhstl[31] = (unsigned int  )12;
 sqlstm.sqhsts[31] = (         int  )0;
 sqlstm.sqindv[31] = (         void  *)0;
 sqlstm.sqinds[31] = (         int  )0;
 sqlstm.sqharm[31] = (unsigned int  )0;
 sqlstm.sqadto[31] = (unsigned short )0;
 sqlstm.sqtdso[31] = (unsigned short )0;
 sqlstm.sqhstv[32] = (         void  *)&dc_full_name;
 sqlstm.sqhstl[32] = (unsigned int  )63;
 sqlstm.sqhsts[32] = (         int  )0;
 sqlstm.sqindv[32] = (         void  *)0;
 sqlstm.sqinds[32] = (         int  )0;
 sqlstm.sqharm[32] = (unsigned int  )0;
 sqlstm.sqadto[32] = (unsigned short )0;
 sqlstm.sqtdso[32] = (unsigned short )0;
 sqlstm.sqhstv[33] = (         void  *)&dc_long_name;
 sqlstm.sqhstl[33] = (unsigned int  )63;
 sqlstm.sqhsts[33] = (         int  )0;
 sqlstm.sqindv[33] = (         void  *)0;
 sqlstm.sqinds[33] = (         int  )0;
 sqlstm.sqharm[33] = (unsigned int  )0;
 sqlstm.sqadto[33] = (unsigned short )0;
 sqlstm.sqtdso[33] = (unsigned short )0;
 sqlstm.sqhstv[34] = (         void  *)&dc_long_desc;
 sqlstm.sqhstl[34] = (unsigned int  )53;
 sqlstm.sqhsts[34] = (         int  )0;
 sqlstm.sqindv[34] = (         void  *)0;
 sqlstm.sqinds[34] = (         int  )0;
 sqlstm.sqharm[34] = (unsigned int  )0;
 sqlstm.sqadto[34] = (unsigned short )0;
 sqlstm.sqtdso[34] = (unsigned short )0;
 sqlstm.sqhstv[35] = (         void  *)&dc_short_desc;
 sqlstm.sqhstl[35] = (unsigned int  )53;
 sqlstm.sqhsts[35] = (         int  )0;
 sqlstm.sqindv[35] = (         void  *)0;
 sqlstm.sqinds[35] = (         int  )0;
 sqlstm.sqharm[35] = (unsigned int  )0;
 sqlstm.sqadto[35] = (unsigned short )0;
 sqlstm.sqtdso[35] = (unsigned short )0;
 sqlstm.sqhstv[36] = (         void  *)&dc_ind;
 sqlstm.sqhstl[36] = (unsigned int  )12;
 sqlstm.sqhsts[36] = (         int  )0;
 sqlstm.sqindv[36] = (         void  *)0;
 sqlstm.sqinds[36] = (         int  )0;
 sqlstm.sqharm[36] = (unsigned int  )0;
 sqlstm.sqadto[36] = (unsigned short )0;
 sqlstm.sqtdso[36] = (unsigned short )0;
 sqlstm.sqhstv[37] = (         void  *)&dc_mpi_id;
 sqlstm.sqhstl[37] = (unsigned int  )102;
 sqlstm.sqhsts[37] = (         int  )0;
 sqlstm.sqindv[37] = (         void  *)0;
 sqlstm.sqinds[37] = (         int  )0;
 sqlstm.sqharm[37] = (unsigned int  )0;
 sqlstm.sqadto[37] = (unsigned short )0;
 sqlstm.sqtdso[37] = (unsigned short )0;
 sqlstm.sqhstv[38] = (         void  *)&dc_credit_doc_ref_date;
 sqlstm.sqhstl[38] = (unsigned int  )13;
 sqlstm.sqhsts[38] = (         int  )0;
 sqlstm.sqindv[38] = (         void  *)0;
 sqlstm.sqinds[38] = (         int  )0;
 sqlstm.sqharm[38] = (unsigned int  )0;
 sqlstm.sqadto[38] = (unsigned short )0;
 sqlstm.sqtdso[38] = (unsigned short )0;
 sqlstm.sqhstv[39] = (         void  *)&dc_policy_type_code;
 sqlstm.sqhstl[39] = (unsigned int  )23;
 sqlstm.sqhsts[39] = (         int  )0;
 sqlstm.sqindv[39] = (         void  *)0;
 sqlstm.sqinds[39] = (         int  )0;
 sqlstm.sqharm[39] = (unsigned int  )0;
 sqlstm.sqadto[39] = (unsigned short )0;
 sqlstm.sqtdso[39] = (unsigned short )0;
 sqlstm.sqhstv[40] = (         void  *)&dc_policy_number;
 sqlstm.sqhstl[40] = (unsigned int  )33;
 sqlstm.sqhsts[40] = (         int  )0;
 sqlstm.sqindv[40] = (         void  *)0;
 sqlstm.sqinds[40] = (         int  )0;
 sqlstm.sqharm[40] = (unsigned int  )0;
 sqlstm.sqadto[40] = (unsigned short )0;
 sqlstm.sqtdso[40] = (unsigned short )0;
 sqlstm.sqhstv[41] = (         void  *)&dc_policy_expiry_date;
 sqlstm.sqhstl[41] = (unsigned int  )13;
 sqlstm.sqhsts[41] = (         int  )0;
 sqlstm.sqindv[41] = (         void  *)0;
 sqlstm.sqinds[41] = (         int  )0;
 sqlstm.sqharm[41] = (unsigned int  )0;
 sqlstm.sqadto[41] = (unsigned short )0;
 sqlstm.sqtdso[41] = (unsigned short )0;
 sqlstm.sqhstv[42] = (         void  *)&nn_cc_code;
 sqlstm.sqhstl[42] = (unsigned int  )5;
 sqlstm.sqhsts[42] = (         int  )0;
 sqlstm.sqindv[42] = (         void  *)0;
 sqlstm.sqinds[42] = (         int  )0;
 sqlstm.sqharm[42] = (unsigned int  )0;
 sqlstm.sqadto[42] = (unsigned short )0;
 sqlstm.sqtdso[42] = (unsigned short )0;
 sqlstm.sqhstv[43] = (         void  *)&nn_shift_id;
 sqlstm.sqhstl[43] = (unsigned int  )4;
 sqlstm.sqhsts[43] = (         int  )0;
 sqlstm.sqindv[43] = (         void  *)0;
 sqlstm.sqinds[43] = (         int  )0;
 sqlstm.sqharm[43] = (unsigned int  )0;
 sqlstm.sqadto[43] = (unsigned short )0;
 sqlstm.sqtdso[43] = (unsigned short )0;
 sqlstm.sqhstv[44] = (         void  *)&nn_cc_id;
 sqlstm.sqhstl[44] = (unsigned int  )33;
 sqlstm.sqhsts[44] = (         int  )0;
 sqlstm.sqindv[44] = (         void  *)0;
 sqlstm.sqinds[44] = (         int  )0;
 sqlstm.sqharm[44] = (unsigned int  )0;
 sqlstm.sqadto[44] = (unsigned short )0;
 sqlstm.sqtdso[44] = (unsigned short )0;
 sqlstm.sqhstv[45] = (         void  *)&nd_spl_agency_amt;
 sqlstm.sqhstl[45] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[45] = (         int  )0;
 sqlstm.sqindv[45] = (         void  *)0;
 sqlstm.sqinds[45] = (         int  )0;
 sqlstm.sqharm[45] = (unsigned int  )0;
 sqlstm.sqadto[45] = (unsigned short )0;
 sqlstm.sqtdso[45] = (unsigned short )0;
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
		disp_message(ERR_MESG,"FETCH FAILED IN BL_BILL_PRINT_TEMP_CUR");
		proc_exit();
	}

    if(NODATAFOUND)
		{
			return 0;
		}


	    nn_cc_code.arr[nn_cc_code.len] = '\0';
        nn_shift_id.arr[nn_shift_id.len] = '\0';
		nn_cc_id.arr[nn_cc_id.len] = '\0';
	    nn_cc_name.arr[nn_cc_name.len] = '\0';

		dc_doc_type_code.arr[dc_doc_type_code.len] = '\0';
		d_doc_num.arr[d_doc_num.len] = '\0';
	   	d_no.arr[d_no.len] = '\0';
	   	d_doc_date.arr[d_doc_date.len] = '\0';
	    dc_episode_id.arr[dc_episode_id.len] = '\0';
	    dc_epi_id.arr[dc_epi_id.len] = '\0';
	    dc_visit_id.arr[dc_visit_id.len] = '\0';
	    dc_admn_date.arr[dc_admn_date.len] = '\0';
	    dc_physician_id.arr[dc_physician_id.len] = '\0';
	    dc_blng_grp_id.arr[dc_blng_grp_id.len] = '\0';
	    dc_patient_id.arr[dc_patient_id.len] = '\0';
		d_bill_nature_code.arr[d_bill_nature_code.len] = '\0';
		d_bill_trx_type_code.arr[d_bill_trx_type_code.len] = '\0';
	    dc_cust_code.arr[dc_cust_code.len] = '\0';
	    dc_bill_type_code.arr[dc_bill_type_code.len] = '\0';
	    dc_clinic_code.arr[dc_clinic_code.len] = '\0';
	    dc_bill_print_flag.arr[dc_bill_print_flag.len] = '\0';
		dc_tot_dep_paid_amt.arr[dc_tot_dep_paid_amt.len] = '\0';
        dc_credit_doc_ref_desc.arr[dc_credit_doc_ref_desc.len] = '\0';
        dc_blng_grp_desc.arr[dc_blng_grp_desc.len] = '\0';
	    dc_short_name.arr[dc_short_name.len] = '\0';
	    dc_short_name_loc_lang.arr[dc_short_name_loc_lang.len] = '\0';
	    dc_date_of_birth.arr[dc_date_of_birth.len] = '\0';
        dc_sex.arr[dc_sex.len] = '\0';
        dc_full_name.arr[dc_full_name.len] = '\0';
        dc_long_name.arr[dc_long_name.len] = '\0';
	    dc_long_desc.arr[dc_long_desc.len] = '\0';
 	    dc_short_desc.arr[dc_short_desc.len] = '\0';
        dc_ind.arr[dc_ind.len] = '\0';
	    dc_mpi_id.arr[dc_mpi_id.len] = '\0';
   	   	dc_credit_doc_ref_date.arr[dc_credit_doc_ref_date.len] = '\0';
	   	dc_policy_type_code.arr[dc_policy_type_code.len] = '\0' ;
	   	dc_policy_number.arr[dc_policy_number.len] = '\0';
	   	dc_policy_expiry_date.arr[dc_policy_expiry_date.len] = '\0';
	    nd_tot_spl_agency_amt = nd_tot_spl_agency_amt + nd_spl_agency_amt;

	    /* Episode Type */
		episode_type();

	return 1;
}

close_master_cur()
{ 
	/* EXEC SQL CLOSE BL_BILL_PRINT_TEMP_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )936;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	if (OERROR) 
		{
			disp_message (ERR_MESG,"Close bl_bill_print_temp_cur failed");
			proc_exit();
		}
return;
}

episode_type()
{
  nd_episode_type = 'O';

  /* EXEC SQL select episode_type into :nd_episode_type 
           from bl_bill_hdr 
		   where doc_type_code = :dc_doc_type_code
		   and doc_num = TO_NUMBER(:d_doc_num); */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select episode_type into :b0  from bl_bill_hdr where (doc_t\
ype_code=:b1 and doc_num=TO_NUMBER(:b2))";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )951;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_episode_type;
  sqlstm.sqhstl[0] = (unsigned int  )1;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&dc_doc_type_code;
  sqlstm.sqhstl[1] = (unsigned int  )9;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_doc_num;
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


  if ( sqlca.sqlcode == 1403 )
	nd_episode_type = 'O';
}


declare_grp_hdr_cur()
{
    /* EXEC SQL DECLARE BL_BILL_GRP_HDR_LINE_CUR CURSOR FOR
	 SELECT	A.DOC_TYPE_CODE,
			A.PRT_GRP_HDR_CODE,
			A.PRT_GRP_LINE_CODE,
            SUM(NVL(A.GROSS_AMT,0)) GROSS_AMT,
		    SUM(NVL(A.NET_AMT,0)),
            C.LONG_DESC,
            D.LONG_DESC,NVL(A.MPI_ID,A.DOC_TYPE_CODE || A.DOC_NUM) MPI_ID,
			SUM(NVL(A.SERV_DISC_AMT,0)+NVL(MAN_DISC_AMT,0))
	FROM    BL_BILL_LINE A,BL_BLNG_PRT_GRP_HDR C,BL_BLNG_PRT_GRP_LINE D
	WHERE 	A.DOC_TYPE_CODE BETWEEN :nd_fm_doc_type AND :nd_to_doc_type
	AND     A.DOC_NUM BETWEEN TO_NUMBER(:nd_fm_doc_num) AND TO_NUMBER(:nd_to_doc_num)
	AND     C.PRT_GRP_HDR_CODE = D.PRT_GRP_HDR_CODE
	AND     A.PRT_GRP_HDR_CODE  = D.PRT_GRP_HDR_CODE (+)
	AND     A.PRT_GRP_LINE_CODE = D.PRT_GRP_LINE_CODE (+)
	AND		NVL(A.MPI_ID,A.DOC_TYPE_CODE || A.DOC_NUM) = :dc_mpi_id
	GROUP BY	A.DOC_TYPE_CODE,
				A.PRT_GRP_HDR_CODE,
				A.PRT_GRP_LINE_CODE,
                C.LONG_DESC,
              	D.LONG_DESC,NVL(A.MPI_ID,A.DOC_TYPE_CODE || A.DOC_NUM) 
	ORDER BY A.PRT_GRP_HDR_CODE, A.PRT_GRP_LINE_CODE; */ 


	if (OERROR) 
	{	disp_message (ERR_MESG,"Failed to Declare Group Header Cursor");
		proc_exit;
	}
	
	return;
}

declare_cust_cur()
{
    /* EXEC SQL DECLARE BL_BILL_HDR_CUST_CUR CURSOR FOR
        SELECT A.DOC_TYPE_CODE,
		A.DOC_NUM,
		TO_CHAR(A.DOC_DATE,'DD/MM/YYYY'),
		DECODE(:discount_print_yn,'Y',nvl(A.BILL_AMT,0),nvl(A.GROSS_AMT,0)) BILL_TOT_AMT,
		A.MPI_IND,
		A.MPI_ID MPI_ID,B.SHORT_NAME
	 FROM	BL_BILL_HDR A,AR_CUSTOMER B
	 WHERE  A.DOC_TYPE_CODE BETWEEN :nd_fm_doc_type AND :nd_to_doc_type
	 AND 	A.DOC_NUM BETWEEN TO_NUMBER(:nd_fm_doc_num) AND TO_NUMBER(:nd_to_doc_num)
	 AND 	A.CUST_CODE =  B.CUST_CODE(+)
	 AND	A.DOC_TYPE_CODE = :dc_doc_type_code
	 AND	A.DOC_NUM	!= :d_doc_num
	 AND 	TO_CHAR(A.DOC_DATE,'DD/MM/YYYY') = :d_doc_date
	 AND    b.acc_entity_code (+)= :nd_acc_entity_code
	 AND 	NVL(A.MPI_ID,A.DOC_TYPE_CODE||A.DOC_NUM)	= :dc_mpi_id; */ 
 

if (OERROR) 
	{	disp_message (ERR_MESG,"Failed to Declare customer cursor");
		proc_exit;
	}
return;
}

fetch_bill_type_desc()
{
    d_bill_type_desc.arr[0]   = '\0';
	d_remarks_1.arr[0]        = '\0';
	d_remarks_2.arr[0]        = '\0';
	d_remarks_3.arr[0]        = '\0';
	d_remarks_4.arr[0]        = '\0';
	d_remarks_5.arr[0]        = '\0';
	d_remarks_6.arr[0]        = '\0';
	d_remarks_7.arr[0]        = '\0';

    d_bill_type_desc.len      = 0;
	d_remarks_1.len           = 0;
	d_remarks_2.len           = 0;
	d_remarks_3.len           = 0;
	d_remarks_4.len           = 0;
	d_remarks_5.len           = 0;
	d_remarks_6.len           = 0;
	d_remarks_7.len           = 0;
	
    /* EXEC SQL SELECT LONG_DESC, 
				REMARKS_1, 
				REMARKS_2, 
				REMARKS_3, 
				REMARKS_4, 
				REMARKS_5, 
				REMARKS_6, 
				REMARKS_7
		 INTO   :d_bill_type_desc, 
				:d_remarks_1, 
				:d_remarks_2,
				:d_remarks_3, 
				:d_remarks_4, 
				:d_remarks_5,
				:d_remarks_6, 
				:d_remarks_7
	         FROM BL_BILL_TYPE
	         WHERE BILL_TYPE_CODE = :dc_bill_type_code
		 AND ACC_ENTITY_CODE IN ( SELECT ACC_ENTITY_CODE FROM SY_ACC_ENTITY
					  WHERE ACC_ENTITY_ID = :nd_facility_id); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 46;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select LONG_DESC ,REMARKS_1 ,REMARKS_2 ,REMARKS_3 ,REMARK\
S_4 ,REMARKS_5 ,REMARKS_6 ,REMARKS_7 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7  fro\
m BL_BILL_TYPE where (BILL_TYPE_CODE=:b8 and ACC_ENTITY_CODE in (select ACC_EN\
TITY_CODE  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b9))";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )978;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_bill_type_desc;
    sqlstm.sqhstl[0] = (unsigned int  )33;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_remarks_1;
    sqlstm.sqhstl[1] = (unsigned int  )63;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_remarks_2;
    sqlstm.sqhstl[2] = (unsigned int  )63;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_remarks_3;
    sqlstm.sqhstl[3] = (unsigned int  )63;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_remarks_4;
    sqlstm.sqhstl[4] = (unsigned int  )63;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_remarks_5;
    sqlstm.sqhstl[5] = (unsigned int  )63;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_remarks_6;
    sqlstm.sqhstl[6] = (unsigned int  )63;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_remarks_7;
    sqlstm.sqhstl[7] = (unsigned int  )63;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&dc_bill_type_code;
    sqlstm.sqhstl[8] = (unsigned int  )5;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&nd_facility_id;
    sqlstm.sqhstl[9] = (unsigned int  )5;
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



    if(OERROR)
	err_mesg("SELECT failed on table BL_BILL_TYPE",0,"");

    d_bill_type_desc.arr[d_bill_type_desc.len]  = '\0';
	d_remarks_1.arr[d_remarks_1.len]            = '\0';
	d_remarks_2.arr[d_remarks_2.len]            = '\0';
	d_remarks_3.arr[d_remarks_3.len]            = '\0';
	d_remarks_4.arr[d_remarks_4.len]            = '\0';
	d_remarks_5.arr[d_remarks_5.len]            = '\0';
	d_remarks_6.arr[d_remarks_6.len]            = '\0';
	d_remarks_7.arr[d_remarks_7.len]            = '\0';
}


declare_refund_cur()
{
    /* EXEC SQL DECLARE BL_REFUND_CUR CURSOR FOR
	 SELECT DOC_TYPE_CODE,
		DOC_NUMBER|| '   ' || TO_CHAR(DOC_DATE,'DD/MM/YYYY') DOC_NUMBER,
		PATIENT_ID,EPISODE_ID,DOC_AMT
	 FROM 	BL_RECEIPT_REFUND_HDR	 
	 WHERE 	EPISODE_TYPE IN ( 'E','O' ,'R')
	 AND    RECPT_NATURE_CODE = 'AD'
	 AND	((EPISODE_ID = :dc_episode_id AND :nd_episode_type in ('E','O'))
			  OR (:nd_episode_type = 'R'))
	 AND	PATIENT_ID = :dc_patient_id
	 AND	(DOC_TYPE_CODE,DOC_NUMBER) IN 
			(SELECT ORG_DOC_TYPE_CODE ,ORG_DOC_NUM FROM BL_PATIENT_LEDGER
			  WHERE RECPT_NATURE_CODE = 'AD' AND 
			  AD_PR_ADJ_BILL_DOC_TYPE = :dc_doc_type_code
			  AND AD_PR_ADJ_BILL_DOC_NUM  = :d_doc_num)
	 AND    CASH_COUNTER_FACILITY_ID = :nd_facility_id; */ 


	if (OERROR) 
	{	disp_message(ERR_MESG,"Failed to Declare refund cursor");
		proc_exit;
	}
	
	return;
}


declare_prepay_cur()
{
    /* EXEC SQL DECLARE BL_PREPAY_CUR CURSOR FOR
	 SELECT DOC_TYPE_CODE,
			DOC_NUMBER||'   ' ||TO_CHAR(DOC_DATE,'DD/MM/YYYY') DOC_NUMBER,
			PATIENT_ID,
			EPISODE_ID,
			DOC_AMT
	   FROM BL_RECEIPT_REFUND_HDR
	  WHERE EPISODE_TYPE IN ('E', 'O' ,'R')
	    AND CASH_COUNTER_FACILITY_ID = :nd_facility_id	
	    AND RECPT_NATURE_CODE = 'PR'
	    AND	((EPISODE_ID = :dc_episode_id AND :nd_episode_type in ('E','O'))
			  OR (:nd_episode_type = 'R'))
		AND	(DOC_TYPE_CODE,DOC_NUMBER) IN 
			( SELECT ORG_DOC_TYPE_CODE ,ORG_DOC_NUM FROM BL_PATIENT_LEDGER
			  WHERE RECPT_NATURE_CODE = 'PR' AND 
			  AD_PR_ADJ_BILL_DOC_TYPE = :dc_doc_type_code
			  AND AD_PR_ADJ_BILL_DOC_NUM  = :d_doc_num )
		AND	PATIENT_ID = :dc_patient_id; */ 


	if (OERROR) 
	{	disp_message (ERR_MESG,"Failed to declare prepay cursor");
		proc_exit();
    }
	return;
}


open_grp_hdr_cur()
{
	
	/* EXEC SQL OPEN BL_BILL_GRP_HDR_LINE_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0022;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1033;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_fm_doc_type;
 sqlstm.sqhstl[0] = (unsigned int  )33;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_to_doc_type;
 sqlstm.sqhstl[1] = (unsigned int  )33;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_fm_doc_num;
 sqlstm.sqhstl[2] = (unsigned int  )33;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_to_doc_num;
 sqlstm.sqhstl[3] = (unsigned int  )33;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&dc_mpi_id;
 sqlstm.sqhstl[4] = (unsigned int  )102;
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
		disp_message (ERR_MESG,"Open Cursor Group Header Failed");
		proc_exit();
	}

	return;
}

fetch_grp_hdr_cur()
{
	d1_doc_type_code.arr[0] = '\0';
	d1_doc_type_code.len = 0;
	d1_prt_grp_hdr_code.arr[0] = '\0';
	d1_prt_grp_hdr_code.len = 0;
	d1_prt_grp_line_code.arr[0] = '\0';
	d1_prt_grp_line_code.len = 0;
    d1_long_desc.arr[0] = '\0';
	d1_long_desc.len = 0;
    d1_long_desc1.arr[0] = '\0';
	d1_long_desc1.len = 0;
	d1_mpi_id.arr[0] = '\0';
	d1_mpi_id.len = 0;
	l_bill_line_pr_gp_disc_amt = 0;
	
	/* EXEC SQL FETCH BL_BILL_GRP_HDR_LINE_CUR INTO	
				:d1_doc_type_code,
				:d1_prt_grp_hdr_code,
				:d1_prt_grp_line_code,
                :d1_gross_amt,
				:d1_net_amt,
                :d1_long_desc,
              	:d1_long_desc1,
				:d1_mpi_id,
				:l_bill_line_pr_gp_disc_amt; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1068;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqfoff = (           int )0;
 sqlstm.sqfmod = (unsigned int )2;
 sqlstm.sqhstv[0] = (         void  *)&d1_doc_type_code;
 sqlstm.sqhstl[0] = (unsigned int  )9;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d1_prt_grp_hdr_code;
 sqlstm.sqhstl[1] = (unsigned int  )5;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d1_prt_grp_line_code;
 sqlstm.sqhstl[2] = (unsigned int  )5;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d1_gross_amt;
 sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d1_net_amt;
 sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&d1_long_desc;
 sqlstm.sqhstl[5] = (unsigned int  )53;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&d1_long_desc1;
 sqlstm.sqhstl[6] = (unsigned int  )53;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&d1_mpi_id;
 sqlstm.sqhstl[7] = (unsigned int  )49;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&l_bill_line_pr_gp_disc_amt;
 sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
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



	if (OERROR)
	{ 
		disp_message(ERR_MESG,"Fetch Group Header Cursor Failed");
		proc_exit();
	}

    if(NODATAFOUND)
	{
   		return 0;
	}

	d1_doc_type_code.arr[d1_doc_type_code.len] = '\0';
	d1_prt_grp_hdr_code.arr[d1_prt_grp_hdr_code.len] = '\0';
	d1_prt_grp_line_code.arr[d1_prt_grp_line_code.len] = '\0';
    d1_long_desc.arr[d1_long_desc.len] = '\0';
    d1_long_desc1.arr[d1_long_desc1.len] = '\0';
	d1_mpi_id.arr[d1_mpi_id.len] = '\0';

	return 1;
}


declare_service_line_cur()
{
         /* EXEC SQL DECLARE BL_BILL_SERV_LINE_CUR CURSOR FOR
         SELECT 	A.PACKAGE_SERVICE_CODE,
			//DECODE(A.PACKAGE_IND, 'S', C.SHORT_DESC, 'P', D.SHORT_DESC),
			//DECODE(NVL(c.misc_serv_yn,'N'),'Y',NVL(b.serv_item_desc,c.long_desc),
			//DECODE(A.PACKAGE_IND, 'S', C.LONG_DESC, 'P', D.LONG_DESC)),
			DECODE(A.PACKAGE_IND, 'S',NVL(b.serv_item_desc,c.long_desc), 'P', D.LONG_DESC,NVL(b.serv_item_desc,c.long_desc)),			
			TO_CHAR(B.SERVICE_DATE,'DD/MM/YYYY'),
			NVL(B.SERV_QTY,0), 
			NVL(B.ORG_GROSS_CHARGE_AMT,0),
			NVL(B.ORG_NET_CHARGE_AMT,0),
			NVL(B.ORG_DISC_AMT,0),
			B.BASE_RATE,
			B.BASE_QTY,
			B.BASE_RATE||'/'||B.BASE_QTY 
		 FROM   BL_BILL_SERVICE_LINE A ,
		        BL_PATIENT_CHARGES_FOLIO B,
	                BL_BLNG_SERV  C,
			BL_PACKAGE_HDR D
		 WHERE	        
			A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID	AND
			A.OPERATING_FACILITY_ID = :nd_facility_id 		AND
			A.DOC_TYPE_CODE		= :dc_doc_type_code      AND
			((A.DOC_NUM		= :d_doc_num							
			  AND :dc_doc_type_code||:d_doc_num = :dc_mpi_id) or
			 (A.DOC_NUM in (select doc_num from bl_bill_hdr where
			  doc_type_code = :dc_doc_type_code and mpi_id = :dc_mpi_id
			  and operating_facility_id = :nd_facility_id) and :dc_doc_type_code||:d_doc_num <> :dc_mpi_id))
				AND
				A.PRT_GRP_HDR_CODE	= :d1_prt_grp_hdr_code	AND
				a.PRT_GRP_LINE_CODE	= :d1_prt_grp_line_code AND 
				A.DOC_TYPE_CODE  	= B.BILL_DOC_TYPE_CODE  AND
				A.DOC_NUM 		= B.BILL_DOC_NUM						AND
				A.PRT_GRP_HDR_CODE 	= B.PRT_GRP_HDR_CODE 	AND		
				A.PRT_GRP_LINE_CODE	= B.PRT_GRP_LINE_CODE	AND
				A.PACKAGE_SERVICE_CODE  = B.BLNG_SERV_CODE		AND  
				A.PACKAGE_IND		= B.PACKAGE_IND							AND
				B.BLNG_SERV_CODE	= C.BLNG_SERV_CODE (+)	AND   
				B.PACKAGE_SERVICE_CODE	= D.PACKAGE_CODE (+)	AND   
				A.AMT_SIGN_IND 			= 0			
and 
(
trx_status is null 
OR 
( 
	trx_status = 'C' and (
				orig_doc_ref is null 
				and 0 = ( select count(1) from bl_patient_charges_folio
					  where operating_facility_id = :nd_facility_id
					  and bill_doc_type_code = :dc_doc_type_code
					  and bill_doc_num = :d_doc_num
					  and orig_doc_ref = b.trx_doc_ref
					  and orig_doc_ref_line_num = b.trx_doc_ref_line_num
					  and orig_doc_ref_seq_num = b.trx_doc_ref_seq_num
					 )
			     )
			 OR
				     (
				orig_doc_ref is not null 
				and 0 = ( select count(1) from bl_patient_charges_folio
					  where operating_facility_id = :nd_facility_id
					  and bill_doc_type_code = :dc_doc_type_code
					  and bill_doc_num = :d_doc_num
					  and trx_doc_ref = b.orig_doc_ref
					  and trx_doc_ref_line_num = b.orig_doc_ref_line_num
					  and trx_doc_ref_seq_num = b.orig_doc_ref_seq_num
					 )
			     )
)
	   )
	 

		/oGROUP BY	A.PACKAGE_SERVICE_CODE,
			DECODE(A.PACKAGE_IND, 'S', C.SHORT_DESC, 'P', D.SHORT_DESC),
			TO_CHAR(B.SERVICE_DATE,'DD/MM/YYYY')o/
		ORDER BY	                3,1; */ 
	
				
}



int fetch_service_line_cur()
{

  d_service_code.arr[0] = '\0';
  d_service_code.len = 0;

  d_service_desc.arr[0] = '\0';
  d_service_desc.len = 0;

  d_service_date.arr[0] = '\0';
  d_service_date.len = 0;

  nd_base_rate_qty.arr[0] = '\0';
  nd_base_rate_qty.len = 0;
  
   /* EXEC SQL FETCH BL_BILL_SERV_LINE_CUR 
	    INTO 
		  :d_service_code,
		  :d_service_desc,
		  :d_service_date,
		  :d_service_qty,
		  :d_service_amt,
		  :d_service_net,
		  :d_service_disc,
		  :d_base_rate,
		  :d_base_qty,
		  :nd_base_rate_qty; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 46;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1119;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqfoff = (           int )0;
   sqlstm.sqfmod = (unsigned int )2;
   sqlstm.sqhstv[0] = (         void  *)&d_service_code;
   sqlstm.sqhstl[0] = (unsigned int  )13;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_service_desc;
   sqlstm.sqhstl[1] = (unsigned int  )43;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_service_date;
   sqlstm.sqhstl[2] = (unsigned int  )14;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_service_qty;
   sqlstm.sqhstl[3] = (unsigned int  )sizeof(long);
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_service_amt;
   sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_service_net;
   sqlstm.sqhstl[5] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&d_service_disc;
   sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&d_base_rate;
   sqlstm.sqhstl[7] = (unsigned int  )sizeof(long);
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&d_base_qty;
   sqlstm.sqhstl[8] = (unsigned int  )sizeof(long);
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_base_rate_qty;
   sqlstm.sqhstl[9] = (unsigned int  )22;
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


	if (OERROR)
	{ 
		disp_message(ERR_MESG,"FETCH FAILED IN BL_BILL_SERV_LINE_CUR ");
		proc_exit();
	}

    if(NODATAFOUND)
	{
		return 0;
	}

	d_service_code.arr[d_service_code.len] = '\0';
	d_service_desc.arr[d_service_desc.len] = '\0';
	d_service_date.arr[d_service_date.len] = '\0';   
	nd_base_rate_qty.arr[nd_base_rate_qty.len] = '\0';
}



open_cust_cur()
{
	/* EXEC SQL OPEN BL_BILL_HDR_CUST_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0023;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1174;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlstm.sqhstv[0] = (         void  *)&discount_print_yn;
 sqlstm.sqhstl[0] = (unsigned int  )1;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_fm_doc_type;
 sqlstm.sqhstl[1] = (unsigned int  )33;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_to_doc_type;
 sqlstm.sqhstl[2] = (unsigned int  )33;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_fm_doc_num;
 sqlstm.sqhstl[3] = (unsigned int  )33;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_to_doc_num;
 sqlstm.sqhstl[4] = (unsigned int  )33;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&dc_doc_type_code;
 sqlstm.sqhstl[5] = (unsigned int  )9;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&d_doc_num;
 sqlstm.sqhstl[6] = (unsigned int  )11;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&d_doc_date;
 sqlstm.sqhstl[7] = (unsigned int  )13;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&nd_acc_entity_code;
 sqlstm.sqhstl[8] = (unsigned int  )7;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&dc_mpi_id;
 sqlstm.sqhstl[9] = (unsigned int  )102;
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



	if (OERROR) 
	{	disp_message(ERR_MESG,"Open Customer Cursor Failed");
		proc_exit();
	}

	return;
}

fetch_cust_cur()
{
	d2_doc_type_code.arr[0] = '\0';
	d2_doc_type_code.len = 0;
	d2_doc_num.arr[0] = '\0';
	d2_doc_num.len = 0;
	d2_doc_date.arr[0] = '\0';
	d2_doc_date.len = 0;
	d2_mpi_ind.arr[0] = '\0';
	d2_mpi_ind.len = 0;
	d2_mpi_id.arr[0] = '\0';
	d2_mpi_id.len =  0;
	d2_short_name.arr[0] = '\0';
	d2_short_name.len = 0;

	/* EXEC SQL FETCH BL_BILL_HDR_CUST_CUR INTO	
		:d2_doc_type_code,
		:d2_doc_num,
		:d2_doc_date,
		:d2_bill_tot_amt,
		:d2_mpi_ind,
		:d2_mpi_id,
		:d2_short_name; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1229;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqfoff = (           int )0;
 sqlstm.sqfmod = (unsigned int )2;
 sqlstm.sqhstv[0] = (         void  *)&d2_doc_type_code;
 sqlstm.sqhstl[0] = (unsigned int  )9;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d2_doc_num;
 sqlstm.sqhstl[1] = (unsigned int  )11;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d2_doc_date;
 sqlstm.sqhstl[2] = (unsigned int  )13;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d2_bill_tot_amt;
 sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d2_mpi_ind;
 sqlstm.sqhstl[4] = (unsigned int  )4;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&d2_mpi_id;
 sqlstm.sqhstl[5] = (unsigned int  )49;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&d2_short_name;
 sqlstm.sqhstl[6] = (unsigned int  )18;
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



	if (OERROR)
	{	
		disp_message(ERR_MESG,"Fetch Customer Cursor Failed");
		proc_exit();
	}

	if(NODATAFOUND)
	{
   		return 0;
	}

	d2_doc_type_code.arr[d2_doc_type_code.len] = '\0';
	d2_doc_num.arr[d2_doc_num.len] = '\0';
	d2_doc_date.arr[d2_doc_date.len] = '\0';
	d2_mpi_ind.arr[d2_mpi_ind.len] = '\0';
	d2_mpi_id.arr[d2_mpi_id.len] = '\0';
	d2_short_name.arr[d2_short_name.len] = '\0';

	return 1;
}

open_refund_cur()
{
	/* EXEC SQL OPEN BL_REFUND_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0025;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1272;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlstm.sqhstv[0] = (         void  *)&dc_episode_id;
 sqlstm.sqhstl[0] = (unsigned int  )11;
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
 sqlstm.sqhstv[2] = (         void  *)&nd_episode_type;
 sqlstm.sqhstl[2] = (unsigned int  )1;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&dc_patient_id;
 sqlstm.sqhstl[3] = (unsigned int  )23;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&dc_doc_type_code;
 sqlstm.sqhstl[4] = (unsigned int  )9;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&d_doc_num;
 sqlstm.sqhstl[5] = (unsigned int  )11;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&nd_facility_id;
 sqlstm.sqhstl[6] = (unsigned int  )5;
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


	if (OERROR) 
	{	
		disp_message (ERR_MESG,"Open Refund Cursor Failed");
		proc_exit();
	}

	return;
}

fetch_refund_cur()
{
		d3_doc_type_code.arr[0] = '\0';
		d3_doc_type_code.len = 0;
		d3_doc_num.arr[0] = '\0';
		d3_doc_num.len = 0;
		d3_patient_id.arr[0] = '\0';
		d3_patient_id.len = 0;
		d3_episode_id.arr[0] = '\0';
		d3_episode_id.len = 0;


	/* EXEC SQL FETCH BL_REFUND_CUR INTO
		:d3_doc_type_code,
		:d3_doc_num,
		:d3_patient_id,
		:d3_episode_id,
		:d3_doc_amt; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1315;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqfoff = (           int )0;
 sqlstm.sqfmod = (unsigned int )2;
 sqlstm.sqhstv[0] = (         void  *)&d3_doc_type_code;
 sqlstm.sqhstl[0] = (unsigned int  )9;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d3_doc_num;
 sqlstm.sqhstl[1] = (unsigned int  )22;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d3_patient_id;
 sqlstm.sqhstl[2] = (unsigned int  )23;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d3_episode_id;
 sqlstm.sqhstl[3] = (unsigned int  )11;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d3_doc_amt;
 sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
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
		disp_message(ERR_MESG,"Fetch Refund Cursor Failed");
		proc_exit();
	}

	if (NODATAFOUND) 
	{ 
		return 0;
	}
		
	d3_doc_type_code.arr[d3_doc_type_code.len] = '\0';
	d3_doc_num.arr[d3_doc_num.len] = '\0';
	d3_patient_id.arr[d3_patient_id.len] = '\0';
	d3_episode_id.arr[d3_episode_id.len] = '\0';

	return 1;
}

open_prepay_cur()
{
	/* EXEC SQL OPEN BL_PREPAY_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0026;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1350;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&dc_episode_id;
 sqlstm.sqhstl[1] = (unsigned int  )11;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_episode_type;
 sqlstm.sqhstl[2] = (unsigned int  )1;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_episode_type;
 sqlstm.sqhstl[3] = (unsigned int  )1;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&dc_doc_type_code;
 sqlstm.sqhstl[4] = (unsigned int  )9;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&d_doc_num;
 sqlstm.sqhstl[5] = (unsigned int  )11;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&dc_patient_id;
 sqlstm.sqhstl[6] = (unsigned int  )23;
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



	if (OERROR) 
	{	disp_message(ERR_MESG,"Open Prepay Cursor Failed");
		proc_exit();
	}

	return;
}

fetch_prepay_cur()
{

	d4_doc_type_code.arr[0] = '\0';
	d4_doc_type_code.len = 0;
	d4_doc_num.arr[0] = '\0';
	d4_doc_num.len = 0;
	d4_patient_id.arr[0] = '\0';
	d4_patient_id.len = 0;
	d4_episode_id.arr[0] = '\0';
	d4_episode_id.len = 0;

	/* EXEC SQL FETCH BL_PREPAY_CUR INTO
		:d4_doc_type_code,
		:d4_doc_num,
		:d4_patient_id,
		:d4_episode_id,
		:d4_doc_amt; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1393;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqfoff = (           int )0;
 sqlstm.sqfmod = (unsigned int )2;
 sqlstm.sqhstv[0] = (         void  *)&d4_doc_type_code;
 sqlstm.sqhstl[0] = (unsigned int  )9;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d4_doc_num;
 sqlstm.sqhstl[1] = (unsigned int  )22;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d4_patient_id;
 sqlstm.sqhstl[2] = (unsigned int  )23;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d4_episode_id;
 sqlstm.sqhstl[3] = (unsigned int  )11;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d4_doc_amt;
 sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
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
	{	disp_message(ERR_MESG,"Fetch Prepay Cursor Failed");
		proc_exit();
	}

	if (NODATAFOUND)
	{
		return 0;
	}

	d4_doc_type_code.arr[d4_doc_type_code.len] = '\0';
	d4_doc_num.arr[d4_doc_num.len] = 0;
	d4_patient_id.arr[d4_patient_id.len] = '\0';
	d4_episode_id.arr[d4_episode_id.len] = '\0';

	return 1;
}


print_report_head()
{	
	int len1 = 0, i = 0;
	v_lno = 0;	

	l_page_no++;
	l_bill_page_no++;

	//disp_message(ERR_MESG,"1");
	//fprintf(fp,"%-75.75s %s %d\n"," ",loc_legend21.arr,l_page_no," ");

	//fprintf(fp,"\n\n");
	
	currency.arr[0] = '\0';
	sub_cur.arr[0]  = '\0';
	currency.len = 0;
	sub_cur.len = 0;
	nd_acc_name.arr[0] = '\0';
	nd_acc_name.len = 0;
	nd_decimal = 0;

	/* EXEC SQL SELECT base_currency,
			base_currency_dec,
			acc_entity_name ,
			accounting_name,
			no_of_decimal 
	INTO :currency,
			:sub_cur,
			:nd_facility_name ,
			:nd_acc_name,
			:nd_decimal
	FROM SY_ACC_ENTITY
	WHERE acc_entity_id = :d_cashfacility_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select base_currency ,base_currency_dec ,acc_entity_name ,ac\
counting_name ,no_of_decimal into :b0,:b1,:b2,:b3,:b4  from SY_ACC_ENTITY wher\
e acc_entity_id=:b5";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1428;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&currency;
 sqlstm.sqhstl[0] = (unsigned int  )18;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&sub_cur;
 sqlstm.sqhstl[1] = (unsigned int  )12;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_facility_name;
 sqlstm.sqhstl[2] = (unsigned int  )33;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_acc_name;
 sqlstm.sqhstl[3] = (unsigned int  )33;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_decimal;
 sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&d_cashfacility_id;
 sqlstm.sqhstl[5] = (unsigned int  )5;
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
		disp_message (ERR_MESG,"SELECT FACILITY STATEMENT FAILED");
		proc_exit();
	}

	currency.arr[currency.len] = '\0';
	sub_cur.arr[sub_cur.len] = '\0';
	nd_facility_name.arr[nd_facility_name.len] = '\0';
	nd_acc_name.arr[nd_acc_name.len] = '\0';

	/* EXEC SQL SELECT acc_entity_name 
	         INTO :nd_facility
		 FROM SY_ACC_ENTITY
		 WHERE acc_entity_id = :nd_facility_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select acc_entity_name into :b0  from SY_ACC_ENTITY where ac\
c_entity_id=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1467;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_facility;
 sqlstm.sqhstl[0] = (unsigned int  )33;
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



	nd_facility.arr[nd_facility.len] = '\0';

	nd_curr_date.arr[0] = '\0';
	nd_curr_date.len = 0;

	/* EXEC SQL SELECT TO_CHAR(SYSDATE,'dd/mm/yyyy') 
		 INTO :nd_curr_date
		 FROM dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select TO_CHAR(SYSDATE,'dd/mm/yyyy') into :b0  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1490;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_curr_date;
 sqlstm.sqhstl[0] = (unsigned int  )22;
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


	nd_curr_date.arr[nd_curr_date.len] = '\0';


	get_gl_holder_name_nric();

	bill_title.arr[0] = '\0';
	bill_title.len = 0;

	if (dc_ind.arr[0] == 'P')
		strcpy(bill_title.arr,loc_legend32.arr);
	else if (dc_ind.arr[0] == 'I')
		strcpy(bill_title.arr,loc_legend33.arr);
	else
		strcpy(bill_title.arr," ");

       bill_title.len = strlen(bill_title.arr); 

	if (l_lsr != 0 && l_dmp == 0)
	{	 

	 if ( l_logo_yniflaser.arr[0] != 'Y')
	    {
		fprintf(fp,"%c(s8H",ESC);	
		fprintf(fp,"%c(s3B",ESC); 	/* To set Bold style 	  */	      
	    }

		fprintf(fp,"%-80.80s\n",loc_legend38.arr);		
		lsr_line_cnt();

		fprintf(fp,"%-80.80s\n",loc_legend37.arr);
		lsr_line_cnt();

		fprintf(fp,"%-80.80s\n",nd_hosp_name.arr);
		lsr_line_cnt();
		
	
	    if ( l_logo_yniflaser.arr[0] != 'Y')
		fprintf(fp,"%c(s12H",ESC);		

		fprintf(fp,"%-80.80s\n",nd_add.arr);
		lsr_line_cnt();

		fprintf(fp,"%-80.80s\n\n",nd_telfax.arr);
		lsr_line_cnt();

	     if ( l_logo_yniflaser.arr[0] != 'Y')
	     {
		fprintf(fp,"%c(s8H",ESC);			
	     }

		fprintf(fp,"%-80.80s\n",loc_legend30.arr);
		lsr_line_cnt();		

		fprintf(fp,"%-80.80s\n",bill_title.arr);
	        lsr_line_cnt();

             if ( l_logo_yniflaser.arr[0] != 'Y')
	      {
		fprintf(fp,"%c(s12H",ESC);	      	      
	      }	      

	    fprintf(fp,"%-s: %-s/%-s ",loc_legend7.arr,dc_doc_type_code.arr,d_doc_num.arr); 
	    	   
	/*
	    len1 = 30 - loc_legend7.len - dc_doc_type_code.len - d_doc_num.len;

	    if (len1 > 0)
	    {
	      for (i=0;i<len1;i++)
	      {
		fprintf(fp,"%-s"," ");		     
	      }
	    } 	      
	*/

	    fprintf(fp,"%-s: %-s ",loc_legend8.arr,d_doc_date.arr);

	    if (nd_reprint_yn == 'Y')
	    {
		if (strcmp(dc_bill_print_flag.arr,"Y") == 0)
		{			
		     if (l_lsr != 0 && l_dmp == 0)
		     {				
			fprintf(fp,"%-s: %-s ",loc_legend29.arr,nd_curr_date.arr);
			fprintf(fp,"\n\n");
			lsr_line_cnt();lsr_line_cnt();
		     }
		     else
		     {			
			fprintf(fp,"%-s: %-s ",loc_legend29.arr,nd_curr_date.arr);
			fprintf(fp,"\n\n");
			lsr_line_cnt();lsr_line_cnt();
		     }		     
		}
		else
		{
			fprintf(fp,"\n\n");
			lsr_line_cnt();lsr_line_cnt();
		}
	    }
	    else
	    {	
			fprintf(fp,"\n\n");
			lsr_line_cnt();lsr_line_cnt();
	    }
	
	    fprintf(fp,"%-45.45s",loc_legend56.arr);
	    fprintf(fp,"%-45.45s\n",loc_legend57.arr);	    
	    lsr_line_cnt();

	    prt_line();
	    fprintf(fp,"\n");    
	    lsr_line_cnt();	    
	
	    

	    dc_short_name1.arr[i] = '\0';
	    dc_short_name1.len = 0;	    

	    dc_short_name2.arr[0] = '\0';
	    dc_short_name2.len = 0;	    

	    dc_short_name3.arr[0] = '\0';
	    dc_short_name3.len = 0;	    

	    r_ctr = 0;   
	    if (dc_short_name.len >0)	
            split_text(dc_short_name.arr,25,dc_short_name1.arr,&r_ctr);	 
	    if (dc_short_name.len >25)
	    split_text(dc_short_name.arr,25,dc_short_name2.arr,&r_ctr);
	    if (dc_short_name.len >50)
	    split_text(dc_short_name.arr,25,dc_short_name3.arr,&r_ctr);	    
	    
	    
	    l_gl_holder_name1.arr[0] = '\0';
	    l_gl_holder_name1.len = 0;

	    l_gl_holder_name2.arr[0] = '\0';
	    l_gl_holder_name2.len = 0;	    


            r_ctr = 0; 
	    if(l_gl_holder_name.len > 0)
	    split_text(l_gl_holder_name.arr,25,l_gl_holder_name1.arr,&r_ctr);	    
	    if(l_gl_holder_name.len > 25)
	    split_text(l_gl_holder_name.arr,25,l_gl_holder_name2.arr,&r_ctr);	    
	    

	    fprintf(fp,"%-17.17s: %-25.25s ",loc_legend10.arr,dc_short_name1.arr);
	    fprintf(fp,"%-18.18s: %-25.25s\n",loc_legend1.arr,l_gl_holder_name1.arr);
	    lsr_line_cnt();
	    

	    if (dc_short_name2.arr[0] != '\0' || l_gl_holder_name2.arr[0] != '\0')
	    {
		fprintf(fp,"%-17.17s  %-25.25s ","",dc_short_name2.arr);
	        fprintf(fp,"%-18.18s  %-25.25s\n","",l_gl_holder_name2.arr);
	        lsr_line_cnt();
	    }

	    if (dc_short_name3.arr[0] != '\0')
	    {
		fprintf(fp,"%-17.17s  %-25.25s ","",dc_short_name3.arr);
	        fprintf(fp,"\n");
	        lsr_line_cnt();
	    }
	    

	    
		
	    fprintf(fp,"%-17.17s: %-25.25s ",loc_legend6.arr,l_nric_number.arr);   
	    fprintf(fp,"%-18.18s: %-25.25s\n",loc_legend58.arr,l_gl_ic.arr);   
	    lsr_line_cnt();	

	    /*

	    l_bill_contact_name_p1.arr[0] = '\0';
	    l_bill_contact_name_p1.len = 0;

	    l_bill_contact_name_p2.arr[0] = '\0';
	    l_bill_contact_name_p2.len = 0;
	    
	    r_ctr = 0; 
	    if(l_bill_contact_name_p.len > 0)
	    split_text(l_bill_contact_name_p.arr,25,l_bill_contact_name_p1.arr,&r_ctr);
	    if(l_bill_contact_name_p.len > 25)
	    split_text(l_bill_contact_name_p.arr,25,l_bill_contact_name_p2.arr,&r_ctr);

	    l_bill_contact_name_c1.arr[0] = '\0';
	    l_bill_contact_name_c1.len = 0;

	    l_bill_contact_name_c2.arr[0] = '\0';
	    l_bill_contact_name_c2.len = 0;

	    r_ctr = 0; 
	    if(l_bill_contact_name_c.len > 0)
	    split_text(l_bill_contact_name_c.arr,25,l_bill_contact_name_c1.arr,&r_ctr);
	    if(l_bill_contact_name_c.len > 25)
	    split_text(l_bill_contact_name_c.arr,25,l_bill_contact_name_c2.arr,&r_ctr);	

	    l_credit_doc_ref_desc1.arr[0] = '\0';
	    l_credit_doc_ref_desc1.len = 0;

	    l_credit_doc_ref_desc2.arr[0] = '\0';
	    l_credit_doc_ref_desc2.len = 0;
	    

	    r_ctr = 0;
	    if(l_credit_doc_ref_desc.len > 0)
	    split_text(l_credit_doc_ref_desc.arr,25,l_credit_doc_ref_desc1.arr,&r_ctr);
	    if(l_credit_doc_ref_desc.len > 25)
	    split_text(l_credit_doc_ref_desc.arr,25,l_credit_doc_ref_desc2.arr,&r_ctr);
	    	     
	    fprintf(fp,"%-17.17s: %-25.25s ",loc_legend59.arr,l_bill_contact_name_p1.arr);	    
	    fprintf(fp,"%-18.18s: %-25.25s\n",loc_legend60.arr,l_credit_doc_ref_desc1.arr);
	    lsr_line_cnt();

	    if (l_bill_contact_name_p2.arr[0] != '\0' 
	          || l_credit_doc_ref_desc2.arr[0] != '\0')
	    {		    
		    fprintf(fp,"%-17.17s  %-25.25s ","",l_bill_contact_name_p2.arr);		    		    
		    fprintf(fp,"%-18.18s  %-25.25s\n",loc_legend61.arr,l_credit_doc_ref_desc2.arr);
		    lsr_line_cnt();

		    loc_legend61.arr[0] = '\0';
		    loc_legend61.len = 0;

		    strcpy(loc_legend61.arr,"");
		    loc_legend61.len = strlen(loc_legend61.arr);
	    }
	    */

	    fprintf(fp,"%-17.17s: %-25.25s ",loc_legend59.arr,l_bill_contact_name_p.arr);	    
	    fprintf(fp,"%-18.18s: %-25.25s\n",loc_legend60.arr,l_credit_doc_ref_desc.arr);
	    lsr_line_cnt();

	    /*
	    l_bill_contact_name_title_p1.arr[0] = '\0';
	    l_bill_contact_name_title_p1.len = 0;

	    l_bill_contact_name_title_p2.arr[0] = '\0';
	    l_bill_contact_name_title_p2.len = 0;	    

	    r_ctr = 0; 
	    if(l_bill_contact_name_title_p.len > 0)
	    split_text(l_bill_contact_name_title_p.arr,25,l_bill_contact_name_title_p1.arr,&r_ctr);
	    if(l_bill_contact_name_title_p.len > 25)
	    split_text(l_bill_contact_name_title_p.arr,25,l_bill_contact_name_title_p2.arr,&r_ctr);

	    l_bill_contact_name_title_c1.arr[0] = '\0';
	    l_bill_contact_name_title_c1.len = 0;

	    l_bill_contact_name_title_c2.arr[0] = '\0';
	    l_bill_contact_name_title_c2.len = 0;	    

	    r_ctr = 0;
	    if(l_bill_contact_name_title_c.len > 0)
	    split_text(l_bill_contact_name_title_c.arr,25,l_bill_contact_name_title_c1.arr,&r_ctr);
	    if(l_bill_contact_name_title_c.len > 25)
	    split_text(l_bill_contact_name_title_c.arr,25,l_bill_contact_name_title_c2.arr,&r_ctr);
    
	    fprintf(fp,"%-17.17s  %-25.25s ","",l_bill_contact_name_title_p1.arr);    	    	    
	    fprintf(fp,"%-18.18s  %-25.25s\n",loc_legend61.arr,l_bill_contact_name_title_c1.arr);   
	    lsr_line_cnt();

	    if (l_bill_contact_name_title_p2.arr[0] != '\0' || 
		 l_bill_contact_name_title_c2.arr[0] != '\0' )
	    {
		
		fprintf(fp,"%-17.17s  %-25.25s ","",l_bill_contact_name_title_p2.arr);		
		fprintf(fp,"%-18.18s  %-25.25s\n","",l_bill_contact_name_title_c2.arr);
		lsr_line_cnt();
	   }

	   */

	    fprintf(fp,"%-17.17s  %-25.25s ","",l_bill_contact_name_title_p.arr);    	    	    
	    fprintf(fp,"%-18.18s  %-25.25s\n",loc_legend61.arr,l_bill_contact_name_title_c.arr);   
	    lsr_line_cnt();

	    /*
	    l_bill_long_desc_p1.arr[0] = '\0';
	    l_bill_long_desc_p1.len = 0;

	    l_bill_long_desc_p2.arr[0] = '\0';
	    l_bill_long_desc_p2.len = 0;

	    r_ctr = 0; 
	    if(l_bill_long_desc_p.len > 0)
	    split_text(l_bill_long_desc_p.arr,25,l_bill_long_desc_p1.arr,&r_ctr);
	    if(l_bill_long_desc_p.len > 25)
	    split_text(l_bill_long_desc_p.arr,25,l_bill_long_desc_p2.arr,&r_ctr);

	    l_bill_long_desc_c1.arr[0] = '\0';
	    l_bill_long_desc_c1.len = 0;

	    l_bill_long_desc_c2.arr[0] = '\0';
	    l_bill_long_desc_c2.len = 0;

	    r_ctr = 0; 
	    if(l_bill_long_desc_c.len > 0)
	    split_text(l_bill_long_desc_c.arr,25,l_bill_long_desc_c1.arr,&r_ctr);
	    if(l_bill_long_desc_c.len > 25)
	    split_text(l_bill_long_desc_c.arr,25,l_bill_long_desc_c2.arr,&r_ctr);
	    
	    fprintf(fp,"%-17.17s  %-25.25s ","",l_bill_long_desc_p1.arr);	        
	    fprintf(fp,"%-18.18s  %-25.25s\n","",l_bill_long_desc_c1.arr);
	    lsr_line_cnt();

	    if (l_bill_long_desc_p2.arr[0] != '\0' || l_bill_long_desc_c2.arr[0] != '\0')
	    {		    
		    fprintf(fp,"%-17.17s  %-25.25s ","",l_bill_long_desc_p2.arr);		    
		    fprintf(fp,"%-18.18s  %-25.25s\n","",l_bill_long_desc_c2.arr);
		    lsr_line_cnt();
	    }
	    */

	    fprintf(fp,"%-17.17s  %-25.25s ","",l_bill_long_desc_p.arr);	        
	    fprintf(fp,"%-18.18s  %-25.25s\n","",l_bill_long_desc_c.arr);
	    lsr_line_cnt();

	    /*

	    l_bill_add1_desc_p1.arr[0] = '\0';
	    l_bill_add1_desc_p1.len = 0;

	    l_bill_add1_desc_p2.arr[0] = '\0';
	    l_bill_add1_desc_p2.len = 0;

	    r_ctr = 0; 
	    if(l_bill_add1_desc_p.len > 0)
	    split_text(l_bill_add1_desc_p.arr,25,l_bill_add1_desc_p1.arr,&r_ctr);
	    if(l_bill_add1_desc_p.len > 25)
	    split_text(l_bill_add1_desc_p.arr,25,l_bill_add1_desc_p2.arr,&r_ctr);

	    l_bill_add1_desc_c1.arr[0] = '\0';
	    l_bill_add1_desc_c1.len = 0;

	    l_bill_add1_desc_c2.arr[0] = '\0';
	    l_bill_add1_desc_c2.len = 0;

	    r_ctr = 0; 
	    if(l_bill_add1_desc_c.len > 0)
	    split_text(l_bill_add1_desc_c.arr,25,l_bill_add1_desc_c1.arr,&r_ctr);
	    if(l_bill_add1_desc_c.len > 25)
	    split_text(l_bill_add1_desc_c.arr,25,l_bill_add1_desc_c2.arr,&r_ctr);
	    
	    fprintf(fp,"%-17.17s  %-25.25s ","",l_bill_add1_desc_p1.arr);	    
	    fprintf(fp,"%-18.18s  %-25.25s\n","",l_bill_add1_desc_c1.arr);
	    lsr_line_cnt();

	    if (l_bill_add1_desc_p2.arr[0] != '\0' ||
			l_bill_add1_desc_c2.arr[0] != '\0')
	    {
		fprintf(fp,"%-17.17s  %-25.25s ","",l_bill_add1_desc_p2.arr);		    
		fprintf(fp,"%-18.18s  %-25.25s\n","",l_bill_add1_desc_c2.arr);
		lsr_line_cnt();
	    }
	    */

	    fprintf(fp,"%-17.17s  %-25.25s ","",l_bill_add1_desc_p.arr);	    
	    fprintf(fp,"%-18.18s  %-25.25s\n","",l_bill_add1_desc_c.arr);
	    lsr_line_cnt();

	    /*
	    l_bill_add2_desc_p1.arr[0] = '\0';
	    l_bill_add2_desc_p1.len = 0;

	    l_bill_add2_desc_p2.arr[0] = '\0';
	    l_bill_add2_desc_p2.len = 0;

	    r_ctr = 0; 
	    if(l_bill_add2_desc_p.len > 0)
	    split_text(l_bill_add2_desc_p.arr,25,l_bill_add2_desc_p1.arr,&r_ctr);
	    if(l_bill_add2_desc_p.len > 25)
	    split_text(l_bill_add2_desc_p.arr,25,l_bill_add2_desc_p2.arr,&r_ctr);


	    l_bill_add2_desc_c1.arr[0] = '\0';
	    l_bill_add2_desc_c1.len = 0;

	    l_bill_add2_desc_c2.arr[0] = '\0';
	    l_bill_add2_desc_c2.len = 0;

	    r_ctr = 0; 
	    if(l_bill_add2_desc_c.len > 0)
	    split_text(l_bill_add2_desc_c.arr,25,l_bill_add2_desc_c1.arr,&r_ctr);
	    if(l_bill_add2_desc_c.len > 25)
	    split_text(l_bill_add2_desc_c.arr,25,l_bill_add2_desc_c2.arr,&r_ctr);
	    
	    fprintf(fp,"%-17.17s  %-25.25s ","",l_bill_add2_desc_p1.arr);	    
	    fprintf(fp,"%-18.18s  %-25.25s\n","",l_bill_add2_desc_c1.arr);
	    lsr_line_cnt();

            if (l_bill_add2_desc_p2.arr[0] != '\0' ||
			l_bill_add2_desc_c2.arr[0] != '\0')
	    {
		    
		fprintf(fp,"%-17.17s  %-25.25s ","",l_bill_add2_desc_p2.arr);		    
		fprintf(fp,"%-18.18s  %-25.25s\n","",l_bill_add2_desc_c2.arr);
		lsr_line_cnt();
	    }

	    */

	    fprintf(fp,"%-17.17s  %-25.25s ","",l_bill_add2_desc_p.arr);	    
	    fprintf(fp,"%-18.18s  %-25.25s\n","",l_bill_add2_desc_c.arr);
	    lsr_line_cnt();
		
	    /*
	    l_bill_add3_desc_p1.arr[0] = '\0';
	    l_bill_add3_desc_p1.len = 0;

	    l_bill_add3_desc_p2.arr[0] = '\0';
	    l_bill_add3_desc_p2.len = 0;

	    r_ctr = 0; 
	    if(l_bill_add3_desc_p.len > 0)
	    split_text(l_bill_add3_desc_p.arr,25,l_bill_add3_desc_p1.arr,&r_ctr);
	    if(l_bill_add3_desc_p.len > 25)
	    split_text(l_bill_add3_desc_p.arr,25,l_bill_add3_desc_p2.arr,&r_ctr);

	    l_bill_add3_desc_c1.arr[0] = '\0';
	    l_bill_add3_desc_c1.len = 0;

	    l_bill_add3_desc_c2.arr[0] = '\0';
	    l_bill_add3_desc_c2.len = 0;

	    r_ctr = 0; 
	    if(l_bill_add3_desc_c.len > 0)
	    split_text(l_bill_add3_desc_c.arr,25,l_bill_add3_desc_c1.arr,&r_ctr);
	    if(l_bill_add3_desc_c.len > 25)
	    split_text(l_bill_add3_desc_c.arr,25,l_bill_add3_desc_c2.arr,&r_ctr);
	    
	    fprintf(fp,"%-17.17s  %-25.25s ","",l_bill_add3_desc_p1.arr);	    
	    fprintf(fp,"%-18.18s  %-25.25s\n","",l_bill_add3_desc_c1.arr);	    
	    lsr_line_cnt();

            if(l_bill_add3_desc_p2.arr[0] != '\0' ||
			l_bill_add3_desc_c2.arr[0] != '\0')
	    {
		    
		    fprintf(fp,"%-17.17s  %-25.25s ","",l_bill_add3_desc_p2.arr);		    
		    fprintf(fp,"%-18.18s  %-25.25s\n","",l_bill_add3_desc_c2.arr);	    
		    lsr_line_cnt();
	    }
	    */

	    fprintf(fp,"%-17.17s  %-25.25s ","",l_bill_add3_desc_p.arr);	    
	    fprintf(fp,"%-18.18s  %-25.25s\n","",l_bill_add3_desc_c.arr);	    
	    lsr_line_cnt();

	    if (l_pat_reln_with_gl_holder.arr[0] != '\0')
	    {

                l_pat_reln_with_gl_holder1.arr[0] = '\0';
		l_pat_reln_with_gl_holder1.len = 0;

		r_ctr = 0; 
		if(l_pat_reln_with_gl_holder.len > 0)
		split_text(l_pat_reln_with_gl_holder.arr,25,l_pat_reln_with_gl_holder1.arr,&r_ctr);
		if(l_pat_reln_with_gl_holder.len > 25)
		split_text(l_pat_reln_with_gl_holder.arr,25,l_pat_reln_with_gl_holder2.arr,&r_ctr);
	    }
		
	    fprintf(fp,"%-17.17s: %-25.25s ",loc_legend2.arr,dc_admn_date.arr);
	    fprintf(fp,"%-18.18s: %-25.25s\n",loc_legend24.arr,l_pat_reln_with_gl_holder1.arr);
	    lsr_line_cnt();

	    fprintf(fp,"%-17.17s: %-25.25s ",loc_legend4.arr,d_dis_date.arr);
	    fprintf(fp,"%-18.18s  %-25.25s\n","",l_pat_reln_with_gl_holder2.arr);
	    lsr_line_cnt();
	
	    fprintf(fp,"%-17.17s: %-25.25s \n",loc_legend5.arr,dc_patient_id.arr);   
	    lsr_line_cnt();

	    fprintf(fp,"%-17.17s: %-8s",loc_legend9.arr,dc_epi_id.arr); 

	    if ( nd_episode_type == 'O' || nd_episode_type == 'E' ) 
		fprintf(fp,"/%-4s\n",dc_visit_id.arr);
	    else
		fprintf(fp,"\n");	

            lsr_line_cnt();
	    
	}

	  if (dc_ind.arr[0] == 'P')
		strcpy(bill_title.arr,loc_legend32.arr);
	  else if (dc_ind.arr[0] == 'I')
		strcpy(bill_title.arr,loc_legend33.arr);
	  else
		strcpy(bill_title.arr," ");
	
	
	if (nd_reprint_yn == 'Y')
	{
		if (strcmp(dc_bill_print_flag.arr,"Y") == 0)
		{    
		     //fprintf(fp,"%c(s4H",ESC);
			
		     if (l_lsr != 0 && l_dmp == 0)
		     {		        
		      /*
			fprintf(fp,"%52.52s        ",bill_title.arr);
			fprintf(fp,"%-17.17s: %-40.40s ",loc_legend29.arr,nd_curr_date.arr);
			fprintf(fp,"\n");
		      */
			
		     }
		     else
		     {
			fprintf(fp,"%-79.79s %s\n"," ",loc_legend19.arr);
			fprintf(fp,"%52.52s        ",bill_title.arr);
			fprintf(fp,"%-17.17s: %-40.40s ",loc_legend29.arr,nd_curr_date.arr);
			fprintf(fp,"\n");
		     }
		     // fprintf(fp,"%c&k2S",ESC);
		}
		else
		{
		     if (l_lsr != 0 && l_dmp == 0)
		     {
			//
		     }
		     else
		     {
			fprintf(fp,"%52.52s        \n\n", bill_title.arr);
		     }
		}
	}
	else
	{
	   if (l_lsr != 0 && l_dmp == 0)
	   {
		//
	   }
	   else
	   {
		fprintf(fp,"%57.57s        \n\n",bill_title.arr);
	   }

	}

	/* LINE 3 */

	/*if(d_bill_nature_code.arr[0] == 'C')
		fprintf(fp,"%-20.20s : %-20.20s ",loc_legend1.arr,dc_credit_doc_ref_desc.arr);
	else
		fprintf(fp,"%-20.20s : %-20.20s ",loc_legend1.arr,dc_long_name.arr);*/

       if (l_lsr != 0 && l_dmp == 0)
       {
		//
       }
       else
       {
		fprintf(fp,"%-17.17s: %-40.40s ",loc_legend1.arr,l_gl_holder_name.arr);
	
		fprintf(fp,"%-17.17s: %-10.10s\n",loc_legend2.arr,dc_admn_date.arr);	

		fprintf(fp,"%-17.17s: %-40.40s ",loc_legend3.arr,l_credit_doc_ref_desc.arr);

		fprintf(fp,"%-17.17s: %-10.10s\n",loc_legend4.arr,d_dis_date.arr);
	
		//fprintf(fp,"%-55.55s",l_bill_contact_name_title.arr);
	
	
		if((strlen(l_bill_contact_name.arr)>0)&&(strlen(l_bill_contact_name_title.arr)>0))
			fprintf(fp,"%-19.19s%-19.19s/%-20.20s"," ",l_bill_contact_name.arr, l_bill_contact_name_title.arr);
		else if((strlen(l_bill_contact_name.arr)>0)||(strlen(l_bill_contact_name_title.arr)==0)) 
			fprintf(fp,"%-19.19s%-40.40s"," ",l_bill_contact_name.arr);
		else if((strlen(l_bill_contact_name.arr)==0)||(strlen(l_bill_contact_name_title.arr)>0)) 
			fprintf(fp,"%-19.19s%-40.40s"," ",l_bill_contact_name_title.arr);
		else if((strlen(l_bill_contact_name.arr)==0)||(strlen(l_bill_contact_name_title.arr)==0))
			fprintf(fp,"%-19.19s%-19.19s %-20.20s"," "," ", " ");
		
		fprintf(fp," %-17.17s: %-20.20s\n",loc_legend5.arr,dc_patient_id.arr);   

		//fprintf(fp,"%-55.55s",l_bill_long_desc.arr);
		fprintf(fp,"%-19.19s%-40.40s"," ",l_bill_long_desc.arr);
		fprintf(fp," %-17.17s: %-20.20s\n",loc_legend6.arr,l_nric_number.arr);   

		//fprintf(fp,"%-55.55s",l_bill_add1_desc.arr);
		fprintf(fp,"%-19.19s%-40.40s"," ",l_bill_add1_desc.arr);
		fprintf(fp," %-17.17s: %-6s/%-8s\n",loc_legend7.arr,dc_doc_type_code.arr,d_doc_num.arr); 

		//fprintf(fp,"%-55.55s",l_bill_add2_desc.arr);
		fprintf(fp,"%-19.19s%-40.40s"," ",l_bill_add2_desc.arr);
		fprintf(fp," %-17.17s: %-12.12s\n",loc_legend8.arr,d_doc_date.arr); 

		//fprintf(fp,"%-55.55s"," ",l_bill_add3_desc.arr);
		fprintf(fp,"%-19.19s%-40.40s"," ",l_bill_add3_desc.arr);
		fprintf(fp," %-17.17s: %-8s",loc_legend9.arr,dc_epi_id.arr); 

		if ( nd_episode_type == 'O' || nd_episode_type == 'E' ) 
			fprintf(fp,"/%-4s\n",dc_visit_id.arr);
		else
			fprintf(fp,"\n");


		/* LINE 4 */
	
		//Before Incoropation Pat Relation legend	
		/*fprintf(fp,"%-17.17s: %-s",loc_legend10.arr,dc_short_name.arr);

		if((l_pat_reln_with_gl_holder.len)>0)
		{
			fprintf(fp," (%-s)",l_pat_reln_with_gl_holder.arr);	
		}*/

		//After Incoropation Pat Relation legend	
		fprintf(fp,"%-17.17s: %-40.40s ",loc_legend10.arr,dc_short_name.arr);
		fprintf(fp,"%-17.17s: %-16.16s",loc_legend24.arr,l_pat_reln_with_gl_holder.arr);

		fprintf(fp,"\n\n");
	}

		//check_report_format();

		/* LINE 5 */
		//if(d_summary_yn=='Y')

	if (l_lsr != 0 && l_dmp == 0)
	{
		prt_line_uc();		
		fprintf(fp,"\n");
		lsr_line_cnt();
		if (l_main_hdr == 0)
		{
			// no need to print Subhdr 
		}
		else
		{
			fprintf(fp,"%6s %-20.20s %5s %-20.20s        %4.4s  %-20.20s\n"," ",loc_legend11.arr," "," ",currency.arr,loc_legend12.arr);		
			lsr_line_cnt();
			prt_line();
			fprintf(fp,"\n");
			lsr_line_cnt();
		}
	}	
	else
	{	
		fprintf(fp,"%6s %-20.20s %5s %-20.20s        %4.4s  %-20.20s\n\n"," ",loc_legend11.arr," "," ",currency.arr,loc_legend12.arr);
	}

	
		//else			
		//fprintf(fp,"%6s %-20.20s %5s %-20.20s %12s%-20.20s\n\n"," ",loc_legend11.arr," ",loc_legend18.arr," ",loc_legend12.arr);
	
	if (l_lsr != 0 && l_dmp == 0)
	{
		l_main_hdr = 1;
	}
	else
	{
		v_lno = 0;
	}
}

prt_line()
{
  int i;
  {
     for (i=0;i<90;i++)
     {
	if ( l_logo_yniflaser.arr[0] == 'Y')	
		fprintf(fp,"%c",175);
	else
		fprintf(fp,"_");		     
     }
  } 	      
}


prt_line_uc()
{
  int i;
  {
     for (i=0;i<90;i++)
     {
	fprintf(fp,"_");		     
     }
  } 	      
}

lsr_line_cnt()
{
	if (l_lsr != 0 && l_dmp == 0)
	{
		v_lno = v_lno  + 1;
	}

}

print_prt_grp_hdr()
{ 
	int fetch_service_line;
	
	//Printing of print group hdr and line commented after discussion with Madam Norijan
	//on 24/01/2004.	
	//fprintf(fp,"%-2s-%-3s",d1_prt_grp_hdr_code.arr,d1_prt_grp_line_code.arr);
	fprintf(fp,"%-2s %-3s"," "," ");
	fprintf(fp," %-35.35s%9s",d1_long_desc1.arr," ");

	check_report_format();

	if (d_summary_yn == 'Y')
	{               
		glcheck = 1;
		
		if (discount_print_yn == 'N')
		{	
			print_formated_amt(d1_gross_amt);
			
			//---------------------------------------------------
			//Added by Harish on 08/11/2003 agianst Customization document
			//Point # 18 - Bill Printing
			/*if (d1_gross_amt==l_bill_line_pr_gp_disc_amt)
			{
				//fprintf(fp," Exempted");
				fprintf(fp," %s",loc_legend23.arr);
			}
			else if((l_bill_line_pr_gp_disc_amt!=0)&&(d1_gross_amt!=l_bill_line_pr_gp_disc_amt))
			{
				//fprintf(fp," Exempted ");
				fprintf(fp," %s ",loc_legend23.arr);
				print_formated_amt_exempt(l_bill_line_pr_gp_disc_amt);
			}*/
			//---------------------------------------------------
			grp_gross_amt   = grp_gross_amt + d1_gross_amt;
		}
		else
		{
			
			if(l_bill_print_opt_for_disc_print==3)
			{
				print_formated_amt(d1_net_amt);
			}
			else
			{
				print_formated_amt(d1_gross_amt);
			
				//---------------------------------------------------
				//Added by Harish on 08/11/2003 agianst Customization document
				//Point # 18 - Bill Printing
															  //If Service amount is 0 then exempted should
															  //Not be printed.	   28/01/2004 Harish
				if ((d1_gross_amt==l_bill_line_pr_gp_disc_amt)&&(d1_gross_amt!=0))
				{
					//fprintf(fp," Exempted");
					fprintf(fp," %s",loc_legend23.arr);
				}
				else if((l_bill_line_pr_gp_disc_amt!=0)&&(d1_gross_amt!=l_bill_line_pr_gp_disc_amt))
				{
					//fprintf(fp," Exempted ");
					fprintf(fp," %s ",loc_legend23.arr);
					print_formated_amt_exempt(l_bill_line_pr_gp_disc_amt);
				}
				
				l_disc_grp_gross_amt = l_disc_grp_gross_amt + d1_gross_amt;
				l_disc_grp_disc_amt  = l_disc_grp_disc_amt  + l_bill_line_pr_gp_disc_amt; 
				//---------------------------------------------------
			}
			grp_gross_amt = grp_gross_amt + d1_net_amt;
		}

		fprintf(fp,"\n");

		v_lno++;
		if (v_lno > max_lines) print_next_page1();

	}
    else
    {	

		glcheck = 2;

        /* EXEC SQL OPEN BL_BILL_SERV_LINE_CUR; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 12;
        sqlstm.arrsiz = 46;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlbuft((void **)0, 
          "select A.PACKAGE_SERVICE_CODE ,DECODE(A.PACKAGE_IND,'S',NVL(b.ser\
v_item_desc,c.long_desc),'P',D.LONG_DESC,NVL(b.serv_item_desc,c.long_desc)) \
,TO_CHAR(B.SERVICE_DATE,'DD/MM/YYYY') ,NVL(B.SERV_QTY,0) ,NVL(B.ORG_GROSS_CH\
ARGE_AMT,0) ,NVL(B.ORG_NET_CHARGE_AMT,0) ,NVL(B.ORG_DISC_AMT,0) ,B.BASE_RATE\
 ,B.BASE_QTY ,((B.BASE_RATE||'/')||B.BASE_QTY)  from BL_BILL_SERVICE_LINE A \
,BL_PATIENT_CHARGES_FOLIO B ,BL_BLNG_SERV C ,BL_PACKAGE_HDR D where ((((((((\
(((((((A.OPERATING_FACILITY_ID=B.OPERATING_FACILITY_ID and A.OPERATING_FACIL\
ITY_ID=:b0) and A.DOC_TYPE_CODE=:b1) and ((A.DOC_NUM=:b2 and (:b1||:b2)=:b5)\
 or (A.DOC_NUM in (select doc_num  from bl_bill_hdr where ((doc_type_code=:b\
1 and mpi_id=:b5) and operating_facility_id=:b0)) and (:b1||:b2)<>:b5))) and\
 A.PRT_GRP_HDR_CODE=:b12) and a.PRT_GRP_LINE_CODE=:b13) and A.DOC_TYPE_CODE=\
B.BILL_DOC_TYPE_CODE) and A.DOC_NUM=B.BILL_DOC_NUM) and A.PRT_GRP_HDR_CODE=B\
.PRT_GRP_HDR_CODE) and A.PRT_GRP_LINE_CODE=B.PRT_GRP_LINE_CODE) and A.PACKAG\
E_SERVICE_CODE=B.BLNG_SERV_CODE) and A.PACKAGE_");
        sqlstm.stmt = sq0027;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )1509;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)4352;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqcmod = (unsigned int )0;
        sqlstm.sqhstv[0] = (         void  *)&nd_facility_id;
        sqlstm.sqhstl[0] = (unsigned int  )5;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&dc_doc_type_code;
        sqlstm.sqhstl[1] = (unsigned int  )9;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&d_doc_num;
        sqlstm.sqhstl[2] = (unsigned int  )11;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&dc_doc_type_code;
        sqlstm.sqhstl[3] = (unsigned int  )9;
        sqlstm.sqhsts[3] = (         int  )0;
        sqlstm.sqindv[3] = (         void  *)0;
        sqlstm.sqinds[3] = (         int  )0;
        sqlstm.sqharm[3] = (unsigned int  )0;
        sqlstm.sqadto[3] = (unsigned short )0;
        sqlstm.sqtdso[3] = (unsigned short )0;
        sqlstm.sqhstv[4] = (         void  *)&d_doc_num;
        sqlstm.sqhstl[4] = (unsigned int  )11;
        sqlstm.sqhsts[4] = (         int  )0;
        sqlstm.sqindv[4] = (         void  *)0;
        sqlstm.sqinds[4] = (         int  )0;
        sqlstm.sqharm[4] = (unsigned int  )0;
        sqlstm.sqadto[4] = (unsigned short )0;
        sqlstm.sqtdso[4] = (unsigned short )0;
        sqlstm.sqhstv[5] = (         void  *)&dc_mpi_id;
        sqlstm.sqhstl[5] = (unsigned int  )102;
        sqlstm.sqhsts[5] = (         int  )0;
        sqlstm.sqindv[5] = (         void  *)0;
        sqlstm.sqinds[5] = (         int  )0;
        sqlstm.sqharm[5] = (unsigned int  )0;
        sqlstm.sqadto[5] = (unsigned short )0;
        sqlstm.sqtdso[5] = (unsigned short )0;
        sqlstm.sqhstv[6] = (         void  *)&dc_doc_type_code;
        sqlstm.sqhstl[6] = (unsigned int  )9;
        sqlstm.sqhsts[6] = (         int  )0;
        sqlstm.sqindv[6] = (         void  *)0;
        sqlstm.sqinds[6] = (         int  )0;
        sqlstm.sqharm[6] = (unsigned int  )0;
        sqlstm.sqadto[6] = (unsigned short )0;
        sqlstm.sqtdso[6] = (unsigned short )0;
        sqlstm.sqhstv[7] = (         void  *)&dc_mpi_id;
        sqlstm.sqhstl[7] = (unsigned int  )102;
        sqlstm.sqhsts[7] = (         int  )0;
        sqlstm.sqindv[7] = (         void  *)0;
        sqlstm.sqinds[7] = (         int  )0;
        sqlstm.sqharm[7] = (unsigned int  )0;
        sqlstm.sqadto[7] = (unsigned short )0;
        sqlstm.sqtdso[7] = (unsigned short )0;
        sqlstm.sqhstv[8] = (         void  *)&nd_facility_id;
        sqlstm.sqhstl[8] = (unsigned int  )5;
        sqlstm.sqhsts[8] = (         int  )0;
        sqlstm.sqindv[8] = (         void  *)0;
        sqlstm.sqinds[8] = (         int  )0;
        sqlstm.sqharm[8] = (unsigned int  )0;
        sqlstm.sqadto[8] = (unsigned short )0;
        sqlstm.sqtdso[8] = (unsigned short )0;
        sqlstm.sqhstv[9] = (         void  *)&dc_doc_type_code;
        sqlstm.sqhstl[9] = (unsigned int  )9;
        sqlstm.sqhsts[9] = (         int  )0;
        sqlstm.sqindv[9] = (         void  *)0;
        sqlstm.sqinds[9] = (         int  )0;
        sqlstm.sqharm[9] = (unsigned int  )0;
        sqlstm.sqadto[9] = (unsigned short )0;
        sqlstm.sqtdso[9] = (unsigned short )0;
        sqlstm.sqhstv[10] = (         void  *)&d_doc_num;
        sqlstm.sqhstl[10] = (unsigned int  )11;
        sqlstm.sqhsts[10] = (         int  )0;
        sqlstm.sqindv[10] = (         void  *)0;
        sqlstm.sqinds[10] = (         int  )0;
        sqlstm.sqharm[10] = (unsigned int  )0;
        sqlstm.sqadto[10] = (unsigned short )0;
        sqlstm.sqtdso[10] = (unsigned short )0;
        sqlstm.sqhstv[11] = (         void  *)&dc_mpi_id;
        sqlstm.sqhstl[11] = (unsigned int  )102;
        sqlstm.sqhsts[11] = (         int  )0;
        sqlstm.sqindv[11] = (         void  *)0;
        sqlstm.sqinds[11] = (         int  )0;
        sqlstm.sqharm[11] = (unsigned int  )0;
        sqlstm.sqadto[11] = (unsigned short )0;
        sqlstm.sqtdso[11] = (unsigned short )0;
        sqlstm.sqhstv[12] = (         void  *)&d1_prt_grp_hdr_code;
        sqlstm.sqhstl[12] = (unsigned int  )5;
        sqlstm.sqhsts[12] = (         int  )0;
        sqlstm.sqindv[12] = (         void  *)0;
        sqlstm.sqinds[12] = (         int  )0;
        sqlstm.sqharm[12] = (unsigned int  )0;
        sqlstm.sqadto[12] = (unsigned short )0;
        sqlstm.sqtdso[12] = (unsigned short )0;
        sqlstm.sqhstv[13] = (         void  *)&d1_prt_grp_line_code;
        sqlstm.sqhstl[13] = (unsigned int  )5;
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
        sqlstm.sqhstv[15] = (         void  *)&dc_doc_type_code;
        sqlstm.sqhstl[15] = (unsigned int  )9;
        sqlstm.sqhsts[15] = (         int  )0;
        sqlstm.sqindv[15] = (         void  *)0;
        sqlstm.sqinds[15] = (         int  )0;
        sqlstm.sqharm[15] = (unsigned int  )0;
        sqlstm.sqadto[15] = (unsigned short )0;
        sqlstm.sqtdso[15] = (unsigned short )0;
        sqlstm.sqhstv[16] = (         void  *)&d_doc_num;
        sqlstm.sqhstl[16] = (unsigned int  )11;
        sqlstm.sqhsts[16] = (         int  )0;
        sqlstm.sqindv[16] = (         void  *)0;
        sqlstm.sqinds[16] = (         int  )0;
        sqlstm.sqharm[16] = (unsigned int  )0;
        sqlstm.sqadto[16] = (unsigned short )0;
        sqlstm.sqtdso[16] = (unsigned short )0;
        sqlstm.sqhstv[17] = (         void  *)&nd_facility_id;
        sqlstm.sqhstl[17] = (unsigned int  )5;
        sqlstm.sqhsts[17] = (         int  )0;
        sqlstm.sqindv[17] = (         void  *)0;
        sqlstm.sqinds[17] = (         int  )0;
        sqlstm.sqharm[17] = (unsigned int  )0;
        sqlstm.sqadto[17] = (unsigned short )0;
        sqlstm.sqtdso[17] = (unsigned short )0;
        sqlstm.sqhstv[18] = (         void  *)&dc_doc_type_code;
        sqlstm.sqhstl[18] = (unsigned int  )9;
        sqlstm.sqhsts[18] = (         int  )0;
        sqlstm.sqindv[18] = (         void  *)0;
        sqlstm.sqinds[18] = (         int  )0;
        sqlstm.sqharm[18] = (unsigned int  )0;
        sqlstm.sqadto[18] = (unsigned short )0;
        sqlstm.sqtdso[18] = (unsigned short )0;
        sqlstm.sqhstv[19] = (         void  *)&d_doc_num;
        sqlstm.sqhstl[19] = (unsigned int  )11;
        sqlstm.sqhsts[19] = (         int  )0;
        sqlstm.sqindv[19] = (         void  *)0;
        sqlstm.sqinds[19] = (         int  )0;
        sqlstm.sqharm[19] = (unsigned int  )0;
        sqlstm.sqadto[19] = (unsigned short )0;
        sqlstm.sqtdso[19] = (unsigned short )0;
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
			disp_message(ERR_MESG,"Open failed on Cursor declare_service_line_cur");
			proc_exit();
		}

		d_service_amt_tot = 0;
		fetch_service_line = fetch_service_line_cur();

		fprintf(fp,"\n");
		v_lno++;
		if (v_lno > max_lines) print_next_page1();

        while(fetch_service_line)
		{ 
			//As per request from MOH, Malaysia (Madam Norizan) the service code is 
			//not printed - Changed by Harish.
			//fprintf(fp," %-10.10s/%-20.20s ",d_service_code.arr,d_service_desc.arr);			
			
			fprintf(fp,"%-32.32s ",d_service_desc.arr);
			//fprintf(fp," %7d/%-2d ",d_base_rate,d_base_qty); 
			fprintf(fp," %9s ",nd_base_rate_qty.arr); 			
			fprintf(fp," %4d "  ,d_service_qty);

			if (discount_print_yn == 'N')
				print_formated_amt(d_service_amt);		
			else
			{
	
				if(l_bill_print_opt_for_disc_print==3)
				{	
					print_formated_amt(d_service_net);
				}
				else
				{
					//---------------------------------------------------
					//Added by Harish on 08/11/2003 agianst Customization document
					//Point # 18 - Bill Printing
					print_formated_amt(d_service_amt);
													  //If Service amount is 0 then exempted should
													  //Not be printed.	  28/01/2004 Harish
					if ((d_service_amt==d_service_disc)&&(d_service_amt!=0))
					{
						//fprintf(fp," Exempted");
						fprintf(fp," %s",loc_legend23.arr);
					}
					else if((d_service_disc!=0)&&(d_service_amt!=d_service_disc))
					{
						//fprintf(fp," Exempted ");
						fprintf(fp," %s ",loc_legend23.arr);
						print_formated_amt_exempt(d_service_disc);
					}
					//---------------------------------------------------
					l_disc_grp_gross_amt = l_disc_grp_gross_amt + d_service_amt;
					l_disc_grp_disc_amt  = l_disc_grp_disc_amt  + d_service_disc; 
				}
			}
						
			//if (d_service_amt == d_service_disc)
			//	fprintf(fp,"Exempted");		

			fprintf(fp,"\n");
			
			if (discount_print_yn == 'N')	
				d_service_amt_tot = d_service_amt_tot + d_service_amt;	
			else
				d_service_amt_tot = d_service_amt_tot + d_service_net;	

        	v_lno++;
	        if (v_lno > max_lines) print_next_page1();

			fetch_service_line = fetch_service_line_cur();
		}

        /* EXEC SQL CLOSE BL_BILL_SERV_LINE_CUR; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 12;
        sqlstm.arrsiz = 46;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )1604;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)4352;
        sqlstm.occurs = (unsigned int  )0;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

 

		grp_gross_amt = grp_gross_amt + d_service_amt_tot;

		if (ccount != gcount)
		{
			fprintf(fp,"\n");	
			v_lno++;
			if (v_lno > max_lines) print_next_page1();
		}
	}
}

print_ins_bill()
{ 
	fetch_cust_cur();

	mcount = 0;

	/* EXEC SQL SELECT NVL(COUNT(*),0) INTO :mcount FROM BL_BILL_HDR
	WHERE  nvl(mpi_id,DOC_TYPE_CODE||DOC_NUM) = :dc_mpi_id
	AND    patient_id = :dc_patient_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select NVL(count(*) ,0) into :b0  from BL_BILL_HDR where (nv\
l(mpi_id,(DOC_TYPE_CODE||DOC_NUM))=:b1 and patient_id=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1619;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&mcount;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&dc_mpi_id;
 sqlstm.sqhstl[1] = (unsigned int  )102;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&dc_patient_id;
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



	if ( mcount > 1 ) 
		less_billed_amt = d2_bill_tot_amt;
	else
		less_billed_amt = 0;
}

print_less_total()
{ int i;

	tot_amt = 0;
	vst_amt = 0;

	/* EXEC SQL SELECT sum(DECODE(:discount_print_yn,'Y',nvl(bill_amt,0),nvl(gross_amt,0))) 
		 INTO :vst_amt
		 FROM BL_BILL_HDR 
		 WHERE DOC_TYPE_CODE  = :dc_doc_type_code
		 AND DOC_NUM        != :d_doc_num
		 AND TO_CHAR(DOC_DATE,'dd/mm/yyyy') = :d_doc_date
		 AND NVL(MPI_ID,DOC_TYPE_CODE||DOC_NUM) = :dc_mpi_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select sum(DECODE(:b0,'Y',nvl(bill_amt,0),nvl(gross_amt,0)))\
 into :b1  from BL_BILL_HDR where (((DOC_TYPE_CODE=:b2 and DOC_NUM<>:b3) and T\
O_CHAR(DOC_DATE,'dd/mm/yyyy')=:b4) and NVL(MPI_ID,(DOC_TYPE_CODE||DOC_NUM))=:b\
5)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1646;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&discount_print_yn;
 sqlstm.sqhstl[0] = (unsigned int  )1;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&vst_amt;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&dc_doc_type_code;
 sqlstm.sqhstl[2] = (unsigned int  )9;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_doc_num;
 sqlstm.sqhstl[3] = (unsigned int  )11;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_doc_date;
 sqlstm.sqhstl[4] = (unsigned int  )13;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&dc_mpi_id;
 sqlstm.sqhstl[5] = (unsigned int  )102;
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



	tot_amt = grp_gross_amt - vst_amt;

	if (dc_episode_id.arr[0] == '\0' && nd_episode_type != 'R' )
	{
		/* EXEC SQL EXECUTE
		BEGIN
		blcommon.proc_get_rounded_Amt
			(
			nvl(:tot_amt,0),
			blcore.get_decimal_place(:nd_facility_id) , 
			:tot_amt ,
			:l_rounding_amt 
			);
		END;
		END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . proc_get_rounded_Amt ( nvl ( :tot_amt , 0 \
) , blcore . get_decimal_place ( :nd_facility_id ) , :tot_amt , :l_rounding_am\
t ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1685;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&tot_amt;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
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
  sqlstm.sqhstv[2] = (         void  *)&l_rounding_amt;
  sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
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
}

print_less_disc()
{ 
	less_disc = 0;

	if (discount_print_yn == 'N')
	{
		if ((strcmp(d_bill_trx_type_code.arr,"O") == 0) || (strcmp(d_bill_trx_type_code.arr,"R") == 0))
  			less_disc = d_serv_disc_amt + d_man_disc_amt + d_overall_disc_amt;

		else
 			less_disc = d_serv_disc_amt + d_tot_bus_man_disc_amt;
	}
	else
	{	
		less_disc = 0;
	}
}


print_ins_ded()
{
	p_vst_ded = 0;

 	/* EXEC SQL SELECT nvl(vst_ded_amt,0) INTO :p_vst_ded FROM BL_BILL_HDR
    		WHERE  DOC_TYPE_CODE = :dc_doc_type_code
    		AND    DOC_NUM       = :d_doc_num; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select nvl(vst_ded_amt,0) into :b0  from BL_BILL_HDR where \
(DOC_TYPE_CODE=:b1 and DOC_NUM=:b2)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1712;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&p_vst_ded;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&dc_doc_type_code;
  sqlstm.sqhstl[1] = (unsigned int  )9;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_doc_num;
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

 
}

print_deposit()
{
	fprintf(fp,"       %-8s %-25s ",d3_doc_type_code.arr,d3_doc_num.arr);
}


print_prepay()
{
	fprintf(fp,"     %-8s %-25s ",d4_doc_type_code.arr,d4_doc_num.arr);
}

print_net_total()
{ 
	net_total = 0;

if (dc_episode_id.arr[0] != '\0' || nd_episode_type == 'R')
{
	net_total = grp_gross_amt - less_disc - d_deposit_adj_amt - d_prepay_adj_amt 
					+ p_vst_ded - vst_amt - nd_tot_spl_agency_amt;

	/*EXEC SQL EXECUTE
	BEGIN
	blcommon.proc_get_rounded_Amt
			(
			nvl(:net_total,0),
			blcore.get_decimal_place(:nd_facility_id), 
			:net_total ,
			:l_rounding_amt 
			);
	END;
	END-EXEC;


	
	if (strcmp(nd_calling_pgm_id.arr,"BLTBILVT") != 0 ||
	strcmp(nd_calling_pgm_id.arr,"BLROPDS2") != 0)
	{

	if ((!equal(d_deposit_adj_amt,(double) 0)) || (!equal(d_prepay_adj_amt,(double) 0)) 
		|| (!equal(p_vst_ded,(double) 0)) 
		||(!equal(nd_tot_spl_agency_amt,(double) 0)) 
		|| (!equal(less_disc,(double) 0))||net_total != 0)
	
//  if (net_total != 0 ) 
	{		
			replicate(vl,1);
			replicate(' ',60);
			fprintf(fp,"TOTAL");
			replicate(vl,1);
			replicate(' ',5);
			print_formated_amt(net_total);
			replicate(' ',1);
			replicate(vl,1);
			fprintf(fp,"\n");
			v_lno++;
				//if (v_lno > max_lines) print_next_page1();

			if ((strcmp(d_bill_nature_code.arr,"C") == 0) && (dc_credit_doc_ref_desc.arr[0] == '\0') && (sett_print_yn == 'N'))
			{	print_tot_box(); }
			else
			{	replicate(vl,1);
				replicate(' ',65);
				replicate(blc,1);
				//replicate(vlti,1);
				replicate(hl,22);
				replicate(vrti,1);
				fprintf(fp,"\n");
				v_lno++;
				//if (v_lno > max_lines) print_next_page1();
			}
			}
		 else
			{	if ((strcmp(d_bill_nature_code.arr,"C") == 0) && (sett_print_yn == 'N'))
					{	one_line_gap(); 
						
						one_line_gap(); 
						
					}
				else
					{	print_border();
						print_border();
					}
			}
		}
		else
		{
					replicate(vl,1);
					replicate(' ',60);
					fprintf(fp,"TOTAL");
					replicate(vl,1);
					replicate(' ',5);
					print_formated_amt(net_total);
					replicate(' ',1);
					replicate(vl,1);
					fprintf(fp,"\n");
					v_lno++;
					print_tot_box();
		}*/

}
}

pat_gen_det()
{   
 
	/* EXEC SQL SELECT long_desc INTO :nd_blng_grp
		 FROM bl_blng_grp WHERE blng_grp_id = :dc_blng_grp_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select long_desc into :b0  from bl_blng_grp where blng_grp_i\
d=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1739;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_blng_grp;
 sqlstm.sqhstl[0] = (unsigned int  )33;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&dc_blng_grp_id;
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



	nd_blng_grp.arr[nd_blng_grp.len] = '\0';

	/* EXEC SQL SELECT nationality  INTO :nd_nationality FROM mp_country_HIS_VW 
	 	 WHERE country_code IN (
				SELECT nationality_code 
				FROM mp_patient_mast  
				WHERE patient_id = :dc_patient_id); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select nationality into :b0  from mp_country_HIS_VW where co\
untry_code in (select nationality_code  from mp_patient_mast where patient_id=\
:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1762;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_nationality;
 sqlstm.sqhstl[0] = (unsigned int  )18;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&dc_patient_id;
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


	
	nd_nationality.arr[nd_nationality.len] = '\0';
	
	/* EXEC SQL SELECT short_desc INTO :nd_cash_counter FROM bl_cash_counter
	 	 WHERE cash_counter_code = :nn_cc_code
		 AND operating_facility_id = :nd_facility_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select short_desc into :b0  from bl_cash_counter where (cash\
_counter_code=:b1 and operating_facility_id=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1785;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_cash_counter;
 sqlstm.sqhstl[0] = (unsigned int  )18;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nn_cc_code;
 sqlstm.sqhstl[1] = (unsigned int  )5;
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



	nd_cash_counter.arr[nd_cash_counter.len] = '\0';

   
   /* EXEC SQL select user into :nd_user from dual; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 46;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select user into :b0  from dual ";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1812;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_user;
   sqlstm.sqhstl[0] = (unsigned int  )33;
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


   nd_user.arr[nd_user.len] = '\0';
	
}


print_balance_due1()
{
	int i,r,j,l;
	char first_line_yn;
    int no_of_lines = 0;
    double prt_cum_amt  = 0;
    char out_str[10][133];

	balance_due = 0;
	out_adj_amt = 0;

    for(i=0; i<10; i++) out_str[i][0] = '\0';

	last_recpt_doc_type_code.arr[0]	= '\0';
	last_recpt_doc_num.arr[0]		= '\0';
	slmt_short_desc.arr[0]			= '\0';
	slmt_doc_ref_desc.arr[0]		= '\0';
	slmt_doc_ref_date.arr[0]		= '\0';
	slmt_remarks.arr[0]				= '\0';

	last_recpt_doc_type_code.len	= 0;
	last_recpt_doc_num.len			= 0;
	slmt_short_desc.len				= 0;
	slmt_doc_ref_desc.len			= 0;
	slmt_doc_ref_date.len			= 0;
	slmt_remarks.len				= 0;
	if ((dc_episode_id.arr[0] != '\0' || nd_episode_type == 'R') && (sett_print_yn == 'N'))
	{
		/*if ((strcmp(d_bill_nature_code.arr,"C") == 0) || (strcmp(nd_calling_pgm_id.arr,"BLTBILVT") == 0 ||
			strcmp(nd_calling_pgm_id.arr,"BLROPDS2") == 0 ))
		{	
			if (strcmp(nd_calling_pgm_id.arr,"BLTBILVT") == 0 || strcmp(nd_calling_pgm_id.arr,"BLROPDS2") == 0)
			{
				EXEC SQL SELECT LAST_RECPT_DOC_TYPE_CODE, 
								LAST_RECPT_DOC_NUM,
								(NVL(BILL_PAID_AMT,0) - NVL(TOT_REFUND_AMT,0))
				           INTO	:last_recpt_doc_type_code, 
								:last_recpt_doc_num,
								:bill_paid_amt
						   FROM	BL_BILL_HDR
						  WHERE	DOC_TYPE_CODE = :dc_doc_type_code
							AND	DOC_NUM       = :d_doc_num
							AND	PATIENT_ID    = :dc_patient_id
							AND	((EPISODE_ID			= :dc_episode_id 
								  AND VISIT_ID			= :dc_visit_id
							      AND :nd_episode_type  in ('E','O') ) 
								  OR 
								  (:nd_episode_type = 'R'));


						last_recpt_doc_type_code.arr[last_recpt_doc_type_code.len]	= '\0';
						last_recpt_doc_num.arr[last_recpt_doc_num.len]				= '\0';
			}

			if (strcmp(d_bill_nature_code.arr,"C") == 0) 
			{ */



				/* EXEC SQL SELECT	nvl(sum(bill_tot_outst_amt),0) 
						   INTO	:bill_outst_amt
  						   FROM BL_BILL_HDR
  						  WHERE PATIENT_ID = :dc_patient_id 
						    AND (DOC_TYPE_CODE||' '||DOC_NUM)
						    != :dc_doc_type_code||' '||:d_doc_num
				            AND BILL_STATUS IS NULL
					    and ((nvl(bill_tot_outst_amt,0)>0 AND NVL(:l_include_refund,'N') = 'N')
				           OR
				           (nvl(bill_tot_outst_amt,0) != 0 AND NVL(:l_include_refund,'N') = 'Y')); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 46;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select nvl(sum(bill_tot_outst_amt),0) into :b0  from BL_B\
ILL_HDR where (((PATIENT_ID=:b1 and ((DOC_TYPE_CODE||' ')||DOC_NUM)<>((:b2||' \
')||:b3)) and BILL_STATUS is null ) and ((nvl(bill_tot_outst_amt,0)>0 and NVL(\
:b4,'N')='N') or (nvl(bill_tot_outst_amt,0)<>0 and NVL(:b4,'N')='Y')))";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1831;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&bill_outst_amt;
    sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&dc_patient_id;
    sqlstm.sqhstl[1] = (unsigned int  )23;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&dc_doc_type_code;
    sqlstm.sqhstl[2] = (unsigned int  )9;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_doc_num;
    sqlstm.sqhstl[3] = (unsigned int  )11;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&l_include_refund;
    sqlstm.sqhstl[4] = (unsigned int  )1;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&l_include_refund;
    sqlstm.sqhstl[5] = (unsigned int  )1;
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


					   //AND	BILL_NATURE_CODE = 'C';
  
				/* EXEC SQL SELECT	nvl(tot_def_pat_outst_amt,0) 
						   INTO	:dcp_outst_amt
          				   FROM	BL_PATIENT_FIN_DTLS
          				  WHERE	PATIENT_ID = :dc_patient_id
					  AND nvl(tot_def_pat_outst_amt,0) > 0; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 46;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select nvl(tot_def_pat_outst_amt,0) into :b0  from BL_PAT\
IENT_FIN_DTLS where (PATIENT_ID=:b1 and nvl(tot_def_pat_outst_amt,0)>0)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1870;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&dcp_outst_amt;
    sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&dc_patient_id;
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



				balance_due = bill_outst_amt + dcp_outst_amt;
				//out_adj_amt = balance_due - net_total;
 				out_adj_amt = balance_due;
			/*}
			else
			{ 
				balance_due = net_total - bill_paid_amt;
				out_adj_amt = 0;
			}

			if ((strcmp(d_bill_nature_code.arr,"C") == 0) && (strcmp(nd_calling_pgm_id.arr,"BLTBILVT") == 0 ||
				strcmp(nd_calling_pgm_id.arr,"BLROPDS2") == 0 ) && (balance_due != 0))
			{
				out_adj_amt = balance_due + bill_paid_amt - net_total;
			}

			if ((strcmp(nd_calling_pgm_id.arr,"BLTBILVT") == 0 || strcmp(nd_calling_pgm_id.arr,"BLROPDS2") == 0) && ((strcmp(d_bill_nature_code.arr,"C") != 0) || (balance_due == 0)))
			{
				out_adj_amt = 0;
			}   */

			if (l_lsr != 0 && l_dmp == 0)
			{
				fprintf(fp,"%-50.50s ",loc_legend17.arr," ");
			}
			else  
			{  			
				fprintf(fp,"%20.20s %30s",loc_legend17.arr," ");
			}


			//print_formated_amt_total(balance_due);
			print_formated_amt_total(out_adj_amt);


			if (l_lsr != 0 && l_dmp == 0 )
			{	
				fprintf(fp,"\n");

				if (l_lsr != 0 && l_dmp == 0 )
				{		
					l_main_hdr = 0;
					v_lno = v_lno+1;	
				        if (v_lno > max_lines) print_next_page1();
				}

				//prt_line_uc();
				fprintf(fp,"\n");    
				lsr_line_cnt();

				fprintf(fp,"%-50.50s ",loc_legend62.arr,"");
				print_formated_amt_total(out_adj_amt+amt_payable - deposit_tot + l_bill_rounding_amt
					- l_bill_tot_adjust_amt - l_bill_tot_exempt_amt - l_bill_tot_write_off_amt);
			
				fprintf(fp,"\n");
			
				if (l_lsr != 0 && l_dmp == 0 )
				{		
				l_main_hdr = 0;
				v_lno = v_lno+1;	
				if (v_lno > max_lines) print_next_page1();
				}

				prt_line_uc();
						
			}

			if (l_lsr != 0 && l_dmp == 0 )
			{
			   /*-----------------------22/09/2005------------------*/

	                       if (loc_legend39.arr[0] != '\0' || loc_legend40.arr[0] != '\0'||
				   loc_legend41.arr[0] != '\0' || loc_legend42.arr[0] != '\0'||
				   loc_legend43.arr[0] != '\0' || loc_legend44.arr[0] != '\0'||
				   loc_legend45.arr[0] != '\0' || loc_legend46.arr[0] != '\0'||
				   loc_legend47.arr[0] != '\0' || loc_legend48.arr[0] != '\0'||
				   loc_legend49.arr[0] != '\0' || loc_legend50.arr[0] != '\0'||
				   loc_legend51.arr[0] != '\0' || loc_legend52.arr[0] != '\0'||
				   loc_legend53.arr[0] != '\0' || loc_legend54.arr[0] != '\0') 
			       {
				   remarks_cnt_chk();

				   while(v_lno <= (max_lines-l_lno))
				   {
					fprintf(fp,"\n");
					v_lno++;
				   }

				   // This  is a check for accommodating remarks with in a page.

				    l_main_hdr = 0;	
				    fprintf(fp,"\n"); 
				    v_lno++;
				    if (v_lno > max_lines) print_next_page1();
				    

			
				if (l_logo_yniflaser.arr[0] != 'Y')			    
				{
				      fprintf(fp,"%c9",ESC);          /* To Release the margin */				  
				      fprintf(fp,"%c(s8H",ESC); 	/* To set the font size	  */
				      fprintf(fp,"%c(s3B",ESC); 	/* To set Bold style 	  */
				      
				      l_main_hdr = 0;
				      fprintf(fp,"\n");					      
				      v_lno++;
				      if (v_lno > max_lines) print_next_page1();
				}

					if (loc_legend39.arr[0]	!= '\0')
					{
					fprintf(fp,"%-s\n\n",loc_legend39.arr);
					l_main_hdr = 0;
					 v_lno=v_lno+2;
					 if (v_lno > max_lines) print_next_page1();
					}

				if (l_logo_yniflaser.arr[0] != 'Y')			    
				{
				      fprintf(fp,"%c(s12.5H",ESC); 	/* To set the font size	  */
				}
				    				      
				      if (loc_legend40.arr[0] != '\0')	
				      {
				      fprintf(fp,"%-s\n",loc_legend40.arr); 
				      l_main_hdr = 0;
				      v_lno++;
				      if (v_lno > max_lines) print_next_page1();
				      }

				      if (loc_legend41.arr[0] != '\0') 
				      {
				      fprintf(fp,"%-s\n",loc_legend41.arr);
				      l_main_hdr = 0;
				      v_lno++;
				      if (v_lno > max_lines) print_next_page1();
				      }

				      if (loc_legend42.arr[0] != '\0') 
				      {
				      l_main_hdr = 0;
				      fprintf(fp,"%-s\n",loc_legend42.arr);
				      v_lno++;
				      if (v_lno > max_lines) print_next_page1();
				      }

				      if (loc_legend43.arr[0] != '\0') 
				      {
				      l_main_hdr = 0;
				      fprintf(fp,"%-s\n",loc_legend43.arr);
				      v_lno++;
				      if (v_lno > max_lines) print_next_page1();
				      }

				      if (loc_legend44.arr[0] != '\0') 
				      {
				      l_main_hdr = 0;
				      fprintf(fp,"%-s\n",loc_legend44.arr);
				      v_lno++;
				      if (v_lno > max_lines) print_next_page1();
				      }

				      if (loc_legend45.arr[0] != '\0') 
				      {
				      l_main_hdr = 0;
				      fprintf(fp,"%-s\n",loc_legend45.arr);
				      v_lno++;
				      if (v_lno > max_lines) print_next_page1();
				      }

				      if (loc_legend46.arr[0] != '\0') 
				      {
				      l_main_hdr = 0;
				       fprintf(fp,"%-s\n",loc_legend46.arr);
				       v_lno++;
				       if (v_lno > max_lines) print_next_page1();
				       }


				      if (loc_legend47.arr[0] != '\0') 
				      {
					l_main_hdr = 0;
				      fprintf(fp,"%-s\n",loc_legend47.arr);
				      v_lno++;
				      if (v_lno > max_lines) print_next_page1();
				      }

				      if (loc_legend48.arr[0] != '\0') 
				      {
				      l_main_hdr = 0;
				      fprintf(fp,"%-s\n",loc_legend48.arr);
				      v_lno++;
				      if (v_lno > max_lines) print_next_page1();
				      }

				     
				     //fprintf(fp,"\n"); v_lno++;

				     if (loc_legend49.arr[0] != '\0') 
				     {
				     l_main_hdr = 0;
				     fprintf(fp,"%-s\n",loc_legend49.arr);
				     v_lno++;
				     if (v_lno > max_lines) print_next_page1();
				     }

				     if (loc_legend50.arr[0] != '\0') 
				     {
				     l_main_hdr = 0;
				     fprintf(fp,"%-s\n",loc_legend50.arr);
				     v_lno++;
				     if (v_lno > max_lines) print_next_page1();
				     }

				     if (loc_legend51.arr[0] != '\0') 
				     {
				     l_main_hdr = 0;
				     fprintf(fp,"%-s\n",loc_legend51.arr);
				     v_lno++;
				     if (v_lno > max_lines) print_next_page1();
				     }

				     if (loc_legend52.arr[0] != '\0') 
				     {
				     l_main_hdr = 0;
				     fprintf(fp,"%-s\n",loc_legend52.arr);
				     v_lno++;
				     if (v_lno > max_lines) print_next_page1();
				     }

				     if (loc_legend53.arr[0] != '\0') 
				     {
				     l_main_hdr = 0;
				     fprintf(fp,"%-s\n",loc_legend53.arr);
				     v_lno++;
				     if (v_lno > max_lines) print_next_page1();
				     }

				     if (loc_legend54.arr[0] != '\0') 
				     {
				     l_main_hdr = 0;
				     fprintf(fp,"%-s\n",loc_legend54.arr);
				     v_lno++;
				     if (v_lno > max_lines) print_next_page1();
				     }
				 }
				 else
				 {
					fprintf(fp,"\n");
					v_lno++;
				 }
				 
				 fprintf(fp,"%-s\n",loc_legend55.arr);
				 v_lno++;
				
				                           
				while(v_lno <= max_lines)
				{
					fprintf(fp,"\n");
					v_lno++;
				}
                             
				fprintf(fp,"\n\n");	
				v_lno=v_lno+2;					
			}
			
			if(l_bill_page_no>1)
			{
				//fprintf(fp,"%-50.50s %s %d"," ",loc_legend21.arr,l_bill_page_no);				
				fprintf(fp,"%80.80s %d",loc_legend21.arr,l_bill_page_no);
			}			
			fprintf(fp,"\n");
				v_lno++;

			if (l_lsr != 0 && l_dmp == 0 )
			{
				if ( l_logo_yniflaser.arr[0] == 'Y')
				{
					fprintf(fp,"\n\n\n");
				}
			}
			

			//sprintf(string_var,"1:%d",v_lno);
			//disp_message(ERR_MESG,string_var);
		//}
	}	
}


remarks_cnt_chk()
{
      l_lno = 0;      
				    
      // fprintf(fp,"\n"); 
      l_lno++;			    

      if (l_logo_yniflaser.arr[0] != 'Y')			    
      {				      
	l_lno++;				    
      }

      if (loc_legend39.arr[0]	!= '\0')
      {					
	l_lno = l_lno + 2;
      }				    				      
      if (loc_legend40.arr[0] != '\0')	
      {      
	l_lno++;      
      }

      if (loc_legend41.arr[0] != '\0') 
      {				      
	l_lno++;      
      }

      if (loc_legend42.arr[0] != '\0') 
      {      
	l_lno++;      
      }

      if (loc_legend43.arr[0] != '\0') 
      {      
	l_lno++;      
      }

      if (loc_legend44.arr[0] != '\0') 
      {				      
	l_lno++;      
      }

      if (loc_legend45.arr[0] != '\0') 
      {				      
	l_lno++;      
      }

      if (loc_legend46.arr[0] != '\0') 
      {      
	l_lno++;       
      }

      if (loc_legend47.arr[0] != '\0') 
      {	
	l_lno++;      
      }

      if (loc_legend48.arr[0] != '\0') 
      {				      
	l_lno++;				      
      }			     

     if (loc_legend49.arr[0] != '\0') 
     {				     
	l_lno++;				     
     }

     if (loc_legend50.arr[0] != '\0') 
     {				     
	l_lno++;				     
     }

     if (loc_legend51.arr[0] != '\0') 
     {				     
	l_lno++;				     
     }

     if (loc_legend52.arr[0] != '\0') 
     {     
	l_lno++;     
     }

     if (loc_legend53.arr[0] != '\0') 
     {     
	l_lno++;     
     }

     if (loc_legend54.arr[0] != '\0') 
     {     
	l_lno++;     
     }                  
          
    //fprintf(fp,"%-s\n",loc_legend55.arr); 
    
    l_lno++;   
    
    if ( (l_lno+v_lno) > max_lines) 
    {       
       print_next_page1();
    }		
}


last_line_prt()
{	
	fprintf(fp,"\n");
	last_line_check = 0;
	rec_out = 'Y';
}

fetch_legend_value()
{
	loc_legend1.arr[0]		= '\0';
	loc_legend2.arr[0]		= '\0';
	loc_legend3.arr[0]		= '\0';
	loc_legend4.arr[0]		= '\0';
	loc_legend5.arr[0]		= '\0';
	loc_legend6.arr[0]		= '\0';
	loc_legend7.arr[0]		= '\0';
	loc_legend8.arr[0]		= '\0';
	loc_legend9.arr[0]		= '\0';
	loc_legend10.arr[0]		= '\0';
	loc_legend11.arr[0]		= '\0';
	loc_legend12.arr[0]		= '\0';
	loc_legend13.arr[0]		= '\0';
	loc_legend14.arr[0]		= '\0';
	loc_legend15.arr[0]		= '\0';
	loc_legend16.arr[0]		= '\0';
	loc_legend17.arr[0]		= '\0';
	loc_legend18.arr[0]		= '\0';
	loc_legend19.arr[0]		= '\0';
	loc_legend20.arr[0]		= '\0';
	loc_legend21.arr[0]		= '\0';
	loc_legend22.arr[0]		= '\0';
	loc_legend23.arr[0]		= '\0';
	loc_legend24.arr[0]		= '\0';
	loc_legend25.arr[0]		= '\0';
	loc_legend26.arr[0]		= '\0';
	loc_legend27.arr[0]		= '\0';
	loc_legend28.arr[0]		= '\0';
	loc_legend29.arr[0]		= '\0';
	loc_legend30.arr[0]		= '\0';
	loc_legend31.arr[0]		= '\0';
	loc_legend32.arr[0]		= '\0';
	loc_legend33.arr[0]		= '\0';
	loc_legend34.arr[0]		= '\0';
	loc_legend35.arr[0]		= '\0';
	loc_legend36.arr[0]		= '\0';
	loc_legend37.arr[0]		= '\0';
	loc_legend38.arr[0]		= '\0';
	loc_legend39.arr[0]		= '\0';
	loc_legend40.arr[0]		= '\0';
	loc_legend41.arr[0]		= '\0';
	loc_legend42.arr[0]		= '\0';
	loc_legend43.arr[0]		= '\0';
	loc_legend44.arr[0]		= '\0';
	loc_legend45.arr[0]		= '\0';
	loc_legend46.arr[0]		= '\0';
	loc_legend47.arr[0]		= '\0';
	loc_legend48.arr[0]		= '\0';
	loc_legend49.arr[0]		= '\0';
	loc_legend50.arr[0]		= '\0';
	loc_legend51.arr[0]		= '\0';
	loc_legend52.arr[0]		= '\0';
	loc_legend53.arr[0]		= '\0';
	loc_legend54.arr[0]		= '\0';
	loc_legend55.arr[0]		= '\0';
	loc_legend56.arr[0]		= '\0';
	loc_legend57.arr[0]		= '\0';
	loc_legend58.arr[0]		= '\0';
	loc_legend59.arr[0]		= '\0';
	loc_legend60.arr[0]		= '\0';
	loc_legend61.arr[0]		= '\0';
	loc_legend62.arr[0]		= '\0';
	loc_legend63.arr[0]		= '\0';

	loc_legend1.len			= 0;
	loc_legend2.len			= 0;
	loc_legend3.len			= 0;
	loc_legend4.len			= 0;
	loc_legend5.len			= 0;
	loc_legend6.len			= 0;
	loc_legend7.len			= 0;
	loc_legend8.len			= 0;
	loc_legend9.len			= 0;
	loc_legend10.len		= 0;
	loc_legend11.len		= 0;
	loc_legend12.len		= 0;
	loc_legend13.len		= 0;
	loc_legend14.len		= 0;
	loc_legend15.len		= 0;
	loc_legend16.len		= 0;
	loc_legend17.len		= 0;
	loc_legend18.len		= 0;
	loc_legend19.len		= 0;
	loc_legend20.len		= 0;
	loc_legend21.len		= 0;
	loc_legend22.len		= 0;
	loc_legend23.len		= 0;
	loc_legend24.len		= 0;
	loc_legend25.len		= 0;
	loc_legend26.len		= 0;
	loc_legend27.len		= 0;
	loc_legend28.len		= 0;
	loc_legend29.len		= 0;
	loc_legend30.len		= 0;
	loc_legend31.len		= 0;
	loc_legend32.len		= 0;
	loc_legend33.len		= 0;
	loc_legend34.len		= 0;
	loc_legend35.len		= 0;
	loc_legend36.len		= 0;
	loc_legend37.len		= 0;
	loc_legend38.len		= 0;
	loc_legend39.len		= 0;
	loc_legend40.len		= 0;
	loc_legend41.len		= 0;
	loc_legend42.len		= 0;
	loc_legend43.len		= 0;
	loc_legend44.len		= 0;
	loc_legend45.len		= 0;
	loc_legend46.len		= 0;
	loc_legend47.len		= 0;
	loc_legend48.len		= 0;
	loc_legend49.len		= 0;
	loc_legend50.len		= 0;
	loc_legend51.len		= 0;
	loc_legend52.len		= 0;
	loc_legend53.len		= 0;
	loc_legend54.len		= 0;
	loc_legend55.len		= 0;
	loc_legend56.len		= 0;
	loc_legend57.len		= 0;
	loc_legend58.len		= 0;
	loc_legend59.len		= 0;
	loc_legend60.len		= 0;
	loc_legend61.len		= 0;
	loc_legend62.len		= 0;
	loc_legend63.len		= 0;



	/* EXEC SQL	select	rtrim(substr(COLUMN_VALUE,1,50))
				  into	:loc_legend1
				  from	SM_RECORD_TRANS_DATA a,
						sm_lang_legend b
				 where	MODULE_ID   = 'SM' 
				   and	TABLE_ID    = 'SM_LANG_LEGEND'
				   and  COLUMN_ID   = 'DFLT_LEGEND_VALUE'
				   and  PK_VALUE    = LEGEND_ID
				   and  LEGEND_ID   = 'BILL_01.LEGEND_010' 
				   and  LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='BILL_01.LEGEND_010') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1893;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend1;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



	if(sqlca.sqlcode == 1403)
	{
		/* EXEC SQL select dflt_legend_value 
		           into :loc_legend1
			  	   from sm_lang_legend
				  where LEGEND_ID = 'BILL_01.LEGEND_010'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='BILL_01.LEGEND_010'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1916;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend1;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 1",0,"");
	}


	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
			 into  :loc_legend2
			 from  SM_RECORD_TRANS_DATA a,sm_lang_legend b
			 where MODULE_ID = 'SM' 
			 and   TABLE_ID = 'SM_LANG_LEGEND'
			 and   COLUMN_ID = 'DFLT_LEGEND_VALUE'
			 and   PK_VALUE = LEGEND_ID
			 and   LEGEND_ID = 'BILL_01.LEGEND_020' 
			 and   LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='BILL_01.LEGEND_020') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1935;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend2;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



	if (sqlca.sqlcode == 1403)
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend2
				from sm_lang_legend
				where LEGEND_ID = 'BILL_01.LEGEND_020'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='BILL_01.LEGEND_020'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1958;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend2;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 2",0,"");
	}


	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend3
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_030' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='BILL_01.LEGEND_030') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1977;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend3;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



	if (sqlca.sqlcode == 1403)
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend3
				from sm_lang_legend
				where LEGEND_ID = 'BILL_01.LEGEND_030'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='BILL_01.LEGEND_030'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )2000;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend3;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 3",0,"");
	}


	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend4
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_040' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='BILL_01.LEGEND_040') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2019;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend4;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



	if (sqlca.sqlcode == 1403)
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend4
				from sm_lang_legend
				where LEGEND_ID = 'BILL_01.LEGEND_040'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='BILL_01.LEGEND_040'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )2042;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend4;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 4",0,"");
	}

	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend5
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_050' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='BILL_01.LEGEND_050') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2061;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend5;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



	if (sqlca.sqlcode == 1403)
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend5
				from sm_lang_legend
				where LEGEND_ID = 'BILL_01.LEGEND_050'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='BILL_01.LEGEND_050'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )2084;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend5;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 5",0,"");
	}


	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend6
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_060' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='BILL_01.LEGEND_060') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2103;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend6;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend6
				from sm_lang_legend
				where LEGEND_ID = 'BILL_01.LEGEND_060'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='BILL_01.LEGEND_060'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2126;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend6;
 sqlstm.sqhstl[0] = (unsigned int  )203;
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


}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 6",0,"");
	}


	/* EXEC SQL select /ortrim(substr(COLUMN_VALUE,1,50))o/ rtrim(COLUMN_VALUE)
				into :loc_legend7
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_070' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(COLUMN_VALUE) into :b0  from SM_RECORD_TRANS_DA\
TA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND'\
) and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='BI\
LL_01.LEGEND_070') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2145;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend7;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend7
				from sm_lang_legend
				where LEGEND_ID = 'BILL_01.LEGEND_070'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='BILL_01.LEGEND_070'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2168;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend7;
 sqlstm.sqhstl[0] = (unsigned int  )203;
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


}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 7",0,"");
	}


	/* EXEC SQL select /ortrim(substr(COLUMN_VALUE,1,50))o/ rtrim(COLUMN_VALUE)
				into :loc_legend8
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_080' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(COLUMN_VALUE) into :b0  from SM_RECORD_TRANS_DA\
TA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND'\
) and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='BI\
LL_01.LEGEND_080') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2187;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend8;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend8
				from sm_lang_legend
				where LEGEND_ID = 'BILL_01.LEGEND_080'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='BILL_01.LEGEND_080'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2210;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend8;
 sqlstm.sqhstl[0] = (unsigned int  )203;
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


}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 8",0,"");
	}


	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend9
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_090' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='BILL_01.LEGEND_090') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2229;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend9;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend9
				from sm_lang_legend
				where LEGEND_ID = 'BILL_01.LEGEND_090'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='BILL_01.LEGEND_090'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2252;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend9;
 sqlstm.sqhstl[0] = (unsigned int  )203;
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


}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 9",0,"");
	}


	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend10
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_100' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='BILL_01.LEGEND_100') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2271;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend10;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend10
				from sm_lang_legend
				where LEGEND_ID = 'BILL_01.LEGEND_100'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='BILL_01.LEGEND_100'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2294;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend10;
 sqlstm.sqhstl[0] = (unsigned int  )203;
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


}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 10",0,"");
	}


	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend11
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_110' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='BILL_01.LEGEND_110') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2313;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend11;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend11
				from sm_lang_legend
				where LEGEND_ID = 'BILL_01.LEGEND_110'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='BILL_01.LEGEND_110'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2336;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend11;
 sqlstm.sqhstl[0] = (unsigned int  )203;
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


}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 11",0,"");
	}

	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend12
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_120' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='BILL_01.LEGEND_120') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2355;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend12;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend12
				from sm_lang_legend
				where LEGEND_ID = 'BILL_01.LEGEND_120'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='BILL_01.LEGEND_120'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2378;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend12;
 sqlstm.sqhstl[0] = (unsigned int  )203;
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


}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 12",0,"");
	}

	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend13
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_130' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='BILL_01.LEGEND_130') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2397;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend13;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend13
				from sm_lang_legend
				where LEGEND_ID = 'BILL_01.LEGEND_130'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='BILL_01.LEGEND_130'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2420;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend13;
 sqlstm.sqhstl[0] = (unsigned int  )203;
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


}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 13",0,"");
	}


	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend14
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_140' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='BILL_01.LEGEND_140') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2439;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend14;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend14
				from sm_lang_legend
				where LEGEND_ID = 'BILL_01.LEGEND_140'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='BILL_01.LEGEND_140'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2462;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend14;
 sqlstm.sqhstl[0] = (unsigned int  )203;
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


}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 14",0,"");
	}


	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend15
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_150' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='BILL_01.LEGEND_150') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2481;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend15;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend15
				from sm_lang_legend
				where LEGEND_ID = 'BILL_01.LEGEND_150'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='BILL_01.LEGEND_150'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2504;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend15;
 sqlstm.sqhstl[0] = (unsigned int  )203;
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


}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 15",0,"");
	}

	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend16
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_160' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='BILL_01.LEGEND_160') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2523;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend16;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend16
				from sm_lang_legend
				where LEGEND_ID = 'BILL_01.LEGEND_160'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='BILL_01.LEGEND_160'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2546;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend16;
 sqlstm.sqhstl[0] = (unsigned int  )203;
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


}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 16",0,"");
	}


	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend17
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_170' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='BILL_01.LEGEND_170') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2565;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend17;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend17
				from sm_lang_legend
				where LEGEND_ID = 'BILL_01.LEGEND_170'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='BILL_01.LEGEND_170'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2588;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend17;
 sqlstm.sqhstl[0] = (unsigned int  )203;
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


}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 17",0,"");
	}


	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend18
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_180' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='BILL_01.LEGEND_180') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2607;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend18;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend18
				from sm_lang_legend
				where LEGEND_ID = 'BILL_01.LEGEND_180'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='BILL_01.LEGEND_180'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2630;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend18;
 sqlstm.sqhstl[0] = (unsigned int  )203;
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


}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 18",0,"");
	}

	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend19
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_190' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='BILL_01.LEGEND_190') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2649;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend19;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend19
				from sm_lang_legend
				where LEGEND_ID = 'BILL_01.LEGEND_190'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='BILL_01.LEGEND_190'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2672;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend19;
 sqlstm.sqhstl[0] = (unsigned int  )203;
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


}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 19",0,"");
	}


	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend20
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_200' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='BILL_01.LEGEND_200') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2691;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend20;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



	if (sqlca.sqlcode == 1403)
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend20
					from sm_lang_legend
					where LEGEND_ID = 'BILL_01.LEGEND_200'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='BILL_01.LEGEND_200'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )2714;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend20;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 20",0,"");
	}

	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend21
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_210' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='BILL_01.LEGEND_210') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2733;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend21;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



	if (sqlca.sqlcode == 1403)
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend21
					from sm_lang_legend
					where LEGEND_ID = 'BILL_01.LEGEND_210'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='BILL_01.LEGEND_210'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )2756;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend21;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 21",0,"");
	}


	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend22
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_220' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='BILL_01.LEGEND_220') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2775;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend22;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



	if (sqlca.sqlcode == 1403)
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend22
					from sm_lang_legend
					where LEGEND_ID = 'BILL_01.LEGEND_220'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='BILL_01.LEGEND_220'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )2798;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend22;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 22",0,"");
	}

	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend23
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_230' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='BILL_01.LEGEND_230') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2817;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend23;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



	if (sqlca.sqlcode == 1403)
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend23
					from sm_lang_legend
					where LEGEND_ID = 'BILL_01.LEGEND_230'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='BILL_01.LEGEND_230'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )2840;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend23;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 23",0,"");
	}

	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend24
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_240' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='BILL_01.LEGEND_240') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2859;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend24;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



	if (sqlca.sqlcode == 1403)
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend24
					from sm_lang_legend
					where LEGEND_ID = 'BILL_01.LEGEND_240'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='BILL_01.LEGEND_240'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )2882;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend24;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 24",0,"");
	}


	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend25
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_250' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='BILL_01.LEGEND_250') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2901;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend25;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



	if (sqlca.sqlcode == 1403)
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend25
					from sm_lang_legend
					where LEGEND_ID = 'BILL_01.LEGEND_250'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='BILL_01.LEGEND_250'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )2924;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend25;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 25",0,"");
	}

	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend26
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_260' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='BILL_01.LEGEND_260') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2943;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend26;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



	if (sqlca.sqlcode == 1403)
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend26
					from sm_lang_legend
					where LEGEND_ID = 'BILL_01.LEGEND_260'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='BILL_01.LEGEND_260'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )2966;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend26;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 26",0,"");
	}


	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend27
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_270' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='BILL_01.LEGEND_270') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2985;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend27;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



	if (sqlca.sqlcode == 1403)
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend27
					from sm_lang_legend
					where LEGEND_ID = 'BILL_01.LEGEND_270'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='BILL_01.LEGEND_270'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3008;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend27;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 27",0,"");
	}

	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend28
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_280' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='BILL_01.LEGEND_280') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3027;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend28;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



	if (sqlca.sqlcode == 1403)
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend28
					from sm_lang_legend
					where LEGEND_ID = 'BILL_01.LEGEND_280'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='BILL_01.LEGEND_280'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3050;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend28;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 28",0,"");
	}


	/* EXEC SQL select /ortrim(substr(COLUMN_VALUE,1,50))o/ rtrim(COLUMN_VALUE)
				into :loc_legend29
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_290' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(COLUMN_VALUE) into :b0  from SM_RECORD_TRANS_DA\
TA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND'\
) and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='BI\
LL_01.LEGEND_290') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3069;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend29;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



	if (sqlca.sqlcode == 1403)
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend29
					from sm_lang_legend
					where LEGEND_ID = 'BILL_01.LEGEND_290'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='BILL_01.LEGEND_290'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3092;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend29;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 29",0,"");
	}

     if (l_lsr != 0 && l_dmp == 0)
      {
	/* EXEC SQL select lpad(' ',round((:l_margin_len-length(rtrim(substr(COLUMN_VALUE,1,50))))/2),' ')||UPPER(rtrim(substr(COLUMN_VALUE,1,50)))	   
				into :loc_legend30
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_300' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select (lpad(' ',round(((:b0-length(rtrim(substr(COLUMN_VALU\
E,1,50))))/2)),' ')||UPPER(rtrim(substr(COLUMN_VALUE,1,50)))) into :b1  from S\
M_RECORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID\
='SM_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) \
and LEGEND_ID='BILL_01.LEGEND_300') and LANGUAGE_ID=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3111;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_margin_len;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&loc_legend30;
 sqlstm.sqhstl[1] = (unsigned int  )203;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_lang_id;
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


     }
     else
     {

	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend30
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_300' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='BILL_01.LEGEND_300') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3138;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend30;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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


      }      

	if (sqlca.sqlcode == 1403)
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend30
					from sm_lang_legend
					where LEGEND_ID = 'BILL_01.LEGEND_300'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='BILL_01.LEGEND_300'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3161;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend30;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 30",0,"");
	}


	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend31
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_310' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='BILL_01.LEGEND_310') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3180;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend31;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



	if (sqlca.sqlcode == 1403)
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend31
					from sm_lang_legend
					where LEGEND_ID = 'BILL_01.LEGEND_310'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='BILL_01.LEGEND_310'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3203;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend31;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 31",0,"");
	}

	if (l_lsr != 0 && l_dmp == 0)
       {
		/* EXEC SQL select lpad(' ',round((:l_margin_len-length(rtrim(substr(COLUMN_VALUE,1,50))))/2),' ')||UPPER(rtrim(substr(COLUMN_VALUE,1,50)))	   
				into :loc_legend32
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_320' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select (lpad(' ',round(((:b0-length(rtrim(substr(COLUMN_VAL\
UE,1,50))))/2)),' ')||UPPER(rtrim(substr(COLUMN_VALUE,1,50)))) into :b1  from \
SM_RECORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_I\
D='SM_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID)\
 and LEGEND_ID='BILL_01.LEGEND_320') and LANGUAGE_ID=:b2)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3222;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&l_margin_len;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&loc_legend32;
  sqlstm.sqhstl[1] = (unsigned int  )203;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_lang_id;
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


	}
	else
	{
		/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend32
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_320' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_R\
ECORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='S\
M_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and\
 LEGEND_ID='BILL_01.LEGEND_320') and LANGUAGE_ID=:b1)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3249;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend32;
  sqlstm.sqhstl[0] = (unsigned int  )203;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
  sqlstm.sqhstl[1] = (unsigned int  )6;
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


	}

	if (sqlca.sqlcode == 1403)
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend32
					from sm_lang_legend
					where LEGEND_ID = 'BILL_01.LEGEND_320'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='BILL_01.LEGEND_320'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3272;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend32;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 32",0,"");
	}

	if (l_lsr != 0 && l_dmp == 0)
	{
		/* EXEC SQL select lpad(' ',round((:l_margin_len-length(rtrim(substr(COLUMN_VALUE,1,50))))/2),' ')||UPPER(rtrim(substr(COLUMN_VALUE,1,50)))	   
				into :loc_legend33
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_330' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select (lpad(' ',round(((:b0-length(rtrim(substr(COLUMN_VAL\
UE,1,50))))/2)),' ')||UPPER(rtrim(substr(COLUMN_VALUE,1,50)))) into :b1  from \
SM_RECORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_I\
D='SM_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID)\
 and LEGEND_ID='BILL_01.LEGEND_330') and LANGUAGE_ID=:b2)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3291;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&l_margin_len;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&loc_legend33;
  sqlstm.sqhstl[1] = (unsigned int  )203;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_lang_id;
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


	}
	else
	{
		/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend33
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_330' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_R\
ECORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='S\
M_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and\
 LEGEND_ID='BILL_01.LEGEND_330') and LANGUAGE_ID=:b1)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3318;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend33;
  sqlstm.sqhstl[0] = (unsigned int  )203;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
  sqlstm.sqhstl[1] = (unsigned int  )6;
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



	}

	if (sqlca.sqlcode == 1403)
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend33
					from sm_lang_legend
					where LEGEND_ID = 'BILL_01.LEGEND_330'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='BILL_01.LEGEND_330'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3341;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend33;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 33",0,"");
	}

	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend34
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_340' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='BILL_01.LEGEND_340') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3360;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend34;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



	if (sqlca.sqlcode == 1403)
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend34
					from sm_lang_legend
					where LEGEND_ID = 'BILL_01.LEGEND_340'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='BILL_01.LEGEND_340'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3383;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend34;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 34",0,"");
	}

	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend35
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_350' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='BILL_01.LEGEND_350') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3402;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend35;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



	if (sqlca.sqlcode == 1403)
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend35
					from sm_lang_legend
					where LEGEND_ID = 'BILL_01.LEGEND_350'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='BILL_01.LEGEND_350'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3425;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend35;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 35",0,"");
	}

	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend36
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_360' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='BILL_01.LEGEND_360') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3444;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend36;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



	if (sqlca.sqlcode == 1403)
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend36
					from sm_lang_legend
					where LEGEND_ID = 'BILL_01.LEGEND_360'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='BILL_01.LEGEND_360'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3467;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend36;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 36",0,"");
	}



	/* EXEC SQL select lpad(' ',round((:l_margin_len-length(rtrim(substr(COLUMN_VALUE,1,50))))/2),' ')||UPPER(rtrim(substr(COLUMN_VALUE,1,50)))	
				into :loc_legend37
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_370' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select (lpad(' ',round(((:b0-length(rtrim(substr(COLUMN_VALU\
E,1,50))))/2)),' ')||UPPER(rtrim(substr(COLUMN_VALUE,1,50)))) into :b1  from S\
M_RECORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID\
='SM_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) \
and LEGEND_ID='BILL_01.LEGEND_370') and LANGUAGE_ID=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3486;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_margin_len;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&loc_legend37;
 sqlstm.sqhstl[1] = (unsigned int  )203;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_lang_id;
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



	if (sqlca.sqlcode == 1403)
	{
		/* EXEC SQL select lpad(' ',round((:l_margin_len-length(rtrim(substr(dflt_legend_value,1,50))))/2),' ')||UPPER(rtrim(substr(dflt_legend_value,1,50)))				
				        into :loc_legend37
					from sm_lang_legend
					where LEGEND_ID = 'BILL_01.LEGEND_370'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select (lpad(' ',round(((:b0-length(rtrim(substr(dflt_legen\
d_value,1,50))))/2)),' ')||UPPER(rtrim(substr(dflt_legend_value,1,50)))) into \
:b1  from sm_lang_legend where LEGEND_ID='BILL_01.LEGEND_370'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3513;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&l_margin_len;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&loc_legend37;
  sqlstm.sqhstl[1] = (unsigned int  )203;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 37",0,"");
	}


	/* EXEC SQL select lpad(' ',round((:l_margin_len-length(rtrim(substr(COLUMN_VALUE,1,50))))/2),' ')||UPPER(rtrim(substr(COLUMN_VALUE,1,50)))	
				into :loc_legend38
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_380' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select (lpad(' ',round(((:b0-length(rtrim(substr(COLUMN_VALU\
E,1,50))))/2)),' ')||UPPER(rtrim(substr(COLUMN_VALUE,1,50)))) into :b1  from S\
M_RECORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID\
='SM_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) \
and LEGEND_ID='BILL_01.LEGEND_380') and LANGUAGE_ID=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3536;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_margin_len;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&loc_legend38;
 sqlstm.sqhstl[1] = (unsigned int  )203;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_lang_id;
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



	if (sqlca.sqlcode == 1403)
	{
		/* EXEC SQL select lpad(' ',round((:l_margin_len-length(rtrim(substr(dflt_legend_value,1,50))))/2),' ')||UPPER(rtrim(substr(dflt_legend_value,1,50)))				
					into :loc_legend38
					from sm_lang_legend
					where LEGEND_ID = 'BILL_01.LEGEND_380'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select (lpad(' ',round(((:b0-length(rtrim(substr(dflt_legen\
d_value,1,50))))/2)),' ')||UPPER(rtrim(substr(dflt_legend_value,1,50)))) into \
:b1  from sm_lang_legend where LEGEND_ID='BILL_01.LEGEND_380'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3563;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&l_margin_len;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&loc_legend38;
  sqlstm.sqhstl[1] = (unsigned int  )203;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 38",0,"");
	}

	/*------------------------22/09/2005-----------------------*/

	/* EXEC SQL select  COLUMN_VALUE 
				into :loc_legend39
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_390' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,s\
m_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and C\
OLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='BILL_01.L\
EGEND_390') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3586;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend39;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



	if (sqlca.sqlcode == 1403)
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend39
					from sm_lang_legend
					where LEGEND_ID = 'BILL_01.LEGEND_390'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='BILL_01.LEGEND_390'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3609;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend39;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 39",0,"");
	}



	/* EXEC SQL select  COLUMN_VALUE 
				into :loc_legend40
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_400' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,s\
m_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and C\
OLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='BILL_01.L\
EGEND_400') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3628;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend40;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



	if (sqlca.sqlcode == 1403)
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend40
					from sm_lang_legend
					where LEGEND_ID = 'BILL_01.LEGEND_400'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='BILL_01.LEGEND_400'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3651;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend40;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 40",0,"");
	}


	/* EXEC SQL select  COLUMN_VALUE 
				into :loc_legend41
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_410' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,s\
m_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and C\
OLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='BILL_01.L\
EGEND_410') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3670;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend41;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



	if (sqlca.sqlcode == 1403)
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend41
					from sm_lang_legend
					where LEGEND_ID = 'BILL_01.LEGEND_410'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='BILL_01.LEGEND_410'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3693;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend41;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 41",0,"");
	}



 /* EXEC SQL select  COLUMN_VALUE 
				into :loc_legend42
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_420' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,s\
m_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and C\
OLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='BILL_01.L\
EGEND_420') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3712;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend42;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



	if (sqlca.sqlcode == 1403)
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend42
					from sm_lang_legend
					where LEGEND_ID = 'BILL_01.LEGEND_420'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='BILL_01.LEGEND_420'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3735;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend42;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 42",0,"");
	}



	/* EXEC SQL select  COLUMN_VALUE 
				into :loc_legend43
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_430' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,s\
m_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and C\
OLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='BILL_01.L\
EGEND_430') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3754;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend43;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



	if (sqlca.sqlcode == 1403)
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend43
					from sm_lang_legend
					where LEGEND_ID = 'BILL_01.LEGEND_430'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='BILL_01.LEGEND_430'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3777;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend43;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 43",0,"");
	}



	/* EXEC SQL select  COLUMN_VALUE 
				into :loc_legend44
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_440' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,s\
m_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and C\
OLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='BILL_01.L\
EGEND_440') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3796;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend44;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



	if (sqlca.sqlcode == 1403)
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend44
					from sm_lang_legend
					where LEGEND_ID = 'BILL_01.LEGEND_440'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='BILL_01.LEGEND_440'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3819;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend44;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 44",0,"");
	}



	/* EXEC SQL select  COLUMN_VALUE 
				into :loc_legend45
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_450' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,s\
m_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and C\
OLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='BILL_01.L\
EGEND_450') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3838;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend45;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



	if (sqlca.sqlcode == 1403)
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend45
					from sm_lang_legend
					where LEGEND_ID = 'BILL_01.LEGEND_450'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='BILL_01.LEGEND_450'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3861;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend45;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 45",0,"");
	}


	
	/* EXEC SQL select  COLUMN_VALUE 
				into :loc_legend46
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_460' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,s\
m_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and C\
OLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='BILL_01.L\
EGEND_460') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3880;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend46;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



	if (sqlca.sqlcode == 1403)
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend46
					from sm_lang_legend
					where LEGEND_ID = 'BILL_01.LEGEND_460'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='BILL_01.LEGEND_460'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3903;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend46;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 46",0,"");
	}






	/* EXEC SQL select  COLUMN_VALUE 
				into :loc_legend47
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_470' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,s\
m_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and C\
OLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='BILL_01.L\
EGEND_470') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3922;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend47;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



	if (sqlca.sqlcode == 1403)
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend47
					from sm_lang_legend
					where LEGEND_ID = 'BILL_01.LEGEND_470'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='BILL_01.LEGEND_470'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3945;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend47;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 47",0,"");
	}




	/* EXEC SQL select  COLUMN_VALUE 
				into :loc_legend48
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_480' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,s\
m_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and C\
OLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='BILL_01.L\
EGEND_480') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3964;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend48;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



	if (sqlca.sqlcode == 1403)
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend48
					from sm_lang_legend
					where LEGEND_ID = 'BILL_01.LEGEND_480'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='BILL_01.LEGEND_480'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3987;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend48;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 48",0,"");
	}



	/* EXEC SQL select  COLUMN_VALUE 
				into :loc_legend49
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_490' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,s\
m_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and C\
OLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='BILL_01.L\
EGEND_490') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4006;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend49;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



	if (sqlca.sqlcode == 1403)
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend49
					from sm_lang_legend
					where LEGEND_ID = 'BILL_01.LEGEND_490'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='BILL_01.LEGEND_490'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )4029;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend49;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 49",0,"");
	}





	/* EXEC SQL select  COLUMN_VALUE 
				into :loc_legend50
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_500' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,s\
m_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and C\
OLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='BILL_01.L\
EGEND_500') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4048;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend50;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



	if (sqlca.sqlcode == 1403)
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend50
					from sm_lang_legend
					where LEGEND_ID = 'BILL_01.LEGEND_500'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='BILL_01.LEGEND_500'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )4071;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend50;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 50",0,"");
	}



	/* EXEC SQL select  COLUMN_VALUE 
				into :loc_legend51
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_510' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,s\
m_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and C\
OLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='BILL_01.L\
EGEND_510') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4090;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend51;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



	if (sqlca.sqlcode == 1403)
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend51
					from sm_lang_legend
					where LEGEND_ID = 'BILL_01.LEGEND_510'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='BILL_01.LEGEND_510'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )4113;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend51;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 51",0,"");
	}




	/* EXEC SQL select  COLUMN_VALUE 
				into :loc_legend52
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_520' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,s\
m_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and C\
OLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='BILL_01.L\
EGEND_520') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4132;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend52;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



	if (sqlca.sqlcode == 1403)
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend52
					from sm_lang_legend
					where LEGEND_ID = 'BILL_01.LEGEND_520'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='BILL_01.LEGEND_520'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )4155;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend52;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 52",0,"");
	}



	/* EXEC SQL select  COLUMN_VALUE 
				into :loc_legend53
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_530' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,s\
m_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and C\
OLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='BILL_01.L\
EGEND_530') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4174;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend53;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



	if (sqlca.sqlcode == 1403)
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend53
					from sm_lang_legend
					where LEGEND_ID = 'BILL_01.LEGEND_530'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='BILL_01.LEGEND_530'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )4197;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend53;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 53",0,"");
	}


	/* EXEC SQL select  COLUMN_VALUE 
				into :loc_legend54
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_540' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,s\
m_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and C\
OLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='BILL_01.L\
EGEND_540') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4216;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend54;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



	if (sqlca.sqlcode == 1403)
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend54
					from sm_lang_legend
					where LEGEND_ID = 'BILL_01.LEGEND_540'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='BILL_01.LEGEND_540'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )4239;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend54;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 54",0,"");
	}



	/* EXEC SQL select  COLUMN_VALUE 
				into :loc_legend55
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_550' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,s\
m_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and C\
OLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='BILL_01.L\
EGEND_550') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4258;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend55;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



	if (sqlca.sqlcode == 1403)
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend55
					from sm_lang_legend
					where LEGEND_ID = 'BILL_01.LEGEND_550'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='BILL_01.LEGEND_550'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )4281;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend55;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 55",0,"");
	}

	/* EXEC SQL select  COLUMN_VALUE 
				into :loc_legend56
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_560' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,s\
m_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and C\
OLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='BILL_01.L\
EGEND_560') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4300;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend56;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



	if (sqlca.sqlcode == 1403)
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend56
					from sm_lang_legend
					where LEGEND_ID = 'BILL_01.LEGEND_560'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='BILL_01.LEGEND_560'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )4323;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend56;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 56",0,"");
	}

	/* EXEC SQL select  COLUMN_VALUE 
				into :loc_legend57
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_570' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,s\
m_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and C\
OLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='BILL_01.L\
EGEND_570') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4342;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend57;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



	if (sqlca.sqlcode == 1403)
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend57
					from sm_lang_legend
					where LEGEND_ID = 'BILL_01.LEGEND_570'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='BILL_01.LEGEND_570'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )4365;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend57;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 57",0,"");
	}

	/* EXEC SQL select  COLUMN_VALUE 
				into :loc_legend58
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_580' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,s\
m_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and C\
OLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='BILL_01.L\
EGEND_580') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4384;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend58;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



	if (sqlca.sqlcode == 1403)
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend58
					from sm_lang_legend
					where LEGEND_ID = 'BILL_01.LEGEND_580'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='BILL_01.LEGEND_580'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )4407;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend58;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 58",0,"");
	}

	/* EXEC SQL select  COLUMN_VALUE 
				into :loc_legend59
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_590' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,s\
m_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and C\
OLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='BILL_01.L\
EGEND_590') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4426;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend59;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



	if (sqlca.sqlcode == 1403)
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend59
					from sm_lang_legend
					where LEGEND_ID = 'BILL_01.LEGEND_590'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='BILL_01.LEGEND_590'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )4449;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend59;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 59",0,"");
	}

	/* EXEC SQL select  COLUMN_VALUE 
				into :loc_legend60
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_600' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,s\
m_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and C\
OLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='BILL_01.L\
EGEND_600') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4468;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend60;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



	if (sqlca.sqlcode == 1403)
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend60
					from sm_lang_legend
					where LEGEND_ID = 'BILL_01.LEGEND_600'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='BILL_01.LEGEND_600'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )4491;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend60;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 60",0,"");
	}


	/* EXEC SQL select  COLUMN_VALUE 
				into :loc_legend61
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_610' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,s\
m_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and C\
OLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='BILL_01.L\
EGEND_610') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4510;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend61;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



	if (sqlca.sqlcode == 1403)
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend61
					from sm_lang_legend
					where LEGEND_ID = 'BILL_01.LEGEND_610'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='BILL_01.LEGEND_610'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )4533;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend61;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 61",0,"");
	}

	/* EXEC SQL select  COLUMN_VALUE 
				into :loc_legend62
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_620' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,s\
m_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and C\
OLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='BILL_01.L\
EGEND_620') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4552;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend62;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



	if (sqlca.sqlcode == 1403)
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend62
					from sm_lang_legend
					where LEGEND_ID = 'BILL_01.LEGEND_620'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='BILL_01.LEGEND_620'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )4575;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend62;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 62",0,"");
	}

	/* EXEC SQL select  COLUMN_VALUE 
				into :loc_legend63
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'BILL_01.LEGEND_630' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,s\
m_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and C\
OLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='BILL_01.L\
EGEND_630') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4594;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend63;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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



	if (sqlca.sqlcode == 1403)
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend63
					from sm_lang_legend
					where LEGEND_ID = 'BILL_01.LEGEND_630'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='BILL_01.LEGEND_630'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )4617;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend63;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 63",0,"");
	}




	loc_legend1.arr[loc_legend1.len]		= '\0';
	loc_legend2.arr[loc_legend2.len]		= '\0';
	loc_legend3.arr[loc_legend3.len]		= '\0';
	loc_legend4.arr[loc_legend4.len]		= '\0';
	loc_legend5.arr[loc_legend5.len]		= '\0';
	loc_legend6.arr[loc_legend6.len]		= '\0';
	loc_legend7.arr[loc_legend7.len]		= '\0';
	loc_legend8.arr[loc_legend8.len]		= '\0';
	loc_legend9.arr[loc_legend9.len]		= '\0';
	loc_legend10.arr[loc_legend10.len]		= '\0';
	loc_legend11.arr[loc_legend11.len]		= '\0';
	loc_legend12.arr[loc_legend12.len]		= '\0';
	loc_legend13.arr[loc_legend13.len]		= '\0';
	loc_legend14.arr[loc_legend14.len]		= '\0';
	loc_legend15.arr[loc_legend15.len]		= '\0';
	loc_legend16.arr[loc_legend16.len]		= '\0';
	loc_legend17.arr[loc_legend17.len]		= '\0';
	loc_legend18.arr[loc_legend18.len]		= '\0';
	loc_legend19.arr[loc_legend19.len]		= '\0';
	loc_legend20.arr[loc_legend20.len]		= '\0';
	loc_legend21.arr[loc_legend21.len]		= '\0';
	loc_legend22.arr[loc_legend22.len]		= '\0';
	loc_legend23.arr[loc_legend23.len]		= '\0';
	loc_legend24.arr[loc_legend24.len]		= '\0';
	loc_legend25.arr[loc_legend25.len]		= '\0';
	loc_legend26.arr[loc_legend26.len]		= '\0';
	loc_legend27.arr[loc_legend27.len]		= '\0';
	loc_legend28.arr[loc_legend28.len]		= '\0';
	loc_legend29.arr[loc_legend29.len]		= '\0';
	loc_legend30.arr[loc_legend30.len]		= '\0';
	loc_legend31.arr[loc_legend31.len]		= '\0';
	loc_legend32.arr[loc_legend32.len]		= '\0';
	loc_legend33.arr[loc_legend33.len]		= '\0';
	loc_legend34.arr[loc_legend34.len]		= '\0';
	loc_legend35.arr[loc_legend35.len]		= '\0';
	loc_legend36.arr[loc_legend36.len]		= '\0';
	loc_legend37.arr[loc_legend37.len]		= '\0';
	loc_legend38.arr[loc_legend38.len]		= '\0';
	loc_legend39.arr[loc_legend39.len]		= '\0';
	loc_legend40.arr[loc_legend40.len]		= '\0';
	loc_legend41.arr[loc_legend41.len]		= '\0';
	loc_legend42.arr[loc_legend42.len]		= '\0';
	loc_legend43.arr[loc_legend43.len]		= '\0';
	loc_legend44.arr[loc_legend44.len]		= '\0';
	loc_legend45.arr[loc_legend45.len]		= '\0';
	loc_legend46.arr[loc_legend46.len]		= '\0';
	loc_legend47.arr[loc_legend47.len]		= '\0';
	loc_legend48.arr[loc_legend48.len]		= '\0';
	loc_legend49.arr[loc_legend49.len]		= '\0';
	loc_legend50.arr[loc_legend50.len]		= '\0';
	loc_legend51.arr[loc_legend51.len]		= '\0';
	loc_legend52.arr[loc_legend52.len]		= '\0';
	loc_legend53.arr[loc_legend53.len]		= '\0';
	loc_legend54.arr[loc_legend54.len]		= '\0';
	loc_legend55.arr[loc_legend55.len]		= '\0';
	loc_legend56.arr[loc_legend56.len]		= '\0';
	loc_legend57.arr[loc_legend57.len]		= '\0';
	loc_legend58.arr[loc_legend58.len]		= '\0';
	loc_legend59.arr[loc_legend59.len]		= '\0';	
	loc_legend60.arr[loc_legend60.len]		= '\0';	
	loc_legend61.arr[loc_legend61.len]		= '\0';	
	loc_legend62.arr[loc_legend62.len]		= '\0';	
	loc_legend63.arr[loc_legend63.len]		= '\0';	
}


print_formated_amt(loc_amount)
double loc_amount;
{
	char s_amt[30], str_amt[30], fstr_amt[30];

    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);        
        format_amt(s_amt);        
        sprintf(str_amt,"%14s",s_amt);				
		ltrim (str_amt);		
		rtrim (str_amt);		
		//strcpy(fstr_amt,"CR ");
		//strcat(fstr_amt,str_amt);		
		//ltrim (fstr_amt);		
		//rtrim (fstr_amt);
		//sprintf(str_amt,"%15s",str_amt);		
        fprintf(fp,"%15s CR",str_amt);
        }
    else 
	{
        put_val(s_amt,loc_amount);         
        format_amt(s_amt);
        sprintf(str_amt,"%15s",s_amt);
        fprintf(fp,"%15s ",str_amt);
     }

}                        


print_formated(loc_amount)
double loc_amount;
{
    char s_amt[30], str_amt[30], fstr_amt[30];

    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);        
        format_amt(s_amt);        
        sprintf(str_amt,"%14s",s_amt);				
		ltrim (str_amt);		
		rtrim (str_amt);
		sprintf(str_amt,"%sCR",str_amt);
		return str_amt;
 
        }
    else 
	{
        put_val(s_amt,loc_amount);         
        format_amt(s_amt);
        sprintf(str_amt,"%sDR",s_amt);
	return str_amt;
     }
}                        

print_next_page1()
{
	int i;
	
	while(v_lno <= max_lines)
	{
		fprintf(fp,"\n");
		v_lno++;
	}	

	if (l_lsr != 0 && l_dmp == 0)
	{	 
		fprintf(fp,"\n\n");
	}
	else
	{
		fprintf(fp,"\n\n\n\n");
	}
		

	//fprintf(fp,"%-80.80s %s %d\n"," ",loc_legend21.arr,l_bill_page_no);
	fprintf(fp,"%80.80s %d\n",loc_legend21.arr,l_bill_page_no);
	if ( l_logo_yniflaser.arr[0] != 'Y')
	{
	fprintf(fp,""); /* To Eject Page */
	}
        fprintf(fp,"\n");

	if (l_lsr != 0 && l_dmp == 0 )
	{
		if ( l_logo_yniflaser.arr[0] == 'Y')
		{
			fprintf(fp,"\n\n");
		}
	}


	//sprintf(string_var,"%d",v_lno);
	//disp_message(ERR_MESG,string_var);

	print_report_head();
}




close_grp_hdr_cur()
{
	/* EXEC SQL CLOSE BL_BILL_GRP_HDR_LINE_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4636;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}


close_prepay_cur()
{
	/* EXEC SQL CLOSE BL_PREPAY_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4651;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

	
}

close_refund_cur()
{
	/* EXEC SQL CLOSE BL_REFUND_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4666;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}	

close_cust_cur()
{
	/* EXEC SQL CLOSE BL_BILL_HDR_CUST_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4681;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}	


ltrim(l_str)
char *l_str;
{
   char *ptr;
   ptr = l_str;
   while (*ptr== ' ') ptr++;
   for(;*ptr!='\0';ptr++,l_str++)
    *l_str = *ptr;
   *l_str = '\0';
}

rtrim(l_str)
char *l_str;
{
  while (*l_str != '\0') *l_str++;
  l_str--;
  while (*l_str == ' ') *l_str--;
  *(l_str+1) = '\0';
}

get_left_margin()
{

	if (l_lsr != 0 && l_dmp == 0)
	  {
		if (l_logo_yniflaser.arr[0] == 'Y')			    
			l_margin_len = 94;				
		else
			l_margin_len = 60;

	  }
}


get_print_net_gross()
{
	//Modified by Harish against the instructions from Mr. Kuila 
	//Date - 06/11/2003 Point # 18 - Customization document.
	l_bill_print_opt_for_disc_print=0;
	
	/* EXEC SQL SELECT bill_print_opt_for_disc_print
	           INTO :l_bill_print_opt_for_disc_print
	           FROM bl_parameters
			  WHERE operating_facility_id = :nd_facility_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select bill_print_opt_for_disc_print into :b0  from bl_param\
eters where operating_facility_id=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4696;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_bill_print_opt_for_disc_print;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
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



   if (OERROR)
        err_mesg("SELECT failed on table BL_PARAMETERS",0,"");

   if (NODATAFOUND)
        err_mesg("No Record found in BL_PARAMETERS",0,"");

	//This option will be used while the bill is printed form 
	//Print Visit Bill - No Discount option.
	if(strcmp(l_print_without_disc_func.arr,"1")==0)
	{
		l_bill_print_opt_for_disc_print=3;
	}
}

print_formated_amt_exempt(loc_amount)
double loc_amount;
{
	char s_amt[30], str_amt[30], fstr_amt[30];

    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);        
        format_amt(s_amt);        
        sprintf(str_amt,"%14s",s_amt);				
		ltrim (str_amt);		
		rtrim (str_amt);		
		strcpy(fstr_amt,"(-)");
		strcat(fstr_amt,str_amt);		
		ltrim (fstr_amt);		
		rtrim (fstr_amt);
		sprintf(str_amt,"%15s",fstr_amt);		
        fprintf(fp,"%15s ",str_amt);
        }
    else 
	{
        put_val(s_amt,loc_amount);         
        format_amt(s_amt);
		ltrim(s_amt);
		rtrim(s_amt);
        sprintf(str_amt,"%-15s",s_amt);
        fprintf(fp,"%-15s ",str_amt);
     }
}                        

get_bill_address()
{
	l_bill_contact_name.arr[0] = '\0';
	l_bill_contact_name.len = 0;

	l_bill_contact_name_title.arr[0] = '\0';
	l_bill_contact_name_title.len = 0;

	l_bill_long_desc.arr[0] = '\0';
	l_bill_long_desc.len = 0;

	l_bill_add1_desc.arr[0] = '\0';
	l_bill_add1_desc.len = 0;

	l_bill_add2_desc.arr[0] = '\0';
	l_bill_add2_desc.len = 0;

	l_bill_add3_desc.arr[0] = '\0';
	l_bill_add3_desc.len = 0;
	
	if(strcmp(d_bill_nature_code.arr,"A")==0)
	{
		/* EXEC SQL SELECT substr(contact_name,1,19),
						substr(contact_name_title,1,20),
						substr(long_name,1,40),
						substr(add1_desc,1,40),
						substr(add2_desc,1,40),
						substr(add3_desc,1,40)						
				   INTO :l_bill_contact_name,
						:l_bill_contact_name_title,
						:l_bill_long_desc,
						:l_bill_add1_desc,
						:l_bill_add2_desc,
						:l_bill_add3_desc
				   FROM ar_customer
				  WHERE cust_code = :dc_cust_code; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select substr(contact_name,1,19) ,substr(contact_name_title\
,1,20) ,substr(long_name,1,40) ,substr(add1_desc,1,40) ,substr(add2_desc,1,40)\
 ,substr(add3_desc,1,40) into :b0,:b1,:b2,:b3,:b4,:b5  from ar_customer where \
cust_code=:b6";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )4719;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&l_bill_contact_name;
  sqlstm.sqhstl[0] = (unsigned int  )52;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&l_bill_contact_name_title;
  sqlstm.sqhstl[1] = (unsigned int  )52;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&l_bill_long_desc;
  sqlstm.sqhstl[2] = (unsigned int  )42;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&l_bill_add1_desc;
  sqlstm.sqhstl[3] = (unsigned int  )42;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&l_bill_add2_desc;
  sqlstm.sqhstl[4] = (unsigned int  )42;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&l_bill_add3_desc;
  sqlstm.sqhstl[5] = (unsigned int  )42;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&dc_cust_code;
  sqlstm.sqhstl[6] = (unsigned int  )11;
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



			   if (OERROR)
					err_mesg("SELECT failed on table AR_CUSTOMER",0,"");

	}
	else if(strcmp(d_bill_nature_code.arr,"C")==0)
	{
		/* EXEC SQL SELECT substr(mail_contact_name,1,19),
						substr(mail_postal_code,1,20),
						substr(ln1_mail_add,1,40),
						substr(ln2_mail_add,1,40),
						substr(ln3_mail_add,1,40),
						substr(mail_country_code,1,40)						
				   INTO :l_bill_contact_name,
						:l_bill_contact_name_title,
						:l_bill_long_desc,
						:l_bill_add1_desc,
						:l_bill_add2_desc,
						:l_bill_add3_desc
				   FROM mp_pat_other_dtls
				  WHERE patient_id = :dc_patient_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select substr(mail_contact_name,1,19) ,substr(mail_postal_c\
ode,1,20) ,substr(ln1_mail_add,1,40) ,substr(ln2_mail_add,1,40) ,substr(ln3_ma\
il_add,1,40) ,substr(mail_country_code,1,40) into :b0,:b1,:b2,:b3,:b4,:b5  fro\
m mp_pat_other_dtls where patient_id=:b6";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )4762;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&l_bill_contact_name;
  sqlstm.sqhstl[0] = (unsigned int  )52;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&l_bill_contact_name_title;
  sqlstm.sqhstl[1] = (unsigned int  )52;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&l_bill_long_desc;
  sqlstm.sqhstl[2] = (unsigned int  )42;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&l_bill_add1_desc;
  sqlstm.sqhstl[3] = (unsigned int  )42;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&l_bill_add2_desc;
  sqlstm.sqhstl[4] = (unsigned int  )42;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&l_bill_add3_desc;
  sqlstm.sqhstl[5] = (unsigned int  )42;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&dc_patient_id;
  sqlstm.sqhstl[6] = (unsigned int  )23;
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



			   if (OERROR)
					err_mesg("SELECT failed on table MP_PAT_OTHER_DTLS",0,"");
	}

	l_bill_contact_name.arr[l_bill_contact_name.len] = '\0';
	l_bill_contact_name_title.arr[l_bill_contact_name_title.len] = '\0';
	l_bill_long_desc.arr[l_bill_long_desc.len] = '\0';
	l_bill_add1_desc.arr[l_bill_add1_desc.len] = '\0';
	l_bill_add2_desc.arr[l_bill_add2_desc.len] = '\0';
	l_bill_add3_desc.arr[l_bill_add3_desc.len] = '\0';

	if(l_bill_add3_desc.len > 0)
	{
		l_bill_add3_desc_temp.arr[0] = '\0';
		l_bill_add3_desc_temp.len = 0;		

		/* EXEC SQL SELECT long_name
				   INTO :l_bill_add3_desc_temp
				   FROM mp_country
				  WHERE country_code = :l_bill_add3_desc; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select long_name into :b0  from mp_country where country_co\
de=:b1";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )4805;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&l_bill_add3_desc_temp;
  sqlstm.sqhstl[0] = (unsigned int  )42;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&l_bill_add3_desc;
  sqlstm.sqhstl[1] = (unsigned int  )42;
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



		l_bill_add3_desc_temp.arr[l_bill_add3_desc_temp.len] = '\0';

		if((strcmp(l_bill_add3_desc_temp.arr,l_bill_add3_desc.arr)!=0) && (l_bill_add3_desc_temp.len > 0))
		{
			strcpy(l_bill_add3_desc.arr,l_bill_add3_desc_temp.arr);
			l_bill_add3_desc.len = strlen(l_bill_add3_desc.arr);
		}
	}
}


get_bill_address_lsr()
{   
        int cnt1 = 0;

	l_bill_contact_name_p.arr[0] = '\0';
	l_bill_contact_name_p.len = 0;

	l_bill_contact_name_title_p.arr[0] = '\0';
	l_bill_contact_name_title_p.len = 0;

	l_bill_long_desc_p.arr[0] = '\0';
	l_bill_long_desc_p.len = 0;

	l_bill_add1_desc_p.arr[0] = '\0';
	l_bill_add1_desc_p.len = 0;

	l_bill_add2_desc_p.arr[0] = '\0';
	l_bill_add2_desc_p.len = 0;

	l_bill_add3_desc_p.arr[0] = '\0';
	l_bill_add3_desc_p.len = 0;


	l_bill_contact_name_c.arr[0] = '\0';
	l_bill_contact_name_c.len = 0;

	l_bill_contact_name_title_c.arr[0] = '\0';
	l_bill_contact_name_title_c.len = 0;

	l_bill_long_desc_c.arr[0] = '\0';
	l_bill_long_desc_c.len = 0;

	l_bill_add1_desc_c.arr[0] = '\0';
	l_bill_add1_desc_c.len = 0;

	l_bill_add2_desc_c.arr[0] = '\0';
	l_bill_add2_desc_c.len = 0;

	l_bill_add3_desc_c.arr[0] = '\0';
	l_bill_add3_desc_c.len = 0;


	l_line1.arr[0] = '\0';
	l_line2.arr[0] = '\0';
	l_line3.arr[0] = '\0';
	l_line4.arr[0] = '\0';
	l_line5.arr[0] = '\0';
	l_line6.arr[0] = '\0';

	l_line1.len = 0;
	l_line2.len = 0;
	l_line3.len = 0;
	l_line4.len = 0;
	l_line5.len = 0;
	l_line6.len = 0;
	
	if(strcmp(d_bill_nature_code.arr,"A")==0)
	{
		/* EXEC SQL SELECT		contact_name,
					contact_name_title,
					long_name,
					add1_desc,
					add2_desc,
					add3_desc
				   INTO 
						/o:l_bill_contact_name_c,
						:l_bill_contact_name_title_c,
						:l_bill_long_desc_c,
						:l_bill_add1_desc_c,
						:l_bill_add2_desc_c,
						:l_bill_add3_desc_co/
					:l_line1,
					:l_line2,
					:l_line3,
					:l_line4,
					:l_line5,
					:l_line6
				   FROM ar_customer
				  WHERE cust_code = :dc_cust_code; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select contact_name ,contact_name_title ,long_name ,add1_de\
sc ,add2_desc ,add3_desc into :b0,:b1,:b2,:b3,:b4,:b5  from ar_customer where \
cust_code=:b6";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )4828;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&l_line1;
  sqlstm.sqhstl[0] = (unsigned int  )52;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&l_line2;
  sqlstm.sqhstl[1] = (unsigned int  )52;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&l_line3;
  sqlstm.sqhstl[2] = (unsigned int  )52;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&l_line4;
  sqlstm.sqhstl[3] = (unsigned int  )52;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&l_line5;
  sqlstm.sqhstl[4] = (unsigned int  )52;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&l_line6;
  sqlstm.sqhstl[5] = (unsigned int  )52;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&dc_cust_code;
  sqlstm.sqhstl[6] = (unsigned int  )11;
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



			   if (OERROR)
					err_mesg("SELECT failed on table AR_CUSTOMER",0,"");

	l_line1.arr[l_line1.len] = '\0';
	l_line2.arr[l_line2.len] = '\0';
	l_line3.arr[l_line3.len] = '\0';
	l_line4.arr[l_line4.len] = '\0';
	l_line5.arr[l_line5.len] = '\0';
	l_line6.arr[l_line6.len] = '\0';

	if(l_line6.len > 0)
		{
			l_bill_add3_desc_temp.arr[0] = '\0';
			l_bill_add3_desc_temp.len = 0;

			/* EXEC SQL SELECT long_name
				 INTO :l_bill_add3_desc_temp
				 FROM mp_country
				 WHERE country_code = :l_line6; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 46;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select long_name into :b0  from mp_country where country_c\
ode=:b1";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )4871;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&l_bill_add3_desc_temp;
   sqlstm.sqhstl[0] = (unsigned int  )42;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&l_line6;
   sqlstm.sqhstl[1] = (unsigned int  )52;
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



			l_bill_add3_desc_temp.arr[l_bill_add3_desc_temp.len] = '\0';

			if((strcmp(l_bill_add3_desc_temp.arr,l_line6.arr)!=0)
				&& (l_bill_add3_desc_temp.len > 0))
			{
				strcpy(l_line6.arr,l_bill_add3_desc_temp.arr);
				l_line6.len = strlen(l_line6.arr);
			}
		}
	
	if (l_line1.arr[0] != '\0')
	{
		cnt1 = cnt1+1;
		strcpy(l_bill_contact_name_c.arr,l_line1.arr);
	}

	if (l_line2.arr[0] != '\0')
	{
		if (cnt1 == 0)
		{
		   cnt1 = cnt1+1;
		   strcpy(l_bill_contact_name_c.arr,l_line2.arr);
		}
		else if (cnt1 == 1)
		{
		   cnt1 = cnt1+1;
		   strcpy(l_bill_contact_name_title_c.arr,l_line2.arr);	
		}
	}

	if (l_line3.arr[0] != '\0')
	{
		if (cnt1 == 0)
		{
		   cnt1 = cnt1+1;
		   strcpy(l_bill_contact_name_c.arr,l_line3.arr);
		}
		else if (cnt1 == 1)
		{
		   cnt1 = cnt1+1;
		   strcpy(l_bill_contact_name_title_c.arr,l_line3.arr);	
		}
		else if (cnt1 == 2)
		{
		   cnt1 = cnt1+1;
		   strcpy(l_bill_long_desc_c.arr,l_line3.arr);	
		}
	}

	if (l_line4.arr[0] != '\0')
	{
		if (cnt1 == 0)
		{
		   cnt1 = cnt1+1;
		   strcpy(l_bill_contact_name_c.arr,l_line4.arr);
		}
		else if (cnt1 == 1)
		{
		   cnt1 = cnt1+1;
		   strcpy(l_bill_contact_name_title_c.arr,l_line4.arr);	
		}
		else if (cnt1 == 2)
		{
		   cnt1 = cnt1+1;
		   strcpy(l_bill_long_desc_c.arr,l_line4.arr);	
		}
		else if (cnt1 == 3)
		{
		   cnt1 = cnt1+1;
		   strcpy(l_bill_add1_desc_c.arr,l_line4.arr);	
		}
	}

	if (l_line5.arr[0] != '\0')
	{
		if (cnt1 == 0)
		{
		   cnt1 = cnt1+1;
		   strcpy(l_bill_contact_name_c.arr,l_line5.arr);
		}
		else if (cnt1 == 1)
		{
		   cnt1 = cnt1+1;
		   strcpy(l_bill_contact_name_title_c.arr,l_line5.arr);	
		}
		else if (cnt1 == 2)
		{
		   cnt1 = cnt1+1;
		   strcpy(l_bill_long_desc_c.arr,l_line5.arr);	
		}
		else if (cnt1 == 3)
		{
		   cnt1 = cnt1+1;
		   strcpy(l_bill_add1_desc_c.arr,l_line5.arr);	
		}

		else if (cnt1 == 4)
		{
		   cnt1 = cnt1+1;
		   strcpy(l_bill_add2_desc_c.arr,l_line5.arr);	
		}
	}

	if (l_line6.arr[0] != '\0')
	{
		if (cnt1 == 0)
		{
		   cnt1 = cnt1+1;
		   strcpy(l_bill_contact_name_c.arr,l_line6.arr);
		}
		else if (cnt1 == 1)
		{
		   cnt1 = cnt1+1;
		   strcpy(l_bill_contact_name_title_c.arr,l_line6.arr);	
		}
		else if (cnt1 == 2)
		{
		   cnt1 = cnt1+1;
		   strcpy(l_bill_long_desc_c.arr,l_line6.arr);	
		}
		else if (cnt1 == 3)
		{
		   cnt1 = cnt1+1;
		   strcpy(l_bill_add1_desc_c.arr,l_line6.arr);	
		}

		else if (cnt1 == 4)
		{
		   cnt1 = cnt1+1;
		   strcpy(l_bill_add2_desc_c.arr,l_line6.arr);	
		}

		else if (cnt1 == 5)
		{
		   cnt1 = cnt1+1;
		   strcpy(l_bill_add3_desc_c.arr,l_line6.arr);	
		}
	}
	
	l_bill_contact_name_c.len = strlen(l_bill_contact_name_c.arr);
	l_bill_contact_name_title_c.len = strlen(l_bill_contact_name_title_c.arr);
	l_bill_long_desc_c.len = strlen(l_bill_long_desc_c.arr);
	l_bill_add1_desc_c.len = strlen(l_bill_add1_desc_c.arr);
	l_bill_add2_desc_c.len = strlen(l_bill_add2_desc_c.arr);
	l_bill_add3_desc_c.len = strlen(l_bill_add3_desc_c.arr);
	
	l_bill_contact_name_c.arr[l_bill_contact_name_c.len] = '\0';
	l_bill_contact_name_title_c.arr[l_bill_contact_name_title_c.len] = '\0';
	l_bill_long_desc_c.arr[l_bill_long_desc_c.len] = '\0';
	l_bill_add1_desc_c.arr[l_bill_add1_desc_c.len] = '\0';
	l_bill_add2_desc_c.arr[l_bill_add2_desc_c.len] = '\0';
	l_bill_add3_desc_c.arr[l_bill_add3_desc_c.len] = '\0';


	}

	cnt1 = 0;

	l_line1.arr[0] = '\0';
	l_line2.arr[0] = '\0';
	l_line3.arr[0] = '\0';
	l_line4.arr[0] = '\0';
	l_line5.arr[0] = '\0';
	l_line6.arr[0] = '\0';	

	l_line1.len = 0;
	l_line2.len = 0;
	l_line3.len = 0;
	l_line4.len = 0;
	l_line5.len = 0;
	l_line6.len = 0;	

	
	/* EXEC SQL SELECT		mail_contact_name,								
				ln1_mail_add,
				ln2_mail_add,
				ln3_mail_add,
				mail_postal_code,
				mail_country_code
			   INTO 
				:l_line1,
				:l_line2,
				:l_line3,
				:l_line4,
				:l_line5,
				:l_line6
			   FROM mp_pat_other_dtls
			   WHERE patient_id = :dc_patient_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select mail_contact_name ,ln1_mail_add ,ln2_mail_add ,ln3_ma\
il_add ,mail_postal_code ,mail_country_code into :b0,:b1,:b2,:b3,:b4,:b5  from\
 mp_pat_other_dtls where patient_id=:b6";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4894;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_line1;
 sqlstm.sqhstl[0] = (unsigned int  )52;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_line2;
 sqlstm.sqhstl[1] = (unsigned int  )52;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&l_line3;
 sqlstm.sqhstl[2] = (unsigned int  )52;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&l_line4;
 sqlstm.sqhstl[3] = (unsigned int  )52;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&l_line5;
 sqlstm.sqhstl[4] = (unsigned int  )52;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&l_line6;
 sqlstm.sqhstl[5] = (unsigned int  )52;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&dc_patient_id;
 sqlstm.sqhstl[6] = (unsigned int  )23;
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



			   if (OERROR)
				  err_mesg("SELECT failed on table MP_PAT_OTHER_DTLS",0,"");

	l_line1.arr[l_line1.len] = '\0';
	l_line2.arr[l_line2.len] = '\0';
	l_line3.arr[l_line3.len] = '\0';
	l_line4.arr[l_line4.len] = '\0';
	l_line5.arr[l_line5.len] = '\0';
	l_line6.arr[l_line6.len] = '\0';		

	if (l_line5.arr[0] != '\0' && loc_legend63.arr[0] != '\0')
	{
		strcat(loc_legend63.arr," ");		
		strcat(loc_legend63.arr,l_line5.arr);		

		l_line5.arr[0] = '\0';
		l_line5.len = 0;
		strcpy(l_line5.arr,loc_legend63.arr);
		l_line5.len = strlen(l_line5.arr);

	}

	if(l_line6.len > 0)   // country code
	{
		l_bill_add3_desc_temp.arr[0] = '\0';
		l_bill_add3_desc_temp.len = 0;

		/* EXEC SQL SELECT long_name
			 INTO :l_bill_add3_desc_temp
			 FROM mp_country
			 WHERE country_code = :l_line6; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select long_name into :b0  from mp_country where country_co\
de=:b1";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )4937;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&l_bill_add3_desc_temp;
  sqlstm.sqhstl[0] = (unsigned int  )42;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&l_line6;
  sqlstm.sqhstl[1] = (unsigned int  )52;
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



		l_bill_add3_desc_temp.arr[l_bill_add3_desc_temp.len] = '\0';

		if((strcmp(l_bill_add3_desc_temp.arr,l_line6.arr)!=0)
			&& (l_bill_add3_desc_temp.len > 0))
		{
			strcpy(l_line6.arr,l_bill_add3_desc_temp.arr);
			l_line6.len = strlen(l_line6.arr);
		}
	}

	if (l_line1.arr[0] != '\0')
	{
		cnt1 = cnt1+1;
		strcpy(l_bill_contact_name_p.arr,l_line1.arr);
	}

	if (l_line2.arr[0] != '\0')
	{
		if (cnt1 == 0)
		{
		   cnt1 = cnt1+1;
		   strcpy(l_bill_contact_name_p.arr,l_line2.arr);
		}
		else if (cnt1 == 1)
		{
		   cnt1 = cnt1+1;
		   strcpy(l_bill_contact_name_title_p.arr,l_line2.arr);	
		}
	}

	if (l_line3.arr[0] != '\0')
	{
		if (cnt1 == 0)
		{
		   cnt1 = cnt1+1;
		   strcpy(l_bill_contact_name_p.arr,l_line3.arr);
		}
		else if (cnt1 == 1)
		{
		   cnt1 = cnt1+1;
		   strcpy(l_bill_contact_name_title_p.arr,l_line3.arr);	
		}
		else if (cnt1 == 2)
		{
		   cnt1 = cnt1+1;
		   strcpy(l_bill_long_desc_p.arr,l_line3.arr);	
		}
	}

	if (l_line4.arr[0] != '\0')
	{
		if (cnt1 == 0)
		{
		   cnt1 = cnt1+1;
		   strcpy(l_bill_contact_name_p.arr,l_line4.arr);
		}
		else if (cnt1 == 1)
		{
		   cnt1 = cnt1+1;
		   strcpy(l_bill_contact_name_title_p.arr,l_line4.arr);	
		}
		else if (cnt1 == 2)
		{
		   cnt1 = cnt1+1;
		   strcpy(l_bill_long_desc_p.arr,l_line4.arr);	
		}
		else if (cnt1 == 3)
		{
		   cnt1 = cnt1+1;
		   strcpy(l_bill_add1_desc_p.arr,l_line4.arr);	
		}
	}

	if (l_line5.arr[0] != '\0')
	{
		if (cnt1 == 0)
		{
		   cnt1 = cnt1+1;
		   strcpy(l_bill_contact_name_p.arr,l_line5.arr);
		}
		else if (cnt1 == 1)
		{
		   cnt1 = cnt1+1;
		   strcpy(l_bill_contact_name_title_p.arr,l_line5.arr);	
		}
		else if (cnt1 == 2)
		{
		   cnt1 = cnt1+1;
		   strcpy(l_bill_long_desc_p.arr,l_line5.arr);	
		}
		else if (cnt1 == 3)
		{
		   cnt1 = cnt1+1;
		   strcpy(l_bill_add1_desc_p.arr,l_line5.arr);	
		}

		else if (cnt1 == 4)
		{
		   cnt1 = cnt1+1;
		   strcpy(l_bill_add2_desc_p.arr,l_line5.arr);	
		}
	}

	if (l_line6.arr[0] != '\0')
	{
		if (cnt1 == 0)
		{
		   cnt1 = cnt1+1;
		   strcpy(l_bill_contact_name_p.arr,l_line6.arr);
		}
		else if (cnt1 == 1)
		{
		   cnt1 = cnt1+1;
		   strcpy(l_bill_contact_name_title_p.arr,l_line6.arr);	
		}
		else if (cnt1 == 2)
		{
		   cnt1 = cnt1+1;
		   strcpy(l_bill_long_desc_p.arr,l_line6.arr);	
		}
		else if (cnt1 == 3)
		{
		   cnt1 = cnt1+1;
		   strcpy(l_bill_add1_desc_p.arr,l_line6.arr);	
		}

		else if (cnt1 == 4)
		{
		   cnt1 = cnt1+1;
		   strcpy(l_bill_add2_desc_p.arr,l_line6.arr);	
		}

		else if (cnt1 == 5)
		{
		   cnt1 = cnt1+1;
		   strcpy(l_bill_add3_desc_p.arr,l_line6.arr);	
		}
	}
	
	
	l_bill_contact_name_p.len = strlen(l_bill_contact_name_p.arr);
	l_bill_contact_name_title_p.len = strlen(l_bill_contact_name_title_p.arr);
	l_bill_long_desc_p.len = strlen(l_bill_long_desc_p.arr);
	l_bill_add1_desc_p.len = strlen(l_bill_add1_desc_p.arr);
	l_bill_add2_desc_p.len = strlen(l_bill_add2_desc_p.arr);
	l_bill_add3_desc_p.len = strlen(l_bill_add3_desc_p.arr);

	l_bill_contact_name_p.arr[l_bill_contact_name_p.len] = '\0';
	l_bill_contact_name_title_p.arr[l_bill_contact_name_title_p.len] = '\0';
	l_bill_long_desc_p.arr[l_bill_long_desc_p.len] = '\0';
	l_bill_add1_desc_p.arr[l_bill_add1_desc_p.len] = '\0';
	l_bill_add2_desc_p.arr[l_bill_add2_desc_p.len] = '\0';
	l_bill_add3_desc_p.arr[l_bill_add3_desc_p.len] = '\0';
		
}


get_gl_holder_name_nric()
{
	l_gl_holder_name.arr[0] = '\0';
	l_gl_holder_name.len = 0;

	l_pat_reln_with_gl_holder.arr[0] = '\0';
	l_pat_reln_with_gl_holder.len = 0;

	l_credit_doc_ref_desc.arr[0] = '\0';
	l_credit_doc_ref_desc.len = 0;
	
	l_gl_ic.arr[0] = '\0';
	l_gl_ic.len = 0;

	
	if(strcmp(d_bill_nature_code.arr,"A")==0)
	{
	   if (l_lsr != 0 && l_dmp == 0)
	   {
		/* EXEC SQL SELECT (substr(gl_holder_name,1,decode(instr(gl_holder_name,';'),0,9999,instr(gl_holder_name,';'))-1)),
			        pat_reln_with_gl_holder,
				credit_doc_ref_desc,
				ltrim(substr(gl_holder_name,decode(instr(gl_holder_name,';'),0,9999,instr(gl_holder_name,';'))+1)) 
		INTO :l_gl_holder_name,
		     :l_pat_reln_with_gl_holder,
		     :l_credit_doc_ref_desc,
		     :l_gl_ic
		FROM bl_bill_hdr
		WHERE operating_facility_id = :nd_facility_id
		AND doc_type_code = :dc_doc_type_code
		AND doc_num       = :d_doc_num; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select substr(gl_holder_name,1,(decode(instr(gl_holder_name\
,';'),0,9999,instr(gl_holder_name,';'))-1)) ,pat_reln_with_gl_holder ,credit_d\
oc_ref_desc ,ltrim(substr(gl_holder_name,(decode(instr(gl_holder_name,';'),0,9\
999,instr(gl_holder_name,';'))+1))) into :b0,:b1,:b2,:b3  from bl_bill_hdr whe\
re ((operating_facility_id=:b4 and doc_type_code=:b5) and doc_num=:b6)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )4960;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&l_gl_holder_name;
  sqlstm.sqhstl[0] = (unsigned int  )63;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&l_pat_reln_with_gl_holder;
  sqlstm.sqhstl[1] = (unsigned int  )37;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&l_credit_doc_ref_desc;
  sqlstm.sqhstl[2] = (unsigned int  )32;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&l_gl_ic;
  sqlstm.sqhstl[3] = (unsigned int  )1002;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_facility_id;
  sqlstm.sqhstl[4] = (unsigned int  )5;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&dc_doc_type_code;
  sqlstm.sqhstl[5] = (unsigned int  )9;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&d_doc_num;
  sqlstm.sqhstl[6] = (unsigned int  )11;
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


	   }
	   else
	   {
		/* EXEC SQL SELECT substr(gl_holder_name,1,40),
			pat_reln_with_gl_holder,
			substr(credit_doc_ref_desc,1,29)||' '||to_char(credit_doc_ref_date,'DD/MM/YYYY')		   
		INTO :l_gl_holder_name,
		     :l_pat_reln_with_gl_holder,
		     :l_credit_doc_ref_desc
	        FROM bl_bill_hdr
		WHERE operating_facility_id = :nd_facility_id
		AND doc_type_code = :dc_doc_type_code
		AND doc_num = :d_doc_num; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select substr(gl_holder_name,1,40) ,pat_reln_with_gl_holder\
 ,((substr(credit_doc_ref_desc,1,29)||' ')||to_char(credit_doc_ref_date,'DD/MM\
/YYYY')) into :b0,:b1,:b2  from bl_bill_hdr where ((operating_facility_id=:b3 \
and doc_type_code=:b4) and doc_num=:b5)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )5003;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&l_gl_holder_name;
  sqlstm.sqhstl[0] = (unsigned int  )63;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&l_pat_reln_with_gl_holder;
  sqlstm.sqhstl[1] = (unsigned int  )37;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&l_credit_doc_ref_desc;
  sqlstm.sqhstl[2] = (unsigned int  )32;
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
  sqlstm.sqhstv[4] = (         void  *)&dc_doc_type_code;
  sqlstm.sqhstl[4] = (unsigned int  )9;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_doc_num;
  sqlstm.sqhstl[5] = (unsigned int  )11;
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

	  if (OERROR)
		err_mesg("SELECT failed on table BL_BILL_HDR - get_gl_holder_name_nric",0,"");
	
	
		l_gl_holder_name.arr[l_gl_holder_name.len] = '\0';
		l_pat_reln_with_gl_holder.arr[l_pat_reln_with_gl_holder.len] = '\0';
		l_gl_ic.arr[l_gl_ic.len] = '\0';
	}
	else
	{
		if (l_lsr != 0 && l_dmp == 0)
		{
			strcpy(l_gl_holder_name.arr,"");
			l_gl_holder_name.len = strlen(l_gl_holder_name.arr);
		}
		else
		{
			strcpy(l_gl_holder_name.arr,dc_short_name.arr);
			l_gl_holder_name.len = strlen(l_gl_holder_name.arr);
		}
	}
	
	l_nric_number.arr[0] = '\0';

	/* EXEC SQL SELECT national_id_num
	           INTO :l_nric_number
			   FROM mp_patient_mast
			  WHERE patient_id = :dc_patient_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select national_id_num into :b0  from mp_patient_mast where \
patient_id=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )5042;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_nric_number;
 sqlstm.sqhstl[0] = (unsigned int  )27;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&dc_patient_id;
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
		err_mesg("SELECT failed on table MP_PATIENT_MAST - get_gl_holder_name_nric",0,"");

	l_nric_number.arr[l_nric_number.len] = '\0';
	l_credit_doc_ref_desc.arr[l_credit_doc_ref_desc.len] = '\0';
}

print_formated_amt_varstr(loc_amount_varstr,loc_amount)
char loc_amount_varstr[100];
double loc_amount;
{
    char s_amt[30], str_amt[30], fstr_amt[30];    

    if(loc_amount < 0)
	{
        put_val(loc_amount_varstr,-loc_amount);        
        format_amt(loc_amount_varstr);                
	ltrim (loc_amount_varstr);		
	rtrim (loc_amount_varstr);		
	strcpy(fstr_amt,"(-)");
	strcat(fstr_amt,loc_amount_varstr);		
	ltrim (fstr_amt);		
	rtrim (fstr_amt);
	sprintf(loc_amount_varstr,"%s",fstr_amt);		  
        }
    else 
	{
        put_val(loc_amount_varstr,loc_amount);         	
	format_amt(loc_amount_varstr);		
	ltrim (loc_amount_varstr);		
	rtrim (loc_amount_varstr);		
     }


}                        

print_formated_amt_total(loc_amount)
double loc_amount;
{
	char s_amt[30], str_amt[30], fstr_amt[30];

    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);        
        format_amt(s_amt);        
        sprintf(str_amt,"%14s",s_amt);				
		ltrim (str_amt);		
		rtrim (str_amt);		
		//strcpy(fstr_amt,"CR ");
		//strcat(fstr_amt,str_amt);		
		//ltrim (fstr_amt);		
		//rtrim (fstr_amt);
		//sprintf(str_amt,"%15s",fstr_amt);	
        fprintf(fp,"%15s CR",str_amt);
    }
    else if(loc_amount > 0)
	{
        put_val(s_amt,loc_amount);         
        format_amt(s_amt);
        sprintf(str_amt,"%15s",s_amt);
        fprintf(fp,"%15s DR",str_amt);
    }
	else if(loc_amount==0)
	{
        put_val(s_amt,loc_amount);         
        format_amt(s_amt);
        sprintf(str_amt,"%15s",s_amt);
        fprintf(fp,"%15s",str_amt);
	 }
}

check_report_format()
{
	//Modified by Harish 
	//Date - 06/11/2003 Point # 1 - modification document.
	//----------------------------------------------------------

    d_summary_yn = '\0';

	l_dflt_bill_print_in_summ_yn.arr[0] = '\0';

	/* EXEC SQL SELECT NVL(DFLT_BILL_PRINT_IN_SUMM_YN,'N')
			   INTO l_dflt_bill_print_in_summ_yn 
	           FROM bl_parameters
			  WHERE operating_facility_id = :nd_facility_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select NVL(DFLT_BILL_PRINT_IN_SUMM_YN,'N') into :b0  from bl\
_parameters where operating_facility_id=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )5065;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_dflt_bill_print_in_summ_yn;
 sqlstm.sqhstl[0] = (unsigned int  )7;
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



	l_dflt_bill_print_in_summ_yn.arr[l_dflt_bill_print_in_summ_yn.len] = '\0';

	//First preference given to front end Summary parameter.	
	if(strcmp(l_dflt_bill_print_in_summ_yn.arr,"Y")==0)
	{
		d_summary_yn='Y';
	}
	else
	{
		/* EXEC SQL SELECT NVL(SUMMARY_YN,'N')
				   INTO :d_summary_yn
				   FROM BL_SUM_DET_PRINT
				  WHERE BLNG_GRP_ID       = :dc_blng_grp_id
    				AND PRT_GRP_HDR_CODE  = :d1_prt_grp_hdr_code
					AND operating_facility_id = :nd_facility_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select NVL(SUMMARY_YN,'N') into :b0  from BL_SUM_DET_PRINT \
where ((BLNG_GRP_ID=:b1 and PRT_GRP_HDR_CODE=:b2) and operating_facility_id=:b\
3)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )5088;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_summary_yn;
  sqlstm.sqhstl[0] = (unsigned int  )1;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&dc_blng_grp_id;
  sqlstm.sqhstl[1] = (unsigned int  )5;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d1_prt_grp_hdr_code;
  sqlstm.sqhstl[2] = (unsigned int  )5;
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

       	

			if (sqlca.sqlcode == 1403 )
			{
				     /* EXEC SQL SELECT NVL(summary_yn,'N')
							    INTO :d_summary_yn
							    FROM bl_sum_det_print
							   WHERE blng_grp_id           = '**'
    						 	 AND prt_grp_hdr_code      = :d1_prt_grp_hdr_code
								 AND operating_facility_id = :nd_facility_id; */ 

{
         struct sqlexd sqlstm;
         sqlstm.sqlvsn = 12;
         sqlstm.arrsiz = 46;
         sqlstm.sqladtp = &sqladt;
         sqlstm.sqltdsp = &sqltds;
         sqlstm.stmt = "select NVL(summary_yn,'N') into :b0  from bl_sum_det\
_print where ((blng_grp_id='**' and prt_grp_hdr_code=:b1) and operating_facili\
ty_id=:b2)";
         sqlstm.iters = (unsigned int  )1;
         sqlstm.offset = (unsigned int  )5119;
         sqlstm.selerr = (unsigned short)1;
         sqlstm.cud = sqlcud0;
         sqlstm.sqlest = (unsigned char  *)&sqlca;
         sqlstm.sqlety = (unsigned short)4352;
         sqlstm.occurs = (unsigned int  )0;
         sqlstm.sqhstv[0] = (         void  *)&d_summary_yn;
         sqlstm.sqhstl[0] = (unsigned int  )1;
         sqlstm.sqhsts[0] = (         int  )0;
         sqlstm.sqindv[0] = (         void  *)0;
         sqlstm.sqinds[0] = (         int  )0;
         sqlstm.sqharm[0] = (unsigned int  )0;
         sqlstm.sqadto[0] = (unsigned short )0;
         sqlstm.sqtdso[0] = (unsigned short )0;
         sqlstm.sqhstv[1] = (         void  *)&d1_prt_grp_hdr_code;
         sqlstm.sqhstl[1] = (unsigned int  )5;
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



					 if (sqlca.sqlcode == 1403 )
							d_summary_yn='Y';
			}
	}

	//If condition will be considered only in reprint options.
	if(strcmp(l_detail_report_flag.arr,"Y")==0)
	{
			/* EXEC SQL SELECT NVL(SUMMARY_YN,'N')
					   INTO :d_summary_yn
					   FROM BL_SUM_DET_PRINT
					  WHERE BLNG_GRP_ID       = :dc_blng_grp_id
    					AND PRT_GRP_HDR_CODE  = :d1_prt_grp_hdr_code
						AND operating_facility_id = :nd_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 46;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select NVL(SUMMARY_YN,'N') into :b0  from BL_SUM_DET_PRINT\
 where ((BLNG_GRP_ID=:b1 and PRT_GRP_HDR_CODE=:b2) and operating_facility_id=:\
b3)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )5146;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_summary_yn;
   sqlstm.sqhstl[0] = (unsigned int  )1;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&dc_blng_grp_id;
   sqlstm.sqhstl[1] = (unsigned int  )5;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d1_prt_grp_hdr_code;
   sqlstm.sqhstl[2] = (unsigned int  )5;
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

       	

			if (sqlca.sqlcode == 1403 )
			{
				     /* EXEC SQL SELECT NVL(summary_yn,'N')
							    INTO :d_summary_yn
							    FROM bl_sum_det_print
							   WHERE blng_grp_id           = '**'
    						 	 AND prt_grp_hdr_code      = :d1_prt_grp_hdr_code
								 AND operating_facility_id = :nd_facility_id; */ 

{
         struct sqlexd sqlstm;
         sqlstm.sqlvsn = 12;
         sqlstm.arrsiz = 46;
         sqlstm.sqladtp = &sqladt;
         sqlstm.sqltdsp = &sqltds;
         sqlstm.stmt = "select NVL(summary_yn,'N') into :b0  from bl_sum_det\
_print where ((blng_grp_id='**' and prt_grp_hdr_code=:b1) and operating_facili\
ty_id=:b2)";
         sqlstm.iters = (unsigned int  )1;
         sqlstm.offset = (unsigned int  )5177;
         sqlstm.selerr = (unsigned short)1;
         sqlstm.cud = sqlcud0;
         sqlstm.sqlest = (unsigned char  *)&sqlca;
         sqlstm.sqlety = (unsigned short)4352;
         sqlstm.occurs = (unsigned int  )0;
         sqlstm.sqhstv[0] = (         void  *)&d_summary_yn;
         sqlstm.sqhstl[0] = (unsigned int  )1;
         sqlstm.sqhsts[0] = (         int  )0;
         sqlstm.sqindv[0] = (         void  *)0;
         sqlstm.sqinds[0] = (         int  )0;
         sqlstm.sqharm[0] = (unsigned int  )0;
         sqlstm.sqadto[0] = (unsigned short )0;
         sqlstm.sqtdso[0] = (unsigned short )0;
         sqlstm.sqhstv[1] = (         void  *)&d1_prt_grp_hdr_code;
         sqlstm.sqhstl[1] = (unsigned int  )5;
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



					 if (sqlca.sqlcode == 1403 )
							d_summary_yn='Y';
			}
	}
}



